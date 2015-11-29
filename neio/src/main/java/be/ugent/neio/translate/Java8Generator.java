package be.ugent.neio.translate;

import be.ugent.neio.industry.NeioExpressionFactory;
import be.ugent.neio.industry.NeioFactory;
import be.ugent.neio.language.Neio;
import be.ugent.neio.model.document.TextDocument;
import be.ugent.neio.util.Variable;
import org.aikodi.chameleon.core.lookup.LookupException;
import org.aikodi.chameleon.oo.expression.ExpressionFactory;
import org.aikodi.chameleon.oo.method.ExpressionImplementation;
import org.aikodi.chameleon.oo.method.RegularImplementation;
import org.aikodi.chameleon.oo.plugin.ObjectOrientedFactory;
import org.aikodi.chameleon.oo.statement.Block;
import org.aikodi.chameleon.oo.statement.Statement;
import org.aikodi.chameleon.oo.type.Type;
import org.aikodi.chameleon.support.member.simplename.method.NormalMethod;
import org.aikodi.chameleon.support.member.simplename.method.RegularMethodInvocation;
import org.aikodi.chameleon.support.statement.ReturnStatement;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            Stack<RegularMethodInvocation> callStack = new Stack<>();

            // MethodInvocations start from the back so push the invocations on a stack to get the correct order
            RegularMethodInvocation rmi = methodChain.nearestDescendants(RegularMethodInvocation.class).get(0);
            while (rmi.getTarget() != null) {
                callStack.push(rmi);
                rmi = (RegularMethodInvocation) rmi.getTarget();
            }
            // Push the new call on the stack
            callStack.push(rmi);

            while (!callStack.isEmpty()) {
                RegularMethodInvocation call = callStack.pop();
                fixNestedMethod(call);

                NormalMethod method = call.getElement();
                Type type = method.nearestAncestor(Type.class);
                Type returnType = method.returnType();
                String prefix = getPrefix(type, variables);

                RegularMethodInvocation clone = (RegularMethodInvocation) call.clone();
                clone.setTarget(prefix == null ? null : eFactory().createNameExpression(prefix));

                String varName = getVarName();
                Statement s = oFactory().createLocalVariable(neio.createTypeReference(returnType.name()), varName, clone);
                variables.push(new Variable(returnType.name(), varName));
                newStatements.add(s);
            }
        }

        Block block = new Block();
        block.addStatements(newStatements);
        neioDocument.setBlock(block);
    }

    private void fixNestedMethod(RegularMethodInvocation rmi) {
        String name = rmi.name();
        if (isNested(name)) {
            rmi.setName(firstChar(name));
            rmi.addArgument(oFactory().createIntegerLiteral(String.valueOf(name.length())));
        }
    }

    private boolean isNested(String name) {
        String c = firstChar(name);
        Pattern p = Pattern.compile("^" + c + c + "+$");
        Matcher m = p.matcher(name);
        return m.matches();
    }

    private String firstChar(String s) {
        return String.valueOf(s.charAt(0));
    }

    private String getPrefix(Type type, Stack<Variable> variables) throws LookupException {
        while (!variables.isEmpty()) {
            Variable var = variables.peek();
            if (var.getTypeName().equals(type.name())) {
                return var.getVarName();
            } else {
                variables.pop();
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
