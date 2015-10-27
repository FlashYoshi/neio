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
		HEADER=1, HEADER_CONTENT=2, COMMENT=3, MULTILINE_COMMENT=4, WORD=5, WORDS=6, 
		WS=7, NEWLINE=8, HASH=9;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"HEADER", "HEADER_CONTENT", "COMMENT", "MULTILINE_COMMENT", "WORD", "WORDS", 
		"WS", "NEWLINE", "HASH"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, null, null, "'#'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "HEADER", "HEADER_CONTENT", "COMMENT", "MULTILINE_COMMENT", "WORD", 
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\13X\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2"+
		"\3\2\3\2\3\3\6\3\33\n\3\r\3\16\3\34\3\4\3\4\3\4\3\4\7\4#\n\4\f\4\16\4"+
		"&\13\4\3\4\3\4\3\5\3\5\3\5\3\5\7\5.\n\5\f\5\16\5\61\13\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\6\6\69\n\6\r\6\16\6:\3\7\7\7>\n\7\f\7\16\7A\13\7\3\7\3\7\7\7"+
		"E\n\7\f\7\16\7H\13\7\6\7J\n\7\r\7\16\7K\3\b\3\b\3\t\5\tQ\n\t\3\t\3\t\3"+
		"\t\3\t\3\n\3\n\3/\2\13\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\3\2\6"+
		"\3\2]_\4\2\f\f\17\17\6\2\13\f\17\17\"\"%%\4\2\13\13\"\"_\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\2\23\3\2\2\2\3\25\3\2\2\2\5\32\3\2\2\2\7\36\3\2\2\2\t"+
		")\3\2\2\2\138\3\2\2\2\rI\3\2\2\2\17M\3\2\2\2\21P\3\2\2\2\23V\3\2\2\2\25"+
		"\26\7]\2\2\26\27\5\5\3\2\27\30\7_\2\2\30\4\3\2\2\2\31\33\n\2\2\2\32\31"+
		"\3\2\2\2\33\34\3\2\2\2\34\32\3\2\2\2\34\35\3\2\2\2\35\6\3\2\2\2\36\37"+
		"\7\61\2\2\37 \7\61\2\2 $\3\2\2\2!#\n\3\2\2\"!\3\2\2\2#&\3\2\2\2$\"\3\2"+
		"\2\2$%\3\2\2\2%\'\3\2\2\2&$\3\2\2\2\'(\b\4\2\2(\b\3\2\2\2)*\7\61\2\2*"+
		"+\7,\2\2+/\3\2\2\2,.\13\2\2\2-,\3\2\2\2.\61\3\2\2\2/\60\3\2\2\2/-\3\2"+
		"\2\2\60\62\3\2\2\2\61/\3\2\2\2\62\63\7,\2\2\63\64\7\61\2\2\64\65\3\2\2"+
		"\2\65\66\b\5\2\2\66\n\3\2\2\2\679\n\4\2\28\67\3\2\2\29:\3\2\2\2:8\3\2"+
		"\2\2:;\3\2\2\2;\f\3\2\2\2<>\5\17\b\2=<\3\2\2\2>A\3\2\2\2?=\3\2\2\2?@\3"+
		"\2\2\2@B\3\2\2\2A?\3\2\2\2BF\5\13\6\2CE\5\17\b\2DC\3\2\2\2EH\3\2\2\2F"+
		"D\3\2\2\2FG\3\2\2\2GJ\3\2\2\2HF\3\2\2\2I?\3\2\2\2JK\3\2\2\2KI\3\2\2\2"+
		"KL\3\2\2\2L\16\3\2\2\2MN\t\5\2\2N\20\3\2\2\2OQ\7\17\2\2PO\3\2\2\2PQ\3"+
		"\2\2\2QR\3\2\2\2RS\7\f\2\2ST\3\2\2\2TU\b\t\2\2U\22\3\2\2\2VW\7%\2\2W\24"+
		"\3\2\2\2\13\2\34$/:?FKP\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}