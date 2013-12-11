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

package com.jengine.orm.field;


import java.util.*;


public class FunctionField extends Field {
    private String expression = "";
    private List attributes = new ArrayList();

    public FunctionField(Class fieldClass, String expression, Object ... attributes) {
        this(fieldClass, new HashMap<String, Object>(), expression, attributes);
    }

    public FunctionField(Class fieldClass, Map<String, Object> options, String expression, Object ... attributes) {
        super(fieldClass, options);
        this.type = Type.FUNCTION;
        this.expression = expression;
        this.attributes = new ArrayList(Arrays.asList(attributes));
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
