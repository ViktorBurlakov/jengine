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

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link STransactionLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       STransactionLocalService
 * @generated
 */
public class STransactionLocalServiceWrapper implements STransactionLocalService,
	ServiceWrapper<STransactionLocalService> {
	public STransactionLocalServiceWrapper(
		STransactionLocalService sTransactionLocalService) {
		_sTransactionLocalService = sTransactionLocalService;
	}

	/**
	* Adds the s transaction to the database. Also notifies the appropriate model listeners.
	*
	* @param sTransaction the s transaction
	* @return the s transaction that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.STransaction addSTransaction(
		com.jenginetest.builder.model.STransaction sTransaction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sTransactionLocalService.addSTransaction(sTransaction);
	}

	/**
	* Creates a new s transaction with the primary key. Does not add the s transaction to the database.
	*
	* @param transactionId the primary key for the new s transaction
	* @return the new s transaction
	*/
	public com.jenginetest.builder.model.STransaction createSTransaction(
		long transactionId) {
		return _sTransactionLocalService.createSTransaction(transactionId);
	}

	/**
	* Deletes the s transaction with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param transactionId the primary key of the s transaction
	* @return the s transaction that was removed
	* @throws PortalException if a s transaction with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.STransaction deleteSTransaction(
		long transactionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sTransactionLocalService.deleteSTransaction(transactionId);
	}

	/**
	* Deletes the s transaction from the database. Also notifies the appropriate model listeners.
	*
	* @param sTransaction the s transaction
	* @return the s transaction that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.STransaction deleteSTransaction(
		com.jenginetest.builder.model.STransaction sTransaction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sTransactionLocalService.deleteSTransaction(sTransaction);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _sTransactionLocalService.dynamicQuery();
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
		return _sTransactionLocalService.dynamicQuery(dynamicQuery);
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
		return _sTransactionLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _sTransactionLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _sTransactionLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.jenginetest.builder.model.STransaction fetchSTransaction(
		long transactionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sTransactionLocalService.fetchSTransaction(transactionId);
	}

	/**
	* Returns the s transaction with the primary key.
	*
	* @param transactionId the primary key of the s transaction
	* @return the s transaction
	* @throws PortalException if a s transaction with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.STransaction getSTransaction(
		long transactionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sTransactionLocalService.getSTransaction(transactionId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sTransactionLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.jenginetest.builder.model.STransaction> getSTransactions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sTransactionLocalService.getSTransactions(start, end);
	}

	/**
	* Returns the number of s transactions.
	*
	* @return the number of s transactions
	* @throws SystemException if a system exception occurred
	*/
	public int getSTransactionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sTransactionLocalService.getSTransactionsCount();
	}

	/**
	* Updates the s transaction in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param sTransaction the s transaction
	* @return the s transaction that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.STransaction updateSTransaction(
		com.jenginetest.builder.model.STransaction sTransaction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sTransactionLocalService.updateSTransaction(sTransaction);
	}

	/**
	* Updates the s transaction in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param sTransaction the s transaction
	* @param merge whether to merge the s transaction with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the s transaction that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.STransaction updateSTransaction(
		com.jenginetest.builder.model.STransaction sTransaction, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sTransactionLocalService.updateSTransaction(sTransaction, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _sTransactionLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_sTransactionLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _sTransactionLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public STransactionLocalService getWrappedSTransactionLocalService() {
		return _sTransactionLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedSTransactionLocalService(
		STransactionLocalService sTransactionLocalService) {
		_sTransactionLocalService = sTransactionLocalService;
	}

	public STransactionLocalService getWrappedService() {
		return _sTransactionLocalService;
	}

	public void setWrappedService(
		STransactionLocalService sTransactionLocalService) {
		_sTransactionLocalService = sTransactionLocalService;
	}

	private STransactionLocalService _sTransactionLocalService;
}