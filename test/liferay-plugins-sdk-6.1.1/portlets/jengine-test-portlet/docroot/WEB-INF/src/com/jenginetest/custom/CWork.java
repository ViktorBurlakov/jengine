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
import com.jengine.utils.CalendarUtil;
import com.jenginetest.builder.model.WLEntry;
import com.jenginetest.builder.model.impl.WLEntryImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import static com.jengine.utils.CollectionUtil.map;


public class CWork extends WLModel<WLEntry> {
    public static ModelField entryId = new PrimaryKey("entryId");
    public static ModelField createUserId = new LongField("createUserId");
    public static ModelField createUserName = new StringField("createUserName");
    public static ModelField createDate = new DateTimeField("createDate");
    public static ModelField modifiedUserId = new LongField("modifiedUserId");
    public static ModelField modifiedUserName = new StringField("modifiedUserName");
    public static ModelField modifiedDate = new DateTimeField("modifiedDate");
    public static ModelField entryDate = new DateField("entryDate", map("verbose", "Entry Date"));
    public static ModelField start = new DateTimeField("start", map("dbName", "start_"));
    public static ModelField length = new DurationField("length", map("verbose", "Duration"));
    public static ModelField task = new ReferenceField("task", CTask.class, map("verbose", "Task"));

    @Manager
    static public ModelManager manager = new ModelManager(CWork.class, "Task Entry", WLEntry.class, WLEntryImpl.class,
            WLEntryImpl.TABLE_NAME, WLEntryImpl.TABLE_COLUMNS, WLEntryImpl.ENTITY_CACHE_ENABLED);
    static public CustomBaseModel.ClassUtil<CWork> cls = new CustomBaseModel.ClassUtil<CWork>(CWork.class);


    public CWork(Serializable id, Map<String, Map> serviceContext) throws SystemException, PortalException {
        super(id, serviceContext);
    }

    public CWork(WLEntry object, Map<String, Map> serviceContext) {
        super(object, serviceContext);
    }

    public String getVerbose() throws SystemException, PortalException {
        return String.format("%s", getFormattedEntryDate());
    }

    public CTask getTask() throws SystemException, PortalException {
        return (CTask) getValue("task");
    }

    public Date getEntryDate() throws SystemException, PortalException {
        return (Date) getValue("entryDate");
    }

    public long getDuration() throws SystemException, PortalException {
        return  (Long) getValue("length");
    }

    @ModelAttribute(name = "formattedEntryDate", verbose = "Entry Date", visible = false)
    public String getFormattedEntryDate() throws SystemException, PortalException {
        return entryDate.format(getEntryDate());
    }

    @ModelAttribute(name = "formattedDuration", verbose = "Duration", visible = false)
    public String getFormattedDuration() throws SystemException, PortalException {
        return length.format(getDuration());
    }

    // inner class
    public static class DurationField extends LongField {

        public DurationField(String name, Map<String, Object> options) {
            super(name, options);
        }

        public String format(Object value) {
            return CalendarUtil.formatTime((Long) value);
        }
    };
}
