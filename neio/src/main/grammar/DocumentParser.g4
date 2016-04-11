parser grammar DocumentParser;

options { tokenVocab = DocumentLexer; }

document : HEADER mnl
           body
           EOF;

body : content*;
content : ( prefixCall
          | imageCall
          | text
          | scode
          | lonecode)
          mnl?;

prefixCall : MethodName S txt NL;
imageCall : BANG (LS_BRACE caption=txt RS_BRACE)? L_BRACE name=WORD R_BRACE;

text : sentence+;

sentence : txt NL;
txt : (S* (inlinecode | WORD) S*)+;
mnl : NL+;

scode : SCOPED_CODE;
lonecode : LONE_CODE;
inlinecode : CODE CCONTENT;