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

import com.jenginetest.builder.NoSuchTransactionException;
import com.jenginetest.builder.model.Transaction;
import com.jenginetest.builder.model.impl.TransactionImpl;
import com.jenginetest.builder.model.impl.TransactionModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the transaction service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TransactionPersistence
 * @see TransactionUtil
 * @generated
 */
public class TransactionPersistenceImpl extends BasePersistenceImpl<Transaction>
	implements TransactionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TransactionUtil} to access the transaction persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TransactionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TransactionModelImpl.ENTITY_CACHE_ENABLED,
			TransactionModelImpl.FINDER_CACHE_ENABLED, TransactionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TransactionModelImpl.ENTITY_CACHE_ENABLED,
			TransactionModelImpl.FINDER_CACHE_ENABLED, TransactionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TransactionModelImpl.ENTITY_CACHE_ENABLED,
			TransactionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the transaction in the entity cache if it is enabled.
	 *
	 * @param transaction the transaction
	 */
	public void cacheResult(Transaction transaction) {
		EntityCacheUtil.putResult(TransactionModelImpl.ENTITY_CACHE_ENABLED,
			TransactionImpl.class, transaction.getPrimaryKey(), transaction);

		transaction.resetOriginalValues();
	}

	/**
	 * Caches the transactions in the entity cache if it is enabled.
	 *
	 * @param transactions the transactions
	 */
	public void cacheResult(List<Transaction> transactions) {
		for (Transaction transaction : transactions) {
			if (EntityCacheUtil.getResult(
						TransactionModelImpl.ENTITY_CACHE_ENABLED,
						TransactionImpl.class, transaction.getPrimaryKey()) == null) {
				cacheResult(transaction);
			}
			else {
				transaction.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all transactions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TransactionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TransactionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the transaction.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Transaction transaction) {
		EntityCacheUtil.removeResult(TransactionModelImpl.ENTITY_CACHE_ENABLED,
			TransactionImpl.class, transaction.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Transaction> transactions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Transaction transaction : transactions) {
			EntityCacheUtil.removeResult(TransactionModelImpl.ENTITY_CACHE_ENABLED,
				TransactionImpl.class, transaction.getPrimaryKey());
		}
	}

	/**
	 * Creates a new transaction with the primary key. Does not add the transaction to the database.
	 *
	 * @param transactionId the primary key for the new transaction
	 * @return the new transaction
	 */
	public Transaction create(long transactionId) {
		Transaction transaction = new TransactionImpl();

		transaction.setNew(true);
		transaction.setPrimaryKey(transactionId);

		return transaction;
	}

	/**
	 * Removes the transaction with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param transactionId the primary key of the transaction
	 * @return the transaction that was removed
	 * @throws com.jenginetest.builder.NoSuchTransactionException if a transaction with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Transaction remove(long transactionId)
		throws NoSuchTransactionException, SystemException {
		return remove(Long.valueOf(transactionId));
	}

	/**
	 * Removes the transaction with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the transaction
	 * @return the transaction that was removed
	 * @throws com.jenginetest.builder.NoSuchTransactionException if a transaction with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Transaction remove(Serializable primaryKey)
		throws NoSuchTransactionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Transaction transaction = (Transaction)session.get(TransactionImpl.class,
					primaryKey);

			if (transaction == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTransactionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(transaction);
		}
		catch (NoSuchTransactionException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Transaction removeImpl(Transaction transaction)
		throws SystemException {
		transaction = toUnwrappedModel(transaction);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, transaction);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(transaction);

		return transaction;
	}

	@Override
	public Transaction updateImpl(
		com.jenginetest.builder.model.Transaction transaction, boolean merge)
		throws SystemException {
		transaction = toUnwrappedModel(transaction);

		boolean isNew = transaction.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, transaction, merge);

			transaction.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(TransactionModelImpl.ENTITY_CACHE_ENABLED,
			TransactionImpl.class, transaction.getPrimaryKey(), transaction);

		return transaction;
	}

	protected Transaction toUnwrappedModel(Transaction transaction) {
		if (transaction instanceof TransactionImpl) {
			return transaction;
		}

		TransactionImpl transactionImpl = new TransactionImpl();

		transactionImpl.setNew(transaction.isNew());
		transactionImpl.setPrimaryKey(transaction.getPrimaryKey());

		transactionImpl.setTransactionId(transaction.getTransactionId());
		transactionImpl.setBookId(transaction.getBookId());
		transactionImpl.setMemberId(transaction.getMemberId());
		transactionImpl.setTdate(transaction.getTdate());

		return transactionImpl;
	}

	/**
	 * Returns the transaction with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the transaction
	 * @return the transaction
	 * @throws com.liferay.portal.NoSuchModelException if a transaction with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Transaction findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the transaction with the primary key or throws a {@link com.jenginetest.builder.NoSuchTransactionException} if it could not be found.
	 *
	 * @param transactionId the primary key of the transaction
	 * @return the transaction
	 * @throws com.jenginetest.builder.NoSuchTransactionException if a transaction with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Transaction findByPrimaryKey(long transactionId)
		throws NoSuchTransactionException, SystemException {
		Transaction transaction = fetchByPrimaryKey(transactionId);

		if (transaction == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + transactionId);
			}

			throw new NoSuchTransactionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				transactionId);
		}

		return transaction;
	}

	/**
	 * Returns the transaction with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the transaction
	 * @return the transaction, or <code>null</code> if a transaction with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Transaction fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the transaction with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param transactionId the primary key of the transaction
	 * @return the transaction, or <code>null</code> if a transaction with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Transaction fetchByPrimaryKey(long transactionId)
		throws SystemException {
		Transaction transaction = (Transaction)EntityCacheUtil.getResult(TransactionModelImpl.ENTITY_CACHE_ENABLED,
				TransactionImpl.class, transactionId);

		if (transaction == _nullTransaction) {
			return null;
		}

		if (transaction == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				transaction = (Transaction)session.get(TransactionImpl.class,
						Long.valueOf(transactionId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (transaction != null) {
					cacheResult(transaction);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(TransactionModelImpl.ENTITY_CACHE_ENABLED,
						TransactionImpl.class, transactionId, _nullTransaction);
				}

				closeSession(session);
			}
		}

		return transaction;
	}

	/**
	 * Returns all the transactions.
	 *
	 * @return the transactions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Transaction> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Transaction> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	public List<Transaction> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Transaction> list = (List<Transaction>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TRANSACTION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TRANSACTION;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Transaction>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Transaction>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the transactions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Transaction transaction : findAll()) {
			remove(transaction);
		}
	}

	/**
	 * Returns the number of transactions.
	 *
	 * @return the number of transactions
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TRANSACTION);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the transaction persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.jenginetest.builder.model.Transaction")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Transaction>> listenersList = new ArrayList<ModelListener<Transaction>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Transaction>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(TransactionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = AuthorPersistence.class)
	protected AuthorPersistence authorPersistence;
	@BeanReference(type = BookPersistence.class)
	protected BookPersistence bookPersistence;
	@BeanReference(type = LibraryPersistence.class)
	protected LibraryPersistence libraryPersistence;
	@BeanReference(type = MemberPersistence.class)
	protected MemberPersistence memberPersistence;
	@BeanReference(type = TransactionPersistence.class)
	protected TransactionPersistence transactionPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_TRANSACTION = "SELECT transaction FROM Transaction transaction";
	private static final String _SQL_COUNT_TRANSACTION = "SELECT COUNT(transaction) FROM Transaction transaction";
	private static final String _ORDER_BY_ENTITY_ALIAS = "transaction.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Transaction exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TransactionPersistenceImpl.class);
	private static Transaction _nullTransaction = new TransactionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Transaction> toCacheModel() {
				return _nullTransactionCacheModel;
			}
		};

	private static CacheModel<Transaction> _nullTransactionCacheModel = new CacheModel<Transaction>() {
			public Transaction toEntityModel() {
				return _nullTransaction;
			}
		};
}