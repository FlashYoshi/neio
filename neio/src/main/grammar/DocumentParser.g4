parser grammar DocumentParser;

options { tokenVocab = DocumentLexer; }

document : HEADER mnl
           body
           EOF;

body : content*;
content : ( prefixCall
          | imageCall
          | text
          | customCommand
          | scode
          | lonecode)
          mnl?;

prefixCall : MethodName+ S sentence;
imageCall : BANG (LS_BRACE caption=txt RS_BRACE)? L_BRACE name=WORD R_BRACE;

text : sentence+;

sentence : txt NL;
txt : (S* (code | WORD) S*)+;
customCommand : CC L_BRACE (WORD | UNKNOWN)* R_BRACE;
mnl : NL+;

scode : SCOPED_CODE SCONTENT;
lonecode : LONE_CODE;
code : CODE CCONTENT;