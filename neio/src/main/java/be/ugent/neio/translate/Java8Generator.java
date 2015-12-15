package be.ugent.neio.translate;

import be.ugent.neio.industry.NeioExpressionFactory;
import be.ugent.neio.industry.NeioFactory;
import be.ugent.neio.language.Neio;
import be.ugent.neio.model.document.TextDocument;
import be.ugent.neio.util.Variable;
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
import org.aikodi.chameleon.oo.variable.VariableDeclaration;
import org.aikodi.chameleon.support.member.simplename.method.NormalMethod;
import org.aikodi.chameleon.support.member.simplename.method.RegularMethodInvocation;
import org.aikodi.chameleon.support.statement.ReturnStatement;
import org.aikodi.chameleon.support.variable.LocalVariableDeclarator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static be.ugent.neio.util.Constants.*;

public class Java8Generator extends AbstractJava8Generator {

    private static final String VAR_NAME = "var";
    public static final String ROOT_VAR = VAR_NAME + "0";
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
        replaceMethodChain(neioDocument);
        String writerReturn = callWriter(neioDocument);
        callBuilder(neioDocument, writerReturn);

        return neioDocument;
    }

    private String callWriter(TextDocument neioDocument) {
        Block block = neioDocument.getBlock();

        List<Expression> arguments = new ArrayList<>();
        arguments.add(eFactory().createNameExpression(ROOT_VAR));
        Expression ci = eFactory().createConstructorInvocation(DEFAULT_WRITER, null, arguments);

        List<Expression> miArguments = new ArrayList<>();
        miArguments.add(oFactory().createStringLiteral(neioDocument.getName()));
        MethodInvocation mi = eFactory().createMethodInvocation(WRITE_METHOD, ci, miArguments);
        LocalVariableDeclarator varDecl = new LocalVariableDeclarator(oFactory().createTypeReference("java.lang.String"));
        String varName = getVarName();
        VariableDeclaration var = new VariableDeclaration(varName, mi);
        varDecl.add(var);

        block.addStatement(varDecl);
        return varName;
    }

    private void callBuilder(TextDocument neioDocument, String writerReturn) {
        List<Expression> arguments = new ArrayList<>();
        Expression ci = eFactory().createConstructorInvocation(DEFAULT_BUILDER, null, arguments);

        List<Expression> miArguments = new ArrayList<>();
        miArguments.add(eFactory().createNameExpression(writerReturn));
        MethodInvocation mi = eFactory().createMethodInvocation(BUILD_METHOD, ci, miArguments);

        neioDocument.getBlock().addStatement(oFactory().createStatement(mi));
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
            // Push the constructor call on the stack
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
}
