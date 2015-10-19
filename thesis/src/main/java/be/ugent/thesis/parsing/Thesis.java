// Generated from Thesis.g4 by ANTLR 4.5.1
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
public class Thesis extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		HEADER=1, DOCUMENT_TYPE=2, COMMENT=3, MULTILINE_COMMENT=4, WORD=5, WORDS=6, 
		WS=7, NEWLINE=8;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"HEADER", "DOCUMENT_TYPE", "COMMENT", "MULTILINE_COMMENT", "WORD", "WORDS", 
		"WS", "NEWLINE"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "HEADER", "DOCUMENT_TYPE", "COMMENT", "MULTILINE_COMMENT", "WORD", 
		"WORDS", "WS", "NEWLINE"
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


	public Thesis(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Thesis.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\n`\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\3\2"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3&\n\3\3\4"+
		"\3\4\3\4\3\4\7\4,\n\4\f\4\16\4/\13\4\3\4\3\4\3\5\3\5\3\5\3\5\7\5\67\n"+
		"\5\f\5\16\5:\13\5\3\5\3\5\3\5\3\5\3\5\3\6\6\6B\n\6\r\6\16\6C\3\7\7\7G"+
		"\n\7\f\7\16\7J\13\7\3\7\3\7\7\7N\n\7\f\7\16\7Q\13\7\6\7S\n\7\r\7\16\7"+
		"T\3\b\6\bX\n\b\r\b\16\bY\3\t\5\t]\n\t\3\t\3\t\4-8\2\n\3\3\5\4\7\5\t\6"+
		"\13\7\r\b\17\t\21\n\3\2\5\4\2\f\f\17\17\6\2\13\f\17\17\"\"%%\4\2\13\13"+
		"\"\"h\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r"+
		"\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\3\23\3\2\2\2\5%\3\2\2\2\7\'\3\2\2\2"+
		"\t\62\3\2\2\2\13A\3\2\2\2\rR\3\2\2\2\17W\3\2\2\2\21\\\3\2\2\2\23\24\7"+
		"]\2\2\24\25\5\5\3\2\25\26\7_\2\2\26\4\3\2\2\2\27\30\7F\2\2\30\31\7q\2"+
		"\2\31\32\7e\2\2\32\33\7w\2\2\33\34\7o\2\2\34\35\7g\2\2\35\36\7p\2\2\36"+
		"&\7v\2\2\37 \7U\2\2 !\7n\2\2!\"\7k\2\2\"#\7f\2\2#$\7g\2\2$&\7u\2\2%\27"+
		"\3\2\2\2%\37\3\2\2\2&\6\3\2\2\2\'(\7\61\2\2()\7\61\2\2)-\3\2\2\2*,\n\2"+
		"\2\2+*\3\2\2\2,/\3\2\2\2-.\3\2\2\2-+\3\2\2\2.\60\3\2\2\2/-\3\2\2\2\60"+
		"\61\b\4\2\2\61\b\3\2\2\2\62\63\7\61\2\2\63\64\7,\2\2\648\3\2\2\2\65\67"+
		"\13\2\2\2\66\65\3\2\2\2\67:\3\2\2\289\3\2\2\28\66\3\2\2\29;\3\2\2\2:8"+
		"\3\2\2\2;<\7,\2\2<=\7\61\2\2=>\3\2\2\2>?\b\5\2\2?\n\3\2\2\2@B\n\3\2\2"+
		"A@\3\2\2\2BC\3\2\2\2CA\3\2\2\2CD\3\2\2\2D\f\3\2\2\2EG\5\17\b\2FE\3\2\2"+
		"\2GJ\3\2\2\2HF\3\2\2\2HI\3\2\2\2IK\3\2\2\2JH\3\2\2\2KO\5\13\6\2LN\5\17"+
		"\b\2ML\3\2\2\2NQ\3\2\2\2OM\3\2\2\2OP\3\2\2\2PS\3\2\2\2QO\3\2\2\2RH\3\2"+
		"\2\2ST\3\2\2\2TR\3\2\2\2TU\3\2\2\2U\16\3\2\2\2VX\t\4\2\2WV\3\2\2\2XY\3"+
		"\2\2\2YW\3\2\2\2YZ\3\2\2\2Z\20\3\2\2\2[]\7\17\2\2\\[\3\2\2\2\\]\3\2\2"+
		"\2]^\3\2\2\2^_\7\f\2\2_\22\3\2\2\2\f\2%-8CHOTY\\\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}