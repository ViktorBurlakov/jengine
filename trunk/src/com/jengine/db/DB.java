package com.jengine.db;


import com.jengine.db.exception.DBException;
import com.jengine.db.expression.Expression;
import com.jengine.db.field.Field;
import com.jengine.db.field.FunctionField;
import com.jengine.db.provider.Provider;
import com.jengine.utils.ClassUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.jengine.utils.CollectionUtil.map;

public class DB {
    private String name;
    private Provider provider;
    public static ConcurrentHashMap<String, ModelManager> managers = new ConcurrentHashMap<String, ModelManager>();

    public DB(Provider provider) {
        this.name = "default";
        this.provider = provider;
    }

    public DB(String name, Provider provider) {
        this.name = name;
        this.provider = provider;
    }

    public ModelManager register(String className) {
        ModelManager manager = new ModelManager();
        manager.setDb(this);
        managers.put(className, manager);
        return manager;
    }

    public ModelManager getManager(Class clazz) {
        ModelManager manager = managers.get(clazz.getName());

        if (manager != null) {
            return manager;
        } else {
            ClassUtils.forceInit(clazz);
            return managers.get(clazz.getName());
        }
    }

    public ModelManager getManager(String name) {
        return managers.get(name);
    }

    public Model get(Class cls, Object id) throws DBException {
        ModelManager manager = getManager(cls);
        Model obj = getCache(cls, id);
        return obj != null ? obj : (Model) new ModelQuery(manager).filter(manager.getPrimaryKey().eq(id)).one();
    }

    public ModelQuery select(Class cls, Object ... fields) throws DBException {
        return select(cls, Arrays.asList(fields));
    }

    public ModelQuery select(Class cls, List fields) throws DBException {
        return new ModelQuery(getManager(cls)).fields(fields);
    }

    public ModelQuery filter(Class cls, String query, Object ... params) throws DBException {
        return new ModelQuery(getManager(cls)).filter(query, (Object[]) params);
    }

    public ModelQuery filter(Class cls, Map<String, Object> filter) throws DBException {
        return new ModelQuery(getManager(cls)).filter(filter);
    }

    public ModelQuery filter(Class cls, Expression... filters) throws DBException {
        return filter(cls, Arrays.asList(filters));
    }

    public ModelQuery filter(Class cls, List<Expression> filter) throws DBException {
        return new ModelQuery(getManager(cls)).filter(filter);
    }

    public Long count(Class cls) throws DBException {
        ModelManager manager = getManager(cls);
        return (Long) new ModelQuery(manager).field(manager.getCountField(manager.getPrimaryKey().getName())).one();
    }

    public Long count(Class cls, String field) throws DBException {
        ModelManager manager = getManager(cls);
        return (Long) new ModelQuery(manager).field(manager.getCountField(field)).one();
    }

    public Object max(Class cls, String field) throws DBException {
        ModelManager manager = getManager(cls);
        return new ModelQuery(manager).field(manager.getMaxField(field)).one();
    }

    public Object min(Class cls, String field) throws DBException {
        ModelManager manager = getManager(cls);
        return new ModelQuery(manager).field(manager.getMinField(field)).one();
    }

    public Object avg(Class cls, String field) throws DBException {
        ModelManager manager = getManager(cls);
        return new ModelQuery(manager).field(manager.getAvgField(field)).one();
    }

    public Object sum(Class cls, String field) throws DBException {
        ModelManager manager = getManager(cls);
        return new ModelQuery(manager).field(manager.getSumField(field)).one();
    }

    public Long count(Class cls, Field field) throws DBException {
        ModelManager manager = getManager(cls);
        return (Long) new ModelQuery(manager).field(manager.getCountField(field)).one();
    }

    public Object max(Class cls, Field field) throws DBException {
        ModelManager manager = getManager(cls);
        return new ModelQuery(manager).field(manager.getMaxField(field)).one();
    }

    public Object min(Class cls, Field field) throws DBException {
        ModelManager manager = getManager(cls);
        return new ModelQuery(manager).field(manager.getMinField(field)).one();
    }

    public Object avg(Class cls, Field field) throws DBException {
        ModelManager manager = getManager(cls);
        return new ModelQuery(manager).field(manager.getAvgField(field)).one();
    }

    public Object sum(Class cls, Field field) throws DBException {
        ModelManager manager = getManager(cls);
        return new ModelQuery(manager).field(manager.getSumField(field)).one();
    }

    public Object calc(Class cls, String name, Class type, String expr, Field ... fields) throws DBException {
        ModelManager manager = getManager(cls);
        FunctionField functionField = new FunctionField(manager, name, type, map(), expr, (Field[]) fields);
        return new ModelQuery(manager).field(functionField).one();
    }

    public void remove(Class cls) throws DBException {
        ModelManager manager = getManager(cls);
        new ModelQuery(manager).remove();
        clearCache(cls);
    }

    public Model cache(Model obj) throws DBException {
        if (getManager(obj.getClass()).getCacheEnabled()) {
            provider.cache(obj);
        }
        return obj;
    }

    public Model getCache(Class cls, Object id) throws DBException {
        return getManager(cls).getCacheEnabled() ? provider.getCache(cls, id) : null;
    }

    public void clearCache(Model obj) throws DBException {
        if (getManager(obj.getClass()).getCacheEnabled()) {
            provider.clearCache(obj);
        }
    }

    public void clearCache(Class cls) throws DBException {
        if (getManager(cls).getCacheEnabled()) {
            provider.clearCache(cls);
        }
    }

    public Model insert(Model obj) throws DBException {
        ModelManager manager = getManager(obj.getClass());
        provider.insert(obj);
       return cache(obj);
    }

    public Model update(Model obj) throws DBException {
        ModelManager manager = getManager(obj.getClass());
        new ModelQuery(manager).values(obj.getValues(manager.getFieldNames())).update();
        return cache(obj);
    }

    public void remove(Model obj) throws DBException {
        ModelManager manager = getManager(obj.getClass());
        new ModelQuery(manager).values(obj.getValues(manager.getFieldNames())).remove();
        clearCache(obj);
    }

    public Model save(Model obj) throws DBException {
        if (obj.isNew()) {
            return insert(obj);
        }
        return update(obj);
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

    public List run(ModelQuery modelQuery) throws DBException {
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
        int index=0;
        for (Field field : modelQuery.getFields()) {
            if (field.isReference() || field.isSelf()) {
                Model obj = newInstance(field.getFieldClass());
                for (Field objField : getManager(field.getFieldClass()).getFields()) {
                    if (!objField.isFunction()) {
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

    protected Model newInstance(Class model) throws DBException {
        Model obj = null;
        try {
            obj = (Model) model.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            throw new DBException(e.getMessage());
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            throw new DBException(e.getMessage());
        }
        return obj;
    }

    /* getters */

    public String getName() {
        return name;
    }

    public Provider getProvider() {
        return provider;
    }

    @Override
    public String toString() {
        return "DB{" +
                "name='" + name + '\'' +
                '}';
    }
}
