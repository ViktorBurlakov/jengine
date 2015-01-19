/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.jenginetest.builder.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the s book local service. This utility wraps {@link com.jenginetest.builder.service.impl.SBookLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SBookLocalService
 * @see com.jenginetest.builder.service.base.SBookLocalServiceBaseImpl
 * @see com.jenginetest.builder.service.impl.SBookLocalServiceImpl
 * @generated
 */
public class SBookLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.jenginetest.builder.service.impl.SBookLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the s book to the database. Also notifies the appropriate model listeners.
	*
	* @param sBook the s book
	* @return the s book that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.SBook addSBook(
		com.jenginetest.builder.model.SBook sBook)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSBook(sBook);
	}

	/**
	* Creates a new s book with the primary key. Does not add the s book to the database.
	*
	* @param bookId the primary key for the new s book
	* @return the new s book
	*/
	public static com.jenginetest.builder.model.SBook createSBook(long bookId) {
		return getService().createSBook(bookId);
	}

	/**
	* Deletes the s book with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bookId the primary key of the s book
	* @return the s book that was removed
	* @throws PortalException if a s book with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.SBook deleteSBook(long bookId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSBook(bookId);
	}

	/**
	* Deletes the s book from the database. Also notifies the appropriate model listeners.
	*
	* @param sBook the s book
	* @return the s book that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.SBook deleteSBook(
		com.jenginetest.builder.model.SBook sBook)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSBook(sBook);
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

	public static com.jenginetest.builder.model.SBook fetchSBook(long bookId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSBook(bookId);
	}

	/**
	* Returns the s book with the primary key.
	*
	* @param bookId the primary key of the s book
	* @return the s book
	* @throws PortalException if a s book with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.SBook getSBook(long bookId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSBook(bookId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the s books.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of s books
	* @param end the upper bound of the range of s books (not inclusive)
	* @return the range of s books
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jenginetest.builder.model.SBook> getSBooks(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSBooks(start, end);
	}

	/**
	* Returns the number of s books.
	*
	* @return the number of s books
	* @throws SystemException if a system exception occurred
	*/
	public static int getSBooksCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSBooksCount();
	}

	/**
	* Updates the s book in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param sBook the s book
	* @return the s book that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.SBook updateSBook(
		com.jenginetest.builder.model.SBook sBook)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSBook(sBook);
	}

	/**
	* Updates the s book in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param sBook the s book
	* @param merge whether to merge the s book with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the s book that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.SBook updateSBook(
		com.jenginetest.builder.model.SBook sBook, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSBook(sBook, merge);
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

	public static SBookLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SBookLocalService.class.getName());

			if (invokableLocalService instanceof SBookLocalService) {
				_service = (SBookLocalService)invokableLocalService;
			}
			else {
				_service = new SBookLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SBookLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(SBookLocalService service) {
	}

	private static SBookLocalService _service;
}