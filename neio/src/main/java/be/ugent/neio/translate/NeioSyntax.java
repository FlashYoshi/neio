package be.ugent.neio.translate;

import be.kuleuven.cs.distrinet.jnome.core.expression.invocation.ConstructorInvocation;
import be.kuleuven.cs.distrinet.jnome.core.expression.invocation.JavaInfixOperatorInvocation;
import be.kuleuven.cs.distrinet.jnome.core.type.BasicJavaTypeReference;
import be.kuleuven.cs.distrinet.jnome.output.Java7Syntax;
import be.ugent.neio.model.modifier.Nested;
import be.ugent.neio.model.modifier.Surround;
import org.aikodi.chameleon.core.element.Element;
import org.aikodi.chameleon.core.lookup.LookupException;
import org.aikodi.chameleon.core.modifier.Modifier;
import org.aikodi.chameleon.exception.ChameleonProgrammerException;
import org.aikodi.chameleon.oo.expression.*;
import org.aikodi.chameleon.oo.method.Method;
import org.aikodi.chameleon.oo.method.exception.ExceptionClause;
import org.aikodi.chameleon.oo.statement.Block;
import org.aikodi.chameleon.oo.statement.Statement;
import org.aikodi.chameleon.oo.type.BasicTypeReference;
import org.aikodi.chameleon.oo.variable.FormalParameter;
import org.aikodi.chameleon.support.expression.RegularLiteral;
import org.aikodi.chameleon.support.member.simplename.method.RegularMethodInvocation;
import org.aikodi.chameleon.support.statement.*;

import java.util.*;
import java.util.regex.Pattern;

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
        map.put("-", "dash");
        map.put("_", "underscore");
        map.put("`", "backquote");
        ALIASES = Collections.unmodifiableMap(map);
    }

    @Override
    public String toCode(Element element) {
        if (isParExpression(element)) {
            return toCodeParExpression((ParExpression) element);
        }

        return super.toCode(element);
    }

    protected boolean isParExpression(Element e) {
        return e instanceof ParExpression;
    }

    protected String toCodeParExpression(ParExpression e) {
        return "(" + toCode(e.expression()) + ")";
    }

    @Override
    protected String toCodeModifier(Modifier element) {
        if (element instanceof Nested || element instanceof Surround) {
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
    public String toCodeReturn(ReturnStatement stat) {
        String result = addCatchAll(stat.getExpression());

        return result != null ? result : super.toCodeReturn(stat);
    }

    @Override
    public String toCodeStatementExpression(StatementExpression stat) {
        String result = addCatchAll(stat.getExpression());

        return result != null ? result : super.toCodeStatementExpression(stat);
    }

    private String addCatchAll(Expression expr) {
        if (expr == null) {
            return null;
        }
        // This will deduce if a basic try catch is needed for this statement and create it if need be
        if (expr.nearestAncestor(TryStatement.class) == null && expr instanceof MethodInvocation) {
            Set exceptions = getExceptions((MethodInvocation) expr);
            if (exceptions != null && !exceptions.isEmpty()) {
                Statement stat = (Statement) expr.parent();
                Block parent = (Block) stat.parent();

                Block tryBlock = new Block();
                tryBlock.addStatement(stat);

                TryStatement tryStatement = new TryStatement(tryBlock);

                // Create error message
                Literal left = new RegularLiteral(new BasicTypeReference("java.lang.String"), "Exception encountered: ");
                JavaInfixOperatorInvocation catchPrint = new JavaInfixOperatorInvocation("+", left);
                catchPrint.addArgument(new NameExpression("e"));

                // Create a throw of a NeioRuntimeException
                ConstructorInvocation runtimeException = new ConstructorInvocation(new BasicJavaTypeReference("neio.stdlib.NeioRuntimeException"), null);
                runtimeException.addArgument(catchPrint);
                ThrowStatement catchThrow = new ThrowStatement(runtimeException);

                Block catchBlock = new Block();
                catchBlock.addStatement(catchThrow);

                FormalParameter parameter = new FormalParameter("e", new BasicTypeReference("java.lang.Exception"));
                tryStatement.addCatchClause(new CatchClause(parameter, catchBlock));

                parent.removeStatement(stat);
                parent.addStatement(tryStatement);
                String result = toCode(tryStatement);
                parent.removeStatement(tryStatement);

                return result;
            }
        }

        return null;
    }

    private Set getExceptions(MethodInvocation mi) {
        Set exceptions = null;
        try {
            List<ExceptionClause> list = mi.getElement().children(ExceptionClause.class);
            if (list != null && !list.isEmpty()) {
                exceptions = list.get(0).getExceptionTypes(mi);
            }
        } catch (LookupException e) {
            System.err.println("Lookup exception when trying to find throws: " + e.getMessage());
        }

        return exceptions;
    }

    @Override
    public String toCodeRegularMethodInvocation(RegularMethodInvocation inv) {
        // Print with a name that Java can work with
        String old = inv.name();
        inv.setName(createValidMethodname(old));

        String result = super.toCodeRegularMethodInvocation(inv);
        inv.setName(old);

        return result;
    }

    // Creates a valid method name as Neio allows for symbols in its methodnames
    private String createValidMethodname(String methodname) {
        String result = methodname;
        for (String s : ALIASES.keySet()) {
            if (result.contains(s)) {
                result = result.replaceAll(Pattern.quote(s), ALIASES.get(s));
            }
        }

        return result;
    }
}
