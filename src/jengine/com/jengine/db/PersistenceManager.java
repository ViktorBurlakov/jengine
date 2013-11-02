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

package com.jengine.db;


import com.jengine.db.field.Field;
import com.jengine.db.field.ForeignField;
import com.jengine.db.field.FunctionField;
import com.jengine.db.field.ReferenceField;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.BasePersistence;

import javax.sql.DataSource;
import java.util.*;

import static com.jengine.utils.CollectionUtil.concat;
import static com.jengine.utils.CollectionUtil.list;


public class PersistenceManager {
    private Dialect dialect = ((SessionFactory) PortalBeanLocatorUtil.locate("liferaySessionFactory")).getDialect();
    private ModelManager manager;

    public PersistenceManager(ModelManager manager) {
        this.manager = manager;
    }

    public void remove(List<Expression> filter, BasePersistence persistence) throws SystemException {
        List items = new ArrayList();
        Session session = null;
        List<Integer> types = new ArrayList<Integer>();
        List params = new ArrayList();

        try {
            StringBuffer sql = new StringBuffer();
            StringBuffer whereClause = new StringBuffer();

            sql.append(" DELETE FROM ").append(manager.getTableName()).append(" ");

            // where clause
            for (Expression expression : filter) {
                if (whereClause.length() > 0) {
                    whereClause.append(", ");
                }
                Field modelField = manager.getField(expression.getField());
                whereClause.append(makeSQLExpr(expression.getField(), expression.getOperation(), expression.getValue()));
                types.add(modelField.getDbType());
                params.add(expression.getValue());
            }
            if (whereClause.length() > 0) {
                sql.append(" WHERE ").append(whereClause);
            }

            // execute
            DataSource dataSource = persistence.getDataSource();
            System.out.println(sql.toString());
            SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource, sql.toString(), toIntArray(types));
            sqlUpdate.update(params.toArray());
            persistence.clearCache();
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }

    public void update(List<Expression> filter, Map<String, Object> values, BasePersistence persistence) throws SystemException {
        List items = new ArrayList();
        Session session = null;
        List<Integer> types = new ArrayList<Integer>();
        List params = new ArrayList();

        try {
            StringBuffer sql = new StringBuffer();
            StringBuffer setClause = new StringBuffer();
            StringBuffer whereClause = new StringBuffer();

            sql.append(" UPDATE ").append(manager.getTableName()).append(" ");

            // set clause
            for (String param : values.keySet()) {
                if (setClause.length() > 0) {
                        setClause.append(", ");
                }
                Field modelField = manager.getField(param);
                setClause.append(param).append("=").append("?");
                types.add(modelField.getDbType());
            }
            if (setClause.length() > 0) {
                sql.append(" SET ").append(setClause);
            }
            for(Object value : values.values()) {
                params.add(value);
            }

            // where clause
            for (Expression expression : filter) {
                if (whereClause.length() > 0) {
                    whereClause.append(", ");
                }
                Field modelField = manager.getField(expression.getField());
                whereClause.append(makeSQLExpr(expression.getField(), expression.getOperation(), expression.getValue()));
                types.add(modelField.getDbType());
                params.add(expression.getValue());
            }
            if (whereClause.length() > 0) {
                sql.append(" WHERE ").append(whereClause);
            }

            // execute
            DataSource dataSource = persistence.getDataSource();
            System.out.println(sql.toString());
            SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource, sql.toString(), toIntArray(types));
            sqlUpdate.update(params.toArray());
            persistence.clearCache();
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }

    protected  int[] toIntArray(List<Integer> list)  {
        int[] ret = new int[list.size()];
        int i = 0;
        for (Integer e : list)
            ret[i++] = e.intValue();
        return ret;
    }

    public List select(ModelQuery modelQuery, BasePersistence persistence) throws SystemException, PortalException {
        Query query = buildSQL(modelQuery);
        return select(query, persistence, dialect);
    }

    public List select(Query query, BasePersistence persistence, Dialect dialect) throws SystemException {
        List items = new ArrayList();
        Session session = null;

        try {
            session = persistence.openSession();
            String sql = buildSQL(query);
            System.out.println(sql);
            SQLQuery sqlQuery = session.createSQLQuery(sql);
            for(String entry : query.getEntires().keySet()) {
                sqlQuery.addEntity(entry, query.getEntires().get(entry));
            }
            for(String scalar : query.getScalars().keySet()) {
                sqlQuery.addScalar(scalar, query.getScalars().get(scalar));
            }
            QueryPos qpos = QueryPos.getInstance(sqlQuery);
            for(Object param : query.getParams()) {
                qpos.add(param);
            }
            items = QueryUtil.list(sqlQuery, dialect, query.getStart(), query.getEnd());
        } catch (Exception e) {
            throw new SystemException(e);
        } finally {
            persistence.closeSession(session);
        }

        return items;
    }


