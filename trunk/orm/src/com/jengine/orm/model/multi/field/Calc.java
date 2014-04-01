package com.jengine.orm.model.multi.field;


import java.util.List;
import java.util.Map;

import static com.jengine.utils.CollectionUtil.map;
import static com.jengine.utils.CollectionUtil.toList;

public class Calc extends CalcMultiField {

    public Calc(Class fieldClass, Integer columnType, String expression, List<String> fields, Map<String, Object> options) {
        super(fieldClass, columnType, expression, fields, options);
    }

    public Calc(String name, Class fieldClass, Integer columnType, String expression, List<String> fields, Map<String, Object> options) {
        super(name, fieldClass, columnType, expression, fields, options);
    }

    public Calc(String name, Class fieldClass, String expr, String ... fields) {
        super(name, fieldClass, null,  expr, toList(fields), map());
    }
}
