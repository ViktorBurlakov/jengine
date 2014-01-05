package com.jengine.orm;


import com.jengine.orm.db.DBFactory;
import com.jengine.orm.field.Field;
import com.jengine.orm.field.reference.SelfField;

import java.util.LinkedHashMap;
import java.util.Map;

public class DynamicModelClass<T extends Model> extends ModelClassBase<T> {

    public DynamicModelClass(String name, Class cls, Map options) {
        super(name, cls);
        String dbName = options.containsKey("dbName") ? (String) options.get("dbName") : "default";
        this.db = DBFactory.get(dbName);
        this.provider = this.db.getProvider();
        this.manager = new ModelManager();
        this.manager.setModelClass(cls);
        this.manager.setCls(this);
        this.manager.setName(name);
        this.manager.setTableName(options.containsKey("table") ? (String) options.get("table") : name);
        this.manager.setCacheEnabled(options.containsKey("cacheEnabled") ? (Boolean) options.get("cacheEnabled") : true);
        // init fields and properties
        Map<String, Field> fields = new LinkedHashMap<String, Field>();
        fields.put(SelfField.DEFAULT_NAME, new SelfField(cls, name));
//        fields.put("verbose", new ModelProperty("getVerbose", String.class, map("verbose", this.manager.getName())));
        for (String fieldName : fields.keySet()) {
            Field field = fields.get(fieldName);
            this.manager.addField(fieldName, field);
        }
        this.manager.addDeferredFields();
    }
}
