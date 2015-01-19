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

package com.jengine.orm.db.adapter.jdbc;

import com.jengine.orm.db.DBConnection;
import com.jengine.orm.db.DBException;
import com.jengine.orm.db.adapter.Adapter;
import com.jengine.orm.db.adapter.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class JDBCAdapter extends Adapter {
    private static Logger logger = Logger.getLogger(JDBCAdapter.class.getName());

    public JDBCAdapter(ConnectionManager connectionManager) throws DBException {
        super(connectionManager);
    }

    public void executeUpdate(DBConnection dbConnection, String sql, List params, Map<String, Object> options) throws DBException {
        Connection connection = (Connection) dbConnection.getNativeConnection();
        PreparedStatement pstmt = null;
        Boolean returnGeneratedKeys = options.containsKey("return_generated_keys") ?
                (Boolean) options.get("return_generated_keys") : false;

        try {
            pstmt = connection.prepareStatement(sql, returnGeneratedKeys ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS);
            int index = 1;
            for (Object item: params) {
                pstmt.setObject(index++, item);
            }
            logger.info(sql + "\n" + params.toString());
            pstmt.executeUpdate();
            if (returnGeneratedKeys) {
                List generatedKeys = new ArrayList();
                ResultSet rs = pstmt.getGeneratedKeys();
                while (rs.next()) {
                    generatedKeys.add(rs.getObject(1));
                }
                dbConnection.setGeneratedKeys(generatedKeys);
            }
        } catch (Exception e) {
            throw new DBException(e);
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    new DBException(e);
                }
            }
        }
    }

    public List executeQuery(DBConnection dbConnection, String sql, List params, LinkedHashMap<String, Integer> types) throws DBException {
        List items = new ArrayList();
        Connection connection = (Connection) dbConnection.getNativeConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = connection.prepareStatement(sql);
            int index = 1;
            for (Object item: params) {
                pstmt.setObject(index++, item);
            }
            logger.info(sql + "\n" + params.toString());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Object[] record = new Object[rs.getMetaData().getColumnCount()];
                for (int i=0; i< rs.getMetaData().getColumnCount(); i++) {
                    record[i] = rs.getObject(i+1);
                }
                items.add(record);
            }
        } catch (Exception e) {
            throw new DBException(e);
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    new DBException(e);
                }
            }
        }

        return items;
    }

}
