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

package com.jengine.orm.model.field;

import com.jengine.orm.model.Model;
import com.jengine.orm.db.DBException;
import com.jengine.orm.model.field.reference.ReferenceField;
import com.jengine.utils.CollectionUtil;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ForeignField extends Field {
    private Map<String, Field> fieldMap = new LinkedHashMap<String, Field>();
    private List<String> fields = new ArrayList<String>();
    private ReferenceField currentField;
    private Field nextField;
    private List<String> parentFields = new ArrayList<String>();

    public ForeignField(ForeignField field) {
        super(field);
        this.fieldMap = field.getFieldMap();
        this.fields = field.getFields();
        this.currentField = field.getCurrentField();
        this.nextField = field.getNextField();
        this.parentFields = field.getParentFields();
    }

    public ForeignField(ReferenceField currentField, Field nextField) {
        super(nextField.getFieldClass());
        this.currentField = currentField;
        this.nextField = nextField;
        this.fieldMap.put(currentField.getFieldName(), currentField);
        if (nextField instanceof ForeignField) {
            ForeignField foreignField = (ForeignField) nextField;
            this.fieldMap.putAll(foreignField.getFieldMap());
        } else {
            this.fieldMap.put(nextField.getFieldName(), nextField);
        }
        this.fields.addAll(this.fieldMap.keySet());
        this.parentFields.addAll(fields.subList(0, fields.size() - 1));
    }

    public Type getType() {
        return Type.FOREIGN;
    }

    public List<String> getParentFields() {
        return parentFields;
    }

    public String getParentName() {
        return fieldName.substring(0, fieldName.lastIndexOf("."));
    }

    public Object getValue(Model obj) throws DBException {
        Object referenceId = obj.getData().get(currentField.getFieldName());
        return currentField.getReferenceClass().get(referenceId).getValue(nextField);
    }

    public List<String> getReferencePath() {
        return getActualField() instanceof ReferenceField ? fields : fields.subList(0, fields.size()-1);
    }

    public String getColumnName() {
        return CollectionUtil.<Field>toList(fieldMap.values()).get(fieldMap.size()-1).getColumnName();
    }

    public boolean isPrimaryKey() {
        return getActualField().isPrimaryKey();
    }

    public Integer getColumnType() {
        return getActualField().getColumnType();
    }

    public Field getActualField() {
        return fieldMap.get(this.fields.get(this.fields.size()-1));
    }

    public Object cast(Object value) throws DBException {
        return nextField.cast(value);
    }

    public Map<String, Field> getFieldMap() {
        return fieldMap;
    }

    public ReferenceField getCurrentField() {
        return currentField;
    }

    public void setCurrentField(ReferenceField currentField) {
        this.currentField = currentField;
    }

    public Field getNextField() {
        return nextField;
    }

    public void setNextField(Field nextField) {
        this.nextField = nextField;
    }

    public List<String> getFields() {
        return fields;
    }
}
