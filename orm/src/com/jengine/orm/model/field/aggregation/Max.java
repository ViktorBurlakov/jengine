package com.jengine.orm.model.field.aggregation;


import com.jengine.orm.model.ModelClassBase;
import com.jengine.orm.model.field.Field;
import com.jengine.orm.model.field.FunctionField;

import static com.jengine.utils.CollectionUtil.map;

public class Max extends FunctionField{

    public Max(ModelClassBase modelClass, String field) {
        this(modelClass, modelClass.getManager().getField(field));
    }

    public Max(ModelClassBase modelClass, Field field) {
        super(field.getFieldClass(), map("columnType", field.getColumnType()), "max(%s)", field);
        config(makeDefaultName(field), modelClass.getManager());
    }

    protected String makeDefaultName(Field field) {
        return String.format("max_%s", field.getFieldName().replaceAll("\\.", "__"));
    }
}
