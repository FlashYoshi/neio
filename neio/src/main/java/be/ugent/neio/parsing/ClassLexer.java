// Generated from /home/flash/Github/neio/neio/src/main/grammar/ClassLexer.g4 by ANTLR 4.2.2
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
public class ClassLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		HEADER=1, COMMENT=2, MULTILINE_COMMENT=3, WS=4, NEWLINE=5, EXTENDS=6, 
		IMPLEMENTS=7, CLASS=8, INTERFACE=9, RETURN=10, NEW=11, THIS=12, METHOD_OPTION=13, 
		STUB=14, CLASS_NAME=15, CAMEL_CASE=16, VAR_WITH_TYPE=17, PERIOD=18, COMMA=19, 
		COLON=20, SEMICOLON=21, EQUALS=22, PLUS=23, MINUS=24, STAR=25, SMALLER=26, 
		BIGGER=27, L_BRACE=28, R_BRACE=29, L_CURLY_BRACE=30, R_CURLY_BRACE=31, 
		DIGIT=32, METHOD_NAME=33;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"HEADER", "COMMENT", "MULTILINE_COMMENT", "WS", "NEWLINE", "'extends'", 
		"'implements'", "'class'", "'interface'", "'return'", "'new'", "'this'", 
		"'nested'", "'stub'", "CLASS_NAME", "CAMEL_CASE", "VAR_WITH_TYPE", "'.'", 
		"','", "':'", "';'", "'='", "'+'", "'-'", "'*'", "'<'", "'>'", "'('", 
		"')'", "'{'", "'}'", "DIGIT", "METHOD_NAME"
	};
	public static final String[] ruleNames = {
		"HEADER", "HEADER_CONTENT", "COMMENT", "MULTILINE_COMMENT", "WS", "NEWLINE", 
		"CAPITAL", "LETTER", "CHAR", "EXTENDS", "IMPLEMENTS", "CLASS", "INTERFACE", 
		"RETURN", "NEW", "THIS", "METHOD_OPTION", "STUB", "CAPITALED", "CLASS_NAME", 
		"CAMEL_CASE", "VAR_WITH_TYPE", "PERIOD", "COMMA", "COLON", "SEMICOLON", 
		"EQUALS", "PLUS", "MINUS", "STAR", "SMALLER", "BIGGER", "L_BRACE", "R_BRACE", 
		"L_CURLY_BRACE", "R_CURLY_BRACE", "DIGIT", "METHOD_NAME"
	};


	public ClassLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ClassLexer.g4"; }

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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2#\u00fe\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\3\2\3\2\3\3\3\3\5\3T\n\3\3"+
		"\4\3\4\3\4\3\4\7\4Z\n\4\f\4\16\4]\13\4\3\4\3\4\3\5\3\5\3\5\3\5\7\5e\n"+
		"\5\f\5\16\5h\13\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\5\7t\n\7\3\7"+
		"\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\6\24"+
		"\u00c1\n\24\r\24\16\24\u00c2\3\25\6\25\u00c6\n\25\r\25\16\25\u00c7\3\26"+
		"\6\26\u00cb\n\26\r\26\16\26\u00cc\3\26\7\26\u00d0\n\26\f\26\16\26\u00d3"+
		"\13\26\3\27\3\27\3\27\3\27\3\27\5\27\u00da\n\27\3\30\3\30\3\31\3\31\3"+
		"\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3"+
		"!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\6\'\u00fb\n\'\r\'\16\'\u00fc\3f"+
		"\2(\3\3\5\2\7\4\t\5\13\6\r\7\17\2\21\2\23\2\25\b\27\t\31\n\33\13\35\f"+
		"\37\r!\16#\17%\20\'\2)\21+\22-\23/\24\61\25\63\26\65\27\67\309\31;\32"+
		"=\33?\34A\35C\36E\37G I!K\"M#\3\2\t\4\2\f\f\17\17\4\2\13\13\"\"\3\2C\\"+
		"\3\2c|\5\2\62;C\\c|\3\2\62;\t\2\13\f\17\17\"\"*+..\60\60<=\u0102\2\3\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2"+
		"\2\2\2#\3\2\2\2\2%\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2"+
		"\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2"+
		"\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2"+
		"\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\3O\3\2\2\2\5S\3\2\2\2\7U\3\2\2\2\t`"+
		"\3\2\2\2\13n\3\2\2\2\rs\3\2\2\2\17y\3\2\2\2\21{\3\2\2\2\23}\3\2\2\2\25"+
		"\177\3\2\2\2\27\u0087\3\2\2\2\31\u0092\3\2\2\2\33\u0098\3\2\2\2\35\u00a2"+
		"\3\2\2\2\37\u00a9\3\2\2\2!\u00ad\3\2\2\2#\u00b2\3\2\2\2%\u00b9\3\2\2\2"+
		"\'\u00be\3\2\2\2)\u00c5\3\2\2\2+\u00ca\3\2\2\2-\u00d4\3\2\2\2/\u00db\3"+
		"\2\2\2\61\u00dd\3\2\2\2\63\u00df\3\2\2\2\65\u00e1\3\2\2\2\67\u00e3\3\2"+
		"\2\29\u00e5\3\2\2\2;\u00e7\3\2\2\2=\u00e9\3\2\2\2?\u00eb\3\2\2\2A\u00ed"+
		"\3\2\2\2C\u00ef\3\2\2\2E\u00f1\3\2\2\2G\u00f3\3\2\2\2I\u00f5\3\2\2\2K"+
		"\u00f7\3\2\2\2M\u00fa\3\2\2\2OP\5\5\3\2P\4\3\2\2\2QT\5\31\r\2RT\5\33\16"+
		"\2SQ\3\2\2\2SR\3\2\2\2T\6\3\2\2\2UV\7\61\2\2VW\7\61\2\2W[\3\2\2\2XZ\n"+
		"\2\2\2YX\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\^\3\2\2\2][\3\2\2\2^"+
		"_\b\4\2\2_\b\3\2\2\2`a\7\61\2\2ab\7,\2\2bf\3\2\2\2ce\13\2\2\2dc\3\2\2"+
		"\2eh\3\2\2\2fg\3\2\2\2fd\3\2\2\2gi\3\2\2\2hf\3\2\2\2ij\7,\2\2jk\7\61\2"+
		"\2kl\3\2\2\2lm\b\5\2\2m\n\3\2\2\2no\t\3\2\2op\3\2\2\2pq\b\6\2\2q\f\3\2"+
		"\2\2rt\7\17\2\2sr\3\2\2\2st\3\2\2\2tu\3\2\2\2uv\7\f\2\2vw\3\2\2\2wx\b"+
		"\7\3\2x\16\3\2\2\2yz\t\4\2\2z\20\3\2\2\2{|\t\5\2\2|\22\3\2\2\2}~\t\6\2"+
		"\2~\24\3\2\2\2\177\u0080\7g\2\2\u0080\u0081\7z\2\2\u0081\u0082\7v\2\2"+
		"\u0082\u0083\7g\2\2\u0083\u0084\7p\2\2\u0084\u0085\7f\2\2\u0085\u0086"+
		"\7u\2\2\u0086\26\3\2\2\2\u0087\u0088\7k\2\2\u0088\u0089\7o\2\2\u0089\u008a"+
		"\7r\2\2\u008a\u008b\7n\2\2\u008b\u008c\7g\2\2\u008c\u008d\7o\2\2\u008d"+
		"\u008e\7g\2\2\u008e\u008f\7p\2\2\u008f\u0090\7v\2\2\u0090\u0091\7u\2\2"+
		"\u0091\30\3\2\2\2\u0092\u0093\7e\2\2\u0093\u0094\7n\2\2\u0094\u0095\7"+
		"c\2\2\u0095\u0096\7u\2\2\u0096\u0097\7u\2\2\u0097\32\3\2\2\2\u0098\u0099"+
		"\7k\2\2\u0099\u009a\7p\2\2\u009a\u009b\7v\2\2\u009b\u009c\7g\2\2\u009c"+
		"\u009d\7t\2\2\u009d\u009e\7h\2\2\u009e\u009f\7c\2\2\u009f\u00a0\7e\2\2"+
		"\u00a0\u00a1\7g\2\2\u00a1\34\3\2\2\2\u00a2\u00a3\7t\2\2\u00a3\u00a4\7"+
		"g\2\2\u00a4\u00a5\7v\2\2\u00a5\u00a6\7w\2\2\u00a6\u00a7\7t\2\2\u00a7\u00a8"+
		"\7p\2\2\u00a8\36\3\2\2\2\u00a9\u00aa\7p\2\2\u00aa\u00ab\7g\2\2\u00ab\u00ac"+
		"\7y\2\2\u00ac \3\2\2\2\u00ad\u00ae\7v\2\2\u00ae\u00af\7j\2\2\u00af\u00b0"+
		"\7k\2\2\u00b0\u00b1\7u\2\2\u00b1\"\3\2\2\2\u00b2\u00b3\7p\2\2\u00b3\u00b4"+
		"\7g\2\2\u00b4\u00b5\7u\2\2\u00b5\u00b6\7v\2\2\u00b6\u00b7\7g\2\2\u00b7"+
		"\u00b8\7f\2\2\u00b8$\3\2\2\2\u00b9\u00ba\7u\2\2\u00ba\u00bb\7v\2\2\u00bb"+
		"\u00bc\7w\2\2\u00bc\u00bd\7d\2\2\u00bd&\3\2\2\2\u00be\u00c0\5\17\b\2\u00bf"+
		"\u00c1\5\21\t\2\u00c0\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c0\3"+
		"\2\2\2\u00c2\u00c3\3\2\2\2\u00c3(\3\2\2\2\u00c4\u00c6\5\'\24\2\u00c5\u00c4"+
		"\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8"+
		"*\3\2\2\2\u00c9\u00cb\5\21\t\2\u00ca\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2"+
		"\u00cc\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00d1\3\2\2\2\u00ce\u00d0"+
		"\5\'\24\2\u00cf\u00ce\3\2\2\2\u00d0\u00d3\3\2\2\2\u00d1\u00cf\3\2\2\2"+
		"\u00d1\u00d2\3\2\2\2\u00d2,\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d4\u00d9\5"+
		")\25\2\u00d5\u00d6\5? \2\u00d6\u00d7\5-\27\2\u00d7\u00d8\5A!\2\u00d8\u00da"+
		"\3\2\2\2\u00d9\u00d5\3\2\2\2\u00d9\u00da\3\2\2\2\u00da.\3\2\2\2\u00db"+
		"\u00dc\7\60\2\2\u00dc\60\3\2\2\2\u00dd\u00de\7.\2\2\u00de\62\3\2\2\2\u00df"+
		"\u00e0\7<\2\2\u00e0\64\3\2\2\2\u00e1\u00e2\7=\2\2\u00e2\66\3\2\2\2\u00e3"+
		"\u00e4\7?\2\2\u00e48\3\2\2\2\u00e5\u00e6\7-\2\2\u00e6:\3\2\2\2\u00e7\u00e8"+
		"\7/\2\2\u00e8<\3\2\2\2\u00e9\u00ea\7,\2\2\u00ea>\3\2\2\2\u00eb\u00ec\7"+
		">\2\2\u00ec@\3\2\2\2\u00ed\u00ee\7@\2\2\u00eeB\3\2\2\2\u00ef\u00f0\7*"+
		"\2\2\u00f0D\3\2\2\2\u00f1\u00f2\7+\2\2\u00f2F\3\2\2\2\u00f3\u00f4\7}\2"+
		"\2\u00f4H\3\2\2\2\u00f5\u00f6\7\177\2\2\u00f6J\3\2\2\2\u00f7\u00f8\t\7"+
		"\2\2\u00f8L\3\2\2\2\u00f9\u00fb\n\b\2\2\u00fa\u00f9\3\2\2\2\u00fb\u00fc"+
		"\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fdN\3\2\2\2\r\2S["+
		"fs\u00c2\u00c7\u00cc\u00d1\u00d9\u00fc\4\2\3\2\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}