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


import java.util.Date;
import java.util.Map;

import static com.jengine.utils.CollectionUtil.map;


public class DateField extends BaseDateField {
    public static  String DEFAULT_FORMAT = "yyyy-MM-dd"; // ISO date format

    public DateField(DateField field) {
        super(field);
    }

    public DateField() {
        this(map());
    }

    public DateField(Object ... options) {
        this(map(options));
    }

    public DateField(Map<String, Object> options) {
        super(Date.class, options);
    }

    public String getDefaultFormat() {
        return DEFAULT_FORMAT;
    }
}
