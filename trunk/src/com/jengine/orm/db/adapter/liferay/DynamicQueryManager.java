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

package com.jengine.orm.db.adapter.liferay;

import com.jengine.orm.ModelManager;
import com.jengine.orm.db.expression.Expression;
import com.jengine.orm.db.expression.ExpressionImpl;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.BasePersistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DynamicQueryManager {
    private ModelManager manager;

    public DynamicQueryManager(ModelManager manager) {
        this.manager = manager;
    }

    public List select(Map<String, Map> context, Map<String, Object> filter, Map<String, String> order) throws SystemException, PortalException {
        BasePersistence persistence = (BasePersistence) context.get(this.manager.getModel().getSimpleName()).get("persistence");
        return select(persistence, filter, order);
    }

    public List select(BasePersistence persistence, Map<String, Object> filter, Map<String, String> order) throws SystemException, PortalException {
        return persistence.findWithDynamicQuery(build(filter, order));
    }

    public long count(Map<String, Object> filter, Map<String, Map> context) throws SystemException, PortalException {
        BasePersistence persistence = (BasePersistence) context.get(this.manager.getModel().getSimpleName()).get("persistence");
        return count(persistence, filter);
    }

    public long count(BasePersistence persistence, Map<String, Object> filter) throws SystemException, PortalException {
        return persistence.countWithDynamicQuery(build(filter));
    }

    public DynamicQuery build(Map<String, Object> filter, Map<String, String> order) throws SystemException, PortalException {
        DynamicQuery dq = DynamicQueryFactoryUtil.forClass(this.manager.getModel());

        build(dq, parse(filter), order);

        return dq;
    }

    public DynamicQuery build(Map<String, Object> filter) throws SystemException, PortalException {
        DynamicQuery dq = DynamicQueryFactoryUtil.forClass(this.manager.getModel());

        build(dq, parse(filter));

        return dq;
    }


    public void build(DynamicQuery dq, List<Expression> filter) throws SystemException, PortalException {
        addFilters(dq, filter);
    }

    public void build(DynamicQuery dq, List<Expression> filter, Map<String, String> order) throws SystemException, PortalException {
        addFilters(dq, filter);
        addOrder(dq, order);
    }

    public void addFilters(DynamicQuery dq, List<Expression> filter) throws SystemException, PortalException {
        for (Expression expression : filter) {
            dq.add(makeCriterion(expression));
        }
    }

    protected Criterion makeCriterion(Expression expression) throws SystemException, PortalException {
//        Field modelField = manager.getField().get(expression.getField());
//        Property property = PropertyFactoryUtil.forName(expression.getField());
//
//        if ("eq".equals(expression.getOperation())) {
//            return property.eq(modelField.cast(expression.getValue()));
//        } if ("ge".equals(expression.getOperation())) {
//            return property.ge(modelField.cast(expression.getValue()));
//        } if ("gt".equals(expression.getOperation())) {
//            return property.gt(modelField.cast(expression.getValue()));
//        } if ("le".equals(expression.getOperation())) {
//            return property.le(modelField.cast(expression.getValue()));
//        } if ("lt".equals(expression.getOperation())) {
//            return property.lt(modelField.cast(expression.getValue()));
//        } if ("like".equals(expression.getOperation())) {
//            return property.like(modelField.cast(expression.getValue()));
//        } if ("ne".equals(expression.getOperation())) {
//            return property.ne(modelField.cast(expression.getValue()));
//        } if ("isnull".equals(expression.getOperation())) {
//            return ((Boolean) expression.getValue()) ? property.isNull() : property.isNotNull();
//        } if ("isempty".equals(expression.getOperation())) {
//            return ((Boolean) expression.getValue()) ?  property.isEmpty() : property.isNotEmpty();
//        }

        return null;
    }

    public void addOrder(DynamicQuery dq, Map<String, String> order) {
        if (order!= null && order.size() > 0) {
            if (order.get("orderType").equals("asc")) {
                dq.addOrder(OrderFactoryUtil.asc(order.get("field")));
            } else {
                dq.addOrder(OrderFactoryUtil.desc(order.get("field")));
            }
        }

    }

    /* static methods */
    static public List<Expression> parse(Map<String, Object> filter) {
        List<Expression> expressionMap = new ArrayList<Expression>();

        for (String key : filter.keySet()) {
            String name = key.contains("__") ? key.split("__")[0] : key;
            String operation = key.contains("__") ? key.split("__")[1] : "eq";
            Object value = filter.get(key);
            expressionMap.add(new ExpressionImpl(name, operation, value));
        }

        return expressionMap;
    }

}
