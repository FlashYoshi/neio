// Generated from ClassParser.g4 by ANTLR 4.5.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ClassParser}.
 */
public interface ClassParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ClassParser#document}.
	 * @param ctx the parse tree
	 */
	void enterDocument(ClassParser.DocumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#document}.
	 * @param ctx the parse tree
	 */
	void exitDocument(ClassParser.DocumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link ClassParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(ClassParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(ClassParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ClassParser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(ClassParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(ClassParser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ClassParser#interfaceBody}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceBody(ClassParser.InterfaceBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#interfaceBody}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceBody(ClassParser.InterfaceBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ClassParser#extension}.
	 * @param ctx the parse tree
	 */
	void enterExtension(ClassParser.ExtensionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#extension}.
	 * @param ctx the parse tree
	 */
	void exitExtension(ClassParser.ExtensionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ClassParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(ClassParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(ClassParser.FieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link ClassParser#fieldName}.
	 * @param ctx the parse tree
	 */
	void enterFieldName(ClassParser.FieldNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#fieldName}.
	 * @param ctx the parse tree
	 */
	void exitFieldName(ClassParser.FieldNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ClassParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(ClassParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(ClassParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by {@link ClassParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(ClassParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(ClassParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ClassParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(ClassParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(ClassParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link ClassParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(ClassParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(ClassParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link ClassParser#method}.
	 * @param ctx the parse tree
	 */
	void enterMethod(ClassParser.MethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#method}.
	 * @param ctx the parse tree
	 */
	void exitMethod(ClassParser.MethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link ClassParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(ClassParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(ClassParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link ClassParser#call}.
	 * @param ctx the parse tree
	 */
	void enterCall(ClassParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#call}.
	 * @param ctx the parse tree
	 */
	void exitCall(ClassParser.CallContext ctx);
	/**
	 * Enter a parse tree produced by {@link ClassParser#methodName}.
	 * @param ctx the parse tree
	 */
	void enterMethodName(ClassParser.MethodNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#methodName}.
	 * @param ctx the parse tree
	 */
	void exitMethodName(ClassParser.MethodNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ClassParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(ClassParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(ClassParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ClassParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(ClassParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(ClassParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ClassParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void enterMethodCall(ClassParser.MethodCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void exitMethodCall(ClassParser.MethodCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link ClassParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(ClassParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(ClassParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link ClassParser#thisChain}.
	 * @param ctx the parse tree
	 */
	void enterThisChain(ClassParser.ThisChainContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#thisChain}.
	 * @param ctx the parse tree
	 */
	void exitThisChain(ClassParser.ThisChainContext ctx);
	/**
	 * Enter a parse tree produced by {@link ClassParser#chain}.
	 * @param ctx the parse tree
	 */
	void enterChain(ClassParser.ChainContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#chain}.
	 * @param ctx the parse tree
	 */
	void exitChain(ClassParser.ChainContext ctx);
	/**
	 * Enter a parse tree produced by {@link ClassParser#newAssignment}.
	 * @param ctx the parse tree
	 */
	void enterNewAssignment(ClassParser.NewAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#newAssignment}.
	 * @param ctx the parse tree
	 */
	void exitNewAssignment(ClassParser.NewAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link ClassParser#newCall}.
	 * @param ctx the parse tree
	 */
	void enterNewCall(ClassParser.NewCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#newCall}.
	 * @param ctx the parse tree
	 */
	void exitNewCall(ClassParser.NewCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link ClassParser#returnCall}.
	 * @param ctx the parse tree
	 */
	void enterReturnCall(ClassParser.ReturnCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#returnCall}.
	 * @param ctx the parse tree
	 */
	void exitReturnCall(ClassParser.ReturnCallContext ctx);
}