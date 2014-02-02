package com.jengine.orm.model.field.reference;


import com.jengine.orm.model.Model;
import com.jengine.orm.model.ModelClassBase;
import com.jengine.orm.db.DBConnection;
import com.jengine.orm.db.DBException;
import com.jengine.orm.db.DBSavePoint;
import com.jengine.orm.exception.ValidateException;
import com.jengine.orm.model.field.Field;
import com.jengine.utils.Variant;

import java.util.*;

public class ManyReferenceField extends BaseReference {
    private String keyFieldName;
    private String referenceKeyFieldName;
    private String middleModelName;
    private String middleModelTableName;
    private String middleModelFieldName;
    private String middleModelReferenceFieldName;

    public ManyReferenceField(Class fieldClass) {
        this(fieldClass, new HashMap<String, Object>());
    }

    public ManyReferenceField(Class fieldClass, Map<String, Object> options) {
        this(fieldClass, fieldClass.getSimpleName(), options);
    }

    public ManyReferenceField(Class fieldClass, String referenceModelName, Map<String, Object> options) {
        super(fieldClass, referenceModelName, options);
        if (options.containsKey("keyFieldName")) {
            keyFieldName = (String) options.get("keyFieldName");
        }
        if (options.containsKey("middleModelName")) {
            middleModelName = (String) options.get("middleModelName");
        }
        if (options.containsKey("middleModelFieldName")) {
            middleModelFieldName = (String) options.get("middleModelFieldName");
        }
        if (options.containsKey("middleModelReferenceFieldName")) {
            middleModelReferenceFieldName = (String) options.get("middleModelReferenceFieldName");
        }
        if (options.containsKey("referenceKeyFieldName")) {
            referenceKeyFieldName = (String) options.get("referenceKeyFieldName");
        }
        if (options.containsKey("middleModelTableName")) {
            middleModelTableName = (String) options.get("middleModelTableName");
        }
    }

    public Object cast(Object value) throws DBException {
        List result = new ArrayList();
        List values = value instanceof List ? (List) value : Arrays.asList(value);
        Field field = getReverseField().getKeyField();

        for (Object item : values) {
            result.add(item instanceof Model ?
                    ((Model) item).getValue(field) : new Variant(item).convertTo(field.getFieldClass()));
        }

        return result;
    }

    public Type getType() {
        return Type.MANY_REFERENCE;
    }

    public Object getValue(Model obj) throws DBException {
        ModelClassBase middleCls = getMiddleClass();
        Field middleField = getMiddleField();
        Object keyValue = obj.getData().get(getKeyFieldName());
        return middleCls.filter(middleField.eq(keyValue)).field(middleField);
    }

    public void update(Model obj) throws ValidateException, DBException {
        DBConnection connection = manager.getModelClass().getProvider().getConnection();

        if (!connection.isTransactionActive()) {
            try {
                connection.startTransaction();
                remove(obj);
                insert(obj);
                connection.commit();
            } catch (Exception e) {
                connection.rollback();
                throw new DBException(e);
            } finally {
                connection.finishTransaction();
            }
        } else {
            DBSavePoint point = connection.savePoint();
            try{
                remove(obj);
                insert(obj);
            } catch (Exception e) {
                connection.rollback(point);
                throw new DBException(e);
            } finally {
                connection.releasePoint(point);
            }
        }
    }

    public void insert(Model obj) throws ValidateException, DBException {
        Map values = obj.getData();
        if (!values.containsKey(fieldName) || values.get(fieldName) == null) {
            return;
        }
        List keys = (List) values.get(fieldName);
        ModelClassBase middleModelClass = getMiddleClass();
        Field middleModelField = getMiddleField();
        Field middleModelReferenceField = getReverseField().getMiddleField();
        for (Object key : keys) {
            Model middleObj = middleModelClass.newInstance();
            middleObj.setValue(middleModelField, values.get(getKeyFieldName()));
            middleObj.setValue(middleModelReferenceField, key);
            middleObj.save();
        }
    }

    public void remove(Model obj) throws DBException {
        ModelClassBase middleModelClass = getMiddleClass();
        Field middleModelField = getMiddleField();
        middleModelClass.filter(middleModelField.eq(obj.getValue(getKeyFieldName()))).remove();
    }

    public ModelClassBase getMiddleClass() {
        return manager.getModelClass().getDb().getModelClass(getMiddleModelName());
    }

    public Field getMiddleField() {
        return getMiddleClass().getManager().getField(getMiddleModelFieldName());
    }

    public ManyReferenceField getReverseField() {
        return (ManyReferenceField) super.getReverseField();
    }

    public Field getKeyField() {
        return manager.getField(getKeyFieldName());
    }

    public String getMiddleModelName() {
        return middleModelName != null ? middleModelName : String.format("%s_%s", manager.getName(), fieldName);
    }

    public void setMiddleModelName(String middleModelName) {
        this.middleModelName = middleModelName;
    }

    public String getMiddleModelFieldName() {
        return middleModelFieldName != null ? middleModelFieldName : manager.getName().toLowerCase();
    }

    public void setMiddleModelFieldName(String middleModelFieldName) {
        this.middleModelFieldName = middleModelFieldName;
    }

    public void setMiddleModelReferenceFieldName(String middleModelReferenceFieldName) {
        this.middleModelReferenceFieldName = middleModelReferenceFieldName;
    }

    public String getMiddleModelReferenceFieldName() {
        return middleModelReferenceFieldName;
    }

    public String getKeyFieldName() {
        return keyFieldName != null ? keyFieldName : manager.getPrimaryKey().getFieldName();
    }

    public void setKeyFieldName(String keyFieldName) {
        this.keyFieldName = keyFieldName;
    }

    public String getReverseFieldName() {
        return reverseFieldName != null ? reverseFieldName :String.format("%s_set", manager.getName().toLowerCase());
    }

    public void setReverseFieldName(String reverseFieldName) {
        this.reverseFieldName = reverseFieldName;
    }

    public String getReferenceKeyFieldName() {
        return referenceKeyFieldName;
    }

    public void setReferenceKeyFieldName(String referenceKeyFieldName) {
        this.referenceKeyFieldName = referenceKeyFieldName;
    }

    public String getMiddleModelTableName() {
        return middleModelTableName != null ? middleModelTableName : String.format("%s_%s", manager.getTableName(), fieldName);
    }

    public void setMiddleModelTableName(String middleModelTableName) {
        this.middleModelTableName = middleModelTableName;
    }
}
