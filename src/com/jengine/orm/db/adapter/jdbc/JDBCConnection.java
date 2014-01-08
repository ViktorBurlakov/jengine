package com.jengine.orm.db.adapter.jdbc;

import com.jengine.orm.db.DBConnection;
import com.jengine.orm.db.DBException;
import com.jengine.orm.db.DBSavePoint;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;


public class JDBCConnection extends DBConnection {

    public JDBCConnection(Object nativeConnection) throws DBException {
        super(nativeConnection);
        if (isTransactionActive()) {
            startTransaction();
        }
    }

    public void startTransaction() throws DBException {
        try {
            getNativeConnection().setAutoCommit(false);
            System.out.println("Transaction started!");
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public void commit() throws DBException {
        try {
            getNativeConnection().commit();
            System.out.println("Transaction commited!");
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public void rollback() throws DBException {
        try {
            getNativeConnection().rollback();
            System.out.println("Transaction rollback!");
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public void finishTransaction() throws DBException {
        try {
            getNativeConnection().setAutoCommit(true);
            System.out.println("Transaction finish!");
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public DBSavePoint savePoint(String name) throws DBException {
        try {
            System.out.println("Save Point '" + name + "' start");
            return new DBSavePoint(getNativeConnection().setSavepoint(name));
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public DBSavePoint savePoint() throws DBException {
        try {
            System.out.println("Save Point start");
            return new DBSavePoint(getNativeConnection().setSavepoint());
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public void releasePoint(DBSavePoint point) throws DBException {
        try {
            getNativeConnection().releaseSavepoint((Savepoint) point.getNativeObject());
            System.out.println("Save Point released");
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public void rollback(DBSavePoint point) throws DBException {
        try {
            getNativeConnection().rollback((Savepoint) point.getNativeObject());
            System.out.println("Save Point rollback : " +((Savepoint) point.getNativeObject()).getSavepointId());
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public boolean isNestedTransactionSupport() {
        return true;
    }

    public boolean isTransactionActive() throws DBException {
        try {
            return getNativeConnection().getAutoCommit() == false;
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public Connection getNativeConnection() {
        return (Connection) super.getNativeConnection();
    }
}
