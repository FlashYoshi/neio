package be.ugent.neio.parsing;

import be.kuleuven.cs.distrinet.jnome.workspace.JavaView;
import be.ugent.neio.industry.NeioExpressionFactory;
import be.ugent.neio.industry.NeioFactory;
import be.ugent.neio.language.Neio;
import be.ugent.neio.model.document.TextDocument;
import org.aikodi.chameleon.core.document.Document;
import org.aikodi.chameleon.core.tag.TagImpl;
import org.aikodi.chameleon.exception.ChameleonProgrammerException;
import org.aikodi.chameleon.oo.expression.Expression;
import org.aikodi.chameleon.oo.expression.ExpressionFactory;
import org.aikodi.chameleon.oo.expression.MethodInvocation;
import org.aikodi.chameleon.oo.plugin.ObjectOrientedFactory;
import org.aikodi.chameleon.oo.statement.Block;
import org.aikodi.chameleon.support.statement.StatementExpression;
import org.antlr.v4.runtime.*;
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

import static be.ugent.neio.util.Constants.IMAGE;

/**
 * @author Titouan Vervack
 */
public class DocumentConverter extends DocumentParserBaseVisitor<Object> {

    private final Neio neio;
    private final TextDocument document;
    private final JavaView view;
    private Expression previousExpression = null;
    private Block block = null;

    public DocumentConverter(Document document, JavaView view) {
        this.document = (TextDocument) document;
        this.view = view;
        this.neio = view.language(Neio.class);
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
        ctx.content().forEach(this::visitContent);

        if (previousExpression != null) {
            block.addStatement(ooFactory().createStatement(previousExpression));
        }
        return block;
    }

    public Block visitContent(ContentContext ctx) {
        if (ctx.code() != null || ctx.scode() != null) {
            Block codeBlock;
            if (ctx.scode() != null) {
                codeBlock = visitCode(ctx.scode().getText(), 2);
            } else {
                codeBlock = visitCode(ctx.code().getText(), 1);
                codeBlock.setMetadata(new TagImpl(), Neio.INLINE_CODE);
            }
            if (codeBlock.nbStatements() != 0) {
                // A block of code has been found, round up the expressions found before this block
                if (previousExpression != null) {
                    block.addStatement(ooFactory().createStatement(previousExpression));
                }
                block.addStatement(codeBlock);
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
            } else if (ctx.postfixCall() != null) {
                previousExpression = visitPostFixCall(ctx.postfixCall());
            } else if (ctx.text() != null) {
                previousExpression = visitText(ctx.text());
//            } else if (ctx.TAG() != null) {
//                previousExpression = visitTag(ctx.TAG());
            } else if (ctx.customCommand() != null) {
                // Stop the previous statement
                if (previousExpression != null) {
                    block.addStatement(ooFactory().createStatement(previousExpression));
                }
                previousExpression = null;
                Block b = ooFactory().createBlock();
                MethodInvocation mi = (MethodInvocation) visitCustomCommand(ctx.customCommand());
                b.addStatement(ooFactory().createStatement(mi));
                block.addStatement(b);
            } else {
                throw new ChameleonProgrammerException("Method could not be found!");
            }
        }

        return null;
    }

    private Expression visitTag(TerminalNode node) {
        String tag = node.getText();
        tag = tag.substring(1, tag.length() - 1);

        ClassParser.ExpressionContext context = getParser(tag).expression();
        Expression e = null;
        ClassConverter converter = new ClassConverter(document, view);
        if (context instanceof ClassParser.IdentifierExpressionContext) {
            ClassParser.IdentifierExpressionContext c = (ClassParser.IdentifierExpressionContext) context;
            e = converter.visitIdentifierExpression(c);
        } else if (context instanceof ClassParser.LowPriorityNumbericalExpressionContext) {
            ClassParser.LowPriorityNumbericalExpressionContext c = (ClassParser.LowPriorityNumbericalExpressionContext) context;
            e = converter.visitLowPriorityNumbericalExpression(c);
        } else if (context instanceof ClassParser.HighPriorityNumbericalExpressionContext) {
            ClassParser.HighPriorityNumbericalExpressionContext c = (ClassParser.HighPriorityNumbericalExpressionContext) context;
            e = converter.visitHighPriorityNumbericalExpression(c);
        } else {
            System.err.println("Unknown type of label encountered: " + tag);
        }

        return e;
    }

