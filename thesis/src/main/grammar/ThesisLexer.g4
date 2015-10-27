lexer grammar ThesisLexer;

HEADER : '[' HEADER_CONTENT ']';
fragment HEADER_CONTENT : ~[\[\]]+;

COMMENT : '//' ~[\r\n]* -> channel(HIDDEN);
MULTILINE_COMMENT : '/*' .*? '*/' -> channel(HIDDEN);

fragment WORD : ~[\r\n\t ]+;
fragment WORDS : WORD+;
PACKAGE : [a-z]+ (PERIOD[a-z]+)+;
WS : [\t ] -> channel(HIDDEN);
NEWLINE : '\r'? '\n' -> skip;
CAPITAL : [A-Z];
LETTER : [a-z];


////////////START KEYWORDS////////////
EXTENDS : 'extends';
IMPLEMENTS : 'implements';
RETURN : 'return';
NEW : 'new';
METHOD_OPTION : 'builder'
               | 'regex'
               | 'util';
STUB : 'stub';
////////////END KEYWORDS////////////


fragment CAPITALED : CAPITAL LETTER+;
CLASS_NAME : CAPITALED+;
CAMEL_CASE : LETTER+ CAPITALED*;
VAR_WITH_TYPE : CLASS_NAME (SMALLER VAR_WITH_TYPE BIGGER)?;

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


METHOD_NAME : ~[()\r\n \t;]+;