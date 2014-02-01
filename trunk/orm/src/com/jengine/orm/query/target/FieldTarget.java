package com.jengine.orm.query.target;

import com.jengine.orm.db.DBException;
import com.jengine.orm.db.query.SQLQuery;
import com.jengine.orm.multi.MultiModelField;
import com.jengine.orm.query.ModelQuery;

import java.util.Iterator;

public class FieldTarget extends Target {
    protected MultiModelField multiModelField;


    public FieldTarget(ModelQuery modelQuery) {
        super(modelQuery);
    }

    public FieldTarget(ModelQuery modelQuery, MultiModelField multiModelField) {
        super(modelQuery);
        this.multiModelField = multiModelField;
    }

    public void setSQL(SQLQuery query) {
        query.addTarget(multiModelField.getSQLName());
    }

    public Object processResult(Iterator itr) throws DBException {
        return multiModelField.getModelField().cast(super.processResult(itr));
    }
}
