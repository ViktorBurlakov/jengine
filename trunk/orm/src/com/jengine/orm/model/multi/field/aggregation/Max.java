package com.jengine.orm.model.multi.field.aggregation;


import com.jengine.orm.model.field.Field;
import com.jengine.orm.model.multi.MultiModel;
import com.jengine.orm.model.multi.field.CalcMultiField;

import static com.jengine.utils.CollectionUtil.list;
import static com.jengine.utils.CollectionUtil.map;

public class Max extends CalcMultiField {

    public Max(String field) {
        super(null, null, "max(%s)", list(field), map());
        name = makeDefaultName(field);
    }

    public Max(Field field) {
        super(field.getFieldClass(), field.getColumnType(), "max(%s)", list(field.getFieldName()), map());
        name = makeDefaultName(field.getFieldName());
    }

    public void config(MultiModel multiModel) {
        super.config(multiModel);
        fieldClass = multiModel.getField(fields.get(0)).getModelField().getFieldClass();
        columnType = multiModel.getField(fields.get(0)).getModelField().getColumnType();
    }

    protected String makeDefaultName(String field) {
        return String.format("max_%s", field.replaceAll("\\.", "__"));
    }
}
