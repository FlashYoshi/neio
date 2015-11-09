// Generated from NeioDocumentParser.g4 by ANTLR 4.5.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link NeioDocumentParser}.
 */
public interface NeioDocumentParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link NeioDocumentParser#document}.
	 * @param ctx the parse tree
	 */
	void enterDocument(NeioDocumentParser.DocumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeioDocumentParser#document}.
	 * @param ctx the parse tree
	 */
	void exitDocument(NeioDocumentParser.DocumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link NeioDocumentParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(NeioDocumentParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeioDocumentParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(NeioDocumentParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NeioDocumentParser#content}.
	 * @param ctx the parse tree
	 */
	void enterContent(NeioDocumentParser.ContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeioDocumentParser#content}.
	 * @param ctx the parse tree
	 */
	void exitContent(NeioDocumentParser.ContentContext ctx);
	/**
	 * Enter a parse tree produced by {@link NeioDocumentParser#prefixCall}.
	 * @param ctx the parse tree
	 */
	void enterPrefixCall(NeioDocumentParser.PrefixCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeioDocumentParser#prefixCall}.
	 * @param ctx the parse tree
	 */
	void exitPrefixCall(NeioDocumentParser.PrefixCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link NeioDocumentParser#text}.
	 * @param ctx the parse tree
	 */
	void enterText(NeioDocumentParser.TextContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeioDocumentParser#text}.
	 * @param ctx the parse tree
	 */
	void exitText(NeioDocumentParser.TextContext ctx);
	/**
	 * Enter a parse tree produced by {@link NeioDocumentParser#postfixCall}.
	 * @param ctx the parse tree
	 */
	void enterPostfixCall(NeioDocumentParser.PostfixCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeioDocumentParser#postfixCall}.
	 * @param ctx the parse tree
	 */
	void exitPostfixCall(NeioDocumentParser.PostfixCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link NeioDocumentParser#sentence}.
	 * @param ctx the parse tree
	 */
	void enterSentence(NeioDocumentParser.SentenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeioDocumentParser#sentence}.
	 * @param ctx the parse tree
	 */
	void exitSentence(NeioDocumentParser.SentenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link NeioDocumentParser#mnl}.
	 * @param ctx the parse tree
	 */
	void enterMnl(NeioDocumentParser.MnlContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeioDocumentParser#mnl}.
	 * @param ctx the parse tree
	 */
	void exitMnl(NeioDocumentParser.MnlContext ctx);
}