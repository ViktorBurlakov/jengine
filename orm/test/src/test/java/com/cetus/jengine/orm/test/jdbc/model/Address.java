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

import com.cetus.jengine.orm.core.model.Meta;
import com.cetus.jengine.orm.core.model.ModelClass;
import com.cetus.jengine.orm.core.db.DBException;
import com.cetus.jengine.orm.core.model.field.Field;
import com.cetus.jengine.orm.core.model.field.StringField;
import com.cetus.jengine.orm.core.model.field.reference.SingleReferenceField;

import static com.cetus.jengine.utils.commons.CollectionUtil.map;

@Meta(table = "MemberAddress")
public class Address extends TestModel {
    public static Field street = new StringField("verbose", "Street");
    public static Field number = new StringField("verbose", "Building Number");
    public static Field member = new SingleReferenceField(Member.class, map("verbose", "Member"));
    public static ModelClass<Address> cls = new ModelClass<Address>(Address.class);

    public Address() throws DBException {
        super();
    }

    public String getVerbose() throws DBException {
        return String.format("%s %s", getNumber(), getStreet());
    }

    public String getStreet() throws DBException {
        return (String) getValue(street);
    }

    public void setStreet(String value) throws DBException {
        setValue(street,value);
    }

    public String getNumber() throws DBException {
        return (String) getValue(number);
    }

    public void setNumber(String value) throws DBException {
        setValue(number, value);
    }

    public Member getMember() throws DBException {
        return (Member) getValue(member);
    }

    public void setMember(Member obj) throws DBException {
        setValue(member, obj);
    }
}
