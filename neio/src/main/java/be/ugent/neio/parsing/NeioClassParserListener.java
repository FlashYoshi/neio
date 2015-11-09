// Generated from B:\Documents\GitHub\neio\neio\src\main\grammar\NeioClassParser.g4 by ANTLR 4.2.2
package be.ugent.neio.parsing;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link NeioClassParser}.
 */
public interface NeioClassParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link NeioClassParser#interfaceBody}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceBody(@NotNull NeioClassParser.InterfaceBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeioClassParser#interfaceBody}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceBody(@NotNull NeioClassParser.InterfaceBodyContext ctx);

	/**
	 * Enter a parse tree produced by {@link NeioClassParser#extension}.
	 * @param ctx the parse tree
	 */
	void enterExtension(@NotNull NeioClassParser.ExtensionContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeioClassParser#extension}.
	 * @param ctx the parse tree
	 */
	void exitExtension(@NotNull NeioClassParser.ExtensionContext ctx);

	/**
	 * Enter a parse tree produced by {@link NeioClassParser#chain}.
	 * @param ctx the parse tree
	 */
	void enterChain(@NotNull NeioClassParser.ChainContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeioClassParser#chain}.
	 * @param ctx the parse tree
	 */
	void exitChain(@NotNull NeioClassParser.ChainContext ctx);

	/**
	 * Enter a parse tree produced by {@link NeioClassParser#returnCall}.
	 * @param ctx the parse tree
	 */
	void enterReturnCall(@NotNull NeioClassParser.ReturnCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeioClassParser#returnCall}.
	 * @param ctx the parse tree
	 */
	void exitReturnCall(@NotNull NeioClassParser.ReturnCallContext ctx);

	/**
	 * Enter a parse tree produced by {@link NeioClassParser#fieldName}.
	 * @param ctx the parse tree
	 */
	void enterFieldName(@NotNull NeioClassParser.FieldNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeioClassParser#fieldName}.
	 * @param ctx the parse tree
	 */
	void exitFieldName(@NotNull NeioClassParser.FieldNameContext ctx);

	/**
	 * Enter a parse tree produced by {@link NeioClassParser#method}.
	 * @param ctx the parse tree
	 */
	void enterMethod(@NotNull NeioClassParser.MethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeioClassParser#method}.
	 * @param ctx the parse tree
	 */
	void exitMethod(@NotNull NeioClassParser.MethodContext ctx);

	/**
	 * Enter a parse tree produced by {@link NeioClassParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(@NotNull NeioClassParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeioClassParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(@NotNull NeioClassParser.DeclContext ctx);

	/**
	 * Enter a parse tree produced by {@link NeioClassParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(@NotNull NeioClassParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeioClassParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(@NotNull NeioClassParser.VarContext ctx);

	/**
	 * Enter a parse tree produced by {@link NeioClassParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(@NotNull NeioClassParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeioClassParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(@NotNull NeioClassParser.AssignmentContext ctx);

	/**
	 * Enter a parse tree produced by {@link NeioClassParser#document}.
	 * @param ctx the parse tree
	 */
	void enterDocument(@NotNull NeioClassParser.DocumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeioClassParser#document}.
	 * @param ctx the parse tree
	 */
	void exitDocument(@NotNull NeioClassParser.DocumentContext ctx);

	/**
	 * Enter a parse tree produced by {@link NeioClassParser#methodName}.
	 * @param ctx the parse tree
	 */
	void enterMethodName(@NotNull NeioClassParser.MethodNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeioClassParser#methodName}.
	 * @param ctx the parse tree
	 */
	void exitMethodName(@NotNull NeioClassParser.MethodNameContext ctx);

	/**
	 * Enter a parse tree produced by {@link NeioClassParser#thisChain}.
	 * @param ctx the parse tree
	 */
	void enterThisChain(@NotNull NeioClassParser.ThisChainContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeioClassParser#thisChain}.
	 * @param ctx the parse tree
	 */
	void exitThisChain(@NotNull NeioClassParser.ThisChainContext ctx);

	/**
	 * Enter a parse tree produced by {@link NeioClassParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(@NotNull NeioClassParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeioClassParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(@NotNull NeioClassParser.BodyContext ctx);

	/**
	 * Enter a parse tree produced by {@link NeioClassParser#newCall}.
	 * @param ctx the parse tree
	 */
	void enterNewCall(@NotNull NeioClassParser.NewCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeioClassParser#newCall}.
	 * @param ctx the parse tree
	 */
	void exitNewCall(@NotNull NeioClassParser.NewCallContext ctx);

	/**
	 * Enter a parse tree produced by {@link NeioClassParser#call}.
	 * @param ctx the parse tree
	 */
	void enterCall(@NotNull NeioClassParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeioClassParser#call}.
	 * @param ctx the parse tree
	 */
	void exitCall(@NotNull NeioClassParser.CallContext ctx);

	/**
	 * Enter a parse tree produced by {@link NeioClassParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(@NotNull NeioClassParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeioClassParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(@NotNull NeioClassParser.FieldContext ctx);

	/**
	 * Enter a parse tree produced by {@link NeioClassParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(@NotNull NeioClassParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeioClassParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(@NotNull NeioClassParser.ParameterContext ctx);

	/**
	 * Enter a parse tree produced by {@link NeioClassParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(@NotNull NeioClassParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeioClassParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(@NotNull NeioClassParser.StatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link NeioClassParser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(@NotNull NeioClassParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeioClassParser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(@NotNull NeioClassParser.ClassBodyContext ctx);

	/**
	 * Enter a parse tree produced by {@link NeioClassParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(@NotNull NeioClassParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeioClassParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(@NotNull NeioClassParser.ArgumentsContext ctx);

	/**
	 * Enter a parse tree produced by {@link NeioClassParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(@NotNull NeioClassParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeioClassParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(@NotNull NeioClassParser.BlockContext ctx);

	/**
	 * Enter a parse tree produced by {@link NeioClassParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(@NotNull NeioClassParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeioClassParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(@NotNull NeioClassParser.ParametersContext ctx);

	/**
	 * Enter a parse tree produced by {@link NeioClassParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void enterMethodCall(@NotNull NeioClassParser.MethodCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeioClassParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void exitMethodCall(@NotNull NeioClassParser.MethodCallContext ctx);
}