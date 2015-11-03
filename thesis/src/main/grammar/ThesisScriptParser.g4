parser grammar ThesisScriptParser;

options { tokenVocab = ThesisScriptLexer; }

document : SCRIPT
           scriptBody
           EOF;

scriptBody : statement+
           | ;

statement : ( assignment
            | methodCall
            | newCall);

assignment : (chain | var | CAMEL_CASE) EQUALS (CAMEL_CASE | chain | methodCall);

methodCall : (CLASS_NAME | CAMEL_CASE)? call+;

newCall : ( NEW (CLASS_NAME | VAR_WITH_TYPE) LEFT_BRACE parameters RIGHT_BRACE CAMEL_CASE
          | (var | CAMEL_CASE) EQUALS NEW CLASS_NAME LEFT_BRACE parameters RIGHT_BRACE);

////////////UTIL////////////

field : var SEMICOLON;
var : fieldName CAMEL_CASE;
fieldName : CLASS_NAME
          | VAR_WITH_TYPE;

arguments : (var COMMA)* var
          | ;

parameter : STRING
          | CAMEL_CASE
          | methodCall;
parameters : (parameter COMMA)* parameter
           | ;

call : (COLON | PERIOD) methodName LEFT_BRACE parameters RIGHT_BRACE;
methodName: CLASS_NAME
          | CAMEL_CASE
          | METHOD_NAME;

chain : (CLASS_NAME | CAMEL_CASE) (PERIOD (CLASS_NAME | CAMEL_CASE))+;