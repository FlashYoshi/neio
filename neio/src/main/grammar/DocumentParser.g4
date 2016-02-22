parser grammar DocumentParser;

options { tokenVocab = DocumentLexer; }

document : HEADER mnl
           body
           EOF;

body : content*;

content : ( prefixCall
          | postfixCall
          | text
          | CODE)
          mnl?;

prefixCall : MethodName+ sentence
           | BANG (LS_BRACE WORD+ RS_BRACE)? L_BRACE WORD R_BRACE;

text : sentence+;

postfixCall : STUB;

sentence : WORD+ NL;

mnl : NL+;