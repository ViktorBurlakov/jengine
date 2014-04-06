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

package com.jengine.orm.model.field;


import com.jengine.orm.model.Model;
import com.jengine.orm.db.DBException;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ModelProperty extends Field {
    private String methodName;

    public ModelProperty(ModelProperty field) {
        super(field);
        this.methodName = field.getMethodName();
    }

    public ModelProperty(String methodName, Class fieldClass) {
        this(methodName, fieldClass, new HashMap<String, Object>());
    }

    public ModelProperty(String methodName, Class fieldClass, Map<String, Object> options) {
        super(fieldClass, options);
        this.methodName = methodName;
    }

    public Type getType() {
        return Type.PROPERTY;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object getValue(Model obj) throws DBException {
        try {
            Method method = obj.getClass().getMethod(methodName);
            return method.invoke(obj);
        } catch (Exception e) {
            throw new DBException(e);
        }
    }

    public boolean isPersistence() {
        return false;
    }
}
