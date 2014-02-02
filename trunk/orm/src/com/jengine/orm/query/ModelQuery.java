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

package com.jengine.orm.query;


import com.jengine.orm.model.ModelClassBase;
import com.jengine.orm.model.ModelManager;
import com.jengine.orm.db.DBException;
import com.jengine.orm.db.query.SQLQuery;
import com.jengine.orm.field.Field;
import com.jengine.orm.field.ForeignField;
import com.jengine.orm.field.FunctionField;
import com.jengine.orm.field.reference.ReferenceField;
import com.jengine.orm.model.multi.MultiModel;
import com.jengine.orm.model.multi.MultiModelField;
import com.jengine.orm.model.multi.MultiModelItem;
import com.jengine.orm.query.filter.Filter;
import com.jengine.orm.query.filter.StringFilter;
import com.jengine.orm.query.target.*;
import com.jengine.utils.CollectionUtil;

import java.util.*;

import static com.jengine.utils.CollectionUtil.concat;
import static com.jengine.utils.CollectionUtil.map;

public class ModelQuery {
    private List<Target> targets = new ArrayList<Target>();
    private Target defaultTarget;
    private MultiModel multiModel;
    private List<Filter> filters = new ArrayList<Filter>();
    private List<StringFilter> stringFilters = new ArrayList<StringFilter>();
    private List<OrderItem> orderList = new ArrayList<OrderItem>();
    private Map<String, Integer> page = map("start", null, "end", null);
    private Map<String, Object> values = new LinkedHashMap<String, Object>();
    private ModelManager manager = null;

    public ModelQuery(ModelManager manager) {
        this.manager = manager;
        this.multiModel = new MultiModel(manager.getModelClass());
        this.defaultTarget = new ModelTarget(this, multiModel.getItemList().get(0));
    }

    public MultiModelField getMultiModelField(Field modelField) {
        return  modelField instanceof ForeignField ?
            multiModel.getFields().get(modelField.getFieldName()) :
            multiModel.getItems().get(manager.getModelClass().getName())
                    .getFields().get(manager.getModelClass().getName() + "." + modelField.getFieldName());
    }

    public void addPath(List<String> path) {
        List<String> currentPath = new ArrayList<String>();
        MultiModelItem currentItem = this.multiModel.getItemList().get(0);
        ReferenceField currentField;

        for (String fieldName : path) {
            currentField = (ReferenceField) currentItem.getModelClass().getManager().getField(fieldName);
            ModelClassBase referenceClass = currentField.getReferenceClass();
            currentPath.add(fieldName);
            String referenceItemName = concat(currentPath, ".").toString();
            if (!this.multiModel.getItems().containsKey(referenceItemName)) {
                this.multiModel.ljoin(referenceClass, referenceItemName,
                        String.format("%s.%s", referenceItemName, currentField.getReferenceModelKey().getFieldName()),
                        String.format("%s.%s", currentItem.getName(), fieldName));
            }
            currentItem = this.multiModel.getItems().get(referenceItemName);
        }
    }

    /* field methods */

    public ModelQuery field(Object field) {
        if (String.class.equals(field.getClass())) {
            this.field((String) field);
        } else  {
            this.field((Field) field);
        }

        return this;
    }

    public ModelQuery field(String field) {
        return this.field(manager.getField(field));
    }

    public ModelQuery field(Field field) {
        if (field instanceof ForeignField) {
            field((ForeignField) field);
        } else if (field instanceof FunctionField) {
            field((FunctionField) field);
        } else {
            this.targets.add(new FieldTarget(this, getMultiModelField(field)));
        }

        return this;
    }

    public ModelQuery field(ForeignField field) {
        this.targets.add(new ForeignTarget(this, field));
        return this;
    }

    public ModelQuery field(FunctionField field) {
        this.targets.add(new FunctionTarget(this, field));
        return this;
    }

    public ModelQuery fields(Object ... fields) {
        for(Object field : fields) {
            this.field(field);
        }
        return this;
    }

    public ModelQuery fields(List fields) {
        for(Object field : fields) {
            this.field(field);
        }

        return this;
    }


    /* filter methods */

