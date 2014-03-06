package com.jengine.orm.model.query.target;

import com.jengine.orm.db.DBException;
import com.jengine.orm.db.query.SQLQuery;
import com.jengine.orm.model.query.BaseQuery;

import java.util.Iterator;

public abstract class Target {
    protected BaseQuery query;
    protected String name;

    protected Target(String name) {
        this.name = name;
    }

    public void config(BaseQuery query) {
        this.query = query;
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
