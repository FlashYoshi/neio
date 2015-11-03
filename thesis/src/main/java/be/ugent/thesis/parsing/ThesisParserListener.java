// Generated from B:\Documents\GitHub\Thesis\thesis\src\main\grammar\ThesisParser.g4 by ANTLR 4.2.2
package be.ugent.thesis.parsing;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ThesisParser}.
 */
public interface ThesisParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ThesisParser#interfaceBody}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceBody(@NotNull ThesisParser.InterfaceBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisParser#interfaceBody}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceBody(@NotNull ThesisParser.InterfaceBodyContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisParser#extension}.
	 * @param ctx the parse tree
	 */
	void enterExtension(@NotNull ThesisParser.ExtensionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisParser#extension}.
	 * @param ctx the parse tree
	 */
	void exitExtension(@NotNull ThesisParser.ExtensionContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisParser#chain}.
	 * @param ctx the parse tree
	 */
	void enterChain(@NotNull ThesisParser.ChainContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisParser#chain}.
	 * @param ctx the parse tree
	 */
	void exitChain(@NotNull ThesisParser.ChainContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisParser#returnCall}.
	 * @param ctx the parse tree
	 */
	void enterReturnCall(@NotNull ThesisParser.ReturnCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisParser#returnCall}.
	 * @param ctx the parse tree
	 */
	void exitReturnCall(@NotNull ThesisParser.ReturnCallContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisParser#fieldName}.
	 * @param ctx the parse tree
	 */
	void enterFieldName(@NotNull ThesisParser.FieldNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisParser#fieldName}.
	 * @param ctx the parse tree
	 */
	void exitFieldName(@NotNull ThesisParser.FieldNameContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisParser#method}.
	 * @param ctx the parse tree
	 */
	void enterMethod(@NotNull ThesisParser.MethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisParser#method}.
	 * @param ctx the parse tree
	 */
	void exitMethod(@NotNull ThesisParser.MethodContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(@NotNull ThesisParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(@NotNull ThesisParser.DeclContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(@NotNull ThesisParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(@NotNull ThesisParser.VarContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(@NotNull ThesisParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(@NotNull ThesisParser.AssignmentContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisParser#document}.
	 * @param ctx the parse tree
	 */
	void enterDocument(@NotNull ThesisParser.DocumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisParser#document}.
	 * @param ctx the parse tree
	 */
	void exitDocument(@NotNull ThesisParser.DocumentContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisParser#scriptBody}.
	 * @param ctx the parse tree
	 */
	void enterScriptBody(@NotNull ThesisParser.ScriptBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisParser#scriptBody}.
	 * @param ctx the parse tree
	 */
	void exitScriptBody(@NotNull ThesisParser.ScriptBodyContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisParser#methodName}.
	 * @param ctx the parse tree
	 */
	void enterMethodName(@NotNull ThesisParser.MethodNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisParser#methodName}.
	 * @param ctx the parse tree
	 */
	void exitMethodName(@NotNull ThesisParser.MethodNameContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisParser#thisChain}.
	 * @param ctx the parse tree
	 */
	void enterThisChain(@NotNull ThesisParser.ThisChainContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisParser#thisChain}.
	 * @param ctx the parse tree
	 */
	void exitThisChain(@NotNull ThesisParser.ThisChainContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(@NotNull ThesisParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(@NotNull ThesisParser.BodyContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisParser#newCall}.
	 * @param ctx the parse tree
	 */
	void enterNewCall(@NotNull ThesisParser.NewCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisParser#newCall}.
	 * @param ctx the parse tree
	 */
	void exitNewCall(@NotNull ThesisParser.NewCallContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisParser#call}.
	 * @param ctx the parse tree
	 */
	void enterCall(@NotNull ThesisParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisParser#call}.
	 * @param ctx the parse tree
	 */
	void exitCall(@NotNull ThesisParser.CallContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(@NotNull ThesisParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(@NotNull ThesisParser.FieldContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(@NotNull ThesisParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(@NotNull ThesisParser.ParameterContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(@NotNull ThesisParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(@NotNull ThesisParser.StatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisParser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(@NotNull ThesisParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisParser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(@NotNull ThesisParser.ClassBodyContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(@NotNull ThesisParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(@NotNull ThesisParser.ArgumentsContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(@NotNull ThesisParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(@NotNull ThesisParser.BlockContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(@NotNull ThesisParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(@NotNull ThesisParser.ParametersContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void enterMethodCall(@NotNull ThesisParser.MethodCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void exitMethodCall(@NotNull ThesisParser.MethodCallContext ctx);
}