package com.jengine.orm.field.reference;


import com.jengine.orm.Model;
import com.jengine.orm.ModelClassBase;
import com.jengine.orm.ModelManager;
import com.jengine.orm.db.DBException;
import com.jengine.orm.field.Field;
import com.jengine.utils.Variant;

import java.util.*;

import static com.jengine.utils.CollectionUtil.map;

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
        super(fieldClass, options);
    }

    public ManyReferenceField(Class fieldClass, String referenceModelName, Map<String, Object> options) {
        super(fieldClass, referenceModelName, options);
    }

    public void config(String fieldName, ModelManager manager) {
        super.config(fieldName, manager);
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

    public ReverseManyReferenceField newReverseField(){
        return new ReverseManyReferenceField(manager.getModelClass(), manager.getName(), map(
                "keyFieldName", referenceKeyFieldName,
                "reverseFieldName", fieldName,
                "referenceKeyFieldName", getKeyFieldName(),
                "middleModelName", getMiddleModelName(),
                "middleModelTableName", getMiddleModelTableName(),
                "middleModelFieldName", middleModelReferenceFieldName,
                "middleModelReferenceFieldName", getMiddleModelFieldName()
        ));
    }

    public ModelClassBase getMiddleClass() {
        return manager.getCls().getModelClass(getMiddleModelName());
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
