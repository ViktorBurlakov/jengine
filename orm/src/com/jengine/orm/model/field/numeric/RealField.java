package com.jengine.orm.model.field.numeric;


import com.jengine.orm.model.field.Field;

import java.util.Map;

import static com.jengine.utils.CollectionUtil.map;

public class RealField extends Field {
    private Integer precision;
    private Integer scale;

    public RealField(RealField field) {
        super(field);
        this.precision = field.getPrecision();
        this.scale = field.getScale();

    }

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

    public Integer getPrecision() {
        return precision;
    }

    public void setPrecision(Integer precision) {
        this.precision = precision;
    }

    public Integer getScale() {
        return scale;
    }

    public void setScale(Integer scale) {
        this.scale = scale;
    }
}
