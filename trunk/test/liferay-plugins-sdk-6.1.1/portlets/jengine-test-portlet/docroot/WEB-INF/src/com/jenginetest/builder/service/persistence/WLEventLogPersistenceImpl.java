/*
 * This file is part of JEngine.
 *
 * Copyright (C) 2013 Victor Burlakov
 *
 * JEngine is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JEngine is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with JEngine.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.jenginetest.builder.service.persistence;

import com.jenginetest.builder.NoSuchEventLogException;
import com.jenginetest.builder.model.WLEventLog;
import com.jenginetest.builder.model.impl.WLEventLogImpl;
import com.jenginetest.builder.model.impl.WLEventLogModelImpl;

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
 * The persistence implementation for the w l event log service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WLEventLogPersistence
 * @see WLEventLogUtil
 * @generated
 */
public class WLEventLogPersistenceImpl extends BasePersistenceImpl<WLEventLog>
	implements WLEventLogPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WLEventLogUtil} to access the w l event log persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WLEventLogImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WLEventLogModelImpl.ENTITY_CACHE_ENABLED,
			WLEventLogModelImpl.FINDER_CACHE_ENABLED, WLEventLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WLEventLogModelImpl.ENTITY_CACHE_ENABLED,
			WLEventLogModelImpl.FINDER_CACHE_ENABLED, WLEventLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WLEventLogModelImpl.ENTITY_CACHE_ENABLED,
			WLEventLogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the w l event log in the entity cache if it is enabled.
	 *
	 * @param wlEventLog the w l event log
	 */
	public void cacheResult(WLEventLog wlEventLog) {
		EntityCacheUtil.putResult(WLEventLogModelImpl.ENTITY_CACHE_ENABLED,
			WLEventLogImpl.class, wlEventLog.getPrimaryKey(), wlEventLog);

		wlEventLog.resetOriginalValues();
	}

	/**
	 * Caches the w l event logs in the entity cache if it is enabled.
	 *
	 * @param wlEventLogs the w l event logs
	 */
	public void cacheResult(List<WLEventLog> wlEventLogs) {
		for (WLEventLog wlEventLog : wlEventLogs) {
			if (EntityCacheUtil.getResult(
						WLEventLogModelImpl.ENTITY_CACHE_ENABLED,
						WLEventLogImpl.class, wlEventLog.getPrimaryKey()) == null) {
				cacheResult(wlEventLog);
			}
			else {
				wlEventLog.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all w l event logs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(WLEventLogImpl.class.getName());
		}

		EntityCacheUtil.clearCache(WLEventLogImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the w l event log.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WLEventLog wlEventLog) {
		EntityCacheUtil.removeResult(WLEventLogModelImpl.ENTITY_CACHE_ENABLED,
			WLEventLogImpl.class, wlEventLog.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<WLEventLog> wlEventLogs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (WLEventLog wlEventLog : wlEventLogs) {
			EntityCacheUtil.removeResult(WLEventLogModelImpl.ENTITY_CACHE_ENABLED,
				WLEventLogImpl.class, wlEventLog.getPrimaryKey());
		}
	}

	/**
	 * Creates a new w l event log with the primary key. Does not add the w l event log to the database.
	 *
	 * @param eventLogId the primary key for the new w l event log
	 * @return the new w l event log
	 */
	public WLEventLog create(long eventLogId) {
		WLEventLog wlEventLog = new WLEventLogImpl();

		wlEventLog.setNew(true);
		wlEventLog.setPrimaryKey(eventLogId);

		return wlEventLog;
	}

	/**
	 * Removes the w l event log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventLogId the primary key of the w l event log
	 * @return the w l event log that was removed
	 * @throws com.jenginetest.builder.NoSuchEventLogException if a w l event log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLEventLog remove(long eventLogId)
		throws NoSuchEventLogException, SystemException {
		return remove(Long.valueOf(eventLogId));
	}

	/**
	 * Removes the w l event log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the w l event log
	 * @return the w l event log that was removed
	 * @throws com.jenginetest.builder.NoSuchEventLogException if a w l event log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WLEventLog remove(Serializable primaryKey)
		throws NoSuchEventLogException, SystemException {
		Session session = null;

		try {
			session = openSession();

			WLEventLog wlEventLog = (WLEventLog)session.get(WLEventLogImpl.class,
					primaryKey);

			if (wlEventLog == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEventLogException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(wlEventLog);
		}
		catch (NoSuchEventLogException nsee) {
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
	protected WLEventLog removeImpl(WLEventLog wlEventLog)
		throws SystemException {
		wlEventLog = toUnwrappedModel(wlEventLog);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, wlEventLog);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(wlEventLog);

		return wlEventLog;
	}

	@Override
	public WLEventLog updateImpl(
		com.jenginetest.builder.model.WLEventLog wlEventLog, boolean merge)
		throws SystemException {
		wlEventLog = toUnwrappedModel(wlEventLog);

		boolean isNew = wlEventLog.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, wlEventLog, merge);

			wlEventLog.setNew(false);
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

		EntityCacheUtil.putResult(WLEventLogModelImpl.ENTITY_CACHE_ENABLED,
			WLEventLogImpl.class, wlEventLog.getPrimaryKey(), wlEventLog);

		return wlEventLog;
	}

	protected WLEventLog toUnwrappedModel(WLEventLog wlEventLog) {
		if (wlEventLog instanceof WLEventLogImpl) {
			return wlEventLog;
		}

		WLEventLogImpl wlEventLogImpl = new WLEventLogImpl();

		wlEventLogImpl.setNew(wlEventLog.isNew());
		wlEventLogImpl.setPrimaryKey(wlEventLog.getPrimaryKey());

		wlEventLogImpl.setGroupId(wlEventLog.getGroupId());
		wlEventLogImpl.setCompanyId(wlEventLog.getCompanyId());
		wlEventLogImpl.setEventLogId(wlEventLog.getEventLogId());
		wlEventLogImpl.setUserId(wlEventLog.getUserId());
		wlEventLogImpl.setLogDate(wlEventLog.getLogDate());
		wlEventLogImpl.setEvent(wlEventLog.getEvent());
		wlEventLogImpl.setTitle(wlEventLog.getTitle());
		wlEventLogImpl.setModelName(wlEventLog.getModelName());
		wlEventLogImpl.setModelPK(wlEventLog.getModelPK());
		wlEventLogImpl.setDescription(wlEventLog.getDescription());

		return wlEventLogImpl;
	}

	/**
	 * Returns the w l event log with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the w l event log
	 * @return the w l event log
	 * @throws com.liferay.portal.NoSuchModelException if a w l event log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WLEventLog findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the w l event log with the primary key or throws a {@link com.jenginetest.builder.NoSuchEventLogException} if it could not be found.
	 *
	 * @param eventLogId the primary key of the w l event log
	 * @return the w l event log
	 * @throws com.jenginetest.builder.NoSuchEventLogException if a w l event log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLEventLog findByPrimaryKey(long eventLogId)
		throws NoSuchEventLogException, SystemException {
		WLEventLog wlEventLog = fetchByPrimaryKey(eventLogId);

		if (wlEventLog == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + eventLogId);
			}

			throw new NoSuchEventLogException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				eventLogId);
		}

		return wlEventLog;
	}

	/**
	 * Returns the w l event log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the w l event log
	 * @return the w l event log, or <code>null</code> if a w l event log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WLEventLog fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the w l event log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param eventLogId the primary key of the w l event log
	 * @return the w l event log, or <code>null</code> if a w l event log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLEventLog fetchByPrimaryKey(long eventLogId)
		throws SystemException {
		WLEventLog wlEventLog = (WLEventLog)EntityCacheUtil.getResult(WLEventLogModelImpl.ENTITY_CACHE_ENABLED,
				WLEventLogImpl.class, eventLogId);

		if (wlEventLog == _nullWLEventLog) {
			return null;
		}

		if (wlEventLog == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				wlEventLog = (WLEventLog)session.get(WLEventLogImpl.class,
						Long.valueOf(eventLogId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (wlEventLog != null) {
					cacheResult(wlEventLog);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(WLEventLogModelImpl.ENTITY_CACHE_ENABLED,
						WLEventLogImpl.class, eventLogId, _nullWLEventLog);
				}

				closeSession(session);
			}
		}

		return wlEventLog;
	}

	/**
	 * Returns all the w l event logs.
	 *
	 * @return the w l event logs
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLEventLog> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the w l event logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of w l event logs
	 * @param end the upper bound of the range of w l event logs (not inclusive)
	 * @return the range of w l event logs
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLEventLog> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the w l event logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of w l event logs
	 * @param end the upper bound of the range of w l event logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of w l event logs
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLEventLog> findAll(int start, int end,
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

		List<WLEventLog> list = (List<WLEventLog>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_WLEVENTLOG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WLEVENTLOG;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<WLEventLog>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<WLEventLog>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the w l event logs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (WLEventLog wlEventLog : findAll()) {
			remove(wlEventLog);
		}
	}

	/**
	 * Returns the number of w l event logs.
	 *
	 * @return the number of w l event logs
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_WLEVENTLOG);

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
	 * Initializes the w l event log persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.jenginetest.builder.model.WLEventLog")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<WLEventLog>> listenersList = new ArrayList<ModelListener<WLEventLog>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<WLEventLog>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(WLEventLogImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = WLEntryPersistence.class)
	protected WLEntryPersistence wlEntryPersistence;
	@BeanReference(type = WLEventLogPersistence.class)
	protected WLEventLogPersistence wlEventLogPersistence;
	@BeanReference(type = WLProjectPersistence.class)
	protected WLProjectPersistence wlProjectPersistence;
	@BeanReference(type = WLProjectUserPersistence.class)
	protected WLProjectUserPersistence wlProjectUserPersistence;
	@BeanReference(type = WLProjectUserRolePersistence.class)
	protected WLProjectUserRolePersistence wlProjectUserRolePersistence;
	@BeanReference(type = WLTaskPersistence.class)
	protected WLTaskPersistence wlTaskPersistence;
	@BeanReference(type = WLTaskOptionPersistence.class)
	protected WLTaskOptionPersistence wlTaskOptionPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_WLEVENTLOG = "SELECT wlEventLog FROM WLEventLog wlEventLog";
	private static final String _SQL_COUNT_WLEVENTLOG = "SELECT COUNT(wlEventLog) FROM WLEventLog wlEventLog";
	private static final String _ORDER_BY_ENTITY_ALIAS = "wlEventLog.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No WLEventLog exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(WLEventLogPersistenceImpl.class);
	private static WLEventLog _nullWLEventLog = new WLEventLogImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<WLEventLog> toCacheModel() {
				return _nullWLEventLogCacheModel;
			}
		};

	private static CacheModel<WLEventLog> _nullWLEventLogCacheModel = new CacheModel<WLEventLog>() {
			public WLEventLog toEntityModel() {
				return _nullWLEventLog;
			}
		};
}