package com.jengine.orm;


import com.jengine.orm.db.DBConnection;
import com.jengine.orm.db.DBException;
import com.jengine.orm.db.cache.CacheManager;
import com.jengine.orm.db.provider.Provider;

import java.util.concurrent.ConcurrentHashMap;

public class DB {
    private String name;
    private Provider provider;
    public static ConcurrentHashMap<String, ModelClassBase> models = new ConcurrentHashMap<String, ModelClassBase>();

    public DB(Provider provider) {
        this("default", provider);
    }

    public DB(String name, Provider provider) {
        this.name = name;
        this.provider = provider;
    }

    public void register(ModelClassBase modelClass) {
        models.put(modelClass.getName(), modelClass);
        provider.register(modelClass.getManager().getTableName());
    }

    public ModelClassBase getModelClass(String name) {
        return models.get(name);
    }

    public DBConnection getConnection() throws DBException {
        return provider.getConnection();
    }

    public void closeConnection(DBConnection connection) throws DBException {
        provider.closeConnection(connection);
    }

    public Provider getProvider() {
        return provider;
    }

    public CacheManager getCacheManager() {
        return provider.getCacheManager();
    }

    @Override
    public String toString() {
        return "DB{" +
                "name='" + name + '\'' +
                '}';
    }
}
