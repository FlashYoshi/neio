package be.ugent.neio.translate;

import be.ugent.neio.industry.NeioExpressionFactory;
import be.ugent.neio.industry.NeioFactory;
import be.ugent.neio.language.Neio;
import be.ugent.neio.model.document.TextDocument;
import org.aikodi.chameleon.core.lookup.LookupException;
import org.aikodi.chameleon.oo.expression.Expression;
import org.aikodi.chameleon.oo.expression.ExpressionFactory;
import org.aikodi.chameleon.oo.expression.MethodInvocation;
import org.aikodi.chameleon.oo.method.ExpressionImplementation;
import org.aikodi.chameleon.oo.method.RegularImplementation;
import org.aikodi.chameleon.oo.plugin.ObjectOrientedFactory;
import org.aikodi.chameleon.oo.statement.Block;
import org.aikodi.chameleon.oo.statement.Statement;
import org.aikodi.chameleon.oo.type.Type;
import org.aikodi.chameleon.support.statement.ReturnStatement;

import java.util.ArrayList;
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

        for (Statement methodChain : neioDocument.getBlock().statements()) {
            Stack<MethodInvocation> callStack = new Stack<>();

            // MethodInvocations start from the back so push the invocations on a stack to get the correct order
            MethodInvocation nmi = methodChain.nearestDescendants(MethodInvocation.class).get(0);
            while (nmi.getTarget() != null) {
                callStack.push(nmi);
                nmi = (MethodInvocation) nmi.getTarget();
            }
            // Push the new call on the stack
            callStack.push(nmi);

            boolean first = true;
            while (!callStack.isEmpty()) {
                MethodInvocation call = callStack.pop();
                Type type = call.getType();

                Expression expression;
                if (first) {
                    call.setTarget(null);
                    // If this is the first expression then it has to be a new call
                    expression = eFactory().createNewExpression(type.name());
                    first = false;
                } else {
                    // TODO: now set the right var as prefix (= target)
                    expression = call;
                }

                Statement s = oFactory().createLocalVariable(neio.createTypeReference(type.name()), getVarName(), expression);
                newStatements.add(s);
            }
        }

        Block block = new Block();
        block.addStatements(newStatements);
        neioDocument.setBlock(block);
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
