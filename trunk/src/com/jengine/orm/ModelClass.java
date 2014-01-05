package com.jengine.orm;

import com.jengine.orm.db.DBFactory;
import com.jengine.orm.field.*;
import com.jengine.orm.field.reference.SelfField;
import com.jengine.utils.ClassUtils;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.jengine.utils.CollectionUtil.map;


public class ModelClass<T extends Model> extends ModelClassBase<T> {

    public ModelClass(Class<T> cls) {
        this(cls, new HashMap());
    }

    public ModelClass(Class<T> cls, Map options) {
        super(cls.getSimpleName(), cls);
        Meta meta = cls.getAnnotation(Meta.class);
        Map metaMap = meta == null ? ClassUtils.annotationToMap(Meta.class) : ClassUtils.annotationToMap(meta);
        String dbName = options.containsKey("dbName") ? (String) options.get("dbName") : (String) metaMap.get("dbName");
        String tableName = options.containsKey("table") ? (String) options.get("table") : (String) metaMap.get("table");
        if (tableName == null || tableName.length() == 0) {
            tableName = name;
        }
        Boolean cacheEnabled = options.containsKey("cacheEnabled") ?
                (Boolean) options.get("cacheEnabled") : (Boolean) metaMap.get("cacheEnabled");
        this.db = DBFactory.get(dbName);
        this.provider = this.db.getProvider();
        this.manager = new ModelManager();
        this.manager.setModelClass(cls);
        this.manager.setCls(this);
        this.manager.setName(options.containsKey("name") ? (String) options.get("name") : cls.getSimpleName());
        this.manager.setTableName(tableName);
        this.manager.setCacheEnabled(cacheEnabled);
        // init fields and properties
        LinkedHashMap<String, Field> fields = new LinkedHashMap<String, Field>();
        fields.put(SelfField.DEFAULT_NAME, new SelfField(cls));
        fields.putAll(collectFields(cls));
        fields.putAll(collectProperties(cls));
        fields.put("verbose", new ModelProperty("getVerbose", String.class, map("verbose", this.manager.getName())));
        Field pkField = getPrimaryKey(fields);
        if (pkField == null) {
            this.manager.addField("id", new PrimaryKey());
        }
        for (String fieldName : fields.keySet()) {
            Field field = fields.get(fieldName);
            this.manager.addField(fieldName, field);
        }
        this.manager.addDeferredFields();
    }

    protected Field getPrimaryKey(LinkedHashMap<String, Field> fields) {
        for (Field field : fields.values()) {
            if (field.isPrimaryKey()) {
                return field;
            }
        }

        return null;
    }


    /* collect methods */

    public Map<String, Field> collectFields(Class cls) {
        Map<String, Field> modelFields = new LinkedHashMap<String, Field>();
        java.lang.reflect.Field fieldlist[] = cls.getDeclaredFields();
        for (int i = 0; i < fieldlist.length; i++) {
            java.lang.reflect.Field fld = fieldlist[i];
            if (Modifier.isStatic(fld.getModifiers())) {
                try {
                    if (fld.get(null) instanceof Field) {
                        Field modelField = (Field) fld.get(null);
                        modelFields.put(fld.getName(), modelField);
                    }
                } catch (IllegalAccessException e) {
                }
            }
        }
        return modelFields;
    }

    public Map<String, ModelProperty> collectProperties(Class cls) {
        Map<String, ModelProperty> properties =  new LinkedHashMap<String, ModelProperty>();

        for (Method method : cls.getMethods()) {
            if (method.isAnnotationPresent(Attribute.class)) {
                Attribute attribute = method.getAnnotation(Attribute.class);
                properties.put(attribute.name(),
                        new ModelProperty(method.getName(), method.getReturnType(),
                                map("verbose", attribute.verbose(), "visible", attribute.visible()))
                );
            }
        }

        return properties;
    }

}