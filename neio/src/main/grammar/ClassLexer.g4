lexer grammar ClassLexer;

HEADER : HEADER_CONTENT;
fragment HEADER_CONTENT : CLASS | INTERFACE;

COMMENT : '//' ~[\r\n]* -> channel(HIDDEN);
MULTILINE_COMMENT : '/*' .*? '*/' -> channel(HIDDEN);

WS : [\t ] -> channel(HIDDEN);
NEWLINE : '\r'? '\n' -> skip;

////////////START KEYWORDS////////////
PACKAGE : 'package';
CLASS : 'class';
INTERFACE : 'interface';
EXTENDS : 'extends';
IMPLEMENTS : 'implements';
RETURN : 'return';
NEW : 'new';
THIS : 'this';
SUPER : 'super';
FOR : 'for';
NESTED : 'nested';
INT : 'int';
TRUE : 'true';
FALSE : 'false';
NULL : 'null';
STUB : 'stub';
////////////END KEYWORDS////////////

fragment N_D_QUOTE : ~["] | B_SLASH D_QUOTE;
StringLiteral : D_QUOTE N_D_QUOTE* D_QUOTE;
fragment N_QUOTE : ~['] | B_SLASH QUOTE;
CharLiteral : QUOTE N_QUOTE QUOTE;

DOT : '.';
COMMA : ',';
COLON : ':';
SCOLON : ';';
EQUAL : '==';
NOT_EQUAL : '!=';
AND : '&&';
AMPERSAND : '&';
OR : '||';
PIPE : '|';
EQUALS : '=';
PLUS : '+';
MINUS : '-';
STAR : '*';
PERCENT : '%';
HAT : '^';
L_SHIFT : '<<';
RR_SHIFT : '>>>';
R_SHIFT : '>>';
SEQ : '<=';
SMALLER : '<';
GEQ : '>';
BIGGER : '>';
L_BRACE : '(';
R_BRACE : ')';
LC_BRACE : '{';
RC_BRACE : '}';
D_QUOTE : '"';
QUOTE : '\'';
SLASH : '/';
B_SLASH : '\\';
DIGIT : [0-9];
LETTER : [a-zA-Z];
CHAR : LETTER | DIGIT;

Integer : DIGIT+;
Double : DIGIT DOT DIGIT;
Identifier : CHAR+;

MethodIdentifier : ~[()\r\n \t;.,:<>]+;