package com.jengine.orm.model.query;


import com.jengine.orm.db.DBException;
import com.jengine.orm.db.query.SQLQuery;
import com.jengine.orm.model.cluster.Cluster;
import com.jengine.orm.model.field.FunctionField;
import com.jengine.orm.model.multi.MultiModelField;
import com.jengine.orm.model.query.filter.Filter;
import com.jengine.orm.model.query.filter.StringFilter;
import com.jengine.orm.model.query.target.FieldTarget;
import com.jengine.orm.model.query.target.Target;

import java.util.List;
import java.util.Map;

public class ClusterQuery extends BaseQuery {

    public ClusterQuery(Cluster cluster) {
        super(cluster);
    }

    public MultiModelField _registerField(String field) {
        return multiModel.getFields().get(field);
    }

    public ClusterQuery target(String field) {
        MultiModelField multiModelField = multiModel.getFields().get(field);
        Target target = new FieldTarget(field, multiModelField);
        target.config(this);
        this.targets.put(target.getName(), target);
        return this;
    }

    public ClusterQuery distinct() {
        return (ClusterQuery) super.distinct();
    }

    public ClusterQuery distinct(String... fields) {
        return (ClusterQuery) super.distinct(fields);
    }

    public ClusterQuery distinct(List<String> fields) {
        return (ClusterQuery) super.distinct(fields);
    }

    public ClusterQuery distinct(String field) {
        return (ClusterQuery) super.distinct(field);
    }

    public ClusterQuery target(FunctionField field) {
        return (ClusterQuery) super.target(field);
    }

    public ClusterQuery targets(String... fields) {
        return (ClusterQuery) super.targets(fields);
    }

    public ClusterQuery targets(List<String> fields) {
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

    public ClusterQuery group(String targetName) {
        return (ClusterQuery) super.group(targetName);
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
        for (Target target : group.values()) {
            query.group(target.getSQLName());
        }
        for (OrderItem orderItem : orderList) {
            orderItem.setSQL(query);
        }
        for (String fieldName : values.keySet()) {
            MultiModelField field = multiModel.getFields().get(fieldName);
            query.addValue(field.getSQLName(), values.get(fieldName));
        }
        query.setStart(page.get("start"));
        query.setEnd(page.get("end"));

        return query;
    }

    public void update() throws DBException {
    }

    public void remove() throws DBException {
    }
}
