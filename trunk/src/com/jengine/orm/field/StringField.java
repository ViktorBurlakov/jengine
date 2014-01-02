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


import com.jengine.orm.db.DBException;

import java.util.Map;

import static com.jengine.utils.CollectionUtil.map;

public class StringField extends Field {
    private Integer maxLength = null;

    public StringField(Object... options) {
        this(map(options));
    }

    public StringField(Map<String, Object> options) {
        super(String.class, options);
        if (options.containsKey("maxLength")) {
            maxLength = (Integer) options.get("maxLength");
        }
    }

    public void validate(String value) throws DBException {
        super.validate(value);
        if (maxLength != null && value != null && value.length() > maxLength) {
            throw new DBException(String.format("'%s' field validation error: max length < actual size (%s)", fieldName, value.length()));
        }
    }


    public Integer getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(Integer maxLength) {
        this.maxLength = maxLength;
    }
}