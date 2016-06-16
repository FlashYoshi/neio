/*
[The BSD License]
Copyright (c) 2012 Terence Parr and Sam Harwell
All rights reserved.

Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:

    Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
    Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
    Neither the name of the author nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY
EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL
THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF
THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
lexer grammar ClassLexer;

COMMENT : '//' ~[\r\n]* -> channel(HIDDEN);
MULTILINE_COMMENT : '/*' .*? '*/' -> channel(HIDDEN);

WS : [ \r\t\u000C\n] -> channel(HIDDEN);

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
SURROUND : 'surround';
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

Double : DIGIT DOT DIGIT+;
Integer : DIGIT+;
Identifier : CHAR+;

MethodIdentifier : ~[!\[\]()\r\n \t;.,:<>]+;