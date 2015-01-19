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

package com.jengine.orm.model.query.target;

import com.jengine.orm.db.DBException;
import com.jengine.orm.db.query.SQLQuery;
import com.jengine.orm.model.query.BaseQuery;

import java.util.Iterator;

public abstract class Target {
    protected BaseQuery query;
    protected String name;

    protected Target(String name) {
        this.name = name;
    }

    public void config(BaseQuery query) {
        this.query = query;
    }

    public String getName() {
        return name;
    }

    abstract public String getSQLName();

    abstract public void setSQL(SQLQuery query);

    public Object processResult(Iterator itr) throws DBException {
        return itr.next();
    }
}
