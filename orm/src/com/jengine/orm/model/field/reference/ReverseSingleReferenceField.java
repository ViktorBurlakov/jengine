package com.jengine.orm.model.field.reference;

import com.jengine.orm.model.Model;
import com.jengine.orm.model.ModelClassBase;
import com.jengine.orm.db.DBException;

import static com.jengine.utils.CollectionUtil.map;

public class ReverseSingleReferenceField extends BaseReference {
    public ReverseSingleReferenceField(Class fieldClass, String reverseFieldName) {
        super(fieldClass, map("reverseFieldName", reverseFieldName));
    }

    public ReverseSingleReferenceField(Class fieldClass, String referenceModelName, String reverseFieldName) {
        super(fieldClass, referenceModelName, map("reverseFieldName", reverseFieldName));
    }

    public Type getType() {
        return Type.REVERSE_SINGLE_REFERENCE;
    }

    public Object getValue(Model obj) throws DBException {
        ModelClassBase referenceCls = getReferenceClass();
        SingleReferenceField singleField = (SingleReferenceField) getReverseField();
        Object key = obj.getData().get(singleField.getReferenceModelKey().getFieldName());
        return referenceCls.filter(singleField.eq(key)).one();
    }
}
