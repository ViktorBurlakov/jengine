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


import com.jengine.db.field.*;
import com.jengine.utils.ClassUtils;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.persistence.BasePersistence;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

import static com.jengine.utils.CollectionUtil.*;


public class ModelManager {
    private String name;
    private String tableName;
    private Class customModel;
    private Class modelClass;
    private Class modelClassImpl;
    private Map<String, Integer> columns = new HashMap<String, Integer>();
    private Map<String, Field> fields = new LinkedHashMap<String, Field>();
    private Map<String, Field> serviceFields = new LinkedHashMap<String, Field>();
    private Field primaryKey = null;
    private SelfField self;
    private PersistenceManager persistenceManager;
    private DynamicQueryManager dynamicQueryManager;
    public Boolean cacheEnabled;

    public ModelManager(Class<? extends CBaseModel> customModel) {
        this(customModel, map());
    }

    public ModelManager(Class<? extends CBaseModel> customModel, Map<String, Object> options) {
        this.customModel = customModel;
        this.name = options.containsKey("name") ? (String) options.get("name") : customModel.getSimpleName();
        this.modelClass = options.containsKey("modelClass") ?
                (Class) options.get("modelClass") : ClassUtils.getGenericSuperclassType(customModel, 0);
        this.modelClassImpl = options.containsKey("modelClassImpl") ?
                (Class) options.get("modelClassImpl") : ClassUtils.getGenericSuperclassType(customModel, 1);
        this.tableName = options.containsKey("table") ?
                (String) options.get("table") : customModel.getAnnotation(Meta.class).table();
        this.cacheEnabled = options.containsKey("cacheEnabled") ?
                (Boolean) options.get("cacheEnabled") : customModel.getAnnotation(Meta.class).cacheEnabled();

        Map<String, Field> clsFields = new LinkedHashMap<String, Field>();
        self = new SelfField(customModel);
        clsFields.put("self", self);
        clsFields.putAll(getFields(customModel));
        clsFields.putAll(getProperties(customModel));
        clsFields.put("verbose", new ModelProperty("verbose", "getVerbose", BaseModel.class, map("verbose", name)));
        for (String fldName: clsFields.keySet()) {
            Field field = clsFields.get(fldName);
            // init field
            field.setName(fldName);
            field.setManager(this);
            field.init();
            if (field.isReference()) {
                ((ReferenceField) field).setFieldClassImpl(field.getFieldClass().equals(customModel) ?
                        modelClassImpl : CBaseModel.getManager(field.getFieldClass()).getModelClassImpl());
            }
            // register field
            this.fields.put(field.getName(), field);
            this.serviceFields.put(field.getServiceName(), field);
            if (field.isPrimaryKey()) {
                this.primaryKey = field;
            }
        }
        persistenceManager = new PersistenceManager(this);
        dynamicQueryManager = new DynamicQueryManager(this);
        // register manager
        CBaseModel.managers.put(customModel.getName(), this);
    }

    protected CBaseModel wrap(Class customModel, BaseModel obj, Map<String, Map> context) throws SystemException, PortalException {
        return CBaseModel.getManager(customModel).wrap(obj, context);
    }

    protected CBaseModel wrap(BaseModel obj, Map<String, Map> context) throws SystemException, PortalException {
        CBaseModel model = newInstance();
        model.setServiceContext(context);
        model.setObject(obj);

        return model;
    }

    public CBaseModel get(Object id, Map<String, Map> context) throws SystemException, PortalException {
        BasePersistence persistence = (BasePersistence) context.get(modelClass.getSimpleName()).get("persistence");
        return wrap(persistence.fetchByPrimaryKey((Serializable) primaryKey.castServiceType(id)), context);
    }

    public ModelQuery select(Object ... fields) throws SystemException {
        return select(Arrays.asList(fields));
    }

    public ModelQuery select(List fields) throws SystemException {
        return new ModelQuery(this).fields(fields);
    }

