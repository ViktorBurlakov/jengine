package com.jengine.orm;

import com.jengine.orm.db.DB;
import com.jengine.orm.db.DBException;
import com.jengine.orm.db.expression.Expression;
import com.jengine.orm.db.provider.Provider;
import com.jengine.orm.field.Field;
import com.jengine.orm.field.FunctionField;
import com.jengine.orm.field.ReferenceField;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ModelClassBase<T extends Model> {
    public static Map<String, ModelClassBase> classMap = new ConcurrentHashMap<String, ModelClassBase>();
    protected DB db;
    protected Provider provider;
    protected ModelManager manager;
    protected String name;
    protected Class<T> cls;

    public ModelClassBase(String name, Class<T> cls) {
        this.name = name;
        this.cls = cls;
        this.classMap.put(name, this);
    }

    static  public ModelClassBase getModelClass(String name) {
        return classMap.get(name);
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
                ModelClassBase fieldModelClass = getModelClass(((ReferenceField)field).getReferenceModelName());
                Model obj = fieldModelClass.newInstance();
                obj.setNew(false);
                for (Field objField : fieldModelClass.getManager().getFields(Field.Type.PLAIN, Field.Type.REFERENCE)) {
                    obj.setValue(objField, items[index++]);
                }
                obj.cache();
                result.add(obj);
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
}
