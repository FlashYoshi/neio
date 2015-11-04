// Generated from /home/flash/Github/neio/neio/src/main/grammar/NeioClassLexer.g4 by ANTLR 4.2.2
package be.ugent.neio.parsing;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class NeioClassLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		HEADER=1, COMMENT=2, MULTILINE_COMMENT=3, WS=4, NEWLINE=5, EXTENDS=6, 
		IMPLEMENTS=7, CLASS=8, INTERFACE=9, RETURN=10, NEW=11, THIS=12, METHOD_OPTION=13, 
		STUB=14, CLASS_NAME=15, CAMEL_CASE=16, VAR_WITH_TYPE=17, PERIOD=18, COMMA=19, 
		COLON=20, SEMICOLON=21, EQUALS=22, PLUS=23, MINUS=24, STAR=25, SMALLER=26, 
		BIGGER=27, LEFT_BRACE=28, RIGHT_BRACE=29, LEFT_CURLY_BRACE=30, RIGHT_CURLY_BRACE=31, 
		METHOD_NAME=32;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"HEADER", "COMMENT", "MULTILINE_COMMENT", "WS", "NEWLINE", "'extends'", 
		"'implements'", "'class'", "'interface'", "'return'", "'new'", "'this'", 
		"METHOD_OPTION", "'stub'", "CLASS_NAME", "CAMEL_CASE", "VAR_WITH_TYPE", 
		"'.'", "','", "':'", "';'", "'='", "'+'", "'-'", "'*'", "'<'", "'>'", 
		"'('", "')'", "'{'", "'}'", "METHOD_NAME"
	};
	public static final String[] ruleNames = {
		"HEADER", "HEADER_CONTENT", "COMMENT", "MULTILINE_COMMENT", "WS", "NEWLINE", 
		"CAPITAL", "LETTER", "CHAR", "EXTENDS", "IMPLEMENTS", "CLASS", "INTERFACE", 
		"RETURN", "NEW", "THIS", "METHOD_OPTION", "STUB", "CAPITALED", "CLASS_NAME", 
		"CAMEL_CASE", "VAR_WITH_TYPE", "PERIOD", "COMMA", "COLON", "SEMICOLON", 
		"EQUALS", "PLUS", "MINUS", "STAR", "SMALLER", "BIGGER", "LEFT_BRACE", 
		"RIGHT_BRACE", "LEFT_CURLY_BRACE", "RIGHT_CURLY_BRACE", "METHOD_NAME"
	};


	public NeioClassLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "NeioClassLexer.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\"\u0105\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\3\2\3\2\3\3\3\3\5\3R\n\3\3\4\3\4\3"+
		"\4\3\4\7\4X\n\4\f\4\16\4[\13\4\3\4\3\4\3\5\3\5\3\5\3\5\7\5c\n\5\f\5\16"+
		"\5f\13\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\5\7r\n\7\3\7\3\7\3\7"+
		"\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22"+
		"\u00c1\n\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\6\24\u00ca\n\24\r\24\16"+
		"\24\u00cb\3\25\6\25\u00cf\n\25\r\25\16\25\u00d0\3\26\6\26\u00d4\n\26\r"+
		"\26\16\26\u00d5\3\26\7\26\u00d9\n\26\f\26\16\26\u00dc\13\26\3\27\3\27"+
		"\3\27\3\27\3\27\5\27\u00e3\n\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33"+
		"\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$"+
		"\3$\3%\3%\3&\6&\u0102\n&\r&\16&\u0103\3d\2\'\3\3\5\2\7\4\t\5\13\6\r\7"+
		"\17\2\21\2\23\2\25\b\27\t\31\n\33\13\35\f\37\r!\16#\17%\20\'\2)\21+\22"+
		"-\23/\24\61\25\63\26\65\27\67\309\31;\32=\33?\34A\35C\36E\37G I!K\"\3"+
		"\2\b\4\2\f\f\17\17\4\2\13\13\"\"\3\2C\\\3\2c|\5\2\62;C\\c|\t\2\13\f\17"+
		"\17\"\"*+..\60\60<=\u010b\2\3\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2"+
		"\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2)\3\2\2\2\2"+
		"+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2"+
		"\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2"+
		"C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\3M\3\2\2\2\5Q\3"+
		"\2\2\2\7S\3\2\2\2\t^\3\2\2\2\13l\3\2\2\2\rq\3\2\2\2\17w\3\2\2\2\21y\3"+
		"\2\2\2\23{\3\2\2\2\25}\3\2\2\2\27\u0085\3\2\2\2\31\u0090\3\2\2\2\33\u0096"+
		"\3\2\2\2\35\u00a0\3\2\2\2\37\u00a7\3\2\2\2!\u00ab\3\2\2\2#\u00c0\3\2\2"+
		"\2%\u00c2\3\2\2\2\'\u00c7\3\2\2\2)\u00ce\3\2\2\2+\u00d3\3\2\2\2-\u00dd"+
		"\3\2\2\2/\u00e4\3\2\2\2\61\u00e6\3\2\2\2\63\u00e8\3\2\2\2\65\u00ea\3\2"+
		"\2\2\67\u00ec\3\2\2\29\u00ee\3\2\2\2;\u00f0\3\2\2\2=\u00f2\3\2\2\2?\u00f4"+
		"\3\2\2\2A\u00f6\3\2\2\2C\u00f8\3\2\2\2E\u00fa\3\2\2\2G\u00fc\3\2\2\2I"+
		"\u00fe\3\2\2\2K\u0101\3\2\2\2MN\5\5\3\2N\4\3\2\2\2OR\5\31\r\2PR\5\33\16"+
		"\2QO\3\2\2\2QP\3\2\2\2R\6\3\2\2\2ST\7\61\2\2TU\7\61\2\2UY\3\2\2\2VX\n"+
		"\2\2\2WV\3\2\2\2X[\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z\\\3\2\2\2[Y\3\2\2\2\\"+
		"]\b\4\2\2]\b\3\2\2\2^_\7\61\2\2_`\7,\2\2`d\3\2\2\2ac\13\2\2\2ba\3\2\2"+
		"\2cf\3\2\2\2de\3\2\2\2db\3\2\2\2eg\3\2\2\2fd\3\2\2\2gh\7,\2\2hi\7\61\2"+
		"\2ij\3\2\2\2jk\b\5\2\2k\n\3\2\2\2lm\t\3\2\2mn\3\2\2\2no\b\6\2\2o\f\3\2"+
		"\2\2pr\7\17\2\2qp\3\2\2\2qr\3\2\2\2rs\3\2\2\2st\7\f\2\2tu\3\2\2\2uv\b"+
		"\7\3\2v\16\3\2\2\2wx\t\4\2\2x\20\3\2\2\2yz\t\5\2\2z\22\3\2\2\2{|\t\6\2"+
		"\2|\24\3\2\2\2}~\7g\2\2~\177\7z\2\2\177\u0080\7v\2\2\u0080\u0081\7g\2"+
		"\2\u0081\u0082\7p\2\2\u0082\u0083\7f\2\2\u0083\u0084\7u\2\2\u0084\26\3"+
		"\2\2\2\u0085\u0086\7k\2\2\u0086\u0087\7o\2\2\u0087\u0088\7r\2\2\u0088"+
		"\u0089\7n\2\2\u0089\u008a\7g\2\2\u008a\u008b\7o\2\2\u008b\u008c\7g\2\2"+
		"\u008c\u008d\7p\2\2\u008d\u008e\7v\2\2\u008e\u008f\7u\2\2\u008f\30\3\2"+
		"\2\2\u0090\u0091\7e\2\2\u0091\u0092\7n\2\2\u0092\u0093\7c\2\2\u0093\u0094"+
		"\7u\2\2\u0094\u0095\7u\2\2\u0095\32\3\2\2\2\u0096\u0097\7k\2\2\u0097\u0098"+
		"\7p\2\2\u0098\u0099\7v\2\2\u0099\u009a\7g\2\2\u009a\u009b\7t\2\2\u009b"+
		"\u009c\7h\2\2\u009c\u009d\7c\2\2\u009d\u009e\7e\2\2\u009e\u009f\7g\2\2"+
		"\u009f\34\3\2\2\2\u00a0\u00a1\7t\2\2\u00a1\u00a2\7g\2\2\u00a2\u00a3\7"+
		"v\2\2\u00a3\u00a4\7w\2\2\u00a4\u00a5\7t\2\2\u00a5\u00a6\7p\2\2\u00a6\36"+
		"\3\2\2\2\u00a7\u00a8\7p\2\2\u00a8\u00a9\7g\2\2\u00a9\u00aa\7y\2\2\u00aa"+
		" \3\2\2\2\u00ab\u00ac\7v\2\2\u00ac\u00ad\7j\2\2\u00ad\u00ae\7k\2\2\u00ae"+
		"\u00af\7u\2\2\u00af\"\3\2\2\2\u00b0\u00b1\7d\2\2\u00b1\u00b2\7w\2\2\u00b2"+
		"\u00b3\7k\2\2\u00b3\u00b4\7n\2\2\u00b4\u00b5\7f\2\2\u00b5\u00b6\7g\2\2"+
		"\u00b6\u00c1\7t\2\2\u00b7\u00b8\7t\2\2\u00b8\u00b9\7g\2\2\u00b9\u00ba"+
		"\7i\2\2\u00ba\u00bb\7g\2\2\u00bb\u00c1\7z\2\2\u00bc\u00bd\7w\2\2\u00bd"+
		"\u00be\7v\2\2\u00be\u00bf\7k\2\2\u00bf\u00c1\7n\2\2\u00c0\u00b0\3\2\2"+
		"\2\u00c0\u00b7\3\2\2\2\u00c0\u00bc\3\2\2\2\u00c1$\3\2\2\2\u00c2\u00c3"+
		"\7u\2\2\u00c3\u00c4\7v\2\2\u00c4\u00c5\7w\2\2\u00c5\u00c6\7d\2\2\u00c6"+
		"&\3\2\2\2\u00c7\u00c9\5\17\b\2\u00c8\u00ca\5\21\t\2\u00c9\u00c8\3\2\2"+
		"\2\u00ca\u00cb\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc("+
		"\3\2\2\2\u00cd\u00cf\5\'\24\2\u00ce\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2"+
		"\u00d0\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1*\3\2\2\2\u00d2\u00d4\5"+
		"\21\t\2\u00d3\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d5"+
		"\u00d6\3\2\2\2\u00d6\u00da\3\2\2\2\u00d7\u00d9\5\'\24\2\u00d8\u00d7\3"+
		"\2\2\2\u00d9\u00dc\3\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db"+
		",\3\2\2\2\u00dc\u00da\3\2\2\2\u00dd\u00e2\5)\25\2\u00de\u00df\5? \2\u00df"+
		"\u00e0\5-\27\2\u00e0\u00e1\5A!\2\u00e1\u00e3\3\2\2\2\u00e2\u00de\3\2\2"+
		"\2\u00e2\u00e3\3\2\2\2\u00e3.\3\2\2\2\u00e4\u00e5\7\60\2\2\u00e5\60\3"+
		"\2\2\2\u00e6\u00e7\7.\2\2\u00e7\62\3\2\2\2\u00e8\u00e9\7<\2\2\u00e9\64"+
		"\3\2\2\2\u00ea\u00eb\7=\2\2\u00eb\66\3\2\2\2\u00ec\u00ed\7?\2\2\u00ed"+
		"8\3\2\2\2\u00ee\u00ef\7-\2\2\u00ef:\3\2\2\2\u00f0\u00f1\7/\2\2\u00f1<"+
		"\3\2\2\2\u00f2\u00f3\7,\2\2\u00f3>\3\2\2\2\u00f4\u00f5\7>\2\2\u00f5@\3"+
		"\2\2\2\u00f6\u00f7\7@\2\2\u00f7B\3\2\2\2\u00f8\u00f9\7*\2\2\u00f9D\3\2"+
		"\2\2\u00fa\u00fb\7+\2\2\u00fbF\3\2\2\2\u00fc\u00fd\7}\2\2\u00fdH\3\2\2"+
		"\2\u00fe\u00ff\7\177\2\2\u00ffJ\3\2\2\2\u0100\u0102\n\7\2\2\u0101\u0100"+
		"\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0101\3\2\2\2\u0103\u0104\3\2\2\2\u0104"+
		"L\3\2\2\2\16\2QYdq\u00c0\u00cb\u00d0\u00d5\u00da\u00e2\u0103\4\2\3\2\b"+
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