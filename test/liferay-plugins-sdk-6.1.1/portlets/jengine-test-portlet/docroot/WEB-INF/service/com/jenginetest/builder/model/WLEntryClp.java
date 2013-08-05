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

import com.jenginetest.builder.service.WLEntryLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class WLEntryClp extends BaseModelImpl<WLEntry> implements WLEntry {
	public WLEntryClp() {
	}

	public Class<?> getModelClass() {
		return WLEntry.class;
	}

	public String getModelClassName() {
		return WLEntry.class.getName();
	}

	public long getPrimaryKey() {
		return _entryId;
	}

	public void setPrimaryKey(long primaryKey) {
		setEntryId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_entryId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("entryId", getEntryId());
		attributes.put("createUserId", getCreateUserId());
		attributes.put("createUserName", getCreateUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedUserId", getModifiedUserId());
		attributes.put("modifiedUserName", getModifiedUserName());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("start", getStart());
		attributes.put("startTime", getStartTime());
		attributes.put("finishTime", getFinishTime());
		attributes.put("entryDate", getEntryDate());
		attributes.put("entryTime", getEntryTime());
		attributes.put("timezone", getTimezone());
		attributes.put("length", getLength());
		attributes.put("taskId", getTaskId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long entryId = (Long)attributes.get("entryId");

		if (entryId != null) {
			setEntryId(entryId);
		}

		Long createUserId = (Long)attributes.get("createUserId");

		if (createUserId != null) {
			setCreateUserId(createUserId);
		}

		String createUserName = (String)attributes.get("createUserName");

		if (createUserName != null) {
			setCreateUserName(createUserName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long modifiedUserId = (Long)attributes.get("modifiedUserId");

		if (modifiedUserId != null) {
			setModifiedUserId(modifiedUserId);
		}

		String modifiedUserName = (String)attributes.get("modifiedUserName");

		if (modifiedUserName != null) {
			setModifiedUserName(modifiedUserName);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Date start = (Date)attributes.get("start");

		if (start != null) {
			setStart(start);
		}

		Long startTime = (Long)attributes.get("startTime");

		if (startTime != null) {
			setStartTime(startTime);
		}

		Long finishTime = (Long)attributes.get("finishTime");

		if (finishTime != null) {
			setFinishTime(finishTime);
		}

		Date entryDate = (Date)attributes.get("entryDate");

		if (entryDate != null) {
			setEntryDate(entryDate);
		}

		Long entryTime = (Long)attributes.get("entryTime");

		if (entryTime != null) {
			setEntryTime(entryTime);
		}

		Integer timezone = (Integer)attributes.get("timezone");

		if (timezone != null) {
			setTimezone(timezone);
		}

		Long length = (Long)attributes.get("length");

		if (length != null) {
			setLength(length);
		}

		Long taskId = (Long)attributes.get("taskId");

		if (taskId != null) {
			setTaskId(taskId);
		}
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

	public String getCreateUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getCreateUserId(), "uuid",
			_createUserUuid);
	}

	public void setCreateUserUuid(String createUserUuid) {
		_createUserUuid = createUserUuid;
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

	public String getModifiedUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getModifiedUserId(), "uuid",
			_modifiedUserUuid);
	}

	public void setModifiedUserUuid(String modifiedUserUuid) {
		_modifiedUserUuid = modifiedUserUuid;
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

	public BaseModel<?> getWLEntryRemoteModel() {
		return _wlEntryRemoteModel;
	}

	public void setWLEntryRemoteModel(BaseModel<?> wlEntryRemoteModel) {
		_wlEntryRemoteModel = wlEntryRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			WLEntryLocalServiceUtil.addWLEntry(this);
		}
		else {
			WLEntryLocalServiceUtil.updateWLEntry(this);
		}
	}

	@Override
	public WLEntry toEscapedModel() {
		return (WLEntry)Proxy.newProxyInstance(WLEntry.class.getClassLoader(),
			new Class[] { WLEntry.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		WLEntryClp clone = new WLEntryClp();

		clone.setEntryId(getEntryId());
		clone.setCreateUserId(getCreateUserId());
		clone.setCreateUserName(getCreateUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedUserId(getModifiedUserId());
		clone.setModifiedUserName(getModifiedUserName());
		clone.setModifiedDate(getModifiedDate());
		clone.setStart(getStart());
		clone.setStartTime(getStartTime());
		clone.setFinishTime(getFinishTime());
		clone.setEntryDate(getEntryDate());
		clone.setEntryTime(getEntryTime());
		clone.setTimezone(getTimezone());
		clone.setLength(getLength());
		clone.setTaskId(getTaskId());

		return clone;
	}

	public int compareTo(WLEntry wlEntry) {
		int value = 0;

		if (getEntryId() < wlEntry.getEntryId()) {
			value = -1;
		}
		else if (getEntryId() > wlEntry.getEntryId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		WLEntryClp wlEntry = null;

		try {
			wlEntry = (WLEntryClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = wlEntry.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{entryId=");
		sb.append(getEntryId());
		sb.append(", createUserId=");
		sb.append(getCreateUserId());
		sb.append(", createUserName=");
		sb.append(getCreateUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedUserId=");
		sb.append(getModifiedUserId());
		sb.append(", modifiedUserName=");
		sb.append(getModifiedUserName());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", start=");
		sb.append(getStart());
		sb.append(", startTime=");
		sb.append(getStartTime());
		sb.append(", finishTime=");
		sb.append(getFinishTime());
		sb.append(", entryDate=");
		sb.append(getEntryDate());
		sb.append(", entryTime=");
		sb.append(getEntryTime());
		sb.append(", timezone=");
		sb.append(getTimezone());
		sb.append(", length=");
		sb.append(getLength());
		sb.append(", taskId=");
		sb.append(getTaskId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(49);

		sb.append("<model><model-name>");
		sb.append("com.jenginetest.builder.model.WLEntry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>entryId</column-name><column-value><![CDATA[");
		sb.append(getEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createUserId</column-name><column-value><![CDATA[");
		sb.append(getCreateUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createUserName</column-name><column-value><![CDATA[");
		sb.append(getCreateUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedUserId</column-name><column-value><![CDATA[");
		sb.append(getModifiedUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedUserName</column-name><column-value><![CDATA[");
		sb.append(getModifiedUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>start</column-name><column-value><![CDATA[");
		sb.append(getStart());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startTime</column-name><column-value><![CDATA[");
		sb.append(getStartTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>finishTime</column-name><column-value><![CDATA[");
		sb.append(getFinishTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>entryDate</column-name><column-value><![CDATA[");
		sb.append(getEntryDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>entryTime</column-name><column-value><![CDATA[");
		sb.append(getEntryTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>timezone</column-name><column-value><![CDATA[");
		sb.append(getTimezone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>length</column-name><column-value><![CDATA[");
		sb.append(getLength());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>taskId</column-name><column-value><![CDATA[");
		sb.append(getTaskId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _entryId;
	private long _createUserId;
	private String _createUserUuid;
	private String _createUserName;
	private Date _createDate;
	private long _modifiedUserId;
	private String _modifiedUserUuid;
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
	private BaseModel<?> _wlEntryRemoteModel;
}