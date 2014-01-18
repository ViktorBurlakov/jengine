package com.jengine.orm.db.cache.ehcache;


import com.jengine.orm.db.cache.Cache;
import com.jengine.orm.db.cache.CacheManager;

public class EhcacheManager implements CacheManager {
    private net.sf.ehcache.CacheManager manager = null;

    public EhcacheManager(net.sf.ehcache.CacheManager manager) {
        this.manager = manager;
    }

    public Cache getCache(String name) {
        return manager.getCache(name) != null ? new EhcacheCache(manager.getCache(name)) : null;
    }

    public Cache addCache(String name) {
        manager.addCache(name);
        return getCache(name);
    }

    public void removeCache(String name) {
        manager.removeCache(name);
    }

    public void shutdown() {
        manager.shutdown();
    }
}
