// Generated from B:\Documents\GitHub\Thesis\thesis\src\main\grammar\ThesisClassParser.g4 by ANTLR 4.2.2
package be.ugent.thesis.parsing;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ThesisClassParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ThesisClassParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ThesisClassParser#interfaceBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceBody(@NotNull ThesisClassParser.InterfaceBodyContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisClassParser#extension}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtension(@NotNull ThesisClassParser.ExtensionContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisClassParser#chain}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChain(@NotNull ThesisClassParser.ChainContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisClassParser#returnCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnCall(@NotNull ThesisClassParser.ReturnCallContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisClassParser#fieldName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldName(@NotNull ThesisClassParser.FieldNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisClassParser#method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod(@NotNull ThesisClassParser.MethodContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisClassParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(@NotNull ThesisClassParser.DeclContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisClassParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(@NotNull ThesisClassParser.VarContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisClassParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(@NotNull ThesisClassParser.AssignmentContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisClassParser#document}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDocument(@NotNull ThesisClassParser.DocumentContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisClassParser#methodName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodName(@NotNull ThesisClassParser.MethodNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisClassParser#thisChain}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThisChain(@NotNull ThesisClassParser.ThisChainContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisClassParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(@NotNull ThesisClassParser.BodyContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisClassParser#newCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewCall(@NotNull ThesisClassParser.NewCallContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisClassParser#call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall(@NotNull ThesisClassParser.CallContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisClassParser#field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField(@NotNull ThesisClassParser.FieldContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisClassParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(@NotNull ThesisClassParser.ParameterContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisClassParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(@NotNull ThesisClassParser.StatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisClassParser#classBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(@NotNull ThesisClassParser.ClassBodyContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisClassParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(@NotNull ThesisClassParser.ArgumentsContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisClassParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(@NotNull ThesisClassParser.BlockContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisClassParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(@NotNull ThesisClassParser.ParametersContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisClassParser#methodCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCall(@NotNull ThesisClassParser.MethodCallContext ctx);
}