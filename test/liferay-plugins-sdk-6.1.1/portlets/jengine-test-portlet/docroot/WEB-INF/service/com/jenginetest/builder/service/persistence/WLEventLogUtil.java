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

import com.jenginetest.builder.model.WLEventLog;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the w l event log service. This utility wraps {@link WLEventLogPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WLEventLogPersistence
 * @see WLEventLogPersistenceImpl
 * @generated
 */
public class WLEventLogUtil {
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
	public static void clearCache(WLEventLog wlEventLog) {
		getPersistence().clearCache(wlEventLog);
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
	public static List<WLEventLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WLEventLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WLEventLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static WLEventLog update(WLEventLog wlEventLog, boolean merge)
		throws SystemException {
		return getPersistence().update(wlEventLog, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static WLEventLog update(WLEventLog wlEventLog, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(wlEventLog, merge, serviceContext);
	}

	/**
	* Caches the w l event log in the entity cache if it is enabled.
	*
	* @param wlEventLog the w l event log
	*/
	public static void cacheResult(
		com.jenginetest.builder.model.WLEventLog wlEventLog) {
		getPersistence().cacheResult(wlEventLog);
	}

	/**
	* Caches the w l event logs in the entity cache if it is enabled.
	*
	* @param wlEventLogs the w l event logs
	*/
	public static void cacheResult(
		java.util.List<com.jenginetest.builder.model.WLEventLog> wlEventLogs) {
		getPersistence().cacheResult(wlEventLogs);
	}

	/**
	* Creates a new w l event log with the primary key. Does not add the w l event log to the database.
	*
	* @param eventLogId the primary key for the new w l event log
	* @return the new w l event log
	*/
	public static com.jenginetest.builder.model.WLEventLog create(
		long eventLogId) {
		return getPersistence().create(eventLogId);
	}

	/**
	* Removes the w l event log with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eventLogId the primary key of the w l event log
	* @return the w l event log that was removed
	* @throws com.jenginetest.builder.NoSuchEventLogException if a w l event log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLEventLog remove(
		long eventLogId)
		throws com.jenginetest.builder.NoSuchEventLogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(eventLogId);
	}

	public static com.jenginetest.builder.model.WLEventLog updateImpl(
		com.jenginetest.builder.model.WLEventLog wlEventLog, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(wlEventLog, merge);
	}

	/**
	* Returns the w l event log with the primary key or throws a {@link com.jenginetest.builder.NoSuchEventLogException} if it could not be found.
	*
	* @param eventLogId the primary key of the w l event log
	* @return the w l event log
	* @throws com.jenginetest.builder.NoSuchEventLogException if a w l event log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLEventLog findByPrimaryKey(
		long eventLogId)
		throws com.jenginetest.builder.NoSuchEventLogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(eventLogId);
	}

	/**
	* Returns the w l event log with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param eventLogId the primary key of the w l event log
	* @return the w l event log, or <code>null</code> if a w l event log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLEventLog fetchByPrimaryKey(
		long eventLogId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(eventLogId);
	}

	/**
	* Returns all the w l event logs.
	*
	* @return the w l event logs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jenginetest.builder.model.WLEventLog> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the w l event logs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of w l event logs
	* @param end the upper bound of the range of w l event logs (not inclusive)
	* @return the range of w l event logs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jenginetest.builder.model.WLEventLog> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the w l event logs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of w l event logs
	* @param end the upper bound of the range of w l event logs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of w l event logs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jenginetest.builder.model.WLEventLog> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the w l event logs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of w l event logs.
	*
	* @return the number of w l event logs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static WLEventLogPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (WLEventLogPersistence)PortletBeanLocatorUtil.locate(com.jenginetest.builder.service.ClpSerializer.getServletContextName(),
					WLEventLogPersistence.class.getName());

			ReferenceRegistry.registerReference(WLEventLogUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(WLEventLogPersistence persistence) {
	}

	private static WLEventLogPersistence _persistence;
}