lexer grammar NeioScriptLexer;

COMMENT : '//' ~[\r\n]* -> channel(HIDDEN);
MULTILINE_COMMENT : '/*' .*? '*/' -> channel(HIDDEN);

WS : [\t ] -> channel(HIDDEN);
NL : '\r'? '\n' -> skip;
fragment CAPITAL : [A-Z];
fragment LETTER : [a-z];
fragment CHAR : [a-zA-Z0-9];


////////////START KEYWORDS////////////
NEW : 'new';
SCRIPT : 'script';
STUB : 'stub';
////////////END KEYWORDS////////////


fragment CAPITALED : CAPITAL LETTER+;
CLASS_NAME : CAPITALED+;
CAMEL_CASE : LETTER+ CAPITALED*;
VAR_WITH_TYPE : CLASS_NAME (SMALLER VAR_WITH_TYPE BIGGER)?;
STRING : DOUBLE_QUOTE .*? DOUBLE_QUOTE;

PERIOD : '.';
COMMA : ',';
COLON : ':';
SEMICOLON : ';';
EQUALS : '=';
PLUS : '+';
MINUS : '-';
STAR : '*';
SMALLER : '<';
BIGGER : '>';
LEFT_BRACE : '(';
RIGHT_BRACE : ')';
LEFT_CURLY_BRACE : '{';
RIGHT_CURLY_BRACE : '}';
DOUBLE_QUOTE : '"';

METHOD_NAME : ~[()\r\n \t;.,:]+;