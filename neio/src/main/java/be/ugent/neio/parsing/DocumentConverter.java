package be.ugent.neio.parsing;

import be.kuleuven.cs.distrinet.jnome.workspace.JavaView;
import be.ugent.neio.expression.NeioMethodInvocation;
import be.ugent.neio.industry.NeioExpressionFactory;
import be.ugent.neio.industry.NeioFactory;
import be.ugent.neio.language.Neio;
import be.ugent.neio.model.document.TextDocument;
import be.ugent.neio.util.CodeTag;
import be.ugent.neio.util.Constants;
import org.aikodi.chameleon.core.document.Document;
import org.aikodi.chameleon.core.tag.TagImpl;
import org.aikodi.chameleon.exception.ChameleonProgrammerException;
import org.aikodi.chameleon.oo.expression.Expression;
import org.aikodi.chameleon.oo.expression.ExpressionFactory;
import org.aikodi.chameleon.oo.expression.MethodInvocation;
import org.aikodi.chameleon.oo.plugin.ObjectOrientedFactory;
import org.aikodi.chameleon.oo.statement.Block;
import org.aikodi.chameleon.oo.statement.Statement;
import org.aikodi.chameleon.support.member.simplename.method.RegularMethodInvocation;
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
import java.util.Stack;
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
    private Stack<Expression> argumentExpression = new Stack<>();
    private Block block = null;
    private int lonecodeid;
    private boolean append;
    private boolean appendInline;

    public DocumentConverter(Document document, JavaView view) {
        this.document = (TextDocument) document;
        this.view = view;
        this.neio = view.language(Neio.class);
        this.lonecodeid = 0;
        this.append = true;
        this.appendInline = true;
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
        ctx.content().forEach(this::visit);

        if (previousExpression != null) {
            block.addStatement(ooFactory().createStatement(previousExpression));
        }
        return block;
    }

    @Override
    public Object visitLonecodeC(@NotNull LonecodeCContext ctx) {
        processCodeBlock(ctx.lonecode());
        return null;
    }

    @Override
    public Object visitScodeC(@NotNull ScodeCContext ctx) {
        processCodeBlock(ctx.scode());
        return null;
    }

    // If the previous expression was a codeblock and there's more neioscript
    // add THIS as prefix to connect back to the rest of the document
    private void fixPreviousExpression() {
        if (previousExpression == null) {
            previousExpression = ooFactory().createThisLiteral();
        }
    }

    @Override
    public Object visitPrefixC(@NotNull PrefixCContext ctx) {
        fixPreviousExpression();
        previousExpression = visitPrefixCall(ctx.prefixCall());
        return null;
    }

    @Override
    public Object visitTextC(@NotNull TextCContext ctx) {
        fixPreviousExpression();
        previousExpression = visitText(ctx.text());
        return null;
    }

    @Override
    public Object visitNlC(@NotNull NlCContext ctx) {
        fixPreviousExpression();
        previousExpression = visitNl(ctx.nl());
        return null;
    }

    private void processCodeBlock(ScodeContext ctx) {
        assembleCodeBlock(processScode(ctx));
    }

    private void processCodeBlock(LonecodeContext ctx) {
        assembleCodeBlock(processLoneCode(ctx));
    }

    private void assembleCodeBlock(Block codeBlock) {
        if (codeBlock.nbStatements() != 0) {
            // A block of code has been found, round up the expressions found before this block
            if (previousExpression != null) {
                block.addStatement(ooFactory().createStatement(previousExpression));
            }
            if (codeBlock.metadata(Neio.LONE_CODE) != null) {
                for (Statement s : codeBlock.statements()) {
                    s.setMetadata(new CodeTag(lonecodeid), Neio.LONE_CODE);
                    block.addStatement(s);
                }
                lonecodeid++;
            } else {
                block.addStatement(codeBlock);
            }
            previousExpression = null;
        }
    }


    private Block processLoneCode(LonecodeContext lonecode) {
        Block codeBlock = visitCode(lonecode.getText(), "{".length(), false);
        codeBlock.setMetadata(new TagImpl(), Neio.LONE_CODE);

        return codeBlock;
    }

    private Block processScode(ScodeContext scode) {
        return visitCode(scode.getText(), "{{".length());
    }

    @Override
    public NeioMethodInvocation visitPrefixCall(PrefixCallContext ctx) {
        // Find the method name and print it
        String methodName = ctx.MethodName().getText();
        List<Expression> arguments = new ArrayList<>();

        // Find the arguments
        if (ctx.txt() != null) {
            Expression argument = visitTxt(ctx.txt());
            arguments.add(argument);
        }

        previousExpression = expressionFactory().createNeioMethodInvocation(methodName, previousExpression, arguments);
        if (ctx.cPrefixCall() != null) {
            return visitCPrefixCall(ctx.cPrefixCall());
        } else {
            return (NeioMethodInvocation) previousExpression;
        }
    }

    @Override
    public NeioMethodInvocation visitCPrefixCall(CPrefixCallContext ctx) {
        String methodName = ctx.preMethodName().getText();
        List<Expression> arguments = new ArrayList<>();

        // Find the arguments
        if (ctx.txt() != null) {
            Expression argument = visitTxt(ctx.txt());
            arguments.add(argument);
        }

        previousExpression = expressionFactory().createNeioMethodInvocation(methodName, previousExpression, arguments);
        if (ctx.cPrefixCall() != null) {
            return visitCPrefixCall(ctx.cPrefixCall());
        } else {
            return (NeioMethodInvocation) previousExpression;
        }
    }

    @Override
    public Expression visitSurroundCall(@NotNull SurroundCallContext ctx) {
        String name = Constants.SURROUND + ctx.left.getText();
        Expression result;

        if (!ctx.ESCAPE().isEmpty()) {
            String text = "";
            for (TerminalNode tn : ctx.ESCAPE()) {
                text += (String) visit(tn);
            }
            result = createText(text);
        } else if (ctx.inlinecode() != null) {
            boolean temp = appendInline;
            appendInline = false;
            result = visitInlinecode(ctx.inlinecode());
            appendInline = temp;
        } else {
            result = createText((String) visit(ctx.WORD()));
        }

        if (ctx.txt() != null) {
            result = appendText(result, visitTxt(ctx.txt()));
        }

        List<Expression> arguments = new ArrayList<>();
        arguments.add(result);


        // There is nothing in front of this surround text, make sure there is a Text
        if (!argumentExpression.isEmpty() && argumentExpression.peek() == null) {
            argumentExpression.pop();
            argumentExpression.push(createText(""));
        }


        Expression e = expressionFactory().createNeioMethodInvocation(name, argumentExpression.pop(), arguments);
        e.setMetadata(new TagImpl(), Constants.SURROUND);

        return e;
    }

    @Override
    public Expression visitText(@NotNull TextContext ctx) {
        Expression txt = visitTxt(ctx.txt());
        if (append) {
            return appendText(previousExpression, txt);
        } else {
            return txt;
        }
    }

    @Override
    public Expression visitTxt(@NotNull TxtContext ctx) {
        Expression result;
        argumentExpression.push(null);

        // This is just plain text
        if ((ctx.inlinecode() == null || ctx.inlinecode().isEmpty())
                && (ctx.surroundCall() == null || ctx.surroundCall().isEmpty())) {
            result = createText(ctx.getText());
            argumentExpression.pop();
        }
        // There's a mix of code and text
        // Only code is not possible as that would be LONE_CODE
        else {
            for (int i = 0; i < ctx.getChildCount(); i++) {
                Object o = visit(ctx.getChild(i));
                if (o instanceof String) {
                    argumentExpression.push(appendText(argumentExpression.pop(), createText((String) o)));
                } else {
                    argumentExpression.push((Expression) o);
                }
            }
            result = argumentExpression.pop();
        }

        return result;
    }

    @Override
    public String visitTextWSpaces(@NotNull TextWSpacesContext ctx) {
        return ctx.getText();
    }

    @Override
    public String visitTerminal(TerminalNode node) {
        return node.getText();
    }

    // e1.TEXT(e2)
    private Expression appendText(Expression e1, Expression e2) {
        List<Expression> arguments = new ArrayList<>();
        arguments.add(e2);

        if (e1 != null) {
            return expressionFactory().createNeioMethodInvocation(TEXT_CALL, e1, arguments);
        } else {
            return e2;
        }
    }

    @Override
    public Expression visitInlinecode(@NotNull InlinecodeContext ctx) {
        Block b = visitCode(ctx.getText(), "{".length(), false);
        if (b.nbStatements() != 1) {
            throw new ChameleonProgrammerException("Inline code can only have 1 statement");
        }

        Statement s = b.statement(0);
        Expression e = s.nearestDescendants(Expression.class).get(0);

        if (e instanceof RegularMethodInvocation) {
            RegularMethodInvocation expression = (RegularMethodInvocation) e;
            while (!expression.nearestDescendants(RegularMethodInvocation.class).isEmpty()) {
                expression = expression.nearestDescendants(RegularMethodInvocation.class).get(0);
            }
            if (expression.getTarget() == null) {
                ((MethodInvocation) e).setTarget(ooFactory().createThisLiteral());
            }
        }

        Expression result = createText(e);
        if (appendInline) {
            return appendText(argumentExpression.pop(), result);
        } else {
            return result;
        }
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

    @Override
    public Expression visitNl(NlContext ctx) {
        return expressionFactory().createNeioMethodInvocation(NEWLINE, previousExpression, new ArrayList<>());
    }

    private Block visitCode(String code, int sepLen) {
        return visitCode(code, sepLen, true);
    }

    private Block visitCode(String code, int sepLen, boolean contextTypes) {
        // Remove the separator
        code = code.trim();
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
        converter.flipStringText();
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

    public void setAppend(boolean append) {
        this.append = append;
    }
}
