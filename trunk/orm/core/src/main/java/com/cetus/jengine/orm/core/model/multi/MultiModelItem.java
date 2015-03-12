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

package com.cetus.jengine.orm.core.model.multi;


import com.cetus.jengine.orm.core.db.query.SQLQuery;
import com.cetus.jengine.orm.core.model.ModelClassBase;
import com.cetus.jengine.orm.core.model.field.Field;
import com.cetus.jengine.orm.core.model.field.FunctionField;
import com.cetus.jengine.orm.core.model.multi.field.FunctionMultiField;
import com.cetus.jengine.orm.core.model.multi.field.MultiModelField;

import java.util.LinkedHashMap;
import java.util.List;

import static com.cetus.jengine.utils.commons.CollectionUtil.toList;

public class MultiModelItem {
    private MultiModel multiModel;
    private ModelClassBase modelClass;
    private String name;
    private MultiModelField primaryKey = null;
    private LinkedHashMap<String, MultiModelField> fields = new LinkedHashMap<String, MultiModelField>();
    private LinkedHashMap<String, MultiModelField> modelFields = new LinkedHashMap<String, MultiModelField>();
    private SQLQuery.TableItem tableItem;

    public MultiModelItem(MultiModel multiModel, ModelClassBase modelClass, String name) {
        this.multiModel = multiModel;
        this.modelClass = modelClass;
        this.name = name;
        this.tableItem = new SQLQuery.TableItem(modelClass.getManager().getTableName(), name.replace(".", "_"));
        for(Field field: modelClass.getManager().getFields()) {
            if (field.isPersistence() || field instanceof FunctionField) {
                addField(field);
            }
        }
    }

    public void config() {
        for (MultiModelField field : fields.values()) {
            field.config(this);
        }
    }

    public MultiModelField getMultiModelField(Field field) {
        return modelFields.get(field.getFieldName());
    }

    public MultiModelField addField(Field field) {
        MultiModelField multiModelField = null;
        if (field instanceof FunctionField) {
            multiModelField = new FunctionMultiField(this, (FunctionField) field);
        } else {
            multiModelField = new MultiModelField(this, field);
        }
        fields.put(multiModelField.getName(), multiModelField);
        modelFields.put(field.getFieldName(), multiModelField);
        if (field.isPrimaryKey()) {
            primaryKey = multiModelField;
        }
        return multiModelField;
    }

//    public void setName(String name) {
//        this.name = name;
//        this.tableItem = new SQLQuery.TableItem(modelClass.getManager().getTableName(), name.replace(".", "_"));
//        fields.clear();
//        for(Field field: modelClass.getManager().getPersistenceFields()) {
//            addField(field);
//        }
//        this.config();
//    }

    public SQLQuery.TableItem getTableItem() {
        return tableItem;
    }

    public MultiModel getMultiModel() {
        return multiModel;
    }

    public String getName() {
        return name;
    }

    public MultiModelField getPrimaryKey() {
        return primaryKey;
    }

    public ModelClassBase getModelClass() {
        return modelClass;
    }

    public List<MultiModelField> getFieldList() {
        return toList(fields.values());
    }

    public LinkedHashMap<String, MultiModelField> getFields() {
        return fields;
    }
}
