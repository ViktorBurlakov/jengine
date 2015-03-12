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

package com.cetus.jengine.orm.core.db.provider;


import com.cetus.jengine.orm.core.db.DBConnection;
import com.cetus.jengine.orm.core.db.DBException;
import com.cetus.jengine.orm.core.db.adapter.Adapter;
import com.cetus.jengine.orm.core.db.cache.CacheManager;
import com.cetus.jengine.orm.core.db.filter.SQLFilter;
import com.cetus.jengine.orm.core.db.filter.SQLStringFilter;
import com.cetus.jengine.orm.core.db.query.SQLQuery;
import com.cetus.jengine.utils.commons.CollectionUtil;
import com.cetus.jengine.utils.commons.expression.ExpressionData;
import com.cetus.jengine.utils.commons.expression.ExpressionNode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.cetus.jengine.utils.commons.CollectionUtil.*;


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
        if (cacheManager != null && cacheManager.getCache(table) == null) {
            cacheManager.addCache(table);
        }
    }

    public void unregister(String table) {
        tables.remove(table);
        if (cacheManager != null && cacheManager.getCache(table) != null) {
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

    public boolean isCacheEnabled() {
        return cacheManager != null;
    }

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
        return connection.getGeneratedKeys().size() == 1 ? connection.getGeneratedKeys().remove(0) : null;
    }

    public void update(String table, String keyName, Serializable id, Map<String, Object> attributes) throws DBException {
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
        params.add(id);
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
        return this.adapter.executeQuery(connection, sql, sqlQuery.getParams(), sqlQuery.getTargetTypes());
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

        sql.append(" INSERT INTO ").append(query.getTable().getItemList().get(0).getTable());
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

        sql.append(" DELETE ");
        if (query.getTable().getItemList().size() > 1) {
            sql.append(query.getTable().getItemList().get(0).getAlias()).append(".*");
        }
        sql.append(" FROM ");
        if (query.getTable().getItemList().size() == 1) {
            sql.append(query.getTable().getItemList().get(0).getTable());
        } else {
            sql.append(TableClause.build(query));
        }
        if (!query.isEmptyFilter()) {
            sql.append(" WHERE ").append(WhereClause.build(this, query));
        }

        return sql.toString();
    }

    protected String buildUpdateSQL(SQLQuery query) {
        StringBuffer sql = new StringBuffer();
        StringBuffer setClause = new StringBuffer();
        StringBuffer whereClause = new StringBuffer();

        sql.append(" UPDATE ").append(TableClause.build(query)).append(" ");

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
        if (!query.isEmptyFilter()) {
            sql.append(" WHERE ").append(WhereClause.build(this, query));
        }

        return sql.toString();
    }

    public String buildSelectSQL(SQLQuery query) {
        StringBuffer queryString = new StringBuffer();

        // select clause
        List<String> targets = new ArrayList<String>();
        for (Object[] target : query.getTargets()) {
            if (target[1] != null) {
                targets.add(String.format("%s AS %s", target));
            } else {
                targets.add((String) target[0]);
            }
        }
        queryString.append("SELECT ");
        if(query.getDistinct()) {
            queryString.append("DISTINCT ");
        }
        queryString.append(concat(targets, ", ")).append(" ");

        // from clause
        queryString.append("FROM ").append(TableClause.build(query)).append(" ");

        // where clause
        if (!query.isEmptyFilter()) {
            queryString.append("WHERE ").append(WhereClause.build(this, query)).append(" ");
        }

        // group clause
        if (query.getGroup().size() > 0) {
            queryString.append("GROUP BY ").append(concat(query.getGroup(), ", ")).append(" ");
        }

        // order clause
        if(!query.getOrder().isEmpty()) {
            queryString.append("ORDER BY ").append(query.getOrder().get("orderByCol"));
            if (query.getOrder().containsKey("orderByType") && query.getOrder().get("orderByType") != null) {
                queryString.append(" ").append(query.getOrder().get("orderByType"));
            }
            queryString.append(" ");
        }

        // limit clause
        if(query.getStart() != null && query.getEnd() != null) {
            queryString.append("LIMIT ").append(LimitClause.build(this, query)).append(" ");
        }

        return queryString.toString();
    }


    public static class LimitClause {
        public static StringBuffer build(Provider provider, SQLQuery query) {
            StringBuffer queryString = new StringBuffer();

            return queryString.append("?").append(", ").append("?");
        }

    }

    public static class WhereClause {

        public static StringBuffer build(Provider provider, SQLQuery query) {
            StringBuffer queryString = new StringBuffer();

            if (!query.isEmptyFilter()) {
                StringBuffer expressionClause = new StringBuffer();
                if (!query.getFilters().isEmpty()) {
                    for (String field : query.getFilters().keySet()) {
                        SQLFilter filter = query.getFilters().get(field);
                        if (expressionClause.length() > 0) {
                            expressionClause.append(" AND ");
                        }
                        Object value = filter.getValue() instanceof SQLQuery ?
                                String.format("(%s)", provider.buildSelectSQL((SQLQuery) filter.getValue())) : "?";
                        expressionClause.append(filter.getOperation().getSQL(field, value));
                    }
                }
                if (!query.getStringFilters().isEmpty()) {
                    for (SQLStringFilter stringFilter : query.getStringFilters()) {
                        if (expressionClause.length() > 0) {
                            expressionClause.append(" AND ");
                        }
                        // sub query building
                        for(int paramIndex = 0; paramIndex < stringFilter.getParams().size(); paramIndex++) {
                            Object param = stringFilter.getParams().get(paramIndex);
                            if (param != null && param.getClass().equals(SQLQuery.class)) {
                                stringFilter.putSQL(paramIndex, "(" + provider.buildSelectSQL((SQLQuery) param) + ")");
                            }
                        }
                        expressionClause.append(stringFilter.renderSQL());
                    }
                }
                queryString.append(expressionClause).append(" ");
            }

            return queryString;
        }
    }

    public static class TableClause {

        public static StringBuffer build(ExpressionNode node) {
            StringBuffer sql = new StringBuffer();

            if (node instanceof SQLQuery.Group) {
                SQLQuery.Group group = (SQLQuery.Group) node;
                sql.append("(").append(build(group.getChild())).append(")");
            } else if (node instanceof SQLQuery.Join) {
                SQLQuery.Join join = (SQLQuery.Join) node;
                sql.append(build(join.getLeftNode()));
                String joinKeyword;
                if (node instanceof SQLQuery.LeftJoin) {
                    joinKeyword = "LEFT JOIN";
                } else if (node instanceof SQLQuery.RightJoin) {
                    joinKeyword = "RIGHT JOIN";
                } else if (node instanceof SQLQuery.FullJoin) {
                    joinKeyword = "FULL JOIN";
                } else {
                    joinKeyword = "INNER JOIN";
                }
                sql.append(" ").append(joinKeyword).append(" ").append(build(join.getJoinNode()));
                sql.append(" ON ").append(join.getRestriction()).append(" ");
            } else if (node instanceof SQLQuery.And) {
                SQLQuery.And and = (SQLQuery.And) node;
                sql.append(build(and.getNodes().get(0))).append(", ").append(build(and.getNodes().get(1)));
            } else if (node instanceof ExpressionData){
                SQLQuery.TableItem item = (SQLQuery.TableItem) ((ExpressionData) node).getData();
                sql.append(item.getTable());
                if (item.getAlias() != null && item.getAlias().length() > 0 && !item.getAlias().equals(item.getTable())) {
                    sql.append(" AS ").append(item.getAlias());
                }
                sql.append(" ");
            }

            return sql;
        }

        public static StringBuffer build(SQLQuery query) {
            return build(query.getTable().getExpression());
        }
    }


}
