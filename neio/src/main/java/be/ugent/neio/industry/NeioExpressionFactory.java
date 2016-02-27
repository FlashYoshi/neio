package be.ugent.neio.industry;

import be.kuleuven.cs.distrinet.jnome.core.expression.invocation.ConstructorInvocation;
import be.kuleuven.cs.distrinet.jnome.core.type.BasicJavaTypeReference;
import be.kuleuven.cs.distrinet.jnome.input.JavaExpressionFactory;
import be.ugent.neio.expression.NeioMethodInvocation;
import be.ugent.neio.expression.NeioNameExpression;
import org.aikodi.chameleon.core.reference.CrossReferenceTarget;
import org.aikodi.chameleon.oo.expression.Expression;
import org.aikodi.chameleon.oo.expression.ParExpression;
import org.aikodi.chameleon.oo.type.TypeReference;

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

    public NeioMethodInvocation createMethodInvocation(String methodName, CrossReferenceTarget prefix, List<Expression> arguments) {
        NeioMethodInvocation mi = new NeioMethodInvocation(methodName, prefix);
        if (arguments != null) {
            mi.addAllArguments(arguments);
        }

        return mi;
    }

    public ParExpression createParExpression(Expression expression) {
        return new ParExpression(expression);
    }

    public NeioNameExpression createNeioNameExpression(String name) {
        return new NeioNameExpression(name);
    }
}
