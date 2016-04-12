package be.ugent.neio.parsing;

import be.kuleuven.cs.distrinet.jnome.input.PrimitiveTypeFactory;
import be.kuleuven.cs.distrinet.jnome.workspace.JavaView;
import be.ugent.neio.industry.NeioExpressionFactory;
import be.ugent.neio.industry.NeioFactory;
import be.ugent.neio.language.Neio;
import be.ugent.neio.model.document.TextDocument;
import be.ugent.neio.model.type.ContextType;
import org.aikodi.chameleon.core.document.Document;
import org.aikodi.chameleon.core.lookup.LookupException;
import org.aikodi.chameleon.core.namespace.Namespace;
import org.aikodi.chameleon.core.namespacedeclaration.NamespaceDeclaration;
import org.aikodi.chameleon.core.tag.TagImpl;
import org.aikodi.chameleon.exception.ChameleonProgrammerException;
import org.aikodi.chameleon.oo.expression.Expression;
import org.aikodi.chameleon.oo.expression.ExpressionFactory;
import org.aikodi.chameleon.oo.expression.MethodInvocation;
import org.aikodi.chameleon.oo.method.Method;
import org.aikodi.chameleon.oo.plugin.ObjectOrientedFactory;
import org.aikodi.chameleon.oo.statement.Block;
import org.aikodi.chameleon.oo.statement.Statement;
import org.aikodi.chameleon.oo.type.RegularType;
import org.aikodi.chameleon.oo.type.Type;
import org.aikodi.chameleon.oo.variable.FormalParameter;
import org.aikodi.chameleon.support.member.simplename.method.RegularMethodInvocation;
import org.aikodi.chameleon.support.modifier.Public;
import org.aikodi.chameleon.support.modifier.Static;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.neio.antlr.ClassLexer;
import org.neio.antlr.ClassParser;
import org.neio.antlr.DocumentParser.*;
import org.neio.antlr.DocumentParserBaseVisitor;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static be.ugent.neio.util.Constants.*;

/**
 * @author Titouan Vervack
 */
public class DocumentConverter extends DocumentParserBaseVisitor<Object> {

    private final Neio neio;
    private final TextDocument document;
    private final JavaView view;
    private Expression previousExpression = null;
    private Block block = null;

    private final Type[] types;


    public DocumentConverter(Document document, JavaView view) {
        this.document = (TextDocument) document;
        this.view = view;
        this.neio = view.language(Neio.class);
        this.types = new Type[]{
                view.primitiveType("float"),
                view.primitiveType("double"),
                view.primitiveType("short"),
                view.primitiveType("int"),
                view.primitiveType("long"),
                view.primitiveType("char"),
                new RegularType(FLOAT),
                new RegularType(DOUBLE),
                new RegularType(SHORT),
                new RegularType(INTEGER),
                new RegularType(LONG),
                new RegularType(CHARACTER),
                new RegularType(STRING)
        };
    }

    protected NeioFactory ooFactory() {
        return (NeioFactory) neio.plugin(ObjectOrientedFactory.class);
    }

    protected NeioExpressionFactory expressionFactory() {
        return (NeioExpressionFactory) neio.plugin(ExpressionFactory.class);
    }

    @Override
    public TextDocument visitDocument(DocumentContext ctx) {
        previousExpression = visitHeader(ctx);
        Block block = visitBody(ctx.body());

        document.setBlock(block);
        return document;
    }


    private Expression visitHeader(DocumentContext ctx) {
        String header = ctx.HEADER().getText();
        // Strip the brackets
        String documentType = header.substring(1, header.length() - 1);

        return expressionFactory().createConstructorInvocation(documentType, null);
    }

    @Override
    public Block visitBody(BodyContext ctx) {
        block = ooFactory().createBlock();
        document.setBlock(block);
        prepareDocument(document);
        ctx.content().forEach(this::visitContent);

        if (previousExpression != null) {
            block.addStatement(ooFactory().createStatement(previousExpression));
        }
        return block;
    }

    private void prepareDocument(TextDocument document) {
        NeioFactory ooFactory = ooFactory();
        Type type = ooFactory.createRegularType(document.getName());
        type.addModifier(new Public());
        Method method = ooFactory.createMethod("main", "void");
        method.header().addFormalParameter(new FormalParameter("args", ooFactory.createTypeReference("String[]")));
        method.addModifier(new Public());
        method.addModifier(new Static());
        Block block = document.getBlock();
        method.setImplementation(ooFactory.createImplementation(block));
        type.add(method);

        NamespaceDeclaration ns = ooFactory.createNamespaceDeclaration(
                ooFactory.createNamespaceReference(document.loader().namespace().fullyQualifiedName()));
        ns.add(type);

        for (Namespace namespace : document.view().namespace().getSubNamespace("neio").descendantNamespaces()) {
            ns.addImport(ooFactory.createDemandImport(namespace.fullyQualifiedName()));
        }

        ns.addImport(ooFactory.createDemandImport("java.util"));
        document.add(ns);
    }

