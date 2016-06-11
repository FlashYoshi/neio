// Generated from B:\Documents\GitHub\neio\neio\src\main\grammar\DocumentLexer.g4 by ANTLR 4.5
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
public class DocumentLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		HEADER=1, COMMENT=2, MULTILINE_COMMENT=3, SCOPED_CODE=4, LONE_CODE=5, 
		CODE=6, ESCAPE=7, S=8, WS=9, NL=10, LS_BRACE=11, RS_BRACE=12, L_BRACE=13, 
		R_BRACE=14, DLCB=15, LCB=16, DRCB=17, RCB=18, Q=19, TQ=20, MethodName=21, 
		HASH=22, DASH=23, STAR=24, P=25, EQ=26, CA=27, BQ=28, US=29, DLR=30, WORD=31, 
		CCONTENT=32, CONTENT=33, ANY=34, STRING=35, TEXTMODE=36, UNKNOWN=37;
	public static final int INCODE = 1;
	public static String[] modeNames = {
		"DEFAULT_MODE", "INCODE"
	};

	public static final String[] ruleNames = {
		"HEADER", "COMMENT", "MULTILINE_COMMENT", "SCOPED_CODE", "LONE_CODE", 
		"CODE", "CHAR", "ESCAPE", "S", "WS", "NL", "LS_BRACE", "RS_BRACE", "L_BRACE", 
		"R_BRACE", "DLCB", "LCB", "DRCB", "RCB", "Q", "SQ", "TQ", "B_QUOTE", "DB_QUOTE", 
		"TB_QUOTE", "B_SLASH", "UNDERSCORE", "H", "D", "ST", "DOLLAR", "PIPE", 
		"EQUALS", "CARET", "MethodName", "HASH", "DASH", "STAR", "P", "EQ", "CA", 
		"BQ", "US", "DLR", "VALID_CHAR", "WORD", "CCONTENT", "CONTENT", "ANY", 
		"STRING", "TEXTMODE", "UNKNOWN"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, null, "' '", null, null, "'['", 
		"']'", "'('", "')'", "'{{'", "'{'", "'}}'", "'}'", "'\"'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "HEADER", "COMMENT", "MULTILINE_COMMENT", "SCOPED_CODE", "LONE_CODE", 
		"CODE", "ESCAPE", "S", "WS", "NL", "LS_BRACE", "RS_BRACE", "L_BRACE", 
		"R_BRACE", "DLCB", "LCB", "DRCB", "RCB", "Q", "TQ", "MethodName", "HASH", 
		"DASH", "STAR", "P", "EQ", "CA", "BQ", "US", "DLR", "WORD", "CCONTENT", 
		"CONTENT", "ANY", "STRING", "TEXTMODE", "UNKNOWN"
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


	public DocumentLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "DocumentLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 0:
			return HEADER_sempred((RuleContext)_localctx, predIndex);
		case 3:
			return SCOPED_CODE_sempred((RuleContext)_localctx, predIndex);
		case 4:
			return LONE_CODE_sempred((RuleContext)_localctx, predIndex);
		case 34:
			return MethodName_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean HEADER_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return getCharPositionInLine() == 0;
		}
		return true;
	}
	private boolean SCOPED_CODE_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return getCharPositionInLine() == 0;
		case 2:
			return _input.LA(1) == '\r' || _input.LA(1) == '\n';
		}
		return true;
	}
	private boolean LONE_CODE_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return getCharPositionInLine() == 0;
		case 4:
			return _input.LA(1) == '\r' || _input.LA(1) == '\n';
		}
		return true;
	}
	private boolean MethodName_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return getCharPositionInLine() == 0;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\'\u016b\b\1\b\1\4"+
		"\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n"+
		"\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\3\2\3\2\3\2\6\2p\n\2\r\2\16\2q\3\2\3\2\3\3\3\3\3\3\3\3"+
		"\7\3z\n\3\f\3\16\3}\13\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\7\4\u0087\n\4"+
		"\f\4\16\4\u008a\13\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\7\5\u0096"+
		"\n\5\f\5\16\5\u0099\13\5\3\5\3\5\3\5\3\6\3\6\3\6\7\6\u00a1\n\6\f\6\16"+
		"\6\u00a4\13\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n"+
		"\3\13\3\13\3\13\3\13\3\f\5\f\u00b9\n\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17"+
		"\3\17\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\25"+
		"\3\25\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\32\3\32"+
		"\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!"+
		"\3!\3\"\3\"\3#\3#\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\6$\u00fc\n$\r$\16$\u00fd"+
		"\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3.\3.\3"+
		".\3.\3.\3.\5.\u011a\n.\3/\6/\u011d\n/\r/\16/\u011e\3\60\7\60\u0122\n\60"+
		"\f\60\16\60\u0125\13\60\3\60\3\60\3\60\3\60\3\61\3\61\7\61\u012d\n\61"+
		"\f\61\16\61\u0130\13\61\3\61\3\61\3\61\5\61\u0135\n\61\3\62\6\62\u0138"+
		"\n\62\r\62\16\62\u0139\3\62\5\62\u013d\n\62\3\63\3\63\3\63\3\63\3\63\7"+
		"\63\u0144\n\63\f\63\16\63\u0147\13\63\3\63\3\63\3\63\3\63\3\63\3\63\3"+
		"\63\7\63\u0150\n\63\f\63\16\63\u0153\13\63\3\63\3\63\3\63\5\63\u0158\n"+
		"\63\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\7\64\u0163\n\64\f\64"+
		"\16\64\u0166\13\64\3\64\3\64\3\65\3\65\4\u0088\u0164\2\66\4\3\6\4\b\5"+
		"\n\6\f\7\16\b\20\2\22\t\24\n\26\13\30\f\32\r\34\16\36\17 \20\"\21$\22"+
		"&\23(\24*\25,\2.\26\60\2\62\2\64\2\66\28\2:\2<\2>\2@\2B\2D\2F\2H\27J\30"+
		"L\31N\32P\33R\34T\35V\36X\37Z \\\2^!`\"b#d$f%h&j\'\4\2\3\t\4\2\f\f\17"+
		"\17\5\2\62;C\\c|\3\2\13\13\n\2\f\f\17\17\"\"%,]_ab}}\177\177\6\2$$))}"+
		"}\177\177\3\2$$\3\2))\u017e\2\4\3\2\2\2\2\6\3\2\2\2\2\b\3\2\2\2\2\n\3"+
		"\2\2\2\2\f\3\2\2\2\2\16\3\2\2\2\2\22\3\2\2\2\2\24\3\2\2\2\2\26\3\2\2\2"+
		"\2\30\3\2\2\2\2\32\3\2\2\2\2\34\3\2\2\2\2\36\3\2\2\2\2 \3\2\2\2\2\"\3"+
		"\2\2\2\2$\3\2\2\2\2&\3\2\2\2\2(\3\2\2\2\2*\3\2\2\2\2.\3\2\2\2\2H\3\2\2"+
		"\2\2J\3\2\2\2\2L\3\2\2\2\2N\3\2\2\2\2P\3\2\2\2\2R\3\2\2\2\2T\3\2\2\2\2"+
		"V\3\2\2\2\2X\3\2\2\2\2Z\3\2\2\2\2^\3\2\2\2\3`\3\2\2\2\3b\3\2\2\2\3d\3"+
		"\2\2\2\3f\3\2\2\2\3h\3\2\2\2\3j\3\2\2\2\4l\3\2\2\2\6u\3\2\2\2\b\u0082"+
		"\3\2\2\2\n\u0092\3\2\2\2\f\u009d\3\2\2\2\16\u00a8\3\2\2\2\20\u00ac\3\2"+
		"\2\2\22\u00ae\3\2\2\2\24\u00b1\3\2\2\2\26\u00b3\3\2\2\2\30\u00b8\3\2\2"+
		"\2\32\u00bc\3\2\2\2\34\u00be\3\2\2\2\36\u00c0\3\2\2\2 \u00c2\3\2\2\2\""+
		"\u00c4\3\2\2\2$\u00c7\3\2\2\2&\u00c9\3\2\2\2(\u00cc\3\2\2\2*\u00ce\3\2"+
		"\2\2,\u00d0\3\2\2\2.\u00d2\3\2\2\2\60\u00d6\3\2\2\2\62\u00d8\3\2\2\2\64"+
		"\u00db\3\2\2\2\66\u00df\3\2\2\28\u00e1\3\2\2\2:\u00e3\3\2\2\2<\u00e5\3"+
		"\2\2\2>\u00e7\3\2\2\2@\u00e9\3\2\2\2B\u00eb\3\2\2\2D\u00ed\3\2\2\2F\u00ef"+
		"\3\2\2\2H\u00f1\3\2\2\2J\u00ff\3\2\2\2L\u0101\3\2\2\2N\u0103\3\2\2\2P"+
		"\u0105\3\2\2\2R\u0107\3\2\2\2T\u0109\3\2\2\2V\u010b\3\2\2\2X\u010d\3\2"+
		"\2\2Z\u010f\3\2\2\2\\\u0119\3\2\2\2^\u011c\3\2\2\2`\u0123\3\2\2\2b\u0134"+
		"\3\2\2\2d\u013c\3\2\2\2f\u0157\3\2\2\2h\u0159\3\2\2\2j\u0169\3\2\2\2l"+
		"m\6\2\2\2mo\5\32\r\2np\5\20\b\2on\3\2\2\2pq\3\2\2\2qo\3\2\2\2qr\3\2\2"+
		"\2rs\3\2\2\2st\5\34\16\2t\5\3\2\2\2uv\7\61\2\2vw\7\61\2\2w{\3\2\2\2xz"+
		"\n\2\2\2yx\3\2\2\2z}\3\2\2\2{y\3\2\2\2{|\3\2\2\2|~\3\2\2\2}{\3\2\2\2~"+
		"\177\5\30\f\2\177\u0080\3\2\2\2\u0080\u0081\b\3\2\2\u0081\7\3\2\2\2\u0082"+
		"\u0083\7\61\2\2\u0083\u0084\7,\2\2\u0084\u0088\3\2\2\2\u0085\u0087\13"+
		"\2\2\2\u0086\u0085\3\2\2\2\u0087\u008a\3\2\2\2\u0088\u0089\3\2\2\2\u0088"+
		"\u0086\3\2\2\2\u0089\u008b\3\2\2\2\u008a\u0088\3\2\2\2\u008b\u008c\7,"+
		"\2\2\u008c\u008d\7\61\2\2\u008d\u008e\3\2\2\2\u008e\u008f\5\30\f\2\u008f"+
		"\u0090\3\2\2\2\u0090\u0091\b\4\2\2\u0091\t\3\2\2\2\u0092\u0093\6\5\3\2"+
		"\u0093\u0097\5\"\21\2\u0094\u0096\5b\61\2\u0095\u0094\3\2\2\2\u0096\u0099"+
		"\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u009a\3\2\2\2\u0099"+
		"\u0097\3\2\2\2\u009a\u009b\5&\23\2\u009b\u009c\6\5\4\2\u009c\13\3\2\2"+
		"\2\u009d\u009e\6\6\5\2\u009e\u00a2\5$\22\2\u009f\u00a1\5b\61\2\u00a0\u009f"+
		"\3\2\2\2\u00a1\u00a4\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3"+
		"\u00a5\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a5\u00a6\5(\24\2\u00a6\u00a7\6\6"+
		"\6\2\u00a7\r\3\2\2\2\u00a8\u00a9\5$\22\2\u00a9\u00aa\3\2\2\2\u00aa\u00ab"+
		"\b\7\3\2\u00ab\17\3\2\2\2\u00ac\u00ad\t\3\2\2\u00ad\21\3\2\2\2\u00ae\u00af"+
		"\5\66\33\2\u00af\u00b0\13\2\2\2\u00b0\23\3\2\2\2\u00b1\u00b2\7\"\2\2\u00b2"+
		"\25\3\2\2\2\u00b3\u00b4\t\4\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b6\b\13\2"+
		"\2\u00b6\27\3\2\2\2\u00b7\u00b9\7\17\2\2\u00b8\u00b7\3\2\2\2\u00b8\u00b9"+
		"\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bb\7\f\2\2\u00bb\31\3\2\2\2\u00bc"+
		"\u00bd\7]\2\2\u00bd\33\3\2\2\2\u00be\u00bf\7_\2\2\u00bf\35\3\2\2\2\u00c0"+
		"\u00c1\7*\2\2\u00c1\37\3\2\2\2\u00c2\u00c3\7+\2\2\u00c3!\3\2\2\2\u00c4"+
		"\u00c5\7}\2\2\u00c5\u00c6\7}\2\2\u00c6#\3\2\2\2\u00c7\u00c8\7}\2\2\u00c8"+
		"%\3\2\2\2\u00c9\u00ca\7\177\2\2\u00ca\u00cb\7\177\2\2\u00cb\'\3\2\2\2"+
		"\u00cc\u00cd\7\177\2\2\u00cd)\3\2\2\2\u00ce\u00cf\7$\2\2\u00cf+\3\2\2"+
		"\2\u00d0\u00d1\7)\2\2\u00d1-\3\2\2\2\u00d2\u00d3\5,\26\2\u00d3\u00d4\5"+
		",\26\2\u00d4\u00d5\5,\26\2\u00d5/\3\2\2\2\u00d6\u00d7\7b\2\2\u00d7\61"+
		"\3\2\2\2\u00d8\u00d9\7b\2\2\u00d9\u00da\7b\2\2\u00da\63\3\2\2\2\u00db"+
		"\u00dc\7b\2\2\u00dc\u00dd\7b\2\2\u00dd\u00de\7b\2\2\u00de\65\3\2\2\2\u00df"+
		"\u00e0\7^\2\2\u00e0\67\3\2\2\2\u00e1\u00e2\7a\2\2\u00e29\3\2\2\2\u00e3"+
		"\u00e4\7%\2\2\u00e4;\3\2\2\2\u00e5\u00e6\7/\2\2\u00e6=\3\2\2\2\u00e7\u00e8"+
		"\7,\2\2\u00e8?\3\2\2\2\u00e9\u00ea\7&\2\2\u00eaA\3\2\2\2\u00eb\u00ec\7"+
		"~\2\2\u00ecC\3\2\2\2\u00ed\u00ee\7?\2\2\u00eeE\3\2\2\2\u00ef\u00f0\7`"+
		"\2\2\u00f0G\3\2\2\2\u00f1\u00fb\6$\7\2\u00f2\u00fc\5:\35\2\u00f3\u00fc"+
		"\5<\36\2\u00f4\u00fc\5>\37\2\u00f5\u00fc\5Z-\2\u00f6\u00fc\5D\"\2\u00f7"+
		"\u00fc\5F#\2\u00f8\u00fc\5\60\30\2\u00f9\u00fc\58\34\2\u00fa\u00fc\5P"+
		"(\2\u00fb\u00f2\3\2\2\2\u00fb\u00f3\3\2\2\2\u00fb\u00f4\3\2\2\2\u00fb"+
		"\u00f5\3\2\2\2\u00fb\u00f6\3\2\2\2\u00fb\u00f7\3\2\2\2\u00fb\u00f8\3\2"+
		"\2\2\u00fb\u00f9\3\2\2\2\u00fb\u00fa\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd"+
		"\u00fb\3\2\2\2\u00fd\u00fe\3\2\2\2\u00feI\3\2\2\2\u00ff\u0100\5:\35\2"+
		"\u0100K\3\2\2\2\u0101\u0102\5<\36\2\u0102M\3\2\2\2\u0103\u0104\5>\37\2"+
		"\u0104O\3\2\2\2\u0105\u0106\5B!\2\u0106Q\3\2\2\2\u0107\u0108\5D\"\2\u0108"+
		"S\3\2\2\2\u0109\u010a\5F#\2\u010aU\3\2\2\2\u010b\u010c\5\60\30\2\u010c"+
		"W\3\2\2\2\u010d\u010e\58\34\2\u010eY\3\2\2\2\u010f\u0110\5@ \2\u0110["+
		"\3\2\2\2\u0111\u011a\n\5\2\2\u0112\u011a\5,\26\2\u0113\u011a\5J%\2\u0114"+
		"\u011a\5Z-\2\u0115\u011a\5\36\17\2\u0116\u011a\5 \20\2\u0117\u011a\5R"+
		")\2\u0118\u011a\5T*\2\u0119\u0111\3\2\2\2\u0119\u0112\3\2\2\2\u0119\u0113"+
		"\3\2\2\2\u0119\u0114\3\2\2\2\u0119\u0115\3\2\2\2\u0119\u0116\3\2\2\2\u0119"+
		"\u0117\3\2\2\2\u0119\u0118\3\2\2\2\u011a]\3\2\2\2\u011b\u011d\5\\.\2\u011c"+
		"\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u011c\3\2\2\2\u011e\u011f\3\2"+
		"\2\2\u011f_\3\2\2\2\u0120\u0122\5b\61\2\u0121\u0120\3\2\2\2\u0122\u0125"+
		"\3\2\2\2\u0123\u0121\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0126\3\2\2\2\u0125"+
		"\u0123\3\2\2\2\u0126\u0127\5(\24\2\u0127\u0128\3\2\2\2\u0128\u0129\b\60"+
		"\4\2\u0129a\3\2\2\2\u012a\u012e\5$\22\2\u012b\u012d\5b\61\2\u012c\u012b"+
		"\3\2\2\2\u012d\u0130\3\2\2\2\u012e\u012c\3\2\2\2\u012e\u012f\3\2\2\2\u012f"+
		"\u0131\3\2\2\2\u0130\u012e\3\2\2\2\u0131\u0132\5(\24\2\u0132\u0135\3\2"+
		"\2\2\u0133\u0135\5d\62\2\u0134\u012a\3\2\2\2\u0134\u0133\3\2\2\2\u0135"+
		"c\3\2\2\2\u0136\u0138\n\6\2\2\u0137\u0136\3\2\2\2\u0138\u0139\3\2\2\2"+
		"\u0139\u0137\3\2\2\2\u0139\u013a\3\2\2\2\u013a\u013d\3\2\2\2\u013b\u013d"+
		"\5f\63\2\u013c\u0137\3\2\2\2\u013c\u013b\3\2\2\2\u013de\3\2\2\2\u013e"+
		"\u0145\5*\25\2\u013f\u0144\n\7\2\2\u0140\u0141\5\66\33\2\u0141\u0142\5"+
		"*\25\2\u0142\u0144\3\2\2\2\u0143\u013f\3\2\2\2\u0143\u0140\3\2\2\2\u0144"+
		"\u0147\3\2\2\2\u0145\u0143\3\2\2\2\u0145\u0146\3\2\2\2\u0146\u0148\3\2"+
		"\2\2\u0147\u0145\3\2\2\2\u0148\u0149\5*\25\2\u0149\u0158\3\2\2\2\u014a"+
		"\u0151\5,\26\2\u014b\u0150\n\b\2\2\u014c\u014d\5\66\33\2\u014d\u014e\5"+
		",\26\2\u014e\u0150\3\2\2\2\u014f\u014b\3\2\2\2\u014f\u014c\3\2\2\2\u0150"+
		"\u0153\3\2\2\2\u0151\u014f\3\2\2\2\u0151\u0152\3\2\2\2\u0152\u0154\3\2"+
		"\2\2\u0153\u0151\3\2\2\2\u0154\u0155\5,\26\2\u0155\u0158\3\2\2\2\u0156"+
		"\u0158\5h\64\2\u0157\u013e\3\2\2\2\u0157\u014a\3\2\2\2\u0157\u0156\3\2"+
		"\2\2\u0158g\3\2\2\2\u0159\u0164\5.\27\2\u015a\u0163\13\2\2\2\u015b\u015c"+
		"\5\66\33\2\u015c\u015d\5,\26\2\u015d\u015e\5\66\33\2\u015e\u015f\5,\26"+
		"\2\u015f\u0160\5\66\33\2\u0160\u0161\5,\26\2\u0161\u0163\3\2\2\2\u0162"+
		"\u015a\3\2\2\2\u0162\u015b\3\2\2\2\u0163\u0166\3\2\2\2\u0164\u0165\3\2"+
		"\2\2\u0164\u0162\3\2\2\2\u0165\u0167\3\2\2\2\u0166\u0164\3\2\2\2\u0167"+
		"\u0168\5.\27\2\u0168i\3\2\2\2\u0169\u016a\13\2\2\2\u016ak\3\2\2\2\32\2"+
		"\3q{\u0088\u0097\u00a2\u00b8\u00fb\u00fd\u0119\u011e\u0123\u012e\u0134"+
		"\u0139\u013c\u0143\u0145\u014f\u0151\u0157\u0162\u0164\5\2\3\2\7\3\2\4"+
		"\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}