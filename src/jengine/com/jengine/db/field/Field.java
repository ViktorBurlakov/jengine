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

package com.jengine.db.field;


import com.jengine.db.Expression;
import com.jengine.db.ExpressionImpl;
import com.jengine.db.ModelManager;
import com.jengine.utils.CollectionUtil;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.sql.Types;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.jengine.utils.CollectionUtil.map;


public class Field implements IModelField {
    public static Map<String, Type> ORM_TYPE_MAP = CollectionUtil.map(
            String.class.getSimpleName(), Type.STRING,
            Long.class.getSimpleName(), Type.LONG,
            Integer.class.getSimpleName(), Type.INTEGER,
            Date.class.getSimpleName(), Type.DATE,
            Float.class.getSimpleName(), Type.DOUBLE,
            Boolean.class.getSimpleName(), Type.BOOLEAN
    );
    public static Map<String, Integer> DB_TYPE_MAP = CollectionUtil.map(
                    String.class.getSimpleName(), Types.VARCHAR,
                    Long.class.getSimpleName(), Types.BIGINT,
                    Integer.class.getSimpleName(), Types.INTEGER,
                    Date.class.getSimpleName(), Types.TIMESTAMP,
                    Float.class.getSimpleName(), Types.DOUBLE,
                    Boolean.class.getSimpleName(), Types.BOOLEAN
    );
    protected String name;
    protected String serviceName;
    protected String dbName;
    protected Class fieldClass;
    protected Type ormType;
    protected int dbType;
    protected Class model;
    protected String verbose;
    protected boolean primaryKey = false;
    protected boolean visible = false;
    protected boolean isInit = false;
    protected Map<String, Object> options = new LinkedHashMap<String, Object>();
    protected ModelManager manager = null;

    public Field(Class fieldClass) {
        this.fieldClass = fieldClass;
    }

    public Field(Class fieldClass, Object ... options) {
        this(fieldClass, map(options));
    }

    public Field(Class fieldClass, Map<String, Object> options) {
        this.fieldClass = fieldClass;
        this.options.putAll(options);
    }

    public Field(String name, Class fieldClass) {
        this.name = name;
        this.fieldClass = fieldClass;
    }

    public Field(String name, Class fieldClass, Map<String, Object> options) {
        this.name = name;
        this.fieldClass = fieldClass;
        this.options.putAll(options);
    }

    public Field(ModelManager manager, String name, Class fieldClass) {
        this.name = name;
        this.manager = manager;
        this.fieldClass = fieldClass;
        this.init();
    }

    public Field(ModelManager manager, String name, Class fieldClass, Map<String, Object> options) {
        this.name = name;
        this.manager = manager;
        this.fieldClass = fieldClass;
        this.options.putAll(options);
        this.init();
    }

    public void init() {
        this.serviceName = name;
        this.dbName = name;
        this.ormType = ORM_TYPE_MAP.containsKey(fieldClass.getSimpleName()) ?
                ORM_TYPE_MAP.get(fieldClass.getSimpleName()) : Type.LONG;
        this.dbType = DB_TYPE_MAP.containsKey(fieldClass.getSimpleName()) ?
                DB_TYPE_MAP.get(fieldClass.getSimpleName()) : Types.BIGINT;
        if (options.containsKey("primaryKey")) {
            this.primaryKey = (Boolean) options.get("primaryKey");
        }
        if (options.containsKey("verbose")) {
            this.verbose = (String) options.get("verbose");
            this.visible = verbose != null && verbose.length() > 0;
        }
        if (options.containsKey("visible")) {
            this.visible = (Boolean) options.get("visible");
        }
        if (options.containsKey("dbName")) {
            this.dbName = (String) options.get("dbName");
        }
        if (options.containsKey("ormType")) {
            this.ormType = (Type) options.get("ormType");
        }
        if (options.containsKey("dbType")) {
            this.dbType =  (Integer) options.get("dbType");
        }
        if (options.containsKey("serviceName")) {
            this.serviceName = (String) options.get("serviceName");
        }
        this.isInit = true;
    }

    public Object castType(Object value) throws SystemException, PortalException {
        if (fieldClass.equals(Long.class)) {
            return new Long(String.valueOf(value));
        }

        return value;
    }

    public Object castServiceType(Object value) throws SystemException, PortalException {
        return castType(value);
    }

    public String format(Object value) throws SystemException, PortalException {
        return String.valueOf(value);
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getDbName() {
        return dbName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getDbType() {
        return dbType;
    }

    public void setDbType(int dbType) {
        this.dbType = dbType;
    }

    public boolean isFunction() {
        return false;
    }

    public boolean isSelf() {
        return false;
    }

    public boolean isMultiReference() {
        return false;
    }

    public boolean isReference() {
        return false;
    }

    public boolean isForeign() {
        return false;
    }

    public boolean isProperty() {
        return false;
    }

    public boolean isKey() {
        return primaryKey || isReference();
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

    public Class getModel() {
        return model;
    }

    public void setModel(Class model) {
        this.model = model;
    }

    public Type getOrmType() {
        return ormType;
    }

    public void setOrmType(Type ormType) {
        this.ormType = ormType;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public ModelManager getManager() {
        return manager;
    }

    public void setManager(ModelManager manager) {
        this.manager = manager;
    }

    public boolean isInit() {
        return isInit;
    }

    public void setInit(boolean init) {
        isInit = init;
    }

    public Map<String, Object> getOptions() {
        return options;
    }

    public void setOptions(Map<String, Object> options) {
        this.options = options;
    }

    public Map<String, Object> toMap() {
        Map result = new HashMap();

        result.put("name" , name);
        result.put("fullname" , String.format("%s.%s", model.getSimpleName(), name));
        result.put("model" , model.getSimpleName());
        result.put("fieldClass" , fieldClass.getName());
        result.put("primaryKey" , primaryKey);
        result.put("verbose" , verbose);
        result.put("visible" , visible);
        result.put("reference" , isReference());
        result.put("dbName" , dbName);
        result.put("ormType" , ormType);
        result.put("serviceName" , serviceName);

        return result;
    }

    /* operation method */

    public Expression eq(Object value) {
        return new ExpressionImpl(name, "eq", value);
    }

    public Expression ge(Object value) {
        return new ExpressionImpl(name, "ge", value);
    }

    public Expression gt(Object value) {
        return new ExpressionImpl(name, "gt", value);
    }

    public Expression le(Object value) {
        return new ExpressionImpl(name, "le", value);
    }

    public Expression lt(Object value) {
        return new ExpressionImpl(name, "lt", value);
    }

    public Expression like(Object value) {
        return new ExpressionImpl(name, "like", value);
    }

    public Expression ne(Object value) {
        return new ExpressionImpl(name, "ne", value);
    }

    public Expression isnull(Object value) {
        return new ExpressionImpl(name, "isnull", value);
    }

    public Expression isempty(Object value) {
        return new ExpressionImpl(name, "isempty", value);
    }

    public Expression op(String op, Object value) {
        return new ExpressionImpl(name, op, value);
    }
}
