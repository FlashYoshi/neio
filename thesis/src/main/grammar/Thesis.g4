lexer grammar Thesis;

HEADER : '[Document]'
       | '[Slides]';

COMMENT : '//' ~[\r\n]* -> channel(HIDDEN);
MULTILINE_COMMENT : '/*' .*? '*/' -> channel(HIDDEN);
