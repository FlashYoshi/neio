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
import org.aikodi.chameleon.oo.expression.Literal;
import org.aikodi.chameleon.oo.expression.MethodInvocation;
import org.aikodi.chameleon.oo.method.Method;
import org.aikodi.chameleon.oo.plugin.ObjectOrientedFactory;
import org.aikodi.chameleon.oo.statement.Block;
import org.aikodi.chameleon.oo.statement.Statement;
import org.aikodi.chameleon.oo.type.Type;
import org.aikodi.chameleon.oo.type.TypeReference;
import org.aikodi.chameleon.oo.type.generics.TypeArgument;
import org.aikodi.chameleon.oo.type.inheritance.InheritanceRelation;
import org.aikodi.chameleon.oo.variable.FormalParameter;
import org.aikodi.chameleon.support.expression.AssignmentExpression;
import org.aikodi.chameleon.support.member.simplename.variable.MemberVariableDeclarator;
import org.aikodi.chameleon.support.modifier.Constructor;
import org.aikodi.chameleon.support.modifier.Interface;
import org.aikodi.chameleon.support.modifier.Private;
import org.aikodi.chameleon.support.modifier.Public;
import org.aikodi.chameleon.support.statement.ReturnStatement;
import org.antlr.v4.runtime.misc.NotNull;
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

    public ClassConverter(Document document, JavaView view) {
        this.document = document;
        this.neio = view.language(Neio.class);
    }

    protected Factory factory() {
        return neio.plugin(Factory.class);
    }

    protected NeioFactory ooFactory() {
        return (NeioFactory) neio.plugin(ObjectOrientedFactory.class);
    }

    protected NeioExpressionFactory eFactory() {
        return (NeioExpressionFactory) neio.plugin(ExpressionFactory.class);
    }

    public Object visitDocument(DocumentContext ctx) {
        visitHeader(ctx);
        return null;
    }

    private void visitHeader(DocumentContext ctx) {
        String header = ctx.HEADER().getText();
        String klassName = ctx.CLASS_NAME().getText();
        visitDocument(ctx, klassName, header);
    }

    private void visitDocument(DocumentContext ctx, String klassName, String header) {
        NamespaceDeclaration ns = visitNamespace(ctx.namespace());

        Type klass = ooFactory().createRegularType(klassName);
        // Every class is allowed to be public for now
        klass.addModifier(new Public());

        visitInheritances(ctx, klass);

        switch (header) {
            case CLASS:
                visitClass(ctx.body().classBody(), klass);
                break;
            case INTERFACE:
                visitInterface(ctx.body().interfaceBody(), klass);
                break;
            default:
                throw new IllegalArgumentException("Header was unknown: " + header);
        }

        ns.add(klass);
        document.add(ns);
    }

    private void visitClass(ClassBodyContext ctx, Type klass) {
        visitFields(ctx, klass);
        visitMethods(ctx, klass);
    }

    private void visitInterface(InterfaceBodyContext ctx, Type klass) {
        klass.addModifier(new Interface());
        for (DeclContext decl : ctx.decl()) {
            String returnType = decl.CLASS_NAME().getText();
            Method method = ooFactory().createMethod(decl.methodName().getText(), returnType);
            method.header().addFormalParameters(visitArguments(decl.arguments()));
            klass.add(method);
        }
    }

    @Override
    public NamespaceDeclaration visitNamespace(NamespaceContext ctx) {
        return factory().createNamespaceDeclaration(ooFactory().createNamespaceReference(ctx.chain().getText()));
    }

    private void visitInheritances(DocumentContext ctx, Type klass) {
        for (InheritanceContext inheritance : ctx.inheritance()) {
            klass.addInheritanceRelation(visitInheritance(inheritance));
        }
    }

    @Override
    public InheritanceRelation visitInheritance(InheritanceContext ctx) {
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

        MemberVariableDeclarator m = ooFactory().createMemberVariableDeclarator(name, type);
        // Every field should be private by default
        m.addModifier(new Private());

        return m;
    }

    private void visitMethods(ClassBodyContext body, Type klass) {
        for (MethodContext method : body.method()) {
            klass.add(visitMethod(method, klass.name()));
        }
    }

    public Method visitMethod(MethodContext ctx, String klassName) {
        // Is this a nested method?
        Modifier m = null;
        if (ctx.MODIFIER() != null) {
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
        Expression e = eFactory().createNameExpression(ctx.var().CAMEL_CASE().getText());

        return ooFactory().createLocalVariable(ooFactory().createTypeReference(ctx.var().fieldName().getText()),
                ctx.var().CAMEL_CASE().getText(), e);
    }

    private Statement visitNewDeclarationAssignment(NewAssignmentContext ctx) {
        Statement declaration;
        Expression value = visitNewCall(ctx.newCall());

        // Neio new call
        if (ctx.EQUALS() == null) {
            String type = ctx.newCall().CLASS_NAME() == null
                    ? ctx.newCall().genericType().getText()
                    : ctx.newCall().CLASS_NAME().getText();
            declaration = ooFactory().createLocalVariable(type, ctx.CAMEL_CASE().getText(), value);
        }
        // Java new call
        else {
            FieldNameContext fieldName = ctx.var().fieldName();
            TypeReference type;
            if (ctx.var().fieldName().genericType() != null) {
                type = visitGenericType(fieldName.genericType());
            } else {
                type = ooFactory().createTypeReference(fieldName.getText());
            }

            declaration = ooFactory().createLocalVariable(type, ctx.var().CAMEL_CASE().getText(), value);
        }

        return declaration;
    }

    @Override
    public TypeReference visitGenericType(GenericTypeContext ctx) {
        return ooFactory().createGenericTypeReference(ctx.CLASS_NAME().getText(), visitGenericArgs(ctx.genericArgs()));
    }

    @Override
    public List<TypeArgument> visitGenericArgs(@NotNull GenericArgsContext ctx) {
        List<TypeArgument> arguments = new ArrayList<>();
        ctx.genericArg().forEach(a -> arguments.add(visitGenericArg(a)));

        return arguments;
    }

    @Override
    public TypeArgument visitGenericArg(@NotNull GenericArgContext ctx) {
        if (ctx.CLASS_NAME() != null) {
            return ooFactory().createTypeArgument(ctx.CLASS_NAME().getText());
        } else {
            return ooFactory().createTypeArgument(visitGenericType(ctx.genericType()));
        }
    }

    private boolean varDeclaration(NewAssignmentContext ctx) {
        return ctx.CAMEL_CASE() == null || ctx.EQUALS() == null;
    }

    private Expression getNewExpression(NewAssignmentContext ctx) {
        Expression var;
        if (ctx.CAMEL_CASE() != null) {
            var = eFactory().createNameExpression(ctx.CAMEL_CASE().getText());
        } else {
            var = eFactory().createNameExpression(ctx.var().CAMEL_CASE().getText());
        }

        return var;
    }

    @Override
    public Expression visitNewAssignment(NewAssignmentContext ctx) {
        Expression var = getNewExpression(ctx);
        Expression value = visitNewCall(ctx.newCall());

        return eFactory().createAssignmentExpression(var, value);
    }

    @Override
    public Expression visitNewCall(NewCallContext ctx) {
        String type;
        if (ctx.CLASS_NAME() != null) {
            type = ctx.CLASS_NAME().getText();
        } else {
            type = ctx.genericType().getText();
        }

        List<Expression> parameters = visitParameters(ctx.parameters());
        return eFactory().createConstructor(type, null, parameters);
    }

    @Override
    public Expression visitMethodCall(MethodCallContext ctx) {
        Expression e = null;
        ThisChainContext chain = ctx.thisChain();
        if (chain != null) {
            e = eFactory().createNameExpression(chain.getText());
        }

        MethodInvocation invocation = eFactory().createInvocation(ctx.call().methodName().getText(), e);
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
            return eFactory().createNameExpression(ctx.CAMEL_CASE().getText());
        } else if (ctx.literal() != null) {
            return visitLiteral(ctx.literal());
        } else {
            return visitMethodCall(ctx.methodCall());
        }
    }

    @Override
    public AssignmentExpression visitAssignment(AssignmentContext ctx) {
        return eFactory().createAssignmentExpression(getAssignmentVar(ctx), getAssignmentValue(ctx));
    }

    private Expression getAssignmentVar(AssignmentContext ctx) {
        if (ctx.thisChain() != null && !ctx.thisChain().isEmpty()) {
            return visitThisChain(ctx.thisChain());
        } else if (ctx.CAMEL_CASE() != null) {
            return eFactory().createNameExpression(ctx.CAMEL_CASE().get(0).getText());
        } else {
            throw new IllegalArgumentException("Nothing to assign to: " + ctx.getText());
        }
    }

    public Expression visitThisChain(ThisChainContext ctx) {
        String chain = getChain(ctx);
        String prefix = getPrefix(chain);
        String thisOrSuper = "";
        if (ctx.THIS() != null || ctx.SUPER() != null) {
            thisOrSuper = ctx.THIS() == null ? ctx.SUPER().getText() : ctx.THIS().getText();
        }

        if (prefix.isEmpty()) {
            return eFactory().createNameExpression(chain);
        } else {
            String varName = getSuffix(chain);
            return eFactory().createNameExpression(varName, eFactory().createNamedTarget(thisOrSuper + prefix));
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

        if (ctx.THIS() != null || ctx.SUPER() != null) {
            chain += (ctx.THIS() == null ? ctx.SUPER().getText() : ctx.THIS().getText()) + ".";
        }

        if (ctx.chain() != null) {
            chain += ctx.chain().getText();
        }

        return chain;
    }

    private Expression getAssignmentValue(AssignmentContext ctx) {
        if (ctx.PLUS().isEmpty()) {
            if (ctx.CAMEL_CASE() != null && !ctx.CAMEL_CASE().isEmpty()) {
                return eFactory().createNameExpression(ctx.CAMEL_CASE().get(0).getText());
            } else if (ctx.methodCall() != null) {
                return visitMethodCall(ctx.methodCall(0));
            } else {
                throw new IllegalArgumentException("Nothing assignable found: " + ctx.getText());
            }
        } else {
            // TODO: do the plus
            return null;
        }
    }

    @Override
    public Literal visitLiteral(@NotNull LiteralContext ctx) {
        if (ctx.integer() != null) {
            return ooFactory().createIntegerLiteral(ctx.integer().getText());
        } else {
            return ooFactory().createStringLiteral(ctx.STRING_LITERAL().getText());
        }
    }

    @Override
    public ReturnStatement visitReturnCall(ReturnCallContext ctx) {
        Expression e;
        if (ctx.PLUS().isEmpty()) {
            return ooFactory().createReturnStatement(visitReturnIntern(ctx.returnIntern(0)));
        } else {
            // TODO: do the plus
            return null;
        }
    }

    @Override
    public Expression visitReturnIntern(@NotNull ReturnInternContext ctx) {
        Expression e;
        if (ctx.newCall() != null) {
            e = visitNewCall(ctx.newCall());
        } else if (ctx.CAMEL_CASE() != null) {
            e = eFactory().createNameExpression(ctx.CAMEL_CASE().getText());
        } else if (ctx.methodCall() != null) {
            e = visitMethodCall(ctx.methodCall());
        } else if (ctx.literal() != null) {
            e = visitLiteral(ctx.literal());
        } else {
            throw new IllegalArgumentException("Nothing to assign to: " + ctx.getText());
        }

        return e;
    }
}
