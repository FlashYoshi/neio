// Generated from B:\Documents\GitHub\Thesis\thesis\src\main\grammar\ThesisScriptParser.g4 by ANTLR 4.2.2
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
public class ThesisScriptParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NEW=5, DOUBLE_QUOTE=26, STUB=7, COMMENT=1, CLASS_NAME=8, MINUS=18, BIGGER=21, 
		CAMEL_CASE=9, SEMICOLON=15, SMALLER=20, MULTILINE_COMMENT=2, LEFT_BRACE=22, 
		WS=3, COMMA=13, RIGHT_BRACE=23, EQUALS=16, RIGHT_CURLY_BRACE=25, COLON=14, 
		SCRIPT=6, STAR=19, PERIOD=12, VAR_WITH_TYPE=10, STRING=11, METHOD_NAME=27, 
		LEFT_CURLY_BRACE=24, NL=4, PLUS=17;
	public static final String[] tokenNames = {
		"<INVALID>", "COMMENT", "MULTILINE_COMMENT", "WS", "NL", "'new'", "'script'", 
		"'stub'", "CLASS_NAME", "CAMEL_CASE", "VAR_WITH_TYPE", "STRING", "'.'", 
		"','", "':'", "';'", "'='", "'+'", "'-'", "'*'", "'<'", "'>'", "'('", 
		"')'", "'{'", "'}'", "'\"'", "METHOD_NAME"
	};
	public static final int
		RULE_document = 0, RULE_scriptBody = 1, RULE_statement = 2, RULE_assignment = 3, 
		RULE_methodCall = 4, RULE_newCall = 5, RULE_field = 6, RULE_var = 7, RULE_fieldName = 8, 
		RULE_arguments = 9, RULE_parameter = 10, RULE_parameters = 11, RULE_call = 12, 
		RULE_methodName = 13, RULE_chain = 14;
	public static final String[] ruleNames = {
		"document", "scriptBody", "statement", "assignment", "methodCall", "newCall", 
		"field", "var", "fieldName", "arguments", "parameter", "parameters", "call", 
		"methodName", "chain"
	};

	@Override
	public String getGrammarFileName() { return "ThesisScriptParser.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ThesisScriptParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class DocumentContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(ThesisScriptParser.EOF, 0); }
		public TerminalNode SCRIPT() { return getToken(ThesisScriptParser.SCRIPT, 0); }
		public ScriptBodyContext scriptBody() {
			return getRuleContext(ScriptBodyContext.class,0);
		}
		public DocumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_document; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisScriptParserListener ) ((ThesisScriptParserListener)listener).enterDocument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisScriptParserListener ) ((ThesisScriptParserListener)listener).exitDocument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThesisScriptParserVisitor ) return ((ThesisScriptParserVisitor<? extends T>)visitor).visitDocument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DocumentContext document() throws RecognitionException {
		DocumentContext _localctx = new DocumentContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_document);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30); match(SCRIPT);
			setState(31); scriptBody();
			setState(32); match(EOF);
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

	public static class ScriptBodyContext extends ParserRuleContext {
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public ScriptBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scriptBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisScriptParserListener ) ((ThesisScriptParserListener)listener).enterScriptBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisScriptParserListener ) ((ThesisScriptParserListener)listener).exitScriptBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThesisScriptParserVisitor ) return ((ThesisScriptParserVisitor<? extends T>)visitor).visitScriptBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScriptBodyContext scriptBody() throws RecognitionException {
		ScriptBodyContext _localctx = new ScriptBodyContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_scriptBody);
		int _la;
		try {
			setState(40);
			switch (_input.LA(1)) {
			case NEW:
			case CLASS_NAME:
			case CAMEL_CASE:
			case VAR_WITH_TYPE:
			case PERIOD:
			case COLON:
				enterOuterAlt(_localctx, 1);
				{
				setState(35); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(34); statement();
					}
					}
					setState(37); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << CLASS_NAME) | (1L << CAMEL_CASE) | (1L << VAR_WITH_TYPE) | (1L << PERIOD) | (1L << COLON))) != 0) );
				}
				break;
			case EOF:
				enterOuterAlt(_localctx, 2);
				{
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

	public static class StatementContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public MethodCallContext methodCall() {
			return getRuleContext(MethodCallContext.class,0);
		}
		public NewCallContext newCall() {
			return getRuleContext(NewCallContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisScriptParserListener ) ((ThesisScriptParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisScriptParserListener ) ((ThesisScriptParserListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThesisScriptParserVisitor ) return ((ThesisScriptParserVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(42); assignment();
				}
				break;

			case 2:
				{
				setState(43); methodCall();
				}
				break;

			case 3:
				{
				setState(44); newCall();
				}
				break;
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

	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode EQUALS() { return getToken(ThesisScriptParser.EQUALS, 0); }
		public List<TerminalNode> CAMEL_CASE() { return getTokens(ThesisScriptParser.CAMEL_CASE); }
		public List<ChainContext> chain() {
			return getRuleContexts(ChainContext.class);
		}
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public ChainContext chain(int i) {
			return getRuleContext(ChainContext.class,i);
		}
		public MethodCallContext methodCall() {
			return getRuleContext(MethodCallContext.class,0);
		}
		public TerminalNode CAMEL_CASE(int i) {
			return getToken(ThesisScriptParser.CAMEL_CASE, i);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisScriptParserListener ) ((ThesisScriptParserListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisScriptParserListener ) ((ThesisScriptParserListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThesisScriptParserVisitor ) return ((ThesisScriptParserVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(47); chain();
				}
				break;

			case 2:
				{
				setState(48); var();
				}
				break;

			case 3:
				{
				setState(49); match(CAMEL_CASE);
				}
				break;
			}
			setState(52); match(EQUALS);
			setState(56);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(53); match(CAMEL_CASE);
				}
				break;

			case 2:
				{
				setState(54); chain();
				}
				break;

			case 3:
				{
				setState(55); methodCall();
				}
				break;
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

	public static class MethodCallContext extends ParserRuleContext {
		public TerminalNode CLASS_NAME() { return getToken(ThesisScriptParser.CLASS_NAME, 0); }
		public TerminalNode CAMEL_CASE() { return getToken(ThesisScriptParser.CAMEL_CASE, 0); }
		public List<CallContext> call() {
			return getRuleContexts(CallContext.class);
		}
		public CallContext call(int i) {
			return getRuleContext(CallContext.class,i);
		}
		public MethodCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisScriptParserListener ) ((ThesisScriptParserListener)listener).enterMethodCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisScriptParserListener ) ((ThesisScriptParserListener)listener).exitMethodCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThesisScriptParserVisitor ) return ((ThesisScriptParserVisitor<? extends T>)visitor).visitMethodCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodCallContext methodCall() throws RecognitionException {
		MethodCallContext _localctx = new MethodCallContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_methodCall);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			_la = _input.LA(1);
			if (_la==CLASS_NAME || _la==CAMEL_CASE) {
				{
				setState(58);
				_la = _input.LA(1);
				if ( !(_la==CLASS_NAME || _la==CAMEL_CASE) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(62); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(61); call();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(64); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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

	public static class NewCallContext extends ParserRuleContext {
		public TerminalNode EQUALS() { return getToken(ThesisScriptParser.EQUALS, 0); }
		public TerminalNode CAMEL_CASE() { return getToken(ThesisScriptParser.CAMEL_CASE, 0); }
		public TerminalNode CLASS_NAME() { return getToken(ThesisScriptParser.CLASS_NAME, 0); }
		public TerminalNode VAR_WITH_TYPE() { return getToken(ThesisScriptParser.VAR_WITH_TYPE, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public TerminalNode LEFT_BRACE() { return getToken(ThesisScriptParser.LEFT_BRACE, 0); }
		public TerminalNode NEW() { return getToken(ThesisScriptParser.NEW, 0); }
		public TerminalNode RIGHT_BRACE() { return getToken(ThesisScriptParser.RIGHT_BRACE, 0); }
		public NewCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisScriptParserListener ) ((ThesisScriptParserListener)listener).enterNewCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisScriptParserListener ) ((ThesisScriptParserListener)listener).exitNewCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThesisScriptParserVisitor ) return ((ThesisScriptParserVisitor<? extends T>)visitor).visitNewCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewCallContext newCall() throws RecognitionException {
		NewCallContext _localctx = new NewCallContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_newCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			switch (_input.LA(1)) {
			case NEW:
				{
				setState(66); match(NEW);
				setState(67);
				_la = _input.LA(1);
				if ( !(_la==CLASS_NAME || _la==VAR_WITH_TYPE) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(68); match(LEFT_BRACE);
				setState(69); parameters();
				setState(70); match(RIGHT_BRACE);
				setState(71); match(CAMEL_CASE);
				}
				break;
			case CLASS_NAME:
			case CAMEL_CASE:
			case VAR_WITH_TYPE:
				{
				setState(75);
				switch (_input.LA(1)) {
				case CLASS_NAME:
				case VAR_WITH_TYPE:
					{
					setState(73); var();
					}
					break;
				case CAMEL_CASE:
					{
					setState(74); match(CAMEL_CASE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(77); match(EQUALS);
				setState(78); match(NEW);
				setState(79); match(CLASS_NAME);
				setState(80); match(LEFT_BRACE);
				setState(81); parameters();
				setState(82); match(RIGHT_BRACE);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class FieldContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(ThesisScriptParser.SEMICOLON, 0); }
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisScriptParserListener ) ((ThesisScriptParserListener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisScriptParserListener ) ((ThesisScriptParserListener)listener).exitField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThesisScriptParserVisitor ) return ((ThesisScriptParserVisitor<? extends T>)visitor).visitField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_field);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86); var();
			setState(87); match(SEMICOLON);
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

	public static class VarContext extends ParserRuleContext {
		public FieldNameContext fieldName() {
			return getRuleContext(FieldNameContext.class,0);
		}
		public TerminalNode CAMEL_CASE() { return getToken(ThesisScriptParser.CAMEL_CASE, 0); }
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisScriptParserListener ) ((ThesisScriptParserListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisScriptParserListener ) ((ThesisScriptParserListener)listener).exitVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThesisScriptParserVisitor ) return ((ThesisScriptParserVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89); fieldName();
			setState(90); match(CAMEL_CASE);
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

	public static class FieldNameContext extends ParserRuleContext {
		public TerminalNode CLASS_NAME() { return getToken(ThesisScriptParser.CLASS_NAME, 0); }
		public TerminalNode VAR_WITH_TYPE() { return getToken(ThesisScriptParser.VAR_WITH_TYPE, 0); }
		public FieldNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisScriptParserListener ) ((ThesisScriptParserListener)listener).enterFieldName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisScriptParserListener ) ((ThesisScriptParserListener)listener).exitFieldName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThesisScriptParserVisitor ) return ((ThesisScriptParserVisitor<? extends T>)visitor).visitFieldName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldNameContext fieldName() throws RecognitionException {
		FieldNameContext _localctx = new FieldNameContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_fieldName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			_la = _input.LA(1);
			if ( !(_la==CLASS_NAME || _la==VAR_WITH_TYPE) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class ArgumentsContext extends ParserRuleContext {
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(ThesisScriptParser.COMMA); }
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(ThesisScriptParser.COMMA, i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisScriptParserListener ) ((ThesisScriptParserListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisScriptParserListener ) ((ThesisScriptParserListener)listener).exitArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThesisScriptParserVisitor ) return ((ThesisScriptParserVisitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_arguments);
		try {
			int _alt;
			setState(104);
			switch (_input.LA(1)) {
			case CLASS_NAME:
			case VAR_WITH_TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(99);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				while ( _alt!=2 && _alt!=ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(94); var();
						setState(95); match(COMMA);
						}
						} 
					}
					setState(101);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				}
				setState(102); var();
				}
				break;
			case EOF:
				enterOuterAlt(_localctx, 2);
				{
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

	public static class ParameterContext extends ParserRuleContext {
		public TerminalNode CAMEL_CASE() { return getToken(ThesisScriptParser.CAMEL_CASE, 0); }
		public MethodCallContext methodCall() {
			return getRuleContext(MethodCallContext.class,0);
		}
		public TerminalNode STRING() { return getToken(ThesisScriptParser.STRING, 0); }
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisScriptParserListener ) ((ThesisScriptParserListener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisScriptParserListener ) ((ThesisScriptParserListener)listener).exitParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThesisScriptParserVisitor ) return ((ThesisScriptParserVisitor<? extends T>)visitor).visitParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_parameter);
		try {
			setState(109);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(106); match(STRING);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(107); match(CAMEL_CASE);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(108); methodCall();
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

	public static class ParametersContext extends ParserRuleContext {
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ThesisScriptParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ThesisScriptParser.COMMA, i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisScriptParserListener ) ((ThesisScriptParserListener)listener).enterParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisScriptParserListener ) ((ThesisScriptParserListener)listener).exitParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThesisScriptParserVisitor ) return ((ThesisScriptParserVisitor<? extends T>)visitor).visitParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_parameters);
		try {
			int _alt;
			setState(121);
			switch (_input.LA(1)) {
			case CLASS_NAME:
			case CAMEL_CASE:
			case STRING:
			case PERIOD:
			case COLON:
				enterOuterAlt(_localctx, 1);
				{
				setState(116);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				while ( _alt!=2 && _alt!=ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(111); parameter();
						setState(112); match(COMMA);
						}
						} 
					}
					setState(118);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				}
				setState(119); parameter();
				}
				break;
			case RIGHT_BRACE:
				enterOuterAlt(_localctx, 2);
				{
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

	public static class CallContext extends ParserRuleContext {
		public MethodNameContext methodName() {
			return getRuleContext(MethodNameContext.class,0);
		}
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public TerminalNode COLON() { return getToken(ThesisScriptParser.COLON, 0); }
		public TerminalNode LEFT_BRACE() { return getToken(ThesisScriptParser.LEFT_BRACE, 0); }
		public TerminalNode PERIOD() { return getToken(ThesisScriptParser.PERIOD, 0); }
		public TerminalNode RIGHT_BRACE() { return getToken(ThesisScriptParser.RIGHT_BRACE, 0); }
		public CallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisScriptParserListener ) ((ThesisScriptParserListener)listener).enterCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisScriptParserListener ) ((ThesisScriptParserListener)listener).exitCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThesisScriptParserVisitor ) return ((ThesisScriptParserVisitor<? extends T>)visitor).visitCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallContext call() throws RecognitionException {
		CallContext _localctx = new CallContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			_la = _input.LA(1);
			if ( !(_la==PERIOD || _la==COLON) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(124); methodName();
			setState(125); match(LEFT_BRACE);
			setState(126); parameters();
			setState(127); match(RIGHT_BRACE);
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

	public static class MethodNameContext extends ParserRuleContext {
		public TerminalNode CLASS_NAME() { return getToken(ThesisScriptParser.CLASS_NAME, 0); }
		public TerminalNode CAMEL_CASE() { return getToken(ThesisScriptParser.CAMEL_CASE, 0); }
		public TerminalNode METHOD_NAME() { return getToken(ThesisScriptParser.METHOD_NAME, 0); }
		public MethodNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisScriptParserListener ) ((ThesisScriptParserListener)listener).enterMethodName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisScriptParserListener ) ((ThesisScriptParserListener)listener).exitMethodName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThesisScriptParserVisitor ) return ((ThesisScriptParserVisitor<? extends T>)visitor).visitMethodName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodNameContext methodName() throws RecognitionException {
		MethodNameContext _localctx = new MethodNameContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_methodName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CLASS_NAME) | (1L << CAMEL_CASE) | (1L << METHOD_NAME))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class ChainContext extends ParserRuleContext {
		public TerminalNode CLASS_NAME(int i) {
			return getToken(ThesisScriptParser.CLASS_NAME, i);
		}
		public List<TerminalNode> CLASS_NAME() { return getTokens(ThesisScriptParser.CLASS_NAME); }
		public List<TerminalNode> CAMEL_CASE() { return getTokens(ThesisScriptParser.CAMEL_CASE); }
		public TerminalNode CAMEL_CASE(int i) {
			return getToken(ThesisScriptParser.CAMEL_CASE, i);
		}
		public List<TerminalNode> PERIOD() { return getTokens(ThesisScriptParser.PERIOD); }
		public TerminalNode PERIOD(int i) {
			return getToken(ThesisScriptParser.PERIOD, i);
		}
		public ChainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chain; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisScriptParserListener ) ((ThesisScriptParserListener)listener).enterChain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisScriptParserListener ) ((ThesisScriptParserListener)listener).exitChain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThesisScriptParserVisitor ) return ((ThesisScriptParserVisitor<? extends T>)visitor).visitChain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChainContext chain() throws RecognitionException {
		ChainContext _localctx = new ChainContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_chain);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			_la = _input.LA(1);
			if ( !(_la==CLASS_NAME || _la==CAMEL_CASE) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(134); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(132); match(PERIOD);
					setState(133);
					_la = _input.LA(1);
					if ( !(_la==CLASS_NAME || _la==CAMEL_CASE) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(136); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\35\u008d\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\2\3"+
		"\3\6\3&\n\3\r\3\16\3\'\3\3\5\3+\n\3\3\4\3\4\3\4\5\4\60\n\4\3\5\3\5\3\5"+
		"\5\5\65\n\5\3\5\3\5\3\5\3\5\5\5;\n\5\3\6\5\6>\n\6\3\6\6\6A\n\6\r\6\16"+
		"\6B\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7N\n\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\5\7W\n\7\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\7\13d\n"+
		"\13\f\13\16\13g\13\13\3\13\3\13\5\13k\n\13\3\f\3\f\3\f\5\fp\n\f\3\r\3"+
		"\r\3\r\7\ru\n\r\f\r\16\rx\13\r\3\r\3\r\5\r|\n\r\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\17\3\17\3\20\3\20\3\20\6\20\u0089\n\20\r\20\16\20\u008a\3\20"+
		"\2\2\21\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36\2\6\3\2\n\13\4\2\n\n\f"+
		"\f\4\2\16\16\20\20\4\2\n\13\35\35\u0090\2 \3\2\2\2\4*\3\2\2\2\6/\3\2\2"+
		"\2\b\64\3\2\2\2\n=\3\2\2\2\fV\3\2\2\2\16X\3\2\2\2\20[\3\2\2\2\22^\3\2"+
		"\2\2\24j\3\2\2\2\26o\3\2\2\2\30{\3\2\2\2\32}\3\2\2\2\34\u0083\3\2\2\2"+
		"\36\u0085\3\2\2\2 !\7\b\2\2!\"\5\4\3\2\"#\7\2\2\3#\3\3\2\2\2$&\5\6\4\2"+
		"%$\3\2\2\2&\'\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2(+\3\2\2\2)+\3\2\2\2*%\3\2"+
		"\2\2*)\3\2\2\2+\5\3\2\2\2,\60\5\b\5\2-\60\5\n\6\2.\60\5\f\7\2/,\3\2\2"+
		"\2/-\3\2\2\2/.\3\2\2\2\60\7\3\2\2\2\61\65\5\36\20\2\62\65\5\20\t\2\63"+
		"\65\7\13\2\2\64\61\3\2\2\2\64\62\3\2\2\2\64\63\3\2\2\2\65\66\3\2\2\2\66"+
		":\7\22\2\2\67;\7\13\2\28;\5\36\20\29;\5\n\6\2:\67\3\2\2\2:8\3\2\2\2:9"+
		"\3\2\2\2;\t\3\2\2\2<>\t\2\2\2=<\3\2\2\2=>\3\2\2\2>@\3\2\2\2?A\5\32\16"+
		"\2@?\3\2\2\2AB\3\2\2\2B@\3\2\2\2BC\3\2\2\2C\13\3\2\2\2DE\7\7\2\2EF\t\3"+
		"\2\2FG\7\30\2\2GH\5\30\r\2HI\7\31\2\2IJ\7\13\2\2JW\3\2\2\2KN\5\20\t\2"+
		"LN\7\13\2\2MK\3\2\2\2ML\3\2\2\2NO\3\2\2\2OP\7\22\2\2PQ\7\7\2\2QR\7\n\2"+
		"\2RS\7\30\2\2ST\5\30\r\2TU\7\31\2\2UW\3\2\2\2VD\3\2\2\2VM\3\2\2\2W\r\3"+
		"\2\2\2XY\5\20\t\2YZ\7\21\2\2Z\17\3\2\2\2[\\\5\22\n\2\\]\7\13\2\2]\21\3"+
		"\2\2\2^_\t\3\2\2_\23\3\2\2\2`a\5\20\t\2ab\7\17\2\2bd\3\2\2\2c`\3\2\2\2"+
		"dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2fh\3\2\2\2ge\3\2\2\2hk\5\20\t\2ik\3\2\2"+
		"\2je\3\2\2\2ji\3\2\2\2k\25\3\2\2\2lp\7\r\2\2mp\7\13\2\2np\5\n\6\2ol\3"+
		"\2\2\2om\3\2\2\2on\3\2\2\2p\27\3\2\2\2qr\5\26\f\2rs\7\17\2\2su\3\2\2\2"+
		"tq\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2wy\3\2\2\2xv\3\2\2\2y|\5\26\f"+
		"\2z|\3\2\2\2{v\3\2\2\2{z\3\2\2\2|\31\3\2\2\2}~\t\4\2\2~\177\5\34\17\2"+
		"\177\u0080\7\30\2\2\u0080\u0081\5\30\r\2\u0081\u0082\7\31\2\2\u0082\33"+
		"\3\2\2\2\u0083\u0084\t\5\2\2\u0084\35\3\2\2\2\u0085\u0088\t\2\2\2\u0086"+
		"\u0087\7\16\2\2\u0087\u0089\t\2\2\2\u0088\u0086\3\2\2\2\u0089\u008a\3"+
		"\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\37\3\2\2\2\21\'*"+
		"/\64:=BMVejov{\u008a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}