parser grammar ClassParser;

options { tokenVocab = ClassLexer; }

document : namespace
           importDeclaration*
           classDef
           body
           EOF;

namespace : NAMESPACE namespaceReference SCOLON;
namespaceReference : Identifier (DOT Identifier)*;

importDeclaration : IMPORT type (DOT STAR)? SCOLON;

classDef : header Identifier inheritance* SCOLON;
header : CLASS | INTERFACE;
inheritance : ( EXTENDS type
              | IMPLEMENTS type);

body : ( fieldDecl SCOLON
       | fieldAssignmentExpression SCOLON
       | (methodExpression SCOLON | method))+
       | ;

fieldDecl : modifier? type Identifier;
fieldAssignmentExpression : var=fieldDecl EQUALS val=expression;

method : methodExpression block;
methodExpression : modifier* methodHeader L_BRACE parameters? R_BRACE;
methodHeader : (type | VOID)? name=(Identifier | MethodIdentifier | STAR);
modifier : PROTECTED
         | PUBLIC
         | NESTED;

block : LC_BRACE statement* RC_BRACE;
statement : expression SCOLON           #expressionStatement
          | RETURN expression SCOLON    #returnStatement
          | neioNewCall SCOLON          #newStatement
          | assignmentExpression SCOLON #assignmentStatement
          | variableDeclaration SCOLON  #variableDeclarationStatement
          | ifteStatement               #ifStatement
          | FOR L_BRACE init=variableDeclaration SCOLON cond=expression SCOLON update=assignmentExpression R_BRACE block #forLoop
          ;

ifteStatement : IF L_BRACE ifCondition=expression R_BRACE ifBlock=block (ELSE (elseBlock=block | elif=ifteStatement))?;

variableDeclaration : type Identifier (EQUALS expression);
assignmentExpression : var=expression EQUALS val=expression;

literal : StringLiteral     #stringLiteral
        | CharLiteral       #charLiteral
        | Integer           #intLiteral
        | Double            #doubleLiteral
        | (TRUE | FALSE)    #boolLiteral
        | NULL              #nullLiteral
        ;

expression : literal                    #literalExpression
           | SUPER                      #superExpression
           | THIS                       #selfExpression
           | Identifier                 #identifierExpression
		   | constructorCall	        #newExpression
           | expression DOT Identifier  #chainExpression
           | L_BRACE expression R_BRACE #parExpression
           | expression DOT name=(Identifier | MethodIdentifier | STAR) args=arguments #qualifiedCallExpression
           | name=Identifier args=arguments                                     #selfCallExpression
           | left=expression op=OR right=expression                             #orExpression
           | left=expression op=AND right=expression                            #andExpression
           | left=expression op=HAT right=expression                            #exponentiationExpression
           | left=expression op=PIPE right=expression                           #pipeExpression
           | left=expression op=AMPERSAND right=expression                      #ampersandExpression
           | left=expression op=(PLUS|MINUS) right=expression                   #lowPriorityNumbericalExpression
           | left=expression op=(EQUAL | NOT_EQUAL) right=expression            #equalityExpression
           | left=expression op=(STAR|SLASH|PERCENT) right=expression           #highPriorityNumbericalExpression
           | left=expression op=(L_SHIFT | RR_SHIFT | R_SHIFT) right=expression #shiftExpression
           | left=expression op=(LEQ | GEQ | BIGGER | SMALLER) right=expression #orderExpression
           ;

constructorCall : NEW type arguments;
neioNewCall : NEW type arguments Identifier;

arguments : L_BRACE expression (COMMA expression)* R_BRACE #someArguments
          | L_BRACE R_BRACE #emptyArguments
          ;

parameters : parameter (COMMA parameter)*;
parameter : type Identifier;

type : Identifier (DOT Identifier)* (SMALLER typeArgumentList BIGGER)?;
typeArgumentList : typeArgumentList COMMA Identifier #typeArguments
                  | Identifier                       #typeArgument
                  ;