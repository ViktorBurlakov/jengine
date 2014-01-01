package com.jengine.orm.field.numeric;


import com.jengine.orm.field.Field;

import java.util.Map;

import static com.jengine.utils.CollectionUtil.map;

public class RealField extends Field {
    private Integer precision;
    private Integer scale;

    public RealField(Class fieldClass) {
        this(fieldClass, map());
    }

    public RealField(Class fieldClass, Map<String, Object> options) {
        super(fieldClass, options);
        if (options.containsKey("precision")) {
            precision = (Integer) options.get("precision");
        }
        if (options.containsKey("scale")) {
            scale = (Integer) options.get("scale");
        }
    }
}
