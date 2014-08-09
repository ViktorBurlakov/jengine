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

package com.jengine.orm.model.multi.field;


import com.jengine.orm.db.DBException;
import com.jengine.orm.model.multi.MultiModel;
import com.jengine.utils.commons.Variant;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CalcMultiField extends MultiModelField {
    protected List<String> fields = new ArrayList<String>();
    protected List<String> columns = new ArrayList<String>();
    protected String expression;
    protected Class fieldClass;
    protected Integer columnType;
    protected Map<String, Object> options = new LinkedHashMap<String, Object>();

    public CalcMultiField(Class fieldClass, Integer columnType, String expression, List<String> fields, Map<String, Object> options) {
        super();
        this.expression = expression;
        this.fieldClass = fieldClass;
        this.columnType = columnType;
        this.fields.addAll(fields);
        this.options.putAll(options);
    }

    public CalcMultiField(String name, Class fieldClass, Integer columnType, String expression, List<String> fields, Map<String, Object> options) {
        super(name);
        this.expression = expression;
        this.fieldClass = fieldClass;
        this.columnType = columnType;
        this.fields.addAll(fields);
        this.options.putAll(options);
    }

    public void config(MultiModel multiModel) {
        this.multiModel = multiModel;
        for (String field : this.fields) {
            columns.add(multiModel.getField(field).getSQLName());
        }
    }

    public String getSQLName() {
        return name;
    }

    public String getAlias() {
        return name;
    }

    public Object cast(Object value) throws DBException {
        return new Variant(value).convertTo(fieldClass);
    }

    public String toSQL() {
        return String.format(expression, columns.toArray());
    }

    public Map<String, Object> getOptions() {
        return options;
    }

    public Integer getColumnType() {
        return columnType;
    }
}
