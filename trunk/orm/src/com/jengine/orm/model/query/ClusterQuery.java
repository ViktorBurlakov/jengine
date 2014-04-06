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


import com.jengine.orm.db.DBException;
import com.jengine.orm.db.query.SQLQuery;
import com.jengine.orm.model.cluster.Cluster;
import com.jengine.orm.model.multi.field.MultiModelField;
import com.jengine.orm.model.query.filter.Filter;
import com.jengine.orm.model.query.filter.StringFilter;
import com.jengine.orm.model.query.target.Target;

import java.util.List;
import java.util.Map;

public class ClusterQuery extends BaseQuery {

    public ClusterQuery(Cluster cluster) {
        super(cluster);
    }

    public ClusterQuery target(String field) {
        return (ClusterQuery) super.target((String) field);
    }

    public ClusterQuery distinct() {
        return (ClusterQuery) super.distinct();
    }

    public ClusterQuery distinct(Object... fields) {
        return (ClusterQuery) super.distinct(fields);
    }

    public ClusterQuery distinct(List fields) {
        return (ClusterQuery) super.distinct(fields);
    }

    public ClusterQuery distinct(Object field) {
        return (ClusterQuery) super.distinct(field);
    }

    public ClusterQuery target(Object field) {
        return (ClusterQuery) super.target(field);
    }

    public ClusterQuery targets(Object... fields) {
        return (ClusterQuery) super.targets(fields);
    }

    public ClusterQuery targets(List fields) {
        return (ClusterQuery) super.targets(fields);
    }

    public ClusterQuery filter(String query, Object... params) throws DBException {
        return (ClusterQuery) super.filter(query, params);
    }

    public ClusterQuery filter(Map<String, Object> filter) throws DBException {
        return (ClusterQuery) super.filter(filter);
    }

    public ClusterQuery filter(List<Filter> filters) throws DBException {
        return (ClusterQuery) super.filter(filters);
    }

    public ClusterQuery filter(Filter... filter) throws DBException {
        return (ClusterQuery) super.filter(filter);
    }

    public ClusterQuery sfilter(StringFilter... filter) throws DBException {
        return (ClusterQuery) super.sfilter(filter);
    }

    public ClusterQuery sfilter(List<StringFilter> filters) throws DBException {
        return (ClusterQuery) super.sfilter(filters);
    }

    public ClusterQuery order(Map<String, String> order) {
        return (ClusterQuery) super.order(order);
    }

    public ClusterQuery order(String field) {
        return (ClusterQuery) super.order(field);
    }

    public ClusterQuery order(String field, String orderType) {
        return (ClusterQuery) super.order(field, orderType);
    }

    public ClusterQuery group(String fieldName) {
        return (ClusterQuery) super.group(fieldName);
    }

    public ClusterQuery group(List<String> fields) {
        return (ClusterQuery) super.group(fields);
    }

    public ClusterQuery group(String... fields) {
        return (ClusterQuery) super.group(fields);
    }

    public ClusterQuery values(Map<String, Object> values) throws DBException {
        return (ClusterQuery) super.values(values);
    }

    public ClusterQuery value(String name, Object value) throws DBException {
        return (ClusterQuery) super.value(name, value);
    }

    public ClusterQuery page(Map<String, Object> page) {
        return (ClusterQuery) super.page(page);
    }

    public ClusterQuery page(Integer start, Integer end) {
        return (ClusterQuery) super.page(start, end);
    }

    public <T extends Object> List<T> list() throws DBException {
        SQLQuery sqlQuery = toSQL();
        List result = multiModel.getDB().getProvider().select(sqlQuery);
        return processResult(result);
    }

    public SQLQuery toSQL() {
        SQLQuery query = new SQLQuery(multiModel.getMultiTable());

        for (Target target : targets.values()) {
            target.setSQL(query);
        }
        query.setDistinct(distinct);
        for (Filter filter : filters) {
            filter.setSQL(query);
        }
        for (StringFilter stringFilter : stringFilters) {
            stringFilter.setSQL(query);
        }
        for (MultiModelField field : group.values()) {
            query.group(field.getSQLName());
        }
        for (OrderItem orderItem : orderList) {
            orderItem.setSQL(query);
        }
        for (String fieldName : values.keySet()) {
            MultiModelField field = multiModel.getFields().get(fieldName);
            query.addValue(field.getSQLName(), values.get(fieldName));
        }
        if (page.get("start") != null && page.get("end") != null) {
            query.setStart(page.get("start"));
            query.setEnd(page.get("end"));
            query.addParam(page.get("start"));
            query.addParam(page.get("end"));
        }

        return query;
    }

    public void update() throws DBException {
    }

    public void remove() throws DBException {
    }
}
