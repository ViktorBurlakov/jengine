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

package com.jengine.orm.field;


import com.jengine.orm.ModelManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class DateTimeField extends Field {
    private String dateFormat = "yyyy-MM-dd HH:mm:ss"; // ISO date time format

    public DateTimeField() {
        super(Date.class);
    }

    public DateTimeField(Object... options) {
        super(Date.class, options);
    }

    public DateTimeField( Map<String, Object> options) {
        super(Date.class, options);
    }

    public DateTimeField(String name, Map<String, Object> options) {
        super(name, Date.class, options);
    }

    public DateTimeField(ModelManager manager, String name, Map<String, Object> options) {
        super(manager, name, Date.class, options);
    }

    public void init() {
        super.init();
        if (options.containsKey("dateFormat")) {
            this.dateFormat = (String) options.get("dateFormat");
        }
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    public Object castType(Object value){
        if (Long.class.isInstance(value)) {
            return new Date((Long)value);
        } else if (String.class.isInstance(value)){
            try {

                return new SimpleDateFormat(dateFormat).parse((String) value);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return value;
    }

    public String format(Object value) {
        return new SimpleDateFormat(dateFormat).format(value);
    }
}
