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

import com.jenginetest.builder.service.WLProjectUserRoleLocalServiceUtil;

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
public class WLProjectUserRoleClp extends BaseModelImpl<WLProjectUserRole>
	implements WLProjectUserRole {
	public WLProjectUserRoleClp() {
	}

	public Class<?> getModelClass() {
		return WLProjectUserRole.class;
	}

	public String getModelClassName() {
		return WLProjectUserRole.class.getName();
	}

	public long getPrimaryKey() {
		return _projectUserRoleId;
	}

	public void setPrimaryKey(long primaryKey) {
		setProjectUserRoleId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_projectUserRoleId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("projectUserRoleId", getProjectUserRoleId());
		attributes.put("projectUserId", getProjectUserId());
		attributes.put("roleId", getRoleId());

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

		Long projectUserRoleId = (Long)attributes.get("projectUserRoleId");

		if (projectUserRoleId != null) {
			setProjectUserRoleId(projectUserRoleId);
		}

		Long projectUserId = (Long)attributes.get("projectUserId");

		if (projectUserId != null) {
			setProjectUserId(projectUserId);
		}

		Long roleId = (Long)attributes.get("roleId");

		if (roleId != null) {
			setRoleId(roleId);
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

	public String getProjectUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getProjectUserId(), "uuid",
			_projectUserUuid);
	}

	public void setProjectUserUuid(String projectUserUuid) {
		_projectUserUuid = projectUserUuid;
	}

	public long getRoleId() {
		return _roleId;
	}

	public void setRoleId(long roleId) {
		_roleId = roleId;
	}

	public BaseModel<?> getWLProjectUserRoleRemoteModel() {
		return _wlProjectUserRoleRemoteModel;
	}

	public void setWLProjectUserRoleRemoteModel(
		BaseModel<?> wlProjectUserRoleRemoteModel) {
		_wlProjectUserRoleRemoteModel = wlProjectUserRoleRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			WLProjectUserRoleLocalServiceUtil.addWLProjectUserRole(this);
		}
		else {
			WLProjectUserRoleLocalServiceUtil.updateWLProjectUserRole(this);
		}
	}

	@Override
	public WLProjectUserRole toEscapedModel() {
		return (WLProjectUserRole)Proxy.newProxyInstance(WLProjectUserRole.class.getClassLoader(),
			new Class[] { WLProjectUserRole.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		WLProjectUserRoleClp clone = new WLProjectUserRoleClp();

		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setProjectUserRoleId(getProjectUserRoleId());
		clone.setProjectUserId(getProjectUserId());
		clone.setRoleId(getRoleId());

		return clone;
	}

	public int compareTo(WLProjectUserRole wlProjectUserRole) {
		long primaryKey = wlProjectUserRole.getPrimaryKey();

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

		WLProjectUserRoleClp wlProjectUserRole = null;

		try {
			wlProjectUserRole = (WLProjectUserRoleClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = wlProjectUserRole.getPrimaryKey();

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
		sb.append(", projectUserRoleId=");
		sb.append(getProjectUserRoleId());
		sb.append(", projectUserId=");
		sb.append(getProjectUserId());
		sb.append(", roleId=");
		sb.append(getRoleId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.jenginetest.builder.model.WLProjectUserRole");
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
			"<column><column-name>projectUserRoleId</column-name><column-value><![CDATA[");
		sb.append(getProjectUserRoleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projectUserId</column-name><column-value><![CDATA[");
		sb.append(getProjectUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>roleId</column-name><column-value><![CDATA[");
		sb.append(getRoleId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _groupId;
	private long _companyId;
	private long _projectUserRoleId;
	private long _projectUserId;
	private String _projectUserUuid;
	private long _roleId;
	private BaseModel<?> _wlProjectUserRoleRemoteModel;
}