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

package models;


import com.jengine.orm.Meta;
import com.jengine.orm.ModelClass;
import com.jengine.orm.ModelQuery;
import com.jengine.orm.db.DBException;
import com.jengine.orm.field.Field;
import com.jengine.orm.field.ManyReferenceField;
import com.jengine.orm.field.PrimaryKey;
import com.jengine.orm.field.StringField;

import java.util.List;


@Meta(table = "SAuthor")
public class Author extends TestModel {
    public static Field authorId  = new PrimaryKey();
    public static Field firstName = new StringField("verbose", "First Name");
    public static Field lastName  = new StringField("verbose", "Last Name");
    public static ManyReferenceField books = new ManyReferenceField(Book.class);
    public static ModelClass<Author> cls = new ModelClass<Author>(Author.class);

    public Author() throws DBException {
        super();
    }

    public String getVerbose() throws DBException {
        return String.format("%s %s", getFirstName(), getLastName());
    }

    /* Getters and Setters */

    public void setAuthorId(Long value) throws DBException {
        setValue(authorId, value);
    }

    public Long getAuthorId() throws DBException {
        return (Long) getValue(authorId);
    }

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
