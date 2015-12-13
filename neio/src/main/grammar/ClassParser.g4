parser grammar ClassParser;

options { tokenVocab = ClassLexer; }

document : namespace
           classDef
           body
           EOF;

namespace : NAMESPACE namespaceReference SCOLON;
namespaceReference : Identifier (DOT Identifier)*;

classDef : HEADER Identifier inheritance*;
inheritance : ( EXTENDS type
              | IMPLEMENTS type)
              SCOLON;

body : classBody
     | interfaceBody
     | ;

classBody : ( fieldDecl SCOLON
            | fieldAssignmentExpression SCOLON
            | method)+;

interfaceBody : (methodExpression SCOLON)+;

fieldDecl : modifier? type Identifier;
fieldAssignmentExpression : var=fieldDecl EQUALS val=expression;

method : methodExpression LC_BRACE block RC_BRACE;
methodExpression : modifier* methodHeader L_BRACE parameters? R_BRACE;
methodHeader : returnType=type? name=(Identifier | MethodIdentifier);
modifier : PROTECTED
         | PUBLIC
         | NESTED;

block : statement*;
statement : expression SCOLON           #expressionStatement
          | RETURN expression SCOLON    #returnStatement
          | neioNewCall SCOLON          #newStatement
          | assignmentExpression SCOLON #assignmentStatement
          | variableDeclaration SCOLON  #variableDeclarationStatement
          | FOR L_BRACE init=variableDeclaration SCOLON cond=expression SCOLON update=assignmentExpression R_BRACE LC_BRACE block RC_BRACE #forLoop
          ;
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
           | L_BRACE expression R_BRACE #parExpression
           | SUPER                      #superExpression
           | THIS                       #selfExpression
           | Identifier                 #identifierExpression
		   | constructorCall	        #newExpression
           | expression DOT Identifier  #chainExpression
           | expression DOT name=(Identifier | MethodIdentifier) args=arguments #qualifiedCallExpression
           | name=Identifier args=arguments #selfCallExpression
           | left=expression op=HAT right=expression #exponentiationExpression
           | left=expression op=(STAR|SLASH|PERCENT) right=expression #highPriorityNumbericalExpression
           | left=expression op=(PLUS|MINUS) right=expression #lowPriorityNumbericalExpression
           | left=expression op=(L_SHIFT | RR_SHIFT | R_SHIFT) right=expression #shiftExpression
           | left=expression op=(LEQ | GEQ | BIGGER | SMALLER) right=expression #orderExpression
           | left=expression op=(EQUAL | NOT_EQUAL) right=expression #equalityExpression
           | left=expression op=AMPERSAND right=expression #ampersandExpression
           | left=expression op=PIPE right=expression #pipeExpression
           | left=expression op=AND right=expression #andExpression
           | left=expression op=OR right=expression #orExpression
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