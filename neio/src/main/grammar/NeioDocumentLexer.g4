lexer grammar NeioDocumentLexer;

HEADER : L_SQ_BRACE CHAR+ R_SQ_BRACE;
COMMENT : '//' ~[\r\n]* NL+ -> channel(HIDDEN);
MULTILINE_COMMENT : '/*' .*? '*/' NL+ -> channel(HIDDEN);

WS : [\t ] -> channel(HIDDEN);
NL : '\r'? '\n';
fragment CHAR : [a-zA-Z0-9];
fragment VALID_CHAR : [a-zA-Z0-9.,!?'];

STUB : 'stub';

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
HASH : '#';
L_BRACE : '(';
R_BRACE : ')';
L_CURLY_BRACE : '{';
R_CURLY_BRACE : '}';
L_SQ_BRACE : '[';
R_SQ_BRACE : ']';
DOUBLE_QUOTE : '"';

WORD : VALID_CHAR+;