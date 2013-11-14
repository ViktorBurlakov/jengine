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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.jenginetest.builder.service.http.STransactionServiceSoap}.
 *
 * @author    Brian Wing Shun Chan
 * @see       com.jenginetest.builder.service.http.STransactionServiceSoap
 * @generated
 */
public class STransactionSoap implements Serializable {
	public static STransactionSoap toSoapModel(STransaction model) {
		STransactionSoap soapModel = new STransactionSoap();

		soapModel.setTransactionId(model.getTransactionId());
		soapModel.setBookId(model.getBookId());
		soapModel.setMemberId(model.getMemberId());
		soapModel.setTdate(model.getTdate());

		return soapModel;
	}

	public static STransactionSoap[] toSoapModels(STransaction[] models) {
		STransactionSoap[] soapModels = new STransactionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static STransactionSoap[][] toSoapModels(STransaction[][] models) {
		STransactionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new STransactionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new STransactionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static STransactionSoap[] toSoapModels(List<STransaction> models) {
		List<STransactionSoap> soapModels = new ArrayList<STransactionSoap>(models.size());

		for (STransaction model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new STransactionSoap[soapModels.size()]);
	}

	public STransactionSoap() {
	}

	public long getPrimaryKey() {
		return _transactionId;
	}

	public void setPrimaryKey(long pk) {
		setTransactionId(pk);
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

	private long _transactionId;
	private long _bookId;
	private long _memberId;
	private Date _tdate;
}