package be.ugent.neio.translate;

import be.ugent.neio.expression.NeioMethodInvocation;
import be.ugent.neio.industry.NeioExpressionFactory;
import be.ugent.neio.industry.NeioFactory;
import be.ugent.neio.language.Neio;
import be.ugent.neio.model.document.TextDocument;
import org.aikodi.chameleon.core.Config;
import org.aikodi.chameleon.core.element.Element;
import org.aikodi.chameleon.core.lookup.LookupException;
import org.aikodi.chameleon.core.variable.Variable;
import org.aikodi.chameleon.exception.ChameleonProgrammerException;
import org.aikodi.chameleon.oo.expression.Expression;
import org.aikodi.chameleon.oo.expression.ExpressionFactory;
import org.aikodi.chameleon.oo.expression.MethodInvocation;
import org.aikodi.chameleon.oo.plugin.ObjectOrientedFactory;
import org.aikodi.chameleon.oo.statement.Block;
import org.aikodi.chameleon.oo.statement.Statement;
import org.aikodi.chameleon.oo.type.Type;
import org.aikodi.chameleon.oo.variable.VariableDeclaration;
import org.aikodi.chameleon.support.expression.ThisLiteral;
import org.aikodi.chameleon.support.member.simplename.method.NormalMethod;
import org.aikodi.chameleon.support.member.simplename.method.RegularMethodInvocation;
import org.aikodi.chameleon.support.statement.StatementExpression;
import org.aikodi.chameleon.support.variable.LocalVariableDeclarator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static be.ugent.neio.util.Constants.*;

public class Java8Generator {

    private static final String VAR_NAME = "$var";
    public static final String ROOT = VAR_NAME + "0";
    private Neio neio;
    private int id;

    private NeioExpressionFactory eFactory() {
        return (NeioExpressionFactory) neio.plugin(ExpressionFactory.class);
    }

    private NeioFactory oFactory() {
        return (NeioFactory) neio.plugin(ObjectOrientedFactory.class);
    }

    public TextDocument createJavaDocument(TextDocument neioDocument) throws LookupException {
        neio = neioDocument.language(Neio.class);
        id = 0;

        replaceMethodChain(neioDocument.getBlock());
        String writerReturn = callWriter(neioDocument);
        callBuilder(neioDocument, writerReturn);

        return neioDocument;
    }

    /**
     * Transforms the methodchains into variable declarations
     *
     * @param oldBlock The block in which to find the methodchains
     * @throws LookupException
     */
    private void replaceMethodChain(Block oldBlock) throws LookupException {
        // The defined variables
        Stack<Variable> variables = new Stack<>();
        // Use a string as we constantly have to create new NameExpressions
        String lastElement = null;

        Block block = new Block();
        oldBlock.replaceWith(block);
        for (Statement statement : oldBlock.statements()) {
            // Is this is a Block?
            // If so, it is an inline code block
            if (getNearestElement(statement, Statement.class) != null) {
                processInlineBlock(lastElement, (Block) statement);
                block.addStatement(statement);
                continue;

            }
            // Add the statement to the new block so that it can do lookups using the new block
            block.addStatement(statement);

            Stack<RegularMethodInvocation> callStack = new Stack<>();
            // MethodInvocations start from the back so push the invocations on a stack to get the correct order
            RegularMethodInvocation inv;
            Element methodChain = statement;
            while ((inv = getInvocation(methodChain)) != null) {
                callStack.push(inv);
                methodChain = inv;
            }

            // Turn the methodchain into local variables, one by one
            while (!callStack.isEmpty()) {
                RegularMethodInvocation call = callStack.pop();
                fixNestedMethod(call);

                // FIXME: instanceof until ThisLiteral stops wrongfully being a literal
                if (call.getTarget() != null && call.getTarget() instanceof ThisLiteral) {
                    //THIS found, substitute it by the last element
                    call.getTarget().replaceWith(eFactory().createNeioNameExpression(lastElement));
                }

                // Get the method to know which type the variable will have to be (= returntype)
                NormalMethod method = call.getElement();
                // Type instead of TypeReference as TypeReference does not return a TypeReference with fqn
                Type returnType = method.returnType();

                // Add a prefix if this is not a constructor
                Type type = method.nearestAncestor(Type.class);
                String prefix = method.isTrue(neio.CONSTRUCTOR) ? null : getPrefix(type, variables);
                RegularMethodInvocation clone = (RegularMethodInvocation) call.clone();
                clone.setTarget(prefix == null ? null : eFactory().createNeioNameExpression(prefix));

                String varName;
                VariableDeclaration var;
                if ((var = getVarDeclaration(methodChain)) != null) {
                    // Use the variable name defined in the statement
                    varName = var.name();
                } else {
                    // Create a new variable name
                    varName = getVarName();
                }
                LocalVariableDeclarator lvd = oFactory().createLocalVariable(returnType.getFullyQualifiedName(), varName, clone);

                variables.push(lvd.variableDeclarations().get(0).variable());
                lastElement = variables.peek().name();
                block.addStatement(lvd);
            }

            // Remove the old statement from the block that will printed to Java
            block.removeStatement(statement);
        }
    }

