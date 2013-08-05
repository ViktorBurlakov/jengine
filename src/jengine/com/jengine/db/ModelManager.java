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
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

import static com.jengine.utils.CollectionUtil.concat;
import static com.jengine.utils.CollectionUtil.list;
import static com.jengine.utils.CollectionUtil.map;


public class ModelManager {
    private String modelName;
    private String tableName;
    private Class customModel;
    private Class modelClass;
    private Class modelClassImpl;
    private Map<String, Integer> columns = new HashMap<String, Integer>();
    private Map<String, ModelField> fields = new LinkedHashMap<String, ModelField>();
    private Map<String, ModelField> serviceFields = new LinkedHashMap<String, ModelField>();
    private ModelField primaryKey = null;
    private SelfField self;
    private PersistenceManager persistenceManager;
    private DynamicQueryManager dynamicQueryManager;
    public Boolean entryCacheEnabled;

    public ModelManager(Class<? extends CustomBaseModel> customModel, String modelName, Class serviceCls, Class serviceClsImpl) {
        this(customModel, modelName, serviceCls, serviceClsImpl,
                (String) ClassUtils.getClassField(serviceClsImpl, "TABLE_NAME", null),
                (Object[][]) ClassUtils.getClassField(serviceClsImpl, "TABLE_COLUMNS", new Object[][]{}),
                (Boolean) ClassUtils.getClassField(serviceClsImpl, "ENTITY_CACHE_ENABLED", true));
    }

    public ModelManager(Class<? extends CustomBaseModel> customModel, String modelName, Class serviceCls, Class serviceClsImpl,
                         String tableName, Object[][] columns, Boolean entryCacheEnabled) {
        this.customModel = customModel;
        this.modelName = modelName;
        this.modelClass = serviceCls;
        this.modelClassImpl = serviceClsImpl;
        this.tableName = tableName;
        this.entryCacheEnabled = entryCacheEnabled;
        // columns
        for (int i=0; i < columns.length; i++) {
            this.columns.put((String) columns[i][0], (Integer) columns[i][1]);
        }
        //fields
        self = new SelfField(customModel);
        self.setFieldClassImpl(serviceClsImpl);
        List<ModelField> clsFields = new ArrayList<ModelField>();
        clsFields.addAll(getFields(customModel).values());
        clsFields.add(self);
        for (ModelField field : clsFields) {
            addField(field);
        }
        // properties
        List<ModelProperty> clsProperties = getProperties(customModel);
        clsProperties.add(new ModelProperty("verbose", "getVerbose", BaseModel.class, map("verbose", modelName)));
        for (ModelProperty property : clsProperties) {
            property.setModel(serviceCls);
            this.fields.put(property.getName(), property);
        }
        //persistence
        persistenceManager = new PersistenceManager(this);
        dynamicQueryManager = new DynamicQueryManager(this);
        // register
        CustomBaseModel.managers.put(customModel.getName(), this);
    }

    public void addField(ModelField field) {
        if (!field.isReference() && this.columns.containsKey(field.getDbName())) {
            field.setDbType(this.columns.get(field.getDbName()));
        }
        if (field.isReference()) {
            ReferenceField referenceField = (ReferenceField) field;
            if (field.getFieldClass().equals(customModel)) {
                referenceField.setFieldClassImpl(modelClassImpl);
            } else {
                referenceField.setFieldClassImpl(CustomBaseModel.getManager(field.getFieldClass()).getModelClassImpl());
            }
        }
        field.setModel(this.modelClass);
        this.fields.put(field.getName(), field);
        serviceFields.put(field.getServiceName(), field);
        if (field.isPrimaryKey()) {
            primaryKey = field;
        }
    }

    protected CustomBaseModel wrap(Class customModel, BaseModel obj, Map<String, Map> context) {
        return CustomBaseModel.getManager(customModel).wrap(obj, context);
    }

