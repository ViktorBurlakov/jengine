package com.jengine.orm;

import com.jengine.orm.db.DB;
import com.jengine.orm.db.DBException;
import com.jengine.orm.db.expression.Expression;
import com.jengine.orm.db.provider.Provider;
import com.jengine.orm.exception.ValidateException;
import com.jengine.orm.field.Field;
import com.jengine.orm.field.FunctionField;
import com.jengine.orm.field.reference.ManyReferenceField;
import com.jengine.orm.field.reference.ReferenceField;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ModelClassBase<T extends Model> {
    public static Map<String, ModelClassBase> classMap = new ConcurrentHashMap<String, ModelClassBase>();
    protected DB db;
    protected Provider provider;
    protected ModelManager manager;
    protected String name;
    protected Class<T> cls;

    static  public ModelClassBase getModelClass(String name) {
        return classMap.get(name);
    }

    public ModelClassBase(String name, Class<T> cls) {
        this.name = name;
        this.cls = cls;
        this.classMap.put(name, this);
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
        return manager.getCacheEnabled() ? (T) provider.getCache(manager.getTableName(), id) : null;
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
            provider.cache(manager.getTableName(), obj.getPersistenceValues());
        }
    }

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
        provider.update(manager.getTableName(), manager.getPrimaryKey().getColumnName(),
                obj.getPersistenceValues());
        for (Field field : manager.getFields(Field.Type.MANY_REFERENCE, Field.Type.REVERSE_MANY_REFERENCE)) {
            ((ManyReferenceField) field).update(obj);
            obj.getData().remove(field.getFieldName());
        }

        return obj;
    }

    public void remove(Model obj) throws DBException {
        provider.remove(manager.getTableName(), manager.getPrimaryKey().getColumnName(), obj.getPrimaryKey());
    }


    public void insert(ModelQuery modelQuery) throws DBException {
        provider.insert(PersistenceManager.buildInsertSQL(modelQuery));
    }

    public void update(ModelQuery modelQuery) throws DBException {
        provider.update(PersistenceManager.buildUpdateSQL(modelQuery));
    }

    public void remove(ModelQuery modelQuery) throws DBException {
        provider.remove(PersistenceManager.buildRemoveSQL(modelQuery));
    }

    public List select(ModelQuery modelQuery) throws DBException {
        List values = provider.select(PersistenceManager.buildSelectSQL(modelQuery));
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
            if (field.getType() == Field.Type.REFERENCE || field.getType() == Field.Type.SELF
                    || field.getType() == Field.Type.SINGLE_REFERENCE) {
                ModelClassBase fieldModelClass = getModelClass(((ReferenceField)field).getReferenceModelName());
                Map<String, Object> values = new LinkedHashMap<String, Object>();
                boolean empty = true;
                for (Field objField : fieldModelClass.getManager().getFields(Field.Type.PLAIN, Field.Type.REFERENCE, Field.Type.SINGLE_REFERENCE)) {
                    values.put(objField.getFieldName(), items[index++]);
                    empty = empty && (values.get(objField.getFieldName()) == null);
                }
                if (!empty) {
                    Model obj = fieldModelClass.newInstance();
                    obj.setNew(false);
                    obj.setValues(values);
                    obj.cache();
                    result.add(obj);
                } else {
                    result.add(null);
                }
            } else {
                result.add(field.cast(items[index++]));
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
