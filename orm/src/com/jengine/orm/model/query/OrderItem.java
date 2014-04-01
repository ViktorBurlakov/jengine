package com.jengine.orm.model.query;


import com.jengine.orm.db.query.SQLQuery;
import com.jengine.orm.model.multi.field.MultiModelField;
import com.jengine.utils.CollectionUtil;

public class OrderItem {
    private String orderType;
    private MultiModelField multiModelField;

    public OrderItem(MultiModelField multiModelField, String orderType) {
        this.multiModelField = multiModelField;
        this.orderType = orderType;
    }

    public OrderItem(MultiModelField multiModelField) {
        this.multiModelField = multiModelField;
    }

    public void setSQL(SQLQuery query) {
        query.setOrder(CollectionUtil.<String>map("orderByCol", this.multiModelField.getSQLName(), "orderByType", this.orderType));
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public MultiModelField getMultiModelField() {
        return multiModelField;
    }

    public void setMultiModelField(MultiModelField multiModelField) {
        this.multiModelField = multiModelField;
    }
}