    public Block visitContent(ContentContext ctx) {
        if (ctx.lonecode() != null || ctx.scode() != null) {
            Block codeBlock;
            if (ctx.scode() != null) {
                codeBlock = visitCode(ctx.scode().getText(), "{{".length());
            } else {
                codeBlock = visitCode(ctx.lonecode().getText(), "{".length());
                codeBlock.setMetadata(new TagImpl(), Neio.LONE_CODE);
            }
            if (codeBlock.nbStatements() != 0) {
                // A block of code has been found, round up the expressions found before this block
                if (previousExpression != null) {
                    block.addStatement(ooFactory().createStatement(previousExpression));
                }
                if (codeBlock.metadata(Neio.LONE_CODE) != null) {
                    for (Statement s : codeBlock.statements()) {
                        s.setMetadata(new TagImpl(), Neio.LONE_CODE);
                        block.addStatement(s);
                    }
                } else {
                    block.addStatement(codeBlock);
                }
                previousExpression = null;
            }
        } else {
            // If the previous expression was a codeblock and there's more neioscript
            // add THIS as prefix to connect back to the rest of the document
            if (previousExpression == null) {
                previousExpression = ooFactory().createThisLiteral();
            }
            if (ctx.prefixCall() != null) {
                previousExpression = visitPrefixCall(ctx.prefixCall());
            } else if (ctx.imageCall() != null) {
                previousExpression = visitImageCall(ctx.imageCall());
            } else if (ctx.text() != null) {
                previousExpression = visitText(ctx.text());
            } else {
                throw new ChameleonProgrammerException("Method could not be found!");
            }
        }

        return null;
    }

    @Override
    public Expression visitPrefixCall(PrefixCallContext ctx) {
        // Find the method name and print it
        String methodName = ctx.MethodName().getText();
        List<Expression> arguments = new ArrayList<>();

        // Find the arguments
        Expression argument = visitTxt(ctx.txt());
        arguments.add(argument);

        return expressionFactory().createNeioMethodInvocation(methodName, previousExpression, arguments);
    }

    @Override
    public Expression visitImageCall(ImageCallContext ctx) {
        List<Expression> arguments = new ArrayList<>();
        if (ctx.caption != null && !ctx.caption.isEmpty()) {
            arguments.add(visitTxt(ctx.txt()));
        }
        arguments.add(ooFactory().createStringLiteral(ctx.name.getText()));

        return expressionFactory().createNeioMethodInvocation(IMAGE, previousExpression, arguments);
    }

    @Override
    public Expression visitSentence(SentenceContext ctx) {
        Expression txt = visitTxt(ctx.txt());
        return appendText(txt, createText("\\n"));
    }

    @Override
    public Expression visitTxt(@NotNull TxtContext ctx) {
        Expression result = null;

        // This is just plain text
        if (ctx.inlinecode() == null || ctx.inlinecode().isEmpty()) {
            result = createText(ctx.getText());
        }
        // There's a mix of code and text
        // Only code is not possible as that would be LONE_CODE
        else {
            String currText = "";
            // The intermediate result
            Expression intermediate = null;
            for (int i = 0; i < ctx.getChildCount(); i++) {
                Object o = visit(ctx.getChild(i));
                if (o instanceof String) {
                    currText += o;
                } else {
                    Expression e = (Expression) o;
                    // The text starts out with inlinecode
                    if (currText.isEmpty() && intermediate == null) {
                        intermediate = e;
                    }
                    // This is the first inlinecode, there is text in front of it
                    else if (intermediate == null) {
                        intermediate = createText(currText);
                        intermediate = appendText(intermediate, e);
                        currText = "";
                    }
                    // Text after some inlinecode
                    else if (!currText.isEmpty()) {
                        Expression append = createText(currText);
                        intermediate = appendText(intermediate, append);
                        intermediate = appendText(intermediate, e);
                        currText = "";
                    }
                    // There is inlinecode in the middle or at the end of the txt
                    else {
                        intermediate = appendText(intermediate, e);
                    }
                }
            }
            if (!currText.isEmpty()) {
                result = appendText(intermediate, createText(currText));
            } else {
                result = intermediate;
            }
        }

        return result;
    }

