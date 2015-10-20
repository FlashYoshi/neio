grammar Document;

import Thesis;

document : HEADER
           body*
           EOF;

body : section
     | paragraph;

section : HASH+ WORDS;

paragraph : WORDS; //NEWLINE)+ {keepNewLine = true;};