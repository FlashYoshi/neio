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
		HEADER=1, COMMENT=2, MULTILINE_COMMENT=3, WORD=4, NEWLINE=5;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"HEADER", "COMMENT", "MULTILINE_COMMENT", "WORD", "NEWLINE"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "HEADER", "COMMENT", "MULTILINE_COMMENT", "WORD", "NEWLINE"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\7D\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2 \n\2\3\3\3\3\3\3\3\3\7\3&\n\3\f\3"+
		"\16\3)\13\3\3\3\3\3\3\4\3\4\3\4\3\4\7\4\61\n\4\f\4\16\4\64\13\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\5\6\5<\n\5\r\5\16\5=\3\6\5\6A\n\6\3\6\3\6\3\62\2\7\3"+
		"\3\5\4\7\5\t\6\13\7\3\2\4\4\2\f\f\17\17\5\2\62;C\\c|H\2\3\3\2\2\2\2\5"+
		"\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\3\37\3\2\2\2\5!\3\2\2\2"+
		"\7,\3\2\2\2\t;\3\2\2\2\13@\3\2\2\2\r\16\7]\2\2\16\17\7F\2\2\17\20\7q\2"+
		"\2\20\21\7e\2\2\21\22\7w\2\2\22\23\7o\2\2\23\24\7g\2\2\24\25\7p\2\2\25"+
		"\26\7v\2\2\26 \7_\2\2\27\30\7]\2\2\30\31\7U\2\2\31\32\7n\2\2\32\33\7k"+
		"\2\2\33\34\7f\2\2\34\35\7g\2\2\35\36\7u\2\2\36 \7_\2\2\37\r\3\2\2\2\37"+
		"\27\3\2\2\2 \4\3\2\2\2!\"\7\61\2\2\"#\7\61\2\2#\'\3\2\2\2$&\n\2\2\2%$"+
		"\3\2\2\2&)\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2(*\3\2\2\2)\'\3\2\2\2*+\b\3\2"+
		"\2+\6\3\2\2\2,-\7\61\2\2-.\7,\2\2.\62\3\2\2\2/\61\13\2\2\2\60/\3\2\2\2"+
		"\61\64\3\2\2\2\62\63\3\2\2\2\62\60\3\2\2\2\63\65\3\2\2\2\64\62\3\2\2\2"+
		"\65\66\7,\2\2\66\67\7\61\2\2\678\3\2\2\289\b\4\2\29\b\3\2\2\2:<\t\3\2"+
		"\2;:\3\2\2\2<=\3\2\2\2=;\3\2\2\2=>\3\2\2\2>\n\3\2\2\2?A\7\17\2\2@?\3\2"+
		"\2\2@A\3\2\2\2AB\3\2\2\2BC\7\f\2\2C\f\3\2\2\2\b\2\37\'\62=@\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}