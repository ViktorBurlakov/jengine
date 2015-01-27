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
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.*;

public class LiferayAdapter extends Adapter {
    private static Log log = LogFactoryUtil.getLog(LiferayAdapter.class);

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
            log.debug(sql + "\n" + params);
            query.executeUpdate();
        } catch (Exception e) {
            throw new DBException(e);
        } finally {
            closeConnection(dbConnection);
        }
    }

    public List executeQuery(DBConnection dbConnection, String sql, List params,  LinkedHashMap<String, Integer> types) throws DBException {
        List items = new ArrayList();
        Session session = (Session) dbConnection.getNativeConnection();
        SQLQuery query = null;

        try {
            query = session.createSQLQuery(sql);
            QueryPos qpos = QueryPos.getInstance(query);
            for (Object item: params) {
                qpos.add(item);
            }
            log.debug(sql + "\n" + params);
            items = query.list();
//            for (Object item : items) {
//                if (item != null) {
//                    if (item.getClass().isArray()) {
//                        for (Object value : (Object[]) item) {
//                            System.out.println("1111111111 :" + value + " ;;;; type : " + (value != null ? value.getClass() : null));
//                        }
//                    }
//                }
//            }
//            System.out.println();
        } catch (Exception e) {
            throw new DBException(e);
        } finally {
            closeConnection(dbConnection);
        }

        return items;
    }

}
