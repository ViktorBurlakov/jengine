package com.jengine.orm.model.multi.field.aggregation;


import com.jengine.orm.model.field.Field;
import com.jengine.orm.model.multi.MultiModel;
import com.jengine.orm.model.multi.field.CalcMultiField;

import static com.jengine.utils.CollectionUtil.list;
import static com.jengine.utils.CollectionUtil.map;

public class Min extends CalcMultiField {

    public Min(String field) {
        super(null, null, "min(%s)", list(field), map());
        name = makeDefaultName(field);
    }

    public Min(Field field) {
        super(field.getFieldClass(), field.getColumnType(), "min(%s)", list(field.getFieldName()), map());
        name = makeDefaultName(field.getFieldName());
    }

    public void config(MultiModel multiModel) {
        super.config(multiModel);
        fieldClass = multiModel.getFields().get(fields.get(0)).getModelField().getFieldClass();
        columnType = multiModel.getFields().get(fields.get(0)).getModelField().getColumnType();
    }

    protected String makeDefaultName(String field) {
        return String.format("min_%s", field.replaceAll("\\.", "__"));
    }

}
