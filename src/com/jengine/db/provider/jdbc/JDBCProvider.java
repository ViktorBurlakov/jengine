package com.jengine.db.provider.jdbc;

import com.jengine.db.ModelQuery;
import com.jengine.db.exception.DBException;
import com.jengine.db.provider.Provider;
import com.jengine.db.query.SQLQuery;
import com.jengine.db.query.SQLQueryBuilder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCProvider extends Provider {
    private String driver;
    private String dialect;
    private SQLQueryBuilder builder;
    private String connection;
    private String user;
    private String password;

    public JDBCProvider(String driver, String dialect, String connection, String user, String password) throws DBException {
        super();
        this.driver = driver;
        this.dialect = dialect;
        this.connection = connection;
        this.user = user;
        this.password = password;
        try {
            Class.forName(driver);
            String builderClassName = String.format("com.jengine.db.query.dialect.%s.QueryBuilder", dialect.toLowerCase());
            this.builder = (SQLQueryBuilder) Class.forName(builderClassName).newInstance();
        } catch (InstantiationException e) {
            new DBException(e.getMessage());
        } catch (IllegalAccessException e) {
            new DBException(e.getMessage());
        } catch (ClassNotFoundException e) {
            new DBException(e.getMessage());
        }
    }

    public Object newPrimaryKey(Class cls) {
        return  0;
    }

    public void insert(ModelQuery modelQuery) throws DBException {
        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
            connection =  getConnection();
            SQLQuery sqlQuery = this.builder.buildInsert(modelQuery);
            String sql = this.builder.buildInsertSQL(sqlQuery);
            pstmt = connection.prepareStatement(sql);
            int index = 0;
            for (Object item: sqlQuery.getParams()) {
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

    public void remove(ModelQuery modelQuery) throws DBException {
        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
            connection =  getConnection();
            SQLQuery sqlQuery = this.builder.buildRemove(modelQuery);
            String sql = this.builder.buildRemoveSQL(sqlQuery);
            pstmt = connection.prepareStatement(sql);
            int index = 0;
            for (Object item: sqlQuery.getParams()) {
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

    public void update(ModelQuery modelQuery) throws DBException {
        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
            connection =  getConnection();
            SQLQuery sqlQuery = this.builder.buildUpdate(modelQuery);
            String sql = this.builder.buildUpdateSQL(sqlQuery);
            pstmt = connection.prepareStatement(sql);
            int index = 0;
            for (Object item: sqlQuery.getParams()) {
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

    public List select(ModelQuery modelQuery) throws DBException {
        List items = new ArrayList();
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            connection =  getConnection();
            SQLQuery sqlQuery = this.builder.buildSelect(modelQuery);
            String sql = this.builder.buildSelectSQL(sqlQuery);
            pstmt = connection.prepareStatement(sql);
            int index = 0;
            for (Object item: sqlQuery.getParams()) {
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
