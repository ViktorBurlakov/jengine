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

package com.jengine.orm.model.field;


import com.jengine.orm.db.DBException;
import com.jengine.orm.exception.ValidateException;
import com.jengine.orm.model.Model;
import com.jengine.orm.model.ModelManager;
import com.jengine.orm.model.query.filter.Filter;
import com.jengine.utils.commons.Variant;

import java.sql.Time;
import java.sql.Types;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.jengine.utils.commons.CollectionUtil.map;


public class Field {
    public enum Type { PLAIN, REFERENCE, SINGLE_REFERENCE, SELF, MULTI_REFERENCE, MANY_REFERENCE, REVERSE_MANY_REFERENCE,
         REVERSE_SINGLE_REFERENCE, FOREIGN, FUNCTION, PROPERTY }
    protected String fieldName;
    protected Class fieldClass;
    protected String columnName;
    protected Integer columnType;
    protected ModelManager manager;
    protected String verbose;
    protected boolean primaryKey = false;
    protected boolean autoIncrement = false;
    protected boolean visible = false;
    protected boolean required = false;
    protected Object defaultValue = null;
    protected Map<String, Object> options = new LinkedHashMap<String, Object>();

    public Field() {
    }

    public Field(Field field) {
        this.fieldName = field.getFieldName();
        this.fieldClass = field.getFieldClass();
        this.columnName = field._getColumnName();
        this.columnType = field.getColumnType();
        this.manager = field.getManager();
        this.verbose = field.getVerbose();
        this.primaryKey = field.isPrimaryKey() ;
        this.autoIncrement = field.isAutoIncrement();
        this.visible = field.isVisible();
        this.required = field.isRequired();
        this.defaultValue = field.getDefaultValue();
        this.options = field.getOptions();
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
//            this.columnType = (Integer) options.get("columnType");
            this.columnType = options.containsKey("columnType") ?  (Integer) options.get("columnType") :
                    (getTypeMap().containsKey(fieldClass.getName()) ? getTypeMap().get(fieldClass.getName())[0] : null);
        }
        if (options.containsKey("required")) {
            this.required = (Boolean) options.get("required");
        }
        if (options.containsKey("default")) {
            this.defaultValue = options.get("default");
        }
    }

    public void config(String fieldName, ModelManager manager) {
        this.fieldName = fieldName;
        this.manager = manager;
    }

    protected Map<String, Integer[]> getTypeMap() {
        return map(
                String.class.getName(), new Integer[] {Types.VARCHAR, Types.CHAR, Types.LONGNVARCHAR, Types.NVARCHAR, Types.LONGVARCHAR, Types.NCHAR},
                Integer.class.getName(), new Integer[] {Types.INTEGER, Types.DECIMAL, Types.NUMERIC, Types.SMALLINT, Types.TINYINT},
                Long.class.getName(), new Integer[] { Types.BIGINT },
                Float.class.getName(), new Integer[] { Types.FLOAT, Types.REAL },
                Double.class.getName(), new Integer[] { Types.DOUBLE },
                Boolean.class.getName(), new Integer[] { Types.BOOLEAN, Types.BIT },
                Date.class.getName(), new Integer[] { Types.DATE, Types.TIMESTAMP },
                java.sql.Date.class.getName(), new Integer[] { Types.DATE, Types.TIMESTAMP },
                Time.class.getName(), new Integer[] { Types.TIME, Types.TIMESTAMP }
        );
    }

    public Object getValue(Model obj) throws DBException {
        Map<String, Object> data = obj.getData();
        return data.containsKey(fieldName) ? data.get(fieldName) : getDefaultValue();
    }

    public Object getPersistenceValue(Model obj) throws DBException {
        Map<String, Object> data = obj.getData();
        return data.containsKey(fieldName) ? data.get(fieldName) : getDefaultValue();
    }

    public boolean isChanged(Model obj) throws DBException {
        return obj.getOldData().containsKey(fieldName);
    }

    public Object cast(Object value) throws DBException {
        return new Variant(value).convertTo(getFieldClass());
    }

    public void validate(Model obj) throws ValidateException, DBException {
        Object value = getPersistenceValue(obj);
        if (required && value == null) {
            throw new ValidateException("'%s' field validation error: required field is empty");
        }
    }

    public String format(Object value) throws DBException {
        return String.valueOf(value);
    }

    public boolean isKey() {
        return false;
    }

    public boolean isPersistence() {
        return true;
    }

    /* getters and setters */

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getColumnName() {
        return columnName == null ? fieldName : columnName;
    }

    public String _getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Integer getColumnType() {
        return columnType;
    }

    public Type getType() {
        return Type.PLAIN;
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
        return visible && (verbose != null && verbose.length() > 0);
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

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public Object getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(Object defaultValue) {
        this.defaultValue = defaultValue;
    }

    public Field copy() throws DBException {
        try {
            return getClass().getConstructor(getClass()).newInstance(this);
        } catch (Exception e) {
            throw new DBException(e);
        }
    }

    public Map<String, Object> toMap() {
        Map result = new HashMap();

        result.put("fieldName" , fieldName);
        result.put("fieldClass" , fieldClass.getName());
        result.put("primaryKey" , primaryKey);
        result.put("verbose" , verbose);
        result.put("visible" , visible);
        result.put("type", getType());
        result.put("class", getClass().getSimpleName());
        result.put("columnType" , columnType);

        return result;
    }

    /* operation methods */

    public Filter eq(Object value) {
        return new Filter(fieldName, "eq", value);
    }

    public Filter ge(Object value) {
        return new Filter(fieldName, "ge", value);
    }

    public Filter gt(Object value) {
        return new Filter(fieldName, "gt", value);
    }

    public Filter le(Object value) {
        return new Filter(fieldName, "le", value);
    }

    public Filter lt(Object value) {
        return new Filter(fieldName, "lt", value);
    }

    public Filter like(Object value) {
        return new Filter(fieldName, "like", value);
    }

    public Filter ne(Object value) {
        return new Filter(fieldName, "ne", value);
    }

    public Filter is_null(Object value) {
        return new Filter(fieldName, "isnull", value);
    }

    public Filter is_empty(Object value) {
        return new Filter(fieldName, "isempty", value);
    }

    public Filter op(String op, Object value) {
        return new Filter(fieldName, op, value);
    }
}
