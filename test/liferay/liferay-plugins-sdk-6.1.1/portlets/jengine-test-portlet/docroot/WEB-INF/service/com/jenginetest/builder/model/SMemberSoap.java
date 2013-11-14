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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.jenginetest.builder.service.http.SMemberServiceSoap}.
 *
 * @author    Brian Wing Shun Chan
 * @see       com.jenginetest.builder.service.http.SMemberServiceSoap
 * @generated
 */
public class SMemberSoap implements Serializable {
	public static SMemberSoap toSoapModel(SMember model) {
		SMemberSoap soapModel = new SMemberSoap();

		soapModel.setMemberId(model.getMemberId());
		soapModel.setLibraryId(model.getLibraryId());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setLastName(model.getLastName());

		return soapModel;
	}

	public static SMemberSoap[] toSoapModels(SMember[] models) {
		SMemberSoap[] soapModels = new SMemberSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SMemberSoap[][] toSoapModels(SMember[][] models) {
		SMemberSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SMemberSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SMemberSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SMemberSoap[] toSoapModels(List<SMember> models) {
		List<SMemberSoap> soapModels = new ArrayList<SMemberSoap>(models.size());

		for (SMember model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SMemberSoap[soapModels.size()]);
	}

	public SMemberSoap() {
	}

	public long getPrimaryKey() {
		return _memberId;
	}

	public void setPrimaryKey(long pk) {
		setMemberId(pk);
	}

	public long getMemberId() {
		return _memberId;
	}

	public void setMemberId(long memberId) {
		_memberId = memberId;
	}

	public long getLibraryId() {
		return _libraryId;
	}

	public void setLibraryId(long libraryId) {
		_libraryId = libraryId;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	private long _memberId;
	private long _libraryId;
	private String _firstName;
	private String _lastName;
}