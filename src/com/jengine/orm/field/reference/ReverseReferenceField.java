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

package com.jengine.orm.field.reference;

import static com.jengine.utils.CollectionUtil.map;

public class ReverseReferenceField extends BaseReference {

    public ReverseReferenceField(Class fieldClass, String reverseFieldName) {
        super(fieldClass, map("reverseFieldName", reverseFieldName));
    }

    public ReverseReferenceField(Class fieldClass, String referenceModelName, String reverseFieldName) {
        super(fieldClass, referenceModelName, map("reverseFieldName", reverseFieldName));
    }

    public Type getType() {
        return Type.REVERSE_REFERENCE;
    }
}
