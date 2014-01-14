package com.jengine.orm.db.adapter.jdbc.connection;


import com.jengine.orm.db.DBConnection;
import com.jengine.orm.db.DBException;
import com.jengine.orm.db.adapter.ConnectionManager;
import com.jengine.orm.db.adapter.jdbc.JDBCConnection;

import javax.sql.DataSource;

public class DBCPConnectionPool extends ConnectionManager {
    protected DataSource dataSource;

    public DBCPConnectionPool(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public DBConnection getConnection() throws DBException {
        try {
            return new JDBCConnection(this.dataSource.getConnection());
        } catch (Exception e) {
            throw new DBException(e);
        }
    }
}
