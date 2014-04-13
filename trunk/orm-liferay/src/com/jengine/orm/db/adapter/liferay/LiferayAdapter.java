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

package com.jengine.orm.db.adapter.liferay;

import com.jengine.orm.db.DBConnection;
import com.jengine.orm.db.DBException;
import com.jengine.orm.db.adapter.Adapter;
import com.jengine.orm.db.adapter.ConnectionManager;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LiferayAdapter extends Adapter {

    public LiferayAdapter(ConnectionManager connectionManager) throws DBException {
        super(connectionManager);
    }

    public DBConnection getConnection() throws DBException {
        return connectionManager.getConnection();
    }

    public void closeConnection(DBConnection connection) throws DBException {
        connectionManager.closeConnection(connection);
    }

    public void executeUpdate(DBConnection dbConnection, String sql, List params, Map<String, Object> options) throws DBException {
        Session session = (Session) dbConnection.getNativeConnection();
        SQLQuery query = null;

        try {
            query = session.createSQLQuery(sql);
            QueryPos qpos = QueryPos.getInstance(query);
            for (Object item: params) {
                qpos.add(item);
            }
            System.out.println(sql);
            System.out.println(params);
            query.executeUpdate();
        } catch (Exception e) {
            throw new DBException(e);
        }
    }

    public List executeQuery(DBConnection dbConnection, String sql, List params, List types) throws DBException {
        List items = new ArrayList();
        Session session = (Session) dbConnection.getNativeConnection();
        SQLQuery query = null;

        try {
            query = session.createSQLQuery(sql);
            QueryPos qpos = QueryPos.getInstance(query);
            for (Object item: params) {
                qpos.add(item);
            }
            System.out.println(sql);
            System.out.println(params);
            items = query.list();
        } catch (Exception e) {
            throw new DBException(e);
        }

        return items;
    }

}
