/*
 * This file is part of JEngine.
 *
 * Copyright (C) 2013 Victor Burlakov
 *
 * JEngine is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JEngine is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with JEngine.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.jengine.orm.db.provider;


import com.jengine.orm.db.DBConnection;
import com.jengine.orm.db.DBException;
import com.jengine.orm.db.adapter.Adapter;
import com.jengine.orm.db.cache.CacheManager;
import com.jengine.orm.db.expression.Expression;
import com.jengine.orm.db.query.SQLQuery;
import com.jengine.orm.db.query.SQLStringExpression;
import com.jengine.utils.CollectionUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.jengine.utils.CollectionUtil.*;


public class Provider {
    private Adapter adapter;
    private CacheManager cacheManager;
    private List<String> tables = new ArrayList<String>();

    public Provider(Adapter adapter) {
        this.adapter = adapter;
    }

    public Provider(Adapter adapter, CacheManager cacheManager) {
        this.adapter = adapter;
        this.cacheManager = cacheManager;
    }

    /* table register method*/

    public void register(String table) {
        tables.add(table);
        if (cacheManager.getCache(table) == null) {
            cacheManager.addCache(table);
        }
    }

    public void unregister(String table) {
        tables.remove(table);
        if (cacheManager.getCache(table) != null) {
            cacheManager.removeCache(table);
        }
    }

    /* connection method */

    public DBConnection getConnection() throws DBException {
        return adapter.getConnection();
    }

    public void closeConnection(DBConnection connection) throws DBException {
        adapter.closeConnection(connection);
    }

    /* cache methods */

    public void addCache(String table) {
        cacheManager.addCache(table);
    }

    public void removeCache(String table) {
        cacheManager.removeCache(table);
    }

    public void cache(String table, Object id, Map<String, Object> attributes) {
        cacheManager.getCache(table).set(id, attributes);
    }

    public Map<String, Object> getCache(String table, Object id) {
        return (Map<String, Object>) cacheManager.getCache(table).get(id);
    }

    public void clearCache(String table, Object id) {
        cacheManager.getCache(table).remove(id);
    }

    public void clearCache(String table) {
        cacheManager.getCache(table).removeAll();
    }


    /* general methods */

    public Object insert(String table, Map<String, Object> attributes, boolean autoIncrement) throws DBException {
        List columns = new ArrayList();
        columns.addAll(attributes.keySet());

        return insert(table, columns, CollectionUtil.values(columns, attributes), autoIncrement);
    }

    public Object insert(String table, List<String> columns, List values, boolean autoIncrement) throws DBException {
        StringBuffer sql = new StringBuffer();
        List valuesMarks = newList(values.size(), "?");

        sql.append("INSERT INTO ")
                .append(table)
                .append(" (").append(concat(columns, ", ")).append(") ")
                .append(" VALUES ").append(" (").append(concat(valuesMarks, ", ")).append(") ");

        DBConnection connection = this.adapter.getConnection();
        this.adapter.executeUpdate(connection, sql.toString(), values, map("return_generated_keys", autoIncrement));
        return connection.getGeneratedKeys().size() == 1 ? connection.getGeneratedKeys().get(0) : null;
    }

    public void update(String table, String keyName, Map<String, Object> attributes) throws DBException {
        StringBuffer sql = new StringBuffer();
        List pairs = new ArrayList();
        List params = new ArrayList();

        for (String columnName : attributes.keySet()) {
            if (keyName.equals(columnName)) {
                continue;
            }
            StringBuffer pair = new StringBuffer();
            pair.append(columnName).append("=").append("?");
            pairs.add(pair.toString());
            params.add(attributes.get(columnName));
        }
        params.add(attributes.get(keyName));
        sql.append("UPDATE ").append(table).append(" SET ").append(concat(pairs, ", "))
                .append(" WHERE ").append(keyName).append("=").append("?");

        DBConnection connection = this.adapter.getConnection();
        this.adapter.executeUpdate(connection, sql.toString(), params);
    }

    public void remove(String table, String key, Serializable id) throws DBException {
        StringBuffer sql = new StringBuffer();
        List params = list(id);

        sql.append("DELETE FROM ").append(table).append(" WHERE ").append(key).append("=").append("?");

        DBConnection connection = this.adapter.getConnection();
        this.adapter.executeUpdate(connection, sql.toString(), params);
    }

    public Object insert(SQLQuery query) throws DBException {
        String sql = buildInsertSQL(query);
        DBConnection connection = this.adapter.getConnection();
        this.adapter.executeUpdate(connection, sql, query.getParams());
        return connection.getGeneratedKeys();
    }

    public void remove(SQLQuery query) throws DBException {
        String sql = buildRemoveSQL(query);
        DBConnection connection = this.adapter.getConnection();
        this.adapter.executeUpdate(connection, sql, query.getParams());
    }

    public void update(SQLQuery query) throws DBException{
        String sql = buildUpdateSQL(query);
        DBConnection connection = this.adapter.getConnection();
        this.adapter.executeUpdate(connection, sql, query.getParams());
    }

    public List select(SQLQuery sqlQuery) throws DBException {
        String sql = buildSelectSQL(sqlQuery);
        DBConnection connection = this.adapter.getConnection();
        return this.adapter.executeQuery(connection, sql, sqlQuery.getParams());
    }


    /* getters and setters */

    public Adapter getAdapter() {
        return adapter;
    }

    public void setAdapter(Adapter adapter) {
        this.adapter = adapter;
    }

    public CacheManager getCacheManager() {
        return cacheManager;
    }

    public void setCacheManager(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    /* protected methods */

    protected String buildInsertSQL(SQLQuery query) {
        StringBuffer sql = new StringBuffer();
        StringBuffer fieldClause = new StringBuffer();
        StringBuffer valueClause = new StringBuffer();

        sql.append(" INSERT INTO ").append(query.getTableName());
        for (String param :query.getValues().keySet()) {
            if (fieldClause.length() > 0) {
                fieldClause.append(", ");
            }
            fieldClause.append(param);
        }
        sql.append(" ").append("(").append(fieldClause).append(")");
        sql.append(" VALUES ");
        for (Object value :query.getValues().values()) {
            if (valueClause.length() > 0) {
                valueClause.append(", ");
            }
            valueClause.append("?");
        }
        sql.append(" ").append("(").append(valueClause).append(")");

        return sql.toString();
    }


    protected String buildRemoveSQL(SQLQuery query)  {
        StringBuffer sql = new StringBuffer();

        // todo: design new classes for sql query to do better
        if (query.getRelations().size() == 0) {
            query.setTableAlias(null);
        }
        sql.append(" DELETE ");
        if (query.getRelations().size() != 0) {
            sql.append(query.getTableAlias()).append(".*");
        }
        sql.append(" FROM ").append(buildTableClause(query)).append(" ").append(buildWhereClause(query));

        return sql.toString();
    }

    protected String buildUpdateSQL(SQLQuery query) {
        StringBuffer sql = new StringBuffer();
        StringBuffer setClause = new StringBuffer();
        StringBuffer whereClause = new StringBuffer();

        sql.append(" UPDATE ").append(buildTableClause(query)).append(" ");

        // set clause
        for (Object param :query.getValues().keySet()) {
            if (setClause.length() > 0) {
                setClause.append(", ");
            }
            setClause.append(param).append("=").append("?");
        }
        if (setClause.length() > 0) {
            sql.append(" SET ").append(setClause);
        }

        sql.append(buildWhereClause(query));

        return sql.toString();
    }

    protected String buildSelectSQL(SQLQuery query) {
        StringBuffer queryString = new StringBuffer();

        // select clause
        List<String> targets = new ArrayList<String>();
        for (Object[] target : query.getTargets()) {
            if (target.length > 1) {
                targets.add(String.format("%s AS %s", target));
            } else {
                targets.add((String) target[0]);
            }
        }
        queryString.append(" SELECT ").append(concat(targets, ", ")).append(" ");

        // from clause
        queryString.append(" FROM ").append(buildTableClause(query));

        // where clause
        queryString.append(buildWhereClause(query));

        // order clause
        if(!query.getOrder().isEmpty()) {
            queryString.append(" ORDER BY ").append(query.getOrder().get("orderByCol"));
            if (query.getOrder().containsKey("orderByType")) {
                queryString.append(" ").append(query.getOrder().get("orderByType"));
            }
            queryString.append("");
        }

        return queryString.toString();
    }

    protected StringBuffer buildWhereClause(SQLQuery query) {
        StringBuffer queryString = new StringBuffer();

        if (!query.getFitler().isEmpty() || !query.getStringExpressions().isEmpty()) {
            queryString.append(" WHERE ");
            StringBuffer expressionClause = new StringBuffer();
            if (!query.getFitler().isEmpty()) {
                for (String field : query.getFitler().keySet()) {
                    Expression expression = query.getFitler().get(field);
                    if (expressionClause.length() > 0) {
                        expressionClause.append(" AND ");
                    }
                    expressionClause.append(makeSQLExpr(field, expression.getOperation(), expression.getValue()));
                }
            }
            if (!query.getStringExpressions().isEmpty()) {
                for (SQLStringExpression stringExpression : query.getStringExpressions()) {
                    if (expressionClause.length() > 0) {
                        expressionClause.append(" AND ");
                    }
                    // sub query building
                    for(int paramIndex =0 ; paramIndex < stringExpression.getParams().size(); paramIndex++) {
                        Object param = stringExpression.getParams().get(paramIndex);
                        if (param != null && param.getClass().equals(SQLQuery.class)) {
                            stringExpression.putParamSQL(paramIndex, "(" + buildSelectSQL((SQLQuery) param) + ")");
                        }
                    }
                    expressionClause.append(stringExpression.getSQL());
                }
            }
            queryString.append(expressionClause).append(" ");
        }

        return queryString;
    }

    protected StringBuffer buildTableClause(SQLQuery query) {
        StringBuffer queryString = new StringBuffer();

        queryString.append(query.getTableName());
        if (query.getTableAlias() != null && query.getTableAlias().length() > 0) {
            queryString.append(" AS ").append(query.getTableAlias()).append(" ");
        }
        for (String alias : query.getRelations().keySet()) {
            String relation = (String) query.getRelations().get(alias).get(0);
            String expr = (String) query.getRelations().get(alias).get(1);
            queryString.append(" LEFT JOIN ").append(relation).append(" AS ").append(alias)
                    .append(" ON ").append(expr).append(" ");
        }
        return queryString;
    }

    protected String makeSQLExpr(String field, String operation, Object value) {
        StringBuffer expr = new StringBuffer();
        Object param = value.getClass().equals(SQLQuery.class) ?
                String.format("(%s)", buildSelectSQL((SQLQuery) value)) : "?";

        if ("eq".equals(operation)) {
            expr.append(field).append("=").append(param);
        } else if ("ge".equals(operation)) {
            expr.append(field).append( ">=").append(param);
        } else  if ("gt".equals(operation)) {
            expr.append(field).append(">").append(param);
        } else if ("le".equals(operation)) {
            expr.append(field).append("<=").append(param);
        } else  if ("lt".equals(operation)) {
            expr.append(field).append("<").append(param);
        } else if ("like".equals(operation)) {
            expr.append(field).append(" ").append("like").append(" ").append(param);
        } else if ("ne".equals(operation)) {
            expr.append(field).append("<>").append(param);
        } else if ("isnull".equals(operation)) {
            if ((Boolean) value) {
                expr.append(field).append(" ").append("is null").append(" ");
            } else  {
                expr.append(field).append(" ").append("is not null").append(" ");
            }
        } else if ("isempty".equals(operation)) {
            if ((Boolean) value) {
                expr.append(field).append("=").append("''");
            } else  {
                expr.append(field).append("<>").append("''");
            }
        } else {
            expr.append(field).append(operation).append(param);
        }

        return expr.toString();
    }
}
