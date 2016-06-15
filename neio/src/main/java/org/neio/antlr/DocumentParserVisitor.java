// Generated from B:\Documents\GitHub\neio\neio\src\main\grammar\DocumentParser.g4 by ANTLR 4.5
package org.neio.antlr;
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
	 * Visit a parse tree produced by the {@code prefixC}
	 * labeled alternative in {@link DocumentParser#content}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixC(DocumentParser.PrefixCContext ctx);
	/**
	 * Visit a parse tree produced by the {@code textC}
	 * labeled alternative in {@link DocumentParser#content}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextC(DocumentParser.TextCContext ctx);
	/**
	 * Visit a parse tree produced by the {@code scodeC}
	 * labeled alternative in {@link DocumentParser#content}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScodeC(DocumentParser.ScodeCContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lonecodeC}
	 * labeled alternative in {@link DocumentParser#content}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLonecodeC(DocumentParser.LonecodeCContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nlC}
	 * labeled alternative in {@link DocumentParser#content}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNlC(DocumentParser.NlCContext ctx);
	/**
	 * Visit a parse tree produced by {@link DocumentParser#prefixCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixCall(DocumentParser.PrefixCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link DocumentParser#cPrefixCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCPrefixCall(DocumentParser.CPrefixCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link DocumentParser#preMethodName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreMethodName(DocumentParser.PreMethodNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link DocumentParser#surroundCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSurroundCall(DocumentParser.SurroundCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link DocumentParser#text}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText(DocumentParser.TextContext ctx);
	/**
	 * Visit a parse tree produced by {@link DocumentParser#txt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTxt(DocumentParser.TxtContext ctx);
	/**
	 * Visit a parse tree produced by {@link DocumentParser#nl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNl(DocumentParser.NlContext ctx);
	/**
	 * Visit a parse tree produced by {@link DocumentParser#textWSpaces}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextWSpaces(DocumentParser.TextWSpacesContext ctx);
	/**
	 * Visit a parse tree produced by {@link DocumentParser#scode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScode(DocumentParser.ScodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DocumentParser#lonecode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLonecode(DocumentParser.LonecodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DocumentParser#inlinecode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInlinecode(DocumentParser.InlinecodeContext ctx);
}