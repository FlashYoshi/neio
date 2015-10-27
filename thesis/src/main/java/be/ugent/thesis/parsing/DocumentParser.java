// Generated from Document.g4 by ANTLR 4.5.1
package be.ugent.thesis.parsing;
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
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		HEADER=1, HEADER_CONTENT=2, COMMENT=3, MULTILINE_COMMENT=4, WORD=5, WORDS=6, 
		WS=7, NEWLINE=8, HASH=9;
	public static final int
		RULE_document = 0, RULE_body = 1, RULE_section = 2, RULE_paragraph = 3;
	public static final String[] ruleNames = {
		"document", "body", "section", "paragraph"
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

	@Override
	public String getGrammarFileName() { return "Document.g4"; }

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
		public TerminalNode EOF() { return getToken(DocumentParser.EOF, 0); }
		public List<BodyContext> body() {
			return getRuleContexts(BodyContext.class);
		}
		public BodyContext body(int i) {
			return getRuleContext(BodyContext.class,i);
		}
		public DocumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_document; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DocumentListener ) ((DocumentListener)listener).enterDocument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DocumentListener ) ((DocumentListener)listener).exitDocument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DocumentVisitor ) return ((DocumentVisitor<? extends T>)visitor).visitDocument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DocumentContext document() throws RecognitionException {
		DocumentContext _localctx = new DocumentContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_document);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(8);
			match(HEADER);
			setState(12);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WORDS || _la==HASH) {
				{
				{
				setState(9);
				body();
				}
				}
				setState(14);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(15);
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
		public SectionContext section() {
			return getRuleContext(SectionContext.class,0);
		}
		public ParagraphContext paragraph() {
			return getRuleContext(ParagraphContext.class,0);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DocumentListener ) ((DocumentListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DocumentListener ) ((DocumentListener)listener).exitBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DocumentVisitor ) return ((DocumentVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_body);
		try {
			setState(19);
			switch (_input.LA(1)) {
			case HASH:
				enterOuterAlt(_localctx, 1);
				{
				setState(17);
				section();
				}
				break;
			case WORDS:
				enterOuterAlt(_localctx, 2);
				{
				setState(18);
				paragraph();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class SectionContext extends ParserRuleContext {
		public TerminalNode WORDS() { return getToken(DocumentParser.WORDS, 0); }
		public List<TerminalNode> HASH() { return getTokens(DocumentParser.HASH); }
		public TerminalNode HASH(int i) {
			return getToken(DocumentParser.HASH, i);
		}
		public SectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_section; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DocumentListener ) ((DocumentListener)listener).enterSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DocumentListener ) ((DocumentListener)listener).exitSection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DocumentVisitor ) return ((DocumentVisitor<? extends T>)visitor).visitSection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SectionContext section() throws RecognitionException {
		SectionContext _localctx = new SectionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_section);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(21);
				match(HASH);
				}
				}
				setState(24); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==HASH );
			setState(26);
			match(WORDS);
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

	public static class ParagraphContext extends ParserRuleContext {
		public TerminalNode WORDS() { return getToken(DocumentParser.WORDS, 0); }
		public ParagraphContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paragraph; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DocumentListener ) ((DocumentListener)listener).enterParagraph(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DocumentListener ) ((DocumentListener)listener).exitParagraph(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DocumentVisitor ) return ((DocumentVisitor<? extends T>)visitor).visitParagraph(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParagraphContext paragraph() throws RecognitionException {
		ParagraphContext _localctx = new ParagraphContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_paragraph);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			match(WORDS);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\13!\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\3\2\3\2\7\2\r\n\2\f\2\16\2\20\13\2\3\2\3\2\3\3\3\3"+
		"\5\3\26\n\3\3\4\6\4\31\n\4\r\4\16\4\32\3\4\3\4\3\5\3\5\3\5\2\2\6\2\4\6"+
		"\b\2\2\37\2\n\3\2\2\2\4\25\3\2\2\2\6\30\3\2\2\2\b\36\3\2\2\2\n\16\7\3"+
		"\2\2\13\r\5\4\3\2\f\13\3\2\2\2\r\20\3\2\2\2\16\f\3\2\2\2\16\17\3\2\2\2"+
		"\17\21\3\2\2\2\20\16\3\2\2\2\21\22\7\2\2\3\22\3\3\2\2\2\23\26\5\6\4\2"+
		"\24\26\5\b\5\2\25\23\3\2\2\2\25\24\3\2\2\2\26\5\3\2\2\2\27\31\7\13\2\2"+
		"\30\27\3\2\2\2\31\32\3\2\2\2\32\30\3\2\2\2\32\33\3\2\2\2\33\34\3\2\2\2"+
		"\34\35\7\b\2\2\35\7\3\2\2\2\36\37\7\b\2\2\37\t\3\2\2\2\5\16\25\32";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}