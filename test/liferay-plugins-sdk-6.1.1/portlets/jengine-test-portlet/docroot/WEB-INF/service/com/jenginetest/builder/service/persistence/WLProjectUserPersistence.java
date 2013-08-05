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

package com.jenginetest.builder.service.persistence;

import com.jenginetest.builder.model.WLProjectUser;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the w l project user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WLProjectUserPersistenceImpl
 * @see WLProjectUserUtil
 * @generated
 */
public interface WLProjectUserPersistence extends BasePersistence<WLProjectUser> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WLProjectUserUtil} to access the w l project user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the w l project user in the entity cache if it is enabled.
	*
	* @param wlProjectUser the w l project user
	*/
	public void cacheResult(
		com.jenginetest.builder.model.WLProjectUser wlProjectUser);

	/**
	* Caches the w l project users in the entity cache if it is enabled.
	*
	* @param wlProjectUsers the w l project users
	*/
	public void cacheResult(
		java.util.List<com.jenginetest.builder.model.WLProjectUser> wlProjectUsers);

	/**
	* Creates a new w l project user with the primary key. Does not add the w l project user to the database.
	*
	* @param projectUserId the primary key for the new w l project user
	* @return the new w l project user
	*/
	public com.jenginetest.builder.model.WLProjectUser create(
		long projectUserId);

	/**
	* Removes the w l project user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param projectUserId the primary key of the w l project user
	* @return the w l project user that was removed
	* @throws com.jenginetest.builder.NoSuchProjectUserException if a w l project user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProjectUser remove(
		long projectUserId)
		throws com.jenginetest.builder.NoSuchProjectUserException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.jenginetest.builder.model.WLProjectUser updateImpl(
		com.jenginetest.builder.model.WLProjectUser wlProjectUser, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the w l project user with the primary key or throws a {@link com.jenginetest.builder.NoSuchProjectUserException} if it could not be found.
	*
	* @param projectUserId the primary key of the w l project user
	* @return the w l project user
	* @throws com.jenginetest.builder.NoSuchProjectUserException if a w l project user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProjectUser findByPrimaryKey(
		long projectUserId)
		throws com.jenginetest.builder.NoSuchProjectUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the w l project user with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param projectUserId the primary key of the w l project user
	* @return the w l project user, or <code>null</code> if a w l project user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProjectUser fetchByPrimaryKey(
		long projectUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the w l project users where projectId = &#63;.
	*
	* @param projectId the project ID
	* @return the matching w l project users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLProjectUser> findByProject(
		long projectId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the w l project users where projectId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param projectId the project ID
	* @param start the lower bound of the range of w l project users
	* @param end the upper bound of the range of w l project users (not inclusive)
	* @return the range of matching w l project users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLProjectUser> findByProject(
		long projectId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the w l project users where projectId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param projectId the project ID
	* @param start the lower bound of the range of w l project users
	* @param end the upper bound of the range of w l project users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching w l project users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLProjectUser> findByProject(
		long projectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first w l project user in the ordered set where projectId = &#63;.
	*
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching w l project user
	* @throws com.jenginetest.builder.NoSuchProjectUserException if a matching w l project user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProjectUser findByProject_First(
		long projectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchProjectUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first w l project user in the ordered set where projectId = &#63;.
	*
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching w l project user, or <code>null</code> if a matching w l project user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProjectUser fetchByProject_First(
		long projectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last w l project user in the ordered set where projectId = &#63;.
	*
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching w l project user
	* @throws com.jenginetest.builder.NoSuchProjectUserException if a matching w l project user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProjectUser findByProject_Last(
		long projectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchProjectUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last w l project user in the ordered set where projectId = &#63;.
	*
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching w l project user, or <code>null</code> if a matching w l project user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProjectUser fetchByProject_Last(
		long projectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the w l project users before and after the current w l project user in the ordered set where projectId = &#63;.
	*
	* @param projectUserId the primary key of the current w l project user
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next w l project user
	* @throws com.jenginetest.builder.NoSuchProjectUserException if a w l project user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProjectUser[] findByProject_PrevAndNext(
		long projectUserId, long projectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchProjectUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the w l project users where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching w l project users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLProjectUser> findByUser(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the w l project users where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of w l project users
	* @param end the upper bound of the range of w l project users (not inclusive)
	* @return the range of matching w l project users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLProjectUser> findByUser(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the w l project users where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of w l project users
	* @param end the upper bound of the range of w l project users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching w l project users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLProjectUser> findByUser(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first w l project user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching w l project user
	* @throws com.jenginetest.builder.NoSuchProjectUserException if a matching w l project user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProjectUser findByUser_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchProjectUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first w l project user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching w l project user, or <code>null</code> if a matching w l project user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProjectUser fetchByUser_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last w l project user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching w l project user
	* @throws com.jenginetest.builder.NoSuchProjectUserException if a matching w l project user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProjectUser findByUser_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchProjectUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last w l project user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching w l project user, or <code>null</code> if a matching w l project user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProjectUser fetchByUser_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the w l project users before and after the current w l project user in the ordered set where userId = &#63;.
	*
	* @param projectUserId the primary key of the current w l project user
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next w l project user
	* @throws com.jenginetest.builder.NoSuchProjectUserException if a w l project user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProjectUser[] findByUser_PrevAndNext(
		long projectUserId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchProjectUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the w l project users where groupId = &#63; and companyId = &#63; and userId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param userId the user ID
	* @return the matching w l project users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLProjectUser> findByG_C_User(
		long groupId, long companyId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the w l project users where groupId = &#63; and companyId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param userId the user ID
	* @param start the lower bound of the range of w l project users
	* @param end the upper bound of the range of w l project users (not inclusive)
	* @return the range of matching w l project users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLProjectUser> findByG_C_User(
		long groupId, long companyId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the w l project users where groupId = &#63; and companyId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param userId the user ID
	* @param start the lower bound of the range of w l project users
	* @param end the upper bound of the range of w l project users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching w l project users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLProjectUser> findByG_C_User(
		long groupId, long companyId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first w l project user in the ordered set where groupId = &#63; and companyId = &#63; and userId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching w l project user
	* @throws com.jenginetest.builder.NoSuchProjectUserException if a matching w l project user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProjectUser findByG_C_User_First(
		long groupId, long companyId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchProjectUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first w l project user in the ordered set where groupId = &#63; and companyId = &#63; and userId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching w l project user, or <code>null</code> if a matching w l project user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProjectUser fetchByG_C_User_First(
		long groupId, long companyId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last w l project user in the ordered set where groupId = &#63; and companyId = &#63; and userId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching w l project user
	* @throws com.jenginetest.builder.NoSuchProjectUserException if a matching w l project user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProjectUser findByG_C_User_Last(
		long groupId, long companyId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchProjectUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last w l project user in the ordered set where groupId = &#63; and companyId = &#63; and userId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching w l project user, or <code>null</code> if a matching w l project user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProjectUser fetchByG_C_User_Last(
		long groupId, long companyId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the w l project users before and after the current w l project user in the ordered set where groupId = &#63; and companyId = &#63; and userId = &#63;.
	*
	* @param projectUserId the primary key of the current w l project user
	* @param groupId the group ID
	* @param companyId the company ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next w l project user
	* @throws com.jenginetest.builder.NoSuchProjectUserException if a w l project user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProjectUser[] findByG_C_User_PrevAndNext(
		long projectUserId, long groupId, long companyId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchProjectUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the w l project user where groupId = &#63; and companyId = &#63; and userId = &#63; and projectId = &#63; or throws a {@link com.jenginetest.builder.NoSuchProjectUserException} if it could not be found.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param userId the user ID
	* @param projectId the project ID
	* @return the matching w l project user
	* @throws com.jenginetest.builder.NoSuchProjectUserException if a matching w l project user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProjectUser findByG_C_UserProject(
		long groupId, long companyId, long userId, long projectId)
		throws com.jenginetest.builder.NoSuchProjectUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the w l project user where groupId = &#63; and companyId = &#63; and userId = &#63; and projectId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param userId the user ID
	* @param projectId the project ID
	* @return the matching w l project user, or <code>null</code> if a matching w l project user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProjectUser fetchByG_C_UserProject(
		long groupId, long companyId, long userId, long projectId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the w l project user where groupId = &#63; and companyId = &#63; and userId = &#63; and projectId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param userId the user ID
	* @param projectId the project ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching w l project user, or <code>null</code> if a matching w l project user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProjectUser fetchByG_C_UserProject(
		long groupId, long companyId, long userId, long projectId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the w l project users where groupId = &#63; and companyId = &#63; and projectId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param projectId the project ID
	* @return the matching w l project users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLProjectUser> findByG_C_Project(
		long groupId, long companyId, long projectId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the w l project users where groupId = &#63; and companyId = &#63; and projectId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param projectId the project ID
	* @param start the lower bound of the range of w l project users
	* @param end the upper bound of the range of w l project users (not inclusive)
	* @return the range of matching w l project users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLProjectUser> findByG_C_Project(
		long groupId, long companyId, long projectId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the w l project users where groupId = &#63; and companyId = &#63; and projectId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param projectId the project ID
	* @param start the lower bound of the range of w l project users
	* @param end the upper bound of the range of w l project users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching w l project users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLProjectUser> findByG_C_Project(
		long groupId, long companyId, long projectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first w l project user in the ordered set where groupId = &#63; and companyId = &#63; and projectId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching w l project user
	* @throws com.jenginetest.builder.NoSuchProjectUserException if a matching w l project user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProjectUser findByG_C_Project_First(
		long groupId, long companyId, long projectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchProjectUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first w l project user in the ordered set where groupId = &#63; and companyId = &#63; and projectId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching w l project user, or <code>null</code> if a matching w l project user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProjectUser fetchByG_C_Project_First(
		long groupId, long companyId, long projectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last w l project user in the ordered set where groupId = &#63; and companyId = &#63; and projectId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching w l project user
	* @throws com.jenginetest.builder.NoSuchProjectUserException if a matching w l project user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProjectUser findByG_C_Project_Last(
		long groupId, long companyId, long projectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchProjectUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last w l project user in the ordered set where groupId = &#63; and companyId = &#63; and projectId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching w l project user, or <code>null</code> if a matching w l project user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProjectUser fetchByG_C_Project_Last(
		long groupId, long companyId, long projectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the w l project users before and after the current w l project user in the ordered set where groupId = &#63; and companyId = &#63; and projectId = &#63;.
	*
	* @param projectUserId the primary key of the current w l project user
	* @param groupId the group ID
	* @param companyId the company ID
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next w l project user
	* @throws com.jenginetest.builder.NoSuchProjectUserException if a w l project user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProjectUser[] findByG_C_Project_PrevAndNext(
		long projectUserId, long groupId, long companyId, long projectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchProjectUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the w l project user where projectId = &#63; and userId = &#63; or throws a {@link com.jenginetest.builder.NoSuchProjectUserException} if it could not be found.
	*
	* @param projectId the project ID
	* @param userId the user ID
	* @return the matching w l project user
	* @throws com.jenginetest.builder.NoSuchProjectUserException if a matching w l project user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProjectUser findByProjectAndUser(
		long projectId, long userId)
		throws com.jenginetest.builder.NoSuchProjectUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the w l project user where projectId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param projectId the project ID
	* @param userId the user ID
	* @return the matching w l project user, or <code>null</code> if a matching w l project user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProjectUser fetchByProjectAndUser(
		long projectId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the w l project user where projectId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param projectId the project ID
	* @param userId the user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching w l project user, or <code>null</code> if a matching w l project user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProjectUser fetchByProjectAndUser(
		long projectId, long userId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the w l project users.
	*
	* @return the w l project users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLProjectUser> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the w l project users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of w l project users
	* @param end the upper bound of the range of w l project users (not inclusive)
	* @return the range of w l project users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLProjectUser> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the w l project users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of w l project users
	* @param end the upper bound of the range of w l project users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of w l project users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLProjectUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the w l project users where projectId = &#63; from the database.
	*
	* @param projectId the project ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByProject(long projectId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the w l project users where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the w l project users where groupId = &#63; and companyId = &#63; and userId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_C_User(long groupId, long companyId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the w l project user where groupId = &#63; and companyId = &#63; and userId = &#63; and projectId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param userId the user ID
	* @param projectId the project ID
	* @return the w l project user that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProjectUser removeByG_C_UserProject(
		long groupId, long companyId, long userId, long projectId)
		throws com.jenginetest.builder.NoSuchProjectUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the w l project users where groupId = &#63; and companyId = &#63; and projectId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param projectId the project ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_C_Project(long groupId, long companyId, long projectId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the w l project user where projectId = &#63; and userId = &#63; from the database.
	*
	* @param projectId the project ID
	* @param userId the user ID
	* @return the w l project user that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProjectUser removeByProjectAndUser(
		long projectId, long userId)
		throws com.jenginetest.builder.NoSuchProjectUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the w l project users from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of w l project users where projectId = &#63;.
	*
	* @param projectId the project ID
	* @return the number of matching w l project users
	* @throws SystemException if a system exception occurred
	*/
	public int countByProject(long projectId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of w l project users where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching w l project users
	* @throws SystemException if a system exception occurred
	*/
	public int countByUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of w l project users where groupId = &#63; and companyId = &#63; and userId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param userId the user ID
	* @return the number of matching w l project users
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_C_User(long groupId, long companyId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of w l project users where groupId = &#63; and companyId = &#63; and userId = &#63; and projectId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param userId the user ID
	* @param projectId the project ID
	* @return the number of matching w l project users
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_C_UserProject(long groupId, long companyId,
		long userId, long projectId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of w l project users where groupId = &#63; and companyId = &#63; and projectId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param projectId the project ID
	* @return the number of matching w l project users
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_C_Project(long groupId, long companyId, long projectId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of w l project users where projectId = &#63; and userId = &#63;.
	*
	* @param projectId the project ID
	* @param userId the user ID
	* @return the number of matching w l project users
	* @throws SystemException if a system exception occurred
	*/
	public int countByProjectAndUser(long projectId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of w l project users.
	*
	* @return the number of w l project users
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}