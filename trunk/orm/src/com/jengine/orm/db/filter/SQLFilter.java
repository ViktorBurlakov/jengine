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

package com.jengine.orm.db.filter;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.jengine.utils.CollectionUtil.list;

public class SQLFilter {
    public static Map<String, Operation> OPERATIONS = new HashMap<String, Operation>();
    static {
        List<Class> operations = list(EQ.class, GE.class, GT.class, LE.class, LT.class, Like.class, NE.class, ISNULL.class, ISEMPTY.class);
        for (Class operationClass : operations) {
            try {
                Operation operation = (Operation) operationClass.newInstance();
                OPERATIONS.put(operation.getName(), operation);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected String field;
    protected Operation operation;
    protected Object value;

    public SQLFilter(String field, String operation, Object value) {
        this.field = field;
        this.operation = OPERATIONS.containsKey(operation) ? OPERATIONS.get(operation) : new Operation(operation);
        this.value = value;
    }

    public SQLFilter(String field, Operation operation, Object value) {
        this.field = field;
        this.operation = operation;
        this.value = value;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String toString() {
        return "SQLFilter{" +
                "field='" + field + '\'' +
                ", operation='" + operation + '\'' +
                ", value=" + value +
                '}';
    }

    /* Operation classes */

    public static class Operation {
        private String name;

        public Operation(String name) {
            this.name = name;
        }

        public StringBuffer getSQL(String field, Object value) {
            StringBuffer sql = new StringBuffer();
            sql.append(field).append("").append(name).append("").append(value);
            return sql;
        }

        public String getName() {
            return name;
        }

    }

    public static class EQ extends Operation {

        public EQ() {
            super("eq");
        }

        public StringBuffer getSQL(String field, Object value) {
                StringBuffer sql = new StringBuffer();
            sql.append(field).append("").append("=").append("").append(value);
            return sql;
        }
    }

    public static class GE extends Operation {
        public GE() {
            super("ge");
        }

        public StringBuffer getSQL(String field, Object value) {
            StringBuffer sql = new StringBuffer();
            sql.append(field).append("").append(">=").append("").append(value);
            return sql;
        }
    }

    public static class GT extends Operation {
        public GT() {
            super("gt");
        }

        public StringBuffer getSQL(String field, Object value) {
            StringBuffer sql = new StringBuffer();
            sql.append(field).append("").append(">").append("").append(value);
            return sql;
        }
    }

    public static class LE extends Operation {
        public LE() {
            super("le");
        }

        public StringBuffer getSQL(String field, Object value) {
            StringBuffer sql = new StringBuffer();
            sql.append(field).append("").append("<=").append("").append(value);
            return sql;
        }
    }

    public static class LT extends Operation {
        public LT() {
            super("lt");
        }

        public StringBuffer getSQL(String field, Object value) {
            StringBuffer sql = new StringBuffer();
            sql.append(field).append("").append("<").append("").append(value);
            return sql;
        }
    }

    public static class Like extends Operation {
        public Like() {
            super("like");
        }

        public StringBuffer getSQL(String field, Object value) {
            StringBuffer sql = new StringBuffer();
            sql.append(field).append(" ").append("like").append(" ").append(value);
            return sql;
        }
    }

    public static class NE extends Operation {
        public NE() {
            super("ne");
        }

        public StringBuffer getSQL(String field, Object value) {
            StringBuffer sql = new StringBuffer();
            sql.append(field).append(" ").append("<>").append(" ").append(value);
            return sql;
        }
    }

    public static class ISNULL extends Operation {
        public ISNULL() {
            super("isnull");
        }

        public StringBuffer getSQL(String field, Object value) {
            StringBuffer sql = new StringBuffer();
            if ((Boolean) value) {
                sql.append(field).append(" ").append("is null").append(" ");
            } else  {
                sql.append(field).append(" ").append("is not null").append(" ");
            }
            return sql;
        }
    }

    public static class ISEMPTY extends Operation {
        public ISEMPTY() {
            super("isempty");
        }

        public StringBuffer getSQL(String field, Object value) {
            StringBuffer sql = new StringBuffer();
            if ((Boolean) value) {
                sql.append(field).append("=").append("''");
            } else  {
                sql.append(field).append("<>").append("''");
            }
            return sql;
        }
    }
}
