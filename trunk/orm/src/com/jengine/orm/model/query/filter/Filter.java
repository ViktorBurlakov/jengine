package com.jengine.orm.model.query.filter;


import com.jengine.orm.db.DBException;
import com.jengine.orm.db.filter.SQLFilter;
import com.jengine.orm.db.query.SQLQuery;
import com.jengine.orm.model.multi.MultiModelField;
import com.jengine.orm.model.query.ModelQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Filter {
    private ModelQuery modelQuery;
    private MultiModelField multiModelField;
    private String field;
    private String operation;
    private Object value;

    public Filter(String field, String operation, Object value) {
        this.field = field;
        this.operation = operation;
        this.value = value;
    }

    public void config(ModelQuery modelQuery) throws DBException {
        this.modelQuery = modelQuery;
        this.multiModelField = modelQuery._registerField(field);
        this.value = this.multiModelField.getModelField().cast(this.value);
    }

    public void setSQL(SQLQuery query) {
        Object value = this.value instanceof ModelQuery ? ((ModelQuery) this.value).toSQL() : this.value;
        query.filter(new SQLFilter(multiModelField.getSQLName(), operation, value));
    }

    static public List<Filter> parse(Map<String, Object> filter) {
        List<Filter> filters = new ArrayList<Filter>();

        for (String key : filter.keySet()) {
            String name = key.contains("__") ? key.split("__")[0] : key;
            String operation = key.contains("__") ? key.split("__")[1] : "eq";
            Object value = filter.get(key);
            filters.add(new Filter(name, operation, value));
        }

        return filters;
    }

}
