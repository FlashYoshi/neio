package be.ugent.neio.translate;

import be.kuleuven.cs.distrinet.jnome.core.expression.invocation.JavaMethodInvocation;
import be.ugent.neio.expression.NeioNameExpression;
import be.ugent.neio.industry.NeioExpressionFactory;
import be.ugent.neio.industry.NeioFactory;
import be.ugent.neio.language.Neio;
import be.ugent.neio.model.document.TextDocument;
import be.ugent.neio.util.CodeTag;
import org.aikodi.chameleon.core.element.Element;
import org.aikodi.chameleon.core.lookup.LookupException;
import org.aikodi.chameleon.core.tag.TagImpl;
import org.aikodi.chameleon.core.variable.Variable;
import org.aikodi.chameleon.exception.ChameleonProgrammerException;
import org.aikodi.chameleon.oo.expression.Expression;
import org.aikodi.chameleon.oo.expression.ExpressionFactory;
import org.aikodi.chameleon.oo.expression.MethodInvocation;
import org.aikodi.chameleon.oo.expression.NameExpression;
import org.aikodi.chameleon.oo.plugin.ObjectOrientedFactory;
import org.aikodi.chameleon.oo.statement.Block;
import org.aikodi.chameleon.oo.statement.Statement;
import org.aikodi.chameleon.oo.type.Type;
import org.aikodi.chameleon.oo.variable.VariableDeclaration;
import org.aikodi.chameleon.support.expression.AssignmentExpression;
import org.aikodi.chameleon.support.expression.ThisLiteral;
import org.aikodi.chameleon.support.member.simplename.method.NormalMethod;
import org.aikodi.chameleon.support.member.simplename.method.RegularMethodInvocation;
import org.aikodi.chameleon.support.statement.ReturnStatement;
import org.aikodi.chameleon.support.variable.LocalVariableDeclarator;
import org.aikodi.chameleon.util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static be.ugent.neio.util.Constants.*;

public class Java8Generator {

    private static final String VAR_NAME = "$var";
    private static final String ROOT = VAR_NAME + "0";
    private Neio neio;
    private int id;
    private String lastElement = null;

    private NeioExpressionFactory eFactory() {
        return (NeioExpressionFactory) neio.plugin(ExpressionFactory.class);
    }

    private NeioFactory oFactory() {
        return (NeioFactory) neio.plugin(ObjectOrientedFactory.class);
    }

