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

package com.jengine.orm.db.query;


import com.jengine.orm.db.expression.Expression;

import java.util.*;

public class SQLQuery {
    private String tableName;
    private String tableAlias;
    private Map<String, List> relations = new LinkedHashMap<String, List>();
    private Map<String, Expression> fitler = new LinkedHashMap<String, Expression>();
    private List<String> stringQueries = new ArrayList<String>();
    private List params = new ArrayList();
    private List<Object[]> targets = new ArrayList<Object[]>();
    private Map<String, String> order = new HashMap<String, String>();
    private Map<String, Object> values = new LinkedHashMap<String, Object>();
    private int start;
    private int end;

    public SQLQuery() {
    }

    public void addStringQuery(String stringQuery) {
        this.stringQueries.add(stringQuery);
    }

    public void addParam(Object param) {
        this.params.add(param);
    }

    /* setter an getters */

    public Map<String, List> getRelations() {
        return relations;
    }

    public void setRelations(Map<String, List> relations) {
        this.relations = relations;
    }

    public Map<String, Expression> getFitler() {
        return fitler;
    }

    public void setFitler(Map<String, Expression> fitler) {
        this.fitler = fitler;
    }

    public List getParams() {
        return params;
    }

    public void setParams(List params) {
        this.params = params;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<String> getStringQueries() {
        return stringQueries;
    }

    public void setStringQueries(List<String> stringQueries) {
        this.stringQueries = stringQueries;
    }

    public String getTableAlias() {
        return tableAlias;
    }

    public void setTableAlias(String tableAlias) {
        this.tableAlias = tableAlias;
    }

    public void addTarget(String target, String alias) {
        targets.add(new String[]{target, alias}) ;
    }

    public void addTarget(String target) {
        targets.add(new String[]{target}) ;
    }


    public List<Object[]> getTargets() {
        return targets;
    }

    public void setTargets(List<Object[]> targets) {
        this.targets = targets;
    }

    public Map<String, String> getOrder() {
        return order;
    }

    public void setOrder(Map<String, String> order) {
        this.order = order;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public void addValue(String field, Object value) {
        values.put(field, value);
    }

    public Map<String, Object> getValues() {
        return values;
    }
}
