lexer grammar QL;
@header {
package com.jengine.utils.ql;
}

T127 : '<<' ;
T128 : '>>' ;
T129 : '^' ;
T130 : '&' ;
T131 : '<<>>' ;

// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 58
LINE_BREACK   : ( ('\r' '\n') | '\n' | '\r' ) ;//{ newline(); } ;
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 59
WS            : ( ' ' | '\t' | LINE_BREACK ) { skip(); };
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 60
ML_COMMENT    : '/*' ( { input.LA(2)!='/' }? '*' |  LINE_BREACK   | ~('*'|'\n'|'\r') )* '*/' { skip(); };
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 61
SEMI          : ';' ;
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 62
DOT           : '.' ;
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 63
COMMA         : ',' ;
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 64
OPEN_PAREN    : '(' ;
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 65
CLOSE_PAREN   : ')' ;
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 66
STAR          : '*' ;
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 67
AT_SIGN       : '@' ;

// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 69
fragment A    : ('a'|'A');
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 70
fragment B    : ('b'|'B');
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 71
fragment C    : ('c'|'C');
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 72
fragment D    : ('d'|'D');
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 73
fragment E    : ('e'|'E');
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 74
fragment F    : ('f'|'F');
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 75
fragment G    : ('g'|'G');
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 76
fragment H    : ('h'|'H');
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 77
fragment I    : ('i'|'I');
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 78
fragment J    : ('j'|'J');
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 79
fragment K    : ('k'|'K');
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 80
fragment L    : ('l'|'L');
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 81
fragment M    : ('m'|'M');
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 82
fragment N    : ('n'|'N');
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 83
fragment O    : ('o'|'O');
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 84
fragment P    : ('p'|'P');
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 85
fragment Q    : ('q'|'Q');
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 86
fragment R    : ('r'|'R');
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 87
fragment S    : ('s'|'S');
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 88
fragment T    : ('t'|'T');
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 89
fragment U    : ('u'|'U');
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 90
fragment V    : ('v'|'V');
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 91
fragment W    : ('w'|'W');
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 92
fragment X    : ('x'|'X');
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 93
fragment Y    : ('y'|'Y');
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 94
fragment Z    : ('z'|'Z');

//             *** types ***
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 97
fragment CHAR : ('a'..'z'|'A'..'Z');
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 98
fragment DIGIT: '0'..'9';
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 99
STRING        : '\'' ( ~'\'' )* '\'' | '\"' ( ~'\"' )* '\"';
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 100
fragment NUM  :  DIGIT ( DIGIT )*;
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 101
NUMBER        : ( PLUS | MINUS )? ( (NUM DOT NUM) | DOT NUM | NUM ) ( 'e' ( PLUS | MINUS )? NUM )? ;
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 102
BOOLEAN       : (T R U E) | (F A L S E);
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 103
DATETIME      : '#' (~ '#' )* '#';
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 104
NULL          : N U L L;


//             *** operations ***
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 108
PLUS          : '+' ;
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 109
MINUS         : '-' ;
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 110
DIVIDE        : '/' ;
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 111
VERTBAR       : '|' ;
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 112
EQ            : '=' | '==' ;
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 113
QUESTION      : '?' ;
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 114
NOT_EQ        : '<>' | '!=' ;
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 115
GT            : '>' ;
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 116
LT            : '<' ;
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 117
LE            : '<=';
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 118
GE            : '>=';
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 119
NOT           : '!' | (N O T);
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 120
OR            : (O R) | '||';
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 121
XOR           : (X O R);
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 122
AND           : (A N D)| '&&';
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 123
MOD           : '%';
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 124
BITWISE_AND   : '&&&';
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 125
BITWISE_XOR   : '^^^';
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 126
BITWISE_LEFT  : '<<<';
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 127
BITWISE_RIGHT : '>>>';
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 128
BIT_INVERSION : '~';


// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 131
ON            : O N;
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 132
IS            : I S;
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 133
IN            : I N;
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 134
LIKE          : L I K E;
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 135
ESCAPE        : E S C A P E;
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 136
EMPTY         : E M P T Y;
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 137
BETWEEN       : B E T W E E N;

// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 139
ASC           : A S C;
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 140
DESC          : D E S C;
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 141
DISTINCT      : D I S T I N C T;
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 142
SELECT        : S E L E C T;
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 143
FROM          : F R O M;
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 144
WHERE         : W H E R E;
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 145
ORDER         : O R D E R;
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 146
BY            : B Y;
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 147
GROUP         : G R O U P;
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 148
HAVING        : H A V I N G;
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 149
LIMIT         : L I M I T;
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 150
LEFT          : L E F T;
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 151
JOIN          : J O I N;
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 152
OUTER         : O U T E R;
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 153
RIGHT         : R I G H T;
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 154
FULL          : F U L L;
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 155
INNER         : I N N E R;
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 156
CROSS         : C R O S S;
// $ANTLR src "/home/vmb/app/IdeaProjects/jengine/utils/ql/src/com/jengine/utils/ql/QL.g" 157
IDENTIFIER    : (CHAR | '_') ( CHAR | DIGIT | '_' | '$' | '#' )* ;



// *********************** Parser  Rules *******************************

