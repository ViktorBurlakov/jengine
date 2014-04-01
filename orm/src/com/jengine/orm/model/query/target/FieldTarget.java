package com.jengine.orm.model.query.target;

import com.jengine.orm.db.DBException;
import com.jengine.orm.db.query.SQLQuery;
import com.jengine.orm.model.multi.field.CalcMultiField;
import com.jengine.orm.model.multi.field.FunctionMultiField;
import com.jengine.orm.model.multi.field.MultiModelField;

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
        if (multiModelField instanceof FunctionMultiField || multiModelField instanceof CalcMultiField) {
            query.addTarget(multiModelField.toSQL(), multiModelField.getSQLName());
        } else {
            query.addTarget(multiModelField.toSQL());
        }

    }

    public Object processResult(Iterator itr) throws DBException {
        return multiModelField.cast(super.processResult(itr));
    }
}
