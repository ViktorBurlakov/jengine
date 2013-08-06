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

package com.jenginetest.builder.service.persistence;

import com.jenginetest.builder.model.Transaction;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the transaction service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TransactionPersistenceImpl
 * @see TransactionUtil
 * @generated
 */
public interface TransactionPersistence extends BasePersistence<Transaction> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TransactionUtil} to access the transaction persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the transaction in the entity cache if it is enabled.
	*
	* @param transaction the transaction
	*/
	public void cacheResult(
		com.jenginetest.builder.model.Transaction transaction);

	/**
	* Caches the transactions in the entity cache if it is enabled.
	*
	* @param transactions the transactions
	*/
	public void cacheResult(
		java.util.List<com.jenginetest.builder.model.Transaction> transactions);

	/**
	* Creates a new transaction with the primary key. Does not add the transaction to the database.
	*
	* @param transactionId the primary key for the new transaction
	* @return the new transaction
	*/
	public com.jenginetest.builder.model.Transaction create(long transactionId);

	/**
	* Removes the transaction with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param transactionId the primary key of the transaction
	* @return the transaction that was removed
	* @throws com.jenginetest.builder.NoSuchTransactionException if a transaction with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.Transaction remove(long transactionId)
		throws com.jenginetest.builder.NoSuchTransactionException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.jenginetest.builder.model.Transaction updateImpl(
		com.jenginetest.builder.model.Transaction transaction, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the transaction with the primary key or throws a {@link com.jenginetest.builder.NoSuchTransactionException} if it could not be found.
	*
	* @param transactionId the primary key of the transaction
	* @return the transaction
	* @throws com.jenginetest.builder.NoSuchTransactionException if a transaction with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.Transaction findByPrimaryKey(
		long transactionId)
		throws com.jenginetest.builder.NoSuchTransactionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the transaction with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param transactionId the primary key of the transaction
	* @return the transaction, or <code>null</code> if a transaction with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.Transaction fetchByPrimaryKey(
		long transactionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the transactions.
	*
	* @return the transactions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.Transaction> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.jenginetest.builder.model.Transaction> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the transactions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of transactions
	* @param end the upper bound of the range of transactions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of transactions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.Transaction> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the transactions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of transactions.
	*
	* @return the number of transactions
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}