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

package com.jengine.db;


import com.jengine.db.field.Field;
import com.jengine.db.field.FunctionField;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.persistence.BasePersistence;

import java.util.*;

import static com.jengine.utils.CollectionUtil.map;

public class ModelQuery {
    private Map<String, Field> fieldMap = new LinkedHashMap<String, Field>();
    private List<Field> fields = new ArrayList<Field>();
    private List<Field> filterFields = new ArrayList<Field>();
    private List<Expression> filter = new ArrayList<Expression>();
    private Field orderField = null;
    private String orderFieldName = null;
    private String orderType = null;
    private Map<String, Integer> page = new HashMap<String, Integer>();
    private ModelManager manager = null;

    public ModelQuery(ModelManager manager) {
        this.manager = manager;
        this.page.put("start", QueryUtil.ALL_POS);
        this.page.put("end", QueryUtil.ALL_POS);
    }

    public ModelQuery field(Field field) {
        this.fields.add(field);
        return this;
    }

    public ModelQuery field(String field) {
        this.fields.add(manager.getField(field));
        return this;
    }

    public ModelQuery fields(Object ... fields) {
        this.fields.addAll(getFields(Arrays.asList(fields)));

        return this;
    }

    public ModelQuery fields(List fields) {
        this.fields.addAll(getFields(fields));

        return this;
    }

    public ModelQuery filterMap(Object ... filter) {
        this.filter.addAll(PersistenceManager.parse(map(filter)));

        return this;
    }

    public ModelQuery filter(Map<String, Object> filter) {
        this.filter.addAll(PersistenceManager.parse(filter));

        return this;
    }

    public ModelQuery filter(List<Expression> filter) {
        this.filter.addAll(filter);

        return this;
    }

    public ModelQuery order(Map<String, String> order) {
        if (order != null && order.size() > 0 && order.containsKey("field")) {
            this.orderFieldName = order.get("field");
            if (order.containsKey("orderType")) {
                this.orderType = order.get("orderType");
            }
        }
        return this;
    }

    public <T extends Object> T one(Map context) throws SystemException, PortalException {
        List values = list(context);
        return values.size() > 0 ? (T) values.get(0) : null;
    }

    public long count(Map<String, Map> context) throws SystemException, PortalException {
        return this.field(manager.getCountAllField()).<Long>one(context);
    }

    public <T extends Object> List<T> list(Map<String, Map> context) throws SystemException, PortalException {
        BasePersistence persistence = (BasePersistence) context.get(manager.getModelClass().getSimpleName()).get("persistence");

        // init model fields
        init();

        // exec Query
        List values = this.manager.getPersistenceManager().select(this, persistence);

        // process result
        List result = new ArrayList();
        if (fields.size() == 1) {
            Field modelField = fields.get(0);
            for (Object item : values) {
                if (modelField.isReference() || modelField.isSelf()) {
                    CBaseModel cObj = manager.wrap(modelField.getFieldClass(), (BaseModel) item, context);
                    result.add(cObj);
                    cObj.cache();
                } else {
                    result.add(modelField.castType(item));
                }
            }
        } else if (fields.size() > 1) {
            for (Object value : values) {
                Object[] items = (Object[]) value;
                Object[] resultItem = new Object[items.length];
                for (int i=0; i < items.length; i++) {
                    Field modelField = fields.get(i);
                    if (modelField.isReference() || modelField.isSelf()) {
                        CBaseModel obj = manager.wrap(modelField.getFieldClass(), (BaseModel) items[i], context);
                        resultItem[i] = obj;
                        obj.cache();
                    } else {
                        resultItem[i] = modelField.castType(items[i]);
                    }
                }
                result.add(resultItem);
            }
        }

        return result;
    }

    public ModelQuery page(Map<String, Object> page) {
        if (page != null) {
            this.page.put("start", page.containsKey("start") ? (Integer) page.get("start") : QueryUtil.ALL_POS);
            this.page.put("end", page.containsKey("end") ? (Integer) page.get("end") : QueryUtil.ALL_POS);
        }

//        return ((QueryService) context.get("QueryService")).select(this);
        return this;
    }

    public Query buildSQL() throws SystemException, PortalException {
        init();
        return this.manager.getPersistenceManager().buildSQL(this);
    }

    protected void init() {
        // init model fields
        if (this.fields.size() > 0) {
            for (Field modelField : this.fields) {
                if (modelField.isFunction()) {
                    for (Field attribute : getFields(((FunctionField) modelField).getAttributes())) {
                        fieldMap.put(attribute.getName(), attribute);
                    }
                } else {
                    fieldMap.put(modelField.getName(), modelField);
                }
            }
        } else {
            this.fields.add(manager.getSelf());
        }
        for (Expression expression : filter) {
            Field modelField = fieldMap.containsKey(expression.getField()) ?
                    fieldMap.get(expression.getField()) :
                    manager.getField(expression.getField());
//            if(modelField.isReference() && !modelField.isSelf()) {
//                ReferenceField referenceField = (ReferenceField) modelField;
//                ModelManager referenceManager = CBaseModel.getManager(referenceField.getFieldClass());
//                modelField = manager.getField(referenceField.getName() + "." +referenceManager.getPrimaryKey().getName());
//            }
            filterFields.add(modelField);
            fieldMap.put(modelField.getName(), modelField);
        }
        if (orderFieldName != null) {
            this.orderField = fieldMap.containsKey(orderFieldName) ? fieldMap.get(orderFieldName) : manager.getField(orderFieldName);
            fieldMap.put(orderFieldName, orderField);
        }

    }

    protected List<Field> getFields(List fields) {
        List<Field> result = new ArrayList<Field>();

        for (Object field : fields) {
            if (field.getClass().equals(String.class)) {
                result.add(manager.getField((String) field));
            } else {
                result.add((Field) field);
            }
        }

        return result;
    }

    /* setters and getters */

    public Map<String, Field> getFieldMap() {
        return fieldMap;
    }

    public List<Field> getFields() {
        return fields;
    }

    public List<Field> getFilterFields() {
        return filterFields;
    }

    public List<Expression> getFilter() {
        return filter;
    }

    public Field getOrderField() {
        return orderField;
    }

    public String getOrderType() {
        return orderType;
    }

    public Map<String, Integer> getPage() {
        return page;
    }
}
