/*
 *  This file is part of JEngine.
 *  *
 *  * Copyright (C) 2013-2014 Cetus (http://cs1.com.ua/). All rights reserved.
 *  *
 *  * JEngine is free software: you can redistribute it and/or modify
 *  * it under the terms of the GNU General Public License as published by
 *  * the Free Software Foundation, either version 3 of the License, or
 *  * (at your option) any later version.
 *  *
 *  * JEngine is distributed in the hope that it will be useful,
 *  * but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  * GNU General Public License for more details.
 *  *
 *  * You should have received a copy of the GNU General Public License
 *  * along with JEngine.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.jengine.orm.model;


import com.jengine.orm.model.field.Field;
import com.jengine.orm.model.field.ForeignField;
import com.jengine.orm.model.field.FunctionField;
import com.jengine.orm.model.field.reference.ReferenceField;
import com.jengine.orm.model.field.reference.SelfField;

import java.util.*;

import static com.jengine.utils.commons.CollectionUtil.concat;
import static com.jengine.utils.commons.CollectionUtil.toList;


public class ModelManager {
    private String name;
    private String tableName;
    private Class model;
    private ModelClassBase modelClass;
    private LinkedHashMap<String, Field> fields = new LinkedHashMap<String, Field>();
    private LinkedHashMap<String, ReferenceField> references = new LinkedHashMap<String, ReferenceField>();
    private HashMap<String, ReferenceField> referenceModels = new HashMap<String, ReferenceField>();
    private Field primaryKey = null;
    private SelfField self;
    private Boolean cacheEnabled;

    public ModelManager() {
    }

    public Field addField(String name, Field field) {
        field.config(name, this);
        return addField(field);
    }

    public Field addField(Field field) {
        this.fields.put(field.getFieldName(), field);
        if (field.isPrimaryKey()) {
            this.primaryKey = field;
        }
        if (field.getType() == Field.Type.SELF) {
            this.self = (SelfField) field;
        }
        if (field instanceof ReferenceField) {
            ReferenceField referenceField = (ReferenceField) field;
            this.references.put(field.getFieldName(), referenceField);
            this.referenceModels.put(referenceField.getReferenceModelName(), referenceField);
        }

        return field;
    }

    public Field getField(String fieldName) {
        if (fieldName.contains(".")) {
            List<String> parts = Arrays.asList(fieldName.split("\\."));
            ReferenceField referenceField = (ReferenceField) fields.get(parts.get(0));
            ModelManager manager = modelClass.getDb().getModelClass(referenceField.getReferenceModelName()).getManager();
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

    public List<Field> getPersistenceFields() {
        List<Field> result = new ArrayList<Field>();

        for (Field field : fields.values()) {
            if (field.isPersistence()) {
                result.add(field);
            }
        }

        return  result;
    }

    public List<Field> getFunctionFields() {
        List<Field> result = new ArrayList<Field>();

        for (Field field : fields.values()) {
            if (field instanceof FunctionField) {
                result.add(field);
            }
        }

        return  result;
    }

    public List<ReferenceField> getReferences() {
        return toList(references.values());
    }

    public Field getFieldByColumn(String columnName) {
        for(Field field : fields.values()) {
            if (columnName.equals(field.getColumnName())) {
                return field;
            }
        }
        return null;
    }

    /* getters and setters */

    public LinkedHashMap<String, Field> getFieldMap() {
        return fields;
    }

    public ModelClassBase getModelClass() {
        return modelClass;
    }

    public void setModelClass(ModelClassBase modelClass) {
        this.modelClass = modelClass;
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

    public Class getModel() {
        return model;
    }

    public void setModel(Class model) {
        this.model = model;
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
        return model.getSimpleName().toLowerCase();
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public HashMap<String, ReferenceField> getReferenceModels() {
        return referenceModels;
    }

}
