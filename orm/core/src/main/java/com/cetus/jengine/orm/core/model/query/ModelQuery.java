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
import com.cetus.jengine.orm.core.db.query.SQLQuery;
import com.cetus.jengine.orm.core.model.ModelClassBase;
import com.cetus.jengine.orm.core.model.ModelManager;
import com.cetus.jengine.orm.core.model.field.Field;
import com.cetus.jengine.orm.core.model.field.FunctionField;
import com.cetus.jengine.orm.core.model.field.reference.BaseReference;
import com.cetus.jengine.orm.core.model.multi.MultiModel;
import com.cetus.jengine.orm.core.model.multi.MultiModelItem;
import com.cetus.jengine.orm.core.model.multi.field.CalcMultiField;
import com.cetus.jengine.orm.core.model.multi.field.MultiModelField;
import com.cetus.jengine.orm.core.model.multi.field.aggregation.Count;
import com.cetus.jengine.orm.core.model.query.filter.Filter;
import com.cetus.jengine.orm.core.model.query.filter.StringFilter;
import com.cetus.jengine.orm.core.model.query.target.FieldTarget;
import com.cetus.jengine.orm.core.model.query.target.ModelTarget;
import com.cetus.jengine.orm.core.model.query.target.Target;

import java.util.List;
import java.util.Map;

public class ModelQuery extends BaseQuery {
    private ModelManager manager = null;

    public ModelQuery(ModelManager manager) {
        super();
        this.manager = manager;
        this.multiModel = new QueryMultiModel(manager.getModelClass());
        this.defaultTarget = new ModelTarget(getMultiModel().getMainItem());
        this.defaultTarget.config(this);
    }

    /* target methods */

    public ModelQuery distinct() {
        return (ModelQuery) super.distinct();
    }

    public ModelQuery distinct(Object ... fields) {
        return (ModelQuery) super.distinct(fields);
    }

    public ModelQuery distinct(List fields) {
        return (ModelQuery) super.distinct(fields);
    }

    public ModelQuery distinct(Object field) {
        return (ModelQuery) super.distinct(field);
    }

    public ModelQuery target(Object field) {
        if (field instanceof CalcMultiField) {
            this.target((CalcMultiField) field);
        } else {
            this.target(getMultiModel().getField(field));
        }

        return this;
    }

    public ModelQuery target(MultiModelField field) {
        if (field instanceof CalcMultiField) {
            target((CalcMultiField) field);
        } else if (field.getModelField() instanceof FunctionField) {
            Target target = new FieldTarget(field);
            target.config(this);
            this.targets.put(target.getName(), target);
        } else if (field.getModelField() instanceof BaseReference) {
            MultiModelItem item =  multiModel.getItems().get(field.getName());
            Target target = new ModelTarget(field.getName(), item);
            target.config(this);
            this.targets.put(target.getName(), target);
        } else {
            Target target = new FieldTarget(field);
            target.config(this);
            this.targets.put(target.getName(), target);
        }

        return this;
    }

    public ModelQuery targets(Object... fields) {
        return (ModelQuery) super.targets(fields);
    }

    public ModelQuery targets(List fields) {
        return (ModelQuery) super.targets(fields);
    }

    public ModelQuery filter(String query, Object... params) throws DBException {
        return (ModelQuery) super.filter(query, params);
    }

    public ModelQuery filter(Map<String, Object> filter) throws DBException {
        return (ModelQuery) super.filter(filter);
    }

    public ModelQuery filter(List<Filter> filters) throws DBException {
        return (ModelQuery) super.filter(filters);
    }

    public ModelQuery filter(Filter... filter) throws DBException {
        return (ModelQuery) super.filter(filter);
    }

    public ModelQuery order(Map<String, String> order) {
        return (ModelQuery) super.order(order);
    }

    public ModelQuery order(String field) {
        return (ModelQuery) super.order(field);
    }

    public ModelQuery order(String field, String orderType) {
        return (ModelQuery) super.order(field, orderType);
    }

    public ModelQuery group(String targetName) {
        return (ModelQuery) super.group(targetName);
    }

    public ModelQuery group(List<String> fields) {
        return (ModelQuery) super.group(fields);
    }

    public ModelQuery group(String... fields) {
        return (ModelQuery) super.group(fields);
    }

    public ModelQuery values(Map<String, Object> values) throws DBException {
        return (ModelQuery) super.values(values);
    }

    public ModelQuery value(String name, Object value) throws DBException {
        return (ModelQuery) super.value(name, value);
    }

    public ModelQuery page(Map<String, Object> page) {
        return (ModelQuery) super.page(page);
    }

    public ModelQuery page(Integer start, Integer end) {
        return (ModelQuery) super.page(start, end);
    }

    /* exec query methods */

    public long count() throws DBException {
        return this.target(new Count()).<Long>one();
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

    public SQLQuery toSQL() {
        SQLQuery query = new SQLQuery(multiModel.getMultiTable());

        if (targets.size() > 0) {
            for (Target target : targets.values()) {
                target.setSQL(query);
            }
        } else {
            defaultTarget.setSQL(query);
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
            Field field = manager.getField(fieldName);
            query.addValue(field.getColumnName(), values.get(fieldName));
        }
        if (page.get("start") != null && page.get("end") != null) {
            query.setStart(page.get("start"));
            query.setEnd(page.get("end"));
            query.addParam(page.get("start"));
            query.addParam(page.get("end"));
        }

        return query;
    }

    /* getters and setters */

    public ModelManager getManager() {
        return manager;
    }

    public QueryMultiModel getMultiModel() {
        return (QueryMultiModel) multiModel;
    }

    /* inner classes */

    public class QueryMultiModel extends MultiModel {
        private MultiModelItem mainItem = null;

        public QueryMultiModel(ModelClassBase model) {
            super(model);
            mainItem = getItemList().get(0);
        }

        public QueryMultiModel(ModelClassBase model, String name) {
            super(model, name);
            mainItem = getItemList().get(0);
        }

        public MultiModelField getField(Object field) {
            return getField(field instanceof String ? (String) field : ((Field) field).getFieldName());
        }

        public MultiModelField getField(String fieldName) {
            return multiModel.getFields().containsKey(fieldName) ?
                    multiModel.getFields().get(fieldName) : getRelatedField(mainItem, fieldName);
        }

        public MultiModelItem getMainItem() {
            return mainItem;
        }
    }
}
