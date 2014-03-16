grammar Expr;


options {
    output=AST;
}

tokens {
    MODEL_EXPRESSION;
    MODEL_NAME;
    GROUP;
    OPERATION;
    ATOM;
}

@header {
package com.jengine.orm.model.multi.parser;
}

@lexer::header {
package com.jengine.orm.model.multi.parser;
}


WS  :   
    (  ' ' |  '\t' |   '\r' '\n'  | '\n' |  '\r'  )
    { skip(); }; // ignore this token

// OPERATORS
LPAREN      :  '('   ;
RPAREN      :  ')'   ;
LEFT_JOIN   :  '<<'  ;
RIGHT_JOIN  :  '>>'  ;
INNER_JOIN  :  '&&'  ;

fragment CHAR : 
    ('a'..'z'|'A'..'Z');

IDENTIFIER : 
     CHAR ( CHAR | '0' .. '9' | '_' | '$' | '#' )* ;


model_expression:
    ( atom (operation^ atom)* )* ;

atom: 
    model_name | group ;

model_name :
    IDENTIFIER -> ^(MODEL_NAME IDENTIFIER);

operation:
    (LEFT_JOIN | RIGHT_JOIN | INNER_JOIN) ;

group: 
    LPAREN model_expression RPAREN -> ^(GROUP model_expression);
