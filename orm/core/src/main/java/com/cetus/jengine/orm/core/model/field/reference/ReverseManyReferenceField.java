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


import com.cetus.jengine.orm.core.db.DBException;
import com.cetus.jengine.orm.core.model.ModelManager;
import com.cetus.jengine.orm.core.model.field.Field;

import java.util.HashMap;
import java.util.Map;

public class ReverseManyReferenceField extends ManyReferenceField {

    public ReverseManyReferenceField(ReverseManyReferenceField field) {
        super(field);
    }

    public ReverseManyReferenceField(Class fieldClass) {
        super(fieldClass);
    }

    public ReverseManyReferenceField(Class fieldClass, String referenceModelName) {
        super(fieldClass, referenceModelName, new HashMap<String, Object>());
    }

    public ReverseManyReferenceField(Class fieldClass, String referenceModelName, Map<String, Object> options) {
        super(fieldClass, referenceModelName, options);
    }

    public Field.Type getType() {
        return Field.Type.REVERSE_MANY_REFERENCE;
    }

    public void config(String fieldName, ModelManager manager) {
        super.config(fieldName, manager);
        if (getMiddleClass() == null) {
            try {
                createMiddleClass();
            } catch (DBException e) {
                e.printStackTrace();
            }
        }
    }
}
