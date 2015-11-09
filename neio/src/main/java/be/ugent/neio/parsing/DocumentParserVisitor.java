// Generated from B:\Documents\GitHub\neio\neio\src\main\grammar\DocumentParser.g4 by ANTLR 4.2.2
package be.ugent.neio.parsing;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DocumentParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface DocumentParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link DocumentParser#sentence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentence(@NotNull DocumentParser.SentenceContext ctx);

	/**
	 * Visit a parse tree produced by {@link DocumentParser#prefixCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixCall(@NotNull DocumentParser.PrefixCallContext ctx);

	/**
	 * Visit a parse tree produced by {@link DocumentParser#document}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDocument(@NotNull DocumentParser.DocumentContext ctx);

	/**
	 * Visit a parse tree produced by {@link DocumentParser#mnl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMnl(@NotNull DocumentParser.MnlContext ctx);

	/**
	 * Visit a parse tree produced by {@link DocumentParser#text}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText(@NotNull DocumentParser.TextContext ctx);

	/**
	 * Visit a parse tree produced by {@link DocumentParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(@NotNull DocumentParser.BodyContext ctx);

	/**
	 * Visit a parse tree produced by {@link DocumentParser#postfixCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixCall(@NotNull DocumentParser.PostfixCallContext ctx);

	/**
	 * Visit a parse tree produced by {@link DocumentParser#content}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContent(@NotNull DocumentParser.ContentContext ctx);
}