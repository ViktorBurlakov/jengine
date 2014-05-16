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

package com.jengine.orm.test.jdbc.model;


import com.jengine.orm.model.ModelClass;
import com.jengine.orm.model.query.ModelQuery;
import com.jengine.orm.db.DBException;
import com.jengine.orm.model.field.Field;
import com.jengine.orm.model.field.reference.ManyReferenceField;
import com.jengine.orm.model.field.PrimaryKey;
import com.jengine.orm.model.field.StringField;

import java.util.List;

public class Author extends TestModel {
    public static Field id  = new PrimaryKey();
    public static Field firstName = new StringField("verbose", "First Name");
    public static Field lastName  = new StringField("verbose", "Last Name");
    public static Field icon  = new StringField("verbose", "Icon", "default", "no_icon.img");
    public static ManyReferenceField books = new ManyReferenceField(Book.class);
    public static ModelClass<Author> cls = new ModelClass<Author>(Author.class);

    public Author() throws DBException {
        super();
    }

    public String getVerbose() throws DBException {
        return String.format("%s %s", getFirstName(), getLastName());
    }

    /* Getters and Setters */

    public void setFirstName(String value) throws DBException {
        setValue(firstName, value);
    }

    public String getFirstName() throws DBException {
        return (String) getValue(firstName);
    }

    public void setLastName(String value) throws DBException {
        setValue(lastName, value);
    }

    public String getLastName() throws DBException {
        return (String) getValue(lastName);
    }

    public ModelQuery getBooks() throws DBException {
        return (ModelQuery) getValue(books);
    }

    public void setBooks(List<Book> values) throws DBException {
        setValue(books, values);
    }
}
