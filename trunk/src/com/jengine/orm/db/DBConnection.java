package com.jengine.orm.db;


import java.util.ArrayList;
import java.util.List;

public abstract class DBConnection {
    private Object nativeConnection;
    private List generatedKeys = new ArrayList();

    public DBConnection(Object nativeConnection) {
        this.nativeConnection = nativeConnection;
    }

    abstract public void startTransaction() throws DBException;

    abstract public void commit() throws DBException;

    abstract public void rollback() throws DBException;

    abstract public void finishTransaction() throws DBException;

    abstract public boolean isTransaction() throws DBException;

    public Object getNativeConnection() {
        return nativeConnection;
    }

    public void setGeneratedKeys(List generatedKeys) {
        this.generatedKeys = generatedKeys;
    }

    public List getGeneratedKeys() {
        return generatedKeys;
    }
}
