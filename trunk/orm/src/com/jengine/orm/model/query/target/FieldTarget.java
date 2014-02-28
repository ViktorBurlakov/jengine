package com.jengine.orm.model.query.target;

import com.jengine.orm.db.DBException;
import com.jengine.orm.db.query.SQLQuery;
import com.jengine.orm.model.multi.MultiModelField;

import java.util.Iterator;

public class FieldTarget extends Target {
    protected MultiModelField multiModelField;

    public FieldTarget(String name) {
        super(name);
    }

    public FieldTarget(MultiModelField multiModelField) {
        super(multiModelField.getName());
        this.multiModelField = multiModelField;
    }

    public FieldTarget(String name, MultiModelField multiModelField) {
        super(name);
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
