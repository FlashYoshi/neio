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

prefixCall : MethodName+ sentence;

text : sentence+;

postfixCall : STUB;

sentence : WORD+ NL;

mnl : NL+;