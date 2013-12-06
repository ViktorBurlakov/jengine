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


import antlr.RecognitionException;
import antlr.TokenStreamException;
import com.jengine.db.exception.DBException;
import com.jengine.db.expression.Expression;
import com.jengine.db.expression.ExpressionImpl;
import com.jengine.db.field.Field;
import com.jengine.db.field.FunctionField;
import com.jengine.db.query.parser.WhereTranslator;
import com.liferay.portal.kernel.dao.orm.QueryUtil;

import java.io.UnsupportedEncodingException;
import java.util.*;

public class ModelQuery {
    private Map<String, Field> fieldMap = new LinkedHashMap<String, Field>();
    private List<Field> fields = new ArrayList<Field>();
    private List<Field> filterFields = new ArrayList<Field>();
    private List<Expression> filter = new ArrayList<Expression>();
    private Field orderField = null;
    private String orderFieldName = null;
    private String orderType = null;
    private Map<String, Integer> page = new HashMap<String, Integer>();
    private ModelManager manager = null;
    private List<StringQuery> stringQueries= new ArrayList<StringQuery>();
    private Map<String, Object> values = new LinkedHashMap<String, java.lang.Object>();
    private List<Field> valueFields = new ArrayList<Field>();

    public ModelQuery(ModelManager manager) {
        this.manager = manager;
        this.page.put("start", QueryUtil.ALL_POS);
        this.page.put("end", QueryUtil.ALL_POS);
    }

    public ModelQuery field(Field field) {
        this.fields.add(field);
        if (field.isFunction()) {
            FunctionField functionField = (FunctionField) field;
            for (Object attribute : functionField.getAttributes()) {
                Field attributeField  = getField(attribute);
                fieldMap.put(attributeField.getName(), attributeField);
            }
        } else {
            fieldMap.put(field.getName(), field);
        }
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
            StringQuery stringQuery = new StringQuery(query, params);
            this.stringQueries.add(stringQuery);
            for (String field : stringQuery.findFields()) {
                Field modelField = getField(field);
                stringQuery.getModelFields().add(modelField);
                fieldMap.put(modelField.getName(), modelField);
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
            fieldMap.put(modelField.getName(), modelField);
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
            fieldMap.put(orderFieldName, orderField);
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
        this.values.put(name, modelField.castType(value));
        valueFields.add(modelField);
        fieldMap.put(modelField.getName(), modelField);
        return this;
    }

    public <T extends Object> T one() throws DBException {
        List values = list();
        return values.size() > 0 ? (T) values.get(0) : null;
    }

    public long count() throws DBException {
        return this.field(manager.getCountAllField()).<Long>one();
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

    public List<Field> getFields() {
        return fields;
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

    public List<StringQuery> getStringQueries() {
        return stringQueries;
    }

    public ModelManager getManager() {
        return manager;
    }

    public Map<String, Object> getValues() {
        return values;
    }

    /* private class */

    public class StringQuery {
        private String query;
        private List params = new ArrayList();
        private WhereTranslator translator;
        private List<Field> modelFields = new ArrayList<Field>();

        public StringQuery(String query, Object[] params) throws TokenStreamException, RecognitionException, UnsupportedEncodingException {
            this.query = query;
            Collections.addAll(this.params, params);
            translator = WhereTranslator.parse(query);
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

        public String getSQL(List<String> sqlFields) {
            for (int i=0; i < sqlFields.size(); i++) {
                translator.getColumns().get(i).setText(sqlFields.get(i));
            }
            return translator.getResult().toString();
        }

        public List getParams() {
            return params;
        }

        public void setParamSQL(int index, String sql) {
            translator.getParams().get(index).setText(sql);
        }

        public List<String> findFields() {
            List<String> fields = new ArrayList<String>();

            for(WhereTranslator.Column column : translator.getColumns()) {
                fields.add(column.getText());
            }

            return fields;
        }


    }
}
