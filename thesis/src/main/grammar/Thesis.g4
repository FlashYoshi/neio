lexer grammar Thesis;

HEADER : '[Document]'
       | '[Slides]';

COMMENT : '//' ~[\r\n]* -> skip;
MULTILINE_COMMENT : '/*' .*? '*/' -> skip;

WORD : [a-zA-Z0-9]+;

NEWLINE : '\r'? '\n';