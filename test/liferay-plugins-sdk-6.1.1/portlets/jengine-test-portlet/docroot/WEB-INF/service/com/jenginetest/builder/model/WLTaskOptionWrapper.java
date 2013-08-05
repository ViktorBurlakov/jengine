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
 * This class is a wrapper for {@link WLTaskOption}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       WLTaskOption
 * @generated
 */
public class WLTaskOptionWrapper implements WLTaskOption,
	ModelWrapper<WLTaskOption> {
	public WLTaskOptionWrapper(WLTaskOption wlTaskOption) {
		_wlTaskOption = wlTaskOption;
	}

	public Class<?> getModelClass() {
		return WLTaskOption.class;
	}

	public String getModelClassName() {
		return WLTaskOption.class.getName();
	}

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

	/**
	* Returns the primary key of this w l task option.
	*
	* @return the primary key of this w l task option
	*/
	public long getPrimaryKey() {
		return _wlTaskOption.getPrimaryKey();
	}

	/**
	* Sets the primary key of this w l task option.
	*
	* @param primaryKey the primary key of this w l task option
	*/
	public void setPrimaryKey(long primaryKey) {
		_wlTaskOption.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the option ID of this w l task option.
	*
	* @return the option ID of this w l task option
	*/
	public long getOptionId() {
		return _wlTaskOption.getOptionId();
	}

	/**
	* Sets the option ID of this w l task option.
	*
	* @param optionId the option ID of this w l task option
	*/
	public void setOptionId(long optionId) {
		_wlTaskOption.setOptionId(optionId);
	}

	/**
	* Returns the group ID of this w l task option.
	*
	* @return the group ID of this w l task option
	*/
	public long getGroupId() {
		return _wlTaskOption.getGroupId();
	}

	/**
	* Sets the group ID of this w l task option.
	*
	* @param groupId the group ID of this w l task option
	*/
	public void setGroupId(long groupId) {
		_wlTaskOption.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this w l task option.
	*
	* @return the company ID of this w l task option
	*/
	public long getCompanyId() {
		return _wlTaskOption.getCompanyId();
	}

	/**
	* Sets the company ID of this w l task option.
	*
	* @param companyId the company ID of this w l task option
	*/
	public void setCompanyId(long companyId) {
		_wlTaskOption.setCompanyId(companyId);
	}

	/**
	* Returns the create user ID of this w l task option.
	*
	* @return the create user ID of this w l task option
	*/
	public long getCreateUserId() {
		return _wlTaskOption.getCreateUserId();
	}

	/**
	* Sets the create user ID of this w l task option.
	*
	* @param createUserId the create user ID of this w l task option
	*/
	public void setCreateUserId(long createUserId) {
		_wlTaskOption.setCreateUserId(createUserId);
	}

	/**
	* Returns the create user uuid of this w l task option.
	*
	* @return the create user uuid of this w l task option
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getCreateUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wlTaskOption.getCreateUserUuid();
	}

	/**
	* Sets the create user uuid of this w l task option.
	*
	* @param createUserUuid the create user uuid of this w l task option
	*/
	public void setCreateUserUuid(java.lang.String createUserUuid) {
		_wlTaskOption.setCreateUserUuid(createUserUuid);
	}

	/**
	* Returns the create user name of this w l task option.
	*
	* @return the create user name of this w l task option
	*/
	public java.lang.String getCreateUserName() {
		return _wlTaskOption.getCreateUserName();
	}

	/**
	* Sets the create user name of this w l task option.
	*
	* @param createUserName the create user name of this w l task option
	*/
	public void setCreateUserName(java.lang.String createUserName) {
		_wlTaskOption.setCreateUserName(createUserName);
	}

	/**
	* Returns the create date of this w l task option.
	*
	* @return the create date of this w l task option
	*/
	public java.util.Date getCreateDate() {
		return _wlTaskOption.getCreateDate();
	}

	/**
	* Sets the create date of this w l task option.
	*
	* @param createDate the create date of this w l task option
	*/
	public void setCreateDate(java.util.Date createDate) {
		_wlTaskOption.setCreateDate(createDate);
	}

	/**
	* Returns the modified user ID of this w l task option.
	*
	* @return the modified user ID of this w l task option
	*/
	public long getModifiedUserId() {
		return _wlTaskOption.getModifiedUserId();
	}

	/**
	* Sets the modified user ID of this w l task option.
	*
	* @param modifiedUserId the modified user ID of this w l task option
	*/
	public void setModifiedUserId(long modifiedUserId) {
		_wlTaskOption.setModifiedUserId(modifiedUserId);
	}

	/**
	* Returns the modified user uuid of this w l task option.
	*
	* @return the modified user uuid of this w l task option
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getModifiedUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wlTaskOption.getModifiedUserUuid();
	}

	/**
	* Sets the modified user uuid of this w l task option.
	*
	* @param modifiedUserUuid the modified user uuid of this w l task option
	*/
	public void setModifiedUserUuid(java.lang.String modifiedUserUuid) {
		_wlTaskOption.setModifiedUserUuid(modifiedUserUuid);
	}

	/**
	* Returns the modified user name of this w l task option.
	*
	* @return the modified user name of this w l task option
	*/
	public java.lang.String getModifiedUserName() {
		return _wlTaskOption.getModifiedUserName();
	}

	/**
	* Sets the modified user name of this w l task option.
	*
	* @param modifiedUserName the modified user name of this w l task option
	*/
	public void setModifiedUserName(java.lang.String modifiedUserName) {
		_wlTaskOption.setModifiedUserName(modifiedUserName);
	}

	/**
	* Returns the modified date of this w l task option.
	*
	* @return the modified date of this w l task option
	*/
	public java.util.Date getModifiedDate() {
		return _wlTaskOption.getModifiedDate();
	}

	/**
	* Sets the modified date of this w l task option.
	*
	* @param modifiedDate the modified date of this w l task option
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_wlTaskOption.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the task ID of this w l task option.
	*
	* @return the task ID of this w l task option
	*/
	public long getTaskId() {
		return _wlTaskOption.getTaskId();
	}

	/**
	* Sets the task ID of this w l task option.
	*
	* @param taskId the task ID of this w l task option
	*/
	public void setTaskId(long taskId) {
		_wlTaskOption.setTaskId(taskId);
	}

	/**
	* Returns the name of this w l task option.
	*
	* @return the name of this w l task option
	*/
	public java.lang.String getName() {
		return _wlTaskOption.getName();
	}

	/**
	* Sets the name of this w l task option.
	*
	* @param name the name of this w l task option
	*/
	public void setName(java.lang.String name) {
		_wlTaskOption.setName(name);
	}

	/**
	* Returns the data of this w l task option.
	*
	* @return the data of this w l task option
	*/
	public java.lang.String getData() {
		return _wlTaskOption.getData();
	}

	/**
	* Sets the data of this w l task option.
	*
	* @param data the data of this w l task option
	*/
	public void setData(java.lang.String data) {
		_wlTaskOption.setData(data);
	}

	public boolean isNew() {
		return _wlTaskOption.isNew();
	}

	public void setNew(boolean n) {
		_wlTaskOption.setNew(n);
	}

	public boolean isCachedModel() {
		return _wlTaskOption.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_wlTaskOption.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _wlTaskOption.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _wlTaskOption.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_wlTaskOption.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _wlTaskOption.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_wlTaskOption.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new WLTaskOptionWrapper((WLTaskOption)_wlTaskOption.clone());
	}

	public int compareTo(
		com.jenginetest.builder.model.WLTaskOption wlTaskOption) {
		return _wlTaskOption.compareTo(wlTaskOption);
	}

	@Override
	public int hashCode() {
		return _wlTaskOption.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.jenginetest.builder.model.WLTaskOption> toCacheModel() {
		return _wlTaskOption.toCacheModel();
	}

	public com.jenginetest.builder.model.WLTaskOption toEscapedModel() {
		return new WLTaskOptionWrapper(_wlTaskOption.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _wlTaskOption.toString();
	}

	public java.lang.String toXmlString() {
		return _wlTaskOption.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_wlTaskOption.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public WLTaskOption getWrappedWLTaskOption() {
		return _wlTaskOption;
	}

	public WLTaskOption getWrappedModel() {
		return _wlTaskOption;
	}

	public void resetOriginalValues() {
		_wlTaskOption.resetOriginalValues();
	}

	private WLTaskOption _wlTaskOption;
}