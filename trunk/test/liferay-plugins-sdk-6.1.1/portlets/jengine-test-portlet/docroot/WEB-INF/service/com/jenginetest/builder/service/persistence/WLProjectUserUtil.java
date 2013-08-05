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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the w l project user service. This utility wraps {@link WLProjectUserPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WLProjectUserPersistence
 * @see WLProjectUserPersistenceImpl
 * @generated
 */
public class WLProjectUserUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(WLProjectUser wlProjectUser) {
		getPersistence().clearCache(wlProjectUser);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<WLProjectUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WLProjectUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WLProjectUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static WLProjectUser update(WLProjectUser wlProjectUser,
		boolean merge) throws SystemException {
		return getPersistence().update(wlProjectUser, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static WLProjectUser update(WLProjectUser wlProjectUser,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(wlProjectUser, merge, serviceContext);
	}

	/**
	* Caches the w l project user in the entity cache if it is enabled.
	*
	* @param wlProjectUser the w l project user
	*/
	public static void cacheResult(
		com.jenginetest.builder.model.WLProjectUser wlProjectUser) {
		getPersistence().cacheResult(wlProjectUser);
	}

	/**
	* Caches the w l project users in the entity cache if it is enabled.
	*
	* @param wlProjectUsers the w l project users
	*/
	public static void cacheResult(
		java.util.List<com.jenginetest.builder.model.WLProjectUser> wlProjectUsers) {
		getPersistence().cacheResult(wlProjectUsers);
	}

	/**
	* Creates a new w l project user with the primary key. Does not add the w l project user to the database.
	*
	* @param projectUserId the primary key for the new w l project user
	* @return the new w l project user
	*/
	public static com.jenginetest.builder.model.WLProjectUser create(
		long projectUserId) {
		return getPersistence().create(projectUserId);
	}

	/**
	* Removes the w l project user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param projectUserId the primary key of the w l project user
	* @return the w l project user that was removed
	* @throws com.jenginetest.builder.NoSuchProjectUserException if a w l project user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLProjectUser remove(
		long projectUserId)
		throws com.jenginetest.builder.NoSuchProjectUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(projectUserId);
	}

	public static com.jenginetest.builder.model.WLProjectUser updateImpl(
		com.jenginetest.builder.model.WLProjectUser wlProjectUser, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(wlProjectUser, merge);
	}

	/**
	* Returns the w l project user with the primary key or throws a {@link com.jenginetest.builder.NoSuchProjectUserException} if it could not be found.
	*
	* @param projectUserId the primary key of the w l project user
	* @return the w l project user
	* @throws com.jenginetest.builder.NoSuchProjectUserException if a w l project user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLProjectUser findByPrimaryKey(
		long projectUserId)
		throws com.jenginetest.builder.NoSuchProjectUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(projectUserId);
	}

	/**
	* Returns the w l project user with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param projectUserId the primary key of the w l project user
	* @return the w l project user, or <code>null</code> if a w l project user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLProjectUser fetchByPrimaryKey(
		long projectUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(projectUserId);
	}

	/**
	* Returns all the w l project users where projectId = &#63;.
	*
	* @param projectId the project ID
	* @return the matching w l project users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jenginetest.builder.model.WLProjectUser> findByProject(
		long projectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByProject(projectId);
	}

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
	public static java.util.List<com.jenginetest.builder.model.WLProjectUser> findByProject(
		long projectId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByProject(projectId, start, end);
	}

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
	public static java.util.List<com.jenginetest.builder.model.WLProjectUser> findByProject(
		long projectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProject(projectId, start, end, orderByComparator);
	}

	/**
	* Returns the first w l project user in the ordered set where projectId = &#63;.
	*
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching w l project user
	* @throws com.jenginetest.builder.NoSuchProjectUserException if a matching w l project user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLProjectUser findByProject_First(
		long projectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchProjectUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByProject_First(projectId, orderByComparator);
	}

	/**
	* Returns the first w l project user in the ordered set where projectId = &#63;.
	*
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching w l project user, or <code>null</code> if a matching w l project user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLProjectUser fetchByProject_First(
		long projectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProject_First(projectId, orderByComparator);
	}

	/**
	* Returns the last w l project user in the ordered set where projectId = &#63;.
	*
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching w l project user
	* @throws com.jenginetest.builder.NoSuchProjectUserException if a matching w l project user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLProjectUser findByProject_Last(
		long projectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchProjectUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByProject_Last(projectId, orderByComparator);
	}

	/**
	* Returns the last w l project user in the ordered set where projectId = &#63;.
	*
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching w l project user, or <code>null</code> if a matching w l project user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLProjectUser fetchByProject_Last(
		long projectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByProject_Last(projectId, orderByComparator);
	}

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
	public static com.jenginetest.builder.model.WLProjectUser[] findByProject_PrevAndNext(
		long projectUserId, long projectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchProjectUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProject_PrevAndNext(projectUserId, projectId,
			orderByComparator);
	}

	/**
	* Returns all the w l project users where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching w l project users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jenginetest.builder.model.WLProjectUser> findByUser(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser(userId);
	}

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
	public static java.util.List<com.jenginetest.builder.model.WLProjectUser> findByUser(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser(userId, start, end);
	}

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
	public static java.util.List<com.jenginetest.builder.model.WLProjectUser> findByUser(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser(userId, start, end, orderByComparator);
	}

	/**
	* Returns the first w l project user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching w l project user
	* @throws com.jenginetest.builder.NoSuchProjectUserException if a matching w l project user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLProjectUser findByUser_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchProjectUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser_First(userId, orderByComparator);
	}

	/**
	* Returns the first w l project user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching w l project user, or <code>null</code> if a matching w l project user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLProjectUser fetchByUser_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUser_First(userId, orderByComparator);
	}

	/**
	* Returns the last w l project user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching w l project user
	* @throws com.jenginetest.builder.NoSuchProjectUserException if a matching w l project user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLProjectUser findByUser_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchProjectUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser_Last(userId, orderByComparator);
	}

	/**
	* Returns the last w l project user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching w l project user, or <code>null</code> if a matching w l project user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLProjectUser fetchByUser_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUser_Last(userId, orderByComparator);
	}

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
	public static com.jenginetest.builder.model.WLProjectUser[] findByUser_PrevAndNext(
		long projectUserId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchProjectUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUser_PrevAndNext(projectUserId, userId,
			orderByComparator);
	}

	/**
	* Returns all the w l project users where groupId = &#63; and companyId = &#63; and userId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param userId the user ID
	* @return the matching w l project users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jenginetest.builder.model.WLProjectUser> findByG_C_User(
		long groupId, long companyId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_C_User(groupId, companyId, userId);
	}

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
	public static java.util.List<com.jenginetest.builder.model.WLProjectUser> findByG_C_User(
		long groupId, long companyId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_C_User(groupId, companyId, userId, start, end);
	}

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
	public static java.util.List<com.jenginetest.builder.model.WLProjectUser> findByG_C_User(
		long groupId, long companyId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_C_User(groupId, companyId, userId, start, end,
			orderByComparator);
	}

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
	public static com.jenginetest.builder.model.WLProjectUser findByG_C_User_First(
		long groupId, long companyId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchProjectUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_C_User_First(groupId, companyId, userId,
			orderByComparator);
	}

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
	public static com.jenginetest.builder.model.WLProjectUser fetchByG_C_User_First(
		long groupId, long companyId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_C_User_First(groupId, companyId, userId,
			orderByComparator);
	}

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
	public static com.jenginetest.builder.model.WLProjectUser findByG_C_User_Last(
		long groupId, long companyId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchProjectUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_C_User_Last(groupId, companyId, userId,
			orderByComparator);
	}

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
	public static com.jenginetest.builder.model.WLProjectUser fetchByG_C_User_Last(
		long groupId, long companyId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_C_User_Last(groupId, companyId, userId,
			orderByComparator);
	}

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
	public static com.jenginetest.builder.model.WLProjectUser[] findByG_C_User_PrevAndNext(
		long projectUserId, long groupId, long companyId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchProjectUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_C_User_PrevAndNext(projectUserId, groupId,
			companyId, userId, orderByComparator);
	}

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
	public static com.jenginetest.builder.model.WLProjectUser findByG_C_UserProject(
		long groupId, long companyId, long userId, long projectId)
		throws com.jenginetest.builder.NoSuchProjectUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_C_UserProject(groupId, companyId, userId, projectId);
	}

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
	public static com.jenginetest.builder.model.WLProjectUser fetchByG_C_UserProject(
		long groupId, long companyId, long userId, long projectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_C_UserProject(groupId, companyId, userId, projectId);
	}

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
	public static com.jenginetest.builder.model.WLProjectUser fetchByG_C_UserProject(
		long groupId, long companyId, long userId, long projectId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_C_UserProject(groupId, companyId, userId,
			projectId, retrieveFromCache);
	}

	/**
	* Returns all the w l project users where groupId = &#63; and companyId = &#63; and projectId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param projectId the project ID
	* @return the matching w l project users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jenginetest.builder.model.WLProjectUser> findByG_C_Project(
		long groupId, long companyId, long projectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_C_Project(groupId, companyId, projectId);
	}

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
	public static java.util.List<com.jenginetest.builder.model.WLProjectUser> findByG_C_Project(
		long groupId, long companyId, long projectId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_C_Project(groupId, companyId, projectId, start, end);
	}

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
	public static java.util.List<com.jenginetest.builder.model.WLProjectUser> findByG_C_Project(
		long groupId, long companyId, long projectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_C_Project(groupId, companyId, projectId, start,
			end, orderByComparator);
	}

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
	public static com.jenginetest.builder.model.WLProjectUser findByG_C_Project_First(
		long groupId, long companyId, long projectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchProjectUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_C_Project_First(groupId, companyId, projectId,
			orderByComparator);
	}

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
	public static com.jenginetest.builder.model.WLProjectUser fetchByG_C_Project_First(
		long groupId, long companyId, long projectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_C_Project_First(groupId, companyId, projectId,
			orderByComparator);
	}

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
	public static com.jenginetest.builder.model.WLProjectUser findByG_C_Project_Last(
		long groupId, long companyId, long projectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchProjectUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_C_Project_Last(groupId, companyId, projectId,
			orderByComparator);
	}

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
	public static com.jenginetest.builder.model.WLProjectUser fetchByG_C_Project_Last(
		long groupId, long companyId, long projectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_C_Project_Last(groupId, companyId, projectId,
			orderByComparator);
	}

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
	public static com.jenginetest.builder.model.WLProjectUser[] findByG_C_Project_PrevAndNext(
		long projectUserId, long groupId, long companyId, long projectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchProjectUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_C_Project_PrevAndNext(projectUserId, groupId,
			companyId, projectId, orderByComparator);
	}

	/**
	* Returns the w l project user where projectId = &#63; and userId = &#63; or throws a {@link com.jenginetest.builder.NoSuchProjectUserException} if it could not be found.
	*
	* @param projectId the project ID
	* @param userId the user ID
	* @return the matching w l project user
	* @throws com.jenginetest.builder.NoSuchProjectUserException if a matching w l project user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLProjectUser findByProjectAndUser(
		long projectId, long userId)
		throws com.jenginetest.builder.NoSuchProjectUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByProjectAndUser(projectId, userId);
	}

	/**
	* Returns the w l project user where projectId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param projectId the project ID
	* @param userId the user ID
	* @return the matching w l project user, or <code>null</code> if a matching w l project user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLProjectUser fetchByProjectAndUser(
		long projectId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByProjectAndUser(projectId, userId);
	}

	/**
	* Returns the w l project user where projectId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param projectId the project ID
	* @param userId the user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching w l project user, or <code>null</code> if a matching w l project user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLProjectUser fetchByProjectAndUser(
		long projectId, long userId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProjectAndUser(projectId, userId, retrieveFromCache);
	}

	/**
	* Returns all the w l project users.
	*
	* @return the w l project users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jenginetest.builder.model.WLProjectUser> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.jenginetest.builder.model.WLProjectUser> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.jenginetest.builder.model.WLProjectUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the w l project users where projectId = &#63; from the database.
	*
	* @param projectId the project ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByProject(long projectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByProject(projectId);
	}

	/**
	* Removes all the w l project users where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUser(userId);
	}

	/**
	* Removes all the w l project users where groupId = &#63; and companyId = &#63; and userId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_C_User(long groupId, long companyId,
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_C_User(groupId, companyId, userId);
	}

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
	public static com.jenginetest.builder.model.WLProjectUser removeByG_C_UserProject(
		long groupId, long companyId, long userId, long projectId)
		throws com.jenginetest.builder.NoSuchProjectUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .removeByG_C_UserProject(groupId, companyId, userId,
			projectId);
	}

	/**
	* Removes all the w l project users where groupId = &#63; and companyId = &#63; and projectId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param projectId the project ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_C_Project(long groupId, long companyId,
		long projectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_C_Project(groupId, companyId, projectId);
	}

	/**
	* Removes the w l project user where projectId = &#63; and userId = &#63; from the database.
	*
	* @param projectId the project ID
	* @param userId the user ID
	* @return the w l project user that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLProjectUser removeByProjectAndUser(
		long projectId, long userId)
		throws com.jenginetest.builder.NoSuchProjectUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByProjectAndUser(projectId, userId);
	}

	/**
	* Removes all the w l project users from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of w l project users where projectId = &#63;.
	*
	* @param projectId the project ID
	* @return the number of matching w l project users
	* @throws SystemException if a system exception occurred
	*/
	public static int countByProject(long projectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByProject(projectId);
	}

	/**
	* Returns the number of w l project users where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching w l project users
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUser(userId);
	}

	/**
	* Returns the number of w l project users where groupId = &#63; and companyId = &#63; and userId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param userId the user ID
	* @return the number of matching w l project users
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_C_User(long groupId, long companyId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_C_User(groupId, companyId, userId);
	}

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
	public static int countByG_C_UserProject(long groupId, long companyId,
		long userId, long projectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByG_C_UserProject(groupId, companyId, userId, projectId);
	}

	/**
	* Returns the number of w l project users where groupId = &#63; and companyId = &#63; and projectId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param projectId the project ID
	* @return the number of matching w l project users
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_C_Project(long groupId, long companyId,
		long projectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_C_Project(groupId, companyId, projectId);
	}

	/**
	* Returns the number of w l project users where projectId = &#63; and userId = &#63;.
	*
	* @param projectId the project ID
	* @param userId the user ID
	* @return the number of matching w l project users
	* @throws SystemException if a system exception occurred
	*/
	public static int countByProjectAndUser(long projectId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByProjectAndUser(projectId, userId);
	}

	/**
	* Returns the number of w l project users.
	*
	* @return the number of w l project users
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static WLProjectUserPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (WLProjectUserPersistence)PortletBeanLocatorUtil.locate(com.jenginetest.builder.service.ClpSerializer.getServletContextName(),
					WLProjectUserPersistence.class.getName());

			ReferenceRegistry.registerReference(WLProjectUserUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(WLProjectUserPersistence persistence) {
	}

	private static WLProjectUserPersistence _persistence;
}