/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.jenginetest.builder.model.impl;

import com.jenginetest.builder.model.STransaction;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing STransaction in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see STransaction
 * @generated
 */
public class STransactionCacheModel implements CacheModel<STransaction>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{transactionId=");
		sb.append(transactionId);
		sb.append(", bookId=");
		sb.append(bookId);
		sb.append(", memberId=");
		sb.append(memberId);
		sb.append(", tdate=");
		sb.append(tdate);
		sb.append("}");

		return sb.toString();
	}

	public STransaction toEntityModel() {
		STransactionImpl sTransactionImpl = new STransactionImpl();

		sTransactionImpl.setTransactionId(transactionId);
		sTransactionImpl.setBookId(bookId);
		sTransactionImpl.setMemberId(memberId);

		if (tdate == Long.MIN_VALUE) {
			sTransactionImpl.setTdate(null);
		}
		else {
			sTransactionImpl.setTdate(new Date(tdate));
		}

		sTransactionImpl.resetOriginalValues();

		return sTransactionImpl;
	}

	public long transactionId;
	public long bookId;
	public long memberId;
	public long tdate;
}