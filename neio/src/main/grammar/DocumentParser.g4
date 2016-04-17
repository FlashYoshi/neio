parser grammar DocumentParser;

options { tokenVocab = DocumentLexer; }

document : HEADER
           body
           EOF;

body : content*;
content : prefixCall
          | txt
          | scode
          | lonecode
          | mnl
          | nl;

prefixCall : MethodName S txt;
// We don't allow spaces next to the MethodName to not confuse us with prefixCalls
surroundCall : left=(MethodName|HASH|DASH|STAR|BQ|US)+ (inlinecode | WORD) txt? right=(HASH|DASH|STAR|BQ|US)+ {$left.text.equals($right.text)}?;

txt : (S* (inlinecode | WORD | surroundCall) S*)+;
nl : NL;
mnl : NL NL+;

scode : NL SCOPED_CODE NL?;
lonecode : NL LONE_CODE NL?;
inlinecode : CODE CCONTENT;