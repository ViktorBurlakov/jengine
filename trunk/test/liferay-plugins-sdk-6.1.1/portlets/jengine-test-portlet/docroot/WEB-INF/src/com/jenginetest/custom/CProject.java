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
import com.jengine.db.field.*;
import com.jenginetest.builder.model.WLProject;
import com.jenginetest.builder.model.impl.WLProjectImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import static com.jengine.utils.CollectionUtil.map;


public class CProject extends WLModel<WLProject> {
    public static ModelField projectId = new PrimaryKey("projectId");
    public static ModelField groupId = new LongField("groupId");
    public static ModelField companyId = new LongField("companyId");
    public static ModelField createUserId = new LongField("createUserId");
    public static ModelField createUserName = new StringField("createUserName");
    public static ModelField createDate = new DateTimeField("createDate");
    public static ModelField modifiedUserId = new LongField("modifiedUserId");
    public static ModelField modifiedUserName = new StringField("modifiedUserName");
    public static ModelField modifiedDate = new DateTimeField("modifiedDate");
    public static ModelField startDate = new DateField("startDate", map("verbose", "Start Date"));
    public static ModelField title = new StringField("title", map("verbose", "Title"));
    public static ModelField status = new IntegerField("status", map("verbose", "Status"));
    public static ModelField description = new StringField("description", map("verbose", "Description"));
    public static ModelField color = new StringField("color", map("verbose", "Color"));
    public static ModelField lockEnable = new BooleanField("lockEnable", map("verbose", "Auto Lock"));
    public static ModelField lockPeriodType = new StringField("lockPeriodType", map("verbose", "Lock in"));
    public static ModelField lockDeferment = new IntegerField("lockDeferment", map("verbose", "Lock Deferment"));
    public static ModelField automaticallyAssign = new BooleanField("automaticallyAssign", map("verbose", "Automatically assign newcomers"));
    public static ModelField defaultProject = new BooleanField("defaultProject");
    public static ModelField externalUrl = new StringField("externalUrl", map("verbose", "External Url"));
    public static ModelField externalMandatory = new BooleanField("externalMandatory", map("verbose", "External Mandatory"));

    @Manager
    public static ModelManager manager = new ModelManager(CProject.class, "Project", WLProject.class, WLProjectImpl.class,
            WLProjectImpl.TABLE_NAME, WLProjectImpl.TABLE_COLUMNS, WLProjectImpl.ENTITY_CACHE_ENABLED);
    static public ClassUtil<CProject> cls = new ClassUtil<CProject>(CProject.class);

    public CProject(Serializable id, Map<String, Map> serviceContext) throws SystemException, PortalException {
        super(id, serviceContext);
    }

    public CProject(WLProject object, Map<String, Map> serviceContext) {
        super(object, serviceContext);
    }

    public String getVerbose() throws SystemException, PortalException {
        return String.format("%s", getTitle());
    }

    public String getTitle() throws SystemException, PortalException {
        return (String) getValue("title");
    }

    public Date getStartDate() throws SystemException, PortalException {
        return (Date) getValue("startDate");
    }

    @ModelAttribute(name = "formattedStartDate", verbose = "Start Date", visible = false)
    public String getFormattedStartDate() throws SystemException, PortalException {
        return startDate.format(getStartDate());
    }

}
