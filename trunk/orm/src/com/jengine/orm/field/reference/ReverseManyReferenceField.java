package com.jengine.orm.field.reference;


import com.jengine.orm.field.Field;

import java.util.HashMap;
import java.util.Map;

public class ReverseManyReferenceField extends ManyReferenceField {

    public ReverseManyReferenceField(Class fieldClass) {
        super(fieldClass);
    }

    public ReverseManyReferenceField(Class fieldClass, String referenceModelName) {
        super(fieldClass, referenceModelName, new HashMap<String, Object>());
    }

    public ReverseManyReferenceField(Class fieldClass, String referenceModelName, Map<String, Object> options) {
        super(fieldClass, referenceModelName, options);
    }

    public Field.Type getType() {
        return Field.Type.REVERSE_MANY_REFERENCE;
    }
}
