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
 * This class is used by SOAP remote services, specifically {@link com.jenginetest.builder.service.http.WLEntryServiceSoap}.
 *
 * @author    Brian Wing Shun Chan
 * @see       com.jenginetest.builder.service.http.WLEntryServiceSoap
 * @generated
 */
public class WLEntrySoap implements Serializable {
	public static WLEntrySoap toSoapModel(WLEntry model) {
		WLEntrySoap soapModel = new WLEntrySoap();

		soapModel.setEntryId(model.getEntryId());
		soapModel.setCreateUserId(model.getCreateUserId());
		soapModel.setCreateUserName(model.getCreateUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedUserId(model.getModifiedUserId());
		soapModel.setModifiedUserName(model.getModifiedUserName());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setStart(model.getStart());
		soapModel.setStartTime(model.getStartTime());
		soapModel.setFinishTime(model.getFinishTime());
		soapModel.setEntryDate(model.getEntryDate());
		soapModel.setEntryTime(model.getEntryTime());
		soapModel.setTimezone(model.getTimezone());
		soapModel.setLength(model.getLength());
		soapModel.setTaskId(model.getTaskId());

		return soapModel;
	}

	public static WLEntrySoap[] toSoapModels(WLEntry[] models) {
		WLEntrySoap[] soapModels = new WLEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WLEntrySoap[][] toSoapModels(WLEntry[][] models) {
		WLEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WLEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new WLEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WLEntrySoap[] toSoapModels(List<WLEntry> models) {
		List<WLEntrySoap> soapModels = new ArrayList<WLEntrySoap>(models.size());

		for (WLEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WLEntrySoap[soapModels.size()]);
	}

	public WLEntrySoap() {
	}

	public long getPrimaryKey() {
		return _entryId;
	}

	public void setPrimaryKey(long pk) {
		setEntryId(pk);
	}

	public long getEntryId() {
		return _entryId;
	}

	public void setEntryId(long entryId) {
		_entryId = entryId;
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

	public Date getStart() {
		return _start;
	}

	public void setStart(Date start) {
		_start = start;
	}

	public long getStartTime() {
		return _startTime;
	}

	public void setStartTime(long startTime) {
		_startTime = startTime;
	}

	public long getFinishTime() {
		return _finishTime;
	}

	public void setFinishTime(long finishTime) {
		_finishTime = finishTime;
	}

	public Date getEntryDate() {
		return _entryDate;
	}

	public void setEntryDate(Date entryDate) {
		_entryDate = entryDate;
	}

	public long getEntryTime() {
		return _entryTime;
	}

	public void setEntryTime(long entryTime) {
		_entryTime = entryTime;
	}

	public int getTimezone() {
		return _timezone;
	}

	public void setTimezone(int timezone) {
		_timezone = timezone;
	}

	public long getLength() {
		return _length;
	}

	public void setLength(long length) {
		_length = length;
	}

	public long getTaskId() {
		return _taskId;
	}

	public void setTaskId(long taskId) {
		_taskId = taskId;
	}

	private long _entryId;
	private long _createUserId;
	private String _createUserName;
	private Date _createDate;
	private long _modifiedUserId;
	private String _modifiedUserName;
	private Date _modifiedDate;
	private Date _start;
	private long _startTime;
	private long _finishTime;
	private Date _entryDate;
	private long _entryTime;
	private int _timezone;
	private long _length;
	private long _taskId;
}