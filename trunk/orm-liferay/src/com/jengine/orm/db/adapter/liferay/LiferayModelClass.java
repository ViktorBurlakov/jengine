package com.jengine.orm.db.adapter.liferay;


import com.jengine.orm.db.DBException;
import com.jengine.orm.exception.ValidateException;
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
import com.jengine.utils.CollectionUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.persistence.BasePersistence;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.*;

import static com.jengine.utils.StringUtil.caps;

public abstract class LiferayModelClass<T extends Model>  extends ModelClass<T> {
    private static Log log = LogFactoryUtil.getLog(LiferayModelClass.class);
    private Class entryModelClass;

    public LiferayModelClass(Class cls, Class entryModelClass, Map options) {
        super(cls, options);
        this.entryModelClass = entryModelClass;
        if (options.containsKey("autoScan") && (Boolean) options.get("autoScan")) {
            scanEntity(entryModelClass, options.containsKey("exclude") ? (Set) options.get("exclude") : new HashSet());
        }
    }

    protected String getEntityFieldName(Field field) {
        return field.getOptions().containsKey("entityFieldName")  ?
                (String) field.getOptions().get("entityFieldName") : field.getFieldName();
    }

    public T newInstance(BaseModel entityObject) throws DBException {
        T obj = newInstance();

        obj.setNew(entityObject.isNew());
        for (Field field : manager.getPersistenceFields()) {
            String entityFieldName = getEntityFieldName(field);
            obj.setValue(field, entityObject.getModelAttributes().get(entityFieldName));
        }

        return obj;
    }

//    public BaseModel toEntityObject(Model obj) throws DBException {
//        BaseModel entityObject = newEntityInstance();
//      entityObject.setNew(obj.isNew());
//       return setEntityAttributes(entityObject, obj);
//    }

    public void setEntityAttributes(BaseModel entityObject, Model obj) throws DBException {
        Map<String, Object> attributes = new HashMap<String, Object>();
        for (Field field : manager.getPersistenceFields()) {
            String entityFieldName = field.getOptions().containsKey("entityFieldName")  ?
                    (String) field.getOptions().get("entityFieldName") : field.getFieldName();
            attributes.put(entityFieldName, obj.getData().get(field.getFieldName()));
        }
        entityObject.setModelAttributes(attributes);
    }

    /*protected BaseModel newEntityImplInstance() throws ValidateException, DBException {
        BaseModel entity = null;
        if (options.containsKey("entryClassImplName")) {
            String entryModelClassImplName = (String) options.get("entryClassImplName");
            try {
                Class entryModelClassImpl = PortalClassLoaderUtil.getClassLoader().loadClass(entryModelClassImplName);
                entity = (BaseModel) entryModelClassImpl.newInstance();
            } catch (Exception e) {
                throw new DBException(e);
            }
        }

        return entity;
    }
*/
    abstract public BaseModel createEntity(Serializable id) throws ValidateException, DBException;

    public T insert(T obj) throws ValidateException, DBException {
        try {
            // TODO: create entity
            BaseModel entity = createEntity(obj.getPrimaryKey());
            setEntityAttributes(entity, obj);
            getPersistence().update(entity, false);
            obj.setNew(false);
            updateManyReference(obj);
            calcFunctionField(obj);
        } catch (SystemException e) {
            throw new DBException(e);
        }
        return obj;
    }

    public T update(T obj) throws ValidateException, DBException {
        try {
            BaseModel entity = getPersistence().fetchByPrimaryKey(obj.getPrimaryKey());
            setEntityAttributes(entity, obj);
            getPersistence().update(entity, true);
            updateManyReference(obj);
            calcFunctionField(obj);
        } catch (SystemException e) {
            throw new DBException(e);
        }
        return obj;
    }

    public void remove(Model obj) throws DBException {
        try {
            getPersistence().remove(obj.getPrimaryKey());
        } catch (Exception e) {
            throw new DBException(e);
        }
    }

    public boolean isCacheEnabled() throws DBException {
        return manager.getCacheEnabled();
    }

