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

import com.jengine.orm.ModelClass;
import com.jengine.orm.db.DBException;
import com.jengine.orm.field.Field;
import com.jengine.orm.field.PrimaryKey;
import com.jengine.orm.field.ReferenceField;
import com.jengine.orm.field.StringField;

import static com.jengine.utils.CollectionUtil.map;


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
