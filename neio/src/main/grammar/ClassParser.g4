/*
[The BSD License]
Copyright (c) 2012 Terence Parr and Sam Harwell
All rights reserved.

Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:

    Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
    Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
    Neither the name of the author nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY
EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL
THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF
THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
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

classDef : ABSTRACT? header Identifier inheritance* SCOLON;
header : CLASS | INTERFACE;
inheritance : ( EXTENDS type
              | IMPLEMENTS type);

body : ( fieldDecl SCOLON
       | fieldAssignmentExpression SCOLON
       | (methodExpression SCOLON | method))+
       | ;

fieldDecl : modifier* type Identifier;
fieldAssignmentExpression : var=fieldDecl EQUALS val=expression;

method : methodExpression block;
methodExpression : modifier* methodHeader L_BRACE parameters? R_BRACE;
methodHeader : (SMALLER typeParameterList BIGGER)? (rtype=type | vd=VOID)? name=(Identifier | MethodIdentifier | STAR | MINUS | PIPE | HAT | EQUALS);
modifier : ABSTRACT
         | PRIVATE
         | PROTECTED
         | PUBLIC
         | FINAL
         | STATIC
         | NESTED
         | SURROUND;

block : LC_BRACE statement* RC_BRACE;
statement : RETURN expression? SCOLON   #returnStatement
          | variableDeclaration SCOLON  #variableDeclarationStatement
          | assignmentExpression SCOLON #assignmentStatement
          | ifteStatement               #ifStatement
          | StringLiteral               #TextModeStatement
          | WHILE L_BRACE expression R_BRACE (block | SCOLON) #whileLoop
          | FOR L_BRACE init=variableDeclaration SCOLON cond=expression SCOLON update=assignmentExpression R_BRACE block #forLoop
          | expression SCOLON           #expressionStatement
          ;

ifteStatement : IF L_BRACE ifCondition=expression R_BRACE ifBlock=block (ELSE (elseBlock=block | elif=ifteStatement))?;

variableDeclaration : neioNewCall
                    | type Identifier (EQUALS expression);
assignmentExpression : var=expression EQUALS val=expression;

literal : StringLiteral     #stringLiteral
        | CharLiteral       #charLiteral
        | Integer           #intLiteral
        | Double            #doubleLiteral
        | (TRUE | FALSE)    #boolLiteral
        | NULL              #nullLiteral
        ;

expression : literal                            #literalExpression
           | TextMode                           #TextMode
           | L_BRACE type R_BRACE expression    #castExpression
           | Identifier DOT CLASS               #classLiteral
           | SUPER                              #superExpression
           | SUPER arguments                    #superDelegation
           | THIS                               #selfExpression
           | THIS arguments                     #thisDelegation
           | Identifier                         #identifierExpression
           | constructorCall                    #newExpression
           | neioNewCall                        #neioNewExpression
           | expression DOT Identifier          #chainExpression
           | L_BRACE expression R_BRACE         #parExpression
           | expression DOT name=(Identifier | NAMESPACE | MethodIdentifier | STAR| MINUS | EQUALS | HAT) args=arguments #qualifiedCallExpression
           | name=(Identifier | NAMESPACE | MethodIdentifier | STAR | MINUS | EQUALS | HAT) args=arguments #selfCallExpression
           | op=E_MARK right=expression                                         #notExpression
           | left=expression op=(INCR | DECR)                                   #postfixCrementExpression
           | op=(INCR | DECR) right=expression                                  #prefixCrementExpression
           | op=(PLUS | MINUS) right=expression                                 #prefixExpression
           | left=expression op=OR right=expression                             #orExpression
           | left=expression op=AND right=expression                            #andExpression
           | left=expression op=HAT right=expression                            #exponentiationExpression
           | left=expression op=PIPE right=expression                           #pipeExpression
           | left=expression op=AMPERSAND right=expression                      #ampersandExpression
           | left=expression op=(EQUAL | NOT_EQUAL) right=expression            #equalityExpression
           | left=expression op=(STAR | SLASH | PERCENT) right=expression       #highPriorityNumbericalExpression
           | left=expression op=(PLUS | MINUS) right=expression                 #lowPriorityNumbericalExpression
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

type : identifier (DOT identifier)* (SMALLER typeArgumentList BIGGER)? (ARRAY)?;
typeArgumentList : typeArgumentList COMMA type  #typeArguments
                 | type                         #typeArgument
                 | Q_MARK EXTENDS bound=type    #boundedTypeArgument
                 ;

typeParameterList : typeParameterList COMMA type  #typeParameters
                  | type                          #typeParameter
                  | Identifier EXTENDS bound=type #boundedTypeParameter
                  ;

identifier : Identifier | NAMESPACE;