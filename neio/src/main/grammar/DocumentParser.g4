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
parser grammar DocumentParser;

options { tokenVocab = DocumentLexer; }

document : HEADER
           body
           EOF;

body : content*;
content : prefixCall    #prefixC
          | text        #textC
          | scode       #scodeC
          | lonecode    #lonecodeC
          | nl          #nlC
          ;

prefixCall : MethodName S+ txt (S+ cPrefixCall)?
           | MethodName S+ cPrefixCall?;
cPrefixCall : preMethodName S+ txt (S+ cPrefixCall)?
            | preMethodName S+ cPrefixCall?;
preMethodName : P | STAR | EQ | DASH | CA | US;
// We don't allow spaces next to the MethodName to not confuse us with prefixCalls
surroundCall : left=(MethodName|HASH|DASH|STAR|BQ|US|DLR|EQ|CA)+ (ESCAPE+ | (inlinecode | WORD)) txt?? right=(HASH|DASH|STAR|BQ|US|DLR|EQ|CA)+ {$left.text.equals($right.text)}?;

text : txt;
txt : ( textWSpaces
      | inlinecode
      | surroundCall)+;
nl : NL;

textWSpaces : (S* (WORD | ESCAPE) S*)+
            | S+;

scode : SCOPED_CODE;
lonecode : LONE_CODE;
inlinecode : CODE CCONTENT;