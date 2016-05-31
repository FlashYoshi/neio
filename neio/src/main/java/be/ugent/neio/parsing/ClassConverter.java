package be.ugent.neio.parsing;

import static be.ugent.neio.util.Constants.ASSIGNMENT;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.aikodi.chameleon.core.document.Document;
import org.aikodi.chameleon.core.element.Element;
import org.aikodi.chameleon.core.modifier.Modifier;
import org.aikodi.chameleon.core.namespace.NamespaceReference;
import org.aikodi.chameleon.core.namespacedeclaration.Import;
import org.aikodi.chameleon.core.namespacedeclaration.NamespaceDeclaration;
import org.aikodi.chameleon.core.reference.CrossReferenceTarget;
import org.aikodi.chameleon.core.tag.TagImpl;
import org.aikodi.chameleon.exception.ChameleonProgrammerException;
import org.aikodi.chameleon.input.InputProcessor;
import org.aikodi.chameleon.input.PositionMetadata;
import org.aikodi.chameleon.oo.expression.Expression;
import org.aikodi.chameleon.oo.expression.ExpressionFactory;
import org.aikodi.chameleon.oo.expression.Literal;
import org.aikodi.chameleon.oo.expression.MethodInvocation;
import org.aikodi.chameleon.oo.expression.NameExpression;
import org.aikodi.chameleon.oo.expression.ParExpression;
import org.aikodi.chameleon.oo.method.Method;
import org.aikodi.chameleon.oo.method.MethodHeader;
import org.aikodi.chameleon.oo.plugin.ObjectOrientedFactory;
import org.aikodi.chameleon.oo.statement.Block;
import org.aikodi.chameleon.oo.statement.Statement;
import org.aikodi.chameleon.oo.type.ClassWithBody;
import org.aikodi.chameleon.oo.type.Type;
import org.aikodi.chameleon.oo.type.TypeReference;
import org.aikodi.chameleon.oo.type.generics.FormalTypeParameter;
import org.aikodi.chameleon.oo.type.generics.TypeArgument;
import org.aikodi.chameleon.oo.type.generics.TypeParameter;
import org.aikodi.chameleon.oo.type.inheritance.SubtypeRelation;
import org.aikodi.chameleon.oo.variable.FormalParameter;
import org.aikodi.chameleon.support.expression.AssignmentExpression;
import org.aikodi.chameleon.support.expression.ClassCastExpression;
import org.aikodi.chameleon.support.expression.SuperTarget;
import org.aikodi.chameleon.support.member.simplename.variable.MemberVariableDeclarator;
import org.aikodi.chameleon.support.modifier.Abstract;
import org.aikodi.chameleon.support.modifier.Constructor;
import org.aikodi.chameleon.support.modifier.Final;
import org.aikodi.chameleon.support.modifier.Interface;
import org.aikodi.chameleon.support.modifier.Private;
import org.aikodi.chameleon.support.modifier.Protected;
import org.aikodi.chameleon.support.modifier.Public;
import org.aikodi.chameleon.support.modifier.Static;
import org.aikodi.chameleon.support.statement.ForControl;
import org.aikodi.chameleon.support.statement.ForStatement;
import org.aikodi.chameleon.support.statement.ReturnStatement;
import org.aikodi.chameleon.support.statement.StatementExprList;
import org.aikodi.chameleon.support.statement.WhileStatement;
import org.aikodi.chameleon.support.variable.LocalVariableDeclarator;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.neio.antlr.ClassParser.AmpersandExpressionContext;
import org.neio.antlr.ClassParser.AndExpressionContext;
import org.neio.antlr.ClassParser.AssignmentExpressionContext;
import org.neio.antlr.ClassParser.AssignmentStatementContext;
import org.neio.antlr.ClassParser.BlockContext;
import org.neio.antlr.ClassParser.BodyContext;
import org.neio.antlr.ClassParser.BoolLiteralContext;
import org.neio.antlr.ClassParser.BoundedTypeArgumentContext;
import org.neio.antlr.ClassParser.BoundedTypeParameterContext;
import org.neio.antlr.ClassParser.CastExpressionContext;
import org.neio.antlr.ClassParser.ChainExpressionContext;
import org.neio.antlr.ClassParser.CharLiteralContext;
import org.neio.antlr.ClassParser.ClassDefContext;
import org.neio.antlr.ClassParser.ClassLiteralContext;
import org.neio.antlr.ClassParser.ConstructorCallContext;
import org.neio.antlr.ClassParser.DocumentContext;
import org.neio.antlr.ClassParser.DoubleLiteralContext;
import org.neio.antlr.ClassParser.EmptyArgumentsContext;
import org.neio.antlr.ClassParser.EqualityExpressionContext;
import org.neio.antlr.ClassParser.ExponentiationExpressionContext;
import org.neio.antlr.ClassParser.ExpressionStatementContext;
import org.neio.antlr.ClassParser.FieldAssignmentExpressionContext;
import org.neio.antlr.ClassParser.FieldDeclContext;
import org.neio.antlr.ClassParser.ForLoopContext;
import org.neio.antlr.ClassParser.HighPriorityNumbericalExpressionContext;
import org.neio.antlr.ClassParser.IdentifierContext;
import org.neio.antlr.ClassParser.IdentifierExpressionContext;
import org.neio.antlr.ClassParser.IfStatementContext;
import org.neio.antlr.ClassParser.IfteStatementContext;
import org.neio.antlr.ClassParser.ImportDeclarationContext;
import org.neio.antlr.ClassParser.InheritanceContext;
import org.neio.antlr.ClassParser.IntLiteralContext;
import org.neio.antlr.ClassParser.LiteralExpressionContext;
import org.neio.antlr.ClassParser.LowPriorityNumbericalExpressionContext;
import org.neio.antlr.ClassParser.MethodContext;
import org.neio.antlr.ClassParser.MethodExpressionContext;
import org.neio.antlr.ClassParser.MethodHeaderContext;
import org.neio.antlr.ClassParser.ModifierContext;
import org.neio.antlr.ClassParser.NamespaceContext;
import org.neio.antlr.ClassParser.NamespaceReferenceContext;
import org.neio.antlr.ClassParser.NeioNewCallContext;
import org.neio.antlr.ClassParser.NeioNewExpressionContext;
import org.neio.antlr.ClassParser.NewExpressionContext;
import org.neio.antlr.ClassParser.NotExpressionContext;
import org.neio.antlr.ClassParser.NullLiteralContext;
import org.neio.antlr.ClassParser.OrExpressionContext;
import org.neio.antlr.ClassParser.OrderExpressionContext;
import org.neio.antlr.ClassParser.ParExpressionContext;
import org.neio.antlr.ClassParser.ParameterContext;
import org.neio.antlr.ClassParser.ParametersContext;
import org.neio.antlr.ClassParser.PipeExpressionContext;
import org.neio.antlr.ClassParser.PostfixCrementExpressionContext;
import org.neio.antlr.ClassParser.PrefixCrementExpressionContext;
import org.neio.antlr.ClassParser.PrefixExpressionContext;
import org.neio.antlr.ClassParser.QualifiedCallExpressionContext;
import org.neio.antlr.ClassParser.ReturnStatementContext;
import org.neio.antlr.ClassParser.SelfCallExpressionContext;
import org.neio.antlr.ClassParser.SelfExpressionContext;
import org.neio.antlr.ClassParser.ShiftExpressionContext;
import org.neio.antlr.ClassParser.SomeArgumentsContext;
import org.neio.antlr.ClassParser.StatementContext;
import org.neio.antlr.ClassParser.StringLiteralContext;
import org.neio.antlr.ClassParser.SuperDelegationContext;
import org.neio.antlr.ClassParser.SuperExpressionContext;
import org.neio.antlr.ClassParser.TextModeContext;
import org.neio.antlr.ClassParser.TextModeStatementContext;
import org.neio.antlr.ClassParser.ThisDelegationContext;
import org.neio.antlr.ClassParser.TypeArgumentContext;
import org.neio.antlr.ClassParser.TypeArgumentsContext;
import org.neio.antlr.ClassParser.TypeContext;
import org.neio.antlr.ClassParser.TypeParameterContext;
import org.neio.antlr.ClassParser.TypeParametersContext;
import org.neio.antlr.ClassParser.VariableDeclarationContext;
import org.neio.antlr.ClassParser.VariableDeclarationStatementContext;
import org.neio.antlr.ClassParser.WhileLoopContext;
import org.neio.antlr.ClassParserBaseVisitor;
import org.neio.antlr.DocumentLexer;
import org.neio.antlr.DocumentParser;

