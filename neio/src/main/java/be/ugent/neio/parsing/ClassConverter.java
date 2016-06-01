package be.ugent.neio.parsing;

import be.kuleuven.cs.distrinet.jnome.core.expression.ClassLiteral;
import be.kuleuven.cs.distrinet.jnome.core.expression.invocation.ConstructorInvocation;
import be.kuleuven.cs.distrinet.jnome.core.expression.invocation.SuperConstructorDelegation;
import be.kuleuven.cs.distrinet.jnome.core.expression.invocation.ThisConstructorDelegation;
import be.kuleuven.cs.distrinet.jnome.core.modifier.Implements;
import be.kuleuven.cs.distrinet.jnome.core.type.BasicJavaTypeReference;
import be.kuleuven.cs.distrinet.jnome.core.type.JavaTypeReference;
import be.kuleuven.cs.distrinet.jnome.workspace.JavaView;
import be.ugent.neio.industry.NeioExpressionFactory;
import be.ugent.neio.industry.NeioFactory;
import be.ugent.neio.language.Neio;
import be.ugent.neio.model.modifier.Nested;
import be.ugent.neio.model.modifier.Surround;
import be.ugent.neio.util.Constants;
import org.aikodi.chameleon.core.document.Document;
import org.aikodi.chameleon.core.lookup.LookupException;
import org.aikodi.chameleon.core.modifier.Modifier;
import org.aikodi.chameleon.core.namespace.NamespaceReference;
import org.aikodi.chameleon.core.namespacedeclaration.Import;
import org.aikodi.chameleon.core.namespacedeclaration.NamespaceDeclaration;
import org.aikodi.chameleon.core.reference.CrossReferenceTarget;
import org.aikodi.chameleon.core.tag.TagImpl;
import org.aikodi.chameleon.exception.ChameleonProgrammerException;
import org.aikodi.chameleon.oo.expression.*;
import org.aikodi.chameleon.oo.method.Method;
import org.aikodi.chameleon.oo.method.MethodHeader;
import org.aikodi.chameleon.oo.plugin.ObjectOrientedFactory;
import org.aikodi.chameleon.oo.statement.Block;
import org.aikodi.chameleon.oo.statement.Statement;
import org.aikodi.chameleon.oo.type.Type;
import org.aikodi.chameleon.oo.type.TypeReference;
import org.aikodi.chameleon.oo.type.generics.FormalTypeParameter;
import org.aikodi.chameleon.oo.type.generics.TypeArgument;
import org.aikodi.chameleon.oo.type.generics.TypeParameter;
import org.aikodi.chameleon.oo.type.inheritance.SubtypeRelation;
import org.aikodi.chameleon.oo.variable.FormalParameter;
import org.aikodi.chameleon.oo.variable.RegularVariable;
import org.aikodi.chameleon.support.expression.AssignmentExpression;
import org.aikodi.chameleon.support.expression.ClassCastExpression;
import org.aikodi.chameleon.support.member.simplename.variable.MemberVariableDeclarator;
import org.aikodi.chameleon.support.modifier.*;
import org.aikodi.chameleon.support.statement.ForControl;
import org.aikodi.chameleon.support.statement.ForStatement;
import org.aikodi.chameleon.support.statement.StatementExprList;
import org.aikodi.chameleon.support.statement.WhileStatement;
import org.aikodi.chameleon.support.variable.LocalVariableDeclarator;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.neio.antlr.ClassParser.*;
import org.neio.antlr.ClassParserBaseVisitor;
import org.neio.antlr.DocumentLexer;
import org.neio.antlr.DocumentParser;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static be.ugent.neio.util.Constants.ASSIGNMENT;

/**
 * @author Titouan Vervack
 */
public class ClassConverter extends ClassParserBaseVisitor<Object> {

    private final Document document;
    private final Neio neio;
    private final JavaView view;
    // Can not use keyword
    private boolean interphase;
    private boolean contextType;
    private boolean isStringMain;

