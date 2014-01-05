package com.jengine.orm.db.query;


import com.jengine.orm.db.query.parser.SqlTranslator;

import java.util.ArrayList;
import java.util.List;

public class StringSQLQuery {
    private String query;
    private List params = new ArrayList();
    private SqlTranslator translator;

    public StringSQLQuery(String source, SqlTranslator translator, List params)  {
        this.query = source;
        this.translator = translator;
        this.params = params;
    }

    public List getParams() {
        return params;
    }

    public void putParamSQL(int index, String sql) {
        translator.getParams().get(index).setText(sql);
    }

    public String getSQL() {
        return translator.getResult().toString();
    }
}
