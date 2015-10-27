lexer grammar Thesis;

/**@members {
  private boolean keepNewLine = false;
}*/

HEADER : '[' HEADER_CONTENT ']';
HEADER_CONTENT : ~[\[\]]+;

COMMENT : '//' ~[\r\n]* -> skip;
MULTILINE_COMMENT : '/*' .*? '*/' -> skip;

WORD : ~[\r\n\t #]+;
WORDS : (WS* WORD WS*)+;
WS : [\t ];
NEWLINE : '\r'? '\n' -> skip; //{if (!keepNewLine) {skip();} else {keepNewLine = false;}};

HASH : '#';