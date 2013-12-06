package com.jengine.db;


import com.jengine.db.provider.Provider;

public class DB {
    private String name;
    private Provider provider;
//    public static ConcurrentHashMap<String, ModelManager> managers = new ConcurrentHashMap<String, ModelManager>();

    public DB(Provider provider) {
        this("default", provider);
    }

    public DB(String name, Provider provider) {
        this.name = name;
        this.provider = provider;
    }

    public Provider getProvider() {
        return provider;
    }

    @Override
    public String toString() {
        return "DB{" +
                "name='" + name + '\'' +
                '}';
    }
}
