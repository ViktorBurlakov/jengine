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
