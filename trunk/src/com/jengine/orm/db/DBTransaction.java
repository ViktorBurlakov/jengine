package com.jengine.orm.db;

public class DBTransaction {
    private DBTransaction parent;
    private DBConnection connection;

    public DBTransaction(DBConnection connection) {
        this.connection = connection;
    }

    public DBTransaction(DBTransaction parent, DBConnection connection) {
        this.parent = parent;
        this.connection = connection;
    }

    public void start() throws DBException {
    }

    public void commit() throws DBException {

    }

    public void rollback() throws DBException {

    }

    public void finish() throws DBException {
    }

    public DBTransaction getParent() {
        return parent;
    }

    public void setParent(DBTransaction parent) {
        this.parent = parent;
    }

    public DBConnection getConnection() {
        return connection;
    }

    public void setConnection(DBConnection connection) {
        this.connection = connection;
    }
}
