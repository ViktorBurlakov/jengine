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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the w l event log service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WLEventLogPersistenceImpl
 * @see WLEventLogUtil
 * @generated
 */
public interface WLEventLogPersistence extends BasePersistence<WLEventLog> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WLEventLogUtil} to access the w l event log persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the w l event log in the entity cache if it is enabled.
	*
	* @param wlEventLog the w l event log
	*/
	public void cacheResult(com.jenginetest.builder.model.WLEventLog wlEventLog);

	/**
	* Caches the w l event logs in the entity cache if it is enabled.
	*
	* @param wlEventLogs the w l event logs
	*/
	public void cacheResult(
		java.util.List<com.jenginetest.builder.model.WLEventLog> wlEventLogs);

	/**
	* Creates a new w l event log with the primary key. Does not add the w l event log to the database.
	*
	* @param eventLogId the primary key for the new w l event log
	* @return the new w l event log
	*/
	public com.jenginetest.builder.model.WLEventLog create(long eventLogId);

	/**
	* Removes the w l event log with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eventLogId the primary key of the w l event log
	* @return the w l event log that was removed
	* @throws com.jenginetest.builder.NoSuchEventLogException if a w l event log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLEventLog remove(long eventLogId)
		throws com.jenginetest.builder.NoSuchEventLogException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.jenginetest.builder.model.WLEventLog updateImpl(
		com.jenginetest.builder.model.WLEventLog wlEventLog, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the w l event log with the primary key or throws a {@link com.jenginetest.builder.NoSuchEventLogException} if it could not be found.
	*
	* @param eventLogId the primary key of the w l event log
	* @return the w l event log
	* @throws com.jenginetest.builder.NoSuchEventLogException if a w l event log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLEventLog findByPrimaryKey(
		long eventLogId)
		throws com.jenginetest.builder.NoSuchEventLogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the w l event log with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param eventLogId the primary key of the w l event log
	* @return the w l event log, or <code>null</code> if a w l event log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLEventLog fetchByPrimaryKey(
		long eventLogId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the w l event logs.
	*
	* @return the w l event logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLEventLog> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.jenginetest.builder.model.WLEventLog> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.jenginetest.builder.model.WLEventLog> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the w l event logs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of w l event logs.
	*
	* @return the number of w l event logs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}