import be.kuleuven.cs.distrinet.jnome.core.expression.ClassLiteral;
import be.kuleuven.cs.distrinet.jnome.core.expression.invocation.ConstructorInvocation;
import be.kuleuven.cs.distrinet.jnome.core.expression.invocation.JavaMethodInvocation;
import be.kuleuven.cs.distrinet.jnome.core.expression.invocation.SuperConstructorDelegation;
import be.kuleuven.cs.distrinet.jnome.core.expression.invocation.ThisConstructorDelegation;
import be.kuleuven.cs.distrinet.jnome.core.modifier.Implements;
import be.kuleuven.cs.distrinet.jnome.core.type.BasicJavaTypeReference;
import be.kuleuven.cs.distrinet.jnome.core.type.JavaTypeReference;
import be.kuleuven.cs.distrinet.jnome.workspace.JavaView;
import be.ugent.neio.industry.NeioExpressionFactory;
import be.ugent.neio.industry.NeioFactory;
import be.ugent.neio.language.Neio;
import be.ugent.neio.model.modifier.Nested;
import be.ugent.neio.model.modifier.Surround;
import be.ugent.neio.util.Constants;

/**
 * @author Titouan Vervack
 * @author Marko van Dooren
 */
public class ClassConverter extends ClassParserBaseVisitor<Object> {

    private final Document document;
    private final Neio neio;
    private final JavaView view;
    // Can not use keyword
    private boolean interphase;
    private boolean contextType;
    private boolean isStringMain;

    public ClassConverter(Document document, JavaView view) {
        this.document = document;
        this.neio = view.language(Neio.class);
        this.view = view;
        interphase = false;
        contextType = false;
        isStringMain = true;
    }
    
		public List<InputProcessor> inputProcessors() {
			if(view != null) {
				return view.processors(InputProcessor.class);
			} else {
				throw new IllegalStateException();
			}
		}
		protected void setAll(Element element, ParserRuleContext context) {
			setAll(element, context.start, context.stop);
		}

		protected void setKeyword(Element element, Token token) {
			setLocation(element, token, token, PositionMetadata.KEYWORD);
		}

