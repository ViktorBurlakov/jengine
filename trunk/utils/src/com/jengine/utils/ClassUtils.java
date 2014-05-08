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


import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.jengine.utils.StringUtil.uncaps;

public class ClassUtils {
    public static List<String> GETTERS_MODIFICATIONS = CollectionUtil.list("is", "get");
    public static List<String> SETTERS_MODIFICATIONS = CollectionUtil.list("set");

    public static LinkedHashMap<String, Class> reflectBeanInterface(Class interfaceClass) {
        LinkedHashMap<String, Class> getters = new LinkedHashMap<String, Class>();
        LinkedHashMap<String, Class> setters = new LinkedHashMap<String, Class>();
        LinkedHashMap<String, Class> result = new LinkedHashMap<String, Class>();

        for (Method method : interfaceClass.getMethods()) {
            for (String modificator: GETTERS_MODIFICATIONS) {
                if (method.getName().startsWith(modificator)) {
                    String fieldName = uncaps(method.getName().substring(modificator.length()));
                    Class fieldClass = method.getReturnType();
                    getters.put(fieldName, fieldClass);
                }
            }
        }

        for (Method method : interfaceClass.getMethods()) {
            for (String modificator: SETTERS_MODIFICATIONS) {
                if (method.getName().startsWith(modificator)) {
                    String fieldName = uncaps(method.getName().substring(modificator.length()));
                    if (method.getParameterTypes().length > 0) {
                        Class fieldClass = method.getParameterTypes()[0];
                        setters.put(fieldName, fieldClass);
                    }
                }
            }
        }

        for(String fieldName : getters.keySet()) {
            if (setters.containsKey(fieldName)) {
                result.put(fieldName, getters.get(fieldName));
            }
        }

        return result;
    }

    public static Map annotationToMap(Object iface) {
        Map result = new HashMap();

        for (Method method : iface.getClass().getDeclaredMethods()) {
            try {
                result.put(method.getName(), method.invoke(iface));
            } catch (Exception e) {
            }
        }

        return result;
    }

    public static Map annotationToMap(Class iface) {
        Map result = new HashMap();

        if (iface.isInterface()) {
            for (Method method : iface.getDeclaredMethods()) {
                result.put(method.getName(), method.getDefaultValue());
            }
        }

        return result;
    }
    /**
     *  returns the class (without the package if any)
     * @param
     * @return
     */
    public static String getClassName(String className) {
        int firstCharIndex = className.lastIndexOf ('.') + 1;
        return firstCharIndex > 0  ? className.substring (firstCharIndex) : className;
    }

    /**
     * returns the package without the classname, empty string if
     * there is no package
     * @param className
     * @return
     */
    public static String getPackageName(String className) {
        int lastPointIndex = className.lastIndexOf('.');
        return lastPointIndex == -1 ? "" : className.substring (0, lastPointIndex);
    }

    public  static void forceInit(Class clazz) {
        try {
            Class.forName(clazz.getName(), true, clazz.getClassLoader());
        } catch (ClassNotFoundException e) {
            throw new AssertionError(e);  // Can't happen
        }
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

    @SuppressWarnings("unchecked")
    public static Class getGenericSuperclassType(Class cls, int index) {
        return (Class) ((ParameterizedType) cls.getGenericSuperclass()).getActualTypeArguments()[index];
    }

    public static boolean isGetter(Method method) {
        if (Modifier.isPublic(method.getModifiers()) &&
                method.getParameterTypes().length == 0) {
            if (method.getName().matches("^get[A-Z].*") &&
                    !method.getReturnType().equals(void.class))
                return true;
            if (method.getName().matches("^is[A-Z].*") &&
                    method.getReturnType().equals(boolean.class))
                return true;
        }
        return false;
    }

    public static boolean isSetter(Method method) {
        return Modifier.isPublic(method.getModifiers()) &&
                method.getReturnType().equals(void.class) &&
                method.getParameterTypes().length == 1 &&
                method.getName().matches("^set[A-Z].*");
    }
}
