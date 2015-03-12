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

package com.cetus.jengine.orm.core.model.multi.field;

import com.cetus.jengine.orm.core.model.field.Field;
import com.cetus.jengine.orm.core.model.field.FunctionField;
import com.cetus.jengine.orm.core.model.multi.MultiModelItem;

import java.util.ArrayList;
import java.util.List;

public class FunctionMultiField extends MultiModelField{
    protected List<String> fields = new ArrayList<String>();
    protected List<String> columns = new ArrayList<String>();

    public FunctionMultiField(MultiModelItem item, FunctionField modelField) {
        super(item, modelField);
    }

    public FunctionMultiField(String name, MultiModelItem item, FunctionField modelField) {
        super(name, item, modelField);
    }

    public FunctionMultiField(String name, FunctionField modelField) {
        super(name, modelField);
    }

    public void config(MultiModelItem item) {
        super.config(item);
        FunctionField functionField = (FunctionField) modelField;
        for (Object attribute: functionField.getAttributes()) {
            String fieldName = attribute instanceof String ? (String) attribute : ((Field) attribute).getFieldName();
            MultiModelField attributeMultiField = multiModel.getRelatedField(item, fieldName);
            this.fields.add(attributeMultiField.getName());
            this.columns.add(attributeMultiField.getSQLName());
        }
    }

    public FunctionField getModelField() {
        return (FunctionField) modelField;
    }

    public String getSQLName() {
        return item != null ? String.format("%s_%s", item.getTableItem().getName(), modelField.getColumnName()) :
                modelField.getColumnName();
    }

    public String toSQL() {
        return String.format(getModelField().getExpression(), columns.toArray());
    }
}
