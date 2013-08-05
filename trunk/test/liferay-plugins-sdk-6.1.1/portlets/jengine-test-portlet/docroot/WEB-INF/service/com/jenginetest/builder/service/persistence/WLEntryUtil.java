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

import com.jenginetest.builder.model.WLEntry;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the w l entry service. This utility wraps {@link WLEntryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WLEntryPersistence
 * @see WLEntryPersistenceImpl
 * @generated
 */
public class WLEntryUtil {
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
	public static void clearCache(WLEntry wlEntry) {
		getPersistence().clearCache(wlEntry);
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
	public static List<WLEntry> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WLEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WLEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static WLEntry update(WLEntry wlEntry, boolean merge)
		throws SystemException {
		return getPersistence().update(wlEntry, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static WLEntry update(WLEntry wlEntry, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(wlEntry, merge, serviceContext);
	}

	/**
	* Caches the w l entry in the entity cache if it is enabled.
	*
	* @param wlEntry the w l entry
	*/
	public static void cacheResult(
		com.jenginetest.builder.model.WLEntry wlEntry) {
		getPersistence().cacheResult(wlEntry);
	}

	/**
	* Caches the w l entries in the entity cache if it is enabled.
	*
	* @param wlEntries the w l entries
	*/
	public static void cacheResult(
		java.util.List<com.jenginetest.builder.model.WLEntry> wlEntries) {
		getPersistence().cacheResult(wlEntries);
	}

	/**
	* Creates a new w l entry with the primary key. Does not add the w l entry to the database.
	*
	* @param entryId the primary key for the new w l entry
	* @return the new w l entry
	*/
	public static com.jenginetest.builder.model.WLEntry create(long entryId) {
		return getPersistence().create(entryId);
	}

	/**
	* Removes the w l entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entryId the primary key of the w l entry
	* @return the w l entry that was removed
	* @throws com.jenginetest.builder.NoSuchEntryException if a w l entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLEntry remove(long entryId)
		throws com.jenginetest.builder.NoSuchEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(entryId);
	}

	public static com.jenginetest.builder.model.WLEntry updateImpl(
		com.jenginetest.builder.model.WLEntry wlEntry, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(wlEntry, merge);
	}

	/**
	* Returns the w l entry with the primary key or throws a {@link com.jenginetest.builder.NoSuchEntryException} if it could not be found.
	*
	* @param entryId the primary key of the w l entry
	* @return the w l entry
	* @throws com.jenginetest.builder.NoSuchEntryException if a w l entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLEntry findByPrimaryKey(
		long entryId)
		throws com.jenginetest.builder.NoSuchEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(entryId);
	}

	/**
	* Returns the w l entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param entryId the primary key of the w l entry
	* @return the w l entry, or <code>null</code> if a w l entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLEntry fetchByPrimaryKey(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(entryId);
	}

	/**
	* Returns all the w l entries where taskId = &#63;.
	*
	* @param taskId the task ID
	* @return the matching w l entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jenginetest.builder.model.WLEntry> findByTaskId(
		long taskId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTaskId(taskId);
	}

	/**
	* Returns a range of all the w l entries where taskId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param taskId the task ID
	* @param start the lower bound of the range of w l entries
	* @param end the upper bound of the range of w l entries (not inclusive)
	* @return the range of matching w l entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jenginetest.builder.model.WLEntry> findByTaskId(
		long taskId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTaskId(taskId, start, end);
	}

	/**
	* Returns an ordered range of all the w l entries where taskId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param taskId the task ID
	* @param start the lower bound of the range of w l entries
	* @param end the upper bound of the range of w l entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching w l entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jenginetest.builder.model.WLEntry> findByTaskId(
		long taskId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTaskId(taskId, start, end, orderByComparator);
	}

	/**
	* Returns the first w l entry in the ordered set where taskId = &#63;.
	*
	* @param taskId the task ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching w l entry
	* @throws com.jenginetest.builder.NoSuchEntryException if a matching w l entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLEntry findByTaskId_First(
		long taskId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTaskId_First(taskId, orderByComparator);
	}

	/**
	* Returns the first w l entry in the ordered set where taskId = &#63;.
	*
	* @param taskId the task ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching w l entry, or <code>null</code> if a matching w l entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLEntry fetchByTaskId_First(
		long taskId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTaskId_First(taskId, orderByComparator);
	}

	/**
	* Returns the last w l entry in the ordered set where taskId = &#63;.
	*
	* @param taskId the task ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching w l entry
	* @throws com.jenginetest.builder.NoSuchEntryException if a matching w l entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLEntry findByTaskId_Last(
		long taskId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTaskId_Last(taskId, orderByComparator);
	}

	/**
	* Returns the last w l entry in the ordered set where taskId = &#63;.
	*
	* @param taskId the task ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching w l entry, or <code>null</code> if a matching w l entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLEntry fetchByTaskId_Last(
		long taskId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTaskId_Last(taskId, orderByComparator);
	}

	/**
	* Returns the w l entries before and after the current w l entry in the ordered set where taskId = &#63;.
	*
	* @param entryId the primary key of the current w l entry
	* @param taskId the task ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next w l entry
	* @throws com.jenginetest.builder.NoSuchEntryException if a w l entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLEntry[] findByTaskId_PrevAndNext(
		long entryId, long taskId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTaskId_PrevAndNext(entryId, taskId, orderByComparator);
	}

	/**
	* Returns all the w l entries where taskId = &#63; and entryDate = &#63;.
	*
	* @param taskId the task ID
	* @param entryDate the entry date
	* @return the matching w l entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jenginetest.builder.model.WLEntry> findByT_ED(
		long taskId, java.util.Date entryDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByT_ED(taskId, entryDate);
	}

	/**
	* Returns a range of all the w l entries where taskId = &#63; and entryDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param taskId the task ID
	* @param entryDate the entry date
	* @param start the lower bound of the range of w l entries
	* @param end the upper bound of the range of w l entries (not inclusive)
	* @return the range of matching w l entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jenginetest.builder.model.WLEntry> findByT_ED(
		long taskId, java.util.Date entryDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByT_ED(taskId, entryDate, start, end);
	}

	/**
	* Returns an ordered range of all the w l entries where taskId = &#63; and entryDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param taskId the task ID
	* @param entryDate the entry date
	* @param start the lower bound of the range of w l entries
	* @param end the upper bound of the range of w l entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching w l entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jenginetest.builder.model.WLEntry> findByT_ED(
		long taskId, java.util.Date entryDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByT_ED(taskId, entryDate, start, end, orderByComparator);
	}

	/**
	* Returns the first w l entry in the ordered set where taskId = &#63; and entryDate = &#63;.
	*
	* @param taskId the task ID
	* @param entryDate the entry date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching w l entry
	* @throws com.jenginetest.builder.NoSuchEntryException if a matching w l entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLEntry findByT_ED_First(
		long taskId, java.util.Date entryDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByT_ED_First(taskId, entryDate, orderByComparator);
	}

	/**
	* Returns the first w l entry in the ordered set where taskId = &#63; and entryDate = &#63;.
	*
	* @param taskId the task ID
	* @param entryDate the entry date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching w l entry, or <code>null</code> if a matching w l entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLEntry fetchByT_ED_First(
		long taskId, java.util.Date entryDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByT_ED_First(taskId, entryDate, orderByComparator);
	}

	/**
	* Returns the last w l entry in the ordered set where taskId = &#63; and entryDate = &#63;.
	*
	* @param taskId the task ID
	* @param entryDate the entry date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching w l entry
	* @throws com.jenginetest.builder.NoSuchEntryException if a matching w l entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLEntry findByT_ED_Last(
		long taskId, java.util.Date entryDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByT_ED_Last(taskId, entryDate, orderByComparator);
	}

	/**
	* Returns the last w l entry in the ordered set where taskId = &#63; and entryDate = &#63;.
	*
	* @param taskId the task ID
	* @param entryDate the entry date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching w l entry, or <code>null</code> if a matching w l entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLEntry fetchByT_ED_Last(
		long taskId, java.util.Date entryDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByT_ED_Last(taskId, entryDate, orderByComparator);
	}

	/**
	* Returns the w l entries before and after the current w l entry in the ordered set where taskId = &#63; and entryDate = &#63;.
	*
	* @param entryId the primary key of the current w l entry
	* @param taskId the task ID
	* @param entryDate the entry date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next w l entry
	* @throws com.jenginetest.builder.NoSuchEntryException if a w l entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLEntry[] findByT_ED_PrevAndNext(
		long entryId, long taskId, java.util.Date entryDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByT_ED_PrevAndNext(entryId, taskId, entryDate,
			orderByComparator);
	}

	/**
	* Returns all the w l entries where entryDate &lt; &#63;.
	*
	* @param entryDate the entry date
	* @return the matching w l entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jenginetest.builder.model.WLEntry> findByLessDate(
		java.util.Date entryDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLessDate(entryDate);
	}

	/**
	* Returns a range of all the w l entries where entryDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param entryDate the entry date
	* @param start the lower bound of the range of w l entries
	* @param end the upper bound of the range of w l entries (not inclusive)
	* @return the range of matching w l entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jenginetest.builder.model.WLEntry> findByLessDate(
		java.util.Date entryDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLessDate(entryDate, start, end);
	}

	/**
	* Returns an ordered range of all the w l entries where entryDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param entryDate the entry date
	* @param start the lower bound of the range of w l entries
	* @param end the upper bound of the range of w l entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching w l entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jenginetest.builder.model.WLEntry> findByLessDate(
		java.util.Date entryDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLessDate(entryDate, start, end, orderByComparator);
	}

	/**
	* Returns the first w l entry in the ordered set where entryDate &lt; &#63;.
	*
	* @param entryDate the entry date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching w l entry
	* @throws com.jenginetest.builder.NoSuchEntryException if a matching w l entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLEntry findByLessDate_First(
		java.util.Date entryDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLessDate_First(entryDate, orderByComparator);
	}

	/**
	* Returns the first w l entry in the ordered set where entryDate &lt; &#63;.
	*
	* @param entryDate the entry date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching w l entry, or <code>null</code> if a matching w l entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLEntry fetchByLessDate_First(
		java.util.Date entryDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLessDate_First(entryDate, orderByComparator);
	}

	/**
	* Returns the last w l entry in the ordered set where entryDate &lt; &#63;.
	*
	* @param entryDate the entry date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching w l entry
	* @throws com.jenginetest.builder.NoSuchEntryException if a matching w l entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLEntry findByLessDate_Last(
		java.util.Date entryDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLessDate_Last(entryDate, orderByComparator);
	}

	/**
	* Returns the last w l entry in the ordered set where entryDate &lt; &#63;.
	*
	* @param entryDate the entry date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching w l entry, or <code>null</code> if a matching w l entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLEntry fetchByLessDate_Last(
		java.util.Date entryDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLessDate_Last(entryDate, orderByComparator);
	}

	/**
	* Returns the w l entries before and after the current w l entry in the ordered set where entryDate &lt; &#63;.
	*
	* @param entryId the primary key of the current w l entry
	* @param entryDate the entry date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next w l entry
	* @throws com.jenginetest.builder.NoSuchEntryException if a w l entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLEntry[] findByLessDate_PrevAndNext(
		long entryId, java.util.Date entryDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLessDate_PrevAndNext(entryId, entryDate,
			orderByComparator);
	}

	/**
	* Returns all the w l entries.
	*
	* @return the w l entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jenginetest.builder.model.WLEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the w l entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of w l entries
	* @param end the upper bound of the range of w l entries (not inclusive)
	* @return the range of w l entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jenginetest.builder.model.WLEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the w l entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of w l entries
	* @param end the upper bound of the range of w l entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of w l entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jenginetest.builder.model.WLEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the w l entries where taskId = &#63; from the database.
	*
	* @param taskId the task ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTaskId(long taskId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTaskId(taskId);
	}

	/**
	* Removes all the w l entries where taskId = &#63; and entryDate = &#63; from the database.
	*
	* @param taskId the task ID
	* @param entryDate the entry date
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByT_ED(long taskId, java.util.Date entryDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByT_ED(taskId, entryDate);
	}

	/**
	* Removes all the w l entries where entryDate &lt; &#63; from the database.
	*
	* @param entryDate the entry date
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLessDate(java.util.Date entryDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByLessDate(entryDate);
	}

	/**
	* Removes all the w l entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of w l entries where taskId = &#63;.
	*
	* @param taskId the task ID
	* @return the number of matching w l entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTaskId(long taskId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTaskId(taskId);
	}

	/**
	* Returns the number of w l entries where taskId = &#63; and entryDate = &#63;.
	*
	* @param taskId the task ID
	* @param entryDate the entry date
	* @return the number of matching w l entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByT_ED(long taskId, java.util.Date entryDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByT_ED(taskId, entryDate);
	}

	/**
	* Returns the number of w l entries where entryDate &lt; &#63;.
	*
	* @param entryDate the entry date
	* @return the number of matching w l entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLessDate(java.util.Date entryDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLessDate(entryDate);
	}

	/**
	* Returns the number of w l entries.
	*
	* @return the number of w l entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static WLEntryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (WLEntryPersistence)PortletBeanLocatorUtil.locate(com.jenginetest.builder.service.ClpSerializer.getServletContextName(),
					WLEntryPersistence.class.getName());

			ReferenceRegistry.registerReference(WLEntryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(WLEntryPersistence persistence) {
	}

	private static WLEntryPersistence _persistence;
}