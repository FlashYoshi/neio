package be.ugent.neio.parsing;

import be.kuleuven.cs.distrinet.jnome.workspace.JavaView;
import be.ugent.neio.industry.NeioFactory;
import be.ugent.neio.language.Neio;
import be.ugent.neio.parsing.ClassParser.*;
import org.aikodi.chameleon.core.document.Document;
import org.aikodi.chameleon.core.factory.Factory;
import org.aikodi.chameleon.core.namespacedeclaration.NamespaceDeclaration;
import org.aikodi.chameleon.oo.expression.Expression;
import org.aikodi.chameleon.oo.expression.ExpressionFactory;
import org.aikodi.chameleon.oo.method.Method;
import org.aikodi.chameleon.oo.plugin.ObjectOrientedFactory;
import org.aikodi.chameleon.oo.statement.Block;
import org.aikodi.chameleon.oo.statement.Statement;
import org.aikodi.chameleon.oo.type.RegularType;
import org.aikodi.chameleon.oo.type.Type;
import org.aikodi.chameleon.oo.type.TypeReference;
import org.aikodi.chameleon.oo.type.inheritance.InheritanceRelation;
import org.aikodi.chameleon.oo.variable.FormalParameter;
import org.aikodi.chameleon.oo.variable.MemberVariable;
import org.aikodi.chameleon.stub.StubExpression;
import org.aikodi.chameleon.support.expression.AssignmentExpression;
import org.aikodi.chameleon.support.modifier.Constructor;
import org.aikodi.chameleon.support.statement.ReturnStatement;
import org.aikodi.chameleon.support.statement.StatementExpression;

import java.util.List;
import java.util.stream.Collectors;

import static be.ugent.neio.util.Keywords.CLASS;
import static be.ugent.neio.util.Keywords.INTERFACE;

/**
 * @author Titouan Vervack
 */
public class ClassConverter extends ClassParserBaseVisitor<Object> {

    private final Document document;
    private final JavaView view;
    private final Neio neio;

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

    protected ExpressionFactory expressionFactory() {
        return neio.plugin(ExpressionFactory.class);
    }

    public Object visitDocument(DocumentContext ctx) {
        visitHeader(ctx);
        return null;
    }

    private void visitHeader(DocumentContext ctx) {
        String header = ctx.HEADER().getText();
        String klassName = ctx.CLASS_NAME().getText();
        System.out.println(header + " " + klassName);
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
        NamespaceDeclaration ns = factory().createRootNamespaceDeclaration();
        Type klass = ooFactory().createRegularType(klassName);

        visitExtensions(body, klass);
        visitFields(body, klass);
        visitMethods(body, klass);
        System.out.println();

        ns.add(klass);
        document.add(ns);
    }

    private void visitExtensions(ClassBodyContext body, Type klass) {
        for (ExtensionContext extension : body.extension()) {
            System.out.println(extension.chain().getText());
            klass.addInheritanceRelation(visitExtension(extension));
        }
    }

    @Override
    public InheritanceRelation visitExtension(ExtensionContext ctx) {
        // Ignore the namespace for now, it does not really matter at this point
        String ignoredNS = ctx.chain().getChild(ctx.chain().getChildCount() - 1).getText();
        TypeReference ref = ooFactory().createTypeReference(ignoredNS);

        return ooFactory().createSubtypeRelation(ref);
    }

    private void visitFields(ClassBodyContext body, Type klass) {
        for (FieldContext field : body.field()) {
            System.out.println(field.var().fieldName().getText() + " " + field.var().CAMEL_CASE().getText() + ";");
            klass.add(visitField(field));
        }
    }

    @Override
    public MemberVariable visitField(FieldContext ctx) {
        String name = ctx.var().CAMEL_CASE().getText();
        TypeReference type = ooFactory().createTypeReference(ctx.var().fieldName().getText());

        return ooFactory().createMemberVariable(name, type);
    }

    private void visitMethods(ClassBodyContext body, Type klass) {
        for (MethodContext method : body.method()) {
            klass.add(visitMethod(method, klass.name()));
            System.out.println();
        }
    }

    public Method visitMethod(MethodContext ctx, String klassName) {
        // Is this a regex method?
        // TODO: Do something for regex
        if (ctx.METHOD_OPTION() != null) {
            System.out.print(ctx.METHOD_OPTION().getText());
        }
        System.out.println(ctx.decl().getText() + " {");

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

        if (c != null) {
            method.addModifier(c);
        }

        Block b = new Block();
        for (StatementContext statement : ctx.block().statement()) {
            b.addStatement(visitStatement(statement));
        }

        if (ctx.block().returnCall() != null) {
            b.addStatement(visitReturnCall(ctx.block().returnCall()));
        }

        method.setImplementation(ooFactory().createImplementation(b));
        System.out.println("}");

        return method;
    }

    @Override
    public List<FormalParameter> visitArguments(ArgumentsContext ctx) {
        return ctx.var().stream().map(v -> new FormalParameter(v.CAMEL_CASE().getText(), ooFactory().createTypeReference(v.fieldName().getText()))).collect(Collectors.toList());
    }

    @Override
    public Statement visitStatement(StatementContext ctx) {
        System.out.println(ctx.getText());
        // TODO
        Expression e;
        if (ctx.newCall() != null) {
            e = visitNewCall(ctx.newCall());
        } else if (ctx.methodCall() != null) {
            e = visitMethodCall(ctx.methodCall());
        } else if (ctx.assignment() != null) {
            e = visitAssignment(ctx.assignment());
        } else {
            throw new IllegalArgumentException("Unrecognized statement: " + ctx.getText());
        }

        return new StatementExpression(e);
    }

    // TODO
    @Override
    public StubExpression visitNewCall(NewCallContext ctx) {
        return new StubExpression(new RegularType(""));
    }


    // TODO
    @Override
    public StubExpression visitMethodCall(MethodCallContext ctx) {
        return new StubExpression(new RegularType(""));
    }

    @Override
    public AssignmentExpression visitAssignment(AssignmentContext ctx) {
        return expressionFactory().createAssignmentExpression(getAssignmentVar(ctx), getAssignmentValue(ctx));
    }

    private Expression getAssignmentVar(AssignmentContext ctx) {
        if (ctx.thisChain() != null && !ctx.thisChain().isEmpty()) {
            String chain = getChain(ctx.thisChain().get(0));
            String[] split = chain.split("\\.");
            String prefix = "";
            for (int i = 0; i < split.length - 1; i++) {
                prefix += split[i];
            }

            // TODO Use prefix
            return expressionFactory().createNameExpression(split[split.length - 1]);
        } else if (ctx.var() != null) {
            // TODO Create variable
            expressionFactory().createNameExpression(ctx.var().CAMEL_CASE().getText());
            return null;
        } else if (ctx.CAMEL_CASE() != null) {
            return expressionFactory().createNameExpression(ctx.CAMEL_CASE().get(0).getText());
        } else {
            throw new IllegalArgumentException("Nothing to assign to: " + ctx.getText());
        }
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

    // TODO
    private Expression getAssignmentValue(AssignmentContext ctx) {
        return new StubExpression(new RegularType(""));
    }

    @Override
    public ReturnStatement visitReturnCall(ReturnCallContext ctx) {
        System.out.println();
        System.out.println(ctx.getText());
        // TODO
        Expression e = new StubExpression(new RegularType(""));
        return new ReturnStatement(e);
    }
}
