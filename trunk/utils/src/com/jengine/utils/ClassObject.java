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

package com.jengine.utils;


import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ClassObject {
    public static Map<String, ClassObject> classMap = new ConcurrentHashMap<String, ClassObject>();

    protected LinkedHashMap<String, Field> fieldMap = new LinkedHashMap<String, Field>();
    protected Class cls;

    public ClassObject(Class cls) {
        this.cls = cls;

        for(Field field : cls.getDeclaredFields()) {
            fieldMap.put(field.getName(), field);
        }

        classMap.put(cls.getName(), this);
    }

    public static ClassObject getClassObject(Class cls) {
        return classMap.get(cls.getName());
    }
}
