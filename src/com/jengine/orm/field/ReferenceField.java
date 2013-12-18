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

package com.jengine.orm.field;


import com.jengine.orm.Model;
import com.jengine.orm.ModelManager;
import com.jengine.orm.db.DBException;

import java.util.HashMap;
import java.util.Map;

import static com.jengine.utils.CollectionUtil.map;

public class ReferenceField extends Field {
    protected String referenceModelName;
    protected String referenceModelFieldName;
    protected String multiReferenceFieldName;

    public ReferenceField(Class fieldClass) {
        this(fieldClass, new HashMap<String, Object>());
    }

    public ReferenceField(Class fieldClass, Object... options) {
        this(fieldClass, map(options));
    }

    public ReferenceField(Class fieldClass, Map<String, Object> options) {
        super(fieldClass, options);
        this.type = Type.REFERENCE;
        this.referenceModelName = fieldClass.getSimpleName();
        if (options.containsKey("referenceModelName")) {
            this.referenceModelName = (String) options.get("referenceModelName");
        }
        if (options.containsKey("referenceModelFieldName")) {
            this.referenceModelFieldName = (String) options.get("referenceModelFieldName");
        }
        if (options.containsKey("multiReferenceFieldName")) {
            this.multiReferenceFieldName = (String) options.get("multiReferenceFieldName");
        }
    }

    public void config(String fieldName, ModelManager manager) {
        super.config(fieldName, manager);
        if (!options.containsKey("columnName")) {
            columnName =  String.format("%sId", fieldName);
        }
        if (referenceModelFieldName == null) {
            referenceModelFieldName = String.format("%sId", fieldName);
        }
    }

    public boolean isKey() {
        return true;
    }

    public Object cast(Object value) throws DBException {
        return value instanceof Model ? (Long) ((Model) value).getPrimaryKey() : new Long(String.valueOf(value));
    }

    public String format(Object value) throws DBException {
        return ((Model)value).getVerbose();
    }

    public String getReferenceModelFieldName() {
        return referenceModelFieldName;
    }

    public void setReferenceModelFieldName(String referenceModelFieldName) {
        this.referenceModelFieldName = referenceModelFieldName;
    }

    public String getMultiReferenceFieldName() {
        return multiReferenceFieldName;
    }

    public void setMultiReferenceFieldName(String multiReferenceFieldName) {
        this.multiReferenceFieldName = multiReferenceFieldName;
    }

    public String getReferenceModelName() {
        return referenceModelName;
    }

    public void setReferenceModelName(String referenceModelName) {
        this.referenceModelName = referenceModelName;
    }
}
