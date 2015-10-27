// Generated from ThesisLexer.g4 by ANTLR 4.5.1
package be.ugent.thesis.parsing;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ThesisLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		HEADER=1, COMMENT=2, MULTILINE_COMMENT=3, PACKAGE=4, WS=5, NEWLINE=6, 
		CAPITAL=7, LETTER=8, EXTENDS=9, IMPLEMENTS=10, RETURN=11, NEW=12, METHOD_OPTION=13, 
		STUB=14, CLASS_NAME=15, CAMEL_CASE=16, VAR_WITH_TYPE=17, PERIOD=18, COMMA=19, 
		COLON=20, SEMICOLON=21, EQUALS=22, PLUS=23, MINUS=24, STAR=25, SMALLER=26, 
		BIGGER=27, LEFT_BRACE=28, RIGHT_BRACE=29, LEFT_CURLY_BRACE=30, RIGHT_CURLY_BRACE=31, 
		METHOD_NAME=32;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"HEADER", "HEADER_CONTENT", "COMMENT", "MULTILINE_COMMENT", "WORD", "WORDS", 
		"PACKAGE", "WS", "NEWLINE", "CAPITAL", "LETTER", "EXTENDS", "IMPLEMENTS", 
		"RETURN", "NEW", "METHOD_OPTION", "STUB", "CAPITALED", "CLASS_NAME", "CAMEL_CASE", 
		"VAR_WITH_TYPE", "PERIOD", "COMMA", "COLON", "SEMICOLON", "EQUALS", "PLUS", 
		"MINUS", "STAR", "SMALLER", "BIGGER", "LEFT_BRACE", "RIGHT_BRACE", "LEFT_CURLY_BRACE", 
		"RIGHT_CURLY_BRACE", "METHOD_NAME"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, null, null, "'extends'", "'implements'", 
		"'return'", "'new'", null, "'stub'", null, null, null, "'.'", "','", "':'", 
		"';'", "'='", "'+'", "'-'", "'*'", "'<'", "'>'", "'('", "')'", "'{'", 
		"'}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "HEADER", "COMMENT", "MULTILINE_COMMENT", "PACKAGE", "WS", "NEWLINE", 
		"CAPITAL", "LETTER", "EXTENDS", "IMPLEMENTS", "RETURN", "NEW", "METHOD_OPTION", 
		"STUB", "CLASS_NAME", "CAMEL_CASE", "VAR_WITH_TYPE", "PERIOD", "COMMA", 
		"COLON", "SEMICOLON", "EQUALS", "PLUS", "MINUS", "STAR", "SMALLER", "BIGGER", 
		"LEFT_BRACE", "RIGHT_BRACE", "LEFT_CURLY_BRACE", "RIGHT_CURLY_BRACE", 
		"METHOD_NAME"
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


	public ThesisLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ThesisLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\"\u0108\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\3\2\3\2\3\2\3\2\3\3\6\3Q\n\3\r\3\16\3R\3"+
		"\4\3\4\3\4\3\4\7\4Y\n\4\f\4\16\4\\\13\4\3\4\3\4\3\5\3\5\3\5\3\5\7\5d\n"+
		"\5\f\5\16\5g\13\5\3\5\3\5\3\5\3\5\3\5\3\6\6\6o\n\6\r\6\16\6p\3\7\6\7t"+
		"\n\7\r\7\16\7u\3\b\6\by\n\b\r\b\16\bz\3\b\3\b\6\b\177\n\b\r\b\16\b\u0080"+
		"\6\b\u0083\n\b\r\b\16\b\u0084\3\t\3\t\3\t\3\t\3\n\5\n\u008c\n\n\3\n\3"+
		"\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00c4\n\21\3\22\3\22\3\22"+
		"\3\22\3\22\3\23\3\23\6\23\u00cd\n\23\r\23\16\23\u00ce\3\24\6\24\u00d2"+
		"\n\24\r\24\16\24\u00d3\3\25\6\25\u00d7\n\25\r\25\16\25\u00d8\3\25\7\25"+
		"\u00dc\n\25\f\25\16\25\u00df\13\25\3\26\3\26\3\26\3\26\3\26\5\26\u00e6"+
		"\n\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35"+
		"\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\6%\u0105"+
		"\n%\r%\16%\u0106\3e\2&\3\3\5\2\7\4\t\5\13\2\r\2\17\6\21\7\23\b\25\t\27"+
		"\n\31\13\33\f\35\r\37\16!\17#\20%\2\'\21)\22+\23-\24/\25\61\26\63\27\65"+
		"\30\67\319\32;\33=\34?\35A\36C\37E G!I\"\3\2\t\3\2]_\4\2\f\f\17\17\5\2"+
		"\13\f\17\17\"\"\3\2c|\4\2\13\13\"\"\3\2C\\\7\2\13\f\17\17\"\"*+==\u0114"+
		"\2\3\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2"+
		"\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3"+
		"\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2"+
		"\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\3K\3\2\2\2\5P\3\2\2\2\7T\3\2\2\2\t"+
		"_\3\2\2\2\13n\3\2\2\2\rs\3\2\2\2\17x\3\2\2\2\21\u0086\3\2\2\2\23\u008b"+
		"\3\2\2\2\25\u0091\3\2\2\2\27\u0093\3\2\2\2\31\u0095\3\2\2\2\33\u009d\3"+
		"\2\2\2\35\u00a8\3\2\2\2\37\u00af\3\2\2\2!\u00c3\3\2\2\2#\u00c5\3\2\2\2"+
		"%\u00ca\3\2\2\2\'\u00d1\3\2\2\2)\u00d6\3\2\2\2+\u00e0\3\2\2\2-\u00e7\3"+
		"\2\2\2/\u00e9\3\2\2\2\61\u00eb\3\2\2\2\63\u00ed\3\2\2\2\65\u00ef\3\2\2"+
		"\2\67\u00f1\3\2\2\29\u00f3\3\2\2\2;\u00f5\3\2\2\2=\u00f7\3\2\2\2?\u00f9"+
		"\3\2\2\2A\u00fb\3\2\2\2C\u00fd\3\2\2\2E\u00ff\3\2\2\2G\u0101\3\2\2\2I"+
		"\u0104\3\2\2\2KL\7]\2\2LM\5\5\3\2MN\7_\2\2N\4\3\2\2\2OQ\n\2\2\2PO\3\2"+
		"\2\2QR\3\2\2\2RP\3\2\2\2RS\3\2\2\2S\6\3\2\2\2TU\7\61\2\2UV\7\61\2\2VZ"+
		"\3\2\2\2WY\n\3\2\2XW\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[]\3\2\2\2"+
		"\\Z\3\2\2\2]^\b\4\2\2^\b\3\2\2\2_`\7\61\2\2`a\7,\2\2ae\3\2\2\2bd\13\2"+
		"\2\2cb\3\2\2\2dg\3\2\2\2ef\3\2\2\2ec\3\2\2\2fh\3\2\2\2ge\3\2\2\2hi\7,"+
		"\2\2ij\7\61\2\2jk\3\2\2\2kl\b\5\2\2l\n\3\2\2\2mo\n\4\2\2nm\3\2\2\2op\3"+
		"\2\2\2pn\3\2\2\2pq\3\2\2\2q\f\3\2\2\2rt\5\13\6\2sr\3\2\2\2tu\3\2\2\2u"+
		"s\3\2\2\2uv\3\2\2\2v\16\3\2\2\2wy\t\5\2\2xw\3\2\2\2yz\3\2\2\2zx\3\2\2"+
		"\2z{\3\2\2\2{\u0082\3\2\2\2|~\5-\27\2}\177\t\5\2\2~}\3\2\2\2\177\u0080"+
		"\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0083\3\2\2\2\u0082"+
		"|\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2\2\2"+
		"\u0085\20\3\2\2\2\u0086\u0087\t\6\2\2\u0087\u0088\3\2\2\2\u0088\u0089"+
		"\b\t\2\2\u0089\22\3\2\2\2\u008a\u008c\7\17\2\2\u008b\u008a\3\2\2\2\u008b"+
		"\u008c\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008e\7\f\2\2\u008e\u008f\3\2"+
		"\2\2\u008f\u0090\b\n\3\2\u0090\24\3\2\2\2\u0091\u0092\t\7\2\2\u0092\26"+
		"\3\2\2\2\u0093\u0094\t\5\2\2\u0094\30\3\2\2\2\u0095\u0096\7g\2\2\u0096"+
		"\u0097\7z\2\2\u0097\u0098\7v\2\2\u0098\u0099\7g\2\2\u0099\u009a\7p\2\2"+
		"\u009a\u009b\7f\2\2\u009b\u009c\7u\2\2\u009c\32\3\2\2\2\u009d\u009e\7"+
		"k\2\2\u009e\u009f\7o\2\2\u009f\u00a0\7r\2\2\u00a0\u00a1\7n\2\2\u00a1\u00a2"+
		"\7g\2\2\u00a2\u00a3\7o\2\2\u00a3\u00a4\7g\2\2\u00a4\u00a5\7p\2\2\u00a5"+
		"\u00a6\7v\2\2\u00a6\u00a7\7u\2\2\u00a7\34\3\2\2\2\u00a8\u00a9\7t\2\2\u00a9"+
		"\u00aa\7g\2\2\u00aa\u00ab\7v\2\2\u00ab\u00ac\7w\2\2\u00ac\u00ad\7t\2\2"+
		"\u00ad\u00ae\7p\2\2\u00ae\36\3\2\2\2\u00af\u00b0\7p\2\2\u00b0\u00b1\7"+
		"g\2\2\u00b1\u00b2\7y\2\2\u00b2 \3\2\2\2\u00b3\u00b4\7d\2\2\u00b4\u00b5"+
		"\7w\2\2\u00b5\u00b6\7k\2\2\u00b6\u00b7\7n\2\2\u00b7\u00b8\7f\2\2\u00b8"+
		"\u00b9\7g\2\2\u00b9\u00c4\7t\2\2\u00ba\u00bb\7t\2\2\u00bb\u00bc\7g\2\2"+
		"\u00bc\u00bd\7i\2\2\u00bd\u00be\7g\2\2\u00be\u00c4\7z\2\2\u00bf\u00c0"+
		"\7w\2\2\u00c0\u00c1\7v\2\2\u00c1\u00c2\7k\2\2\u00c2\u00c4\7n\2\2\u00c3"+
		"\u00b3\3\2\2\2\u00c3\u00ba\3\2\2\2\u00c3\u00bf\3\2\2\2\u00c4\"\3\2\2\2"+
		"\u00c5\u00c6\7u\2\2\u00c6\u00c7\7v\2\2\u00c7\u00c8\7w\2\2\u00c8\u00c9"+
		"\7d\2\2\u00c9$\3\2\2\2\u00ca\u00cc\5\25\13\2\u00cb\u00cd\5\27\f\2\u00cc"+
		"\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cf\3\2"+
		"\2\2\u00cf&\3\2\2\2\u00d0\u00d2\5%\23\2\u00d1\u00d0\3\2\2\2\u00d2\u00d3"+
		"\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4(\3\2\2\2\u00d5"+
		"\u00d7\5\27\f\2\u00d6\u00d5\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d6\3"+
		"\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00dd\3\2\2\2\u00da\u00dc\5%\23\2\u00db"+
		"\u00da\3\2\2\2\u00dc\u00df\3\2\2\2\u00dd\u00db\3\2\2\2\u00dd\u00de\3\2"+
		"\2\2\u00de*\3\2\2\2\u00df\u00dd\3\2\2\2\u00e0\u00e5\5\'\24\2\u00e1\u00e2"+
		"\5=\37\2\u00e2\u00e3\5+\26\2\u00e3\u00e4\5? \2\u00e4\u00e6\3\2\2\2\u00e5"+
		"\u00e1\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6,\3\2\2\2\u00e7\u00e8\7\60\2\2"+
		"\u00e8.\3\2\2\2\u00e9\u00ea\7.\2\2\u00ea\60\3\2\2\2\u00eb\u00ec\7<\2\2"+
		"\u00ec\62\3\2\2\2\u00ed\u00ee\7=\2\2\u00ee\64\3\2\2\2\u00ef\u00f0\7?\2"+
		"\2\u00f0\66\3\2\2\2\u00f1\u00f2\7-\2\2\u00f28\3\2\2\2\u00f3\u00f4\7/\2"+
		"\2\u00f4:\3\2\2\2\u00f5\u00f6\7,\2\2\u00f6<\3\2\2\2\u00f7\u00f8\7>\2\2"+
		"\u00f8>\3\2\2\2\u00f9\u00fa\7@\2\2\u00fa@\3\2\2\2\u00fb\u00fc\7*\2\2\u00fc"+
		"B\3\2\2\2\u00fd\u00fe\7+\2\2\u00feD\3\2\2\2\u00ff\u0100\7}\2\2\u0100F"+
		"\3\2\2\2\u0101\u0102\7\177\2\2\u0102H\3\2\2\2\u0103\u0105\n\b\2\2\u0104"+
		"\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0104\3\2\2\2\u0106\u0107\3\2"+
		"\2\2\u0107J\3\2\2\2\23\2RZepuz\u0080\u0084\u008b\u00c3\u00ce\u00d3\u00d8"+
		"\u00dd\u00e5\u0106\4\2\3\2\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}