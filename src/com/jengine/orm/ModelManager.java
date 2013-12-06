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


import com.jengine.orm.field.*;
import com.liferay.portal.kernel.dao.orm.Type;

import java.util.*;

import static com.jengine.utils.CollectionUtil.concat;
import static com.jengine.utils.CollectionUtil.map;


public class ModelManager {
//    public static Map<String, List<MultiReferenceField>> deferredReferences = new ConcurrentHashMap<String, List<MultiReferenceField>>();
    private String name;
    private String tableName;
    private Class modelClass;
    private Map<String, Field> fields = new LinkedHashMap<String, Field>();
    private Field primaryKey = null;
    private SelfField self;
    private Boolean cacheEnabled;
    private ModelClass cls;

    public ModelManager() {
    }

    public void addProperties(List<ModelProperty> properties) {
        for (ModelProperty property: properties) {
            addField(property);
        }
    }

    public void addFields(List<Field> fields) {
        for (Field field: fields) {
            addField(field);
        }
    }

    public void addField(Field field) {
        // collect fields
//        if (deferredReferences.containsKey(customModel.getName())) {
//            for (MultiReferenceField multiReferenceField: deferredReferences.get(customModel.getName())){
//                clsFields.put(multiReferenceField.getName(), multiReferenceField);
//           }
//        }
        // init field
        field.setManager(this);
        field.init();
        if (field.isReference()) {
            ReferenceField referenceField = (ReferenceField) field;
            // add multi reference field to another model
//                String multiFieldName = referenceField.getMultiReferenceFieldName() != null ?
//                        referenceField.getMultiReferenceFieldName() : String.format("%s_set", customModel.getSimpleName().toLowerCase());
//                MultiReferenceField multiReferenceField = new MultiReferenceField(multiFieldName, customModel, referenceField.getName());
//                ModelManager referenceManager = CBaseModel.getManager(field.getFieldClass());
//                if (referenceManager != null) {
//                    referenceManager.addMultiField(multiReferenceField);
//                } else {
//                    if (!deferredReferences.containsKey(field.getFieldClass().getName())) {
//                        deferredReferences.put(field.getFieldClass().getName(), new ArrayList<MultiReferenceField>());
//                    }
//                    deferredReferences.get(field.getFieldClass().getName()).add(multiReferenceField);
//                }
        }
        // register field
        this.fields.put(field.getName(), field);
        if (field.isPrimaryKey()) {
            this.primaryKey = field;
        }
        if (field.isSelf()) {
            this.self = (SelfField) field;
        }
    }

    public void addMultiField(MultiReferenceField field) {
        field.setManager(this);
        field.init();
        // register field
        this.fields.put(field.getName(), field);
    }

    /* aggregation function fields */

    public FunctionField getCountField(String field) {
        return getCountField(getField(field));
    }

    public FunctionField getCountAllField() {
        return new FunctionField(this, "_count_", Long.class, "count(*)");
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
        return getMinField(getField(field));
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
            ModelManager manager = cls.getModelClass(referenceModelClass).getManager();
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

    public List<String> getFieldNames() {
        List<String> result = new ArrayList<String>();

        result.addAll(this.fields.keySet());

        return  result;
    }

    /* getters and setters */

    public ModelClass getCls() {
        return cls;
    }

    public void setCls(ModelClass cls) {
        this.cls = cls;
    }

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

    public Field getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(Field primaryKey) {
        this.primaryKey = primaryKey;
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


}
