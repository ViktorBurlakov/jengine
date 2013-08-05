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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the w l project user local service. This utility wraps {@link com.jenginetest.builder.service.impl.WLProjectUserLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WLProjectUserLocalService
 * @see com.jenginetest.builder.service.base.WLProjectUserLocalServiceBaseImpl
 * @see com.jenginetest.builder.service.impl.WLProjectUserLocalServiceImpl
 * @generated
 */
public class WLProjectUserLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.jenginetest.builder.service.impl.WLProjectUserLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the w l project user to the database. Also notifies the appropriate model listeners.
	*
	* @param wlProjectUser the w l project user
	* @return the w l project user that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLProjectUser addWLProjectUser(
		com.jenginetest.builder.model.WLProjectUser wlProjectUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addWLProjectUser(wlProjectUser);
	}

	/**
	* Creates a new w l project user with the primary key. Does not add the w l project user to the database.
	*
	* @param projectUserId the primary key for the new w l project user
	* @return the new w l project user
	*/
	public static com.jenginetest.builder.model.WLProjectUser createWLProjectUser(
		long projectUserId) {
		return getService().createWLProjectUser(projectUserId);
	}

	/**
	* Deletes the w l project user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param projectUserId the primary key of the w l project user
	* @return the w l project user that was removed
	* @throws PortalException if a w l project user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLProjectUser deleteWLProjectUser(
		long projectUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteWLProjectUser(projectUserId);
	}

	/**
	* Deletes the w l project user from the database. Also notifies the appropriate model listeners.
	*
	* @param wlProjectUser the w l project user
	* @return the w l project user that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLProjectUser deleteWLProjectUser(
		com.jenginetest.builder.model.WLProjectUser wlProjectUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteWLProjectUser(wlProjectUser);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static com.jenginetest.builder.model.WLProjectUser fetchWLProjectUser(
		long projectUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchWLProjectUser(projectUserId);
	}

	/**
	* Returns the w l project user with the primary key.
	*
	* @param projectUserId the primary key of the w l project user
	* @return the w l project user
	* @throws PortalException if a w l project user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLProjectUser getWLProjectUser(
		long projectUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getWLProjectUser(projectUserId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.jenginetest.builder.model.WLProjectUser> getWLProjectUsers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getWLProjectUsers(start, end);
	}

	/**
	* Returns the number of w l project users.
	*
	* @return the number of w l project users
	* @throws SystemException if a system exception occurred
	*/
	public static int getWLProjectUsersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getWLProjectUsersCount();
	}

	/**
	* Updates the w l project user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param wlProjectUser the w l project user
	* @return the w l project user that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLProjectUser updateWLProjectUser(
		com.jenginetest.builder.model.WLProjectUser wlProjectUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateWLProjectUser(wlProjectUser);
	}

	/**
	* Updates the w l project user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param wlProjectUser the w l project user
	* @param merge whether to merge the w l project user with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the w l project user that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLProjectUser updateWLProjectUser(
		com.jenginetest.builder.model.WLProjectUser wlProjectUser, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateWLProjectUser(wlProjectUser, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static void clearService() {
		_service = null;
	}

	public static WLProjectUserLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					WLProjectUserLocalService.class.getName());

			if (invokableLocalService instanceof WLProjectUserLocalService) {
				_service = (WLProjectUserLocalService)invokableLocalService;
			}
			else {
				_service = new WLProjectUserLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(WLProjectUserLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(WLProjectUserLocalService service) {
	}

	private static WLProjectUserLocalService _service;
}