// Generated from B:\Documents\GitHub\Thesis\thesis\src\main\grammar\ThesisParser.g4 by ANTLR 4.2.2
package be.ugent.thesis.parsing;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ThesisParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ThesisParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ThesisParser#interfaceBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceBody(@NotNull ThesisParser.InterfaceBodyContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisParser#extension}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtension(@NotNull ThesisParser.ExtensionContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisParser#chain}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChain(@NotNull ThesisParser.ChainContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisParser#returnCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnCall(@NotNull ThesisParser.ReturnCallContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisParser#fieldName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldName(@NotNull ThesisParser.FieldNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisParser#method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod(@NotNull ThesisParser.MethodContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(@NotNull ThesisParser.DeclContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(@NotNull ThesisParser.VarContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(@NotNull ThesisParser.AssignmentContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisParser#document}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDocument(@NotNull ThesisParser.DocumentContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisParser#scriptBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScriptBody(@NotNull ThesisParser.ScriptBodyContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisParser#methodName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodName(@NotNull ThesisParser.MethodNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisParser#thisChain}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThisChain(@NotNull ThesisParser.ThisChainContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(@NotNull ThesisParser.BodyContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisParser#newCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewCall(@NotNull ThesisParser.NewCallContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisParser#call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall(@NotNull ThesisParser.CallContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisParser#field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField(@NotNull ThesisParser.FieldContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(@NotNull ThesisParser.ParameterContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(@NotNull ThesisParser.StatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisParser#classBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(@NotNull ThesisParser.ClassBodyContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(@NotNull ThesisParser.ArgumentsContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(@NotNull ThesisParser.BlockContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(@NotNull ThesisParser.ParametersContext ctx);

	/**
	 * Visit a parse tree produced by {@link ThesisParser#methodCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCall(@NotNull ThesisParser.MethodCallContext ctx);
}