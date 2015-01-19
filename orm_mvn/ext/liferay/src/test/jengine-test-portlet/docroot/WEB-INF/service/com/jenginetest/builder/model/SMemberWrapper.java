/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.jenginetest.builder.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SMember}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       SMember
 * @generated
 */
public class SMemberWrapper implements SMember, ModelWrapper<SMember> {
	public SMemberWrapper(SMember sMember) {
		_sMember = sMember;
	}

	public Class<?> getModelClass() {
		return SMember.class;
	}

	public String getModelClassName() {
		return SMember.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("memberId", getMemberId());
		attributes.put("libraryId", getLibraryId());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long memberId = (Long)attributes.get("memberId");

		if (memberId != null) {
			setMemberId(memberId);
		}

		Long libraryId = (Long)attributes.get("libraryId");

		if (libraryId != null) {
			setLibraryId(libraryId);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}
	}

	/**
	* Returns the primary key of this s member.
	*
	* @return the primary key of this s member
	*/
	public long getPrimaryKey() {
		return _sMember.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s member.
	*
	* @param primaryKey the primary key of this s member
	*/
	public void setPrimaryKey(long primaryKey) {
		_sMember.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the member ID of this s member.
	*
	* @return the member ID of this s member
	*/
	public long getMemberId() {
		return _sMember.getMemberId();
	}

	/**
	* Sets the member ID of this s member.
	*
	* @param memberId the member ID of this s member
	*/
	public void setMemberId(long memberId) {
		_sMember.setMemberId(memberId);
	}

	/**
	* Returns the library ID of this s member.
	*
	* @return the library ID of this s member
	*/
	public long getLibraryId() {
		return _sMember.getLibraryId();
	}

	/**
	* Sets the library ID of this s member.
	*
	* @param libraryId the library ID of this s member
	*/
	public void setLibraryId(long libraryId) {
		_sMember.setLibraryId(libraryId);
	}

	/**
	* Returns the first name of this s member.
	*
	* @return the first name of this s member
	*/
	public java.lang.String getFirstName() {
		return _sMember.getFirstName();
	}

	/**
	* Sets the first name of this s member.
	*
	* @param firstName the first name of this s member
	*/
	public void setFirstName(java.lang.String firstName) {
		_sMember.setFirstName(firstName);
	}

	/**
	* Returns the last name of this s member.
	*
	* @return the last name of this s member
	*/
	public java.lang.String getLastName() {
		return _sMember.getLastName();
	}

	/**
	* Sets the last name of this s member.
	*
	* @param lastName the last name of this s member
	*/
	public void setLastName(java.lang.String lastName) {
		_sMember.setLastName(lastName);
	}

	public boolean isNew() {
		return _sMember.isNew();
	}

	public void setNew(boolean n) {
		_sMember.setNew(n);
	}

	public boolean isCachedModel() {
		return _sMember.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_sMember.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _sMember.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _sMember.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_sMember.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _sMember.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_sMember.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SMemberWrapper((SMember)_sMember.clone());
	}

	public int compareTo(com.jenginetest.builder.model.SMember sMember) {
		return _sMember.compareTo(sMember);
	}

	@Override
	public int hashCode() {
		return _sMember.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.jenginetest.builder.model.SMember> toCacheModel() {
		return _sMember.toCacheModel();
	}

	public com.jenginetest.builder.model.SMember toEscapedModel() {
		return new SMemberWrapper(_sMember.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _sMember.toString();
	}

	public java.lang.String toXmlString() {
		return _sMember.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_sMember.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public SMember getWrappedSMember() {
		return _sMember;
	}

	public SMember getWrappedModel() {
		return _sMember;
	}

	public void resetOriginalValues() {
		_sMember.resetOriginalValues();
	}

	private SMember _sMember;
}