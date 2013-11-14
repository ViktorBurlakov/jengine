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


import com.liferay.portal.kernel.dao.orm.Type;

import java.util.*;

public class Query {
    private List<Object[]> targets = new ArrayList<Object[]>();
    private String modelAlias;
    private Class model;
    private Map<String, List> relations = new LinkedHashMap<String, List>();
    private Map<String, Expression> fitler = new LinkedHashMap<String, Expression>();
    private List<String> stringQueries = new ArrayList<String>();
    private Map<String, String> order = new HashMap<String, String>();
    private List params = new ArrayList();
    private Map<String, Class> entires = new LinkedHashMap<String, Class>();
    private Map<String, Type> scalars = new LinkedHashMap<String, Type>();
    private int start;
    private int end;
    private String tableName;

    public Query() {
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

    public String getModelAlias() {
        return modelAlias;
    }

    public void setModelAlias(String modelAlias) {
        this.modelAlias = modelAlias;
    }

    public String getModelName() {
        return model.getSimpleName();
    }

    public Class getModel() {
        return model;
    }

    public void setModel(Class model) {
        this.model = model;
    }

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

    public Map<String, String> getOrder() {
        return order;
    }

    public void setOrder(Map<String, String> order) {
        this.order = order;
    }

    public List getParams() {
        return params;
    }

    public void setParams(List params) {
        this.params = params;
    }

    public Map<String, Class> getEntires() {
        return entires;
    }

    public void setEntires(Map<String, Class> entires) {
        this.entires = entires;
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

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Map<String, Type> getScalars() {
        return scalars;
    }

    public void setScalars(Map<String, Type> scalars) {
        this.scalars = scalars;
    }

    public List<String> getStringQueries() {
        return stringQueries;
    }

    public void setStringQueries(List<String> stringQueries) {
        this.stringQueries = stringQueries;
    }

    public void addStringQuery(String stringQuery) {
        this.stringQueries.add(stringQuery);
    }
}
