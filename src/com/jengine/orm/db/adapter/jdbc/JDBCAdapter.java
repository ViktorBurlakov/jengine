package com.jengine.orm.db.adapter.jdbc;

import com.jengine.orm.db.DBConnection;
import com.jengine.orm.db.DBException;
import com.jengine.orm.db.adapter.Adapter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JDBCAdapter extends Adapter {
    private String driver;
    private String connection;
    private String user;
    private String password;

    public JDBCAdapter(String driver, String connection, String user, String password) throws DBException {
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

    public DBConnection newConnection() throws DBException {
        try {
            return new DBConnection(DriverManager.getConnection(this.connection, this.user, this.password));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException(e);
        }
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
