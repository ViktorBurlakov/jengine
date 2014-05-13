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

import com.jenginetest.builder.model.STransaction;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the s transaction service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see STransactionPersistenceImpl
 * @see STransactionUtil
 * @generated
 */
public interface STransactionPersistence extends BasePersistence<STransaction> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link STransactionUtil} to access the s transaction persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the s transaction in the entity cache if it is enabled.
	*
	* @param sTransaction the s transaction
	*/
	public void cacheResult(
		com.jenginetest.builder.model.STransaction sTransaction);

	/**
	* Caches the s transactions in the entity cache if it is enabled.
	*
	* @param sTransactions the s transactions
	*/
	public void cacheResult(
		java.util.List<com.jenginetest.builder.model.STransaction> sTransactions);

	/**
	* Creates a new s transaction with the primary key. Does not add the s transaction to the database.
	*
	* @param transactionId the primary key for the new s transaction
	* @return the new s transaction
	*/
	public com.jenginetest.builder.model.STransaction create(long transactionId);

	/**
	* Removes the s transaction with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param transactionId the primary key of the s transaction
	* @return the s transaction that was removed
	* @throws com.jenginetest.builder.NoSuchSTransactionException if a s transaction with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.STransaction remove(long transactionId)
		throws com.jenginetest.builder.NoSuchSTransactionException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.jenginetest.builder.model.STransaction updateImpl(
		com.jenginetest.builder.model.STransaction sTransaction, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s transaction with the primary key or throws a {@link com.jenginetest.builder.NoSuchSTransactionException} if it could not be found.
	*
	* @param transactionId the primary key of the s transaction
	* @return the s transaction
	* @throws com.jenginetest.builder.NoSuchSTransactionException if a s transaction with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.STransaction findByPrimaryKey(
		long transactionId)
		throws com.jenginetest.builder.NoSuchSTransactionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s transaction with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param transactionId the primary key of the s transaction
	* @return the s transaction, or <code>null</code> if a s transaction with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.STransaction fetchByPrimaryKey(
		long transactionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s transactions.
	*
	* @return the s transactions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.STransaction> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.jenginetest.builder.model.STransaction> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s transactions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of s transactions
	* @param end the upper bound of the range of s transactions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s transactions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.STransaction> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the s transactions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s transactions.
	*
	* @return the number of s transactions
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}