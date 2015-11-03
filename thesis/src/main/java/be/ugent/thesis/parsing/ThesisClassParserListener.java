// Generated from B:\Documents\GitHub\Thesis\thesis\src\main\grammar\ThesisClassParser.g4 by ANTLR 4.2.2
package be.ugent.thesis.parsing;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ThesisClassParser}.
 */
public interface ThesisClassParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ThesisClassParser#interfaceBody}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceBody(@NotNull ThesisClassParser.InterfaceBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisClassParser#interfaceBody}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceBody(@NotNull ThesisClassParser.InterfaceBodyContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisClassParser#extension}.
	 * @param ctx the parse tree
	 */
	void enterExtension(@NotNull ThesisClassParser.ExtensionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisClassParser#extension}.
	 * @param ctx the parse tree
	 */
	void exitExtension(@NotNull ThesisClassParser.ExtensionContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisClassParser#chain}.
	 * @param ctx the parse tree
	 */
	void enterChain(@NotNull ThesisClassParser.ChainContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisClassParser#chain}.
	 * @param ctx the parse tree
	 */
	void exitChain(@NotNull ThesisClassParser.ChainContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisClassParser#returnCall}.
	 * @param ctx the parse tree
	 */
	void enterReturnCall(@NotNull ThesisClassParser.ReturnCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisClassParser#returnCall}.
	 * @param ctx the parse tree
	 */
	void exitReturnCall(@NotNull ThesisClassParser.ReturnCallContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisClassParser#fieldName}.
	 * @param ctx the parse tree
	 */
	void enterFieldName(@NotNull ThesisClassParser.FieldNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisClassParser#fieldName}.
	 * @param ctx the parse tree
	 */
	void exitFieldName(@NotNull ThesisClassParser.FieldNameContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisClassParser#method}.
	 * @param ctx the parse tree
	 */
	void enterMethod(@NotNull ThesisClassParser.MethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisClassParser#method}.
	 * @param ctx the parse tree
	 */
	void exitMethod(@NotNull ThesisClassParser.MethodContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisClassParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(@NotNull ThesisClassParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisClassParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(@NotNull ThesisClassParser.DeclContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisClassParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(@NotNull ThesisClassParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisClassParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(@NotNull ThesisClassParser.VarContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisClassParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(@NotNull ThesisClassParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisClassParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(@NotNull ThesisClassParser.AssignmentContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisClassParser#document}.
	 * @param ctx the parse tree
	 */
	void enterDocument(@NotNull ThesisClassParser.DocumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisClassParser#document}.
	 * @param ctx the parse tree
	 */
	void exitDocument(@NotNull ThesisClassParser.DocumentContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisClassParser#scriptBody}.
	 * @param ctx the parse tree
	 */
	void enterScriptBody(@NotNull ThesisClassParser.ScriptBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisClassParser#scriptBody}.
	 * @param ctx the parse tree
	 */
	void exitScriptBody(@NotNull ThesisClassParser.ScriptBodyContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisClassParser#methodName}.
	 * @param ctx the parse tree
	 */
	void enterMethodName(@NotNull ThesisClassParser.MethodNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisClassParser#methodName}.
	 * @param ctx the parse tree
	 */
	void exitMethodName(@NotNull ThesisClassParser.MethodNameContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisClassParser#thisChain}.
	 * @param ctx the parse tree
	 */
	void enterThisChain(@NotNull ThesisClassParser.ThisChainContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisClassParser#thisChain}.
	 * @param ctx the parse tree
	 */
	void exitThisChain(@NotNull ThesisClassParser.ThisChainContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisClassParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(@NotNull ThesisClassParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisClassParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(@NotNull ThesisClassParser.BodyContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisClassParser#newCall}.
	 * @param ctx the parse tree
	 */
	void enterNewCall(@NotNull ThesisClassParser.NewCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisClassParser#newCall}.
	 * @param ctx the parse tree
	 */
	void exitNewCall(@NotNull ThesisClassParser.NewCallContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisClassParser#call}.
	 * @param ctx the parse tree
	 */
	void enterCall(@NotNull ThesisClassParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisClassParser#call}.
	 * @param ctx the parse tree
	 */
	void exitCall(@NotNull ThesisClassParser.CallContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisClassParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(@NotNull ThesisClassParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisClassParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(@NotNull ThesisClassParser.FieldContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisClassParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(@NotNull ThesisClassParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisClassParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(@NotNull ThesisClassParser.ParameterContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisClassParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(@NotNull ThesisClassParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisClassParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(@NotNull ThesisClassParser.StatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisClassParser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(@NotNull ThesisClassParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisClassParser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(@NotNull ThesisClassParser.ClassBodyContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisClassParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(@NotNull ThesisClassParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisClassParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(@NotNull ThesisClassParser.ArgumentsContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisClassParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(@NotNull ThesisClassParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisClassParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(@NotNull ThesisClassParser.BlockContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisClassParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(@NotNull ThesisClassParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisClassParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(@NotNull ThesisClassParser.ParametersContext ctx);

	/**
	 * Enter a parse tree produced by {@link ThesisClassParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void enterMethodCall(@NotNull ThesisClassParser.MethodCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThesisClassParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void exitMethodCall(@NotNull ThesisClassParser.MethodCallContext ctx);
}