    public ModelQuery filter(Map<String, Object> filter) throws SystemException {
        return filter(PersistenceManager.parse(filter));
    }

    public ModelQuery filterMap(Object ... filters) throws SystemException {
        return filter(PersistenceManager.parse(map(filters)));
    }

    public ModelQuery filter(Expression ... filters) throws SystemException {
        return filter(Arrays.asList(filters));
    }

    public ModelQuery filter(List<Expression> filter) throws SystemException {
        return new ModelQuery(this).filter(filter);
    }

    public void update(Map<String, Object> filter, Map<String, Object> values, Map<String, Map> context) throws SystemException {
        update(PersistenceManager.parse(filter), values, context);
    }

    public void update(List<Expression> filter, Map<String, Object> values, Map<String, Map> context) throws SystemException {
        BasePersistence persistence = (BasePersistence) context.get(modelClass.getSimpleName()).get("persistence");
        persistenceManager.update(filter, values, persistence);
    }

    public void remove(Map<String, Map> context) throws SystemException {
        remove(list(), context);
    }

    public void remove(Map<String, Object> filter, Map<String, Map> context) throws SystemException {
        remove(PersistenceManager.parse(filter), context);
    }

    public void remove(List<Expression> filter, Map<String, Map> context) throws SystemException {
        BasePersistence persistence = (BasePersistence) context.get(modelClass.getSimpleName()).get("persistence");
        persistenceManager.remove(filter, persistence);
    }

    public Long count(Map<String, Map> context) throws SystemException, PortalException {
        return (Long) new ModelQuery(this).field(getCountField(primaryKey.getName())).one(context);
    }

    public Long count(String field, Map<String, Map> context) throws SystemException, PortalException {
        return (Long) new ModelQuery(this).field(getCountField(field)).one(context);
    }

    public Object max(String field, Map<String, Map> context) throws SystemException, PortalException {
        return new ModelQuery(this).field(getMaxField(field)).one(context);
    }

    public Object min(String field, Map<String, Map> context) throws SystemException, PortalException {
        return new ModelQuery(this).field(getMinField(field)).one(context);
    }

    public Object avg(String field, Map<String, Map> context) throws SystemException, PortalException {
        return new ModelQuery(this).field(getAvgField(field)).one(context);
    }

    public Object sum(String field, Map<String, Map> context) throws SystemException, PortalException {
        return new ModelQuery(this).field(getSumField(field)).one(context);
    }

    public Long count(Field field, Map<String, Map> context) throws SystemException, PortalException {
        return (Long) new ModelQuery(this).field(getCountField(field)).one(context);
    }

    public Object max(Field field, Map<String, Map> context) throws SystemException, PortalException {
        return new ModelQuery(this).field(getMaxField(field)).one(context);
    }

    public Object min(Field field, Map<String, Map> context) throws SystemException, PortalException {
        return new ModelQuery(this).field(getMinField(field)).one(context);
    }

    public Object avg(Field field, Map<String, Map> context) throws SystemException, PortalException {
        return new ModelQuery(this).field(getAvgField(field)).one(context);
    }

    public Object sum(Field field, Map<String, Map> context) throws SystemException, PortalException {
        return new ModelQuery(this).field(getSumField(field)).one(context);
    }

    public Object calc(Map<String, Map> context, String name, Class type, String expr, Field ... fields) throws SystemException, PortalException {
        FunctionField functionField = new FunctionField(this, name, type, map(), expr, (Field[]) fields);
        return new ModelQuery(this).field(functionField).one(context);
    }

    public BaseModel createServiceModel(Serializable id, Map<String, Map> context) throws SystemException, PortalException {
        BasePersistence persistence = (BasePersistence) context.get(modelClass.getSimpleName()).get("persistence");

        BaseModel obj = null;
        try {
            obj = (BaseModel) modelClassImpl.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
            throw new SystemException(e);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new SystemException(e);
        }

        obj.setNew(true);
        obj.setPrimaryKeyObj((Serializable) primaryKey.castType(id));

        return obj;
    }

