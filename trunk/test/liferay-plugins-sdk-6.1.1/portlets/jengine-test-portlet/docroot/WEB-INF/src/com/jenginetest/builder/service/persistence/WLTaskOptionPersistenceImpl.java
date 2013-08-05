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

import com.jenginetest.builder.NoSuchTaskOptionException;
import com.jenginetest.builder.model.WLTaskOption;
import com.jenginetest.builder.model.impl.WLTaskOptionImpl;
import com.jenginetest.builder.model.impl.WLTaskOptionModelImpl;

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
import com.liferay.portal.service.persistence.GroupPersistence;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the w l task option service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WLTaskOptionPersistence
 * @see WLTaskOptionUtil
 * @generated
 */
public class WLTaskOptionPersistenceImpl extends BasePersistenceImpl<WLTaskOption>
	implements WLTaskOptionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WLTaskOptionUtil} to access the w l task option persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WLTaskOptionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WLTaskOptionModelImpl.ENTITY_CACHE_ENABLED,
			WLTaskOptionModelImpl.FINDER_CACHE_ENABLED, WLTaskOptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WLTaskOptionModelImpl.ENTITY_CACHE_ENABLED,
			WLTaskOptionModelImpl.FINDER_CACHE_ENABLED, WLTaskOptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WLTaskOptionModelImpl.ENTITY_CACHE_ENABLED,
			WLTaskOptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the w l task option in the entity cache if it is enabled.
	 *
	 * @param wlTaskOption the w l task option
	 */
	public void cacheResult(WLTaskOption wlTaskOption) {
		EntityCacheUtil.putResult(WLTaskOptionModelImpl.ENTITY_CACHE_ENABLED,
			WLTaskOptionImpl.class, wlTaskOption.getPrimaryKey(), wlTaskOption);

		wlTaskOption.resetOriginalValues();
	}

	/**
	 * Caches the w l task options in the entity cache if it is enabled.
	 *
	 * @param wlTaskOptions the w l task options
	 */
	public void cacheResult(List<WLTaskOption> wlTaskOptions) {
		for (WLTaskOption wlTaskOption : wlTaskOptions) {
			if (EntityCacheUtil.getResult(
						WLTaskOptionModelImpl.ENTITY_CACHE_ENABLED,
						WLTaskOptionImpl.class, wlTaskOption.getPrimaryKey()) == null) {
				cacheResult(wlTaskOption);
			}
			else {
				wlTaskOption.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all w l task options.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(WLTaskOptionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(WLTaskOptionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the w l task option.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WLTaskOption wlTaskOption) {
		EntityCacheUtil.removeResult(WLTaskOptionModelImpl.ENTITY_CACHE_ENABLED,
			WLTaskOptionImpl.class, wlTaskOption.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<WLTaskOption> wlTaskOptions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (WLTaskOption wlTaskOption : wlTaskOptions) {
			EntityCacheUtil.removeResult(WLTaskOptionModelImpl.ENTITY_CACHE_ENABLED,
				WLTaskOptionImpl.class, wlTaskOption.getPrimaryKey());
		}
	}

	/**
	 * Creates a new w l task option with the primary key. Does not add the w l task option to the database.
	 *
	 * @param optionId the primary key for the new w l task option
	 * @return the new w l task option
	 */
	public WLTaskOption create(long optionId) {
		WLTaskOption wlTaskOption = new WLTaskOptionImpl();

		wlTaskOption.setNew(true);
		wlTaskOption.setPrimaryKey(optionId);

		return wlTaskOption;
	}

	/**
	 * Removes the w l task option with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param optionId the primary key of the w l task option
	 * @return the w l task option that was removed
	 * @throws com.jenginetest.builder.NoSuchTaskOptionException if a w l task option with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLTaskOption remove(long optionId)
		throws NoSuchTaskOptionException, SystemException {
		return remove(Long.valueOf(optionId));
	}

	/**
	 * Removes the w l task option with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the w l task option
	 * @return the w l task option that was removed
	 * @throws com.jenginetest.builder.NoSuchTaskOptionException if a w l task option with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WLTaskOption remove(Serializable primaryKey)
		throws NoSuchTaskOptionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			WLTaskOption wlTaskOption = (WLTaskOption)session.get(WLTaskOptionImpl.class,
					primaryKey);

			if (wlTaskOption == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTaskOptionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(wlTaskOption);
		}
		catch (NoSuchTaskOptionException nsee) {
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
	protected WLTaskOption removeImpl(WLTaskOption wlTaskOption)
		throws SystemException {
		wlTaskOption = toUnwrappedModel(wlTaskOption);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, wlTaskOption);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(wlTaskOption);

		return wlTaskOption;
	}

	@Override
	public WLTaskOption updateImpl(
		com.jenginetest.builder.model.WLTaskOption wlTaskOption, boolean merge)
		throws SystemException {
		wlTaskOption = toUnwrappedModel(wlTaskOption);

		boolean isNew = wlTaskOption.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, wlTaskOption, merge);

			wlTaskOption.setNew(false);
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

		EntityCacheUtil.putResult(WLTaskOptionModelImpl.ENTITY_CACHE_ENABLED,
			WLTaskOptionImpl.class, wlTaskOption.getPrimaryKey(), wlTaskOption);

		return wlTaskOption;
	}

	protected WLTaskOption toUnwrappedModel(WLTaskOption wlTaskOption) {
		if (wlTaskOption instanceof WLTaskOptionImpl) {
			return wlTaskOption;
		}

		WLTaskOptionImpl wlTaskOptionImpl = new WLTaskOptionImpl();

		wlTaskOptionImpl.setNew(wlTaskOption.isNew());
		wlTaskOptionImpl.setPrimaryKey(wlTaskOption.getPrimaryKey());

		wlTaskOptionImpl.setOptionId(wlTaskOption.getOptionId());
		wlTaskOptionImpl.setGroupId(wlTaskOption.getGroupId());
		wlTaskOptionImpl.setCompanyId(wlTaskOption.getCompanyId());
		wlTaskOptionImpl.setCreateUserId(wlTaskOption.getCreateUserId());
		wlTaskOptionImpl.setCreateUserName(wlTaskOption.getCreateUserName());
		wlTaskOptionImpl.setCreateDate(wlTaskOption.getCreateDate());
		wlTaskOptionImpl.setModifiedUserId(wlTaskOption.getModifiedUserId());
		wlTaskOptionImpl.setModifiedUserName(wlTaskOption.getModifiedUserName());
		wlTaskOptionImpl.setModifiedDate(wlTaskOption.getModifiedDate());
		wlTaskOptionImpl.setTaskId(wlTaskOption.getTaskId());
		wlTaskOptionImpl.setName(wlTaskOption.getName());
		wlTaskOptionImpl.setData(wlTaskOption.getData());

		return wlTaskOptionImpl;
	}

	/**
	 * Returns the w l task option with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the w l task option
	 * @return the w l task option
	 * @throws com.liferay.portal.NoSuchModelException if a w l task option with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WLTaskOption findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the w l task option with the primary key or throws a {@link com.jenginetest.builder.NoSuchTaskOptionException} if it could not be found.
	 *
	 * @param optionId the primary key of the w l task option
	 * @return the w l task option
	 * @throws com.jenginetest.builder.NoSuchTaskOptionException if a w l task option with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLTaskOption findByPrimaryKey(long optionId)
		throws NoSuchTaskOptionException, SystemException {
		WLTaskOption wlTaskOption = fetchByPrimaryKey(optionId);

		if (wlTaskOption == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + optionId);
			}

			throw new NoSuchTaskOptionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				optionId);
		}

		return wlTaskOption;
	}

	/**
	 * Returns the w l task option with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the w l task option
	 * @return the w l task option, or <code>null</code> if a w l task option with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WLTaskOption fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the w l task option with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param optionId the primary key of the w l task option
	 * @return the w l task option, or <code>null</code> if a w l task option with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLTaskOption fetchByPrimaryKey(long optionId)
		throws SystemException {
		WLTaskOption wlTaskOption = (WLTaskOption)EntityCacheUtil.getResult(WLTaskOptionModelImpl.ENTITY_CACHE_ENABLED,
				WLTaskOptionImpl.class, optionId);

		if (wlTaskOption == _nullWLTaskOption) {
			return null;
		}

		if (wlTaskOption == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				wlTaskOption = (WLTaskOption)session.get(WLTaskOptionImpl.class,
						Long.valueOf(optionId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (wlTaskOption != null) {
					cacheResult(wlTaskOption);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(WLTaskOptionModelImpl.ENTITY_CACHE_ENABLED,
						WLTaskOptionImpl.class, optionId, _nullWLTaskOption);
				}

				closeSession(session);
			}
		}

		return wlTaskOption;
	}

	/**
	 * Returns all the w l task options.
	 *
	 * @return the w l task options
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLTaskOption> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the w l task options.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of w l task options
	 * @param end the upper bound of the range of w l task options (not inclusive)
	 * @return the range of w l task options
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLTaskOption> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the w l task options.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of w l task options
	 * @param end the upper bound of the range of w l task options (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of w l task options
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLTaskOption> findAll(int start, int end,
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

		List<WLTaskOption> list = (List<WLTaskOption>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_WLTASKOPTION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WLTASKOPTION;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<WLTaskOption>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<WLTaskOption>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the w l task options from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (WLTaskOption wlTaskOption : findAll()) {
			remove(wlTaskOption);
		}
	}

	/**
	 * Returns the number of w l task options.
	 *
	 * @return the number of w l task options
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_WLTASKOPTION);

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
	 * Initializes the w l task option persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.jenginetest.builder.model.WLTaskOption")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<WLTaskOption>> listenersList = new ArrayList<ModelListener<WLTaskOption>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<WLTaskOption>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(WLTaskOptionImpl.class.getName());
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
	@BeanReference(type = GroupPersistence.class)
	protected GroupPersistence groupPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_WLTASKOPTION = "SELECT wlTaskOption FROM WLTaskOption wlTaskOption";
	private static final String _SQL_COUNT_WLTASKOPTION = "SELECT COUNT(wlTaskOption) FROM WLTaskOption wlTaskOption";
	private static final String _ORDER_BY_ENTITY_ALIAS = "wlTaskOption.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No WLTaskOption exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(WLTaskOptionPersistenceImpl.class);
	private static WLTaskOption _nullWLTaskOption = new WLTaskOptionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<WLTaskOption> toCacheModel() {
				return _nullWLTaskOptionCacheModel;
			}
		};

	private static CacheModel<WLTaskOption> _nullWLTaskOptionCacheModel = new CacheModel<WLTaskOption>() {
			public WLTaskOption toEntityModel() {
				return _nullWLTaskOption;
			}
		};
}