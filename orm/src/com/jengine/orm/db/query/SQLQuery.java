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


import com.jengine.orm.db.filter.SQLFilter;
import com.jengine.orm.db.filter.SQLStringFilter;
import com.jengine.utils.expression.ExpressionData;
import com.jengine.utils.expression.ExpressionNode;
import com.jengine.utils.expression.ExpressionOperation;

import java.util.*;

import static com.jengine.utils.CollectionUtil.toList;

public class SQLQuery {
    private Table table;
    private Map<String, SQLFilter> filters = new LinkedHashMap<String, SQLFilter>();
    private List<SQLStringFilter> stringFilters = new ArrayList<SQLStringFilter>();
    private List params = new ArrayList();
    private List<Object[]> targets = new ArrayList<Object[]>();
    private List<String> group = new ArrayList<String>();
    private LinkedHashMap<String, Integer> targetTypes = new LinkedHashMap<String, Integer>();
    private Map<String, String> order = new HashMap<String, String>();
    private Map<String, Object> values = new LinkedHashMap<String, Object>();
    private Integer start;
    private Integer end;
    private Boolean distinct;

    public SQLQuery(Table table) {
        this.table = table;
    }

    public SQLQuery filter(SQLFilter filter) {
        this.filters.put(filter.getField(), filter);
        this.params.add(filter.getValue());
        return this;
    }

    public void addStringFilter(SQLStringFilter stringFilter) {
        this.stringFilters.add(stringFilter);
        this.params.addAll(stringFilter.getParams());
    }

    public void addParam(Object param) {
        this.params.add(param);
    }

    public void group(String field) {
        this.group.add(field);
    }

    /* setter an getters */

    public Boolean getDistinct() {
        return distinct;
    }

    public void setDistinct(Boolean distinct) {
        this.distinct = distinct;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public boolean isEmptyFilter() {
        return filters.isEmpty() && stringFilters.isEmpty();
    }

    public Map<String, SQLFilter> getFilters() {
        return filters;
    }

    public void setFilters(Map<String, SQLFilter> filters) {
        this.filters = filters;
    }

    public List getParams() {
        List result = new ArrayList();
        for (Object param: params) {
            if (param instanceof SQLQuery) {
                result.addAll(((SQLQuery) param).getParams());
            } else {
                result.add(param);
            }
        }
        return result;
    }

    public void setParams(List params) {
        this.params = params;
    }

    public List<SQLStringFilter> getStringFilters() {
        return stringFilters;
    }

    public void setStringFilters(List<SQLStringFilter> stringFilters) {
        this.stringFilters = stringFilters;
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

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public void addValue(String field, Object value) {
        values.put(field, value);
    }

    public Map<String, Object> getValues() {
        return values;
    }

    public LinkedHashMap<String, Integer> getTargetTypes() {
        return targetTypes;
    }

    public void putTargetType(String name, Integer type) {
        this.targetTypes.put(name, type);
    }

    public void setTargetTypes(LinkedHashMap<String, Integer> targetTypes) {
        this.targetTypes = targetTypes;
    }

    public List<String> getGroup() {
        return group;
    }

    public void setGroup(List<String> group) {
        this.group = group;
    }

    /* nested classes  */

    public static class Table {
        private Map<String, TableItem> items = new LinkedHashMap<String, TableItem>();
        private ExpressionNode expression;

        public Table(List<TableItem> items, ExpressionNode expression) {
            for (TableItem item : items) {
                this.items.put(item.getName(), item);
            }
            this.expression = expression;
        }

        public Table(String table) {
            this(new TableItem(table));
        }

        public Table(String table, String alias) {
            this(new TableItem(table, alias));
        }

        public Table(TableItem item) {
            items.put(item.getName(), item);
            expression = new ExpressionData<TableItem>(item);
        }

        public Table join(String table, String alias, String restriction) {
            return join(new TableItem(table, alias, restriction));
        }

        public Table join(TableItem item) {
            items.put(item.getName(), item);
            expression = new Join(expression, new ExpressionData<TableItem>(item));
            return this;
        }

        public Table ljoin(String table, String alias, String restriction) {
            return ljoin(new TableItem(table, alias, restriction));
        }

        public Table ljoin(TableItem item) {
            items.put(item.getName(), item);
            expression = new LeftJoin(expression, new ExpressionData<TableItem>(item));
            return this;
        }

        public Table rjoin(String table, String alias, String restriction) {
            return rjoin(new TableItem(table, alias, restriction));
        }

        public Table rjoin(TableItem item) {
            items.put(item.getName(), item);
            expression = new RightJoin(expression, new ExpressionData<TableItem>(item));
            return this;
        }

        public Table and(String table, String alias, String restriction) {
            return and(new TableItem(table, alias, restriction));
        }

        public Table and(TableItem item) {
            items.put(item.getName(), item);
            expression = new And(expression, new ExpressionData<TableItem>(item));
            return this;
        }

        public List<TableItem> getItemList() {
            return toList(items.values());
        }

        public Map<String, TableItem> getItems() {
            return items;
        }

        public ExpressionNode getExpression() {
            return expression;
        }
    }


    public static class TableItem {
        private String alias;
        private String table;
        private String restriction;

        public TableItem(String table, String alias, String restriction) {
            this.alias = alias;
            this.table = table;
            this.restriction = restriction;
        }

        public TableItem(String table) {
            this.table = table;
        }

        public TableItem(String table, String alias) {
            this.table = table;
            this.alias = alias;
        }

        public String getName() {
            return alias == null ? table : alias;
        }

        public String getAlias() {
            return alias;
        }

        public String getTable() {
            return table;
        }

        public String getRestriction() {
            return restriction;
        }

        public void setRestriction(String restriction) {
            this.restriction = restriction;
        }
    }


    public static class Group extends ExpressionOperation {

        public Group(ExpressionNode expressionNode) {
            super(expressionNode);
        }

        public ExpressionNode getChild() {
            return nodes.get(0);
        }
    }

    public static class Join extends ExpressionOperation {

        public Join(ExpressionNode operand1, ExpressionNode operand2) {
            super(operand1, operand2);
        }

        public ExpressionNode getLeftNode() {
            return nodes.get(0);
        }

        public ExpressionNode getJoinNode() {
            return nodes.get(1);
        }

    }

    public static class LeftJoin extends Join {
        public LeftJoin(ExpressionNode operand1, ExpressionNode operand2) {
            super(operand1, operand2);
        }
    }

    public static class RightJoin extends Join {
        public RightJoin(ExpressionNode operand1, ExpressionNode operand2) {
            super(operand1, operand2);
        }
    }

    public static class And extends ExpressionOperation {
        public And(ExpressionNode operand1, ExpressionNode operand2) {
            super(operand1, operand2);
        }
    }

}
