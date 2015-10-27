// Generated from ThesisParser.g4 by ANTLR 4.5.1
package be.ugent.thesis.parsing;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ThesisParser}.
 */
public interface ThesisParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ThesisParser#document}.
	 * @param ctx the parse tree
	 */
	void enterDocument(ThesisParser.DocumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisParser#document}.
	 * @param ctx the parse tree
	 */
	void exitDocument(ThesisParser.DocumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThesisParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(ThesisParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(ThesisParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThesisParser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(ThesisParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisParser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(ThesisParser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThesisParser#interfaceBody}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceBody(ThesisParser.InterfaceBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisParser#interfaceBody}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceBody(ThesisParser.InterfaceBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThesisParser#scriptBody}.
	 * @param ctx the parse tree
	 */
	void enterScriptBody(ThesisParser.ScriptBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisParser#scriptBody}.
	 * @param ctx the parse tree
	 */
	void exitScriptBody(ThesisParser.ScriptBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThesisParser#extension}.
	 * @param ctx the parse tree
	 */
	void enterExtension(ThesisParser.ExtensionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisParser#extension}.
	 * @param ctx the parse tree
	 */
	void exitExtension(ThesisParser.ExtensionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThesisParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(ThesisParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(ThesisParser.FieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThesisParser#fieldName}.
	 * @param ctx the parse tree
	 */
	void enterFieldName(ThesisParser.FieldNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisParser#fieldName}.
	 * @param ctx the parse tree
	 */
	void exitFieldName(ThesisParser.FieldNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThesisParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(ThesisParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(ThesisParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThesisParser#method}.
	 * @param ctx the parse tree
	 */
	void enterMethod(ThesisParser.MethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisParser#method}.
	 * @param ctx the parse tree
	 */
	void exitMethod(ThesisParser.MethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThesisParser#call}.
	 * @param ctx the parse tree
	 */
	void enterCall(ThesisParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisParser#call}.
	 * @param ctx the parse tree
	 */
	void exitCall(ThesisParser.CallContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThesisParser#methodName}.
	 * @param ctx the parse tree
	 */
	void enterMethodName(ThesisParser.MethodNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisParser#methodName}.
	 * @param ctx the parse tree
	 */
	void exitMethodName(ThesisParser.MethodNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThesisParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(ThesisParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(ThesisParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThesisParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(ThesisParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(ThesisParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThesisParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(ThesisParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(ThesisParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThesisParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void enterMethodCall(ThesisParser.MethodCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void exitMethodCall(ThesisParser.MethodCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThesisParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(ThesisParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(ThesisParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThesisParser#thisChain}.
	 * @param ctx the parse tree
	 */
	void enterThisChain(ThesisParser.ThisChainContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisParser#thisChain}.
	 * @param ctx the parse tree
	 */
	void exitThisChain(ThesisParser.ThisChainContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThesisParser#newCall}.
	 * @param ctx the parse tree
	 */
	void enterNewCall(ThesisParser.NewCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisParser#newCall}.
	 * @param ctx the parse tree
	 */
	void exitNewCall(ThesisParser.NewCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThesisParser#returnCall}.
	 * @param ctx the parse tree
	 */
	void enterReturnCall(ThesisParser.ReturnCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisParser#returnCall}.
	 * @param ctx the parse tree
	 */
	void exitReturnCall(ThesisParser.ReturnCallContext ctx);
}