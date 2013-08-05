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

import com.jenginetest.builder.model.WLProject;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the w l project service. This utility wraps {@link WLProjectPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WLProjectPersistence
 * @see WLProjectPersistenceImpl
 * @generated
 */
public class WLProjectUtil {
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
	public static void clearCache(WLProject wlProject) {
		getPersistence().clearCache(wlProject);
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
	public static List<WLProject> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WLProject> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WLProject> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static WLProject update(WLProject wlProject, boolean merge)
		throws SystemException {
		return getPersistence().update(wlProject, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static WLProject update(WLProject wlProject, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(wlProject, merge, serviceContext);
	}

	/**
	* Caches the w l project in the entity cache if it is enabled.
	*
	* @param wlProject the w l project
	*/
	public static void cacheResult(
		com.jenginetest.builder.model.WLProject wlProject) {
		getPersistence().cacheResult(wlProject);
	}

	/**
	* Caches the w l projects in the entity cache if it is enabled.
	*
	* @param wlProjects the w l projects
	*/
	public static void cacheResult(
		java.util.List<com.jenginetest.builder.model.WLProject> wlProjects) {
		getPersistence().cacheResult(wlProjects);
	}

	/**
	* Creates a new w l project with the primary key. Does not add the w l project to the database.
	*
	* @param projectId the primary key for the new w l project
	* @return the new w l project
	*/
	public static com.jenginetest.builder.model.WLProject create(long projectId) {
		return getPersistence().create(projectId);
	}

	/**
	* Removes the w l project with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param projectId the primary key of the w l project
	* @return the w l project that was removed
	* @throws com.jenginetest.builder.NoSuchProjectException if a w l project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLProject remove(long projectId)
		throws com.jenginetest.builder.NoSuchProjectException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(projectId);
	}

	public static com.jenginetest.builder.model.WLProject updateImpl(
		com.jenginetest.builder.model.WLProject wlProject, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(wlProject, merge);
	}

	/**
	* Returns the w l project with the primary key or throws a {@link com.jenginetest.builder.NoSuchProjectException} if it could not be found.
	*
	* @param projectId the primary key of the w l project
	* @return the w l project
	* @throws com.jenginetest.builder.NoSuchProjectException if a w l project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLProject findByPrimaryKey(
		long projectId)
		throws com.jenginetest.builder.NoSuchProjectException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(projectId);
	}

	/**
	* Returns the w l project with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param projectId the primary key of the w l project
	* @return the w l project, or <code>null</code> if a w l project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLProject fetchByPrimaryKey(
		long projectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(projectId);
	}

	/**
	* Returns all the w l projects where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching w l projects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jenginetest.builder.model.WLProject> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the w l projects where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of w l projects
	* @param end the upper bound of the range of w l projects (not inclusive)
	* @return the range of matching w l projects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jenginetest.builder.model.WLProject> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the w l projects where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of w l projects
	* @param end the upper bound of the range of w l projects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching w l projects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jenginetest.builder.model.WLProject> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first w l project in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching w l project
	* @throws com.jenginetest.builder.NoSuchProjectException if a matching w l project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLProject findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchProjectException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first w l project in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching w l project, or <code>null</code> if a matching w l project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLProject fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last w l project in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching w l project
	* @throws com.jenginetest.builder.NoSuchProjectException if a matching w l project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLProject findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchProjectException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last w l project in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching w l project, or <code>null</code> if a matching w l project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLProject fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the w l projects before and after the current w l project in the ordered set where groupId = &#63;.
	*
	* @param projectId the primary key of the current w l project
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next w l project
	* @throws com.jenginetest.builder.NoSuchProjectException if a w l project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLProject[] findByGroupId_PrevAndNext(
		long projectId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchProjectException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(projectId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the w l projects where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @return the matching w l projects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jenginetest.builder.model.WLProject> findByGroupCompany(
		long groupId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupCompany(groupId, companyId);
	}

	/**
	* Returns a range of all the w l projects where groupId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param start the lower bound of the range of w l projects
	* @param end the upper bound of the range of w l projects (not inclusive)
	* @return the range of matching w l projects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jenginetest.builder.model.WLProject> findByGroupCompany(
		long groupId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupCompany(groupId, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the w l projects where groupId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param start the lower bound of the range of w l projects
	* @param end the upper bound of the range of w l projects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching w l projects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jenginetest.builder.model.WLProject> findByGroupCompany(
		long groupId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupCompany(groupId, companyId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first w l project in the ordered set where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching w l project
	* @throws com.jenginetest.builder.NoSuchProjectException if a matching w l project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLProject findByGroupCompany_First(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchProjectException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupCompany_First(groupId, companyId,
			orderByComparator);
	}

	/**
	* Returns the first w l project in the ordered set where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching w l project, or <code>null</code> if a matching w l project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLProject fetchByGroupCompany_First(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupCompany_First(groupId, companyId,
			orderByComparator);
	}

	/**
	* Returns the last w l project in the ordered set where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching w l project
	* @throws com.jenginetest.builder.NoSuchProjectException if a matching w l project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLProject findByGroupCompany_Last(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchProjectException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupCompany_Last(groupId, companyId,
			orderByComparator);
	}

	/**
	* Returns the last w l project in the ordered set where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching w l project, or <code>null</code> if a matching w l project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLProject fetchByGroupCompany_Last(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupCompany_Last(groupId, companyId,
			orderByComparator);
	}

	/**
	* Returns the w l projects before and after the current w l project in the ordered set where groupId = &#63; and companyId = &#63;.
	*
	* @param projectId the primary key of the current w l project
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next w l project
	* @throws com.jenginetest.builder.NoSuchProjectException if a w l project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLProject[] findByGroupCompany_PrevAndNext(
		long projectId, long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchProjectException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupCompany_PrevAndNext(projectId, groupId,
			companyId, orderByComparator);
	}

	/**
	* Returns all the w l projects where groupId = &#63; and companyId = &#63; and automaticallyAssign = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param automaticallyAssign the automatically assign
	* @return the matching w l projects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jenginetest.builder.model.WLProject> findByGroupCompanyAutomaticallyAssign(
		long groupId, long companyId, boolean automaticallyAssign)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupCompanyAutomaticallyAssign(groupId, companyId,
			automaticallyAssign);
	}

	/**
	* Returns a range of all the w l projects where groupId = &#63; and companyId = &#63; and automaticallyAssign = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param automaticallyAssign the automatically assign
	* @param start the lower bound of the range of w l projects
	* @param end the upper bound of the range of w l projects (not inclusive)
	* @return the range of matching w l projects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jenginetest.builder.model.WLProject> findByGroupCompanyAutomaticallyAssign(
		long groupId, long companyId, boolean automaticallyAssign, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupCompanyAutomaticallyAssign(groupId, companyId,
			automaticallyAssign, start, end);
	}

	/**
	* Returns an ordered range of all the w l projects where groupId = &#63; and companyId = &#63; and automaticallyAssign = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param automaticallyAssign the automatically assign
	* @param start the lower bound of the range of w l projects
	* @param end the upper bound of the range of w l projects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching w l projects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jenginetest.builder.model.WLProject> findByGroupCompanyAutomaticallyAssign(
		long groupId, long companyId, boolean automaticallyAssign, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupCompanyAutomaticallyAssign(groupId, companyId,
			automaticallyAssign, start, end, orderByComparator);
	}

	/**
	* Returns the first w l project in the ordered set where groupId = &#63; and companyId = &#63; and automaticallyAssign = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param automaticallyAssign the automatically assign
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching w l project
	* @throws com.jenginetest.builder.NoSuchProjectException if a matching w l project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLProject findByGroupCompanyAutomaticallyAssign_First(
		long groupId, long companyId, boolean automaticallyAssign,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchProjectException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupCompanyAutomaticallyAssign_First(groupId,
			companyId, automaticallyAssign, orderByComparator);
	}

	/**
	* Returns the first w l project in the ordered set where groupId = &#63; and companyId = &#63; and automaticallyAssign = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param automaticallyAssign the automatically assign
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching w l project, or <code>null</code> if a matching w l project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLProject fetchByGroupCompanyAutomaticallyAssign_First(
		long groupId, long companyId, boolean automaticallyAssign,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupCompanyAutomaticallyAssign_First(groupId,
			companyId, automaticallyAssign, orderByComparator);
	}

	/**
	* Returns the last w l project in the ordered set where groupId = &#63; and companyId = &#63; and automaticallyAssign = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param automaticallyAssign the automatically assign
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching w l project
	* @throws com.jenginetest.builder.NoSuchProjectException if a matching w l project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLProject findByGroupCompanyAutomaticallyAssign_Last(
		long groupId, long companyId, boolean automaticallyAssign,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchProjectException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupCompanyAutomaticallyAssign_Last(groupId,
			companyId, automaticallyAssign, orderByComparator);
	}

	/**
	* Returns the last w l project in the ordered set where groupId = &#63; and companyId = &#63; and automaticallyAssign = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param automaticallyAssign the automatically assign
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching w l project, or <code>null</code> if a matching w l project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLProject fetchByGroupCompanyAutomaticallyAssign_Last(
		long groupId, long companyId, boolean automaticallyAssign,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupCompanyAutomaticallyAssign_Last(groupId,
			companyId, automaticallyAssign, orderByComparator);
	}

	/**
	* Returns the w l projects before and after the current w l project in the ordered set where groupId = &#63; and companyId = &#63; and automaticallyAssign = &#63;.
	*
	* @param projectId the primary key of the current w l project
	* @param groupId the group ID
	* @param companyId the company ID
	* @param automaticallyAssign the automatically assign
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next w l project
	* @throws com.jenginetest.builder.NoSuchProjectException if a w l project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLProject[] findByGroupCompanyAutomaticallyAssign_PrevAndNext(
		long projectId, long groupId, long companyId,
		boolean automaticallyAssign,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchProjectException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupCompanyAutomaticallyAssign_PrevAndNext(projectId,
			groupId, companyId, automaticallyAssign, orderByComparator);
	}

	/**
	* Returns the w l project where groupId = &#63; and companyId = &#63; and defaultProject = &#63; or throws a {@link com.jenginetest.builder.NoSuchProjectException} if it could not be found.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param defaultProject the default project
	* @return the matching w l project
	* @throws com.jenginetest.builder.NoSuchProjectException if a matching w l project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLProject findByDefaultGroupCompany(
		long groupId, long companyId, boolean defaultProject)
		throws com.jenginetest.builder.NoSuchProjectException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDefaultGroupCompany(groupId, companyId, defaultProject);
	}

	/**
	* Returns the w l project where groupId = &#63; and companyId = &#63; and defaultProject = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param defaultProject the default project
	* @return the matching w l project, or <code>null</code> if a matching w l project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLProject fetchByDefaultGroupCompany(
		long groupId, long companyId, boolean defaultProject)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDefaultGroupCompany(groupId, companyId,
			defaultProject);
	}

	/**
	* Returns the w l project where groupId = &#63; and companyId = &#63; and defaultProject = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param defaultProject the default project
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching w l project, or <code>null</code> if a matching w l project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLProject fetchByDefaultGroupCompany(
		long groupId, long companyId, boolean defaultProject,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDefaultGroupCompany(groupId, companyId,
			defaultProject, retrieveFromCache);
	}

	/**
	* Returns all the w l projects where title = &#63;.
	*
	* @param title the title
	* @return the matching w l projects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jenginetest.builder.model.WLProject> findByTitle(
		java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTitle(title);
	}

	/**
	* Returns a range of all the w l projects where title = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param title the title
	* @param start the lower bound of the range of w l projects
	* @param end the upper bound of the range of w l projects (not inclusive)
	* @return the range of matching w l projects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jenginetest.builder.model.WLProject> findByTitle(
		java.lang.String title, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTitle(title, start, end);
	}

	/**
	* Returns an ordered range of all the w l projects where title = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param title the title
	* @param start the lower bound of the range of w l projects
	* @param end the upper bound of the range of w l projects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching w l projects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jenginetest.builder.model.WLProject> findByTitle(
		java.lang.String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTitle(title, start, end, orderByComparator);
	}

	/**
	* Returns the first w l project in the ordered set where title = &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching w l project
	* @throws com.jenginetest.builder.NoSuchProjectException if a matching w l project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLProject findByTitle_First(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchProjectException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTitle_First(title, orderByComparator);
	}

	/**
	* Returns the first w l project in the ordered set where title = &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching w l project, or <code>null</code> if a matching w l project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLProject fetchByTitle_First(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTitle_First(title, orderByComparator);
	}

	/**
	* Returns the last w l project in the ordered set where title = &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching w l project
	* @throws com.jenginetest.builder.NoSuchProjectException if a matching w l project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLProject findByTitle_Last(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchProjectException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTitle_Last(title, orderByComparator);
	}

	/**
	* Returns the last w l project in the ordered set where title = &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching w l project, or <code>null</code> if a matching w l project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLProject fetchByTitle_Last(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTitle_Last(title, orderByComparator);
	}

	/**
	* Returns the w l projects before and after the current w l project in the ordered set where title = &#63;.
	*
	* @param projectId the primary key of the current w l project
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next w l project
	* @throws com.jenginetest.builder.NoSuchProjectException if a w l project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLProject[] findByTitle_PrevAndNext(
		long projectId, java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchProjectException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTitle_PrevAndNext(projectId, title, orderByComparator);
	}

	/**
	* Returns all the w l projects.
	*
	* @return the w l projects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jenginetest.builder.model.WLProject> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the w l projects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of w l projects
	* @param end the upper bound of the range of w l projects (not inclusive)
	* @return the range of w l projects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jenginetest.builder.model.WLProject> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the w l projects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of w l projects
	* @param end the upper bound of the range of w l projects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of w l projects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jenginetest.builder.model.WLProject> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the w l projects where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Removes all the w l projects where groupId = &#63; and companyId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupCompany(long groupId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupCompany(groupId, companyId);
	}

	/**
	* Removes all the w l projects where groupId = &#63; and companyId = &#63; and automaticallyAssign = &#63; from the database.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param automaticallyAssign the automatically assign
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupCompanyAutomaticallyAssign(long groupId,
		long companyId, boolean automaticallyAssign)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByGroupCompanyAutomaticallyAssign(groupId, companyId,
			automaticallyAssign);
	}

	/**
	* Removes the w l project where groupId = &#63; and companyId = &#63; and defaultProject = &#63; from the database.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param defaultProject the default project
	* @return the w l project that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLProject removeByDefaultGroupCompany(
		long groupId, long companyId, boolean defaultProject)
		throws com.jenginetest.builder.NoSuchProjectException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .removeByDefaultGroupCompany(groupId, companyId,
			defaultProject);
	}

	/**
	* Removes all the w l projects where title = &#63; from the database.
	*
	* @param title the title
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTitle(java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTitle(title);
	}

	/**
	* Removes all the w l projects from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of w l projects where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching w l projects
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns the number of w l projects where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @return the number of matching w l projects
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupCompany(long groupId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupCompany(groupId, companyId);
	}

	/**
	* Returns the number of w l projects where groupId = &#63; and companyId = &#63; and automaticallyAssign = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param automaticallyAssign the automatically assign
	* @return the number of matching w l projects
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupCompanyAutomaticallyAssign(long groupId,
		long companyId, boolean automaticallyAssign)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByGroupCompanyAutomaticallyAssign(groupId, companyId,
			automaticallyAssign);
	}

	/**
	* Returns the number of w l projects where groupId = &#63; and companyId = &#63; and defaultProject = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param defaultProject the default project
	* @return the number of matching w l projects
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDefaultGroupCompany(long groupId, long companyId,
		boolean defaultProject)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByDefaultGroupCompany(groupId, companyId,
			defaultProject);
	}

	/**
	* Returns the number of w l projects where title = &#63;.
	*
	* @param title the title
	* @return the number of matching w l projects
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTitle(java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTitle(title);
	}

	/**
	* Returns the number of w l projects.
	*
	* @return the number of w l projects
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	/**
	* Returns all the w l tasks associated with the w l project.
	*
	* @param pk the primary key of the w l project
	* @return the w l tasks associated with the w l project
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jenginetest.builder.model.WLTask> getWLTasks(
		long pk) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getWLTasks(pk);
	}

	/**
	* Returns a range of all the w l tasks associated with the w l project.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the w l project
	* @param start the lower bound of the range of w l projects
	* @param end the upper bound of the range of w l projects (not inclusive)
	* @return the range of w l tasks associated with the w l project
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jenginetest.builder.model.WLTask> getWLTasks(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getWLTasks(pk, start, end);
	}

	/**
	* Returns an ordered range of all the w l tasks associated with the w l project.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the w l project
	* @param start the lower bound of the range of w l projects
	* @param end the upper bound of the range of w l projects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of w l tasks associated with the w l project
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jenginetest.builder.model.WLTask> getWLTasks(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getWLTasks(pk, start, end, orderByComparator);
	}

	/**
	* Returns the number of w l tasks associated with the w l project.
	*
	* @param pk the primary key of the w l project
	* @return the number of w l tasks associated with the w l project
	* @throws SystemException if a system exception occurred
	*/
	public static int getWLTasksSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getWLTasksSize(pk);
	}

	/**
	* Returns <code>true</code> if the w l task is associated with the w l project.
	*
	* @param pk the primary key of the w l project
	* @param wlTaskPK the primary key of the w l task
	* @return <code>true</code> if the w l task is associated with the w l project; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsWLTask(long pk, long wlTaskPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsWLTask(pk, wlTaskPK);
	}

	/**
	* Returns <code>true</code> if the w l project has any w l tasks associated with it.
	*
	* @param pk the primary key of the w l project to check for associations with w l tasks
	* @return <code>true</code> if the w l project has any w l tasks associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsWLTasks(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsWLTasks(pk);
	}

	public static WLProjectPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (WLProjectPersistence)PortletBeanLocatorUtil.locate(com.jenginetest.builder.service.ClpSerializer.getServletContextName(),
					WLProjectPersistence.class.getName());

			ReferenceRegistry.registerReference(WLProjectUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(WLProjectPersistence persistence) {
	}

	private static WLProjectPersistence _persistence;
}