// Generated from B:\Documents\GitHub\neio\neio\src\main\grammar\ClassParser.g4 by ANTLR 4.5
package org.neio.antlr;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ClassParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ClassParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ClassParser#document}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDocument(ClassParser.DocumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClassParser#namespace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamespace(ClassParser.NamespaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClassParser#namespaceReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamespaceReference(ClassParser.NamespaceReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClassParser#importDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportDeclaration(ClassParser.ImportDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClassParser#classDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDef(ClassParser.ClassDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClassParser#header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeader(ClassParser.HeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClassParser#inheritance}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInheritance(ClassParser.InheritanceContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClassParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(ClassParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClassParser#fieldDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDecl(ClassParser.FieldDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClassParser#fieldAssignmentExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldAssignmentExpression(ClassParser.FieldAssignmentExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClassParser#method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod(ClassParser.MethodContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClassParser#methodExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodExpression(ClassParser.MethodExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClassParser#methodHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodHeader(ClassParser.MethodHeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClassParser#modifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifier(ClassParser.ModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClassParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(ClassParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code returnStatement}
	 * labeled alternative in {@link ClassParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(ClassParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variableDeclarationStatement}
	 * labeled alternative in {@link ClassParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarationStatement(ClassParser.VariableDeclarationStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignmentStatement}
	 * labeled alternative in {@link ClassParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStatement(ClassParser.AssignmentStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifStatement}
	 * labeled alternative in {@link ClassParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(ClassParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TextModeStatement}
	 * labeled alternative in {@link ClassParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextModeStatement(ClassParser.TextModeStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whileLoop}
	 * labeled alternative in {@link ClassParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileLoop(ClassParser.WhileLoopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forLoop}
	 * labeled alternative in {@link ClassParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForLoop(ClassParser.ForLoopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionStatement}
	 * labeled alternative in {@link ClassParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement(ClassParser.ExpressionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClassParser#ifteStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfteStatement(ClassParser.IfteStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClassParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(ClassParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClassParser#assignmentExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentExpression(ClassParser.AssignmentExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringLiteral}
	 * labeled alternative in {@link ClassParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(ClassParser.StringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code charLiteral}
	 * labeled alternative in {@link ClassParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharLiteral(ClassParser.CharLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intLiteral}
	 * labeled alternative in {@link ClassParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntLiteral(ClassParser.IntLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code doubleLiteral}
	 * labeled alternative in {@link ClassParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleLiteral(ClassParser.DoubleLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolLiteral}
	 * labeled alternative in {@link ClassParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolLiteral(ClassParser.BoolLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nullLiteral}
	 * labeled alternative in {@link ClassParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullLiteral(ClassParser.NullLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code postfixCrementExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixCrementExpression(ClassParser.PostfixCrementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierExpression(ClassParser.IdentifierExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code qualifiedCallExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifiedCallExpression(ClassParser.QualifiedCallExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpression(ClassParser.NotExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lowPriorityNumbericalExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLowPriorityNumbericalExpression(ClassParser.LowPriorityNumbericalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code highPriorityNumbericalExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHighPriorityNumbericalExpression(ClassParser.HighPriorityNumbericalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code prefixCrementExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixCrementExpression(ClassParser.PrefixCrementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code superExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuperExpression(ClassParser.SuperExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code castExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastExpression(ClassParser.CastExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpression(ClassParser.AndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code prefixExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixExpression(ClassParser.PrefixExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ampersandExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAmpersandExpression(ClassParser.AmpersandExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TextMode}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextMode(ClassParser.TextModeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code superDelegation}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuperDelegation(ClassParser.SuperDelegationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orderExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrderExpression(ClassParser.OrderExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParExpression(ClassParser.ParExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code thisDelegation}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThisDelegation(ClassParser.ThisDelegationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pipeExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPipeExpression(ClassParser.PipeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code shiftExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShiftExpression(ClassParser.ShiftExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewExpression(ClassParser.NewExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code classLiteral}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassLiteral(ClassParser.ClassLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code neioNewExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNeioNewExpression(ClassParser.NeioNewExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code selfCallExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelfCallExpression(ClassParser.SelfCallExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpression(ClassParser.OrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code chainExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChainExpression(ClassParser.ChainExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code selfExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelfExpression(ClassParser.SelfExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equalityExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpression(ClassParser.EqualityExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exponentiationExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExponentiationExpression(ClassParser.ExponentiationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code literalExpression}
	 * labeled alternative in {@link ClassParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralExpression(ClassParser.LiteralExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClassParser#constructorCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorCall(ClassParser.ConstructorCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClassParser#neioNewCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNeioNewCall(ClassParser.NeioNewCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code someArguments}
	 * labeled alternative in {@link ClassParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSomeArguments(ClassParser.SomeArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code emptyArguments}
	 * labeled alternative in {@link ClassParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyArguments(ClassParser.EmptyArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClassParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(ClassParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClassParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(ClassParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClassParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(ClassParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typeArguments}
	 * labeled alternative in {@link ClassParser#typeArgumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArguments(ClassParser.TypeArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typeArgument}
	 * labeled alternative in {@link ClassParser#typeArgumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArgument(ClassParser.TypeArgumentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boundedTypeArgument}
	 * labeled alternative in {@link ClassParser#typeArgumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoundedTypeArgument(ClassParser.BoundedTypeArgumentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typeParameter}
	 * labeled alternative in {@link ClassParser#typeParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameter(ClassParser.TypeParameterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boundedTypeParameter}
	 * labeled alternative in {@link ClassParser#typeParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoundedTypeParameter(ClassParser.BoundedTypeParameterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typeParameters}
	 * labeled alternative in {@link ClassParser#typeParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameters(ClassParser.TypeParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClassParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(ClassParser.IdentifierContext ctx);
}