package com.jengine.orm.model.multi.field;


import com.jengine.orm.db.DBException;
import com.jengine.orm.model.field.Field;
import com.jengine.orm.model.multi.MultiModel;
import com.jengine.orm.model.multi.MultiModelItem;

public class MultiModelField {
    protected String name;
    protected Field modelField;
    protected MultiModelItem item;
    protected MultiModel multiModel;

    public MultiModelField() {
    }

    public MultiModelField(String name) {
        this.name = name;
    }

    public MultiModelField(MultiModelItem item, Field modelField) {
        this.name = String.format("%s.%s", item.getName(), modelField.getFieldName());
        this.modelField = modelField;
        this.item = item;
        this.multiModel = item.getMultiModel();
    }

    public MultiModelField(String name, MultiModelItem item, Field modelField) {
        this.name = name;
        this.modelField = modelField;
        this.item = item;
        this.multiModel = item.getMultiModel();
    }

    public MultiModelField(String name, Field modelField) {
        this.name = name;
        this.modelField = modelField;
    }

    public void config(MultiModelItem item) {
        this.item = item;
        this.multiModel = item.getMultiModel();
    }

    public String getSQLName() {
        return item != null ? String.format("%s.%s", item.getTableItem().getName(), modelField.getColumnName()) :
                modelField.getColumnName();
    }

    public Object cast(Object value) throws DBException {
        return modelField.cast(value);
    }

    public String toSQL() {
        return getSQLName();
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