		protected void setAll(Element element, Token start, Token stop) {
		  setLocation(element, start, stop, PositionMetadata.ALL);
		}

		protected void setName(Element element, Token token) {
		  setLocation(element, token, token, PositionMetadata.NAME);
		}

		protected void setCrossReference(Element element, ParserRuleContext context) {
			setCrossReference(element, context.start, context.stop);
		}
		
		protected void setCrossReference(Element element, Token start, Token stop) {
			setLocation(element, start, stop, PositionMetadata.CROSSREFERENCE);
		}

		protected void setLocation(Element element, Token start, Token stop, String tagType) {
	     List<InputProcessor> processors = inputProcessors();
	     if(processors.size() > 0) {
	    	 if(start != null && stop != null) {
	    		 int offset = offset(start);
	    		 int length = length(start,stop);
	    		 for(InputProcessor processor: processors) {
	    			 processor.setLocation(element, offset, length, document, tagType);
	    		 }
	    	 }
	     }
	   }

	   protected int lineNumber(Token token) {
	  	 return token.getLine();
	   }
	   
	   protected int offset(Token token) {
	  	 return token.getStartIndex();
	   }
	   
	   protected int length(Token start, Token stop) {
	  	 return stop.getStopIndex() - offset(start);
	   }

    protected NeioFactory ooFactory() {
        return (NeioFactory) neio.plugin(ObjectOrientedFactory.class);
    }

    protected NeioExpressionFactory eFactory() {
        return (NeioExpressionFactory) neio.plugin(ExpressionFactory.class);
    }

    private boolean isInterface() {
        return interphase;
    }

    private void setInterface() {
        interphase = true;
    }

    public Document visitDocument(DocumentContext ctx) {
    	NamespaceDeclaration ns = visitNamespace(ctx.namespace());
    	if(ns != null) {
    		for (ImportDeclarationContext importCtx : ctx.importDeclaration()) {
    			ns.addImport(visitImportDeclaration(importCtx));
    		}

    		Type type = visitClassDef(ctx.classDef());

    		for (InheritanceContext inheritance : ctx.classDef().inheritance()) {
    			type.addInheritanceRelation(visitInheritance(inheritance));
    		}

    		visitBody(ctx.body(), type);

    		ns.add(type);
    	}
    	document.add(ns);

        return document;
    }

    @Override
    public NamespaceDeclaration visitNamespace(@NotNull NamespaceContext ctx) {
    	NamespaceDeclaration result = null;
        if (ctx != null) {
            NamespaceReference namespaceReference = visitNamespaceReference(ctx.namespaceReference());
            if(namespaceReference != null) {
              result = ooFactory().createNamespaceDeclaration(namespaceReference);
              setAll(result,ctx);
              setKeyword(result,ctx.NAMESPACE().getSymbol());
            }
        }
        return result;
    }

    @Override
    public NamespaceReference visitNamespaceReference(@NotNull NamespaceReferenceContext ctx) {
    	NamespaceReference result = null;
    	if(ctx != null) {
        NeioFactory ooFactory = ooFactory();
				result = ooFactory.createNamespaceReference(ctx.getText());
				setAll(result,ctx);
				setCrossReference(result, ctx);
    	}
    	return result;
    }

    @Override
    public Import visitImportDeclaration(@NotNull ImportDeclarationContext ctx) {
    	Import result;
        if (ctx.STAR() != null) {
            result = ooFactory().createDemandImport(ctx.type().getText());
        } else {
            result = ooFactory().createTypeImport(visitType(ctx.type()));
        }
        setKeyword(result, ctx.IMPORT().getSymbol());
        return result;
    }

    @Override
    public Type visitClassDef(@NotNull ClassDefContext ctx) {
        TerminalNode nameToken = ctx.Identifier();
        Type type = null;
        if(nameToken != null) {
        	type = ooFactory().createRegularType(nameToken.getText());
        	// Every class is allowed to be public for now
        	type.addModifier(new Public());
        	//FIXME Code duplication! The visit method of the modifier should do this.
        	if (ctx.ABSTRACT() != null) {
        		type.addModifier(new Abstract());
        	}

        	if (ctx.header().INTERFACE() != null) {
        		type.addModifier(new Interface());
        		setInterface();
          	setKeyword(type, ctx.header().INTERFACE().getSymbol());
        	} else {
          	setKeyword(type, ctx.header().CLASS().getSymbol());
        	}
        	setName(type, nameToken.getSymbol());
        	setAll(type, ctx);
        }
        return type;
    }

    @Override
    public SubtypeRelation visitInheritance(@NotNull InheritanceContext ctx) {
        SubtypeRelation relation = ooFactory().createSubtypeRelation(visitType(ctx.type()));
        if (ctx.IMPLEMENTS() != null) {
            relation.addModifier(new Implements());
            setKeyword(relation, ctx.IMPLEMENTS().getSymbol());
        } else {
        	setKeyword(relation, ctx.EXTENDS().getSymbol());
        }
        setAll(relation,ctx);
        return relation;
    }

    private void visitBody(BodyContext ctx, Type klass) {
        if (ctx == null) {
            return;
        }

        for (FieldDeclContext decl : ctx.fieldDecl()) {
            klass.add(visitFieldDecl(decl));
        }

        for (FieldAssignmentExpressionContext assignment : ctx.fieldAssignmentExpression()) {
            klass.add(visitFieldAssignmentExpression(assignment));
        }

        for (MethodContext method : ctx.method()) {
            klass.add(visitMethod(method));
        }

        for (MethodExpressionContext method : ctx.methodExpression()) {
            klass.add(visitMethodExpression(method));
        }
        setAll(((ClassWithBody)klass).body(), ctx);
    }


