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

import com.jenginetest.builder.NoSuchLibraryException;
import com.jenginetest.builder.model.Library;
import com.jenginetest.builder.model.impl.LibraryImpl;
import com.jenginetest.builder.model.impl.LibraryModelImpl;

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
 * The persistence implementation for the library service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LibraryPersistence
 * @see LibraryUtil
 * @generated
 */
public class LibraryPersistenceImpl extends BasePersistenceImpl<Library>
	implements LibraryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LibraryUtil} to access the library persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LibraryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LibraryModelImpl.ENTITY_CACHE_ENABLED,
			LibraryModelImpl.FINDER_CACHE_ENABLED, LibraryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LibraryModelImpl.ENTITY_CACHE_ENABLED,
			LibraryModelImpl.FINDER_CACHE_ENABLED, LibraryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LibraryModelImpl.ENTITY_CACHE_ENABLED,
			LibraryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the library in the entity cache if it is enabled.
	 *
	 * @param library the library
	 */
	public void cacheResult(Library library) {
		EntityCacheUtil.putResult(LibraryModelImpl.ENTITY_CACHE_ENABLED,
			LibraryImpl.class, library.getPrimaryKey(), library);

		library.resetOriginalValues();
	}

	/**
	 * Caches the libraries in the entity cache if it is enabled.
	 *
	 * @param libraries the libraries
	 */
	public void cacheResult(List<Library> libraries) {
		for (Library library : libraries) {
			if (EntityCacheUtil.getResult(
						LibraryModelImpl.ENTITY_CACHE_ENABLED,
						LibraryImpl.class, library.getPrimaryKey()) == null) {
				cacheResult(library);
			}
			else {
				library.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all libraries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LibraryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LibraryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the library.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Library library) {
		EntityCacheUtil.removeResult(LibraryModelImpl.ENTITY_CACHE_ENABLED,
			LibraryImpl.class, library.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Library> libraries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Library library : libraries) {
			EntityCacheUtil.removeResult(LibraryModelImpl.ENTITY_CACHE_ENABLED,
				LibraryImpl.class, library.getPrimaryKey());
		}
	}

	/**
	 * Creates a new library with the primary key. Does not add the library to the database.
	 *
	 * @param libraryId the primary key for the new library
	 * @return the new library
	 */
	public Library create(long libraryId) {
		Library library = new LibraryImpl();

		library.setNew(true);
		library.setPrimaryKey(libraryId);

		return library;
	}

	/**
	 * Removes the library with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param libraryId the primary key of the library
	 * @return the library that was removed
	 * @throws com.jenginetest.builder.NoSuchLibraryException if a library with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Library remove(long libraryId)
		throws NoSuchLibraryException, SystemException {
		return remove(Long.valueOf(libraryId));
	}

	/**
	 * Removes the library with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the library
	 * @return the library that was removed
	 * @throws com.jenginetest.builder.NoSuchLibraryException if a library with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Library remove(Serializable primaryKey)
		throws NoSuchLibraryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Library library = (Library)session.get(LibraryImpl.class, primaryKey);

			if (library == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLibraryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(library);
		}
		catch (NoSuchLibraryException nsee) {
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
	protected Library removeImpl(Library library) throws SystemException {
		library = toUnwrappedModel(library);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, library);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(library);

		return library;
	}

	@Override
	public Library updateImpl(com.jenginetest.builder.model.Library library,
		boolean merge) throws SystemException {
		library = toUnwrappedModel(library);

		boolean isNew = library.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, library, merge);

			library.setNew(false);
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

		EntityCacheUtil.putResult(LibraryModelImpl.ENTITY_CACHE_ENABLED,
			LibraryImpl.class, library.getPrimaryKey(), library);

		return library;
	}

	protected Library toUnwrappedModel(Library library) {
		if (library instanceof LibraryImpl) {
			return library;
		}

		LibraryImpl libraryImpl = new LibraryImpl();

		libraryImpl.setNew(library.isNew());
		libraryImpl.setPrimaryKey(library.getPrimaryKey());

		libraryImpl.setLibraryId(library.getLibraryId());
		libraryImpl.setName(library.getName());
		libraryImpl.setAddress(library.getAddress());

		return libraryImpl;
	}

	/**
	 * Returns the library with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the library
	 * @return the library
	 * @throws com.liferay.portal.NoSuchModelException if a library with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Library findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the library with the primary key or throws a {@link com.jenginetest.builder.NoSuchLibraryException} if it could not be found.
	 *
	 * @param libraryId the primary key of the library
	 * @return the library
	 * @throws com.jenginetest.builder.NoSuchLibraryException if a library with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Library findByPrimaryKey(long libraryId)
		throws NoSuchLibraryException, SystemException {
		Library library = fetchByPrimaryKey(libraryId);

		if (library == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + libraryId);
			}

			throw new NoSuchLibraryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				libraryId);
		}

		return library;
	}

	/**
	 * Returns the library with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the library
	 * @return the library, or <code>null</code> if a library with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Library fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the library with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param libraryId the primary key of the library
	 * @return the library, or <code>null</code> if a library with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Library fetchByPrimaryKey(long libraryId) throws SystemException {
		Library library = (Library)EntityCacheUtil.getResult(LibraryModelImpl.ENTITY_CACHE_ENABLED,
				LibraryImpl.class, libraryId);

		if (library == _nullLibrary) {
			return null;
		}

		if (library == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				library = (Library)session.get(LibraryImpl.class,
						Long.valueOf(libraryId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (library != null) {
					cacheResult(library);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(LibraryModelImpl.ENTITY_CACHE_ENABLED,
						LibraryImpl.class, libraryId, _nullLibrary);
				}

				closeSession(session);
			}
		}

		return library;
	}

	/**
	 * Returns all the libraries.
	 *
	 * @return the libraries
	 * @throws SystemException if a system exception occurred
	 */
	public List<Library> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the libraries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of libraries
	 * @param end the upper bound of the range of libraries (not inclusive)
	 * @return the range of libraries
	 * @throws SystemException if a system exception occurred
	 */
	public List<Library> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the libraries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of libraries
	 * @param end the upper bound of the range of libraries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of libraries
	 * @throws SystemException if a system exception occurred
	 */
	public List<Library> findAll(int start, int end,
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

		List<Library> list = (List<Library>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LIBRARY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LIBRARY;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Library>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Library>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the libraries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Library library : findAll()) {
			remove(library);
		}
	}

	/**
	 * Returns the number of libraries.
	 *
	 * @return the number of libraries
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LIBRARY);

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
	 * Initializes the library persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.jenginetest.builder.model.Library")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Library>> listenersList = new ArrayList<ModelListener<Library>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Library>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LibraryImpl.class.getName());
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
	private static final String _SQL_SELECT_LIBRARY = "SELECT library FROM Library library";
	private static final String _SQL_COUNT_LIBRARY = "SELECT COUNT(library) FROM Library library";
	private static final String _ORDER_BY_ENTITY_ALIAS = "library.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Library exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LibraryPersistenceImpl.class);
	private static Library _nullLibrary = new LibraryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Library> toCacheModel() {
				return _nullLibraryCacheModel;
			}
		};

	private static CacheModel<Library> _nullLibraryCacheModel = new CacheModel<Library>() {
			public Library toEntityModel() {
				return _nullLibrary;
			}
		};
}