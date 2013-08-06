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

import com.jenginetest.builder.model.SMember;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the s member service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SMemberPersistenceImpl
 * @see SMemberUtil
 * @generated
 */
public interface SMemberPersistence extends BasePersistence<SMember> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SMemberUtil} to access the s member persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the s member in the entity cache if it is enabled.
	*
	* @param sMember the s member
	*/
	public void cacheResult(com.jenginetest.builder.model.SMember sMember);

	/**
	* Caches the s members in the entity cache if it is enabled.
	*
	* @param sMembers the s members
	*/
	public void cacheResult(
		java.util.List<com.jenginetest.builder.model.SMember> sMembers);

	/**
	* Creates a new s member with the primary key. Does not add the s member to the database.
	*
	* @param memberId the primary key for the new s member
	* @return the new s member
	*/
	public com.jenginetest.builder.model.SMember create(long memberId);

	/**
	* Removes the s member with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param memberId the primary key of the s member
	* @return the s member that was removed
	* @throws com.jenginetest.builder.NoSuchSMemberException if a s member with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.SMember remove(long memberId)
		throws com.jenginetest.builder.NoSuchSMemberException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.jenginetest.builder.model.SMember updateImpl(
		com.jenginetest.builder.model.SMember sMember, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s member with the primary key or throws a {@link com.jenginetest.builder.NoSuchSMemberException} if it could not be found.
	*
	* @param memberId the primary key of the s member
	* @return the s member
	* @throws com.jenginetest.builder.NoSuchSMemberException if a s member with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.SMember findByPrimaryKey(long memberId)
		throws com.jenginetest.builder.NoSuchSMemberException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s member with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param memberId the primary key of the s member
	* @return the s member, or <code>null</code> if a s member with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.SMember fetchByPrimaryKey(
		long memberId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s members.
	*
	* @return the s members
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.SMember> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s members.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of s members
	* @param end the upper bound of the range of s members (not inclusive)
	* @return the range of s members
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.SMember> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s members.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of s members
	* @param end the upper bound of the range of s members (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s members
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.SMember> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the s members from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s members.
	*
	* @return the number of s members
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}