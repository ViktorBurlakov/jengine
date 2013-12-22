package com.jengine.orm;

import com.jengine.orm.db.DBFactory;
import com.jengine.orm.field.*;

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
        String dbName = options.containsKey("dbName") ?
                (String) options.get("dbName") : cls.getAnnotation(Meta.class).dbName();
        this.db = DBFactory.get(dbName);
        this.provider = this.db.getProvider();
        this.provider.setModelClass(this);
        this.manager = new ModelManager();
        this.manager.setModelClass(cls);
        this.manager.setCls(this);
        this.manager.setName(options.containsKey("name") ? (String) options.get("name") : cls.getSimpleName());
        this.manager.setTableName(options.containsKey("table") ?
                (String) options.get("table") : cls.getAnnotation(Meta.class).table());
        this.manager.setCacheEnabled(options.containsKey("cacheEnabled") ?
                (Boolean) options.get("cacheEnabled") : cls.getAnnotation(Meta.class).cacheEnabled());
        // init fields and properties
        Map<String, Field> fields = new LinkedHashMap<String, Field>();
        fields.put(SelfField.DEFAULT_NAME, new SelfField(cls));
        fields.putAll(collectFields(cls));
        fields.putAll(collectProperties(cls));
        fields.put("verbose", new ModelProperty("getVerbose", String.class, map("verbose", this.manager.getName())));
        for (String fieldName : fields.keySet()) {
            Field field = fields.get(fieldName);
            this.manager.addField(fieldName, field);
        }
        this.manager.addDeferredFields();
    }

    /* collect methods */

    public Map<String, Field> collectFields(Class cls) {
        Map<String, Field> modelFields = new LinkedHashMap<String, Field>();
        java.lang.reflect.Field fieldlist[] = cls.getDeclaredFields();
        for (int i = 0; i < fieldlist.length; i++) {
            java.lang.reflect.Field fld = fieldlist[i];
            if (Modifier.isStatic(fld.getModifiers()) &&
                    (fld.getType().isAssignableFrom(Field.class) || fld.getType().isAssignableFrom(ManyReferenceField.class))) {
                try {
                    Field modelField = (Field) fld.get(null);
                    modelFields.put(fld.getName(), modelField);
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