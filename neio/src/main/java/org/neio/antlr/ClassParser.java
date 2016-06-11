// Generated from B:\Documents\GitHub\neio\neio\src\main\grammar\ClassParser.g4 by ANTLR 4.5
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
public class ClassParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMENT=1, MULTILINE_COMMENT=2, WS=3, NAMESPACE=4, ABSTRACT=5, CLASS=6, 
		INTERFACE=7, EXTENDS=8, IMPLEMENTS=9, IMPORT=10, RETURN=11, NEW=12, THIS=13, 
		SUPER=14, PRIVATE=15, PROTECTED=16, PUBLIC=17, VOID=18, IF=19, ELSE=20, 
		FOR=21, WHILE=22, NESTED=23, SURROUND=24, FINAL=25, STATIC=26, TRUE=27, 
		FALSE=28, NULL=29, STUB=30, StringLiteral=31, CharLiteral=32, TextMode=33, 
		DOT=34, COMMA=35, COLON=36, SCOLON=37, EQUAL=38, NOT_EQUAL=39, AND=40, 
		AMPERSAND=41, OR=42, PIPE=43, EQUALS=44, INCR=45, PLUS=46, DECR=47, MINUS=48, 
		STAR=49, PERCENT=50, HAT=51, L_SHIFT=52, RR_SHIFT=53, R_SHIFT=54, LEQ=55, 
		SMALLER=56, GEQ=57, BIGGER=58, L_BRACE=59, R_BRACE=60, LC_BRACE=61, RC_BRACE=62, 
		LS_BRACE=63, RS_BRACE=64, D_QUOTE=65, TSQ=66, QUOTE=67, SLASH=68, B_SLASH=69, 
		Q_MARK=70, ARRAY=71, E_MARK=72, Double=73, Integer=74, Identifier=75, 
		MethodIdentifier=76;
	public static final int
		RULE_document = 0, RULE_namespace = 1, RULE_namespaceReference = 2, RULE_importDeclaration = 3, 
		RULE_classDef = 4, RULE_header = 5, RULE_inheritance = 6, RULE_body = 7, 
		RULE_fieldDecl = 8, RULE_fieldAssignmentExpression = 9, RULE_method = 10, 
		RULE_methodExpression = 11, RULE_methodHeader = 12, RULE_modifier = 13, 
		RULE_block = 14, RULE_statement = 15, RULE_ifteStatement = 16, RULE_variableDeclaration = 17, 
		RULE_assignmentExpression = 18, RULE_literal = 19, RULE_expression = 20, 
		RULE_constructorCall = 21, RULE_neioNewCall = 22, RULE_arguments = 23, 
		RULE_parameters = 24, RULE_parameter = 25, RULE_type = 26, RULE_typeArgumentList = 27, 
		RULE_typeParameterList = 28, RULE_identifier = 29;
	public static final String[] ruleNames = {
		"document", "namespace", "namespaceReference", "importDeclaration", "classDef", 
		"header", "inheritance", "body", "fieldDecl", "fieldAssignmentExpression", 
		"method", "methodExpression", "methodHeader", "modifier", "block", "statement", 
		"ifteStatement", "variableDeclaration", "assignmentExpression", "literal", 
		"expression", "constructorCall", "neioNewCall", "arguments", "parameters", 
		"parameter", "type", "typeArgumentList", "typeParameterList", "identifier"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, "'namespace'", "'abstract'", "'class'", "'interface'", 
		"'extends'", "'implements'", "'import'", "'return'", "'new'", "'this'", 
		"'super'", "'private'", "'protected'", "'public'", "'void'", "'if'", "'else'", 
		"'for'", "'while'", "'nested'", "'surround'", "'final'", "'static'", "'true'", 
		"'false'", "'null'", "'stub'", null, null, null, "'.'", "','", "':'", 
		"';'", "'=='", "'!='", "'&&'", "'&'", "'||'", "'|'", "'='", "'++'", "'+'", 
		"'--'", "'-'", "'*'", "'%'", "'^'", "'<<'", "'>>>'", "'>>'", "'<='", "'<'", 
		"'>='", "'>'", "'('", "')'", "'{'", "'}'", "'['", "']'", "'\"'", "'''''", 
		"'''", "'/'", "'\\'", "'?'", "'[]'", "'!'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "COMMENT", "MULTILINE_COMMENT", "WS", "NAMESPACE", "ABSTRACT", "CLASS", 
		"INTERFACE", "EXTENDS", "IMPLEMENTS", "IMPORT", "RETURN", "NEW", "THIS", 
		"SUPER", "PRIVATE", "PROTECTED", "PUBLIC", "VOID", "IF", "ELSE", "FOR", 
		"WHILE", "NESTED", "SURROUND", "FINAL", "STATIC", "TRUE", "FALSE", "NULL", 
		"STUB", "StringLiteral", "CharLiteral", "TextMode", "DOT", "COMMA", "COLON", 
		"SCOLON", "EQUAL", "NOT_EQUAL", "AND", "AMPERSAND", "OR", "PIPE", "EQUALS", 
		"INCR", "PLUS", "DECR", "MINUS", "STAR", "PERCENT", "HAT", "L_SHIFT", 
		"RR_SHIFT", "R_SHIFT", "LEQ", "SMALLER", "GEQ", "BIGGER", "L_BRACE", "R_BRACE", 
		"LC_BRACE", "RC_BRACE", "LS_BRACE", "RS_BRACE", "D_QUOTE", "TSQ", "QUOTE", 
		"SLASH", "B_SLASH", "Q_MARK", "ARRAY", "E_MARK", "Double", "Integer", 
		"Identifier", "MethodIdentifier"
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
		public NamespaceContext namespace() {
			return getRuleContext(NamespaceContext.class,0);
		}
		public ClassDefContext classDef() {
			return getRuleContext(ClassDefContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ClassParser.EOF, 0); }
		public List<ImportDeclarationContext> importDeclaration() {
			return getRuleContexts(ImportDeclarationContext.class);
		}
		public ImportDeclarationContext importDeclaration(int i) {
			return getRuleContext(ImportDeclarationContext.class,i);
		}
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitDocument(this);
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
			setState(60);
			namespace();
			setState(64);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(61);
				importDeclaration();
				}
				}
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(67);
			classDef();
			setState(68);
			body();
			setState(69);
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

	public static class NamespaceContext extends ParserRuleContext {
		public TerminalNode NAMESPACE() { return getToken(ClassParser.NAMESPACE, 0); }
		public NamespaceReferenceContext namespaceReference() {
			return getRuleContext(NamespaceReferenceContext.class,0);
		}
		public TerminalNode SCOLON() { return getToken(ClassParser.SCOLON, 0); }
		public NamespaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namespace; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterNamespace(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitNamespace(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitNamespace(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NamespaceContext namespace() throws RecognitionException {
		NamespaceContext _localctx = new NamespaceContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_namespace);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(NAMESPACE);
			setState(72);
			namespaceReference();
			setState(73);
			match(SCOLON);
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

	public static class NamespaceReferenceContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(ClassParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(ClassParser.Identifier, i);
		}
		public List<TerminalNode> DOT() { return getTokens(ClassParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(ClassParser.DOT, i);
		}
		public NamespaceReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namespaceReference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterNamespaceReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitNamespaceReference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitNamespaceReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NamespaceReferenceContext namespaceReference() throws RecognitionException {
		NamespaceReferenceContext _localctx = new NamespaceReferenceContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_namespaceReference);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(Identifier);
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(76);
				match(DOT);
				setState(77);
				match(Identifier);
				}
				}
				setState(82);
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

	public static class ImportDeclarationContext extends ParserRuleContext {
		public TerminalNode IMPORT() { return getToken(ClassParser.IMPORT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode SCOLON() { return getToken(ClassParser.SCOLON, 0); }
		public TerminalNode DOT() { return getToken(ClassParser.DOT, 0); }
		public TerminalNode STAR() { return getToken(ClassParser.STAR, 0); }
		public ImportDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterImportDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitImportDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitImportDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportDeclarationContext importDeclaration() throws RecognitionException {
		ImportDeclarationContext _localctx = new ImportDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_importDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(IMPORT);
			setState(84);
			type();
			setState(87);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(85);
				match(DOT);
				setState(86);
				match(STAR);
				}
			}

			setState(89);
			match(SCOLON);
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

	public static class ClassDefContext extends ParserRuleContext {
		public HeaderContext header() {
			return getRuleContext(HeaderContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(ClassParser.Identifier, 0); }
		public TerminalNode SCOLON() { return getToken(ClassParser.SCOLON, 0); }
		public TerminalNode ABSTRACT() { return getToken(ClassParser.ABSTRACT, 0); }
		public List<InheritanceContext> inheritance() {
			return getRuleContexts(InheritanceContext.class);
		}
		public InheritanceContext inheritance(int i) {
			return getRuleContext(InheritanceContext.class,i);
		}
		public ClassDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterClassDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitClassDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitClassDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDefContext classDef() throws RecognitionException {
		ClassDefContext _localctx = new ClassDefContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_classDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			_la = _input.LA(1);
			if (_la==ABSTRACT) {
				{
				setState(91);
				match(ABSTRACT);
				}
			}

			setState(94);
			header();
			setState(95);
			match(Identifier);
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EXTENDS || _la==IMPLEMENTS) {
				{
				{
				setState(96);
				inheritance();
				}
				}
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(102);
			match(SCOLON);
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

	public static class HeaderContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(ClassParser.CLASS, 0); }
		public TerminalNode INTERFACE() { return getToken(ClassParser.INTERFACE, 0); }
		public HeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_header; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitHeader(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitHeader(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HeaderContext header() throws RecognitionException {
		HeaderContext _localctx = new HeaderContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_header);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			_la = _input.LA(1);
			if ( !(_la==CLASS || _la==INTERFACE) ) {
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

	public static class InheritanceContext extends ParserRuleContext {
		public TerminalNode EXTENDS() { return getToken(ClassParser.EXTENDS, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IMPLEMENTS() { return getToken(ClassParser.IMPLEMENTS, 0); }
		public InheritanceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inheritance; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterInheritance(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitInheritance(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitInheritance(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InheritanceContext inheritance() throws RecognitionException {
		InheritanceContext _localctx = new InheritanceContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_inheritance);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			switch (_input.LA(1)) {
			case EXTENDS:
				{
				setState(106);
				match(EXTENDS);
				setState(107);
				type();
				}
				break;
			case IMPLEMENTS:
				{
				setState(108);
				match(IMPLEMENTS);
				setState(109);
				type();
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

	public static class BodyContext extends ParserRuleContext {
		public List<FieldDeclContext> fieldDecl() {
			return getRuleContexts(FieldDeclContext.class);
		}
		public FieldDeclContext fieldDecl(int i) {
			return getRuleContext(FieldDeclContext.class,i);
		}
		public List<TerminalNode> SCOLON() { return getTokens(ClassParser.SCOLON); }
		public TerminalNode SCOLON(int i) {
			return getToken(ClassParser.SCOLON, i);
		}
		public List<FieldAssignmentExpressionContext> fieldAssignmentExpression() {
			return getRuleContexts(FieldAssignmentExpressionContext.class);
		}
		public FieldAssignmentExpressionContext fieldAssignmentExpression(int i) {
			return getRuleContext(FieldAssignmentExpressionContext.class,i);
		}
		public List<MethodExpressionContext> methodExpression() {
			return getRuleContexts(MethodExpressionContext.class);
		}
		public MethodExpressionContext methodExpression(int i) {
			return getRuleContext(MethodExpressionContext.class,i);
		}
		public List<MethodContext> method() {
			return getRuleContexts(MethodContext.class);
		}
		public MethodContext method(int i) {
			return getRuleContext(MethodContext.class,i);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_body);
		int _la;
		try {
			setState(129);
			switch (_input.LA(1)) {
			case NAMESPACE:
			case ABSTRACT:
			case PRIVATE:
			case PROTECTED:
			case PUBLIC:
			case VOID:
			case NESTED:
			case SURROUND:
			case FINAL:
			case STATIC:
			case PIPE:
			case EQUALS:
			case MINUS:
			case STAR:
			case HAT:
			case SMALLER:
			case Identifier:
			case MethodIdentifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(124); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(124);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						setState(112);
						fieldDecl();
						setState(113);
						match(SCOLON);
						}
						break;
					case 2:
						{
						setState(115);
						fieldAssignmentExpression();
						setState(116);
						match(SCOLON);
						}
						break;
					case 3:
						{
						setState(122);
						switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
						case 1:
							{
							setState(118);
							methodExpression();
							setState(119);
							match(SCOLON);
							}
							break;
						case 2:
							{
							setState(121);
							method();
							}
							break;
						}
						}
						break;
					}
					}
					setState(126); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NAMESPACE) | (1L << ABSTRACT) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << VOID) | (1L << NESTED) | (1L << SURROUND) | (1L << FINAL) | (1L << STATIC) | (1L << PIPE) | (1L << EQUALS) | (1L << MINUS) | (1L << STAR) | (1L << HAT) | (1L << SMALLER))) != 0) || _la==Identifier || _la==MethodIdentifier );
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

	public static class FieldDeclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(ClassParser.Identifier, 0); }
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public FieldDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterFieldDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitFieldDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitFieldDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldDeclContext fieldDecl() throws RecognitionException {
		FieldDeclContext _localctx = new FieldDeclContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_fieldDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << NESTED) | (1L << SURROUND) | (1L << FINAL) | (1L << STATIC))) != 0)) {
				{
				{
				setState(131);
				modifier();
				}
				}
				setState(136);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(137);
			type();
			setState(138);
			match(Identifier);
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

	public static class FieldAssignmentExpressionContext extends ParserRuleContext {
		public FieldDeclContext var;
		public ExpressionContext val;
		public TerminalNode EQUALS() { return getToken(ClassParser.EQUALS, 0); }
		public FieldDeclContext fieldDecl() {
			return getRuleContext(FieldDeclContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FieldAssignmentExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldAssignmentExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterFieldAssignmentExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitFieldAssignmentExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitFieldAssignmentExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldAssignmentExpressionContext fieldAssignmentExpression() throws RecognitionException {
		FieldAssignmentExpressionContext _localctx = new FieldAssignmentExpressionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_fieldAssignmentExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			((FieldAssignmentExpressionContext)_localctx).var = fieldDecl();
			setState(141);
			match(EQUALS);
			setState(142);
			((FieldAssignmentExpressionContext)_localctx).val = expression(0);
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
		public MethodExpressionContext methodExpression() {
			return getRuleContext(MethodExpressionContext.class,0);
		}
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodContext method() throws RecognitionException {
		MethodContext _localctx = new MethodContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_method);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			methodExpression();
			setState(145);
			block();
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

	public static class MethodExpressionContext extends ParserRuleContext {
		public MethodHeaderContext methodHeader() {
			return getRuleContext(MethodHeaderContext.class,0);
		}
		public TerminalNode L_BRACE() { return getToken(ClassParser.L_BRACE, 0); }
		public TerminalNode R_BRACE() { return getToken(ClassParser.R_BRACE, 0); }
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public MethodExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterMethodExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitMethodExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitMethodExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodExpressionContext methodExpression() throws RecognitionException {
		MethodExpressionContext _localctx = new MethodExpressionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_methodExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << NESTED) | (1L << SURROUND) | (1L << FINAL) | (1L << STATIC))) != 0)) {
				{
				{
				setState(147);
				modifier();
				}
				}
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(153);
			methodHeader();
			setState(154);
			match(L_BRACE);
			setState(156);
			_la = _input.LA(1);
			if (_la==NAMESPACE || _la==Identifier) {
				{
				setState(155);
				parameters();
				}
			}

			setState(158);
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

	public static class MethodHeaderContext extends ParserRuleContext {
		public TypeContext rtype;
		public Token vd;
		public Token name;
		public TerminalNode Identifier() { return getToken(ClassParser.Identifier, 0); }
		public TerminalNode MethodIdentifier() { return getToken(ClassParser.MethodIdentifier, 0); }
		public TerminalNode STAR() { return getToken(ClassParser.STAR, 0); }
		public TerminalNode MINUS() { return getToken(ClassParser.MINUS, 0); }
		public TerminalNode PIPE() { return getToken(ClassParser.PIPE, 0); }
		public TerminalNode HAT() { return getToken(ClassParser.HAT, 0); }
		public TerminalNode EQUALS() { return getToken(ClassParser.EQUALS, 0); }
		public TerminalNode SMALLER() { return getToken(ClassParser.SMALLER, 0); }
		public TypeParameterListContext typeParameterList() {
			return getRuleContext(TypeParameterListContext.class,0);
		}
		public TerminalNode BIGGER() { return getToken(ClassParser.BIGGER, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode VOID() { return getToken(ClassParser.VOID, 0); }
		public MethodHeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodHeader; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterMethodHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitMethodHeader(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitMethodHeader(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodHeaderContext methodHeader() throws RecognitionException {
		MethodHeaderContext _localctx = new MethodHeaderContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_methodHeader);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			_la = _input.LA(1);
			if (_la==SMALLER) {
				{
				setState(160);
				match(SMALLER);
				setState(161);
				typeParameterList(0);
				setState(162);
				match(BIGGER);
				}
			}

			setState(168);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(166);
				((MethodHeaderContext)_localctx).rtype = type();
				}
				break;
			case 2:
				{
				setState(167);
				((MethodHeaderContext)_localctx).vd = match(VOID);
				}
				break;
			}
			setState(170);
			((MethodHeaderContext)_localctx).name = _input.LT(1);
			_la = _input.LA(1);
			if ( !(((((_la - 43)) & ~0x3f) == 0 && ((1L << (_la - 43)) & ((1L << (PIPE - 43)) | (1L << (EQUALS - 43)) | (1L << (MINUS - 43)) | (1L << (STAR - 43)) | (1L << (HAT - 43)) | (1L << (Identifier - 43)) | (1L << (MethodIdentifier - 43)))) != 0)) ) {
				((MethodHeaderContext)_localctx).name = (Token)_errHandler.recoverInline(this);
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

	public static class ModifierContext extends ParserRuleContext {
		public TerminalNode ABSTRACT() { return getToken(ClassParser.ABSTRACT, 0); }
		public TerminalNode PRIVATE() { return getToken(ClassParser.PRIVATE, 0); }
		public TerminalNode PROTECTED() { return getToken(ClassParser.PROTECTED, 0); }
		public TerminalNode PUBLIC() { return getToken(ClassParser.PUBLIC, 0); }
		public TerminalNode FINAL() { return getToken(ClassParser.FINAL, 0); }
		public TerminalNode STATIC() { return getToken(ClassParser.STATIC, 0); }
		public TerminalNode NESTED() { return getToken(ClassParser.NESTED, 0); }
		public TerminalNode SURROUND() { return getToken(ClassParser.SURROUND, 0); }
		public ModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModifierContext modifier() throws RecognitionException {
		ModifierContext _localctx = new ModifierContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_modifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABSTRACT) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << NESTED) | (1L << SURROUND) | (1L << FINAL) | (1L << STATIC))) != 0)) ) {
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
		public TerminalNode LC_BRACE() { return getToken(ClassParser.LC_BRACE, 0); }
		public TerminalNode RC_BRACE() { return getToken(ClassParser.RC_BRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			match(LC_BRACE);
			setState(178);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NAMESPACE) | (1L << RETURN) | (1L << NEW) | (1L << THIS) | (1L << SUPER) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << TRUE) | (1L << FALSE) | (1L << NULL) | (1L << StringLiteral) | (1L << CharLiteral) | (1L << TextMode) | (1L << EQUALS) | (1L << INCR) | (1L << PLUS) | (1L << DECR) | (1L << MINUS) | (1L << STAR) | (1L << HAT) | (1L << L_BRACE))) != 0) || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (E_MARK - 72)) | (1L << (Double - 72)) | (1L << (Integer - 72)) | (1L << (Identifier - 72)) | (1L << (MethodIdentifier - 72)))) != 0)) {
				{
				{
				setState(175);
				statement();
				}
				}
				setState(180);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(181);
			match(RC_BRACE);
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
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class WhileLoopContext extends StatementContext {
		public TerminalNode WHILE() { return getToken(ClassParser.WHILE, 0); }
		public TerminalNode L_BRACE() { return getToken(ClassParser.L_BRACE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode R_BRACE() { return getToken(ClassParser.R_BRACE, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode SCOLON() { return getToken(ClassParser.SCOLON, 0); }
		public WhileLoopContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterWhileLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitWhileLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitWhileLoop(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TextModeStatementContext extends StatementContext {
		public TerminalNode StringLiteral() { return getToken(ClassParser.StringLiteral, 0); }
		public TextModeStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterTextModeStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitTextModeStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitTextModeStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignmentStatementContext extends StatementContext {
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public TerminalNode SCOLON() { return getToken(ClassParser.SCOLON, 0); }
		public AssignmentStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterAssignmentStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitAssignmentStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitAssignmentStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VariableDeclarationStatementContext extends StatementContext {
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public TerminalNode SCOLON() { return getToken(ClassParser.SCOLON, 0); }
		public VariableDeclarationStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterVariableDeclarationStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitVariableDeclarationStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitVariableDeclarationStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionStatementContext extends StatementContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SCOLON() { return getToken(ClassParser.SCOLON, 0); }
		public ExpressionStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterExpressionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitExpressionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitExpressionStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReturnStatementContext extends StatementContext {
		public TerminalNode RETURN() { return getToken(ClassParser.RETURN, 0); }
		public TerminalNode SCOLON() { return getToken(ClassParser.SCOLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfStatementContext extends StatementContext {
		public IfteStatementContext ifteStatement() {
			return getRuleContext(IfteStatementContext.class,0);
		}
		public IfStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForLoopContext extends StatementContext {
		public VariableDeclarationContext init;
		public ExpressionContext cond;
		public AssignmentExpressionContext update;
		public TerminalNode FOR() { return getToken(ClassParser.FOR, 0); }
		public TerminalNode L_BRACE() { return getToken(ClassParser.L_BRACE, 0); }
		public List<TerminalNode> SCOLON() { return getTokens(ClassParser.SCOLON); }
		public TerminalNode SCOLON(int i) {
			return getToken(ClassParser.SCOLON, i);
		}
		public TerminalNode R_BRACE() { return getToken(ClassParser.R_BRACE, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public ForLoopContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterForLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitForLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitForLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_statement);
		int _la;
		try {
			setState(217);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				_localctx = new ReturnStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(183);
				match(RETURN);
				setState(185);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NAMESPACE) | (1L << NEW) | (1L << THIS) | (1L << SUPER) | (1L << TRUE) | (1L << FALSE) | (1L << NULL) | (1L << StringLiteral) | (1L << CharLiteral) | (1L << TextMode) | (1L << EQUALS) | (1L << INCR) | (1L << PLUS) | (1L << DECR) | (1L << MINUS) | (1L << STAR) | (1L << HAT) | (1L << L_BRACE))) != 0) || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (E_MARK - 72)) | (1L << (Double - 72)) | (1L << (Integer - 72)) | (1L << (Identifier - 72)) | (1L << (MethodIdentifier - 72)))) != 0)) {
					{
					setState(184);
					expression(0);
					}
				}

				setState(187);
				match(SCOLON);
				}
				break;
			case 2:
				_localctx = new VariableDeclarationStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(188);
				variableDeclaration();
				setState(189);
				match(SCOLON);
				}
				break;
			case 3:
				_localctx = new AssignmentStatementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(191);
				assignmentExpression();
				setState(192);
				match(SCOLON);
				}
				break;
			case 4:
				_localctx = new IfStatementContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(194);
				ifteStatement();
				}
				break;
			case 5:
				_localctx = new TextModeStatementContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(195);
				match(StringLiteral);
				}
				break;
			case 6:
				_localctx = new WhileLoopContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(196);
				match(WHILE);
				setState(197);
				match(L_BRACE);
				setState(198);
				expression(0);
				setState(199);
				match(R_BRACE);
				setState(202);
				switch (_input.LA(1)) {
				case LC_BRACE:
					{
					setState(200);
					block();
					}
					break;
				case SCOLON:
					{
					setState(201);
					match(SCOLON);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 7:
				_localctx = new ForLoopContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(204);
				match(FOR);
				setState(205);
				match(L_BRACE);
				setState(206);
				((ForLoopContext)_localctx).init = variableDeclaration();
				setState(207);
				match(SCOLON);
				setState(208);
				((ForLoopContext)_localctx).cond = expression(0);
				setState(209);
				match(SCOLON);
				setState(210);
				((ForLoopContext)_localctx).update = assignmentExpression();
				setState(211);
				match(R_BRACE);
				setState(212);
				block();
				}
				break;
			case 8:
				_localctx = new ExpressionStatementContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(214);
				expression(0);
				setState(215);
				match(SCOLON);
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

	public static class IfteStatementContext extends ParserRuleContext {
		public ExpressionContext ifCondition;
		public BlockContext ifBlock;
		public BlockContext elseBlock;
		public IfteStatementContext elif;
		public TerminalNode IF() { return getToken(ClassParser.IF, 0); }
		public TerminalNode L_BRACE() { return getToken(ClassParser.L_BRACE, 0); }
		public TerminalNode R_BRACE() { return getToken(ClassParser.R_BRACE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(ClassParser.ELSE, 0); }
		public IfteStatementContext ifteStatement() {
			return getRuleContext(IfteStatementContext.class,0);
		}
		public IfteStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifteStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterIfteStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitIfteStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitIfteStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfteStatementContext ifteStatement() throws RecognitionException {
		IfteStatementContext _localctx = new IfteStatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_ifteStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			match(IF);
			setState(220);
			match(L_BRACE);
			setState(221);
			((IfteStatementContext)_localctx).ifCondition = expression(0);
			setState(222);
			match(R_BRACE);
			setState(223);
			((IfteStatementContext)_localctx).ifBlock = block();
			setState(229);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(224);
				match(ELSE);
				setState(227);
				switch (_input.LA(1)) {
				case LC_BRACE:
					{
					setState(225);
					((IfteStatementContext)_localctx).elseBlock = block();
					}
					break;
				case IF:
					{
					setState(226);
					((IfteStatementContext)_localctx).elif = ifteStatement();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
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

	public static class VariableDeclarationContext extends ParserRuleContext {
		public NeioNewCallContext neioNewCall() {
			return getRuleContext(NeioNewCallContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(ClassParser.Identifier, 0); }
		public TerminalNode EQUALS() { return getToken(ClassParser.EQUALS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitVariableDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_variableDeclaration);
		try {
			setState(237);
			switch (_input.LA(1)) {
			case NEW:
				enterOuterAlt(_localctx, 1);
				{
				setState(231);
				neioNewCall();
				}
				break;
			case NAMESPACE:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(232);
				type();
				setState(233);
				match(Identifier);
				{
				setState(234);
				match(EQUALS);
				setState(235);
				expression(0);
				}
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

	public static class AssignmentExpressionContext extends ParserRuleContext {
		public ExpressionContext var;
		public ExpressionContext val;
		public TerminalNode EQUALS() { return getToken(ClassParser.EQUALS, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AssignmentExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterAssignmentExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitAssignmentExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitAssignmentExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentExpressionContext assignmentExpression() throws RecognitionException {
		AssignmentExpressionContext _localctx = new AssignmentExpressionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_assignmentExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			((AssignmentExpressionContext)_localctx).var = expression(0);
			setState(240);
			match(EQUALS);
			setState(241);
			((AssignmentExpressionContext)_localctx).val = expression(0);
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

	public static class LiteralContext extends ParserRuleContext {
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	 
		public LiteralContext() { }
		public void copyFrom(LiteralContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NullLiteralContext extends LiteralContext {
		public TerminalNode NULL() { return getToken(ClassParser.NULL, 0); }
		public NullLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterNullLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitNullLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitNullLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringLiteralContext extends LiteralContext {
		public TerminalNode StringLiteral() { return getToken(ClassParser.StringLiteral, 0); }
		public StringLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitStringLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntLiteralContext extends LiteralContext {
		public TerminalNode Integer() { return getToken(ClassParser.Integer, 0); }
		public IntLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterIntLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitIntLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitIntLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DoubleLiteralContext extends LiteralContext {
		public TerminalNode Double() { return getToken(ClassParser.Double, 0); }
		public DoubleLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterDoubleLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitDoubleLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitDoubleLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CharLiteralContext extends LiteralContext {
		public TerminalNode CharLiteral() { return getToken(ClassParser.CharLiteral, 0); }
		public CharLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterCharLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitCharLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitCharLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolLiteralContext extends LiteralContext {
		public TerminalNode TRUE() { return getToken(ClassParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(ClassParser.FALSE, 0); }
		public BoolLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterBoolLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitBoolLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitBoolLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_literal);
		int _la;
		try {
			setState(249);
			switch (_input.LA(1)) {
			case StringLiteral:
				_localctx = new StringLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(243);
				match(StringLiteral);
				}
				break;
			case CharLiteral:
				_localctx = new CharLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(244);
				match(CharLiteral);
				}
				break;
			case Integer:
				_localctx = new IntLiteralContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(245);
				match(Integer);
				}
				break;
			case Double:
				_localctx = new DoubleLiteralContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(246);
				match(Double);
				}
				break;
			case TRUE:
			case FALSE:
				_localctx = new BoolLiteralContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(247);
				_la = _input.LA(1);
				if ( !(_la==TRUE || _la==FALSE) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			case NULL:
				_localctx = new NullLiteralContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(248);
				match(NULL);
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

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PostfixCrementExpressionContext extends ExpressionContext {
		public ExpressionContext left;
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode INCR() { return getToken(ClassParser.INCR, 0); }
		public TerminalNode DECR() { return getToken(ClassParser.DECR, 0); }
		public PostfixCrementExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterPostfixCrementExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitPostfixCrementExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitPostfixCrementExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdentifierExpressionContext extends ExpressionContext {
		public TerminalNode Identifier() { return getToken(ClassParser.Identifier, 0); }
		public IdentifierExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterIdentifierExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitIdentifierExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitIdentifierExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class QualifiedCallExpressionContext extends ExpressionContext {
		public Token name;
		public ArgumentsContext args;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DOT() { return getToken(ClassParser.DOT, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(ClassParser.Identifier, 0); }
		public TerminalNode NAMESPACE() { return getToken(ClassParser.NAMESPACE, 0); }
		public TerminalNode MethodIdentifier() { return getToken(ClassParser.MethodIdentifier, 0); }
		public TerminalNode STAR() { return getToken(ClassParser.STAR, 0); }
		public TerminalNode MINUS() { return getToken(ClassParser.MINUS, 0); }
		public TerminalNode EQUALS() { return getToken(ClassParser.EQUALS, 0); }
		public TerminalNode HAT() { return getToken(ClassParser.HAT, 0); }
		public QualifiedCallExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterQualifiedCallExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitQualifiedCallExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitQualifiedCallExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotExpressionContext extends ExpressionContext {
		public Token op;
		public ExpressionContext right;
		public TerminalNode E_MARK() { return getToken(ClassParser.E_MARK, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NotExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterNotExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitNotExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitNotExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LowPriorityNumbericalExpressionContext extends ExpressionContext {
		public ExpressionContext left;
		public Token op;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(ClassParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(ClassParser.MINUS, 0); }
		public LowPriorityNumbericalExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterLowPriorityNumbericalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitLowPriorityNumbericalExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitLowPriorityNumbericalExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class HighPriorityNumbericalExpressionContext extends ExpressionContext {
		public ExpressionContext left;
		public Token op;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode STAR() { return getToken(ClassParser.STAR, 0); }
		public TerminalNode SLASH() { return getToken(ClassParser.SLASH, 0); }
		public TerminalNode PERCENT() { return getToken(ClassParser.PERCENT, 0); }
		public HighPriorityNumbericalExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterHighPriorityNumbericalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitHighPriorityNumbericalExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitHighPriorityNumbericalExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrefixCrementExpressionContext extends ExpressionContext {
		public Token op;
		public ExpressionContext right;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode INCR() { return getToken(ClassParser.INCR, 0); }
		public TerminalNode DECR() { return getToken(ClassParser.DECR, 0); }
		public PrefixCrementExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterPrefixCrementExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitPrefixCrementExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitPrefixCrementExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SuperExpressionContext extends ExpressionContext {
		public TerminalNode SUPER() { return getToken(ClassParser.SUPER, 0); }
		public SuperExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterSuperExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitSuperExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitSuperExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CastExpressionContext extends ExpressionContext {
		public TerminalNode L_BRACE() { return getToken(ClassParser.L_BRACE, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode R_BRACE() { return getToken(ClassParser.R_BRACE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CastExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterCastExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitCastExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitCastExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndExpressionContext extends ExpressionContext {
		public ExpressionContext left;
		public Token op;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode AND() { return getToken(ClassParser.AND, 0); }
		public AndExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitAndExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitAndExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrefixExpressionContext extends ExpressionContext {
		public Token op;
		public ExpressionContext right;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(ClassParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(ClassParser.MINUS, 0); }
		public PrefixExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterPrefixExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitPrefixExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitPrefixExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AmpersandExpressionContext extends ExpressionContext {
		public ExpressionContext left;
		public Token op;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode AMPERSAND() { return getToken(ClassParser.AMPERSAND, 0); }
		public AmpersandExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterAmpersandExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitAmpersandExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitAmpersandExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TextModeContext extends ExpressionContext {
		public TerminalNode TextMode() { return getToken(ClassParser.TextMode, 0); }
		public TextModeContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterTextMode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitTextMode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitTextMode(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SuperDelegationContext extends ExpressionContext {
		public TerminalNode SUPER() { return getToken(ClassParser.SUPER, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public SuperDelegationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterSuperDelegation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitSuperDelegation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitSuperDelegation(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrderExpressionContext extends ExpressionContext {
		public ExpressionContext left;
		public Token op;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LEQ() { return getToken(ClassParser.LEQ, 0); }
		public TerminalNode GEQ() { return getToken(ClassParser.GEQ, 0); }
		public TerminalNode BIGGER() { return getToken(ClassParser.BIGGER, 0); }
		public TerminalNode SMALLER() { return getToken(ClassParser.SMALLER, 0); }
		public OrderExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterOrderExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitOrderExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitOrderExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParExpressionContext extends ExpressionContext {
		public TerminalNode L_BRACE() { return getToken(ClassParser.L_BRACE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode R_BRACE() { return getToken(ClassParser.R_BRACE, 0); }
		public ParExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterParExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitParExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitParExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ThisDelegationContext extends ExpressionContext {
		public TerminalNode THIS() { return getToken(ClassParser.THIS, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public ThisDelegationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterThisDelegation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitThisDelegation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitThisDelegation(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PipeExpressionContext extends ExpressionContext {
		public ExpressionContext left;
		public Token op;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode PIPE() { return getToken(ClassParser.PIPE, 0); }
		public PipeExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterPipeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitPipeExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitPipeExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ShiftExpressionContext extends ExpressionContext {
		public ExpressionContext left;
		public Token op;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode L_SHIFT() { return getToken(ClassParser.L_SHIFT, 0); }
		public TerminalNode RR_SHIFT() { return getToken(ClassParser.RR_SHIFT, 0); }
		public TerminalNode R_SHIFT() { return getToken(ClassParser.R_SHIFT, 0); }
		public ShiftExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterShiftExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitShiftExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitShiftExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewExpressionContext extends ExpressionContext {
		public ConstructorCallContext constructorCall() {
			return getRuleContext(ConstructorCallContext.class,0);
		}
		public NewExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterNewExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitNewExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitNewExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ClassLiteralContext extends ExpressionContext {
		public TerminalNode Identifier() { return getToken(ClassParser.Identifier, 0); }
		public TerminalNode DOT() { return getToken(ClassParser.DOT, 0); }
		public TerminalNode CLASS() { return getToken(ClassParser.CLASS, 0); }
		public ClassLiteralContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterClassLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitClassLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitClassLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NeioNewExpressionContext extends ExpressionContext {
		public NeioNewCallContext neioNewCall() {
			return getRuleContext(NeioNewCallContext.class,0);
		}
		public NeioNewExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterNeioNewExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitNeioNewExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitNeioNewExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SelfCallExpressionContext extends ExpressionContext {
		public Token name;
		public ArgumentsContext args;
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(ClassParser.Identifier, 0); }
		public TerminalNode NAMESPACE() { return getToken(ClassParser.NAMESPACE, 0); }
		public TerminalNode MethodIdentifier() { return getToken(ClassParser.MethodIdentifier, 0); }
		public TerminalNode STAR() { return getToken(ClassParser.STAR, 0); }
		public TerminalNode MINUS() { return getToken(ClassParser.MINUS, 0); }
		public TerminalNode EQUALS() { return getToken(ClassParser.EQUALS, 0); }
		public TerminalNode HAT() { return getToken(ClassParser.HAT, 0); }
		public SelfCallExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterSelfCallExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitSelfCallExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitSelfCallExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrExpressionContext extends ExpressionContext {
		public ExpressionContext left;
		public Token op;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode OR() { return getToken(ClassParser.OR, 0); }
		public OrExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitOrExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitOrExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ChainExpressionContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DOT() { return getToken(ClassParser.DOT, 0); }
		public TerminalNode Identifier() { return getToken(ClassParser.Identifier, 0); }
		public ChainExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterChainExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitChainExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitChainExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SelfExpressionContext extends ExpressionContext {
		public TerminalNode THIS() { return getToken(ClassParser.THIS, 0); }
		public SelfExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterSelfExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitSelfExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitSelfExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualityExpressionContext extends ExpressionContext {
		public ExpressionContext left;
		public Token op;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode EQUAL() { return getToken(ClassParser.EQUAL, 0); }
		public TerminalNode NOT_EQUAL() { return getToken(ClassParser.NOT_EQUAL, 0); }
		public EqualityExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterEqualityExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitEqualityExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitEqualityExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExponentiationExpressionContext extends ExpressionContext {
		public ExpressionContext left;
		public Token op;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode HAT() { return getToken(ClassParser.HAT, 0); }
		public ExponentiationExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterExponentiationExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitExponentiationExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitExponentiationExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LiteralExpressionContext extends ExpressionContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public LiteralExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterLiteralExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitLiteralExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitLiteralExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 40;
		enterRecursionRule(_localctx, 40, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				_localctx = new CastExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(252);
				match(L_BRACE);
				setState(253);
				type();
				setState(254);
				match(R_BRACE);
				setState(255);
				expression(27);
				}
				break;
			case 2:
				{
				_localctx = new NotExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(257);
				((NotExpressionContext)_localctx).op = match(E_MARK);
				setState(258);
				((NotExpressionContext)_localctx).right = expression(14);
				}
				break;
			case 3:
				{
				_localctx = new PrefixCrementExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(259);
				((PrefixCrementExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==INCR || _la==DECR) ) {
					((PrefixCrementExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(260);
				((PrefixCrementExpressionContext)_localctx).right = expression(12);
				}
				break;
			case 4:
				{
				_localctx = new PrefixExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(261);
				((PrefixExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
					((PrefixExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(262);
				((PrefixExpressionContext)_localctx).right = expression(11);
				}
				break;
			case 5:
				{
				_localctx = new LiteralExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(263);
				literal();
				}
				break;
			case 6:
				{
				_localctx = new TextModeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(264);
				match(TextMode);
				}
				break;
			case 7:
				{
				_localctx = new ClassLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(265);
				match(Identifier);
				setState(266);
				match(DOT);
				setState(267);
				match(CLASS);
				}
				break;
			case 8:
				{
				_localctx = new SuperExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(268);
				match(SUPER);
				}
				break;
			case 9:
				{
				_localctx = new SuperDelegationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(269);
				match(SUPER);
				setState(270);
				arguments();
				}
				break;
			case 10:
				{
				_localctx = new SelfExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(271);
				match(THIS);
				}
				break;
			case 11:
				{
				_localctx = new ThisDelegationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(272);
				match(THIS);
				setState(273);
				arguments();
				}
				break;
			case 12:
				{
				_localctx = new IdentifierExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(274);
				match(Identifier);
				}
				break;
			case 13:
				{
				_localctx = new NewExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(275);
				constructorCall();
				}
				break;
			case 14:
				{
				_localctx = new NeioNewExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(276);
				neioNewCall();
				}
				break;
			case 15:
				{
				_localctx = new ParExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(277);
				match(L_BRACE);
				setState(278);
				expression(0);
				setState(279);
				match(R_BRACE);
				}
				break;
			case 16:
				{
				_localctx = new SelfCallExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(281);
				((SelfCallExpressionContext)_localctx).name = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NAMESPACE) | (1L << EQUALS) | (1L << MINUS) | (1L << STAR) | (1L << HAT))) != 0) || _la==Identifier || _la==MethodIdentifier) ) {
					((SelfCallExpressionContext)_localctx).name = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(282);
				((SelfCallExpressionContext)_localctx).args = arguments();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(326);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(324);
					switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
					case 1:
						{
						_localctx = new OrExpressionContext(new ExpressionContext(_parentctx, _parentState));
						((OrExpressionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(285);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(286);
						((OrExpressionContext)_localctx).op = match(OR);
						setState(287);
						((OrExpressionContext)_localctx).right = expression(11);
						}
						break;
					case 2:
						{
						_localctx = new AndExpressionContext(new ExpressionContext(_parentctx, _parentState));
						((AndExpressionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(288);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(289);
						((AndExpressionContext)_localctx).op = match(AND);
						setState(290);
						((AndExpressionContext)_localctx).right = expression(10);
						}
						break;
					case 3:
						{
						_localctx = new ExponentiationExpressionContext(new ExpressionContext(_parentctx, _parentState));
						((ExponentiationExpressionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(291);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(292);
						((ExponentiationExpressionContext)_localctx).op = match(HAT);
						setState(293);
						((ExponentiationExpressionContext)_localctx).right = expression(9);
						}
						break;
					case 4:
						{
						_localctx = new PipeExpressionContext(new ExpressionContext(_parentctx, _parentState));
						((PipeExpressionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(294);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(295);
						((PipeExpressionContext)_localctx).op = match(PIPE);
						setState(296);
						((PipeExpressionContext)_localctx).right = expression(8);
						}
						break;
					case 5:
						{
						_localctx = new AmpersandExpressionContext(new ExpressionContext(_parentctx, _parentState));
						((AmpersandExpressionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(297);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(298);
						((AmpersandExpressionContext)_localctx).op = match(AMPERSAND);
						setState(299);
						((AmpersandExpressionContext)_localctx).right = expression(7);
						}
						break;
					case 6:
						{
						_localctx = new EqualityExpressionContext(new ExpressionContext(_parentctx, _parentState));
						((EqualityExpressionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(300);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(301);
						((EqualityExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQUAL || _la==NOT_EQUAL) ) {
							((EqualityExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(302);
						((EqualityExpressionContext)_localctx).right = expression(6);
						}
						break;
					case 7:
						{
						_localctx = new HighPriorityNumbericalExpressionContext(new ExpressionContext(_parentctx, _parentState));
						((HighPriorityNumbericalExpressionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(303);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(304);
						((HighPriorityNumbericalExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 49)) & ~0x3f) == 0 && ((1L << (_la - 49)) & ((1L << (STAR - 49)) | (1L << (PERCENT - 49)) | (1L << (SLASH - 49)))) != 0)) ) {
							((HighPriorityNumbericalExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(305);
						((HighPriorityNumbericalExpressionContext)_localctx).right = expression(5);
						}
						break;
					case 8:
						{
						_localctx = new LowPriorityNumbericalExpressionContext(new ExpressionContext(_parentctx, _parentState));
						((LowPriorityNumbericalExpressionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(306);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(307);
						((LowPriorityNumbericalExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((LowPriorityNumbericalExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(308);
						((LowPriorityNumbericalExpressionContext)_localctx).right = expression(4);
						}
						break;
					case 9:
						{
						_localctx = new ShiftExpressionContext(new ExpressionContext(_parentctx, _parentState));
						((ShiftExpressionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(309);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(310);
						((ShiftExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << L_SHIFT) | (1L << RR_SHIFT) | (1L << R_SHIFT))) != 0)) ) {
							((ShiftExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(311);
						((ShiftExpressionContext)_localctx).right = expression(3);
						}
						break;
					case 10:
						{
						_localctx = new OrderExpressionContext(new ExpressionContext(_parentctx, _parentState));
						((OrderExpressionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(312);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(313);
						((OrderExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEQ) | (1L << SMALLER) | (1L << GEQ) | (1L << BIGGER))) != 0)) ) {
							((OrderExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(314);
						((OrderExpressionContext)_localctx).right = expression(2);
						}
						break;
					case 11:
						{
						_localctx = new ChainExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(315);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(316);
						match(DOT);
						setState(317);
						match(Identifier);
						}
						break;
					case 12:
						{
						_localctx = new QualifiedCallExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(318);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(319);
						match(DOT);
						setState(320);
						((QualifiedCallExpressionContext)_localctx).name = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NAMESPACE) | (1L << EQUALS) | (1L << MINUS) | (1L << STAR) | (1L << HAT))) != 0) || _la==Identifier || _la==MethodIdentifier) ) {
							((QualifiedCallExpressionContext)_localctx).name = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(321);
						((QualifiedCallExpressionContext)_localctx).args = arguments();
						}
						break;
					case 13:
						{
						_localctx = new PostfixCrementExpressionContext(new ExpressionContext(_parentctx, _parentState));
						((PostfixCrementExpressionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(322);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(323);
						((PostfixCrementExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==INCR || _la==DECR) ) {
							((PostfixCrementExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						}
						break;
					}
					} 
				}
				setState(328);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ConstructorCallContext extends ParserRuleContext {
		public TerminalNode NEW() { return getToken(ClassParser.NEW, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public ConstructorCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructorCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterConstructorCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitConstructorCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitConstructorCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructorCallContext constructorCall() throws RecognitionException {
		ConstructorCallContext _localctx = new ConstructorCallContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_constructorCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(329);
			match(NEW);
			setState(330);
			type();
			setState(331);
			arguments();
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

	public static class NeioNewCallContext extends ParserRuleContext {
		public TerminalNode NEW() { return getToken(ClassParser.NEW, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(ClassParser.Identifier, 0); }
		public NeioNewCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_neioNewCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterNeioNewCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitNeioNewCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitNeioNewCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NeioNewCallContext neioNewCall() throws RecognitionException {
		NeioNewCallContext _localctx = new NeioNewCallContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_neioNewCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(333);
			match(NEW);
			setState(334);
			type();
			setState(335);
			arguments();
			setState(336);
			match(Identifier);
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
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
	 
		public ArgumentsContext() { }
		public void copyFrom(ArgumentsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EmptyArgumentsContext extends ArgumentsContext {
		public TerminalNode L_BRACE() { return getToken(ClassParser.L_BRACE, 0); }
		public TerminalNode R_BRACE() { return getToken(ClassParser.R_BRACE, 0); }
		public EmptyArgumentsContext(ArgumentsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterEmptyArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitEmptyArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitEmptyArguments(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SomeArgumentsContext extends ArgumentsContext {
		public TerminalNode L_BRACE() { return getToken(ClassParser.L_BRACE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode R_BRACE() { return getToken(ClassParser.R_BRACE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(ClassParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ClassParser.COMMA, i);
		}
		public SomeArgumentsContext(ArgumentsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterSomeArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitSomeArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitSomeArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_arguments);
		int _la;
		try {
			setState(351);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				_localctx = new SomeArgumentsContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(338);
				match(L_BRACE);
				setState(339);
				expression(0);
				setState(344);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(340);
					match(COMMA);
					setState(341);
					expression(0);
					}
					}
					setState(346);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(347);
				match(R_BRACE);
				}
				break;
			case 2:
				_localctx = new EmptyArgumentsContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(349);
				match(L_BRACE);
				setState(350);
				match(R_BRACE);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(353);
			parameter();
			setState(358);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(354);
				match(COMMA);
				setState(355);
				parameter();
				}
				}
				setState(360);
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

	public static class ParameterContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(ClassParser.Identifier, 0); }
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(361);
			type();
			setState(362);
			match(Identifier);
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

	public static class TypeContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(ClassParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(ClassParser.DOT, i);
		}
		public TerminalNode SMALLER() { return getToken(ClassParser.SMALLER, 0); }
		public TypeArgumentListContext typeArgumentList() {
			return getRuleContext(TypeArgumentListContext.class,0);
		}
		public TerminalNode BIGGER() { return getToken(ClassParser.BIGGER, 0); }
		public TerminalNode ARRAY() { return getToken(ClassParser.ARRAY, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_type);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(364);
			identifier();
			setState(369);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(365);
					match(DOT);
					setState(366);
					identifier();
					}
					} 
				}
				setState(371);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			}
			setState(376);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(372);
				match(SMALLER);
				setState(373);
				typeArgumentList(0);
				setState(374);
				match(BIGGER);
				}
				break;
			}
			setState(379);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				setState(378);
				match(ARRAY);
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

	public static class TypeArgumentListContext extends ParserRuleContext {
		public TypeArgumentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeArgumentList; }
	 
		public TypeArgumentListContext() { }
		public void copyFrom(TypeArgumentListContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TypeArgumentsContext extends TypeArgumentListContext {
		public TypeArgumentListContext typeArgumentList() {
			return getRuleContext(TypeArgumentListContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(ClassParser.COMMA, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TypeArgumentsContext(TypeArgumentListContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterTypeArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitTypeArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitTypeArguments(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeArgumentContext extends TypeArgumentListContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TypeArgumentContext(TypeArgumentListContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterTypeArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitTypeArgument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitTypeArgument(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoundedTypeArgumentContext extends TypeArgumentListContext {
		public TypeContext bound;
		public TerminalNode Q_MARK() { return getToken(ClassParser.Q_MARK, 0); }
		public TerminalNode EXTENDS() { return getToken(ClassParser.EXTENDS, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public BoundedTypeArgumentContext(TypeArgumentListContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterBoundedTypeArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitBoundedTypeArgument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitBoundedTypeArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeArgumentListContext typeArgumentList() throws RecognitionException {
		return typeArgumentList(0);
	}

	private TypeArgumentListContext typeArgumentList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeArgumentListContext _localctx = new TypeArgumentListContext(_ctx, _parentState);
		TypeArgumentListContext _prevctx = _localctx;
		int _startState = 54;
		enterRecursionRule(_localctx, 54, RULE_typeArgumentList, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(386);
			switch (_input.LA(1)) {
			case NAMESPACE:
			case Identifier:
				{
				_localctx = new TypeArgumentContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(382);
				type();
				}
				break;
			case Q_MARK:
				{
				_localctx = new BoundedTypeArgumentContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(383);
				match(Q_MARK);
				setState(384);
				match(EXTENDS);
				setState(385);
				((BoundedTypeArgumentContext)_localctx).bound = type();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(393);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeArgumentsContext(new TypeArgumentListContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_typeArgumentList);
					setState(388);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(389);
					match(COMMA);
					setState(390);
					type();
					}
					} 
				}
				setState(395);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TypeParameterListContext extends ParserRuleContext {
		public TypeParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameterList; }
	 
		public TypeParameterListContext() { }
		public void copyFrom(TypeParameterListContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TypeParameterContext extends TypeParameterListContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TypeParameterContext(TypeParameterListContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterTypeParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitTypeParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitTypeParameter(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoundedTypeParameterContext extends TypeParameterListContext {
		public TypeContext bound;
		public TerminalNode Identifier() { return getToken(ClassParser.Identifier, 0); }
		public TerminalNode EXTENDS() { return getToken(ClassParser.EXTENDS, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public BoundedTypeParameterContext(TypeParameterListContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterBoundedTypeParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitBoundedTypeParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitBoundedTypeParameter(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeParametersContext extends TypeParameterListContext {
		public TypeParameterListContext typeParameterList() {
			return getRuleContext(TypeParameterListContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(ClassParser.COMMA, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TypeParametersContext(TypeParameterListContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterTypeParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitTypeParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitTypeParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeParameterListContext typeParameterList() throws RecognitionException {
		return typeParameterList(0);
	}

	private TypeParameterListContext typeParameterList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeParameterListContext _localctx = new TypeParameterListContext(_ctx, _parentState);
		TypeParameterListContext _prevctx = _localctx;
		int _startState = 56;
		enterRecursionRule(_localctx, 56, RULE_typeParameterList, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(401);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				{
				_localctx = new TypeParameterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(397);
				type();
				}
				break;
			case 2:
				{
				_localctx = new BoundedTypeParameterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(398);
				match(Identifier);
				setState(399);
				match(EXTENDS);
				setState(400);
				((BoundedTypeParameterContext)_localctx).bound = type();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(408);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeParametersContext(new TypeParameterListContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_typeParameterList);
					setState(403);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(404);
					match(COMMA);
					setState(405);
					type();
					}
					} 
				}
				setState(410);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(ClassParser.Identifier, 0); }
		public TerminalNode NAMESPACE() { return getToken(ClassParser.NAMESPACE, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ClassParserListener ) ((ClassParserListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClassParserVisitor ) return ((ClassParserVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(411);
			_la = _input.LA(1);
			if ( !(_la==NAMESPACE || _la==Identifier) ) {
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 20:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 27:
			return typeArgumentList_sempred((TypeArgumentListContext)_localctx, predIndex);
		case 28:
			return typeParameterList_sempred((TypeParameterListContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 10);
		case 1:
			return precpred(_ctx, 9);
		case 2:
			return precpred(_ctx, 8);
		case 3:
			return precpred(_ctx, 7);
		case 4:
			return precpred(_ctx, 6);
		case 5:
			return precpred(_ctx, 5);
		case 6:
			return precpred(_ctx, 4);
		case 7:
			return precpred(_ctx, 3);
		case 8:
			return precpred(_ctx, 2);
		case 9:
			return precpred(_ctx, 1);
		case 10:
			return precpred(_ctx, 18);
		case 11:
			return precpred(_ctx, 16);
		case 12:
			return precpred(_ctx, 13);
		}
		return true;
	}
	private boolean typeArgumentList_sempred(TypeArgumentListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 13:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean typeParameterList_sempred(TypeParameterListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 14:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3N\u01a0\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\3\2\3\2\7"+
		"\2A\n\2\f\2\16\2D\13\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\7\4"+
		"Q\n\4\f\4\16\4T\13\4\3\5\3\5\3\5\3\5\5\5Z\n\5\3\5\3\5\3\6\5\6_\n\6\3\6"+
		"\3\6\3\6\7\6d\n\6\f\6\16\6g\13\6\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\5\bq"+
		"\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t}\n\t\6\t\177\n\t\r\t"+
		"\16\t\u0080\3\t\5\t\u0084\n\t\3\n\7\n\u0087\n\n\f\n\16\n\u008a\13\n\3"+
		"\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\r\7\r\u0097\n\r\f\r\16\r"+
		"\u009a\13\r\3\r\3\r\3\r\5\r\u009f\n\r\3\r\3\r\3\16\3\16\3\16\3\16\5\16"+
		"\u00a7\n\16\3\16\3\16\5\16\u00ab\n\16\3\16\3\16\3\17\3\17\3\20\3\20\7"+
		"\20\u00b3\n\20\f\20\16\20\u00b6\13\20\3\20\3\20\3\21\3\21\5\21\u00bc\n"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\5\21\u00cd\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\5\21\u00dc\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\5\22\u00e6\n\22\5\22\u00e8\n\22\3\23\3\23\3\23\3\23\3\23\3\23\5"+
		"\23\u00f0\n\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\5\25"+
		"\u00fc\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u011e\n\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\7\26\u0147\n\26\f\26\16\26\u014a\13\26"+
		"\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\7\31"+
		"\u0159\n\31\f\31\16\31\u015c\13\31\3\31\3\31\3\31\3\31\5\31\u0162\n\31"+
		"\3\32\3\32\3\32\7\32\u0167\n\32\f\32\16\32\u016a\13\32\3\33\3\33\3\33"+
		"\3\34\3\34\3\34\7\34\u0172\n\34\f\34\16\34\u0175\13\34\3\34\3\34\3\34"+
		"\3\34\5\34\u017b\n\34\3\34\5\34\u017e\n\34\3\35\3\35\3\35\3\35\3\35\5"+
		"\35\u0185\n\35\3\35\3\35\3\35\7\35\u018a\n\35\f\35\16\35\u018d\13\35\3"+
		"\36\3\36\3\36\3\36\3\36\5\36\u0194\n\36\3\36\3\36\3\36\7\36\u0199\n\36"+
		"\f\36\16\36\u019c\13\36\3\37\3\37\3\37\2\5*8: \2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$&(*,.\60\62\64\668:<\2\16\3\2\b\t\6\2-.\62\63\65\65"+
		"MN\5\2\7\7\21\23\31\34\3\2\35\36\4\2//\61\61\4\2\60\60\62\62\7\2\6\6."+
		".\62\63\65\65MN\3\2()\4\2\63\64FF\3\2\668\3\29<\4\2\6\6MM\u01ca\2>\3\2"+
		"\2\2\4I\3\2\2\2\6M\3\2\2\2\bU\3\2\2\2\n^\3\2\2\2\fj\3\2\2\2\16p\3\2\2"+
		"\2\20\u0083\3\2\2\2\22\u0088\3\2\2\2\24\u008e\3\2\2\2\26\u0092\3\2\2\2"+
		"\30\u0098\3\2\2\2\32\u00a6\3\2\2\2\34\u00ae\3\2\2\2\36\u00b0\3\2\2\2 "+
		"\u00db\3\2\2\2\"\u00dd\3\2\2\2$\u00ef\3\2\2\2&\u00f1\3\2\2\2(\u00fb\3"+
		"\2\2\2*\u011d\3\2\2\2,\u014b\3\2\2\2.\u014f\3\2\2\2\60\u0161\3\2\2\2\62"+
		"\u0163\3\2\2\2\64\u016b\3\2\2\2\66\u016e\3\2\2\28\u0184\3\2\2\2:\u0193"+
		"\3\2\2\2<\u019d\3\2\2\2>B\5\4\3\2?A\5\b\5\2@?\3\2\2\2AD\3\2\2\2B@\3\2"+
		"\2\2BC\3\2\2\2CE\3\2\2\2DB\3\2\2\2EF\5\n\6\2FG\5\20\t\2GH\7\2\2\3H\3\3"+
		"\2\2\2IJ\7\6\2\2JK\5\6\4\2KL\7\'\2\2L\5\3\2\2\2MR\7M\2\2NO\7$\2\2OQ\7"+
		"M\2\2PN\3\2\2\2QT\3\2\2\2RP\3\2\2\2RS\3\2\2\2S\7\3\2\2\2TR\3\2\2\2UV\7"+
		"\f\2\2VY\5\66\34\2WX\7$\2\2XZ\7\63\2\2YW\3\2\2\2YZ\3\2\2\2Z[\3\2\2\2["+
		"\\\7\'\2\2\\\t\3\2\2\2]_\7\7\2\2^]\3\2\2\2^_\3\2\2\2_`\3\2\2\2`a\5\f\7"+
		"\2ae\7M\2\2bd\5\16\b\2cb\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2fh\3\2\2"+
		"\2ge\3\2\2\2hi\7\'\2\2i\13\3\2\2\2jk\t\2\2\2k\r\3\2\2\2lm\7\n\2\2mq\5"+
		"\66\34\2no\7\13\2\2oq\5\66\34\2pl\3\2\2\2pn\3\2\2\2q\17\3\2\2\2rs\5\22"+
		"\n\2st\7\'\2\2t\177\3\2\2\2uv\5\24\13\2vw\7\'\2\2w\177\3\2\2\2xy\5\30"+
		"\r\2yz\7\'\2\2z}\3\2\2\2{}\5\26\f\2|x\3\2\2\2|{\3\2\2\2}\177\3\2\2\2~"+
		"r\3\2\2\2~u\3\2\2\2~|\3\2\2\2\177\u0080\3\2\2\2\u0080~\3\2\2\2\u0080\u0081"+
		"\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0084\3\2\2\2\u0083~\3\2\2\2\u0083"+
		"\u0082\3\2\2\2\u0084\21\3\2\2\2\u0085\u0087\5\34\17\2\u0086\u0085\3\2"+
		"\2\2\u0087\u008a\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089"+
		"\u008b\3\2\2\2\u008a\u0088\3\2\2\2\u008b\u008c\5\66\34\2\u008c\u008d\7"+
		"M\2\2\u008d\23\3\2\2\2\u008e\u008f\5\22\n\2\u008f\u0090\7.\2\2\u0090\u0091"+
		"\5*\26\2\u0091\25\3\2\2\2\u0092\u0093\5\30\r\2\u0093\u0094\5\36\20\2\u0094"+
		"\27\3\2\2\2\u0095\u0097\5\34\17\2\u0096\u0095\3\2\2\2\u0097\u009a\3\2"+
		"\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009b\3\2\2\2\u009a"+
		"\u0098\3\2\2\2\u009b\u009c\5\32\16\2\u009c\u009e\7=\2\2\u009d\u009f\5"+
		"\62\32\2\u009e\u009d\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0"+
		"\u00a1\7>\2\2\u00a1\31\3\2\2\2\u00a2\u00a3\7:\2\2\u00a3\u00a4\5:\36\2"+
		"\u00a4\u00a5\7<\2\2\u00a5\u00a7\3\2\2\2\u00a6\u00a2\3\2\2\2\u00a6\u00a7"+
		"\3\2\2\2\u00a7\u00aa\3\2\2\2\u00a8\u00ab\5\66\34\2\u00a9\u00ab\7\24\2"+
		"\2\u00aa\u00a8\3\2\2\2\u00aa\u00a9\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac"+
		"\3\2\2\2\u00ac\u00ad\t\3\2\2\u00ad\33\3\2\2\2\u00ae\u00af\t\4\2\2\u00af"+
		"\35\3\2\2\2\u00b0\u00b4\7?\2\2\u00b1\u00b3\5 \21\2\u00b2\u00b1\3\2\2\2"+
		"\u00b3\u00b6\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b7"+
		"\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b7\u00b8\7@\2\2\u00b8\37\3\2\2\2\u00b9"+
		"\u00bb\7\r\2\2\u00ba\u00bc\5*\26\2\u00bb\u00ba\3\2\2\2\u00bb\u00bc\3\2"+
		"\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00dc\7\'\2\2\u00be\u00bf\5$\23\2\u00bf"+
		"\u00c0\7\'\2\2\u00c0\u00dc\3\2\2\2\u00c1\u00c2\5&\24\2\u00c2\u00c3\7\'"+
		"\2\2\u00c3\u00dc\3\2\2\2\u00c4\u00dc\5\"\22\2\u00c5\u00dc\7!\2\2\u00c6"+
		"\u00c7\7\30\2\2\u00c7\u00c8\7=\2\2\u00c8\u00c9\5*\26\2\u00c9\u00cc\7>"+
		"\2\2\u00ca\u00cd\5\36\20\2\u00cb\u00cd\7\'\2\2\u00cc\u00ca\3\2\2\2\u00cc"+
		"\u00cb\3\2\2\2\u00cd\u00dc\3\2\2\2\u00ce\u00cf\7\27\2\2\u00cf\u00d0\7"+
		"=\2\2\u00d0\u00d1\5$\23\2\u00d1\u00d2\7\'\2\2\u00d2\u00d3\5*\26\2\u00d3"+
		"\u00d4\7\'\2\2\u00d4\u00d5\5&\24\2\u00d5\u00d6\7>\2\2\u00d6\u00d7\5\36"+
		"\20\2\u00d7\u00dc\3\2\2\2\u00d8\u00d9\5*\26\2\u00d9\u00da\7\'\2\2\u00da"+
		"\u00dc\3\2\2\2\u00db\u00b9\3\2\2\2\u00db\u00be\3\2\2\2\u00db\u00c1\3\2"+
		"\2\2\u00db\u00c4\3\2\2\2\u00db\u00c5\3\2\2\2\u00db\u00c6\3\2\2\2\u00db"+
		"\u00ce\3\2\2\2\u00db\u00d8\3\2\2\2\u00dc!\3\2\2\2\u00dd\u00de\7\25\2\2"+
		"\u00de\u00df\7=\2\2\u00df\u00e0\5*\26\2\u00e0\u00e1\7>\2\2\u00e1\u00e7"+
		"\5\36\20\2\u00e2\u00e5\7\26\2\2\u00e3\u00e6\5\36\20\2\u00e4\u00e6\5\""+
		"\22\2\u00e5\u00e3\3\2\2\2\u00e5\u00e4\3\2\2\2\u00e6\u00e8\3\2\2\2\u00e7"+
		"\u00e2\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8#\3\2\2\2\u00e9\u00f0\5.\30\2"+
		"\u00ea\u00eb\5\66\34\2\u00eb\u00ec\7M\2\2\u00ec\u00ed\7.\2\2\u00ed\u00ee"+
		"\5*\26\2\u00ee\u00f0\3\2\2\2\u00ef\u00e9\3\2\2\2\u00ef\u00ea\3\2\2\2\u00f0"+
		"%\3\2\2\2\u00f1\u00f2\5*\26\2\u00f2\u00f3\7.\2\2\u00f3\u00f4\5*\26\2\u00f4"+
		"\'\3\2\2\2\u00f5\u00fc\7!\2\2\u00f6\u00fc\7\"\2\2\u00f7\u00fc\7L\2\2\u00f8"+
		"\u00fc\7K\2\2\u00f9\u00fc\t\5\2\2\u00fa\u00fc\7\37\2\2\u00fb\u00f5\3\2"+
		"\2\2\u00fb\u00f6\3\2\2\2\u00fb\u00f7\3\2\2\2\u00fb\u00f8\3\2\2\2\u00fb"+
		"\u00f9\3\2\2\2\u00fb\u00fa\3\2\2\2\u00fc)\3\2\2\2\u00fd\u00fe\b\26\1\2"+
		"\u00fe\u00ff\7=\2\2\u00ff\u0100\5\66\34\2\u0100\u0101\7>\2\2\u0101\u0102"+
		"\5*\26\35\u0102\u011e\3\2\2\2\u0103\u0104\7J\2\2\u0104\u011e\5*\26\20"+
		"\u0105\u0106\t\6\2\2\u0106\u011e\5*\26\16\u0107\u0108\t\7\2\2\u0108\u011e"+
		"\5*\26\r\u0109\u011e\5(\25\2\u010a\u011e\7#\2\2\u010b\u010c\7M\2\2\u010c"+
		"\u010d\7$\2\2\u010d\u011e\7\b\2\2\u010e\u011e\7\20\2\2\u010f\u0110\7\20"+
		"\2\2\u0110\u011e\5\60\31\2\u0111\u011e\7\17\2\2\u0112\u0113\7\17\2\2\u0113"+
		"\u011e\5\60\31\2\u0114\u011e\7M\2\2\u0115\u011e\5,\27\2\u0116\u011e\5"+
		".\30\2\u0117\u0118\7=\2\2\u0118\u0119\5*\26\2\u0119\u011a\7>\2\2\u011a"+
		"\u011e\3\2\2\2\u011b\u011c\t\b\2\2\u011c\u011e\5\60\31\2\u011d\u00fd\3"+
		"\2\2\2\u011d\u0103\3\2\2\2\u011d\u0105\3\2\2\2\u011d\u0107\3\2\2\2\u011d"+
		"\u0109\3\2\2\2\u011d\u010a\3\2\2\2\u011d\u010b\3\2\2\2\u011d\u010e\3\2"+
		"\2\2\u011d\u010f\3\2\2\2\u011d\u0111\3\2\2\2\u011d\u0112\3\2\2\2\u011d"+
		"\u0114\3\2\2\2\u011d\u0115\3\2\2\2\u011d\u0116\3\2\2\2\u011d\u0117\3\2"+
		"\2\2\u011d\u011b\3\2\2\2\u011e\u0148\3\2\2\2\u011f\u0120\f\f\2\2\u0120"+
		"\u0121\7,\2\2\u0121\u0147\5*\26\r\u0122\u0123\f\13\2\2\u0123\u0124\7*"+
		"\2\2\u0124\u0147\5*\26\f\u0125\u0126\f\n\2\2\u0126\u0127\7\65\2\2\u0127"+
		"\u0147\5*\26\13\u0128\u0129\f\t\2\2\u0129\u012a\7-\2\2\u012a\u0147\5*"+
		"\26\n\u012b\u012c\f\b\2\2\u012c\u012d\7+\2\2\u012d\u0147\5*\26\t\u012e"+
		"\u012f\f\7\2\2\u012f\u0130\t\t\2\2\u0130\u0147\5*\26\b\u0131\u0132\f\6"+
		"\2\2\u0132\u0133\t\n\2\2\u0133\u0147\5*\26\7\u0134\u0135\f\5\2\2\u0135"+
		"\u0136\t\7\2\2\u0136\u0147\5*\26\6\u0137\u0138\f\4\2\2\u0138\u0139\t\13"+
		"\2\2\u0139\u0147\5*\26\5\u013a\u013b\f\3\2\2\u013b\u013c\t\f\2\2\u013c"+
		"\u0147\5*\26\4\u013d\u013e\f\24\2\2\u013e\u013f\7$\2\2\u013f\u0147\7M"+
		"\2\2\u0140\u0141\f\22\2\2\u0141\u0142\7$\2\2\u0142\u0143\t\b\2\2\u0143"+
		"\u0147\5\60\31\2\u0144\u0145\f\17\2\2\u0145\u0147\t\6\2\2\u0146\u011f"+
		"\3\2\2\2\u0146\u0122\3\2\2\2\u0146\u0125\3\2\2\2\u0146\u0128\3\2\2\2\u0146"+
		"\u012b\3\2\2\2\u0146\u012e\3\2\2\2\u0146\u0131\3\2\2\2\u0146\u0134\3\2"+
		"\2\2\u0146\u0137\3\2\2\2\u0146\u013a\3\2\2\2\u0146\u013d\3\2\2\2\u0146"+
		"\u0140\3\2\2\2\u0146\u0144\3\2\2\2\u0147\u014a\3\2\2\2\u0148\u0146\3\2"+
		"\2\2\u0148\u0149\3\2\2\2\u0149+\3\2\2\2\u014a\u0148\3\2\2\2\u014b\u014c"+
		"\7\16\2\2\u014c\u014d\5\66\34\2\u014d\u014e\5\60\31\2\u014e-\3\2\2\2\u014f"+
		"\u0150\7\16\2\2\u0150\u0151\5\66\34\2\u0151\u0152\5\60\31\2\u0152\u0153"+
		"\7M\2\2\u0153/\3\2\2\2\u0154\u0155\7=\2\2\u0155\u015a\5*\26\2\u0156\u0157"+
		"\7%\2\2\u0157\u0159\5*\26\2\u0158\u0156\3\2\2\2\u0159\u015c\3\2\2\2\u015a"+
		"\u0158\3\2\2\2\u015a\u015b\3\2\2\2\u015b\u015d\3\2\2\2\u015c\u015a\3\2"+
		"\2\2\u015d\u015e\7>\2\2\u015e\u0162\3\2\2\2\u015f\u0160\7=\2\2\u0160\u0162"+
		"\7>\2\2\u0161\u0154\3\2\2\2\u0161\u015f\3\2\2\2\u0162\61\3\2\2\2\u0163"+
		"\u0168\5\64\33\2\u0164\u0165\7%\2\2\u0165\u0167\5\64\33\2\u0166\u0164"+
		"\3\2\2\2\u0167\u016a\3\2\2\2\u0168\u0166\3\2\2\2\u0168\u0169\3\2\2\2\u0169"+
		"\63\3\2\2\2\u016a\u0168\3\2\2\2\u016b\u016c\5\66\34\2\u016c\u016d\7M\2"+
		"\2\u016d\65\3\2\2\2\u016e\u0173\5<\37\2\u016f\u0170\7$\2\2\u0170\u0172"+
		"\5<\37\2\u0171\u016f\3\2\2\2\u0172\u0175\3\2\2\2\u0173\u0171\3\2\2\2\u0173"+
		"\u0174\3\2\2\2\u0174\u017a\3\2\2\2\u0175\u0173\3\2\2\2\u0176\u0177\7:"+
		"\2\2\u0177\u0178\58\35\2\u0178\u0179\7<\2\2\u0179\u017b\3\2\2\2\u017a"+
		"\u0176\3\2\2\2\u017a\u017b\3\2\2\2\u017b\u017d\3\2\2\2\u017c\u017e\7I"+
		"\2\2\u017d\u017c\3\2\2\2\u017d\u017e\3\2\2\2\u017e\67\3\2\2\2\u017f\u0180"+
		"\b\35\1\2\u0180\u0185\5\66\34\2\u0181\u0182\7H\2\2\u0182\u0183\7\n\2\2"+
		"\u0183\u0185\5\66\34\2\u0184\u017f\3\2\2\2\u0184\u0181\3\2\2\2\u0185\u018b"+
		"\3\2\2\2\u0186\u0187\f\5\2\2\u0187\u0188\7%\2\2\u0188\u018a\5\66\34\2"+
		"\u0189\u0186\3\2\2\2\u018a\u018d\3\2\2\2\u018b\u0189\3\2\2\2\u018b\u018c"+
		"\3\2\2\2\u018c9\3\2\2\2\u018d\u018b\3\2\2\2\u018e\u018f\b\36\1\2\u018f"+
		"\u0194\5\66\34\2\u0190\u0191\7M\2\2\u0191\u0192\7\n\2\2\u0192\u0194\5"+
		"\66\34\2\u0193\u018e\3\2\2\2\u0193\u0190\3\2\2\2\u0194\u019a\3\2\2\2\u0195"+
		"\u0196\f\5\2\2\u0196\u0197\7%\2\2\u0197\u0199\5\66\34\2\u0198\u0195\3"+
		"\2\2\2\u0199\u019c\3\2\2\2\u019a\u0198\3\2\2\2\u019a\u019b\3\2\2\2\u019b"+
		";\3\2\2\2\u019c\u019a\3\2\2\2\u019d\u019e\t\r\2\2\u019e=\3\2\2\2&BRY^"+
		"ep|~\u0080\u0083\u0088\u0098\u009e\u00a6\u00aa\u00b4\u00bb\u00cc\u00db"+
		"\u00e5\u00e7\u00ef\u00fb\u011d\u0146\u0148\u015a\u0161\u0168\u0173\u017a"+
		"\u017d\u0184\u018b\u0193\u019a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}