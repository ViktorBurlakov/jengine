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
 * This class is a wrapper for {@link WLProjectLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       WLProjectLocalService
 * @generated
 */
public class WLProjectLocalServiceWrapper implements WLProjectLocalService,
	ServiceWrapper<WLProjectLocalService> {
	public WLProjectLocalServiceWrapper(
		WLProjectLocalService wlProjectLocalService) {
		_wlProjectLocalService = wlProjectLocalService;
	}

	/**
	* Adds the w l project to the database. Also notifies the appropriate model listeners.
	*
	* @param wlProject the w l project
	* @return the w l project that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProject addWLProject(
		com.jenginetest.builder.model.WLProject wlProject)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wlProjectLocalService.addWLProject(wlProject);
	}

	/**
	* Creates a new w l project with the primary key. Does not add the w l project to the database.
	*
	* @param projectId the primary key for the new w l project
	* @return the new w l project
	*/
	public com.jenginetest.builder.model.WLProject createWLProject(
		long projectId) {
		return _wlProjectLocalService.createWLProject(projectId);
	}

	/**
	* Deletes the w l project with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param projectId the primary key of the w l project
	* @return the w l project that was removed
	* @throws PortalException if a w l project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProject deleteWLProject(
		long projectId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _wlProjectLocalService.deleteWLProject(projectId);
	}

	/**
	* Deletes the w l project from the database. Also notifies the appropriate model listeners.
	*
	* @param wlProject the w l project
	* @return the w l project that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProject deleteWLProject(
		com.jenginetest.builder.model.WLProject wlProject)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wlProjectLocalService.deleteWLProject(wlProject);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _wlProjectLocalService.dynamicQuery();
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
		return _wlProjectLocalService.dynamicQuery(dynamicQuery);
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
		return _wlProjectLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _wlProjectLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _wlProjectLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.jenginetest.builder.model.WLProject fetchWLProject(
		long projectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wlProjectLocalService.fetchWLProject(projectId);
	}

	/**
	* Returns the w l project with the primary key.
	*
	* @param projectId the primary key of the w l project
	* @return the w l project
	* @throws PortalException if a w l project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProject getWLProject(long projectId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _wlProjectLocalService.getWLProject(projectId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _wlProjectLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.jenginetest.builder.model.WLProject> getWLProjects(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wlProjectLocalService.getWLProjects(start, end);
	}

	/**
	* Returns the number of w l projects.
	*
	* @return the number of w l projects
	* @throws SystemException if a system exception occurred
	*/
	public int getWLProjectsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wlProjectLocalService.getWLProjectsCount();
	}

	/**
	* Updates the w l project in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param wlProject the w l project
	* @return the w l project that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProject updateWLProject(
		com.jenginetest.builder.model.WLProject wlProject)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wlProjectLocalService.updateWLProject(wlProject);
	}

	/**
	* Updates the w l project in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param wlProject the w l project
	* @param merge whether to merge the w l project with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the w l project that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLProject updateWLProject(
		com.jenginetest.builder.model.WLProject wlProject, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wlProjectLocalService.updateWLProject(wlProject, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _wlProjectLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_wlProjectLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _wlProjectLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	* test of removing all and add new model
	*/
	public void clearData()
		throws com.liferay.portal.kernel.exception.SystemException {
		_wlProjectLocalService.clearData();
	}

	public void loadData()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_wlProjectLocalService.loadData();
	}

	/**
	* Clearing data test
	*/
	public void test1()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_wlProjectLocalService.test1();
	}

	/**
	* Object creation test
	*/
	public void test2()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_wlProjectLocalService.test2();
	}

	/**
	* Object selection test
	*/
	public void test3()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_wlProjectLocalService.test3();
	}

	/**
	* Object sub query test
	*/
	public void test4()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_wlProjectLocalService.test4();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public WLProjectLocalService getWrappedWLProjectLocalService() {
		return _wlProjectLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedWLProjectLocalService(
		WLProjectLocalService wlProjectLocalService) {
		_wlProjectLocalService = wlProjectLocalService;
	}

	public WLProjectLocalService getWrappedService() {
		return _wlProjectLocalService;
	}

	public void setWrappedService(WLProjectLocalService wlProjectLocalService) {
		_wlProjectLocalService = wlProjectLocalService;
	}

	private WLProjectLocalService _wlProjectLocalService;
}