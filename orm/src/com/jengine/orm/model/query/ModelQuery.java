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

package com.jengine.orm.model.query;


import com.jengine.orm.db.DBException;
import com.jengine.orm.db.query.SQLQuery;
import com.jengine.orm.model.ModelClassBase;
import com.jengine.orm.model.ModelManager;
import com.jengine.orm.model.field.Field;
import com.jengine.orm.model.field.ForeignField;
import com.jengine.orm.model.field.FunctionField;
import com.jengine.orm.model.field.aggregation.Count;
import com.jengine.orm.model.field.reference.BaseReference;
import com.jengine.orm.model.field.reference.ReferenceField;
import com.jengine.orm.model.multi.MultiModel;
import com.jengine.orm.model.multi.MultiModelField;
import com.jengine.orm.model.multi.MultiModelItem;
import com.jengine.orm.model.query.filter.Filter;
import com.jengine.orm.model.query.filter.StringFilter;
import com.jengine.orm.model.query.target.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.jengine.utils.CollectionUtil.concat;

public class ModelQuery extends BaseQuery {
    private ModelManager manager = null;
    protected MultiModel multiModel;

    public ModelQuery(ModelManager manager) {
        super();
        this.manager = manager;
        this.multiModel = new MultiModel(manager.getModelClass());
        for (MultiModelField field : this.multiModel.getFieldList()) {
            if (!(field.getModelField() instanceof BaseReference)) {
                multiModel.getFields().put(field.getModelField().getFieldName(), field);
            }
        }
        this.defaultTarget = new ModelTarget(multiModel.getItemList().get(0));
        this.defaultTarget.config(this);
    }

    public MultiModelField _registerField(String field) {
        return multiModel.getFields().containsKey(field) ?
                multiModel.getFields().get(field) :
                _registerField(manager.getField(field));
    }

    public MultiModelField _registerField(Field modelField) {
        return _registerField(modelField.getFieldName(), modelField);
    }

    public MultiModelField _registerField(String name, Field modelField) {
        if (modelField instanceof ForeignField) {
            _addPath(((ForeignField) modelField).getReferencePath());
        }
        MultiModelField multiModelField = multiModel.getFields().get(name);
        if (multiModelField == null) {
            multiModelField = new MultiModelField(name, modelField);
            multiModel.getFields().put(name, multiModelField);
        }
        return multiModelField;
    }

    public void _addPath(List<String> path) {
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

    /* target methods */

    public ModelQuery distinct() {
        return (ModelQuery) super.distinct();
    }

    public ModelQuery distinct(String... fields) {
        return (ModelQuery) super.distinct(fields);
    }

    public ModelQuery distinct(String field) {
        return (ModelQuery) super.distinct(field);
    }

    public ModelQuery distinct(Object ... fields) {
        this.distinct = true;
        this.targets(fields);
        return this;
    }

    public ModelQuery distinct(List fields) {
        this.distinct = true;
        this.targets(fields);
        return this;
    }

    public ModelQuery distinct(Object field) {
        this.distinct = true;
        this.target(field);
        return this;
    }

    public ModelQuery target(FunctionField field) {
        return (ModelQuery) super.target(field);
    }

    public ModelQuery targets(String... fields) {
        return (ModelQuery) super.targets(fields);
    }

    public ModelQuery target(Object field) {
        if (String.class.equals(field.getClass())) {
            this.target((String) field);
        } else  {
            this.target((Field) field);
        }

        return this;
    }

    public ModelQuery target(String field) {
        return this.target(manager.getField(field));
    }

    public ModelQuery target(Field field) {
        if (field instanceof ForeignField) {
            target((ForeignField) field);
        } else if (field instanceof FunctionField) {
            target((FunctionField) field);
        } else if (field instanceof BaseReference) {
            target((BaseReference) field);
        } else {
            Target target = new FieldTarget(field.getFieldName(), multiModel.getFields().get(field.getFieldName()));
            target.config(this);
            this.targets.put(target.getName(), target);
        }

        return this;
    }

    public ModelQuery target(ForeignField field) {
        Target target = new ForeignTarget(field);
        target.config(this);
        this.targets.put(target.getName(), target);
        return this;
    }

    public ModelQuery target(BaseReference field) {
        Target target = new ReferenceTarget(field);
        target.config(this);
        this.targets.put(target.getName(), target);
        return this;
    }

    public ModelQuery targets(Object... fields) {
        for(Object field : fields) {
            this.target(field);
        }
        return this;
    }

    public ModelQuery targets(List fields) {
        for(Object field : fields) {
            this.target(field);
        }

        return this;
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
        return this.target(new Count(this.manager.getModelClass())).<Long>one();
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

    public MultiModel getMultiModel() {
        return multiModel;
    }
}
