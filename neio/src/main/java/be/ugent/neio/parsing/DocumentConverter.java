package be.ugent.neio.parsing;

import be.kuleuven.cs.distrinet.jnome.workspace.JavaView;
import be.ugent.neio.industry.NeioExpressionFactory;
import be.ugent.neio.industry.NeioFactory;
import be.ugent.neio.language.Neio;
import be.ugent.neio.model.modifier.Nested;
import org.aikodi.chameleon.core.factory.Factory;
import org.aikodi.chameleon.core.lookup.LookupException;
import org.aikodi.chameleon.core.modifier.Modifier;
import org.aikodi.chameleon.core.namespace.NamespaceReference;
import org.aikodi.chameleon.core.namespacedeclaration.NamespaceDeclaration;
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
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


/**
 * @author Titouan Vervack
 */
public class DocumentConverter extends DocumentParserBaseVisitor<Object> {

    private final Neio neio;
    private final Block block;
    private final String name;
    private final Stack<Variable> callStack;
    private final JavaView view;
    private Expression previousExpression;

    public DocumentConverter(JavaView view, String name) {
        this.view = view;
        this.neio = view.language(Neio.class);
        this.block = ooFactory().createBlock();
        this.name = name;
        this.callStack = new Stack<>();
        previousExpression = null;
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

    public NamespaceDeclaration visitDocument(DocumentContext ctx) {
        System.out.println("Parsing " + name + "...");
        visitHeader(ctx);
        visitBody(ctx);

        return fillDocument();

        //return block;
    }

    private NamespaceDeclaration fillDocument() {
        NamespaceDeclaration ns = factory().createNamespaceDeclaration(new NamespaceReference("be.ugent"));
        Type type = ooFactory().createRegularType(name);
        type.addModifier(new Public());
        Method method = ooFactory().createMethod("main", "void");
        method.header().addFormalParameter(new FormalParameter("args", ooFactory().createTypeReference("String[]")));
        method.addModifier(new Public());
        method.addModifier(new Static());

        method.setImplementation(ooFactory().createImplementation(block));
        type.add(method);
        ns.add(type);

        return ns;
    }

    private void visitHeader(DocumentContext ctx) {
        String header = ctx.HEADER().getText();
        // Strip the brackets
        String documentType = header.substring(1, header.length() - 1);
        TypeReference type = ooFactory().createTypeReference(documentType);
        Expression expression = expressionFactory().createNewExpression(documentType);
        setPreviousExpression(expression);

        callStack.push(new Variable(type, 0, documentType));
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
            expression = visitPrefixCall(ctx);
        } else if (ctx.postfixCall() != null) {
            expression = visitPostFixCall(ctx);
        } else if (ctx.text() != null) {
            expression = visitText(ctx);
        } else {
            throw new Error("Method could not be found!");
        }

        return expression;
    }

    private Expression visitPrefixCall(ContentContext ctx) {
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
        Method m = findNeioMethod(methodName, nested);

        // Add the arguments
        List<Expression> arguments = new ArrayList<>();
        arguments.add(ooFactory().createStringLiteral(argument));

        // Prepare the new method to add it to the stack
        TypeReference type = m.returnTypeReference();
        int nextLevel = callStack.peek().getLevel() + 1;
        Variable var;
        if (isNested(m)) {
            int nestingLevel = methodName.length();
            // nestingLevel since this is a property that might be used by the chapter to decide what layout to use
            // The total level is not important for this chapter
            arguments.add(ooFactory().createIntegerLiteral(String.valueOf(nestingLevel)));
            var = new Variable(type, nextLevel, methodName, nestingLevel);
        } else {
            var = new Variable(type, nextLevel, methodName);
        }

        // Add the statement to the block and add the method to the call stack
        Expression expression = expressionFactory().createMethodInvocation(m.name(), previousExpression, arguments);
        setPreviousExpression(expression);
        callStack.push(var);

        return expression;
    }

    private void setPreviousExpression(Expression expression) {
        previousExpression = expression;
    }

    private Method findNeioMethod(String methodName, boolean nested) {
        Method neioMethod = null;
        while (neioMethod == null) {
            if (callStack.isEmpty()) {
                throw new Error("The method " + methodName + " could not be found.");
            }

            Variable var = callStack.peek();
            List<Method> methods = getMethods(var.getType());
            // Do we suspect nesting?
            if (nested) {
                int nestedLevel = methodName.length();
                // Can not nest same elements
                if (!methodName.equals(var.getMethodName())) {
                    List<Method> nestedMethods = methods.stream().filter(this::isNested).collect(Collectors.toList());
                    neioMethod = findMethod(methodName.charAt(0) + "", nestedMethods);
                    // Is the found method really nested?
                    if (neioMethod != null && isNested(neioMethod)) {
                        // Then check the level IF it is not the same kind of method
                        // Level check is for i.e. # when the previous method was ###
                        // The same methodCheck is for i.e. * when the previous method was ##
                        if (sameNestedMethod(neioMethod.name(), methodName) && (nestedLevel <= var.getNestingLevel())) {
                            neioMethod = null;
                        }
                    }
                }
            }

            // Did not find it as nested method, try the other methods
            if (neioMethod == null) {
                List<Method> normalMethods = methods.stream().filter(m -> !isNested(m)).collect(Collectors.toList());
                neioMethod = findMethod(methodName, normalMethods);
            }

            // Did not find the method, try on the other part of the tree
            if (neioMethod == null) {
                callStack.pop();
            }
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
        while (!callStack.isEmpty()) {
            Variable var = callStack.peek();
            Method method = getMethod(var.getType(), methodName);
            if (method != null) {
                List<Expression> arguments = new ArrayList<>();
                arguments.add(ooFactory().createStringLiteral(paragraph));

                TypeReference returnType = method.returnTypeReference();
                Expression expression = expressionFactory().createMethodInvocation(methodName, previousExpression, arguments);
                setPreviousExpression(expression);
                callStack.push(new Variable(returnType, var.getLevel() + 1, methodName));
                // Needed to prevent the exception of being thrown

                return expression;
            } else {
                callStack.pop();
            }
        }
        throw new Error("The method " + methodName + " was not found!");
    }
}
