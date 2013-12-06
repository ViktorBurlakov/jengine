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


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import static com.jengine.utils.CollectionUtil.map;

public class TimeField extends Field {
    private String timeFormat = "HH:mm:ss"; // ISO date time format


    public TimeField(Object... options) {
        super(Date.class, map(options));
    }

    public TimeField(Map<String, Object> options) {
        super(Date.class, options);
    }

    public TimeField(String name, Map<String, Object> options) {
        super(name, Date.class, options);
    }

    public void init() {
        super.init();
        if (options.containsKey("timeFormat")) {
            this.timeFormat = (String) options.get("timeFormat");
        }
    }

    public String getTimeFormat() {
        return timeFormat;
    }

    public void setTimeFormat(String timeFormat) {
        this.timeFormat = timeFormat;
    }

    public Object castType(Object value){
        if (String.class.isInstance(value)){
            try {

                return new SimpleDateFormat(timeFormat).parse((String) value);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return value;
    }

    public String format(Object value) {
        return new SimpleDateFormat(timeFormat).format(value);
    }
}
