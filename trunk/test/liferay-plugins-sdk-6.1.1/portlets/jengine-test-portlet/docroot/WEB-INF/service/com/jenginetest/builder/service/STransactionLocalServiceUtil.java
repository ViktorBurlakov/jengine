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
 * The utility for the s transaction local service. This utility wraps {@link com.jenginetest.builder.service.impl.STransactionLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see STransactionLocalService
 * @see com.jenginetest.builder.service.base.STransactionLocalServiceBaseImpl
 * @see com.jenginetest.builder.service.impl.STransactionLocalServiceImpl
 * @generated
 */
public class STransactionLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.jenginetest.builder.service.impl.STransactionLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the s transaction to the database. Also notifies the appropriate model listeners.
	*
	* @param sTransaction the s transaction
	* @return the s transaction that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.STransaction addSTransaction(
		com.jenginetest.builder.model.STransaction sTransaction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSTransaction(sTransaction);
	}

	/**
	* Creates a new s transaction with the primary key. Does not add the s transaction to the database.
	*
	* @param transactionId the primary key for the new s transaction
	* @return the new s transaction
	*/
	public static com.jenginetest.builder.model.STransaction createSTransaction(
		long transactionId) {
		return getService().createSTransaction(transactionId);
	}

	/**
	* Deletes the s transaction with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param transactionId the primary key of the s transaction
	* @return the s transaction that was removed
	* @throws PortalException if a s transaction with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.STransaction deleteSTransaction(
		long transactionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSTransaction(transactionId);
	}

	/**
	* Deletes the s transaction from the database. Also notifies the appropriate model listeners.
	*
	* @param sTransaction the s transaction
	* @return the s transaction that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.STransaction deleteSTransaction(
		com.jenginetest.builder.model.STransaction sTransaction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSTransaction(sTransaction);
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

	public static com.jenginetest.builder.model.STransaction fetchSTransaction(
		long transactionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSTransaction(transactionId);
	}

	/**
	* Returns the s transaction with the primary key.
	*
	* @param transactionId the primary key of the s transaction
	* @return the s transaction
	* @throws PortalException if a s transaction with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.STransaction getSTransaction(
		long transactionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSTransaction(transactionId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the s transactions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of s transactions
	* @param end the upper bound of the range of s transactions (not inclusive)
	* @return the range of s transactions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jenginetest.builder.model.STransaction> getSTransactions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSTransactions(start, end);
	}

	/**
	* Returns the number of s transactions.
	*
	* @return the number of s transactions
	* @throws SystemException if a system exception occurred
	*/
	public static int getSTransactionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSTransactionsCount();
	}

	/**
	* Updates the s transaction in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param sTransaction the s transaction
	* @return the s transaction that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.STransaction updateSTransaction(
		com.jenginetest.builder.model.STransaction sTransaction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSTransaction(sTransaction);
	}

	/**
	* Updates the s transaction in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param sTransaction the s transaction
	* @param merge whether to merge the s transaction with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the s transaction that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.STransaction updateSTransaction(
		com.jenginetest.builder.model.STransaction sTransaction, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSTransaction(sTransaction, merge);
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

	public static STransactionLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					STransactionLocalService.class.getName());

			if (invokableLocalService instanceof STransactionLocalService) {
				_service = (STransactionLocalService)invokableLocalService;
			}
			else {
				_service = new STransactionLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(STransactionLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(STransactionLocalService service) {
	}

	private static STransactionLocalService _service;
}