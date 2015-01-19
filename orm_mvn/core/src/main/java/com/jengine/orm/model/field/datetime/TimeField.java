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

package com.jengine.orm.model.field.datetime;


import java.sql.Types;
import java.util.Date;
import java.util.Map;

import static com.jengine.utils.commons.CollectionUtil.map;

public class TimeField extends BaseDateField {
    public static String DEFAULT_FORMAT = "HH:mm:ss"; // ISO date time format

    public TimeField(TimeField field) {
        super(field);
    }

    public TimeField(Object... options) {
        this(map(options));
    }

    public TimeField(Map<String, Object> options) {
        super(Date.class, options);
    }

    protected Map<String, Integer[]> getTypeMap() {
        return map(Date.class.getName(), new Integer[] { Types.TIME, Types.TIMESTAMP });
    }

    public String getDefaultFormat() {
        return DEFAULT_FORMAT;
    }
}
