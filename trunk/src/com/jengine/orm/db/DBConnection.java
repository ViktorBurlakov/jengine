package com.jengine.orm.db;


import java.util.ArrayList;
import java.util.List;

public abstract class DBConnection {
    private Object nativeConnection;
    private List generatedKeys = new ArrayList();

    public DBConnection(Object nativeConnection) {
        this.nativeConnection = nativeConnection;
    }

    abstract public void close() throws DBException;

    abstract public void startTransaction() throws DBException ;

    abstract public void commit() throws DBException;

    abstract public void rollback() throws DBException;

    abstract public void finishTransaction() throws DBException;

    public DBSavePoint savePoint(String name) throws DBException {
        return null;
    }

    public DBSavePoint savePoint() throws DBException {
        return null;
    }

    public void releasePoint(DBSavePoint point) throws DBException {
    }

    public void rollback(DBSavePoint point) throws DBException {

    }

    public boolean isTransactionActive() throws DBException {
        return false;
    }

    public boolean isSavePointSupport() {
        return false;
    }

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
