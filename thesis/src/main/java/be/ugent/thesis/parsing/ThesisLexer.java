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
		EXTENDS=7, IMPLEMENTS=8, RETURN=9, NEW=10, METHOD_OPTION=11, STUB=12, 
		CLASS_NAME=13, CAMEL_CASE=14, VAR_WITH_TYPE=15, PERIOD=16, COMMA=17, COLON=18, 
		SEMICOLON=19, EQUALS=20, PLUS=21, MINUS=22, STAR=23, SMALLER=24, BIGGER=25, 
		LEFT_BRACE=26, RIGHT_BRACE=27, LEFT_CURLY_BRACE=28, RIGHT_CURLY_BRACE=29, 
		METHOD_NAME=30;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"HEADER", "HEADER_CONTENT", "COMMENT", "MULTILINE_COMMENT", "PACKAGE", 
		"WS", "NEWLINE", "CAPITAL", "LETTER", "CHAR", "EXTENDS", "IMPLEMENTS", 
		"RETURN", "NEW", "METHOD_OPTION", "STUB", "CAPITALED", "CLASS_NAME", "CAMEL_CASE", 
		"VAR_WITH_TYPE", "PERIOD", "COMMA", "COLON", "SEMICOLON", "EQUALS", "PLUS", 
		"MINUS", "STAR", "SMALLER", "BIGGER", "LEFT_BRACE", "RIGHT_BRACE", "LEFT_CURLY_BRACE", 
		"RIGHT_CURLY_BRACE", "METHOD_NAME"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, "'extends'", "'implements'", 
		"'return'", "'new'", null, "'stub'", null, null, null, "'.'", "','", "':'", 
		"';'", "'='", "'+'", "'-'", "'*'", "'<'", "'>'", "'('", "')'", "'{'", 
		"'}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "HEADER", "COMMENT", "MULTILINE_COMMENT", "PACKAGE", "WS", "NEWLINE", 
		"EXTENDS", "IMPLEMENTS", "RETURN", "NEW", "METHOD_OPTION", "STUB", "CLASS_NAME", 
		"CAMEL_CASE", "VAR_WITH_TYPE", "PERIOD", "COMMA", "COLON", "SEMICOLON", 
		"EQUALS", "PLUS", "MINUS", "STAR", "SMALLER", "BIGGER", "LEFT_BRACE", 
		"RIGHT_BRACE", "LEFT_CURLY_BRACE", "RIGHT_CURLY_BRACE", "METHOD_NAME"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2 \u00fe\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\3\2\3\2\3\2\3\2\3\3\6\3O\n\3\r\3\16\3P\3\4\3\4"+
		"\3\4\3\4\7\4W\n\4\f\4\16\4Z\13\4\3\4\3\4\3\5\3\5\3\5\3\5\7\5b\n\5\f\5"+
		"\16\5e\13\5\3\5\3\5\3\5\3\5\3\5\3\6\6\6m\n\6\r\6\16\6n\3\6\3\6\6\6s\n"+
		"\6\r\6\16\6t\6\6w\n\6\r\6\16\6x\3\7\3\7\3\7\3\7\3\b\5\b\u0080\n\b\3\b"+
		"\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00ba\n\20\3\21\3\21\3\21"+
		"\3\21\3\21\3\22\3\22\6\22\u00c3\n\22\r\22\16\22\u00c4\3\23\6\23\u00c8"+
		"\n\23\r\23\16\23\u00c9\3\24\6\24\u00cd\n\24\r\24\16\24\u00ce\3\24\7\24"+
		"\u00d2\n\24\f\24\16\24\u00d5\13\24\3\25\3\25\3\25\3\25\3\25\5\25\u00dc"+
		"\n\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34"+
		"\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\6$\u00fb"+
		"\n$\r$\16$\u00fc\3c\2%\3\3\5\2\7\4\t\5\13\6\r\7\17\b\21\2\23\2\25\2\27"+
		"\t\31\n\33\13\35\f\37\r!\16#\2%\17\'\20)\21+\22-\23/\24\61\25\63\26\65"+
		"\27\67\309\31;\32=\33?\34A\35C\36E\37G \3\2\b\4\2\f\f\17\17\4\2\13\13"+
		"\"\"\3\2C\\\3\2c|\5\2\62;C\\c|\7\2\13\f\17\17\"\"*+==\u0107\2\3\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2"+
		"\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2"+
		"\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2"+
		"\3I\3\2\2\2\5N\3\2\2\2\7R\3\2\2\2\t]\3\2\2\2\13l\3\2\2\2\rz\3\2\2\2\17"+
		"\177\3\2\2\2\21\u0085\3\2\2\2\23\u0087\3\2\2\2\25\u0089\3\2\2\2\27\u008b"+
		"\3\2\2\2\31\u0093\3\2\2\2\33\u009e\3\2\2\2\35\u00a5\3\2\2\2\37\u00b9\3"+
		"\2\2\2!\u00bb\3\2\2\2#\u00c0\3\2\2\2%\u00c7\3\2\2\2\'\u00cc\3\2\2\2)\u00d6"+
		"\3\2\2\2+\u00dd\3\2\2\2-\u00df\3\2\2\2/\u00e1\3\2\2\2\61\u00e3\3\2\2\2"+
		"\63\u00e5\3\2\2\2\65\u00e7\3\2\2\2\67\u00e9\3\2\2\29\u00eb\3\2\2\2;\u00ed"+
		"\3\2\2\2=\u00ef\3\2\2\2?\u00f1\3\2\2\2A\u00f3\3\2\2\2C\u00f5\3\2\2\2E"+
		"\u00f7\3\2\2\2G\u00fa\3\2\2\2IJ\7]\2\2JK\5\5\3\2KL\7_\2\2L\4\3\2\2\2M"+
		"O\5\25\13\2NM\3\2\2\2OP\3\2\2\2PN\3\2\2\2PQ\3\2\2\2Q\6\3\2\2\2RS\7\61"+
		"\2\2ST\7\61\2\2TX\3\2\2\2UW\n\2\2\2VU\3\2\2\2WZ\3\2\2\2XV\3\2\2\2XY\3"+
		"\2\2\2Y[\3\2\2\2ZX\3\2\2\2[\\\b\4\2\2\\\b\3\2\2\2]^\7\61\2\2^_\7,\2\2"+
		"_c\3\2\2\2`b\13\2\2\2a`\3\2\2\2be\3\2\2\2cd\3\2\2\2ca\3\2\2\2df\3\2\2"+
		"\2ec\3\2\2\2fg\7,\2\2gh\7\61\2\2hi\3\2\2\2ij\b\5\2\2j\n\3\2\2\2km\5\25"+
		"\13\2lk\3\2\2\2mn\3\2\2\2nl\3\2\2\2no\3\2\2\2ov\3\2\2\2pr\5+\26\2qs\5"+
		"\25\13\2rq\3\2\2\2st\3\2\2\2tr\3\2\2\2tu\3\2\2\2uw\3\2\2\2vp\3\2\2\2w"+
		"x\3\2\2\2xv\3\2\2\2xy\3\2\2\2y\f\3\2\2\2z{\t\3\2\2{|\3\2\2\2|}\b\7\2\2"+
		"}\16\3\2\2\2~\u0080\7\17\2\2\177~\3\2\2\2\177\u0080\3\2\2\2\u0080\u0081"+
		"\3\2\2\2\u0081\u0082\7\f\2\2\u0082\u0083\3\2\2\2\u0083\u0084\b\b\3\2\u0084"+
		"\20\3\2\2\2\u0085\u0086\t\4\2\2\u0086\22\3\2\2\2\u0087\u0088\t\5\2\2\u0088"+
		"\24\3\2\2\2\u0089\u008a\t\6\2\2\u008a\26\3\2\2\2\u008b\u008c\7g\2\2\u008c"+
		"\u008d\7z\2\2\u008d\u008e\7v\2\2\u008e\u008f\7g\2\2\u008f\u0090\7p\2\2"+
		"\u0090\u0091\7f\2\2\u0091\u0092\7u\2\2\u0092\30\3\2\2\2\u0093\u0094\7"+
		"k\2\2\u0094\u0095\7o\2\2\u0095\u0096\7r\2\2\u0096\u0097\7n\2\2\u0097\u0098"+
		"\7g\2\2\u0098\u0099\7o\2\2\u0099\u009a\7g\2\2\u009a\u009b\7p\2\2\u009b"+
		"\u009c\7v\2\2\u009c\u009d\7u\2\2\u009d\32\3\2\2\2\u009e\u009f\7t\2\2\u009f"+
		"\u00a0\7g\2\2\u00a0\u00a1\7v\2\2\u00a1\u00a2\7w\2\2\u00a2\u00a3\7t\2\2"+
		"\u00a3\u00a4\7p\2\2\u00a4\34\3\2\2\2\u00a5\u00a6\7p\2\2\u00a6\u00a7\7"+
		"g\2\2\u00a7\u00a8\7y\2\2\u00a8\36\3\2\2\2\u00a9\u00aa\7d\2\2\u00aa\u00ab"+
		"\7w\2\2\u00ab\u00ac\7k\2\2\u00ac\u00ad\7n\2\2\u00ad\u00ae\7f\2\2\u00ae"+
		"\u00af\7g\2\2\u00af\u00ba\7t\2\2\u00b0\u00b1\7t\2\2\u00b1\u00b2\7g\2\2"+
		"\u00b2\u00b3\7i\2\2\u00b3\u00b4\7g\2\2\u00b4\u00ba\7z\2\2\u00b5\u00b6"+
		"\7w\2\2\u00b6\u00b7\7v\2\2\u00b7\u00b8\7k\2\2\u00b8\u00ba\7n\2\2\u00b9"+
		"\u00a9\3\2\2\2\u00b9\u00b0\3\2\2\2\u00b9\u00b5\3\2\2\2\u00ba \3\2\2\2"+
		"\u00bb\u00bc\7u\2\2\u00bc\u00bd\7v\2\2\u00bd\u00be\7w\2\2\u00be\u00bf"+
		"\7d\2\2\u00bf\"\3\2\2\2\u00c0\u00c2\5\21\t\2\u00c1\u00c3\5\23\n\2\u00c2"+
		"\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c5\3\2"+
		"\2\2\u00c5$\3\2\2\2\u00c6\u00c8\5#\22\2\u00c7\u00c6\3\2\2\2\u00c8\u00c9"+
		"\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca&\3\2\2\2\u00cb"+
		"\u00cd\5\23\n\2\u00cc\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00cc\3"+
		"\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d3\3\2\2\2\u00d0\u00d2\5#\22\2\u00d1"+
		"\u00d0\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d4\3\2"+
		"\2\2\u00d4(\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d6\u00db\5%\23\2\u00d7\u00d8"+
		"\5;\36\2\u00d8\u00d9\5)\25\2\u00d9\u00da\5=\37\2\u00da\u00dc\3\2\2\2\u00db"+
		"\u00d7\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc*\3\2\2\2\u00dd\u00de\7\60\2\2"+
		"\u00de,\3\2\2\2\u00df\u00e0\7.\2\2\u00e0.\3\2\2\2\u00e1\u00e2\7<\2\2\u00e2"+
		"\60\3\2\2\2\u00e3\u00e4\7=\2\2\u00e4\62\3\2\2\2\u00e5\u00e6\7?\2\2\u00e6"+
		"\64\3\2\2\2\u00e7\u00e8\7-\2\2\u00e8\66\3\2\2\2\u00e9\u00ea\7/\2\2\u00ea"+
		"8\3\2\2\2\u00eb\u00ec\7,\2\2\u00ec:\3\2\2\2\u00ed\u00ee\7>\2\2\u00ee<"+
		"\3\2\2\2\u00ef\u00f0\7@\2\2\u00f0>\3\2\2\2\u00f1\u00f2\7*\2\2\u00f2@\3"+
		"\2\2\2\u00f3\u00f4\7+\2\2\u00f4B\3\2\2\2\u00f5\u00f6\7}\2\2\u00f6D\3\2"+
		"\2\2\u00f7\u00f8\7\177\2\2\u00f8F\3\2\2\2\u00f9\u00fb\n\7\2\2\u00fa\u00f9"+
		"\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd"+
		"H\3\2\2\2\21\2PXcntx\177\u00b9\u00c4\u00c9\u00ce\u00d3\u00db\u00fc\4\2"+
		"\3\2\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}