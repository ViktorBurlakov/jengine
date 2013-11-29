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
import com.jengine.db.field.StringField;
import com.jenginetest.builder.model.SAuthor;
import com.jenginetest.builder.model.impl.SAuthorImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import java.util.Map;


@Meta(table = SAuthorImpl.TABLE_NAME)
public class Author extends CModel<SAuthor, SAuthorImpl> {
    public static Field authorId  = new PrimaryKey();
    public static Field firstName = new StringField("verbose", "First Name");
    public static Field lastName  = new StringField("verbose", "Last Name");

    @Manager
    public static ModelManager manager = new ModelManager(Author.class);
    public static ClassObject<Author> cls = new ClassObject<Author>(Author.class);


    public Author() throws SystemException, PortalException {
        super();
    }

    public Author(Map<String, Map> serviceContext) throws SystemException, PortalException {
        super(serviceContext);
    }

    public String getVerbose() throws SystemException, PortalException {
        return String.format("%s %s", getFirstName(), getLastName());
    }

    /* Getters and Setters */

    public void setAuthorId(Long value) throws SystemException, PortalException {
        setValue(authorId, value);
    }

    public Long getAuthorId() throws SystemException, PortalException {
        return (Long) getValue(authorId);
    }

    public void setFirstName(String value) throws SystemException, PortalException {
        setValue(firstName, value);
    }

    public String getFirstName() throws SystemException, PortalException {
        return (String) getValue(firstName);
    }

    public void setLastName(String value) throws SystemException, PortalException {
        setValue(lastName, value);
    }

    public String getLastName() throws SystemException, PortalException {
        return (String) getValue(lastName);
    }
}