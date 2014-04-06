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

package com.jengine.orm.model.field;


import java.util.HashMap;
import java.util.Map;

import static com.jengine.utils.CollectionUtil.map;

public class BooleanField extends Field {

    public BooleanField(BooleanField field) {
        super(field);
    }

    public BooleanField() {
        this(new HashMap<String, Object>());
    }

    public BooleanField(Object... options) {
        this(map(options));
    }

    public BooleanField(Map<String, Object> options) {
        super(Boolean.class, options);
    }
}
