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

package com.jengine.orm.model.field.reference;


import com.jengine.orm.model.field.Field;

import java.util.HashMap;
import java.util.Map;

public class SelfField extends ReferenceField {
    public static String DEFAULT_NAME = "self";

    public SelfField(SelfField field) {
        super(field);
    }

    public SelfField(Class fieldClass) {
        this(fieldClass, new HashMap<String, Object>());
    }

    public SelfField(Class fieldClass, String referenceModelName) {
        this(fieldClass, referenceModelName, new HashMap<String, Object>());
    }

    public SelfField(Class fieldClass, Map<String, Object> options) {
        this(fieldClass, fieldClass.getSimpleName(), options);
    }

    public SelfField(Class fieldClass, String referenceModelName, Map<String, Object> options) {
        super(fieldClass, referenceModelName, options);
        if (!options.containsKey("columnName")) {
            columnName =  null;
        }
        if (!options.containsKey("referenceModelKeyName")) {
            referenceModelKeyName = null;
        }
        reverseFieldName = null;
    }

    public String getReverseFieldName() {
        return reverseFieldName;
    }

    public Field.Type getType() {
        return Field.Type.SELF;
    }

    public boolean isPersistence() {
        return false;
    }
}
