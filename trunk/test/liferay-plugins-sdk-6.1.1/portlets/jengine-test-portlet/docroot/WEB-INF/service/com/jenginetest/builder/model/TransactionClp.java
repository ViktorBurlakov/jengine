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

package com.jenginetest.builder.model;

import com.jenginetest.builder.service.TransactionLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class TransactionClp extends BaseModelImpl<Transaction>
	implements Transaction {
	public TransactionClp() {
	}

	public Class<?> getModelClass() {
		return Transaction.class;
	}

	public String getModelClassName() {
		return Transaction.class.getName();
	}

	public long getPrimaryKey() {
		return _transactionId;
	}

	public void setPrimaryKey(long primaryKey) {
		setTransactionId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_transactionId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("transactionId", getTransactionId());
		attributes.put("bookId", getBookId());
		attributes.put("memberId", getMemberId());
		attributes.put("tdate", getTdate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long transactionId = (Long)attributes.get("transactionId");

		if (transactionId != null) {
			setTransactionId(transactionId);
		}

		Long bookId = (Long)attributes.get("bookId");

		if (bookId != null) {
			setBookId(bookId);
		}

		Long memberId = (Long)attributes.get("memberId");

		if (memberId != null) {
			setMemberId(memberId);
		}

		Date tdate = (Date)attributes.get("tdate");

		if (tdate != null) {
			setTdate(tdate);
		}
	}

	public long getTransactionId() {
		return _transactionId;
	}

	public void setTransactionId(long transactionId) {
		_transactionId = transactionId;
	}

	public long getBookId() {
		return _bookId;
	}

	public void setBookId(long bookId) {
		_bookId = bookId;
	}

	public long getMemberId() {
		return _memberId;
	}

	public void setMemberId(long memberId) {
		_memberId = memberId;
	}

	public Date getTdate() {
		return _tdate;
	}

	public void setTdate(Date tdate) {
		_tdate = tdate;
	}

	public BaseModel<?> getTransactionRemoteModel() {
		return _transactionRemoteModel;
	}

	public void setTransactionRemoteModel(BaseModel<?> transactionRemoteModel) {
		_transactionRemoteModel = transactionRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			TransactionLocalServiceUtil.addTransaction(this);
		}
		else {
			TransactionLocalServiceUtil.updateTransaction(this);
		}
	}

	@Override
	public Transaction toEscapedModel() {
		return (Transaction)Proxy.newProxyInstance(Transaction.class.getClassLoader(),
			new Class[] { Transaction.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TransactionClp clone = new TransactionClp();

		clone.setTransactionId(getTransactionId());
		clone.setBookId(getBookId());
		clone.setMemberId(getMemberId());
		clone.setTdate(getTdate());

		return clone;
	}

	public int compareTo(Transaction transaction) {
		long primaryKey = transaction.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		TransactionClp transaction = null;

		try {
			transaction = (TransactionClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = transaction.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{transactionId=");
		sb.append(getTransactionId());
		sb.append(", bookId=");
		sb.append(getBookId());
		sb.append(", memberId=");
		sb.append(getMemberId());
		sb.append(", tdate=");
		sb.append(getTdate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.jenginetest.builder.model.Transaction");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>transactionId</column-name><column-value><![CDATA[");
		sb.append(getTransactionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bookId</column-name><column-value><![CDATA[");
		sb.append(getBookId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>memberId</column-name><column-value><![CDATA[");
		sb.append(getMemberId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tdate</column-name><column-value><![CDATA[");
		sb.append(getTdate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _transactionId;
	private long _bookId;
	private long _memberId;
	private Date _tdate;
	private BaseModel<?> _transactionRemoteModel;
}