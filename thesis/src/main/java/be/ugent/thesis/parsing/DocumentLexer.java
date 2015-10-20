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
		HEADER=1, DOCUMENT_TYPE=2, COMMENT=3, MULTILINE_COMMENT=4, WORD=5, WORDS=6, 
		WS=7, NEWLINE=8, HASH=9;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"HEADER", "DOCUMENT_TYPE", "COMMENT", "MULTILINE_COMMENT", "WORD", "WORDS", 
		"WS", "NEWLINE", "HASH"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, null, null, "'#'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "HEADER", "DOCUMENT_TYPE", "COMMENT", "MULTILINE_COMMENT", "WORD", 
		"WORDS", "WS", "NEWLINE", "HASH"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\13c\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2"+
		"\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3("+
		"\n\3\3\4\3\4\3\4\3\4\7\4.\n\4\f\4\16\4\61\13\4\3\4\3\4\3\5\3\5\3\5\3\5"+
		"\7\59\n\5\f\5\16\5<\13\5\3\5\3\5\3\5\3\5\3\5\3\6\6\6D\n\6\r\6\16\6E\3"+
		"\7\7\7I\n\7\f\7\16\7L\13\7\3\7\3\7\7\7P\n\7\f\7\16\7S\13\7\6\7U\n\7\r"+
		"\7\16\7V\3\b\3\b\3\t\5\t\\\n\t\3\t\3\t\3\t\3\t\3\n\3\n\3:\2\13\3\3\5\4"+
		"\7\5\t\6\13\7\r\b\17\t\21\n\23\13\3\2\5\4\2\f\f\17\17\6\2\13\f\17\17\""+
		"\"%%\4\2\13\13\"\"j\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2"+
		"\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\3\25\3"+
		"\2\2\2\5\'\3\2\2\2\7)\3\2\2\2\t\64\3\2\2\2\13C\3\2\2\2\rT\3\2\2\2\17X"+
		"\3\2\2\2\21[\3\2\2\2\23a\3\2\2\2\25\26\7]\2\2\26\27\5\5\3\2\27\30\7_\2"+
		"\2\30\4\3\2\2\2\31\32\7F\2\2\32\33\7q\2\2\33\34\7e\2\2\34\35\7w\2\2\35"+
		"\36\7o\2\2\36\37\7g\2\2\37 \7p\2\2 (\7v\2\2!\"\7U\2\2\"#\7n\2\2#$\7k\2"+
		"\2$%\7f\2\2%&\7g\2\2&(\7u\2\2\'\31\3\2\2\2\'!\3\2\2\2(\6\3\2\2\2)*\7\61"+
		"\2\2*+\7\61\2\2+/\3\2\2\2,.\n\2\2\2-,\3\2\2\2.\61\3\2\2\2/-\3\2\2\2/\60"+
		"\3\2\2\2\60\62\3\2\2\2\61/\3\2\2\2\62\63\b\4\2\2\63\b\3\2\2\2\64\65\7"+
		"\61\2\2\65\66\7,\2\2\66:\3\2\2\2\679\13\2\2\28\67\3\2\2\29<\3\2\2\2:;"+
		"\3\2\2\2:8\3\2\2\2;=\3\2\2\2<:\3\2\2\2=>\7,\2\2>?\7\61\2\2?@\3\2\2\2@"+
		"A\b\5\2\2A\n\3\2\2\2BD\n\3\2\2CB\3\2\2\2DE\3\2\2\2EC\3\2\2\2EF\3\2\2\2"+
		"F\f\3\2\2\2GI\5\17\b\2HG\3\2\2\2IL\3\2\2\2JH\3\2\2\2JK\3\2\2\2KM\3\2\2"+
		"\2LJ\3\2\2\2MQ\5\13\6\2NP\5\17\b\2ON\3\2\2\2PS\3\2\2\2QO\3\2\2\2QR\3\2"+
		"\2\2RU\3\2\2\2SQ\3\2\2\2TJ\3\2\2\2UV\3\2\2\2VT\3\2\2\2VW\3\2\2\2W\16\3"+
		"\2\2\2XY\t\4\2\2Y\20\3\2\2\2Z\\\7\17\2\2[Z\3\2\2\2[\\\3\2\2\2\\]\3\2\2"+
		"\2]^\7\f\2\2^_\3\2\2\2_`\b\t\2\2`\22\3\2\2\2ab\7%\2\2b\24\3\2\2\2\13\2"+
		"\'/:EJQV[\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}