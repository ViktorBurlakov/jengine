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

package com.jengine.orm.model;

import com.jengine.orm.db.DBException;
import com.jengine.orm.exception.ValidateException;
import com.jengine.orm.model.field.Field;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.jengine.utils.CollectionUtil.map;


public class Model {
    protected ModelClassBase cls;
    protected Map<String, Object> data = new LinkedHashMap<String, Object>();
    protected Map<String, Object> oldData = new LinkedHashMap<String, Object>();
    protected boolean _new = true;

    public Model() throws DBException {
        cls = ModelClass.classMap.get(getClass().getName());
        if (cls != null) {
            setDefaultData();
        }
    }

    public String getVerbose() throws DBException {
        return String.valueOf(this.getPrimaryKey());
    }

    public String format(String field) throws DBException {
        return cls.getManager().getField(field).format(this.getValue(field));
    }

    /* get & set field values */

    public boolean isNew() throws DBException {
        return _new;
    }

    public void setNew(boolean value) throws DBException {
        _new = value;
    }

    public ModelClassBase getModelClass() {
        return cls;
    }

    public void setModelClass(ModelClassBase cls) throws DBException {
        this.cls = cls;
        setDefaultData();
    }

    public void setPrimaryKey(Serializable value) throws DBException {
        setValue(cls.getManager().getPrimaryKey(), value);
    }

    public Serializable getPrimaryKey() throws DBException {
        return (Serializable) getValue(cls.getManager().getPrimaryKey());
    }

    public <T extends Serializable> void setId(T value) throws DBException {
        setPrimaryKey(value);
    }

    public <T extends Serializable> T getId() throws DBException {
        return (T) getPrimaryKey();
    }

    public void setValue(String fieldName, Object value) throws DBException {
        this.setValue(cls.getManager().getField(fieldName), value);
    }

    public Object getValue(String fieldName) throws DBException {
        return this.getValue(cls.getManager().getField(fieldName));
    }

    public void setValue(Field field, Object value) throws DBException {
        if (!oldData.containsKey(field.getFieldName())) {
            oldData.put(field.getFieldName(), data.get(field.getFieldName()));
        }
        data.put(field.getFieldName(), field.cast(value));
    }

    public Object getValue(Field field) throws DBException {
        return field.getValue(this);
    }

    public void setValues(Map<String, Object> valueMap) throws DBException {
        for (String fieldName : valueMap.keySet()) {
            setValue(fieldName, valueMap.get(fieldName));
        }
    }

    public Map<String, Object> getValues() throws DBException {
        Map<String, Object> result = new LinkedHashMap<String, Object>();

        for (Field field : cls.getManager().getPersistenceFields()) {
            result.put(field.getFieldName(), getValue(field));
        }

        return result;
    }

    /*  data methods */

    public Map<String, Object> getData() throws DBException {
        return data;
    }

    public void setDefaultData() throws DBException {
        setData(map());
    }

    public void setData(LinkedHashMap<String, Object> values) throws DBException {
        oldData.clear();
        for (Field field : cls.getManager().getPersistenceFields()){
            Object value = values.containsKey(field.getFieldName()) ?
                    values.get(field.getFieldName()) : field.getDefaultValue();
            data.put(field.getFieldName(), value);
        }
    }

    protected Map<String, Object> getPersistenceValues() throws DBException {
        Map<String, Object> result = new LinkedHashMap<String, Object>();

        for (Field field : cls.getManager().getPersistenceFields()) {
            result.put(field.getColumnName(), field.getPersistenceValue(this));
        }

        return result;
    }

    protected Map<String, Object> getChangedPersistenceValues() throws DBException {
        Map<String, Object> result = new LinkedHashMap<String, Object>();

        for (String fieldName : oldData.keySet()) {
            Field field = cls.getManager().getField(fieldName);
            if (field.isPersistence()) {
                result.put(field.getColumnName(), field.getPersistenceValue(this));
            }
        }

        return result;
    }

    public void validate() throws ValidateException, DBException {
        for (Field field : cls.getManager().getFields()) {
            field.validate(this);
        }
    }

    /* modify methods */

    public Model save() throws ValidateException, DBException {
        if (_new) {
            return insert();
        }
        return update();
    }


    public Model insert() throws ValidateException, DBException {
        this.validate();
        cls.insert(this);
        oldData.clear();
        this.cache();
        return this;
    }

    public Model update() throws ValidateException, DBException {
        this.validate();
        cls.update(this);
        oldData.clear();
        this.cache();
        return this;
    }

    public void remove() throws DBException {
        cls.remove(this);
        oldData.clear();
        clearCache();
    }

    public void clearCache() throws DBException {
        if (cls.getManager().getCacheEnabled()) {
            cls.clearCache(this);
        }
    }

    public void cache() throws DBException {
        if (cls.getManager().getCacheEnabled()) {
            cls.cache(this);
        }
    }

    public boolean equals(Object obj) {
        try {
            return getPrimaryKey().equals(((Model)obj).getPrimaryKey());
        } catch (DBException e) {
            e.printStackTrace();
        }
        return false;
    }
}