    public TextDocument createJavaDocument(TextDocument neioDocument) throws LookupException {
        neio = neioDocument.language(Neio.class);
        id = 0;

        neioDocument.setBlock(replaceMethodChain(neioDocument.getBlock()));
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
    private Block replaceMethodChain(Block oldBlock) throws LookupException {
        // The defined variables
        Stack<Variable> variables = new Stack<>();
        // Use a string as we constantly have to create new NameExpressions
        lastElement = null;

        Block block = new Block();
        oldBlock.replaceWith(block);
        Block loneCode = oFactory().createBlock();
        loneCode.setMetadata(new TagImpl(), Neio.LONE_CODE);
        int prevCodeId = -1;
        Statement nextBlock = null;
        for (Statement statement : oldBlock.statements()) {
            Statement oldStatement = null;
            // If so, it is an inline code block
            if (statement.hasMetadata(Neio.LONE_CODE)) {
                int id = ((CodeTag)statement.metadata(Neio.LONE_CODE)).id();
                if (id == prevCodeId) {
                    // There is more than 1 instruction in the new block
                    if (nextBlock != null) {
                        loneCode.addStatement(nextBlock);
                        nextBlock = null;
                    }
                    loneCode.addStatement(statement);
                } else {
                    // More than 2 consecutive online lonecodeblocks
                    if (nextBlock != null) {
                        loneCode.addStatement(nextBlock);
                    }
                    prevCodeId = id;
                    nextBlock = statement;
                }
                // Can't fix the lonecode in the next statement if this is the last statement
                if (oldBlock.nbStatements() != 0 && nextBlock == null) {
                    continue;
                } else {
                    statement = loneCode;
                }
            }
            // If there's a loneblock, process it first
            else if (loneCode.nbStatements() > 0) {
                oldStatement = statement;
                statement = loneCode;
            }
            // If there's another loneblock, process it first
            else if (nextBlock != null) {
                oldStatement = statement;
                loneCode.addStatement(nextBlock);
                statement = loneCode;
                nextBlock = null;
            }
            if (getNearestElement(statement, Statement.class) != null) {
                block.addStatement(statement);
                Block blockStatement = (Block) statement;
                processCodeBlock(lastElement, blockStatement, variables);
                if (statement.hasMetadata(Neio.LONE_CODE)) {
                    if (statement.hasDescendant(ReturnStatement.class)) {
                        blockStatement = fixReturnStatement(blockStatement, variables);
                    }
                    block.removeStatement(statement);
                    block.addStatements((blockStatement.statements()));
                    loneCode.clear();
                    if (oldStatement != null) {
                        statement = oldStatement;
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
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
                if (inv.getTarget() instanceof ThisLiteral) {
                    break;
                }
            }

            // Turn the methodchain into local variables, one by one
            while (!callStack.isEmpty()) {
                RegularMethodInvocation call = callStack.pop();
                fixNestedMethod(call);

                // FIXME: instanceof until ThisLiteral stops wrongfully being a literal
                /*if (call.getTarget() != null && call.getTarget() instanceof ThisLiteral) {
                    //THIS found, substitute it by the last element
                    call.getTarget().replaceWith(eFactory().createNeioNameExpression(lastElement));
                }*/

                for (ThisLiteral t : call.descendants(ThisLiteral.class)) {
                    //THIS found, substitute it by the last element
                    NeioNameExpression expr = eFactory().createNeioNameExpression(lastElement);
                    t.replaceWith(expr);
                    if (expr.parent() != null) {
                        String prefix = getPrefix(((RegularMethodInvocation) expr.parent()), variables);
                        if (prefix != null) {
                            expr.replaceWith(eFactory().createNeioNameExpression(prefix));
                        }
                    }
                }

                String prefix = getPrefix(call, variables);
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

                NormalMethod method = call.getElement();
                // Type instead of TypeReference as TypeReference does not return a TypeReference with fqn
                Type returnType = method.returnType();

                LocalVariableDeclarator lvd = oFactory().createLocalVariable(returnType.name(), varName, clone);

                variables.push(lvd.variableDeclarations().get(0).variable());
                lastElement = variables.peek().name();
                block.addStatement(lvd);
            }

            // Remove the old statement from the block that will printed to Java
            block.removeStatement(statement);
        }

        return block;
    }

    private String getPrefix(RegularMethodInvocation call, Stack<Variable> variables) throws LookupException {
        // Get the method to know which type the variable will have to be (= returntype)
        NormalMethod method = call.getElement();

        // Add a prefix if this is not a constructor
        Type type = method.nearestAncestor(Type.class);
        return method.isTrue(neio.CONSTRUCTOR) ? null : getPrefix(type, variables);
    }

    /**
     * Checks if the return statement in an inline code block returns content.
     * It also assigns a variable to it and makes sure the compiler uses this new element when building the document.
     *
     * @param block     The block of inline code
     * @param variables The previously defined variables
     * @return The block with a variable declaration instead of a returnstatement
     */
    private Block fixReturnStatement(Block block, Stack<Variable> variables) {
        for (ReturnStatement returnStat : block.nearestDescendants(ReturnStatement.class)) {
            String prev = lastElement;
            Expression e = returnStat.getExpression();
            Type type = null;
            if (!(e instanceof NameExpression) && (!(e instanceof MethodInvocation))) {
                System.err.println("You can only return Content in an inline code block, unknown expression: " + e.toString());
                return block;
            } else {
                try {
                    if (e instanceof NameExpression) {
                        lastElement = ((NameExpression) e).name();
                        // TODO: set type
                    } else {
                        // Check if we return Content
                        NormalMethod method = (NormalMethod) ((MethodInvocation) e).getElement();
                        type = method.returnType();
                        boolean content = false;
                        for (Type t : type.getSelfAndAllSuperTypesView()) {
                            if (t.name().equals(Util.getLastPart(BASE_CLASS))) {
                                content = true;
                                break;
                            }
                        }
                        if (!content) {
                            System.err.println("You can only return Content in an inline code block, unknown expression: " + e.toString());
                            return block;
                        }

                        LocalVariableDeclarator lvd = oFactory().createLocalVariable(type.name(), getVarName(), (Expression) e.clone());
                        variables.push(lvd.variableDeclarations().get(0).variable());
                        lastElement = variables.peek().name();
                        block.addStatement(lvd);
                    }
                } catch (LookupException e1) {
                    System.err.println(e + " has not been declared yet!");
                    lastElement = prev;
                    return block;
                }

                block.removeStatement(returnStat);
                List<Expression> arguments = new ArrayList<>();
                arguments.add(eFactory().createNameExpression(lastElement));
                JavaMethodInvocation expr = eFactory().createNeioMethodInvocation(APPEND_CONTENT, eFactory().createNeioNameExpression(prev), arguments);
                block.addStatement(oFactory().createStatement(expr));
                // Resolve the right target using contexttypes
                try {
                    Stack<Variable> vars = (Stack<Variable>) variables.clone();
                    vars.pop();
                    setThis(expr, expr.getTarget(), vars);
                    block.removeStatement(expr.nearestAncestor(Statement.class));
                    LocalVariableDeclarator lvd = oFactory().createLocalVariable(type.name(), getVarName(), expr);
                    variables.push(lvd.variableDeclarations().get(0).variable());
                    lastElement = variables.peek().name();
                    block.addStatement(lvd);
                } catch (LookupException e1) {
                    System.err.println("Error while setting this on " + APPEND_CONTENT);
                }
            }
        }

        return block;
    }

    private void processCodeBlock(String lastElement, Block block, Stack<Variable> variables) throws LookupException {
        if (lastElement == null) {
            throw new ChameleonProgrammerException("Code blocks are not allowed as the first element in a document!");
        }

        for (LocalVariableDeclarator lvd : block.descendants(LocalVariableDeclarator.class)) {
            for (Element replacee : lvd.variableDeclarations().get(0).descendants(ThisLiteral.class)) {
                NameExpression replacer = eFactory().createNeioNameExpression(lastElement);
                replacee.replaceWith(replacer);
            }
        }

        for (AssignmentExpression as : block.descendants(AssignmentExpression.class)) {
            List<ThisLiteral> thisLiterals = as.variableExpression().nearestDescendants(ThisLiteral.class);

            // There should only be 1
            for (ThisLiteral t : thisLiterals) {
                // TODO: set this
            }
        }


        // Replace occurences of 'this'
        for (Element replacee : block.descendants(ThisLiteral.class)) {
            NameExpression replacer = eFactory().createNeioNameExpression(lastElement);
            replacee.replaceWith(replacer);

            RegularMethodInvocation mi = (RegularMethodInvocation) replacer.parent();
            // Am I the target of a method invocation?
            if (mi.getTarget().equals(replacer)) {
                setThis(mi, replacer, variables);
            }
        }

        for (JavaMethodInvocation jmi : block.descendants(JavaMethodInvocation.class)) {
            // This is a method invocation that should be called on 'this'
            if (jmi.getTarget() == null) {
                jmi.setTarget(eFactory().createNeioNameExpression(lastElement));
                setThis(jmi, jmi.getTarget(), variables);
            }
        }
    }

    private void setThis(RegularMethodInvocation mi, Element replacee, Stack<Variable> variables) throws LookupException {
        NormalMethod method = mi.getElement();
        Type type = method.nearestAncestor(Type.class);
        replacee.replaceWith(eFactory().createNeioNameExpression(getPrefix(type, variables)));
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
        MethodInvocation mi = eFactory().createNeioMethodInvocation(WRITE_METHOD, ci, miArguments);
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
        MethodInvocation mi = eFactory().createNeioMethodInvocation(BUILD_METHOD, ci, miArguments);

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

    private String getPrefix(Type type, Stack<Variable> stack) throws LookupException {
        Stack<Variable> variables = (Stack<Variable>) stack.clone();
        while (!variables.isEmpty()) {
            Variable var = variables.peek();
            boolean found = false;
            for (Type t : var.getType().getSelfAndAllSuperTypesView()) {
                if (t.name().equals(type.name())) {
                    found = true;
                    break;
                }
            }
            if (found) {
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
