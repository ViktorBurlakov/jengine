package com.jengine.orm.model.multi;


import com.jengine.orm.model.ModelClassBase;
import com.jengine.orm.db.query.SQLQuery;
import com.jengine.orm.field.Field;

import java.util.LinkedHashMap;
import java.util.List;

import static com.jengine.utils.CollectionUtil.toList;

public class MultiModelItem {
    private MultiModel multiModel;
    private ModelClassBase modelClass;
    private String name;
    private SQLQuery.TableItem tableItem;
    private MultiModelField primaryKey = null;
    private LinkedHashMap<String, MultiModelField> fields = new LinkedHashMap<String, MultiModelField>();

    public MultiModelItem(MultiModel multiModel, ModelClassBase modelClass, String name) {
        this.multiModel = multiModel;
        this.modelClass = modelClass;
        this.name = name;
        for(Field field: modelClass.getManager().getPersistenceFields()) {
            MultiModelField multiModelField = new MultiModelField(this, field);
            fields.put(multiModelField.getName(), multiModelField);
            if (field.isPrimaryKey()) {
                primaryKey = multiModelField;
            }
        }
    }

    public void setTableItem(SQLQuery.TableItem tableItem) {
        this.tableItem = tableItem;
    }

    public SQLQuery.TableItem getTableItem() {
        return tableItem;
    }

    public MultiModel getMultiModel() {
        return multiModel;
    }

    public String getName() {
        return name;
    }

    public MultiModelField getPrimaryKey() {
        return primaryKey;
    }

    public ModelClassBase getModelClass() {
        return modelClass;
    }

    public List<MultiModelField> getFieldList() {
        return toList(fields.values());
    }

    public LinkedHashMap<String, MultiModelField> getFields() {
        return fields;
    }
}
