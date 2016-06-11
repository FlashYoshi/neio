// Generated from B:\Documents\GitHub\neio\neio\src\main\grammar\DocumentParser.g4 by ANTLR 4.5
package org.neio.antlr;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DocumentParser}.
 */
public interface DocumentParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link DocumentParser#document}.
	 * @param ctx the parse tree
	 */
	void enterDocument(DocumentParser.DocumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link DocumentParser#document}.
	 * @param ctx the parse tree
	 */
	void exitDocument(DocumentParser.DocumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link DocumentParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(DocumentParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link DocumentParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(DocumentParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code prefixC}
	 * labeled alternative in {@link DocumentParser#content}.
	 * @param ctx the parse tree
	 */
	void enterPrefixC(DocumentParser.PrefixCContext ctx);
	/**
	 * Exit a parse tree produced by the {@code prefixC}
	 * labeled alternative in {@link DocumentParser#content}.
	 * @param ctx the parse tree
	 */
	void exitPrefixC(DocumentParser.PrefixCContext ctx);
	/**
	 * Enter a parse tree produced by the {@code textC}
	 * labeled alternative in {@link DocumentParser#content}.
	 * @param ctx the parse tree
	 */
	void enterTextC(DocumentParser.TextCContext ctx);
	/**
	 * Exit a parse tree produced by the {@code textC}
	 * labeled alternative in {@link DocumentParser#content}.
	 * @param ctx the parse tree
	 */
	void exitTextC(DocumentParser.TextCContext ctx);
	/**
	 * Enter a parse tree produced by the {@code scodeC}
	 * labeled alternative in {@link DocumentParser#content}.
	 * @param ctx the parse tree
	 */
	void enterScodeC(DocumentParser.ScodeCContext ctx);
	/**
	 * Exit a parse tree produced by the {@code scodeC}
	 * labeled alternative in {@link DocumentParser#content}.
	 * @param ctx the parse tree
	 */
	void exitScodeC(DocumentParser.ScodeCContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lonecodeC}
	 * labeled alternative in {@link DocumentParser#content}.
	 * @param ctx the parse tree
	 */
	void enterLonecodeC(DocumentParser.LonecodeCContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lonecodeC}
	 * labeled alternative in {@link DocumentParser#content}.
	 * @param ctx the parse tree
	 */
	void exitLonecodeC(DocumentParser.LonecodeCContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nlC}
	 * labeled alternative in {@link DocumentParser#content}.
	 * @param ctx the parse tree
	 */
	void enterNlC(DocumentParser.NlCContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nlC}
	 * labeled alternative in {@link DocumentParser#content}.
	 * @param ctx the parse tree
	 */
	void exitNlC(DocumentParser.NlCContext ctx);
	/**
	 * Enter a parse tree produced by {@link DocumentParser#prefixCall}.
	 * @param ctx the parse tree
	 */
	void enterPrefixCall(DocumentParser.PrefixCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link DocumentParser#prefixCall}.
	 * @param ctx the parse tree
	 */
	void exitPrefixCall(DocumentParser.PrefixCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link DocumentParser#cPrefixCall}.
	 * @param ctx the parse tree
	 */
	void enterCPrefixCall(DocumentParser.CPrefixCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link DocumentParser#cPrefixCall}.
	 * @param ctx the parse tree
	 */
	void exitCPrefixCall(DocumentParser.CPrefixCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link DocumentParser#preMethodName}.
	 * @param ctx the parse tree
	 */
	void enterPreMethodName(DocumentParser.PreMethodNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link DocumentParser#preMethodName}.
	 * @param ctx the parse tree
	 */
	void exitPreMethodName(DocumentParser.PreMethodNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link DocumentParser#surroundCall}.
	 * @param ctx the parse tree
	 */
	void enterSurroundCall(DocumentParser.SurroundCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link DocumentParser#surroundCall}.
	 * @param ctx the parse tree
	 */
	void exitSurroundCall(DocumentParser.SurroundCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link DocumentParser#text}.
	 * @param ctx the parse tree
	 */
	void enterText(DocumentParser.TextContext ctx);
	/**
	 * Exit a parse tree produced by {@link DocumentParser#text}.
	 * @param ctx the parse tree
	 */
	void exitText(DocumentParser.TextContext ctx);
	/**
	 * Enter a parse tree produced by {@link DocumentParser#txt}.
	 * @param ctx the parse tree
	 */
	void enterTxt(DocumentParser.TxtContext ctx);
	/**
	 * Exit a parse tree produced by {@link DocumentParser#txt}.
	 * @param ctx the parse tree
	 */
	void exitTxt(DocumentParser.TxtContext ctx);
	/**
	 * Enter a parse tree produced by {@link DocumentParser#nl}.
	 * @param ctx the parse tree
	 */
	void enterNl(DocumentParser.NlContext ctx);
	/**
	 * Exit a parse tree produced by {@link DocumentParser#nl}.
	 * @param ctx the parse tree
	 */
	void exitNl(DocumentParser.NlContext ctx);
	/**
	 * Enter a parse tree produced by {@link DocumentParser#textWSpaces}.
	 * @param ctx the parse tree
	 */
	void enterTextWSpaces(DocumentParser.TextWSpacesContext ctx);
	/**
	 * Exit a parse tree produced by {@link DocumentParser#textWSpaces}.
	 * @param ctx the parse tree
	 */
	void exitTextWSpaces(DocumentParser.TextWSpacesContext ctx);
	/**
	 * Enter a parse tree produced by {@link DocumentParser#scode}.
	 * @param ctx the parse tree
	 */
	void enterScode(DocumentParser.ScodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DocumentParser#scode}.
	 * @param ctx the parse tree
	 */
	void exitScode(DocumentParser.ScodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DocumentParser#lonecode}.
	 * @param ctx the parse tree
	 */
	void enterLonecode(DocumentParser.LonecodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DocumentParser#lonecode}.
	 * @param ctx the parse tree
	 */
	void exitLonecode(DocumentParser.LonecodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DocumentParser#inlinecode}.
	 * @param ctx the parse tree
	 */
	void enterInlinecode(DocumentParser.InlinecodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DocumentParser#inlinecode}.
	 * @param ctx the parse tree
	 */
	void exitInlinecode(DocumentParser.InlinecodeContext ctx);
}