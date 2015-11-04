// Generated from /home/flash/Github/neio/neio/src/main/grammar/NeioScriptParser.g4 by ANTLR 4.2.2
package be.ugent.neio.parsing;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link NeioScriptParser}.
 */
public interface NeioScriptParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link NeioScriptParser#chain}.
	 * @param ctx the parse tree
	 */
	void enterChain(@NotNull NeioScriptParser.ChainContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeioScriptParser#chain}.
	 * @param ctx the parse tree
	 */
	void exitChain(@NotNull NeioScriptParser.ChainContext ctx);

	/**
	 * Enter a parse tree produced by {@link NeioScriptParser#fieldName}.
	 * @param ctx the parse tree
	 */
	void enterFieldName(@NotNull NeioScriptParser.FieldNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeioScriptParser#fieldName}.
	 * @param ctx the parse tree
	 */
	void exitFieldName(@NotNull NeioScriptParser.FieldNameContext ctx);

	/**
	 * Enter a parse tree produced by {@link NeioScriptParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(@NotNull NeioScriptParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeioScriptParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(@NotNull NeioScriptParser.AssignmentContext ctx);

	/**
	 * Enter a parse tree produced by {@link NeioScriptParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(@NotNull NeioScriptParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeioScriptParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(@NotNull NeioScriptParser.VarContext ctx);

	/**
	 * Enter a parse tree produced by {@link NeioScriptParser#document}.
	 * @param ctx the parse tree
	 */
	void enterDocument(@NotNull NeioScriptParser.DocumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeioScriptParser#document}.
	 * @param ctx the parse tree
	 */
	void exitDocument(@NotNull NeioScriptParser.DocumentContext ctx);

	/**
	 * Enter a parse tree produced by {@link NeioScriptParser#scriptBody}.
	 * @param ctx the parse tree
	 */
	void enterScriptBody(@NotNull NeioScriptParser.ScriptBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeioScriptParser#scriptBody}.
	 * @param ctx the parse tree
	 */
	void exitScriptBody(@NotNull NeioScriptParser.ScriptBodyContext ctx);

	/**
	 * Enter a parse tree produced by {@link NeioScriptParser#methodName}.
	 * @param ctx the parse tree
	 */
	void enterMethodName(@NotNull NeioScriptParser.MethodNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeioScriptParser#methodName}.
	 * @param ctx the parse tree
	 */
	void exitMethodName(@NotNull NeioScriptParser.MethodNameContext ctx);

	/**
	 * Enter a parse tree produced by {@link NeioScriptParser#newCall}.
	 * @param ctx the parse tree
	 */
	void enterNewCall(@NotNull NeioScriptParser.NewCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeioScriptParser#newCall}.
	 * @param ctx the parse tree
	 */
	void exitNewCall(@NotNull NeioScriptParser.NewCallContext ctx);

	/**
	 * Enter a parse tree produced by {@link NeioScriptParser#call}.
	 * @param ctx the parse tree
	 */
	void enterCall(@NotNull NeioScriptParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeioScriptParser#call}.
	 * @param ctx the parse tree
	 */
	void exitCall(@NotNull NeioScriptParser.CallContext ctx);

	/**
	 * Enter a parse tree produced by {@link NeioScriptParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(@NotNull NeioScriptParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeioScriptParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(@NotNull NeioScriptParser.FieldContext ctx);

	/**
	 * Enter a parse tree produced by {@link NeioScriptParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(@NotNull NeioScriptParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeioScriptParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(@NotNull NeioScriptParser.ParameterContext ctx);

	/**
	 * Enter a parse tree produced by {@link NeioScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(@NotNull NeioScriptParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeioScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(@NotNull NeioScriptParser.StatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link NeioScriptParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(@NotNull NeioScriptParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeioScriptParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(@NotNull NeioScriptParser.ArgumentsContext ctx);

	/**
	 * Enter a parse tree produced by {@link NeioScriptParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(@NotNull NeioScriptParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeioScriptParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(@NotNull NeioScriptParser.ParametersContext ctx);

	/**
	 * Enter a parse tree produced by {@link NeioScriptParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void enterMethodCall(@NotNull NeioScriptParser.MethodCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeioScriptParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void exitMethodCall(@NotNull NeioScriptParser.MethodCallContext ctx);
}