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

import com.jengine.db.Meta;
import com.jengine.db.ModelClass;
import com.jengine.db.exception.DBException;
import com.jengine.db.field.Field;
import com.jengine.db.field.PrimaryKey;
import com.jengine.db.field.ReferenceField;
import com.jengine.db.field.StringField;

import static com.jengine.utils.CollectionUtil.map;


@Meta(table = "SBook")
public class Book extends TestModel {
    public static Field bookId  = new PrimaryKey();
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

    public void setBookId(Long value) throws DBException {
        setValue(bookId, value);
    }

    public Long getBookId() throws DBException {
        return (Long) getValue(bookId);
    }

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
