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
 * This class is a wrapper for {@link WLTask}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       WLTask
 * @generated
 */
public class WLTaskWrapper implements WLTask, ModelWrapper<WLTask> {
	public WLTaskWrapper(WLTask wlTask) {
		_wlTask = wlTask;
	}

	public Class<?> getModelClass() {
		return WLTask.class;
	}

	public String getModelClassName() {
		return WLTask.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("taskId", getTaskId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createUserId", getCreateUserId());
		attributes.put("createUserName", getCreateUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedUserId", getModifiedUserId());
		attributes.put("modifiedUserName", getModifiedUserName());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("subject", getSubject());
		attributes.put("projectId", getProjectId());
		attributes.put("ownerId", getOwnerId());
		attributes.put("workerId", getWorkerId());
		attributes.put("externalId", getExternalId());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long taskId = (Long)attributes.get("taskId");

		if (taskId != null) {
			setTaskId(taskId);
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

		String subject = (String)attributes.get("subject");

		if (subject != null) {
			setSubject(subject);
		}

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}

		Long ownerId = (Long)attributes.get("ownerId");

		if (ownerId != null) {
			setOwnerId(ownerId);
		}

		Long workerId = (Long)attributes.get("workerId");

		if (workerId != null) {
			setWorkerId(workerId);
		}

		String externalId = (String)attributes.get("externalId");

		if (externalId != null) {
			setExternalId(externalId);
		}
	}

	/**
	* Returns the primary key of this w l task.
	*
	* @return the primary key of this w l task
	*/
	public long getPrimaryKey() {
		return _wlTask.getPrimaryKey();
	}

	/**
	* Sets the primary key of this w l task.
	*
	* @param primaryKey the primary key of this w l task
	*/
	public void setPrimaryKey(long primaryKey) {
		_wlTask.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the task ID of this w l task.
	*
	* @return the task ID of this w l task
	*/
	public long getTaskId() {
		return _wlTask.getTaskId();
	}

	/**
	* Sets the task ID of this w l task.
	*
	* @param taskId the task ID of this w l task
	*/
	public void setTaskId(long taskId) {
		_wlTask.setTaskId(taskId);
	}

	/**
	* Returns the group ID of this w l task.
	*
	* @return the group ID of this w l task
	*/
	public long getGroupId() {
		return _wlTask.getGroupId();
	}

	/**
	* Sets the group ID of this w l task.
	*
	* @param groupId the group ID of this w l task
	*/
	public void setGroupId(long groupId) {
		_wlTask.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this w l task.
	*
	* @return the company ID of this w l task
	*/
	public long getCompanyId() {
		return _wlTask.getCompanyId();
	}

	/**
	* Sets the company ID of this w l task.
	*
	* @param companyId the company ID of this w l task
	*/
	public void setCompanyId(long companyId) {
		_wlTask.setCompanyId(companyId);
	}

	/**
	* Returns the create user ID of this w l task.
	*
	* @return the create user ID of this w l task
	*/
	public long getCreateUserId() {
		return _wlTask.getCreateUserId();
	}

	/**
	* Sets the create user ID of this w l task.
	*
	* @param createUserId the create user ID of this w l task
	*/
	public void setCreateUserId(long createUserId) {
		_wlTask.setCreateUserId(createUserId);
	}

	/**
	* Returns the create user uuid of this w l task.
	*
	* @return the create user uuid of this w l task
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getCreateUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wlTask.getCreateUserUuid();
	}

	/**
	* Sets the create user uuid of this w l task.
	*
	* @param createUserUuid the create user uuid of this w l task
	*/
	public void setCreateUserUuid(java.lang.String createUserUuid) {
		_wlTask.setCreateUserUuid(createUserUuid);
	}

	/**
	* Returns the create user name of this w l task.
	*
	* @return the create user name of this w l task
	*/
	public java.lang.String getCreateUserName() {
		return _wlTask.getCreateUserName();
	}

	/**
	* Sets the create user name of this w l task.
	*
	* @param createUserName the create user name of this w l task
	*/
	public void setCreateUserName(java.lang.String createUserName) {
		_wlTask.setCreateUserName(createUserName);
	}

	/**
	* Returns the create date of this w l task.
	*
	* @return the create date of this w l task
	*/
	public java.util.Date getCreateDate() {
		return _wlTask.getCreateDate();
	}

	/**
	* Sets the create date of this w l task.
	*
	* @param createDate the create date of this w l task
	*/
	public void setCreateDate(java.util.Date createDate) {
		_wlTask.setCreateDate(createDate);
	}

	/**
	* Returns the modified user ID of this w l task.
	*
	* @return the modified user ID of this w l task
	*/
	public long getModifiedUserId() {
		return _wlTask.getModifiedUserId();
	}

	/**
	* Sets the modified user ID of this w l task.
	*
	* @param modifiedUserId the modified user ID of this w l task
	*/
	public void setModifiedUserId(long modifiedUserId) {
		_wlTask.setModifiedUserId(modifiedUserId);
	}

	/**
	* Returns the modified user uuid of this w l task.
	*
	* @return the modified user uuid of this w l task
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getModifiedUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wlTask.getModifiedUserUuid();
	}

	/**
	* Sets the modified user uuid of this w l task.
	*
	* @param modifiedUserUuid the modified user uuid of this w l task
	*/
	public void setModifiedUserUuid(java.lang.String modifiedUserUuid) {
		_wlTask.setModifiedUserUuid(modifiedUserUuid);
	}

	/**
	* Returns the modified user name of this w l task.
	*
	* @return the modified user name of this w l task
	*/
	public java.lang.String getModifiedUserName() {
		return _wlTask.getModifiedUserName();
	}

	/**
	* Sets the modified user name of this w l task.
	*
	* @param modifiedUserName the modified user name of this w l task
	*/
	public void setModifiedUserName(java.lang.String modifiedUserName) {
		_wlTask.setModifiedUserName(modifiedUserName);
	}

	/**
	* Returns the modified date of this w l task.
	*
	* @return the modified date of this w l task
	*/
	public java.util.Date getModifiedDate() {
		return _wlTask.getModifiedDate();
	}

	/**
	* Sets the modified date of this w l task.
	*
	* @param modifiedDate the modified date of this w l task
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_wlTask.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the subject of this w l task.
	*
	* @return the subject of this w l task
	*/
	public java.lang.String getSubject() {
		return _wlTask.getSubject();
	}

	/**
	* Sets the subject of this w l task.
	*
	* @param subject the subject of this w l task
	*/
	public void setSubject(java.lang.String subject) {
		_wlTask.setSubject(subject);
	}

	/**
	* Returns the project ID of this w l task.
	*
	* @return the project ID of this w l task
	*/
	public long getProjectId() {
		return _wlTask.getProjectId();
	}

	/**
	* Sets the project ID of this w l task.
	*
	* @param projectId the project ID of this w l task
	*/
	public void setProjectId(long projectId) {
		_wlTask.setProjectId(projectId);
	}

	/**
	* Returns the owner ID of this w l task.
	*
	* @return the owner ID of this w l task
	*/
	public long getOwnerId() {
		return _wlTask.getOwnerId();
	}

	/**
	* Sets the owner ID of this w l task.
	*
	* @param ownerId the owner ID of this w l task
	*/
	public void setOwnerId(long ownerId) {
		_wlTask.setOwnerId(ownerId);
	}

	/**
	* Returns the worker ID of this w l task.
	*
	* @return the worker ID of this w l task
	*/
	public long getWorkerId() {
		return _wlTask.getWorkerId();
	}

	/**
	* Sets the worker ID of this w l task.
	*
	* @param workerId the worker ID of this w l task
	*/
	public void setWorkerId(long workerId) {
		_wlTask.setWorkerId(workerId);
	}

	/**
	* Returns the external ID of this w l task.
	*
	* @return the external ID of this w l task
	*/
	public java.lang.String getExternalId() {
		return _wlTask.getExternalId();
	}

	/**
	* Sets the external ID of this w l task.
	*
	* @param externalId the external ID of this w l task
	*/
	public void setExternalId(java.lang.String externalId) {
		_wlTask.setExternalId(externalId);
	}

	public boolean isNew() {
		return _wlTask.isNew();
	}

	public void setNew(boolean n) {
		_wlTask.setNew(n);
	}

	public boolean isCachedModel() {
		return _wlTask.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_wlTask.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _wlTask.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _wlTask.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_wlTask.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _wlTask.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_wlTask.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new WLTaskWrapper((WLTask)_wlTask.clone());
	}

	public int compareTo(com.jenginetest.builder.model.WLTask wlTask) {
		return _wlTask.compareTo(wlTask);
	}

	@Override
	public int hashCode() {
		return _wlTask.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.jenginetest.builder.model.WLTask> toCacheModel() {
		return _wlTask.toCacheModel();
	}

	public com.jenginetest.builder.model.WLTask toEscapedModel() {
		return new WLTaskWrapper(_wlTask.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _wlTask.toString();
	}

	public java.lang.String toXmlString() {
		return _wlTask.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_wlTask.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public WLTask getWrappedWLTask() {
		return _wlTask;
	}

	public WLTask getWrappedModel() {
		return _wlTask;
	}

	public void resetOriginalValues() {
		_wlTask.resetOriginalValues();
	}

	private WLTask _wlTask;
}