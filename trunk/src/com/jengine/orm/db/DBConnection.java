package com.jengine.orm.db;


import com.jengine.orm.db.adapter.jdbc.JDBCTransaction;

import java.util.ArrayList;
import java.util.List;

public abstract class DBConnection {
    private Object nativeConnection;
    private List generatedKeys = new ArrayList();
    protected DBTransaction transaction = null;

    public DBConnection(Object nativeConnection) {
        this.nativeConnection = nativeConnection;
    }

    public void startTransaction() throws DBException {
        transaction = new JDBCTransaction(transaction, this);
        transaction.start();
    }

    public void commit() throws DBException {
        transaction.commit();
    }

    public void rollback() throws DBException {
        transaction.rollback();
    }

    public void finishTransaction() throws DBException {
        transaction.finish();
        transaction = transaction.getParent();
    }

    public boolean isTransactionActive() throws DBException {
        return transaction != null;
    }

    public boolean isNestedTransactionSupport() {
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

    public DBTransaction getTransaction() {
        return transaction;
    }

    public void setTransaction(DBTransaction transaction) {
        this.transaction = transaction;
    }
}
