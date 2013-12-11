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

package com.jengine.utils;


import java.util.*;

public class CollectionUtil {

    public static List values(List keys, Map map) {
        List result = new ArrayList();

        for (Object key : keys) {
            result.add(map.get(key));
        }

        return result;
    }

    public static List newList(int length) {
        List result = new ArrayList();

        for (int i=0; i<length; i++) {
            result.add(null);
        }

        return result;
    }

    public static <Type> List<Type> newList(int length, Type value) {
        return fill(newList(length), value);
    }

    public static <Type> List<Type> fill(List<Type> input, Type value) {
        for(int i=0; i < input.size(); i++) {
            input.set(i, value);
        }

        return input;
    }

    public static StringBuffer concat(Collection collection, String separator) {
        StringBuffer result = new StringBuffer();

        for(Object item : collection) {
            if (result.length() > 0) {
                result.append(separator);
            }
            result.append(item);
        }

        return result;
    }

    public static List toList(Collection collection) {
        List list = new ArrayList();
        list.addAll(collection);
        return list;
    }

    public static List list(Object... values) {
        return Arrays.asList(values);
    }

    public static <V> LinkedHashMap<String, V> map(Object... values) {
        LinkedHashMap<String, V> result = new LinkedHashMap<String, V>();

        for(int i=0; i < values.length; i+=2) {
            result.put((String) values[i], (V) values[i+1]);
        }

        return  result;
    }

    public static HashMap<String, Object[]> toMap(Object[][] data) {
        HashMap<String, Object[]> result = new HashMap<String, Object[]>();
        for (int i=0; i < data.length; i++) {
            Object[] item = data[i];
            String key = (String) item[0];
            result.put(key, item);
        }
        return result;
    }

    public static Object getClassField(Class cls, String fieldName, Object defaultValue) {
        try {
            return cls.getDeclaredField(fieldName).get(cls);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return defaultValue;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            return defaultValue;
        }
    }
}