    public ClassConverter(Document document, JavaView view) {
        this.document = document;
        this.neio = view.language(Neio.class);
        this.view = view;
        interphase = false;
        contextType = false;
        isStringMain = true;
    }

    protected NeioFactory ooFactory() {
        return (NeioFactory) neio.plugin(ObjectOrientedFactory.class);
    }

    protected NeioExpressionFactory eFactory() {
        return (NeioExpressionFactory) neio.plugin(ExpressionFactory.class);
    }

    private boolean isInterface() {
        return interphase;
    }

    private void setInterface() {
        interphase = true;
    }

    public Document visitDocument(DocumentContext ctx) {
        NamespaceDeclaration ns = visitNamespace(ctx.namespace());

        for (ImportDeclarationContext importCtx : ctx.importDeclaration()) {
            ns.addImport(visitImportDeclaration(importCtx));
        }

        Type type = visitClassDef(ctx.classDef());

        for (InheritanceContext inheritance : ctx.classDef().inheritance()) {
            type.addInheritanceRelation(visitInheritance(inheritance));
        }

        visitBody(ctx.body(), type);

        ns.add(type);
        document.add(ns);

        return document;
    }

    @Override
    public NamespaceDeclaration visitNamespace(NamespaceContext ctx) {
        if (ctx != null) {
            NamespaceReference namespaceReference = visitNamespaceReference(ctx.namespaceReference());
            return ooFactory().createNamespaceDeclaration(namespaceReference);
        }

        return null;
    }

    @Override
    public NamespaceReference visitNamespaceReference(NamespaceReferenceContext ctx) {
        return ooFactory().createNamespaceReference(ctx.getText());
    }

    @Override
    public Import visitImportDeclaration(ImportDeclarationContext ctx) {
        if (ctx.STAR() != null) {
            return ooFactory().createDemandImport(ctx.type().getText());
        } else {
            return ooFactory().createTypeImport(visitType(ctx.type()));
        }
    }

    @Override
    public Type visitClassDef(ClassDefContext ctx) {
        Type type = ooFactory().createRegularType(ctx.Identifier().getText());
        // Every class is allowed to be public for now
        type.addModifier(new Public());
        if (ctx.ABSTRACT() != null) {
            type.addModifier(new Abstract());
        }

        if (ctx.header().INTERFACE() != null) {
            type.addModifier(new Interface());
            setInterface();
        }

        return type;
    }

    @Override
    public SubtypeRelation visitInheritance(InheritanceContext ctx) {
        SubtypeRelation relation = ooFactory().createSubtypeRelation(visitType(ctx.type()));
        if (ctx.IMPLEMENTS() != null) {
            relation.addModifier(new Implements());
        }

        return relation;
    }

    private void visitBody(BodyContext ctx, Type klass) {
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

        for (MethodExpressionContext method : ctx.methodExpression()) {
            klass.add(visitMethodExpression(method));
        }
    }


    @Override
    public MemberVariableDeclarator visitFieldDecl(FieldDeclContext ctx) {
        MemberVariableDeclarator declarator = ooFactory().createMemberVariableDeclarator(ctx.Identifier().getText(), visitType(ctx.type()));
        for (ModifierContext modifier : ctx.modifier()) {
            declarator.addModifier(visitModifier(modifier));
        }


        if (ctx.modifier().isEmpty() && !isInterface()) {
            declarator.addModifier(new Private());
        }

        return declarator;
    }

    @Override
    public LocalVariableDeclarator visitVariableDeclaration(VariableDeclarationContext ctx) {
        if (ctx.neioNewCall() != null) {
            ConstructorInvocation ci = visitNeioNewCall(ctx.neioNewCall());
            return ooFactory().createLocalVariable(ci.name(), ctx.neioNewCall().Identifier().getText(), ci);
        } else {
            return ooFactory().createLocalVariable(visitType(ctx.type()), ctx.Identifier().getText(), (Expression) visit(ctx.expression()));
        }
    }

