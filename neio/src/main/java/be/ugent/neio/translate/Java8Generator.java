package be.ugent.neio.translate;

import be.ugent.neio.industry.NeioExpressionFactory;
import be.ugent.neio.industry.NeioFactory;
import be.ugent.neio.language.Neio;
import be.ugent.neio.model.document.TextDocument;
import be.ugent.neio.model.modifier.Nested;
import be.ugent.neio.util.Variable;
import org.aikodi.chameleon.core.lookup.LookupException;
import org.aikodi.chameleon.core.lookup.NameSelector;
import org.aikodi.chameleon.core.lookup.SelectionResult;
import org.aikodi.chameleon.oo.expression.ExpressionFactory;
import org.aikodi.chameleon.oo.expression.MethodInvocation;
import org.aikodi.chameleon.oo.method.ExpressionImplementation;
import org.aikodi.chameleon.oo.method.Method;
import org.aikodi.chameleon.oo.method.RegularImplementation;
import org.aikodi.chameleon.oo.plugin.ObjectOrientedFactory;
import org.aikodi.chameleon.oo.statement.Block;
import org.aikodi.chameleon.oo.statement.Statement;
import org.aikodi.chameleon.oo.type.Type;
import org.aikodi.chameleon.support.member.simplename.method.NormalMethod;
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
        Stack<Variable> variables = new Stack<>();

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

            while (!callStack.isEmpty()) {
                MethodInvocation call = callStack.pop();
                Type type = call.getType();
                Method method = (Method) call.getElement();
                String methodName = method.name();
                String prefix = getPrefix(type, methodName, variables);

                call.setTarget(eFactory().createNameExpression(prefix));
                // Add nesting level if this is a nested method
                if (method.hasModifier(new Nested())) {
                    call.addArgument(oFactory().createIntegerLiteral(String.valueOf(methodName.length())));
                }

                String varName = getVarName();
                Statement s = oFactory().createLocalVariable(neio.createTypeReference(type.name()), varName, call);
                variables.push(new Variable(type.name(), varName));
                newStatements.add(s);
            }
        }

        Block block = new Block();
        block.addStatements(newStatements);
        neioDocument.setBlock(block);
    }

    private String getPrefix(Type type, String methodName, Stack<Variable> variables) throws LookupException {
        List<? extends SelectionResult> declarations = type.declarations(new NameSelector<NormalMethod>(NormalMethod.class) {
            @Override
            public String name() {
                return methodName;
            }
        });

        if (!declarations.isEmpty()) {
            while (!variables.isEmpty()) {
                Variable var = variables.pop();
                if (var.getTypeName().equals(type.name())) {
                    return var.getVarName();
                }
            }
        }

        return null;
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
