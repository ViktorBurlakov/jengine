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
 * This class is a wrapper for {@link Library}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       Library
 * @generated
 */
public class LibraryWrapper implements Library, ModelWrapper<Library> {
	public LibraryWrapper(Library library) {
		_library = library;
	}

	public Class<?> getModelClass() {
		return Library.class;
	}

	public String getModelClassName() {
		return Library.class.getName();
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
	* Returns the primary key of this library.
	*
	* @return the primary key of this library
	*/
	public long getPrimaryKey() {
		return _library.getPrimaryKey();
	}

	/**
	* Sets the primary key of this library.
	*
	* @param primaryKey the primary key of this library
	*/
	public void setPrimaryKey(long primaryKey) {
		_library.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the library ID of this library.
	*
	* @return the library ID of this library
	*/
	public long getLibraryId() {
		return _library.getLibraryId();
	}

	/**
	* Sets the library ID of this library.
	*
	* @param libraryId the library ID of this library
	*/
	public void setLibraryId(long libraryId) {
		_library.setLibraryId(libraryId);
	}

	/**
	* Returns the name of this library.
	*
	* @return the name of this library
	*/
	public java.lang.String getName() {
		return _library.getName();
	}

	/**
	* Sets the name of this library.
	*
	* @param name the name of this library
	*/
	public void setName(java.lang.String name) {
		_library.setName(name);
	}

	/**
	* Returns the address of this library.
	*
	* @return the address of this library
	*/
	public java.lang.String getAddress() {
		return _library.getAddress();
	}

	/**
	* Sets the address of this library.
	*
	* @param address the address of this library
	*/
	public void setAddress(java.lang.String address) {
		_library.setAddress(address);
	}

	public boolean isNew() {
		return _library.isNew();
	}

	public void setNew(boolean n) {
		_library.setNew(n);
	}

	public boolean isCachedModel() {
		return _library.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_library.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _library.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _library.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_library.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _library.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_library.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LibraryWrapper((Library)_library.clone());
	}

	public int compareTo(Library library) {
		return _library.compareTo(library);
	}

	@Override
	public int hashCode() {
		return _library.hashCode();
	}

	public com.liferay.portal.model.CacheModel<Library> toCacheModel() {
		return _library.toCacheModel();
	}

	public Library toEscapedModel() {
		return new LibraryWrapper(_library.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _library.toString();
	}

	public java.lang.String toXmlString() {
		return _library.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_library.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Library getWrappedLibrary() {
		return _library;
	}

	public Library getWrappedModel() {
		return _library;
	}

	public void resetOriginalValues() {
		_library.resetOriginalValues();
	}

	private Library _library;
}