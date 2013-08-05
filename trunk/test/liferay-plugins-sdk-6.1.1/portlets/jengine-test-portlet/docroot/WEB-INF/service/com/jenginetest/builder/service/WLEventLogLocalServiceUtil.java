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
 * The utility for the w l event log local service. This utility wraps {@link com.jenginetest.builder.service.impl.WLEventLogLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WLEventLogLocalService
 * @see com.jenginetest.builder.service.base.WLEventLogLocalServiceBaseImpl
 * @see com.jenginetest.builder.service.impl.WLEventLogLocalServiceImpl
 * @generated
 */
public class WLEventLogLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.jenginetest.builder.service.impl.WLEventLogLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the w l event log to the database. Also notifies the appropriate model listeners.
	*
	* @param wlEventLog the w l event log
	* @return the w l event log that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLEventLog addWLEventLog(
		com.jenginetest.builder.model.WLEventLog wlEventLog)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addWLEventLog(wlEventLog);
	}

	/**
	* Creates a new w l event log with the primary key. Does not add the w l event log to the database.
	*
	* @param eventLogId the primary key for the new w l event log
	* @return the new w l event log
	*/
	public static com.jenginetest.builder.model.WLEventLog createWLEventLog(
		long eventLogId) {
		return getService().createWLEventLog(eventLogId);
	}

	/**
	* Deletes the w l event log with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eventLogId the primary key of the w l event log
	* @return the w l event log that was removed
	* @throws PortalException if a w l event log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLEventLog deleteWLEventLog(
		long eventLogId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteWLEventLog(eventLogId);
	}

	/**
	* Deletes the w l event log from the database. Also notifies the appropriate model listeners.
	*
	* @param wlEventLog the w l event log
	* @return the w l event log that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLEventLog deleteWLEventLog(
		com.jenginetest.builder.model.WLEventLog wlEventLog)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteWLEventLog(wlEventLog);
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

	public static com.jenginetest.builder.model.WLEventLog fetchWLEventLog(
		long eventLogId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchWLEventLog(eventLogId);
	}

	/**
	* Returns the w l event log with the primary key.
	*
	* @param eventLogId the primary key of the w l event log
	* @return the w l event log
	* @throws PortalException if a w l event log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLEventLog getWLEventLog(
		long eventLogId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getWLEventLog(eventLogId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.jenginetest.builder.model.WLEventLog> getWLEventLogs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getWLEventLogs(start, end);
	}

	/**
	* Returns the number of w l event logs.
	*
	* @return the number of w l event logs
	* @throws SystemException if a system exception occurred
	*/
	public static int getWLEventLogsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getWLEventLogsCount();
	}

	/**
	* Updates the w l event log in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param wlEventLog the w l event log
	* @return the w l event log that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLEventLog updateWLEventLog(
		com.jenginetest.builder.model.WLEventLog wlEventLog)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateWLEventLog(wlEventLog);
	}

	/**
	* Updates the w l event log in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param wlEventLog the w l event log
	* @param merge whether to merge the w l event log with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the w l event log that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLEventLog updateWLEventLog(
		com.jenginetest.builder.model.WLEventLog wlEventLog, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateWLEventLog(wlEventLog, merge);
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

	public static WLEventLogLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					WLEventLogLocalService.class.getName());

			if (invokableLocalService instanceof WLEventLogLocalService) {
				_service = (WLEventLogLocalService)invokableLocalService;
			}
			else {
				_service = new WLEventLogLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(WLEventLogLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(WLEventLogLocalService service) {
	}

	private static WLEventLogLocalService _service;
}