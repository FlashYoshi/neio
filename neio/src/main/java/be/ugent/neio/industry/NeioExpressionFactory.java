package be.ugent.neio.industry;

import be.kuleuven.cs.distrinet.jnome.input.JavaExpressionFactory;
import org.aikodi.chameleon.oo.expression.Expression;
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

        return createNameExpression("new " + createMethodString(method, parameters));
    }

    public Expression createMethodCall(String method) {
        return createMethodCall(method, new ArrayList<>());
    }

    public Expression createMethodCall(String method, List<FormalParameter>parameters) {
        return createNameExpression(createMethodString(method, parameters));
    }

    private String createMethodString(String method, List<FormalParameter> parameters) {
        String result = "";
        for (FormalParameter f : parameters) {
            if (!result.isEmpty()) {
                result += ",";
            }
            result += f.name();
        }

        return method + "(" + result + ")";
    }
}
