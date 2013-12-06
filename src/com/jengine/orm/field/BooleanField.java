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

import java.util.Map;

public class BooleanField extends Field {

    public BooleanField() {
        super(Boolean.class);
    }

    public BooleanField(Object... options) {
        super(Boolean.class, options);
    }

    public BooleanField(Map<String, Object> options) {
        super(Boolean.class, options);
    }

    public BooleanField(String name, Map<String, Object> options) {
        super(name, Boolean.class, options);
    }

    public BooleanField(ModelManager manager, String name, Map<String, Object> options) {
        super(manager, name, Boolean.class, options);
    }
}