    public CBaseModel update(CBaseModel obj) throws SystemException, PortalException {
        Map<String, Map> context = obj.getServiceContext();
        BasePersistence persistence = (BasePersistence) context.get(modelClass.getSimpleName()).get("persistence");

        persistence.update(obj.getObject(), false);

        return obj;
    }

    public void remove(CBaseModel obj) throws SystemException, PortalException {
        Map<String, Map> context = obj.getServiceContext();
        BasePersistence persistence = (BasePersistence) context.get(modelClass.getSimpleName()).get("persistence");

        persistence.remove(obj.getObject().getPrimaryKeyObj());
    }

    public CBaseModel save(CBaseModel obj) throws SystemException, PortalException {
        if (obj.isNew()) {
            createServiceModel((Serializable) primaryKey.castServiceType(obj.getPrimaryKey()), obj.getServiceContext());
        }
        return update(obj);
    }

    public void cache(CBaseModel obj) throws SystemException, PortalException {
        EntityCacheUtil.putResult(cacheEnabled, modelClassImpl, obj.getPrimaryKey(), obj.getObject());

        obj.getObject().resetOriginalValues();
    }

    public CBaseModel newInstance() throws SystemException, PortalException {
        CBaseModel obj = null;
        try {
            obj = (CBaseModel) customModel.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            throw new SystemException(e.getMessage());
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            throw new SystemException(e.getMessage());
        }
        return obj;
    }

    public void setValue(CBaseModel obj, String fieldName, Object value) throws SystemException, PortalException {
        setValue(obj, getField(fieldName), value);
    }

    public void setValue(CBaseModel obj, Field field, Object value) throws SystemException, PortalException {
        if (field.isForeign() || field.isFunction() || field.isProperty()) {
            return;
        }
        obj.getDbValues().put(field.getServiceName(), field.castServiceType(value));
    }

    public void setValues(CBaseModel obj,  BaseModel serviceObj) throws SystemException, PortalException {
        for (String fieldName : serviceFields.keySet()) {
            Field field = serviceFields.get(fieldName);
            if (!field.isFunction() && !field.isMultiReference() && !field.isProperty() && !field.isSelf()) {
                setValue(obj, field, field.castServiceType(serviceObj.getModelAttributes().get(fieldName)));
            }
        }
    }

    public void setValues(CBaseModel obj, Map<String, Object> valueMap) throws SystemException, PortalException {
        for (String fieldName : valueMap.keySet()) {
            setValue(obj, fieldName, valueMap.get(fieldName));
        }
    }

    public Object getValue(CBaseModel obj, String field, Map<String, Map> context) throws SystemException, PortalException {
        return getValue(obj, getField(field), context);
    }

    public Object getValue(CBaseModel obj, Field modelField, Map<String, Map> context) throws SystemException, PortalException {
        if (modelField.isForeign()) {
            ForeignField foreignField = (ForeignField) modelField;
            Object referenceId = obj.getDbValues().get(foreignField.getReference().getName());
            CBaseModel reference = CBaseModel.get(modelField.getFieldClass(), referenceId, context);

            return reference.getValue(foreignField.getField());
        } else if (modelField.isReference()) {
                Object referenceId = obj.getDbValues().get(modelField.getServiceName());
                return CBaseModel.get(modelField.getFieldClass(), referenceId, context);
        } else if (modelField.isMultiReference()) {
                MultiReferenceField multiField = (MultiReferenceField) modelField;
                Object primaryKey = getValue(obj, getPrimaryKey(), context);
                return CBaseModel.filter(modelField.getFieldClass(), map(multiField.getReferenceModelField(), primaryKey));
        } else if (modelField.isProperty()) {
            try {
                Method method = customModel.getMethod(((ModelProperty) modelField).getMethodName());
                return method.invoke(obj);
            } catch (Exception e) {
                throw new SystemException(e);
            }
        } else {
            return obj.getDbValues().get(modelField.getServiceName());
        }
    }

