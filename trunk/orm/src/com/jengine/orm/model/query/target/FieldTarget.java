package com.jengine.orm.model.query.target;

import com.jengine.orm.db.DBException;
import com.jengine.orm.db.query.SQLQuery;
import com.jengine.orm.model.multi.MultiModelField;
import com.jengine.orm.model.query.ModelQuery;

import java.util.Iterator;

public class FieldTarget extends Target {
    protected MultiModelField multiModelField;


    public FieldTarget(ModelQuery modelQuery, String name) {
        super(modelQuery, name);
    }

    public FieldTarget(ModelQuery modelQuery, MultiModelField multiModelField) {
        super(modelQuery, multiModelField.getName());
        this.multiModelField = multiModelField;
    }

    public FieldTarget(ModelQuery modelQuery, String name, MultiModelField multiModelField) {
        super(modelQuery, name);
        this.multiModelField = multiModelField;
    }

    public String getSQLName() {
        return multiModelField.getSQLName();
    }

    public void setSQL(SQLQuery query) {
        query.addTarget(multiModelField.getSQLName());
    }

    public Object processResult(Iterator itr) throws DBException {
        return multiModelField.getModelField().cast(super.processResult(itr));
    }
}
