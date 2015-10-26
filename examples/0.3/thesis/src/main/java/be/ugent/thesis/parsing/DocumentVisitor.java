// Generated from Document.g4 by ANTLR 4.5.1
package be.ugent.thesis.parsing;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DocumentParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface DocumentVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link DocumentParser#document}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDocument(DocumentParser.DocumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link DocumentParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(DocumentParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link DocumentParser#section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSection(DocumentParser.SectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DocumentParser#paragraph}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParagraph(DocumentParser.ParagraphContext ctx);
}