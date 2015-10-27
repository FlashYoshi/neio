parser grammar ThesisParser;

options { tokenVocab = ThesisLexer; }

document : HEADER
           body
           EOF;

body : classBody
     | interfaceBody
     | scriptBody;

classBody : extension*
            (field | method)*;

interfaceBody : STUB;

scriptBody : STUB;

////////////UTIL////////////
extension : ( EXTENDS PACKAGE
            | IMPLEMENTS PACKAGE)
            SEMICOLON;

field : var SEMICOLON;
fieldName : CLASS_NAME
          | VAR_WITH_TYPE;
var : fieldName CAMEL_CASE;

method : METHOD_OPTION? call LEFT_CURLY_BRACE block? RIGHT_CURLY_BRACE;
call : methodName LEFT_BRACE arguments RIGHT_BRACE;
methodName: CLASS_NAME
          | CAMEL_CASE
          | METHOD_NAME;

arguments : (var COMMA)* var
          | ;

block : statement+
        returnCall?;

statement : ( assignment
            | methodCall
            | newCall)
            SEMICOLON;

methodCall : (CLASS_NAME | CAMEL_CASE) (SEMICOLON | PERIOD) call;

assignment : var EQUALS CAMEL_CASE
           | CAMEL_CASE EQUALS CAMEL_CASE;

newCall : NEW VAR_WITH_TYPE LEFT_BRACE arguments RIGHT_BRACE CAMEL_CASE
        | (var | CAMEL_CASE) EQUALS NEW CLASS_NAME LEFT_BRACE arguments RIGHT_BRACE;

returnCall : ( RETURN statement
             | RETURN CAMEL_CASE)
             SEMICOLON;
