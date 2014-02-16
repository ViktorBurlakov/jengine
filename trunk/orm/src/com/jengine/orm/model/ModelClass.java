package com.jengine.orm.model;

import com.jengine.orm.DBFactory;
import com.jengine.orm.model.field.*;
import com.jengine.orm.model.field.reference.SelfField;
import com.jengine.utils.ClassUtils;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
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