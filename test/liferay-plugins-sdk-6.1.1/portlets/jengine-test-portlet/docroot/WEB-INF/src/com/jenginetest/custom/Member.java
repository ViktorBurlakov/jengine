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
import com.jengine.db.ModelManager;
import com.jengine.db.field.Field;
import com.jengine.db.field.PrimaryKey;
import com.jengine.db.field.ReferenceField;
import com.jengine.db.field.StringField;
import com.jenginetest.builder.model.SMember;
import com.jenginetest.builder.model.impl.SMemberImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.io.Serializable;
import java.util.Map;

import static com.jengine.utils.CollectionUtil.map;

public class Member extends CModel<SMember> {
    public static Field memberId  = new PrimaryKey();
    public static Field firstName = new StringField("verbose", "First Name");
    public static Field lastName  = new StringField("verbose", "Last Name");
    public static Field library   = new ReferenceField(Library.class, map("verbose", "Library"));

    @Manager
    public static ModelManager manager = new ModelManager(Member.class, "Member", SMember.class, SMemberImpl.class,
            SMemberImpl.TABLE_NAME, SMemberImpl.TABLE_COLUMNS, SMemberImpl.ENTITY_CACHE_ENABLED);
    static public ClassUtil<Member> cls = new ClassUtil<Member>(Member.class);


    public Member(Serializable id, Map<String, Map> serviceContext) throws SystemException, PortalException {
        super(id, serviceContext);
    }

    public Member(SMember member, Map<String, Map> serviceContext) {
        super(member, serviceContext);
    }

    public String getVerbose() throws SystemException, PortalException {
        return String.format("%s %s", getFirstName(), getLastName());
    }

    /* getters and setters block  */

    public String getFirstName() throws SystemException, PortalException {
        return (String) getValue(firstName);
    }

    public String getLastName() throws SystemException, PortalException {
        return (String) getValue(lastName);
    }

    public Library getLibrary() throws SystemException, PortalException {
        return (Library) getValue(library);
    }
}