    @Override
    public MemberVariableDeclarator visitFieldDecl(@NotNull FieldDeclContext ctx) {
        MemberVariableDeclarator declarator = ooFactory().createMemberVariableDeclarator(ctx.Identifier().getText(), visitType(ctx.type()));
        for (ModifierContext modifier : ctx.modifier()) {
            declarator.addModifier(visitModifier(modifier));
        }


        if (ctx.modifier().isEmpty() && !isInterface()) {
            declarator.addModifier(new Private());
        }
        setAll(declarator, ctx);
        setName(declarator, ctx.Identifier().getSymbol());
        return declarator;
    }

    @Override
    public LocalVariableDeclarator visitVariableDeclaration(@NotNull VariableDeclarationContext ctx) {
    	LocalVariableDeclarator result;
        if (ctx.neioNewCall() != null) {
            ConstructorInvocation ci = visitNeioNewCall(ctx.neioNewCall());
            result = ooFactory().createLocalVariable(ci.name(), ctx.neioNewCall().Identifier().getText(), ci);
            setName(result, ctx.neioNewCall().Identifier().getSymbol());
        } else {
            result = ooFactory().createLocalVariable(visitType(ctx.type()), ctx.Identifier().getText(), (Expression) visit(ctx.expression()));
            setName(result, ctx.Identifier().getSymbol());
        }
        setAll(result, ctx);
        return result;
    }

    @Override
    public MemberVariableDeclarator visitFieldAssignmentExpression(@NotNull FieldAssignmentExpressionContext ctx) {
    	MemberVariableDeclarator varDecl = visitFieldDecl(ctx.var);
    	varDecl.variableDeclarations().get(0).setInitialization((Expression)visit(ctx.val));
    	return varDecl;
    }

    @Override
    public AssignmentExpression visitAssignmentExpression(@NotNull AssignmentExpressionContext ctx) {
        return eFactory().createAssignmentExpression((Expression) visit(ctx.var), (Expression) visit(ctx.val));
    }

    @Override
    public Method visitMethod(@NotNull MethodContext ctx) {
        Method method = visitMethodExpression(ctx.methodExpression());
        method.setImplementation(ooFactory().createImplementation(visitBlock(ctx.block())));
        setAll(method,ctx);
        setName(method,ctx.methodExpression().methodHeader().name);
        return method;
    }

    @Override
    public Block visitBlock(@NotNull BlockContext ctx) {
        if (ctx == null) {
            return null;
        }

        Block block = ooFactory().createBlock();
        for (StatementContext statement : ctx.statement()) {
            if (statement != null) {
                block.addStatement((Statement) visit(statement));
            }
        }

        return block;
    }

    @Override
    public Statement visitAssignmentStatement(@NotNull AssignmentStatementContext ctx) {
        Statement statement = ooFactory().createStatement(visitAssignmentExpression(ctx.assignmentExpression()));
        statement.setMetadata(new TagImpl(), ASSIGNMENT);
        return statement;
    }

    @Override
    public Statement visitExpressionStatement(@NotNull ExpressionStatementContext ctx) {
        return ooFactory().createStatement((Expression) visit(ctx.expression()));
    }

    @Override
    public Statement visitReturnStatement(@NotNull ReturnStatementContext ctx) {
        Expression e = null;
        if (ctx.expression() != null && !ctx.expression().isEmpty()) {
            e = (Expression) visit(ctx.expression());
        }
        ReturnStatement result = ooFactory().createReturnStatement(e);
        setAll(result, ctx);
        setKeyword(result, ctx.RETURN().getSymbol());
				return result;
    }

    @Override
    public Statement visitVariableDeclarationStatement(@NotNull VariableDeclarationStatementContext ctx) {
        LocalVariableDeclarator lvd = visitVariableDeclaration(ctx.variableDeclaration());
        lvd.setMetadata(new TagImpl(), ASSIGNMENT);
        return lvd;
    }

    @Override
    public ClassCastExpression visitCastExpression(@NotNull CastExpressionContext ctx) {
        return eFactory().createClassCastExpression(visitType(ctx.type()), (Expression) visit(ctx.expression()));
    }

    @Override
    public WhileStatement visitWhileLoop(@NotNull WhileLoopContext ctx) {
        Statement statement = null;
        if (ctx.block() != null && !ctx.block().isEmpty()) {
            statement = visitBlock(ctx.block());
        }

        WhileStatement result = ooFactory().createWhileStatement((Expression) visit(ctx.expression()), statement);
        setAll(result, ctx);
        setKeyword(result, ctx.WHILE().getSymbol());
				return result;
    }

    @Override
    public ForStatement visitForLoop(@NotNull ForLoopContext ctx) {
        LocalVariableDeclarator init = visitVariableDeclaration(ctx.init);

        AssignmentExpression update = visitAssignmentExpression(ctx.update);
        StatementExprList list = new StatementExprList();
        list.addStatement(ooFactory().createStatementExpression(update));

        ForControl control = ooFactory().createForControl(init, (Expression) visit(ctx.cond), list);
        ForStatement result = ooFactory().createForStatement(control, visitBlock(ctx.block()));
        setAll(result, ctx);
        setKeyword(result, ctx.FOR().getSymbol());
				return result;
    }

