package com.jengine.orm.model.field;


import com.jengine.orm.model.ModelClassBase;

public class Calc extends FunctionField {

    public Calc(String name, Class type, String expr, Field ... fields) {
        super(type, expr, (Field[]) fields);
        this.fieldName = name;
    }

    public Calc(ModelClassBase modelClass, String name, Class type, String expr, Field ... fields) {
        super(type, expr, (Field[]) fields);
        config(name, modelClass.getManager()) ;
    }

    public Calc(Class type, String expr, Field ... fields) {
        super(type, expr, (Field[]) fields);
    }
}
