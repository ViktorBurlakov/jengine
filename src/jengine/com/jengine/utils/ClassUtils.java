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


public class ClassUtils {

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

}
