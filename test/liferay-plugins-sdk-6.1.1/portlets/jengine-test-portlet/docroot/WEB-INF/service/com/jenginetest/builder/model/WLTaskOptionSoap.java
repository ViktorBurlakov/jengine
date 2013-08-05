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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.jenginetest.builder.service.http.WLTaskOptionServiceSoap}.
 *
 * @author    Brian Wing Shun Chan
 * @see       com.jenginetest.builder.service.http.WLTaskOptionServiceSoap
 * @generated
 */
public class WLTaskOptionSoap implements Serializable {
	public static WLTaskOptionSoap toSoapModel(WLTaskOption model) {
		WLTaskOptionSoap soapModel = new WLTaskOptionSoap();

		soapModel.setOptionId(model.getOptionId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateUserId(model.getCreateUserId());
		soapModel.setCreateUserName(model.getCreateUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedUserId(model.getModifiedUserId());
		soapModel.setModifiedUserName(model.getModifiedUserName());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTaskId(model.getTaskId());
		soapModel.setName(model.getName());
		soapModel.setData(model.getData());

		return soapModel;
	}

	public static WLTaskOptionSoap[] toSoapModels(WLTaskOption[] models) {
		WLTaskOptionSoap[] soapModels = new WLTaskOptionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WLTaskOptionSoap[][] toSoapModels(WLTaskOption[][] models) {
		WLTaskOptionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WLTaskOptionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WLTaskOptionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WLTaskOptionSoap[] toSoapModels(List<WLTaskOption> models) {
		List<WLTaskOptionSoap> soapModels = new ArrayList<WLTaskOptionSoap>(models.size());

		for (WLTaskOption model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WLTaskOptionSoap[soapModels.size()]);
	}

	public WLTaskOptionSoap() {
	}

	public long getPrimaryKey() {
		return _optionId;
	}

	public void setPrimaryKey(long pk) {
		setOptionId(pk);
	}

	public long getOptionId() {
		return _optionId;
	}

	public void setOptionId(long optionId) {
		_optionId = optionId;
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

	public long getCreateUserId() {
		return _createUserId;
	}

	public void setCreateUserId(long createUserId) {
		_createUserId = createUserId;
	}

	public String getCreateUserName() {
		return _createUserName;
	}

	public void setCreateUserName(String createUserName) {
		_createUserName = createUserName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public long getModifiedUserId() {
		return _modifiedUserId;
	}

	public void setModifiedUserId(long modifiedUserId) {
		_modifiedUserId = modifiedUserId;
	}

	public String getModifiedUserName() {
		return _modifiedUserName;
	}

	public void setModifiedUserName(String modifiedUserName) {
		_modifiedUserName = modifiedUserName;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getTaskId() {
		return _taskId;
	}

	public void setTaskId(long taskId) {
		_taskId = taskId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getData() {
		return _data;
	}

	public void setData(String data) {
		_data = data;
	}

	private long _optionId;
	private long _groupId;
	private long _companyId;
	private long _createUserId;
	private String _createUserName;
	private Date _createDate;
	private long _modifiedUserId;
	private String _modifiedUserName;
	private Date _modifiedDate;
	private long _taskId;
	private String _name;
	private String _data;
}