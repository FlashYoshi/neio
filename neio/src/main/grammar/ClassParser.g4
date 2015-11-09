parser grammar ClassParser;

options { tokenVocab = ClassLexer; }

document : HEADER
           body
           EOF;

body : classBody
     | interfaceBody;

classBody : extension*
            (field | method)*;

interfaceBody : STUB;

////////////UTIL////////////
extension : ( EXTENDS chain
            | IMPLEMENTS chain)
            SEMICOLON;

field : var SEMICOLON;
fieldName : CLASS_NAME
          | VAR_WITH_TYPE;
var : fieldName CAMEL_CASE;

arguments : (var COMMA)* var
          | ;

parameter : CAMEL_CASE
          | methodCall;
parameters : (parameter COMMA)* parameter
           | ;

method : METHOD_OPTION? decl L_CURLY_BRACE block? R_CURLY_BRACE;
decl : methodName L_BRACE arguments R_BRACE;
call : methodName L_BRACE parameters R_BRACE;
methodName: CLASS_NAME
          | CAMEL_CASE
          | METHOD_NAME;

block : statement+
        returnCall?;

statement : ( assignment
            | methodCall
            | newCall)
            SEMICOLON;

methodCall : ((CLASS_NAME | CAMEL_CASE) (SEMICOLON | PERIOD))? call;

assignment : (thisChain | var | CAMEL_CASE) EQUALS (CAMEL_CASE | thisChain | methodCall);
thisChain : (THIS PERIOD)? (chain | (CLASS_NAME | CAMEL_CASE));

chain : (CLASS_NAME | CAMEL_CASE) (PERIOD (CLASS_NAME | CAMEL_CASE))+;

newCall : NEW (CLASS_NAME | VAR_WITH_TYPE) L_BRACE parameters R_BRACE CAMEL_CASE
        | (var | CAMEL_CASE) EQUALS NEW CLASS_NAME L_BRACE parameters R_BRACE;

returnCall : ( RETURN statement
             | RETURN CAMEL_CASE
             | RETURN methodCall)
             SEMICOLON;
