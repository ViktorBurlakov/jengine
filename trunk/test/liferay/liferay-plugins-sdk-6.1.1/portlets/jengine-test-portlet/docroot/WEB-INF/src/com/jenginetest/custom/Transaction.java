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
import com.jengine.db.Meta;
import com.jengine.db.ModelManager;
import com.jengine.db.field.DateField;
import com.jengine.db.field.Field;
import com.jengine.db.field.PrimaryKey;
import com.jengine.db.field.ReferenceField;
import com.jenginetest.builder.model.STransaction;
import com.jenginetest.builder.model.impl.STransactionImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.Date;
import java.util.Map;

import static com.jengine.utils.CollectionUtil.map;

@Meta(table = STransactionImpl.TABLE_NAME)
public class Transaction extends CModel<STransaction, STransactionImpl> {
    public static Field transactionId = new PrimaryKey();
    public static Field book   = new ReferenceField(Book.class, map("verbose", "Book"));
    public static Field member = new ReferenceField(Member.class, map("verbose", "Member"));
    public static Field tdate  = new DateField("verbose", "Date");

    @Manager
    public static ModelManager manager = new ModelManager(Transaction.class);
    public static ClassObject<Transaction> cls = new ClassObject<Transaction>(Transaction.class);


    public Transaction() throws SystemException, PortalException {
    }

    public Transaction(Map<String, Map> serviceContext, Map values) throws SystemException, PortalException {
        super(serviceContext, values);
    }


    public String getVerbose() throws SystemException, PortalException {
        return String.format("%s: %s : %s", getDate(), getBook().getVerbose(), getMember().getVerbose());
    }

    /* getters and setters block  */

    public Book getBook() throws SystemException, PortalException {
        return (Book) getValue(book);
    }

    public Member getMember() throws SystemException, PortalException {
        return (Member) getValue(member);
    }

    public Date getDate() throws SystemException, PortalException {
        return (Date) getValue(tdate);
    }

}
