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

import com.jenginetest.builder.model.SLibrary;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the s library service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SLibraryPersistenceImpl
 * @see SLibraryUtil
 * @generated
 */
public interface SLibraryPersistence extends BasePersistence<SLibrary> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SLibraryUtil} to access the s library persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the s library in the entity cache if it is enabled.
	*
	* @param sLibrary the s library
	*/
	public void cacheResult(com.jenginetest.builder.model.SLibrary sLibrary);

	/**
	* Caches the s libraries in the entity cache if it is enabled.
	*
	* @param sLibraries the s libraries
	*/
	public void cacheResult(
		java.util.List<com.jenginetest.builder.model.SLibrary> sLibraries);

	/**
	* Creates a new s library with the primary key. Does not add the s library to the database.
	*
	* @param libraryId the primary key for the new s library
	* @return the new s library
	*/
	public com.jenginetest.builder.model.SLibrary create(long libraryId);

	/**
	* Removes the s library with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param libraryId the primary key of the s library
	* @return the s library that was removed
	* @throws com.jenginetest.builder.NoSuchSLibraryException if a s library with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.SLibrary remove(long libraryId)
		throws com.jenginetest.builder.NoSuchSLibraryException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.jenginetest.builder.model.SLibrary updateImpl(
		com.jenginetest.builder.model.SLibrary sLibrary, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s library with the primary key or throws a {@link com.jenginetest.builder.NoSuchSLibraryException} if it could not be found.
	*
	* @param libraryId the primary key of the s library
	* @return the s library
	* @throws com.jenginetest.builder.NoSuchSLibraryException if a s library with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.SLibrary findByPrimaryKey(
		long libraryId)
		throws com.jenginetest.builder.NoSuchSLibraryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s library with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param libraryId the primary key of the s library
	* @return the s library, or <code>null</code> if a s library with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.SLibrary fetchByPrimaryKey(
		long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s libraries.
	*
	* @return the s libraries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.SLibrary> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s libraries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of s libraries
	* @param end the upper bound of the range of s libraries (not inclusive)
	* @return the range of s libraries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.SLibrary> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s libraries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of s libraries
	* @param end the upper bound of the range of s libraries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s libraries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.SLibrary> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the s libraries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s libraries.
	*
	* @return the number of s libraries
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}