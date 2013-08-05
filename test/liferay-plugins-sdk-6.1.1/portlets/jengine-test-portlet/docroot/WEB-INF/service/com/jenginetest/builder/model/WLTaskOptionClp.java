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

import com.jenginetest.builder.service.WLTaskOptionLocalServiceUtil;

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
public class WLTaskOptionClp extends BaseModelImpl<WLTaskOption>
	implements WLTaskOption {
	public WLTaskOptionClp() {
	}

	public Class<?> getModelClass() {
		return WLTaskOption.class;
	}

	public String getModelClassName() {
		return WLTaskOption.class.getName();
	}

	public long getPrimaryKey() {
		return _optionId;
	}

	public void setPrimaryKey(long primaryKey) {
		setOptionId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_optionId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("optionId", getOptionId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createUserId", getCreateUserId());
		attributes.put("createUserName", getCreateUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedUserId", getModifiedUserId());
		attributes.put("modifiedUserName", getModifiedUserName());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("taskId", getTaskId());
		attributes.put("name", getName());
		attributes.put("data", getData());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long optionId = (Long)attributes.get("optionId");

		if (optionId != null) {
			setOptionId(optionId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
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

		Long taskId = (Long)attributes.get("taskId");

		if (taskId != null) {
			setTaskId(taskId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String data = (String)attributes.get("data");

		if (data != null) {
			setData(data);
		}
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

	public BaseModel<?> getWLTaskOptionRemoteModel() {
		return _wlTaskOptionRemoteModel;
	}

	public void setWLTaskOptionRemoteModel(BaseModel<?> wlTaskOptionRemoteModel) {
		_wlTaskOptionRemoteModel = wlTaskOptionRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			WLTaskOptionLocalServiceUtil.addWLTaskOption(this);
		}
		else {
			WLTaskOptionLocalServiceUtil.updateWLTaskOption(this);
		}
	}

	@Override
	public WLTaskOption toEscapedModel() {
		return (WLTaskOption)Proxy.newProxyInstance(WLTaskOption.class.getClassLoader(),
			new Class[] { WLTaskOption.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		WLTaskOptionClp clone = new WLTaskOptionClp();

		clone.setOptionId(getOptionId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setCreateUserId(getCreateUserId());
		clone.setCreateUserName(getCreateUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedUserId(getModifiedUserId());
		clone.setModifiedUserName(getModifiedUserName());
		clone.setModifiedDate(getModifiedDate());
		clone.setTaskId(getTaskId());
		clone.setName(getName());
		clone.setData(getData());

		return clone;
	}

	public int compareTo(WLTaskOption wlTaskOption) {
		long primaryKey = wlTaskOption.getPrimaryKey();

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

		WLTaskOptionClp wlTaskOption = null;

		try {
			wlTaskOption = (WLTaskOptionClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = wlTaskOption.getPrimaryKey();

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
		StringBundler sb = new StringBundler(25);

		sb.append("{optionId=");
		sb.append(getOptionId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
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
		sb.append(", taskId=");
		sb.append(getTaskId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", data=");
		sb.append(getData());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.jenginetest.builder.model.WLTaskOption");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>optionId</column-name><column-value><![CDATA[");
		sb.append(getOptionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
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
			"<column><column-name>taskId</column-name><column-value><![CDATA[");
		sb.append(getTaskId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>data</column-name><column-value><![CDATA[");
		sb.append(getData());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _optionId;
	private long _groupId;
	private long _companyId;
	private long _createUserId;
	private String _createUserUuid;
	private String _createUserName;
	private Date _createDate;
	private long _modifiedUserId;
	private String _modifiedUserUuid;
	private String _modifiedUserName;
	private Date _modifiedDate;
	private long _taskId;
	private String _name;
	private String _data;
	private BaseModel<?> _wlTaskOptionRemoteModel;
}