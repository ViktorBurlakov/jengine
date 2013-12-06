package com.jengine.orm;

import com.jengine.orm.db.DB;
import com.jengine.orm.db.DBException;
import com.jengine.orm.db.DBFactory;
import com.jengine.orm.db.expression.Expression;
import com.jengine.orm.db.provider.Provider;
import com.jengine.orm.field.*;
import com.jengine.utils.ClassObject;

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
        this.manager.addField(new SelfField(cls));
        this.manager.addFields(collectFields(cls));
        this.manager.addProperties(collectProperties(cls));
        this.manager.addField(new ModelProperty("verbose", "getVerbose", String.class, map("verbose", this.manager.getName())));
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
        return (Long) new ModelQuery(manager).field(manager.getCountField(manager.getPrimaryKey().getName())).one();
    }

    public Long count(String field) throws DBException {
        return (Long) new ModelQuery(manager).field(manager.getCountField(field)).one();
    }

    public Object max(String field) throws DBException {
        return new ModelQuery(manager).field(manager.getMaxField(field)).one();
    }

    public Object min(String field) throws DBException {
        return new ModelQuery(manager).field(manager.getMinField(field)).one();
    }

    public Object avg(String field) throws DBException {
        return new ModelQuery(manager).field(manager.getAvgField(field)).one();
    }

    public Object sum(String field) throws DBException {
        return new ModelQuery(manager).field(manager.getSumField(field)).one();
    }

    public Long count(Field field) throws DBException {
        return (Long) new ModelQuery(manager).field(manager.getCountField(field)).one();
    }

    public <ResultType> ResultType max(Field field) throws DBException {
        return (ResultType) new ModelQuery(manager).field(manager.getMaxField(field)).one();
    }

    public <ResultType> ResultType min(Field field) throws DBException {
        return (ResultType) new ModelQuery(manager).field(manager.getMinField(field)).one();
    }

    public <ResultType> ResultType avg(Field field) throws DBException {
        return (ResultType) new ModelQuery(manager).field(manager.getAvgField(field)).one();
    }

    public <ResultType> ResultType sum(Field field) throws DBException {
        return (ResultType) new ModelQuery(manager).field(manager.getSumField(field)).one();
    }

    public <ResultType> ResultType calc(String name, Class type, String expr, Field ... fields) throws DBException {
        FunctionField functionField = new FunctionField(manager, name, type, map(), expr, (Field[]) fields);
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
        provider.insert(obj);
        obj.setNew(false);
        return (T) obj;
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
            if (field.isReference() || field.isSelf()) {
                ModelClass fieldModelClass = getModelClass(field.getFieldClass());
                Model obj = fieldModelClass.newInstance();
                obj.setNew(false);
                for (Field objField : fieldModelClass.getManager().getFields()) {
                    if (!objField.isFunction() && !objField.isSelf() && !objField.isProperty()) {
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