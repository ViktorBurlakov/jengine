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

package com.jenginetest.builder.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.jenginetest.builder.service.http.WLProjectUserServiceSoap}.
 *
 * @author    Brian Wing Shun Chan
 * @see       com.jenginetest.builder.service.http.WLProjectUserServiceSoap
 * @generated
 */
public class WLProjectUserSoap implements Serializable {
	public static WLProjectUserSoap toSoapModel(WLProjectUser model) {
		WLProjectUserSoap soapModel = new WLProjectUserSoap();

		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setProjectUserId(model.getProjectUserId());
		soapModel.setUserId(model.getUserId());
		soapModel.setProjectId(model.getProjectId());

		return soapModel;
	}

	public static WLProjectUserSoap[] toSoapModels(WLProjectUser[] models) {
		WLProjectUserSoap[] soapModels = new WLProjectUserSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WLProjectUserSoap[][] toSoapModels(WLProjectUser[][] models) {
		WLProjectUserSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WLProjectUserSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WLProjectUserSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WLProjectUserSoap[] toSoapModels(List<WLProjectUser> models) {
		List<WLProjectUserSoap> soapModels = new ArrayList<WLProjectUserSoap>(models.size());

		for (WLProjectUser model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WLProjectUserSoap[soapModels.size()]);
	}

	public WLProjectUserSoap() {
	}

	public long getPrimaryKey() {
		return _projectUserId;
	}

	public void setPrimaryKey(long pk) {
		setProjectUserId(pk);
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getProjectUserId() {
		return _projectUserId;
	}

	public void setProjectUserId(long projectUserId) {
		_projectUserId = projectUserId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getProjectId() {
		return _projectId;
	}

	public void setProjectId(long projectId) {
		_projectId = projectId;
	}

	private long _groupId;
	private long _companyId;
	private long _projectUserId;
	private long _userId;
	private long _projectId;
}