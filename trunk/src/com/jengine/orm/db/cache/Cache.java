package com.jengine.orm.db.cache;


public interface Cache {

    public Object get(Object key);

    public void set(Object key, Object value);

    public void remove(Object key);

    public void removeAll();

}
