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

package com.jengine.db.field;


import com.jengine.db.ModelManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class FunctionField extends Field {
    private String expression = "";
    private List attributes = new ArrayList();

    public FunctionField(Class fieldClass, String expr, Object ... attributes) {
        super(fieldClass);
        this.expression = expr;
        this.attributes = new ArrayList(Arrays.asList(attributes));
    }

    public FunctionField(String name, Class fieldClass, String expression, Object ... attributes) {
        super(name, fieldClass);
        this.expression = expression;
        this.attributes = new ArrayList(Arrays.asList(attributes));
    }

    public FunctionField(String name, Class fieldClass, Map<String, Object> options, String expression, Object ... attributes) {
        super(name, fieldClass, options);
        this.expression = expression;
        this.attributes = new ArrayList(Arrays.asList(attributes));
    }

    public FunctionField(ModelManager manager, String name, Class fieldClass, String expression, Object ... attributes) {
        super(manager, name, fieldClass);
        this.expression = expression;
        this.attributes = new ArrayList(Arrays.asList(attributes));
    }

    public FunctionField(ModelManager manager, String name, Class fieldClass, Map<String, Object> options, String expression, Object ... attributes) {
        super(manager, name, fieldClass, options);
        this.expression = expression;
        this.attributes = new ArrayList(Arrays.asList(attributes));
    }

    public boolean isFunction() {
        return true;
    }

    public String render(List<String> attributes) {
        return String.format(expression, attributes.toArray());
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public void setAttributes(List attributes) {
        this.attributes = attributes;
    }

    public List getAttributes() {
        return attributes;
    }

    public String getExpression() {
        return expression;
    }
}
