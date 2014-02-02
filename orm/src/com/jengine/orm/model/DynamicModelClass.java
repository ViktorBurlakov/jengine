package com.jengine.orm.model;


import com.jengine.orm.DBFactory;
import com.jengine.orm.model.field.Field;
import com.jengine.orm.model.field.reference.SelfField;

import java.util.LinkedHashMap;
import java.util.Map;

public class DynamicModelClass<T extends Model> extends ModelClassBase<T> {

    public DynamicModelClass(String name, Class cls, Map options) {
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
//        fields.put("verbose", new ModelProperty("getVerbose", String.class, map("verbose", this.manager.getName())));
        for (String fieldName : fields.keySet()) {
            Field field = fields.get(fieldName);
            manager.addField(fieldName, field);
        }
        manager.addDeferredFields();
        register();
    }
}
