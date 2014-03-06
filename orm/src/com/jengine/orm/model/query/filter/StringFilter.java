package com.jengine.orm.model.query.filter;


import antlr.RecognitionException;
import antlr.TokenStreamException;
import com.jengine.orm.db.filter.SQLStringFilter;
import com.jengine.orm.db.query.SQLQuery;
import com.jengine.orm.model.multi.MultiModelField;
import com.jengine.orm.model.query.BaseQuery;
import com.jengine.orm.model.query.ModelQuery;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import static com.jengine.utils.CollectionUtil.toList;


public class StringFilter {
    private SQLStringFilter stringFilter;
    private List<MultiModelField> multiModelFields = new ArrayList<MultiModelField>();
    private String source;
    private List params = new ArrayList();


    public StringFilter(String source, Object[] params) throws TokenStreamException, RecognitionException, UnsupportedEncodingException {
        this.source = source;
        this.params.addAll(toList(params));
    }

    public void config(BaseQuery query) throws TokenStreamException, RecognitionException, UnsupportedEncodingException {
        List sqlParams = new ArrayList();
        for (Object param : this.params) {
            sqlParams.add(param instanceof ModelQuery ? ((ModelQuery) param).toSQL() : param);
        }
        stringFilter = new SQLStringFilter(this.source, sqlParams);
        List<String> columns = stringFilter.findColumns();
        for (int index = 0; index < columns.size(); index++) {
            MultiModelField multiModelField = query._registerField(columns.get(index));
            multiModelFields.add(multiModelField);
            stringFilter.setColumnSQLName(index, multiModelField.getSQLName());
        }
    }

    public void setSQL(SQLQuery query) {
        query.addStringFilter(stringFilter);
    }

}
