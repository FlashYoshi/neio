// Generated from ThesisParser.g4 by ANTLR 4.5.1
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
public class ThesisParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		HEADER=1, COMMENT=2, MULTILINE_COMMENT=3, PACKAGE=4, WS=5, NEWLINE=6, 
		CAPITAL=7, LETTER=8, EXTENDS=9, IMPLEMENTS=10, RETURN=11, NEW=12, METHOD_OPTION=13, 
		STUB=14, CLASS_NAME=15, CAMEL_CASE=16, VAR_WITH_TYPE=17, PERIOD=18, COMMA=19, 
		COLON=20, SEMICOLON=21, EQUALS=22, PLUS=23, MINUS=24, STAR=25, SMALLER=26, 
		BIGGER=27, LEFT_BRACE=28, RIGHT_BRACE=29, LEFT_CURLY_BRACE=30, RIGHT_CURLY_BRACE=31, 
		METHOD_NAME=32;
	public static final int
		RULE_document = 0, RULE_body = 1, RULE_classBody = 2, RULE_interfaceBody = 3, 
		RULE_scriptBody = 4, RULE_extension = 5, RULE_field = 6, RULE_method = 7, 
		RULE_call = 8, RULE_methodName = 9, RULE_var = 10, RULE_arguments = 11, 
		RULE_block = 12, RULE_statement = 13, RULE_methodCall = 14, RULE_assignment = 15, 
		RULE_newCall = 16, RULE_returnCall = 17;
	public static final String[] ruleNames = {
		"document", "body", "classBody", "interfaceBody", "scriptBody", "extension", 
		"field", "method", "call", "methodName", "var", "arguments", "block", 
		"statement", "methodCall", "assignment", "newCall", "returnCall"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, null, null, "'extends'", "'implements'", 
		"'return'", "'new'", null, "'stub'", null, null, null, "'.'", "','", "':'", 
		"';'", "'='", "'+'", "'-'", "'*'", "'<'", "'>'", "'('", "')'", "'{'", 
		"'}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "HEADER", "COMMENT", "MULTILINE_COMMENT", "PACKAGE", "WS", "NEWLINE", 
		"CAPITAL", "LETTER", "EXTENDS", "IMPLEMENTS", "RETURN", "NEW", "METHOD_OPTION", 
		"STUB", "CLASS_NAME", "CAMEL_CASE", "VAR_WITH_TYPE", "PERIOD", "COMMA", 
		"COLON", "SEMICOLON", "EQUALS", "PLUS", "MINUS", "STAR", "SMALLER", "BIGGER", 
		"LEFT_BRACE", "RIGHT_BRACE", "LEFT_CURLY_BRACE", "RIGHT_CURLY_BRACE", 
		"METHOD_NAME"
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
	public String getGrammarFileName() { return "ThesisParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ThesisParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class DocumentContext extends ParserRuleContext {
		public TerminalNode HEADER() { return getToken(ThesisParser.HEADER, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ThesisParser.EOF, 0); }
		public DocumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_document; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisParserListener ) ((ThesisParserListener)listener).enterDocument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisParserListener ) ((ThesisParserListener)listener).exitDocument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThesisParserVisitor ) return ((ThesisParserVisitor<? extends T>)visitor).visitDocument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DocumentContext document() throws RecognitionException {
		DocumentContext _localctx = new DocumentContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_document);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			match(HEADER);
			setState(37);
			body();
			setState(38);
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
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public InterfaceBodyContext interfaceBody() {
			return getRuleContext(InterfaceBodyContext.class,0);
		}
		public ScriptBodyContext scriptBody() {
			return getRuleContext(ScriptBodyContext.class,0);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisParserListener ) ((ThesisParserListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisParserListener ) ((ThesisParserListener)listener).exitBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThesisParserVisitor ) return ((ThesisParserVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_body);
		try {
			setState(43);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(40);
				classBody();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(41);
				interfaceBody();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(42);
				scriptBody();
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

	public static class ClassBodyContext extends ParserRuleContext {
		public List<ExtensionContext> extension() {
			return getRuleContexts(ExtensionContext.class);
		}
		public ExtensionContext extension(int i) {
			return getRuleContext(ExtensionContext.class,i);
		}
		public List<FieldContext> field() {
			return getRuleContexts(FieldContext.class);
		}
		public FieldContext field(int i) {
			return getRuleContext(FieldContext.class,i);
		}
		public List<MethodContext> method() {
			return getRuleContexts(MethodContext.class);
		}
		public MethodContext method(int i) {
			return getRuleContext(MethodContext.class,i);
		}
		public ClassBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisParserListener ) ((ThesisParserListener)listener).enterClassBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisParserListener ) ((ThesisParserListener)listener).exitClassBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThesisParserVisitor ) return ((ThesisParserVisitor<? extends T>)visitor).visitClassBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassBodyContext classBody() throws RecognitionException {
		ClassBodyContext _localctx = new ClassBodyContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_classBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EXTENDS || _la==IMPLEMENTS) {
				{
				{
				setState(45);
				extension();
				}
				}
				setState(50);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << METHOD_OPTION) | (1L << CLASS_NAME) | (1L << CAMEL_CASE) | (1L << VAR_WITH_TYPE) | (1L << METHOD_NAME))) != 0)) {
				{
				setState(53);
				switch (_input.LA(1)) {
				case VAR_WITH_TYPE:
					{
					setState(51);
					field();
					}
					break;
				case METHOD_OPTION:
				case CLASS_NAME:
				case CAMEL_CASE:
				case METHOD_NAME:
					{
					setState(52);
					method();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(57);
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

	public static class InterfaceBodyContext extends ParserRuleContext {
		public TerminalNode STUB() { return getToken(ThesisParser.STUB, 0); }
		public InterfaceBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisParserListener ) ((ThesisParserListener)listener).enterInterfaceBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisParserListener ) ((ThesisParserListener)listener).exitInterfaceBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThesisParserVisitor ) return ((ThesisParserVisitor<? extends T>)visitor).visitInterfaceBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InterfaceBodyContext interfaceBody() throws RecognitionException {
		InterfaceBodyContext _localctx = new InterfaceBodyContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_interfaceBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
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

	public static class ScriptBodyContext extends ParserRuleContext {
		public TerminalNode STUB() { return getToken(ThesisParser.STUB, 0); }
		public ScriptBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scriptBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisParserListener ) ((ThesisParserListener)listener).enterScriptBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisParserListener ) ((ThesisParserListener)listener).exitScriptBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThesisParserVisitor ) return ((ThesisParserVisitor<? extends T>)visitor).visitScriptBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScriptBodyContext scriptBody() throws RecognitionException {
		ScriptBodyContext _localctx = new ScriptBodyContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_scriptBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
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

	public static class ExtensionContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(ThesisParser.SEMICOLON, 0); }
		public TerminalNode EXTENDS() { return getToken(ThesisParser.EXTENDS, 0); }
		public TerminalNode PACKAGE() { return getToken(ThesisParser.PACKAGE, 0); }
		public TerminalNode IMPLEMENTS() { return getToken(ThesisParser.IMPLEMENTS, 0); }
		public ExtensionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extension; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisParserListener ) ((ThesisParserListener)listener).enterExtension(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisParserListener ) ((ThesisParserListener)listener).exitExtension(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThesisParserVisitor ) return ((ThesisParserVisitor<? extends T>)visitor).visitExtension(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExtensionContext extension() throws RecognitionException {
		ExtensionContext _localctx = new ExtensionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_extension);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			switch (_input.LA(1)) {
			case EXTENDS:
				{
				setState(62);
				match(EXTENDS);
				setState(63);
				match(PACKAGE);
				}
				break;
			case IMPLEMENTS:
				{
				setState(64);
				match(IMPLEMENTS);
				setState(65);
				match(PACKAGE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(68);
			match(SEMICOLON);
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
		public TerminalNode VAR_WITH_TYPE() { return getToken(ThesisParser.VAR_WITH_TYPE, 0); }
		public TerminalNode CAMEL_CASE() { return getToken(ThesisParser.CAMEL_CASE, 0); }
		public TerminalNode SEMICOLON() { return getToken(ThesisParser.SEMICOLON, 0); }
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisParserListener ) ((ThesisParserListener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisParserListener ) ((ThesisParserListener)listener).exitField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThesisParserVisitor ) return ((ThesisParserVisitor<? extends T>)visitor).visitField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_field);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			match(VAR_WITH_TYPE);
			setState(71);
			match(CAMEL_CASE);
			setState(72);
			match(SEMICOLON);
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

	public static class MethodContext extends ParserRuleContext {
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public TerminalNode LEFT_CURLY_BRACE() { return getToken(ThesisParser.LEFT_CURLY_BRACE, 0); }
		public TerminalNode RIGHT_CURLY_BRACE() { return getToken(ThesisParser.RIGHT_CURLY_BRACE, 0); }
		public List<TerminalNode> METHOD_OPTION() { return getTokens(ThesisParser.METHOD_OPTION); }
		public TerminalNode METHOD_OPTION(int i) {
			return getToken(ThesisParser.METHOD_OPTION, i);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public MethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisParserListener ) ((ThesisParserListener)listener).enterMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisParserListener ) ((ThesisParserListener)listener).exitMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThesisParserVisitor ) return ((ThesisParserVisitor<? extends T>)visitor).visitMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodContext method() throws RecognitionException {
		MethodContext _localctx = new MethodContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_method);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==METHOD_OPTION) {
				{
				{
				setState(74);
				match(METHOD_OPTION);
				}
				}
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(80);
			call();
			setState(81);
			match(LEFT_CURLY_BRACE);
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << CLASS_NAME) | (1L << CAMEL_CASE) | (1L << VAR_WITH_TYPE))) != 0)) {
				{
				{
				setState(82);
				block();
				}
				}
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(88);
			match(RIGHT_CURLY_BRACE);
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
		public TerminalNode LEFT_BRACE() { return getToken(ThesisParser.LEFT_BRACE, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(ThesisParser.RIGHT_BRACE, 0); }
		public CallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisParserListener ) ((ThesisParserListener)listener).enterCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisParserListener ) ((ThesisParserListener)listener).exitCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThesisParserVisitor ) return ((ThesisParserVisitor<? extends T>)visitor).visitCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallContext call() throws RecognitionException {
		CallContext _localctx = new CallContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			methodName();
			setState(91);
			match(LEFT_BRACE);
			setState(92);
			arguments();
			setState(93);
			match(RIGHT_BRACE);
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
		public TerminalNode CLASS_NAME() { return getToken(ThesisParser.CLASS_NAME, 0); }
		public TerminalNode CAMEL_CASE() { return getToken(ThesisParser.CAMEL_CASE, 0); }
		public TerminalNode METHOD_NAME() { return getToken(ThesisParser.METHOD_NAME, 0); }
		public MethodNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisParserListener ) ((ThesisParserListener)listener).enterMethodName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisParserListener ) ((ThesisParserListener)listener).exitMethodName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThesisParserVisitor ) return ((ThesisParserVisitor<? extends T>)visitor).visitMethodName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodNameContext methodName() throws RecognitionException {
		MethodNameContext _localctx = new MethodNameContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_methodName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CLASS_NAME) | (1L << CAMEL_CASE) | (1L << METHOD_NAME))) != 0)) ) {
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

	public static class VarContext extends ParserRuleContext {
		public TerminalNode VAR_WITH_TYPE() { return getToken(ThesisParser.VAR_WITH_TYPE, 0); }
		public TerminalNode CAMEL_CASE() { return getToken(ThesisParser.CAMEL_CASE, 0); }
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisParserListener ) ((ThesisParserListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisParserListener ) ((ThesisParserListener)listener).exitVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThesisParserVisitor ) return ((ThesisParserVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(VAR_WITH_TYPE);
			setState(98);
			match(CAMEL_CASE);
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
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ThesisParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ThesisParser.COMMA, i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisParserListener ) ((ThesisParserListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisParserListener ) ((ThesisParserListener)listener).exitArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThesisParserVisitor ) return ((ThesisParserVisitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_arguments);
		try {
			int _alt;
			setState(110);
			switch (_input.LA(1)) {
			case VAR_WITH_TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(105);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(100);
						var();
						setState(101);
						match(COMMA);
						}
						} 
					}
					setState(107);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				}
				setState(108);
				var();
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

	public static class BlockContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<ReturnCallContext> returnCall() {
			return getRuleContexts(ReturnCallContext.class);
		}
		public ReturnCallContext returnCall(int i) {
			return getRuleContext(ReturnCallContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisParserListener ) ((ThesisParserListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisParserListener ) ((ThesisParserListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThesisParserVisitor ) return ((ThesisParserVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_block);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(113); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(112);
					statement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(115); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==RETURN) {
				{
				{
				setState(117);
				returnCall();
				}
				}
				setState(122);
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

	public static class StatementContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(ThesisParser.SEMICOLON, 0); }
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
			if ( listener instanceof ThesisParserListener ) ((ThesisParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisParserListener ) ((ThesisParserListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThesisParserVisitor ) return ((ThesisParserVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(123);
				assignment();
				}
				break;
			case 2:
				{
				setState(124);
				methodCall();
				}
				break;
			case 3:
				{
				setState(125);
				newCall();
				}
				break;
			}
			setState(128);
			match(SEMICOLON);
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
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public TerminalNode CLASS_NAME() { return getToken(ThesisParser.CLASS_NAME, 0); }
		public TerminalNode CAMEL_CASE() { return getToken(ThesisParser.CAMEL_CASE, 0); }
		public TerminalNode SEMICOLON() { return getToken(ThesisParser.SEMICOLON, 0); }
		public TerminalNode PERIOD() { return getToken(ThesisParser.PERIOD, 0); }
		public MethodCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisParserListener ) ((ThesisParserListener)listener).enterMethodCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisParserListener ) ((ThesisParserListener)listener).exitMethodCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThesisParserVisitor ) return ((ThesisParserVisitor<? extends T>)visitor).visitMethodCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodCallContext methodCall() throws RecognitionException {
		MethodCallContext _localctx = new MethodCallContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_methodCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			_la = _input.LA(1);
			if ( !(_la==CLASS_NAME || _la==CAMEL_CASE) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(131);
			_la = _input.LA(1);
			if ( !(_la==PERIOD || _la==SEMICOLON) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(132);
			call();
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
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(ThesisParser.EQUALS, 0); }
		public List<TerminalNode> CAMEL_CASE() { return getTokens(ThesisParser.CAMEL_CASE); }
		public TerminalNode CAMEL_CASE(int i) {
			return getToken(ThesisParser.CAMEL_CASE, i);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisParserListener ) ((ThesisParserListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisParserListener ) ((ThesisParserListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThesisParserVisitor ) return ((ThesisParserVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_assignment);
		try {
			setState(141);
			switch (_input.LA(1)) {
			case VAR_WITH_TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(134);
				var();
				setState(135);
				match(EQUALS);
				setState(136);
				match(CAMEL_CASE);
				}
				break;
			case CAMEL_CASE:
				enterOuterAlt(_localctx, 2);
				{
				setState(138);
				match(CAMEL_CASE);
				setState(139);
				match(EQUALS);
				setState(140);
				match(CAMEL_CASE);
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

	public static class NewCallContext extends ParserRuleContext {
		public TerminalNode NEW() { return getToken(ThesisParser.NEW, 0); }
		public TerminalNode VAR_WITH_TYPE() { return getToken(ThesisParser.VAR_WITH_TYPE, 0); }
		public TerminalNode LEFT_BRACE() { return getToken(ThesisParser.LEFT_BRACE, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(ThesisParser.RIGHT_BRACE, 0); }
		public TerminalNode CAMEL_CASE() { return getToken(ThesisParser.CAMEL_CASE, 0); }
		public TerminalNode EQUALS() { return getToken(ThesisParser.EQUALS, 0); }
		public TerminalNode CLASS_NAME() { return getToken(ThesisParser.CLASS_NAME, 0); }
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public NewCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisParserListener ) ((ThesisParserListener)listener).enterNewCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisParserListener ) ((ThesisParserListener)listener).exitNewCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThesisParserVisitor ) return ((ThesisParserVisitor<? extends T>)visitor).visitNewCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewCallContext newCall() throws RecognitionException {
		NewCallContext _localctx = new NewCallContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_newCall);
		try {
			setState(161);
			switch (_input.LA(1)) {
			case NEW:
				enterOuterAlt(_localctx, 1);
				{
				setState(143);
				match(NEW);
				setState(144);
				match(VAR_WITH_TYPE);
				setState(145);
				match(LEFT_BRACE);
				setState(146);
				arguments();
				setState(147);
				match(RIGHT_BRACE);
				setState(148);
				match(CAMEL_CASE);
				}
				break;
			case CAMEL_CASE:
			case VAR_WITH_TYPE:
				enterOuterAlt(_localctx, 2);
				{
				setState(152);
				switch (_input.LA(1)) {
				case VAR_WITH_TYPE:
					{
					setState(150);
					var();
					}
					break;
				case CAMEL_CASE:
					{
					setState(151);
					match(CAMEL_CASE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(154);
				match(EQUALS);
				setState(155);
				match(NEW);
				setState(156);
				match(CLASS_NAME);
				setState(157);
				match(LEFT_BRACE);
				setState(158);
				arguments();
				setState(159);
				match(RIGHT_BRACE);
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

	public static class ReturnCallContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(ThesisParser.SEMICOLON, 0); }
		public TerminalNode RETURN() { return getToken(ThesisParser.RETURN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode CAMEL_CASE() { return getToken(ThesisParser.CAMEL_CASE, 0); }
		public ReturnCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisParserListener ) ((ThesisParserListener)listener).enterReturnCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisParserListener ) ((ThesisParserListener)listener).exitReturnCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThesisParserVisitor ) return ((ThesisParserVisitor<? extends T>)visitor).visitReturnCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnCallContext returnCall() throws RecognitionException {
		ReturnCallContext _localctx = new ReturnCallContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_returnCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(163);
				match(RETURN);
				setState(164);
				statement();
				}
				break;
			case 2:
				{
				setState(165);
				match(RETURN);
				setState(166);
				match(CAMEL_CASE);
				}
				break;
			}
			setState(169);
			match(SEMICOLON);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\"\u00ae\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\2\3\2\3\3\3\3\3\3\5\3.\n\3\3\4\7\4\61\n\4\f\4\16"+
		"\4\64\13\4\3\4\3\4\7\48\n\4\f\4\16\4;\13\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7"+
		"\3\7\5\7E\n\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\7\tN\n\t\f\t\16\tQ\13\t\3\t"+
		"\3\t\3\t\7\tV\n\t\f\t\16\tY\13\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13"+
		"\3\f\3\f\3\f\3\r\3\r\3\r\7\rj\n\r\f\r\16\rm\13\r\3\r\3\r\5\rq\n\r\3\16"+
		"\6\16t\n\16\r\16\16\16u\3\16\7\16y\n\16\f\16\16\16|\13\16\3\17\3\17\3"+
		"\17\5\17\u0081\n\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\5\21\u0090\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\5\22\u009b\n\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00a4\n"+
		"\22\3\23\3\23\3\23\3\23\5\23\u00aa\n\23\3\23\3\23\3\23\2\2\24\2\4\6\b"+
		"\n\f\16\20\22\24\26\30\32\34\36 \"$\2\5\4\2\21\22\"\"\3\2\21\22\4\2\24"+
		"\24\27\27\u00ad\2&\3\2\2\2\4-\3\2\2\2\6\62\3\2\2\2\b<\3\2\2\2\n>\3\2\2"+
		"\2\fD\3\2\2\2\16H\3\2\2\2\20O\3\2\2\2\22\\\3\2\2\2\24a\3\2\2\2\26c\3\2"+
		"\2\2\30p\3\2\2\2\32s\3\2\2\2\34\u0080\3\2\2\2\36\u0084\3\2\2\2 \u008f"+
		"\3\2\2\2\"\u00a3\3\2\2\2$\u00a9\3\2\2\2&\'\7\3\2\2\'(\5\4\3\2()\7\2\2"+
		"\3)\3\3\2\2\2*.\5\6\4\2+.\5\b\5\2,.\5\n\6\2-*\3\2\2\2-+\3\2\2\2-,\3\2"+
		"\2\2.\5\3\2\2\2/\61\5\f\7\2\60/\3\2\2\2\61\64\3\2\2\2\62\60\3\2\2\2\62"+
		"\63\3\2\2\2\639\3\2\2\2\64\62\3\2\2\2\658\5\16\b\2\668\5\20\t\2\67\65"+
		"\3\2\2\2\67\66\3\2\2\28;\3\2\2\29\67\3\2\2\29:\3\2\2\2:\7\3\2\2\2;9\3"+
		"\2\2\2<=\7\20\2\2=\t\3\2\2\2>?\7\20\2\2?\13\3\2\2\2@A\7\13\2\2AE\7\6\2"+
		"\2BC\7\f\2\2CE\7\6\2\2D@\3\2\2\2DB\3\2\2\2EF\3\2\2\2FG\7\27\2\2G\r\3\2"+
		"\2\2HI\7\23\2\2IJ\7\22\2\2JK\7\27\2\2K\17\3\2\2\2LN\7\17\2\2ML\3\2\2\2"+
		"NQ\3\2\2\2OM\3\2\2\2OP\3\2\2\2PR\3\2\2\2QO\3\2\2\2RS\5\22\n\2SW\7 \2\2"+
		"TV\5\32\16\2UT\3\2\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2\2\2XZ\3\2\2\2YW\3\2\2"+
		"\2Z[\7!\2\2[\21\3\2\2\2\\]\5\24\13\2]^\7\36\2\2^_\5\30\r\2_`\7\37\2\2"+
		"`\23\3\2\2\2ab\t\2\2\2b\25\3\2\2\2cd\7\23\2\2de\7\22\2\2e\27\3\2\2\2f"+
		"g\5\26\f\2gh\7\25\2\2hj\3\2\2\2if\3\2\2\2jm\3\2\2\2ki\3\2\2\2kl\3\2\2"+
		"\2ln\3\2\2\2mk\3\2\2\2nq\5\26\f\2oq\3\2\2\2pk\3\2\2\2po\3\2\2\2q\31\3"+
		"\2\2\2rt\5\34\17\2sr\3\2\2\2tu\3\2\2\2us\3\2\2\2uv\3\2\2\2vz\3\2\2\2w"+
		"y\5$\23\2xw\3\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2{\33\3\2\2\2|z\3\2\2"+
		"\2}\u0081\5 \21\2~\u0081\5\36\20\2\177\u0081\5\"\22\2\u0080}\3\2\2\2\u0080"+
		"~\3\2\2\2\u0080\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0083\7\27\2\2\u0083"+
		"\35\3\2\2\2\u0084\u0085\t\3\2\2\u0085\u0086\t\4\2\2\u0086\u0087\5\22\n"+
		"\2\u0087\37\3\2\2\2\u0088\u0089\5\26\f\2\u0089\u008a\7\30\2\2\u008a\u008b"+
		"\7\22\2\2\u008b\u0090\3\2\2\2\u008c\u008d\7\22\2\2\u008d\u008e\7\30\2"+
		"\2\u008e\u0090\7\22\2\2\u008f\u0088\3\2\2\2\u008f\u008c\3\2\2\2\u0090"+
		"!\3\2\2\2\u0091\u0092\7\16\2\2\u0092\u0093\7\23\2\2\u0093\u0094\7\36\2"+
		"\2\u0094\u0095\5\30\r\2\u0095\u0096\7\37\2\2\u0096\u0097\7\22\2\2\u0097"+
		"\u00a4\3\2\2\2\u0098\u009b\5\26\f\2\u0099\u009b\7\22\2\2\u009a\u0098\3"+
		"\2\2\2\u009a\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009d\7\30\2\2\u009d"+
		"\u009e\7\16\2\2\u009e\u009f\7\21\2\2\u009f\u00a0\7\36\2\2\u00a0\u00a1"+
		"\5\30\r\2\u00a1\u00a2\7\37\2\2\u00a2\u00a4\3\2\2\2\u00a3\u0091\3\2\2\2"+
		"\u00a3\u009a\3\2\2\2\u00a4#\3\2\2\2\u00a5\u00a6\7\r\2\2\u00a6\u00aa\5"+
		"\34\17\2\u00a7\u00a8\7\r\2\2\u00a8\u00aa\7\22\2\2\u00a9\u00a5\3\2\2\2"+
		"\u00a9\u00a7\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac\7\27\2\2\u00ac%\3"+
		"\2\2\2\22-\62\679DOWkpuz\u0080\u008f\u009a\u00a3\u00a9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}