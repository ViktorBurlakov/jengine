package com.jengine.orm.db.adapter.liferay;


import com.jengine.orm.db.DBException;
import com.jengine.orm.model.Model;
import com.jengine.orm.model.ModelClass;
import com.jengine.orm.model.field.BooleanField;
import com.jengine.orm.model.field.Field;
import com.jengine.orm.model.field.PrimaryKey;
import com.jengine.orm.model.field.StringField;
import com.jengine.orm.model.field.datetime.DateTimeField;
import com.jengine.orm.model.field.numeric.DoubleField;
import com.jengine.orm.model.field.numeric.FloatField;
import com.jengine.orm.model.field.numeric.IntegerField;
import com.jengine.orm.model.field.numeric.LongField;
import com.jengine.utils.ClassUtils;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.model.BaseModel;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.*;

public class LiferayModelClass<T extends Model>  extends ModelClass<T> {
    private Class entryModelClass;
    private Class entryModelClassImpl;
    private boolean liferayCacheEnabled = true;
    private boolean autoScan = true;

    public LiferayModelClass(Class cls) {
        this(cls, new HashMap());
    }

    public LiferayModelClass(Class cls, Map options) {
        super(cls, options);
        liferayCacheEnabled = options.containsKey("liferayCacheEnabled") ?
                (Boolean) options.get("liferayCacheEnabled") : liferayCacheEnabled;
        liferayCacheEnabled = options.containsKey("autoScan") ?
                (Boolean) options.get("autoScan") : liferayCacheEnabled;
        entryModelClass = ClassUtils.getGenericSuperclassType(cls, 0);
        try {
            entryModelClassImpl = PortalClassLoaderUtil.getClassLoader().loadClass(entryModelClass.getClass().getName() + "Impl");
            if (liferayCacheEnabled) {
            boolean cacheEnabled = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get("value.object.entity.cache.enabled." + entryModelClass.getName()));
            manager.setCacheEnabled(cacheEnabled && manager.getCacheEnabled());
            }
            manager.setTableName((String) entryModelClassImpl.getDeclaredField("TABLE_NAME").get(entryModelClassImpl));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (autoScan) {
            Set exclude = options.containsKey("exclude") ? (Set) options.get("exclude") : new HashSet();
            String pkFieldName = null;
            try {
                BeanInfo bi = Introspector.getBeanInfo(entryModelClassImpl);
                for (PropertyDescriptor propertyDescriptor : bi.getPropertyDescriptors()) {
                    String fieldName = propertyDescriptor.getName();
                    Class fieldClass = propertyDescriptor.getPropertyType();
                    if (!manager.getFieldMap().containsKey(fieldName) && !exclude.contains(fieldName)) {
                        if (pkFieldName == null) {
                            getManager().addField(fieldName, new PrimaryKey(fieldClass));
                            pkFieldName = fieldName;
                        } else {
                            Field field = map(fieldClass);
                            if (field != null) {
                                getManager().addField(fieldName, field);
                            }
                        }
                    }
                }
            } catch (IntrospectionException e) {
                e.printStackTrace();
            }
        }
    }

    public T newInstance(BaseModel entityObject) throws DBException {
        T obj = newInstance();

        obj.setNew(entityObject.isNew());
        for (Field field : manager.getPersistenceFields()) {
            String entityFieldName = field.getOptions().containsKey("entityFieldName")  ?
                    (String) field.getOptions().get("entityFieldName") : field.getFieldName();
            obj.setValue(field, entityObject.getModelAttributes().get(entityFieldName));
        }

        return obj;
    }

    public BaseModel toEntityObject(Model obj) throws DBException {
        BaseModel entityObject = null;
        try {
            entityObject = (BaseModel) entryModelClassImpl.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException(e);
        }

        obj.setNew(obj.isNew());
        for (Field field : manager.getPersistenceFields()) {
            String entityFieldName = field.getOptions().containsKey("entityFieldName")  ?
                    (String) field.getOptions().get("entityFieldName") : field.getFieldName();
            entityObject.getModelAttributes().put(entityFieldName, obj.getData().get(field.getFieldName()));
        }

        return entityObject;
    }

    protected Field map(Class entityClass) {
        Field field = null;
        if (entityClass.equals(String.class)) {
           field = new StringField();
        } else if (entityClass.equals(Integer.class)) {
            field = new IntegerField();
        } else if (entityClass.equals(Long.class)) {
            field = new LongField();
        } else if (entityClass.equals(Float.class)) {
            field = new FloatField();
        } else if (entityClass.equals(Double.class)) {
            field = new DoubleField();
        } else if (entityClass.equals(Double.class)) {
            field = new DoubleField();
        } else if (entityClass.equals(Date.class)) {
            field = new DateTimeField();
        } else if (entityClass.equals(Boolean.class)) {
            field = new BooleanField();
        }

        return field;
    }

    /* getters && setters */

    public Class getEntryModelClass() {
        return entryModelClass;
    }

    public void setEntryModelClass(Class entryModelClass) {
        this.entryModelClass = entryModelClass;
    }

    public Class getEntryModelClassImpl() {
        return entryModelClassImpl;
    }

    public void setEntryModelClassImpl(Class entryModelClassImpl) {
        this.entryModelClassImpl = entryModelClassImpl;
    }
}
