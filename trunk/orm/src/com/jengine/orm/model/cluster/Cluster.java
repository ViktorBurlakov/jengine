package com.jengine.orm.model.cluster;


import com.jengine.orm.db.DBException;
import com.jengine.orm.model.ModelClassBase;
import com.jengine.orm.model.multi.MultiModel;
import com.jengine.orm.model.query.ClusterQuery;
import com.jengine.orm.model.query.filter.Filter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Cluster extends MultiModel {

    public Cluster(ModelClassBase model) {
        super(model);
    }

    public Cluster(ModelClassBase model, String name) {
        super(model, name);
    }

    public Cluster join(ModelClassBase model, String name, String reference, String key) {
        return (Cluster) super.join(model, name, reference, key);
    }

    public Cluster ljoin(ModelClassBase model, String name, String reference, String key) {
        return (Cluster) super.ljoin(model, name, reference, key);
    }

    public Cluster rjoin(ModelClassBase model, String name, String reference, String key) {
        return (Cluster) super.rjoin(model, name, reference, key);
    }

    public Cluster and(ModelClassBase model, String name) {
        return (Cluster) super.and(model, name);
    }

    public ClusterQuery select(Object ... fields) throws DBException {
        return select(Arrays.asList(fields));
    }

    public ClusterQuery select(List fields) throws DBException {
        return new ClusterQuery(this).fields(fields);
    }

    public ClusterQuery filter(String query, Object ... params) throws DBException {
        return new ClusterQuery(this).filter(query, (Object[]) params);
    }

    public ClusterQuery filter(Map<String, Object> filter) throws DBException {
        return new ClusterQuery(this).filter(filter);
    }

    public ClusterQuery filter(Filter... filters) throws DBException {
        return filter(Arrays.asList(filters));
    }

    public ClusterQuery filter(List<Filter> filter) throws DBException {
        return new ClusterQuery(this).filter(filter);
    }

//    public Long count() throws DBException {
//        return (Long) new ClusterQuery(this).field(new Count(this)).one();
//    }
//
//    public Long count(String field) throws DBException {
//        return (Long) new ClusterQuery(this).field(new Count(this, field)).one();
//    }
//
//    public Object max(String field) throws DBException {
//        return new ClusterQuery(this).field(new Max(this, field)).one();
//    }
//
//    public Object min(String field) throws DBException {
//        return new ClusterQuery(this).field(new Min(this, field)).one();
//    }
//
//    public Object avg(String field) throws DBException {
//        return new ClusterQuery(this).field(new Avg(this, field)).one();
//    }
//
//    public Object sum(String field) throws DBException {
//        return new ClusterQuery(this).field(new Sum(this, field)).one();
//    }
//
//    public <ResultType> ResultType calc(String name, Class type, String expr, String ... fields) throws DBException {
//        return (ResultType) new ClusterQuery(this).field(new Calc(this, name, type, expr, fields)).one();
//    }
}
