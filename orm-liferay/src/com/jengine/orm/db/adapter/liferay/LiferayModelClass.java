package com.jengine.orm.db.adapter.liferay;


import com.jengine.orm.db.DBException;
import com.jengine.orm.model.Model;
import com.jengine.orm.model.ModelClass;
import com.jengine.orm.model.field.BooleanField;
import com.jengine.orm.model.field.Field;
import com.jengine.orm.model.field.StringField;
import com.jengine.orm.model.field.datetime.DateTimeField;
import com.jengine.orm.model.field.numeric.DoubleField;
import com.jengine.orm.model.field.numeric.FloatField;
import com.jengine.orm.model.field.numeric.IntegerField;
import com.jengine.orm.model.field.numeric.LongField;
import com.jengine.utils.ClassUtils;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.*;

import static com.jengine.utils.StringUtil.caps;

public class LiferayModelClass<T extends Model>  extends ModelClass<T> {
    private Class entryModelClass;
    private Class entryModelClassImpl;
    private boolean liferayCacheEnabled = true;
    private boolean autoScan = true;

    public LiferayModelClass(Class cls, String entryClassImplName) {
        this(cls, entryClassImplName, new HashMap());
    }

    public LiferayModelClass(Class cls, String entryClassImplName, Map options) {
        super(cls, options);
        liferayCacheEnabled = options.containsKey("liferayCacheEnabled") ?
                (Boolean) options.get("liferayCacheEnabled") : liferayCacheEnabled;
        autoScan = options.containsKey("autoScan") ?  (Boolean) options.get("autoScan") : liferayCacheEnabled;
        entryModelClass = ClassUtils.getGenericSuperclassType(cls, 0);
        try {
            entryModelClassImpl = PortalClassLoaderUtil.getClassLoader().loadClass(entryClassImplName);
            if (liferayCacheEnabled) {
//            boolean cacheEnabled = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get("value.object.entity.cache.enabled." + entryModelClass.getName()));
                boolean cacheEnabled = (Boolean) entryModelClassImpl.getField("ENTITY_CACHE_ENABLED").get(entryModelClassImpl);
                manager.setCacheEnabled(cacheEnabled && manager.getCacheEnabled());
            }
            manager.setTableName((String) entryModelClassImpl.getField("TABLE_NAME").get(entryModelClassImpl));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (autoScan) {
            scanEntity();
        }
    }

    protected void scanEntity() {
        Set exclude = options.containsKey("exclude") ? (Set) options.get("exclude") : new HashSet();
        try {
            BeanInfo bi = Introspector.getBeanInfo(entryModelClassImpl, BaseModelImpl.class);
            for (PropertyDescriptor propertyDescriptor : bi.getPropertyDescriptors()) {
                if (propertyDescriptor.getWriteMethod() == null || propertyDescriptor.getReadMethod() == null) {
                    continue;
                }
                String fieldName = propertyDescriptor.getName();
                Class fieldClass = propertyDescriptor.getPropertyType();
                if (!manager.getFieldMap().containsKey(fieldName) && !exclude.contains(fieldName)) {
                    Field field = map(fieldClass);
                    if (field != null) {
                        field.setVerbose(caps(fieldName));
                        getManager().addField(fieldName, field);
                    } else {
                        System.out.println("fieldName type mapping not found: " + fieldName);
                    }
                }
            }
        } catch (IntrospectionException e) {
            e.printStackTrace();
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
        } else if (entityClass.equals(Integer.class) || entityClass.equals(int.class)) {
            field = new IntegerField();
        } else if (entityClass.equals(Long.class) || entityClass.equals(long.class) ) {
            field = new LongField();
        } else if (entityClass.equals(Float.class) || entityClass.equals(float.class)) {
            field = new FloatField();
        } else if (entityClass.equals(Double.class) || entityClass.equals(double.class)) {
            field = new DoubleField();
        } else if (entityClass.equals(Date.class)) {
            field = new DateTimeField();
        } else if (entityClass.equals(Boolean.class) || entityClass.equals(boolean.class)) {
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
