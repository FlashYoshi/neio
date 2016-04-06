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

prefixCall : MethodName+ sentence;
imageCall : BANG (LS_BRACE caption=txt RS_BRACE)? L_BRACE name=WORD R_BRACE;

text : sentence+;

sentence : txt NL;
txt : (code | WORD)+;
customCommand : CC L_BRACE (WORD | UNKNOWN)* R_BRACE;
mnl : NL+;

scode : SCOPED_CODE SCONTENT;
lonecode : LONE_CODE LCONTENT;
code : CODE CCONTENT;