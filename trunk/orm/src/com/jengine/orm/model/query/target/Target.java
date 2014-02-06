package com.jengine.orm.model.query.target;

import com.jengine.orm.db.DBException;
import com.jengine.orm.db.query.SQLQuery;
import com.jengine.orm.model.query.ModelQuery;

import java.util.Iterator;

public abstract class Target {
    protected ModelQuery modelQuery;
    protected String name;

    protected Target(ModelQuery modelQuery) {
        this.modelQuery = modelQuery;
    }

    protected Target(ModelQuery modelQuery, String name) {
        this.modelQuery = modelQuery;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    abstract public String getSQLName();

    abstract public void setSQL(SQLQuery query);

    public Object processResult(Iterator itr) throws DBException {
        return itr.next();
    }
}
