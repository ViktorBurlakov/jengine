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
 * This class is a wrapper for {@link Member}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       Member
 * @generated
 */
public class MemberWrapper implements Member, ModelWrapper<Member> {
	public MemberWrapper(Member member) {
		_member = member;
	}

	public Class<?> getModelClass() {
		return Member.class;
	}

	public String getModelClassName() {
		return Member.class.getName();
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
	* Returns the primary key of this member.
	*
	* @return the primary key of this member
	*/
	public long getPrimaryKey() {
		return _member.getPrimaryKey();
	}

	/**
	* Sets the primary key of this member.
	*
	* @param primaryKey the primary key of this member
	*/
	public void setPrimaryKey(long primaryKey) {
		_member.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the member ID of this member.
	*
	* @return the member ID of this member
	*/
	public long getMemberId() {
		return _member.getMemberId();
	}

	/**
	* Sets the member ID of this member.
	*
	* @param memberId the member ID of this member
	*/
	public void setMemberId(long memberId) {
		_member.setMemberId(memberId);
	}

	/**
	* Returns the library ID of this member.
	*
	* @return the library ID of this member
	*/
	public long getLibraryId() {
		return _member.getLibraryId();
	}

	/**
	* Sets the library ID of this member.
	*
	* @param libraryId the library ID of this member
	*/
	public void setLibraryId(long libraryId) {
		_member.setLibraryId(libraryId);
	}

	/**
	* Returns the first name of this member.
	*
	* @return the first name of this member
	*/
	public java.lang.String getFirstName() {
		return _member.getFirstName();
	}

	/**
	* Sets the first name of this member.
	*
	* @param firstName the first name of this member
	*/
	public void setFirstName(java.lang.String firstName) {
		_member.setFirstName(firstName);
	}

	/**
	* Returns the last name of this member.
	*
	* @return the last name of this member
	*/
	public java.lang.String getLastName() {
		return _member.getLastName();
	}

	/**
	* Sets the last name of this member.
	*
	* @param lastName the last name of this member
	*/
	public void setLastName(java.lang.String lastName) {
		_member.setLastName(lastName);
	}

	public boolean isNew() {
		return _member.isNew();
	}

	public void setNew(boolean n) {
		_member.setNew(n);
	}

	public boolean isCachedModel() {
		return _member.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_member.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _member.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _member.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_member.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _member.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_member.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MemberWrapper((Member)_member.clone());
	}

	public int compareTo(Member member) {
		return _member.compareTo(member);
	}

	@Override
	public int hashCode() {
		return _member.hashCode();
	}

	public com.liferay.portal.model.CacheModel<Member> toCacheModel() {
		return _member.toCacheModel();
	}

	public Member toEscapedModel() {
		return new MemberWrapper(_member.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _member.toString();
	}

	public java.lang.String toXmlString() {
		return _member.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_member.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Member getWrappedMember() {
		return _member;
	}

	public Member getWrappedModel() {
		return _member;
	}

	public void resetOriginalValues() {
		_member.resetOriginalValues();
	}

	private Member _member;
}