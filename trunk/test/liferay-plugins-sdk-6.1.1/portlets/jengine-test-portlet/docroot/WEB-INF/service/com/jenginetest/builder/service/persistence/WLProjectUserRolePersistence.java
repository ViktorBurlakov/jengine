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

import com.jenginetest.builder.model.WLProjectUserRole;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the w l project user role service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WLProjectUserRolePersistenceImpl
 * @see WLProjectUserRoleUtil
 * @generated
 */
public interface WLProjectUserRolePersistence extends BasePersistence<WLProjectUserRole> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WLProjectUserRoleUtil} to access the w l project user role persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the w l project user role in the entity cache if it is enabled.
	*
	* @param wlProjectUserRole the w l project user role
	*/
	public void cacheResult(
		com.jenginetest.builder.model.WLProjectUserRole wlProjectUserRole);

	/**
	* Caches the w l project user roles in the entity cache if it is enabled.
	*
	* @param wlProjectUserRoles the w l project user roles
	*/
	public void cacheResult(
		java.util.List<com.jenginetest.builder.model.WLProjectUserRole> wlProjectUserRoles);

	/**
	* Creates a new w l project user role with the primary key. Does not add the w l project user role to the database.
	*
	* @param projectUserRoleId the primary key for the new w l project user role
	* @return the new w l project user role
	*/
	public com.jenginetest.builder.model.WLProjectUserRole create(
		long projectUserRoleId);

	/**
	* Removes the w l project user role with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param projectUserRoleId the primary key of the w l project user role
	* @return the w l project user role that was removed
	* @throws com.jenginetest.builder.NoSuchProjectUserRoleException if a w l project user role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProjectUserRole remove(
		long projectUserRoleId)
		throws com.jenginetest.builder.NoSuchProjectUserRoleException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.jenginetest.builder.model.WLProjectUserRole updateImpl(
		com.jenginetest.builder.model.WLProjectUserRole wlProjectUserRole,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the w l project user role with the primary key or throws a {@link com.jenginetest.builder.NoSuchProjectUserRoleException} if it could not be found.
	*
	* @param projectUserRoleId the primary key of the w l project user role
	* @return the w l project user role
	* @throws com.jenginetest.builder.NoSuchProjectUserRoleException if a w l project user role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProjectUserRole findByPrimaryKey(
		long projectUserRoleId)
		throws com.jenginetest.builder.NoSuchProjectUserRoleException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the w l project user role with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param projectUserRoleId the primary key of the w l project user role
	* @return the w l project user role, or <code>null</code> if a w l project user role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProjectUserRole fetchByPrimaryKey(
		long projectUserRoleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the w l project user roles where projectUserId = &#63;.
	*
	* @param projectUserId the project user ID
	* @return the matching w l project user roles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLProjectUserRole> findByPU(
		long projectUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the w l project user roles where projectUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param projectUserId the project user ID
	* @param start the lower bound of the range of w l project user roles
	* @param end the upper bound of the range of w l project user roles (not inclusive)
	* @return the range of matching w l project user roles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLProjectUserRole> findByPU(
		long projectUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the w l project user roles where projectUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param projectUserId the project user ID
	* @param start the lower bound of the range of w l project user roles
	* @param end the upper bound of the range of w l project user roles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching w l project user roles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLProjectUserRole> findByPU(
		long projectUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first w l project user role in the ordered set where projectUserId = &#63;.
	*
	* @param projectUserId the project user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching w l project user role
	* @throws com.jenginetest.builder.NoSuchProjectUserRoleException if a matching w l project user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProjectUserRole findByPU_First(
		long projectUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchProjectUserRoleException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first w l project user role in the ordered set where projectUserId = &#63;.
	*
	* @param projectUserId the project user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching w l project user role, or <code>null</code> if a matching w l project user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProjectUserRole fetchByPU_First(
		long projectUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last w l project user role in the ordered set where projectUserId = &#63;.
	*
	* @param projectUserId the project user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching w l project user role
	* @throws com.jenginetest.builder.NoSuchProjectUserRoleException if a matching w l project user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProjectUserRole findByPU_Last(
		long projectUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchProjectUserRoleException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last w l project user role in the ordered set where projectUserId = &#63;.
	*
	* @param projectUserId the project user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching w l project user role, or <code>null</code> if a matching w l project user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProjectUserRole fetchByPU_Last(
		long projectUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the w l project user roles before and after the current w l project user role in the ordered set where projectUserId = &#63;.
	*
	* @param projectUserRoleId the primary key of the current w l project user role
	* @param projectUserId the project user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next w l project user role
	* @throws com.jenginetest.builder.NoSuchProjectUserRoleException if a w l project user role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProjectUserRole[] findByPU_PrevAndNext(
		long projectUserRoleId, long projectUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchProjectUserRoleException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the w l project user roles where roleId = &#63;.
	*
	* @param roleId the role ID
	* @return the matching w l project user roles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLProjectUserRole> findByR(
		long roleId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the w l project user roles where roleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param roleId the role ID
	* @param start the lower bound of the range of w l project user roles
	* @param end the upper bound of the range of w l project user roles (not inclusive)
	* @return the range of matching w l project user roles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLProjectUserRole> findByR(
		long roleId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the w l project user roles where roleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param roleId the role ID
	* @param start the lower bound of the range of w l project user roles
	* @param end the upper bound of the range of w l project user roles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching w l project user roles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLProjectUserRole> findByR(
		long roleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first w l project user role in the ordered set where roleId = &#63;.
	*
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching w l project user role
	* @throws com.jenginetest.builder.NoSuchProjectUserRoleException if a matching w l project user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProjectUserRole findByR_First(
		long roleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchProjectUserRoleException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first w l project user role in the ordered set where roleId = &#63;.
	*
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching w l project user role, or <code>null</code> if a matching w l project user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProjectUserRole fetchByR_First(
		long roleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last w l project user role in the ordered set where roleId = &#63;.
	*
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching w l project user role
	* @throws com.jenginetest.builder.NoSuchProjectUserRoleException if a matching w l project user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProjectUserRole findByR_Last(
		long roleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchProjectUserRoleException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last w l project user role in the ordered set where roleId = &#63;.
	*
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching w l project user role, or <code>null</code> if a matching w l project user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProjectUserRole fetchByR_Last(
		long roleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the w l project user roles before and after the current w l project user role in the ordered set where roleId = &#63;.
	*
	* @param projectUserRoleId the primary key of the current w l project user role
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next w l project user role
	* @throws com.jenginetest.builder.NoSuchProjectUserRoleException if a w l project user role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProjectUserRole[] findByR_PrevAndNext(
		long projectUserRoleId, long roleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchProjectUserRoleException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the w l project user roles where groupId = &#63; and companyId = &#63; and roleId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param roleId the role ID
	* @return the matching w l project user roles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLProjectUserRole> findByG_C_Role(
		long groupId, long companyId, long roleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the w l project user roles where groupId = &#63; and companyId = &#63; and roleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param roleId the role ID
	* @param start the lower bound of the range of w l project user roles
	* @param end the upper bound of the range of w l project user roles (not inclusive)
	* @return the range of matching w l project user roles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLProjectUserRole> findByG_C_Role(
		long groupId, long companyId, long roleId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the w l project user roles where groupId = &#63; and companyId = &#63; and roleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param roleId the role ID
	* @param start the lower bound of the range of w l project user roles
	* @param end the upper bound of the range of w l project user roles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching w l project user roles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLProjectUserRole> findByG_C_Role(
		long groupId, long companyId, long roleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first w l project user role in the ordered set where groupId = &#63; and companyId = &#63; and roleId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching w l project user role
	* @throws com.jenginetest.builder.NoSuchProjectUserRoleException if a matching w l project user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProjectUserRole findByG_C_Role_First(
		long groupId, long companyId, long roleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchProjectUserRoleException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first w l project user role in the ordered set where groupId = &#63; and companyId = &#63; and roleId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching w l project user role, or <code>null</code> if a matching w l project user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProjectUserRole fetchByG_C_Role_First(
		long groupId, long companyId, long roleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last w l project user role in the ordered set where groupId = &#63; and companyId = &#63; and roleId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching w l project user role
	* @throws com.jenginetest.builder.NoSuchProjectUserRoleException if a matching w l project user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProjectUserRole findByG_C_Role_Last(
		long groupId, long companyId, long roleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchProjectUserRoleException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last w l project user role in the ordered set where groupId = &#63; and companyId = &#63; and roleId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching w l project user role, or <code>null</code> if a matching w l project user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProjectUserRole fetchByG_C_Role_Last(
		long groupId, long companyId, long roleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the w l project user roles before and after the current w l project user role in the ordered set where groupId = &#63; and companyId = &#63; and roleId = &#63;.
	*
	* @param projectUserRoleId the primary key of the current w l project user role
	* @param groupId the group ID
	* @param companyId the company ID
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next w l project user role
	* @throws com.jenginetest.builder.NoSuchProjectUserRoleException if a w l project user role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProjectUserRole[] findByG_C_Role_PrevAndNext(
		long projectUserRoleId, long groupId, long companyId, long roleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchProjectUserRoleException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the w l project user role where projectUserId = &#63; and roleId = &#63; or throws a {@link com.jenginetest.builder.NoSuchProjectUserRoleException} if it could not be found.
	*
	* @param projectUserId the project user ID
	* @param roleId the role ID
	* @return the matching w l project user role
	* @throws com.jenginetest.builder.NoSuchProjectUserRoleException if a matching w l project user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProjectUserRole findByProjectUserAndRole(
		long projectUserId, long roleId)
		throws com.jenginetest.builder.NoSuchProjectUserRoleException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the w l project user role where projectUserId = &#63; and roleId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param projectUserId the project user ID
	* @param roleId the role ID
	* @return the matching w l project user role, or <code>null</code> if a matching w l project user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProjectUserRole fetchByProjectUserAndRole(
		long projectUserId, long roleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the w l project user role where projectUserId = &#63; and roleId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param projectUserId the project user ID
	* @param roleId the role ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching w l project user role, or <code>null</code> if a matching w l project user role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProjectUserRole fetchByProjectUserAndRole(
		long projectUserId, long roleId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the w l project user roles.
	*
	* @return the w l project user roles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLProjectUserRole> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the w l project user roles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of w l project user roles
	* @param end the upper bound of the range of w l project user roles (not inclusive)
	* @return the range of w l project user roles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLProjectUserRole> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the w l project user roles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of w l project user roles
	* @param end the upper bound of the range of w l project user roles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of w l project user roles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLProjectUserRole> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the w l project user roles where projectUserId = &#63; from the database.
	*
	* @param projectUserId the project user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPU(long projectUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the w l project user roles where roleId = &#63; from the database.
	*
	* @param roleId the role ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByR(long roleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the w l project user roles where groupId = &#63; and companyId = &#63; and roleId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param roleId the role ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_C_Role(long groupId, long companyId, long roleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the w l project user role where projectUserId = &#63; and roleId = &#63; from the database.
	*
	* @param projectUserId the project user ID
	* @param roleId the role ID
	* @return the w l project user role that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProjectUserRole removeByProjectUserAndRole(
		long projectUserId, long roleId)
		throws com.jenginetest.builder.NoSuchProjectUserRoleException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the w l project user roles from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of w l project user roles where projectUserId = &#63;.
	*
	* @param projectUserId the project user ID
	* @return the number of matching w l project user roles
	* @throws SystemException if a system exception occurred
	*/
	public int countByPU(long projectUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of w l project user roles where roleId = &#63;.
	*
	* @param roleId the role ID
	* @return the number of matching w l project user roles
	* @throws SystemException if a system exception occurred
	*/
	public int countByR(long roleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of w l project user roles where groupId = &#63; and companyId = &#63; and roleId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param roleId the role ID
	* @return the number of matching w l project user roles
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_C_Role(long groupId, long companyId, long roleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of w l project user roles where projectUserId = &#63; and roleId = &#63;.
	*
	* @param projectUserId the project user ID
	* @param roleId the role ID
	* @return the number of matching w l project user roles
	* @throws SystemException if a system exception occurred
	*/
	public int countByProjectUserAndRole(long projectUserId, long roleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of w l project user roles.
	*
	* @return the number of w l project user roles
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}