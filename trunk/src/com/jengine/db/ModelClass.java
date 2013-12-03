package com.jengine.db;

import com.jengine.db.exception.DBException;
import com.jengine.db.expression.Expression;
import com.jengine.db.field.Field;
import com.jengine.db.field.ModelAttribute;
import com.jengine.db.field.ModelProperty;
import com.jengine.db.field.SelfField;
import com.jengine.utils.ClassObject;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.jengine.utils.CollectionUtil.map;


public class ModelClass<T extends Model> extends ClassObject {
    private ModelManager manager;
    private DB db;

    public ModelClass(Class<T> cls) {
        this(cls, new HashMap());
    }

    public ModelClass(Class<T> cls, Map options) {
        super(cls);
        String dbName = options.containsKey("dbName") ?
                (String) options.get("dbName") : cls.getAnnotation(Meta.class).dbName();
        this.db = DBFactory.get(dbName);
        this.manager = this.db.register(cls.getName());

        this.manager.setName(options.containsKey("name") ? (String) options.get("name") : cls.getSimpleName());
        this.manager.setTableName(options.containsKey("table") ?
                (String) options.get("table") : cls.getAnnotation(Meta.class).table());
        this.manager.setCacheEnabled(options.containsKey("cacheEnabled") ?
                (Boolean) options.get("cacheEnabled") : cls.getAnnotation(Meta.class).cacheEnabled());
        // init fields and properties
        this.manager.addField(new SelfField(cls));
        this.manager.addFields(collectFields(cls));
        this.manager.addProperties(collectProperties(cls));
        this.manager.addField(new ModelProperty("verbose", "getVerbose", String.class, map("verbose", this.manager.getName())));
    }

    public ModelManager getManager() {
        return manager;
    }

    public DB getDb() {
        return db;
    }

    public T newInstance(Map values) throws DBException {
        Model obj = db.newInstance(cls);
        obj.setValues(values);
        return (T) obj;
    }

    public T newInstance() throws DBException {
        return (T) db.newInstance(cls);
    }

    public T get(Object id) throws DBException {
        return (T) db.get(cls, id);
    }

    public ModelQuery select() throws DBException {
        return db.select(cls);
    }

    public ModelQuery select(Object ... fields) throws DBException {
        return db.select(cls, fields);
    }

    public ModelQuery select(Class cls, List ... fields) throws DBException {
        return db.select(cls, fields);
    }

    public ModelQuery filter(String query, Object ... params) throws DBException {
        return db.filter(cls, query, params);
    }

    public ModelQuery filter(Map<String, Object> filter) throws DBException {
        return db.filter(cls, filter);
    }

    public ModelQuery filter(List<Expression> filter) throws DBException {
        return db.filter(cls, filter);
    }

    public ModelQuery filter(Expression ... filter) throws DBException {
        return db.filter(cls, filter);
    }

    public Object max(String field) throws DBException {
        return db.max(cls, field);
    }

    public Object min(String field) throws DBException {
        return db.min(cls, field);
    }

    public long count() throws DBException {
        return db.count(cls);
    }

    public long count(String field) throws DBException {
        return db.count(cls, field);
    }

    public Object avg(String field) throws DBException {
        return db.avg(cls, field);
    }

    public Object sum(String field) throws DBException {
        return db.sum(cls, field);
    }

    public <ResultType> ResultType max(Field field) throws DBException {
        return (ResultType) db.max(cls, field);
    }

    public <ResultType> ResultType min(Field field) throws DBException {
        return (ResultType) db.min(cls, field);
    }

    public long count(Field field) throws DBException {
        return db.count(cls, field);
    }

    public <ResultType> ResultType avg(Field field) throws DBException {
        return (ResultType) db.avg(cls, field);
    }

    public <ResultType> ResultType sum(Field field) throws DBException {
        return (ResultType) db.sum(cls, field);
    }

    public <ResultType> ResultType calc(String name, Class type, String expr, Field ... fields) throws DBException {
        return (ResultType) db.calc(cls, name, type, expr, fields);
    }

    public void remove() throws DBException {
        db.remove(cls);
    }


    /* collect methods */

    public List<Field> collectFields(Class cls) {
        List<Field> modelFields = new ArrayList<Field>();
        java.lang.reflect.Field fieldlist[] = cls.getDeclaredFields();
        for (int i = 0; i < fieldlist.length; i++) {
            java.lang.reflect.Field fld = fieldlist[i];
            if (Modifier.isStatic(fld.getModifiers()) &&
                    fld.getType().isAssignableFrom(Field.class)) {
                try {
                    Field modelField = (Field) fld.get(null);
                    modelField.setName(fld.getName());
                    modelFields.add(modelField);
                } catch (IllegalAccessException e) {
                }
            }
        }
        return modelFields;
    }

    public List<ModelProperty> collectProperties(Class cls) {
        List<ModelProperty> properties = new ArrayList<ModelProperty>();

        for (Method method : cls.getMethods()) {
            if (method.isAnnotationPresent(ModelAttribute.class)) {
                ModelAttribute attribute = method.getAnnotation(ModelAttribute.class);
                properties.add(new ModelProperty(attribute.name(), method.getName(), method.getReturnType(),
                        map("verbose", attribute.verbose(), "visible", attribute.visible())));
            }
        }
        return properties;
    }

}