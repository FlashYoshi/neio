// Generated from B:\Documents\GitHub\Thesis\thesis\src\main\grammar\ThesisScriptParser.g4 by ANTLR 4.2.2
package be.ugent.neio.parsing;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ThesisScriptParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ThesisScriptParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ThesisScriptParser#chain}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChain(@NotNull ThesisScriptParser.ChainContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisScriptParser#fieldName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldName(@NotNull ThesisScriptParser.FieldNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisScriptParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(@NotNull ThesisScriptParser.AssignmentContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisScriptParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(@NotNull ThesisScriptParser.VarContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisScriptParser#document}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDocument(@NotNull ThesisScriptParser.DocumentContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisScriptParser#scriptBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScriptBody(@NotNull ThesisScriptParser.ScriptBodyContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisScriptParser#methodName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodName(@NotNull ThesisScriptParser.MethodNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisScriptParser#newCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewCall(@NotNull ThesisScriptParser.NewCallContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisScriptParser#call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall(@NotNull ThesisScriptParser.CallContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisScriptParser#field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField(@NotNull ThesisScriptParser.FieldContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisScriptParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(@NotNull ThesisScriptParser.ParameterContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisScriptParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(@NotNull ThesisScriptParser.StatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisScriptParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(@NotNull ThesisScriptParser.ArgumentsContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisScriptParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(@NotNull ThesisScriptParser.ParametersContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisScriptParser#methodCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCall(@NotNull ThesisScriptParser.MethodCallContext ctx);
}