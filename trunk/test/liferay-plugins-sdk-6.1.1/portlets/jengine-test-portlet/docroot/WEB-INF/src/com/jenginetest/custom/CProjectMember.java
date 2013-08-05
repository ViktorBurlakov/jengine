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
import com.jengine.db.field.LongField;
import com.jengine.db.field.ModelField;
import com.jengine.db.field.PrimaryKey;
import com.jengine.db.field.ReferenceField;
import com.jenginetest.builder.model.WLProjectUser;
import com.jenginetest.builder.model.impl.WLProjectUserImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.io.Serializable;
import java.util.Map;

import static com.jengine.utils.CollectionUtil.map;


public class CProjectMember extends WLModel<WLProjectUser> {
    public static ModelField projectUserId = new PrimaryKey("projectUserId");
    public static ModelField groupId = new LongField("groupId");
    public static ModelField companyId = new LongField("companyId");
    public static ModelField project = new ReferenceField("project", CProject.class, map("verbose", "Project"));
    public static ModelField user = new ReferenceField("user", CUser.class, map("verbose", "User"));

    @Manager
    static public ModelManager manager = new ModelManager(CProjectMember.class, "Project Membership", WLProjectUser.class, WLProjectUserImpl.class,
            WLProjectUserImpl.TABLE_NAME, WLProjectUserImpl.TABLE_COLUMNS, WLProjectUserImpl.ENTITY_CACHE_ENABLED);
    static public ClassUtil<CProjectMember> cls = new ClassUtil<CProjectMember>(CProjectMember.class);


    public CProjectMember(Serializable id, Map<String, Map> serviceContext) throws SystemException, PortalException {
        super(id, serviceContext);
    }

    public CProjectMember(WLProjectUser object, Map<String, Map> serviceContext) {
        super(object, serviceContext);
    }

    public String getVerbose() throws SystemException, PortalException {
        CProject project = getProject();
        CUser user = getUser();
        return String.format("Member %s of project %s", user.getVerbose(), project.getTitle());
    }

    public CProject getProject() throws SystemException, PortalException {
        return (CProject) getValue("project");
    }

    public CUser getUser() throws SystemException, PortalException {
        return (CUser) getValue("user");
    }

}
