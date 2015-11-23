package be.ugent.neio.translate;

import be.ugent.neio.expression.NeioMethodInvocation;
import be.ugent.neio.industry.NeioExpressionFactory;
import be.ugent.neio.industry.NeioFactory;
import be.ugent.neio.language.Neio;
import be.ugent.neio.model.document.TextDocument;
import org.aikodi.chameleon.core.lookup.LookupException;
import org.aikodi.chameleon.oo.expression.Expression;
import org.aikodi.chameleon.oo.expression.ExpressionFactory;
import org.aikodi.chameleon.oo.method.ExpressionImplementation;
import org.aikodi.chameleon.oo.method.RegularImplementation;
import org.aikodi.chameleon.oo.plugin.ObjectOrientedFactory;
import org.aikodi.chameleon.oo.statement.Block;
import org.aikodi.chameleon.oo.statement.Statement;
import org.aikodi.chameleon.oo.type.Type;
import org.aikodi.chameleon.support.statement.ReturnStatement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Java8Generator extends AbstractJava8Generator {

    private static final String VAR_NAME = "var";
    private Neio neio;
    private int id;

    private NeioExpressionFactory eFactory() {
        return (NeioExpressionFactory) neio.plugin(ExpressionFactory.class);
    }

    private NeioFactory oFactory() {
        return (NeioFactory) neio.plugin(ObjectOrientedFactory.class);
    }

    public TextDocument createJavaDocument(TextDocument neioDocument) throws LookupException {
        neio = neio(neioDocument);
        id = 0;
        replaceExpressionImplementations(neioDocument);
        replaceMethodChain(neioDocument);
        return neioDocument;
    }

    private void replaceMethodChain(TextDocument neioDocument) throws LookupException {
        List<Statement> newStatements = new ArrayList<>();

        Iterator<Statement> iterator = neioDocument.getBlock().statements().iterator();
        while (iterator.hasNext()) {
            Stack<NeioMethodInvocation> callStack = new Stack<>();
            Statement methodChain = iterator.next();
            iterator.remove();

            // MethodInvocations start from the back so push the invocations on a stack to get the correct order
            // TODO: Should only be one?
            NeioMethodInvocation nmi = methodChain.nearestDescendants(NeioMethodInvocation.class).get(0);
            while (nmi.getTarget() != null) {
                callStack.push(nmi);
                nmi = (NeioMethodInvocation) nmi.getTarget();
            }

            boolean first = true;
            while (!callStack.isEmpty()) {
                NeioMethodInvocation call = callStack.pop();
                Type type = call.getType();
                // TODO: is this allowed?
                Expression expression;
                if (first) {
                    call.setTarget(null);
                    // If this is the first expression then it has to be a new call
                    expression = eFactory().createNewExpression(call.toString());
                    first = false;
                } else {
                    // TODO: now set the right var as prefix
                    expression = call;
                }

                oFactory().createLocalVariable(neio.createTypeReference(type.name()), getVarName(), expression);
            }
        }

        neioDocument.getBlock().addStatements(newStatements);
    }

    private String getVarName() {
        return VAR_NAME + (id++);
    }

    protected void replaceExpressionImplementations(TextDocument javaDocument) {
        javaDocument.getBlock().apply(ExpressionImplementation.class, implementation -> {
            Block body = new Block();
            // We move the expression instead of cloning it
            body.addStatement(new ReturnStatement(implementation.expression()));
            RegularImplementation replacement = new RegularImplementation(body);
            implementation.replaceWith(replacement);
        });
    }
}