    @Override
    public String visitTerminal(TerminalNode node) {
        return node.getText();
    }

    // e1.APPEND_TEXT(e2)
    private Expression appendText(Expression e1, Expression e2) {
        List<Expression> arguments = new ArrayList<>();
        arguments.add(e2);

        return expressionFactory().createMethodInvocation(APPEND_TEXT, e1, arguments);
    }

    @Override
    public Expression visitInlinecode(@NotNull InlinecodeContext ctx) {
        Block b = visitCode(ctx.getText(), "{".length(), false);
        if (b.nbStatements() != 1) {
            throw new ChameleonProgrammerException("Inline code can only have 1 statement");
        }

        Type base = new RegularType(TEXT);
        Statement s = b.statement(0);
        Expression e = s.nearestDescendants(Expression.class).get(0);
        block.addStatement(s);

        Expression result = null;
        try {
            if (e instanceof RegularMethodInvocation) {
                ((MethodInvocation) e).setTarget(ooFactory().createThisLiteral());
                return createText(e);
            }
            Type type = e.getType();
            if (stringable(type)) {
                result = createText(e);
            } else if (subtype(type, base)) {
                result = e;
            } else {
                System.err.println("Inline code can only return a String or Text");
            }
        } catch (LookupException e1) {
            System.err.println("Syntax error in inlinecode");
        }

        block.removeStatement(s);
        return result;
    }

    private boolean subtype(Type other, Type base) throws LookupException {
        for (Type type : other.getSelfAndAllSuperTypesView()) {
            if (type.getFullyQualifiedName().equals(base.name())) {
                return true;
            }
        }

        return false;
    }

    private Expression createText(String s) {
        return createText(ooFactory().createStringLiteral(s), false);
    }

    private Expression createText(Expression e) {
        return createText(e, true);
    }

    private Expression createText(Expression strArgument, boolean createString) {
        // Create a String out of the expression
        Expression str = strArgument;
        if (createString) {
            str = expressionFactory().createInfixOperatorInvocation("+", ooFactory().createStringLiteral(""));
            ((MethodInvocation) str).addArgument(strArgument);
        }
        List<Expression> arguments = new ArrayList<>();
        arguments.add(str);

        // Create the most basic type of content, a piece of text
        return expressionFactory().createConstructorInvocation(TEXT, null, arguments);
    }

    private boolean stringable(Type type) throws LookupException {
        for (Type t : types) {
            if (subtype(type, t)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Expression visitText(TextContext ctx) {
        List<SentenceContext> sentences = ctx.sentence();
        Expression paragraph = visitSentence(sentences.get(0));

        for (int i = 1; i < sentences.size(); i++) {
            SentenceContext s = sentences.get(i);
            paragraph = appendText(paragraph, visitSentence(s));
        }

        // This is always the newline method
        String methodName = NEWLINE;

        List<Expression> arguments = new ArrayList<>();
        arguments.add(paragraph);

        return expressionFactory().createNeioMethodInvocation(methodName, previousExpression, arguments);
    }

    private Block visitCode(String code, int sepLen) {
        return visitCode(code, sepLen, true);
    }

    private Block visitCode(String code, int sepLen, boolean contextTypes) {
        // Remove the separator
        code = code.substring(sepLen, code.length() - sepLen);
        // Add a semicolon if needed
        int index = code.length();
        if (Pattern.matches("^[\t\n\r ]*$", code)) {
            return ooFactory().createBlock();
        }
        while (Pattern.matches("[\t\n\r ]", code.charAt(--index) + "")) ;

        if (code.charAt(index) != ';' && code.charAt(index) != '}') {
            code = new StringBuilder(code).insert(index + 1, ';').toString();
        }

        // Add newlines if needed
        if (code.charAt(0) != '\n' && code.charAt(0) != '\r') {
            code = '\n' + code;
        }
        if (code.charAt(code.length() - 1) != '\n') {
            code += '\n';
        }

        // Add the curly braces required for the parsing of a block
        code = "{" + code + "}";

        ClassConverter converter = new ClassConverter(document, view);
        if (contextTypes) {
            converter.enableContextTypes();
        }
        return converter.visitBlock(getParser(code).block());
    }

    private ClassParser getParser(String s) {
        InputStream stream = new ByteArrayInputStream(s.getBytes(StandardCharsets.UTF_8));
        ANTLRInputStream input = null;
        try {
            input = new ANTLRInputStream(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Lexer lexer = new ClassLexer(input);
        TokenStream tokens = new CommonTokenStream(lexer);

        return new ClassParser(tokens);
    }
}
