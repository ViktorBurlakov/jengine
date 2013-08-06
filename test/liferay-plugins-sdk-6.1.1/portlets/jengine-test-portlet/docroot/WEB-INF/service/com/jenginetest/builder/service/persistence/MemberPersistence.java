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

import com.jenginetest.builder.model.Member;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the member service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MemberPersistenceImpl
 * @see MemberUtil
 * @generated
 */
public interface MemberPersistence extends BasePersistence<Member> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MemberUtil} to access the member persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the member in the entity cache if it is enabled.
	*
	* @param member the member
	*/
	public void cacheResult(com.jenginetest.builder.model.Member member);

	/**
	* Caches the members in the entity cache if it is enabled.
	*
	* @param members the members
	*/
	public void cacheResult(
		java.util.List<com.jenginetest.builder.model.Member> members);

	/**
	* Creates a new member with the primary key. Does not add the member to the database.
	*
	* @param memberId the primary key for the new member
	* @return the new member
	*/
	public com.jenginetest.builder.model.Member create(long memberId);

	/**
	* Removes the member with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param memberId the primary key of the member
	* @return the member that was removed
	* @throws com.jenginetest.builder.NoSuchMemberException if a member with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.Member remove(long memberId)
		throws com.jenginetest.builder.NoSuchMemberException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.jenginetest.builder.model.Member updateImpl(
		com.jenginetest.builder.model.Member member, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the member with the primary key or throws a {@link com.jenginetest.builder.NoSuchMemberException} if it could not be found.
	*
	* @param memberId the primary key of the member
	* @return the member
	* @throws com.jenginetest.builder.NoSuchMemberException if a member with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.Member findByPrimaryKey(long memberId)
		throws com.jenginetest.builder.NoSuchMemberException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the member with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param memberId the primary key of the member
	* @return the member, or <code>null</code> if a member with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.Member fetchByPrimaryKey(long memberId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the members.
	*
	* @return the members
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.Member> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the members.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of members
	* @param end the upper bound of the range of members (not inclusive)
	* @return the range of members
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.Member> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the members.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of members
	* @param end the upper bound of the range of members (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of members
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.Member> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the members from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of members.
	*
	* @return the number of members
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}