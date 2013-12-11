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

    public Field addField(String name, Field field) {
        field.config(name, this);
        return addField(field);
    }

    public Field addField(Field field) {
        // collect fields
//        if (deferredReferences.containsKey(customModel.getName())) {
//            for (MultiReferenceField multiReferenceField: deferredReferences.get(customModel.getName())){
//                clsFields.put(multiReferenceField.getName(), multiReferenceField);
//           }
//        }
        // init field
        if (field.getType() == Field.Type.REFERENCE) {
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
        this.fields.put(field.getFieldName(), field);
        if (field.isPrimaryKey()) {
            this.primaryKey = field;
        }
        if (field.getType() == Field.Type.SELF) {
            this.self = (SelfField) field;
        }

        return field;
    }

    public void addMultiField(MultiReferenceField field) {
//        field.config(this);
        // register field
        this.fields.put(field.getFieldName(), field);
    }

    /* aggregation function fields */

    public FunctionField newCalcField(String name, Class type, String expr, Field ... fields) {
        FunctionField functionField = new FunctionField(type, map(), expr, (Field[]) fields);
        functionField.config(name, this);
        return functionField;
    }

    public FunctionField newCountField(String field) {
        return newCountField(getField(field));
    }

    public FunctionField newCountAllField() {
        FunctionField field = new FunctionField(Long.class, "count(*)");
        field.config("_count_", this);
        return field;
    }

    public FunctionField newCountField(Field modelField) {
        String name = String.format("count_%s", modelField.getFieldName().replaceAll("\\.", "__"));
        FunctionField field = new FunctionField(modelField.getFieldClass(), map("columnType", Type.LONG), "count(%s)", modelField);
        field.config(name, this);
        return field;
    }

    public FunctionField newMaxField(String field) {
        return newMaxField(getField(field));
    }

    public FunctionField newMaxField(Field modelField) {
        String name = String.format("max_%s", modelField.getFieldName().replaceAll("\\.", "__"));
        FunctionField field = new FunctionField(modelField.getFieldClass(), map("columnType", modelField.getColumnType()), "max(%s)", modelField);
        field.config(name, this);
        return field;
    }

    public FunctionField newMinField(String field) throws DBException {
        return newMinField(getField(field));
    }

    public FunctionField newMinField(Field modelField) {
        String name = String.format("min_%s", modelField.getFieldName().replaceAll("\\.", "__"));
        FunctionField field = new FunctionField(modelField.getFieldClass(), map("columnType", modelField.getColumnType()), "min(%s)", modelField);
        field.config(name, this);
        return field;
    }

    public FunctionField newAvgField(String field) {
        return newAvgField(getField(field));
    }

    public FunctionField newAvgField(Field modelField) {
        String name = String.format("avg_%s", modelField.getFieldName().replaceAll("\\.", "__"));
        FunctionField field = new FunctionField(modelField.getFieldClass(), map("columnType", Type.DOUBLE), "avg(%s)", modelField);
        field.config(name, this);
        return field;
    }

    public FunctionField newSumField(String field) {
        return newSumField(getField(field));
    }

    public FunctionField newSumField(Field modelField) {
        String name = String.format("sum_%s", modelField.getFieldName().replaceAll("\\.", "__"));
        FunctionField field = new FunctionField(modelField.getFieldClass(), map("columnType", modelField.getColumnType()), "sum(%s)", modelField);
        field.config(name, this);
        return field;
    }

    public Field getField(String fieldName) {
        if (fieldName.contains(".")) {
            List<String> parts = Arrays.asList(fieldName.split("\\."));
            ReferenceField referenceField = (ReferenceField) fields.get(parts.get(0));
            Class referenceModelClass = referenceField.getFieldClass();
            ModelManager manager = cls.getModelClass(referenceModelClass).getManager();
            String tail = concat(parts.subList(1, parts.size()), ".").toString();
            ForeignField foreignField = new ForeignField(referenceField,  manager.getField(tail));
            foreignField.config(fieldName, this);
            return foreignField;
        } else {
            return fields.get(fieldName);
        }
    }

    public List<Field> getFields() {
        List<Field> result = new ArrayList<Field>();

        result.addAll(this.fields.values());

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
