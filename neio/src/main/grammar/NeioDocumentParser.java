// Generated from NeioDocumentParser.g4 by ANTLR 4.5.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class NeioDocumentParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		HEADER=1, COMMENT=2, MULTILINE_COMMENT=3, WS=4, NL=5, STUB=6, PERIOD=7, 
		COMMA=8, COLON=9, SEMICOLON=10, EQUALS=11, PLUS=12, MINUS=13, STAR=14, 
		SMALLER=15, BIGGER=16, HASH=17, L_BRACE=18, R_BRACE=19, L_CURLY_BRACE=20, 
		R_CURLY_BRACE=21, L_SQ_BRACE=22, R_SQ_BRACE=23, DOUBLE_QUOTE=24, WORD=25;
	public static final int
		RULE_document = 0, RULE_body = 1, RULE_content = 2, RULE_prefixCall = 3, 
		RULE_text = 4, RULE_postfixCall = 5, RULE_sentence = 6, RULE_mnl = 7;
	public static final String[] ruleNames = {
		"document", "body", "content", "prefixCall", "text", "postfixCall", "sentence", 
		"mnl"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, "'stub'", "'.'", "','", "':'", "';'", 
		"'='", "'+'", "'-'", "'*'", "'<'", "'>'", "'#'", "'('", "')'", "'{'", 
		"'}'", "'['", "']'", "'\"'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "HEADER", "COMMENT", "MULTILINE_COMMENT", "WS", "NL", "STUB", "PERIOD", 
		"COMMA", "COLON", "SEMICOLON", "EQUALS", "PLUS", "MINUS", "STAR", "SMALLER", 
		"BIGGER", "HASH", "L_BRACE", "R_BRACE", "L_CURLY_BRACE", "R_CURLY_BRACE", 
		"L_SQ_BRACE", "R_SQ_BRACE", "DOUBLE_QUOTE", "WORD"
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

	@Override
	public String getGrammarFileName() { return "NeioDocumentParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public NeioDocumentParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class DocumentContext extends ParserRuleContext {
		public TerminalNode HEADER() { return getToken(NeioDocumentParser.HEADER, 0); }
		public MnlContext mnl() {
			return getRuleContext(MnlContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode EOF() { return getToken(NeioDocumentParser.EOF, 0); }
		public DocumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_document; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NeioDocumentParserListener ) ((NeioDocumentParserListener)listener).enterDocument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NeioDocumentParserListener ) ((NeioDocumentParserListener)listener).exitDocument(this);
		}
	}

	public final DocumentContext document() throws RecognitionException {
		DocumentContext _localctx = new DocumentContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_document);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			match(HEADER);
			setState(17);
			mnl();
			setState(18);
			body();
			setState(19);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BodyContext extends ParserRuleContext {
		public List<ContentContext> content() {
			return getRuleContexts(ContentContext.class);
		}
		public ContentContext content(int i) {
			return getRuleContext(ContentContext.class,i);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NeioDocumentParserListener ) ((NeioDocumentParserListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NeioDocumentParserListener ) ((NeioDocumentParserListener)listener).exitBody(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STUB) | (1L << HASH) | (1L << WORD))) != 0)) {
				{
				{
				setState(21);
				content();
				}
				}
				setState(26);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ContentContext extends ParserRuleContext {
		public PrefixCallContext prefixCall() {
			return getRuleContext(PrefixCallContext.class,0);
		}
		public PostfixCallContext postfixCall() {
			return getRuleContext(PostfixCallContext.class,0);
		}
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public List<MnlContext> mnl() {
			return getRuleContexts(MnlContext.class);
		}
		public MnlContext mnl(int i) {
			return getRuleContext(MnlContext.class,i);
		}
		public ContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_content; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NeioDocumentParserListener ) ((NeioDocumentParserListener)listener).enterContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NeioDocumentParserListener ) ((NeioDocumentParserListener)listener).exitContent(this);
		}
	}

	public final ContentContext content() throws RecognitionException {
		ContentContext _localctx = new ContentContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_content);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			switch (_input.LA(1)) {
			case HASH:
				{
				setState(27);
				prefixCall();
				}
				break;
			case STUB:
				{
				setState(28);
				postfixCall();
				}
				break;
			case WORD:
				{
				setState(29);
				text();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(32);
				mnl();
				}
				}
				setState(37);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrefixCallContext extends ParserRuleContext {
		public SentenceContext sentence() {
			return getRuleContext(SentenceContext.class,0);
		}
		public List<TerminalNode> HASH() { return getTokens(NeioDocumentParser.HASH); }
		public TerminalNode HASH(int i) {
			return getToken(NeioDocumentParser.HASH, i);
		}
		public PrefixCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefixCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NeioDocumentParserListener ) ((NeioDocumentParserListener)listener).enterPrefixCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NeioDocumentParserListener ) ((NeioDocumentParserListener)listener).exitPrefixCall(this);
		}
	}

	public final PrefixCallContext prefixCall() throws RecognitionException {
		PrefixCallContext _localctx = new PrefixCallContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_prefixCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(38);
				match(HASH);
				}
				}
				setState(41); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==HASH );
			setState(43);
			sentence();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TextContext extends ParserRuleContext {
		public List<SentenceContext> sentence() {
			return getRuleContexts(SentenceContext.class);
		}
		public SentenceContext sentence(int i) {
			return getRuleContext(SentenceContext.class,i);
		}
		public TextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_text; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NeioDocumentParserListener ) ((NeioDocumentParserListener)listener).enterText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NeioDocumentParserListener ) ((NeioDocumentParserListener)listener).exitText(this);
		}
	}

	public final TextContext text() throws RecognitionException {
		TextContext _localctx = new TextContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_text);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(46); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(45);
					sentence();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(48); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PostfixCallContext extends ParserRuleContext {
		public TerminalNode STUB() { return getToken(NeioDocumentParser.STUB, 0); }
		public PostfixCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfixCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NeioDocumentParserListener ) ((NeioDocumentParserListener)listener).enterPostfixCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NeioDocumentParserListener ) ((NeioDocumentParserListener)listener).exitPostfixCall(this);
		}
	}

	public final PostfixCallContext postfixCall() throws RecognitionException {
		PostfixCallContext _localctx = new PostfixCallContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_postfixCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(STUB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SentenceContext extends ParserRuleContext {
		public TerminalNode NL() { return getToken(NeioDocumentParser.NL, 0); }
		public List<TerminalNode> WORD() { return getTokens(NeioDocumentParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(NeioDocumentParser.WORD, i);
		}
		public SentenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NeioDocumentParserListener ) ((NeioDocumentParserListener)listener).enterSentence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NeioDocumentParserListener ) ((NeioDocumentParserListener)listener).exitSentence(this);
		}
	}

	public final SentenceContext sentence() throws RecognitionException {
		SentenceContext _localctx = new SentenceContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_sentence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(52);
				match(WORD);
				}
				}
				setState(55); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WORD );
			setState(57);
			match(NL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MnlContext extends ParserRuleContext {
		public List<TerminalNode> NL() { return getTokens(NeioDocumentParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(NeioDocumentParser.NL, i);
		}
		public MnlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mnl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NeioDocumentParserListener ) ((NeioDocumentParserListener)listener).enterMnl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NeioDocumentParserListener ) ((NeioDocumentParserListener)listener).exitMnl(this);
		}
	}

	public final MnlContext mnl() throws RecognitionException {
		MnlContext _localctx = new MnlContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_mnl);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(60); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(59);
					match(NL);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(62); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\33C\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\3\2\3\2"+
		"\3\3\7\3\31\n\3\f\3\16\3\34\13\3\3\4\3\4\3\4\5\4!\n\4\3\4\7\4$\n\4\f\4"+
		"\16\4\'\13\4\3\5\6\5*\n\5\r\5\16\5+\3\5\3\5\3\6\6\6\61\n\6\r\6\16\6\62"+
		"\3\7\3\7\3\b\6\b8\n\b\r\b\16\b9\3\b\3\b\3\t\6\t?\n\t\r\t\16\t@\3\t\2\2"+
		"\n\2\4\6\b\n\f\16\20\2\2B\2\22\3\2\2\2\4\32\3\2\2\2\6 \3\2\2\2\b)\3\2"+
		"\2\2\n\60\3\2\2\2\f\64\3\2\2\2\16\67\3\2\2\2\20>\3\2\2\2\22\23\7\3\2\2"+
		"\23\24\5\20\t\2\24\25\5\4\3\2\25\26\7\2\2\3\26\3\3\2\2\2\27\31\5\6\4\2"+
		"\30\27\3\2\2\2\31\34\3\2\2\2\32\30\3\2\2\2\32\33\3\2\2\2\33\5\3\2\2\2"+
		"\34\32\3\2\2\2\35!\5\b\5\2\36!\5\f\7\2\37!\5\n\6\2 \35\3\2\2\2 \36\3\2"+
		"\2\2 \37\3\2\2\2!%\3\2\2\2\"$\5\20\t\2#\"\3\2\2\2$\'\3\2\2\2%#\3\2\2\2"+
		"%&\3\2\2\2&\7\3\2\2\2\'%\3\2\2\2(*\7\23\2\2)(\3\2\2\2*+\3\2\2\2+)\3\2"+
		"\2\2+,\3\2\2\2,-\3\2\2\2-.\5\16\b\2.\t\3\2\2\2/\61\5\16\b\2\60/\3\2\2"+
		"\2\61\62\3\2\2\2\62\60\3\2\2\2\62\63\3\2\2\2\63\13\3\2\2\2\64\65\7\b\2"+
		"\2\65\r\3\2\2\2\668\7\33\2\2\67\66\3\2\2\289\3\2\2\29\67\3\2\2\29:\3\2"+
		"\2\2:;\3\2\2\2;<\7\7\2\2<\17\3\2\2\2=?\7\7\2\2>=\3\2\2\2?@\3\2\2\2@>\3"+
		"\2\2\2@A\3\2\2\2A\21\3\2\2\2\t\32 %+\629@";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}