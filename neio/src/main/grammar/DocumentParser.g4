parser grammar DocumentParser;

options { tokenVocab = DocumentLexer; }

document : HEADER mnl
           body
           EOF;

body : content*;
content : ( prefixCall
          | postfixCall
          | text
          | customCommand
          | scode
          | lonecode)
          mnl?;

prefixCall : MethodName+ sentence
           | BANG (LS_BRACE WORD+ RS_BRACE)? L_BRACE WORD R_BRACE;

text : sentence+;

postfixCall : STUB;

sentence : (code | WORD)+ NL;
customCommand : CC L_BRACE (WORD | UNKNOWN)* R_BRACE;
mnl : NL+;

scode : SCOPED_CODE SCONTENT;
lonecode : LONE_CODE LCONTENT;
code : CODE CCONTENT;