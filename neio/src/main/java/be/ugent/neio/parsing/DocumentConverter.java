package be.ugent.neio.parsing;

import be.kuleuven.cs.distrinet.jnome.workspace.JavaView;
import be.ugent.neio.industry.NeioExpressionFactory;
import be.ugent.neio.industry.NeioFactory;
import be.ugent.neio.language.Neio;
import be.ugent.neio.model.modifier.Nested;
import be.ugent.neio.model.type.ContextType;
import org.aikodi.chameleon.core.factory.Factory;
import org.aikodi.chameleon.core.lookup.LookupException;
import org.aikodi.chameleon.core.modifier.Modifier;
import org.aikodi.chameleon.core.namespacedeclaration.NamespaceDeclaration;
import org.aikodi.chameleon.exception.ChameleonProgrammerException;
import org.aikodi.chameleon.oo.expression.Expression;
import org.aikodi.chameleon.oo.expression.ExpressionFactory;
import org.aikodi.chameleon.oo.method.Method;
import org.aikodi.chameleon.oo.plugin.ObjectOrientedFactory;
import org.aikodi.chameleon.oo.statement.Block;
import org.aikodi.chameleon.oo.type.Type;
import org.aikodi.chameleon.oo.type.TypeReference;
import org.aikodi.chameleon.oo.variable.FormalParameter;
import org.aikodi.chameleon.support.modifier.Public;
import org.aikodi.chameleon.support.modifier.Static;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.neio.antlr.DocumentParser.ContentContext;
import org.neio.antlr.DocumentParser.DocumentContext;
import org.neio.antlr.DocumentParser.SentenceContext;
import org.neio.antlr.DocumentParserBaseVisitor;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author Titouan Vervack
 */
public class DocumentConverter extends DocumentParserBaseVisitor<Object> {

    private final Neio neio;
    private final Block block;
    private final String name;
    private final JavaView view;
    private boolean firstMethod;
    private Type previousType;

    public DocumentConverter(JavaView view, String name) {
        this.view = view;
        this.neio = view.language(Neio.class);
        this.block = ooFactory().createBlock();
        this.name = name;
        previousType = null;
        firstMethod = true;
    }

    protected NeioFactory factory() {
        return (NeioFactory) neio.plugin(Factory.class);
    }

    protected NeioFactory ooFactory() {
        return (NeioFactory) neio.plugin(ObjectOrientedFactory.class);
    }

    protected NeioExpressionFactory expressionFactory() {
        return (NeioExpressionFactory) neio.plugin(ExpressionFactory.class);
    }

    public void visitDocument(DocumentContext ctx, NamespaceDeclaration nd) throws LookupException {
        System.out.println("Parsing " + name + "...");
        visitHeader(ctx);
        visitBody(ctx);

        fillDocument(nd);

        //return block;
    }

    private void fillDocument(NamespaceDeclaration nd) {
        Type type = ooFactory().createRegularType(name);
        type.addModifier(new Public());
        Method method = ooFactory().createMethod("main", "void");
        method.header().addFormalParameter(new FormalParameter("args", ooFactory().createTypeReference("String[]")));
        method.addModifier(new Public());
        method.addModifier(new Static());

        method.setImplementation(ooFactory().createImplementation(block));
        type.add(method);
        nd.add(type);
    }

    private void visitHeader(DocumentContext ctx) throws LookupException {
        String header = ctx.HEADER().getText();
        // Strip the brackets
        String documentType = header.substring(1, header.length() - 1);
        TypeReference type = ooFactory().createTypeReference(documentType);
        Expression expression = expressionFactory().createNewExpression(documentType);
        setPreviousType(view.findType(documentType));

        //TODO: Is this right?
        ooFactory().createStatement(expression);
    }

    private void visitBody(DocumentContext ctx) {
        Expression chainedExpression = null;
        for (ContentContext content : ctx.body().content()) {
            chainedExpression = visitContent(content);
        }

        block.addStatement(ooFactory().createStatement(chainedExpression));
    }

