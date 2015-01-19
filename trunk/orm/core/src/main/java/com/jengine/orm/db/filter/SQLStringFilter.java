/*
 *  This file is part of JEngine.
 *  *
 *  * Copyright (C) 2013-2014 Cetus (http://cs1.com.ua/). All rights reserved.
 *  *
 *  * JEngine is free software: you can redistribute it and/or modify
 *  * it under the terms of the GNU General Public License as published by
 *  * the Free Software Foundation, either version 3 of the License, or
 *  * (at your option) any later version.
 *  *
 *  * JEngine is distributed in the hope that it will be useful,
 *  * but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  * GNU General Public License for more details.
 *  *
 *  * You should have received a copy of the GNU General Public License
 *  * along with JEngine.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.jengine.orm.db.filter;


import antlr.RecognitionException;
import antlr.TokenStreamException;
import com.jengine.orm.db.query.parser.SqlParser;
import com.jengine.orm.db.query.parser.SqlTranslator;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import static com.jengine.utils.commons.CollectionUtil.toList;

public class SQLStringFilter {
    private String query;
    private SqlTranslator translator;
    private List params = new ArrayList();

    public SQLStringFilter(String query, Object[] params) throws TokenStreamException, RecognitionException, UnsupportedEncodingException {
        this(query, toList(params));
    }

    public SQLStringFilter(String query, List params) throws TokenStreamException, RecognitionException, UnsupportedEncodingException {
        this.query = query;
        this.params = params;
        SqlParser parser = SqlTranslator.getParser(query);
        parser.where_condition();
        this.translator = new SqlTranslator(query);
        this.translator.visit(parser.getAST());
    }

    public void setColumnSQLName(int index, String sqlName) {
        translator.getColumns().get(index).setText(sqlName);
    }

    public List<String> findColumns() {
        List<String> columns = new ArrayList<String>();

        for(SqlTranslator.Column column : translator.getColumns()) {
            columns.add(column.getText());
        }

        return columns;
    }

    public void putSQL(int paramIndex, String sql) {
        translator.getParams().get(paramIndex).setText(sql);
    }

    public String renderSQL() {
        return translator.getResult().toString();
    }

    public List getParams() {
        return params;
    }

    public void setParams(List params) {
        this.params = params;
    }
}
