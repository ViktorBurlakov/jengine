
package com.jengine.orm.db.query.parser;


import antlr.CommonAST;
import antlr.Token;

public class SQLCommonAST extends CommonAST {
    protected Token token;

    public SQLCommonAST() {
    }

    public SQLCommonAST(Token tok) {
        super(tok);
    }

    public void initialize(Token tok) {
        super.initialize(tok);
        this.token = tok;
    }

    public int getLine() {
        return this.token.getLine();
    }

    public int getColumn() {
        return this.token.getColumn();
    }

    public Token getToken() {
        return token;
    }
}
