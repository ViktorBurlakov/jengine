package com.jengine.orm.model.field.aggregation;


import com.jengine.orm.model.ModelClassBase;
import com.jengine.orm.model.field.Field;
import com.jengine.orm.model.field.FunctionField;

import java.sql.Types;

import static com.jengine.utils.CollectionUtil.map;

public class Avg extends FunctionField {

    public Avg(String field) {
        this(Double.class, field);
    }

    public Avg(Class clazz, String field) {
        super(clazz, map("columnType", Types.DOUBLE), "avg(%s)", field);
        this.fieldName = makeDefaultName(field);
    }

    public Avg(ModelClassBase modelClass, String field) {
        this(modelClass, modelClass.getManager().getField(field));
    }

    public Avg(ModelClassBase modelClass, Field field) {
        super(field.getFieldClass(), map("columnType", Types.DOUBLE), "avg(%s)", field);
        config(makeDefaultName(field.getFieldName()), modelClass.getManager());
    }

    protected String makeDefaultName(String field) {
        return String.format("avg_%s", field.replaceAll("\\.", "__"));
    }
}
