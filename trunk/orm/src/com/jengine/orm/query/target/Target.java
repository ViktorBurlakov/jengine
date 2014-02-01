package com.jengine.orm.query.target;

import com.jengine.orm.db.DBException;
import com.jengine.orm.db.query.SQLQuery;
import com.jengine.orm.query.ModelQuery;

import java.util.Iterator;

public abstract class Target {
    protected ModelQuery modelQuery;

    public Target(ModelQuery modelQuery) {
        this.modelQuery = modelQuery;
    }

    abstract public void setSQL(SQLQuery query);

    public Object processResult(Iterator itr) throws DBException {
        return itr.next();
    }
}
