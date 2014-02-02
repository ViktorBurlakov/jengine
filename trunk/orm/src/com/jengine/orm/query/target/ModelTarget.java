package com.jengine.orm.query.target;

import com.jengine.orm.model.Model;
import com.jengine.orm.db.DBException;
import com.jengine.orm.db.query.SQLQuery;
import com.jengine.orm.field.Field;
import com.jengine.orm.model.multi.MultiModelField;
import com.jengine.orm.model.multi.MultiModelItem;
import com.jengine.orm.query.ModelQuery;

import java.util.Iterator;
import java.util.LinkedHashMap;


public class ModelTarget extends Target {
    protected MultiModelItem item;

    public ModelTarget(ModelQuery modelQuery) {
        super(modelQuery);
    }

    public ModelTarget(ModelQuery modelQuery, MultiModelItem item) {
        super(modelQuery);
        this.item = item;
    }

    public Object processResult(Iterator itr) throws DBException {
       return processItem(itr, item);
    }

    public void setSQL(SQLQuery query) {
        for (MultiModelField field : item.getFieldList()) {
            query.addTarget(field.getSQLName());
        }
    }

    protected Object processItem(Iterator itr, MultiModelItem item) throws DBException {
        LinkedHashMap<String, Object> values = new LinkedHashMap<String, Object>();
        for (MultiModelField field : item.getFieldList()) {
            values.put(field.getModelField().getFieldName(), field.getModelField().cast(itr.next()));
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
