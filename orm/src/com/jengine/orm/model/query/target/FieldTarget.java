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

package com.jengine.orm.model.query.target;

import com.jengine.orm.db.DBException;
import com.jengine.orm.db.query.SQLQuery;
import com.jengine.orm.model.multi.field.CalcMultiField;
import com.jengine.orm.model.multi.field.FunctionMultiField;
import com.jengine.orm.model.multi.field.MultiModelField;

import java.util.Iterator;

public class FieldTarget extends Target {
    protected MultiModelField multiModelField;

    public FieldTarget(String name) {
        super(name);
    }

    public FieldTarget(MultiModelField multiModelField) {
        super(multiModelField.getName());
        this.multiModelField = multiModelField;
    }

    public FieldTarget(String name, MultiModelField multiModelField) {
        super(name);
        this.multiModelField = multiModelField;
    }

    public String getSQLName() {
        return multiModelField.getSQLName();
    }

    public void setSQL(SQLQuery query) {
        if (multiModelField instanceof FunctionMultiField || multiModelField instanceof CalcMultiField) {
            query.addTarget(multiModelField.toSQL(), multiModelField.getSQLName());
        } else {
            query.addTarget(multiModelField.toSQL());
        }

    }

    public Object processResult(Iterator itr) throws DBException {
        return multiModelField.cast(super.processResult(itr));
    }
}
