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
lexer grammar DocumentLexer;

HEADER : {getCharPositionInLine() == 0}? LS_BRACE CHAR+ RS_BRACE;
COMMENT : '//' ~[\r\n]* NL -> channel(HIDDEN);
MULTILINE_COMMENT : '/*' .*? '*/' NL -> channel(HIDDEN);

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
fragment UNDERSCORE : '_';

fragment H : '#';
fragment D : '-';
fragment ST : '*';
fragment DOLLAR : '$';
fragment PIPE : '|';
fragment EQUALS : '=';
fragment CARET : '^';
MethodName : {getCharPositionInLine() == 0}? (H | D | ST | DLR | EQUALS | CARET | B_QUOTE | UNDERSCORE | P)+;
HASH : H;
DASH : D;
STAR : ST;
P : PIPE;
EQ : EQUALS;
CA : CARET;
BQ : B_QUOTE;
US : UNDERSCORE;
DLR : DOLLAR;

fragment VALID_CHAR : ~[#-*_`\[\]{} \r\n] | SQ | HASH | DLR | L_BRACE | R_BRACE | EQ | CA;

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