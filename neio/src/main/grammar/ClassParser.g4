parser grammar ClassParser;

options { tokenVocab = ClassLexer; }

document : namespace
           HEADER CLASS_NAME
           inheritance*
           body
           EOF;

body : classBody
     | interfaceBody;

classBody : (field | method)*;

interfaceBody : (decl SEMICOLON)*;

namespace: NAMESPACE chain SEMICOLON;

////////////UTIL////////////
inheritance : ( EXTENDS chain
              | IMPLEMENTS chain)
              SEMICOLON;

field : var SEMICOLON;
genericArg : CLASS_NAME | genericType;
genericArgs : genericArg (COMMA genericArg)*;
genericType : CLASS_NAME SMALLER genericArgs BIGGER;
fieldName : CLASS_NAME
          | genericType;
var : fieldName CAMEL_CASE;

arguments : (var COMMA)* var
          | ;

parameter : CAMEL_CASE (DIGIT+)?
          | methodCall
          | literal;
parameters : (parameter COMMA)* parameter
           | ;

literal : STRING_LITERAL
        | integer;

integer : DIGIT+;

method : MODIFIER? decl L_CURLY_BRACE block R_CURLY_BRACE;
decl : CLASS_NAME? methodName L_BRACE arguments R_BRACE;
call : methodName L_BRACE parameters R_BRACE;
methodName: CLASS_NAME
          | CAMEL_CASE
          | METHOD_NAME;

block : statement*
        returnCall?
        | ;

statement : ( assignment
            | methodCall
            | newAssignment
            | forloop)
            SEMICOLON;

forloop: FOR L_BRACE forDecl R_BRACE L_CURLY_BRACE block R_CURLY_BRACE;
forDecl : INT CAMEL_CASE EQUALS (integer | methodCall) SEMICOLON comparison SEMICOLON assignment;
comparison : CAMEL_CASE operator (integer | methodCall);

operator : SMALLER
         | BIGGER
         | EQUALS EQUALS;

methodCall : (thisChain PERIOD)? call;

assignment : (thisChain | var | CAMEL_CASE) EQUALS (CAMEL_CASE | methodCall | literal) (PLUS (CAMEL_CASE | methodCall | literal))*;
thisChain : ((THIS | SUPER) PERIOD)? chain;

chain : (CLASS_NAME | CAMEL_CASE | call) (PERIOD (CLASS_NAME | CAMEL_CASE | call))*;

newAssignment : newCall CAMEL_CASE
              | (var | CAMEL_CASE) EQUALS newCall;

newCall : NEW (CLASS_NAME | genericType) L_BRACE parameters R_BRACE;

returnCall : RETURN
             returnIntern
             (PLUS returnIntern)*
             SEMICOLON;

returnIntern : ( newCall
               | CAMEL_CASE
               | methodCall
               | literal);
