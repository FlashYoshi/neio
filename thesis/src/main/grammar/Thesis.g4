lexer grammar Thesis;

HEADER : '[' DOCUMENT_TYPE ']';
DOCUMENT_TYPE : 'Document'
              | 'Slides';

COMMENT : '//' ~[\r\n]*? -> skip;
MULTILINE_COMMENT : '/*' .*? '*/' -> skip;

WORD : ~[\r\n\t #]+;
WORDS : (WS* WORD WS*)+;
WS : [\t ]+;
NEWLINE : '\r'? '\n';