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
import static com.jengine.utils.StringUtil.caps;


public class ModelManager {
    public static Map<String, Map<String, Field>> deferredFields = new ConcurrentHashMap<String, Map<String, Field>>();
    private String name;
    private String tableName;
    private Class modelClass;
    private Map<String, Field> fields = new LinkedHashMap<String, Field>();
    private Field primaryKey = null;
    private SelfField self;
    private Boolean cacheEnabled;
    private ModelClassBase cls;

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
            if (referenceField.getMultiReferenceFieldName() == null) {
                referenceField.setMultiReferenceFieldName(String.format("%s_set", name.toLowerCase()));
            }
                    ;
            MultiReferenceField multiReferenceField = new MultiReferenceField(name, modelClass, referenceField.getFieldName());
            ModelClassBase referenceModelClass = cls.getModelClass(referenceField.getReferenceModelName());

            if (referenceModelClass != null) {
                multiReferenceField.config(referenceField.getMultiReferenceFieldName(), referenceModelClass.getManager());
                referenceModelClass.getManager().addField(multiReferenceField);
            } else {
                putDeferredField(referenceField.getReferenceModelName(), referenceField.getMultiReferenceFieldName(), multiReferenceField);
            }
        }  else if (field.getType() == Field.Type.MANY_REFERENCE) {
            ManyReferenceField manyField = (ManyReferenceField) field;
            ModelClassBase referenceModelClass = cls.getModelClass(manyField.getReferenceModelName());

            if (manyField.getKeyFieldName() == null) {
                manyField.setKeyFieldName(primaryKey.getFieldName());
            }
            if (manyField.getReferenceFieldName() == null) {
                manyField.setReferenceFieldName(String.format("%s_set", name.toLowerCase()));
            }
            if (manyField.getMiddleModelName() == null) {
                manyField.setMiddleModelName(String.format("%s_%s", name, manyField.getFieldName()));
            }
            if (manyField.getMiddleModelFieldName() == null) {
                manyField.setMiddleModelFieldName(String.format("%s", name.toLowerCase()));
            }
            ReverseManyReferenceField reverseField = new ReverseManyReferenceField(name, map(
                    "keyFieldName", manyField.getReferenceKeyFieldName(),
                    "referenceFieldName", manyField.getFieldName(),
                    "referenceKeyFieldName", manyField.getKeyFieldName(),
                    "middleModelName", manyField.getMiddleModelName(),
                    "middleModelFieldName", manyField.getMiddleModelReferenceFieldName(),
                    "middleModelReferenceFieldName", manyField.getMiddleModelFieldName(),
                    "middleModelTableName", manyField.getMiddleModelTableName()
            ));
            if (referenceModelClass != null) {
                referenceModelClass.getManager().addField(manyField.getReferenceFieldName(), reverseField);
            } else {
                putDeferredField(manyField.getReferenceModelName(), manyField.getReferenceFieldName(), reverseField);
            }
        } else if (field.getType() == Field.Type.REVERSE_MANY_REFERENCE) {
            ReverseManyReferenceField reverseField = (ReverseManyReferenceField) field;
            ModelClassBase referenceModelClass = cls.getModelClass(reverseField.getReferenceModelName());
            ManyReferenceField manyReferenceField = (ManyReferenceField) referenceModelClass.getManager().getField(reverseField.getReferenceFieldName());
            if (reverseField.getKeyFieldName() == null) {
                reverseField.setKeyFieldName(primaryKey.getFieldName());
                manyReferenceField.setReferenceKeyFieldName(reverseField.getKeyFieldName());
            }
            if (reverseField.getMiddleModelFieldName() == null) {
                reverseField.setMiddleModelFieldName(String.format("%s", name.toLowerCase()));
                manyReferenceField.setMiddleModelReferenceFieldName(reverseField.getMiddleModelFieldName());
            }
            if (reverseField.getMiddleModelTableName() == null) {
                reverseField.setMiddleModelTableName(String.format("%s_%s",
                        referenceModelClass.getManager().getTableName(),
                        reverseField.getReferenceFieldName()));
                manyReferenceField.setMiddleModelTableName(reverseField.getMiddleModelTableName());
            }
            ModelClassBase middleModelClass = cls.getModelClass(reverseField.getMiddleModelName());
            if (middleModelClass == null) {
                Field referenceKeyField = referenceModelClass.getManager().getField(reverseField.getReferenceKeyFieldName());

                middleModelClass = new DynamicModelClass(reverseField.getMiddleModelName(),
                        Model.class,
                        map("table", reverseField.getMiddleModelTableName()));
                middleModelClass.getManager().addField(
                        reverseField.getMiddleModelReferenceFieldName(),
                        new ReferenceField(referenceModelClass.getManager().getModelClass(), map(
                                "referenceModelName", reverseField.getReferenceModelName(),
                                "referenceModelFieldName", referenceKeyField.getFieldName(),
                                "columnName", referenceModelClass.getManager().getTableName().toLowerCase()))
                );
                middleModelClass.getManager().addField(
                        reverseField.getMiddleModelFieldName(),
                        new ReferenceField(modelClass, map(
                                "referenceModelName", name,
                                "referenceModelFieldName", reverseField.getKeyFieldName(),
                                "columnName", tableName.toLowerCase()))
                );
                middleModelClass.getManager().addField("id", new PrimaryKey(map("autoIncrement", true)));
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

    public List<Field> getFields(Field.Type ... types) {
        List<Field> result = new ArrayList<Field>();
        List<Field.Type> typeList = Arrays.asList(types);

        for (Field field : fields.values()) {
            if (typeList.contains(field.getType())) {
                result.add(field);
            }
        }

        return  result;
    }

    public List<String> getFieldNames() {
        List<String> result = new ArrayList<String>();

        result.addAll(this.fields.keySet());

        return  result;
    }

    /* getters and setters */

    public ModelClassBase getCls() {
        return cls;
    }

    public void setCls(ModelClassBase cls) {
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
