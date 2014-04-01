package com.jengine.orm.model.multi;


import com.jengine.orm.db.query.SQLQuery;
import com.jengine.orm.model.ModelClassBase;
import com.jengine.orm.model.field.Field;
import com.jengine.orm.model.multi.field.MultiModelField;

import java.util.LinkedHashMap;
import java.util.List;

import static com.jengine.utils.CollectionUtil.toList;

public class MultiModelItem {
    private MultiModel multiModel;
    private ModelClassBase modelClass;
    private String name;
    private MultiModelField primaryKey = null;
    private LinkedHashMap<String, MultiModelField> fields = new LinkedHashMap<String, MultiModelField>();
    private LinkedHashMap<String, MultiModelField> modelFields = new LinkedHashMap<String, MultiModelField>();
    private SQLQuery.TableItem tableItem;

    public MultiModelItem(MultiModel multiModel, ModelClassBase modelClass, String name) {
        this.multiModel = multiModel;
        this.modelClass = modelClass;
        this.name = name;
        for(Field field: modelClass.getManager().getPersistenceFields()) {
            addField(field);
        }
        this.tableItem = new SQLQuery.TableItem(modelClass.getManager().getTableName(), name.replace(".", "_"));
    }

    public MultiModelField getMultiModelField(Field field) {
        return modelFields.get(field.getFieldName());
    }

    public MultiModelField addField(Field field) {
        MultiModelField multiModelField = new MultiModelField(this, field);
        fields.put(multiModelField.getName(), multiModelField);
        modelFields.put(field.getFieldName(), multiModelField);
        if (field.isPrimaryKey()) {
            primaryKey = multiModelField;
        }
        return multiModelField;
    }

    public void setName(String name) {
        this.name = name;
        this.tableItem = new SQLQuery.TableItem(modelClass.getManager().getTableName(), name.replace(".", "_"));
        fields.clear();
        for(Field field: modelClass.getManager().getPersistenceFields()) {
            addField(field);
        }
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
