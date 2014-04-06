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
import com.jengine.orm.model.field.ModelProperty;
import com.jengine.orm.model.field.PrimaryKey;
import com.jengine.orm.model.field.reference.SelfField;
import com.jengine.utils.ClassUtils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.jengine.utils.CollectionUtil.map;


public class ModelClass<T extends Model> extends ModelClassBase<T> {
    public static Map<String, ModelClass> classMap = new ConcurrentHashMap<String, ModelClass>();

    public ModelClass(Class<T> cls) {
        this(cls, new HashMap());
    }

    public ModelClass(Class<T> cls, Map options) {
        super(cls.getSimpleName(), cls);
        classMap.put(cls.getName(), this);
        Meta meta = cls.getAnnotation(Meta.class);
        Map metaMap = meta == null ? ClassUtils.annotationToMap(Meta.class) : ClassUtils.annotationToMap(meta);
        String dbName = options.containsKey("dbName") ? (String) options.get("dbName") : (String) metaMap.get("dbName");
        String tableName = options.containsKey("table") ? (String) options.get("table") : (String) metaMap.get("table");
        if (tableName == null || tableName.length() == 0) {
            tableName = name;
        }
        Boolean cacheEnabled = options.containsKey("cacheEnabled") ?
                (Boolean) options.get("cacheEnabled") : (Boolean) metaMap.get("cacheEnabled");
        db = DBFactory.get(dbName);
        provider = db.getProvider();
        manager = new ModelManager();
        manager.setModel(cls);
        manager.setModelClass(this);
        manager.setName(options.containsKey("name") ? (String) options.get("name") : cls.getSimpleName());
        manager.setTableName(tableName);
        manager.setCacheEnabled(cacheEnabled);
        // init fields and properties
        LinkedHashMap<String, Field> fields = new LinkedHashMap<String, Field>();
        fields.put(SelfField.DEFAULT_NAME, new SelfField(cls));
        fields.putAll(collectFields(cls));
        fields.putAll(collectProperties(cls));
        fields.put("verbose", new ModelProperty("getVerbose", String.class, map("verbose", manager.getName())));
        Field pkField = getPrimaryKey(fields);
        if (pkField == null) {
            manager.addField("id", new PrimaryKey());
        }
        for (String fieldName : fields.keySet()) {
            Field field = fields.get(fieldName);
            manager.addField(fieldName, field);
        }
        register();
    }

    protected Field getPrimaryKey(LinkedHashMap<String, Field> fields) {
        for (Field field : fields.values()) {
            if (field.isPrimaryKey()) {
                return field;
            }
        }

        return null;
    }

}