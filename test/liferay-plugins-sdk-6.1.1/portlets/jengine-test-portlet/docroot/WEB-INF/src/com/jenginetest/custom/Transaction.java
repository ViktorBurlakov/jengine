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
import com.jengine.db.ModelManager;
import com.jengine.db.field.DateField;
import com.jengine.db.field.ModelField;
import com.jengine.db.field.PrimaryKey;
import com.jengine.db.field.ReferenceField;
import com.jenginetest.builder.model.STransaction;
import com.jenginetest.builder.model.impl.STransactionImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import static com.jengine.utils.CollectionUtil.map;

public class Transaction extends CModel<STransaction> {
    public static ModelField transactionId = new PrimaryKey("transactionId");
    public static ModelField book = new ReferenceField("book", Book.class, map("verbose", "Book"));
    public static ModelField member = new ReferenceField("member", Member.class, map("verbose", "Member"));
    public static ModelField tdate = new DateField("tdate", map("verbose", "Date"));

    @Manager
    public static ModelManager manager = new ModelManager(Transaction.class, "Transaction", STransaction.class, STransactionImpl.class,
            STransactionImpl.TABLE_NAME, STransactionImpl.TABLE_COLUMNS, STransactionImpl.ENTITY_CACHE_ENABLED);
    static public ClassUtil<Transaction> cls = new ClassUtil<Transaction>(Transaction.class);


    public Transaction(Serializable id, Map<String, Map> serviceContext) throws SystemException, PortalException {
        super(id, serviceContext);
    }

    public Transaction(STransaction transaction, Map<String, Map> serviceContext) {
        super(transaction, serviceContext);
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