    @Override
    public MemberVariableDeclarator visitFieldAssignmentExpression(FieldAssignmentExpressionContext ctx) {
        MemberVariableDeclarator varDecl = visitFieldDecl(ctx.var);
        // visitFieldDecl should have filled in exactly one variable
        try {
            RegularVariable var = (RegularVariable) varDecl.declarations().get(0);
            MemberVariableDeclarator mvd = ooFactory().createMemberVariableDeclarator(var.name(), var.getTypeReference(), (Expression) visit(ctx.val));
            mvd.addModifiers(varDecl.modifiers());

            return mvd;
        } catch (LookupException e) {
            e.printStackTrace();
        }

        return varDecl;
    }

    @Override
    public AssignmentExpression visitAssignmentExpression(AssignmentExpressionContext ctx) {
        return eFactory().createAssignmentExpression((Expression) visit(ctx.var), (Expression) visit(ctx.val));
    }

    @Override
    public Method visitMethod(MethodContext ctx) {
        Method method = visitMethodExpression(ctx.methodExpression());
        method.setImplementation(ooFactory().createImplementation(visitBlock(ctx.block())));

        return method;
    }

    @Override
    public Block visitBlock(BlockContext ctx) {
        if (ctx == null) {
            return null;
        }

        Block block = ooFactory().createBlock();
        for (StatementContext statement : ctx.statement()) {
            if (statement != null) {
                block.addStatement((Statement) visit(statement));
            }
        }

        return block;
    }

    @Override
    public Statement visitAssignmentStatement(AssignmentStatementContext ctx) {
        Statement statement = ooFactory().createStatement(visitAssignmentExpression(ctx.assignmentExpression()));
        statement.setMetadata(new TagImpl(), ASSIGNMENT);
        return statement;
    }

    @Override
    public Statement visitExpressionStatement(ExpressionStatementContext ctx) {
        return ooFactory().createStatement((Expression) visit(ctx.expression()));
    }

    @Override
    public Statement visitReturnStatement(ReturnStatementContext ctx) {
        Expression e = null;
        if (ctx.expression() != null && !ctx.expression().isEmpty()) {
            e = (Expression) visit(ctx.expression());
        }

        return ooFactory().createReturnStatement(e);
    }

    @Override
    public Statement visitVariableDeclarationStatement(VariableDeclarationStatementContext ctx) {
        LocalVariableDeclarator lvd = visitVariableDeclaration(ctx.variableDeclaration());
        lvd.setMetadata(new TagImpl(), ASSIGNMENT);
        return lvd;
    }

    @Override
    public ClassCastExpression visitCastExpression(CastExpressionContext ctx) {
        return eFactory().createClassCastExpression(visitType(ctx.type()), (Expression) visit(ctx.expression()));
    }

    @Override
    public WhileStatement visitWhileLoop(WhileLoopContext ctx) {
        Statement statement = null;
        if (ctx.block() != null && !ctx.block().isEmpty()) {
            statement = visitBlock(ctx.block());
        }

        return ooFactory().createWhileStatement((Expression) visit(ctx.expression()), statement);
    }

    @Override
    public ForStatement visitForLoop(ForLoopContext ctx) {
        LocalVariableDeclarator init = visitVariableDeclaration(ctx.init);

        AssignmentExpression update = visitAssignmentExpression(ctx.update);
        StatementExprList list = new StatementExprList();
        list.addStatement(ooFactory().createStatementExpression(update));

        ForControl control = ooFactory().createForControl(init, (Expression) visit(ctx.cond), list);
        return ooFactory().createForStatement(control, visitBlock(ctx.block()));
    }

    @Override
    public Statement visitIfStatement(IfStatementContext ctx) {
        Statement statement = visitIfteStatement(ctx.ifteStatement());
        statement.setMetadata(new TagImpl(), ASSIGNMENT);
        return statement;
    }

