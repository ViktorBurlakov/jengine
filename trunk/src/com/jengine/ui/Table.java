/*
 * This file is part of JEngine.
 *
 * Copyright (C) 2013 Victor Burlakov
 *
 * JEngine is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JEngine is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with JEngine.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.jengine.ui;


import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.jengine.utils.CollectionUtil.map;


public class Table extends GridWidget {
    private String orderByCol;
    private String orderByType = "asc";

    public Table(String name, String title, PortletRequest request) {
        this(name, title, null, request);
    }

    public Table(String name, String title, Widget parent, PortletRequest request) {
        super(name, title, parent, request);
    }

    public void init(List<Map<String, Object>> fields, String orderByCol, String orderByType) {
        this.init(fields);
        this.orderByCol = ParamUtil.getString(getRequest(), "orderByCol", orderByCol);
        this.orderByType = ParamUtil.getString(getRequest(), "orderByType", orderByType);
    }

    public String getOrderByCol() {
        return orderByCol;
    }

    public void setOrderByCol(String orderByCol) {
        this.orderByCol = orderByCol;
    }

    public String getOrderByType() {
        return orderByType;
    }

    public void setOrderByType(String orderByType) {
        this.orderByType = orderByType;
    }

    public Map getOrderMap() {
        return Validator.isNotNull(orderByCol) && Validator.isNotNull(orderByType) ?
                map("orderByCol", orderByCol, "orderByType", orderByType) : null;
    }
}
