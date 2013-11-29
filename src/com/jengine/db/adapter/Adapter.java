package com.jengine.db.adapter;


import com.jengine.db.exception.DBException;

import java.util.ArrayList;
import java.util.List;

public class Adapter {
    public void executeUpdate(String sql, List params) throws DBException {
    }

    public List executeQuery(String sql, List params) throws DBException {
        return  new ArrayList();
    }
}