    @Override
    public Statement visitIfStatement(@NotNull IfStatementContext ctx) {
        Statement statement = visitIfteStatement(ctx.ifteStatement());
        statement.setMetadata(new TagImpl(), ASSIGNMENT);
        setAll(statement,ctx);
        setKeyword(statement, ctx.ifteStatement().IF().getSymbol());
        return statement;
    }

    @Override
    public Statement visitIfteStatement(@NotNull IfteStatementContext ctx) {
        Expression condition = (Expression) visit(ctx.ifCondition);
        Statement elseStatement = null;
        if (ctx.elseBlock != null) {
            elseStatement = visitBlock(ctx.elseBlock);
        } else if (ctx.elif != null) {
            elseStatement = visitIfteStatement(ctx.elif);
        }

        Block ifBlock = visitBlock(ctx.ifBlock);

        // If statement
        /*if (ctx.elif != null || ifBlock.nbStatements() > 1
                || ifBlock.nearestDescendants(Statement.class).get(0).metadata(ASSIGNMENT) != null
                || (elseStatement != null &&
                (((Block) elseStatement).nbStatements() > 1
                        || elseStatement.nearestDescendants(Statement.class).get(0).metadata(ASSIGNMENT) != null))
                || ifBlock.nearestDescendants(ReturnStatement.class).size() > 0
                || elseStatement == null
                || elseStatement.nearestDescendants(ReturnStatement.class).size() > 0
                || ifBlock.nearestDescendants(RegularMethodInvocation.class).get(0).name().equals("void")) {*/
        return ooFactory().createIfStatement(condition, ifBlock, elseStatement);
        /*} // Ternary operator
        else {
            Expression conditionalExpression = eFactory().createConditionalExpression(condition,
                    ifBlock.nearestDescendants(Expression.class).get(0),
                    elseStatement.nearestDescendants(Expression.class).get(0));
            List<Expression> arguments = new ArrayList<>();
            arguments.add(conditionalExpression);
            return ooFactory().createStatement(eFactory().createMethodInvocation(IFCALL, eFactory().createNameExpression(IFCLASS), arguments));
        }*/
    }

    @Override
    public Expression visitLiteralExpression(@NotNull LiteralExpressionContext ctx) {
        return (Expression) visit(ctx.literal());
    }

    @Override
    public Expression visitNewExpression(@NotNull NewExpressionContext ctx) {
        ConstructorInvocation result = visitConstructorCall(ctx.constructorCall());
        setAll(result, ctx);
        setCrossReference(result,ctx);
        setKeyword(result, ctx.constructorCall().NEW().getSymbol());
				return result;
    }

    @Override
    public Object visitNeioNewExpression(@NotNull NeioNewExpressionContext ctx) {
        ConstructorInvocation result = visitNeioNewCall(ctx.neioNewCall());
        setAll(result, ctx);
        setCrossReference(result,ctx);
        setKeyword(result, ctx.neioNewCall().NEW().getSymbol());
				return result;
    }

    @Override
    public ParExpression visitParExpression(@NotNull ParExpressionContext ctx) {
        return eFactory().createParExpression((Expression) visit(ctx.expression()));
    }

    @Override
    public CrossReferenceTarget visitSuperExpression(@NotNull SuperExpressionContext ctx) {
        SuperTarget result = ooFactory().createSuper();
        setAll(result, ctx);
        setKeyword(result,ctx.start);
				return result;
    }

    @Override
    public SuperConstructorDelegation visitSuperDelegation(@NotNull SuperDelegationContext ctx) {
        SuperConstructorDelegation delegation = ooFactory().createSuperDelegation();
        List<Expression> arguments = ((List<Expression>) visit(ctx.arguments()));
        delegation.addAllArguments(arguments);
        setAll(delegation, ctx);
        setKeyword(delegation, ctx.SUPER().getSymbol());
        setCrossReference(delegation, ctx);
        return delegation;
    }

    @Override
    public Literal visitSelfExpression(@NotNull SelfExpressionContext ctx) {
        Literal result = ooFactory().createThisLiteral();
        setAll(result, ctx);
        setKeyword(result, ctx.THIS().getSymbol());
				return result;
    }

    @Override
    public ThisConstructorDelegation visitThisDelegation(@NotNull ThisDelegationContext ctx) {
        ThisConstructorDelegation delegation = ooFactory().createThisDelegation();
        List<Expression> arguments = ((List<Expression>) visit(ctx.arguments()));
        delegation.addAllArguments(arguments);

        return delegation;
    }

    @Override
    public NameExpression visitIdentifierExpression(@NotNull IdentifierExpressionContext ctx) {
        NameExpression result = eFactory().createNameExpression(contextType, ctx.Identifier().getText());
        setAll(result, ctx);
        setCrossReference(result, ctx);
				return result;
    }

    @Override
    public NameExpression visitChainExpression(@NotNull ChainExpressionContext ctx) {
        return eFactory().createNameExpression(ctx.Identifier().getText(), (CrossReferenceTarget) visit(ctx.expression()));
    }

    @Override
    public MethodInvocation visitSelfCallExpression(@NotNull SelfCallExpressionContext ctx) {
        Literal thisLiteral = ooFactory().createThisLiteral();
				JavaMethodInvocation result = eFactory().createMethodInvocation(contextType, ctx.name.getText(), thisLiteral, (List<Expression>) visit(ctx.arguments()));
				setAll(result, ctx);
				setCrossReference(result, ctx);
				return result;
    }

