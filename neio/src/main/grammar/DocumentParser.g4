parser grammar DocumentParser;

options { tokenVocab = DocumentLexer; }

document : HEADER
           body
           EOF;

body : realContent*;
realContent : content
            | mnl
            | nl;
content : prefixCall                        #prefixC
          | text                            #textC
          | multicode                       #multicodeC
          | content nl (lonecode | scode)   #contentCodeC
          | (lonecode | scode) nl content   #codeContentC
          | scode                           #scodeC
          | lonecode                        #lonecodeC
          ;

prefixCall : MethodName S txt;
// We don't allow spaces next to the MethodName to not confuse us with prefixCalls
surroundCall : left=(MethodName|HASH|DASH|STAR|BQ|US)+ (inlinecode | WORD) txt? right=(HASH|DASH|STAR|BQ|US)+ {$left.text.equals($right.text)}?;

text : (mnl | nl)? txt;
txt : (S* (inlinecode | WORD | surroundCall) S*)+;
nl : NL;
mnl : NL NL+;

scode : SCOPED_CODE;
lonecode : LONE_CODE;
multicode : (scode | lonecode) (NL (scode | lonecode))+;
inlinecode : CODE CCONTENT;