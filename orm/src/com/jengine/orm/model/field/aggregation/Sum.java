package com.jengine.orm.model.field.aggregation;


import com.jengine.orm.model.ModelClassBase;
import com.jengine.orm.model.field.Field;
import com.jengine.orm.model.field.FunctionField;

import static com.jengine.utils.CollectionUtil.map;

public class Sum extends FunctionField {

    public Sum(ModelClassBase modelClass, String field) {
        this(modelClass, modelClass.getManager().getField(field));
    }

    public Sum(ModelClassBase modelClass, Field field) {
        super(field.getFieldClass(), map("columnType", field.getColumnType()), "sum(%s)", field);
        config(makeDefaultName(field), modelClass.getManager());
    }

    protected String makeDefaultName(Field field) {
        return String.format("sum_%s", field.getFieldName().replaceAll("\\.", "__"));
    }
}
