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
    protected T object = null;
    protected ModelManager _manager;

    public CBaseModel(Serializable id, Map<String, Map> serviceContext) throws SystemException, PortalException {
        this._manager = getManager(this.getClass());
        this.object = (T) this._manager.createModel(id, serviceContext);
        this.serviceContext = serviceContext;
    }

    public CBaseModel(T object, Map<String, Map> serviceContext) {
        this.object = object;
        this.serviceContext = serviceContext;
        this._manager = getManager(this.getClass());
    }

    public String getVerbose() throws SystemException, PortalException {
        return this.object.toString();
    }

    public ModelManager getManager() {
        return _manager;
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

    public void setValues(Map<String, Object> valueMap) throws SystemException, PortalException {
        _manager.setValues(this, valueMap);
    }

    public Object getValue(String fieldName) throws SystemException, PortalException {
        return _manager.getValue(this, fieldName, getServiceContext());
    }

    public ModelQuery getMuliValue(String fieldName) throws SystemException, PortalException {
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

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public Map<String, Map> getServiceContext() {
        return serviceContext;
    }

    public void setServiceContext(Map<String, Map> serviceContext) {
        this.serviceContext = serviceContext;
    }


    /* static methods */

    public static ModelManager getManager(Class clazz) {
        ModelManager manager = managers.get(clazz.getName());

        if (manager != null) {
            return manager;
        } else {
//            try {
//                Method method = clazz.getMethod("getManager");
//                ModelManager2 manager = (ModelManager2) method.invoke(clazz);
//                Field  field = clazz.getField("manager");
//                manager = (ModelManager2) field.get(clazz);
//                managers.putIfAbsent(clazz.getName(), manager);
//            } catch (NoSuchMethodException e) {
//                e.printStackTrace();
//            } catch (InvocationTargetException e) {
//                e.printStackTrace();
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (NoSuchFieldException e) {
//                e.printStackTrace();
//            }
            // return manager;
            ClassUtils.forceInit(clazz);
            return managers.get(clazz.getName());
        }
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

    /* inner classes */

    public static class ClassUtil<T extends CBaseModel> {
        private Class cls;

        public ClassUtil(Class<T> cls) {
            this.cls = cls;
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
    }
}