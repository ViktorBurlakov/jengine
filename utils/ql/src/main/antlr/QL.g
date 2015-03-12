grammar QL;

options {
    output=AST;
}

tokens {
    MODEL_NAME;
    MODEL_GROUP;
    FUNCTION;
    NOT_LIKE;
    NOT_EQ;
    IS_NULL;
    IS_NOT_NULL;
    IS_EMPTY;
    IS_NOT_EMPTY;
    NOT_IN;
    NOT_BETWEEN;
    FIELD;
    GROUP;
    TARGET;
    TARGETS;
    LIMIT;
    GROUP_LIST;
    GROUP_ITEM;
    ORDER_LIST;
    ORDER_ITEM;
    LEFT_JOIN;
    RIGHT_JOIN;
    FULL_JOIN;
    INNER_JOIN;
    CROSS_JOIN;
    SELECT_QUERY;
    MODEL_EXPRESSION;
    HAVING;
    FROM_CLAUSE;
    SELECT_CLAUSE;
    FROM_CLAUSE;
    WHERE_CLAUSE;
    ORDER_BY_CLAUSE;
    GROUP_BY_CLAUSE;
    HAVING_CLAUSE;
    LIMIT_CLAUSE;
    EXPRESSION;
}

@header {
package com.cetus.jengine.utils.ql;
}

@lexer::header {
package com.cetus.jengine.utils.ql;
}


// ************************ Lexer ****************************************

LINE_BREACK   : ( ('\r' '\n') | '\n' | '\r' ) ;//{ newline(); } ;
WS            : ( ' ' | '\t' | LINE_BREACK ) { skip(); };
ML_COMMENT    : '/*' ( { input.LA(2)!='/' }? '*' |  LINE_BREACK   | ~('*'|'\n'|'\r') )* '*/' { skip(); };
SEMI          : ';' ;
DOT           : '.' ;
COMMA         : ',' ;
OPEN_PAREN    : '(' ;
CLOSE_PAREN   : ')' ;
STAR          : '*' ;
AT_SIGN       : '@' ;

fragment A    : ('a'|'A');
fragment B    : ('b'|'B');
fragment C    : ('c'|'C');
fragment D    : ('d'|'D');
fragment E    : ('e'|'E');
fragment F    : ('f'|'F');
fragment G    : ('g'|'G');
fragment H    : ('h'|'H');
fragment I    : ('i'|'I');
fragment J    : ('j'|'J');
fragment K    : ('k'|'K');
fragment L    : ('l'|'L');
fragment M    : ('m'|'M');
fragment N    : ('n'|'N');
fragment O    : ('o'|'O');
fragment P    : ('p'|'P');
fragment Q    : ('q'|'Q');
fragment R    : ('r'|'R');
fragment S    : ('s'|'S');
fragment T    : ('t'|'T');
fragment U    : ('u'|'U');
fragment V    : ('v'|'V');
fragment W    : ('w'|'W');
fragment X    : ('x'|'X');
fragment Y    : ('y'|'Y');
fragment Z    : ('z'|'Z');

//             *** types ***
fragment CHAR : ('a'..'z'|'A'..'Z');
fragment DIGIT: '0'..'9';
STRING        : '\'' ( ~'\'' )* '\'' | '\"' ( ~'\"' )* '\"';
fragment NUM  :  DIGIT ( DIGIT )*;
NUMBER        : ( PLUS | MINUS )? ( (NUM DOT NUM) | DOT NUM | NUM ) ( 'e' ( PLUS | MINUS )? NUM )? ;
BOOLEAN       : (T R U E) | (F A L S E);
DATETIME      : '#' (~ '#' )* '#';
NULL          : N U L L;


//             *** operations ***
PLUS          : '+' ;
MINUS         : '-' ;
DIVIDE        : '/' ;
VERTBAR       : '|' ;
EQ            : '=' | '==' ;
QUESTION      : '?' ;
NOT_EQ        : '<>' | '!=' ;
GT            : '>' ;
LT            : '<' ;
LE            : '<=';
GE            : '>=';
NOT           : '!' | (N O T);
OR            : (O R) | '||';
XOR           : (X O R);
AND           : (A N D)| '&&';
MOD           : '%';
BITWISE_AND   : '&&&';
BITWISE_XOR   : '^^^';
BITWISE_LEFT  : '<<<';
BITWISE_RIGHT : '>>>';
BIT_INVERSION : '~';


