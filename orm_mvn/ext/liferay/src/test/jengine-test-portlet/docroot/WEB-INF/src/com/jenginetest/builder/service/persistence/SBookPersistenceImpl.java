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

import com.jenginetest.builder.NoSuchookException;
import com.jenginetest.builder.model.SBook;
import com.jenginetest.builder.model.impl.SBookImpl;
import com.jenginetest.builder.model.impl.SBookModelImpl;

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
 * The persistence implementation for the s book service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SBookPersistence
 * @see SBookUtil
 * @generated
 */
public class SBookPersistenceImpl extends BasePersistenceImpl<SBook>
	implements SBookPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SBookUtil} to access the s book persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SBookImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SBookModelImpl.ENTITY_CACHE_ENABLED,
			SBookModelImpl.FINDER_CACHE_ENABLED, SBookImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SBookModelImpl.ENTITY_CACHE_ENABLED,
			SBookModelImpl.FINDER_CACHE_ENABLED, SBookImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SBookModelImpl.ENTITY_CACHE_ENABLED,
			SBookModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the s book in the entity cache if it is enabled.
	 *
	 * @param sBook the s book
	 */
	public void cacheResult(SBook sBook) {
		EntityCacheUtil.putResult(SBookModelImpl.ENTITY_CACHE_ENABLED,
			SBookImpl.class, sBook.getPrimaryKey(), sBook);

		sBook.resetOriginalValues();
	}

	/**
	 * Caches the s books in the entity cache if it is enabled.
	 *
	 * @param sBooks the s books
	 */
	public void cacheResult(List<SBook> sBooks) {
		for (SBook sBook : sBooks) {
			if (EntityCacheUtil.getResult(SBookModelImpl.ENTITY_CACHE_ENABLED,
						SBookImpl.class, sBook.getPrimaryKey()) == null) {
				cacheResult(sBook);
			}
			else {
				sBook.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s books.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SBookImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SBookImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s book.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SBook sBook) {
		EntityCacheUtil.removeResult(SBookModelImpl.ENTITY_CACHE_ENABLED,
			SBookImpl.class, sBook.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SBook> sBooks) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SBook sBook : sBooks) {
			EntityCacheUtil.removeResult(SBookModelImpl.ENTITY_CACHE_ENABLED,
				SBookImpl.class, sBook.getPrimaryKey());
		}
	}

	/**
	 * Creates a new s book with the primary key. Does not add the s book to the database.
	 *
	 * @param bookId the primary key for the new s book
	 * @return the new s book
	 */
	public SBook create(long bookId) {
		SBook sBook = new SBookImpl();

		sBook.setNew(true);
		sBook.setPrimaryKey(bookId);

		return sBook;
	}

	/**
	 * Removes the s book with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bookId the primary key of the s book
	 * @return the s book that was removed
	 * @throws com.jenginetest.builder.NoSuchookException if a s book with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SBook remove(long bookId) throws NoSuchookException, SystemException {
		return remove(Long.valueOf(bookId));
	}

	/**
	 * Removes the s book with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s book
	 * @return the s book that was removed
	 * @throws com.jenginetest.builder.NoSuchookException if a s book with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SBook remove(Serializable primaryKey)
		throws NoSuchookException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SBook sBook = (SBook)session.get(SBookImpl.class, primaryKey);

			if (sBook == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchookException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(sBook);
		}
		catch (NoSuchookException nsee) {
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
	protected SBook removeImpl(SBook sBook) throws SystemException {
		sBook = toUnwrappedModel(sBook);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, sBook);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(sBook);

		return sBook;
	}

	@Override
	public SBook updateImpl(com.jenginetest.builder.model.SBook sBook,
		boolean merge) throws SystemException {
		sBook = toUnwrappedModel(sBook);

		boolean isNew = sBook.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, sBook, merge);

			sBook.setNew(false);
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

		EntityCacheUtil.putResult(SBookModelImpl.ENTITY_CACHE_ENABLED,
			SBookImpl.class, sBook.getPrimaryKey(), sBook);

		return sBook;
	}

	protected SBook toUnwrappedModel(SBook sBook) {
		if (sBook instanceof SBookImpl) {
			return sBook;
		}

		SBookImpl sBookImpl = new SBookImpl();

		sBookImpl.setNew(sBook.isNew());
		sBookImpl.setPrimaryKey(sBook.getPrimaryKey());

		sBookImpl.setBookId(sBook.getBookId());
		sBookImpl.setLibraryId(sBook.getLibraryId());
		sBookImpl.setTitle(sBook.getTitle());

		return sBookImpl;
	}

	/**
	 * Returns the s book with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s book
	 * @return the s book
	 * @throws com.liferay.portal.NoSuchModelException if a s book with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SBook findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the s book with the primary key or throws a {@link com.jenginetest.builder.NoSuchookException} if it could not be found.
	 *
	 * @param bookId the primary key of the s book
	 * @return the s book
	 * @throws com.jenginetest.builder.NoSuchookException if a s book with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SBook findByPrimaryKey(long bookId)
		throws NoSuchookException, SystemException {
		SBook sBook = fetchByPrimaryKey(bookId);

		if (sBook == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + bookId);
			}

			throw new NoSuchookException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				bookId);
		}

		return sBook;
	}

	/**
	 * Returns the s book with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s book
	 * @return the s book, or <code>null</code> if a s book with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SBook fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the s book with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bookId the primary key of the s book
	 * @return the s book, or <code>null</code> if a s book with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SBook fetchByPrimaryKey(long bookId) throws SystemException {
		SBook sBook = (SBook)EntityCacheUtil.getResult(SBookModelImpl.ENTITY_CACHE_ENABLED,
				SBookImpl.class, bookId);

		if (sBook == _nullSBook) {
			return null;
		}

		if (sBook == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				sBook = (SBook)session.get(SBookImpl.class, Long.valueOf(bookId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (sBook != null) {
					cacheResult(sBook);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(SBookModelImpl.ENTITY_CACHE_ENABLED,
						SBookImpl.class, bookId, _nullSBook);
				}

				closeSession(session);
			}
		}

		return sBook;
	}

	/**
	 * Returns all the s books.
	 *
	 * @return the s books
	 * @throws SystemException if a system exception occurred
	 */
	public List<SBook> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<SBook> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s books.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of s books
	 * @param end the upper bound of the range of s books (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s books
	 * @throws SystemException if a system exception occurred
	 */
	public List<SBook> findAll(int start, int end,
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

		List<SBook> list = (List<SBook>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SBOOK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SBOOK;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<SBook>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<SBook>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the s books from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (SBook sBook : findAll()) {
			remove(sBook);
		}
	}

	/**
	 * Returns the number of s books.
	 *
	 * @return the number of s books
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SBOOK);

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
	 * Initializes the s book persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.jenginetest.builder.model.SBook")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SBook>> listenersList = new ArrayList<ModelListener<SBook>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SBook>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SBookImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = SAuthorPersistence.class)
	protected SAuthorPersistence sAuthorPersistence;
	@BeanReference(type = SBookPersistence.class)
	protected SBookPersistence sBookPersistence;
	@BeanReference(type = SLibraryPersistence.class)
	protected SLibraryPersistence sLibraryPersistence;
	@BeanReference(type = SMemberPersistence.class)
	protected SMemberPersistence sMemberPersistence;
	@BeanReference(type = STransactionPersistence.class)
	protected STransactionPersistence sTransactionPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_SBOOK = "SELECT sBook FROM SBook sBook";
	private static final String _SQL_COUNT_SBOOK = "SELECT COUNT(sBook) FROM SBook sBook";
	private static final String _ORDER_BY_ENTITY_ALIAS = "sBook.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SBook exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SBookPersistenceImpl.class);
	private static SBook _nullSBook = new SBookImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SBook> toCacheModel() {
				return _nullSBookCacheModel;
			}
		};

	private static CacheModel<SBook> _nullSBookCacheModel = new CacheModel<SBook>() {
			public SBook toEntityModel() {
				return _nullSBook;
			}
		};
}