    private void processInlineBlock(String lastElement, Block block) {
        if (lastElement == null) {
            throw new ChameleonProgrammerException("Inline code blocks are not allowed as the first element in a document!");
        }

        for (Element replacee : block.nearestDescendants(ThisLiteral.class)) {
            replacee.replaceWith(eFactory().createNeioNameExpression(lastElement));
        }
    }

    /**
     * Creates a document writer and calls the write method on it creating a TeX/JS/... string
     *
     * @param neioDocument The document to write
     * @return The variable name of the generated string
     */
    private String callWriter(TextDocument neioDocument) {
        Block block = neioDocument.getBlock();

        List<Expression> arguments = new ArrayList<>();
        arguments.add(eFactory().createNameExpression(ROOT));
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

    /**
     * Builds the TeX/JS/... string into a real document such as a PDF
     *
     * @param neioDocument The document to build
     * @param writerReturn The variable name of the TeX/JS/... string
     */
    private void callBuilder(TextDocument neioDocument, String writerReturn) {
        List<Expression> arguments = new ArrayList<>();
        Expression ci = eFactory().createConstructorInvocation(DEFAULT_BUILDER, null, arguments);

        List<Expression> miArguments = new ArrayList<>();
        miArguments.add(eFactory().createNameExpression(writerReturn));
        MethodInvocation mi = eFactory().createMethodInvocation(BUILD_METHOD, ci, miArguments);

        neioDocument.getBlock().addStatement(oFactory().createStatement(mi));
    }

    /**
     * Get the nearest element of type T
     *
     * @param element The element in which to look for the nearest element
     * @param klass   The class of the element we're looking for
     * @param <T>     The type of the element we're looking for
     * @return The nearest element of type T
     */
    private <T extends Element> T getNearestElement(Element element, Class<T> klass) {
        List elements = element.nearestDescendants(klass);
        if (elements == null || elements.isEmpty()) {
            return null;
        }

        return (T) elements.get(0);
    }

    /**
     * Gets the nearest variable declaration, there can only be one in a statement
     *
     * @param statement The statement in which to look for variable declaration
     * @return The variable declaration
     */
    private VariableDeclaration getVarDeclaration(Element statement) {
        VariableDeclaration variableDeclaration = statement.nearestAncestor(VariableDeclaration.class);
        if (variableDeclaration == null) {
            return getNearestElement(statement, VariableDeclaration.class);
        } else {
            return variableDeclaration;
        }
    }

    /**
     * Gets the nearest (= furthest in a methodchain) method invocation
     *
     * @param statement The statement in which to look for a method invocation
     * @return The nearest method invocation
     */
    private RegularMethodInvocation getInvocation(Element statement) {
        return getNearestElement(statement, RegularMethodInvocation.class);
    }

    /**
     * Creates a valid methodname for Java
     *
     * @param rmi The methodinvocation to transform
     */
    private void fixNestedMethod(RegularMethodInvocation rmi) {
        String name = rmi.name();
        if (isNested(name)) {
            rmi.setName(firstChar(name));
            rmi.addArgument(oFactory().createIntegerLiteral(String.valueOf(name.length())));
        }
    }

    /**
     * Checks if a method seems nested
     */
    private boolean isNested(String name) {
        String c = firstChar(name);
        Pattern p = Pattern.compile("^[" + c + "][" + c + "]+$");
        Matcher m = p.matcher(name);
        return m.matches();
    }

    private String firstChar(String s) {
        return String.valueOf(s.charAt(0));
    }

    private String getPrefix(Type type, Stack<Variable> variables) throws LookupException {
        while (!variables.isEmpty()) {
            Variable var = variables.peek();
            if (var.getTypeReference().toString().equals(type.toString())) {
                return var.name();
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
