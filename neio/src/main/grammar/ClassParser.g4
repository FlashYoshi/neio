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

classBody : ( decl SCOLON
            | assignmentExpression SCOLON
            | method)+;

interfaceBody : (methodHeader SCOLON)+;

method : methodHeader LC_BRACE block RC_BRACE;
methodHeader : modifier returnType=type? name=(Identifier | MethodIdentifier) arguments;
modifier : NESTED
         | ;

block : statement*;
statement : expression SCOLON           #expressionStatement
          | RETURN expression SCOLON    #returnStatement
          | assignmentExpression SCOLON #assignStatement
          | FOR L_BRACE assignmentExpression SCOLON expression SCOLON assignmentExpression R_BRACE LC_BRACE block RC_BRACE #forLoop
          ;
assignmentExpression : var=expression EQUALS val=expression;

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

newCall : NEW (expression DOT)? type arguments              #javaNewCall
        | NEW (expression DOT)? type arguments Identifier   #neioNewCall
        ;
arguments : L_BRACE expression (COMMA expression)* R_BRACE #someArguments
          | L_BRACE R_BRACE #emptyArguments
          ;

type : Identifier (DOT Identifier)* (SMALLER typeParameterList BIGGER)?;
typeParameterList : typeParameterList COMMA Identifier #typeParameters
                  | Identifier                         #typeParameter
                  ;

decl : type Identifier;