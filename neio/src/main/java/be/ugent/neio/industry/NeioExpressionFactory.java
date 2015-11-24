package be.ugent.neio.industry;

import be.kuleuven.cs.distrinet.jnome.core.expression.invocation.ConstructorInvocation;
import be.kuleuven.cs.distrinet.jnome.core.type.BasicJavaTypeReference;
import be.kuleuven.cs.distrinet.jnome.input.JavaExpressionFactory;
import be.ugent.neio.expression.NeioMethodInvocation;
import org.aikodi.chameleon.core.reference.CrossReferenceTarget;
import org.aikodi.chameleon.oo.expression.Expression;
import org.aikodi.chameleon.oo.expression.MethodInvocation;
import org.aikodi.chameleon.oo.type.TypeReference;
import org.aikodi.chameleon.oo.variable.FormalParameter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Titouan Vervack
 */
public class NeioExpressionFactory extends JavaExpressionFactory {

    public Expression createNewExpression(String type) {
        return createNewExpression(type, new ArrayList<>());
    }

    public Expression createNewExpression(String method, List<FormalParameter> parameters) {
        return createNameExpression("new " + createMethodString(null, method, parameters));
    }

    public Expression createConstructor(String type, TypeReference prefix) {
        return createConstructor(type, prefix, new ArrayList<Expression>());
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

    private String createMethodString(String caller, String method, List<FormalParameter> parameters) {
        String result = "";
        for (FormalParameter f : parameters) {
            if (!result.isEmpty()) {
                result += ", ";
            }

            boolean string = f.getTypeReference().toString().equals("String");

            result += (string ? "\"" : "") + f.name() + (string ? "\"" : "");
        }

        result = method + "(" + result + ")";
        if (caller != null && !caller.isEmpty()) {
            result = caller + "." + result;
        }

        return result;
    }
}
