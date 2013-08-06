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
 * This class is a wrapper for {@link Author}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       Author
 * @generated
 */
public class AuthorWrapper implements Author, ModelWrapper<Author> {
	public AuthorWrapper(Author author) {
		_author = author;
	}

	public Class<?> getModelClass() {
		return Author.class;
	}

	public String getModelClassName() {
		return Author.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("authorId", getAuthorId());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long authorId = (Long)attributes.get("authorId");

		if (authorId != null) {
			setAuthorId(authorId);
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
	* Returns the primary key of this author.
	*
	* @return the primary key of this author
	*/
	public long getPrimaryKey() {
		return _author.getPrimaryKey();
	}

	/**
	* Sets the primary key of this author.
	*
	* @param primaryKey the primary key of this author
	*/
	public void setPrimaryKey(long primaryKey) {
		_author.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the author ID of this author.
	*
	* @return the author ID of this author
	*/
	public long getAuthorId() {
		return _author.getAuthorId();
	}

	/**
	* Sets the author ID of this author.
	*
	* @param authorId the author ID of this author
	*/
	public void setAuthorId(long authorId) {
		_author.setAuthorId(authorId);
	}

	/**
	* Returns the first name of this author.
	*
	* @return the first name of this author
	*/
	public java.lang.String getFirstName() {
		return _author.getFirstName();
	}

	/**
	* Sets the first name of this author.
	*
	* @param firstName the first name of this author
	*/
	public void setFirstName(java.lang.String firstName) {
		_author.setFirstName(firstName);
	}

	/**
	* Returns the last name of this author.
	*
	* @return the last name of this author
	*/
	public java.lang.String getLastName() {
		return _author.getLastName();
	}

	/**
	* Sets the last name of this author.
	*
	* @param lastName the last name of this author
	*/
	public void setLastName(java.lang.String lastName) {
		_author.setLastName(lastName);
	}

	public boolean isNew() {
		return _author.isNew();
	}

	public void setNew(boolean n) {
		_author.setNew(n);
	}

	public boolean isCachedModel() {
		return _author.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_author.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _author.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _author.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_author.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _author.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_author.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AuthorWrapper((Author)_author.clone());
	}

	public int compareTo(Author author) {
		return _author.compareTo(author);
	}

	@Override
	public int hashCode() {
		return _author.hashCode();
	}

	public com.liferay.portal.model.CacheModel<Author> toCacheModel() {
		return _author.toCacheModel();
	}

	public Author toEscapedModel() {
		return new AuthorWrapper(_author.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _author.toString();
	}

	public java.lang.String toXmlString() {
		return _author.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_author.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Author getWrappedAuthor() {
		return _author;
	}

	public Author getWrappedModel() {
		return _author;
	}

	public void resetOriginalValues() {
		_author.resetOriginalValues();
	}

	private Author _author;
}