    @Override
    public Expression visitQualifiedCallExpression(@NotNull QualifiedCallExpressionContext ctx) {
        CrossReferenceTarget target = (CrossReferenceTarget) visit(ctx.expression());
        Expression result;
        if (ctx.args != null) {
            List<Expression> arguments = ((List<Expression>) visit(ctx.args));
            result = eFactory().createMethodInvocation(contextType, ctx.name.getText(), target, arguments);
        } else {
            result = new NameExpression(ctx.name.getText(), target);
        }
        setAll(result, ctx);
        setCrossReference(result, ctx.name, ctx.args.stop);
        return result;
    }

    @Override
    public Expression visitExponentiationExpression(ExponentiationExpressionContext ctx) {
        MethodInvocation result = eFactory().createInfixOperatorInvocation(ctx.op.getText(), (Expression) visit(ctx.left));
        result.addArgument((Expression) visit(ctx.right));
        return result;
    }

    @Override
    public Expression visitHighPriorityNumbericalExpression(HighPriorityNumbericalExpressionContext ctx) {
        MethodInvocation result = eFactory().createInfixOperatorInvocation(ctx.op.getText(), (Expression) visit(ctx.left));
        result.addArgument((Expression) visit(ctx.right));
        return result;
    }

    @Override
    public Expression visitLowPriorityNumbericalExpression(LowPriorityNumbericalExpressionContext ctx) {
        MethodInvocation result = eFactory().createInfixOperatorInvocation(ctx.op.getText(), (Expression) visit(ctx.left));
        result.addArgument((Expression) visit(ctx.right));
        return result;
    }

    @Override
    public Expression visitShiftExpression(ShiftExpressionContext ctx) {
        MethodInvocation result = eFactory().createInfixOperatorInvocation(ctx.op.getText(), (Expression) visit(ctx.left));
        result.addArgument((Expression) visit(ctx.right));
        return result;
    }

    @Override
    public Expression visitOrderExpression(OrderExpressionContext ctx) {
        MethodInvocation result = eFactory().createInfixOperatorInvocation(ctx.op.getText(), (Expression) visit(ctx.left));
        result.addArgument((Expression) visit(ctx.right));
        return result;
    }

    @Override
    public Expression visitEqualityExpression(EqualityExpressionContext ctx) {
        MethodInvocation result = eFactory().createInfixOperatorInvocation(ctx.op.getText(), (Expression) visit(ctx.left));
        result.addArgument((Expression) visit(ctx.right));
        return result;
    }

    @Override
    public Expression visitNotExpression(@NotNull NotExpressionContext ctx) {
        return eFactory().createPrefixOperatorInvocation(ctx.op.getText(), (Expression) visit(ctx.right));
    }

    @Override
    public Expression visitPostfixCrementExpression(@NotNull PostfixCrementExpressionContext ctx) {
        return eFactory().createPostfixOperatorInvocation(ctx.op.getText(), (Expression) visit(ctx.left));
    }

    @Override
    public Expression visitPrefixCrementExpression(@NotNull PrefixCrementExpressionContext ctx) {
        return eFactory().createPrefixOperatorInvocation(ctx.op.getText(), (Expression) visit(ctx.right));
    }

    @Override
    public Object visitPrefixExpression(@NotNull PrefixExpressionContext ctx) {
        return eFactory().createPrefixOperatorInvocation(ctx.op.getText(), (Expression) visit(ctx.right));
    }

    @Override
    public Expression visitAmpersandExpression(@NotNull AmpersandExpressionContext ctx) {
        MethodInvocation result = eFactory().createInfixOperatorInvocation(ctx.op.getText(), (Expression) visit(ctx.left));
        result.addArgument((Expression) visit(ctx.right));
        return result;
    }

    @Override
    public Expression visitPipeExpression(@NotNull PipeExpressionContext ctx) {
        MethodInvocation result = eFactory().createInfixOperatorInvocation(ctx.op.getText(), (Expression) visit(ctx.left));
        result.addArgument((Expression) visit(ctx.right));
        return result;
    }

    @Override
    public Expression visitAndExpression(AndExpressionContext ctx) {
        MethodInvocation result = eFactory().createInfixOperatorInvocation(ctx.op.getText(), (Expression) visit(ctx.left));
        result.addArgument((Expression) visit(ctx.right));
        return result;
    }

    @Override
    public Expression visitOrExpression(OrExpressionContext ctx) {
        MethodInvocation result = eFactory().createInfixOperatorInvocation(ctx.op.getText(), (Expression) visit(ctx.left));
        result.addArgument((Expression) visit(ctx.right));
        return result;
    }

    @Override
    public ConstructorInvocation visitConstructorCall(@NotNull ConstructorCallContext ctx) {
        BasicJavaTypeReference type = (BasicJavaTypeReference) visitType(ctx.type());
        return eFactory().createConstructorInvocation(type, null, (List<Expression>) visit(ctx.arguments()));
    }

    @Override
    public ConstructorInvocation visitNeioNewCall(@NotNull NeioNewCallContext ctx) {
        BasicJavaTypeReference type = (BasicJavaTypeReference) visitType(ctx.type());
        return eFactory().createConstructorInvocation(type, null, (List<Expression>) visit(ctx.arguments()));
    }

