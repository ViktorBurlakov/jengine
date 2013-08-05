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

import com.jenginetest.builder.service.WLEventLogLocalServiceUtil;

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
public class WLEventLogClp extends BaseModelImpl<WLEventLog>
	implements WLEventLog {
	public WLEventLogClp() {
	}

	public Class<?> getModelClass() {
		return WLEventLog.class;
	}

	public String getModelClassName() {
		return WLEventLog.class.getName();
	}

	public long getPrimaryKey() {
		return _eventLogId;
	}

	public void setPrimaryKey(long primaryKey) {
		setEventLogId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_eventLogId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("eventLogId", getEventLogId());
		attributes.put("userId", getUserId());
		attributes.put("logDate", getLogDate());
		attributes.put("event", getEvent());
		attributes.put("title", getTitle());
		attributes.put("modelName", getModelName());
		attributes.put("modelPK", getModelPK());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long eventLogId = (Long)attributes.get("eventLogId");

		if (eventLogId != null) {
			setEventLogId(eventLogId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date logDate = (Date)attributes.get("logDate");

		if (logDate != null) {
			setLogDate(logDate);
		}

		String event = (String)attributes.get("event");

		if (event != null) {
			setEvent(event);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String modelName = (String)attributes.get("modelName");

		if (modelName != null) {
			setModelName(modelName);
		}

		Long modelPK = (Long)attributes.get("modelPK");

		if (modelPK != null) {
			setModelPK(modelPK);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
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

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
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

	public BaseModel<?> getWLEventLogRemoteModel() {
		return _wlEventLogRemoteModel;
	}

	public void setWLEventLogRemoteModel(BaseModel<?> wlEventLogRemoteModel) {
		_wlEventLogRemoteModel = wlEventLogRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			WLEventLogLocalServiceUtil.addWLEventLog(this);
		}
		else {
			WLEventLogLocalServiceUtil.updateWLEventLog(this);
		}
	}

	@Override
	public WLEventLog toEscapedModel() {
		return (WLEventLog)Proxy.newProxyInstance(WLEventLog.class.getClassLoader(),
			new Class[] { WLEventLog.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		WLEventLogClp clone = new WLEventLogClp();

		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setEventLogId(getEventLogId());
		clone.setUserId(getUserId());
		clone.setLogDate(getLogDate());
		clone.setEvent(getEvent());
		clone.setTitle(getTitle());
		clone.setModelName(getModelName());
		clone.setModelPK(getModelPK());
		clone.setDescription(getDescription());

		return clone;
	}

	public int compareTo(WLEventLog wlEventLog) {
		long primaryKey = wlEventLog.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		WLEventLogClp wlEventLog = null;

		try {
			wlEventLog = (WLEventLogClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = wlEventLog.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", eventLogId=");
		sb.append(getEventLogId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", logDate=");
		sb.append(getLogDate());
		sb.append(", event=");
		sb.append(getEvent());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", modelName=");
		sb.append(getModelName());
		sb.append(", modelPK=");
		sb.append(getModelPK());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.jenginetest.builder.model.WLEventLog");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventLogId</column-name><column-value><![CDATA[");
		sb.append(getEventLogId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>logDate</column-name><column-value><![CDATA[");
		sb.append(getLogDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>event</column-name><column-value><![CDATA[");
		sb.append(getEvent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modelName</column-name><column-value><![CDATA[");
		sb.append(getModelName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modelPK</column-name><column-value><![CDATA[");
		sb.append(getModelPK());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _groupId;
	private long _companyId;
	private long _eventLogId;
	private long _userId;
	private String _userUuid;
	private Date _logDate;
	private String _event;
	private String _title;
	private String _modelName;
	private Long _modelPK;
	private String _description;
	private BaseModel<?> _wlEventLogRemoteModel;
}