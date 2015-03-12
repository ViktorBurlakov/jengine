lexer grammar Expr;
@header {
package com.cetus.jengine.orm.model.multi.parser;
}

// $ANTLR src "/home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g" 25
WS  :   
    (  ' ' |  '\t' |   '\r' '\n'  | '\n' |  '\r'  )
    { skip(); }; // ignore this token

// OPERATORS
// $ANTLR src "/home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g" 30
LPAREN      :  '('   ;
// $ANTLR src "/home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g" 31
RPAREN      :  ')'   ;
// $ANTLR src "/home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g" 32
LEFT_JOIN   :  '<<'  ;
// $ANTLR src "/home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g" 33
RIGHT_JOIN  :  '>>'  ;
// $ANTLR src "/home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g" 34
FULL_JOIN   :  '^'   ;
// $ANTLR src "/home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g" 35
INNER_JOIN  :  '&&'  ;
// $ANTLR src "/home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g" 36
AND         :  ','   ;

// $ANTLR src "/home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g" 38
fragment CHAR : 
    ('a'..'z'|'A'..'Z');

// $ANTLR src "/home/victor/IdeaProjects/jengine/orm/src/com/jengine/orm/model/multi/parser/Expr.g" 41
IDENTIFIER : 
     CHAR ( CHAR | '0' .. '9' | '_' | '$' | '#' )* ;


