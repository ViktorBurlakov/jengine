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

package com.cetus.jengine.orm.core.model.field.datetime;


import java.sql.Types;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.cetus.jengine.utils.commons.CollectionUtil.map;

public class DateTimeField extends BaseDateField {
    public static String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public DateTimeField(DateTimeField field) {
        super(field);
    }

    public DateTimeField() {
        this(new HashMap<String, Object>());
    }

    public DateTimeField(Object... options) {
        this(map(options));
    }

    public DateTimeField(Map<String, Object> options) {
        this(Date.class, options);
    }

    public DateTimeField(Class fieldClass, Map<String, Object> options) {
        super(fieldClass, options);
    }

    protected Map<String, Integer[]> getTypeMap() {
        return map(Date.class.getName(), new Integer[] { Types.TIMESTAMP, Types.BIGINT });
    }

    public String getDefaultFormat() {
        return DEFAULT_FORMAT;
    }
}
