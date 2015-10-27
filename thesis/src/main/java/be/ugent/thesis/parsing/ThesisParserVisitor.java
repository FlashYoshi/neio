// Generated from ThesisParser.g4 by ANTLR 4.5.1
package be.ugent.thesis.parsing;
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
	 * Visit a parse tree produced by {@link ThesisParser#document}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDocument(ThesisParser.DocumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThesisParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(ThesisParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThesisParser#classBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(ThesisParser.ClassBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThesisParser#interfaceBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceBody(ThesisParser.InterfaceBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThesisParser#scriptBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScriptBody(ThesisParser.ScriptBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThesisParser#extension}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtension(ThesisParser.ExtensionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThesisParser#field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField(ThesisParser.FieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThesisParser#method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod(ThesisParser.MethodContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThesisParser#call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall(ThesisParser.CallContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThesisParser#methodName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodName(ThesisParser.MethodNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThesisParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(ThesisParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThesisParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(ThesisParser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThesisParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(ThesisParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThesisParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(ThesisParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThesisParser#methodCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCall(ThesisParser.MethodCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThesisParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(ThesisParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThesisParser#newCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewCall(ThesisParser.NewCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThesisParser#returnCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnCall(ThesisParser.ReturnCallContext ctx);
}