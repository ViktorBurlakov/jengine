package com.jengine.orm.db.filter;


import antlr.RecognitionException;
import antlr.TokenStreamException;
import com.jengine.orm.db.query.parser.SqlTranslator;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import static com.jengine.utils.CollectionUtil.toList;

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
        this.translator = SqlTranslator.parse(query);
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
