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