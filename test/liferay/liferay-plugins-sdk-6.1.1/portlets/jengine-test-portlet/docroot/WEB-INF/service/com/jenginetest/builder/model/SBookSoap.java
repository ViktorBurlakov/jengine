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
 * This class is used by SOAP remote services, specifically {@link com.jenginetest.builder.service.http.SBookServiceSoap}.
 *
 * @author    Brian Wing Shun Chan
 * @see       com.jenginetest.builder.service.http.SBookServiceSoap
 * @generated
 */
public class SBookSoap implements Serializable {
	public static SBookSoap toSoapModel(SBook model) {
		SBookSoap soapModel = new SBookSoap();

		soapModel.setBookId(model.getBookId());
		soapModel.setLibraryId(model.getLibraryId());
		soapModel.setTitle(model.getTitle());

		return soapModel;
	}

	public static SBookSoap[] toSoapModels(SBook[] models) {
		SBookSoap[] soapModels = new SBookSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SBookSoap[][] toSoapModels(SBook[][] models) {
		SBookSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SBookSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SBookSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SBookSoap[] toSoapModels(List<SBook> models) {
		List<SBookSoap> soapModels = new ArrayList<SBookSoap>(models.size());

		for (SBook model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SBookSoap[soapModels.size()]);
	}

	public SBookSoap() {
	}

	public long getPrimaryKey() {
		return _bookId;
	}

	public void setPrimaryKey(long pk) {
		setBookId(pk);
	}

	public long getBookId() {
		return _bookId;
	}

	public void setBookId(long bookId) {
		_bookId = bookId;
	}

	public long getLibraryId() {
		return _libraryId;
	}

	public void setLibraryId(long libraryId) {
		_libraryId = libraryId;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	private long _bookId;
	private long _libraryId;
	private String _title;
}