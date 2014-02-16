package com.jengine.orm;


import com.jengine.orm.db.DBConnection;
import com.jengine.orm.db.DBException;
import com.jengine.orm.db.cache.CacheManager;
import com.jengine.orm.db.provider.Provider;
import com.jengine.orm.model.ModelClassBase;
import com.jengine.orm.model.field.Field;
import com.jengine.orm.model.field.reference.BaseReference;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DB {
    protected String name;
    protected Provider provider;
    protected ConcurrentHashMap<String, ModelClassBase> models = new ConcurrentHashMap<String, ModelClassBase>();
    protected Map<String, Map<String, Field>> deferredFields = new ConcurrentHashMap<String, Map<String, Field>>();

    public DB(Provider provider) {
        this("default", provider);
    }

    public DB(String name, Provider provider) {
        this.name = name;
        this.provider = provider;
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

    @Override
    public String toString() {
        return "DB{" +
                "name='" + name + '\'' +
                '}';
    }
}