    @Override
    public Method visitMethodExpression(@NotNull MethodExpressionContext ctx) {
        MethodHeader methodHeader = visitMethodHeader(ctx.methodHeader());
        Method method = ooFactory().createMethod(methodHeader);

        if (ctx.methodHeader().rtype == null && ctx.methodHeader().vd == null) {
            method.addModifier(new Constructor());
        }

        boolean addPublic = ctx.modifier().isEmpty();
        for (ModifierContext modifier : ctx.modifier()) {
            if (modifier.NESTED() != null && !modifier.NESTED().getText().isEmpty() && ctx.modifier().size() == 1) {
                addPublic = true;
            }

            if (modifier.SURROUND() != null && !modifier.SURROUND().getText().isEmpty()) {
                methodHeader.setName(Constants.SURROUND + methodHeader.name());
            }
            method.addModifier(visitModifier(modifier));
        }

        if (addPublic) {
            method.addModifier(new Public());
        }

        if (ctx.parameters() != null) {
            method.header().addFormalParameters((List<FormalParameter>) visit(ctx.parameters()));
        }

        return method;
    }

    @Override
    public MethodHeader visitMethodHeader(@NotNull MethodHeaderContext ctx) {
        List<TypeParameter> typeParameters = new ArrayList<>();
        if (ctx.typeParameterList() != null) {
            typeParameters = (List<TypeParameter>) visit(ctx.typeParameterList());
        }

        if (ctx.type() != null) {
            return ooFactory().createMethodHeader(ctx.name.getText(), visitType(ctx.type()), typeParameters);
        } else if (ctx.VOID() != null) {
            return ooFactory().createMethodHeader(ctx.name.getText(), ctx.VOID().getText(), typeParameters);
        } else {
            // Method is a constructor
            return ooFactory().createMethodHeader(ctx.name.getText(), ctx.name.getText(), typeParameters);
        }
    }

    @Override
    public Modifier visitModifier(@NotNull ModifierContext ctx) {
    	Modifier result;
    	if (ctx.ABSTRACT() != null) {
    		result = new Abstract();
    	} else if (ctx.PRIVATE() != null) {
    		result = new Private();
    	} else if (ctx.PROTECTED() != null) {
    		result = new Protected();
    	} else if (ctx.PUBLIC() != null) {
    		result = new Public();
    	} else if (ctx.NESTED() != null) {
    		result = new Nested();
    	} else if (ctx.SURROUND() != null) {
    		result = new Surround();
    	} else if (ctx.FINAL() != null) {
    		result = new Final();
    	} else if (ctx.STATIC() != null) {
    		result = new Static();
    	} else {
    		throw new ChameleonProgrammerException("Unknown modifier encountered: " + ctx.getText());
    	}
    	setKeyword(result, ctx.start);
    	return result;
    }

    @Override
    public List<FormalParameter> visitParameters(@NotNull ParametersContext ctx) {
        return ctx.parameter().stream().map(this::visitParameter).collect(Collectors.toList());
    }

    @Override
    public FormalParameter visitParameter(@NotNull ParameterContext ctx) {
        FormalParameter createParameter = ooFactory().createParameter(ctx.Identifier().getText(), visitType(ctx.type()));
        setAll(createParameter, ctx);
        setName(createParameter, ctx.Identifier().getSymbol());
				return createParameter;
    }

    @Override
    public List<FormalParameter> visitEmptyArguments(@NotNull EmptyArgumentsContext ctx) {
        return new ArrayList<>();
    }

    @Override
    public List<Expression> visitSomeArguments(@NotNull SomeArgumentsContext ctx) {
        if (ctx == null) {
            return null;
        }

        return ctx.expression().stream().map(ectx -> (Expression) visit(ectx)).collect(Collectors.toList());
    }

    @Override
    public JavaTypeReference visitType(@NotNull TypeContext ctx) {
        String name = visitIdentifiers(ctx.identifier());
        JavaTypeReference type;
        List<TypeArgument> typeArguments = new ArrayList<>();
        if (ctx.typeArgumentList() != null) {
            typeArguments = (List<TypeArgument>) visit(ctx.typeArgumentList());
        }
        // The type is an array
        if (ctx.ARRAY() != null) {
            type = ooFactory().createArrayTypeReference(name, typeArguments);
        } else {
            type = ooFactory().createTypeReference(name, typeArguments);
        }
        setAll(type, ctx);
        setCrossReference(type, ctx);
        return type;
    }

    @Override
    public List<TypeParameter> visitTypeParameters(@NotNull TypeParametersContext ctx) {
        List<TypeParameter> typeParams = new ArrayList<>();

        if (ctx != null) {
            typeParams.addAll((List<TypeParameter>) visit(ctx.typeParameterList()));
            typeParams.add(ooFactory().createTypeParameter(((BasicJavaTypeReference) visitType(ctx.type())).name()));
        }

        return typeParams;
    }

    @Override
    public List<TypeParameter> visitTypeParameter(@NotNull TypeParameterContext ctx) {
        List<TypeParameter> typeParams = new ArrayList<>();
        typeParams.add(ooFactory().createTypeParameter(((BasicJavaTypeReference) visitType(ctx.type())).name()));

        return typeParams;
    }

    @Override
    public List<FormalTypeParameter> visitBoundedTypeParameter(@NotNull BoundedTypeParameterContext ctx) {
        List<FormalTypeParameter> list = new ArrayList<>();
        FormalTypeParameter parameter = ooFactory().createFormalTypeParameter(ctx.Identifier().getText());
        parameter.addConstraint(ooFactory().createExtendsConstraint(visitType(ctx.bound)));
        list.add(parameter);

        return list;
    }

