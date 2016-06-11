// Generated from B:\Documents\GitHub\neio\neio\src\main\grammar\DocumentParser.g4 by ANTLR 4.5
package org.neio.antlr;
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
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		HEADER=1, COMMENT=2, MULTILINE_COMMENT=3, SCOPED_CODE=4, LONE_CODE=5, 
		CODE=6, ESCAPE=7, S=8, WS=9, NL=10, LS_BRACE=11, RS_BRACE=12, L_BRACE=13, 
		R_BRACE=14, DLCB=15, LCB=16, DRCB=17, RCB=18, Q=19, TQ=20, MethodName=21, 
		HASH=22, DASH=23, STAR=24, P=25, EQ=26, CA=27, BQ=28, US=29, DLR=30, WORD=31, 
		CCONTENT=32, CONTENT=33, ANY=34, STRING=35, TEXTMODE=36, UNKNOWN=37;
	public static final int
		RULE_document = 0, RULE_body = 1, RULE_content = 2, RULE_prefixCall = 3, 
		RULE_cPrefixCall = 4, RULE_preMethodName = 5, RULE_surroundCall = 6, RULE_text = 7, 
		RULE_txt = 8, RULE_nl = 9, RULE_textWSpaces = 10, RULE_scode = 11, RULE_lonecode = 12, 
		RULE_inlinecode = 13;
	public static final String[] ruleNames = {
		"document", "body", "content", "prefixCall", "cPrefixCall", "preMethodName", 
		"surroundCall", "text", "txt", "nl", "textWSpaces", "scode", "lonecode", 
		"inlinecode"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, null, "' '", null, null, "'['", 
		"']'", "'('", "')'", "'{{'", "'{'", "'}}'", "'}'", "'\"'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "HEADER", "COMMENT", "MULTILINE_COMMENT", "SCOPED_CODE", "LONE_CODE", 
		"CODE", "ESCAPE", "S", "WS", "NL", "LS_BRACE", "RS_BRACE", "L_BRACE", 
		"R_BRACE", "DLCB", "LCB", "DRCB", "RCB", "Q", "TQ", "MethodName", "HASH", 
		"DASH", "STAR", "P", "EQ", "CA", "BQ", "US", "DLR", "WORD", "CCONTENT", 
		"CONTENT", "ANY", "STRING", "TEXTMODE", "UNKNOWN"
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
	public String getGrammarFileName() { return "DocumentParser.g4"; }

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
		public TerminalNode HEADER() { return getToken(DocumentParser.HEADER, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode EOF() { return getToken(DocumentParser.EOF, 0); }
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
			setState(28);
			match(HEADER);
			setState(29);
			body();
			setState(30);
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
			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SCOPED_CODE) | (1L << LONE_CODE) | (1L << CODE) | (1L << ESCAPE) | (1L << S) | (1L << NL) | (1L << MethodName) | (1L << HASH) | (1L << DASH) | (1L << STAR) | (1L << EQ) | (1L << CA) | (1L << BQ) | (1L << US) | (1L << DLR) | (1L << WORD))) != 0)) {
				{
				{
				setState(32);
				content();
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

	public static class ContentContext extends ParserRuleContext {
		public ContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_content; }
	 
		public ContentContext() { }
		public void copyFrom(ContentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PrefixCContext extends ContentContext {
		public PrefixCallContext prefixCall() {
			return getRuleContext(PrefixCallContext.class,0);
		}
		public PrefixCContext(ContentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DocumentParserListener ) ((DocumentParserListener)listener).enterPrefixC(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DocumentParserListener ) ((DocumentParserListener)listener).exitPrefixC(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DocumentParserVisitor ) return ((DocumentParserVisitor<? extends T>)visitor).visitPrefixC(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LonecodeCContext extends ContentContext {
		public LonecodeContext lonecode() {
			return getRuleContext(LonecodeContext.class,0);
		}
		public LonecodeCContext(ContentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DocumentParserListener ) ((DocumentParserListener)listener).enterLonecodeC(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DocumentParserListener ) ((DocumentParserListener)listener).exitLonecodeC(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DocumentParserVisitor ) return ((DocumentParserVisitor<? extends T>)visitor).visitLonecodeC(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TextCContext extends ContentContext {
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public TextCContext(ContentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DocumentParserListener ) ((DocumentParserListener)listener).enterTextC(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DocumentParserListener ) ((DocumentParserListener)listener).exitTextC(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DocumentParserVisitor ) return ((DocumentParserVisitor<? extends T>)visitor).visitTextC(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NlCContext extends ContentContext {
		public NlContext nl() {
			return getRuleContext(NlContext.class,0);
		}
		public NlCContext(ContentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DocumentParserListener ) ((DocumentParserListener)listener).enterNlC(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DocumentParserListener ) ((DocumentParserListener)listener).exitNlC(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DocumentParserVisitor ) return ((DocumentParserVisitor<? extends T>)visitor).visitNlC(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ScodeCContext extends ContentContext {
		public ScodeContext scode() {
			return getRuleContext(ScodeContext.class,0);
		}
		public ScodeCContext(ContentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DocumentParserListener ) ((DocumentParserListener)listener).enterScodeC(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DocumentParserListener ) ((DocumentParserListener)listener).exitScodeC(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DocumentParserVisitor ) return ((DocumentParserVisitor<? extends T>)visitor).visitScodeC(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContentContext content() throws RecognitionException {
		ContentContext _localctx = new ContentContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_content);
		try {
			setState(43);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new PrefixCContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(38);
				prefixCall();
				}
				break;
			case 2:
				_localctx = new TextCContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(39);
				text();
				}
				break;
			case 3:
				_localctx = new ScodeCContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(40);
				scode();
				}
				break;
			case 4:
				_localctx = new LonecodeCContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(41);
				lonecode();
				}
				break;
			case 5:
				_localctx = new NlCContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(42);
				nl();
				}
				break;
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
		public TerminalNode MethodName() { return getToken(DocumentParser.MethodName, 0); }
		public TxtContext txt() {
			return getRuleContext(TxtContext.class,0);
		}
		public List<TerminalNode> S() { return getTokens(DocumentParser.S); }
		public TerminalNode S(int i) {
			return getToken(DocumentParser.S, i);
		}
		public CPrefixCallContext cPrefixCall() {
			return getRuleContext(CPrefixCallContext.class,0);
		}
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
			int _alt;
			setState(69);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(45);
				match(MethodName);
				setState(47); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(46);
						match(S);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(49); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(51);
				txt();
				setState(58);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(53); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(52);
						match(S);
						}
						}
						setState(55); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==S );
					setState(57);
					cPrefixCall();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				match(MethodName);
				setState(62); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(61);
						match(S);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(64); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(67);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(66);
					cPrefixCall();
					}
					break;
				}
				}
				break;
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

	public static class CPrefixCallContext extends ParserRuleContext {
		public PreMethodNameContext preMethodName() {
			return getRuleContext(PreMethodNameContext.class,0);
		}
		public TxtContext txt() {
			return getRuleContext(TxtContext.class,0);
		}
		public List<TerminalNode> S() { return getTokens(DocumentParser.S); }
		public TerminalNode S(int i) {
			return getToken(DocumentParser.S, i);
		}
		public CPrefixCallContext cPrefixCall() {
			return getRuleContext(CPrefixCallContext.class,0);
		}
		public CPrefixCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cPrefixCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DocumentParserListener ) ((DocumentParserListener)listener).enterCPrefixCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DocumentParserListener ) ((DocumentParserListener)listener).exitCPrefixCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DocumentParserVisitor ) return ((DocumentParserVisitor<? extends T>)visitor).visitCPrefixCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CPrefixCallContext cPrefixCall() throws RecognitionException {
		CPrefixCallContext _localctx = new CPrefixCallContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_cPrefixCall);
		int _la;
		try {
			int _alt;
			setState(95);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				preMethodName();
				setState(73); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(72);
						match(S);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(75); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(77);
				txt();
				setState(84);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(79); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(78);
						match(S);
						}
						}
						setState(81); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==S );
					setState(83);
					cPrefixCall();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(86);
				preMethodName();
				setState(88); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(87);
						match(S);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(90); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(93);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(92);
					cPrefixCall();
					}
					break;
				}
				}
				break;
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

	public static class PreMethodNameContext extends ParserRuleContext {
		public TerminalNode P() { return getToken(DocumentParser.P, 0); }
		public TerminalNode STAR() { return getToken(DocumentParser.STAR, 0); }
		public TerminalNode EQ() { return getToken(DocumentParser.EQ, 0); }
		public TerminalNode DASH() { return getToken(DocumentParser.DASH, 0); }
		public TerminalNode CA() { return getToken(DocumentParser.CA, 0); }
		public TerminalNode US() { return getToken(DocumentParser.US, 0); }
		public PreMethodNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preMethodName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DocumentParserListener ) ((DocumentParserListener)listener).enterPreMethodName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DocumentParserListener ) ((DocumentParserListener)listener).exitPreMethodName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DocumentParserVisitor ) return ((DocumentParserVisitor<? extends T>)visitor).visitPreMethodName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PreMethodNameContext preMethodName() throws RecognitionException {
		PreMethodNameContext _localctx = new PreMethodNameContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_preMethodName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DASH) | (1L << STAR) | (1L << P) | (1L << EQ) | (1L << CA) | (1L << US))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
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

	public static class SurroundCallContext extends ParserRuleContext {
		public Token left;
		public Token right;
		public TxtContext txt() {
			return getRuleContext(TxtContext.class,0);
		}
		public InlinecodeContext inlinecode() {
			return getRuleContext(InlinecodeContext.class,0);
		}
		public TerminalNode WORD() { return getToken(DocumentParser.WORD, 0); }
		public List<TerminalNode> MethodName() { return getTokens(DocumentParser.MethodName); }
		public TerminalNode MethodName(int i) {
			return getToken(DocumentParser.MethodName, i);
		}
		public List<TerminalNode> HASH() { return getTokens(DocumentParser.HASH); }
		public TerminalNode HASH(int i) {
			return getToken(DocumentParser.HASH, i);
		}
		public List<TerminalNode> DASH() { return getTokens(DocumentParser.DASH); }
		public TerminalNode DASH(int i) {
			return getToken(DocumentParser.DASH, i);
		}
		public List<TerminalNode> STAR() { return getTokens(DocumentParser.STAR); }
		public TerminalNode STAR(int i) {
			return getToken(DocumentParser.STAR, i);
		}
		public List<TerminalNode> BQ() { return getTokens(DocumentParser.BQ); }
		public TerminalNode BQ(int i) {
			return getToken(DocumentParser.BQ, i);
		}
		public List<TerminalNode> US() { return getTokens(DocumentParser.US); }
		public TerminalNode US(int i) {
			return getToken(DocumentParser.US, i);
		}
		public List<TerminalNode> DLR() { return getTokens(DocumentParser.DLR); }
		public TerminalNode DLR(int i) {
			return getToken(DocumentParser.DLR, i);
		}
		public List<TerminalNode> EQ() { return getTokens(DocumentParser.EQ); }
		public TerminalNode EQ(int i) {
			return getToken(DocumentParser.EQ, i);
		}
		public List<TerminalNode> CA() { return getTokens(DocumentParser.CA); }
		public TerminalNode CA(int i) {
			return getToken(DocumentParser.CA, i);
		}
		public List<TerminalNode> ESCAPE() { return getTokens(DocumentParser.ESCAPE); }
		public TerminalNode ESCAPE(int i) {
			return getToken(DocumentParser.ESCAPE, i);
		}
		public SurroundCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_surroundCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DocumentParserListener ) ((DocumentParserListener)listener).enterSurroundCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DocumentParserListener ) ((DocumentParserListener)listener).exitSurroundCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DocumentParserVisitor ) return ((DocumentParserVisitor<? extends T>)visitor).visitSurroundCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SurroundCallContext surroundCall() throws RecognitionException {
		SurroundCallContext _localctx = new SurroundCallContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_surroundCall);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(100); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(99);
				((SurroundCallContext)_localctx).left = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MethodName) | (1L << HASH) | (1L << DASH) | (1L << STAR) | (1L << EQ) | (1L << CA) | (1L << BQ) | (1L << US) | (1L << DLR))) != 0)) ) {
					((SurroundCallContext)_localctx).left = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				}
				setState(102); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MethodName) | (1L << HASH) | (1L << DASH) | (1L << STAR) | (1L << EQ) | (1L << CA) | (1L << BQ) | (1L << US) | (1L << DLR))) != 0) );
			setState(113);
			switch (_input.LA(1)) {
			case ESCAPE:
				{
				setState(105); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(104);
						match(ESCAPE);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(107); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case CODE:
			case WORD:
				{
				setState(111);
				switch (_input.LA(1)) {
				case CODE:
					{
					setState(109);
					inlinecode();
					}
					break;
				case WORD:
					{
					setState(110);
					match(WORD);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(116);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1+1:
				{
				setState(115);
				txt();
				}
				break;
			}
			setState(119); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(118);
					((SurroundCallContext)_localctx).right = _input.LT(1);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << HASH) | (1L << DASH) | (1L << STAR) | (1L << EQ) | (1L << CA) | (1L << BQ) | (1L << US) | (1L << DLR))) != 0)) ) {
						((SurroundCallContext)_localctx).right = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(121); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(123);
			if (!((((SurroundCallContext)_localctx).left!=null?((SurroundCallContext)_localctx).left.getText():null).equals((((SurroundCallContext)_localctx).right!=null?((SurroundCallContext)_localctx).right.getText():null)))) throw new FailedPredicateException(this, "$left.text.equals($right.text)");
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
		public TxtContext txt() {
			return getRuleContext(TxtContext.class,0);
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
		enterRule(_localctx, 14, RULE_text);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			txt();
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

	public static class TxtContext extends ParserRuleContext {
		public List<TextWSpacesContext> textWSpaces() {
			return getRuleContexts(TextWSpacesContext.class);
		}
		public TextWSpacesContext textWSpaces(int i) {
			return getRuleContext(TextWSpacesContext.class,i);
		}
		public List<InlinecodeContext> inlinecode() {
			return getRuleContexts(InlinecodeContext.class);
		}
		public InlinecodeContext inlinecode(int i) {
			return getRuleContext(InlinecodeContext.class,i);
		}
		public List<SurroundCallContext> surroundCall() {
			return getRuleContexts(SurroundCallContext.class);
		}
		public SurroundCallContext surroundCall(int i) {
			return getRuleContext(SurroundCallContext.class,i);
		}
		public TxtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_txt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DocumentParserListener ) ((DocumentParserListener)listener).enterTxt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DocumentParserListener ) ((DocumentParserListener)listener).exitTxt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DocumentParserVisitor ) return ((DocumentParserVisitor<? extends T>)visitor).visitTxt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TxtContext txt() throws RecognitionException {
		TxtContext _localctx = new TxtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_txt);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(130); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(130);
					switch (_input.LA(1)) {
					case ESCAPE:
					case S:
					case WORD:
						{
						setState(127);
						textWSpaces();
						}
						break;
					case CODE:
						{
						setState(128);
						inlinecode();
						}
						break;
					case MethodName:
					case HASH:
					case DASH:
					case STAR:
					case EQ:
					case CA:
					case BQ:
					case US:
					case DLR:
						{
						setState(129);
						surroundCall();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(132); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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

	public static class NlContext extends ParserRuleContext {
		public TerminalNode NL() { return getToken(DocumentParser.NL, 0); }
		public NlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DocumentParserListener ) ((DocumentParserListener)listener).enterNl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DocumentParserListener ) ((DocumentParserListener)listener).exitNl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DocumentParserVisitor ) return ((DocumentParserVisitor<? extends T>)visitor).visitNl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NlContext nl() throws RecognitionException {
		NlContext _localctx = new NlContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_nl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
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

	public static class TextWSpacesContext extends ParserRuleContext {
		public List<TerminalNode> WORD() { return getTokens(DocumentParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(DocumentParser.WORD, i);
		}
		public List<TerminalNode> ESCAPE() { return getTokens(DocumentParser.ESCAPE); }
		public TerminalNode ESCAPE(int i) {
			return getToken(DocumentParser.ESCAPE, i);
		}
		public List<TerminalNode> S() { return getTokens(DocumentParser.S); }
		public TerminalNode S(int i) {
			return getToken(DocumentParser.S, i);
		}
		public TextWSpacesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_textWSpaces; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DocumentParserListener ) ((DocumentParserListener)listener).enterTextWSpaces(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DocumentParserListener ) ((DocumentParserListener)listener).exitTextWSpaces(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DocumentParserVisitor ) return ((DocumentParserVisitor<? extends T>)visitor).visitTextWSpaces(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TextWSpacesContext textWSpaces() throws RecognitionException {
		TextWSpacesContext _localctx = new TextWSpacesContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_textWSpaces);
		int _la;
		try {
			int _alt;
			setState(158);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(149); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(139);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==S) {
							{
							{
							setState(136);
							match(S);
							}
							}
							setState(141);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(142);
						_la = _input.LA(1);
						if ( !(_la==ESCAPE || _la==WORD) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(146);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(143);
								match(S);
								}
								} 
							}
							setState(148);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
						}
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(151); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(154); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(153);
						match(S);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(156); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
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

	public static class ScodeContext extends ParserRuleContext {
		public TerminalNode SCOPED_CODE() { return getToken(DocumentParser.SCOPED_CODE, 0); }
		public ScodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DocumentParserListener ) ((DocumentParserListener)listener).enterScode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DocumentParserListener ) ((DocumentParserListener)listener).exitScode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DocumentParserVisitor ) return ((DocumentParserVisitor<? extends T>)visitor).visitScode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScodeContext scode() throws RecognitionException {
		ScodeContext _localctx = new ScodeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_scode);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(SCOPED_CODE);
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

	public static class LonecodeContext extends ParserRuleContext {
		public TerminalNode LONE_CODE() { return getToken(DocumentParser.LONE_CODE, 0); }
		public LonecodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lonecode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DocumentParserListener ) ((DocumentParserListener)listener).enterLonecode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DocumentParserListener ) ((DocumentParserListener)listener).exitLonecode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DocumentParserVisitor ) return ((DocumentParserVisitor<? extends T>)visitor).visitLonecode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LonecodeContext lonecode() throws RecognitionException {
		LonecodeContext _localctx = new LonecodeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_lonecode);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			match(LONE_CODE);
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

	public static class InlinecodeContext extends ParserRuleContext {
		public TerminalNode CODE() { return getToken(DocumentParser.CODE, 0); }
		public TerminalNode CCONTENT() { return getToken(DocumentParser.CCONTENT, 0); }
		public InlinecodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inlinecode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DocumentParserListener ) ((DocumentParserListener)listener).enterInlinecode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DocumentParserListener ) ((DocumentParserListener)listener).exitInlinecode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DocumentParserVisitor ) return ((DocumentParserVisitor<? extends T>)visitor).visitInlinecode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InlinecodeContext inlinecode() throws RecognitionException {
		InlinecodeContext _localctx = new InlinecodeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_inlinecode);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			match(CODE);
			setState(165);
			match(CCONTENT);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 6:
			return surroundCall_sempred((SurroundCallContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean surroundCall_sempred(SurroundCallContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return (((SurroundCallContext)_localctx).left!=null?((SurroundCallContext)_localctx).left.getText():null).equals((((SurroundCallContext)_localctx).right!=null?((SurroundCallContext)_localctx).right.getText():null));
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\'\u00aa\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\2\3\3\7\3$\n\3\f"+
		"\3\16\3\'\13\3\3\4\3\4\3\4\3\4\3\4\5\4.\n\4\3\5\3\5\6\5\62\n\5\r\5\16"+
		"\5\63\3\5\3\5\6\58\n\5\r\5\16\59\3\5\5\5=\n\5\3\5\3\5\6\5A\n\5\r\5\16"+
		"\5B\3\5\5\5F\n\5\5\5H\n\5\3\6\3\6\6\6L\n\6\r\6\16\6M\3\6\3\6\6\6R\n\6"+
		"\r\6\16\6S\3\6\5\6W\n\6\3\6\3\6\6\6[\n\6\r\6\16\6\\\3\6\5\6`\n\6\5\6b"+
		"\n\6\3\7\3\7\3\b\6\bg\n\b\r\b\16\bh\3\b\6\bl\n\b\r\b\16\bm\3\b\3\b\5\b"+
		"r\n\b\5\bt\n\b\3\b\5\bw\n\b\3\b\6\bz\n\b\r\b\16\b{\3\b\3\b\3\t\3\t\3\n"+
		"\3\n\3\n\6\n\u0085\n\n\r\n\16\n\u0086\3\13\3\13\3\f\7\f\u008c\n\f\f\f"+
		"\16\f\u008f\13\f\3\f\3\f\7\f\u0093\n\f\f\f\16\f\u0096\13\f\6\f\u0098\n"+
		"\f\r\f\16\f\u0099\3\f\6\f\u009d\n\f\r\f\16\f\u009e\5\f\u00a1\n\f\3\r\3"+
		"\r\3\16\3\16\3\17\3\17\3\17\3\17\3v\2\20\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\2\6\4\2\31\35\37\37\4\2\27\32\34 \4\2\30\32\34 \4\2\t\t!!\u00ba"+
		"\2\36\3\2\2\2\4%\3\2\2\2\6-\3\2\2\2\bG\3\2\2\2\na\3\2\2\2\fc\3\2\2\2\16"+
		"f\3\2\2\2\20\177\3\2\2\2\22\u0084\3\2\2\2\24\u0088\3\2\2\2\26\u00a0\3"+
		"\2\2\2\30\u00a2\3\2\2\2\32\u00a4\3\2\2\2\34\u00a6\3\2\2\2\36\37\7\3\2"+
		"\2\37 \5\4\3\2 !\7\2\2\3!\3\3\2\2\2\"$\5\6\4\2#\"\3\2\2\2$\'\3\2\2\2%"+
		"#\3\2\2\2%&\3\2\2\2&\5\3\2\2\2\'%\3\2\2\2(.\5\b\5\2).\5\20\t\2*.\5\30"+
		"\r\2+.\5\32\16\2,.\5\24\13\2-(\3\2\2\2-)\3\2\2\2-*\3\2\2\2-+\3\2\2\2-"+
		",\3\2\2\2.\7\3\2\2\2/\61\7\27\2\2\60\62\7\n\2\2\61\60\3\2\2\2\62\63\3"+
		"\2\2\2\63\61\3\2\2\2\63\64\3\2\2\2\64\65\3\2\2\2\65<\5\22\n\2\668\7\n"+
		"\2\2\67\66\3\2\2\289\3\2\2\29\67\3\2\2\29:\3\2\2\2:;\3\2\2\2;=\5\n\6\2"+
		"<\67\3\2\2\2<=\3\2\2\2=H\3\2\2\2>@\7\27\2\2?A\7\n\2\2@?\3\2\2\2AB\3\2"+
		"\2\2B@\3\2\2\2BC\3\2\2\2CE\3\2\2\2DF\5\n\6\2ED\3\2\2\2EF\3\2\2\2FH\3\2"+
		"\2\2G/\3\2\2\2G>\3\2\2\2H\t\3\2\2\2IK\5\f\7\2JL\7\n\2\2KJ\3\2\2\2LM\3"+
		"\2\2\2MK\3\2\2\2MN\3\2\2\2NO\3\2\2\2OV\5\22\n\2PR\7\n\2\2QP\3\2\2\2RS"+
		"\3\2\2\2SQ\3\2\2\2ST\3\2\2\2TU\3\2\2\2UW\5\n\6\2VQ\3\2\2\2VW\3\2\2\2W"+
		"b\3\2\2\2XZ\5\f\7\2Y[\7\n\2\2ZY\3\2\2\2[\\\3\2\2\2\\Z\3\2\2\2\\]\3\2\2"+
		"\2]_\3\2\2\2^`\5\n\6\2_^\3\2\2\2_`\3\2\2\2`b\3\2\2\2aI\3\2\2\2aX\3\2\2"+
		"\2b\13\3\2\2\2cd\t\2\2\2d\r\3\2\2\2eg\t\3\2\2fe\3\2\2\2gh\3\2\2\2hf\3"+
		"\2\2\2hi\3\2\2\2is\3\2\2\2jl\7\t\2\2kj\3\2\2\2lm\3\2\2\2mk\3\2\2\2mn\3"+
		"\2\2\2nt\3\2\2\2or\5\34\17\2pr\7!\2\2qo\3\2\2\2qp\3\2\2\2rt\3\2\2\2sk"+
		"\3\2\2\2sq\3\2\2\2tv\3\2\2\2uw\5\22\n\2vw\3\2\2\2vu\3\2\2\2wy\3\2\2\2"+
		"xz\t\4\2\2yx\3\2\2\2z{\3\2\2\2{y\3\2\2\2{|\3\2\2\2|}\3\2\2\2}~\6\b\2\3"+
		"~\17\3\2\2\2\177\u0080\5\22\n\2\u0080\21\3\2\2\2\u0081\u0085\5\26\f\2"+
		"\u0082\u0085\5\34\17\2\u0083\u0085\5\16\b\2\u0084\u0081\3\2\2\2\u0084"+
		"\u0082\3\2\2\2\u0084\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0084\3\2"+
		"\2\2\u0086\u0087\3\2\2\2\u0087\23\3\2\2\2\u0088\u0089\7\f\2\2\u0089\25"+
		"\3\2\2\2\u008a\u008c\7\n\2\2\u008b\u008a\3\2\2\2\u008c\u008f\3\2\2\2\u008d"+
		"\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u0090\3\2\2\2\u008f\u008d\3\2"+
		"\2\2\u0090\u0094\t\5\2\2\u0091\u0093\7\n\2\2\u0092\u0091\3\2\2\2\u0093"+
		"\u0096\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0098\3\2"+
		"\2\2\u0096\u0094\3\2\2\2\u0097\u008d\3\2\2\2\u0098\u0099\3\2\2\2\u0099"+
		"\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u00a1\3\2\2\2\u009b\u009d\7\n"+
		"\2\2\u009c\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009c\3\2\2\2\u009e"+
		"\u009f\3\2\2\2\u009f\u00a1\3\2\2\2\u00a0\u0097\3\2\2\2\u00a0\u009c\3\2"+
		"\2\2\u00a1\27\3\2\2\2\u00a2\u00a3\7\6\2\2\u00a3\31\3\2\2\2\u00a4\u00a5"+
		"\7\7\2\2\u00a5\33\3\2\2\2\u00a6\u00a7\7\b\2\2\u00a7\u00a8\7\"\2\2\u00a8"+
		"\35\3\2\2\2\35%-\639<BEGMSV\\_ahmqsv{\u0084\u0086\u008d\u0094\u0099\u009e"+
		"\u00a0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}