package com.jengine.orm.db.adapter.jdbc;

import com.jengine.orm.db.DBConnection;
import com.jengine.orm.db.DBException;

import java.sql.Connection;
import java.sql.SQLException;


public class JDBCConnection extends DBConnection {
    private Boolean prevTransactionState = null;

    public JDBCConnection(Object nativeConnection) {
        super(nativeConnection);
    }

    public void startTransaction() throws DBException {
        try {
            prevTransactionState = getNativeConnection().getAutoCommit();
            getNativeConnection().setAutoCommit(false);
            System.out.println(" TRANSACTION STARTED");
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public void finishTransaction() throws DBException {
        try {
            getNativeConnection().setAutoCommit(prevTransactionState);
            prevTransactionState = null;
            System.out.println(" TRANSACTION FINISHED");
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public boolean isTransaction() throws DBException {
        try {
            return getNativeConnection().getAutoCommit() == false;
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public void commit() throws DBException {
        try {
            getNativeConnection().commit();
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public void rollback() throws DBException {
        try {
            getNativeConnection().rollback();
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public Connection getNativeConnection() {
        return (Connection) super.getNativeConnection();
    }
}
