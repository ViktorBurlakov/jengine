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

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link WLProject}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       WLProject
 * @generated
 */
public class WLProjectWrapper implements WLProject, ModelWrapper<WLProject> {
	public WLProjectWrapper(WLProject wlProject) {
		_wlProject = wlProject;
	}

	public Class<?> getModelClass() {
		return WLProject.class;
	}

	public String getModelClassName() {
		return WLProject.class.getName();
	}

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

	/**
	* Returns the primary key of this w l project.
	*
	* @return the primary key of this w l project
	*/
	public long getPrimaryKey() {
		return _wlProject.getPrimaryKey();
	}

	/**
	* Sets the primary key of this w l project.
	*
	* @param primaryKey the primary key of this w l project
	*/
	public void setPrimaryKey(long primaryKey) {
		_wlProject.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the project ID of this w l project.
	*
	* @return the project ID of this w l project
	*/
	public long getProjectId() {
		return _wlProject.getProjectId();
	}

	/**
	* Sets the project ID of this w l project.
	*
	* @param projectId the project ID of this w l project
	*/
	public void setProjectId(long projectId) {
		_wlProject.setProjectId(projectId);
	}

	/**
	* Returns the group ID of this w l project.
	*
	* @return the group ID of this w l project
	*/
	public long getGroupId() {
		return _wlProject.getGroupId();
	}

	/**
	* Sets the group ID of this w l project.
	*
	* @param groupId the group ID of this w l project
	*/
	public void setGroupId(long groupId) {
		_wlProject.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this w l project.
	*
	* @return the company ID of this w l project
	*/
	public long getCompanyId() {
		return _wlProject.getCompanyId();
	}

	/**
	* Sets the company ID of this w l project.
	*
	* @param companyId the company ID of this w l project
	*/
	public void setCompanyId(long companyId) {
		_wlProject.setCompanyId(companyId);
	}

	/**
	* Returns the create user ID of this w l project.
	*
	* @return the create user ID of this w l project
	*/
	public long getCreateUserId() {
		return _wlProject.getCreateUserId();
	}

	/**
	* Sets the create user ID of this w l project.
	*
	* @param createUserId the create user ID of this w l project
	*/
	public void setCreateUserId(long createUserId) {
		_wlProject.setCreateUserId(createUserId);
	}

	/**
	* Returns the create user uuid of this w l project.
	*
	* @return the create user uuid of this w l project
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getCreateUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wlProject.getCreateUserUuid();
	}

	/**
	* Sets the create user uuid of this w l project.
	*
	* @param createUserUuid the create user uuid of this w l project
	*/
	public void setCreateUserUuid(java.lang.String createUserUuid) {
		_wlProject.setCreateUserUuid(createUserUuid);
	}

	/**
	* Returns the create user name of this w l project.
	*
	* @return the create user name of this w l project
	*/
	public java.lang.String getCreateUserName() {
		return _wlProject.getCreateUserName();
	}

	/**
	* Sets the create user name of this w l project.
	*
	* @param createUserName the create user name of this w l project
	*/
	public void setCreateUserName(java.lang.String createUserName) {
		_wlProject.setCreateUserName(createUserName);
	}

	/**
	* Returns the create date of this w l project.
	*
	* @return the create date of this w l project
	*/
	public java.util.Date getCreateDate() {
		return _wlProject.getCreateDate();
	}

	/**
	* Sets the create date of this w l project.
	*
	* @param createDate the create date of this w l project
	*/
	public void setCreateDate(java.util.Date createDate) {
		_wlProject.setCreateDate(createDate);
	}

	/**
	* Returns the modified user ID of this w l project.
	*
	* @return the modified user ID of this w l project
	*/
	public long getModifiedUserId() {
		return _wlProject.getModifiedUserId();
	}

	/**
	* Sets the modified user ID of this w l project.
	*
	* @param modifiedUserId the modified user ID of this w l project
	*/
	public void setModifiedUserId(long modifiedUserId) {
		_wlProject.setModifiedUserId(modifiedUserId);
	}

	/**
	* Returns the modified user uuid of this w l project.
	*
	* @return the modified user uuid of this w l project
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getModifiedUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wlProject.getModifiedUserUuid();
	}

	/**
	* Sets the modified user uuid of this w l project.
	*
	* @param modifiedUserUuid the modified user uuid of this w l project
	*/
	public void setModifiedUserUuid(java.lang.String modifiedUserUuid) {
		_wlProject.setModifiedUserUuid(modifiedUserUuid);
	}

	/**
	* Returns the modified user name of this w l project.
	*
	* @return the modified user name of this w l project
	*/
	public java.lang.String getModifiedUserName() {
		return _wlProject.getModifiedUserName();
	}

	/**
	* Sets the modified user name of this w l project.
	*
	* @param modifiedUserName the modified user name of this w l project
	*/
	public void setModifiedUserName(java.lang.String modifiedUserName) {
		_wlProject.setModifiedUserName(modifiedUserName);
	}

	/**
	* Returns the modified date of this w l project.
	*
	* @return the modified date of this w l project
	*/
	public java.util.Date getModifiedDate() {
		return _wlProject.getModifiedDate();
	}

	/**
	* Sets the modified date of this w l project.
	*
	* @param modifiedDate the modified date of this w l project
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_wlProject.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the start date of this w l project.
	*
	* @return the start date of this w l project
	*/
	public java.util.Date getStartDate() {
		return _wlProject.getStartDate();
	}

	/**
	* Sets the start date of this w l project.
	*
	* @param startDate the start date of this w l project
	*/
	public void setStartDate(java.util.Date startDate) {
		_wlProject.setStartDate(startDate);
	}

	/**
	* Returns the title of this w l project.
	*
	* @return the title of this w l project
	*/
	public java.lang.String getTitle() {
		return _wlProject.getTitle();
	}

	/**
	* Sets the title of this w l project.
	*
	* @param title the title of this w l project
	*/
	public void setTitle(java.lang.String title) {
		_wlProject.setTitle(title);
	}

	/**
	* Returns the status of this w l project.
	*
	* @return the status of this w l project
	*/
	public int getStatus() {
		return _wlProject.getStatus();
	}

	/**
	* Sets the status of this w l project.
	*
	* @param status the status of this w l project
	*/
	public void setStatus(int status) {
		_wlProject.setStatus(status);
	}

	/**
	* Returns the description of this w l project.
	*
	* @return the description of this w l project
	*/
	public java.lang.String getDescription() {
		return _wlProject.getDescription();
	}

	/**
	* Sets the description of this w l project.
	*
	* @param description the description of this w l project
	*/
	public void setDescription(java.lang.String description) {
		_wlProject.setDescription(description);
	}

	/**
	* Returns the color of this w l project.
	*
	* @return the color of this w l project
	*/
	public java.lang.String getColor() {
		return _wlProject.getColor();
	}

	/**
	* Sets the color of this w l project.
	*
	* @param color the color of this w l project
	*/
	public void setColor(java.lang.String color) {
		_wlProject.setColor(color);
	}

	/**
	* Returns the lock enable of this w l project.
	*
	* @return the lock enable of this w l project
	*/
	public boolean getLockEnable() {
		return _wlProject.getLockEnable();
	}

	/**
	* Returns <code>true</code> if this w l project is lock enable.
	*
	* @return <code>true</code> if this w l project is lock enable; <code>false</code> otherwise
	*/
	public boolean isLockEnable() {
		return _wlProject.isLockEnable();
	}

	/**
	* Sets whether this w l project is lock enable.
	*
	* @param lockEnable the lock enable of this w l project
	*/
	public void setLockEnable(boolean lockEnable) {
		_wlProject.setLockEnable(lockEnable);
	}

	/**
	* Returns the lock period type of this w l project.
	*
	* @return the lock period type of this w l project
	*/
	public java.lang.String getLockPeriodType() {
		return _wlProject.getLockPeriodType();
	}

	/**
	* Sets the lock period type of this w l project.
	*
	* @param lockPeriodType the lock period type of this w l project
	*/
	public void setLockPeriodType(java.lang.String lockPeriodType) {
		_wlProject.setLockPeriodType(lockPeriodType);
	}

	/**
	* Returns the lock deferment of this w l project.
	*
	* @return the lock deferment of this w l project
	*/
	public int getLockDeferment() {
		return _wlProject.getLockDeferment();
	}

	/**
	* Sets the lock deferment of this w l project.
	*
	* @param lockDeferment the lock deferment of this w l project
	*/
	public void setLockDeferment(int lockDeferment) {
		_wlProject.setLockDeferment(lockDeferment);
	}

	/**
	* Returns the automatically assign of this w l project.
	*
	* @return the automatically assign of this w l project
	*/
	public boolean getAutomaticallyAssign() {
		return _wlProject.getAutomaticallyAssign();
	}

	/**
	* Returns <code>true</code> if this w l project is automatically assign.
	*
	* @return <code>true</code> if this w l project is automatically assign; <code>false</code> otherwise
	*/
	public boolean isAutomaticallyAssign() {
		return _wlProject.isAutomaticallyAssign();
	}

	/**
	* Sets whether this w l project is automatically assign.
	*
	* @param automaticallyAssign the automatically assign of this w l project
	*/
	public void setAutomaticallyAssign(boolean automaticallyAssign) {
		_wlProject.setAutomaticallyAssign(automaticallyAssign);
	}

	/**
	* Returns the default project of this w l project.
	*
	* @return the default project of this w l project
	*/
	public boolean getDefaultProject() {
		return _wlProject.getDefaultProject();
	}

	/**
	* Returns <code>true</code> if this w l project is default project.
	*
	* @return <code>true</code> if this w l project is default project; <code>false</code> otherwise
	*/
	public boolean isDefaultProject() {
		return _wlProject.isDefaultProject();
	}

	/**
	* Sets whether this w l project is default project.
	*
	* @param defaultProject the default project of this w l project
	*/
	public void setDefaultProject(boolean defaultProject) {
		_wlProject.setDefaultProject(defaultProject);
	}

	/**
	* Returns the external url of this w l project.
	*
	* @return the external url of this w l project
	*/
	public java.lang.String getExternalUrl() {
		return _wlProject.getExternalUrl();
	}

	/**
	* Sets the external url of this w l project.
	*
	* @param externalUrl the external url of this w l project
	*/
	public void setExternalUrl(java.lang.String externalUrl) {
		_wlProject.setExternalUrl(externalUrl);
	}

	/**
	* Returns the external mandatory of this w l project.
	*
	* @return the external mandatory of this w l project
	*/
	public boolean getExternalMandatory() {
		return _wlProject.getExternalMandatory();
	}

	/**
	* Returns <code>true</code> if this w l project is external mandatory.
	*
	* @return <code>true</code> if this w l project is external mandatory; <code>false</code> otherwise
	*/
	public boolean isExternalMandatory() {
		return _wlProject.isExternalMandatory();
	}

	/**
	* Sets whether this w l project is external mandatory.
	*
	* @param externalMandatory the external mandatory of this w l project
	*/
	public void setExternalMandatory(boolean externalMandatory) {
		_wlProject.setExternalMandatory(externalMandatory);
	}

	public boolean isNew() {
		return _wlProject.isNew();
	}

	public void setNew(boolean n) {
		_wlProject.setNew(n);
	}

	public boolean isCachedModel() {
		return _wlProject.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_wlProject.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _wlProject.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _wlProject.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_wlProject.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _wlProject.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_wlProject.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new WLProjectWrapper((WLProject)_wlProject.clone());
	}

	public int compareTo(com.jenginetest.builder.model.WLProject wlProject) {
		return _wlProject.compareTo(wlProject);
	}

	@Override
	public int hashCode() {
		return _wlProject.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.jenginetest.builder.model.WLProject> toCacheModel() {
		return _wlProject.toCacheModel();
	}

	public com.jenginetest.builder.model.WLProject toEscapedModel() {
		return new WLProjectWrapper(_wlProject.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _wlProject.toString();
	}

	public java.lang.String toXmlString() {
		return _wlProject.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_wlProject.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public WLProject getWrappedWLProject() {
		return _wlProject;
	}

	public WLProject getWrappedModel() {
		return _wlProject;
	}

	public void resetOriginalValues() {
		_wlProject.resetOriginalValues();
	}

	private WLProject _wlProject;
}