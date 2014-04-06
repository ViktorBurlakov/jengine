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

package com.jengine.orm.model.query.filter;


import com.jengine.orm.db.DBException;
import com.jengine.orm.db.filter.SQLFilter;
import com.jengine.orm.db.query.SQLQuery;
import com.jengine.orm.model.multi.field.MultiModelField;
import com.jengine.orm.model.query.BaseQuery;
import com.jengine.orm.model.query.ModelQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Filter {
    private BaseQuery query;
    private MultiModelField multiModelField;
    private String field;
    private String operation;
    private Object value;

    public Filter(String field, String operation, Object value) {
        this.field = field;
        this.operation = operation;
        this.value = value;
    }

    public void config(BaseQuery query) throws DBException {
        this.query = query;
        this.multiModelField = query.getMultiModel().getField(field);
        this.value = this.multiModelField.getModelField().cast(this.value);
    }

    public void setSQL(SQLQuery query) {
        Object value = this.value instanceof ModelQuery ? ((ModelQuery) this.value).toSQL() : this.value;
        query.filter(new SQLFilter(multiModelField.getSQLName(), operation, value));
    }

    static public List<Filter> parse(Map<String, Object> filter) {
        List<Filter> filters = new ArrayList<Filter>();

        for (String key : filter.keySet()) {
            String name = key.contains("__") ? key.split("__")[0] : key;
            String operation = key.contains("__") ? key.split("__")[1] : "eq";
            Object value = filter.get(key);
            filters.add(new Filter(name, operation, value));
        }

        return filters;
    }

}
