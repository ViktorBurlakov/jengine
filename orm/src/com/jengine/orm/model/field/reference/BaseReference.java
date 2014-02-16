package com.jengine.orm.model.field.reference;


import com.jengine.orm.model.ModelClassBase;
import com.jengine.orm.model.ModelManager;
import com.jengine.orm.model.field.Field;

import java.util.HashMap;
import java.util.Map;

import static com.jengine.utils.CollectionUtil.map;

abstract public class BaseReference extends Field {
    protected String referenceModelName;
    protected String reverseFieldName;

    public BaseReference(Class fieldClass) {
        this(fieldClass, new HashMap<String, Object>());
    }

    public BaseReference(Class fieldClass, Object... options) {
        this(fieldClass, map(options));
    }

    public BaseReference(Class fieldClass, Map<String, Object> options) {
        this(fieldClass, fieldClass.getSimpleName(),  options);
    }

    public BaseReference(Class fieldClass, String referenceModelName, Map<String, Object> options) {
        super(fieldClass, options);
        this.referenceModelName = referenceModelName;
    }

    public void config(String fieldName, ModelManager manager) {
        super.config(fieldName, manager);
        if (options.containsKey("reverseFieldName")) {
            this.reverseFieldName = (String) options.get("reverseFieldName");
        }
    }

    public Field newReverseField() {
        return null;
    }

    public boolean isKey() {
        return true;
    }

    public boolean isPersistence() {
        return false;
    }

    public ModelClassBase getReferenceClass() {
        return manager.getModelClass().getDb().getModelClass(referenceModelName);
    }

    public Field getReverseField() {
        return getReferenceClass().getManager().getField(getReverseFieldName());
    }

    public String getReverseFieldName() {
        return reverseFieldName;
    }

    public void setReverseFieldName(String reverseFieldName) {
        this.reverseFieldName = reverseFieldName;
    }

    public String getReferenceModelName() {
        return referenceModelName;
    }

    public void setReferenceModelName(String referenceModelName) {
        this.referenceModelName = referenceModelName;
    }
}
