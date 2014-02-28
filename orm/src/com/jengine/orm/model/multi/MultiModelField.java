package com.jengine.orm.model.multi;


import com.jengine.orm.model.field.Field;

public class MultiModelField {
    private String name;
    private String sqlName;
    private Field modelField;
    private MultiModelItem item;

    public MultiModelField(MultiModelItem item, Field modelField) {
        this.name = String.format("%s.%s", item.getName(), modelField.getFieldName());
        this.modelField = modelField;
        this.item = item;
    }

    public MultiModelField(String name, MultiModelItem item, Field modelField) {
        this.name = name;
        this.modelField = modelField;
        this.item = item;
    }

    public MultiModelField(String name, Field modelField) {
        this.name = name;
        this.modelField = modelField;
    }

    public String getSQLName() {
        return item != null ? String.format("%s.%s", item.getTableItem().getName(), modelField.getColumnName()) :
                modelField.getColumnName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Field getModelField() {
        return modelField;
    }

    public void setModelField(Field modelField) {
        this.modelField = modelField;
    }

    public MultiModelItem getItem() {
        return item;
    }

    public void setItem(MultiModelItem item) {
        this.item = item;
    }
}
