lexer grammar DocumentLexer;

HEADER : {getCharPositionInLine() == 0}? LS_BRACE CHAR+ RS_BRACE;
COMMENT : '//' ~[\r\n]* NL+ -> channel(HIDDEN);
MULTILINE_COMMENT : '/*' .*? '*/' NL+ -> channel(HIDDEN);

SCOPED_CODE : {getCharPositionInLine() == 0}? DLCB CONTENT* DRCB {_input.LA(1) == '\r' || _input.LA(1) == '\n'}?;
LONE_CODE : {getCharPositionInLine() == 0}? LCB CONTENT* RCB {_input.LA(1) == '\r' || _input.LA(1) == '\n'}?;
CODE : LCB -> pushMode(INCODE);

fragment CHAR : [a-zA-Z0-9];
ESCAPE : B_SLASH .;

S : ' ';
WS : [\t] -> channel(HIDDEN);
NL : '\r'? '\n';

LS_BRACE : '[';
RS_BRACE : ']';
L_BRACE : '(';
R_BRACE : ')';
DLCB : '{{';
LCB : '{';
DRCB : '}}';
RCB : '}';
Q : '"';
fragment SQ : '\'';
TQ : SQ SQ SQ;
fragment B_QUOTE : '`';
fragment DB_QUOTE : '``';
fragment TB_QUOTE : '```';
fragment B_SLASH : '\\';

fragment HASH : '#';
fragment DASH : '-';
fragment STAR : '*';
BANG : '!';
MethodName : {getCharPositionInLine() == 0}? (HASH | DASH | STAR);

fragment VALID_CHAR : ~[#-+*_\[\]{} \r\n] | SQ | HASH | DASH | STAR | BANG;

WORD : VALID_CHAR+;

mode INCODE;
CCONTENT : CONTENT* RCB -> mode(DEFAULT_MODE);
CONTENT : (LCB CONTENT* RCB) | ANY;
ANY : ~["{}']+ | STRING;
STRING : Q (~["] | B_SLASH Q)* Q
       | SQ (~['] | B_SLASH SQ)* SQ
       | TEXTMODE;
TEXTMODE : TQ (. | B_SLASH SQ B_SLASH SQ B_SLASH SQ)*? TQ;

UNKNOWN : . ;