package com.jengine.orm;

import com.jengine.orm.db.DB;
import com.jengine.orm.db.DBException;
import com.jengine.orm.db.expression.Expression;
import com.jengine.orm.db.provider.Provider;
import com.jengine.orm.field.*;
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
        return manager.getCacheEnabled() ? (T) provider.getCache(cls, id) : null;
    }

    public void clearCache(Class cls) throws DBException {
        if (manager.getCacheEnabled()) {
            provider.clearCache(cls);
        }
    }

    public T insert(Model obj) throws DBException {
        List<Field> fields = manager.getFields(Field.Type.REFERENCE, Field.Type.PLAIN, Field.Type.SINGLE_REFERENCE);
        Object id = provider.insert(manager.getTableName(), getDbValues(obj, fields));
        obj.setNew(false);
        if (manager.getPrimaryKey().isAutoIncrement()) {
            obj.setPrimaryKey((Serializable) id);
        }
        insertReferences(obj);
        return (T) obj;
    }

    protected Map<String, Object> getDbValues(Model obj, List<Field> fields) throws DBException {
        Map<String, Object> result = new LinkedHashMap<String, Object>();
        Map<String, Object> values = obj._getData(fields);

        for (String fieldName : values.keySet()) {
            result.put(manager.getField(fieldName).getColumnName(), values.get(fieldName));
        }

        return result;
    }

    protected void insertReferences(Model obj) throws DBException {
        List<Field> fields = manager.getFields(Field.Type.MANY_REFERENCE, Field.Type.REVERSE_MANY_REFERENCE);
        Map values = obj._getManyReferenceData();
        if (values.size() == 0) {
            return;
        }
        for (Field field : fields) {
            ManyReferenceField manyReferenceField = (ManyReferenceField) field;
            if (values.containsKey(field.getFieldName())) {
                List keys = (List) values.get(field.getFieldName());
                ModelClassBase referenceModelClass = getModelClass(manyReferenceField.getReferenceModelName());
                ModelClassBase middleModelClass = getModelClass(manyReferenceField.getMiddleModelName());
                Field referenceKeyField = manyReferenceField.getReverseField().getKeyField();
                Field middleModelField = middleModelClass.getManager().getField(manyReferenceField.getMiddleModelFieldName());
                Field middleModelReferenceField = middleModelClass.getManager().getField(manyReferenceField.getReverseField().getMiddleModelFieldName());
                for (Object key : keys) {
                    Model referenceObj = referenceModelClass.filter(referenceKeyField.eq(key)).one();
                    Model middleObj = middleModelClass.newInstance();
                    middleObj.setValue(middleModelField, obj.getValue(manyReferenceField.getKeyFieldName()));
                    middleObj.setValue(middleModelReferenceField, referenceObj);
                    middleObj.save();
                }
            }
        }
    }

    protected void removeReferences(Model obj) throws DBException {
        List<Field> fields = manager.getFields(Field.Type.MANY_REFERENCE, Field.Type.REVERSE_MANY_REFERENCE);
        for (Field field : fields) {
            ManyReferenceField manyReferenceField = (ManyReferenceField) field;
            ModelClassBase middleModelClass = getModelClass(manyReferenceField.getMiddleModelName());
            Field middleModelField = middleModelClass.getManager().getField(manyReferenceField.getMiddleModelFieldName());
            middleModelClass.filter(middleModelField.eq(obj.getValue(manyReferenceField.getKeyFieldName()))).remove();
        }
    }

    public Model update(Model obj) throws DBException {
        List<Field> fields = manager.getFields(Field.Type.REFERENCE, Field.Type.PLAIN, Field.Type.SINGLE_REFERENCE);
        provider.update(manager.getTableName(), manager.getPrimaryKey().getColumnName(), getDbValues(obj, fields));
        if (obj._getManyReferenceData().size() > 0) {
            removeReferences(obj);
            insertReferences(obj);
            obj._getManyReferenceData().clear();
        }
        return obj;
    }

    public void remove(Model obj) throws DBException {
        provider.remove(manager.getTableName(), manager.getPrimaryKey().getColumnName(), obj.getPrimaryKey());
        removeReferences(obj);
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
            if (field.getType() == Field.Type.REFERENCE || field.getType() == Field.Type.SELF
                    || field.getType() == Field.Type.SINGLE_REFERENCE) {
                ModelClassBase fieldModelClass = getModelClass(((ReferenceField)field).getReferenceModelName());
                Model obj = fieldModelClass.newInstance();
                obj.setNew(false);
                for (Field objField : fieldModelClass.getManager().getFields(Field.Type.PLAIN, Field.Type.REFERENCE, Field.Type.SINGLE_REFERENCE)) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
