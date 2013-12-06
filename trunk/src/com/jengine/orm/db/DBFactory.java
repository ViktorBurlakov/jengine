package com.jengine.orm.db;

import java.util.concurrent.ConcurrentHashMap;

public class DBFactory {
    public static ConcurrentHashMap<String, DB> dbMap = new ConcurrentHashMap<String, DB>();

    public static void register(DB db) {
        dbMap.put("default", db);
    }

    public static void register(String name, DB db) {
        dbMap.put(name, db);
    }

    public static DB get(String name) {
        return dbMap.get(name);
    }
}
