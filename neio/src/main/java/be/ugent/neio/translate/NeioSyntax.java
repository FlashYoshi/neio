package be.ugent.neio.translate;

import be.kuleuven.cs.distrinet.jnome.output.Java7Syntax;
import be.ugent.neio.model.modifier.Nested;
import org.aikodi.chameleon.core.lookup.LookupException;
import org.aikodi.chameleon.core.modifier.Modifier;
import org.aikodi.chameleon.exception.ChameleonProgrammerException;
import org.aikodi.chameleon.oo.expression.Literal;
import org.aikodi.chameleon.oo.method.Method;
import org.aikodi.chameleon.support.member.simplename.method.RegularMethodInvocation;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Titouan Vervack
 */
public class NeioSyntax extends Java7Syntax {

    private static final Map<String, String> ALIASES;

    static {
        Map<String, String> map = new HashMap<>();
        map.put("#", "hash");
        map.put("*", "star");
        map.put("=", "equalSign");
        ALIASES = Collections.unmodifiableMap(map);
    }

    @Override
    protected String toCodeModifier(Modifier element) {
        if (element instanceof Nested) {
            return "";
        } else {
            return super.toCodeModifier(element);
        }
    }

    // Used to put quotes around String literals
    @Override
    public String toCodeLiteral(Literal literal) {
        try {
            String literalText = super.toCodeLiteral(literal);
            if (literal.getType().getFullyQualifiedName().equals("java.lang.String") && !literalText.startsWith("\"")) {
                return "\"" + literalText + "\"";
            } else {
                return literalText;
            }
        } catch (LookupException e) {
            throw new ChameleonProgrammerException("Could not lookup: " + e);
        }
    }

    @Override
    public String toCodeMethod(Method method) {
        // Be sure we do not make changes to the actual method
        Method clone = (Method) method.clone();
        // Need to set parent to be able to do some lookups in super()
        clone.setUniParent(method.parent());
        clone.header().signature().setName(createValidMethodname(clone.name()));
        return super.toCodeMethod(clone);
    }

    @Override
    public String toCodeRegularMethodInvocation(RegularMethodInvocation inv) {
        inv.setName(createValidMethodname(inv.name()));
        return super.toCodeRegularMethodInvocation(inv);
    }

    // Creates a valid method name as Neio allows for symbols in its methodnames
    private String createValidMethodname(String methodname) {
        if (ALIASES.get(methodname) != null) {
            return ALIASES.get(methodname);
        } else {
            return methodname;
        }
    }
}
