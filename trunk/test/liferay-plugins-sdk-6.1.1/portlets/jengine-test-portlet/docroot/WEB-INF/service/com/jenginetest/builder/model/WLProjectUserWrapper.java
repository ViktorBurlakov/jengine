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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link WLProjectUser}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       WLProjectUser
 * @generated
 */
public class WLProjectUserWrapper implements WLProjectUser,
	ModelWrapper<WLProjectUser> {
	public WLProjectUserWrapper(WLProjectUser wlProjectUser) {
		_wlProjectUser = wlProjectUser;
	}

	public Class<?> getModelClass() {
		return WLProjectUser.class;
	}

	public String getModelClassName() {
		return WLProjectUser.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("projectUserId", getProjectUserId());
		attributes.put("userId", getUserId());
		attributes.put("projectId", getProjectId());

		return attributes;
	}

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

	/**
	* Returns the primary key of this w l project user.
	*
	* @return the primary key of this w l project user
	*/
	public long getPrimaryKey() {
		return _wlProjectUser.getPrimaryKey();
	}

	/**
	* Sets the primary key of this w l project user.
	*
	* @param primaryKey the primary key of this w l project user
	*/
	public void setPrimaryKey(long primaryKey) {
		_wlProjectUser.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the group ID of this w l project user.
	*
	* @return the group ID of this w l project user
	*/
	public long getGroupId() {
		return _wlProjectUser.getGroupId();
	}

	/**
	* Sets the group ID of this w l project user.
	*
	* @param groupId the group ID of this w l project user
	*/
	public void setGroupId(long groupId) {
		_wlProjectUser.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this w l project user.
	*
	* @return the company ID of this w l project user
	*/
	public long getCompanyId() {
		return _wlProjectUser.getCompanyId();
	}

	/**
	* Sets the company ID of this w l project user.
	*
	* @param companyId the company ID of this w l project user
	*/
	public void setCompanyId(long companyId) {
		_wlProjectUser.setCompanyId(companyId);
	}

	/**
	* Returns the project user ID of this w l project user.
	*
	* @return the project user ID of this w l project user
	*/
	public long getProjectUserId() {
		return _wlProjectUser.getProjectUserId();
	}

	/**
	* Sets the project user ID of this w l project user.
	*
	* @param projectUserId the project user ID of this w l project user
	*/
	public void setProjectUserId(long projectUserId) {
		_wlProjectUser.setProjectUserId(projectUserId);
	}

	/**
	* Returns the project user uuid of this w l project user.
	*
	* @return the project user uuid of this w l project user
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getProjectUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wlProjectUser.getProjectUserUuid();
	}

	/**
	* Sets the project user uuid of this w l project user.
	*
	* @param projectUserUuid the project user uuid of this w l project user
	*/
	public void setProjectUserUuid(java.lang.String projectUserUuid) {
		_wlProjectUser.setProjectUserUuid(projectUserUuid);
	}

	/**
	* Returns the user ID of this w l project user.
	*
	* @return the user ID of this w l project user
	*/
	public long getUserId() {
		return _wlProjectUser.getUserId();
	}

	/**
	* Sets the user ID of this w l project user.
	*
	* @param userId the user ID of this w l project user
	*/
	public void setUserId(long userId) {
		_wlProjectUser.setUserId(userId);
	}

	/**
	* Returns the user uuid of this w l project user.
	*
	* @return the user uuid of this w l project user
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wlProjectUser.getUserUuid();
	}

	/**
	* Sets the user uuid of this w l project user.
	*
	* @param userUuid the user uuid of this w l project user
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_wlProjectUser.setUserUuid(userUuid);
	}

	/**
	* Returns the project ID of this w l project user.
	*
	* @return the project ID of this w l project user
	*/
	public long getProjectId() {
		return _wlProjectUser.getProjectId();
	}

	/**
	* Sets the project ID of this w l project user.
	*
	* @param projectId the project ID of this w l project user
	*/
	public void setProjectId(long projectId) {
		_wlProjectUser.setProjectId(projectId);
	}

	public boolean isNew() {
		return _wlProjectUser.isNew();
	}

	public void setNew(boolean n) {
		_wlProjectUser.setNew(n);
	}

	public boolean isCachedModel() {
		return _wlProjectUser.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_wlProjectUser.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _wlProjectUser.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _wlProjectUser.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_wlProjectUser.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _wlProjectUser.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_wlProjectUser.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new WLProjectUserWrapper((WLProjectUser)_wlProjectUser.clone());
	}

	public int compareTo(
		com.jenginetest.builder.model.WLProjectUser wlProjectUser) {
		return _wlProjectUser.compareTo(wlProjectUser);
	}

	@Override
	public int hashCode() {
		return _wlProjectUser.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.jenginetest.builder.model.WLProjectUser> toCacheModel() {
		return _wlProjectUser.toCacheModel();
	}

	public com.jenginetest.builder.model.WLProjectUser toEscapedModel() {
		return new WLProjectUserWrapper(_wlProjectUser.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _wlProjectUser.toString();
	}

	public java.lang.String toXmlString() {
		return _wlProjectUser.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_wlProjectUser.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public WLProjectUser getWrappedWLProjectUser() {
		return _wlProjectUser;
	}

	public WLProjectUser getWrappedModel() {
		return _wlProjectUser;
	}

	public void resetOriginalValues() {
		_wlProjectUser.resetOriginalValues();
	}

	private WLProjectUser _wlProjectUser;
}