    @Override
    public Expression visitContent(ContentContext ctx) {
        Expression expression;
        if (ctx.prefixCall() != null) {
            try {
                expression = visitPrefixCall(ctx);
            } catch (LookupException e) {
                e.printStackTrace();
                throw new ChameleonProgrammerException("Could not lookup: " + e);
            }
        } else if (ctx.postfixCall() != null) {
            expression = visitPostFixCall(ctx);
        } else if (ctx.text() != null) {
            expression = visitText(ctx);
        } else {
            throw new Error("Method could not be found!");
        }

        return expression;
    }

    private Expression visitPrefixCall(ContentContext ctx) throws LookupException {
        // Find the method name and print it
        String methodName = "";
        for (TerminalNode h : ctx.prefixCall().HASH()) {
            methodName += h;
        }

        // Find the arguments and print them
        String argument = createSentence(ctx.prefixCall().sentence().WORD());

        // Check if this method might be a nested method
        boolean nested = isNested(methodName);
        // Find the method in the Neio classes
        Method m = findNeioMethod(methodName);
        TypeReference type = (TypeReference) m.returnTypeReference().clone();
        ContextType ctxType = new ContextType(m.returnType(), previousType);
        setPreviousType(ctxType);

        // Add the arguments
        List<Expression> arguments = new ArrayList<>();
        arguments.add(ooFactory().createStringLiteral(argument));

        // Prepare the new method to add it to the stack
        if (isNested(m)) {
            int nestingLevel = methodName.length();
            // nestingLevel since this is a property that might be used by the chapter to decide what layout to use
            // The total level is not important for this chapter
            arguments.add(ooFactory().createIntegerLiteral(String.valueOf(nestingLevel)));
        }

        // Add the statement to the block and add the method to the call stack

        return expressionFactory().createMethodInvocation(m.name(), ooFactory().createTypeReference(ctxType), arguments);
    }

    private void setPreviousType(Type type) {
        previousType = type;
    }

//    private void setPreviousType(TypeReference type) {
//        previousType = type;
//    }

    private Method findNeioMethod(String methodName) {
        Method neioMethod = null;
        if (!firstMethod) {
            try {
                previousType.members();
            } catch (LookupException e) {
                e.printStackTrace();
            }
        } else {
            neioMethod = getMethod(ooFactory().createTypeReference(previousType), methodName);
            firstMethod = false;
        }

        return neioMethod;
    }

    private boolean sameNestedMethod(String nestedMethod, String toTest) {
        Pattern p = Pattern.compile("^" + nestedMethod.charAt(0) + "+$");
        Matcher m = p.matcher(toTest);
        return m.matches();
    }

    /**
     * Checks if a method could be a nested method
     *
     * @param method the name of the method to test
     * @return if the method might be a nested method
     */
    private boolean isNested(String method) {
        Pattern p = Pattern.compile("^" + method.charAt(0) + "+$");
        Matcher m = p.matcher(method);
        return m.matches();
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

    private Method findMethod(String methodName, List<Method> methods) {
        for (Method m : methods) {
            if (m.name().equals(methodName)) {
                return (Method) m.clone();
            }
        }

        return null;
    }

    private List<Method> getMethods(TypeReference type) {
        List<Method> result = new ArrayList<>();
        try {
            result.addAll(view.findType(type.toString()).descendants(Method.class));
        } catch (LookupException e) {
            e.printStackTrace();
        }

        return result;
    }

    private Method getMethod(TypeReference type, String methodName) {
        List<Method> methods = getMethods(type);
        return findMethod(methodName, methods);
    }

    private Expression visitPostFixCall(ContentContext ctx) {
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

            TypeReference returnType = method.returnTypeReference();
            Expression expression = expressionFactory().createMethodInvocation(methodName, ooFactory().createTypeReference(previousType), arguments);
            ContextType ctxType = null;
            try {
                ctxType = new ContextType(method.returnType(), previousType);
            } catch (LookupException e) {
                e.printStackTrace();
            }
            setPreviousType(ctxType);

            return expression;
        }
        throw new Error("The method " + methodName + " was not found!");
    }
}
