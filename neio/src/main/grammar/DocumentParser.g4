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

prefixCall : MethodName S+ txt? (S+ cPrefixCall)?;
cPrefixCall : preMethodName S+ txt? (S+ cPrefixCall)?;
preMethodName : P;
// We don't allow spaces next to the MethodName to not confuse us with prefixCalls
surroundCall : left=(MethodName|HASH|DASH|STAR|BQ|US|DLR)+ (inlinecode | WORD) txt? right=(HASH|DASH|STAR|BQ|US|DLR)+ {$left.text.equals($right.text)}?;

text : txt;
txt : ( textWSpaces
      | inlinecode
      | surroundCall)+;
nl : NL;

textWSpaces : (S* WORD S*)+
            | S+;

scode : SCOPED_CODE;
lonecode : LONE_CODE;
inlinecode : CODE CCONTENT;