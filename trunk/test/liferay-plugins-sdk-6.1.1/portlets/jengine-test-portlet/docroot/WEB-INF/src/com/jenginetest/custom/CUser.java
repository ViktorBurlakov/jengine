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
import com.jengine.db.field.IntegerField;
import com.jengine.db.field.ModelField;
import com.jengine.db.field.PrimaryKey;
import com.jengine.db.field.StringField;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;

import java.util.Map;

import static com.jengine.utils.CollectionUtil.map;


public class CUser extends WLModel<User> {
    public static ModelField userId = new PrimaryKey("userId");
    public static ModelField screenName = new StringField("screenName", map("verbose", "Screen Name"));
    public static ModelField emailAddress = new StringField("emailAddress", map("verbose", "Email Address"));
    public static ModelField firstName = new StringField("firstName", map("verbose", "First Name"));
    public static ModelField middleName = new StringField("middleName", map("verbose", "Middle Name"));
    public static ModelField lastName = new StringField("lastName", map("verbose", "Last Name"));
    public static ModelField status = new IntegerField("status", map("verbose", "Status"));

    @Manager
    public static ModelManager manager = new ModelManager(CUser.class, "User", User.class, null, "User", new Object[][] {}, false);
    static public CustomBaseModel.ClassUtil<CUser> cls = new CustomBaseModel.ClassUtil<CUser>(CUser.class);


    public CUser(User object, Map<String, Map> serviceContext) {
        super(object, serviceContext);
    }

    public String getVerbose() throws SystemException, PortalException {
        return String.format("%s %s", this.object.getFirstName(), this.object.getLastName());
    }
}
