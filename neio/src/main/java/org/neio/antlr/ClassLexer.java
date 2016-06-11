// Generated from B:\Documents\GitHub\neio\neio\src\main\grammar\ClassLexer.g4 by ANTLR 4.5
package org.neio.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ClassLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMENT=1, MULTILINE_COMMENT=2, WS=3, NAMESPACE=4, ABSTRACT=5, CLASS=6, 
		INTERFACE=7, EXTENDS=8, IMPLEMENTS=9, IMPORT=10, RETURN=11, NEW=12, THIS=13, 
		SUPER=14, PRIVATE=15, PROTECTED=16, PUBLIC=17, VOID=18, IF=19, ELSE=20, 
		FOR=21, WHILE=22, NESTED=23, SURROUND=24, FINAL=25, STATIC=26, TRUE=27, 
		FALSE=28, NULL=29, STUB=30, StringLiteral=31, CharLiteral=32, TextMode=33, 
		DOT=34, COMMA=35, COLON=36, SCOLON=37, EQUAL=38, NOT_EQUAL=39, AND=40, 
		AMPERSAND=41, OR=42, PIPE=43, EQUALS=44, INCR=45, PLUS=46, DECR=47, MINUS=48, 
		STAR=49, PERCENT=50, HAT=51, L_SHIFT=52, RR_SHIFT=53, R_SHIFT=54, LEQ=55, 
		SMALLER=56, GEQ=57, BIGGER=58, L_BRACE=59, R_BRACE=60, LC_BRACE=61, RC_BRACE=62, 
		LS_BRACE=63, RS_BRACE=64, D_QUOTE=65, TSQ=66, QUOTE=67, SLASH=68, B_SLASH=69, 
		Q_MARK=70, ARRAY=71, E_MARK=72, Double=73, Integer=74, Identifier=75, 
		MethodIdentifier=76;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"COMMENT", "MULTILINE_COMMENT", "WS", "NAMESPACE", "ABSTRACT", "CLASS", 
		"INTERFACE", "EXTENDS", "IMPLEMENTS", "IMPORT", "RETURN", "NEW", "THIS", 
		"SUPER", "PRIVATE", "PROTECTED", "PUBLIC", "VOID", "IF", "ELSE", "FOR", 
		"WHILE", "NESTED", "SURROUND", "FINAL", "STATIC", "TRUE", "FALSE", "NULL", 
		"STUB", "N_D_QUOTE", "StringLiteral", "N_QUOTE", "CharLiteral", "TextMode", 
		"DOT", "COMMA", "COLON", "SCOLON", "EQUAL", "NOT_EQUAL", "AND", "AMPERSAND", 
		"OR", "PIPE", "EQUALS", "INCR", "PLUS", "DECR", "MINUS", "STAR", "PERCENT", 
		"HAT", "L_SHIFT", "RR_SHIFT", "R_SHIFT", "LEQ", "SMALLER", "GEQ", "BIGGER", 
		"L_BRACE", "R_BRACE", "LC_BRACE", "RC_BRACE", "LS_BRACE", "RS_BRACE", 
		"D_QUOTE", "TSQ", "QUOTE", "SLASH", "B_SLASH", "Q_MARK", "ARRAY", "E_MARK", 
		"DIGIT", "LETTER", "UNDERSCORE", "DOLLAR", "CHAR", "Double", "Integer", 
		"Identifier", "MethodIdentifier"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, "'namespace'", "'abstract'", "'class'", "'interface'", 
		"'extends'", "'implements'", "'import'", "'return'", "'new'", "'this'", 
		"'super'", "'private'", "'protected'", "'public'", "'void'", "'if'", "'else'", 
		"'for'", "'while'", "'nested'", "'surround'", "'final'", "'static'", "'true'", 
		"'false'", "'null'", "'stub'", null, null, null, "'.'", "','", "':'", 
		"';'", "'=='", "'!='", "'&&'", "'&'", "'||'", "'|'", "'='", "'++'", "'+'", 
		"'--'", "'-'", "'*'", "'%'", "'^'", "'<<'", "'>>>'", "'>>'", "'<='", "'<'", 
		"'>='", "'>'", "'('", "')'", "'{'", "'}'", "'['", "']'", "'\"'", "'''''", 
		"'''", "'/'", "'\\'", "'?'", "'[]'", "'!'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "COMMENT", "MULTILINE_COMMENT", "WS", "NAMESPACE", "ABSTRACT", "CLASS", 
		"INTERFACE", "EXTENDS", "IMPLEMENTS", "IMPORT", "RETURN", "NEW", "THIS", 
		"SUPER", "PRIVATE", "PROTECTED", "PUBLIC", "VOID", "IF", "ELSE", "FOR", 
		"WHILE", "NESTED", "SURROUND", "FINAL", "STATIC", "TRUE", "FALSE", "NULL", 
		"STUB", "StringLiteral", "CharLiteral", "TextMode", "DOT", "COMMA", "COLON", 
		"SCOLON", "EQUAL", "NOT_EQUAL", "AND", "AMPERSAND", "OR", "PIPE", "EQUALS", 
		"INCR", "PLUS", "DECR", "MINUS", "STAR", "PERCENT", "HAT", "L_SHIFT", 
		"RR_SHIFT", "R_SHIFT", "LEQ", "SMALLER", "GEQ", "BIGGER", "L_BRACE", "R_BRACE", 
		"LC_BRACE", "RC_BRACE", "LS_BRACE", "RS_BRACE", "D_QUOTE", "TSQ", "QUOTE", 
		"SLASH", "B_SLASH", "Q_MARK", "ARRAY", "E_MARK", "Double", "Integer", 
		"Identifier", "MethodIdentifier"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public ClassLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ClassLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2N\u021f\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\3\2\3\2\3\2\3\2\7\2\u00ae\n\2\f\2\16\2\u00b1\13\2\3\2\3\2\3\3\3\3\3\3"+
		"\3\3\7\3\u00b9\n\3\f\3\16\3\u00bc\13\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4"+
		"\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23"+
		"\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26"+
		"\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37"+
		"\3\37\3 \3 \3 \3 \3 \5 \u0181\n \3!\3!\7!\u0185\n!\f!\16!\u0188\13!\3"+
		"!\3!\3\"\3\"\3\"\3\"\5\"\u0190\n\"\3#\3#\3#\3#\3$\3$\7$\u0198\n$\f$\16"+
		"$\u019b\13$\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3)\3*\3*\3*\3+\3+\3"+
		"+\3,\3,\3-\3-\3-\3.\3.\3/\3/\3\60\3\60\3\60\3\61\3\61\3\62\3\62\3\62\3"+
		"\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\3\67\38\38\38\38\39\3"+
		"9\39\3:\3:\3:\3;\3;\3<\3<\3<\3=\3=\3>\3>\3?\3?\3@\3@\3A\3A\3B\3B\3C\3"+
		"C\3D\3D\3E\3E\3E\3E\3F\3F\3G\3G\3H\3H\3I\3I\3J\3J\3J\3K\3K\3L\3L\3M\3"+
		"M\3N\3N\3O\3O\3P\3P\3P\3P\5P\u0208\nP\3Q\3Q\3Q\6Q\u020d\nQ\rQ\16Q\u020e"+
		"\3R\6R\u0212\nR\rR\16R\u0213\3S\6S\u0217\nS\rS\16S\u0218\3T\6T\u021c\n"+
		"T\rT\16T\u021d\4\u00ba\u0199\2U\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31"+
		"\61\32\63\33\65\34\67\359\36;\37= ?\2A!C\2E\"G#I$K%M&O\'Q(S)U*W+Y,[-]"+
		"._/a\60c\61e\62g\63i\64k\65m\66o\67q8s9u:w;y<{=}>\177?\u0081@\u0083A\u0085"+
		"B\u0087C\u0089D\u008bE\u008dF\u008fG\u0091H\u0093I\u0095J\u0097\2\u0099"+
		"\2\u009b\2\u009d\2\u009f\2\u00a1K\u00a3L\u00a5M\u00a7N\3\2\n\4\2\f\f\17"+
		"\17\5\2\13\f\16\17\"\"\3\2$$\3\2^^\3\2))\3\2\62;\4\2C\\c|\13\2\13\f\17"+
		"\17\"#*+..\60\60<>@@]_\u0224\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37"+
		"\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3"+
		"\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2"+
		"\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2A\3\2\2\2\2E\3\2\2\2\2G"+
		"\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2"+
		"\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2"+
		"\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m"+
		"\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2"+
		"\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2"+
		"\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d"+
		"\3\2\2\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\2\u0093\3\2\2\2\2\u0095\3\2\2"+
		"\2\2\u00a1\3\2\2\2\2\u00a3\3\2\2\2\2\u00a5\3\2\2\2\2\u00a7\3\2\2\2\3\u00a9"+
		"\3\2\2\2\5\u00b4\3\2\2\2\7\u00c2\3\2\2\2\t\u00c6\3\2\2\2\13\u00d0\3\2"+
		"\2\2\r\u00d9\3\2\2\2\17\u00df\3\2\2\2\21\u00e9\3\2\2\2\23\u00f1\3\2\2"+
		"\2\25\u00fc\3\2\2\2\27\u0103\3\2\2\2\31\u010a\3\2\2\2\33\u010e\3\2\2\2"+
		"\35\u0113\3\2\2\2\37\u0119\3\2\2\2!\u0121\3\2\2\2#\u012b\3\2\2\2%\u0132"+
		"\3\2\2\2\'\u0137\3\2\2\2)\u013a\3\2\2\2+\u013f\3\2\2\2-\u0143\3\2\2\2"+
		"/\u0149\3\2\2\2\61\u0150\3\2\2\2\63\u0159\3\2\2\2\65\u015f\3\2\2\2\67"+
		"\u0166\3\2\2\29\u016b\3\2\2\2;\u0171\3\2\2\2=\u0176\3\2\2\2?\u0180\3\2"+
		"\2\2A\u0182\3\2\2\2C\u018f\3\2\2\2E\u0191\3\2\2\2G\u0195\3\2\2\2I\u019e"+
		"\3\2\2\2K\u01a0\3\2\2\2M\u01a2\3\2\2\2O\u01a4\3\2\2\2Q\u01a6\3\2\2\2S"+
		"\u01a9\3\2\2\2U\u01ac\3\2\2\2W\u01af\3\2\2\2Y\u01b1\3\2\2\2[\u01b4\3\2"+
		"\2\2]\u01b6\3\2\2\2_\u01b8\3\2\2\2a\u01bb\3\2\2\2c\u01bd\3\2\2\2e\u01c0"+
		"\3\2\2\2g\u01c2\3\2\2\2i\u01c4\3\2\2\2k\u01c6\3\2\2\2m\u01c8\3\2\2\2o"+
		"\u01cb\3\2\2\2q\u01cf\3\2\2\2s\u01d2\3\2\2\2u\u01d5\3\2\2\2w\u01d7\3\2"+
		"\2\2y\u01da\3\2\2\2{\u01dc\3\2\2\2}\u01de\3\2\2\2\177\u01e0\3\2\2\2\u0081"+
		"\u01e2\3\2\2\2\u0083\u01e4\3\2\2\2\u0085\u01e6\3\2\2\2\u0087\u01e8\3\2"+
		"\2\2\u0089\u01ea\3\2\2\2\u008b\u01ee\3\2\2\2\u008d\u01f0\3\2\2\2\u008f"+
		"\u01f2\3\2\2\2\u0091\u01f4\3\2\2\2\u0093\u01f6\3\2\2\2\u0095\u01f9\3\2"+
		"\2\2\u0097\u01fb\3\2\2\2\u0099\u01fd\3\2\2\2\u009b\u01ff\3\2\2\2\u009d"+
		"\u0201\3\2\2\2\u009f\u0207\3\2\2\2\u00a1\u0209\3\2\2\2\u00a3\u0211\3\2"+
		"\2\2\u00a5\u0216\3\2\2\2\u00a7\u021b\3\2\2\2\u00a9\u00aa\7\61\2\2\u00aa"+
		"\u00ab\7\61\2\2\u00ab\u00af\3\2\2\2\u00ac\u00ae\n\2\2\2\u00ad\u00ac\3"+
		"\2\2\2\u00ae\u00b1\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0"+
		"\u00b2\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2\u00b3\b\2\2\2\u00b3\4\3\2\2\2"+
		"\u00b4\u00b5\7\61\2\2\u00b5\u00b6\7,\2\2\u00b6\u00ba\3\2\2\2\u00b7\u00b9"+
		"\13\2\2\2\u00b8\u00b7\3\2\2\2\u00b9\u00bc\3\2\2\2\u00ba\u00bb\3\2\2\2"+
		"\u00ba\u00b8\3\2\2\2\u00bb\u00bd\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bd\u00be"+
		"\7,\2\2\u00be\u00bf\7\61\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c1\b\3\2\2\u00c1"+
		"\6\3\2\2\2\u00c2\u00c3\t\3\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c5\b\4\2\2"+
		"\u00c5\b\3\2\2\2\u00c6\u00c7\7p\2\2\u00c7\u00c8\7c\2\2\u00c8\u00c9\7o"+
		"\2\2\u00c9\u00ca\7g\2\2\u00ca\u00cb\7u\2\2\u00cb\u00cc\7r\2\2\u00cc\u00cd"+
		"\7c\2\2\u00cd\u00ce\7e\2\2\u00ce\u00cf\7g\2\2\u00cf\n\3\2\2\2\u00d0\u00d1"+
		"\7c\2\2\u00d1\u00d2\7d\2\2\u00d2\u00d3\7u\2\2\u00d3\u00d4\7v\2\2\u00d4"+
		"\u00d5\7t\2\2\u00d5\u00d6\7c\2\2\u00d6\u00d7\7e\2\2\u00d7\u00d8\7v\2\2"+
		"\u00d8\f\3\2\2\2\u00d9\u00da\7e\2\2\u00da\u00db\7n\2\2\u00db\u00dc\7c"+
		"\2\2\u00dc\u00dd\7u\2\2\u00dd\u00de\7u\2\2\u00de\16\3\2\2\2\u00df\u00e0"+
		"\7k\2\2\u00e0\u00e1\7p\2\2\u00e1\u00e2\7v\2\2\u00e2\u00e3\7g\2\2\u00e3"+
		"\u00e4\7t\2\2\u00e4\u00e5\7h\2\2\u00e5\u00e6\7c\2\2\u00e6\u00e7\7e\2\2"+
		"\u00e7\u00e8\7g\2\2\u00e8\20\3\2\2\2\u00e9\u00ea\7g\2\2\u00ea\u00eb\7"+
		"z\2\2\u00eb\u00ec\7v\2\2\u00ec\u00ed\7g\2\2\u00ed\u00ee\7p\2\2\u00ee\u00ef"+
		"\7f\2\2\u00ef\u00f0\7u\2\2\u00f0\22\3\2\2\2\u00f1\u00f2\7k\2\2\u00f2\u00f3"+
		"\7o\2\2\u00f3\u00f4\7r\2\2\u00f4\u00f5\7n\2\2\u00f5\u00f6\7g\2\2\u00f6"+
		"\u00f7\7o\2\2\u00f7\u00f8\7g\2\2\u00f8\u00f9\7p\2\2\u00f9\u00fa\7v\2\2"+
		"\u00fa\u00fb\7u\2\2\u00fb\24\3\2\2\2\u00fc\u00fd\7k\2\2\u00fd\u00fe\7"+
		"o\2\2\u00fe\u00ff\7r\2\2\u00ff\u0100\7q\2\2\u0100\u0101\7t\2\2\u0101\u0102"+
		"\7v\2\2\u0102\26\3\2\2\2\u0103\u0104\7t\2\2\u0104\u0105\7g\2\2\u0105\u0106"+
		"\7v\2\2\u0106\u0107\7w\2\2\u0107\u0108\7t\2\2\u0108\u0109\7p\2\2\u0109"+
		"\30\3\2\2\2\u010a\u010b\7p\2\2\u010b\u010c\7g\2\2\u010c\u010d\7y\2\2\u010d"+
		"\32\3\2\2\2\u010e\u010f\7v\2\2\u010f\u0110\7j\2\2\u0110\u0111\7k\2\2\u0111"+
		"\u0112\7u\2\2\u0112\34\3\2\2\2\u0113\u0114\7u\2\2\u0114\u0115\7w\2\2\u0115"+
		"\u0116\7r\2\2\u0116\u0117\7g\2\2\u0117\u0118\7t\2\2\u0118\36\3\2\2\2\u0119"+
		"\u011a\7r\2\2\u011a\u011b\7t\2\2\u011b\u011c\7k\2\2\u011c\u011d\7x\2\2"+
		"\u011d\u011e\7c\2\2\u011e\u011f\7v\2\2\u011f\u0120\7g\2\2\u0120 \3\2\2"+
		"\2\u0121\u0122\7r\2\2\u0122\u0123\7t\2\2\u0123\u0124\7q\2\2\u0124\u0125"+
		"\7v\2\2\u0125\u0126\7g\2\2\u0126\u0127\7e\2\2\u0127\u0128\7v\2\2\u0128"+
		"\u0129\7g\2\2\u0129\u012a\7f\2\2\u012a\"\3\2\2\2\u012b\u012c\7r\2\2\u012c"+
		"\u012d\7w\2\2\u012d\u012e\7d\2\2\u012e\u012f\7n\2\2\u012f\u0130\7k\2\2"+
		"\u0130\u0131\7e\2\2\u0131$\3\2\2\2\u0132\u0133\7x\2\2\u0133\u0134\7q\2"+
		"\2\u0134\u0135\7k\2\2\u0135\u0136\7f\2\2\u0136&\3\2\2\2\u0137\u0138\7"+
		"k\2\2\u0138\u0139\7h\2\2\u0139(\3\2\2\2\u013a\u013b\7g\2\2\u013b\u013c"+
		"\7n\2\2\u013c\u013d\7u\2\2\u013d\u013e\7g\2\2\u013e*\3\2\2\2\u013f\u0140"+
		"\7h\2\2\u0140\u0141\7q\2\2\u0141\u0142\7t\2\2\u0142,\3\2\2\2\u0143\u0144"+
		"\7y\2\2\u0144\u0145\7j\2\2\u0145\u0146\7k\2\2\u0146\u0147\7n\2\2\u0147"+
		"\u0148\7g\2\2\u0148.\3\2\2\2\u0149\u014a\7p\2\2\u014a\u014b\7g\2\2\u014b"+
		"\u014c\7u\2\2\u014c\u014d\7v\2\2\u014d\u014e\7g\2\2\u014e\u014f\7f\2\2"+
		"\u014f\60\3\2\2\2\u0150\u0151\7u\2\2\u0151\u0152\7w\2\2\u0152\u0153\7"+
		"t\2\2\u0153\u0154\7t\2\2\u0154\u0155\7q\2\2\u0155\u0156\7w\2\2\u0156\u0157"+
		"\7p\2\2\u0157\u0158\7f\2\2\u0158\62\3\2\2\2\u0159\u015a\7h\2\2\u015a\u015b"+
		"\7k\2\2\u015b\u015c\7p\2\2\u015c\u015d\7c\2\2\u015d\u015e\7n\2\2\u015e"+
		"\64\3\2\2\2\u015f\u0160\7u\2\2\u0160\u0161\7v\2\2\u0161\u0162\7c\2\2\u0162"+
		"\u0163\7v\2\2\u0163\u0164\7k\2\2\u0164\u0165\7e\2\2\u0165\66\3\2\2\2\u0166"+
		"\u0167\7v\2\2\u0167\u0168\7t\2\2\u0168\u0169\7w\2\2\u0169\u016a\7g\2\2"+
		"\u016a8\3\2\2\2\u016b\u016c\7h\2\2\u016c\u016d\7c\2\2\u016d\u016e\7n\2"+
		"\2\u016e\u016f\7u\2\2\u016f\u0170\7g\2\2\u0170:\3\2\2\2\u0171\u0172\7"+
		"p\2\2\u0172\u0173\7w\2\2\u0173\u0174\7n\2\2\u0174\u0175\7n\2\2\u0175<"+
		"\3\2\2\2\u0176\u0177\7u\2\2\u0177\u0178\7v\2\2\u0178\u0179\7w\2\2\u0179"+
		"\u017a\7d\2\2\u017a>\3\2\2\2\u017b\u0181\n\4\2\2\u017c\u017d\n\5\2\2\u017d"+
		"\u017e\5\u008fH\2\u017e\u017f\5\u0087D\2\u017f\u0181\3\2\2\2\u0180\u017b"+
		"\3\2\2\2\u0180\u017c\3\2\2\2\u0181@\3\2\2\2\u0182\u0186\5\u0087D\2\u0183"+
		"\u0185\5? \2\u0184\u0183\3\2\2\2\u0185\u0188\3\2\2\2\u0186\u0184\3\2\2"+
		"\2\u0186\u0187\3\2\2\2\u0187\u0189\3\2\2\2\u0188\u0186\3\2\2\2\u0189\u018a"+
		"\5\u0087D\2\u018aB\3\2\2\2\u018b\u0190\n\6\2\2\u018c\u018d\5\u008fH\2"+
		"\u018d\u018e\5\u008bF\2\u018e\u0190\3\2\2\2\u018f\u018b\3\2\2\2\u018f"+
		"\u018c\3\2\2\2\u0190D\3\2\2\2\u0191\u0192\5\u008bF\2\u0192\u0193\5C\""+
		"\2\u0193\u0194\5\u008bF\2\u0194F\3\2\2\2\u0195\u0199\5\u0089E\2\u0196"+
		"\u0198\13\2\2\2\u0197\u0196\3\2\2\2\u0198\u019b\3\2\2\2\u0199\u019a\3"+
		"\2\2\2\u0199\u0197\3\2\2\2\u019a\u019c\3\2\2\2\u019b\u0199\3\2\2\2\u019c"+
		"\u019d\5\u0089E\2\u019dH\3\2\2\2\u019e\u019f\7\60\2\2\u019fJ\3\2\2\2\u01a0"+
		"\u01a1\7.\2\2\u01a1L\3\2\2\2\u01a2\u01a3\7<\2\2\u01a3N\3\2\2\2\u01a4\u01a5"+
		"\7=\2\2\u01a5P\3\2\2\2\u01a6\u01a7\7?\2\2\u01a7\u01a8\7?\2\2\u01a8R\3"+
		"\2\2\2\u01a9\u01aa\7#\2\2\u01aa\u01ab\7?\2\2\u01abT\3\2\2\2\u01ac\u01ad"+
		"\7(\2\2\u01ad\u01ae\7(\2\2\u01aeV\3\2\2\2\u01af\u01b0\7(\2\2\u01b0X\3"+
		"\2\2\2\u01b1\u01b2\7~\2\2\u01b2\u01b3\7~\2\2\u01b3Z\3\2\2\2\u01b4\u01b5"+
		"\7~\2\2\u01b5\\\3\2\2\2\u01b6\u01b7\7?\2\2\u01b7^\3\2\2\2\u01b8\u01b9"+
		"\7-\2\2\u01b9\u01ba\7-\2\2\u01ba`\3\2\2\2\u01bb\u01bc\7-\2\2\u01bcb\3"+
		"\2\2\2\u01bd\u01be\7/\2\2\u01be\u01bf\7/\2\2\u01bfd\3\2\2\2\u01c0\u01c1"+
		"\7/\2\2\u01c1f\3\2\2\2\u01c2\u01c3\7,\2\2\u01c3h\3\2\2\2\u01c4\u01c5\7"+
		"\'\2\2\u01c5j\3\2\2\2\u01c6\u01c7\7`\2\2\u01c7l\3\2\2\2\u01c8\u01c9\7"+
		">\2\2\u01c9\u01ca\7>\2\2\u01can\3\2\2\2\u01cb\u01cc\7@\2\2\u01cc\u01cd"+
		"\7@\2\2\u01cd\u01ce\7@\2\2\u01cep\3\2\2\2\u01cf\u01d0\7@\2\2\u01d0\u01d1"+
		"\7@\2\2\u01d1r\3\2\2\2\u01d2\u01d3\7>\2\2\u01d3\u01d4\7?\2\2\u01d4t\3"+
		"\2\2\2\u01d5\u01d6\7>\2\2\u01d6v\3\2\2\2\u01d7\u01d8\7@\2\2\u01d8\u01d9"+
		"\7?\2\2\u01d9x\3\2\2\2\u01da\u01db\7@\2\2\u01dbz\3\2\2\2\u01dc\u01dd\7"+
		"*\2\2\u01dd|\3\2\2\2\u01de\u01df\7+\2\2\u01df~\3\2\2\2\u01e0\u01e1\7}"+
		"\2\2\u01e1\u0080\3\2\2\2\u01e2\u01e3\7\177\2\2\u01e3\u0082\3\2\2\2\u01e4"+
		"\u01e5\7]\2\2\u01e5\u0084\3\2\2\2\u01e6\u01e7\7_\2\2\u01e7\u0086\3\2\2"+
		"\2\u01e8\u01e9\7$\2\2\u01e9\u0088\3\2\2\2\u01ea\u01eb\7)\2\2\u01eb\u01ec"+
		"\7)\2\2\u01ec\u01ed\7)\2\2\u01ed\u008a\3\2\2\2\u01ee\u01ef\7)\2\2\u01ef"+
		"\u008c\3\2\2\2\u01f0\u01f1\7\61\2\2\u01f1\u008e\3\2\2\2\u01f2\u01f3\7"+
		"^\2\2\u01f3\u0090\3\2\2\2\u01f4\u01f5\7A\2\2\u01f5\u0092\3\2\2\2\u01f6"+
		"\u01f7\7]\2\2\u01f7\u01f8\7_\2\2\u01f8\u0094\3\2\2\2\u01f9\u01fa\7#\2"+
		"\2\u01fa\u0096\3\2\2\2\u01fb\u01fc\t\7\2\2\u01fc\u0098\3\2\2\2\u01fd\u01fe"+
		"\t\b\2\2\u01fe\u009a\3\2\2\2\u01ff\u0200\7a\2\2\u0200\u009c\3\2\2\2\u0201"+
		"\u0202\7&\2\2\u0202\u009e\3\2\2\2\u0203\u0208\5\u0099M\2\u0204\u0208\5"+
		"\u0097L\2\u0205\u0208\5\u009bN\2\u0206\u0208\5\u009dO\2\u0207\u0203\3"+
		"\2\2\2\u0207\u0204\3\2\2\2\u0207\u0205\3\2\2\2\u0207\u0206\3\2\2\2\u0208"+
		"\u00a0\3\2\2\2\u0209\u020a\5\u0097L\2\u020a\u020c\5I%\2\u020b\u020d\5"+
		"\u0097L\2\u020c\u020b\3\2\2\2\u020d\u020e\3\2\2\2\u020e\u020c\3\2\2\2"+
		"\u020e\u020f\3\2\2\2\u020f\u00a2\3\2\2\2\u0210\u0212\5\u0097L\2\u0211"+
		"\u0210\3\2\2\2\u0212\u0213\3\2\2\2\u0213\u0211\3\2\2\2\u0213\u0214\3\2"+
		"\2\2\u0214\u00a4\3\2\2\2\u0215\u0217\5\u009fP\2\u0216\u0215\3\2\2\2\u0217"+
		"\u0218\3\2\2\2\u0218\u0216\3\2\2\2\u0218\u0219\3\2\2\2\u0219\u00a6\3\2"+
		"\2\2\u021a\u021c\n\t\2\2\u021b\u021a\3\2\2\2\u021c\u021d\3\2\2\2\u021d"+
		"\u021b\3\2\2\2\u021d\u021e\3\2\2\2\u021e\u00a8\3\2\2\2\16\2\u00af\u00ba"+
		"\u0180\u0186\u018f\u0199\u0207\u020e\u0213\u0218\u021d\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}