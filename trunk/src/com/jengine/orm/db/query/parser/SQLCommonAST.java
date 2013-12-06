/*
 * This file is part of JEngine.
 *
 * Copyright (C) 2013 Victor Burlakov
 *
 * JEngine is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JEngine is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with JEngine.  If not, see <http://www.gnu.org/licenses/>.
 */

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
