package be.ugent.neio.parsing;

import be.kuleuven.cs.distrinet.jnome.workspace.JavaView;
import be.ugent.neio.industry.NeioExpressionFactory;
import be.ugent.neio.industry.NeioFactory;
import be.ugent.neio.language.Neio;
import be.ugent.neio.language.Nested;
import be.ugent.neio.parsing.DocumentParser.ContentContext;
import be.ugent.neio.parsing.DocumentParser.DocumentContext;
import be.ugent.neio.parsing.DocumentParser.SentenceContext;
import org.aikodi.chameleon.core.document.Document;
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
import org.aikodi.chameleon.oo.statement.Statement;
import org.aikodi.chameleon.oo.type.Type;
import org.aikodi.chameleon.oo.type.TypeReference;
import org.aikodi.chameleon.oo.variable.FormalParameter;
import org.aikodi.chameleon.support.modifier.Public;
import org.aikodi.chameleon.support.modifier.Static;
import org.antlr.v4.runtime.tree.TerminalNode;

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

    private static final String VAR_NAME = "var";
    private final Document document;
    private final Neio neio;
    private final Block block;
    private final String name;
    private final Stack<Variable> vars;
    private final JavaView view;
    private int varCount = 0;

    public DocumentConverter(Document document, JavaView view, String name) {
        this.document = document;
        this.view = view;
        this.neio = view.language(Neio.class);
        this.block = ooFactory().createBlock();
        this.name = name;
        this.vars = new Stack<>();
    }

    protected Factory factory() {
        return neio.plugin(Factory.class);
    }

    protected NeioFactory ooFactory() {
        return (NeioFactory) neio.plugin(ObjectOrientedFactory.class);
    }

    protected NeioExpressionFactory expressionFactory() {
        return (NeioExpressionFactory) neio.plugin(ExpressionFactory.class);
    }

    public Document visitDocument(DocumentContext ctx) {
        block.addStatement(visitHeader(ctx));
        visitBody(ctx);

        fillDocument();

        return document;
    }

    private void fillDocument() {
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
        document.add(ns);
    }

    private Statement visitHeader(DocumentContext ctx) {
        String header = ctx.HEADER().getText();
        // Strip the brackets
        String documentType = header.substring(1, header.length() - 1);
        String name = getVarName();
        TypeReference type = ooFactory().createTypeReference(documentType);
        Statement s = ooFactory().createLocalVariable(type, name, expressionFactory().createNewExpression(documentType));
        vars.push(new Variable(name, type));

        System.out.println(ctx.HEADER().getText());
        return s;
    }

    private String getVarName() {
        return VAR_NAME + varCount++;
    }

    private void visitBody(DocumentContext ctx) {
        ctx.body().content().forEach(this::visitContent);
    }

    @Override
    public Object visitContent(ContentContext ctx) {
        visitPrefixCall(ctx);
        visitPostFixCall(ctx);
        visitText(ctx);
        if (ctx.mnl() != null) {
            System.out.print(ctx.mnl().getText());
        }
        return null;
    }

    private void visitPrefixCall(ContentContext ctx) {
        if (ctx.prefixCall() != null) {
            String methodName = "";
            for (TerminalNode h : ctx.prefixCall().HASH()) {
                methodName += h;
            }
            System.out.print(methodName + " ");

            String parameter = "";
            for (TerminalNode w : ctx.prefixCall().sentence().WORD()) {
                parameter += w + " ";
            }
            System.out.println(parameter);

            boolean nested = isNested(methodName);
            Method m = findOriginalMethod(methodName, nested);

            TypeReference type = m.returnTypeReference();
            String name = getVarName();
            List<FormalParameter> parameters = new ArrayList<>();
            parameters.add(new FormalParameter(parameter, ooFactory().createTypeReference("String")));
            Variable var;
            if (isNested(m)) {
                int nestedLevel = methodName.length();
                parameters.add(new FormalParameter("" + nestedLevel, ooFactory().createTypeReference("Integer")));
                var = new Variable(name, type, nestedLevel);
            } else {
                var = new Variable(name, type);
            }

            Expression expression = expressionFactory().createMethodCall(vars.peek().getName(), m.name(), parameters);
            block.addStatement(ooFactory().createLocalVariable(type, name, expression));
            vars.push(var);
        }
    }

    private Method findOriginalMethod(String methodName, boolean nested) {
        Method originalMethod = null;
        while (originalMethod == null) {
            if (vars.isEmpty()) {
                throw new IllegalArgumentException("The method " + methodName + " could not be found.");
            }

            Variable var = vars.peek();
            List<Method> methods = getMethods(var.getType());
            if (nested) {
                int nestedLevel = methodName.length();
                // The new nesting can not be the same or smaller than the already existing nesting
                if (!(var.isNested() && nestedLevel <= var.getLevel())) {
                    List<Method> nestedMethods = methods.stream().filter(this::isNested).collect(Collectors.toList());
                    originalMethod = findMethod(methodName.charAt(0) + "", nestedMethods);
                }
            }

            // Did not find it as nested method, try the other methods
            if (originalMethod == null) {
                List<Method> normalMethods = methods.stream().filter(m -> !isNested(m)).collect(Collectors.toList());
                originalMethod = findMethod(methodName, normalMethods);
            }

            // Did not find the method, try on the other part of the tree
            if (originalMethod == null) {
                vars.pop();
            }
        }

        return originalMethod;
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

    private void visitPostFixCall(ContentContext ctx) {
        if (ctx.postfixCall() != null) {
            System.out.println(ctx.postfixCall().getText());
        }
    }

    private void visitText(ContentContext ctx) {
        if (ctx.text() != null) {
            for (SentenceContext s : ctx.text().sentence()) {
                for (TerminalNode w : s.WORD()) {
                    System.out.print(w + " ");
                }
                System.out.println();
            }
        }
    }
}
