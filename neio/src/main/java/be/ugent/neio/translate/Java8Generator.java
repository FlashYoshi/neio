package be.ugent.neio.translate;

import be.kuleuven.cs.distrinet.jnome.core.expression.invocation.JavaMethodInvocation;
import be.ugent.neio.expression.NeioMethodInvocation;
import be.ugent.neio.expression.NeioNameExpression;
import be.ugent.neio.industry.NeioExpressionFactory;
import be.ugent.neio.industry.NeioFactory;
import be.ugent.neio.language.Neio;
import be.ugent.neio.model.document.TextDocument;
import be.ugent.neio.util.CodeTag;
import be.ugent.neio.util.Constants;
import org.aikodi.chameleon.core.element.Element;
import org.aikodi.chameleon.core.lookup.LookupException;
import org.aikodi.chameleon.core.tag.TagImpl;
import org.aikodi.chameleon.core.variable.Variable;
import org.aikodi.chameleon.exception.ChameleonProgrammerException;
import org.aikodi.chameleon.oo.expression.*;
import org.aikodi.chameleon.oo.plugin.ObjectOrientedFactory;
import org.aikodi.chameleon.oo.statement.Block;
import org.aikodi.chameleon.oo.statement.Statement;
import org.aikodi.chameleon.oo.type.RegularType;
import org.aikodi.chameleon.oo.type.Type;
import org.aikodi.chameleon.oo.variable.VariableDeclaration;
import org.aikodi.chameleon.support.expression.AssignmentExpression;
import org.aikodi.chameleon.support.expression.ThisLiteral;
import org.aikodi.chameleon.support.member.simplename.method.NormalMethod;
import org.aikodi.chameleon.support.member.simplename.method.RegularMethodInvocation;
import org.aikodi.chameleon.support.member.simplename.operator.infix.InfixOperatorInvocation;
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

        List<Statement> statements = new ArrayList<>(oldBlock.statements());
        for (int i = 0; i < statements.size(); i++) {
            Statement statement = statements.get(i);
            // Is this a block of lonecode
            if (statement.hasMetadata(Neio.LONE_CODE)) {
                int id = ((CodeTag) statement.metadata(Neio.LONE_CODE)).id();
                // New codeblock
                if (loneCode.nbStatements() <= 0) {
                    prevCodeId = id;
                }
                // Statement in same block
                if (id == prevCodeId) {
                    loneCode.addStatement(statement);
                    // Accumulate all of the statements of the lonecode
                    if (i < statements.size() - 1) {
                        continue;
                    }
                    // Process the last instruction, aka the last lonecode
                    else {
                        statement = loneCode;
                    }
                }
                // New lonecode
                else {
                    prevCodeId = id;
                    statement = loneCode;
                    // We still have to process the second block
                    i--;
                }
            }
            // Set the counter back by one and process the lonecode
            else if (loneCode.nbStatements() > 0) {
                i--;
                statement = loneCode;
            }

            // Handles a codeblock if there is one
            statement = fixCodeBlock(block, statement, variables, loneCode);
            if (statement == null) {
                continue;
            }

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

            breakupMethodChain(callStack, variables, block, methodChain, statement);
        }

        return block;
    }

    /**
     * Gets rid of String + Text concats incase the String is just the empty String
     *
     * @param element The element in which some concats might have to be fixed
     */
    private void fixStringConcats(Element element) throws LookupException {
        for (InfixOperatorInvocation ioi : element.descendants(InfixOperatorInvocation.class)) {
            // args == right
            // target == left
            Type rightType = ioi.getActualParameters().get(0).getType();
            if (ioi.name().equals("+") &&
                    subtypeOf(rightType, TEXT) | subtypeOf(rightType, STRING)) {
                if (ioi.getTarget() instanceof Literal) {
                    Literal lit = (Literal) ioi.getTarget();
                    if (lit.text().isEmpty()) {
                        ioi.replaceWith(ioi.getActualParameters().get(0));
                    }
                }
            }
        }
    }

    private boolean subtypeOf(Type sub, String superType) throws LookupException {
        return subtypeOf(sub, new RegularType(superType));
    }

    private boolean subtypeOf(Type sub, Type superType) throws LookupException {
        for (Type t : sub.getSelfAndAllSuperTypesView()) {
            if (getName(t).equals(getName(superType))) {
                return true;
            }
        }

        return false;
    }

    private String getName(Type type) {
        String result = type.getFullyQualifiedName();
        if (result == null) {
            result = type.name();
        }

        return result;
    }

    private void breakupMethodChain(Stack<RegularMethodInvocation> callStack, Stack<Variable> variables, Block block, Element methodChain, Statement statement) throws LookupException {
        // Turn the methodchain into local variables, one by one
        while (!callStack.isEmpty()) {
            // Add the statement to the new block so that it can do lookups using the new block
            // Do so in the loop to be able to use the newly defined variables (otherwise they are defined after this
            // statement)
            block.addStatement(statement);
            RegularMethodInvocation call = callStack.pop();
            fixNestedMethod(call);

            // Make certain to call surround methods on the right targets
            for (NeioMethodInvocation n : call.descendants(NeioMethodInvocation.class)) {
                if (n.metadata(Constants.SURROUND) != null) {
                    if (n.getTarget() == null) {
                        NeioNameExpression expr = eFactory().createNeioNameExpression(lastElement);
                        n.setTarget(expr);
                        setThis(n, expr, variables);
                    }
                }
            }

            // Substitute 'this' by the last element
            for (ThisLiteral t : call.descendants(ThisLiteral.class)) {
                NeioNameExpression expr = eFactory().createNeioNameExpression(lastElement);
                t.replaceWith(expr);
                // Check if we're a methodcall
                /*if (expr.parent() != null) {
                    String prefix = getPrefix(((RegularMethodInvocation) expr.parent()), variables);
                    if (prefix != null) {
                        expr.replaceWith(eFactory().createNeioNameExpression(prefix));
                    }
                }*/
            }

            fixStringConcats(call);

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
            createAndAddLocalVar(returnType.name(), varName, clone, variables, block);
            // Don't forget to remove the old (non broken up) statement
            block.removeStatement(statement);
        }
    }

    private LocalVariableDeclarator createAndAddLocalVar(String typeName, String varName, Expression e, Stack<Variable> variables, Block block) {
        LocalVariableDeclarator lvd = oFactory().createLocalVariable(typeName, varName, e);
        variables.push(lvd.variableDeclarations().get(0).variable());
        lastElement = variables.peek().name();
        block.addStatement(lvd);

        return lvd;
    }

    /**
     * Switches out returnstatements for {@code appendContent} and calls {@code processCodeBlock}
     *
     * @param block     The block containing the processed statements
     * @param statement The statement we assume to be a code block
     * @param variables The stack of previously defined variables
     * @param loneCode  The block of loneCode, passed to be able to clear it if needed
     * @return {@code null} if the block was processed, {@code statement} if {@code statement} was not a Block
     * @throws LookupException
     */
    private Statement fixCodeBlock(Block block, Statement statement, Stack<Variable> variables, Block loneCode) throws LookupException {
        // Is statement a Block?
        if (getNearestElement(statement, Statement.class) != null) {
            block.addStatement(statement);
            Block blockStatement = (Block) statement;
            processCodeBlock(blockStatement, variables);
            if (statement.hasMetadata(Neio.LONE_CODE)) {
                if (statement.hasDescendant(ReturnStatement.class)) {
                    blockStatement = fixReturnStatement(blockStatement, variables);
                } else if (makeReturnable(blockStatement.statement(blockStatement.nbStatements() - 1))) {
                    blockStatement = fixReturnStatement(blockStatement, variables);
                }
                block.removeStatement(statement);
                block.addStatements((blockStatement.statements()));
                loneCode.clear();
            }
            // No further processing required
            return null;
        }

        // Process this statement further as it isn't a block
        return statement;
    }

    /**
     * Checks if the last statement in a lone code block is a return statement with missing return keyword
     *
     * @param statement The last statement in the block
     * @return True if a statement was made into a returnstatement
     */
    private boolean makeReturnable(Statement statement) {
        if (statement.metadata(ASSIGNMENT) == null) {
            Expression e = statement.nearestDescendants(Expression.class).get(0);
            Statement returnStatement = oFactory().createReturnStatement(e);
            statement.replaceWith(returnStatement);
            return true;
        }

        return false;
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
            Type type;
            if (!(e instanceof NameExpression) && (!(e instanceof MethodInvocation))) {
                System.err.println("You can only return Content in an inline code block, unknown expression: " + e.toString());
                return block;
            } else {
                try {
                    if (e instanceof NameExpression) {
                        lastElement = ((NameExpression) e).name();
                        type = e.getType();
                    } else {
                        // Check if we return Content
                        NormalMethod method = (NormalMethod) ((MethodInvocation) e).getElement();
                        type = method.returnType();
                        if (!subtypeOf(type, BASE_CLASS)) {
                            System.err.println("You can only return Content in an inline code block, unknown expression: " + e.toString());
                            return block;
                        }

                        createAndAddLocalVar(type.name(), getVarName(), (Expression) e.clone(), variables, block);
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

                    createAndAddLocalVar(type.name(), getVarName(), expr, variables, block);
                } catch (LookupException e1) {
                    System.err.println("Error while setting this on " + APPEND_CONTENT);
                }
            }
        }

        return block;
    }

    /**
     * Replaces occurrences of {@code this} in code blocks
     *
     * @param block     The block in which we have to do replacements
     * @param variables The stack of previous variables
     * @throws LookupException
     */
    private void processCodeBlock(Block block, Stack<Variable> variables) throws LookupException {
        if (lastElement == null) {
            throw new ChameleonProgrammerException("Code blocks are not allowed as the first element in a document!");
        }
        String newcomer = "";

        // Replace values of variable declarations that are 'this'
        for (LocalVariableDeclarator lvd : block.descendants(LocalVariableDeclarator.class)) {
            lvd.variableDeclarations().get(0).descendants(ThisLiteral.class).forEach(this::thisToNameExpression);
            variables.push(lvd.variableDeclarations().get(0).variable());
            newcomer = variables.peek().name();
        }

        for (Statement s : block.statements()) {
            // Modify lastElement
            for (AssignmentExpression as : s.descendants(AssignmentExpression.class)) {
                replaceThis(as.getValue(), variables);

                // There should only be 1, others have been replaced above
                List<ThisLiteral> thisLiterals = as.nearestDescendants(ThisLiteral.class);
                for (ThisLiteral t : thisLiterals) {
                    String varName = getVarName();

                    if (!as.nearestDescendants(RegularMethodInvocation.class).isEmpty()) {
                        // Create and add a new local variable (also sets lastElement)
                        Statement lvd = createAndAddLocalVar(as.getValue().getType().name(), varName, as.getValue(), variables, block);
                        lvd.setMetadata(new TagImpl(), ASSIGNMENT);
                        // Remove it from the block, it shouldn't be placed at the end
                        block.removeStatement(lvd);
                        // Add it at the right space
                        s.replaceWith(lvd);
                    }
                    // `this = name;`
                    else {
                        lastElement = ((NameExpression) as.getValue()).name();
                        block.removeStatement(s);
                        // Remove variables that are too new
                        while (!variables.isEmpty() && !variables.peek().name().equals(lastElement)) {
                            variables.pop();
                        }
                    }
                }
            }

            // Replace 'this' on self calls
            for (MethodInvocation e : s.descendants(MethodInvocation.class)) {
                if (e.getTarget() != null && e.getTarget() instanceof ThisLiteral) {
                    replaceThis(e, variables);
                }
            }

            // Replace all other 'this' (arguments,...)
            s.descendants(ThisLiteral.class).forEach(this::thisToNameExpression);
        }

        if (!lastElement.equals(newcomer)) {
            for (Variable var : variables) {
                if (var.name().equals(newcomer)) {
                    variables.remove(var);
                    break;
                }
            }
        }
    }

    /**
     * Replaces a ThisLiteral by the last expression
     *
     * @param replacee The thisLiteral to replace
     */
    private void thisToNameExpression(Expression replacee) {
        NameExpression replacer = eFactory().createNeioNameExpression(lastElement);
        replacee.replaceWith(replacer);
    }

    /**
     * Switches out ThisLiterals in an expression
     *
     * @param e         The expression containing ThisLiterals
     * @param variables The previous variables
     * @throws LookupException
     */
    private void replaceThis(Expression e, Stack<Variable> variables) throws LookupException {
        // Replace occurences of 'this' by the right variable
        List<ThisLiteral> descendants = e.descendants(ThisLiteral.class);
        for (Element replacee : descendants) {
            NameExpression replacer = eFactory().createNeioNameExpression(lastElement);
            replacee.replaceWith(replacer);

            RegularMethodInvocation mi = (RegularMethodInvocation) replacer.parent();
            // Am I the target of a method invocation?
            if (mi.getTarget().equals(replacer)) {
                setThis(mi, replacer, variables);
            }
        }
    }


    /**
     * Switches out a ThisLiteral with the right variable
     *
     * @param mi        The methodinvocation in which the literal occurs
     * @param replacee  The literal to replace
     * @param variables The previous variables
     * @throws LookupException
     */
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
            if (subtypeOf(var.getType(), type)) {
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
