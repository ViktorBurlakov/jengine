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

import com.jenginetest.builder.NoSuchAuthorException;
import com.jenginetest.builder.model.Author;
import com.jenginetest.builder.model.impl.AuthorImpl;
import com.jenginetest.builder.model.impl.AuthorModelImpl;

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
 * The persistence implementation for the author service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AuthorPersistence
 * @see AuthorUtil
 * @generated
 */
public class AuthorPersistenceImpl extends BasePersistenceImpl<Author>
	implements AuthorPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AuthorUtil} to access the author persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AuthorImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AuthorModelImpl.ENTITY_CACHE_ENABLED,
			AuthorModelImpl.FINDER_CACHE_ENABLED, AuthorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AuthorModelImpl.ENTITY_CACHE_ENABLED,
			AuthorModelImpl.FINDER_CACHE_ENABLED, AuthorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AuthorModelImpl.ENTITY_CACHE_ENABLED,
			AuthorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the author in the entity cache if it is enabled.
	 *
	 * @param author the author
	 */
	public void cacheResult(Author author) {
		EntityCacheUtil.putResult(AuthorModelImpl.ENTITY_CACHE_ENABLED,
			AuthorImpl.class, author.getPrimaryKey(), author);

		author.resetOriginalValues();
	}

	/**
	 * Caches the authors in the entity cache if it is enabled.
	 *
	 * @param authors the authors
	 */
	public void cacheResult(List<Author> authors) {
		for (Author author : authors) {
			if (EntityCacheUtil.getResult(
						AuthorModelImpl.ENTITY_CACHE_ENABLED, AuthorImpl.class,
						author.getPrimaryKey()) == null) {
				cacheResult(author);
			}
			else {
				author.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all authors.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AuthorImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AuthorImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the author.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Author author) {
		EntityCacheUtil.removeResult(AuthorModelImpl.ENTITY_CACHE_ENABLED,
			AuthorImpl.class, author.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Author> authors) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Author author : authors) {
			EntityCacheUtil.removeResult(AuthorModelImpl.ENTITY_CACHE_ENABLED,
				AuthorImpl.class, author.getPrimaryKey());
		}
	}

	/**
	 * Creates a new author with the primary key. Does not add the author to the database.
	 *
	 * @param authorId the primary key for the new author
	 * @return the new author
	 */
	public Author create(long authorId) {
		Author author = new AuthorImpl();

		author.setNew(true);
		author.setPrimaryKey(authorId);

		return author;
	}

	/**
	 * Removes the author with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param authorId the primary key of the author
	 * @return the author that was removed
	 * @throws com.jenginetest.builder.NoSuchAuthorException if a author with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Author remove(long authorId)
		throws NoSuchAuthorException, SystemException {
		return remove(Long.valueOf(authorId));
	}

	/**
	 * Removes the author with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the author
	 * @return the author that was removed
	 * @throws com.jenginetest.builder.NoSuchAuthorException if a author with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Author remove(Serializable primaryKey)
		throws NoSuchAuthorException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Author author = (Author)session.get(AuthorImpl.class, primaryKey);

			if (author == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAuthorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(author);
		}
		catch (NoSuchAuthorException nsee) {
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
	protected Author removeImpl(Author author) throws SystemException {
		author = toUnwrappedModel(author);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, author);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(author);

		return author;
	}

	@Override
	public Author updateImpl(com.jenginetest.builder.model.Author author,
		boolean merge) throws SystemException {
		author = toUnwrappedModel(author);

		boolean isNew = author.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, author, merge);

			author.setNew(false);
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

		EntityCacheUtil.putResult(AuthorModelImpl.ENTITY_CACHE_ENABLED,
			AuthorImpl.class, author.getPrimaryKey(), author);

		return author;
	}

	protected Author toUnwrappedModel(Author author) {
		if (author instanceof AuthorImpl) {
			return author;
		}

		AuthorImpl authorImpl = new AuthorImpl();

		authorImpl.setNew(author.isNew());
		authorImpl.setPrimaryKey(author.getPrimaryKey());

		authorImpl.setAuthorId(author.getAuthorId());
		authorImpl.setFirstName(author.getFirstName());
		authorImpl.setLastName(author.getLastName());

		return authorImpl;
	}

	/**
	 * Returns the author with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the author
	 * @return the author
	 * @throws com.liferay.portal.NoSuchModelException if a author with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Author findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the author with the primary key or throws a {@link com.jenginetest.builder.NoSuchAuthorException} if it could not be found.
	 *
	 * @param authorId the primary key of the author
	 * @return the author
	 * @throws com.jenginetest.builder.NoSuchAuthorException if a author with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Author findByPrimaryKey(long authorId)
		throws NoSuchAuthorException, SystemException {
		Author author = fetchByPrimaryKey(authorId);

		if (author == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + authorId);
			}

			throw new NoSuchAuthorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				authorId);
		}

		return author;
	}

	/**
	 * Returns the author with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the author
	 * @return the author, or <code>null</code> if a author with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Author fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the author with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param authorId the primary key of the author
	 * @return the author, or <code>null</code> if a author with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Author fetchByPrimaryKey(long authorId) throws SystemException {
		Author author = (Author)EntityCacheUtil.getResult(AuthorModelImpl.ENTITY_CACHE_ENABLED,
				AuthorImpl.class, authorId);

		if (author == _nullAuthor) {
			return null;
		}

		if (author == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				author = (Author)session.get(AuthorImpl.class,
						Long.valueOf(authorId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (author != null) {
					cacheResult(author);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(AuthorModelImpl.ENTITY_CACHE_ENABLED,
						AuthorImpl.class, authorId, _nullAuthor);
				}

				closeSession(session);
			}
		}

		return author;
	}

	/**
	 * Returns all the authors.
	 *
	 * @return the authors
	 * @throws SystemException if a system exception occurred
	 */
	public List<Author> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the authors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of authors
	 * @param end the upper bound of the range of authors (not inclusive)
	 * @return the range of authors
	 * @throws SystemException if a system exception occurred
	 */
	public List<Author> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the authors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of authors
	 * @param end the upper bound of the range of authors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of authors
	 * @throws SystemException if a system exception occurred
	 */
	public List<Author> findAll(int start, int end,
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

		List<Author> list = (List<Author>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_AUTHOR);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_AUTHOR;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Author>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Author>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the authors from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Author author : findAll()) {
			remove(author);
		}
	}

	/**
	 * Returns the number of authors.
	 *
	 * @return the number of authors
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_AUTHOR);

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
	 * Initializes the author persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.jenginetest.builder.model.Author")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Author>> listenersList = new ArrayList<ModelListener<Author>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Author>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AuthorImpl.class.getName());
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
	private static final String _SQL_SELECT_AUTHOR = "SELECT author FROM Author author";
	private static final String _SQL_COUNT_AUTHOR = "SELECT COUNT(author) FROM Author author";
	private static final String _ORDER_BY_ENTITY_ALIAS = "author.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Author exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AuthorPersistenceImpl.class);
	private static Author _nullAuthor = new AuthorImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Author> toCacheModel() {
				return _nullAuthorCacheModel;
			}
		};

	private static CacheModel<Author> _nullAuthorCacheModel = new CacheModel<Author>() {
			public Author toEntityModel() {
				return _nullAuthor;
			}
		};
}