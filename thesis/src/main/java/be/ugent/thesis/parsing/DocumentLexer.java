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
		T__0=1, HEADER=2, COMMENT=3, MULTILINE_COMMENT=4, WORD=5, NEWLINE=6;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "HEADER", "COMMENT", "MULTILINE_COMMENT", "WORD", "NEWLINE"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'#'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "HEADER", "COMMENT", "MULTILINE_COMMENT", "WORD", "NEWLINE"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\bH\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3$\n\3\3\4\3\4\3\4"+
		"\3\4\7\4*\n\4\f\4\16\4-\13\4\3\4\3\4\3\5\3\5\3\5\3\5\7\5\65\n\5\f\5\16"+
		"\58\13\5\3\5\3\5\3\5\3\5\3\5\3\6\6\6@\n\6\r\6\16\6A\3\7\5\7E\n\7\3\7\3"+
		"\7\3\66\2\b\3\3\5\4\7\5\t\6\13\7\r\b\3\2\4\4\2\f\f\17\17\5\2\62;C\\c|"+
		"L\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\3\17\3\2\2\2\5#\3\2\2\2\7%\3\2\2\2\t\60\3\2\2\2\13?\3\2\2\2\rD\3"+
		"\2\2\2\17\20\7%\2\2\20\4\3\2\2\2\21\22\7]\2\2\22\23\7F\2\2\23\24\7q\2"+
		"\2\24\25\7e\2\2\25\26\7w\2\2\26\27\7o\2\2\27\30\7g\2\2\30\31\7p\2\2\31"+
		"\32\7v\2\2\32$\7_\2\2\33\34\7]\2\2\34\35\7U\2\2\35\36\7n\2\2\36\37\7k"+
		"\2\2\37 \7f\2\2 !\7g\2\2!\"\7u\2\2\"$\7_\2\2#\21\3\2\2\2#\33\3\2\2\2$"+
		"\6\3\2\2\2%&\7\61\2\2&\'\7\61\2\2\'+\3\2\2\2(*\n\2\2\2)(\3\2\2\2*-\3\2"+
		"\2\2+)\3\2\2\2+,\3\2\2\2,.\3\2\2\2-+\3\2\2\2./\b\4\2\2/\b\3\2\2\2\60\61"+
		"\7\61\2\2\61\62\7,\2\2\62\66\3\2\2\2\63\65\13\2\2\2\64\63\3\2\2\2\658"+
		"\3\2\2\2\66\67\3\2\2\2\66\64\3\2\2\2\679\3\2\2\28\66\3\2\2\29:\7,\2\2"+
		":;\7\61\2\2;<\3\2\2\2<=\b\5\2\2=\n\3\2\2\2>@\t\3\2\2?>\3\2\2\2@A\3\2\2"+
		"\2A?\3\2\2\2AB\3\2\2\2B\f\3\2\2\2CE\7\17\2\2DC\3\2\2\2DE\3\2\2\2EF\3\2"+
		"\2\2FG\7\f\2\2G\16\3\2\2\2\b\2#+\66AD\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}