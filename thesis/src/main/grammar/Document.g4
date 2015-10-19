grammar Document;

import Thesis;

section : '#' .*?;

paragraph : WORD .*? NEWLINE ;

WORD : [a-z ]+;

NEWLINE : '\r\n';