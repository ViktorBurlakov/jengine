package com.jengine.orm.field;


import java.util.Map;

import static com.jengine.utils.CollectionUtil.map;

public class DoubleField extends RealField {
    public DoubleField() {
        this(map());
    }

    public DoubleField(Map<String, Object> options) {
        super(Double.class, options);
    }
}
