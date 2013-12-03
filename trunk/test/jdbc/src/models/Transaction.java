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

import com.jengine.db.Meta;
import com.jengine.db.ModelClass;
import com.jengine.db.exception.DBException;
import com.jengine.db.field.DateField;
import com.jengine.db.field.Field;
import com.jengine.db.field.PrimaryKey;
import com.jengine.db.field.ReferenceField;

import java.util.Date;

import static com.jengine.utils.CollectionUtil.map;

@Meta(table = "STransaction")
public class Transaction extends TestModel {
    public static Field transactionId = new PrimaryKey();
    public static Field book   = new ReferenceField(Book.class, map("verbose", "Book"));
    public static Field member = new ReferenceField(Member.class, map("verbose", "Member"));
    public static Field tdate  = new DateField("verbose", "Date");
    public static ModelClass<Transaction> cls = new ModelClass<Transaction>(Transaction.class);


    public Transaction() throws DBException {
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
