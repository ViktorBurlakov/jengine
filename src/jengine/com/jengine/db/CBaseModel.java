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
import com.jengine.utils.ClassUtils;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class CBaseModel<T extends BaseModel<T>> {
    // list of managers
    public static ConcurrentHashMap<String, ModelManager> managers = new ConcurrentHashMap<String, ModelManager>();
    protected Map<String, Map> serviceContext = new HashMap<String, Map>();
    protected ModelManager _manager;
    protected Map<String, Object> dbValues = new LinkedHashMap<String, Object>();

    public CBaseModel() throws SystemException, PortalException {
        this._manager = getManager(this.getClass());
    }

    public CBaseModel(Map<String, Map> serviceContext) throws SystemException, PortalException {
        this();
        this.serviceContext = serviceContext;
    }

    public CBaseModel(Map<String, Map> serviceContext, Map values) throws SystemException, PortalException {
        this();
        this.serviceContext = serviceContext;
        setValues(values);
    }

    public CBaseModel(Map<String, Map> serviceContext, T object) throws SystemException, PortalException {
        this();
        this.serviceContext = serviceContext;
        this.setValues(object);
    }

    public String getVerbose() throws SystemException, PortalException {
        return String.valueOf(this.getPrimaryKey());
    }

    public ModelManager getManager() {
        return _manager;
    }

    public boolean isNew() throws SystemException, PortalException {
        return getValue(_manager.getPrimaryKey()) == null;
    }

    public Serializable getPrimaryKey() throws SystemException, PortalException {
        return (Serializable) getValue(_manager.getPrimaryKey());
    }

    public void setValue(String fieldName, Object value) throws SystemException, PortalException {
        _manager.setValue(this, fieldName, value);
    }

    public void setValue(Field field, Object value) throws SystemException, PortalException {
        _manager.setValue(this, field, value);
    }

    public void setValues(T object) throws SystemException, PortalException {
        _manager.setValues(this, object);
    }

    public void setValues(Map<String, Object> valueMap) throws SystemException, PortalException {
        _manager.setValues(this, valueMap);
    }

    public Object getValue(String fieldName) throws SystemException, PortalException {
        return _manager.getValue(this, fieldName, getServiceContext());
    }

    public ModelQuery getMultiValue(String fieldName) throws SystemException, PortalException {
        return (ModelQuery) getValue(fieldName);
    }

    public Object getValue(Field field) throws SystemException, PortalException {
        return _manager.getValue(this, field, getServiceContext());
    }

    public Object getValues(List<String> fields) throws SystemException, PortalException {
        return _manager.getValues(this, fields, getServiceContext());
    }

    public String format(String field) throws SystemException, PortalException {
        return _manager.getField(field).format(this.getValue(field));
    }

    public Map<String, Object> getVOs() throws SystemException, PortalException {
        Map<String, Object> vos = new LinkedHashMap<String, Object>();

        for (Field field : _manager.getFieldMap().values()) {
            if (!field.isFunction() && !field.isMultiReference() && !field.isProperty() && !field.isSelf()) {
                vos.put(field.getName(), getValue(field));
            }
        }

        return vos;
    }

    /* modify methods */

    public CBaseModel save() throws SystemException, PortalException {
        return _manager.save(this);
    }

    public void remove() throws SystemException, PortalException {
        _manager.remove(this);
    }

    public void cache() throws SystemException, PortalException {
        _manager.cache(this);
    }

    /* getters and setters */

    public T getObject() throws PortalException, SystemException {
        return (T) this._manager.getServiceObject(this, serviceContext);
    }

    public void setObject(T object) throws SystemException, PortalException {
        this.setValues(object);
    }

    public Map<String, Map> getServiceContext() {
        return serviceContext;
    }

    public void setServiceContext(Map<String, Map> serviceContext) {
        this.serviceContext = serviceContext;
    }

    public Map<String, Object> getDbValues() {
        return dbValues;
    }

    public void setDbValues(Map<String, Object> dbValues) {
        this.dbValues = dbValues;
    }

    /* static methods */

    public static ModelManager getManager(Class clazz) {
        ModelManager manager = managers.get(clazz.getName());

        if (manager != null) {
            return manager;
        } else {
            ClassUtils.forceInit(clazz);
            return managers.get(clazz.getName());
        }
    }

    /** static class methods **/

    public static CBaseModel newInstance(Class cls, Map<String, Map> serviceContext) throws SystemException, PortalException {
        CBaseModel obj = getManager(cls).newInstance();
        obj.setServiceContext(serviceContext);
        return obj;
    }

    public static CBaseModel newInstance(Class cls, Map<String, Map> serviceContext, Map values) throws SystemException, PortalException {
        CBaseModel obj = getManager(cls).newInstance();
        obj.setServiceContext(serviceContext);
        obj.setValues(values);
        return obj;
    }

    public static CBaseModel newInstance(Class cls, Map<String, Map> serviceContext, BaseModel object) throws SystemException, PortalException {
        CBaseModel obj = getManager(cls).newInstance();
        obj.setServiceContext(serviceContext);
        obj.setObject((BaseModel) object);
        return obj;
    }

    public static CBaseModel get(Class cls, Object id, Map<String, Map> context) throws SystemException, PortalException {
        return getManager(cls).get(id, context);
    }

    public static ModelQuery select(Class cls) throws SystemException {
        return getManager(cls).select();
    }

    public static ModelQuery select(Class cls, Object ... fields) throws SystemException {
        return getManager(cls).select(fields);
    }

    public static ModelQuery select(Class cls, List fields) throws SystemException {
        return getManager(cls).select(fields);
    }

    public static ModelQuery filter(Class cls, Map<String, Object> filter) throws SystemException {
        return getManager(cls).filter(filter);
    }

    public static ModelQuery filterMap(Class cls, Object ... filter) throws SystemException {
        return getManager(cls).filterMap(filter);
    }

    public static ModelQuery filter(Class cls, List<Expression> filter) throws SystemException {
        return getManager(cls).filter(filter);
    }

    public static ModelQuery filter(Class cls, Expression ... filter) throws SystemException {
        return getManager(cls).filter(filter);
    }

    public static Object max(Class cls, String field, Map<String, Map> context) throws SystemException, PortalException {
        return getManager(cls).max(field, context);
    }

    public static Object min(Class cls, String field, Map<String, Map> context) throws SystemException, PortalException {
        return getManager(cls).min(field, context);
    }

    public static long count(Class cls, Map<String, Map> context) throws SystemException, PortalException {
        return getManager(cls).count(context);
    }

    public static long count(Class cls, String field, Map<String, Map> context) throws SystemException, PortalException {
        return getManager(cls).count(field, context);
    }

    public static Object avg(Class cls, String field, Map<String, Map> context) throws SystemException, PortalException {
        return getManager(cls).avg(field, context);
    }

    public static Object sum(Class cls, String field, Map<String, Map> context) throws SystemException, PortalException {
        return getManager(cls).sum(field, context);
    }

    public static Object max(Class cls, Field field, Map<String, Map> context) throws SystemException, PortalException {
        return getManager(cls).max(field, context);
    }

    public static Object min(Class cls, Field field, Map<String, Map> context) throws SystemException, PortalException {
        return getManager(cls).min(field, context);
    }

    public static long count(Class cls, Field field, Map<String, Map> context) throws SystemException, PortalException {
        return getManager(cls).count(field, context);
    }

    public static Object avg(Class cls, Field field, Map<String, Map> context) throws SystemException, PortalException {
        return getManager(cls).avg(field, context);
    }

    public static Object sum(Class cls, Field field, Map<String, Map> context) throws SystemException, PortalException {
        return getManager(cls).sum(field, context);
    }

    public static Object calc(Class cls, Map<String, Map> context, String name, Class type, String expr, Field ... fields) throws SystemException, PortalException {
        return getManager(cls).calc(context, name, type, expr, fields);
    }

    /* inner classes */

    public static class ClassUtil<T extends CBaseModel> {
        private Class cls;

        public ClassUtil(Class<T> cls) {
            this.cls = cls;
        }

        public T newInstance(Map<String, Map> serviceContext, Map values) throws SystemException, PortalException {
            return (T) CBaseModel.newInstance(cls, serviceContext, values);
        }

        public T newInstance(Map<String, Map> serviceContext) throws SystemException, PortalException {
            return (T) CBaseModel.newInstance(cls, serviceContext);
        }

        public T newInstance(Map<String, Map> serviceContext, BaseModel object) throws SystemException, PortalException {
            return (T) CBaseModel.newInstance(cls, serviceContext, object);
        }

        public T get(Object id, Map<String, Map> context) throws SystemException, PortalException {
            return (T) CBaseModel.get(cls, id, context);
        }

        public ModelQuery select() throws SystemException {
            return CBaseModel.select(cls);
        }

        public ModelQuery select(Object ... fields) throws SystemException {
            return CBaseModel.select(cls, fields);
        }
        public ModelQuery select(Class cls, List ... fields) throws SystemException {
            return CBaseModel.select(cls, fields);
        }

        public ModelQuery filter(Map<String, Object> filter) throws SystemException {
            return CBaseModel.filter(cls, filter);
        }

        public ModelQuery filterMap(Object ... filter) throws SystemException {
            return CBaseModel.filterMap(cls, filter);
        }

        public ModelQuery filter(Class cls, List<Expression> filter) throws SystemException {
            return CBaseModel.filter(cls, filter);
        }

        public ModelQuery filter(Class cls, Expression ... filter) throws SystemException {
            return CBaseModel.filter(cls, filter);
        }

        public Object max(String field, Map<String, Map> context) throws SystemException, PortalException {
            return CBaseModel.max(cls, field, context);
        }

        public Object min(String field, Map<String, Map> context) throws SystemException, PortalException {
            return CBaseModel.min(cls, field, context);
        }

        public long count(Map<String, Map> context) throws SystemException, PortalException {
            return CBaseModel.count(cls, context);
        }

        public long count(String field, Map<String, Map> context) throws SystemException, PortalException {
            return CBaseModel.count(cls, field, context);
        }

        public Object avg(String field, Map<String, Map> context) throws SystemException, PortalException {
            return CBaseModel.avg(cls, field, context);
        }

        public Object sum(String field, Map<String, Map> context) throws SystemException, PortalException {
            return CBaseModel.sum(cls, field, context);
        }

        public <ResultType> ResultType max(Field field, Map<String, Map> context) throws SystemException, PortalException {
            return (ResultType) CBaseModel.max(cls, field, context);
        }

        public <ResultType> ResultType min(Field field, Map<String, Map> context) throws SystemException, PortalException {
            return (ResultType) CBaseModel.min(cls, field, context);
        }

        public long count(Field field, Map<String, Map> context) throws SystemException, PortalException {
            return CBaseModel.count(cls, field, context);
        }

        public <ResultType> ResultType avg(Field field, Map<String, Map> context) throws SystemException, PortalException {
            return (ResultType) CBaseModel.avg(cls, field, context);
        }

        public <ResultType> ResultType sum(Field field, Map<String, Map> context) throws SystemException, PortalException {
            return (ResultType) CBaseModel.sum(cls, field, context);
        }

        public <ResultType> ResultType calc(Map<String, Map> context, String name, Class type, String expr, Field ... fields) throws SystemException, PortalException {
            return (ResultType) CBaseModel.calc(cls, context, name, type, expr, fields);
        }
    }
}
