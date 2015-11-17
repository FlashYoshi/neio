// Generated from /home/flash/Github/neio/neio/src/main/grammar/DocumentParser.g4 by ANTLR 4.2.2
package be.ugent.neio.parsing;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DocumentParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		R_CURLY_BRACE=21, R_BRACE=19, DOUBLE_QUOTE=24, STUB=6, HEADER=1, L_CURLY_BRACE=20, 
		COMMENT=2, MINUS=13, BIGGER=16, R_SQ_BRACE=23, SEMICOLON=10, SMALLER=15, 
		MULTILINE_COMMENT=3, WS=4, L_BRACE=18, COMMA=8, WORD=25, EQUALS=11, COLON=9, 
		HASH=17, STAR=14, L_SQ_BRACE=22, PERIOD=7, NL=5, PLUS=12;
	public static final String[] tokenNames = {
		"<INVALID>", "HEADER", "COMMENT", "MULTILINE_COMMENT", "WS", "NL", "'stub'", 
		"'.'", "','", "':'", "';'", "'='", "'+'", "'-'", "'*'", "'<'", "'>'", 
		"'#'", "'('", "')'", "'{'", "'}'", "'['", "']'", "'\"'", "WORD"
	};
	public static final int
		RULE_document = 0, RULE_body = 1, RULE_content = 2, RULE_prefixCall = 3, 
		RULE_text = 4, RULE_postfixCall = 5, RULE_sentence = 6, RULE_mnl = 7;
	public static final String[] ruleNames = {
		"document", "body", "content", "prefixCall", "text", "postfixCall", "sentence", 
		"mnl"
	};

	@Override
	public String getGrammarFileName() { return "DocumentParser.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public DocumentParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class DocumentContext extends ParserRuleContext {
		public MnlContext mnl() {
			return getRuleContext(MnlContext.class,0);
		}
		public TerminalNode EOF() { return getToken(DocumentParser.EOF, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode HEADER() { return getToken(DocumentParser.HEADER, 0); }
		public DocumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_document; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DocumentParserListener ) ((DocumentParserListener)listener).enterDocument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DocumentParserListener ) ((DocumentParserListener)listener).exitDocument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DocumentParserVisitor ) return ((DocumentParserVisitor<? extends T>)visitor).visitDocument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DocumentContext document() throws RecognitionException {
		DocumentContext _localctx = new DocumentContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_document);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16); match(HEADER);
			setState(17); mnl();
			setState(18); body();
			setState(19); match(EOF);
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
			if ( listener instanceof DocumentParserListener ) ((DocumentParserListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DocumentParserListener ) ((DocumentParserListener)listener).exitBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DocumentParserVisitor ) return ((DocumentParserVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
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
				setState(21); content();
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
		public PostfixCallContext postfixCall() {
			return getRuleContext(PostfixCallContext.class,0);
		}
		public PrefixCallContext prefixCall() {
			return getRuleContext(PrefixCallContext.class,0);
		}
		public MnlContext mnl() {
			return getRuleContext(MnlContext.class,0);
		}
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public ContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_content; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DocumentParserListener ) ((DocumentParserListener)listener).enterContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DocumentParserListener ) ((DocumentParserListener)listener).exitContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DocumentParserVisitor ) return ((DocumentParserVisitor<? extends T>)visitor).visitContent(this);
			else return visitor.visitChildren(this);
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
				setState(27); prefixCall();
				}
				break;
			case STUB:
				{
				setState(28); postfixCall();
				}
				break;
			case WORD:
				{
				setState(29); text();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(33);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(32); mnl();
				}
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
		public TerminalNode HASH(int i) {
			return getToken(DocumentParser.HASH, i);
		}
		public SentenceContext sentence() {
			return getRuleContext(SentenceContext.class,0);
		}
		public List<TerminalNode> HASH() { return getTokens(DocumentParser.HASH); }
		public PrefixCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefixCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DocumentParserListener ) ((DocumentParserListener)listener).enterPrefixCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DocumentParserListener ) ((DocumentParserListener)listener).exitPrefixCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DocumentParserVisitor ) return ((DocumentParserVisitor<? extends T>)visitor).visitPrefixCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrefixCallContext prefixCall() throws RecognitionException {
		PrefixCallContext _localctx = new PrefixCallContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_prefixCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(35); match(HASH);
				}
				}
				setState(38); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==HASH );
			setState(40); sentence();
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
		public SentenceContext sentence(int i) {
			return getRuleContext(SentenceContext.class,i);
		}
		public List<SentenceContext> sentence() {
			return getRuleContexts(SentenceContext.class);
		}
		public TextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_text; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DocumentParserListener ) ((DocumentParserListener)listener).enterText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DocumentParserListener ) ((DocumentParserListener)listener).exitText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DocumentParserVisitor ) return ((DocumentParserVisitor<? extends T>)visitor).visitText(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TextContext text() throws RecognitionException {
		TextContext _localctx = new TextContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_text);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(43); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(42); sentence();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(45); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			} while ( _alt!=2 && _alt!=ATN.INVALID_ALT_NUMBER );
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
		public TerminalNode STUB() { return getToken(DocumentParser.STUB, 0); }
		public PostfixCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfixCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DocumentParserListener ) ((DocumentParserListener)listener).enterPostfixCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DocumentParserListener ) ((DocumentParserListener)listener).exitPostfixCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DocumentParserVisitor ) return ((DocumentParserVisitor<? extends T>)visitor).visitPostfixCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PostfixCallContext postfixCall() throws RecognitionException {
		PostfixCallContext _localctx = new PostfixCallContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_postfixCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47); match(STUB);
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
		public TerminalNode NL() { return getToken(DocumentParser.NL, 0); }
		public List<TerminalNode> WORD() { return getTokens(DocumentParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(DocumentParser.WORD, i);
		}
		public SentenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DocumentParserListener ) ((DocumentParserListener)listener).enterSentence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DocumentParserListener ) ((DocumentParserListener)listener).exitSentence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DocumentParserVisitor ) return ((DocumentParserVisitor<? extends T>)visitor).visitSentence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenceContext sentence() throws RecognitionException {
		SentenceContext _localctx = new SentenceContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_sentence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(49); match(WORD);
				}
				}
				setState(52); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WORD );
			setState(54); match(NL);
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
		public List<TerminalNode> NL() { return getTokens(DocumentParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(DocumentParser.NL, i);
		}
		public MnlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mnl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DocumentParserListener ) ((DocumentParserListener)listener).enterMnl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DocumentParserListener ) ((DocumentParserListener)listener).exitMnl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DocumentParserVisitor ) return ((DocumentParserVisitor<? extends T>)visitor).visitMnl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MnlContext mnl() throws RecognitionException {
		MnlContext _localctx = new MnlContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_mnl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(56); match(NL);
				}
				}
				setState(59); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NL );
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\33@\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\3\2\3\2"+
		"\3\3\7\3\31\n\3\f\3\16\3\34\13\3\3\4\3\4\3\4\5\4!\n\4\3\4\5\4$\n\4\3\5"+
		"\6\5\'\n\5\r\5\16\5(\3\5\3\5\3\6\6\6.\n\6\r\6\16\6/\3\7\3\7\3\b\6\b\65"+
		"\n\b\r\b\16\b\66\3\b\3\b\3\t\6\t<\n\t\r\t\16\t=\3\t\2\2\n\2\4\6\b\n\f"+
		"\16\20\2\2?\2\22\3\2\2\2\4\32\3\2\2\2\6 \3\2\2\2\b&\3\2\2\2\n-\3\2\2\2"+
		"\f\61\3\2\2\2\16\64\3\2\2\2\20;\3\2\2\2\22\23\7\3\2\2\23\24\5\20\t\2\24"+
		"\25\5\4\3\2\25\26\7\2\2\3\26\3\3\2\2\2\27\31\5\6\4\2\30\27\3\2\2\2\31"+
		"\34\3\2\2\2\32\30\3\2\2\2\32\33\3\2\2\2\33\5\3\2\2\2\34\32\3\2\2\2\35"+
		"!\5\b\5\2\36!\5\f\7\2\37!\5\n\6\2 \35\3\2\2\2 \36\3\2\2\2 \37\3\2\2\2"+
		"!#\3\2\2\2\"$\5\20\t\2#\"\3\2\2\2#$\3\2\2\2$\7\3\2\2\2%\'\7\23\2\2&%\3"+
		"\2\2\2\'(\3\2\2\2(&\3\2\2\2()\3\2\2\2)*\3\2\2\2*+\5\16\b\2+\t\3\2\2\2"+
		",.\5\16\b\2-,\3\2\2\2./\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\60\13\3\2\2\2\61"+
		"\62\7\b\2\2\62\r\3\2\2\2\63\65\7\33\2\2\64\63\3\2\2\2\65\66\3\2\2\2\66"+
		"\64\3\2\2\2\66\67\3\2\2\2\678\3\2\2\289\7\7\2\29\17\3\2\2\2:<\7\7\2\2"+
		";:\3\2\2\2<=\3\2\2\2=;\3\2\2\2=>\3\2\2\2>\21\3\2\2\2\t\32 #(/\66=";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}