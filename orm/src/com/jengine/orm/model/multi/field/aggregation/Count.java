package com.jengine.orm.model.multi.field.aggregation;


import com.jengine.orm.model.field.Field;
import com.jengine.orm.model.multi.field.CalcMultiField;

import java.sql.Types;

import static com.jengine.utils.CollectionUtil.list;
import static com.jengine.utils.CollectionUtil.map;

public class Count extends CalcMultiField {

    public Count(String field) {
        super(Long.class,  Types.DECIMAL, "count(%s)", list(field), map());
        name = makeDefaultName(field);
    }

    public Count(Field field) {
        super(Long.class, Types.DECIMAL, "count(%s)", list(field.getFieldName()), map());
        name = makeDefaultName(field.getFieldName());
    }

    public Count() {
        super(Long.class, Types.DECIMAL, "count(*)", list(), map());
        name = "_count_";
    }

    protected String makeDefaultName(String field) {
        return String.format("count_%s", field.replaceAll("\\.", "__"));
    }
}
