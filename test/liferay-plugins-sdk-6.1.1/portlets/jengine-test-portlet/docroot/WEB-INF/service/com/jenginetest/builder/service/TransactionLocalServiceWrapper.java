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
 * This class is a wrapper for {@link TransactionLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       TransactionLocalService
 * @generated
 */
public class TransactionLocalServiceWrapper implements TransactionLocalService,
	ServiceWrapper<TransactionLocalService> {
	public TransactionLocalServiceWrapper(
		TransactionLocalService transactionLocalService) {
		_transactionLocalService = transactionLocalService;
	}

	/**
	* Adds the transaction to the database. Also notifies the appropriate model listeners.
	*
	* @param transaction the transaction
	* @return the transaction that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.Transaction addTransaction(
		com.jenginetest.builder.model.Transaction transaction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _transactionLocalService.addTransaction(transaction);
	}

	/**
	* Creates a new transaction with the primary key. Does not add the transaction to the database.
	*
	* @param transactionId the primary key for the new transaction
	* @return the new transaction
	*/
	public com.jenginetest.builder.model.Transaction createTransaction(
		long transactionId) {
		return _transactionLocalService.createTransaction(transactionId);
	}

	/**
	* Deletes the transaction with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param transactionId the primary key of the transaction
	* @return the transaction that was removed
	* @throws PortalException if a transaction with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.Transaction deleteTransaction(
		long transactionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _transactionLocalService.deleteTransaction(transactionId);
	}

	/**
	* Deletes the transaction from the database. Also notifies the appropriate model listeners.
	*
	* @param transaction the transaction
	* @return the transaction that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.Transaction deleteTransaction(
		com.jenginetest.builder.model.Transaction transaction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _transactionLocalService.deleteTransaction(transaction);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _transactionLocalService.dynamicQuery();
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
		return _transactionLocalService.dynamicQuery(dynamicQuery);
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
		return _transactionLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _transactionLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _transactionLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.jenginetest.builder.model.Transaction fetchTransaction(
		long transactionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _transactionLocalService.fetchTransaction(transactionId);
	}

	/**
	* Returns the transaction with the primary key.
	*
	* @param transactionId the primary key of the transaction
	* @return the transaction
	* @throws PortalException if a transaction with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.Transaction getTransaction(
		long transactionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _transactionLocalService.getTransaction(transactionId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _transactionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the transactions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of transactions
	* @param end the upper bound of the range of transactions (not inclusive)
	* @return the range of transactions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.Transaction> getTransactions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _transactionLocalService.getTransactions(start, end);
	}

	/**
	* Returns the number of transactions.
	*
	* @return the number of transactions
	* @throws SystemException if a system exception occurred
	*/
	public int getTransactionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _transactionLocalService.getTransactionsCount();
	}

	/**
	* Updates the transaction in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param transaction the transaction
	* @return the transaction that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.Transaction updateTransaction(
		com.jenginetest.builder.model.Transaction transaction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _transactionLocalService.updateTransaction(transaction);
	}

	/**
	* Updates the transaction in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param transaction the transaction
	* @param merge whether to merge the transaction with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the transaction that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.Transaction updateTransaction(
		com.jenginetest.builder.model.Transaction transaction, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _transactionLocalService.updateTransaction(transaction, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _transactionLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_transactionLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _transactionLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public TransactionLocalService getWrappedTransactionLocalService() {
		return _transactionLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedTransactionLocalService(
		TransactionLocalService transactionLocalService) {
		_transactionLocalService = transactionLocalService;
	}

	public TransactionLocalService getWrappedService() {
		return _transactionLocalService;
	}

	public void setWrappedService(
		TransactionLocalService transactionLocalService) {
		_transactionLocalService = transactionLocalService;
	}

	private TransactionLocalService _transactionLocalService;
}