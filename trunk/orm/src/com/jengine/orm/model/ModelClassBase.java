package com.jengine.orm.model;

import com.jengine.orm.DB;
import com.jengine.orm.db.DBException;
import com.jengine.orm.db.provider.Provider;
import com.jengine.orm.exception.ValidateException;
import com.jengine.orm.model.field.Field;
import com.jengine.orm.model.field.aggregation.*;
import com.jengine.orm.model.field.reference.ManyReferenceField;
import com.jengine.orm.model.query.ModelQuery;
import com.jengine.orm.model.query.filter.Filter;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ModelClassBase<T extends Model> {
    protected DB db;
    protected Provider provider;
    protected ModelManager manager;
    protected String name;
    protected Class<T> cls;

    public ModelClassBase(String name, Class<T> cls) {
        this.name = name;
        this.cls = cls;
    }

    public void register() {
        db.register(this);
    }

    public T newInstance(Map values) throws DBException {
        Model obj = newInstance();
        obj.setModelClass(this);
        obj.setValues(values);
        return (T) obj;
    }

    public T newInstance() throws DBException {
        Model obj = null;
        try {
            obj = cls.newInstance();
            obj.setModelClass(this);
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
        Model obj = getCache(manager.getPrimaryKey().cast(id));
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

    public ModelQuery filter(Filter... filters) throws DBException {
        return filter(Arrays.asList(filters));
    }

    public ModelQuery filter(List<Filter> filter) throws DBException {
        return new ModelQuery(manager).filter(filter);
    }

    public Long count() throws DBException {
        return (Long) new ModelQuery(manager).field(new Count(this, manager.getPrimaryKey())).one();
    }

    public Long count(String field) throws DBException {
        return (Long) new ModelQuery(manager).field(new Count(this, field)).one();
    }

    public Object max(String field) throws DBException {
        return new ModelQuery(manager).field(new Max(this, field)).one();
    }

    public Object min(String field) throws DBException {
        return new ModelQuery(manager).field(new Min(this, field)).one();
    }

    public Object avg(String field) throws DBException {
        return new ModelQuery(manager).field(new Avg(this, field)).one();
    }

    public Object sum(String field) throws DBException {
        return new ModelQuery(manager).field(new Sum(this, field)).one();
    }

    public Long count(Field field) throws DBException {
        return (Long) new ModelQuery(manager).field(new Count(this, field)).one();
    }

    public <ResultType> ResultType max(Field field) throws DBException {
        return (ResultType) new ModelQuery(manager).field(new Max(this, field)).one();
    }

    public <ResultType> ResultType min(Field field) throws DBException {
        return (ResultType) new ModelQuery(manager).field(new Min(this, field)).one();
    }

    public <ResultType> ResultType avg(Field field) throws DBException {
        return (ResultType) new ModelQuery(manager).field(new Avg(this, field)).one();
    }

    public <ResultType> ResultType sum(Field field) throws DBException {
        return (ResultType) new ModelQuery(manager).field(new Sum(this, field)).one();
    }

    public <ResultType> ResultType calc(String name, Class type, String expr, Field ... fields) throws DBException {
        return (ResultType) new ModelQuery(manager).field(new Calc(this, name, type, expr, fields)).one();
    }

    public void remove() throws DBException {
        new ModelQuery(manager).remove();
        clearCache(cls);
    }

    public Model wrap(Map<String, Object> values) throws DBException {
        Model obj = newInstance();
        for(String columnName : values.keySet()) {
            obj.setValue(manager.getFieldByColumn(columnName), values.get(columnName));
        }
        obj.setNew(false);
        return obj;
    }

    /* Cache methods  */

    public T getCache(Object id) throws DBException {
        if (manager.getCacheEnabled()) {
            Map<String, Object> values = provider.getCache(manager.getTableName(), id);
            return values != null ? (T) wrap(values) : null;
        } else {
            return null;
        }
    }

    public void clearCache(Class cls) throws DBException {
        if (manager.getCacheEnabled()) {
            provider.clearCache(manager.getTableName());
        }
    }

    public void clearCache(Model obj) throws DBException {
        if (manager.getCacheEnabled()) {
            provider.clearCache(manager.getTableName(), obj.getPrimaryKey());
        }
    }

    public void cache(Model obj) throws DBException {
        if (manager.getCacheEnabled()) {
            provider.cache(manager.getTableName(), manager.getPrimaryKey().getPersistenceValue(obj), obj.getPersistenceValues());
        }
    }


    /* Model object methods  */

    public T insert(Model obj) throws ValidateException, DBException {
        boolean autoIncrement = obj.getPrimaryKey() == null && manager.getPrimaryKey().isAutoIncrement();
        Object id = provider.insert(manager.getTableName(), obj.getPersistenceValues(), autoIncrement);
        obj.setNew(false);
        if (autoIncrement) {
            obj.setPrimaryKey((Serializable) id);
        }
        for (Field field : manager.getFields(Field.Type.MANY_REFERENCE, Field.Type.REVERSE_MANY_REFERENCE)) {
            ((ManyReferenceField) field).insert(obj);
            obj.getData().remove(field.getFieldName());
        }
        return (T) obj;
    }

    public Model update(Model obj) throws ValidateException, DBException {
        Map<String, Object> changes = obj.getChangedPersistenceValues();
        if (changes.size() > 0) {
            provider.update(manager.getTableName(), manager.getPrimaryKey().getColumnName(), changes);
        }
        for (Field field : manager.getFields(Field.Type.MANY_REFERENCE, Field.Type.REVERSE_MANY_REFERENCE)) {
            ((ManyReferenceField) field).update(obj);
            obj.getData().remove(field.getFieldName());
        }

        return obj;
    }

    public void remove(Model obj) throws DBException {
        provider.remove(manager.getTableName(), manager.getPrimaryKey().getColumnName(), obj.getPrimaryKey());
    }


    /* getters and setters */

    public Provider getProvider() {
        return provider;
    }

    public ModelManager getManager() {
        return manager;
    }

    public String getName() {
        return name;
    }

    public DB getDb() {
        return db;
    }
}
