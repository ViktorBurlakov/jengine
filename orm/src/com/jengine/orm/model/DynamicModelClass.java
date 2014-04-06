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

package com.jengine.orm.model;


import com.jengine.orm.DBFactory;
import com.jengine.orm.db.DBException;
import com.jengine.orm.model.field.Field;
import com.jengine.orm.model.field.reference.SelfField;

import java.util.LinkedHashMap;
import java.util.Map;

public class DynamicModelClass<T extends Model> extends ModelClassBase<T> {

    public DynamicModelClass(String name, Class cls, Map options) throws DBException {
        super(name, cls);
        String dbName = options.containsKey("dbName") ? (String) options.get("dbName") : "default";
        db = DBFactory.get(dbName);
        provider = this.db.getProvider();
        manager = new ModelManager();
        manager.setModel(cls);
        manager.setModelClass(this);
        manager.setName(name);
        manager.setTableName(options.containsKey("table") ? (String) options.get("table") : name);
        manager.setCacheEnabled(options.containsKey("cacheEnabled") ? (Boolean) options.get("cacheEnabled") : true);
        // init fields and properties
        Map<String, Field> fields = new LinkedHashMap<String, Field>();
        fields.put(SelfField.DEFAULT_NAME, new SelfField(cls, name));
        fields.putAll(collectFields(cls));
        for (String fieldName : fields.keySet()) {
            Field field = fields.get(fieldName);
            manager.addField(fieldName, field);
        }
        register();
    }
}
