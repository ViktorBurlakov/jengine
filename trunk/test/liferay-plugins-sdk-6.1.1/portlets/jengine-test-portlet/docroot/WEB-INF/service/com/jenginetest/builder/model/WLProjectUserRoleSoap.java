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
 * This class is used by SOAP remote services, specifically {@link com.jenginetest.builder.service.http.WLProjectUserRoleServiceSoap}.
 *
 * @author    Brian Wing Shun Chan
 * @see       com.jenginetest.builder.service.http.WLProjectUserRoleServiceSoap
 * @generated
 */
public class WLProjectUserRoleSoap implements Serializable {
	public static WLProjectUserRoleSoap toSoapModel(WLProjectUserRole model) {
		WLProjectUserRoleSoap soapModel = new WLProjectUserRoleSoap();

		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setProjectUserRoleId(model.getProjectUserRoleId());
		soapModel.setProjectUserId(model.getProjectUserId());
		soapModel.setRoleId(model.getRoleId());

		return soapModel;
	}

	public static WLProjectUserRoleSoap[] toSoapModels(
		WLProjectUserRole[] models) {
		WLProjectUserRoleSoap[] soapModels = new WLProjectUserRoleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WLProjectUserRoleSoap[][] toSoapModels(
		WLProjectUserRole[][] models) {
		WLProjectUserRoleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WLProjectUserRoleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WLProjectUserRoleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WLProjectUserRoleSoap[] toSoapModels(
		List<WLProjectUserRole> models) {
		List<WLProjectUserRoleSoap> soapModels = new ArrayList<WLProjectUserRoleSoap>(models.size());

		for (WLProjectUserRole model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WLProjectUserRoleSoap[soapModels.size()]);
	}

	public WLProjectUserRoleSoap() {
	}

	public long getPrimaryKey() {
		return _projectUserRoleId;
	}

	public void setPrimaryKey(long pk) {
		setProjectUserRoleId(pk);
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

	public long getProjectUserRoleId() {
		return _projectUserRoleId;
	}

	public void setProjectUserRoleId(long projectUserRoleId) {
		_projectUserRoleId = projectUserRoleId;
	}

	public long getProjectUserId() {
		return _projectUserId;
	}

	public void setProjectUserId(long projectUserId) {
		_projectUserId = projectUserId;
	}

	public long getRoleId() {
		return _roleId;
	}

	public void setRoleId(long roleId) {
		_roleId = roleId;
	}

	private long _groupId;
	private long _companyId;
	private long _projectUserRoleId;
	private long _projectUserId;
	private long _roleId;
}