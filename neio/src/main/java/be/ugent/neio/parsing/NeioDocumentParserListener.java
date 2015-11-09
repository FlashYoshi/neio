// Generated from B:\Documents\GitHub\neio\neio\src\main\grammar\NeioDocumentParser.g4 by ANTLR 4.2.2
package be.ugent.neio.parsing;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link NeioDocumentParser}.
 */
public interface NeioDocumentParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link NeioDocumentParser#sentence}.
	 * @param ctx the parse tree
	 */
	void enterSentence(@NotNull NeioDocumentParser.SentenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeioDocumentParser#sentence}.
	 * @param ctx the parse tree
	 */
	void exitSentence(@NotNull NeioDocumentParser.SentenceContext ctx);

	/**
	 * Enter a parse tree produced by {@link NeioDocumentParser#prefixCall}.
	 * @param ctx the parse tree
	 */
	void enterPrefixCall(@NotNull NeioDocumentParser.PrefixCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeioDocumentParser#prefixCall}.
	 * @param ctx the parse tree
	 */
	void exitPrefixCall(@NotNull NeioDocumentParser.PrefixCallContext ctx);

	/**
	 * Enter a parse tree produced by {@link NeioDocumentParser#document}.
	 * @param ctx the parse tree
	 */
	void enterDocument(@NotNull NeioDocumentParser.DocumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeioDocumentParser#document}.
	 * @param ctx the parse tree
	 */
	void exitDocument(@NotNull NeioDocumentParser.DocumentContext ctx);

	/**
	 * Enter a parse tree produced by {@link NeioDocumentParser#mnl}.
	 * @param ctx the parse tree
	 */
	void enterMnl(@NotNull NeioDocumentParser.MnlContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeioDocumentParser#mnl}.
	 * @param ctx the parse tree
	 */
	void exitMnl(@NotNull NeioDocumentParser.MnlContext ctx);

	/**
	 * Enter a parse tree produced by {@link NeioDocumentParser#text}.
	 * @param ctx the parse tree
	 */
	void enterText(@NotNull NeioDocumentParser.TextContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeioDocumentParser#text}.
	 * @param ctx the parse tree
	 */
	void exitText(@NotNull NeioDocumentParser.TextContext ctx);

	/**
	 * Enter a parse tree produced by {@link NeioDocumentParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(@NotNull NeioDocumentParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeioDocumentParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(@NotNull NeioDocumentParser.BodyContext ctx);

	/**
	 * Enter a parse tree produced by {@link NeioDocumentParser#postfixCall}.
	 * @param ctx the parse tree
	 */
	void enterPostfixCall(@NotNull NeioDocumentParser.PostfixCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeioDocumentParser#postfixCall}.
	 * @param ctx the parse tree
	 */
	void exitPostfixCall(@NotNull NeioDocumentParser.PostfixCallContext ctx);

	/**
	 * Enter a parse tree produced by {@link NeioDocumentParser#content}.
	 * @param ctx the parse tree
	 */
	void enterContent(@NotNull NeioDocumentParser.ContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeioDocumentParser#content}.
	 * @param ctx the parse tree
	 */
	void exitContent(@NotNull NeioDocumentParser.ContentContext ctx);
}