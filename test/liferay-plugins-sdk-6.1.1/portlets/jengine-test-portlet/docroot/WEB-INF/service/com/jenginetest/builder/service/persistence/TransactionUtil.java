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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the transaction service. This utility wraps {@link TransactionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TransactionPersistence
 * @see TransactionPersistenceImpl
 * @generated
 */
public class TransactionUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Transaction transaction) {
		getPersistence().clearCache(transaction);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Transaction> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Transaction> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Transaction> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Transaction update(Transaction transaction, boolean merge)
		throws SystemException {
		return getPersistence().update(transaction, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Transaction update(Transaction transaction, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(transaction, merge, serviceContext);
	}

	/**
	* Caches the transaction in the entity cache if it is enabled.
	*
	* @param transaction the transaction
	*/
	public static void cacheResult(
		com.jenginetest.builder.model.Transaction transaction) {
		getPersistence().cacheResult(transaction);
	}

	/**
	* Caches the transactions in the entity cache if it is enabled.
	*
	* @param transactions the transactions
	*/
	public static void cacheResult(
		java.util.List<com.jenginetest.builder.model.Transaction> transactions) {
		getPersistence().cacheResult(transactions);
	}

	/**
	* Creates a new transaction with the primary key. Does not add the transaction to the database.
	*
	* @param transactionId the primary key for the new transaction
	* @return the new transaction
	*/
	public static com.jenginetest.builder.model.Transaction create(
		long transactionId) {
		return getPersistence().create(transactionId);
	}

	/**
	* Removes the transaction with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param transactionId the primary key of the transaction
	* @return the transaction that was removed
	* @throws com.jenginetest.builder.NoSuchTransactionException if a transaction with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.Transaction remove(
		long transactionId)
		throws com.jenginetest.builder.NoSuchTransactionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(transactionId);
	}

	public static com.jenginetest.builder.model.Transaction updateImpl(
		com.jenginetest.builder.model.Transaction transaction, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(transaction, merge);
	}

	/**
	* Returns the transaction with the primary key or throws a {@link com.jenginetest.builder.NoSuchTransactionException} if it could not be found.
	*
	* @param transactionId the primary key of the transaction
	* @return the transaction
	* @throws com.jenginetest.builder.NoSuchTransactionException if a transaction with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.Transaction findByPrimaryKey(
		long transactionId)
		throws com.jenginetest.builder.NoSuchTransactionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(transactionId);
	}

	/**
	* Returns the transaction with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param transactionId the primary key of the transaction
	* @return the transaction, or <code>null</code> if a transaction with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.Transaction fetchByPrimaryKey(
		long transactionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(transactionId);
	}

	/**
	* Returns all the transactions.
	*
	* @return the transactions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jenginetest.builder.model.Transaction> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.jenginetest.builder.model.Transaction> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.jenginetest.builder.model.Transaction> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the transactions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of transactions.
	*
	* @return the number of transactions
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TransactionPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TransactionPersistence)PortletBeanLocatorUtil.locate(com.jenginetest.builder.service.ClpSerializer.getServletContextName(),
					TransactionPersistence.class.getName());

			ReferenceRegistry.registerReference(TransactionUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(TransactionPersistence persistence) {
	}

	private static TransactionPersistence _persistence;
}