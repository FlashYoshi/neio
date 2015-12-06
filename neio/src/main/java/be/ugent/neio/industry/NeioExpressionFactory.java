package be.ugent.neio.industry;

import be.kuleuven.cs.distrinet.jnome.core.expression.invocation.ConstructorInvocation;
import be.kuleuven.cs.distrinet.jnome.core.type.BasicJavaTypeReference;
import be.kuleuven.cs.distrinet.jnome.input.JavaExpressionFactory;
import be.ugent.neio.expression.NeioMethodInvocation;
import org.aikodi.chameleon.core.reference.CrossReferenceTarget;
import org.aikodi.chameleon.oo.expression.Expression;
import org.aikodi.chameleon.oo.expression.MethodInvocation;
import org.aikodi.chameleon.oo.expression.NameExpression;
import org.aikodi.chameleon.oo.type.TypeReference;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Titouan Vervack
 */
public class NeioExpressionFactory extends JavaExpressionFactory {

    public Expression createConstructor(String type, TypeReference prefix) {
        return createConstructor(type, prefix, new ArrayList<>());
    }

    public Expression createConstructor(String type, TypeReference prefix, List<? extends Expression> arguments) {
        ConstructorInvocation ci = new ConstructorInvocation(new BasicJavaTypeReference(type), prefix);
        ci.addAllArguments(arguments);

        return ci;
    }

    public Expression createMethodInvocation(String methodName, CrossReferenceTarget prefix, List<Expression> arguments) {
        MethodInvocation mi = new NeioMethodInvocation(methodName, prefix);
        mi.addAllArguments(arguments);

        return mi;
    }
}
