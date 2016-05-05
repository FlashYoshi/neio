package be.ugent.neio.industry;

import be.kuleuven.cs.distrinet.jnome.core.expression.invocation.ConstructorInvocation;
import be.kuleuven.cs.distrinet.jnome.core.expression.invocation.JavaMethodInvocation;
import be.kuleuven.cs.distrinet.jnome.core.type.BasicJavaTypeReference;
import be.kuleuven.cs.distrinet.jnome.input.JavaExpressionFactory;
import be.ugent.neio.expression.NeioMethodInvocation;
import be.ugent.neio.expression.NeioNameExpression;
import org.aikodi.chameleon.core.reference.CrossReferenceTarget;
import org.aikodi.chameleon.oo.expression.Expression;
import org.aikodi.chameleon.oo.expression.NameExpression;
import org.aikodi.chameleon.oo.expression.ParExpression;
import org.aikodi.chameleon.oo.type.TypeReference;
import org.aikodi.chameleon.support.expression.ClassCastExpression;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Titouan Vervack
 */
public class NeioExpressionFactory extends JavaExpressionFactory {

    public Expression createConstructorInvocation(BasicJavaTypeReference type, TypeReference prefix) {
        return createConstructorInvocation(type, prefix, new ArrayList<>());
    }

    public Expression createConstructorInvocation(String type, TypeReference prefix) {
        return createConstructorInvocation(new BasicJavaTypeReference(type), prefix, new ArrayList<>());
    }

    public ConstructorInvocation createConstructorInvocation(String type, TypeReference prefix, List<? extends Expression> arguments) {
        ConstructorInvocation ci = new ConstructorInvocation(new BasicJavaTypeReference(type), prefix);
        ci.addAllArguments(arguments);

        return ci;
    }

    public ConstructorInvocation createConstructorInvocation(BasicJavaTypeReference type, TypeReference prefix, List<? extends Expression> arguments) {
        ConstructorInvocation ci = new ConstructorInvocation(type, prefix);
        ci.addAllArguments(arguments);

        return ci;
    }

    public JavaMethodInvocation createMethodInvocation(boolean contextType, String methodName, CrossReferenceTarget prefix, List<Expression> arguments) {
        if (contextType) {
            return createNeioMethodInvocation(methodName, prefix, arguments);
        } else {
            return createMethodInvocation(methodName, prefix, arguments);
        }
    }

    public JavaMethodInvocation createMethodInvocation(String methodName, CrossReferenceTarget prefix, List<Expression> arguments) {
        JavaMethodInvocation mi = new JavaMethodInvocation(methodName, prefix);
        if (arguments != null) {
            mi.addAllArguments(arguments);
        }

        return mi;
    }

    public NeioMethodInvocation createNeioMethodInvocation(String methodName, CrossReferenceTarget prefix, List<Expression> arguments) {
        NeioMethodInvocation mi = new NeioMethodInvocation(methodName, prefix);
        if (arguments != null) {
            mi.addAllArguments(arguments);
        }

        return mi;
    }

    public ParExpression createParExpression(Expression expression) {
        return new ParExpression(expression);
    }


    public NameExpression createNameExpression(boolean contextTypes, String name) {
        if (contextTypes) {
            return createNeioNameExpression(name);
        } else {
            return createNameExpression(name);
        }
    }

    public NeioNameExpression createNeioNameExpression(String name) {
        return new NeioNameExpression(name);
    }

    public ClassCastExpression createClassCastExpression(TypeReference type, Expression expression) {
        return new ClassCastExpression(type, expression);
    }
}
