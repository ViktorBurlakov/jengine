package com.jengine.orm.db.adapter.jdbc;

import com.jengine.orm.db.DBConnection;
import com.jengine.orm.db.DBException;
import com.jengine.orm.db.DBTransaction;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;

public class JDBCTransaction extends DBTransaction {
    private Savepoint savepoint = null;

    public JDBCTransaction(DBConnection connection) {
        super(connection);
    }

    public JDBCTransaction(DBTransaction parent, DBConnection connection) {
        super(parent, connection);
    }

    public void start() throws DBException {
        try {
            Connection nativeConnection = (Connection) getConnection().getNativeConnection();
            if (!getConnection().isTransactionActive()) {
                nativeConnection.setAutoCommit(false);
            }
            if (getConnection().isNestedTransactionSupport()) {
                savepoint = nativeConnection.setSavepoint();
            }
            System.out.println(" TRANSACTION STARTED");
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public void commit() throws DBException {
        try {
            ((Connection)getConnection().getNativeConnection()).commit();
            System.out.println("    commit");
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public void rollback() throws DBException {
        try {
            if (getParent() == null) {
                ((Connection)getConnection().getNativeConnection()).rollback();
                System.out.println("    rollback");
            } else if (getConnection().isNestedTransactionSupport()) {
                ((Connection)getConnection().getNativeConnection()).rollback(savepoint);
                System.out.println("    rollback");
            }
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public void finish() throws DBException {
        try {
            Connection nativeConnection = (Connection) getConnection().getNativeConnection();
            if (getConnection().isNestedTransactionSupport()) {
                nativeConnection.releaseSavepoint(savepoint);
            }
            if (getParent() == null) {
                nativeConnection.setAutoCommit(true);
            }
            System.out.println(" TRANSACTION FINISHED");
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }
}
