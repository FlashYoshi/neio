// Generated from B:\Documents\GitHub\neio\neio\src\main\grammar\ClassParser.g4 by ANTLR 4.2.2
package be.ugent.neio.parsing;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ClassParser}.
 */
public interface ClassParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ClassParser#interfaceBody}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceBody(@NotNull ClassParser.InterfaceBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#interfaceBody}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceBody(@NotNull ClassParser.InterfaceBodyContext ctx);

	/**
	 * Enter a parse tree produced by {@link ClassParser#extension}.
	 * @param ctx the parse tree
	 */
	void enterExtension(@NotNull ClassParser.ExtensionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#extension}.
	 * @param ctx the parse tree
	 */
	void exitExtension(@NotNull ClassParser.ExtensionContext ctx);

	/**
	 * Enter a parse tree produced by {@link ClassParser#chain}.
	 * @param ctx the parse tree
	 */
	void enterChain(@NotNull ClassParser.ChainContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#chain}.
	 * @param ctx the parse tree
	 */
	void exitChain(@NotNull ClassParser.ChainContext ctx);

	/**
	 * Enter a parse tree produced by {@link ClassParser#newAssignment}.
	 * @param ctx the parse tree
	 */
	void enterNewAssignment(@NotNull ClassParser.NewAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#newAssignment}.
	 * @param ctx the parse tree
	 */
	void exitNewAssignment(@NotNull ClassParser.NewAssignmentContext ctx);

	/**
	 * Enter a parse tree produced by {@link ClassParser#returnCall}.
	 * @param ctx the parse tree
	 */
	void enterReturnCall(@NotNull ClassParser.ReturnCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#returnCall}.
	 * @param ctx the parse tree
	 */
	void exitReturnCall(@NotNull ClassParser.ReturnCallContext ctx);

	/**
	 * Enter a parse tree produced by {@link ClassParser#fieldName}.
	 * @param ctx the parse tree
	 */
	void enterFieldName(@NotNull ClassParser.FieldNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#fieldName}.
	 * @param ctx the parse tree
	 */
	void exitFieldName(@NotNull ClassParser.FieldNameContext ctx);

	/**
	 * Enter a parse tree produced by {@link ClassParser#method}.
	 * @param ctx the parse tree
	 */
	void enterMethod(@NotNull ClassParser.MethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#method}.
	 * @param ctx the parse tree
	 */
	void exitMethod(@NotNull ClassParser.MethodContext ctx);

	/**
	 * Enter a parse tree produced by {@link ClassParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(@NotNull ClassParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(@NotNull ClassParser.DeclContext ctx);

	/**
	 * Enter a parse tree produced by {@link ClassParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(@NotNull ClassParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(@NotNull ClassParser.VarContext ctx);

	/**
	 * Enter a parse tree produced by {@link ClassParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(@NotNull ClassParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(@NotNull ClassParser.AssignmentContext ctx);

	/**
	 * Enter a parse tree produced by {@link ClassParser#document}.
	 * @param ctx the parse tree
	 */
	void enterDocument(@NotNull ClassParser.DocumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#document}.
	 * @param ctx the parse tree
	 */
	void exitDocument(@NotNull ClassParser.DocumentContext ctx);

	/**
	 * Enter a parse tree produced by {@link ClassParser#methodName}.
	 * @param ctx the parse tree
	 */
	void enterMethodName(@NotNull ClassParser.MethodNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#methodName}.
	 * @param ctx the parse tree
	 */
	void exitMethodName(@NotNull ClassParser.MethodNameContext ctx);

	/**
	 * Enter a parse tree produced by {@link ClassParser#thisChain}.
	 * @param ctx the parse tree
	 */
	void enterThisChain(@NotNull ClassParser.ThisChainContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#thisChain}.
	 * @param ctx the parse tree
	 */
	void exitThisChain(@NotNull ClassParser.ThisChainContext ctx);

	/**
	 * Enter a parse tree produced by {@link ClassParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(@NotNull ClassParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(@NotNull ClassParser.BodyContext ctx);

	/**
	 * Enter a parse tree produced by {@link ClassParser#newCall}.
	 * @param ctx the parse tree
	 */
	void enterNewCall(@NotNull ClassParser.NewCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#newCall}.
	 * @param ctx the parse tree
	 */
	void exitNewCall(@NotNull ClassParser.NewCallContext ctx);

	/**
	 * Enter a parse tree produced by {@link ClassParser#call}.
	 * @param ctx the parse tree
	 */
	void enterCall(@NotNull ClassParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#call}.
	 * @param ctx the parse tree
	 */
	void exitCall(@NotNull ClassParser.CallContext ctx);

	/**
	 * Enter a parse tree produced by {@link ClassParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(@NotNull ClassParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(@NotNull ClassParser.FieldContext ctx);

	/**
	 * Enter a parse tree produced by {@link ClassParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(@NotNull ClassParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(@NotNull ClassParser.ParameterContext ctx);

	/**
	 * Enter a parse tree produced by {@link ClassParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(@NotNull ClassParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(@NotNull ClassParser.StatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link ClassParser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(@NotNull ClassParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(@NotNull ClassParser.ClassBodyContext ctx);

	/**
	 * Enter a parse tree produced by {@link ClassParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(@NotNull ClassParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(@NotNull ClassParser.ArgumentsContext ctx);

	/**
	 * Enter a parse tree produced by {@link ClassParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(@NotNull ClassParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(@NotNull ClassParser.BlockContext ctx);

	/**
	 * Enter a parse tree produced by {@link ClassParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(@NotNull ClassParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(@NotNull ClassParser.ParametersContext ctx);

	/**
	 * Enter a parse tree produced by {@link ClassParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void enterMethodCall(@NotNull ClassParser.MethodCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void exitMethodCall(@NotNull ClassParser.MethodCallContext ctx);
}