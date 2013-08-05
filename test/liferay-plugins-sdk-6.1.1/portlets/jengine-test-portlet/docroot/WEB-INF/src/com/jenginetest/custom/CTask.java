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


import com.jengine.db.CustomBaseModel;
import com.jengine.db.Manager;
import com.jengine.db.ModelManager;
import com.jengine.db.field.*;
import com.jenginetest.builder.model.WLTask;
import com.jenginetest.builder.model.impl.WLTaskImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.io.Serializable;
import java.util.Map;

import static com.jengine.utils.CollectionUtil.map;


public class CTask extends WLModel<WLTask> {
    public static ModelField taskId = new PrimaryKey("taskId");
    public static ModelField groupId = new LongField("groupId");
    public static ModelField companyId = new LongField("companyId");
    public static ModelField createUserId = new LongField("createUserId");
    public static ModelField createUserName = new StringField("createUserName");
    public static ModelField createDate = new DateTimeField("createDate");
    public static ModelField modifiedUserId = new LongField("modifiedUserId");
    public static ModelField modifiedUserName = new StringField("modifiedUserName");
    public static ModelField modifiedDate = new DateTimeField("modifiedDate");
    public static ModelField subject = new StringField("subject",map("verbose", "Name"));
    public static ModelField externalId = new StringField("externalId", map("verbose", "External Id"));
    public static ModelField project = new ReferenceField("project", CProject.class, map("verbose", "Project"));
    public static ModelField owner = new ReferenceField("owner", CUser.class, map("verbose", "User"));
    public static ModelField worker = new ReferenceField("worker", CUser.class, map("verbose", "Worker"));
    public static ModelField works = new MultiReferenceField("works", CWork.class, "task");

    @Manager
    static public ModelManager manager = new ModelManager(CTask.class, "Task", WLTask.class, WLTaskImpl.class,
            WLTaskImpl.TABLE_NAME, WLTaskImpl.TABLE_COLUMNS, WLTaskImpl.ENTITY_CACHE_ENABLED);
    static public CustomBaseModel.ClassUtil<CTask> cls = new CustomBaseModel.ClassUtil<CTask>(CTask.class);

    public CTask(Serializable id, Map<String, Map> serviceContext) throws SystemException, PortalException {
        super(id, serviceContext);
    }

    public CTask(WLTask object, Map<String, Map> serviceContext) {
        super(object, serviceContext);
    }

    public String getVerbose() throws SystemException, PortalException {
        return String.format("%s", getSubject());
    }

    public String getSubject() throws SystemException, PortalException {
        return (String) getValue("subject");
    }

    public CProject getProject() throws SystemException, PortalException {
        return (CProject) getValue("project");
    }

}
