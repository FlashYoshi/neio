// Generated from B:\Documents\GitHub\Thesis\thesis\src\main\grammar\ThesisScriptParser.g4 by ANTLR 4.2.2
package be.ugent.neio.parsing;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ThesisScriptParser}.
 */
public interface ThesisScriptParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ThesisScriptParser#chain}.
	 * @param ctx the parse tree
	 */
	void enterChain(@NotNull ThesisScriptParser.ChainContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisScriptParser#chain}.
	 * @param ctx the parse tree
	 */
	void exitChain(@NotNull ThesisScriptParser.ChainContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisScriptParser#fieldName}.
	 * @param ctx the parse tree
	 */
	void enterFieldName(@NotNull ThesisScriptParser.FieldNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisScriptParser#fieldName}.
	 * @param ctx the parse tree
	 */
	void exitFieldName(@NotNull ThesisScriptParser.FieldNameContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisScriptParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(@NotNull ThesisScriptParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisScriptParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(@NotNull ThesisScriptParser.AssignmentContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisScriptParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(@NotNull ThesisScriptParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisScriptParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(@NotNull ThesisScriptParser.VarContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisScriptParser#document}.
	 * @param ctx the parse tree
	 */
	void enterDocument(@NotNull ThesisScriptParser.DocumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisScriptParser#document}.
	 * @param ctx the parse tree
	 */
	void exitDocument(@NotNull ThesisScriptParser.DocumentContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisScriptParser#scriptBody}.
	 * @param ctx the parse tree
	 */
	void enterScriptBody(@NotNull ThesisScriptParser.ScriptBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisScriptParser#scriptBody}.
	 * @param ctx the parse tree
	 */
	void exitScriptBody(@NotNull ThesisScriptParser.ScriptBodyContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisScriptParser#methodName}.
	 * @param ctx the parse tree
	 */
	void enterMethodName(@NotNull ThesisScriptParser.MethodNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisScriptParser#methodName}.
	 * @param ctx the parse tree
	 */
	void exitMethodName(@NotNull ThesisScriptParser.MethodNameContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisScriptParser#newCall}.
	 * @param ctx the parse tree
	 */
	void enterNewCall(@NotNull ThesisScriptParser.NewCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisScriptParser#newCall}.
	 * @param ctx the parse tree
	 */
	void exitNewCall(@NotNull ThesisScriptParser.NewCallContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisScriptParser#call}.
	 * @param ctx the parse tree
	 */
	void enterCall(@NotNull ThesisScriptParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisScriptParser#call}.
	 * @param ctx the parse tree
	 */
	void exitCall(@NotNull ThesisScriptParser.CallContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisScriptParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(@NotNull ThesisScriptParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisScriptParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(@NotNull ThesisScriptParser.FieldContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisScriptParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(@NotNull ThesisScriptParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisScriptParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(@NotNull ThesisScriptParser.ParameterContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(@NotNull ThesisScriptParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(@NotNull ThesisScriptParser.StatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisScriptParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(@NotNull ThesisScriptParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisScriptParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(@NotNull ThesisScriptParser.ArgumentsContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisScriptParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(@NotNull ThesisScriptParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisScriptParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(@NotNull ThesisScriptParser.ParametersContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisScriptParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void enterMethodCall(@NotNull ThesisScriptParser.MethodCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisScriptParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void exitMethodCall(@NotNull ThesisScriptParser.MethodCallContext ctx);
}