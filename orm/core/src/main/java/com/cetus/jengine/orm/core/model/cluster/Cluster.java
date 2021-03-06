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

package com.cetus.jengine.orm.core.model.cluster;


import com.cetus.jengine.orm.core.DB;
import com.cetus.jengine.orm.core.db.DBException;
import com.cetus.jengine.orm.core.model.ModelClassBase;
import com.cetus.jengine.orm.core.model.multi.MultiModel;
import com.cetus.jengine.orm.core.model.multi.MultiModelItem;
import com.cetus.jengine.orm.core.model.multi.field.CalcMultiField;
import com.cetus.jengine.orm.core.model.multi.field.MultiModelField;
import com.cetus.jengine.orm.core.model.multi.field.aggregation.*;
import com.cetus.jengine.orm.core.model.query.ClusterQuery;
import com.cetus.jengine.orm.core.model.query.filter.Filter;
import com.cetus.jengine.orm.core.model.query.filter.StringFilter;
import org.antlr.runtime.RecognitionException;

import java.util.*;

import static com.cetus.jengine.utils.commons.CollectionUtil.toList;

public class Cluster extends MultiModel {
    protected LinkedHashMap<String, MultiModelField> selectedFields = new LinkedHashMap<String, MultiModelField>();
    protected List<Filter> filters = new ArrayList<Filter>();
    protected List<StringFilter> stringFilters = new ArrayList<StringFilter>();
    protected List<String> group = new ArrayList<String>();

    public Cluster(ModelClassBase model) {
        super(model);
    }

    public Cluster(String expr) throws RecognitionException {
        super(expr);
    }

    public Cluster(DB db, String expr) throws RecognitionException {
        super(db, expr);
    }

    public Cluster(ModelClassBase model, String name) {
        super(model, name);
    }

    public Cluster(ModelClassBase model, List fields) {
        super(model);
        fields(fields);
    }

    public Cluster(String expr, List fields) throws RecognitionException {
        super(expr);
        fields(fields);
    }

    public Cluster(DB db, String expr, List fields) throws RecognitionException {
        super(db, expr);
        fields(fields);
    }

    public Cluster(ModelClassBase model, String name, List fields) {
        super(model, name);
        fields(fields);
    }

    public Cluster fields(Object ... fields) {
        return fields(toList(fields));
    }

    public Cluster fields(List fields) {
        for (Object field : fields) {
            this.field(field);
        }
        return this;
    }

    public Cluster field(Object field) {
        if (field instanceof String) {
            this.selectedFields.put((String) field, this.fields.get(field));
        } else if (field instanceof CalcMultiField) {
            CalcMultiField multiField = (CalcMultiField) field;
            multiField.config(this);
            this.fields.put(multiField.getName(), multiField);
            this.selectedFields.put(multiField.getName(), multiField);
        }
        return this;
    }

    public Cluster restriction(int operationIndex, String reference, String key) {
        return (Cluster) super.restriction(operationIndex, reference, key);
    }

    public Cluster alias(String itemName, String alias) {
        return (Cluster) super.alias(itemName, alias);
    }

    public Cluster alias(int itemIndex, String alias) {
        return (Cluster) super.alias(itemIndex, alias);
    }

    public Cluster alias(MultiModelItem item, String alias) {
        return (Cluster) super.alias(item, alias);
    }

    public Cluster join(ModelClassBase model) {
        return (Cluster) super.join(model);
    }

    public Cluster join(ModelClassBase model, String reference, String key) {
        return (Cluster) super.join(model, reference, key);
    }

    public Cluster join(ModelClassBase model, String name, String reference, String key) {
        return (Cluster) super.join(model, name, reference, key);
    }

    public Cluster ljoin(ModelClassBase model) {
        return (Cluster) super.ljoin(model);
    }

    public Cluster ljoin(ModelClassBase model, String reference, String key) {
        return (Cluster) super.ljoin(model, reference, key);
    }

    public Cluster ljoin(ModelClassBase model, String name, String reference, String key) {
        return (Cluster) super.ljoin(model, name, reference, key);
    }

