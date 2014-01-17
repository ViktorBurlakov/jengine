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

package com.jengine.orm.query;


import antlr.RecognitionException;
import antlr.TokenStreamException;
import com.jengine.orm.ModelClassBase;
import com.jengine.orm.ModelManager;
import com.jengine.orm.db.DBException;
import com.jengine.orm.db.expression.Expression;
import com.jengine.orm.db.expression.ExpressionImpl;
import com.jengine.orm.db.query.parser.SqlTranslator;
import com.jengine.orm.field.Field;
import com.jengine.orm.field.ForeignField;
import com.jengine.orm.field.FunctionField;
import com.jengine.orm.field.reference.ReferenceField;
import com.jengine.utils.CollectionUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;

import java.io.UnsupportedEncodingException;
import java.util.*;

public class ModelQuery {
    private Map<String, Field> fieldMap = new LinkedHashMap<String, Field>();
    private List<Field> fields = new ArrayList<Field>();
    private Map<String, List<Field>> fieldTargets = new LinkedHashMap<String, List<Field>>();
    private List<Field> filterFields = new ArrayList<Field>();
    private List<Expression> filter = new ArrayList<Expression>();
    private Field orderField = null;
    private String orderFieldName = null;
    private String orderType = null;
    private Map<String, Integer> page = new HashMap<String, Integer>();
    private ModelManager manager = null;
    private List<StringExpression> stringExpressions = new ArrayList<StringExpression>();
    private Map<String, Object> values = new LinkedHashMap<String, java.lang.Object>();
    private List<Field> valueFields = new ArrayList<Field>();

    public ModelQuery(ModelManager manager) {
        this.manager = manager;
        this.addToFieldMap(manager.getSelf(), true);
        this.page.put("start", QueryUtil.ALL_POS);
        this.page.put("end", QueryUtil.ALL_POS);
    }

    protected void addToFieldMap(Field field, boolean referenceAsObject) {
        if (field instanceof FunctionField) {
            FunctionField functionField = (FunctionField) field;
            for (Object attribute : functionField.getAttributes()) {
                Field attributeField  = getField(attribute);
                fieldMap.put(attributeField.getFieldName(), attributeField);
                fieldTargets.put(attributeField.getFieldName(), CollectionUtil.list(attributeField));
            }
        } else if (field instanceof ForeignField) {
            fieldMap.put(field.getFieldName(), field);
            fieldTargets.put(field.getFieldName(), new ArrayList<Field>());
            ForeignField foreignField = (ForeignField)field;
            if (foreignField.getActualField() instanceof ReferenceField) {
                ReferenceField actualField = (ReferenceField) foreignField.getActualField();
                ModelClassBase fieldModelClass = manager.getCls().getModelClass(actualField.getReferenceModelName());
                for (Field field1 : fieldModelClass.getManager().getPersistenceFields()) {
                    String fullFieldName = String.format("%s.%s", foreignField.getFieldName(), field1.getFieldName());
                    fieldMap.put(fullFieldName, manager.getField(fullFieldName));
                    fieldTargets.get(field.getFieldName()).add(fieldMap.get(fullFieldName));
                }
            }
        } else if (field instanceof ReferenceField) {
            fieldMap.put(field.getFieldName(), field);
            fieldTargets.put(field.getFieldName(), new ArrayList<Field>());
            if (referenceAsObject) {
                ReferenceField referenceField = (ReferenceField)field;
                for (Field field1 : referenceField.getReferenceClass().getManager().getPersistenceFields()) {
                    String fullFieldName = String.format("%s.%s", referenceField.getFieldName(), field1.getFieldName());
                    fieldMap.put(fullFieldName, manager.getField(fullFieldName));
                    fieldTargets.get(field.getFieldName()).add(fieldMap.get(fullFieldName));
                }
            }
        } else {
            fieldMap.put(field.getFieldName(), field);
            fieldTargets.put(field.getFieldName(), CollectionUtil.list(field));
        }
    }

    public ModelQuery field(Field field) {
        this.fields.add(field);
        this.addToFieldMap(field, true);
        return this;
    }

    public ModelQuery field(String field) {
        return this.field(manager.getField(field));
    }

    public ModelQuery fields(Object ... fields) {
        for(Object field : fields) {
            field(getField(field));
        }
        return this;
    }

    public ModelQuery fields(List fields) {
        for(Object field : fields) {
            field(getField(field));
        }

        return this;
    }

    public ModelQuery filter(String query, Object ... params) throws DBException {
        try{
            StringExpression stringExpression = new StringExpression(query, params);
            this.stringExpressions.add(stringExpression);
            for (String field : stringExpression.findModelFields()) {
                Field modelField = getField(field);
                stringExpression.getModelFields().add(modelField);
                this.addToFieldMap(modelField, false);
            }
        } catch (Exception e) {
            throw new DBException(e);
        }

        return this;
    }

    public ModelQuery filter(Map<String, Object> filter) {
        return filter(parse(filter));
    }

