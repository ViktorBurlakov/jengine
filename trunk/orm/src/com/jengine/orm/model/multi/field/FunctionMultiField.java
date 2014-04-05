package com.jengine.orm.model.multi.field;

import com.jengine.orm.model.field.Field;
import com.jengine.orm.model.field.FunctionField;
import com.jengine.orm.model.multi.MultiModelItem;

import java.util.ArrayList;
import java.util.List;

public class FunctionMultiField extends MultiModelField{
    protected List<String> fields = new ArrayList<String>();
    protected List<String> columns = new ArrayList<String>();

    public FunctionMultiField(MultiModelItem item, FunctionField modelField) {
        super(item, modelField);
    }

    public FunctionMultiField(String name, MultiModelItem item, FunctionField modelField) {
        super(name, item, modelField);
    }

    public FunctionMultiField(String name, FunctionField modelField) {
        super(name, modelField);
    }

    public void config(MultiModelItem item) {
        super.config(item);
        FunctionField functionField = (FunctionField) modelField;
        for (Object attribute: functionField.getAttributes()) {
            String fieldName = attribute instanceof String ? (String) attribute : ((Field) attribute).getFieldName();
            MultiModelField attributeMultiField = multiModel.getRelatedField(item, fieldName);
            this.fields.add(attributeMultiField.getName());
            this.columns.add(attributeMultiField.getSQLName());
        }
    }

    public FunctionField getModelField() {
        return (FunctionField) modelField;
    }

    public String getSQLName() {
        return item != null ? String.format("%s_%s", item.getTableItem().getName(), modelField.getColumnName()) :
                modelField.getColumnName();
    }

    public String toSQL() {
        return String.format(getModelField().getExpression(), columns.toArray());
    }
}