    public Cluster rjoin(ModelClassBase model) {
        return (Cluster) super.rjoin(model);
    }

    public Cluster rjoin(ModelClassBase model, String reference, String key) {
        return (Cluster) super.rjoin(model, reference, key);
    }

    public Cluster rjoin(ModelClassBase model, String name, String reference, String key) {
        return (Cluster) super.rjoin(model, name, reference, key);
    }

    public Cluster fjoin(ModelClassBase model, String reference, String key) {
        return (Cluster) super.fjoin(model, reference, key);
    }

    public Cluster fjoin(ModelClassBase model, String name, String reference, String key) {
        return (Cluster) super.fjoin(model, name, reference, key);
    }

    public Cluster fjoin(ModelClassBase model) {
        return (Cluster) super.fjoin(model);
    }

    public Cluster and(ModelClassBase model) {
        return (Cluster) super.and(model);
    }

    public Cluster and(ModelClassBase model, String name) {
        return (Cluster) super.and(model, name);
    }

    public Cluster filterCluster(String query, Object ... params) throws DBException {
        try {
            stringFilters.add(new StringFilter(query, toList(params)));
        } catch (Exception e) {
            throw new DBException(e);
        }
        return this;
    }

    public Cluster filterCluster(Map<String, Object> filter) throws DBException {
        return filterCluster(Filter.parse(filter));
    }

    public Cluster filterCluster(Filter... filters) throws DBException {
        return filterCluster(Arrays.asList(filters));
    }

    public Cluster filterCluster(List<Filter> filter) throws DBException {
        filters.addAll(filter);
        return this;
    }

    public Cluster groupCluster(String fieldName) {
        group.add(fieldName);
        return this;
    }

    public <T extends Object> T one() throws DBException {
        return newQuery().one();
    }

    public <T extends Object> List<T> list() throws DBException {
        return newQuery().list();
    }

    public ClusterQuery select(Object ... fields) throws DBException {
        return select(Arrays.asList(fields));
    }

    public ClusterQuery select(List fields) throws DBException {
        return newQuery(fields);
    }

    public ClusterQuery filter(String query, Object ... params) throws DBException {
        return newQuery().filter(query, (Object[]) params);
    }

    public ClusterQuery filter(Map<String, Object> filter) throws DBException {
        return newQuery().filter(filter);
    }

    public ClusterQuery filter(Filter... filters) throws DBException {
        return filter(Arrays.asList(filters));
    }

    public ClusterQuery filter(List<Filter> filter) throws DBException {
        return newQuery().filter(filter);
    }

    public Long count() throws DBException {
        return (Long) new ClusterQuery(this).target(new Count()).one();
    }

    public Long count(String field) throws DBException {
        return (Long) new ClusterQuery(this).target(new Count(field)).one();
    }

    public <T> T max(String field) throws DBException {
        return new ClusterQuery(this).target(new Max(field)).one();
    }

    public <T> T min(String field) throws DBException {
        return new ClusterQuery(this).target(new Min(field)).one();
    }

    public <T> T avg(String field) throws DBException {
        return new ClusterQuery(this).target(new Avg(field)).one();
    }

    public<T> T sum(String field) throws DBException {
        return new ClusterQuery(this).target(new Sum(field)).one();
    }

//    public <ResultType> ResultType calc(String expr, String ... fields) throws DBException {
//        return (ResultType) new ClusterQuery(this).target(new Calc("_calc_", null, expr, fields)).one();
//    }
//

    protected ClusterQuery newQuery() throws DBException {
        return new ClusterQuery(this).targets(getTargets()).filter(filters).sfilter(stringFilters).group(group);
    }

    protected ClusterQuery newQuery(List fields) throws DBException {
        List targets = fields.size() > 0 ? fields : getTargets();
        return new ClusterQuery(this).targets(targets).filter(filters).sfilter(stringFilters).group(group);
    }

    protected List<String> getTargets() {
        return selectedFields.size() > 0 ? toList(this.selectedFields.keySet()) : toList(this.fields.keySet());
    }

}
