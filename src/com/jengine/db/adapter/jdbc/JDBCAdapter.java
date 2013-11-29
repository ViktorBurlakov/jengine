package com.jengine.db.adapter.jdbc;

import com.jengine.db.adapter.Adapter;
import com.jengine.db.exception.DBException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCAdapter extends Adapter {
    private String driver;
    private String connection;
    private String user;
    private String password;

    public JDBCAdapter(String driver, String dialect, String connection, String user, String password) throws DBException {
        super();
        this.driver = driver;
        this.connection = connection;
        this.user = user;
        this.password = password;
    }

    public void executeUpdate(String sql, List params) throws DBException {
        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
            connection =  getConnection();
            pstmt = connection.prepareStatement(sql);
            int index = 0;
            for (Object item: params) {
                pstmt.setObject(index++, item);
            }
            System.out.println(sql);
            pstmt.executeUpdate();
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

    public List executeQuery(String sql, List params) throws DBException {
        List items = new ArrayList();
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            connection =  getConnection();
            pstmt = connection.prepareStatement(sql);
            int index = 0;
            for (Object item: params) {
                pstmt.setObject(index++, item);
            }
            System.out.println(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                List record = new ArrayList();
                for (int i=0; i< rs.getMetaData().getColumnCount(); i++) {
                    record.add(rs.getObject(i+1));
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

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(this.connection, this.user, this.password);
    }

}
