package be.ugent.neio.parsing;

import be.kuleuven.cs.distrinet.jnome.workspace.JavaView;
import be.ugent.neio.industry.NeioExpressionFactory;
import be.ugent.neio.industry.NeioFactory;
import be.ugent.neio.language.Neio;
import be.ugent.neio.model.modifier.Nested;
import org.aikodi.chameleon.core.document.Document;
import org.aikodi.chameleon.core.factory.Factory;
import org.aikodi.chameleon.core.modifier.Modifier;
import org.aikodi.chameleon.core.namespacedeclaration.NamespaceDeclaration;
import org.aikodi.chameleon.oo.expression.Expression;
import org.aikodi.chameleon.oo.expression.ExpressionFactory;
import org.aikodi.chameleon.oo.expression.MethodInvocation;
import org.aikodi.chameleon.oo.method.Method;
import org.aikodi.chameleon.oo.plugin.ObjectOrientedFactory;
import org.aikodi.chameleon.oo.statement.Block;
import org.aikodi.chameleon.oo.statement.Statement;
import org.aikodi.chameleon.oo.type.Type;
import org.aikodi.chameleon.oo.type.TypeReference;
import org.aikodi.chameleon.oo.type.inheritance.InheritanceRelation;
import org.aikodi.chameleon.oo.variable.FormalParameter;
import org.aikodi.chameleon.support.expression.AssignmentExpression;
import org.aikodi.chameleon.support.member.simplename.variable.MemberVariableDeclarator;
import org.aikodi.chameleon.support.modifier.Constructor;
import org.aikodi.chameleon.support.modifier.Public;
import org.aikodi.chameleon.support.statement.ReturnStatement;
import org.neio.antlr.ClassParser.*;
import org.neio.antlr.ClassParserBaseVisitor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static be.ugent.neio.util.Keywords.CLASS;
import static be.ugent.neio.util.Keywords.INTERFACE;

/**
 * @author Titouan Vervack
 */
public class ClassConverter extends ClassParserBaseVisitor<Object> {

    private final Document document;
    private final Neio neio;
    private final JavaView view;

