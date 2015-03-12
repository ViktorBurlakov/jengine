/*
 *  This file is part of JEngine.
 *  *
 *  * Copyright (C) 2013-2014 Cetus (http://cs1.com.ua/). All rights reserved.
 *  *
 *  * JEngine is free software: you can redistribute it and/or modify
 *  * it under the terms of the GNU General Public License as published by
 *  * the Free Software Foundation, either version 3 of the License, or
 *  * (at your option) any later version.
 *  *
 *  * JEngine is distributed in the hope that it will be useful,
 *  * but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  * GNU General Public License for more details.
 *  *
 *  * You should have received a copy of the GNU General Public License
 *  * along with JEngine.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.cetus.jengine.orm.ext.ehcache;


import com.cetus.jengine.orm.core.db.cache.Cache;
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
