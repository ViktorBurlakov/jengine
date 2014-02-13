package com.jengine.orm.model.field.aggregation;


import com.jengine.orm.model.ModelClassBase;
import com.jengine.orm.model.field.Field;
import com.jengine.orm.model.field.FunctionField;

public class Calc extends FunctionField {

    public Calc(ModelClassBase modelClass, String name, Class type, String expr, Field ... fields) {
        super(type, expr, (Field[]) fields);
        config(name, modelClass.getManager()) ;
    }

    public Calc(Class type, String expr, Field ... fields) {
        super(type, expr, (Field[]) fields);
    }
}
