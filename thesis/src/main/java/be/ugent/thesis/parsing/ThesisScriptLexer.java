// Generated from B:\Documents\GitHub\Thesis\thesis\src\main\grammar\ThesisScriptLexer.g4 by ANTLR 4.2.2
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
public class ThesisScriptLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMENT=1, MULTILINE_COMMENT=2, WS=3, NL=4, NEW=5, SCRIPT=6, STUB=7, CLASS_NAME=8, 
		CAMEL_CASE=9, VAR_WITH_TYPE=10, STRING=11, PERIOD=12, COMMA=13, COLON=14, 
		SEMICOLON=15, EQUALS=16, PLUS=17, MINUS=18, STAR=19, SMALLER=20, BIGGER=21, 
		LEFT_BRACE=22, RIGHT_BRACE=23, LEFT_CURLY_BRACE=24, RIGHT_CURLY_BRACE=25, 
		DOUBLE_QUOTE=26, METHOD_NAME=27;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"COMMENT", "MULTILINE_COMMENT", "WS", "NL", "'new'", "'script'", "'stub'", 
		"CLASS_NAME", "CAMEL_CASE", "VAR_WITH_TYPE", "STRING", "'.'", "','", "':'", 
		"';'", "'='", "'+'", "'-'", "'*'", "'<'", "'>'", "'('", "')'", "'{'", 
		"'}'", "'\"'", "METHOD_NAME"
	};
	public static final String[] ruleNames = {
		"COMMENT", "MULTILINE_COMMENT", "WS", "NL", "CAPITAL", "LETTER", "CHAR", 
		"NEW", "SCRIPT", "STUB", "CAPITALED", "CLASS_NAME", "CAMEL_CASE", "VAR_WITH_TYPE", 
		"STRING", "PERIOD", "COMMA", "COLON", "SEMICOLON", "EQUALS", "PLUS", "MINUS", 
		"STAR", "SMALLER", "BIGGER", "LEFT_BRACE", "RIGHT_BRACE", "LEFT_CURLY_BRACE", 
		"RIGHT_CURLY_BRACE", "DOUBLE_QUOTE", "METHOD_NAME"
	};


	public ThesisScriptLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ThesisScriptLexer.g4"; }

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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\35\u00c4\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \3\2\3\2\3\2\3\2\7\2F\n\2\f\2\16\2I\13\2\3\2\3\2\3\3\3\3\3\3\3\3\7\3"+
		"Q\n\3\f\3\16\3T\13\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\5\5`\n\5"+
		"\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\6\f~\n\f\r\f\16\f\177"+
		"\3\r\6\r\u0083\n\r\r\r\16\r\u0084\3\16\6\16\u0088\n\16\r\16\16\16\u0089"+
		"\3\16\7\16\u008d\n\16\f\16\16\16\u0090\13\16\3\17\3\17\3\17\3\17\3\17"+
		"\5\17\u0097\n\17\3\20\3\20\7\20\u009b\n\20\f\20\16\20\u009e\13\20\3\20"+
		"\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27"+
		"\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36"+
		"\3\36\3\37\3\37\3 \6 \u00c1\n \r \16 \u00c2\4R\u009c\2!\3\3\5\4\7\5\t"+
		"\6\13\2\r\2\17\2\21\7\23\b\25\t\27\2\31\n\33\13\35\f\37\r!\16#\17%\20"+
		"\'\21)\22+\23-\24/\25\61\26\63\27\65\30\67\319\32;\33=\34?\35\3\2\b\4"+
		"\2\f\f\17\17\4\2\13\13\"\"\3\2C\\\3\2c|\5\2\62;C\\c|\t\2\13\f\17\17\""+
		"\"*+..\60\60<=\u00c9\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3"+
		"\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3"+
		"\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65"+
		"\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\3A\3"+
		"\2\2\2\5L\3\2\2\2\7Z\3\2\2\2\t_\3\2\2\2\13e\3\2\2\2\rg\3\2\2\2\17i\3\2"+
		"\2\2\21k\3\2\2\2\23o\3\2\2\2\25v\3\2\2\2\27{\3\2\2\2\31\u0082\3\2\2\2"+
		"\33\u0087\3\2\2\2\35\u0091\3\2\2\2\37\u0098\3\2\2\2!\u00a1\3\2\2\2#\u00a3"+
		"\3\2\2\2%\u00a5\3\2\2\2\'\u00a7\3\2\2\2)\u00a9\3\2\2\2+\u00ab\3\2\2\2"+
		"-\u00ad\3\2\2\2/\u00af\3\2\2\2\61\u00b1\3\2\2\2\63\u00b3\3\2\2\2\65\u00b5"+
		"\3\2\2\2\67\u00b7\3\2\2\29\u00b9\3\2\2\2;\u00bb\3\2\2\2=\u00bd\3\2\2\2"+
		"?\u00c0\3\2\2\2AB\7\61\2\2BC\7\61\2\2CG\3\2\2\2DF\n\2\2\2ED\3\2\2\2FI"+
		"\3\2\2\2GE\3\2\2\2GH\3\2\2\2HJ\3\2\2\2IG\3\2\2\2JK\b\2\2\2K\4\3\2\2\2"+
		"LM\7\61\2\2MN\7,\2\2NR\3\2\2\2OQ\13\2\2\2PO\3\2\2\2QT\3\2\2\2RS\3\2\2"+
		"\2RP\3\2\2\2SU\3\2\2\2TR\3\2\2\2UV\7,\2\2VW\7\61\2\2WX\3\2\2\2XY\b\3\2"+
		"\2Y\6\3\2\2\2Z[\t\3\2\2[\\\3\2\2\2\\]\b\4\2\2]\b\3\2\2\2^`\7\17\2\2_^"+
		"\3\2\2\2_`\3\2\2\2`a\3\2\2\2ab\7\f\2\2bc\3\2\2\2cd\b\5\3\2d\n\3\2\2\2"+
		"ef\t\4\2\2f\f\3\2\2\2gh\t\5\2\2h\16\3\2\2\2ij\t\6\2\2j\20\3\2\2\2kl\7"+
		"p\2\2lm\7g\2\2mn\7y\2\2n\22\3\2\2\2op\7u\2\2pq\7e\2\2qr\7t\2\2rs\7k\2"+
		"\2st\7r\2\2tu\7v\2\2u\24\3\2\2\2vw\7u\2\2wx\7v\2\2xy\7w\2\2yz\7d\2\2z"+
		"\26\3\2\2\2{}\5\13\6\2|~\5\r\7\2}|\3\2\2\2~\177\3\2\2\2\177}\3\2\2\2\177"+
		"\u0080\3\2\2\2\u0080\30\3\2\2\2\u0081\u0083\5\27\f\2\u0082\u0081\3\2\2"+
		"\2\u0083\u0084\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\32"+
		"\3\2\2\2\u0086\u0088\5\r\7\2\u0087\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089"+
		"\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008e\3\2\2\2\u008b\u008d\5\27"+
		"\f\2\u008c\u008b\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u008c\3\2\2\2\u008e"+
		"\u008f\3\2\2\2\u008f\34\3\2\2\2\u0090\u008e\3\2\2\2\u0091\u0096\5\31\r"+
		"\2\u0092\u0093\5\61\31\2\u0093\u0094\5\35\17\2\u0094\u0095\5\63\32\2\u0095"+
		"\u0097\3\2\2\2\u0096\u0092\3\2\2\2\u0096\u0097\3\2\2\2\u0097\36\3\2\2"+
		"\2\u0098\u009c\5=\37\2\u0099\u009b\13\2\2\2\u009a\u0099\3\2\2\2\u009b"+
		"\u009e\3\2\2\2\u009c\u009d\3\2\2\2\u009c\u009a\3\2\2\2\u009d\u009f\3\2"+
		"\2\2\u009e\u009c\3\2\2\2\u009f\u00a0\5=\37\2\u00a0 \3\2\2\2\u00a1\u00a2"+
		"\7\60\2\2\u00a2\"\3\2\2\2\u00a3\u00a4\7.\2\2\u00a4$\3\2\2\2\u00a5\u00a6"+
		"\7<\2\2\u00a6&\3\2\2\2\u00a7\u00a8\7=\2\2\u00a8(\3\2\2\2\u00a9\u00aa\7"+
		"?\2\2\u00aa*\3\2\2\2\u00ab\u00ac\7-\2\2\u00ac,\3\2\2\2\u00ad\u00ae\7/"+
		"\2\2\u00ae.\3\2\2\2\u00af\u00b0\7,\2\2\u00b0\60\3\2\2\2\u00b1\u00b2\7"+
		">\2\2\u00b2\62\3\2\2\2\u00b3\u00b4\7@\2\2\u00b4\64\3\2\2\2\u00b5\u00b6"+
		"\7*\2\2\u00b6\66\3\2\2\2\u00b7\u00b8\7+\2\2\u00b88\3\2\2\2\u00b9\u00ba"+
		"\7}\2\2\u00ba:\3\2\2\2\u00bb\u00bc\7\177\2\2\u00bc<\3\2\2\2\u00bd\u00be"+
		"\7$\2\2\u00be>\3\2\2\2\u00bf\u00c1\n\7\2\2\u00c0\u00bf\3\2\2\2\u00c1\u00c2"+
		"\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3@\3\2\2\2\r\2GR"+
		"_\177\u0084\u0089\u008e\u0096\u009c\u00c2\4\2\3\2\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}