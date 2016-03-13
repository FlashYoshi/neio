lexer grammar DocumentLexer;

HEADER : LS_BRACE CHAR+ RS_BRACE;
COMMENT : '//' ~[\r\n]* NL+ -> channel(HIDDEN);
MULTILINE_COMMENT : '/*' .*? '*/' NL+ -> channel(HIDDEN);

INLINE_CODE : DB_QUOTE .+? DB_QUOTE;
CODE : B_QUOTE .+? B_QUOTE;
TAG : LC_BRACE .+? RC_BRACE;

ESCAPE : B_SLASH .;
CC : B_SLASH CHAR CHAR+;

WS : [\t ] -> channel(HIDDEN);
NL : '\r'? '\n';
fragment CHAR : [a-zA-Z0-9];
fragment VALID_CHAR : [a-zA-Z0-9.,!?"'];

STUB : 'stub';

LS_BRACE : '[';
RS_BRACE : ']';
L_BRACE : '(';
R_BRACE : ')';
LC_BRACE : '{';
RC_BRACE : '}';
fragment B_QUOTE : '`';
fragment DB_QUOTE : '``';
fragment B_SLASH : '\\';

fragment HASH : '#';
fragment DASH : '-';
fragment STAR : '*';
BANG : '!';
MethodName : HASH | DASH | STAR;

WORD : VALID_CHAR+;

UNKNOWN : . ;
