parser grammar NeioDocumentParser;

options { tokenVocab = NeioDocumentLexer; }

document : HEADER mnl
           body
           EOF;

body : content*;

content : ( prefixCall
          | postfixCall
          | text)
          mnl?;

prefixCall : HASH+ sentence ;

text : sentence+;

postfixCall : STUB;

sentence : WORD+ NL;

mnl : NL+;