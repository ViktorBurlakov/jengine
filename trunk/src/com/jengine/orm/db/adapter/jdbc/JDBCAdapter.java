package com.jengine.orm.db.adapter.jdbc;

import com.jengine.orm.db.DBConnection;
import com.jengine.orm.db.DBException;
import com.jengine.orm.db.adapter.Adapter;
import com.jengine.orm.db.adapter.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JDBCAdapter extends Adapter {

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
            System.out.println(sql);
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

    public List executeQuery(DBConnection dbConnection, String sql, List params) throws DBException {
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
            System.out.println(sql);
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
