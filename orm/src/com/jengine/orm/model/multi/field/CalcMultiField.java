package com.jengine.orm.model.multi.field;


import com.jengine.orm.db.DBException;
import com.jengine.orm.model.multi.MultiModel;
import com.jengine.utils.Variant;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CalcMultiField extends MultiModelField {
    protected List<String> fields = new ArrayList<String>();
    protected List<String> columns = new ArrayList<String>();
    protected String expression;
    protected Class fieldClass;
    protected Integer columnType;
    protected Map<String, Object> options = new LinkedHashMap<String, Object>();

    public CalcMultiField(Class fieldClass, Integer columnType, String expression, List<String> fields, Map<String, Object> options) {
        super();
        this.expression = expression;
        this.fieldClass = fieldClass;
        this.columnType = columnType;
        this.fields.addAll(fields);
        this.options.putAll(options);
    }

    public CalcMultiField(String name, Class fieldClass, Integer columnType, String expression, List<String> fields, Map<String, Object> options) {
        super(name);
        this.expression = expression;
        this.fieldClass = fieldClass;
        this.columnType = columnType;
        this.fields.addAll(fields);
        this.options.putAll(options);
    }

    public void config(MultiModel multiModel) {
        this.multiModel = multiModel;
        for (String field : this.fields) {
            columns.add(multiModel.getField(field).getSQLName());
        }
    }

    public String getSQLName() {
        return name;
    }

    public Object cast(Object value) throws DBException {
        return new Variant(value).convertTo(fieldClass);
    }

    public String toSQL() {
        return String.format(expression, columns.toArray());
    }

}
