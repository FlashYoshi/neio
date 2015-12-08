parser grammar ClassParser;

options { tokenVocab = ClassLexer; }

document : package
           classDef
           body
           EOF;

package : PACKAGE identifier;
identifier : Identifier (DOT Identifier)*;

classDef : HEADER Identifier inheritance*;
inheritance : ( EXTENDS identifier
              | IMPLEMENTS identifier)
              SCOLON;

body : classBody
     | interfaceBody
     | ;

classBody : decl | method;

interfaceBody : method SCOLON;

method : modifier return=Identifier name=(Identifier | MethodIdentifier) arguments LC_BRACE block RC_BRACE;
modifier : NESTED
         | ;

block : statement*;
statement : expression SCOLON
          | RETURN expression SCOLON
          | var=expression EQUALS val=expression SEMI #assignmentStatement
          | VAR Identifier COLON type ( ASSIGN expression)? SEMI # varDeclaration
          ;

literal : StringLiteral     #stringLiteral
        | CharLiteral       #charLiteral
        | Integer           #intLiteral
        | Double            #doubleLiteral
        | (TRUE | FALSE)    #boolLiteral
        | NULL              #nullLiteral
        ;

expression : literal                    #literalExpression
           | decl                       #declExpression
           | newCall                    #newExpression
           | L_BRACE expression R_BRACE #parExpression
           | SUPER                      #superExpression
           | THIS                       #selfExpression
           | Identifier                 #identifierExpression
           | expression DOT name=(Identifier | MethodIdentifier) args=arguments #qualifiedCallExpression
           | name=Identifier args=arguments #selfCallExpression
           | left=expression op=HAT right=expression #exponentiationExpression
           | left=expression op=(STAR|SLASH|PERCENT) right=expression #highPriorityNumbericalExpression
           | left=expression op=(PLUS|MINUS) right=expression #lowPriorityNumbericalExpression
           | left=expression op=(L_SHIFT | RR_SHIFT | R_SHIFT) right=expression #shiftExpression
           | left=expression op=(SEQ | GEQ | BIGGER | SMALLER) right=expression #orderExpression
           | left=expression op=(EQUAL | NOT_EQUAL) right=expression #equalityExpression
           | left=expression op=AMPERSAND right=expression #ampersandExpression
           | left=expression op=PIPE right=expression #pipeExpression
           | left=expression op=AND right=expression #andExpression
           | left=expression op=OR right=expression #orExpression
           ;

newCall : NEW expression DOT (Identifier | MethodIdentifier) arguments;
arguments : L_BRACE expression (COMMA expression)* R_BRACE #someArguments
          | L_BRACE R_BRACE #emptyArguments
          ;

decl : Identifier Identifier;