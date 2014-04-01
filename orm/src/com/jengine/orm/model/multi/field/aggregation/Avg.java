package com.jengine.orm.model.multi.field.aggregation;


import com.jengine.orm.model.field.Field;
import com.jengine.orm.model.multi.field.CalcMultiField;

import java.sql.Types;

import static com.jengine.utils.CollectionUtil.list;
import static com.jengine.utils.CollectionUtil.map;

public class Avg extends CalcMultiField {

    public Avg(Class clazz, String field) {
        super(Double.class, Types.DOUBLE, "avg(%s)", list(field), map());
        name = makeDefaultName(field);
    }

    public Avg(String field) {
        super(Double.class,  Types.DOUBLE, "avg(%s)", list(field), map());
        name = makeDefaultName(field);
    }

    public Avg(Field field) {
        super(field.getFieldClass(), Types.DECIMAL, "avg(%s)", list(field.getFieldName()), map());
        name = makeDefaultName(field.getFieldName());
    }

    protected String makeDefaultName(String field) {
        return String.format("avg_%s", field.replaceAll("\\.", "__"));
    }

}
