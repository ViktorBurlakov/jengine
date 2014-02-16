package com.jengine.orm.model.field.reference;

import com.jengine.orm.model.field.Field;

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

    public Field newReverseField() {
        return new ReverseSingleReferenceField(fieldClass, manager.getName(), fieldName);
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
