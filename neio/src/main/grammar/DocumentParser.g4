parser grammar DocumentParser;

options { tokenVocab = DocumentLexer; }

document : HEADER
           body
           EOF;

body : content*;
content : prefixCall
          | text
          | scode
          | lonecode
          | mnl
          | nl;

prefixCall : (nl | mnl)? MethodName S txt;
// We don't allow spaces next to the MethodName to not confuse us with prefixCalls
surroundCall : left=(MethodName|HASH|DASH|STAR|BQ|US)+ (inlinecode | WORD) txt? right=(HASH|DASH|STAR|BQ|US)+ {$left.text.equals($right.text)}?;

text : (mnl | nl)? txt;
txt : (S* (inlinecode | WORD | surroundCall) S*)+;
nl : NL;
mnl : NL NL+;

scode : SCOPED_CODE;
lonecode : LONE_CODE;
inlinecode : CODE CCONTENT;