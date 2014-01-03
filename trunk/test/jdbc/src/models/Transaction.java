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

package models;


import com.jengine.orm.ModelClass;
import com.jengine.orm.db.DBException;
import com.jengine.orm.field.datetime.DateField;
import com.jengine.orm.field.Field;
import com.jengine.orm.field.reference.ReferenceField;

import java.util.Date;

import static com.jengine.utils.CollectionUtil.map;


public class Transaction extends TestModel {
    public static Field book   = new ReferenceField(Book.class, map("verbose", "Book"));
    public static Field member = new ReferenceField(Member.class, map("verbose", "Member"));
    public static Field tdate  = new DateField("verbose", "Date");
    public static Field modificationDate  = new DateField("verbose", "Modification Date", "required", true, "autoNow", true);
    public static ModelClass<Transaction> cls = new ModelClass<Transaction>(Transaction.class);


    public Transaction() throws DBException {
        super();
    }

    public String getVerbose() throws DBException {
        return String.format("%s: %s : %s", getDate(), getBook().getVerbose(), getMember().getVerbose());
    }

    /* getters and setters block  */

    public Book getBook() throws DBException {
        return (Book) getValue(book);
    }

    public Member getMember() throws DBException {
        return (Member) getValue(member);
    }

    public Date getDate() throws DBException {
        return (Date) getValue(tdate);
    }
}