    public T get(Object id) throws DBException {
        try {
            BaseModel entity = getPersistence().fetchByPrimaryKey((Serializable) id);
            return newInstance(entity);
        } catch (SystemException e) {
            e.printStackTrace();
        }
        return null;
    }

    public T getCache(Object id) throws DBException {
//        if (isCacheEnabled()) {
//            try {
//                BaseModel entity = getPersistence().fetchByPrimaryKey((Serializable) id);
//                return newInstance(entity);
//            } catch (SystemException e) {
//                e.printStackTrace();
//            }
//        }
        return null;
    }

    public void clearCache() throws DBException {
        if (isCacheEnabled()) {
            getPersistence().clearCache();
        }
    }

    public void clearCache(Model obj) throws DBException {
//        if (isCacheEnabled()) {
//            getPersistence().clearCache(toEntityObject(obj));
//        }
    }

    public void cache(Model obj) throws DBException {
//        if (isCacheEnabled()) {
//            getPersistence().cache();
//        }
    }

    abstract public BasePersistence getPersistence();

    // for testing
    public boolean equalsEntity(Model model, BaseModel entity) throws DBException {
        boolean result = true;
        for (Field field : getManager().getFields()) {
            String entityFieldName = getEntityFieldName(field);
            System.out.println(field.getFieldName() + " = (" +
                    entity.getModelAttributes().get(entityFieldName) +"," + model.getData().get(field.getFieldName()) + "}");
            if ( entity.getModelAttributes().get(entityFieldName) == null && model.getData().get(field.getFieldName()) != null) {
                result = false;
            } else if (entity.getModelAttributes().get(entityFieldName) != null && model.getData().get(field.getFieldName()) != null) {
                // dynamic query return sql.Timestamp not Date
//                if (entity.getModelAttributes().get(entityFieldName) instanceof Timestamp) {
//                    result = ((Timestamp) entity.getModelAttributes().get(entityFieldName)).getTime() ==
//                            ((Date) model.getData().get(field.getFieldName())).getTime();
//                } else {
//                    result = entity.getModelAttributes().get(entityFieldName).equals(model.getData().get(field.getFieldName()));
//                }
                result = entity.getModelAttributes().get(entityFieldName).equals(model.getData().get(field.getFieldName()));
            }
            if (!result) {
                return false;
            }
        }

        return true;

    }

    /* scan methods */

    /*public void scanEntityImpl(Class entryModelClassImpl, Set exclude) {
        try {
            BeanInfo bi = Introspector.getBeanInfo(entryModelClassImpl, BaseModelImpl.class);
            for (PropertyDescriptor propertyDescriptor : bi.getPropertyDescriptors()) {
                if (propertyDescriptor.getWriteMethod() == null || propertyDescriptor.getReadMethod() == null) {
                    continue;
                }
                String fieldName = propertyDescriptor.getName();
                Class fieldClass = propertyDescriptor.getPropertyType();
                if (!exclude.contains(fieldName)) {
                    Field field = mapFieldType(fieldClass);
                    if (field != null) {
                        field.setVerbose(caps(fieldName));
                        getManager().addField(fieldName, field);
                    } else {
                        log.debug("fieldName type mapping not found: " + fieldName);
                    }
                }
            }
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
    }*/

    public void scanEntity(Class entryModelClass, Set exclude) {
        try {
            LinkedHashMap<String, Class> properties = ClassUtils.reflectBeanInterface(entryModelClass);
            for(String propertyName : properties.keySet()) {
                if (!exclude.contains(propertyName) && !getManager().getFieldMap().containsKey(propertyName)) {
                    Field field = mapFieldType(properties.get(propertyName));
                    if (field != null) {
                        field.setVerbose(caps(propertyName));
                        getManager().addField(propertyName, field);
                    } else {
                        log.debug("fieldName type mapping not found: " + propertyName);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected Field mapFieldType(Class entityClass) {
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
//            field = new DateTimeField();
            field = new DateTimeField(Timestamp.class, CollectionUtil.map());
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
}
