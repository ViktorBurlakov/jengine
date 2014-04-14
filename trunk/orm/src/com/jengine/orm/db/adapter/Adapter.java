/*
 *  This file is part of JEngine.
 *  *
 *  * Copyright (C) 2013-2014 Cetus (http://cs1.com.ua/). All rights reserved.
 *  *
 *  * JEngine is free software: you can redistribute it and/or modify
 *  * it under the terms of the GNU General Public License as published by
 *  * the Free Software Foundation, either version 3 of the License, or
 *  * (at your option) any later version.
 *  *
 *  * JEngine is distributed in the hope that it will be useful,
 *  * but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  * GNU General Public License for more details.
 *  *
 *  * You should have received a copy of the GNU General Public License
 *  * along with JEngine.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.jengine.orm.db.adapter;


import com.jengine.orm.db.DBConnection;
import com.jengine.orm.db.DBException;

import java.util.ArrayList;
import java.util.LinkedHashMap;
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

    public List executeQuery(DBConnection dbConnection, String sql, List params, LinkedHashMap<String, Integer> types) throws DBException {
        return new ArrayList();
    }

    public String getDialect() {
        return dialect;
    }

    public void setDialect(String dialect) {
        this.dialect = dialect;
    }
}
