parser grammar ClassParser;

options { tokenVocab = ClassLexer; }

document : namespace
           HEADER CLASS_NAME
           body
           EOF;

body : classBody
     | interfaceBody;

classBody : inheritance*
            (field | method)*;

interfaceBody : STUB;

namespace: NAMESPACE chain SEMICOLON;

////////////UTIL////////////
inheritance : ( EXTENDS chain
            | IMPLEMENTS chain)
            SEMICOLON;

field : var SEMICOLON;
fieldName : CLASS_NAME
          | VAR_WITH_TYPE;
var : fieldName CAMEL_CASE;

arguments : (var COMMA)* var
          | ;

parameter : CAMEL_CASE (DIGIT+)?
          | methodCall
          | DIGIT+;
parameters : (parameter COMMA)* parameter
           | ;

method : MODIFIER? decl L_CURLY_BRACE block? R_CURLY_BRACE;
decl : CLASS_NAME? methodName L_BRACE arguments R_BRACE;
call : methodName L_BRACE parameters R_BRACE;
methodName: CLASS_NAME
          | CAMEL_CASE
          | METHOD_NAME;

block : statement+
        returnCall?;

statement : ( assignment
            | methodCall
            | newAssignment)
            SEMICOLON;

methodCall : (chain PERIOD)? call;

assignment : (thisChain | var | CAMEL_CASE) EQUALS (CAMEL_CASE | thisChain | methodCall);
thisChain : (THIS PERIOD)? (chain PERIOD | (CLASS_NAME | CAMEL_CASE));

chain : (CLASS_NAME | CAMEL_CASE) (PERIOD (CLASS_NAME | CAMEL_CASE))*;

newAssignment : newCall CAMEL_CASE
              | (var | CAMEL_CASE) EQUALS newCall;

newCall : NEW (CLASS_NAME | VAR_WITH_TYPE) L_BRACE parameters R_BRACE;

returnCall : ( RETURN newCall
             | RETURN CAMEL_CASE
             | RETURN methodCall)
             SEMICOLON;
