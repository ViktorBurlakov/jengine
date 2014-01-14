package com.jengine.orm.db.adapter;

import com.jengine.orm.db.DBConnection;
import com.jengine.orm.db.DBException;

public abstract class ConnectionManager {

    abstract public DBConnection getConnection() throws DBException;

    public void closeConnection(DBConnection connection) throws DBException {
        connection.close();
    }
}
