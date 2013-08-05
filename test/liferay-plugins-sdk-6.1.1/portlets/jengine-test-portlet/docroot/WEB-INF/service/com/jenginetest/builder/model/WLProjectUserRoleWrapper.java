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
 * This class is a wrapper for {@link WLProjectUserRole}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       WLProjectUserRole
 * @generated
 */
public class WLProjectUserRoleWrapper implements WLProjectUserRole,
	ModelWrapper<WLProjectUserRole> {
	public WLProjectUserRoleWrapper(WLProjectUserRole wlProjectUserRole) {
		_wlProjectUserRole = wlProjectUserRole;
	}

	public Class<?> getModelClass() {
		return WLProjectUserRole.class;
	}

	public String getModelClassName() {
		return WLProjectUserRole.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("projectUserRoleId", getProjectUserRoleId());
		attributes.put("projectUserId", getProjectUserId());
		attributes.put("roleId", getRoleId());

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

	/**
	* Returns the primary key of this w l project user role.
	*
	* @return the primary key of this w l project user role
	*/
	public long getPrimaryKey() {
		return _wlProjectUserRole.getPrimaryKey();
	}

	/**
	* Sets the primary key of this w l project user role.
	*
	* @param primaryKey the primary key of this w l project user role
	*/
	public void setPrimaryKey(long primaryKey) {
		_wlProjectUserRole.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the group ID of this w l project user role.
	*
	* @return the group ID of this w l project user role
	*/
	public long getGroupId() {
		return _wlProjectUserRole.getGroupId();
	}

	/**
	* Sets the group ID of this w l project user role.
	*
	* @param groupId the group ID of this w l project user role
	*/
	public void setGroupId(long groupId) {
		_wlProjectUserRole.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this w l project user role.
	*
	* @return the company ID of this w l project user role
	*/
	public long getCompanyId() {
		return _wlProjectUserRole.getCompanyId();
	}

	/**
	* Sets the company ID of this w l project user role.
	*
	* @param companyId the company ID of this w l project user role
	*/
	public void setCompanyId(long companyId) {
		_wlProjectUserRole.setCompanyId(companyId);
	}

	/**
	* Returns the project user role ID of this w l project user role.
	*
	* @return the project user role ID of this w l project user role
	*/
	public long getProjectUserRoleId() {
		return _wlProjectUserRole.getProjectUserRoleId();
	}

	/**
	* Sets the project user role ID of this w l project user role.
	*
	* @param projectUserRoleId the project user role ID of this w l project user role
	*/
	public void setProjectUserRoleId(long projectUserRoleId) {
		_wlProjectUserRole.setProjectUserRoleId(projectUserRoleId);
	}

	/**
	* Returns the project user ID of this w l project user role.
	*
	* @return the project user ID of this w l project user role
	*/
	public long getProjectUserId() {
		return _wlProjectUserRole.getProjectUserId();
	}

	/**
	* Sets the project user ID of this w l project user role.
	*
	* @param projectUserId the project user ID of this w l project user role
	*/
	public void setProjectUserId(long projectUserId) {
		_wlProjectUserRole.setProjectUserId(projectUserId);
	}

	/**
	* Returns the project user uuid of this w l project user role.
	*
	* @return the project user uuid of this w l project user role
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getProjectUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wlProjectUserRole.getProjectUserUuid();
	}

	/**
	* Sets the project user uuid of this w l project user role.
	*
	* @param projectUserUuid the project user uuid of this w l project user role
	*/
	public void setProjectUserUuid(java.lang.String projectUserUuid) {
		_wlProjectUserRole.setProjectUserUuid(projectUserUuid);
	}

	/**
	* Returns the role ID of this w l project user role.
	*
	* @return the role ID of this w l project user role
	*/
	public long getRoleId() {
		return _wlProjectUserRole.getRoleId();
	}

	/**
	* Sets the role ID of this w l project user role.
	*
	* @param roleId the role ID of this w l project user role
	*/
	public void setRoleId(long roleId) {
		_wlProjectUserRole.setRoleId(roleId);
	}

	public boolean isNew() {
		return _wlProjectUserRole.isNew();
	}

	public void setNew(boolean n) {
		_wlProjectUserRole.setNew(n);
	}

	public boolean isCachedModel() {
		return _wlProjectUserRole.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_wlProjectUserRole.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _wlProjectUserRole.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _wlProjectUserRole.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_wlProjectUserRole.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _wlProjectUserRole.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_wlProjectUserRole.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new WLProjectUserRoleWrapper((WLProjectUserRole)_wlProjectUserRole.clone());
	}

	public int compareTo(
		com.jenginetest.builder.model.WLProjectUserRole wlProjectUserRole) {
		return _wlProjectUserRole.compareTo(wlProjectUserRole);
	}

	@Override
	public int hashCode() {
		return _wlProjectUserRole.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.jenginetest.builder.model.WLProjectUserRole> toCacheModel() {
		return _wlProjectUserRole.toCacheModel();
	}

	public com.jenginetest.builder.model.WLProjectUserRole toEscapedModel() {
		return new WLProjectUserRoleWrapper(_wlProjectUserRole.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _wlProjectUserRole.toString();
	}

	public java.lang.String toXmlString() {
		return _wlProjectUserRole.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_wlProjectUserRole.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public WLProjectUserRole getWrappedWLProjectUserRole() {
		return _wlProjectUserRole;
	}

	public WLProjectUserRole getWrappedModel() {
		return _wlProjectUserRole;
	}

	public void resetOriginalValues() {
		_wlProjectUserRole.resetOriginalValues();
	}

	private WLProjectUserRole _wlProjectUserRole;
}