    public ModelQuery filter(String query, Object ... params) throws DBException {
        try {
            StringFilter stringFilter = new StringFilter(query, params);
            stringFilter.config(this);
            this.stringFilters.add(stringFilter);
        } catch (Exception e) {
            throw new DBException(e);
        }

        return this;
    }

    public ModelQuery filter(Map<String, Object> filter) throws DBException {
        return filter(Filter.parse(filter));
    }

    public ModelQuery filter(List<Filter> filters) throws DBException {
        for (Filter filter : filters) {
            filter.config(this);
            this.filters.add(filter);
        }

        return this;
    }

    public ModelQuery filter(Filter ... filter) throws DBException {
        return this.filter(Arrays.asList(filter));
    }


    /* order methods */

    public ModelQuery order(Map<String, String> order) {
        if (order != null && order.size() > 0 && order.containsKey("field")) {
            OrderItem orderItem = new OrderItem(order);
            orderItem.config(this);
            orderList.add(orderItem);
        }

        return this;
    }

    public ModelQuery order(String field) {
        OrderItem orderItem = new OrderItem(field, null);
        orderItem.config(this);
        orderList.add(orderItem);
        return this;
    }

    public ModelQuery order(Field field) {
        OrderItem orderItem = new OrderItem(field.getFieldName(), null);
        orderItem.config(this);
        orderList.add(orderItem);
        return this;
    }


    /* value methods */

    public ModelQuery values(Map<String, Object> values) throws DBException {
        if (values != null && values.size() > 0) {
            for (String name : values.keySet()) {
                value(name, values.get(name));
            }
        }

        return this;
    }

    public ModelQuery value(String name, Object value) throws DBException {
        MultiModelField multiModelField = getMultiModelField(manager.getField(name));
        this.values.put(multiModelField.getName(), value);
        return this;
    }

    /* page methods */

    public ModelQuery page(Map<String, Object> page) {
        if (page != null) {
            this.page.put("start", page.containsKey("start") ? (Integer) page.get("start") : null);
            this.page.put("end", page.containsKey("end") ? (Integer) page.get("end") : null);
        }

        return this;
    }

    /* exec query methods */

    public <T extends Object> T one() throws DBException {
        List values = list();
        return values.size() > 0 ? (T) values.get(0) : null;
    }

    public long count() throws DBException {
        return this.field(manager.newCountAllField()).<Long>one();
    }

    public <T extends Object> List<T> list() throws DBException {
        SQLQuery sqlQuery = toSQL();
        List result = manager.getModelClass().getProvider().select(sqlQuery);
        return processResult(result);
    }

    public void update() throws DBException {
        manager.getModelClass().getProvider().update(toSQL());
    }

    public void remove() throws DBException {
        manager.getModelClass().getProvider().remove(toSQL());
    }

    protected List processResult(List values) throws DBException {
        List result = new ArrayList();
        List<Target> targets = this.targets.size() > 0 ? this.targets : CollectionUtil.list(defaultTarget);

        for (Object value : values) {
            Object[] items = value.getClass().isArray() ? (Object[]) value : new Object[]{value};
            List resultItem = new ArrayList();
            Iterator itemIterator =  Arrays.asList(items).iterator();
            for (Target target : targets) {
                resultItem.add(target.processResult(itemIterator));
            }
            result.add(resultItem.size() == 1 ? resultItem.get(0) : resultItem);
        }

        return result;
    }

    public SQLQuery toSQL() {
        SQLQuery query = new SQLQuery(multiModel.getTable());

        if (targets.size() > 0) {
            for (Target target : targets) {
                target.setSQL(query);
            }
        } else {
            defaultTarget.setSQL(query);
        }
        for (Filter filter : filters) {
            filter.setSQL(query);
        }
        for (StringFilter stringFilter : stringFilters) {
            stringFilter.setSQL(query);
        }
        for (OrderItem orderItem : orderList) {
            orderItem.setSQL(query);
        }
        for (String fieldName : values.keySet()) {
            Field field = manager.getField(fieldName);
            query.addValue(field.getColumnName(), values.get(fieldName));
        }
        query.setStart(page.get("start"));
        query.setEnd(page.get("end"));

        return query;
    }

    /* getters and setters */

    public ModelManager getManager() {
        return manager;
    }

    public MultiModel getMultiModel() {
        return multiModel;
    }
}
