package com.jengine.orm.field.numeric;


import java.util.Map;

import static com.jengine.utils.CollectionUtil.map;

public class FloatField extends RealField {
    public FloatField() {
        this(map());
    }

    public FloatField(Map<String, Object> options) {
        super(Float.class, options);
    }
}
