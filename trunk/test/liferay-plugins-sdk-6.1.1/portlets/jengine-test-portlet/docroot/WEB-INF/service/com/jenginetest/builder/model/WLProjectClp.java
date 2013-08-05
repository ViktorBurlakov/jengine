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

import com.jenginetest.builder.service.WLProjectLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
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
public class WLProjectClp extends BaseModelImpl<WLProject> implements WLProject {
	public WLProjectClp() {
	}

	public Class<?> getModelClass() {
		return WLProject.class;
	}

	public String getModelClassName() {
		return WLProject.class.getName();
	}

	public long getPrimaryKey() {
		return _projectId;
	}

	public void setPrimaryKey(long primaryKey) {
		setProjectId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_projectId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("projectId", getProjectId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createUserId", getCreateUserId());
		attributes.put("createUserName", getCreateUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedUserId", getModifiedUserId());
		attributes.put("modifiedUserName", getModifiedUserName());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("startDate", getStartDate());
		attributes.put("title", getTitle());
		attributes.put("status", getStatus());
		attributes.put("description", getDescription());
		attributes.put("color", getColor());
		attributes.put("lockEnable", getLockEnable());
		attributes.put("lockPeriodType", getLockPeriodType());
		attributes.put("lockDeferment", getLockDeferment());
		attributes.put("automaticallyAssign", getAutomaticallyAssign());
		attributes.put("defaultProject", getDefaultProject());
		attributes.put("externalUrl", getExternalUrl());
		attributes.put("externalMandatory", getExternalMandatory());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
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

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String color = (String)attributes.get("color");

		if (color != null) {
			setColor(color);
		}

		Boolean lockEnable = (Boolean)attributes.get("lockEnable");

		if (lockEnable != null) {
			setLockEnable(lockEnable);
		}

		String lockPeriodType = (String)attributes.get("lockPeriodType");

		if (lockPeriodType != null) {
			setLockPeriodType(lockPeriodType);
		}

		Integer lockDeferment = (Integer)attributes.get("lockDeferment");

		if (lockDeferment != null) {
			setLockDeferment(lockDeferment);
		}

		Boolean automaticallyAssign = (Boolean)attributes.get(
				"automaticallyAssign");

		if (automaticallyAssign != null) {
			setAutomaticallyAssign(automaticallyAssign);
		}

		Boolean defaultProject = (Boolean)attributes.get("defaultProject");

		if (defaultProject != null) {
			setDefaultProject(defaultProject);
		}

		String externalUrl = (String)attributes.get("externalUrl");

		if (externalUrl != null) {
			setExternalUrl(externalUrl);
		}

		Boolean externalMandatory = (Boolean)attributes.get("externalMandatory");

		if (externalMandatory != null) {
			setExternalMandatory(externalMandatory);
		}
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

	public BaseModel<?> getWLProjectRemoteModel() {
		return _wlProjectRemoteModel;
	}

	public void setWLProjectRemoteModel(BaseModel<?> wlProjectRemoteModel) {
		_wlProjectRemoteModel = wlProjectRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			WLProjectLocalServiceUtil.addWLProject(this);
		}
		else {
			WLProjectLocalServiceUtil.updateWLProject(this);
		}
	}

	@Override
	public WLProject toEscapedModel() {
		return (WLProject)Proxy.newProxyInstance(WLProject.class.getClassLoader(),
			new Class[] { WLProject.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		WLProjectClp clone = new WLProjectClp();

		clone.setProjectId(getProjectId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setCreateUserId(getCreateUserId());
		clone.setCreateUserName(getCreateUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedUserId(getModifiedUserId());
		clone.setModifiedUserName(getModifiedUserName());
		clone.setModifiedDate(getModifiedDate());
		clone.setStartDate(getStartDate());
		clone.setTitle(getTitle());
		clone.setStatus(getStatus());
		clone.setDescription(getDescription());
		clone.setColor(getColor());
		clone.setLockEnable(getLockEnable());
		clone.setLockPeriodType(getLockPeriodType());
		clone.setLockDeferment(getLockDeferment());
		clone.setAutomaticallyAssign(getAutomaticallyAssign());
		clone.setDefaultProject(getDefaultProject());
		clone.setExternalUrl(getExternalUrl());
		clone.setExternalMandatory(getExternalMandatory());

		return clone;
	}

	public int compareTo(WLProject wlProject) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), wlProject.getCreateDate());

		value = value * -1;

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

		WLProjectClp wlProject = null;

		try {
			wlProject = (WLProjectClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = wlProject.getPrimaryKey();

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
		StringBundler sb = new StringBundler(43);

		sb.append("{projectId=");
		sb.append(getProjectId());
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
		sb.append(", startDate=");
		sb.append(getStartDate());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", color=");
		sb.append(getColor());
		sb.append(", lockEnable=");
		sb.append(getLockEnable());
		sb.append(", lockPeriodType=");
		sb.append(getLockPeriodType());
		sb.append(", lockDeferment=");
		sb.append(getLockDeferment());
		sb.append(", automaticallyAssign=");
		sb.append(getAutomaticallyAssign());
		sb.append(", defaultProject=");
		sb.append(getDefaultProject());
		sb.append(", externalUrl=");
		sb.append(getExternalUrl());
		sb.append(", externalMandatory=");
		sb.append(getExternalMandatory());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(67);

		sb.append("<model><model-name>");
		sb.append("com.jenginetest.builder.model.WLProject");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>projectId</column-name><column-value><![CDATA[");
		sb.append(getProjectId());
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
			"<column><column-name>startDate</column-name><column-value><![CDATA[");
		sb.append(getStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>color</column-name><column-value><![CDATA[");
		sb.append(getColor());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lockEnable</column-name><column-value><![CDATA[");
		sb.append(getLockEnable());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lockPeriodType</column-name><column-value><![CDATA[");
		sb.append(getLockPeriodType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lockDeferment</column-name><column-value><![CDATA[");
		sb.append(getLockDeferment());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>automaticallyAssign</column-name><column-value><![CDATA[");
		sb.append(getAutomaticallyAssign());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>defaultProject</column-name><column-value><![CDATA[");
		sb.append(getDefaultProject());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>externalUrl</column-name><column-value><![CDATA[");
		sb.append(getExternalUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>externalMandatory</column-name><column-value><![CDATA[");
		sb.append(getExternalMandatory());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _projectId;
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
	private BaseModel<?> _wlProjectRemoteModel;
}