    public ModelQuery filter(List<Expression> filter) {
        this.filter.addAll(filter);
        for (Expression expression : filter) {
            Field modelField = getField(expression.getField());
            filterFields.add(modelField);
            this.addToFieldMap(modelField, false);
        }

        return this;
    }

    public ModelQuery filter(Expression ... filter) {
        return this.filter(Arrays.asList(filter));
    }

    public ModelQuery order(Map<String, String> order) {
        if (order != null && order.size() > 0 && order.containsKey("field")) {
            this.orderFieldName = order.get("field");
            orderField = getField(orderFieldName);
            this.addToFieldMap(orderField, false);
            if (order.containsKey("orderType")) {
                this.orderType = order.get("orderType");
            }
        }

        return this;
    }

    public ModelQuery values(Map<String, Object> values) throws DBException {
        if (values != null && values.size() > 0) {
            for (String name : values.keySet()) {
                value(name, values.get(name));
            }
        }

        return this;
    }

    public ModelQuery value(String name, Object value) throws DBException {
        Field modelField = getField(name);
        this.values.put(name, modelField.cast(value));
        valueFields.add(modelField);
        this.addToFieldMap(modelField, false);
        return this;
    }

    public <T extends Object> T one() throws DBException {
        List values = list();
        return values.size() > 0 ? (T) values.get(0) : null;
    }

    public long count() throws DBException {
        return this.field(manager.newCountAllField()).<Long>one();
    }

    public <T extends Object> List<T> list() throws DBException {
        return manager.getCls().select(this);
    }

    public void update() throws DBException {
        manager.getCls().update(this);
    }

    public void remove() throws DBException {
        manager.getCls().remove(this);
    }

    public ModelQuery page(Map<String, Object> page) {
        if (page != null) {
            this.page.put("start", page.containsKey("start") ? (Integer) page.get("start") : QueryUtil.ALL_POS);
            this.page.put("end", page.containsKey("end") ? (Integer) page.get("end") : QueryUtil.ALL_POS);
        }

        return this;
    }

    protected Field getField(Object field) {
        return field.getClass().equals(String.class) ? getField((String) field) : (Field) field;
    }

    protected  Field getField(String fieldName) {
        return fieldMap.containsKey(fieldName) ? fieldMap.get(fieldName) : manager.getField(fieldName);
    }

    public List<Expression> parse(Map<String, Object> filter) {
        List<Expression> expressionMap = new ArrayList<Expression>();

        for (String key : filter.keySet()) {
            String name = key.contains("__") ? key.split("__")[0] : key;
            String operation = key.contains("__") ? key.split("__")[1] : "eq";
            Object value = filter.get(key);
            expressionMap.add(new ExpressionImpl(name, operation, value));
        }

        return expressionMap;
    }

    /* setters and getters */

    public Map<String, Field> getFieldMap() {
        return fieldMap;
    }

    public List<Field> getTargetFields() {
        List<Field> result = new ArrayList<Field>();

        for (Field field : getFields()) {
            if (fieldTargets.containsKey(field.getFieldName()) &&
                    fieldTargets.get(field.getFieldName()).size() > 0) {
                result.addAll(fieldTargets.get(field.getFieldName()));
            } else {
                result.add(field);
            }
        }

        return result;
    }

    public List<Field> getTargets(String fieldName) {
        return fieldTargets.get(fieldName);
    }

    public List<Field> getFields() {
        return fields.size() == 0 ? CollectionUtil.list(manager.getSelf()) : fields;
    }

    public List<Field> getFilterFields() {
        return filterFields;
    }

    public List<Expression> getFilter() {
        return filter;
    }

    public Field getOrderField() {
        return orderField;
    }

    public String getOrderType() {
        return orderType;
    }

    public Map<String, Integer> getPage() {
        return page;
    }

    public List<StringExpression> getStringExpressions() {
        return stringExpressions;
    }

    public ModelManager getManager() {
        return manager;
    }

    public Map<String, Object> getValues() {
        return values;
    }

    /* private class */

    public class StringExpression {
        private String query;
        private List params = new ArrayList();
        private SqlTranslator translator;
        private List<Field> modelFields = new ArrayList<Field>();

        public StringExpression(String query, Object[] params) throws TokenStreamException, RecognitionException, UnsupportedEncodingException {
            this.query = query;
            Collections.addAll(this.params, params);
            translator = SqlTranslator.parse(query);
        }

        public List<Field> getModelFields() {
            return modelFields;
        }

        public void setModelFields(List<Field> modelFields) {
            this.modelFields = modelFields;
        }

        public String getQuery() {
            return query;
        }

        public List getParams() {
            return params;
        }

        public SqlTranslator getTranslator() {
            return translator;
        }

        public void setSQLFields(List<String> sqlFields) {
            for (int i=0; i < sqlFields.size(); i++) {
                translator.getColumns().get(i).setText(sqlFields.get(i));
            }
        }

        public List<String> findModelFields() {
            List<String> fields = new ArrayList<String>();

            for(SqlTranslator.Column column : translator.getColumns()) {
                fields.add(column.getText());
            }

            return fields;
        }


    }
}
