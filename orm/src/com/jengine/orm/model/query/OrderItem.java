/*
 *  This file is part of JEngine.
 *  *
 *  * Copyright (C) 2013-2014 Cetus (http://cs1.com.ua/). All rights reserved.
 *  *
 *  * JEngine is free software: you can redistribute it and/or modify
 *  * it under the terms of the GNU General Public License as published by
 *  * the Free Software Foundation, either version 3 of the License, or
 *  * (at your option) any later version.
 *  *
 *  * JEngine is distributed in the hope that it will be useful,
 *  * but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  * GNU General Public License for more details.
 *  *
 *  * You should have received a copy of the GNU General Public License
 *  * along with JEngine.  If not, see <http://www.gnu.org/licenses/>.
 */

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