    public Query buildSQL(ModelQuery modelQuery) throws SystemException, PortalException {
        Query query = new Query();

        setModels(query, modelQuery);
        setTargets(query, modelQuery);
        setFilters(query, modelQuery);
        setStringQuery(query, modelQuery);
        setOrder(query, modelQuery);
        setPage(query, modelQuery);

        return query;
    }

    protected void setModels(Query query, ModelQuery modelQuery) {
        query.setTableName(manager.getTableName());
        query.setModel(manager.getModelClass());
        query.setModelAlias(manager.getSelf().getName());

        for (Field field : modelQuery.getFieldMap().values()) {
            if (field.isForeign()) {
                addRelation(query, new ArrayList<String>(), query.getModelAlias(), (ForeignField) field);
            }
        }
    }

    protected void addRelation(Query query, List<String> path, String alias, ForeignField foreignField) {
        ModelManager manager = CBaseModel.getManager(foreignField.getReference().getFieldClass());
        path.add(foreignField.getReference().getName());
        String foreignAlias = concat(path, "__");
        List value = list(manager.getTableName(),String.format("%s.%s = %s.%s",
                foreignAlias, foreignField.getReference().getReferenceFieldDbName(),
                alias, foreignField.getReference().getDbName()));
        query.getRelations().put(foreignAlias, value);
        if (foreignField.getField().isForeign()) {
            addRelation(query, path, foreignAlias, (ForeignField) foreignField.getField());
        }
    }

    protected void setTargets(Query query, ModelQuery modelQuery) {
        for (Field field : modelQuery.getFields()) {
            if (field.isReference()) {
                if (field.isForeign()) {
                    ForeignField foreignField = (ForeignField) field;
                    String sqlName = field.getName().replaceAll("\\.", "__");
                    query.addTarget(String.format("{%s.*}", sqlName));
                    query.getEntires().put(sqlName, ((ReferenceField)foreignField.getLastField()).getFieldClassImpl());
                } else {
                    query.addTarget(String.format("{%s.*}", field.getName()));
                    query.getEntires().put(field.getName(), ((ReferenceField)field).getFieldClassImpl());
                }
            } else if (field.isFunction()) {
                FunctionField functionField = (FunctionField) field;
                List<Field> attributes = functionField.getAttributes();
                List<String> dbAttributes = new ArrayList<String>();
                for (Field attr : attributes) {
                    dbAttributes.add(getSQLName(attr));
                }
                query.addTarget(functionField.render(dbAttributes), functionField.getName());
                query.getScalars().put(functionField.getName(), functionField.getOrmType());
            } else {
                String sqlName = getSQLName(field);
                query.addTarget(sqlName);
                query.getScalars().put(sqlName, field.getOrmType());
            }
        }
    }

    protected void setFilters(Query query, ModelQuery modelQuery) throws SystemException, PortalException {
        if (modelQuery.getFilter().size() > 0) {
            for (int i=0; i < modelQuery.getFilter().size(); i++) {
                Expression expression = modelQuery.getFilter().get(i);
                Field field = modelQuery.getFilterFields().get(i);
                String sqlName = getSQLName(field);

                if (expression.getValue() != null && expression.getValue().getClass().equals(ModelQuery.class)) {
                    Query subSql = ((ModelQuery) expression.getValue()).buildSQL();
                    query.getFitler().put(sqlName, new ExpressionImpl(sqlName, expression.getOperation(), subSql));
                    for(Object param : subSql.getParams()) {
                        query.getParams().add(param);
                    }
                } else {
                    Object value = field.castServiceType(expression.getValue());
                    query.getFitler().put(sqlName, new ExpressionImpl(sqlName, expression.getOperation(), value));
                    query.getParams().add(value);
                }
            }
        }
    }