    @Override
    public List<TypeArgument> visitTypeArguments(@NotNull TypeArgumentsContext ctx) {
        List<TypeArgument> typeArguments = new ArrayList<>();

        if (ctx != null) {
            // This means visitTypeArguments and visitTypeArgument both have to return a list
            typeArguments.addAll((List<TypeArgument>) visit(ctx.typeArgumentList()));
            typeArguments.add(ooFactory().createTypeArgument(((BasicJavaTypeReference) visitType(ctx.type())).name()));
        }

        return typeArguments;
    }

    /**
     * Has to return a list, see {@link #visitTypeArguments(TypeArgumentsContext)}
     */
    @Override
    public List<TypeArgument> visitTypeArgument(@NotNull TypeArgumentContext ctx) {
        List<TypeArgument> arguments = new ArrayList<>();

        arguments.add(ooFactory().createTypeArgument(((BasicJavaTypeReference) visitType(ctx.type())).name()));

        return arguments;
    }

    @Override
    public Object visitBoundedTypeArgument(@NotNull BoundedTypeArgumentContext ctx) {
        List<TypeArgument> arguments = new ArrayList<>();
        if (ctx.Q_MARK() != null) {
            TypeReference type = visitType(ctx.bound);
            arguments.add(ooFactory().createExtendsWildcard(type));
        }

        return arguments;
    }

    @Override
    public ClassLiteral visitClassLiteral(@NotNull ClassLiteralContext ctx) {
        ClassLiteral result = ooFactory().createClassLiteral(ctx.Identifier().getText());
        setAll(result.target(),ctx.Identifier().getSymbol(), ctx.Identifier().getSymbol());
        setCrossReference(result.target(),ctx.Identifier().getSymbol(), ctx.Identifier().getSymbol());
				return result;
    }

    @Override
    public Expression visitStringLiteral(@NotNull StringLiteralContext ctx) {
        if (isStringMain) {
            return visitString(ctx.getText());
        } else {
            return visitTextMode(getText(ctx.getText(), "\"".length()), false).nearestDescendants(Expression.class).get(0);
        }
    }

    private Expression visitString(String content) {
        content = content.replaceAll("\\r?\\n", "\\\\n");
        return ooFactory().createStringLiteral(content);
    }

    private Block visitTextMode(String text, boolean append) {
        DocumentConverter converter = new DocumentConverter(document, view);
        text = trimText(text);
        text = text.trim();
        DocumentParser parser = getParser(text);
        converter.setAppend(append);

        return converter.visitBody(parser.body());
    }

    @Override
    public Statement visitTextModeStatement(@NotNull TextModeStatementContext ctx) {
        return visitTextMode(getText(ctx.getText(), "\"".length()), true);
    }

    @Override
    public Expression visitTextMode(@NotNull TextModeContext ctx) {
        if (isStringMain) {
            DocumentConverter converter = new DocumentConverter(document, view);
            DocumentParser parser = getParser(getText(ctx.getText(), "'''".length()));

            return converter.visitTxt(parser.txt());
        } else {
            return visitString(getText(ctx.getText(), "'''".length()));
        }
    }

    @Override
    public Literal visitDoubleLiteral(@NotNull DoubleLiteralContext ctx) {
        return ooFactory().createDoubleLiteral(ctx.getText());
    }

    @Override
    public Literal visitBoolLiteral(@NotNull BoolLiteralContext ctx) {
        Literal result = ooFactory().createBooleanLiteral(ctx.getText());
        setKeyword(result, ctx.start);
				return result;
    }

    @Override
    public Literal visitNullLiteral(@NotNull NullLiteralContext ctx) {
        Literal result = ooFactory().createNullLiteral();
        setKeyword(result, ctx.start);
				return result;
    }

    @Override
    public Literal visitIntLiteral(@NotNull IntLiteralContext ctx) {
        return ooFactory().createIntegerLiteral(ctx.Integer().getText());
    }

    @Override
    public Literal visitCharLiteral(@NotNull CharLiteralContext ctx) {
        return ooFactory().createCharLiteral(ctx.CharLiteral().getText());
    }

    private String trimText(String text) {
        String[] lines = text.split("\r\n | [\n\r]");
        StringBuilder builder = new StringBuilder();
        for (String line : lines) {
            builder.append(line.trim()).append("\n");
        }

        return builder.toString();
    }

    private String getText(String textMode, int sepLen) {
        return textMode.substring(sepLen, textMode.length() - sepLen);
    }

    private DocumentParser getParser(String s) {
        InputStream stream = new ByteArrayInputStream(s.getBytes(StandardCharsets.UTF_8));
        ANTLRInputStream input = null;
        try {
            input = new ANTLRInputStream(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Lexer lexer = new DocumentLexer(input);
        TokenStream tokens = new CommonTokenStream(lexer);

        return new DocumentParser(tokens);
    }

    private String visitIdentifiers(List<IdentifierContext> identifiers) {
        if (identifiers == null || identifiers.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder(identifiers.get(0).getText());
        for (int i = 1; i < identifiers.size(); i++) {
            result.append(".").append(identifiers.get(i).getText());
        }

        return result.toString();
    }

    public void enableContextTypes() {
        contextType = true;
    }

    public void flipStringText() {
        isStringMain = false;
    }
}