    @Override
    public Statement visitIfteStatement(IfteStatementContext ctx) {
        Expression condition = (Expression) visit(ctx.ifCondition);
        Statement elseStatement = null;
        if (ctx.elseBlock != null) {
            elseStatement = visitBlock(ctx.elseBlock);
        } else if (ctx.elif != null) {
            elseStatement = visitIfteStatement(ctx.elif);
        }

        Block ifBlock = visitBlock(ctx.ifBlock);

        // If statement
        /*if (ctx.elif != null || ifBlock.nbStatements() > 1
                || ifBlock.nearestDescendants(Statement.class).get(0).metadata(ASSIGNMENT) != null
                || (elseStatement != null &&
                (((Block) elseStatement).nbStatements() > 1
                        || elseStatement.nearestDescendants(Statement.class).get(0).metadata(ASSIGNMENT) != null))
                || ifBlock.nearestDescendants(ReturnStatement.class).size() > 0
                || elseStatement == null
                || elseStatement.nearestDescendants(ReturnStatement.class).size() > 0
                || ifBlock.nearestDescendants(RegularMethodInvocation.class).get(0).name().equals("void")) {*/
        return ooFactory().createIfStatement(condition, ifBlock, elseStatement);
        /*} // Ternary operator
        else {
            Expression conditionalExpression = eFactory().createConditionalExpression(condition,
                    ifBlock.nearestDescendants(Expression.class).get(0),
                    elseStatement.nearestDescendants(Expression.class).get(0));
            List<Expression> arguments = new ArrayList<>();
            arguments.add(conditionalExpression);
            return ooFactory().createStatement(eFactory().createMethodInvocation(IFCALL, eFactory().createNameExpression(IFCLASS), arguments));
        }*/
    }

    @Override
    public Expression visitLiteralExpression(LiteralExpressionContext ctx) {
        return (Expression) visit(ctx.literal());
    }

    @Override
    public Expression visitNewExpression(NewExpressionContext ctx) {
        return visitConstructorCall(ctx.constructorCall());
    }

    @Override
    public Object visitNeioNewExpression(NeioNewExpressionContext ctx) {
        return visitNeioNewCall(ctx.neioNewCall());
    }

    @Override
    public ParExpression visitParExpression(ParExpressionContext ctx) {
        return eFactory().createParExpression((Expression) visit(ctx.expression()));
    }

    @Override
    public CrossReferenceTarget visitSuperExpression(SuperExpressionContext ctx) {
        return ooFactory().createSuper();
    }

    @Override
    public SuperConstructorDelegation visitSuperDelegation(SuperDelegationContext ctx) {
        SuperConstructorDelegation delegation = ooFactory().createSuperDelegation();
        List<Expression> arguments = ((List<Expression>) visit(ctx.arguments()));
        delegation.addAllArguments(arguments);

        return delegation;
    }

    @Override
    public Literal visitSelfExpression(SelfExpressionContext ctx) {
        return ooFactory().createThisLiteral();
    }

    @Override
    public ThisConstructorDelegation visitThisDelegation(ThisDelegationContext ctx) {
        ThisConstructorDelegation delegation = ooFactory().createThisDelegation();
        List<Expression> arguments = ((List<Expression>) visit(ctx.arguments()));
        delegation.addAllArguments(arguments);

        return delegation;
    }

    @Override
    public NameExpression visitIdentifierExpression(IdentifierExpressionContext ctx) {
        return eFactory().createNameExpression(contextType, ctx.Identifier().getText());
    }

    @Override
    public NameExpression visitChainExpression(ChainExpressionContext ctx) {
        return eFactory().createNameExpression(ctx.Identifier().getText(), (CrossReferenceTarget) visit(ctx.expression()));
    }

    @Override
    public MethodInvocation visitSelfCallExpression(SelfCallExpressionContext ctx) {
        return eFactory().createMethodInvocation(contextType, ctx.name.getText(), ooFactory().createThisLiteral(), (List<Expression>) visit(ctx.arguments()));
    }

