package be.ugent.neio.parsing;

import be.kuleuven.cs.distrinet.jnome.workspace.JavaView;
import be.ugent.neio.industry.NeioExpressionFactory;
import be.ugent.neio.industry.NeioFactory;
import be.ugent.neio.industry.NeioLanguageFactory;
import be.ugent.neio.language.Neio;
import be.ugent.neio.model.document.TextDocument;
import be.ugent.neio.model.modifier.Nested;
import org.aikodi.chameleon.core.lookup.LookupException;
import org.aikodi.chameleon.core.modifier.Modifier;
import org.aikodi.chameleon.core.namespace.LazyRootNamespace;
import org.aikodi.chameleon.exception.ChameleonProgrammerException;
import org.aikodi.chameleon.oo.expression.Expression;
import org.aikodi.chameleon.oo.expression.ExpressionFactory;
import org.aikodi.chameleon.oo.method.Method;
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
import java.util.stream.Collectors;


/**
 * @author Titouan Vervack
 */
public class DocumentConverter extends DocumentParserBaseVisitor<Object> {

    private final Neio neio;
    private final String name;
    private final JavaView view;
    private Type previousType;

    public DocumentConverter(JavaView view, String name) {
        this.view = view;
        this.neio = view.language(Neio.class);
        this.name = name;
        previousType = null;
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
        Expression expression = expressionFactory().createMethodInvocation(documentType, null, new ArrayList<>());
        try {
            setPreviousType(view.findType(documentType));
        } catch (LookupException e) {
            throw new ChameleonProgrammerException("Could not lookup: " + e);
        }

        return expression;
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
            expression = visitText(ctx);
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
        System.out.println(methodName);

        // Find the arguments and print them
        String argument = createSentence(ctx.prefixCall().sentence().WORD());

        // Find the method in the Neio classes
        Method m = findNeioMethod(methodName);

        // Add the arguments
        List<Expression> arguments = new ArrayList<>();
        arguments.add(ooFactory().createStringLiteral(argument));

        // Add the nesting level in case this is a nested method
        if (isNested(m)) {
            // nestingLevel since this is a property that might be used by the chapter to decide what layout to use
            // The total level is not important for this chapter
            arguments.add(ooFactory().createIntegerLiteral(String.valueOf(methodName.length())));
        }

        Expression expression = expressionFactory().createMethodInvocation(m.name(), previousExpression, arguments);
        try {
            setPreviousType(expression.getType());
        } catch (LookupException e) {
            throw new ChameleonProgrammerException("Could not lookup: " + e);
        }

        return expression;
    }

    private void setPreviousType(Type type) {
        previousType = type;
    }

    private Method findNeioMethod(String methodName) {
        // TODO: Should call contextType.inheritedMembers
        return previousType.descendants(Method.class).stream().filter(a -> a.name().equals(methodName)).collect(Collectors.toList()).get(0);
    }

    private boolean isNested(Method m) {
        return hasModifier(m, new Nested());
    }

    private boolean hasModifier(Method method, Modifier has) {
        for (Modifier m : method.modifiers()) {
            if (m.getClass().isInstance(has)) {
                return true;
            }
        }

        return false;
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

    private Expression visitText(ContentContext ctx) {
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

        // Add the statement to the block and add the method to the call stack
        Method method = findNeioMethod(methodName);
        if (method != null) {
            List<Expression> arguments = new ArrayList<>();
            arguments.add(ooFactory().createStringLiteral(paragraph));

            Expression expression = expressionFactory().createMethodInvocation(methodName, ooFactory().createTypeReference(previousType), arguments);

            try {
                setPreviousType(expression.getType());
            } catch (LookupException e) {
                throw new ChameleonProgrammerException("Could not lookup: " + e);
            }

            return expression;
        }
        throw new Error("The method " + methodName + " was not found!");
    }
}
