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

package com.cetus.jengine.orm.ext.liferay.testportlet.test.model;



import com.cetus.jengine.orm.core.db.DBException;
import com.cetus.jengine.orm.core.model.Model;
import com.cetus.jengine.orm.core.model.field.Field;
import com.cetus.jengine.orm.core.model.field.StringField;

public class TestModel extends Model {
    public static Field enable = new StringField("default", "y");

    public TestModel() throws DBException {
        super();
    }
}
