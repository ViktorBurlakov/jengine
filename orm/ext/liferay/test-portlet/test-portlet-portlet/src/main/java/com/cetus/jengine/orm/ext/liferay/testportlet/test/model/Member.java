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

package com.cetus.jengine.orm.ext.liferay.testportlet.test.model;


import com.cetus.jengine.orm.core.db.DBException;
import com.cetus.jengine.orm.core.model.ModelClass;
import com.cetus.jengine.orm.core.model.field.Field;
import com.cetus.jengine.orm.core.model.field.PrimaryKey;
import com.cetus.jengine.orm.core.model.field.StringField;
import com.cetus.jengine.orm.core.model.field.reference.ReferenceField;

import static com.cetus.jengine.utils.commons.CollectionUtil.map;


public class Member extends TestModel {
    public static Field id = new PrimaryKey();
    public static Field firstName = new StringField("verbose", "First Name");
    public static Field lastName  = new StringField("verbose", "Last Name");
    public static Field account = new ReferenceField(Account.class, map("verbose", "Account", "required", false, "columnName", "userId"));
    public static Field library   = new ReferenceField(Library.class, map("verbose", "Library", "required", false));
    public static ModelClass<Member> cls = new ModelClass<Member>(Member.class);

    public Member() throws DBException {
        super();
    }

    public String getVerbose() throws DBException {
        return String.format("%s %s", getFirstName(), getLastName());
    }

    /* getters and setters block  */

    public void setFirstName(String value) throws DBException {
        setValue(firstName, value);
    }

    public String getFirstName() throws DBException {
        return (String) getValue(firstName);
    }

    public void setLastName(String value) throws DBException {
        setValue(lastName, value);
    }

    public String getLastName() throws DBException {
        return (String) getValue(lastName);
    }

    public void setLibrary(Library value) throws DBException {
        setValue(library, value);
    }

    public Library getLibrary() throws DBException {
        return (Library) getValue(library);
    }

    public Address getAddress() throws DBException {
        return (Address) getValue("address");
    }

    public void setAddress(Address value) throws DBException {
        setValue("address", value);
    }

    public Account getAccount() throws DBException {
        return (Account) getValue(account);
    }

    public void setAccount(Account value) throws DBException {
        setValue(account, value);
    }

}