    protected CustomBaseModel wrap(BaseModel obj, Map<String, Map> context) {
        try {
            return (CustomBaseModel) customModel.getDeclaredConstructor(modelClass, Map.class).newInstance(obj, context);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    public CustomBaseModel get(Object id, Map<String, Map> context) throws SystemException, PortalException {
        BasePersistence persistence = (BasePersistence) context.get(modelClass.getSimpleName()).get("persistence");
        return wrap(persistence.fetchByPrimaryKey((Serializable) primaryKey.castType(id)), context);
    }

    public ModelQuery select() throws SystemException {
        return new ModelQuery(this);
    }

    public ModelQuery select(Map<String, Object> filter) throws SystemException {
        return select(PersistenceManager.parse(filter));
    }

    public ModelQuery select(List<Expression> filter) throws SystemException {
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

    public BaseModel createModel(Serializable id, Map<String, Map> context) throws SystemException, PortalException {
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

    public CustomBaseModel update(CustomBaseModel obj) throws SystemException, PortalException {
        Map<String, Map> context = obj.getServiceContext();
        BasePersistence persistence = (BasePersistence) context.get(modelClass.getSimpleName()).get("persistence");

        persistence.update(obj.getObject(), false);

        return obj;
    }

    public void remove(CustomBaseModel obj) throws SystemException, PortalException {
        Map<String, Map> context = obj.getServiceContext();
        BasePersistence persistence = (BasePersistence) context.get(modelClass.getSimpleName()).get("persistence");

        persistence.remove(obj.getObject().getPrimaryKeyObj());
    }

    public CustomBaseModel save(CustomBaseModel obj) throws SystemException, PortalException {
        return update(obj);
    }

    public void cache(CustomBaseModel obj) throws SystemException, PortalException {
        EntityCacheUtil.putResult(entryCacheEnabled, modelClassImpl, obj.getPrimaryKey(), obj.getObject());

        obj.getObject().resetOriginalValues();
    }

    public void setValue(CustomBaseModel obj, String fieldName, Object value) throws SystemException, PortalException {
        setValue(obj, getField(fieldName), value);
    }

    public void setValue(CustomBaseModel obj, ModelField field, Object value) throws SystemException, PortalException {
        if (field.isForeign() || field.isFunction() || field.isProperty()) {
            return;
        }
        Map<String, Object> attributes = obj.getObject().getModelAttributes();
        attributes.put(field.getServiceName(), field.castServiceType(value));
        obj.getObject().setModelAttributes(attributes);
    }

    public void setValues(CustomBaseModel obj, Map<String, Object> valueMap) throws SystemException, PortalException {
        for (String fieldName : valueMap.keySet()) {
            setValue(obj, fieldName, valueMap.get(fieldName));
        }
    }

    public Object getValue(CustomBaseModel obj, String field, Map<String, Map> context) throws SystemException, PortalException {
        return getValue(obj, getField(field), context);
    }

    public Object getValue(CustomBaseModel obj, ModelField modelField, Map<String, Map> context) throws SystemException, PortalException {
        if (modelField.isForeign()) {
            ForeignField foreignField = (ForeignField) modelField;
            Object referenceId = obj.getObject().getModelAttributes().get(foreignField.getReference().getServiceName());
            CustomBaseModel reference = CustomBaseModel.get(modelField.getFieldClass(), referenceId, context);

            return reference.getValue(foreignField.getField());
        } else if (modelField.isReference()) {
                Object referenceId = obj.getObject().getModelAttributes().get(modelField.getServiceName());
                return CustomBaseModel.get(modelField.getFieldClass(), referenceId, context);
        } else if (modelField.isMultiReference()) {
                MultiReferenceField multiField = (MultiReferenceField) modelField;
                Object primaryKey = getValue(obj, getPrimaryKey(), context);
                return CustomBaseModel.select(modelField.getFieldClass()).filter(map(multiField.getReferenceModelField(), primaryKey));
        } else if (modelField.isProperty()) {
            try {
                Method method = customModel.getMethod(((ModelProperty) modelField).getMethodName());
                return method.invoke(obj);
            } catch (Exception e) {
                throw new SystemException(e);
            }
        } else {
            return obj.getObject().getModelAttributes().get(modelField.getServiceName());
        }
    }

    public Map<String, Object> getValues(CustomBaseModel obj, List<String> fields, Map<String, Map> context) throws SystemException, PortalException {
        Map<String, Object> values = new LinkedHashMap<String, Object>();

        for (String fieldName : fields) {
            values.put(fieldName, getValue(obj, fieldName, context));
       }

        return values;
    }

    public FunctionField getCountField(String field) {
        String name = String.format("count_%s", field.replaceAll("\\.", "__"));
        ModelField modelField = getField(field);
        return new FunctionField(name, modelField.getFieldClass(), map("ormType", Type.LONG), "count(%s)", modelField);
    }

    public FunctionField getMaxField(String field) {
        String name = String.format("max_%s", field.replaceAll("\\.", "__"));
        ModelField modelField = getField(field);
        return new FunctionField(name, modelField.getFieldClass(), map("ormType", modelField.getOrmType()), "max(%s)", modelField);
    }

    public FunctionField getMinField(String field) {
        String name = String.format("min_%s", field.replaceAll("\\.", "__"));
        ModelField modelField = getField(field);
        return new FunctionField(name, modelField.getFieldClass(), map("ormType", modelField.getOrmType()), "min(%s)", modelField);
    }

    public FunctionField getAvgField(String field) {
        String name = String.format("avg_%s", field.replaceAll("\\.", "__"));
        ModelField modelField = getField(field);
        return new FunctionField(name, modelField.getFieldClass(), map("ormType", Type.DOUBLE), "avg(%s)", modelField);
    }

    public FunctionField getSumField(String field) {
        String name = String.format("sum_%s", field.replaceAll("\\.", "__"));
        ModelField modelField = getField(field);
        return new FunctionField(name, modelField.getFieldClass(), map("ormType", modelField.getOrmType()), "sum(%s)", modelField);
    }

    public ModelField getField(String fieldName) {
        if (fieldName.contains(".")) {
            List<String> parts = Arrays.asList(fieldName.split("\\."));
            ReferenceField referenceField = (ReferenceField) fields.get(parts.get(0));
            Class referenceModelClass = referenceField.getFieldClass();
            ModelManager manager = CustomBaseModel.getManager(referenceModelClass);
            String tail = concat(parts.subList(1, parts.size()), ".");

            return new ForeignField(fieldName, referenceField, manager.getField(tail));
        } else {
            return fields.get(fieldName);
        }
    }

    public List<ModelField> getFields(boolean visible, boolean keys) {
        return getFields(new ArrayList<String>(), visible, keys, new ArrayList<String>());
    }

    public List<ModelField> getFields(List<String> fields) {
        return getFields(fields, false, false, new ArrayList<String>());
    }

    public List<ModelField> getFields(List<String> fields, boolean visible, boolean keys, List<String> exclude) {
        List<ModelField> result = new ArrayList<ModelField>();
        Map<String, ModelField> cache = new  HashMap<String, ModelField>();

        for (String fieldName : fields) {
            ModelField field = getField(fieldName);
            cache.put(fieldName, field);
            result.add(field);
        }
        if (keys) {
            for (ModelField field : this.fields.values()) {
                if (field.isKey() && !cache.containsKey(field.getName())) {
                    cache.put(field.getName(), field);
                    result.add(field);
                }
            }
        }
        if (visible) {
            for (ModelField field : this.fields.values()) {
                if (field.isVisible() && !cache.containsKey(field.getName())) {
                    cache.put(field.getName(), field);
                    result.add(field);
                }
            }
        }
        return  result;
    }

    public List<ModelField> getFields() {
        List<ModelField> result = new ArrayList<ModelField>();

        for (ModelField field : this.fields.values()) {
            result.add(field);
        }

        return  result;
    }

    /* getters and setters */

    public SelfField getSelf() {
        return self;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Class getModelClass() {
        return modelClass;
    }

    public void setModelClass(Class modelClass) {
        this.modelClass = modelClass;
    }

    public Map<String, ModelField> getFieldMap() {
        return fields;
    }

    public PersistenceManager getPersistenceManager() {
        return persistenceManager;
    }

    public Map<String, ModelField> getServiceFields() {
        return serviceFields;
    }

    public void setServiceFields(Map<String, ModelField> serviceFields) {
        this.serviceFields = serviceFields;
    }

    public ModelField getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(ModelField primaryKey) {
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

    public static Map<String, Map<String, Object>> serialize(Map<String, ModelField> fieldMap) {
        Map<String, Map<String, Object>> result = new HashMap<String, Map<String, Object>>();

        for (ModelField field : fieldMap.values()) {
            result.put(field.getName(), field.toMap());
        }

        return result;
    }

    public static List<Map<String, Object>> serialize(List<ModelField> fieldList) {
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();

        for (ModelField field : fieldList) {
            result.add(field.toMap());
        }

        return result;
    }

    public LinkedHashMap<String, ModelField> getFields(Class cls) {
        LinkedHashMap<String, ModelField> modelFields = new LinkedHashMap<String, ModelField>();
        java.lang.reflect.Field fieldlist[] = cls.getDeclaredFields();
        for (int i = 0; i < fieldlist.length; i++) {
            java.lang.reflect.Field fld = fieldlist[i];
            if (Modifier.isStatic(fld.getModifiers()) &&
                    fld.getType().isAssignableFrom(ModelField.class)) {
                try {
                    modelFields.put(fld.getName(), (ModelField) fld.get(null));
                } catch (IllegalAccessException e) {
                }
            }
        }
        return modelFields;
    }

    public static List<ModelProperty> getProperties(Class cls) {
        List<ModelProperty> properties = new ArrayList<ModelProperty>();

        for (Method method : cls.getMethods()) {
            if (method.isAnnotationPresent(ModelAttribute.class)) {
                ModelAttribute attribute = method.getAnnotation(ModelAttribute.class);
                properties.add(new ModelProperty(attribute.name(), method.getName(), method.getReturnType(),
                        map("verbose", attribute.verbose(), "visible", attribute.visible())));
            }
        }
        return properties;
    }
}
