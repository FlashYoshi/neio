package be.ugent.neio.industry;

import be.kuleuven.cs.distrinet.jnome.core.expression.ClassLiteral;
import be.kuleuven.cs.distrinet.jnome.core.expression.invocation.SuperConstructorDelegation;
import be.kuleuven.cs.distrinet.jnome.core.expression.invocation.ThisConstructorDelegation;
import be.kuleuven.cs.distrinet.jnome.core.method.JavaMethod;
import be.kuleuven.cs.distrinet.jnome.core.type.ArrayTypeReference;
import be.kuleuven.cs.distrinet.jnome.core.type.BasicJavaTypeReference;
import be.kuleuven.cs.distrinet.jnome.core.type.RegularJavaType;
import be.kuleuven.cs.distrinet.jnome.input.Java7Factory;
import org.aikodi.chameleon.core.namespace.Namespace;
import org.aikodi.chameleon.core.namespace.NamespaceReference;
import org.aikodi.chameleon.core.namespacedeclaration.DemandImport;
import org.aikodi.chameleon.core.namespacedeclaration.Import;
import org.aikodi.chameleon.oo.expression.Expression;
import org.aikodi.chameleon.oo.expression.Literal;
import org.aikodi.chameleon.oo.method.*;
import org.aikodi.chameleon.oo.namespacedeclaration.TypeImport;
import org.aikodi.chameleon.oo.statement.Block;
import org.aikodi.chameleon.oo.statement.Statement;
import org.aikodi.chameleon.oo.type.RegularType;
import org.aikodi.chameleon.oo.type.TypeReference;
import org.aikodi.chameleon.oo.type.generics.*;
import org.aikodi.chameleon.oo.type.inheritance.SubtypeRelation;
import org.aikodi.chameleon.oo.variable.FormalParameter;
import org.aikodi.chameleon.oo.variable.VariableDeclaration;
import org.aikodi.chameleon.support.expression.NullLiteral;
import org.aikodi.chameleon.support.expression.RegularLiteral;
import org.aikodi.chameleon.support.expression.SuperTarget;
import org.aikodi.chameleon.support.expression.ThisLiteral;
import org.aikodi.chameleon.support.member.simplename.variable.MemberVariableDeclarator;
import org.aikodi.chameleon.support.statement.*;
import org.aikodi.chameleon.support.variable.LocalVariableDeclarator;

import java.util.List;

public class NeioFactory extends Java7Factory {

    public NeioFactory() {

    }

    @Override
    public RegularType createRegularType(String name) {
        return new RegularJavaType(name);
    }

    public BasicJavaTypeReference createTypeReference(String name) {
        return new BasicJavaTypeReference(name);
    }

    public ArrayTypeReference createArrayTypeReference(String name) {
        return new ArrayTypeReference(createTypeReference(name));
    }

    public Import createDemandImport(String fqn) {
        return new DemandImport(createNameReference(fqn, Namespace.class));
    }

    public NamespaceReference createNamespaceReference(String qn) {
        return new NamespaceReference(qn);
    }

    public SubtypeRelation createSubtypeRelation(TypeReference type) {
        return new SubtypeRelation(type);
    }

    public MemberVariableDeclarator createMemberVariableDeclarator(String name, TypeReference type) {
        return createMemberVariableDeclarator(name, type, null);
    }

    public MemberVariableDeclarator createMemberVariableDeclarator(String name, TypeReference type, Expression expression) {
        MemberVariableDeclarator m = new MemberVariableDeclarator(type);
        m.add(new VariableDeclaration(name, expression));

        return m;
    }

    public LocalVariableDeclarator createLocalVariable(String type, String name, Expression e) {
        return createLocalVariable(createTypeReference(type), name, e);
    }

    public LocalVariableDeclarator createLocalVariable(TypeReference type, String name, Expression e) {
        LocalVariableDeclarator declarator = new LocalVariableDeclarator(type);
        declarator.add(new VariableDeclaration(name, e));

        return declarator;
    }

    public JavaMethod createMethod(String methodName, String returnType) {
        return new JavaMethod(new SimpleNameMethodHeader(methodName, createTypeReference(returnType)));
    }

    public Method createMethod(MethodHeader methodHeader) {
        return new JavaMethod(methodHeader);
    }

    public Implementation createImplementation(Block b) {
        return new RegularImplementation(b);
    }

    public Statement createStatement(Expression e) {
        return new StatementExpression(e);
    }

    public ReturnStatement createReturnStatement(Expression e) {
        return new ReturnStatement(e);
    }

    public Block createBlock() {
        return new Block();
    }

    public ClassLiteral createClassLiteral(String identifier) {
        return new ClassLiteral(createTypeReference(identifier));
    }

    public Literal createDoubleLiteral(String value) {
        return createLiteral(createTypeReference("java.lang.Double"), value);
    }

    public Literal createCharLiteral(String value) {
        return createLiteral(createTypeReference("java.lang.Character"), value);
    }

    public Literal createBooleanLiteral(String value) {
        return createLiteral(createTypeReference("java.lang.Boolean"), value);
    }

    public Literal createNullLiteral() {
        return new NullLiteral();
    }

    public Literal createStringLiteral(String value) {
        return createLiteral(createTypeReference("java.lang.String"), value);
    }

    public Literal createIntegerLiteral(String value) {
        return createLiteral(createTypeReference("java.lang.Integer"), value);
    }

    public Literal createThisLiteral() {
        return new ThisLiteral();
    }

    public Literal createLiteral(TypeReference type, String value) {
        return new RegularLiteral(type, value);
    }

    public TypeArgument createTypeArgument(String type) {
        return createTypeArgument(createTypeReference(type));
    }

    public TypeArgument createTypeArgument(TypeReference type) {
        return new EqualityTypeArgument(type);
    }

    public SimpleNameMethodHeader createMethodHeader(String name, String type) {
        return new SimpleNameMethodHeader(name, createTypeReference(type));
    }

    public SimpleNameMethodHeader createMethodHeader(String name, String type, List<TypeParameter> typeArguments) {
        SimpleNameMethodHeader header = createMethodHeader(name, type);
        header.addAllTypeParameters(typeArguments);

        return header;
    }

    public FormalParameter createParameter(String name, TypeReference type) {
        return new FormalParameter(name, type);
    }

    public ForControl createForControl(ForInit init, Expression condition, StatementExprList update) {
        return new SimpleForControl(init, condition, update);
    }

    public ForStatement createForStatement(ForControl control, Statement statement) {
        return new ForStatement(control, statement);
    }

    public StatementExpression createStatementExpression(Expression expression) {
        return new StatementExpression(expression);
    }

    public SuperTarget createSuper() {
        return new SuperTarget();
    }

    public Import createTypeImport(TypeReference typeReference) {
        return new TypeImport(typeReference);
    }

    public IfThenElseStatement createIfStatement(Expression expression, Statement ifStatement, Statement elseStatement) {
        return new IfThenElseStatement(expression, ifStatement, elseStatement);
    }

    public SuperConstructorDelegation createSuperDelegation() {
        return new SuperConstructorDelegation();
    }

    public ThisConstructorDelegation createThisDelegation() {
        return new ThisConstructorDelegation();
    }

    public WhileStatement createWhileStatement(Expression expression, Statement statement) {
        return new WhileStatement(expression, statement);
    }

    public TypeParameter createTypeParameter(String name) {
        return new FormalTypeParameter(name);
    }

    public ExtendsWildcard createExtendsWildcard(String type) {
        return new ExtendsWildcard(createTypeReference(type));
    }
}
