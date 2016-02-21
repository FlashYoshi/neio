lexer grammar DocumentLexer;

HEADER : LS_BRACE CHAR+ RS_BRACE;
COMMENT : '//' ~[\r\n]* NL+ -> channel(HIDDEN);
MULTILINE_COMMENT : '/*' .*? '*/' NL+ -> channel(HIDDEN);

CODE : TB_QUOTE .+? TB_QUOTE;

WS : [\t ] -> channel(HIDDEN);
NL : '\r'? '\n';
fragment CHAR : [a-zA-Z0-9];
fragment VALID_CHAR : [a-zA-Z0-9.,!?"'];

STUB : 'stub';

fragment LS_BRACE : '[';
fragment RS_BRACE : ']';
fragment TB_QUOTE : '```';

fragment HASH : '#';
fragment DASH : '-';
fragment STAR : '*';
MethodName : HASH | DASH | STAR;

WORD : VALID_CHAR+;