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

package com.cetus.jengine.orm.core.model.query;


import com.cetus.jengine.orm.core.db.DBException;
import com.cetus.jengine.orm.core.db.query.parser.SQLCommonAST;
import com.cetus.jengine.orm.core.model.multi.MultiModel;
import com.cetus.jengine.orm.core.model.multi.field.CalcMultiField;
import com.cetus.jengine.orm.core.model.multi.field.MultiModelField;
import com.cetus.jengine.orm.core.model.query.filter.Filter;
import com.cetus.jengine.orm.core.model.query.filter.StringFilter;
import com.cetus.jengine.orm.core.model.query.target.FieldTarget;
import com.cetus.jengine.orm.core.model.query.target.Target;
import com.cetus.jengine.utils.commons.CollectionUtil;

import java.util.*;

import static com.cetus.jengine.utils.commons.CollectionUtil.map;
import static com.cetus.jengine.utils.commons.CollectionUtil.toList;

public abstract class BaseQuery {
    protected LinkedHashMap<String, Target> targets = new LinkedHashMap<String, Target>();
    protected Target defaultTarget;
    protected MultiModel multiModel;
    protected List<Filter> filters = new ArrayList<Filter>();
    protected List<StringFilter> stringFilters = new ArrayList<StringFilter>();
    protected List<OrderItem> orderList = new ArrayList<OrderItem>();
    protected Map<String, Integer> page = map("start", null, "end", null);
    protected Map<String, Object> values = new LinkedHashMap<String, Object>();
    protected LinkedHashMap<String, MultiModelField> group = new LinkedHashMap<String, MultiModelField>();
    protected Boolean distinct = false;

    public BaseQuery() {
    }

    protected BaseQuery(MultiModel multiModel) {
        this.multiModel = multiModel;
    }

    /* target methods */

    public BaseQuery distinct() {
        this.distinct = true;
        return this;
    }

    public BaseQuery distinct(Object ... fields) {
        this.distinct = true;
        this.targets(fields);
        return this;
    }

    public BaseQuery distinct(List fields) {
        this.distinct = true;
        this.targets(fields);
        return this;
    }

    public BaseQuery distinct(Object field) {
        this.distinct = true;
        this.target(field);
        return this;
    }

    public BaseQuery target(Object field) {
        if (field instanceof CalcMultiField)  {
            return target((CalcMultiField) field);
        }  else {
            MultiModelField multiModelField = multiModel.getField((String) field);
            Target target = new FieldTarget((String) field, multiModelField);
            target.config(this);
            this.targets.put(target.getName(), target);
        }

        return this;
    }

    protected BaseQuery target(CalcMultiField field) {
        multiModel.addCalcField(field);
        Target target = new FieldTarget(field);
        target.config(this);
        targets.put(field.getName(), target);
        return this;
    }

    public BaseQuery targets(Object ... fields) {
        for(Object field : fields) {
            this.target(field);
        }
        return this;
    }

    public BaseQuery targets(List fields) {
        for(Object field : fields) {
            this.target(field);
        }

        return this;
    }


    /* filter methods */

    public BaseQuery filter(String query, Object ... params) throws DBException {
        try {
            StringFilter stringFilter = new StringFilter(query, params);
            stringFilter.config(this);
            this.stringFilters.add(stringFilter);
        } catch (Exception e) {
            throw new DBException(e);
        }

        return this;
    }

    public BaseQuery filter(Map<String, Object> filter) throws DBException {
        return filter(Filter.parse(filter));
    }

    public BaseQuery filter(List<Filter> filters) throws DBException {
        for (Filter filter : filters) {
            filter.config(this);
            this.filters.add(filter);
        }

        return this;
    }

    public BaseQuery filter(Filter ... filter) throws DBException {
        return this.filter(Arrays.asList(filter));
    }

    public BaseQuery sfilter(StringFilter ... filter) throws DBException {
        return sfilter(toList(filter));
    }

    public BaseQuery sfilter(List<StringFilter> filters) throws DBException {
        for (StringFilter filter : filters) {
            try {
                filter.config(this);
                this.stringFilters.add(filter);
            } catch (Exception e) {
                throw new DBException(e);
            }
        }
        this.stringFilters.addAll(filters);
        return this;
    }


    /* order methods */

    public BaseQuery order(Map<String, String> order) {
        if (order != null && order.size() > 0 && order.containsKey("field")) {
            return order(order.get("field"), order.get("orderType"));
        }

        return this;
    }

    public BaseQuery order(String field) {
        return order(field, null);
    }

    public BaseQuery order(String field, String orderType) {
        MultiModelField multiModelField = multiModel.getField(field);
        orderList.add(new OrderItem(multiModelField, orderType));
        return this;
    }

    /* group by methods */

    public BaseQuery group(String fieldName) {
        group.put(fieldName, multiModel.getField(fieldName));
        return this;
    }

    public BaseQuery group(List<String> fields) {
        for (String fieldName : fields) {
            this.group(fieldName);
        }
        return this;
    }

    public BaseQuery group(String ... fields) {
        for (String fieldName : fields) {
            this.group(fieldName);
        }
        return this;
    }

    /* value methods */

    public BaseQuery values(Map<String, Object> values) throws DBException {
        if (values != null && values.size() > 0) {
            for (String name : values.keySet()) {
                value(name, values.get(name));
            }
        }

        return this;
    }

    public BaseQuery value(String name, Object value) throws DBException {
        MultiModelField multiModelField = multiModel.getField(name);
        this.values.put(multiModelField.getName(), value);
        return this;
    }

    /* page methods */

    public BaseQuery page(Map<String, Object> page) {
        if (page != null) {
            this.page.put("start", page.containsKey("start") ? (Integer) page.get("start") : null);
            this.page.put("end", page.containsKey("end") ? (Integer) page.get("end") : null);
        }

        return this;
    }

    public BaseQuery page(Integer start, Integer end) {
        this.page.put("start", start);
        this.page.put("end", end);
        return this;
    }


    /* exec query methods */

    public <T extends Object> T one() throws DBException {
        List values = list();
        return values.size() > 0 ? (T) values.get(0) : null;
    }

//    public long count() throws DBException {
//        return this.target(new Count(this.manager.getModelClass())).<Long>one();
//    }

    abstract public <T extends Object> List<T> list() throws DBException;

    abstract public void update() throws DBException;

    abstract public void remove() throws DBException;

    protected List processResult(List values) throws DBException {
        List result = new ArrayList();
        List<Target> targets = this.targets.size() > 0 ? toList(this.targets.values()) : CollectionUtil.list(defaultTarget);

        for (Object value : values) {
            if (value != null) {
                Object[] items = value.getClass().isArray() ? (Object[]) value : new Object[]{value};
                List resultItem = new ArrayList();
                Iterator itemIterator =  Arrays.asList(items).iterator();
                for (Target target : targets) {
                    resultItem.add(target.processResult(itemIterator));
                }
                result.add(resultItem.size() == 1 ? resultItem.get(0) : resultItem);
            } else {
                result.add(null);
            }
        }

        return result;
    }

    public MultiModel getMultiModel() {
        return multiModel;
    }

}
