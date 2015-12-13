package be.ugent.neio.parsing;

import be.kuleuven.cs.distrinet.jnome.core.expression.invocation.ConstructorInvocation;
import be.kuleuven.cs.distrinet.jnome.core.modifier.Implements;
import be.kuleuven.cs.distrinet.jnome.core.type.BasicJavaTypeReference;
import be.kuleuven.cs.distrinet.jnome.workspace.JavaView;
import be.ugent.neio.industry.NeioExpressionFactory;
import be.ugent.neio.industry.NeioFactory;
import be.ugent.neio.language.Neio;
import be.ugent.neio.model.modifier.Nested;
import org.aikodi.chameleon.core.document.Document;
import org.aikodi.chameleon.core.factory.Factory;
import org.aikodi.chameleon.core.lookup.LookupException;
import org.aikodi.chameleon.core.modifier.Modifier;
import org.aikodi.chameleon.core.namespace.NamespaceReference;
import org.aikodi.chameleon.core.namespacedeclaration.NamespaceDeclaration;
import org.aikodi.chameleon.exception.ChameleonProgrammerException;
import org.aikodi.chameleon.oo.expression.*;
import org.aikodi.chameleon.oo.method.Method;
import org.aikodi.chameleon.oo.method.MethodHeader;
import org.aikodi.chameleon.oo.plugin.ObjectOrientedFactory;
import org.aikodi.chameleon.oo.statement.Block;
import org.aikodi.chameleon.oo.statement.Statement;
import org.aikodi.chameleon.oo.type.Type;
import org.aikodi.chameleon.oo.type.TypeReference;
import org.aikodi.chameleon.oo.type.generics.TypeArgument;
import org.aikodi.chameleon.oo.type.inheritance.SubtypeRelation;
import org.aikodi.chameleon.oo.variable.FormalParameter;
import org.aikodi.chameleon.oo.variable.VariableDeclaration;
import org.aikodi.chameleon.support.expression.AssignmentExpression;
import org.aikodi.chameleon.support.member.simplename.variable.MemberVariableDeclarator;
import org.aikodi.chameleon.support.modifier.*;
import org.aikodi.chameleon.support.statement.ForControl;
import org.aikodi.chameleon.support.statement.ForStatement;
import org.aikodi.chameleon.support.statement.StatementExprList;
import org.aikodi.chameleon.support.variable.LocalVariableDeclarator;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.TerminalNode;
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
        String header = ctx.classDef().HEADER().getText();
        String klassName = ctx.classDef().Identifier().getText();
        visitDocument(ctx, klassName, header);
    }

    private void visitDocument(DocumentContext ctx, String klassName, String header) {
        NamespaceDeclaration ns = visitNamespace(ctx.namespace());

        Type klass = ooFactory().createRegularType(klassName);
        // Every class is allowed to be public for now
        klass.addModifier(new Public());


        for (InheritanceContext inheritance : ctx.classDef().inheritance()) {
            klass.addInheritanceRelation(visitInheritance(inheritance));
        }

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

    @Override
    public NamespaceDeclaration visitNamespace(@NotNull NamespaceContext ctx) {
        if (ctx != null) {
            NamespaceReference namespaceReference = visitNamespaceReference(ctx.namespaceReference());
            return ooFactory().createNamespaceDeclaration(namespaceReference);
        }

        return null;
    }

    @Override
    public NamespaceReference visitNamespaceReference(@NotNull NamespaceReferenceContext ctx) {
        return ooFactory().createNamespaceReference(ctx.getText());
    }

    @Override
    public SubtypeRelation visitInheritance(@NotNull InheritanceContext ctx) {
        SubtypeRelation relation = ooFactory().createSubtypeRelation(visitType(ctx.type()));
        if (ctx.IMPLEMENTS() != null) {
            relation.addModifier(new Implements());
        }

        return relation;
    }

    private void visitClass(ClassBodyContext ctx, Type klass) {
        if (ctx == null) {
            return;
        }
        for (FieldDeclContext decl : ctx.fieldDecl()) {
            klass.add(visitFieldDecl(decl));
        }

        for (FieldAssignmentExpressionContext assignment : ctx.fieldAssignmentExpression()) {
            klass.add(visitFieldAssignmentExpression(assignment));
        }

        for (MethodContext method : ctx.method()) {
            klass.add(visitMethod(method));
        }
    }

    private void visitInterface(InterfaceBodyContext ctx, Type klass) {
        klass.addModifier(new Interface());
        if (ctx != null) {
            for (MethodExpressionContext methodExpr : ctx.methodExpression()) {
                Method method = visitMethodExpression(methodExpr);
                klass.add(method);
            }
        }
    }

    @Override
    public MemberVariableDeclarator visitFieldDecl(@NotNull FieldDeclContext ctx) {
        MemberVariableDeclarator declarator = ooFactory().createMemberVariableDeclarator(ctx.Identifier().getText(), visitType(ctx.type()));
        if (ctx.modifier() != null) {
            declarator.addModifier(visitModifier(ctx.modifier()));
        } else {
            declarator.addModifier(new Private());
        }

        return declarator;
    }

    @Override
    public VariableReference visitDecl(@NotNull DeclContext ctx) {
        // FIXME: do this correctly
        return eFactory().createVariableReference(" ", ooFactory().createTypeReference(visitType(ctx.type()).toString() + " " + ctx.Identifier().getText()));
    }

    @Override
    public MemberVariableDeclarator visitFieldAssignmentExpression(@NotNull FieldAssignmentExpressionContext ctx) {
        MemberVariableDeclarator var = visitFieldDecl(ctx.var);
        // visitFieldDecl should have filled in exactly one variable
        try {
            ((VariableDeclaration) var.declarations().get(0)).setInitialization((Expression) visit(ctx.val));
        } catch (LookupException e) {
            e.printStackTrace();
        }

        return var;
    }

    @Override
    public AssignmentExpression visitAssignmentExpression(@NotNull AssignmentExpressionContext ctx) {
        return eFactory().createAssignmentExpression((Expression) visit(ctx.var), (Expression) visit(ctx.val));
    }

    @Override
    public Method visitMethod(@NotNull MethodContext ctx) {
        Method method = visitMethodExpression(ctx.methodExpression());
        method.setImplementation(ooFactory().createImplementation(visitBlock(ctx.block())));

        return method;
    }

    @Override
    public Block visitBlock(@NotNull BlockContext ctx) {
        if (ctx == null) {
            return null;
        }

        Block block = ooFactory().createBlock();
        for (StatementContext statement : ctx.statement()) {
            block.addStatement((Statement) visit(statement));
        }

        return block;
    }

    @Override
    public Object visitAssignmentStatement(@NotNull AssignmentStatementContext ctx) {
        return ooFactory().createStatement(visitAssignmentExpression(ctx.assignmentExpression()));
    }

    @Override
    public Statement visitExpressionStatement(@NotNull ExpressionStatementContext ctx) {
        return ooFactory().createStatement((Expression) visit(ctx.expression()));
    }

    @Override
    public Statement visitReturnStatement(@NotNull ReturnStatementContext ctx) {
        return ooFactory().createReturnStatement((Expression) visit(ctx.expression()));
    }

    @Override
    public ForStatement visitForLoop(@NotNull ForLoopContext ctx) {
        AssignmentExpression init = visitAssignmentExpression(ctx.init);
        // Get the variable values out manually as lookup will not work yet at this point
        VariableReference var = (VariableReference) init.variableExpression();
        LocalVariableDeclarator declarator = ooFactory().createLocalVariable((TypeReference) var.getTarget(),
                var.name(),
                init.getValue());

        AssignmentExpression update = visitAssignmentExpression(ctx.update);
        StatementExprList list = new StatementExprList();
        list.addStatement(ooFactory().createStatementExpression(update));

        ForControl control = ooFactory().createForControl(declarator, (Expression) visit(ctx.cond), list);
        return ooFactory().createForStatement(control, visitBlock(ctx.block()));
    }

    @Override
    public Expression visitDeclExpression(@NotNull DeclExpressionContext ctx) {
        return visitDecl(ctx.decl());
    }

    @Override
    public Expression visitLiteralExpression(@NotNull LiteralExpressionContext ctx) {
        return (Literal) visit(ctx.literal());
    }

    @Override
    public Object visitNewStatement(@NotNull NewStatementContext ctx) {
        return visit(ctx.neioNewCall());
    }

    @Override
    public ParExpression visitParExpression(@NotNull ParExpressionContext ctx) {
        return eFactory().createParExpression((Expression) visit(ctx.expression()));
    }

    @Override
    public Literal visitSuperExpression(@NotNull SuperExpressionContext ctx) {
        return ooFactory().createSuperLiteral();
    }

    @Override
    public Literal visitSelfExpression(@NotNull SelfExpressionContext ctx) {
        return ooFactory().createThisLiteral();
    }

    @Override
    public NameExpression visitIdentifierExpression(@NotNull IdentifierExpressionContext ctx) {
        return eFactory().createNameExpression(ctx.Identifier().getText());
    }

    @Override
    public NameExpression visitChainExpression(@NotNull ChainExpressionContext ctx) {
        return eFactory().createNameExpression(ctx.Identifier().getText(), (Expression) visit(ctx.expression()));
    }

    @Override
    public MethodInvocation visitSelfCallExpression(@NotNull SelfCallExpressionContext ctx) {
        return eFactory().createMethodInvocation(ctx.name.getText(), null, (List<Expression>) visit(ctx.arguments()));
    }

    @Override
    public Object visitQualifiedCallExpression(@NotNull QualifiedCallExpressionContext ctx) {
        Expression target = (Expression) visit(ctx.expression());
        Expression result;
        if (ctx.args != null) {
            result = eFactory().createInvocation(ctx.name.getText(), target);
            ((List<Expression>) visit(ctx.args)).forEach(((MethodInvocation) result)::addArgument);
        } else {
            result = new NameExpression(ctx.name.getText(), target);
        }

        return result;
    }

    @Override
    public Expression visitExponentiationExpression(ExponentiationExpressionContext ctx) {
        MethodInvocation result = eFactory().createInfixOperatorInvocation(ctx.op.getText(), (Expression) visit(ctx.left));
        result.addArgument((Expression) visit(ctx.right));
        return result;
    }

    @Override
    public Expression visitHighPriorityNumbericalExpression(HighPriorityNumbericalExpressionContext ctx) {
        MethodInvocation result = eFactory().createInfixOperatorInvocation(ctx.op.getText(), (Expression) visit(ctx.left));
        result.addArgument((Expression) visit(ctx.right));
        return result;
    }

    @Override
    public Expression visitLowPriorityNumbericalExpression(LowPriorityNumbericalExpressionContext ctx) {
        MethodInvocation result = eFactory().createInfixOperatorInvocation(ctx.op.getText(), (Expression) visit(ctx.left));
        result.addArgument((Expression) visit(ctx.right));
        return result;
    }

    @Override
    public Expression visitShiftExpression(ShiftExpressionContext ctx) {
        MethodInvocation result = eFactory().createInfixOperatorInvocation(ctx.op.getText(), (Expression) visit(ctx.left));
        result.addArgument((Expression) visit(ctx.right));
        return result;
    }

    @Override
    public Expression visitOrderExpression(OrderExpressionContext ctx) {
        MethodInvocation result = eFactory().createInfixOperatorInvocation(ctx.op.getText(), (Expression) visit(ctx.left));
        result.addArgument((Expression) visit(ctx.right));
        return result;
    }

    @Override
    public Expression visitEqualityExpression(EqualityExpressionContext ctx) {
        MethodInvocation result = eFactory().createInfixOperatorInvocation(ctx.op.getText(), (Expression) visit(ctx.left));
        result.addArgument((Expression) visit(ctx.right));
        return result;
    }

    @Override
    public Object visitAmpersandExpression(@NotNull AmpersandExpressionContext ctx) {
        MethodInvocation result = eFactory().createInfixOperatorInvocation(ctx.op.getText(), (Expression) visit(ctx.left));
        result.addArgument((Expression) visit(ctx.right));
        return result;
    }

    @Override
    public Object visitPipeExpression(@NotNull PipeExpressionContext ctx) {
        MethodInvocation result = eFactory().createInfixOperatorInvocation(ctx.op.getText(), (Expression) visit(ctx.left));
        result.addArgument((Expression) visit(ctx.right));
        return result;
    }

    @Override
    public Expression visitAndExpression(AndExpressionContext ctx) {
        MethodInvocation result = eFactory().createInfixOperatorInvocation(ctx.op.getText(), (Expression) visit(ctx.left));
        result.addArgument((Expression) visit(ctx.right));
        return result;
    }

    @Override
    public Expression visitOrExpression(OrExpressionContext ctx) {
        MethodInvocation result = eFactory().createInfixOperatorInvocation(ctx.op.getText(), (Expression) visit(ctx.left));
        result.addArgument((Expression) visit(ctx.right));
        return result;
    }

    @Override
    public ConstructorInvocation visitConstructorCall(@NotNull ConstructorCallContext ctx) {
        return eFactory().createConstructorInvocation(visitType(ctx.type()).toString(), null, (List<Expression>) visit(ctx.arguments()));
    }

    @Override
    public LocalVariableDeclarator visitNeioNewCall(@NotNull NeioNewCallContext ctx) {
        Expression e = eFactory().createConstructorInvocation(visitType(ctx.type()).toString(), null, (List<Expression>) visit(ctx.arguments()));
        return ooFactory().createLocalVariable(visitType(ctx.type()).toString(), ctx.Identifier().getText(), e);
    }

    @Override
    public Method visitMethodExpression(@NotNull MethodExpressionContext ctx) {
        MethodHeader methodHeader = visitMethodHeader(ctx.methodHeader());
        Method method = ooFactory().createMethod(methodHeader);
        // All methods can be public for now
        method.addModifier(new Public());
        if (methodHeader.name().equals(methodHeader.returnTypeReference().toString())) {
            method.addModifier(new Constructor());
        }

        for (ModifierContext modifier : ctx.modifier()) {
            method.addModifier(visitModifier(modifier));
        }

        if (ctx.parameters() != null) {
            method.header().addFormalParameters((List<FormalParameter>) visit(ctx.parameters()));
        }

        return method;
    }

    @Override
    public MethodHeader visitMethodHeader(@NotNull MethodHeaderContext ctx) {
        String returnType;
        if (ctx.returnType != null) {
            returnType = ctx.returnType.getText();
        }
        // Method is a constructor
        else {
            returnType = ctx.name.getText();
        }

        return ooFactory().createMethodHeader(ctx.name.getText(), returnType);
    }

    @Override
    public Modifier visitModifier(@NotNull ModifierContext ctx) {
        if (ctx.PROTECTED() != null) {
            return new Protected();
        } else if (ctx.PUBLIC() != null) {
            return new Public();
        } else if (ctx.NESTED() != null) {
            return new Nested();
        } else {
            throw new ChameleonProgrammerException("Unknown modifier encountered: " + ctx.getText());
        }
    }

    @Override
    public List<FormalParameter> visitParameters(@NotNull ParametersContext ctx) {
        return ctx.parameter().stream().map(this::visitParameter).collect(Collectors.toList());
    }

    @Override
    public FormalParameter visitParameter(@NotNull ParameterContext ctx) {
        return ooFactory().createParameter(ctx.Identifier().getText(), visitType(ctx.type()));
    }

    @Override
    public List<FormalParameter> visitEmptyArguments(@NotNull EmptyArgumentsContext ctx) {
        return new ArrayList<>();
    }

    @Override
    public List<Expression> visitSomeArguments(@NotNull SomeArgumentsContext ctx) {
        if (ctx == null) {
            return null;
        }

        return ctx.expression().stream().map(ectx -> (Expression) visit(ectx)).collect(Collectors.toList());
    }

    @Override
    public TypeReference visitType(@NotNull TypeContext ctx) {
        if (ctx.typeArgumentList() != null) {
            List<TypeArgument> typeArguments = (List<TypeArgument>) visit(ctx.typeArgumentList());

            BasicJavaTypeReference type = ooFactory().createBasicJavaTypeReference(visitIdentifiers(ctx.Identifier()));
            type.addAllArguments(typeArguments);
            return type;
        } else {
            return ooFactory().createTypeReference(visitIdentifiers(ctx.Identifier()));
        }
    }

    @Override
    public List<TypeArgument> visitTypeArguments(@NotNull TypeArgumentsContext ctx) {
        List<TypeArgument> typeArguments = new ArrayList<>();

        if (ctx != null) {
            // This means visitTypeArguments and visitTypeArgument both have to return a list
            typeArguments.addAll((List<TypeArgument>) visit(ctx.typeArgumentList()));
            typeArguments.add(ooFactory().createTypeArgument(ctx.Identifier().getText()));
        }

        return typeArguments;
    }

    /**
     * Has to return a list, see {@link #visitTypeArguments(TypeArgumentsContext)}
     */
    @Override
    public List<TypeArgument> visitTypeArgument(@NotNull TypeArgumentContext ctx) {
        List<TypeArgument> arguments = new ArrayList<>();
        arguments.add(ooFactory().createTypeArgument(ctx.Identifier().getText()));

        return arguments;
    }

    @Override
    public Literal visitStringLiteral(@NotNull StringLiteralContext ctx) {
        return ooFactory().createStringLiteral(ctx.getText());
    }

    @Override
    public Literal visitDoubleLiteral(@NotNull DoubleLiteralContext ctx) {
        return ooFactory().createDoubleLiteral(ctx.getText());
    }

    @Override
    public Literal visitBoolLiteral(@NotNull BoolLiteralContext ctx) {
        return ooFactory().createBooleanLiteral(ctx.TRUE() != null ? ctx.TRUE().getText() : ctx.FALSE().getText());
    }

    @Override
    public Literal visitNullLiteral(@NotNull NullLiteralContext ctx) {
        return ooFactory().createNullLiteral();
    }

    @Override
    public Literal visitIntLiteral(@NotNull IntLiteralContext ctx) {
        return ooFactory().createIntegerLiteral(ctx.Integer().getText());
    }

    @Override
    public Literal visitCharLiteral(@NotNull CharLiteralContext ctx) {
        return ooFactory().createCharLiteral(ctx.CharLiteral().getText());
    }

    private String visitIdentifiers(List<TerminalNode> identifiers) {
        String result = "";
        if (identifiers != null && identifiers.size() > 0) {
            result = identifiers.get(0).getText();
        } else {
            return result;
        }

        for (int i = 1; i < identifiers.size(); i++) {
            result += "." + identifiers.get(i);
        }

        return result;
    }
}
