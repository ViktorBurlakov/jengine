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

import com.jenginetest.builder.service.WLProjectUserLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class WLProjectUserClp extends BaseModelImpl<WLProjectUser>
	implements WLProjectUser {
	public WLProjectUserClp() {
	}

	public Class<?> getModelClass() {
		return WLProjectUser.class;
	}

	public String getModelClassName() {
		return WLProjectUser.class.getName();
	}

	public long getPrimaryKey() {
		return _projectUserId;
	}

	public void setPrimaryKey(long primaryKey) {
		setProjectUserId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_projectUserId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("projectUserId", getProjectUserId());
		attributes.put("userId", getUserId());
		attributes.put("projectId", getProjectId());

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

		Long projectUserId = (Long)attributes.get("projectUserId");

		if (projectUserId != null) {
			setProjectUserId(projectUserId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
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

	public long getProjectUserId() {
		return _projectUserId;
	}

	public void setProjectUserId(long projectUserId) {
		_projectUserId = projectUserId;
	}

	public String getProjectUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getProjectUserId(), "uuid",
			_projectUserUuid);
	}

	public void setProjectUserUuid(String projectUserUuid) {
		_projectUserUuid = projectUserUuid;
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

	public long getProjectId() {
		return _projectId;
	}

	public void setProjectId(long projectId) {
		_projectId = projectId;
	}

	public BaseModel<?> getWLProjectUserRemoteModel() {
		return _wlProjectUserRemoteModel;
	}

	public void setWLProjectUserRemoteModel(
		BaseModel<?> wlProjectUserRemoteModel) {
		_wlProjectUserRemoteModel = wlProjectUserRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			WLProjectUserLocalServiceUtil.addWLProjectUser(this);
		}
		else {
			WLProjectUserLocalServiceUtil.updateWLProjectUser(this);
		}
	}

	@Override
	public WLProjectUser toEscapedModel() {
		return (WLProjectUser)Proxy.newProxyInstance(WLProjectUser.class.getClassLoader(),
			new Class[] { WLProjectUser.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		WLProjectUserClp clone = new WLProjectUserClp();

		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setProjectUserId(getProjectUserId());
		clone.setUserId(getUserId());
		clone.setProjectId(getProjectId());

		return clone;
	}

	public int compareTo(WLProjectUser wlProjectUser) {
		long primaryKey = wlProjectUser.getPrimaryKey();

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

		WLProjectUserClp wlProjectUser = null;

		try {
			wlProjectUser = (WLProjectUserClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = wlProjectUser.getPrimaryKey();

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
		StringBundler sb = new StringBundler(11);

		sb.append("{groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", projectUserId=");
		sb.append(getProjectUserId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", projectId=");
		sb.append(getProjectId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.jenginetest.builder.model.WLProjectUser");
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
			"<column><column-name>projectUserId</column-name><column-value><![CDATA[");
		sb.append(getProjectUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projectId</column-name><column-value><![CDATA[");
		sb.append(getProjectId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _groupId;
	private long _companyId;
	private long _projectUserId;
	private String _projectUserUuid;
	private long _userId;
	private String _userUuid;
	private long _projectId;
	private BaseModel<?> _wlProjectUserRemoteModel;
}