package com.jengine.orm.db.adapter;


import com.jengine.orm.db.DBConnection;
import com.jengine.orm.db.DBException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.jengine.utils.CollectionUtil.map;

public class Adapter {
    private String dialect;
    private ThreadLocal<DBConnection> threadConnection = new ThreadLocal<DBConnection>();
    protected ConnectionManager connectionManager;

    public Adapter(ConnectionManager connectionManager) throws DBException {
        this.connectionManager = connectionManager;
    }

    public DBConnection getConnection() throws DBException {
        if (threadConnection.get() == null) {
            threadConnection.set(connectionManager.getConnection());
        }
        return threadConnection.get();
    }

    public void closeConnection(DBConnection connection) throws DBException {
        threadConnection.remove();
        connectionManager.closeConnection(connection);
    }

    public void executeUpdate(DBConnection dbConnection, String sql, List params) throws DBException {
        executeUpdate(dbConnection, sql, params, map());
    }

    public void executeUpdate(DBConnection dbConnection, String sql, List params, Map<String, Object> options) throws DBException {
    }

    public List executeQuery(DBConnection dbConnection, String sql, List params) throws DBException {
        return new ArrayList();
    }

    public String getDialect() {
        return dialect;
    }

    public void setDialect(String dialect) {
        this.dialect = dialect;
    }
}
