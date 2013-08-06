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

package com.jenginetest.builder.service.persistence;

import com.jenginetest.builder.model.Author;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the author service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AuthorPersistenceImpl
 * @see AuthorUtil
 * @generated
 */
public interface AuthorPersistence extends BasePersistence<Author> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AuthorUtil} to access the author persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the author in the entity cache if it is enabled.
	*
	* @param author the author
	*/
	public void cacheResult(com.jenginetest.builder.model.Author author);

	/**
	* Caches the authors in the entity cache if it is enabled.
	*
	* @param authors the authors
	*/
	public void cacheResult(
		java.util.List<com.jenginetest.builder.model.Author> authors);

	/**
	* Creates a new author with the primary key. Does not add the author to the database.
	*
	* @param authorId the primary key for the new author
	* @return the new author
	*/
	public com.jenginetest.builder.model.Author create(long authorId);

	/**
	* Removes the author with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param authorId the primary key of the author
	* @return the author that was removed
	* @throws com.jenginetest.builder.NoSuchAuthorException if a author with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.Author remove(long authorId)
		throws com.jenginetest.builder.NoSuchAuthorException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.jenginetest.builder.model.Author updateImpl(
		com.jenginetest.builder.model.Author author, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the author with the primary key or throws a {@link com.jenginetest.builder.NoSuchAuthorException} if it could not be found.
	*
	* @param authorId the primary key of the author
	* @return the author
	* @throws com.jenginetest.builder.NoSuchAuthorException if a author with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.Author findByPrimaryKey(long authorId)
		throws com.jenginetest.builder.NoSuchAuthorException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the author with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param authorId the primary key of the author
	* @return the author, or <code>null</code> if a author with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.Author fetchByPrimaryKey(long authorId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the authors.
	*
	* @return the authors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.Author> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the authors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of authors
	* @param end the upper bound of the range of authors (not inclusive)
	* @return the range of authors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.Author> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the authors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of authors
	* @param end the upper bound of the range of authors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of authors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.Author> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the authors from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of authors.
	*
	* @return the number of authors
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}