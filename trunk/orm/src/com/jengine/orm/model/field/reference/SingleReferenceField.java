package com.jengine.orm.model.field.reference;

import java.util.Map;

public class SingleReferenceField extends ReferenceField {

    public SingleReferenceField(Class fieldClass) {
        super(fieldClass);
    }

    public SingleReferenceField(Class fieldClass, Object... options) {
        super(fieldClass, options);
    }

    public SingleReferenceField(Class fieldClass, Map<String, Object> options) {
        super(fieldClass, options);
    }

    public Type getType() {
        return Type.SINGLE_REFERENCE;
    }

    public String getReverseFieldName() {
        return reverseFieldName != null ? reverseFieldName : manager.getName().toLowerCase();
    }

    public boolean isPersistence() {
        return true;
    }
}
