package be.ugent.neio.industry;

import be.kuleuven.cs.distrinet.jnome.core.method.JavaMethod;
import be.kuleuven.cs.distrinet.jnome.core.type.BasicJavaTypeReference;
import be.kuleuven.cs.distrinet.jnome.core.type.GenericTypeReference;
import be.kuleuven.cs.distrinet.jnome.core.type.RegularJavaType;
import be.kuleuven.cs.distrinet.jnome.input.Java7Factory;
import org.aikodi.chameleon.core.namespace.Namespace;
import org.aikodi.chameleon.core.namespace.NamespaceReference;
import org.aikodi.chameleon.core.namespacedeclaration.DemandImport;
import org.aikodi.chameleon.core.namespacedeclaration.Import;
import org.aikodi.chameleon.oo.expression.Expression;
import org.aikodi.chameleon.oo.expression.Literal;
import org.aikodi.chameleon.oo.method.Implementation;
import org.aikodi.chameleon.oo.method.Method;
import org.aikodi.chameleon.oo.method.RegularImplementation;
import org.aikodi.chameleon.oo.method.SimpleNameMethodHeader;
import org.aikodi.chameleon.oo.statement.Block;
import org.aikodi.chameleon.oo.statement.Statement;
import org.aikodi.chameleon.oo.type.BasicTypeReference;
import org.aikodi.chameleon.oo.type.RegularType;
import org.aikodi.chameleon.oo.type.TypeReference;
import org.aikodi.chameleon.oo.type.generics.EqualityTypeArgument;
import org.aikodi.chameleon.oo.type.generics.TypeArgument;
import org.aikodi.chameleon.oo.type.inheritance.SubtypeRelation;
import org.aikodi.chameleon.oo.variable.VariableDeclaration;
import org.aikodi.chameleon.support.expression.RegularLiteral;
import org.aikodi.chameleon.support.member.simplename.variable.MemberVariableDeclarator;
import org.aikodi.chameleon.support.statement.ReturnStatement;
import org.aikodi.chameleon.support.statement.StatementExpression;
import org.aikodi.chameleon.support.variable.LocalVariableDeclarator;

import java.util.List;

public class NeioFactory extends Java7Factory {

    public NeioFactory() {

    }

    @Override
    public RegularType createRegularType(String name) {
        return new RegularJavaType(name);
    }

    public TypeReference createTypeReference(String name) {
        return new BasicTypeReference(name);
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
        MemberVariableDeclarator m = new MemberVariableDeclarator(type);
        m.add(new VariableDeclaration(name));

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

    public Method createMethod(String methodName, String returnType) {
        return new JavaMethod(new SimpleNameMethodHeader(methodName, createTypeReference(returnType)));
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

    public Literal createStringLiteral(String value) {
        return createLiteral(createTypeReference("java.lang.String"), value);
    }

    public Literal createIntegerLiteral(String value) {
        return createLiteral(createTypeReference("java.lang.Integer"), value);
    }

    public Literal createLiteral(TypeReference type, String value) {
        return new RegularLiteral(type, value);
    }

    public TypeArgument createTypeArgument(String type) {
        return createTypeArgument(createTypeReference(type));
    }

    public TypeArgument createTypeArgument(TypeReference type) {
        // TODO: Is this correct?
        return new EqualityTypeArgument(type);
    }

    public GenericTypeReference createGenericTypeReference(String target, List<TypeArgument> typeArguments) {
        return new GenericTypeReference(createBasicJavaTypeReference(target), typeArguments);
    }

    private BasicJavaTypeReference createBasicJavaTypeReference(String fqn) {
        return new BasicJavaTypeReference(fqn);
    }
}
