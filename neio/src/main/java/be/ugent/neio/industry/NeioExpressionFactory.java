package be.ugent.neio.industry;

import be.kuleuven.cs.distrinet.jnome.core.expression.invocation.ConstructorInvocation;
import be.kuleuven.cs.distrinet.jnome.core.type.BasicJavaTypeReference;
import be.kuleuven.cs.distrinet.jnome.input.JavaExpressionFactory;
import be.ugent.neio.expression.NeioMethodInvocation;
import org.aikodi.chameleon.core.reference.CrossReferenceTarget;
import org.aikodi.chameleon.oo.expression.Expression;
import org.aikodi.chameleon.oo.expression.MethodInvocation;
import org.aikodi.chameleon.oo.expression.ParExpression;
import org.aikodi.chameleon.oo.expression.VariableReference;
import org.aikodi.chameleon.oo.type.TypeReference;
import org.aikodi.chameleon.support.expression.SuperTarget;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Titouan Vervack
 */
public class NeioExpressionFactory extends JavaExpressionFactory {

    public Expression createConstructorInvocation(String type, TypeReference prefix) {
        return createConstructorInvocation(type, prefix, new ArrayList<>());
    }

    public ConstructorInvocation createConstructorInvocation(String type, TypeReference prefix, List<? extends Expression> arguments) {
        ConstructorInvocation ci = new ConstructorInvocation(new BasicJavaTypeReference(type), prefix);
        ci.addAllArguments(arguments);

        return ci;
    }

    public MethodInvocation createMethodInvocation(String methodName, CrossReferenceTarget prefix, List<Expression> arguments) {
        MethodInvocation mi = new NeioMethodInvocation(methodName, prefix);
        mi.addAllArguments(arguments);

        return mi;
    }

    public VariableReference createVariableReference(String name, TypeReference type) {
        return new VariableReference(name, type);
    }

    public ParExpression createParExpression(Expression expression) {
        return new ParExpression(expression);
    }

    public SuperTarget createSuper() {
        return new SuperTarget();
    }
}
