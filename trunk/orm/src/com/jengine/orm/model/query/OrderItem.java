package com.jengine.orm.model.query;


import com.jengine.orm.db.query.SQLQuery;
import com.jengine.orm.model.field.Field;
import com.jengine.orm.model.field.ForeignField;
import com.jengine.orm.model.multi.MultiModelField;
import com.jengine.utils.CollectionUtil;

import java.util.Map;

public class OrderItem {
    private String name;
    private String orderType;
    private Field modelField;
    private MultiModelField multiModelField;
    private ModelQuery modelQuery;

    public OrderItem(Map<String, String> order) {
        this(order.get("field"), order.get("orderType"));
    }

    public OrderItem(String name, String orderType) {
        this.name = name;
        this.orderType = orderType;
    }

    public void config(ModelQuery modelQuery) {
        this.modelQuery = modelQuery;
        this.modelField = modelQuery.getManager().getField(this.name);
        if (this.modelField instanceof ForeignField) {
            modelQuery.addPath(((ForeignField) this.modelField).getReferencePath());
        }
        this.multiModelField = modelQuery.getMultiModelField(this.modelField);
    }

    public void setSQL(SQLQuery query) {
        query.setOrder(CollectionUtil.<String>map("orderByCol", this.multiModelField.getSQLName(), "orderByType", this.orderType));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public Field getModelField() {
        return modelField;
    }

    public void setModelField(Field modelField) {
        this.modelField = modelField;
    }
}
