package com.jengine.orm.db.provider.mysql;


import com.jengine.orm.db.adapter.Adapter;
import com.jengine.orm.db.cache.CacheManager;
import com.jengine.orm.db.provider.Provider;

public class MySQLProvider extends Provider {

    public MySQLProvider(Adapter adapter) {
        super(adapter);
    }

    public MySQLProvider(Adapter adapter, CacheManager cacheManager) {
        super(adapter, cacheManager);
    }
}
