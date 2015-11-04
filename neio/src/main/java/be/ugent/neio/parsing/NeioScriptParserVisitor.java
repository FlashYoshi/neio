// Generated from /home/flash/Github/neio/neio/src/main/grammar/NeioScriptParser.g4 by ANTLR 4.2.2
package be.ugent.neio.parsing;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link NeioScriptParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface NeioScriptParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link NeioScriptParser#chain}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChain(@NotNull NeioScriptParser.ChainContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeioScriptParser#fieldName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldName(@NotNull NeioScriptParser.FieldNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeioScriptParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(@NotNull NeioScriptParser.AssignmentContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeioScriptParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(@NotNull NeioScriptParser.VarContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeioScriptParser#document}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDocument(@NotNull NeioScriptParser.DocumentContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeioScriptParser#scriptBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScriptBody(@NotNull NeioScriptParser.ScriptBodyContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeioScriptParser#methodName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodName(@NotNull NeioScriptParser.MethodNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeioScriptParser#newCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewCall(@NotNull NeioScriptParser.NewCallContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeioScriptParser#call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall(@NotNull NeioScriptParser.CallContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeioScriptParser#field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField(@NotNull NeioScriptParser.FieldContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeioScriptParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(@NotNull NeioScriptParser.ParameterContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeioScriptParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(@NotNull NeioScriptParser.StatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeioScriptParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(@NotNull NeioScriptParser.ArgumentsContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeioScriptParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(@NotNull NeioScriptParser.ParametersContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeioScriptParser#methodCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCall(@NotNull NeioScriptParser.MethodCallContext ctx);
}