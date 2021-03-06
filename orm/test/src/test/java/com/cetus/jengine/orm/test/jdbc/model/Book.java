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

package com.cetus.jengine.orm.test.jdbc.model;

import com.cetus.jengine.orm.core.model.ModelClass;
import com.cetus.jengine.orm.core.db.DBException;
import com.cetus.jengine.orm.core.model.field.Field;
import com.cetus.jengine.orm.core.model.field.PrimaryKey;
import com.cetus.jengine.orm.core.model.field.reference.ReferenceField;
import com.cetus.jengine.orm.core.model.field.StringField;

import static com.cetus.jengine.utils.commons.CollectionUtil.map;


public class Book extends TestModel {
    public static Field id  = new PrimaryKey();
    public static Field title   = new StringField("verbose", "Title");
    public static Field library = new ReferenceField(Library.class, map("verbose", "Library"));
    public static ModelClass<Book> cls = new ModelClass<Book>(Book.class);

    public Book() throws DBException {
        super();
    }

    public String getVerbose() throws DBException {
        return String.format("%s", getTitle());
    }

    /* getters and setters block  */

    public void setTitle(String value) throws DBException {
        setValue(title, value);
    }

    public String getTitle() throws DBException {
        return (String) getValue(title);
    }

    public void setLibrary(Library value) throws DBException {
        setValue(library, value);
    }

    public Library getLibrary() throws DBException {
        return (Library) getValue(library);
    }
}
