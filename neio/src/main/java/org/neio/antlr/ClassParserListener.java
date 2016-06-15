// Generated from B:\Documents\GitHub\neio\neio\src\main\grammar\ClassParser.g4 by ANTLR 4.5
package org.neio.antlr;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ClassParser}.
 */
public interface ClassParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ClassParser#document}.
	 * @param ctx the parse tree
	 */
	void enterDocument(ClassParser.DocumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#document}.
	 * @param ctx the parse tree
	 */
	void exitDocument(ClassParser.DocumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link ClassParser#namespace}.
	 * @param ctx the parse tree
	 */
	void enterNamespace(ClassParser.NamespaceContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#namespace}.
	 * @param ctx the parse tree
	 */
	void exitNamespace(ClassParser.NamespaceContext ctx);
	/**
	 * Enter a parse tree produced by {@link ClassParser#namespaceReference}.
	 * @param ctx the parse tree
	 */
	void enterNamespaceReference(ClassParser.NamespaceReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#namespaceReference}.
	 * @param ctx the parse tree
	 */
	void exitNamespaceReference(ClassParser.NamespaceReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link ClassParser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterImportDeclaration(ClassParser.ImportDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitImportDeclaration(ClassParser.ImportDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ClassParser#classDef}.
	 * @param ctx the parse tree
	 */
	void enterClassDef(ClassParser.ClassDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#classDef}.
	 * @param ctx the parse tree
	 */
	void exitClassDef(ClassParser.ClassDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link ClassParser#header}.
	 * @param ctx the parse tree
	 */
	void enterHeader(ClassParser.HeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#header}.
	 * @param ctx the parse tree
	 */
	void exitHeader(ClassParser.HeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link ClassParser#inheritance}.
	 * @param ctx the parse tree
	 */
	void enterInheritance(ClassParser.InheritanceContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#inheritance}.
	 * @param ctx the parse tree
	 */
	void exitInheritance(ClassParser.InheritanceContext ctx);
	/**
	 * Enter a parse tree produced by {@link ClassParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(ClassParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(ClassParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ClassParser#fieldDecl}.
	 * @param ctx the parse tree
	 */
	void enterFieldDecl(ClassParser.FieldDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#fieldDecl}.
	 * @param ctx the parse tree
	 */
	void exitFieldDecl(ClassParser.FieldDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link ClassParser#fieldAssignmentExpression}.
	 * @param ctx the parse tree
	 */
	void enterFieldAssignmentExpression(ClassParser.FieldAssignmentExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#fieldAssignmentExpression}.
	 * @param ctx the parse tree
	 */
	void exitFieldAssignmentExpression(ClassParser.FieldAssignmentExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ClassParser#method}.
	 * @param ctx the parse tree
	 */
	void enterMethod(ClassParser.MethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#method}.
	 * @param ctx the parse tree
	 */
	void exitMethod(ClassParser.MethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link ClassParser#methodExpression}.
	 * @param ctx the parse tree
	 */
	void enterMethodExpression(ClassParser.MethodExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#methodExpression}.
	 * @param ctx the parse tree
	 */
	void exitMethodExpression(ClassParser.MethodExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ClassParser#methodHeader}.
	 * @param ctx the parse tree
	 */
	void enterMethodHeader(ClassParser.MethodHeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#methodHeader}.
	 * @param ctx the parse tree
	 */
	void exitMethodHeader(ClassParser.MethodHeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link ClassParser#modifier}.
	 * @param ctx the parse tree
	 */
	void enterModifier(ClassParser.ModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#modifier}.
	 * @param ctx the parse tree
	 */
	void exitModifier(ClassParser.ModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ClassParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(ClassParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(ClassParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code returnStatement}
	 * labeled alternative in {@link ClassParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(ClassParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code returnStatement}
	 * labeled alternative in {@link ClassParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(ClassParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variableDeclarationStatement}
	 * labeled alternative in {@link ClassParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarationStatement(ClassParser.VariableDeclarationStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variableDeclarationStatement}
	 * labeled alternative in {@link ClassParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarationStatement(ClassParser.VariableDeclarationStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignmentStatement}
	 * labeled alternative in {@link ClassParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentStatement(ClassParser.AssignmentStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignmentStatement}
	 * labeled alternative in {@link ClassParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentStatement(ClassParser.AssignmentStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifStatement}
	 * labeled alternative in {@link ClassParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(ClassParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifStatement}
	 * labeled alternative in {@link ClassParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(ClassParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TextModeStatement}
	 * labeled alternative in {@link ClassParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterTextModeStatement(ClassParser.TextModeStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TextModeStatement}
	 * labeled alternative in {@link ClassParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitTextModeStatement(ClassParser.TextModeStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whileLoop}
	 * labeled alternative in {@link ClassParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterWhileLoop(ClassParser.WhileLoopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whileLoop}
	 * labeled alternative in {@link ClassParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitWhileLoop(ClassParser.WhileLoopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forLoop}
	 * labeled alternative in {@link ClassParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterForLoop(ClassParser.ForLoopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forLoop}
	 * labeled alternative in {@link ClassParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitForLoop(ClassParser.ForLoopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionStatement}
	 * labeled alternative in {@link ClassParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(ClassParser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionStatement}
	 * labeled alternative in {@link ClassParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(ClassParser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ClassParser#ifteStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfteStatement(ClassParser.IfteStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#ifteStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfteStatement(ClassParser.IfteStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ClassParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(ClassParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(ClassParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ClassParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentExpression(ClassParser.AssignmentExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentExpression(ClassParser.AssignmentExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringLiteral}
	 * labeled alternative in {@link ClassParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(ClassParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringLiteral}
	 * labeled alternative in {@link ClassParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(ClassParser.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code charLiteral}
	 * labeled alternative in {@link ClassParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterCharLiteral(ClassParser.CharLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code charLiteral}
	 * labeled alternative in {@link ClassParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitCharLiteral(ClassParser.CharLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intLiteral}
	 * labeled alternative in {@link ClassParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterIntLiteral(ClassParser.IntLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intLiteral}
	 * labeled alternative in {@link ClassParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitIntLiteral(ClassParser.IntLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code doubleLiteral}
	 * labeled alternative in {@link ClassParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterDoubleLiteral(ClassParser.DoubleLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code doubleLiteral}
	 * labeled alternative in {@link ClassParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitDoubleLiteral(ClassParser.DoubleLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolLiteral}
	 * labeled alternative in {@link ClassParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterBoolLiteral(ClassParser.BoolLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolLiteral}
	 * labeled alternative in {@link ClassParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitBoolLiteral(ClassParser.BoolLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nullLiteral}
	 * labeled alternative in {@link ClassParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterNullLiteral(ClassParser.NullLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nullLiteral}
	 * labeled alternative in {@link ClassParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitNullLiteral(ClassParser.NullLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code postfixCrementExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPostfixCrementExpression(ClassParser.PostfixCrementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code postfixCrementExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPostfixCrementExpression(ClassParser.PostfixCrementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierExpression(ClassParser.IdentifierExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierExpression(ClassParser.IdentifierExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code qualifiedCallExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedCallExpression(ClassParser.QualifiedCallExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code qualifiedCallExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedCallExpression(ClassParser.QualifiedCallExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpression(ClassParser.NotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpression(ClassParser.NotExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lowPriorityNumbericalExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLowPriorityNumbericalExpression(ClassParser.LowPriorityNumbericalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lowPriorityNumbericalExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLowPriorityNumbericalExpression(ClassParser.LowPriorityNumbericalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code highPriorityNumbericalExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterHighPriorityNumbericalExpression(ClassParser.HighPriorityNumbericalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code highPriorityNumbericalExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitHighPriorityNumbericalExpression(ClassParser.HighPriorityNumbericalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code prefixCrementExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPrefixCrementExpression(ClassParser.PrefixCrementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code prefixCrementExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPrefixCrementExpression(ClassParser.PrefixCrementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code superExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSuperExpression(ClassParser.SuperExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code superExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSuperExpression(ClassParser.SuperExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code castExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCastExpression(ClassParser.CastExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code castExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCastExpression(ClassParser.CastExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression(ClassParser.AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression(ClassParser.AndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code prefixExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPrefixExpression(ClassParser.PrefixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code prefixExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPrefixExpression(ClassParser.PrefixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ampersandExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAmpersandExpression(ClassParser.AmpersandExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ampersandExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAmpersandExpression(ClassParser.AmpersandExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TextMode}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTextMode(ClassParser.TextModeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TextMode}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTextMode(ClassParser.TextModeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code superDelegation}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSuperDelegation(ClassParser.SuperDelegationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code superDelegation}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSuperDelegation(ClassParser.SuperDelegationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orderExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOrderExpression(ClassParser.OrderExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orderExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOrderExpression(ClassParser.OrderExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParExpression(ClassParser.ParExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParExpression(ClassParser.ParExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code thisDelegation}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterThisDelegation(ClassParser.ThisDelegationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code thisDelegation}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitThisDelegation(ClassParser.ThisDelegationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pipeExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPipeExpression(ClassParser.PipeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pipeExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPipeExpression(ClassParser.PipeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code shiftExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterShiftExpression(ClassParser.ShiftExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code shiftExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitShiftExpression(ClassParser.ShiftExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNewExpression(ClassParser.NewExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNewExpression(ClassParser.NewExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code classLiteral}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterClassLiteral(ClassParser.ClassLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code classLiteral}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitClassLiteral(ClassParser.ClassLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code neioNewExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNeioNewExpression(ClassParser.NeioNewExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code neioNewExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNeioNewExpression(ClassParser.NeioNewExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code selfCallExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSelfCallExpression(ClassParser.SelfCallExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code selfCallExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSelfCallExpression(ClassParser.SelfCallExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOrExpression(ClassParser.OrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOrExpression(ClassParser.OrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code chainExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterChainExpression(ClassParser.ChainExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code chainExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitChainExpression(ClassParser.ChainExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code selfExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSelfExpression(ClassParser.SelfExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code selfExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSelfExpression(ClassParser.SelfExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equalityExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression(ClassParser.EqualityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equalityExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression(ClassParser.EqualityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exponentiationExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExponentiationExpression(ClassParser.ExponentiationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exponentiationExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExponentiationExpression(ClassParser.ExponentiationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literalExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLiteralExpression(ClassParser.LiteralExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literalExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLiteralExpression(ClassParser.LiteralExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ClassParser#constructorCall}.
	 * @param ctx the parse tree
	 */
	void enterConstructorCall(ClassParser.ConstructorCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#constructorCall}.
	 * @param ctx the parse tree
	 */
	void exitConstructorCall(ClassParser.ConstructorCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link ClassParser#neioNewCall}.
	 * @param ctx the parse tree
	 */
	void enterNeioNewCall(ClassParser.NeioNewCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#neioNewCall}.
	 * @param ctx the parse tree
	 */
	void exitNeioNewCall(ClassParser.NeioNewCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code someArguments}
	 * labeled alternative in {@link ClassParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterSomeArguments(ClassParser.SomeArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code someArguments}
	 * labeled alternative in {@link ClassParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitSomeArguments(ClassParser.SomeArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code emptyArguments}
	 * labeled alternative in {@link ClassParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterEmptyArguments(ClassParser.EmptyArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code emptyArguments}
	 * labeled alternative in {@link ClassParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitEmptyArguments(ClassParser.EmptyArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ClassParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(ClassParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(ClassParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link ClassParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(ClassParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(ClassParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link ClassParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(ClassParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(ClassParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code typeArguments}
	 * labeled alternative in {@link ClassParser#typeArgumentList}.
	 * @param ctx the parse tree
	 */
	void enterTypeArguments(ClassParser.TypeArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code typeArguments}
	 * labeled alternative in {@link ClassParser#typeArgumentList}.
	 * @param ctx the parse tree
	 */
	void exitTypeArguments(ClassParser.TypeArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code typeArgument}
	 * labeled alternative in {@link ClassParser#typeArgumentList}.
	 * @param ctx the parse tree
	 */
	void enterTypeArgument(ClassParser.TypeArgumentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code typeArgument}
	 * labeled alternative in {@link ClassParser#typeArgumentList}.
	 * @param ctx the parse tree
	 */
	void exitTypeArgument(ClassParser.TypeArgumentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boundedTypeArgument}
	 * labeled alternative in {@link ClassParser#typeArgumentList}.
	 * @param ctx the parse tree
	 */
	void enterBoundedTypeArgument(ClassParser.BoundedTypeArgumentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boundedTypeArgument}
	 * labeled alternative in {@link ClassParser#typeArgumentList}.
	 * @param ctx the parse tree
	 */
	void exitBoundedTypeArgument(ClassParser.BoundedTypeArgumentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code typeParameter}
	 * labeled alternative in {@link ClassParser#typeParameterList}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameter(ClassParser.TypeParameterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code typeParameter}
	 * labeled alternative in {@link ClassParser#typeParameterList}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameter(ClassParser.TypeParameterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boundedTypeParameter}
	 * labeled alternative in {@link ClassParser#typeParameterList}.
	 * @param ctx the parse tree
	 */
	void enterBoundedTypeParameter(ClassParser.BoundedTypeParameterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boundedTypeParameter}
	 * labeled alternative in {@link ClassParser#typeParameterList}.
	 * @param ctx the parse tree
	 */
	void exitBoundedTypeParameter(ClassParser.BoundedTypeParameterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code typeParameters}
	 * labeled alternative in {@link ClassParser#typeParameterList}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameters(ClassParser.TypeParametersContext ctx);
	/**
	 * Exit a parse tree produced by the {@code typeParameters}
	 * labeled alternative in {@link ClassParser#typeParameterList}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameters(ClassParser.TypeParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link ClassParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(ClassParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ClassParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(ClassParser.IdentifierContext ctx);
}