package com.jengine.orm.db.adapter.jdbc.connection;


import com.jengine.orm.db.DBConnection;
import com.jengine.orm.db.DBException;
import com.jengine.orm.db.adapter.ConnectionManager;
import com.jengine.orm.db.adapter.jdbc.JDBCConnection;

import java.sql.DriverManager;

public class SingleConnectionManager extends ConnectionManager{
    private String driver;
    private String connection;
    private String user;
    private String password;

    public SingleConnectionManager(String driver, String connection, String user, String password) throws DBException {
        super();
        this.driver = driver;
        this.connection = connection;
        this.user = user;
        this.password = password;
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new DBException(e);
        }
    }

    public DBConnection getConnection() throws DBException {
        try {
            return new JDBCConnection(DriverManager.getConnection(this.connection, this.user, this.password));
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException(e);
        }
    }
}
