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

package com.jengine.orm.model.field.reference;


import com.jengine.orm.db.DBException;
import com.jengine.orm.model.Model;
import com.jengine.orm.model.field.Field;
import com.jengine.utils.Variant;

import java.util.HashMap;
import java.util.Map;

import static com.jengine.utils.CollectionUtil.map;
import static com.jengine.utils.StringUtil.caps;

public class ReferenceField extends BaseReference {
    protected String referenceModelKeyName;

    public ReferenceField(ReferenceField field) {
        super(field);
        this.referenceModelKeyName = field.getReferenceModelKeyName();
    }

    public ReferenceField(Class fieldClass) {
        this(fieldClass, new HashMap<String, Object>());
    }

    public ReferenceField(Class fieldClass, Object... options) {
        this(fieldClass, map(options));
    }

    public ReferenceField(Class fieldClass, Map<String, Object> options) {
        this(fieldClass, fieldClass.getSimpleName(), options);
    }

    public ReferenceField(Class fieldClass, String referenceModelName, Map<String, Object> options) {
        super(fieldClass, referenceModelName, options);
        if (options.containsKey("referenceModelKeyName")) {
            this.referenceModelKeyName = (String) options.get("referenceModelKeyName");
        }
    }

    public Type getType() {
        return Type.REFERENCE;
    }

    public Field newReverseField() {
        return new MultiReferenceField(fieldClass, manager.getName(), fieldName);
    }

    public boolean isPersistence() {
        return true;
    }

    public Integer getColumnType() {
        return getReferenceModelKey().getColumnType();
    }

    public Object getValue(Model obj) throws DBException {
        Object key = obj.getData().get(fieldName);
        return key != null ? getReferenceClass().filter(getReferenceModelKey().eq(key)).one() : null;
    }

    public Object cast(Object value) throws DBException {
        Field field = getReferenceModelKey();
        return value instanceof Model ? ((Model) value).getValue(field) : new Variant(value).convertTo(field.getFieldClass());
    }

    public String format(Object value) throws DBException {
        return ((Model)value).getVerbose();
    }

    public String getColumnName() {
        return columnName != null ? columnName : String.format("%s%s", fieldName, caps(getReferenceModelKey().getColumnName()));
    }

    public Field getReferenceModelKey() {
        return referenceModelKeyName != null ?
                getReferenceClass().getManager().getField(referenceModelKeyName) :
                getReferenceClass().getManager().getPrimaryKey();
    }

    public void setReferenceModelKeyName(String referenceModelKeyName) {
        this.referenceModelKeyName = referenceModelKeyName;
    }

    public String getReferenceModelKeyName() {
        return referenceModelKeyName;
    }

    public String getReverseFieldName() {
        return reverseFieldName != null ? reverseFieldName : String.format("%s_set", manager.getName().toLowerCase());
    }
}
