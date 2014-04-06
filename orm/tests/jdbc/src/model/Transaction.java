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

package model;


import com.jengine.orm.model.ModelClass;
import com.jengine.orm.db.DBException;
import com.jengine.orm.model.field.FunctionField;
import com.jengine.orm.model.field.datetime.DateField;
import com.jengine.orm.model.field.Field;
import com.jengine.orm.model.field.reference.ReferenceField;

import java.util.Date;

import static com.jengine.utils.CollectionUtil.map;


public class Transaction extends TestModel {
    public static Field book   = new ReferenceField(Book.class, map("verbose", "Book", "required", true));
    public static Field member = new ReferenceField(Member.class, map("verbose", "Member", "required", true));
    public static Field tdate  = new DateField("verbose", "Date", "required", true, "autoNowAdd", true);
    public static Field counter  = new FunctionField(Long.class, "%s + 1", "id");
//    public static Field counter  = new FunctionField(Long.class, "%s + 1", "book.id");
    public static Field modificationDate  = new DateField("verbose", "Modification Date", "required", true, "autoNow", true);
    public static ModelClass<Transaction> cls = new ModelClass<Transaction>(Transaction.class);


    public Transaction() throws DBException {
        super();
    }

    public String getVerbose() throws DBException {
        return String.format("%s: %s : %s", getDate(), getBook().getVerbose(), getMember().getVerbose());
    }

    /* getters and setters block  */

    public void setBook(Book obj) throws DBException {
        setValue(book, obj);
    }

    public Book getBook() throws DBException {
        return (Book) getValue(book);
    }

    public void setMember(Member obj) throws DBException {
        setValue(member, obj);
    }

    public Member getMember() throws DBException {
        return (Member) getValue(member);
    }

    public void setDate(Date d) throws DBException {
        setValue(tdate, d);
    }

    public Date getDate() throws DBException {
        return (Date) getValue(tdate);
    }

    public Long getCounter() throws DBException {
        return (Long) getValue(counter);
    }

    public Date getModificationDate() throws DBException {
        return (Date) getValue(modificationDate);
    }
}
