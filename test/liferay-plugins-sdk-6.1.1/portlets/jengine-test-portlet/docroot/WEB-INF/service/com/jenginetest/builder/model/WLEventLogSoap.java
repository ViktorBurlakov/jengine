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
 * This class is used by SOAP remote services, specifically {@link com.jenginetest.builder.service.http.WLEventLogServiceSoap}.
 *
 * @author    Brian Wing Shun Chan
 * @see       com.jenginetest.builder.service.http.WLEventLogServiceSoap
 * @generated
 */
public class WLEventLogSoap implements Serializable {
	public static WLEventLogSoap toSoapModel(WLEventLog model) {
		WLEventLogSoap soapModel = new WLEventLogSoap();

		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setEventLogId(model.getEventLogId());
		soapModel.setUserId(model.getUserId());
		soapModel.setLogDate(model.getLogDate());
		soapModel.setEvent(model.getEvent());
		soapModel.setTitle(model.getTitle());
		soapModel.setModelName(model.getModelName());
		soapModel.setModelPK(model.getModelPK());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static WLEventLogSoap[] toSoapModels(WLEventLog[] models) {
		WLEventLogSoap[] soapModels = new WLEventLogSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WLEventLogSoap[][] toSoapModels(WLEventLog[][] models) {
		WLEventLogSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WLEventLogSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WLEventLogSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WLEventLogSoap[] toSoapModels(List<WLEventLog> models) {
		List<WLEventLogSoap> soapModels = new ArrayList<WLEventLogSoap>(models.size());

		for (WLEventLog model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WLEventLogSoap[soapModels.size()]);
	}

	public WLEventLogSoap() {
	}

	public long getPrimaryKey() {
		return _eventLogId;
	}

	public void setPrimaryKey(long pk) {
		setEventLogId(pk);
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

	public long getEventLogId() {
		return _eventLogId;
	}

	public void setEventLogId(long eventLogId) {
		_eventLogId = eventLogId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public Date getLogDate() {
		return _logDate;
	}

	public void setLogDate(Date logDate) {
		_logDate = logDate;
	}

	public String getEvent() {
		return _event;
	}

	public void setEvent(String event) {
		_event = event;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getModelName() {
		return _modelName;
	}

	public void setModelName(String modelName) {
		_modelName = modelName;
	}

	public Long getModelPK() {
		return _modelPK;
	}

	public void setModelPK(Long modelPK) {
		_modelPK = modelPK;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private long _groupId;
	private long _companyId;
	private long _eventLogId;
	private long _userId;
	private Date _logDate;
	private String _event;
	private String _title;
	private String _modelName;
	private Long _modelPK;
	private String _description;
}