    @Override
    public Expression visitPrefixCall(PrefixCallContext ctx) {
        // Find the method name and print it
        String methodName = "";
        List<Expression> arguments = new ArrayList<>();
        if (ctx.MethodName() != null && !ctx.MethodName().isEmpty()) {
            for (TerminalNode h : ctx.MethodName()) {
                methodName += h;
            }

            // Find the arguments
            String argument = visitSentence(ctx.sentence());
            arguments.add(ooFactory().createStringLiteral(argument));
        } else {
            methodName = IMAGE;
            String caption = "";
            for (int i = 0; i < ctx.WORD().size() - 1; i++) {
                caption += ctx.WORD().get(i).getText() + " ";
            }
            arguments.add(ooFactory().createStringLiteral(caption));
            arguments.add(ooFactory().createStringLiteral(ctx.WORD().get(ctx.WORD().size() - 1).getText()));
        }

        return expressionFactory().createNeioMethodInvocation(methodName, previousExpression, arguments);
    }

    private Expression visitPostFixCall(PostfixCallContext ctx) {
        return null;
    }

    public String visitSentence(SentenceContext ctx) {
        List<TerminalNode> nodes = ctx.WORD();
        String result = "";
        for (int j = 0; j < nodes.size(); j++) {
            TerminalNode tn = nodes.get(j);
            result += tn;

            // Do not add a space to the end of a sentence
            if (j != nodes.size() - 1) {
                result += " ";
            }
        }

        return result;
    }

    @Override
    public Expression visitCustomCommand(@NotNull CustomCommandContext ctx) {
        // Remove the backslash
        String code = ctx.getText().substring(1);
        if (ctx.L_BRACE() == null) {
            code += "()";
        }
        code += ";";

        InputStream stream = new ByteArrayInputStream(code.getBytes(StandardCharsets.UTF_8));
        ANTLRInputStream input = null;
        try {
            input = new ANTLRInputStream(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Lexer lexer = new ClassLexer(input);
        TokenStream tokens = new CommonTokenStream(lexer);

        ClassParser parser = new ClassParser(tokens);
        return ((StatementExpression) new ClassConverter(document, view).visit(parser.statement())).getExpression();
    }

    @Override
    public Expression visitText(TextContext ctx) {
        String paragraph = "";
        List<SentenceContext> sentences = ctx.sentence();
        for (int i = 0; i < sentences.size(); i++) {
            SentenceContext s = sentences.get(i);
            paragraph += visitSentence(s);

            // Do not add a newline to the end of the paragraph
            if (i != sentences.size() - 1) {
                paragraph += "\\n";
            }
        }

        // This is always the newline method
        String methodName = "newline";

        List<Expression> arguments = new ArrayList<>();
        arguments.add(ooFactory().createStringLiteral(paragraph));

        return expressionFactory().createNeioMethodInvocation(methodName, previousExpression, arguments);
    }

    public Block visitCode(String code, int sepLen) {
        // Remove the separator
        code = code.substring(sepLen, code.length() - sepLen);
        // Add a semicolon if needed
        int index = code.length();
        while (Pattern.matches("[\t\n\r ]", code.charAt(--index) + "")) ;

        if (code.charAt(index) != ';') {
            code = new StringBuilder(code).insert(index + 1, ';').toString();
        }

        // Add newlines if needed
        if (code.charAt(0) != '\n') {
            code = '\n' + code;
        }
        if (code.charAt(code.length() - 1) != '\n') {
            code += '\n';
        }

        // Add the curly braces required for the parsing of a block
        code = "{" + code + "}";

        return new ClassConverter(document, view).visitBlock(getParser(code).block());
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
