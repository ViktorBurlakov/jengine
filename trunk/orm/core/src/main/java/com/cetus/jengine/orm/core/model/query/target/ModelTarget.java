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

package com.cetus.jengine.orm.core.model.query.target;

import com.cetus.jengine.orm.core.db.DBException;
import com.cetus.jengine.orm.core.db.query.SQLQuery;
import com.cetus.jengine.orm.core.model.Model;
import com.cetus.jengine.orm.core.model.field.Field;
import com.cetus.jengine.orm.core.model.multi.MultiModelItem;
import com.cetus.jengine.orm.core.model.multi.field.FunctionMultiField;
import com.cetus.jengine.orm.core.model.multi.field.MultiModelField;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;


public class ModelTarget extends Target {
    protected MultiModelItem item;

    public ModelTarget(String name) {
        super(name);
    }

    public ModelTarget(MultiModelItem item) {
        this(item.getName(), item);
    }

    public ModelTarget(String name, MultiModelItem item) {
        super(name);
        this.item = item;
    }

    public String getSQLName() {
        return item.getName();
    }

    public Object processResult(Iterator itr) throws DBException {
       return processItem(itr, item);
    }

    public void setSQL(SQLQuery query) {
        Map<String, Object> options = this.query.getMultiModel().getDB().getOptions();
        boolean aliasEnabled = options.containsKey("aliasEnabled") && ((Boolean) options.get("aliasEnabled"));

        for (MultiModelField field : item.getFieldList()) {
            if (field instanceof FunctionMultiField) {
                query.addTarget(field.toSQL(), field.getAlias());
                query.getTargetTypes().put(field.getAlias(), field.getModelField().getColumnType());
            } else {
                query.addTarget(field.getSQLName(), aliasEnabled ? field.getAlias() : null);
                query.getTargetTypes().put(aliasEnabled ? field.getAlias() : field.getSQLName(), field.getModelField().getColumnType());            }
        }
    }

    protected Object processItem(Iterator itr, MultiModelItem item) throws DBException {
        LinkedHashMap<String, Object> values = new LinkedHashMap<String, Object>();
        for (MultiModelField field : item.getFieldList()) {
            values.put(field.getModelField().getFieldName(), field.cast(itr.next()));
        }
        Field pk = item.getPrimaryKey().getModelField();
        if (values.containsKey(pk.getFieldName()) && values.get(pk.getFieldName()) != null) {
            Model obj = item.getModelClass().newInstance();
            obj.setNew(false);
            obj.setData(values);
            obj.cache();

            return obj;
        } else {
            return null;
        }
    }

}
