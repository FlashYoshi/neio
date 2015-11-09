// Generated from B:\Documents\GitHub\neio\neio\src\main\grammar\DocumentLexer.g4 by ANTLR 4.2.2
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
public class DocumentLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		HEADER=1, COMMENT=2, MULTILINE_COMMENT=3, WS=4, NL=5, STUB=6, PERIOD=7, 
		COMMA=8, COLON=9, SEMICOLON=10, EQUALS=11, PLUS=12, MINUS=13, STAR=14, 
		SMALLER=15, BIGGER=16, HASH=17, L_BRACE=18, R_BRACE=19, L_CURLY_BRACE=20, 
		R_CURLY_BRACE=21, L_SQ_BRACE=22, R_SQ_BRACE=23, DOUBLE_QUOTE=24, WORD=25;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"HEADER", "COMMENT", "MULTILINE_COMMENT", "WS", "NL", "'stub'", "'.'", 
		"','", "':'", "';'", "'='", "'+'", "'-'", "'*'", "'<'", "'>'", "'#'", 
		"'('", "')'", "'{'", "'}'", "'['", "']'", "'\"'", "WORD"
	};
	public static final String[] ruleNames = {
		"HEADER", "COMMENT", "MULTILINE_COMMENT", "WS", "NL", "CHAR", "VALID_CHAR", 
		"STUB", "PERIOD", "COMMA", "COLON", "SEMICOLON", "EQUALS", "PLUS", "MINUS", 
		"STAR", "SMALLER", "BIGGER", "HASH", "L_BRACE", "R_BRACE", "L_CURLY_BRACE", 
		"R_CURLY_BRACE", "L_SQ_BRACE", "R_SQ_BRACE", "DOUBLE_QUOTE", "WORD"
	};


	public DocumentLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "DocumentLexer.g4"; }

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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\33\u009f\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\6\2<\n\2\r\2\16\2=\3\2\3\2"+
		"\3\3\3\3\3\3\3\3\7\3F\n\3\f\3\16\3I\13\3\3\3\6\3L\n\3\r\3\16\3M\3\3\3"+
		"\3\3\4\3\4\3\4\3\4\7\4V\n\4\f\4\16\4Y\13\4\3\4\3\4\3\4\3\4\6\4_\n\4\r"+
		"\4\16\4`\3\4\3\4\3\5\3\5\3\5\3\5\3\6\5\6j\n\6\3\6\3\6\3\7\3\7\3\b\3\b"+
		"\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17"+
		"\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26"+
		"\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\6\34\u009c"+
		"\n\34\r\34\16\34\u009d\3W\2\35\3\3\5\4\7\5\t\6\13\7\r\2\17\2\21\b\23\t"+
		"\25\n\27\13\31\f\33\r\35\16\37\17!\20#\21%\22\'\23)\24+\25-\26/\27\61"+
		"\30\63\31\65\32\67\33\3\2\6\4\2\f\f\17\17\4\2\13\13\"\"\5\2\62;C\\c|\n"+
		"\2##))..\60\60\62;AAC\\c|\u00a3\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2"+
		"/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\39\3\2\2"+
		"\2\5A\3\2\2\2\7Q\3\2\2\2\td\3\2\2\2\13i\3\2\2\2\rm\3\2\2\2\17o\3\2\2\2"+
		"\21q\3\2\2\2\23v\3\2\2\2\25x\3\2\2\2\27z\3\2\2\2\31|\3\2\2\2\33~\3\2\2"+
		"\2\35\u0080\3\2\2\2\37\u0082\3\2\2\2!\u0084\3\2\2\2#\u0086\3\2\2\2%\u0088"+
		"\3\2\2\2\'\u008a\3\2\2\2)\u008c\3\2\2\2+\u008e\3\2\2\2-\u0090\3\2\2\2"+
		"/\u0092\3\2\2\2\61\u0094\3\2\2\2\63\u0096\3\2\2\2\65\u0098\3\2\2\2\67"+
		"\u009b\3\2\2\29;\5\61\31\2:<\5\r\7\2;:\3\2\2\2<=\3\2\2\2=;\3\2\2\2=>\3"+
		"\2\2\2>?\3\2\2\2?@\5\63\32\2@\4\3\2\2\2AB\7\61\2\2BC\7\61\2\2CG\3\2\2"+
		"\2DF\n\2\2\2ED\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2\2\2HK\3\2\2\2IG\3\2\2"+
		"\2JL\5\13\6\2KJ\3\2\2\2LM\3\2\2\2MK\3\2\2\2MN\3\2\2\2NO\3\2\2\2OP\b\3"+
		"\2\2P\6\3\2\2\2QR\7\61\2\2RS\7,\2\2SW\3\2\2\2TV\13\2\2\2UT\3\2\2\2VY\3"+
		"\2\2\2WX\3\2\2\2WU\3\2\2\2XZ\3\2\2\2YW\3\2\2\2Z[\7,\2\2[\\\7\61\2\2\\"+
		"^\3\2\2\2]_\5\13\6\2^]\3\2\2\2_`\3\2\2\2`^\3\2\2\2`a\3\2\2\2ab\3\2\2\2"+
		"bc\b\4\2\2c\b\3\2\2\2de\t\3\2\2ef\3\2\2\2fg\b\5\2\2g\n\3\2\2\2hj\7\17"+
		"\2\2ih\3\2\2\2ij\3\2\2\2jk\3\2\2\2kl\7\f\2\2l\f\3\2\2\2mn\t\4\2\2n\16"+
		"\3\2\2\2op\t\5\2\2p\20\3\2\2\2qr\7u\2\2rs\7v\2\2st\7w\2\2tu\7d\2\2u\22"+
		"\3\2\2\2vw\7\60\2\2w\24\3\2\2\2xy\7.\2\2y\26\3\2\2\2z{\7<\2\2{\30\3\2"+
		"\2\2|}\7=\2\2}\32\3\2\2\2~\177\7?\2\2\177\34\3\2\2\2\u0080\u0081\7-\2"+
		"\2\u0081\36\3\2\2\2\u0082\u0083\7/\2\2\u0083 \3\2\2\2\u0084\u0085\7,\2"+
		"\2\u0085\"\3\2\2\2\u0086\u0087\7>\2\2\u0087$\3\2\2\2\u0088\u0089\7@\2"+
		"\2\u0089&\3\2\2\2\u008a\u008b\7%\2\2\u008b(\3\2\2\2\u008c\u008d\7*\2\2"+
		"\u008d*\3\2\2\2\u008e\u008f\7+\2\2\u008f,\3\2\2\2\u0090\u0091\7}\2\2\u0091"+
		".\3\2\2\2\u0092\u0093\7\177\2\2\u0093\60\3\2\2\2\u0094\u0095\7]\2\2\u0095"+
		"\62\3\2\2\2\u0096\u0097\7_\2\2\u0097\64\3\2\2\2\u0098\u0099\7$\2\2\u0099"+
		"\66\3\2\2\2\u009a\u009c\5\17\b\2\u009b\u009a\3\2\2\2\u009c\u009d\3\2\2"+
		"\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e8\3\2\2\2\n\2=GMW`i\u009d"+
		"\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}