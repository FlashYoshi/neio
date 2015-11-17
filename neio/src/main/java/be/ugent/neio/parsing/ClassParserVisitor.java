// Generated from /home/flash/Github/neio/neio/src/main/grammar/ClassParser.g4 by ANTLR 4.2.2
package be.ugent.neio.parsing;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ClassParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ClassParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ClassParser#interfaceBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceBody(@NotNull ClassParser.InterfaceBodyContext ctx);

	/**
	 * Visit a parse tree produced by {@link ClassParser#extension}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtension(@NotNull ClassParser.ExtensionContext ctx);

	/**
	 * Visit a parse tree produced by {@link ClassParser#chain}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChain(@NotNull ClassParser.ChainContext ctx);

	/**
	 * Visit a parse tree produced by {@link ClassParser#newAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewAssignment(@NotNull ClassParser.NewAssignmentContext ctx);

	/**
	 * Visit a parse tree produced by {@link ClassParser#returnCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnCall(@NotNull ClassParser.ReturnCallContext ctx);

	/**
	 * Visit a parse tree produced by {@link ClassParser#fieldName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldName(@NotNull ClassParser.FieldNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link ClassParser#method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod(@NotNull ClassParser.MethodContext ctx);

	/**
	 * Visit a parse tree produced by {@link ClassParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(@NotNull ClassParser.DeclContext ctx);

	/**
	 * Visit a parse tree produced by {@link ClassParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(@NotNull ClassParser.VarContext ctx);

	/**
	 * Visit a parse tree produced by {@link ClassParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(@NotNull ClassParser.AssignmentContext ctx);

	/**
	 * Visit a parse tree produced by {@link ClassParser#document}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDocument(@NotNull ClassParser.DocumentContext ctx);

	/**
	 * Visit a parse tree produced by {@link ClassParser#methodName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodName(@NotNull ClassParser.MethodNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link ClassParser#thisChain}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThisChain(@NotNull ClassParser.ThisChainContext ctx);

	/**
	 * Visit a parse tree produced by {@link ClassParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(@NotNull ClassParser.BodyContext ctx);

	/**
	 * Visit a parse tree produced by {@link ClassParser#newCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewCall(@NotNull ClassParser.NewCallContext ctx);

	/**
	 * Visit a parse tree produced by {@link ClassParser#call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall(@NotNull ClassParser.CallContext ctx);

	/**
	 * Visit a parse tree produced by {@link ClassParser#field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField(@NotNull ClassParser.FieldContext ctx);

	/**
	 * Visit a parse tree produced by {@link ClassParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(@NotNull ClassParser.ParameterContext ctx);

	/**
	 * Visit a parse tree produced by {@link ClassParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(@NotNull ClassParser.StatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link ClassParser#classBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(@NotNull ClassParser.ClassBodyContext ctx);

	/**
	 * Visit a parse tree produced by {@link ClassParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(@NotNull ClassParser.ArgumentsContext ctx);

	/**
	 * Visit a parse tree produced by {@link ClassParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(@NotNull ClassParser.BlockContext ctx);

	/**
	 * Visit a parse tree produced by {@link ClassParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(@NotNull ClassParser.ParametersContext ctx);

	/**
	 * Visit a parse tree produced by {@link ClassParser#methodCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCall(@NotNull ClassParser.MethodCallContext ctx);
}