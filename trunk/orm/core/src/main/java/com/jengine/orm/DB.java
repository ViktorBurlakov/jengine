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

package com.jengine.orm;


import com.jengine.orm.db.DBConnection;
import com.jengine.orm.db.DBException;
import com.jengine.orm.db.cache.CacheManager;
import com.jengine.orm.db.provider.Provider;
import com.jengine.orm.model.ModelClassBase;
import com.jengine.orm.model.field.Field;
import com.jengine.orm.model.field.reference.BaseReference;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.cetus.jengine.utils.commons.CollectionUtil.map;

public class DB {
    protected String name;
    protected Provider provider;
    protected ConcurrentHashMap<String, ModelClassBase> models = new ConcurrentHashMap<String, ModelClassBase>();
    protected Map<String, Map<String, Field>> deferredFields = new ConcurrentHashMap<String, Map<String, Field>>();
    protected Map<String, Object> options = map("aliasEnabled", true);

    public DB(Provider provider) {
        this("default", provider);
    }

    public DB(Provider provider, Map<String, Object> options) {
        this("default", provider, options);
    }

    public DB(String name, Provider provider) {
        this(name, provider, new HashMap<String, Object>());
    }

    public DB(String name, Provider provider, Map<String, Object> options) {
        this.name = name;
        this.provider = provider;
        this.options.putAll(options);
    }

    public void register(ModelClassBase modelClass) {
        models.put(modelClass.getName(), modelClass);
        provider.register(modelClass.getManager().getTableName());

        // process references to create reverse fields
        for (Field field : modelClass.getManager().getFields()) {
            if (field instanceof BaseReference) {
                BaseReference reference = (BaseReference) field;
                String reverseFieldName = reference.getReverseFieldName();
                if (reverseFieldName != null) {
                    Field reverseField = reference.newReverseField();
                    ModelClassBase referenceModelClass = reference.getReferenceClass();
                    if (referenceModelClass != null &&
                            !referenceModelClass.getManager().getFieldMap().containsValue(reverseFieldName)) {
                        referenceModelClass.getManager().addField(reverseFieldName, reverseField);
                    } else {
                        if (!deferredFields.containsKey(reference.getReferenceModelName())) {
                            deferredFields.put(reference.getReferenceModelName(), new LinkedHashMap<String, Field>());
                        }
                        deferredFields.get(reference.getReferenceModelName()).put(reverseFieldName, reverseField);
                    }
                }
            }
        }
        if (!deferredFields.containsKey(modelClass.getName())) {
            deferredFields.put(modelClass.getName(), new LinkedHashMap<String, Field>());
        }
        Map<String, Field> fields = deferredFields.get(modelClass.getName());
        for (String fieldName: fields.keySet()) {
            if (!modelClass.getManager().getFieldMap().containsValue(fieldName)) {
                modelClass.getManager().addField(fieldName, fields.get(fieldName));
            }
        }
    }

    public ModelClassBase getModelClass(String name) {
        return models.get(name);
    }

    public DBConnection getConnection() throws DBException {
        return provider.getConnection();
    }

    public void closeConnection(DBConnection connection) throws DBException {
        provider.closeConnection(connection);
    }

    public Provider getProvider() {
        return provider;
    }

    public CacheManager getCacheManager() {
        return provider.getCacheManager();
    }

    public Map<String, Object> getOptions() {
        return options;
    }

    public void setOptions(Map<String, Object> options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "DB{" +
                "name='" + name + '\'' +
                '}';
    }
}
