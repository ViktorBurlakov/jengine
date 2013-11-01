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

package com.jenginetest.custom;

import com.jengine.db.Manager;
import com.jengine.db.Meta;
import com.jengine.db.ModelManager;
import com.jengine.db.field.Field;
import com.jengine.db.field.PrimaryKey;
import com.jengine.db.field.ReferenceField;
import com.jengine.db.field.StringField;
import com.jenginetest.builder.model.SBook;
import com.jenginetest.builder.model.impl.SBookImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.Map;

import static com.jengine.utils.CollectionUtil.map;


@Meta(table = SBookImpl.TABLE_NAME)
public class Book extends CModel<SBook, SBookImpl> {
    public static Field bookId  = new PrimaryKey();
    public static Field title   = new StringField("verbose", "Title");
    public static Field library = new ReferenceField(Library.class, map("verbose", "Library"));

    @Manager
    public static ModelManager manager = new ModelManager(Book.class);
    public static ClassUtil<Book> cls = new ClassUtil<Book>(Book.class);


    public Book() throws SystemException, PortalException {
    }

    public Book(Map<String, Map> serviceContext) throws SystemException, PortalException {
        super(serviceContext);
    }


    public String getVerbose() throws SystemException, PortalException {
        return String.format("%s", getTitle());
    }

    /* getters and setters block  */

    public void setBookId(Long value) throws SystemException, PortalException {
        setValue(bookId, value);
    }

    public Long getBookId() throws SystemException, PortalException {
        return (Long) getValue(bookId);
    }

    public void setTitle(String value) throws SystemException, PortalException {
        setValue(title, value);
    }

    public String getTitle() throws SystemException, PortalException {
        return (String) getValue(title);
    }

    public void setLibrary(Library value) throws SystemException, PortalException {
        setValue(library, value);
    }

    public Library getLibrary() throws SystemException, PortalException {
        return (Library) getValue(library);
    }
}
