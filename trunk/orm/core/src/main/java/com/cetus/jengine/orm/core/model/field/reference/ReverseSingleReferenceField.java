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

public class ReverseSingleReferenceField extends BaseReference {
    public ReverseSingleReferenceField(ReverseSingleReferenceField field) {
        super(field);
    }

    public ReverseSingleReferenceField(Class fieldClass, String reverseFieldName) {
        super(fieldClass, map("reverseFieldName", reverseFieldName));
    }

    public ReverseSingleReferenceField(Class fieldClass, String referenceModelName, String reverseFieldName) {
        super(fieldClass, referenceModelName, map("reverseFieldName", reverseFieldName));
    }

    public Type getType() {
        return Type.REVERSE_SINGLE_REFERENCE;
    }

    public Object getValue(Model obj) throws DBException {
        ModelClassBase referenceCls = getReferenceClass();
        SingleReferenceField singleField = (SingleReferenceField) getReverseField();
        Object key = obj.getData().get(singleField.getReferenceModelKey().getFieldName());
        return referenceCls.filter(singleField.eq(key)).one();
    }
}
