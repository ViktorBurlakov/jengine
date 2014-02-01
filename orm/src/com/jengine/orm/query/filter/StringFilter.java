package com.jengine.orm.query.filter;


import antlr.RecognitionException;
import antlr.TokenStreamException;
import com.jengine.orm.db.filter.SQLStringFilter;
import com.jengine.orm.db.query.SQLQuery;
import com.jengine.orm.field.Field;
import com.jengine.orm.field.ForeignField;
import com.jengine.orm.multi.MultiModelField;
import com.jengine.orm.query.ModelQuery;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import static com.jengine.utils.CollectionUtil.toList;


public class StringFilter {
    private SQLStringFilter stringFilter;
    private List<MultiModelField> multiModelFields = new ArrayList<MultiModelField>();
    private String query;
    private List params = new ArrayList();


    public StringFilter(String query, Object[] params) throws TokenStreamException, RecognitionException, UnsupportedEncodingException {
        this.query = query;
        this.params.addAll(toList(params));
    }

    public void config(ModelQuery modelQuery) throws TokenStreamException, RecognitionException, UnsupportedEncodingException {
        List sqlParams = new ArrayList();
        for (Object param : this.params) {
            sqlParams.add(param instanceof ModelQuery ? ((ModelQuery) param).toSQL() : param);
        }
        stringFilter = new SQLStringFilter(this.query, sqlParams);
        List<String> columns = stringFilter.findColumns();
        for (int index = 0; index < columns.size(); index++) {
            Field modelField = modelQuery.getManager().getField(columns.get(index));
            if (modelField instanceof ForeignField) {
                modelQuery.addPath(((ForeignField) modelField).getReferencePath());
            }
            MultiModelField multiModelField = modelQuery.getMultiModelField(modelField);
            multiModelFields.add(multiModelField);
            stringFilter.setColumnSQLName(index, multiModelField.getSQLName());
        }
    }

    public void setSQL(SQLQuery query) {
        query.addStringFilter(stringFilter);
    }

}
