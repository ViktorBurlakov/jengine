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
 * This class is a wrapper for {@link SLibrary}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       SLibrary
 * @generated
 */
public class SLibraryWrapper implements SLibrary, ModelWrapper<SLibrary> {
	public SLibraryWrapper(SLibrary sLibrary) {
		_sLibrary = sLibrary;
	}

	public Class<?> getModelClass() {
		return SLibrary.class;
	}

	public String getModelClassName() {
		return SLibrary.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("libraryId", getLibraryId());
		attributes.put("name", getName());
		attributes.put("address", getAddress());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long libraryId = (Long)attributes.get("libraryId");

		if (libraryId != null) {
			setLibraryId(libraryId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}
	}

	/**
	* Returns the primary key of this s library.
	*
	* @return the primary key of this s library
	*/
	public long getPrimaryKey() {
		return _sLibrary.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s library.
	*
	* @param primaryKey the primary key of this s library
	*/
	public void setPrimaryKey(long primaryKey) {
		_sLibrary.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the library ID of this s library.
	*
	* @return the library ID of this s library
	*/
	public long getLibraryId() {
		return _sLibrary.getLibraryId();
	}

	/**
	* Sets the library ID of this s library.
	*
	* @param libraryId the library ID of this s library
	*/
	public void setLibraryId(long libraryId) {
		_sLibrary.setLibraryId(libraryId);
	}

	/**
	* Returns the name of this s library.
	*
	* @return the name of this s library
	*/
	public java.lang.String getName() {
		return _sLibrary.getName();
	}

	/**
	* Sets the name of this s library.
	*
	* @param name the name of this s library
	*/
	public void setName(java.lang.String name) {
		_sLibrary.setName(name);
	}

	/**
	* Returns the address of this s library.
	*
	* @return the address of this s library
	*/
	public java.lang.String getAddress() {
		return _sLibrary.getAddress();
	}

	/**
	* Sets the address of this s library.
	*
	* @param address the address of this s library
	*/
	public void setAddress(java.lang.String address) {
		_sLibrary.setAddress(address);
	}

	public boolean isNew() {
		return _sLibrary.isNew();
	}

	public void setNew(boolean n) {
		_sLibrary.setNew(n);
	}

	public boolean isCachedModel() {
		return _sLibrary.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_sLibrary.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _sLibrary.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _sLibrary.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_sLibrary.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _sLibrary.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_sLibrary.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SLibraryWrapper((SLibrary)_sLibrary.clone());
	}

	public int compareTo(SLibrary sLibrary) {
		return _sLibrary.compareTo(sLibrary);
	}

	@Override
	public int hashCode() {
		return _sLibrary.hashCode();
	}

	public com.liferay.portal.model.CacheModel<SLibrary> toCacheModel() {
		return _sLibrary.toCacheModel();
	}

	public SLibrary toEscapedModel() {
		return new SLibraryWrapper(_sLibrary.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _sLibrary.toString();
	}

	public java.lang.String toXmlString() {
		return _sLibrary.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_sLibrary.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public SLibrary getWrappedSLibrary() {
		return _sLibrary;
	}

	public SLibrary getWrappedModel() {
		return _sLibrary;
	}

	public void resetOriginalValues() {
		_sLibrary.resetOriginalValues();
	}

	private SLibrary _sLibrary;
}