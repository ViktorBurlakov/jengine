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

package com.cetus.jengine.orm.core.model.field.reference;

import com.cetus.jengine.orm.core.model.Model;
import com.cetus.jengine.orm.core.model.ModelClassBase;
import com.cetus.jengine.orm.core.db.DBException;

import static com.cetus.jengine.utils.commons.CollectionUtil.map;

public class MultiReferenceField extends BaseReference {

    public MultiReferenceField(MultiReferenceField field) {
        super(field);
    }

    public MultiReferenceField(Class fieldClass, String reverseFieldName) {
        this(fieldClass, fieldClass.getSimpleName(), reverseFieldName);
    }

    public MultiReferenceField(Class fieldClass, String referenceModelName, String reverseFieldName) {
        super(fieldClass, referenceModelName, map("reverseFieldName", reverseFieldName));
    }

    public Type getType() {
        return Type.MULTI_REFERENCE;
    }

    public Object getValue(Model obj) throws DBException {
        ModelClassBase referenceCls = getReferenceClass();
        ReferenceField reverseField = (ReferenceField) getReverseField();
        Object key = obj.getData().get(reverseField.getReferenceModelKey().getFieldName());
        return referenceCls.filter(reverseField.eq(key));
    }
}
