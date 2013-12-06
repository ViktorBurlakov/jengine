package com.jengine.db.adapter;


import com.jengine.db.DBConnection;
import com.jengine.db.exception.DBException;

import java.util.ArrayList;
import java.util.List;

public class Adapter {

    public DBConnection getConnection() throws DBException {
        return null;
    }

    public void executeUpdate(DBConnection dbConnection, String sql, List params) throws DBException {
    }

    public List executeQuery(DBConnection dbConnection, String sql, List params) throws DBException {
        return  new ArrayList();
    }
}
