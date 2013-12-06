package com.jengine.orm.db.adapter;


import com.jengine.orm.db.DBConnection;
import com.jengine.orm.db.DBException;

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