    protected void setStringQuery(Query query, ModelQuery modelQuery) throws SystemException, PortalException {
        if (modelQuery.getStringQueries().size() > 0) {
            for (int i=0; i < modelQuery.getStringQueries().size(); i++) {
                ModelQuery.StringQuery stringQuery = modelQuery.getStringQueries().get(i);
                List<Field> modelFields = stringQuery.getModelFields();
                List<String> sqlFields = new ArrayList<String>();

                for (Field field : modelFields) {
                    sqlFields.add(getSQLName(field));
                }
                for (int paramIndex = 0; paramIndex < stringQuery.getParams().size(); paramIndex++) {
                    Object param = stringQuery.getParams().get(paramIndex);

                    if (param != null && param.getClass().equals(ModelQuery.class)) {
                        Query subSql = ((ModelQuery) param).buildSQL();
                        for(Object subParam : subSql.getParams()) {
                            query.getParams().add(subParam);
                        }
                        stringQuery.setParamSQL(paramIndex, "(" + PersistenceManager.buildSQL(subSql) + ")");
                    } else {
                        query.getParams().add(param);
                    }
                }
                query.addStringQuery(stringQuery.getSQL(sqlFields));
            }
        }
    }

    protected void setOrder(Query query, ModelQuery modelQuery) {
        if (modelQuery.getOrderField() != null) {
            Map<String, String> result = new HashMap<String, String>();
            result.put("orderByCol", getSQLName((ForeignField) modelQuery.getOrderField()));
            if (modelQuery.getOrderType() != null) {
                result.put("orderByType", modelQuery.getOrderType());
            }
            query.setOrder(result);
        }
    }

    protected void setPage(Query query, ModelQuery modelQuery) {
        query.setStart(modelQuery.getPage().get("start"));
        query.setEnd(modelQuery.getPage().get("end"));
    }

    protected String normalize(ForeignField field) {
        ForeignField foreignField = (ForeignField) field;
        String alias = concat(foreignField.getReferencePath(), "__");
        return String.format("%s.%s", alias, foreignField.getDbName());
    }

    protected String getSQLName(Field field) {
        if (field.isForeign()) {
            return normalize((ForeignField) field);
        }  else {
            return field.getServiceName();
        }
    }

    /* static methods */

    static public List<Expression> parse(Map<String, Object> filter) {
        List<Expression> expressionMap = new ArrayList<Expression>();

        for (String key : filter.keySet()) {
            String name = key.contains("__") ? key.split("__")[0] : key;
            String operation = key.contains("__") ? key.split("__")[1] : "eq";
            Object value = filter.get(key);
            expressionMap.add(new ExpressionImpl(name, operation, value));
        }

        return expressionMap;
    }

    static protected String makeSQLExpr(String field, String operation, Object value) {
        StringBuffer expr = new StringBuffer();
        Object param = value.getClass().equals(Query.class) ?
                String.format("(%s)", PersistenceManager.buildSQL((Query) value)) : "?";

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

    static public String buildSQL(Query query) {
        StringBuffer queryString = new StringBuffer();

        List<String> targets = new ArrayList<String>();
        for (Object[] target : query.getTargets()) {
            if (target.length > 1) {
                targets.add(String.format("%s as %s", target));
            } else {
                targets.add((String) target[0]);
            }
        }
        queryString.append(" SELECT ").append(concat(targets, ", ")).append(" ");
        queryString.append(" FROM ").append(query.getTableName()).append(" as ").append(query.getModelAlias()).append(" ");
        for (String alias : query.getRelations().keySet()) {
            String relation = (String) query.getRelations().get(alias).get(0);
            String expr = (String) query.getRelations().get(alias).get(1);
            queryString.append(" LEFT JOIN ").append(relation).append(" as ").append(alias)
                    .append(" ON ").append(expr).append(" ");
        }
        if (!query.getFitler().isEmpty() || !query.getStringQueries().isEmpty()) {
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
            if (!query.getStringQueries().isEmpty()) {
                for (String stringQuery : query.getStringQueries()) {
                    if (expressionClause.length() > 0) {
                        expressionClause.append(" AND ");
                    }
                    expressionClause.append(stringQuery);
                }
            }
            queryString.append(expressionClause).append(" ");
        }

        if(!query.getOrder().isEmpty()) {
            queryString.append(" ORDER BY ").append(query.getOrder().get("orderByCol"));
            if (query.getOrder().containsKey("orderByType")) {
                queryString.append(" ").append(query.getOrder().get("orderByType"));
            }
            queryString.append("");
        }

        return queryString.toString();
    }

}
