// Generated from B:\Documents\GitHub\neio\neio\src\main\grammar\DocumentParser.g4 by ANTLR 4.2.2
package be.ugent.neio.parsing;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DocumentParser}.
 */
public interface DocumentParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link DocumentParser#sentence}.
	 * @param ctx the parse tree
	 */
	void enterSentence(@NotNull DocumentParser.SentenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link DocumentParser#sentence}.
	 * @param ctx the parse tree
	 */
	void exitSentence(@NotNull DocumentParser.SentenceContext ctx);

	/**
	 * Enter a parse tree produced by {@link DocumentParser#prefixCall}.
	 * @param ctx the parse tree
	 */
	void enterPrefixCall(@NotNull DocumentParser.PrefixCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link DocumentParser#prefixCall}.
	 * @param ctx the parse tree
	 */
	void exitPrefixCall(@NotNull DocumentParser.PrefixCallContext ctx);

	/**
	 * Enter a parse tree produced by {@link DocumentParser#document}.
	 * @param ctx the parse tree
	 */
	void enterDocument(@NotNull DocumentParser.DocumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link DocumentParser#document}.
	 * @param ctx the parse tree
	 */
	void exitDocument(@NotNull DocumentParser.DocumentContext ctx);

	/**
	 * Enter a parse tree produced by {@link DocumentParser#mnl}.
	 * @param ctx the parse tree
	 */
	void enterMnl(@NotNull DocumentParser.MnlContext ctx);
	/**
	 * Exit a parse tree produced by {@link DocumentParser#mnl}.
	 * @param ctx the parse tree
	 */
	void exitMnl(@NotNull DocumentParser.MnlContext ctx);

	/**
	 * Enter a parse tree produced by {@link DocumentParser#text}.
	 * @param ctx the parse tree
	 */
	void enterText(@NotNull DocumentParser.TextContext ctx);
	/**
	 * Exit a parse tree produced by {@link DocumentParser#text}.
	 * @param ctx the parse tree
	 */
	void exitText(@NotNull DocumentParser.TextContext ctx);

	/**
	 * Enter a parse tree produced by {@link DocumentParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(@NotNull DocumentParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link DocumentParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(@NotNull DocumentParser.BodyContext ctx);

	/**
	 * Enter a parse tree produced by {@link DocumentParser#postfixCall}.
	 * @param ctx the parse tree
	 */
	void enterPostfixCall(@NotNull DocumentParser.PostfixCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link DocumentParser#postfixCall}.
	 * @param ctx the parse tree
	 */
	void exitPostfixCall(@NotNull DocumentParser.PostfixCallContext ctx);

	/**
	 * Enter a parse tree produced by {@link DocumentParser#content}.
	 * @param ctx the parse tree
	 */
	void enterContent(@NotNull DocumentParser.ContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link DocumentParser#content}.
	 * @param ctx the parse tree
	 */
	void exitContent(@NotNull DocumentParser.ContentContext ctx);
}