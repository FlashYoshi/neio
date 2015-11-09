// Generated from B:\Documents\GitHub\neio\neio\src\main\grammar\NeioClassParser.g4 by ANTLR 4.2.2
package be.ugent.neio.parsing;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link NeioClassParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface NeioClassParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link NeioClassParser#interfaceBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceBody(@NotNull NeioClassParser.InterfaceBodyContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeioClassParser#extension}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtension(@NotNull NeioClassParser.ExtensionContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeioClassParser#chain}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChain(@NotNull NeioClassParser.ChainContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeioClassParser#returnCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnCall(@NotNull NeioClassParser.ReturnCallContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeioClassParser#fieldName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldName(@NotNull NeioClassParser.FieldNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeioClassParser#method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod(@NotNull NeioClassParser.MethodContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeioClassParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(@NotNull NeioClassParser.DeclContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeioClassParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(@NotNull NeioClassParser.VarContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeioClassParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(@NotNull NeioClassParser.AssignmentContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeioClassParser#document}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDocument(@NotNull NeioClassParser.DocumentContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeioClassParser#methodName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodName(@NotNull NeioClassParser.MethodNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeioClassParser#thisChain}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThisChain(@NotNull NeioClassParser.ThisChainContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeioClassParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(@NotNull NeioClassParser.BodyContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeioClassParser#newCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewCall(@NotNull NeioClassParser.NewCallContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeioClassParser#call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall(@NotNull NeioClassParser.CallContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeioClassParser#field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField(@NotNull NeioClassParser.FieldContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeioClassParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(@NotNull NeioClassParser.ParameterContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeioClassParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(@NotNull NeioClassParser.StatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeioClassParser#classBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(@NotNull NeioClassParser.ClassBodyContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeioClassParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(@NotNull NeioClassParser.ArgumentsContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeioClassParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(@NotNull NeioClassParser.BlockContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeioClassParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(@NotNull NeioClassParser.ParametersContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeioClassParser#methodCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCall(@NotNull NeioClassParser.MethodCallContext ctx);
}