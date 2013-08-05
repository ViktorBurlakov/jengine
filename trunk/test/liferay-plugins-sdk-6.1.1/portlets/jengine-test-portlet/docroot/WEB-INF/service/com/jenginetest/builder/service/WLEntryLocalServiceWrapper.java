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

package com.jenginetest.builder.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link WLEntryLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       WLEntryLocalService
 * @generated
 */
public class WLEntryLocalServiceWrapper implements WLEntryLocalService,
	ServiceWrapper<WLEntryLocalService> {
	public WLEntryLocalServiceWrapper(WLEntryLocalService wlEntryLocalService) {
		_wlEntryLocalService = wlEntryLocalService;
	}

	/**
	* Adds the w l entry to the database. Also notifies the appropriate model listeners.
	*
	* @param wlEntry the w l entry
	* @return the w l entry that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLEntry addWLEntry(
		com.jenginetest.builder.model.WLEntry wlEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wlEntryLocalService.addWLEntry(wlEntry);
	}

	/**
	* Creates a new w l entry with the primary key. Does not add the w l entry to the database.
	*
	* @param entryId the primary key for the new w l entry
	* @return the new w l entry
	*/
	public com.jenginetest.builder.model.WLEntry createWLEntry(long entryId) {
		return _wlEntryLocalService.createWLEntry(entryId);
	}

	/**
	* Deletes the w l entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entryId the primary key of the w l entry
	* @return the w l entry that was removed
	* @throws PortalException if a w l entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLEntry deleteWLEntry(long entryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _wlEntryLocalService.deleteWLEntry(entryId);
	}

	/**
	* Deletes the w l entry from the database. Also notifies the appropriate model listeners.
	*
	* @param wlEntry the w l entry
	* @return the w l entry that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLEntry deleteWLEntry(
		com.jenginetest.builder.model.WLEntry wlEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wlEntryLocalService.deleteWLEntry(wlEntry);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _wlEntryLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wlEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _wlEntryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wlEntryLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wlEntryLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.jenginetest.builder.model.WLEntry fetchWLEntry(long entryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wlEntryLocalService.fetchWLEntry(entryId);
	}

	/**
	* Returns the w l entry with the primary key.
	*
	* @param entryId the primary key of the w l entry
	* @return the w l entry
	* @throws PortalException if a w l entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLEntry getWLEntry(long entryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _wlEntryLocalService.getWLEntry(entryId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _wlEntryLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.jenginetest.builder.model.WLEntry> getWLEntries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wlEntryLocalService.getWLEntries(start, end);
	}

	/**
	* Returns the number of w l entries.
	*
	* @return the number of w l entries
	* @throws SystemException if a system exception occurred
	*/
	public int getWLEntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wlEntryLocalService.getWLEntriesCount();
	}

	/**
	* Updates the w l entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param wlEntry the w l entry
	* @return the w l entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLEntry updateWLEntry(
		com.jenginetest.builder.model.WLEntry wlEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wlEntryLocalService.updateWLEntry(wlEntry);
	}

	/**
	* Updates the w l entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param wlEntry the w l entry
	* @param merge whether to merge the w l entry with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the w l entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLEntry updateWLEntry(
		com.jenginetest.builder.model.WLEntry wlEntry, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wlEntryLocalService.updateWLEntry(wlEntry, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _wlEntryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_wlEntryLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _wlEntryLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public WLEntryLocalService getWrappedWLEntryLocalService() {
		return _wlEntryLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedWLEntryLocalService(
		WLEntryLocalService wlEntryLocalService) {
		_wlEntryLocalService = wlEntryLocalService;
	}

	public WLEntryLocalService getWrappedService() {
		return _wlEntryLocalService;
	}

	public void setWrappedService(WLEntryLocalService wlEntryLocalService) {
		_wlEntryLocalService = wlEntryLocalService;
	}

	private WLEntryLocalService _wlEntryLocalService;
}