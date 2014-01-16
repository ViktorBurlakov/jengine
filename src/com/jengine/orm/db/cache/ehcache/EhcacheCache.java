package com.jengine.orm.db.cache.ehcache;


import com.jengine.orm.db.cache.Cache;
import net.sf.ehcache.Element;

public class EhcacheCache implements Cache {
    private net.sf.ehcache.Cache cache;

    public EhcacheCache(net.sf.ehcache.Cache cache) {
        this.cache = cache;
    }

    public Object get(Object key) {
        return cache.get(key) != null ? cache.get(key).getObjectValue() : null;
    }

    public void set(Object key, Object value) {
        cache.put(new Element(key, value));
    }

    public void remove(Object key) {
        cache.remove(key);
    }

    public void removeAll() {
        cache.removeAll();
    }
}
