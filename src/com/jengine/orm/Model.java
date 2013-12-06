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

package com.jengine.orm;

import com.jengine.orm.db.DBException;
import com.jengine.orm.field.*;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.*;


public class Model {
    protected ModelClass cls;
    protected Map<String, Object> values = new LinkedHashMap<String, Object>();
    protected boolean _new = true;

    public Model() throws DBException {
        cls = (ModelClass) ModelClass.getClassObject(getClass());
    }

    public Model(Map values) throws DBException {
        this();
        setValues(values);
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

    public Serializable getPrimaryKey() throws DBException {
        return (Serializable) getValue(cls.getManager().getPrimaryKey());
    }

    public void setValue(String fieldName, Object value) throws DBException {
        this.setValue(cls.getManager().getField(fieldName), value);
    }

    public Object getValue(String fieldName) throws DBException {
        return this.getValue(cls.getManager().getField(fieldName));
    }

    public void setValue(Field field, Object value) throws DBException {
        if (field.isForeign() || field.isFunction() || field.isProperty()) {
            return;
        }
        values.put(field.getName(), field.castType(value));
    }

    public Object getValue(Field field) throws DBException {
        if (field.isForeign()) {
            ForeignField foreignField = (ForeignField) field;
            Object referenceId = values.get(foreignField.getReference().getName());
            Model reference = cls.getModelClass(field.getFieldClass()).get(referenceId);
            return reference.getValue(foreignField.getField());
        } else if (field.isReference()) {
            return cls.getModelClass(field.getFieldClass()).get(values.get(field.getName()));
        } else if (field.isMultiReference()) {
            MultiReferenceField multiField = (MultiReferenceField) field;
            return cls.getModelClass(field.getFieldClass()).filter("? = ?", multiField.getReferenceModelField(), getPrimaryKey());
        } else if (field.isProperty()) {
            try {
                Method method = getClass().getMethod(((ModelProperty) field).getMethodName());
                return method.invoke(this);
            } catch (Exception e) {
                throw new DBException(e);
            }
        } else {
            return values.get(field.getServiceName());
        }
    }

    public void setValues(Map<String, Object> valueMap) throws DBException {
        for (String fieldName : valueMap.keySet()) {
            setValue(fieldName, valueMap.get(fieldName));
        }
    }

    public Map<String, Object> getValues(List<String> fields) throws DBException {
        Map<String, Object> values = new LinkedHashMap<String, Object>();

        for (String fieldName : fields) {
            values.put(fieldName, getValue(fieldName));
        }

        return values;
    }

    public Map<String, Object> getDBValues() throws DBException {
        return values;
    }

    /* modify methods */

    public Model save() throws DBException {
        if (_new) {
            cls.insert(this);
            this.cache();
            return this;
        }
        return this.update();
    }


    public Model update() throws DBException {
        ModelManager manager = cls.getManager();
        new ModelQuery(manager).values(values).update();
        cache();
        return this;
    }

    public void remove() throws DBException {
        ModelManager manager = cls.getManager();
        new ModelQuery(manager).values(values).remove();
        clearCache();
    }

    public void clearCache() throws DBException {
        if (cls.getManager().getCacheEnabled()) {
            cls.getProvider().clearCache(this);
        }
    }

    public void cache() throws DBException {
        if (cls.getManager().getCacheEnabled()) {
            cls.getProvider().cache(this);
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
