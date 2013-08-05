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
 * This class is a wrapper for {@link WLTaskLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       WLTaskLocalService
 * @generated
 */
public class WLTaskLocalServiceWrapper implements WLTaskLocalService,
	ServiceWrapper<WLTaskLocalService> {
	public WLTaskLocalServiceWrapper(WLTaskLocalService wlTaskLocalService) {
		_wlTaskLocalService = wlTaskLocalService;
	}

	/**
	* Adds the w l task to the database. Also notifies the appropriate model listeners.
	*
	* @param wlTask the w l task
	* @return the w l task that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLTask addWLTask(
		com.jenginetest.builder.model.WLTask wlTask)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wlTaskLocalService.addWLTask(wlTask);
	}

	/**
	* Creates a new w l task with the primary key. Does not add the w l task to the database.
	*
	* @param taskId the primary key for the new w l task
	* @return the new w l task
	*/
	public com.jenginetest.builder.model.WLTask createWLTask(long taskId) {
		return _wlTaskLocalService.createWLTask(taskId);
	}

	/**
	* Deletes the w l task with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param taskId the primary key of the w l task
	* @return the w l task that was removed
	* @throws PortalException if a w l task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLTask deleteWLTask(long taskId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _wlTaskLocalService.deleteWLTask(taskId);
	}

	/**
	* Deletes the w l task from the database. Also notifies the appropriate model listeners.
	*
	* @param wlTask the w l task
	* @return the w l task that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLTask deleteWLTask(
		com.jenginetest.builder.model.WLTask wlTask)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wlTaskLocalService.deleteWLTask(wlTask);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _wlTaskLocalService.dynamicQuery();
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
		return _wlTaskLocalService.dynamicQuery(dynamicQuery);
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
		return _wlTaskLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _wlTaskLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _wlTaskLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.jenginetest.builder.model.WLTask fetchWLTask(long taskId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wlTaskLocalService.fetchWLTask(taskId);
	}

	/**
	* Returns the w l task with the primary key.
	*
	* @param taskId the primary key of the w l task
	* @return the w l task
	* @throws PortalException if a w l task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLTask getWLTask(long taskId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _wlTaskLocalService.getWLTask(taskId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _wlTaskLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the w l tasks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of w l tasks
	* @param end the upper bound of the range of w l tasks (not inclusive)
	* @return the range of w l tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLTask> getWLTasks(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wlTaskLocalService.getWLTasks(start, end);
	}

	/**
	* Returns the number of w l tasks.
	*
	* @return the number of w l tasks
	* @throws SystemException if a system exception occurred
	*/
	public int getWLTasksCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wlTaskLocalService.getWLTasksCount();
	}

	/**
	* Updates the w l task in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param wlTask the w l task
	* @return the w l task that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLTask updateWLTask(
		com.jenginetest.builder.model.WLTask wlTask)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wlTaskLocalService.updateWLTask(wlTask);
	}

	/**
	* Updates the w l task in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param wlTask the w l task
	* @param merge whether to merge the w l task with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the w l task that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLTask updateWLTask(
		com.jenginetest.builder.model.WLTask wlTask, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wlTaskLocalService.updateWLTask(wlTask, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _wlTaskLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_wlTaskLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _wlTaskLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public WLTaskLocalService getWrappedWLTaskLocalService() {
		return _wlTaskLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedWLTaskLocalService(
		WLTaskLocalService wlTaskLocalService) {
		_wlTaskLocalService = wlTaskLocalService;
	}

	public WLTaskLocalService getWrappedService() {
		return _wlTaskLocalService;
	}

	public void setWrappedService(WLTaskLocalService wlTaskLocalService) {
		_wlTaskLocalService = wlTaskLocalService;
	}

	private WLTaskLocalService _wlTaskLocalService;
}