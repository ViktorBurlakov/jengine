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
 * This class is used by SOAP remote services, specifically {@link com.jenginetest.builder.service.http.WLProjectServiceSoap}.
 *
 * @author    Brian Wing Shun Chan
 * @see       com.jenginetest.builder.service.http.WLProjectServiceSoap
 * @generated
 */
public class WLProjectSoap implements Serializable {
	public static WLProjectSoap toSoapModel(WLProject model) {
		WLProjectSoap soapModel = new WLProjectSoap();

		soapModel.setProjectId(model.getProjectId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateUserId(model.getCreateUserId());
		soapModel.setCreateUserName(model.getCreateUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedUserId(model.getModifiedUserId());
		soapModel.setModifiedUserName(model.getModifiedUserName());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setTitle(model.getTitle());
		soapModel.setStatus(model.getStatus());
		soapModel.setDescription(model.getDescription());
		soapModel.setColor(model.getColor());
		soapModel.setLockEnable(model.getLockEnable());
		soapModel.setLockPeriodType(model.getLockPeriodType());
		soapModel.setLockDeferment(model.getLockDeferment());
		soapModel.setAutomaticallyAssign(model.getAutomaticallyAssign());
		soapModel.setDefaultProject(model.getDefaultProject());
		soapModel.setExternalUrl(model.getExternalUrl());
		soapModel.setExternalMandatory(model.getExternalMandatory());

		return soapModel;
	}

	public static WLProjectSoap[] toSoapModels(WLProject[] models) {
		WLProjectSoap[] soapModels = new WLProjectSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WLProjectSoap[][] toSoapModels(WLProject[][] models) {
		WLProjectSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WLProjectSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WLProjectSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WLProjectSoap[] toSoapModels(List<WLProject> models) {
		List<WLProjectSoap> soapModels = new ArrayList<WLProjectSoap>(models.size());

		for (WLProject model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WLProjectSoap[soapModels.size()]);
	}

	public WLProjectSoap() {
	}

	public long getPrimaryKey() {
		return _projectId;
	}

	public void setPrimaryKey(long pk) {
		setProjectId(pk);
	}

	public long getProjectId() {
		return _projectId;
	}

	public void setProjectId(long projectId) {
		_projectId = projectId;
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

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getColor() {
		return _color;
	}

	public void setColor(String color) {
		_color = color;
	}

	public boolean getLockEnable() {
		return _lockEnable;
	}

	public boolean isLockEnable() {
		return _lockEnable;
	}

	public void setLockEnable(boolean lockEnable) {
		_lockEnable = lockEnable;
	}

	public String getLockPeriodType() {
		return _lockPeriodType;
	}

	public void setLockPeriodType(String lockPeriodType) {
		_lockPeriodType = lockPeriodType;
	}

	public int getLockDeferment() {
		return _lockDeferment;
	}

	public void setLockDeferment(int lockDeferment) {
		_lockDeferment = lockDeferment;
	}

	public boolean getAutomaticallyAssign() {
		return _automaticallyAssign;
	}

	public boolean isAutomaticallyAssign() {
		return _automaticallyAssign;
	}

	public void setAutomaticallyAssign(boolean automaticallyAssign) {
		_automaticallyAssign = automaticallyAssign;
	}

	public boolean getDefaultProject() {
		return _defaultProject;
	}

	public boolean isDefaultProject() {
		return _defaultProject;
	}

	public void setDefaultProject(boolean defaultProject) {
		_defaultProject = defaultProject;
	}

	public String getExternalUrl() {
		return _externalUrl;
	}

	public void setExternalUrl(String externalUrl) {
		_externalUrl = externalUrl;
	}

	public boolean getExternalMandatory() {
		return _externalMandatory;
	}

	public boolean isExternalMandatory() {
		return _externalMandatory;
	}

	public void setExternalMandatory(boolean externalMandatory) {
		_externalMandatory = externalMandatory;
	}

	private long _projectId;
	private long _groupId;
	private long _companyId;
	private long _createUserId;
	private String _createUserName;
	private Date _createDate;
	private long _modifiedUserId;
	private String _modifiedUserName;
	private Date _modifiedDate;
	private Date _startDate;
	private String _title;
	private int _status;
	private String _description;
	private String _color;
	private boolean _lockEnable;
	private String _lockPeriodType;
	private int _lockDeferment;
	private boolean _automaticallyAssign;
	private boolean _defaultProject;
	private String _externalUrl;
	private boolean _externalMandatory;
}