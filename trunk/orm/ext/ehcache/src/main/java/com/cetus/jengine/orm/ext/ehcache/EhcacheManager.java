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
import com.cetus.jengine.orm.core.db.cache.CacheManager;

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
