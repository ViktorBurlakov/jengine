package com.jengine.orm.db.adapter.jdbc;

import com.jengine.orm.db.DBConnection;
import com.jengine.orm.db.DBException;

import java.sql.Connection;
import java.sql.SQLException;


public class JDBCConnection extends DBConnection {

    public JDBCConnection(Object nativeConnection) throws DBException {
        super(nativeConnection);
        if (isTransactionActive()) {
            startTransaction();
        }
    }

    public boolean isNestedTransactionSupport() {
        return true;
    }

    public boolean isTransactionActive() throws DBException {
        try {
            return ((Connection) getNativeConnection()).getAutoCommit() == false;
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }
}
