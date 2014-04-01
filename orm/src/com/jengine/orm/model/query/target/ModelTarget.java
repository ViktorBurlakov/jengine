package com.jengine.orm.model.query.target;

import com.jengine.orm.db.DBException;
import com.jengine.orm.db.query.SQLQuery;
import com.jengine.orm.model.Model;
import com.jengine.orm.model.field.Field;
import com.jengine.orm.model.multi.MultiModelItem;
import com.jengine.orm.model.multi.field.FunctionMultiField;
import com.jengine.orm.model.multi.field.MultiModelField;

import java.util.Iterator;
import java.util.LinkedHashMap;


public class ModelTarget extends Target {
    protected MultiModelItem item;

    public ModelTarget(String name) {
        super(name);
    }

    public ModelTarget(MultiModelItem item) {
        this(item.getName(), item);
    }

    public ModelTarget(String name, MultiModelItem item) {
        super(name);
        this.item = item;
    }

    public String getSQLName() {
        return item.getName();
    }

    public Object processResult(Iterator itr) throws DBException {
       return processItem(itr, item);
    }

    public void setSQL(SQLQuery query) {
        for (MultiModelField field : item.getFieldList()) {
            if (field instanceof FunctionMultiField) {
                query.addTarget(field.toSQL(), field.getSQLName());
            } else {
                query.addTarget(field.toSQL());
            }
        }
    }

    protected Object processItem(Iterator itr, MultiModelItem item) throws DBException {
        LinkedHashMap<String, Object> values = new LinkedHashMap<String, Object>();
        for (MultiModelField field : item.getFieldList()) {
            values.put(field.getModelField().getFieldName(), field.cast(itr.next()));
        }
        Field pk = item.getPrimaryKey().getModelField();
        if (values.containsKey(pk.getFieldName()) && values.get(pk.getFieldName()) != null) {
            Model obj = item.getModelClass().newInstance();
            obj.setNew(false);
            obj.setData(values);
            obj.cache();

            return obj;
        } else {
            return null;
        }
    }

}
