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

import com.jengine.orm.model.field.Field;

import java.util.Map;

public class SingleReferenceField extends ReferenceField {

    public SingleReferenceField(SingleReferenceField field) {
        super(field);
    }

    public SingleReferenceField(Class fieldClass) {
        super(fieldClass);
    }

    public SingleReferenceField(Class fieldClass, Object... options) {
        super(fieldClass, options);
    }

    public SingleReferenceField(Class fieldClass, Map<String, Object> options) {
        super(fieldClass, options);
    }

    public Field newReverseField() {
        return new ReverseSingleReferenceField(fieldClass, manager.getName(), fieldName);
    }

    public Type getType() {
        return Type.SINGLE_REFERENCE;
    }

    public String getReverseFieldName() {
        return reverseFieldName != null ? reverseFieldName : manager.getName().toLowerCase();
    }

    public boolean isPersistence() {
        return true;
    }
}
