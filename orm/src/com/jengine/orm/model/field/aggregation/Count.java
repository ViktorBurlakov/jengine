package com.jengine.orm.model.field.aggregation;


import com.jengine.orm.model.ModelClassBase;
import com.jengine.orm.model.field.Field;
import com.jengine.orm.model.field.FunctionField;

import java.sql.Types;

import static com.jengine.utils.CollectionUtil.map;

public class Count extends FunctionField {

    public Count(String field) {
        super(Long.class, map("columnType", Types.DECIMAL), "count(%s)", field);
        this.fieldName = makeDefaultName(field);
    }

    public Count(ModelClassBase modelClassBase, String field) {
        this(modelClassBase, modelClassBase.getManager().getField(field));
    }

    public Count(ModelClassBase modelClassBase, Field field) {
        super(Long.class, map("columnType", Types.DECIMAL), "count(%s)", field);
        config(makeDefaultName(field.getFieldName()), modelClassBase.getManager());
    }

    public Count(ModelClassBase modelClassBase) {
        super(Long.class, map("columnType", Types.DECIMAL), "count(*)");
        config("_count_", modelClassBase.getManager());
    }

    protected String makeDefaultName(String field) {
        return String.format("count_%s", field.replaceAll("\\.", "__"));
    }
}