    public ClassConverter(Document document, JavaView view) {
        this.document = document;
        this.view = view;
        this.neio = view.language(Neio.class);
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

    public Object visitDocument(DocumentContext ctx) {
        visitHeader(ctx);
        return null;
    }

    private void visitHeader(DocumentContext ctx) {
        String header = ctx.HEADER().getText();
        String klassName = ctx.CLASS_NAME().getText();
        switch (header) {
            case CLASS:
                visitClass(ctx, klassName);
                break;
            case INTERFACE:
                break;
            default:
                break;
        }
    }

    private void visitClass(DocumentContext ctx, String klassName) {
        ClassBodyContext body = ctx.body().classBody();
        NamespaceDeclaration ns = visitNamespace(ctx.namespace());

        Type klass = ooFactory().createRegularType(klassName);
        // Every class is allowed to be public for now
        klass.addModifier(new Public());

        visitExtensions(body, klass);
        visitFields(body, klass);
        visitMethods(body, klass);

        ns.add(klass);
        document.add(ns);
    }

    @Override
    public NamespaceDeclaration visitNamespace(NamespaceContext ctx) {
        return factory().createNamespaceDeclaration(ooFactory().createNamespaceReference(ctx.chain().getText()));
    }

    private void visitExtensions(ClassBodyContext body, Type klass) {
        for (ExtensionContext extension : body.extension()) {
            klass.addInheritanceRelation(visitExtension(extension));
        }
    }

    @Override
    public InheritanceRelation visitExtension(ExtensionContext ctx) {
        TypeReference ref = ooFactory().createTypeReference(ctx.chain().getText());

        return ooFactory().createSubtypeRelation(ref);
    }

    private void visitFields(ClassBodyContext body, Type klass) {
        for (FieldContext field : body.field()) {
            klass.add(visitField(field));
        }
    }

    @Override
    public MemberVariableDeclarator visitField(FieldContext ctx) {
        String name = ctx.var().CAMEL_CASE().getText();
        TypeReference type = ooFactory().createTypeReference(ctx.var().fieldName().getText());

        return ooFactory().createMemberVariableDeclarator(name, type);
    }

    private void visitMethods(ClassBodyContext body, Type klass) {
        for (MethodContext method : body.method()) {
            klass.add(visitMethod(method, klass.name()));
        }
    }

    public Method visitMethod(MethodContext ctx, String klassName) {
        // Is this a regex method?
        Modifier m = null;
        if (ctx.METHOD_OPTION() != null) {
            m = new Nested();
        }

        String returnType = klassName;
        Constructor c = null;
        // If their is no return type, this is a constructor
        if (ctx.decl().CLASS_NAME() == null) {
            c = new Constructor();
        } else {
            returnType = ctx.decl().CLASS_NAME().getText();
        }
        Method method = ooFactory().createMethod(ctx.decl().methodName().getText(), returnType);
        method.header().addFormalParameters(visitArguments(ctx.decl().arguments()));

        if (m != null) {
            method.addModifier(m);
        }
        if (c != null) {
            method.addModifier(c);
        }

        Block b = ooFactory().createBlock();
        for (StatementContext statement : ctx.block().statement()) {
            b.addStatement(visitStatement(statement));
        }

        if (ctx.block().returnCall() != null) {
            b.addStatement(visitReturnCall(ctx.block().returnCall()));
        }

        method.setImplementation(ooFactory().createImplementation(b));
        // Every method is allowed to be public for now
        method.addModifier(new Public());

        return method;
    }

    @Override
    public List<FormalParameter> visitArguments(ArgumentsContext ctx) {
        return ctx.var().stream().map(v -> new FormalParameter(v.CAMEL_CASE().getText(), ooFactory().createTypeReference(v.fieldName().getText()))).collect(Collectors.toList());
    }

    @Override
    public Statement visitStatement(StatementContext ctx) {
        Expression e;
        if (ctx.newAssignment() != null) {
            if (!varDeclaration(ctx.newAssignment())) {
                e = visitNewAssignment(ctx.newAssignment());
            } else {
                return visitNewDeclarationAssignment(ctx.newAssignment());
            }
        } else if (ctx.methodCall() != null) {
            e = visitMethodCall(ctx.methodCall());
        } else if (ctx.assignment() != null) {
            if (ctx.assignment().var() != null) {
                return visitAssignmentDeclaration(ctx.assignment());
            } else {
                e = visitAssignment(ctx.assignment());
            }
        } else {
            throw new IllegalArgumentException("Unrecognized statement: " + ctx.getText());
        }

        return ooFactory().createStatement(e);
    }

    private Statement visitAssignmentDeclaration(AssignmentContext ctx) {
        Expression e = expressionFactory().createNameExpression(ctx.var().CAMEL_CASE().getText());

        return ooFactory().createLocalVariable(ooFactory().createTypeReference(ctx.var().fieldName().getText()),
                ctx.var().CAMEL_CASE().getText(), e);
    }

    private Statement visitNewDeclarationAssignment(NewAssignmentContext ctx) {
        Statement declaration;
        Expression value = visitNewCall(ctx.newCall());

        // Neio new call
        if (ctx.EQUALS() == null) {
            String type = ctx.newCall().CLASS_NAME() == null
                    ? ctx.newCall().VAR_WITH_TYPE().getText()
                    : ctx.newCall().CLASS_NAME().getText();
            // Add constructor parameters
            declaration = ooFactory().createLocalVariable(type, ctx.CAMEL_CASE().getText(), value);
        }
        // Java new call
        else {
            TypeReference type = ooFactory().createTypeReference(ctx.var().fieldName().getText());
            declaration = ooFactory().createLocalVariable(type, ctx.var().CAMEL_CASE().getText(), value);
        }

        return declaration;
    }

    private boolean varDeclaration(NewAssignmentContext ctx) {
        return ctx.CAMEL_CASE() == null || ctx.EQUALS() == null;
    }

    private Expression getNewExpression(NewAssignmentContext ctx) {
        Expression var;
        if (ctx.CAMEL_CASE() != null) {
            var = expressionFactory().createNameExpression(ctx.CAMEL_CASE().getText());
        } else {
            var = expressionFactory().createNameExpression(ctx.var().CAMEL_CASE().getText());
        }

        return var;
    }

    @Override
    public Expression visitNewAssignment(NewAssignmentContext ctx) {
        Expression var = getNewExpression(ctx);
        Expression value = visitNewCall(ctx.newCall());

        return expressionFactory().createAssignmentExpression(var, value);
    }

    @Override
    public Expression visitNewCall(NewCallContext ctx) {
        String type;
        if (ctx.CLASS_NAME() != null) {
            type = ctx.CLASS_NAME().getText();
        } else {
            type = ctx.VAR_WITH_TYPE().getText();
        }

        List<Expression> parameters = visitParameters(ctx.parameters());
        return expressionFactory().createConstructor(type, null, parameters);
    }

    @Override
    public Expression visitMethodCall(MethodCallContext ctx) {
        Expression e;
        String chain = ctx.chain().getText();
        String prefix = getPrefix(chain);

        if (getPrefix(chain).isEmpty()) {
            e = expressionFactory().createNameExpression(chain);
        } else {
            e = expressionFactory().createNameExpression(prefix, expressionFactory().createNamedTarget(getSuffix(chain)));
        }
        MethodInvocation invocation = expressionFactory().createInvocation(ctx.call().methodName().getText(), e);
        if (!ctx.call().parameters().isEmpty()) {
            invocation.addAllArguments(visitParameters(ctx.call().parameters()));
        }

        return invocation;
    }

    @Override
    public List<Expression> visitParameters(ParametersContext ctx) {
        List<Expression> parameters = new ArrayList<>();
        ctx.parameter().forEach(a -> parameters.add(visitParameter(a)));

        return parameters;
    }

    @Override
    public Expression visitParameter(ParameterContext ctx) {
        if (ctx.CAMEL_CASE() != null) {
            return expressionFactory().createNameExpression(ctx.CAMEL_CASE().getText());
        } else if (ctx.DIGIT() != null) {
            StringBuilder number = new StringBuilder();
            ctx.DIGIT().forEach(d -> number.append(d.getText()));
            return ooFactory().createIntegerLiteral(number.toString());
        } else {
            return visitMethodCall(ctx.methodCall());
        }
    }

    @Override
    public AssignmentExpression visitAssignment(AssignmentContext ctx) {
        return expressionFactory().createAssignmentExpression(getAssignmentVar(ctx), getAssignmentValue(ctx));
    }

    private Expression getAssignmentVar(AssignmentContext ctx) {
        if (ctx.thisChain() != null && !ctx.thisChain().isEmpty()) {
            return visitThisChain(ctx.thisChain().get(0));
        } else if (ctx.CAMEL_CASE() != null) {
            return expressionFactory().createNameExpression(ctx.CAMEL_CASE().get(0).getText());
        } else {
            throw new IllegalArgumentException("Nothing to assign to: " + ctx.getText());
        }
    }

    public Expression visitThisChain(ThisChainContext ctx) {
        String chain = getChain(ctx);
        String prefix = getPrefix(chain);

        if (prefix.isEmpty()) {
            return expressionFactory().createNameExpression(chain);
        } else {
            String varName = getSuffix(chain);
            return expressionFactory().createNameExpression(varName, expressionFactory().createNamedTarget(prefix));
        }
    }

    private String getPrefix(String s) {
        String[] split = s.split("\\.");
        String prefix = "";
        for (int i = 0; i < split.length - 1; i++) {
            prefix += split[i];
        }

        return prefix;
    }

    private String getSuffix(String s) {
        String[] split = s.split("\\.");

        return split[split.length - 1];
    }

    private String getChain(ThisChainContext ctx) {
        String chain = "";

        if (ctx.THIS() != null) {
            chain += ctx.THIS().getText() + ".";
        }

        if (ctx.chain() != null) {
            chain += ctx.chain().getText();
        }

        if (ctx.CLASS_NAME() != null) {
            chain += ctx.CLASS_NAME().getText();
        }

        if (ctx.CAMEL_CASE() != null) {
            chain += ctx.CAMEL_CASE().getText();
        }

        return chain;
    }

    private Expression getAssignmentValue(AssignmentContext ctx) {
        if (ctx.CAMEL_CASE() != null && !ctx.CAMEL_CASE().isEmpty()) {
            return expressionFactory().createNameExpression(ctx.CAMEL_CASE().get(0).getText());
        } else if (ctx.thisChain() != null && !ctx.thisChain().isEmpty()) {
            int index = 0;
            if (ctx.thisChain().size() > 1) {
                index = 1;
            }

            return visitThisChain(ctx.thisChain().get(index));
        } else if (ctx.methodCall() != null) {
            return visitMethodCall(ctx.methodCall());
        } else {
            throw new IllegalArgumentException("Nothing assignable found: " + ctx.getText());
        }
    }

    @Override
    public ReturnStatement visitReturnCall(ReturnCallContext ctx) {
        Expression e;
        if (ctx.newCall() != null) {
            e = visitNewCall(ctx.newCall());
        } else if (ctx.CAMEL_CASE() != null) {
            e = expressionFactory().createNameExpression(ctx.CAMEL_CASE().getText());
        } else if (ctx.methodCall() != null) {
            e = visitMethodCall(ctx.methodCall());
        } else {
            throw new IllegalArgumentException("Nothing to assign to: " + ctx.getText());
        }

        return ooFactory().createReturnStatement(e);
    }
}
