lexer grammar ClassLexer;

HEADER : HEADER_CONTENT;
fragment HEADER_CONTENT : CLASS | INTERFACE;

COMMENT : '//' ~[\r\n]* -> channel(HIDDEN);
MULTILINE_COMMENT : '/*' .*? '*/' -> channel(HIDDEN);

WS : [\t ] -> channel(HIDDEN);
NEWLINE : '\r'? '\n' -> skip;
fragment CAPITAL : [A-Z];
fragment LETTER : [a-z];
fragment CHAR : [a-zA-Z0-9];


////////////START KEYWORDS////////////
EXTENDS : 'extends';
IMPLEMENTS : 'implements';
CLASS : 'class';
INTERFACE : 'interface';
RETURN : 'return';
NEW : 'new';
THIS : 'this';
FOR : 'for';
SUPER : 'super';
MODIFIER : 'nested';
NAMESPACE : 'namespace';
INT : 'int';
STUB : 'stub';
////////////END KEYWORDS////////////

fragment N_D_QUOTE : ~["];
STRING_LITERAL : D_QUOTE N_D_QUOTE* D_QUOTE;

fragment CAPITALED : CAPITAL LETTER+;
CLASS_NAME : CAPITALED+;
CAMEL_CASE : LETTER+ CAPITALED*;

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
L_BRACE : '(';
R_BRACE : ')';
L_CURLY_BRACE : '{';
R_CURLY_BRACE : '}';
D_QUOTE : '"';
DIGIT : [0-9];

METHOD_NAME : ~[()\r\n \t;.,:<>]+;