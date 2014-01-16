package com.jengine.orm.db.cache;


public interface CacheManager {

    public Cache getCache(String name);

    public Cache addCache(String name);

    public void removeCache(String name);

    public void shutdown();

}
