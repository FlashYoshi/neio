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
		HEADER=1, COMMENT=2, MULTILINE_COMMENT=3, CHAIN=4, WS=5, NEWLINE=6, EXTENDS=7, 
		IMPLEMENTS=8, RETURN=9, NEW=10, THIS=11, METHOD_OPTION=12, STUB=13, CLASS_NAME=14, 
		CAMEL_CASE=15, VAR_WITH_TYPE=16, PERIOD=17, COMMA=18, COLON=19, SEMICOLON=20, 
		EQUALS=21, PLUS=22, MINUS=23, STAR=24, SMALLER=25, BIGGER=26, LEFT_BRACE=27, 
		RIGHT_BRACE=28, LEFT_CURLY_BRACE=29, RIGHT_CURLY_BRACE=30, METHOD_NAME=31;
	public static final int
		RULE_document = 0, RULE_body = 1, RULE_classBody = 2, RULE_interfaceBody = 3, 
		RULE_scriptBody = 4, RULE_extension = 5, RULE_field = 6, RULE_fieldName = 7, 
		RULE_var = 8, RULE_method = 9, RULE_call = 10, RULE_methodName = 11, RULE_arguments = 12, 
		RULE_block = 13, RULE_statement = 14, RULE_methodCall = 15, RULE_assignment = 16, 
		RULE_thisChain = 17, RULE_newCall = 18, RULE_returnCall = 19;
	public static final String[] ruleNames = {
		"document", "body", "classBody", "interfaceBody", "scriptBody", "extension", 
		"field", "fieldName", "var", "method", "call", "methodName", "arguments", 
		"block", "statement", "methodCall", "assignment", "thisChain", "newCall", 
		"returnCall"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, "'extends'", "'implements'", 
		"'return'", "'new'", "'this'", null, "'stub'", null, null, null, "'.'", 
		"','", "':'", "';'", "'='", "'+'", "'-'", "'*'", "'<'", "'>'", "'('", 
		"')'", "'{'", "'}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "HEADER", "COMMENT", "MULTILINE_COMMENT", "CHAIN", "WS", "NEWLINE", 
		"EXTENDS", "IMPLEMENTS", "RETURN", "NEW", "THIS", "METHOD_OPTION", "STUB", 
		"CLASS_NAME", "CAMEL_CASE", "VAR_WITH_TYPE", "PERIOD", "COMMA", "COLON", 
		"SEMICOLON", "EQUALS", "PLUS", "MINUS", "STAR", "SMALLER", "BIGGER", "LEFT_BRACE", 
		"RIGHT_BRACE", "LEFT_CURLY_BRACE", "RIGHT_CURLY_BRACE", "METHOD_NAME"
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
			setState(40);
			match(HEADER);
			setState(41);
			body();
			setState(42);
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
			setState(47);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				classBody();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				interfaceBody();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(46);
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
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EXTENDS || _la==IMPLEMENTS) {
				{
				{
				setState(49);
				extension();
				}
				}
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << METHOD_OPTION) | (1L << CLASS_NAME) | (1L << CAMEL_CASE) | (1L << VAR_WITH_TYPE) | (1L << METHOD_NAME))) != 0)) {
				{
				setState(57);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(55);
					field();
					}
					break;
				case 2:
					{
					setState(56);
					method();
					}
					break;
				}
				}
				setState(61);
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
			setState(62);
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
			setState(64);
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
		public TerminalNode CHAIN() { return getToken(ThesisParser.CHAIN, 0); }
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
			setState(70);
			switch (_input.LA(1)) {
			case EXTENDS:
				{
				setState(66);
				match(EXTENDS);
				setState(67);
				match(CHAIN);
				}
				break;
			case IMPLEMENTS:
				{
				setState(68);
				match(IMPLEMENTS);
				setState(69);
				match(CHAIN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
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

	public static class FieldContext extends ParserRuleContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
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
			setState(74);
			var();
			setState(75);
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

	public static class FieldNameContext extends ParserRuleContext {
		public TerminalNode CLASS_NAME() { return getToken(ThesisParser.CLASS_NAME, 0); }
		public TerminalNode VAR_WITH_TYPE() { return getToken(ThesisParser.VAR_WITH_TYPE, 0); }
		public FieldNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisParserListener ) ((ThesisParserListener)listener).enterFieldName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisParserListener ) ((ThesisParserListener)listener).exitFieldName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThesisParserVisitor ) return ((ThesisParserVisitor<? extends T>)visitor).visitFieldName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldNameContext fieldName() throws RecognitionException {
		FieldNameContext _localctx = new FieldNameContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_fieldName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			_la = _input.LA(1);
			if ( !(_la==CLASS_NAME || _la==VAR_WITH_TYPE) ) {
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
		public FieldNameContext fieldName() {
			return getRuleContext(FieldNameContext.class,0);
		}
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
		enterRule(_localctx, 16, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			fieldName();
			setState(80);
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

	public static class MethodContext extends ParserRuleContext {
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public TerminalNode LEFT_CURLY_BRACE() { return getToken(ThesisParser.LEFT_CURLY_BRACE, 0); }
		public TerminalNode RIGHT_CURLY_BRACE() { return getToken(ThesisParser.RIGHT_CURLY_BRACE, 0); }
		public TerminalNode METHOD_OPTION() { return getToken(ThesisParser.METHOD_OPTION, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
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
		enterRule(_localctx, 18, RULE_method);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			_la = _input.LA(1);
			if (_la==METHOD_OPTION) {
				{
				setState(82);
				match(METHOD_OPTION);
				}
			}

			setState(85);
			call();
			setState(86);
			match(LEFT_CURLY_BRACE);
			setState(88);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CHAIN) | (1L << NEW) | (1L << THIS) | (1L << CLASS_NAME) | (1L << CAMEL_CASE) | (1L << VAR_WITH_TYPE) | (1L << METHOD_NAME))) != 0)) {
				{
				setState(87);
				block();
				}
			}

			setState(90);
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
		enterRule(_localctx, 20, RULE_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			methodName();
			setState(93);
			match(LEFT_BRACE);
			setState(94);
			arguments();
			setState(95);
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
		enterRule(_localctx, 22, RULE_methodName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
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
		enterRule(_localctx, 24, RULE_arguments);
		try {
			int _alt;
			setState(109);
			switch (_input.LA(1)) {
			case CLASS_NAME:
			case VAR_WITH_TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(104);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(99);
						var();
						setState(100);
						match(COMMA);
						}
						} 
					}
					setState(106);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				}
				setState(107);
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
		public ReturnCallContext returnCall() {
			return getRuleContext(ReturnCallContext.class,0);
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
		enterRule(_localctx, 26, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(111);
				statement();
				}
				}
				setState(114); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CHAIN) | (1L << NEW) | (1L << THIS) | (1L << CLASS_NAME) | (1L << CAMEL_CASE) | (1L << VAR_WITH_TYPE) | (1L << METHOD_NAME))) != 0) );
			setState(117);
			_la = _input.LA(1);
			if (_la==RETURN) {
				{
				setState(116);
				returnCall();
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
		enterRule(_localctx, 28, RULE_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(119);
				assignment();
				}
				break;
			case 2:
				{
				setState(120);
				methodCall();
				}
				break;
			case 3:
				{
				setState(121);
				newCall();
				}
				break;
			}
			setState(124);
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
		enterRule(_localctx, 30, RULE_methodCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(126);
				_la = _input.LA(1);
				if ( !(_la==CLASS_NAME || _la==CAMEL_CASE) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(127);
				_la = _input.LA(1);
				if ( !(_la==PERIOD || _la==SEMICOLON) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			}
			setState(130);
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
		public TerminalNode EQUALS() { return getToken(ThesisParser.EQUALS, 0); }
		public List<ThisChainContext> thisChain() {
			return getRuleContexts(ThisChainContext.class);
		}
		public ThisChainContext thisChain(int i) {
			return getRuleContext(ThisChainContext.class,i);
		}
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public List<TerminalNode> CAMEL_CASE() { return getTokens(ThesisParser.CAMEL_CASE); }
		public TerminalNode CAMEL_CASE(int i) {
			return getToken(ThesisParser.CAMEL_CASE, i);
		}
		public MethodCallContext methodCall() {
			return getRuleContext(MethodCallContext.class,0);
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
		enterRule(_localctx, 32, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			switch (_input.LA(1)) {
			case CHAIN:
			case THIS:
				{
				setState(132);
				thisChain();
				}
				break;
			case CLASS_NAME:
			case VAR_WITH_TYPE:
				{
				setState(133);
				var();
				}
				break;
			case CAMEL_CASE:
				{
				setState(134);
				match(CAMEL_CASE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(137);
			match(EQUALS);
			setState(141);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(138);
				match(CAMEL_CASE);
				}
				break;
			case 2:
				{
				setState(139);
				thisChain();
				}
				break;
			case 3:
				{
				setState(140);
				methodCall();
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

	public static class ThisChainContext extends ParserRuleContext {
		public TerminalNode CHAIN() { return getToken(ThesisParser.CHAIN, 0); }
		public TerminalNode THIS() { return getToken(ThesisParser.THIS, 0); }
		public TerminalNode PERIOD() { return getToken(ThesisParser.PERIOD, 0); }
		public ThisChainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_thisChain; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisParserListener ) ((ThesisParserListener)listener).enterThisChain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThesisParserListener ) ((ThesisParserListener)listener).exitThisChain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThesisParserVisitor ) return ((ThesisParserVisitor<? extends T>)visitor).visitThisChain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ThisChainContext thisChain() throws RecognitionException {
		ThisChainContext _localctx = new ThisChainContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_thisChain);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			_la = _input.LA(1);
			if (_la==THIS) {
				{
				setState(143);
				match(THIS);
				setState(144);
				match(PERIOD);
				}
			}

			setState(147);
			match(CHAIN);
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
		enterRule(_localctx, 36, RULE_newCall);
		try {
			setState(167);
			switch (_input.LA(1)) {
			case NEW:
				enterOuterAlt(_localctx, 1);
				{
				setState(149);
				match(NEW);
				setState(150);
				match(VAR_WITH_TYPE);
				setState(151);
				match(LEFT_BRACE);
				setState(152);
				arguments();
				setState(153);
				match(RIGHT_BRACE);
				setState(154);
				match(CAMEL_CASE);
				}
				break;
			case CLASS_NAME:
			case CAMEL_CASE:
			case VAR_WITH_TYPE:
				enterOuterAlt(_localctx, 2);
				{
				setState(158);
				switch (_input.LA(1)) {
				case CLASS_NAME:
				case VAR_WITH_TYPE:
					{
					setState(156);
					var();
					}
					break;
				case CAMEL_CASE:
					{
					setState(157);
					match(CAMEL_CASE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(160);
				match(EQUALS);
				setState(161);
				match(NEW);
				setState(162);
				match(CLASS_NAME);
				setState(163);
				match(LEFT_BRACE);
				setState(164);
				arguments();
				setState(165);
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
		enterRule(_localctx, 38, RULE_returnCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(169);
				match(RETURN);
				setState(170);
				statement();
				}
				break;
			case 2:
				{
				setState(171);
				match(RETURN);
				setState(172);
				match(CAMEL_CASE);
				}
				break;
			}
			setState(175);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3!\u00b4\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\2\3\2\3\3\3\3\3\3\5\3\62\n\3"+
		"\3\4\7\4\65\n\4\f\4\16\48\13\4\3\4\3\4\7\4<\n\4\f\4\16\4?\13\4\3\5\3\5"+
		"\3\6\3\6\3\7\3\7\3\7\3\7\5\7I\n\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\n\3\n"+
		"\3\n\3\13\5\13V\n\13\3\13\3\13\3\13\5\13[\n\13\3\13\3\13\3\f\3\f\3\f\3"+
		"\f\3\f\3\r\3\r\3\16\3\16\3\16\7\16i\n\16\f\16\16\16l\13\16\3\16\3\16\5"+
		"\16p\n\16\3\17\6\17s\n\17\r\17\16\17t\3\17\5\17x\n\17\3\20\3\20\3\20\5"+
		"\20}\n\20\3\20\3\20\3\21\3\21\5\21\u0083\n\21\3\21\3\21\3\22\3\22\3\22"+
		"\5\22\u008a\n\22\3\22\3\22\3\22\3\22\5\22\u0090\n\22\3\23\3\23\5\23\u0094"+
		"\n\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00a1"+
		"\n\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00aa\n\24\3\25\3\25\3\25"+
		"\3\25\5\25\u00b0\n\25\3\25\3\25\3\25\2\2\26\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \"$&(\2\6\4\2\20\20\22\22\4\2\20\21!!\3\2\20\21\4\2\23\23"+
		"\26\26\u00b6\2*\3\2\2\2\4\61\3\2\2\2\6\66\3\2\2\2\b@\3\2\2\2\nB\3\2\2"+
		"\2\fH\3\2\2\2\16L\3\2\2\2\20O\3\2\2\2\22Q\3\2\2\2\24U\3\2\2\2\26^\3\2"+
		"\2\2\30c\3\2\2\2\32o\3\2\2\2\34r\3\2\2\2\36|\3\2\2\2 \u0082\3\2\2\2\""+
		"\u0089\3\2\2\2$\u0093\3\2\2\2&\u00a9\3\2\2\2(\u00af\3\2\2\2*+\7\3\2\2"+
		"+,\5\4\3\2,-\7\2\2\3-\3\3\2\2\2.\62\5\6\4\2/\62\5\b\5\2\60\62\5\n\6\2"+
		"\61.\3\2\2\2\61/\3\2\2\2\61\60\3\2\2\2\62\5\3\2\2\2\63\65\5\f\7\2\64\63"+
		"\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\67=\3\2\2\28\66\3\2\2"+
		"\29<\5\16\b\2:<\5\24\13\2;9\3\2\2\2;:\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3"+
		"\2\2\2>\7\3\2\2\2?=\3\2\2\2@A\7\17\2\2A\t\3\2\2\2BC\7\17\2\2C\13\3\2\2"+
		"\2DE\7\t\2\2EI\7\6\2\2FG\7\n\2\2GI\7\6\2\2HD\3\2\2\2HF\3\2\2\2IJ\3\2\2"+
		"\2JK\7\26\2\2K\r\3\2\2\2LM\5\22\n\2MN\7\26\2\2N\17\3\2\2\2OP\t\2\2\2P"+
		"\21\3\2\2\2QR\5\20\t\2RS\7\21\2\2S\23\3\2\2\2TV\7\16\2\2UT\3\2\2\2UV\3"+
		"\2\2\2VW\3\2\2\2WX\5\26\f\2XZ\7\37\2\2Y[\5\34\17\2ZY\3\2\2\2Z[\3\2\2\2"+
		"[\\\3\2\2\2\\]\7 \2\2]\25\3\2\2\2^_\5\30\r\2_`\7\35\2\2`a\5\32\16\2ab"+
		"\7\36\2\2b\27\3\2\2\2cd\t\3\2\2d\31\3\2\2\2ef\5\22\n\2fg\7\24\2\2gi\3"+
		"\2\2\2he\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2km\3\2\2\2lj\3\2\2\2mp\5"+
		"\22\n\2np\3\2\2\2oj\3\2\2\2on\3\2\2\2p\33\3\2\2\2qs\5\36\20\2rq\3\2\2"+
		"\2st\3\2\2\2tr\3\2\2\2tu\3\2\2\2uw\3\2\2\2vx\5(\25\2wv\3\2\2\2wx\3\2\2"+
		"\2x\35\3\2\2\2y}\5\"\22\2z}\5 \21\2{}\5&\24\2|y\3\2\2\2|z\3\2\2\2|{\3"+
		"\2\2\2}~\3\2\2\2~\177\7\26\2\2\177\37\3\2\2\2\u0080\u0081\t\4\2\2\u0081"+
		"\u0083\t\5\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0084\3\2"+
		"\2\2\u0084\u0085\5\26\f\2\u0085!\3\2\2\2\u0086\u008a\5$\23\2\u0087\u008a"+
		"\5\22\n\2\u0088\u008a\7\21\2\2\u0089\u0086\3\2\2\2\u0089\u0087\3\2\2\2"+
		"\u0089\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008f\7\27\2\2\u008c\u0090"+
		"\7\21\2\2\u008d\u0090\5$\23\2\u008e\u0090\5 \21\2\u008f\u008c\3\2\2\2"+
		"\u008f\u008d\3\2\2\2\u008f\u008e\3\2\2\2\u0090#\3\2\2\2\u0091\u0092\7"+
		"\r\2\2\u0092\u0094\7\23\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094"+
		"\u0095\3\2\2\2\u0095\u0096\7\6\2\2\u0096%\3\2\2\2\u0097\u0098\7\f\2\2"+
		"\u0098\u0099\7\22\2\2\u0099\u009a\7\35\2\2\u009a\u009b\5\32\16\2\u009b"+
		"\u009c\7\36\2\2\u009c\u009d\7\21\2\2\u009d\u00aa\3\2\2\2\u009e\u00a1\5"+
		"\22\n\2\u009f\u00a1\7\21\2\2\u00a0\u009e\3\2\2\2\u00a0\u009f\3\2\2\2\u00a1"+
		"\u00a2\3\2\2\2\u00a2\u00a3\7\27\2\2\u00a3\u00a4\7\f\2\2\u00a4\u00a5\7"+
		"\20\2\2\u00a5\u00a6\7\35\2\2\u00a6\u00a7\5\32\16\2\u00a7\u00a8\7\36\2"+
		"\2\u00a8\u00aa\3\2\2\2\u00a9\u0097\3\2\2\2\u00a9\u00a0\3\2\2\2\u00aa\'"+
		"\3\2\2\2\u00ab\u00ac\7\13\2\2\u00ac\u00b0\5\36\20\2\u00ad\u00ae\7\13\2"+
		"\2\u00ae\u00b0\7\21\2\2\u00af\u00ab\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0"+
		"\u00b1\3\2\2\2\u00b1\u00b2\7\26\2\2\u00b2)\3\2\2\2\25\61\66;=HUZjotw|"+
		"\u0082\u0089\u008f\u0093\u00a0\u00a9\u00af";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}