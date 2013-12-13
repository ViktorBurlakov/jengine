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

import java.sql.Types;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static com.jengine.utils.CollectionUtil.concat;
import static com.jengine.utils.CollectionUtil.map;


public class ModelManager {
    public static Map<String, Map<String, Field>> deferredFields = new ConcurrentHashMap<String, Map<String, Field>>();
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
        if (field.getType() == Field.Type.REFERENCE) {
            ReferenceField referenceField = (ReferenceField) field;
            // add multi reference field to another model
            String multiFieldName = referenceField.getMultiReferenceFieldName();
            MultiReferenceField multiReferenceField = new MultiReferenceField(name, modelClass, referenceField.getFieldName());
            ModelClassBase referenceModelClass = cls.getModelClass(referenceField.getReferenceModelName());
            if (referenceModelClass != null) {
                multiReferenceField.config(multiFieldName, referenceModelClass.getManager());
                referenceModelClass.getManager().addField(multiReferenceField);
            } else {
                putDeferredField(referenceField.getReferenceModelName(), multiFieldName, multiReferenceField);
            }
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

    public void addDeferredFields() {
        if (deferredFields.containsKey(name)) {
            for (String fieldName: deferredFields.get(name).keySet()){
                Field field = deferredFields.get(name).get(fieldName);
                field.config(fieldName, this);
                if (!fields.containsKey(fieldName)) {
                    addField(field);
                }
            }
        }
    }

    protected void putDeferredField(String modelName, String fieldName, Field field) {
        if (!deferredFields.containsKey(modelName)) {
            deferredFields.put(modelName, new LinkedHashMap<String, Field>());
        }
        deferredFields.get(modelName).put(fieldName, field);
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
        FunctionField field = new FunctionField(modelField.getFieldClass(), map("columnType", Types.DECIMAL), "count(%s)", modelField);
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
        FunctionField field = new FunctionField(modelField.getFieldClass(), map("columnType", Types.DOUBLE), "avg(%s)", modelField);
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
            ModelManager manager = cls.getModelClass(referenceField.getReferenceModelName()).getManager();
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
