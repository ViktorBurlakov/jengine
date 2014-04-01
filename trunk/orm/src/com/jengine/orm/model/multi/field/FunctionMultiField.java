package com.jengine.orm.model.multi.field;

import com.jengine.orm.model.field.FunctionField;
import com.jengine.orm.model.multi.MultiModel;
import com.jengine.orm.model.multi.MultiModelItem;

import java.util.ArrayList;
import java.util.List;

public class FunctionMultiField extends MultiModelField{
    private List<String> fields = new ArrayList<String>();
    private List<String> columns = new ArrayList<String>();

    public FunctionMultiField(MultiModelItem item, FunctionField modelField, List<String> fields) {
        super(item, modelField);
        this.fields = fields;
    }

    public FunctionMultiField(String name, MultiModelItem item, FunctionField modelField, List<String> fields) {
        super(name, item, modelField);
        this.fields = fields;
    }

    public FunctionMultiField(String name, FunctionField modelField, List<String> fields) {
        super(name, modelField);
        this.fields = fields;
    }

    public void config(MultiModel multiModel) {
        super.config(multiModel);
        for (String field : fields) {
            columns.add(multiModel.getFields().get(field).getSQLName());
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
