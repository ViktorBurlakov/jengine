package com.jengine.orm.field;


import java.util.HashMap;
import java.util.Map;

public class ManyReferenceField extends Field {
    private String keyFieldName;
    private String referenceModelName;
    private String referenceFieldName;
    private String referenceKeyFieldName;
    private String middleModelName;
    private String middleModelTableName;
    private String middleModelFieldName;
    private String middleModelReferenceFieldName;

    public ManyReferenceField(Class fieldClass) {
        this(fieldClass, new HashMap<String, Object>());
    }

    public ManyReferenceField(Class fieldClass, Map<String, Object> options) {
        this(fieldClass.getSimpleName(), options);
    }

    public ManyReferenceField(String referenceModelName, Map<String, Object> options) {
        super(null, options);
        this.referenceModelName = referenceModelName;
        if (options.containsKey("keyFieldName")) {
            keyFieldName = (String) options.get("keyFieldName");
        }
        if (options.containsKey("referenceFieldName")) {
            referenceFieldName = (String) options.get("referenceFieldName");
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

    public Type getType() {
        return Type.MANY_REFERENCE;
    }

    public String getReferenceModelName() {
        return referenceModelName;
    }

    public void setReferenceModelName(String referenceModelName) {
        this.referenceModelName = referenceModelName;
    }

    public String getMiddleModelName() {
        return middleModelName;
    }

    public void setMiddleModelName(String middleModelName) {
        this.middleModelName = middleModelName;
    }

    public String getMiddleModelFieldName() {
        return middleModelFieldName;
    }

    public void setMiddleModelFieldName(String middleModelFieldName) {
        this.middleModelFieldName = middleModelFieldName;
    }

    public String getMiddleModelReferenceFieldName() {
        return middleModelReferenceFieldName;
    }

    public void setMiddleModelReferenceFieldName(String middleModelReferenceFieldName) {
        this.middleModelReferenceFieldName = middleModelReferenceFieldName;
    }

    public String getKeyFieldName() {
        return keyFieldName;
    }

    public void setKeyFieldName(String keyFieldName) {
        this.keyFieldName = keyFieldName;
    }

    public String getReferenceFieldName() {
        return referenceFieldName;
    }

    public void setReferenceFieldName(String referenceFieldName) {
        this.referenceFieldName = referenceFieldName;
    }

    public String getReferenceKeyFieldName() {
        return referenceKeyFieldName;
    }

    public void setReferenceKeyFieldName(String referenceKeyFieldName) {
        this.referenceKeyFieldName = referenceKeyFieldName;
    }

    public String getMiddleModelTableName() {
        return middleModelTableName;
    }

    public void setMiddleModelTableName(String middleModelTableName) {
        this.middleModelTableName = middleModelTableName;
    }
}
