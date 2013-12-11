package com.jengine.orm;

import com.jengine.orm.db.DB;
import com.jengine.orm.db.DBException;
import com.jengine.orm.db.DBFactory;
import com.jengine.orm.db.expression.Expression;
import com.jengine.orm.db.provider.Provider;
import com.jengine.orm.field.*;
import com.jengine.utils.ClassObject;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

import static com.jengine.utils.CollectionUtil.map;


public class ModelClass<T extends Model> extends ClassObject {
    private DB db;
    private Provider provider;
    private ModelManager manager;

    public ModelClass(Class<T> cls) {
        this(cls, new HashMap());
    }

    public ModelClass(Class<T> cls, Map options) {
        super(cls);
        String dbName = options.containsKey("dbName") ?
                (String) options.get("dbName") : cls.getAnnotation(Meta.class).dbName();
        this.db = DBFactory.get(dbName);
        this.provider = this.db.getProvider();
        this.provider.setCls(this);
        this.manager = new ModelManager();
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
    }

    public ModelClass getModelClass(Class clazz) {
        return (ModelClass) getClassObject(clazz);
    }

    public T newInstance(Map values) throws DBException {
        Model obj = newInstance();
        obj.setValues(values);
        return (T) obj;
    }

    public T newInstance() throws DBException {
        Model obj = null;
        try {
            obj = (Model) cls.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            throw new DBException(e.getMessage());
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            throw new DBException(e.getMessage());
        }
        return (T) obj;
    }

    public T get(Object id) throws DBException {
        Model obj = getCache(id);
        return (T) (obj != null ? obj : (Model) new ModelQuery(manager).filter(manager.getPrimaryKey().eq(id)).one());
    }

    public ModelQuery select(Object ... fields) throws DBException {
        return select(Arrays.asList(fields));
    }

    public ModelQuery select(List fields) throws DBException {
        return new ModelQuery(manager).fields(fields);
    }

    public ModelQuery filter(String query, Object ... params) throws DBException {
        return new ModelQuery(manager).filter(query, (Object[]) params);
    }

    public ModelQuery filter(Map<String, Object> filter) throws DBException {
        return new ModelQuery(manager).filter(filter);
    }

    public ModelQuery filter(Expression... filters) throws DBException {
        return filter(Arrays.asList(filters));
    }

    public ModelQuery filter(List<Expression> filter) throws DBException {
        return new ModelQuery(manager).filter(filter);
    }

    public Long count() throws DBException {
        return (Long) new ModelQuery(manager).field(manager.newCountField(manager.getPrimaryKey().getFieldName())).one();
    }

    public Long count(String field) throws DBException {
        return (Long) new ModelQuery(manager).field(manager.newCountField(field)).one();
    }

    public Object max(String field) throws DBException {
        return new ModelQuery(manager).field(manager.newMaxField(field)).one();
    }

    public Object min(String field) throws DBException {
        return new ModelQuery(manager).field(manager.newMinField(field)).one();
    }

    public Object avg(String field) throws DBException {
        return new ModelQuery(manager).field(manager.newAvgField(field)).one();
    }

    public Object sum(String field) throws DBException {
        return new ModelQuery(manager).field(manager.newSumField(field)).one();
    }

    public Long count(Field field) throws DBException {
        return (Long) new ModelQuery(manager).field(manager.newCountField(field)).one();
    }

    public <ResultType> ResultType max(Field field) throws DBException {
        return (ResultType) new ModelQuery(manager).field(manager.newMaxField(field)).one();
    }

    public <ResultType> ResultType min(Field field) throws DBException {
        return (ResultType) new ModelQuery(manager).field(manager.newMinField(field)).one();
    }

    public <ResultType> ResultType avg(Field field) throws DBException {
        return (ResultType) new ModelQuery(manager).field(manager.newAvgField(field)).one();
    }

    public <ResultType> ResultType sum(Field field) throws DBException {
        return (ResultType) new ModelQuery(manager).field(manager.newSumField(field)).one();
    }

    public <ResultType> ResultType calc(String name, Class type, String expr, Field ... fields) throws DBException {
        FunctionField functionField = manager.newCalcField(name, type, expr, fields);
        return (ResultType) new ModelQuery(manager).field(functionField).one();
    }

    public void remove() throws DBException {
        new ModelQuery(manager).remove();
        clearCache(cls);
    }

    public T getCache(Object id) throws DBException {
        return manager.getCacheEnabled() ? (T) provider.getCache(cls, id) : null;
    }

    public void clearCache(Class cls) throws DBException {
        if (manager.getCacheEnabled()) {
            provider.clearCache(cls);
        }
    }

    public T insert(Model obj) throws DBException {
        Object id = provider.insert(manager.getTableName(), obj.getDBValues());
        obj.setNew(false);
        if (manager.getPrimaryKey().isAutoIncrement()) {
            obj.setPrimaryKey((Serializable) id);
        }
        return (T) obj;
    }

    public Model update(Model obj) throws DBException {
        provider.update(manager.getTableName(), obj.getDBValues());
        return obj;
    }

    public void remove(Model obj) throws DBException {
        provider.remove(manager.getTableName(), manager.getPrimaryKey().getColumnName(), obj.getPrimaryKey());
    }


    public void insert(ModelQuery modelQuery) throws DBException {
        provider.insert(modelQuery);
    }

    public void update(ModelQuery modelQuery) throws DBException {
        provider.update(modelQuery);
    }

    public void remove(ModelQuery modelQuery) throws DBException {
        provider.remove(modelQuery);
    }

    public List select(ModelQuery modelQuery) throws DBException {
        List values = provider.select(modelQuery);
        return processResult(modelQuery, values);
    }

    protected List processResult(ModelQuery modelQuery, List values) throws DBException {
        List result = new ArrayList();

        for (Object value : values) {
            Object[] items = value.getClass().isArray() ? (Object[]) value : new Object[]{value};
            List resultItem = processResultItem(modelQuery, items);
            result.add(resultItem.size() == 1 ? resultItem.get(0) : resultItem);
        }

        return result;
    }

    protected List processResultItem(ModelQuery modelQuery, Object[] items) throws DBException {
        List result = new ArrayList();
        List<Field> fields = modelQuery.getFields();
        int index=0;
        if (fields.size() == 0) {
            fields.add(modelQuery.getManager().getSelf());
        }
        for (Field field : fields) {
            if (field.getType() == Field.Type.REFERENCE || field.getType() == Field.Type.SELF) {
                ModelClass fieldModelClass = getModelClass(field.getFieldClass());
                Model obj = fieldModelClass.newInstance();
                obj.setNew(false);
                for (Field objField : fieldModelClass.getManager().getFields()) {
                    if (objField.getType() == Field.Type.PLAIN || objField.getType() == Field.Type.REFERENCE) {
                        obj.setValue(objField, items[index++]);
                    }
                }
                obj.cache();
                result.add(obj);
            } else {
                result.add(field.castType(items[index++]));
            }
        }

        return result;
    }

    /* getters */

    public Provider getProvider() {
        return provider;
    }

    public ModelManager getManager() {
        return manager;
    }

    /* collect methods */

    public Map<String, Field> collectFields(Class cls) {
        Map<String, Field> modelFields = new LinkedHashMap<String, Field>();
        java.lang.reflect.Field fieldlist[] = cls.getDeclaredFields();
        for (int i = 0; i < fieldlist.length; i++) {
            java.lang.reflect.Field fld = fieldlist[i];
            if (Modifier.isStatic(fld.getModifiers()) &&
                    fld.getType().isAssignableFrom(Field.class)) {
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