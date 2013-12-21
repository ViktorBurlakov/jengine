package com.jengine.orm.field;


import java.util.HashMap;
import java.util.Map;

public class ReverseManyReferenceField extends ManyReferenceField {
    public ReverseManyReferenceField(Class fieldClass) {
        this(fieldClass.getSimpleName());
    }

    public ReverseManyReferenceField(String referenceModelName) {
        this(referenceModelName, new HashMap<String, Object>());
    }

    public ReverseManyReferenceField(String referenceModelName, Map<String, Object> options) {
        super(referenceModelName, options);
    }

    public Type getType() {
        return Type.REVERSE_MANY_REFERENCE;
    }
}