    @Override
    public Expression visitQualifiedCallExpression(QualifiedCallExpressionContext ctx) {
        CrossReferenceTarget target = (CrossReferenceTarget) visit(ctx.expression());
        Expression result;
        if (ctx.args != null) {
            List<Expression> arguments = ((List<Expression>) visit(ctx.args));
            result = eFactory().createMethodInvocation(contextType, ctx.name.getText(), target, arguments);
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
    public Expression visitNotExpression(NotExpressionContext ctx) {
        return eFactory().createPrefixOperatorInvocation(ctx.op.getText(), (Expression) visit(ctx.right));
    }

    @Override
    public Expression visitPostfixCrementExpression(PostfixCrementExpressionContext ctx) {
        return eFactory().createPostfixOperatorInvocation(ctx.op.getText(), (Expression) visit(ctx.left));
    }

    @Override
    public Expression visitPrefixCrementExpression(PrefixCrementExpressionContext ctx) {
        return eFactory().createPrefixOperatorInvocation(ctx.op.getText(), (Expression) visit(ctx.right));
    }

    @Override
    public Object visitPrefixExpression(PrefixExpressionContext ctx) {
        return eFactory().createPrefixOperatorInvocation(ctx.op.getText(), (Expression) visit(ctx.right));
    }

    @Override
    public Expression visitAmpersandExpression(AmpersandExpressionContext ctx) {
        MethodInvocation result = eFactory().createInfixOperatorInvocation(ctx.op.getText(), (Expression) visit(ctx.left));
        result.addArgument((Expression) visit(ctx.right));
        return result;
    }

    @Override
    public Expression visitPipeExpression(PipeExpressionContext ctx) {
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
    public ConstructorInvocation visitConstructorCall(ConstructorCallContext ctx) {
        BasicJavaTypeReference type = (BasicJavaTypeReference) visitType(ctx.type());
        return eFactory().createConstructorInvocation(type, null, (List<Expression>) visit(ctx.arguments()));
    }

    @Override
    public ConstructorInvocation visitNeioNewCall(NeioNewCallContext ctx) {
        BasicJavaTypeReference type = (BasicJavaTypeReference) visitType(ctx.type());
        return eFactory().createConstructorInvocation(type, null, (List<Expression>) visit(ctx.arguments()));
    }

    @Override
    public Method visitMethodExpression(MethodExpressionContext ctx) {
        MethodHeader methodHeader = visitMethodHeader(ctx.methodHeader());
        Method method = ooFactory().createMethod(methodHeader);

        if (methodHeader.name().equals(methodHeader.returnTypeReference().toString())) {
            method.addModifier(new Constructor());
        }

        boolean addPublic = ctx.modifier().isEmpty();
        for (ModifierContext modifier : ctx.modifier()) {
            if (modifier.NESTED() != null && !modifier.NESTED().getText().isEmpty() && ctx.modifier().size() == 1) {
                addPublic = true;
            }

            if (modifier.SURROUND() != null && !modifier.SURROUND().getText().isEmpty()) {
                methodHeader.setName(Constants.SURROUND + methodHeader.name());
            }
            method.addModifier(visitModifier(modifier));
        }

        if (addPublic) {
            method.addModifier(new Public());
        }

        if (ctx.parameters() != null) {
            method.header().addFormalParameters((List<FormalParameter>) visit(ctx.parameters()));
        }

        return method;
    }

    @Override
    public MethodHeader visitMethodHeader(MethodHeaderContext ctx) {
        List<TypeParameter> typeParameters = new ArrayList<>();
        if (ctx.typeParameterList() != null) {
            typeParameters = (List<TypeParameter>) visit(ctx.typeParameterList());
        }

        if (ctx.type() != null) {
            return ooFactory().createMethodHeader(ctx.name.getText(), visitType(ctx.type()), typeParameters);
        } else if (ctx.VOID() != null) {
            return ooFactory().createMethodHeader(ctx.name.getText(), ctx.VOID().getText(), typeParameters);
        } else {
            // Method is a constructor
            return ooFactory().createMethodHeader(ctx.name.getText(), ctx.name.getText(), typeParameters);
        }
    }

    @Override
    public Modifier visitModifier(ModifierContext ctx) {
        if (ctx.ABSTRACT() != null) {
            return new Abstract();
        } else if (ctx.PRIVATE() != null) {
            return new Private();
        } else if (ctx.PROTECTED() != null) {
            return new Protected();
        } else if (ctx.PUBLIC() != null) {
            return new Public();
        } else if (ctx.NESTED() != null) {
            return new Nested();
        } else if (ctx.SURROUND() != null) {
            return new Surround();
        } else if (ctx.FINAL() != null) {
            return new Final();
        } else if (ctx.STATIC() != null) {
            return new Static();
        } else {
            throw new ChameleonProgrammerException("Unknown modifier encountered: " + ctx.getText());
        }
    }

    @Override
    public List<FormalParameter> visitParameters(ParametersContext ctx) {
        return ctx.parameter().stream().map(this::visitParameter).collect(Collectors.toList());
    }

    @Override
    public FormalParameter visitParameter(ParameterContext ctx) {
        return ooFactory().createParameter(ctx.Identifier().getText(), visitType(ctx.type()));
    }

    @Override
    public List<FormalParameter> visitEmptyArguments(EmptyArgumentsContext ctx) {
        return new ArrayList<>();
    }

    @Override
    public List<Expression> visitSomeArguments(SomeArgumentsContext ctx) {
        if (ctx == null) {
            return null;
        }

        return ctx.expression().stream().map(ectx -> (Expression) visit(ectx)).collect(Collectors.toList());
    }

    @Override
    public TypeReference visitType(TypeContext ctx) {
        String name = visitIdentifiers(ctx.identifier());
        TypeReference type;
        List<TypeArgument> typeArguments = new ArrayList<>();
        if (ctx.typeArgumentList() != null) {
            typeArguments = (List<TypeArgument>) visit(ctx.typeArgumentList());
        }
        // The type is an array
        if (ctx.ARRAY() != null) {
            type = ooFactory().createArrayTypeReference(name, typeArguments);
        } else {
            type = ooFactory().createTypeReference(name, typeArguments);
        }

        return type;
    }

    @Override
    public List<TypeParameter> visitTypeParameters(TypeParametersContext ctx) {
        List<TypeParameter> typeParams = new ArrayList<>();

        if (ctx != null) {
            typeParams.addAll((List<TypeParameter>) visit(ctx.typeParameterList()));
            typeParams.add(ooFactory().createTypeParameter(((BasicJavaTypeReference) visitType(ctx.type())).name()));
        }

        return typeParams;
    }

    @Override
    public List<TypeParameter> visitTypeParameter(TypeParameterContext ctx) {
        List<TypeParameter> typeParams = new ArrayList<>();
        typeParams.add(ooFactory().createTypeParameter(((BasicJavaTypeReference) visitType(ctx.type())).name()));

        return typeParams;
    }

    @Override
    public List<FormalTypeParameter> visitBoundedTypeParameter(BoundedTypeParameterContext ctx) {
        List<FormalTypeParameter> list = new ArrayList<>();
        FormalTypeParameter parameter = ooFactory().createFormalTypeParameter(ctx.Identifier().getText());
        parameter.addConstraint(ooFactory().createExtendsConstraint(visitType(ctx.bound)));
        list.add(parameter);

        return list;
    }

    @Override
    public List<TypeArgument> visitTypeArguments(TypeArgumentsContext ctx) {
        List<TypeArgument> typeArguments = new ArrayList<>();

        if (ctx != null) {
            // This means visitTypeArguments and visitTypeArgument both have to return a list
            typeArguments.addAll((List<TypeArgument>) visit(ctx.typeArgumentList()));
            typeArguments.add(ooFactory().createTypeArgument(((BasicJavaTypeReference) visitType(ctx.type())).name()));
        }

        return typeArguments;
    }

    /**
     * Has to return a list, see {@link #visitTypeArguments(TypeArgumentsContext)}
     */
    @Override
    public List<TypeArgument> visitTypeArgument(TypeArgumentContext ctx) {
        List<TypeArgument> arguments = new ArrayList<>();

        arguments.add(ooFactory().createTypeArgument(((BasicJavaTypeReference) visitType(ctx.type())).name()));

        return arguments;
    }

    @Override
    public Object visitBoundedTypeArgument(BoundedTypeArgumentContext ctx) {
        List<TypeArgument> arguments = new ArrayList<>();
        if (ctx.Q_MARK() != null) {
            TypeReference type = visitType(ctx.bound);
            arguments.add(ooFactory().createExtendsWildcard(type));
        }

        return arguments;
    }

    @Override
    public ClassLiteral visitClassLiteral(ClassLiteralContext ctx) {
        return ooFactory().createClassLiteral(ctx.Identifier().getText());
    }

    @Override
    public Expression visitStringLiteral(StringLiteralContext ctx) {
        if (isStringMain) {
            return visitString(ctx.getText());
        } else {
            return visitTextMode(getText(ctx.getText(), "\"".length()), false).nearestDescendants(Expression.class).get(0);
        }
    }

    private Expression visitString(String content) {
        content = content.replaceAll("\\r?\\n", "\\\\n");
        return ooFactory().createStringLiteral(content);
    }

    private Block visitTextMode(String text, boolean append) {
        DocumentConverter converter = new DocumentConverter(document, view);
        text = trimText(text);
        text = text.trim();
        DocumentParser parser = getParser(text);
        converter.setAppend(append);

        return converter.visitBody(parser.body());
    }

    @Override
    public Statement visitTextModeStatement(TextModeStatementContext ctx) {
        return visitTextMode(getText(ctx.getText(), "\"".length()), true);
    }

    @Override
    public Expression visitTextMode(TextModeContext ctx) {
        if (isStringMain) {
            DocumentConverter converter = new DocumentConverter(document, view);
            DocumentParser parser = getParser(getText(ctx.getText(), "'''".length()));

            return converter.visitTxt(parser.txt());
        } else {
            return visitString(getText(ctx.getText(), "'''".length()));
        }
    }

    @Override
    public Literal visitDoubleLiteral(DoubleLiteralContext ctx) {
        return ooFactory().createDoubleLiteral(ctx.getText());
    }

    @Override
    public Literal visitBoolLiteral(BoolLiteralContext ctx) {
        return ooFactory().createBooleanLiteral(ctx.getText());
    }

    @Override
    public Literal visitNullLiteral(NullLiteralContext ctx) {
        return ooFactory().createNullLiteral();
    }

    @Override
    public Literal visitIntLiteral(IntLiteralContext ctx) {
        return ooFactory().createIntegerLiteral(ctx.Integer().getText());
    }

    @Override
    public Literal visitCharLiteral(CharLiteralContext ctx) {
        return ooFactory().createCharLiteral(ctx.CharLiteral().getText());
    }

    private String trimText(String text) {
        String[] lines = text.split("\r\n | [\n\r]");
        StringBuilder builder = new StringBuilder();
        for (String line : lines) {
            builder.append(line.trim()).append("\n");
        }

        return builder.toString();
    }

    private String getText(String textMode, int sepLen) {
        return textMode.substring(sepLen, textMode.length() - sepLen);
    }

    private DocumentParser getParser(String s) {
        InputStream stream = new ByteArrayInputStream(s.getBytes(StandardCharsets.UTF_8));
        ANTLRInputStream input = null;
        try {
            input = new ANTLRInputStream(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Lexer lexer = new DocumentLexer(input);
        TokenStream tokens = new CommonTokenStream(lexer);

        return new DocumentParser(tokens);
    }

    private String visitIdentifiers(List<IdentifierContext> identifiers) {
        if (identifiers == null || identifiers.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder(identifiers.get(0).getText());
        for (int i = 1; i < identifiers.size(); i++) {
            result.append(".").append(identifiers.get(i).getText());
        }

        return result.toString();
    }

    public void enableContextTypes() {
        contextType = true;
    }

    public void flipStringText() {
        isStringMain = false;
    }
}
