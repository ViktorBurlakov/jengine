package com.jengine.orm.multi;


import com.jengine.orm.ModelClassBase;
import com.jengine.orm.db.query.SQLQuery;

import java.util.LinkedHashMap;
import java.util.List;

import static com.jengine.utils.CollectionUtil.toList;

public class MultiModel {
    private LinkedHashMap<String, MultiModelItem> items = new LinkedHashMap<String, MultiModelItem>();
    private LinkedHashMap<String, MultiModelField> fields = new LinkedHashMap<String, MultiModelField>();
    private SQLQuery.Table table;


    public MultiModel(ModelClassBase model) {
        MultiModelItem item = add(new MultiModelItem(this, model, model.getName()));
        item.setTableItem(new SQLQuery.TableItem(model.getManager().getTableName()));
        table = new SQLQuery.Table(item.getTableItem());
    }

    public MultiModel(ModelClassBase model, String name) {
        MultiModelItem item = add(new MultiModelItem(this, model, name));
        item.setTableItem(new SQLQuery.TableItem(model.getManager().getTableName(), name.replace(".", "_")));
        table = new SQLQuery.Table(item.getTableItem());
    }

    /* model operations */

    public MultiModel join(ModelClassBase model, String name, String reference, String key) {
        MultiModelItem item = add(new MultiModelItem(this, model, name));
        SQLQuery.TableItem tableItem = new SQLQuery.TableItem(model.getManager().getTableName(), name.replace(".", "_"));
        item.setTableItem(tableItem);
        tableItem.setRestriction(makeRestriction(reference, key));
        table.join(item.getTableItem());
        return this;
    }

    public MultiModel ljoin(ModelClassBase model, String name, String reference, String key) {
        MultiModelItem item = add(new MultiModelItem(this, model, name));
        SQLQuery.TableItem tableItem = new SQLQuery.TableItem(model.getManager().getTableName(), name.replace(".", "_"));
        item.setTableItem(tableItem);
        tableItem.setRestriction(makeRestriction(reference, key));
        table.ljoin(item.getTableItem());
        return this;
    }

    public MultiModel rjoin(ModelClassBase model, String name, String reference, String key) {
        MultiModelItem item = add(new MultiModelItem(this, model, name));
        SQLQuery.TableItem tableItem = new SQLQuery.TableItem(model.getManager().getTableName(), name.replace(".", "_"));
        item.setTableItem(tableItem);
        tableItem.setRestriction(makeRestriction(reference, key));
        table.ljoin(item.getTableItem());
        return this;
    }

    public MultiModel and(ModelClassBase model, String name, String reference, String key) {
        MultiModelItem item = add(new MultiModelItem(this, model, name));
        SQLQuery.TableItem tableItem = new SQLQuery.TableItem(model.getManager().getTableName(), name.replace(".", "_"));
        item.setTableItem(tableItem);
        tableItem.setRestriction(makeRestriction(reference, key));
        table.and(item.getTableItem());
        return this;
    }

    protected MultiModelItem add(MultiModelItem item) {
        items.put(item.getName(), item);
        fields.putAll(item.getFields());
        return item;
    }

    protected String makeRestriction(String reference, String key) {
        return String.format("%s = %s", fields.get(reference).getSQLName(), fields.get(key).getSQLName());
    }

    /* getters and setters */


    public SQLQuery.Table getTable() {
        return table;
    }

    public List<MultiModelItem> getItemList() {
        return toList(items.values());
    }

    public LinkedHashMap<String, MultiModelItem> getItems() {
        return items;
    }

    public LinkedHashMap<String, MultiModelField> getFields() {
        return fields;
    }
}