ON            : O N;
IS            : I S;
IN            : I N;
LIKE          : L I K E;
ESCAPE        : E S C A P E;
EMPTY         : E M P T Y;
BETWEEN       : B E T W E E N;

ASC           : A S C;
DESC          : D E S C;
DISTINCT      : D I S T I N C T;
SELECT        : S E L E C T;
FROM          : F R O M;
WHERE         : W H E R E;
ORDER         : O R D E R;
BY            : B Y;
GROUP         : G R O U P;
HAVING        : H A V I N G;
LIMIT         : L I M I T;
LEFT          : L E F T;
JOIN          : J O I N;
OUTER         : O U T E R;
RIGHT         : R I G H T;
FULL          : F U L L;
INNER         : I N N E R;
CROSS         : C R O S S;
IDENTIFIER    : (CHAR | '_') ( CHAR | DIGIT | '_' | '$' | '#' )* ;



// *********************** Parser  Rules *******************************

query:
	select_query // | update_query | remove_query
    ;

select_query:
	select_clause? from_clause where_clause? order_by_clause? group_by_clause? having_clause? limit_clause?
	-> ^(SELECT_QUERY select_clause? from_clause where_clause? order_by_clause? group_by_clause? having_clause? limit_clause?)
    ;

select_clause:
	SELECT (d=DISTINCT)? targets -> ^(SELECT_CLAUSE targets $d?)
    ;

from_clause:
	FROM model_expression -> ^(FROM_CLAUSE model_expression)
    ;

where_clause:
	WHERE expression  -> ^(WHERE_CLAUSE expression)
    ;

order_by_clause:
	ORDER BY order_item_list_expression -> ^(ORDER_BY_CLAUSE order_item_list_expression)
    ;

group_by_clause:
	GROUP BY group_item_list_expression -> ^(GROUP_BY_CLAUSE group_item_list_expression)
    ;

having_clause:
	HAVING having_expression -> ^(HAVING_CLAUSE having_expression)
    ;

limit_clause:
	LIMIT limit -> ^(LIMIT_CLAUSE limit)
    ;


// target expression

targets: 
	target (COMMA target)* -> ^(TARGETS target (target)*)
    ;

target:
	expression -> ^(TARGET expression)
    ;


// model expression

model_expression:
	model_expression_item* -> ^(MODEL_EXPRESSION model_expression_item*)
    ;

model_expression_item:
	model_expression_atom (model_operation^ model_expression_atom (ON logicalExpression)?)*
    ;

model_expression_atom:
	model_name | model_group 
    ;

model_name :
	IDENTIFIER (DOT IDENTIFIER)* -> ^(MODEL_NAME IDENTIFIER (DOT IDENTIFIER)*)
    ;

model_operation:
	left_join | right_join | inner_join | full_join | cross_join
    ;

left_join:
	('<<' | LEFT JOIN | LEFT OUTER JOIN) -> ^(LEFT_JOIN)
    ;

right_join:
	('>>'| RIGHT JOIN | RIGHT OUTER JOIN) -> ^(RIGHT_JOIN)
    ;

full_join:
	('^' | FULL JOIN | FULL OUTER JOIN) -> ^(FULL_JOIN)
    ;

inner_join:
	('&' | INNER JOIN) -> ^(INNER_JOIN)
    ;

cross_join:
	('<<>>' | CROSS JOIN) -> ^(CROSS_JOIN)
    ;

model_group:
	OPEN_PAREN model_expression CLOSE_PAREN -> ^(MODEL_GROUP model_expression)
    ;


// filter expression

expression:
	logicalExpression -> ^(EXPRESSION logicalExpression);

logicalExpression:
	booleanXorExpression ( OR^ booleanXorExpression )*;

booleanXorExpression:
	booleanAndExpression ( XOR^ booleanAndExpression )*
    ;

booleanAndExpression:
	booleanNotExpression ( AND^ booleanNotExpression )*
    ;

booleanNotExpression:
	betweenExpression ( NOT^ betweenExpression )*
    ;

betweenExpression:
	equalityExpression ( (not_between^ | BETWEEN^) equalityExpression AND equalityExpression )*
    ;

not_between:
	NOT BETWEEN -> ^(NOT_BETWEEN)
    ;

equalityExpression:
	relationalExpression ( (EQ | NOT_EQ)^ relationalExpression )*
    ;

not_eq:
	NOT EQ -> ^(NOT_EQ)
    ;

