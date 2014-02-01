package com.jengine.utils.expression;


public class ExpressionData<Type> extends ExpressionNode {
    private Type data;

    public ExpressionData(Type data) {
        this.data = data;
    }

    public Type getData() {
        return data;
    }

    public void setData(Type data) {
        this.data = data;
    }
}
