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
        SQLQuery.TableItem tableItem = new SQLQuery.TableItem(model.getManager().getTableName());
        table = new SQLQuery.Table(tableItem);
        add(new MultiModelItem(this, model, model.getName(), tableItem.getName()));
    }

    public MultiModel(ModelClassBase model, String name) {
        SQLQuery.TableItem tableItem = new SQLQuery.TableItem(model.getManager().getTableName(), name);
        table = new SQLQuery.Table(tableItem);
        add(new MultiModelItem(this, model, name, tableItem.getName()));
    }

    /* model operations */

    public MultiModel join(ModelClassBase model, String name, String reference, String key) {
        String restriction = makeRestriction(reference, key);
        SQLQuery.TableItem tableItem = new SQLQuery.TableItem(model.getManager().getTableName(), name, restriction);
        table.join(tableItem);
        add(new MultiModelItem(this, model, name, tableItem.getName()));
        return this;
    }

    public MultiModel ljoin(ModelClassBase model, String name, String reference, String key) {
        String restriction = makeRestriction(reference, key);
        SQLQuery.TableItem tableItem = new SQLQuery.TableItem(model.getManager().getTableName(), name, restriction);
        table.ljoin(tableItem);
        add(new MultiModelItem(this, model, name, tableItem.getName()));
        return this;
    }

    public MultiModel rjoin(ModelClassBase model, String name, String reference, String key) {
        String restriction = makeRestriction(reference, key);
        SQLQuery.TableItem tableItem = new SQLQuery.TableItem(model.getManager().getTableName(), name, restriction);
        table.rjoin(tableItem);
        add(new MultiModelItem(this, model, name, tableItem.getName()));
        return this;
    }

    public MultiModel and(ModelClassBase model, String name, String reference, String key) {
        String restriction = makeRestriction(reference, key);
        SQLQuery.TableItem tableItem = new SQLQuery.TableItem(model.getManager().getTableName(), name, restriction);
        table.and(tableItem);
        add(new MultiModelItem(this, model, name, tableItem.getName()));
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
