// Generated from ClassParser.g4 by ANTLR 4.5.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ClassParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		HEADER=1, COMMENT=2, MULTILINE_COMMENT=3, WS=4, NEWLINE=5, EXTENDS=6, 
		IMPLEMENTS=7, CLASS=8, INTERFACE=9, RETURN=10, NEW=11, THIS=12, METHOD_OPTION=13, 
		STUB=14, CLASS_NAME=15, CAMEL_CASE=16, VAR_WITH_TYPE=17, PERIOD=18, COMMA=19, 
		COLON=20, SEMICOLON=21, EQUALS=22, PLUS=23, MINUS=24, STAR=25, SMALLER=26, 
		BIGGER=27, L_BRACE=28, R_BRACE=29, L_CURLY_BRACE=30, R_CURLY_BRACE=31, 
		METHOD_NAME=32;
	public static final int
		RULE_document = 0, RULE_body = 1, RULE_classBody = 2, RULE_interfaceBody = 3, 
		RULE_extension = 4, RULE_field = 5, RULE_fieldName = 6, RULE_var = 7, 
		RULE_arguments = 8, RULE_parameter = 9, RULE_parameters = 10, RULE_method = 11, 
		RULE_decl = 12, RULE_call = 13, RULE_methodName = 14, RULE_block = 15, 
		RULE_statement = 16, RULE_methodCall = 17, RULE_assignment = 18, RULE_thisChain = 19, 
		RULE_chain = 20, RULE_newCall = 21, RULE_returnCall = 22;
	public static final String[] ruleNames = {
		"document", "body", "classBody", "interfaceBody", "extension", "field", 
		"fieldName", "var", "arguments", "parameter", "parameters", "method", 
		"decl", "call", "methodName", "block", "statement", "methodCall", "assignment", 
		"thisChain", "chain", "newCall", "returnCall"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, "'extends'", "'implements'", "'class'", 
		"'interface'", "'return'", "'new'", "'this'", null, "'stub'", null, null, 
		null, "'.'", "','", "':'", "';'", "'='", "'+'", "'-'", "'*'", "'<'", "'>'", 
		"'('", "')'", "'{'", "'}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "HEADER", "COMMENT", "MULTILINE_COMMENT", "WS", "NEWLINE", "EXTENDS", 
		"IMPLEMENTS", "CLASS", "INTERFACE", "RETURN", "NEW", "THIS", "METHOD_OPTION", 
		"STUB", "CLASS_NAME", "CAMEL_CASE", "VAR_WITH_TYPE", "PERIOD", "COMMA", 
		"COLON", "SEMICOLON", "EQUALS", "PLUS", "MINUS", "STAR", "SMALLER", "BIGGER", 
		"L_BRACE", "R_BRACE", "L_CURLY_BRACE", "R_CURLY_BRACE", "METHOD_NAME"
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
	public String getGrammarFileName() { return "ClassParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ClassParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class DocumentContext extends ParserRuleContext {
		public TerminalNode HEADER() { return getToken(ClassParser.HEADER, 0); }
		public TerminalNode CLASS_NAME() { return getToken(ClassParser.CLASS_NAME, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ClassParser.EOF, 0); }
		public DocumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_document; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterDocument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitDocument(this);
		}
	}

	public final DocumentContext document() throws RecognitionException {
		DocumentContext _localctx = new DocumentContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_document);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(HEADER);
			setState(47);
			match(CLASS_NAME);
			setState(48);
			body();
			setState(49);
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
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitBody(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_body);
		try {
			setState(53);
			switch (_input.LA(1)) {
			case EOF:
			case EXTENDS:
			case IMPLEMENTS:
			case METHOD_OPTION:
			case CLASS_NAME:
			case CAMEL_CASE:
			case VAR_WITH_TYPE:
			case METHOD_NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(51);
				classBody();
				}
				break;
			case STUB:
				enterOuterAlt(_localctx, 2);
				{
				setState(52);
				interfaceBody();
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
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterClassBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitClassBody(this);
		}
	}

	public final ClassBodyContext classBody() throws RecognitionException {
		ClassBodyContext _localctx = new ClassBodyContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_classBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EXTENDS || _la==IMPLEMENTS) {
				{
				{
				setState(55);
				extension();
				}
				}
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << METHOD_OPTION) | (1L << CLASS_NAME) | (1L << CAMEL_CASE) | (1L << VAR_WITH_TYPE) | (1L << METHOD_NAME))) != 0)) {
				{
				setState(63);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(61);
					field();
					}
					break;
				case 2:
					{
					setState(62);
					method();
					}
					break;
				}
				}
				setState(67);
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
		public TerminalNode STUB() { return getToken(ClassParser.STUB, 0); }
		public InterfaceBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterInterfaceBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitInterfaceBody(this);
		}
	}

	public final InterfaceBodyContext interfaceBody() throws RecognitionException {
		InterfaceBodyContext _localctx = new InterfaceBodyContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_interfaceBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
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
		public TerminalNode SEMICOLON() { return getToken(ClassParser.SEMICOLON, 0); }
		public TerminalNode EXTENDS() { return getToken(ClassParser.EXTENDS, 0); }
		public ChainContext chain() {
			return getRuleContext(ChainContext.class,0);
		}
		public TerminalNode IMPLEMENTS() { return getToken(ClassParser.IMPLEMENTS, 0); }
		public ExtensionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extension; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterExtension(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitExtension(this);
		}
	}

	public final ExtensionContext extension() throws RecognitionException {
		ExtensionContext _localctx = new ExtensionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_extension);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			switch (_input.LA(1)) {
			case EXTENDS:
				{
				setState(70);
				match(EXTENDS);
				setState(71);
				chain();
				}
				break;
			case IMPLEMENTS:
				{
				setState(72);
				match(IMPLEMENTS);
				setState(73);
				chain();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(76);
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
		public TerminalNode SEMICOLON() { return getToken(ClassParser.SEMICOLON, 0); }
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitField(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_field);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			var();
			setState(79);
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
		public TerminalNode CLASS_NAME() { return getToken(ClassParser.CLASS_NAME, 0); }
		public TerminalNode VAR_WITH_TYPE() { return getToken(ClassParser.VAR_WITH_TYPE, 0); }
		public FieldNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterFieldName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitFieldName(this);
		}
	}

	public final FieldNameContext fieldName() throws RecognitionException {
		FieldNameContext _localctx = new FieldNameContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_fieldName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
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
		public TerminalNode CAMEL_CASE() { return getToken(ClassParser.CAMEL_CASE, 0); }
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitVar(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			fieldName();
			setState(84);
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
		public List<TerminalNode> COMMA() { return getTokens(ClassParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ClassParser.COMMA, i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitArguments(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_arguments);
		try {
			int _alt;
			setState(96);
			switch (_input.LA(1)) {
			case CLASS_NAME:
			case VAR_WITH_TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(91);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(86);
						var();
						setState(87);
						match(COMMA);
						}
						} 
					}
					setState(93);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				}
				setState(94);
				var();
				}
				break;
			case R_BRACE:
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
		public TerminalNode CAMEL_CASE() { return getToken(ClassParser.CAMEL_CASE, 0); }
		public MethodCallContext methodCall() {
			return getRuleContext(MethodCallContext.class,0);
		}
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitParameter(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_parameter);
		try {
			setState(100);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(98);
				match(CAMEL_CASE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(99);
				methodCall();
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
		public List<TerminalNode> COMMA() { return getTokens(ClassParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ClassParser.COMMA, i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitParameters(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_parameters);
		try {
			int _alt;
			setState(112);
			switch (_input.LA(1)) {
			case CLASS_NAME:
			case CAMEL_CASE:
			case METHOD_NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(107);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(102);
						parameter();
						setState(103);
						match(COMMA);
						}
						} 
					}
					setState(109);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
				}
				setState(110);
				parameter();
				}
				break;
			case R_BRACE:
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

	public static class MethodContext extends ParserRuleContext {
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public TerminalNode L_CURLY_BRACE() { return getToken(ClassParser.L_CURLY_BRACE, 0); }
		public TerminalNode R_CURLY_BRACE() { return getToken(ClassParser.R_CURLY_BRACE, 0); }
		public TerminalNode METHOD_OPTION() { return getToken(ClassParser.METHOD_OPTION, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public MethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitMethod(this);
		}
	}

	public final MethodContext method() throws RecognitionException {
		MethodContext _localctx = new MethodContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_method);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			_la = _input.LA(1);
			if (_la==METHOD_OPTION) {
				{
				setState(114);
				match(METHOD_OPTION);
				}
			}

			setState(117);
			decl();
			setState(118);
			match(L_CURLY_BRACE);
			setState(120);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << THIS) | (1L << CLASS_NAME) | (1L << CAMEL_CASE) | (1L << VAR_WITH_TYPE) | (1L << METHOD_NAME))) != 0)) {
				{
				setState(119);
				block();
				}
			}

			setState(122);
			match(R_CURLY_BRACE);
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

	public static class DeclContext extends ParserRuleContext {
		public MethodNameContext methodName() {
			return getRuleContext(MethodNameContext.class,0);
		}
		public TerminalNode L_BRACE() { return getToken(ClassParser.L_BRACE, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public TerminalNode R_BRACE() { return getToken(ClassParser.R_BRACE, 0); }
		public TerminalNode CLASS_NAME() { return getToken(ClassParser.CLASS_NAME, 0); }
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitDecl(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(124);
				match(CLASS_NAME);
				}
				break;
			}
			setState(127);
			methodName();
			setState(128);
			match(L_BRACE);
			setState(129);
			arguments();
			setState(130);
			match(R_BRACE);
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
		public TerminalNode L_BRACE() { return getToken(ClassParser.L_BRACE, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public TerminalNode R_BRACE() { return getToken(ClassParser.R_BRACE, 0); }
		public CallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitCall(this);
		}
	}

	public final CallContext call() throws RecognitionException {
		CallContext _localctx = new CallContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			methodName();
			setState(133);
			match(L_BRACE);
			setState(134);
			parameters();
			setState(135);
			match(R_BRACE);
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
		public TerminalNode CLASS_NAME() { return getToken(ClassParser.CLASS_NAME, 0); }
		public TerminalNode CAMEL_CASE() { return getToken(ClassParser.CAMEL_CASE, 0); }
		public TerminalNode METHOD_NAME() { return getToken(ClassParser.METHOD_NAME, 0); }
		public MethodNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterMethodName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitMethodName(this);
		}
	}

	public final MethodNameContext methodName() throws RecognitionException {
		MethodNameContext _localctx = new MethodNameContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_methodName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
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
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(139);
				statement();
				}
				}
				setState(142); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << THIS) | (1L << CLASS_NAME) | (1L << CAMEL_CASE) | (1L << VAR_WITH_TYPE) | (1L << METHOD_NAME))) != 0) );
			setState(145);
			_la = _input.LA(1);
			if (_la==RETURN) {
				{
				setState(144);
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
		public TerminalNode SEMICOLON() { return getToken(ClassParser.SEMICOLON, 0); }
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
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(147);
				assignment();
				}
				break;
			case 2:
				{
				setState(148);
				methodCall();
				}
				break;
			case 3:
				{
				setState(149);
				newCall();
				}
				break;
			}
			setState(152);
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
		public TerminalNode CLASS_NAME() { return getToken(ClassParser.CLASS_NAME, 0); }
		public TerminalNode CAMEL_CASE() { return getToken(ClassParser.CAMEL_CASE, 0); }
		public TerminalNode SEMICOLON() { return getToken(ClassParser.SEMICOLON, 0); }
		public TerminalNode PERIOD() { return getToken(ClassParser.PERIOD, 0); }
		public MethodCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterMethodCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitMethodCall(this);
		}
	}

	public final MethodCallContext methodCall() throws RecognitionException {
		MethodCallContext _localctx = new MethodCallContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_methodCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(154);
				_la = _input.LA(1);
				if ( !(_la==CLASS_NAME || _la==CAMEL_CASE) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(155);
				_la = _input.LA(1);
				if ( !(_la==PERIOD || _la==SEMICOLON) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			}
			setState(158);
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
		public TerminalNode EQUALS() { return getToken(ClassParser.EQUALS, 0); }
		public List<ThisChainContext> thisChain() {
			return getRuleContexts(ThisChainContext.class);
		}
		public ThisChainContext thisChain(int i) {
			return getRuleContext(ThisChainContext.class,i);
		}
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public List<TerminalNode> CAMEL_CASE() { return getTokens(ClassParser.CAMEL_CASE); }
		public TerminalNode CAMEL_CASE(int i) {
			return getToken(ClassParser.CAMEL_CASE, i);
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
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitAssignment(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(160);
				thisChain();
				}
				break;
			case 2:
				{
				setState(161);
				var();
				}
				break;
			case 3:
				{
				setState(162);
				match(CAMEL_CASE);
				}
				break;
			}
			setState(165);
			match(EQUALS);
			setState(169);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(166);
				match(CAMEL_CASE);
				}
				break;
			case 2:
				{
				setState(167);
				thisChain();
				}
				break;
			case 3:
				{
				setState(168);
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
		public ChainContext chain() {
			return getRuleContext(ChainContext.class,0);
		}
		public TerminalNode THIS() { return getToken(ClassParser.THIS, 0); }
		public TerminalNode PERIOD() { return getToken(ClassParser.PERIOD, 0); }
		public TerminalNode CLASS_NAME() { return getToken(ClassParser.CLASS_NAME, 0); }
		public TerminalNode CAMEL_CASE() { return getToken(ClassParser.CAMEL_CASE, 0); }
		public ThisChainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_thisChain; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterThisChain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitThisChain(this);
		}
	}

	public final ThisChainContext thisChain() throws RecognitionException {
		ThisChainContext _localctx = new ThisChainContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_thisChain);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			_la = _input.LA(1);
			if (_la==THIS) {
				{
				setState(171);
				match(THIS);
				setState(172);
				match(PERIOD);
				}
			}

			setState(177);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(175);
				chain();
				}
				break;
			case 2:
				{
				setState(176);
				_la = _input.LA(1);
				if ( !(_la==CLASS_NAME || _la==CAMEL_CASE) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
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

	public static class ChainContext extends ParserRuleContext {
		public List<TerminalNode> CLASS_NAME() { return getTokens(ClassParser.CLASS_NAME); }
		public TerminalNode CLASS_NAME(int i) {
			return getToken(ClassParser.CLASS_NAME, i);
		}
		public List<TerminalNode> CAMEL_CASE() { return getTokens(ClassParser.CAMEL_CASE); }
		public TerminalNode CAMEL_CASE(int i) {
			return getToken(ClassParser.CAMEL_CASE, i);
		}
		public List<TerminalNode> PERIOD() { return getTokens(ClassParser.PERIOD); }
		public TerminalNode PERIOD(int i) {
			return getToken(ClassParser.PERIOD, i);
		}
		public ChainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chain; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterChain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitChain(this);
		}
	}

	public final ChainContext chain() throws RecognitionException {
		ChainContext _localctx = new ChainContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_chain);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			_la = _input.LA(1);
			if ( !(_la==CLASS_NAME || _la==CAMEL_CASE) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(182); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(180);
				match(PERIOD);
				setState(181);
				_la = _input.LA(1);
				if ( !(_la==CLASS_NAME || _la==CAMEL_CASE) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				}
				setState(184); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==PERIOD );
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
		public TerminalNode NEW() { return getToken(ClassParser.NEW, 0); }
		public TerminalNode L_BRACE() { return getToken(ClassParser.L_BRACE, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public TerminalNode R_BRACE() { return getToken(ClassParser.R_BRACE, 0); }
		public TerminalNode CAMEL_CASE() { return getToken(ClassParser.CAMEL_CASE, 0); }
		public TerminalNode CLASS_NAME() { return getToken(ClassParser.CLASS_NAME, 0); }
		public TerminalNode VAR_WITH_TYPE() { return getToken(ClassParser.VAR_WITH_TYPE, 0); }
		public TerminalNode EQUALS() { return getToken(ClassParser.EQUALS, 0); }
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public NewCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterNewCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitNewCall(this);
		}
	}

	public final NewCallContext newCall() throws RecognitionException {
		NewCallContext _localctx = new NewCallContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_newCall);
		int _la;
		try {
			setState(204);
			switch (_input.LA(1)) {
			case NEW:
				enterOuterAlt(_localctx, 1);
				{
				setState(186);
				match(NEW);
				setState(187);
				_la = _input.LA(1);
				if ( !(_la==CLASS_NAME || _la==VAR_WITH_TYPE) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(188);
				match(L_BRACE);
				setState(189);
				parameters();
				setState(190);
				match(R_BRACE);
				setState(191);
				match(CAMEL_CASE);
				}
				break;
			case CLASS_NAME:
			case CAMEL_CASE:
			case VAR_WITH_TYPE:
				enterOuterAlt(_localctx, 2);
				{
				setState(195);
				switch (_input.LA(1)) {
				case CLASS_NAME:
				case VAR_WITH_TYPE:
					{
					setState(193);
					var();
					}
					break;
				case CAMEL_CASE:
					{
					setState(194);
					match(CAMEL_CASE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(197);
				match(EQUALS);
				setState(198);
				match(NEW);
				setState(199);
				match(CLASS_NAME);
				setState(200);
				match(L_BRACE);
				setState(201);
				parameters();
				setState(202);
				match(R_BRACE);
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
		public TerminalNode SEMICOLON() { return getToken(ClassParser.SEMICOLON, 0); }
		public TerminalNode RETURN() { return getToken(ClassParser.RETURN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode CAMEL_CASE() { return getToken(ClassParser.CAMEL_CASE, 0); }
		public MethodCallContext methodCall() {
			return getRuleContext(MethodCallContext.class,0);
		}
		public ReturnCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterReturnCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitReturnCall(this);
		}
	}

	public final ReturnCallContext returnCall() throws RecognitionException {
		ReturnCallContext _localctx = new ReturnCallContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_returnCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(206);
				match(RETURN);
				setState(207);
				statement();
				}
				break;
			case 2:
				{
				setState(208);
				match(RETURN);
				setState(209);
				match(CAMEL_CASE);
				}
				break;
			case 3:
				{
				setState(210);
				match(RETURN);
				setState(211);
				methodCall();
				}
				break;
			}
			setState(214);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\"\u00db\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\3\2\3"+
		"\2\3\2\3\2\3\3\3\3\5\38\n\3\3\4\7\4;\n\4\f\4\16\4>\13\4\3\4\3\4\7\4B\n"+
		"\4\f\4\16\4E\13\4\3\5\3\5\3\6\3\6\3\6\3\6\5\6M\n\6\3\6\3\6\3\7\3\7\3\7"+
		"\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\7\n\\\n\n\f\n\16\n_\13\n\3\n\3\n\5\n"+
		"c\n\n\3\13\3\13\5\13g\n\13\3\f\3\f\3\f\7\fl\n\f\f\f\16\fo\13\f\3\f\3\f"+
		"\5\fs\n\f\3\r\5\rv\n\r\3\r\3\r\3\r\5\r{\n\r\3\r\3\r\3\16\5\16\u0080\n"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\21\6"+
		"\21\u008f\n\21\r\21\16\21\u0090\3\21\5\21\u0094\n\21\3\22\3\22\3\22\5"+
		"\22\u0099\n\22\3\22\3\22\3\23\3\23\5\23\u009f\n\23\3\23\3\23\3\24\3\24"+
		"\3\24\5\24\u00a6\n\24\3\24\3\24\3\24\3\24\5\24\u00ac\n\24\3\25\3\25\5"+
		"\25\u00b0\n\25\3\25\3\25\5\25\u00b4\n\25\3\26\3\26\3\26\6\26\u00b9\n\26"+
		"\r\26\16\26\u00ba\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u00c6"+
		"\n\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u00cf\n\27\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\5\30\u00d7\n\30\3\30\3\30\3\30\2\2\31\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\34\36 \"$&(*,.\2\6\4\2\21\21\23\23\4\2\21\22\"\"\3\2\21"+
		"\22\4\2\24\24\27\27\u00e0\2\60\3\2\2\2\4\67\3\2\2\2\6<\3\2\2\2\bF\3\2"+
		"\2\2\nL\3\2\2\2\fP\3\2\2\2\16S\3\2\2\2\20U\3\2\2\2\22b\3\2\2\2\24f\3\2"+
		"\2\2\26r\3\2\2\2\30u\3\2\2\2\32\177\3\2\2\2\34\u0086\3\2\2\2\36\u008b"+
		"\3\2\2\2 \u008e\3\2\2\2\"\u0098\3\2\2\2$\u009e\3\2\2\2&\u00a5\3\2\2\2"+
		"(\u00af\3\2\2\2*\u00b5\3\2\2\2,\u00ce\3\2\2\2.\u00d6\3\2\2\2\60\61\7\3"+
		"\2\2\61\62\7\21\2\2\62\63\5\4\3\2\63\64\7\2\2\3\64\3\3\2\2\2\658\5\6\4"+
		"\2\668\5\b\5\2\67\65\3\2\2\2\67\66\3\2\2\28\5\3\2\2\29;\5\n\6\2:9\3\2"+
		"\2\2;>\3\2\2\2<:\3\2\2\2<=\3\2\2\2=C\3\2\2\2><\3\2\2\2?B\5\f\7\2@B\5\30"+
		"\r\2A?\3\2\2\2A@\3\2\2\2BE\3\2\2\2CA\3\2\2\2CD\3\2\2\2D\7\3\2\2\2EC\3"+
		"\2\2\2FG\7\20\2\2G\t\3\2\2\2HI\7\b\2\2IM\5*\26\2JK\7\t\2\2KM\5*\26\2L"+
		"H\3\2\2\2LJ\3\2\2\2MN\3\2\2\2NO\7\27\2\2O\13\3\2\2\2PQ\5\20\t\2QR\7\27"+
		"\2\2R\r\3\2\2\2ST\t\2\2\2T\17\3\2\2\2UV\5\16\b\2VW\7\22\2\2W\21\3\2\2"+
		"\2XY\5\20\t\2YZ\7\25\2\2Z\\\3\2\2\2[X\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3"+
		"\2\2\2^`\3\2\2\2_]\3\2\2\2`c\5\20\t\2ac\3\2\2\2b]\3\2\2\2ba\3\2\2\2c\23"+
		"\3\2\2\2dg\7\22\2\2eg\5$\23\2fd\3\2\2\2fe\3\2\2\2g\25\3\2\2\2hi\5\24\13"+
		"\2ij\7\25\2\2jl\3\2\2\2kh\3\2\2\2lo\3\2\2\2mk\3\2\2\2mn\3\2\2\2np\3\2"+
		"\2\2om\3\2\2\2ps\5\24\13\2qs\3\2\2\2rm\3\2\2\2rq\3\2\2\2s\27\3\2\2\2t"+
		"v\7\17\2\2ut\3\2\2\2uv\3\2\2\2vw\3\2\2\2wx\5\32\16\2xz\7 \2\2y{\5 \21"+
		"\2zy\3\2\2\2z{\3\2\2\2{|\3\2\2\2|}\7!\2\2}\31\3\2\2\2~\u0080\7\21\2\2"+
		"\177~\3\2\2\2\177\u0080\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0082\5\36\20"+
		"\2\u0082\u0083\7\36\2\2\u0083\u0084\5\22\n\2\u0084\u0085\7\37\2\2\u0085"+
		"\33\3\2\2\2\u0086\u0087\5\36\20\2\u0087\u0088\7\36\2\2\u0088\u0089\5\26"+
		"\f\2\u0089\u008a\7\37\2\2\u008a\35\3\2\2\2\u008b\u008c\t\3\2\2\u008c\37"+
		"\3\2\2\2\u008d\u008f\5\"\22\2\u008e\u008d\3\2\2\2\u008f\u0090\3\2\2\2"+
		"\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0093\3\2\2\2\u0092\u0094"+
		"\5.\30\2\u0093\u0092\3\2\2\2\u0093\u0094\3\2\2\2\u0094!\3\2\2\2\u0095"+
		"\u0099\5&\24\2\u0096\u0099\5$\23\2\u0097\u0099\5,\27\2\u0098\u0095\3\2"+
		"\2\2\u0098\u0096\3\2\2\2\u0098\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a"+
		"\u009b\7\27\2\2\u009b#\3\2\2\2\u009c\u009d\t\4\2\2\u009d\u009f\t\5\2\2"+
		"\u009e\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1"+
		"\5\34\17\2\u00a1%\3\2\2\2\u00a2\u00a6\5(\25\2\u00a3\u00a6\5\20\t\2\u00a4"+
		"\u00a6\7\22\2\2\u00a5\u00a2\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a4\3"+
		"\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00ab\7\30\2\2\u00a8\u00ac\7\22\2\2\u00a9"+
		"\u00ac\5(\25\2\u00aa\u00ac\5$\23\2\u00ab\u00a8\3\2\2\2\u00ab\u00a9\3\2"+
		"\2\2\u00ab\u00aa\3\2\2\2\u00ac\'\3\2\2\2\u00ad\u00ae\7\16\2\2\u00ae\u00b0"+
		"\7\24\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b3\3\2\2\2"+
		"\u00b1\u00b4\5*\26\2\u00b2\u00b4\t\4\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b2"+
		"\3\2\2\2\u00b4)\3\2\2\2\u00b5\u00b8\t\4\2\2\u00b6\u00b7\7\24\2\2\u00b7"+
		"\u00b9\t\4\2\2\u00b8\u00b6\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00b8\3\2"+
		"\2\2\u00ba\u00bb\3\2\2\2\u00bb+\3\2\2\2\u00bc\u00bd\7\r\2\2\u00bd\u00be"+
		"\t\2\2\2\u00be\u00bf\7\36\2\2\u00bf\u00c0\5\26\f\2\u00c0\u00c1\7\37\2"+
		"\2\u00c1\u00c2\7\22\2\2\u00c2\u00cf\3\2\2\2\u00c3\u00c6\5\20\t\2\u00c4"+
		"\u00c6\7\22\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c4\3\2\2\2\u00c6\u00c7\3"+
		"\2\2\2\u00c7\u00c8\7\30\2\2\u00c8\u00c9\7\r\2\2\u00c9\u00ca\7\21\2\2\u00ca"+
		"\u00cb\7\36\2\2\u00cb\u00cc\5\26\f\2\u00cc\u00cd\7\37\2\2\u00cd\u00cf"+
		"\3\2\2\2\u00ce\u00bc\3\2\2\2\u00ce\u00c5\3\2\2\2\u00cf-\3\2\2\2\u00d0"+
		"\u00d1\7\f\2\2\u00d1\u00d7\5\"\22\2\u00d2\u00d3\7\f\2\2\u00d3\u00d7\7"+
		"\22\2\2\u00d4\u00d5\7\f\2\2\u00d5\u00d7\5$\23\2\u00d6\u00d0\3\2\2\2\u00d6"+
		"\u00d2\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d9\7\27"+
		"\2\2\u00d9/\3\2\2\2\33\67<ACL]bfmruz\177\u0090\u0093\u0098\u009e\u00a5"+
		"\u00ab\u00af\u00b3\u00ba\u00c5\u00ce\u00d6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}