package com.jengine.orm;


import com.jengine.orm.db.DBException;
import com.jengine.orm.db.expression.Expression;
import com.jengine.orm.db.expression.ExpressionImpl;
import com.jengine.orm.db.query.SQLQuery;
import com.jengine.orm.db.query.SQLStringExpression;
import com.jengine.orm.field.Field;
import com.jengine.orm.field.ForeignField;
import com.jengine.orm.field.FunctionField;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.jengine.utils.CollectionUtil.concat;
import static com.jengine.utils.CollectionUtil.list;

public class PersistenceManager {

    public static SQLQuery buildInsertSQL(ModelQuery modelQuery) throws DBException {
        SQLQuery query = new SQLQuery();

        setModels(query, modelQuery);
        setValues(query, modelQuery);

        return query;
    }

    public static SQLQuery buildRemoveSQL(ModelQuery modelQuery) throws DBException {
        SQLQuery query = new SQLQuery();

        setModels(query, modelQuery);
        setFilters(query, modelQuery);
        setStringQuery(query, modelQuery);

        return query;
    }

    public static SQLQuery buildUpdateSQL(ModelQuery modelQuery) throws DBException{
        SQLQuery query = new SQLQuery();

        setModels(query, modelQuery);
        setValues(query, modelQuery);
        setFilters(query, modelQuery);
        setStringQuery(query, modelQuery);

        return query;
    }

    public static SQLQuery buildSelectSQL(ModelQuery modelQuery) throws DBException {
        SQLQuery query = new SQLQuery();

        setModels(query, modelQuery);
        setTargets(query, modelQuery);
        setFilters(query, modelQuery);
        setStringQuery(query, modelQuery);
        setOrder(query, modelQuery);
        setPage(query, modelQuery);

        return query;
    }

    protected static void setValues(SQLQuery query, ModelQuery modelQuery) throws DBException {
        for (String fieldName : modelQuery.getValues().keySet()) {
            Field field = modelQuery.getFieldMap().get(fieldName);
            Object value = modelQuery.getValues().get(fieldName);
            query.addValue(getSQLName(query, field), value);
            query.addParam(value);
        }
    }

    protected static void setModels(SQLQuery query, ModelQuery modelQuery) {
        query.setTableName(modelQuery.getManager().getTableName());
        query.setTableAlias(modelQuery.getManager().getSelf().getFieldName());

        for (Field field : modelQuery.getFieldMap().values()) {
            if (field.getType() == Field.Type.FOREIGN) {
                addRelation(query, new ArrayList<String>(), query.getTableAlias(), (ForeignField) field);
            }
        }
    }

    protected static void addRelation(SQLQuery query, List<String> path, String alias, ForeignField foreignField) {
        path.add(foreignField.getCurrentField().getFieldName());
        String foreignAlias = concat(path, "__").toString();
        if (foreignField.getCurrentField().getType() != Field.Type.SELF) {
            String tableName =  foreignField.getCurrentField().getReferenceClass().getManager().getTableName();
            Field referenceModelField = foreignField.getCurrentField().getReferenceModelKey();
            List value = list(tableName,String.format("%s.%s = %s.%s",
                    foreignAlias, referenceModelField.getColumnName(),
                    alias, foreignField.getCurrentField().getColumnName()));
            query.getRelations().put(foreignAlias, value);
        }
        if (foreignField.getNextField().getType() == Field.Type.FOREIGN) {
            addRelation(query, path, foreignAlias, (ForeignField) foreignField.getNextField());
        }
    }

    protected static void setTargets(SQLQuery query, ModelQuery modelQuery) {
        for (Field field : modelQuery.getFullFields()) {
            addTarget(field, query);
        }
    }

    protected static void addTarget(Field field, SQLQuery query) {
        if (field.getType() == Field.Type.FUNCTION) {
            FunctionField functionField = (FunctionField) field;
            List<Field> attributes = functionField.getAttributes();
            List<String> dbAttributes = new ArrayList<String>();
            for (Field attr : attributes) {
                dbAttributes.add(getSQLName(query, attr));
            }
            query.addTarget(functionField.render(dbAttributes), functionField.getFieldName());
            query.putTargetType(functionField.getFieldName(), functionField.getColumnType());
        } else {
            String sqlName = getSQLName(query, field);
            query.addTarget(sqlName);
            query.putTargetType(sqlName, field.getColumnType());
        }
    }

    protected static void setFilters(SQLQuery query, ModelQuery modelQuery) throws DBException {
        if (modelQuery.getFilter().size() > 0) {
            for (int i=0; i < modelQuery.getFilter().size(); i++) {
                Expression expression = modelQuery.getFilter().get(i);
                Field field = modelQuery.getFilterFields().get(i);
                String sqlName = getSQLName(query, field);

                if (expression.getValue() != null && expression.getValue().getClass().equals(ModelQuery.class)) {
                    SQLQuery subSql = buildSelectSQL((ModelQuery) expression.getValue());
                    query.getFitler().put(sqlName, new ExpressionImpl(sqlName, expression.getOperation(), subSql));
                    for(Object param : subSql.getParams()) {
                        query.getParams().add(param);
                    }
                } else {
                    Object value = field.cast(expression.getValue());
                    query.getFitler().put(sqlName, new ExpressionImpl(sqlName, expression.getOperation(), value));
                    query.getParams().add(value);
                }
            }
        }
    }

    protected static void setStringQuery(SQLQuery query, ModelQuery modelQuery) throws DBException {
        if (modelQuery.getStringExpressions().size() > 0) {
            for (int i=0; i < modelQuery.getStringExpressions().size(); i++) {
                ModelQuery.StringExpression stringExpression = modelQuery.getStringExpressions().get(i);
                List<Field> modelFields = stringExpression.getModelFields();
                List<String> sqlFields = new ArrayList<String>();
                List params = new ArrayList();

                for (Field field : modelFields) {
                    sqlFields.add(getSQLName(query, field));
                }
                stringExpression.setSQLFields(sqlFields);
                for (Object param : stringExpression.getParams()){
                    if (param != null && param.getClass().equals(ModelQuery.class)) {
                        SQLQuery subSql = buildSelectSQL((ModelQuery) param);
                        for(Object subParam : subSql.getParams()) {
                            query.getParams().add(subParam);
                        }
                        params.add(subSql);
                    } else {
                        query.getParams().add(param);
                        params.add(param);
                    }
                }
                query.addStringQuery(new SQLStringExpression(stringExpression.getQuery(), stringExpression.getTranslator(), params));
            }
        }
    }

    protected static void setOrder(SQLQuery query, ModelQuery modelQuery) {
        if (modelQuery.getOrderField() != null) {
            Map<String, String> result = new HashMap<String, String>();
            result.put("orderByCol", getSQLName(query, modelQuery.getOrderField()));
            if (modelQuery.getOrderType() != null) {
                result.put("orderByType", modelQuery.getOrderType());
            }
            query.setOrder(result);
        }
    }

    protected static void setPage(SQLQuery query, ModelQuery modelQuery) {
        query.setStart(modelQuery.getPage().get("start"));
        query.setEnd(modelQuery.getPage().get("end"));
    }

    protected static String getSQLName(SQLQuery query, Field field) {
        if (field.getType() == Field.Type.FOREIGN) {
            String alias = concat(((ForeignField)field).getReferenceFields(), "__").toString();
            return String.format("%s.%s", alias, field.getColumnName());
        } else {
            return String.format("%s.%s", query.getTableAlias(), field.getColumnName());
        }
    }
}
