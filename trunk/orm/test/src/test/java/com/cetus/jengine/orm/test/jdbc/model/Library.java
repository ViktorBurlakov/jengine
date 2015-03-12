/*
 *  This file is part of JEngine.
 *  *
 *  * Copyright (C) 2013-2014 Cetus (http://cs1.com.ua/). All rights reserved.
 *  *
 *  * JEngine is free software: you can redistribute it and/or modify
 *  * it under the terms of the GNU General Public License as published by
 *  * the Free Software Foundation, either version 3 of the License, or
 *  * (at your option) any later version.
 *  *
 *  * JEngine is distributed in the hope that it will be useful,
 *  * but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  * GNU General Public License for more details.
 *  *
 *  * You should have received a copy of the GNU General Public License
 *  * along with JEngine.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.cetus.jengine.orm.test.jdbc.model;


import com.cetus.jengine.orm.core.model.ModelClass;
import com.cetus.jengine.orm.core.model.query.ModelQuery;
import com.cetus.jengine.orm.core.db.DBException;
import com.cetus.jengine.orm.core.model.field.Field;
import com.cetus.jengine.orm.core.model.field.StringField;

import java.util.List;


public class Library extends TestModel {
    public static Field name    = new StringField("verbose", "Name");
    public static Field address = new StringField("verbose", "Address");
    public static ModelClass<Library> cls = new ModelClass<Library>(Library.class);


    public Library() throws DBException {
        super();
    }

    public String getVerbose() throws DBException {
        return String.format("%s", getName());
    }

    /* getters and setters block  */

    public void setName(String value) throws DBException {
        setValue(name, value);
    }

    public String getName() throws DBException {
        return (String) getValue(name);
    }

    public void setAddress(String value) throws DBException {
        setValue(address, value);
    }

    public String getAddress() throws DBException {
        return (String) getValue(address);
    }

    public ModelQuery getMembers() throws DBException {
        return (ModelQuery) getValue("member_set");
    }

    public List<Member> getMemberList() throws DBException {
        return getMembers().list();
    }
}
