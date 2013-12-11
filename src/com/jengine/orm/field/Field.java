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

package com.jengine.orm.field;


import com.jengine.orm.ModelManager;
import com.jengine.orm.db.DBException;
import com.jengine.orm.db.expression.Expression;
import com.jengine.orm.db.expression.ExpressionImpl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class Field {
    public enum Type { PLAIN, SELF, MULTI_REFERENCE, MANY_REFERENCE, REFERENCE, FOREIGN, FUNCTION, PROPERTY };
    protected Type type = Type.PLAIN;
    protected String fieldName;
    protected Class fieldClass;
    protected String columnName;
    protected Integer columnType;
    protected ModelManager manager;
    protected String verbose;
    protected boolean primaryKey = false;
    protected boolean autoIncrement = false;
    protected boolean visible = false;
    protected Map<String, Object> options = new LinkedHashMap<String, Object>();

    public Field() {
    }

    public Field(Class fieldClass) {
        this(fieldClass, new HashMap<String, Object>());
    }

    public Field(Class fieldClass, Map<String, Object> options) {
        this.fieldClass = fieldClass;
        this.options.putAll(options);
        if (options.containsKey("primaryKey")) {
            this.primaryKey = (Boolean) options.get("primaryKey");
        }
        if (options.containsKey("verbose")) {
            this.verbose = (String) options.get("verbose");
        }
        if (options.containsKey("visible")) {
            this.visible = (Boolean) options.get("visible");
        }
        if (options.containsKey("columnName")) {
            this.columnName = (String) options.get("columnName");
        }
        if (options.containsKey("columnType")) {
            this.columnType = (Integer) options.get("columnType");
        }
        if (options.containsKey("autoIncrement")) {
            this.autoIncrement = (Boolean) options.get("autoIncrement");
        }
    }

    public void config(String fieldName, ModelManager manager) {
        this.fieldName = fieldName;
        this.manager = manager;
        if (visible) {
            this.visible = (verbose != null && verbose.length() > 0);
        }
        if (columnName == null) {
            this.columnName = fieldName;
        }
    }

    public Object castType(Object value) throws DBException {
        return value;
    }

    public String format(Object value) throws DBException {
        return String.valueOf(value);
    }

    public boolean isKey() {
        return false;
    }

    /* getters and setters */

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Integer getColumnType() {
        return columnType;
    }

    public Type getType() {
        return type;
    }

    public ModelManager getManager() {
        return manager;
    }

    public String getVerbose() {
        return verbose;
    }

    public void setVerbose(String verbose) {
        this.verbose = verbose;
    }

    public Class getFieldClass() {
        return fieldClass;
    }

    public void setFieldClass(Class fieldClass) {
        this.fieldClass = fieldClass;
    }

    public boolean isPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(boolean primaryKey) {
        this.primaryKey = primaryKey;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Map<String, Object> getOptions() {
        return options;
    }

    public void setOptions(Map<String, Object> options) {
        this.options = options;
    }

    public boolean isAutoIncrement() {
        return autoIncrement;
    }

    public void setAutoIncrement(boolean autoIncrement) {
        this.autoIncrement = autoIncrement;
    }

    public Map<String, Object> toMap() {
        Map result = new HashMap();

        result.put("fieldName" , fieldName);
        result.put("fieldClass" , fieldClass.getName());
        result.put("primaryKey" , primaryKey);
        result.put("verbose" , verbose);
        result.put("visible" , visible);
        result.put("type" , type);
        result.put("columnType" , columnType);

        return result;
    }

    /* operation method */

    public Expression eq(Object value) {
        return new ExpressionImpl(fieldName, "eq", value);
    }

    public Expression ge(Object value) {
        return new ExpressionImpl(fieldName, "ge", value);
    }

    public Expression gt(Object value) {
        return new ExpressionImpl(fieldName, "gt", value);
    }

    public Expression le(Object value) {
        return new ExpressionImpl(fieldName, "le", value);
    }

    public Expression lt(Object value) {
        return new ExpressionImpl(fieldName, "lt", value);
    }

    public Expression like(Object value) {
        return new ExpressionImpl(fieldName, "like", value);
    }

    public Expression ne(Object value) {
        return new ExpressionImpl(fieldName, "ne", value);
    }

    public Expression is_null(Object value) {
        return new ExpressionImpl(fieldName, "isnull", value);
    }

    public Expression is_empty(Object value) {
        return new ExpressionImpl(fieldName, "isempty", value);
    }

    public Expression op(String op, Object value) {
        return new ExpressionImpl(fieldName, op, value);
    }
}