relationalExpression:
    nullComparisonExpression ( (LT | LE | GT | GE )^ nullComparisonExpression)*
    ;

nullComparisonExpression:
	likeExpression ( (is_not_null^ | is_null^) )?
    ;

is_null:
    IS NULL -> ^(IS_NULL)
    ;

is_not_null:
	IS NOT NULL  -> ^(IS_NOT_NULL)
    ;

likeExpression:
	inExpression ( (not_like^ | LIKE^) likePattern (ESCAPE STRING)? )?
    ;

not_like:
	NOT LIKE -> ^(NOT_LIKE)
    ;

likePattern:
	STRING | param
    ;

inExpression
	: bitwiseOrExpression ( (not_in | IN)^ OPEN_PAREN atomList CLOSE_PAREN )?
    ;

not_in:
	NOT IN -> ^(NOT_IN)
    ;

//betweenExpression:
//	comparisonExpression ( (not_between^ | BETWEEN^) comparisonExpression AND! comparisonExpression )*
//    ;
//
//comparisonExpression:
//	bitwiseOrExpression (
//	    (EQ^ | not_eq^) bitwiseOrExpression  | 
//	    (LT | LE | GT | GE )^ bitwiseOrExpression |
//	    (is_not_null^ | is_null^) |
//	    (not_like^ | LIKE^) likePattern (ESCAPE STRING)? |
//	    (not_in^ | IN^) OPEN_PAREN atomList CLOSE_PAREN
//	)*
//    ;
//
//likePattern:
//	STRING | param
//    ;

bitwiseOrExpression
	: bitwiseAndExpression ( bitwiseOr^ bitwiseAndExpression )?
    ;

bitwiseOr:
	VERTBAR
    ;

bitwiseAndExpression:
	bitwiseLeftExpression ( BITWISE_AND^ bitwiseLeftExpression )?
    ;

bitwiseLeftExpression:
	bitwiseRightExpression ( BITWISE_LEFT^ bitwiseRightExpression )?
    ;

bitwiseRightExpression:
	additiveExpression ( BITWISE_RIGHT^ additiveExpression )?
    ;

additiveExpression:
	multiplicativeExpression ( (PLUS | MINUS)^ multiplicativeExpression )*
    ;

multiplicativeExpression:
	unaryExpression ( (STAR | DIVIDE | MOD)^ unaryExpression)*
    ;

unaryExpression:
	(MINUS | BIT_INVERSION)^ unaryExpression | atom | groupExpression
    ;

groupExpression:
	OPEN_PAREN logicalExpression CLOSE_PAREN -> ^(GROUP logicalExpression)
    ;

atom:
	value | param | function | field
    ;

atomList:
	atom (COMMA atom)*
    ;

value:
	NUMBER | STRING | DATETIME | BOOLEAN
    ;

param:
	QUESTION
    ;

field:
	IDENTIFIER (DOT IDENTIFIER)* -> ^(FIELD IDENTIFIER (DOT IDENTIFIER)*)
    ;

function:
	//{ input.LT(2).getText().equals("(")}? IDENTIFIER OPEN_PAREN functionParameterList CLOSE_PAREN -> ^(FUNCTION IDENTIFIER OPEN_PAREN functionParameterList CLOSE_PAREN) 
	{ input.LA(2) == OPEN_PAREN }? IDENTIFIER OPEN_PAREN functionParameterList CLOSE_PAREN -> ^(FUNCTION IDENTIFIER functionParameterList) 
    ;

functionParameterList:
	( logicalExpression (COMMA logicalExpression)* )?
    ;

is_empty:
	IS EMPTY -> ^(IS_EMPTY)
    ;

is_not_empty:
	IS NOT EMPTY -> ^(IS_NOT_EMPTY)
    ;


// order expression
order_item_list_expression:
	order_item (COMMA order_item)* -> ^(ORDER_LIST order_item (order_item)*)
    ;

order_item:
	expression (a=ASC | a=DESC)? -> ^(ORDER_ITEM expression $a?)
    ;


// group expression
group_item_list_expression:
	group_item (COMMA group_item)* -> ^(GROUP_LIST group_item (group_item)*)
    ;

group_item:
	expression -> ^(GROUP_ITEM expression)
    ;


// having expression
having_expression:
	expression -> ^(HAVING expression)
    ;


// limit expression
limit:
	(a=NUMBER COMMA)? b=NUMBER -> ^(LIMIT $b $a?)
    ;
