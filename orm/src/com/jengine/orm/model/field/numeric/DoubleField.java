package com.jengine.orm.model.field.numeric;


import java.util.Map;

import static com.jengine.utils.CollectionUtil.map;

public class DoubleField extends RealField {
    public DoubleField() {
        this(map());
    }

    public DoubleField(DoubleField fieldClass) {
        super(fieldClass);
    }

    public DoubleField(Map<String, Object> options) {
        super(Double.class, options);
    }
}
