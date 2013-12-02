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


import com.jengine.db.exception.DBException;

import java.util.Map;

public interface IModelField {
    Object castType(Object value) throws DBException;

    String format(Object value) throws DBException;

    String getServiceName();

    String getDbName();

    String getName();

    String getVerbose();

    Class getFieldClass();

    int getDbType();

    boolean isReference();

    boolean isProperty();

    boolean isKey();

    boolean isPrimaryKey();

    boolean isVisible();

    Class getModel();

    Map<String, Object> toMap();
}
