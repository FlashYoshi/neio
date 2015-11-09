// Generated from B:\Documents\GitHub\neio\neio\src\main\grammar\NeioDocumentParser.g4 by ANTLR 4.2.2
package be.ugent.neio.parsing;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link NeioDocumentParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface NeioDocumentParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link NeioDocumentParser#sentence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentence(@NotNull NeioDocumentParser.SentenceContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeioDocumentParser#prefixCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixCall(@NotNull NeioDocumentParser.PrefixCallContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeioDocumentParser#document}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDocument(@NotNull NeioDocumentParser.DocumentContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeioDocumentParser#mnl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMnl(@NotNull NeioDocumentParser.MnlContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeioDocumentParser#text}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText(@NotNull NeioDocumentParser.TextContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeioDocumentParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(@NotNull NeioDocumentParser.BodyContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeioDocumentParser#postfixCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixCall(@NotNull NeioDocumentParser.PostfixCallContext ctx);

	/**
	 * Visit a parse tree produced by {@link NeioDocumentParser#content}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContent(@NotNull NeioDocumentParser.ContentContext ctx);
}