    public Map<String, Object> getValues(CBaseModel obj, List<String> fields, Map<String, Map> context) throws SystemException, PortalException {
        Map<String, Object> values = new LinkedHashMap<String, Object>();

        for (String fieldName : fields) {
            values.put(fieldName, getValue(obj, fieldName, context));
       }

        return values;
    }

    public BaseModel getServiceObject(CBaseModel obj, Map<String, Map> context) throws PortalException, SystemException {
        BaseModel serviceObject = null;
        try {
            serviceObject = (BaseModel) modelClassImpl.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new PortalException(e.getMessage());
        }
        Map<String, Object> objectAttributes = serviceObject.getModelAttributes();
        for (String fieldName : serviceFields.keySet()) {
            Field field = serviceFields.get(fieldName);
            if (!field.isFunction() && !field.isMultiReference() && !field.isProperty() && !field.isSelf()) {
                objectAttributes.put(fieldName, field.castServiceType(getValue(obj, field, context)));
            }
        }
        serviceObject.setModelAttributes(objectAttributes);
        return serviceObject;
    }

    public FunctionField getCountField(String field) {
        return getCountField(getField(field));
    }

    public FunctionField getCountField(Field modelField) {
        String name = String.format("count_%s", modelField.getName().replaceAll("\\.", "__"));
        return new FunctionField(this, name, modelField.getFieldClass(), map("ormType", Type.LONG), "count(%s)", modelField);
    }

    public FunctionField getMaxField(String field) {
        return getMaxField(getField(field));
    }

    public FunctionField getMaxField(Field modelField) {
        String name = String.format("max_%s", modelField.getName().replaceAll("\\.", "__"));
        return new FunctionField(this, name, modelField.getFieldClass(), map("ormType", modelField.getOrmType()), "max(%s)", modelField);
    }

    public FunctionField getMinField(String field) {
        return  getMinField(getField(field));
    }

    public FunctionField getMinField(Field modelField) {
        String name = String.format("min_%s", modelField.getName().replaceAll("\\.", "__"));
        return new FunctionField(this, name, modelField.getFieldClass(), map("ormType", modelField.getOrmType()), "min(%s)", modelField);
    }

    public FunctionField getAvgField(String field) {
        return getAvgField(getField(field));
    }

    public FunctionField getAvgField(Field modelField) {
        String name = String.format("avg_%s", modelField.getName().replaceAll("\\.", "__"));
        return new FunctionField(this, name, modelField.getFieldClass(), map("ormType", Type.DOUBLE), "avg(%s)", modelField);
    }

    public FunctionField getSumField(String field) {
        return getSumField(getField(field));
    }

    public FunctionField getSumField(Field modelField) {
        String name = String.format("sum_%s", modelField.getName().replaceAll("\\.", "__"));
        return new FunctionField(this, name, modelField.getFieldClass(), map("ormType", modelField.getOrmType()), "sum(%s)", modelField);
    }

    public Field getField(String fieldName) {
        if (fieldName.contains(".")) {
            List<String> parts = Arrays.asList(fieldName.split("\\."));
            ReferenceField referenceField = (ReferenceField) fields.get(parts.get(0));
            Class referenceModelClass = referenceField.getFieldClass();
            ModelManager manager = CBaseModel.getManager(referenceModelClass);
            String tail = concat(parts.subList(1, parts.size()), ".");
            return new ForeignField(this, fieldName, referenceField, manager.getField(tail));
        } else {
            return fields.get(fieldName);
        }
    }

    public List<Field> getFields(boolean visible, boolean keys) {
        return getFields(new ArrayList<String>(), visible, keys, new ArrayList<String>());
    }

    public List<Field> getFields(List<String> fields) {
        return getFields(fields, false, false, new ArrayList<String>());
    }

