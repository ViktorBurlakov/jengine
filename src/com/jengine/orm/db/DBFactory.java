package com.jengine.orm.db;

import java.util.concurrent.ConcurrentHashMap;

public class DBFactory {
    public static ConcurrentHashMap<String, DB> dbMap = new ConcurrentHashMap<String, DB>();

    public static DB register(DB db) {
        return dbMap.put("default", db);
    }

    public static DB register(String name, DB db) {
        return dbMap.put(name, db);
    }

    public static DB get(String name) {
        return dbMap.get(name);
    }

    public static DB get() {
        return get("default");
    }
}
