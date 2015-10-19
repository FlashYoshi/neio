// Generated from Document.g4 by ANTLR 4.5.1
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
public class DocumentLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, HEADER=2, DOCUMENT_TYPE=3, COMMENT=4, MULTILINE_COMMENT=5, WORD=6, 
		WORDS=7, WS=8, NEWLINE=9;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "HEADER", "DOCUMENT_TYPE", "COMMENT", "MULTILINE_COMMENT", "WORD", 
		"WORDS", "WS", "NEWLINE"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'#'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "HEADER", "DOCUMENT_TYPE", "COMMENT", "MULTILINE_COMMENT", 
		"WORD", "WORDS", "WS", "NEWLINE"
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
	public String getGrammarFileName() { return "Document.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\13d\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2"+
		"\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\5\4*\n\4\3\5\3\5\3\5\3\5\7\5\60\n\5\f\5\16\5\63\13\5\3\5\3\5\3\6\3"+
		"\6\3\6\3\6\7\6;\n\6\f\6\16\6>\13\6\3\6\3\6\3\6\3\6\3\6\3\7\6\7F\n\7\r"+
		"\7\16\7G\3\b\7\bK\n\b\f\b\16\bN\13\b\3\b\3\b\7\bR\n\b\f\b\16\bU\13\b\6"+
		"\bW\n\b\r\b\16\bX\3\t\6\t\\\n\t\r\t\16\t]\3\n\5\na\n\n\3\n\3\n\4\61<\2"+
		"\13\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\3\2\5\4\2\f\f\17\17\6\2\13"+
		"\f\17\17\"\"%%\4\2\13\13\"\"l\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t"+
		"\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2"+
		"\2\3\25\3\2\2\2\5\27\3\2\2\2\7)\3\2\2\2\t+\3\2\2\2\13\66\3\2\2\2\rE\3"+
		"\2\2\2\17V\3\2\2\2\21[\3\2\2\2\23`\3\2\2\2\25\26\7%\2\2\26\4\3\2\2\2\27"+
		"\30\7]\2\2\30\31\5\7\4\2\31\32\7_\2\2\32\6\3\2\2\2\33\34\7F\2\2\34\35"+
		"\7q\2\2\35\36\7e\2\2\36\37\7w\2\2\37 \7o\2\2 !\7g\2\2!\"\7p\2\2\"*\7v"+
		"\2\2#$\7U\2\2$%\7n\2\2%&\7k\2\2&\'\7f\2\2\'(\7g\2\2(*\7u\2\2)\33\3\2\2"+
		"\2)#\3\2\2\2*\b\3\2\2\2+,\7\61\2\2,-\7\61\2\2-\61\3\2\2\2.\60\n\2\2\2"+
		"/.\3\2\2\2\60\63\3\2\2\2\61\62\3\2\2\2\61/\3\2\2\2\62\64\3\2\2\2\63\61"+
		"\3\2\2\2\64\65\b\5\2\2\65\n\3\2\2\2\66\67\7\61\2\2\678\7,\2\28<\3\2\2"+
		"\29;\13\2\2\2:9\3\2\2\2;>\3\2\2\2<=\3\2\2\2<:\3\2\2\2=?\3\2\2\2><\3\2"+
		"\2\2?@\7,\2\2@A\7\61\2\2AB\3\2\2\2BC\b\6\2\2C\f\3\2\2\2DF\n\3\2\2ED\3"+
		"\2\2\2FG\3\2\2\2GE\3\2\2\2GH\3\2\2\2H\16\3\2\2\2IK\5\21\t\2JI\3\2\2\2"+
		"KN\3\2\2\2LJ\3\2\2\2LM\3\2\2\2MO\3\2\2\2NL\3\2\2\2OS\5\r\7\2PR\5\21\t"+
		"\2QP\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2TW\3\2\2\2US\3\2\2\2VL\3\2\2"+
		"\2WX\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y\20\3\2\2\2Z\\\t\4\2\2[Z\3\2\2\2\\]\3"+
		"\2\2\2][\3\2\2\2]^\3\2\2\2^\22\3\2\2\2_a\7\17\2\2`_\3\2\2\2`a\3\2\2\2"+
		"ab\3\2\2\2bc\7\f\2\2c\24\3\2\2\2\f\2)\61<GLSX]`\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}