/*
 * This file is part of JEngine.
 *
 * Copyright (C) 2013 Victor Burlakov
 *
 * JEngine is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JEngine is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with JEngine.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.jengine.db.provider;


import com.jengine.db.Model;
import com.jengine.db.ModelQuery;
import com.jengine.db.exception.DBException;

import java.util.ArrayList;
import java.util.List;


public class Provider {

    public Provider() {
    }

    public Object newPrimaryKey(Class cls) {
        return  0;
    }

    /* cache methods */
    public void cache(Model obj) {
    }

    public Model getCache(Class cls, Object id) {
        return null;
    }

    public void clearCache(Model obj) {
    }

    public void clearCache(Class cls) {
    }

    /* general methods */

    public void insert(ModelQuery modelQuery) throws DBException {
    }

    public void remove(ModelQuery modelQuery) throws DBException {
    }

    public void update(ModelQuery modelQuery) throws DBException{
    }

    public List select(ModelQuery modelQuery) throws DBException {
        return new ArrayList();
    }
}
