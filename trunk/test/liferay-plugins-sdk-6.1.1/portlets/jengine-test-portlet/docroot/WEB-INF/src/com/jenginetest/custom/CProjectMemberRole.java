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
import com.jenginetest.builder.model.WLProjectUserRole;
import com.jenginetest.builder.model.impl.WLProjectUserRoleImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Role;
import com.liferay.portal.service.RoleLocalServiceUtil;

import java.io.Serializable;
import java.util.Map;

import static com.jengine.utils.CollectionUtil.map;


public class CProjectMemberRole extends WLModel<WLProjectUserRole> {
    public static ModelField projectUserRoleId = new PrimaryKey("projectUserRoleId");
    public static ModelField groupId = new LongField("groupId");
    public static ModelField companyId = new LongField("companyId");
    public static ModelField projectUser = new ReferenceField("projectUser", CProjectMember.class);
    public static ModelField roleId = new LongField("roleId", map("verbose", "Project Role"));

    @Manager
    static public ModelManager manager = new ModelManager(CProjectMemberRole.class, "Membership Role", WLProjectUserRole.class,
            WLProjectUserRoleImpl.class, WLProjectUserRoleImpl.TABLE_NAME, WLProjectUserRoleImpl.TABLE_COLUMNS, WLProjectUserRoleImpl.ENTITY_CACHE_ENABLED);
    static public ClassUtil<CProjectMemberRole> cls = new ClassUtil<CProjectMemberRole>(CProjectMemberRole.class);


    public CProjectMemberRole(Serializable id, Map<String, Map> serviceContext) throws SystemException, PortalException {
        super(id, serviceContext);
    }

    public CProjectMemberRole(WLProjectUserRole object, Map<String, Map> serviceContext) {
        super(object, serviceContext);
    }

    public String getVerbose() throws SystemException, PortalException {
        return String.format("%s - %s - %s", getProject().getTitle(), getUser().getVerbose(), getRole().getTitle());
    }

    public CProject getProject() throws SystemException, PortalException {
        return (CProject) getValue("projectUser.project");
    }

    public CUser getUser() throws SystemException, PortalException {
        return (CUser) getValue("projectUser.user");
    }

    public Role getRole() throws SystemException, PortalException {
        return RoleLocalServiceUtil.getRole((Long) getValue("role"));
    }
}
