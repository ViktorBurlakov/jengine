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

package com.jengine.db.field;


import com.jengine.db.CBaseModel;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.HashMap;
import java.util.Map;

import static com.jengine.utils.CollectionUtil.map;

public class PrimaryKey extends Field {

    public PrimaryKey() {
        this(new HashMap<String, Object>());
    }

    public PrimaryKey(Object ... options) {
        this(map(options));
    }

    public PrimaryKey(Map<String, Object> options) {
        this(Long.class, options);
    }

    public PrimaryKey(Class fieldClass, Map<String, Object> options) {
        super(fieldClass, options);
    }

    public PrimaryKey(String name, Class fieldClass, Map<String, Object> options) {
        super(name, fieldClass, options);
    }

    public void init() {
        primaryKey = true;
        super.init();
    }

    public Object castType(Object value) throws SystemException, PortalException {
        return value instanceof CBaseModel ? ((CBaseModel) value).getPrimaryKey() : new Long(String.valueOf(value));
    }
}
