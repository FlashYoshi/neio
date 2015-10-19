// Generated from Document.g4 by ANTLR 4.5.1
package be.ugent.thesis.parsing;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DocumentParser}.
 */
public interface DocumentListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link DocumentParser#section}.
	 * @param ctx the parse tree
	 */
	void enterSection(DocumentParser.SectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DocumentParser#section}.
	 * @param ctx the parse tree
	 */
	void exitSection(DocumentParser.SectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DocumentParser#paragraph}.
	 * @param ctx the parse tree
	 */
	void enterParagraph(DocumentParser.ParagraphContext ctx);
	/**
	 * Exit a parse tree produced by {@link DocumentParser#paragraph}.
	 * @param ctx the parse tree
	 */
	void exitParagraph(DocumentParser.ParagraphContext ctx);
}