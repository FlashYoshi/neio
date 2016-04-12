lexer grammar ClassLexer;

COMMENT : '//' ~[\r\n]* -> channel(HIDDEN);
MULTILINE_COMMENT : '/*' .*? '*/' -> channel(HIDDEN);

WS : [\t ] -> channel(HIDDEN);
NEWLINE : '\r'? '\n' -> skip;

////////////START KEYWORDS////////////
NAMESPACE : 'namespace';
ABSTRACT : 'abstract';
CLASS : 'class';
INTERFACE : 'interface';
EXTENDS : 'extends';
IMPLEMENTS : 'implements';
IMPORT : 'import';
RETURN : 'return';
NEW : 'new';
THIS : 'this';
SUPER : 'super';
PRIVATE : 'private';
PROTECTED : 'protected';
PUBLIC : 'public';
VOID : 'void';
IF : 'if';
ELSE : 'else';
FOR : 'for';
WHILE : 'while';
NESTED : 'nested';
FINAL : 'final';
STATIC : 'static';
TRUE : 'true';
FALSE : 'false';
NULL : 'null';
STUB : 'stub';
////////////END KEYWORDS////////////

fragment N_D_QUOTE : ~["] | ~[\\] B_SLASH D_QUOTE;
StringLiteral : D_QUOTE N_D_QUOTE* D_QUOTE;
fragment N_QUOTE : ~['] | B_SLASH QUOTE;
CharLiteral : QUOTE N_QUOTE QUOTE;
TextMode : TSQ .*? TSQ;

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
INCR : '++';
PLUS : '+';
DECR : '--';
MINUS : '-';
STAR : '*';
PERCENT : '%';
HAT : '^';
L_SHIFT : '<<';
RR_SHIFT : '>>>';
R_SHIFT : '>>';
LEQ : '<=';
SMALLER : '<';
GEQ : '>=';
BIGGER : '>';
L_BRACE : '(';
R_BRACE : ')';
LC_BRACE : '{';
RC_BRACE : '}';
LS_BRACE : '[';
RS_BRACE : ']';
D_QUOTE : '"';
TSQ : '\'\'\'';
QUOTE : '\'';
SLASH : '/';
B_SLASH : '\\';
Q_MARK : '?';
ARRAY : '[]';
E_MARK : '!';
fragment DIGIT : [0-9];
fragment LETTER : [a-zA-Z];
fragment UNDERSCORE : '_';
fragment DOLLAR : '$';
fragment CHAR : LETTER | DIGIT | UNDERSCORE | DOLLAR;

Integer : DIGIT+;
Double : DIGIT DOT DIGIT;
Identifier : CHAR+;

MethodIdentifier : ~[!\[\]()\r\n \t;.,:<>]+;