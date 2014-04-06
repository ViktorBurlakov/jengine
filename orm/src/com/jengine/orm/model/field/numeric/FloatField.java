package com.jengine.orm.model.field.numeric;


import java.util.Map;

import static com.jengine.utils.CollectionUtil.map;

public class FloatField extends RealField {
    public FloatField() {
        this(map());
    }

    public FloatField(FloatField field) {
        super(field);
    }

    public FloatField(Map<String, Object> options) {
        super(Float.class, options);
    }
}
