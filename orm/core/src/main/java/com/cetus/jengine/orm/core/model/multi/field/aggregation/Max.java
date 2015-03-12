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

package com.cetus.jengine.orm.core.model.multi.field.aggregation;


import com.cetus.jengine.orm.core.model.field.Field;
import com.cetus.jengine.orm.core.model.multi.MultiModel;
import com.cetus.jengine.orm.core.model.multi.field.CalcMultiField;

import static com.cetus.jengine.utils.commons.CollectionUtil.list;
import static com.cetus.jengine.utils.commons.CollectionUtil.map;

public class Max extends CalcMultiField {

    public Max(String field) {
        super(null, null, "max(%s)", list(field), map());
        name = makeDefaultName(field);
    }

    public Max(Field field) {
        super(field.getFieldClass(), field.getColumnType(), "max(%s)", list(field.getFieldName()), map());
        name = makeDefaultName(field.getFieldName());
    }

    public void config(MultiModel multiModel) {
        super.config(multiModel);
        fieldClass = multiModel.getField(fields.get(0)).getModelField().getFieldClass();
        columnType = multiModel.getField(fields.get(0)).getModelField().getColumnType();
    }

    protected String makeDefaultName(String field) {
        return String.format("max_%s", field.replaceAll("\\.", "__"));
    }
}
