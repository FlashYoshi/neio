package be.ugent.neio.parsing;

import be.kuleuven.cs.distrinet.jnome.workspace.JavaView;
import be.ugent.neio.industry.NeioExpressionFactory;
import be.ugent.neio.industry.NeioFactory;
import be.ugent.neio.industry.NeioLanguageFactory;
import be.ugent.neio.language.Neio;
import be.ugent.neio.model.document.TextDocument;
import org.aikodi.chameleon.core.namespace.LazyRootNamespace;
import org.aikodi.chameleon.exception.ChameleonProgrammerException;
import org.aikodi.chameleon.oo.expression.Expression;
import org.aikodi.chameleon.oo.expression.ExpressionFactory;
import org.aikodi.chameleon.oo.plugin.ObjectOrientedFactory;
import org.aikodi.chameleon.oo.statement.Block;
import org.aikodi.chameleon.oo.type.Type;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.neio.antlr.DocumentParser.ContentContext;
import org.neio.antlr.DocumentParser.DocumentContext;
import org.neio.antlr.DocumentParser.SentenceContext;
import org.neio.antlr.DocumentParserBaseVisitor;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Titouan Vervack
 */
public class DocumentConverter extends DocumentParserBaseVisitor<Object> {

    private final Neio neio;
    private final String name;

    public DocumentConverter(JavaView view, String name) {
        this.neio = view.language(Neio.class);
        this.name = name;
    }

    protected NeioFactory ooFactory() {
        return (NeioFactory) neio.plugin(ObjectOrientedFactory.class);
    }

    protected NeioExpressionFactory expressionFactory() {
        return (NeioExpressionFactory) neio.plugin(ExpressionFactory.class);
    }

    @Override
    public TextDocument visitDocument(DocumentContext ctx) {
        System.out.println("Parsing " + name + "...");
        Expression headerExpression = visitHeader(ctx);
        Expression expression = visitBody(ctx, headerExpression);

        Block block = ooFactory().createBlock();
        block.addStatement(ooFactory().createStatement(expression));

        return createDocument(block);
    }

    private TextDocument createDocument(Block block) {
        Neio target = new NeioLanguageFactory().create();
        JavaView targetView = new JavaView(new LazyRootNamespace(), target);

        return new TextDocument(targetView, block);
    }

    private Expression visitHeader(DocumentContext ctx) {
        String header = ctx.HEADER().getText();
        // Strip the brackets
        String documentType = header.substring(1, header.length() - 1);

        return expressionFactory().createConstructor(documentType, null);
    }

    public Expression visitBody(DocumentContext ctx, Expression expression) {
        for (ContentContext c : ctx.body().content()) {
            expression = visitContent(c, expression);
        }

        return expression;
    }

    public Expression visitContent(ContentContext ctx, Expression previousExpression) {
        Expression expression;
        if (ctx.prefixCall() != null) {
            expression = visitPrefixCall(ctx, previousExpression);
        } else if (ctx.postfixCall() != null) {
            expression = visitPostFixCall(ctx, previousExpression);
        } else if (ctx.text() != null) {
            expression = visitText(ctx, previousExpression);
        } else {
            throw new ChameleonProgrammerException("Method could not be found!");
        }

        return expression;
    }

    private Expression visitPrefixCall(ContentContext ctx, Expression previousExpression) {
        // Find the method name and print it
        String methodName = "";
        for (TerminalNode h : ctx.prefixCall().HASH()) {
            methodName += h;
        }

        // Find the arguments
        String argument = createSentence(ctx.prefixCall().sentence().WORD());
        List<Expression> arguments = new ArrayList<>();
        arguments.add(ooFactory().createStringLiteral(argument));

        return expressionFactory().createMethodInvocation(methodName, previousExpression, arguments);
    }

    private Expression visitPostFixCall(ContentContext ctx, Expression previousExpression) {
        return null;
    }

    private String createSentence(List<TerminalNode> nodes) {
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

    private Expression visitText(ContentContext ctx, Expression previousExpression) {
        String paragraph = "";
        List<SentenceContext> sentences = ctx.text().sentence();
        for (int i = 0; i < sentences.size(); i++) {
            SentenceContext s = sentences.get(i);
            paragraph += createSentence(s.WORD());

            // Do not add a newline to the end of the paragraph
            if (i != sentences.size() - 1) {
                paragraph += "\\n";
            }
        }

        // This is always the newline method
        String methodName = "newline";

        List<Expression> arguments = new ArrayList<>();
        arguments.add(ooFactory().createStringLiteral(paragraph));

        return expressionFactory().createMethodInvocation(methodName, previousExpression, arguments);
    }
}
