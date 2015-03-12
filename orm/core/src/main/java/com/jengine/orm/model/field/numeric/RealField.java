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

package com.jengine.orm.model.field.numeric;


import com.jengine.orm.model.field.Field;

import java.util.Map;

import static com.cetus.jengine.utils.commons.CollectionUtil.map;

public class RealField extends Field {
    private Integer precision;
    private Integer scale;

    public RealField(RealField field) {
        super(field);
        this.precision = field.getPrecision();
        this.scale = field.getScale();

    }

    public RealField(Class fieldClass) {
        this(fieldClass, map());
    }

    public RealField(Class fieldClass, Map<String, Object> options) {
        super(fieldClass, options);
        if (options.containsKey("precision")) {
            precision = (Integer) options.get("precision");
        }
        if (options.containsKey("scale")) {
            scale = (Integer) options.get("scale");
        }
    }

    public Integer getPrecision() {
        return precision;
    }

    public void setPrecision(Integer precision) {
        this.precision = precision;
    }

    public Integer getScale() {
        return scale;
    }

    public void setScale(Integer scale) {
        this.scale = scale;
    }
}
