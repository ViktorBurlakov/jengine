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
 * This class is used by SOAP remote services, specifically {@link com.jenginetest.builder.service.http.SAuthorServiceSoap}.
 *
 * @author    Brian Wing Shun Chan
 * @see       com.jenginetest.builder.service.http.SAuthorServiceSoap
 * @generated
 */
public class SAuthorSoap implements Serializable {
	public static SAuthorSoap toSoapModel(SAuthor model) {
		SAuthorSoap soapModel = new SAuthorSoap();

		soapModel.setAuthorId(model.getAuthorId());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setLastName(model.getLastName());

		return soapModel;
	}

	public static SAuthorSoap[] toSoapModels(SAuthor[] models) {
		SAuthorSoap[] soapModels = new SAuthorSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SAuthorSoap[][] toSoapModels(SAuthor[][] models) {
		SAuthorSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SAuthorSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SAuthorSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SAuthorSoap[] toSoapModels(List<SAuthor> models) {
		List<SAuthorSoap> soapModels = new ArrayList<SAuthorSoap>(models.size());

		for (SAuthor model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SAuthorSoap[soapModels.size()]);
	}

	public SAuthorSoap() {
	}

	public long getPrimaryKey() {
		return _authorId;
	}

	public void setPrimaryKey(long pk) {
		setAuthorId(pk);
	}

	public long getAuthorId() {
		return _authorId;
	}

	public void setAuthorId(long authorId) {
		_authorId = authorId;
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

	private long _authorId;
	private String _firstName;
	private String _lastName;
}