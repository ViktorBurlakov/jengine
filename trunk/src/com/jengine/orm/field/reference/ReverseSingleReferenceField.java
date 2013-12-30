package com.jengine.orm.field.reference;

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
}