    public List<Field> getFields(List<String> fields, boolean visible, boolean keys, List<String> exclude) {
        List<Field> result = new ArrayList<Field>();
        Map<String, Field> cache = new  HashMap<String, Field>();

        for (String fieldName : fields) {
            Field field = getField(fieldName);
            cache.put(fieldName, field);
            result.add(field);
        }
        if (keys) {
            for (Field field : this.fields.values()) {
                if (field.isKey() && !cache.containsKey(field.getName())) {
                    cache.put(field.getName(), field);
                    result.add(field);
                }
            }
        }
        if (visible) {
            for (Field field : this.fields.values()) {
                if (field.isVisible() && !cache.containsKey(field.getName())) {
                    cache.put(field.getName(), field);
                    result.add(field);
                }
            }
        }
        return  result;
    }

    public List<Field> getFields() {
        List<Field> result = new ArrayList<Field>();

        for (Field field : this.fields.values()) {
            result.add(field);
        }

        return  result;
    }

    /* getters and setters */

    public SelfField getSelf() {
        return self;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getCacheEnabled() {
        return cacheEnabled;
    }

    public void setCacheEnabled(Boolean cacheEnabled) {
        this.cacheEnabled = cacheEnabled;
    }

    public Class getModelClass() {
        return modelClass;
    }

    public void setModelClass(Class modelClass) {
        this.modelClass = modelClass;
    }

    public Map<String, Field> getFieldMap() {
        return fields;
    }

    public PersistenceManager getPersistenceManager() {
        return persistenceManager;
    }

    public Map<String, Field> getServiceFields() {
        return serviceFields;
    }

    public void setServiceFields(Map<String, Field> serviceFields) {
        this.serviceFields = serviceFields;
    }

    public Field getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(Field primaryKey) {
        this.primaryKey = primaryKey;
    }

    public Class getModelClassImpl() {
        return modelClassImpl;
    }

    public String getTableName() {
        return tableName;
    }

    public String getModelAlias() {
        return modelClass.getSimpleName().toLowerCase();
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Class getCustomModel() {
        return customModel;
    }

    public void setCustomModel(Class customModel) {
        this.customModel = customModel;
    }

    public Map<String, Integer> getColumns() {
        return columns;
    }

    public void setColumns(Map<String, Integer> columns) {
        this.columns = columns;
    }

    public DynamicQueryManager getDynamicQueryManager() {
        return dynamicQueryManager;
    }

    /* static methods */

    public static Map<String, Map<String, Object>> serialize(Map<String, Field> fieldMap) {
        Map<String, Map<String, Object>> result = new HashMap<String, Map<String, Object>>();

        for (Field field : fieldMap.values()) {
            result.put(field.getName(), field.toMap());
        }

        return result;
    }

    public static List<Map<String, Object>> serialize(List<Field> fieldList) {
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();

        for (Field field : fieldList) {
            result.add(field.toMap());
        }

        return result;
    }

    public LinkedHashMap<String, Field> getFields(Class cls) {
        LinkedHashMap<String, Field> modelFields = new LinkedHashMap<String, Field>();
        java.lang.reflect.Field fieldlist[] = cls.getDeclaredFields();
        for (int i = 0; i < fieldlist.length; i++) {
            java.lang.reflect.Field fld = fieldlist[i];
            if (Modifier.isStatic(fld.getModifiers()) &&
                    fld.getType().isAssignableFrom(Field.class)) {
                try {
                    modelFields.put(fld.getName(), (Field) fld.get(null));
                } catch (IllegalAccessException e) {
                }
            }
        }
        return modelFields;
    }

    public static Map<String, ModelProperty> getProperties(Class cls) {
        Map<String, ModelProperty> properties = new LinkedHashMap<String, ModelProperty>();

        for (Method method : cls.getMethods()) {
            if (method.isAnnotationPresent(ModelAttribute.class)) {
                ModelAttribute attribute = method.getAnnotation(ModelAttribute.class);
                properties.put(attribute.name(), new ModelProperty(attribute.name(), method.getName(), method.getReturnType(),
                        map("verbose", attribute.verbose(), "visible", attribute.visible())));
            }
        }
        return properties;
    }
}
