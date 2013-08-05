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

import com.jenginetest.builder.NoSuchEntryException;
import com.jenginetest.builder.model.WLEntry;
import com.jenginetest.builder.model.impl.WLEntryImpl;
import com.jenginetest.builder.model.impl.WLEntryModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.portlet.asset.service.persistence.AssetCategoryPersistence;
import com.liferay.portlet.asset.service.persistence.AssetEntryPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * The persistence implementation for the w l entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WLEntryPersistence
 * @see WLEntryUtil
 * @generated
 */
public class WLEntryPersistenceImpl extends BasePersistenceImpl<WLEntry>
	implements WLEntryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WLEntryUtil} to access the w l entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WLEntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TASKID = new FinderPath(WLEntryModelImpl.ENTITY_CACHE_ENABLED,
			WLEntryModelImpl.FINDER_CACHE_ENABLED, WLEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTaskId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TASKID =
		new FinderPath(WLEntryModelImpl.ENTITY_CACHE_ENABLED,
			WLEntryModelImpl.FINDER_CACHE_ENABLED, WLEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTaskId",
			new String[] { Long.class.getName() },
			WLEntryModelImpl.TASKID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TASKID = new FinderPath(WLEntryModelImpl.ENTITY_CACHE_ENABLED,
			WLEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTaskId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_T_ED = new FinderPath(WLEntryModelImpl.ENTITY_CACHE_ENABLED,
			WLEntryModelImpl.FINDER_CACHE_ENABLED, WLEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByT_ED",
			new String[] {
				Long.class.getName(), Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_ED = new FinderPath(WLEntryModelImpl.ENTITY_CACHE_ENABLED,
			WLEntryModelImpl.FINDER_CACHE_ENABLED, WLEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByT_ED",
			new String[] { Long.class.getName(), Date.class.getName() },
			WLEntryModelImpl.TASKID_COLUMN_BITMASK |
			WLEntryModelImpl.ENTRYDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_T_ED = new FinderPath(WLEntryModelImpl.ENTITY_CACHE_ENABLED,
			WLEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByT_ED",
			new String[] { Long.class.getName(), Date.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LESSDATE = new FinderPath(WLEntryModelImpl.ENTITY_CACHE_ENABLED,
			WLEntryModelImpl.FINDER_CACHE_ENABLED, WLEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLessDate",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_LESSDATE =
		new FinderPath(WLEntryModelImpl.ENTITY_CACHE_ENABLED,
			WLEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByLessDate",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WLEntryModelImpl.ENTITY_CACHE_ENABLED,
			WLEntryModelImpl.FINDER_CACHE_ENABLED, WLEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WLEntryModelImpl.ENTITY_CACHE_ENABLED,
			WLEntryModelImpl.FINDER_CACHE_ENABLED, WLEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WLEntryModelImpl.ENTITY_CACHE_ENABLED,
			WLEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the w l entry in the entity cache if it is enabled.
	 *
	 * @param wlEntry the w l entry
	 */
	public void cacheResult(WLEntry wlEntry) {
		EntityCacheUtil.putResult(WLEntryModelImpl.ENTITY_CACHE_ENABLED,
			WLEntryImpl.class, wlEntry.getPrimaryKey(), wlEntry);

		wlEntry.resetOriginalValues();
	}

	/**
	 * Caches the w l entries in the entity cache if it is enabled.
	 *
	 * @param wlEntries the w l entries
	 */
	public void cacheResult(List<WLEntry> wlEntries) {
		for (WLEntry wlEntry : wlEntries) {
			if (EntityCacheUtil.getResult(
						WLEntryModelImpl.ENTITY_CACHE_ENABLED,
						WLEntryImpl.class, wlEntry.getPrimaryKey()) == null) {
				cacheResult(wlEntry);
			}
			else {
				wlEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all w l entries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(WLEntryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(WLEntryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the w l entry.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WLEntry wlEntry) {
		EntityCacheUtil.removeResult(WLEntryModelImpl.ENTITY_CACHE_ENABLED,
			WLEntryImpl.class, wlEntry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<WLEntry> wlEntries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (WLEntry wlEntry : wlEntries) {
			EntityCacheUtil.removeResult(WLEntryModelImpl.ENTITY_CACHE_ENABLED,
				WLEntryImpl.class, wlEntry.getPrimaryKey());
		}
	}

	/**
	 * Creates a new w l entry with the primary key. Does not add the w l entry to the database.
	 *
	 * @param entryId the primary key for the new w l entry
	 * @return the new w l entry
	 */
	public WLEntry create(long entryId) {
		WLEntry wlEntry = new WLEntryImpl();

		wlEntry.setNew(true);
		wlEntry.setPrimaryKey(entryId);

		return wlEntry;
	}

	/**
	 * Removes the w l entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entryId the primary key of the w l entry
	 * @return the w l entry that was removed
	 * @throws com.jenginetest.builder.NoSuchEntryException if a w l entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLEntry remove(long entryId)
		throws NoSuchEntryException, SystemException {
		return remove(Long.valueOf(entryId));
	}

	/**
	 * Removes the w l entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the w l entry
	 * @return the w l entry that was removed
	 * @throws com.jenginetest.builder.NoSuchEntryException if a w l entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WLEntry remove(Serializable primaryKey)
		throws NoSuchEntryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			WLEntry wlEntry = (WLEntry)session.get(WLEntryImpl.class, primaryKey);

			if (wlEntry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(wlEntry);
		}
		catch (NoSuchEntryException nsee) {
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
	protected WLEntry removeImpl(WLEntry wlEntry) throws SystemException {
		wlEntry = toUnwrappedModel(wlEntry);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, wlEntry);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(wlEntry);

		return wlEntry;
	}

	@Override
	public WLEntry updateImpl(com.jenginetest.builder.model.WLEntry wlEntry,
		boolean merge) throws SystemException {
		wlEntry = toUnwrappedModel(wlEntry);

		boolean isNew = wlEntry.isNew();

		WLEntryModelImpl wlEntryModelImpl = (WLEntryModelImpl)wlEntry;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, wlEntry, merge);

			wlEntry.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !WLEntryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((wlEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TASKID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(wlEntryModelImpl.getOriginalTaskId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TASKID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TASKID,
					args);

				args = new Object[] { Long.valueOf(wlEntryModelImpl.getTaskId()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TASKID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TASKID,
					args);
			}

			if ((wlEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_ED.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(wlEntryModelImpl.getOriginalTaskId()),
						
						wlEntryModelImpl.getOriginalEntryDate()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_T_ED, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_ED,
					args);

				args = new Object[] {
						Long.valueOf(wlEntryModelImpl.getTaskId()),
						
						wlEntryModelImpl.getEntryDate()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_T_ED, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_ED,
					args);
			}
		}

		EntityCacheUtil.putResult(WLEntryModelImpl.ENTITY_CACHE_ENABLED,
			WLEntryImpl.class, wlEntry.getPrimaryKey(), wlEntry);

		return wlEntry;
	}

	protected WLEntry toUnwrappedModel(WLEntry wlEntry) {
		if (wlEntry instanceof WLEntryImpl) {
			return wlEntry;
		}

		WLEntryImpl wlEntryImpl = new WLEntryImpl();

		wlEntryImpl.setNew(wlEntry.isNew());
		wlEntryImpl.setPrimaryKey(wlEntry.getPrimaryKey());

		wlEntryImpl.setEntryId(wlEntry.getEntryId());
		wlEntryImpl.setCreateUserId(wlEntry.getCreateUserId());
		wlEntryImpl.setCreateUserName(wlEntry.getCreateUserName());
		wlEntryImpl.setCreateDate(wlEntry.getCreateDate());
		wlEntryImpl.setModifiedUserId(wlEntry.getModifiedUserId());
		wlEntryImpl.setModifiedUserName(wlEntry.getModifiedUserName());
		wlEntryImpl.setModifiedDate(wlEntry.getModifiedDate());
		wlEntryImpl.setStart(wlEntry.getStart());
		wlEntryImpl.setStartTime(wlEntry.getStartTime());
		wlEntryImpl.setFinishTime(wlEntry.getFinishTime());
		wlEntryImpl.setEntryDate(wlEntry.getEntryDate());
		wlEntryImpl.setEntryTime(wlEntry.getEntryTime());
		wlEntryImpl.setTimezone(wlEntry.getTimezone());
		wlEntryImpl.setLength(wlEntry.getLength());
		wlEntryImpl.setTaskId(wlEntry.getTaskId());

		return wlEntryImpl;
	}

	/**
	 * Returns the w l entry with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the w l entry
	 * @return the w l entry
	 * @throws com.liferay.portal.NoSuchModelException if a w l entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WLEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the w l entry with the primary key or throws a {@link com.jenginetest.builder.NoSuchEntryException} if it could not be found.
	 *
	 * @param entryId the primary key of the w l entry
	 * @return the w l entry
	 * @throws com.jenginetest.builder.NoSuchEntryException if a w l entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLEntry findByPrimaryKey(long entryId)
		throws NoSuchEntryException, SystemException {
		WLEntry wlEntry = fetchByPrimaryKey(entryId);

		if (wlEntry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + entryId);
			}

			throw new NoSuchEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				entryId);
		}

		return wlEntry;
	}

	/**
	 * Returns the w l entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the w l entry
	 * @return the w l entry, or <code>null</code> if a w l entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WLEntry fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the w l entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entryId the primary key of the w l entry
	 * @return the w l entry, or <code>null</code> if a w l entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLEntry fetchByPrimaryKey(long entryId) throws SystemException {
		WLEntry wlEntry = (WLEntry)EntityCacheUtil.getResult(WLEntryModelImpl.ENTITY_CACHE_ENABLED,
				WLEntryImpl.class, entryId);

		if (wlEntry == _nullWLEntry) {
			return null;
		}

		if (wlEntry == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				wlEntry = (WLEntry)session.get(WLEntryImpl.class,
						Long.valueOf(entryId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (wlEntry != null) {
					cacheResult(wlEntry);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(WLEntryModelImpl.ENTITY_CACHE_ENABLED,
						WLEntryImpl.class, entryId, _nullWLEntry);
				}

				closeSession(session);
			}
		}

		return wlEntry;
	}

	/**
	 * Returns all the w l entries where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @return the matching w l entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLEntry> findByTaskId(long taskId) throws SystemException {
		return findByTaskId(taskId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the w l entries where taskId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param taskId the task ID
	 * @param start the lower bound of the range of w l entries
	 * @param end the upper bound of the range of w l entries (not inclusive)
	 * @return the range of matching w l entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLEntry> findByTaskId(long taskId, int start, int end)
		throws SystemException {
		return findByTaskId(taskId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the w l entries where taskId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param taskId the task ID
	 * @param start the lower bound of the range of w l entries
	 * @param end the upper bound of the range of w l entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching w l entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLEntry> findByTaskId(long taskId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TASKID;
			finderArgs = new Object[] { taskId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TASKID;
			finderArgs = new Object[] { taskId, start, end, orderByComparator };
		}

		List<WLEntry> list = (List<WLEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (WLEntry wlEntry : list) {
				if ((taskId != wlEntry.getTaskId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_WLENTRY_WHERE);

			query.append(_FINDER_COLUMN_TASKID_TASKID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(WLEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(taskId);

				list = (List<WLEntry>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first w l entry in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching w l entry
	 * @throws com.jenginetest.builder.NoSuchEntryException if a matching w l entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLEntry findByTaskId_First(long taskId,
		OrderByComparator orderByComparator)
		throws NoSuchEntryException, SystemException {
		WLEntry wlEntry = fetchByTaskId_First(taskId, orderByComparator);

		if (wlEntry != null) {
			return wlEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("taskId=");
		msg.append(taskId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the first w l entry in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching w l entry, or <code>null</code> if a matching w l entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLEntry fetchByTaskId_First(long taskId,
		OrderByComparator orderByComparator) throws SystemException {
		List<WLEntry> list = findByTaskId(taskId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last w l entry in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching w l entry
	 * @throws com.jenginetest.builder.NoSuchEntryException if a matching w l entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLEntry findByTaskId_Last(long taskId,
		OrderByComparator orderByComparator)
		throws NoSuchEntryException, SystemException {
		WLEntry wlEntry = fetchByTaskId_Last(taskId, orderByComparator);

		if (wlEntry != null) {
			return wlEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("taskId=");
		msg.append(taskId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the last w l entry in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching w l entry, or <code>null</code> if a matching w l entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLEntry fetchByTaskId_Last(long taskId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTaskId(taskId);

		List<WLEntry> list = findByTaskId(taskId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the w l entries before and after the current w l entry in the ordered set where taskId = &#63;.
	 *
	 * @param entryId the primary key of the current w l entry
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next w l entry
	 * @throws com.jenginetest.builder.NoSuchEntryException if a w l entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLEntry[] findByTaskId_PrevAndNext(long entryId, long taskId,
		OrderByComparator orderByComparator)
		throws NoSuchEntryException, SystemException {
		WLEntry wlEntry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			WLEntry[] array = new WLEntryImpl[3];

			array[0] = getByTaskId_PrevAndNext(session, wlEntry, taskId,
					orderByComparator, true);

			array[1] = wlEntry;

			array[2] = getByTaskId_PrevAndNext(session, wlEntry, taskId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WLEntry getByTaskId_PrevAndNext(Session session, WLEntry wlEntry,
		long taskId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WLENTRY_WHERE);

		query.append(_FINDER_COLUMN_TASKID_TASKID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(WLEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(taskId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wlEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WLEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the w l entries where taskId = &#63; and entryDate = &#63;.
	 *
	 * @param taskId the task ID
	 * @param entryDate the entry date
	 * @return the matching w l entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLEntry> findByT_ED(long taskId, Date entryDate)
		throws SystemException {
		return findByT_ED(taskId, entryDate, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the w l entries where taskId = &#63; and entryDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param taskId the task ID
	 * @param entryDate the entry date
	 * @param start the lower bound of the range of w l entries
	 * @param end the upper bound of the range of w l entries (not inclusive)
	 * @return the range of matching w l entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLEntry> findByT_ED(long taskId, Date entryDate, int start,
		int end) throws SystemException {
		return findByT_ED(taskId, entryDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the w l entries where taskId = &#63; and entryDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param taskId the task ID
	 * @param entryDate the entry date
	 * @param start the lower bound of the range of w l entries
	 * @param end the upper bound of the range of w l entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching w l entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLEntry> findByT_ED(long taskId, Date entryDate, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_ED;
			finderArgs = new Object[] { taskId, entryDate };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_T_ED;
			finderArgs = new Object[] {
					taskId, entryDate,
					
					start, end, orderByComparator
				};
		}

		List<WLEntry> list = (List<WLEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (WLEntry wlEntry : list) {
				if ((taskId != wlEntry.getTaskId()) ||
						!Validator.equals(entryDate, wlEntry.getEntryDate())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_WLENTRY_WHERE);

			query.append(_FINDER_COLUMN_T_ED_TASKID_2);

			if (entryDate == null) {
				query.append(_FINDER_COLUMN_T_ED_ENTRYDATE_1);
			}
			else {
				query.append(_FINDER_COLUMN_T_ED_ENTRYDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(WLEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(taskId);

				if (entryDate != null) {
					qPos.add(CalendarUtil.getTimestamp(entryDate));
				}

				list = (List<WLEntry>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first w l entry in the ordered set where taskId = &#63; and entryDate = &#63;.
	 *
	 * @param taskId the task ID
	 * @param entryDate the entry date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching w l entry
	 * @throws com.jenginetest.builder.NoSuchEntryException if a matching w l entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLEntry findByT_ED_First(long taskId, Date entryDate,
		OrderByComparator orderByComparator)
		throws NoSuchEntryException, SystemException {
		WLEntry wlEntry = fetchByT_ED_First(taskId, entryDate, orderByComparator);

		if (wlEntry != null) {
			return wlEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("taskId=");
		msg.append(taskId);

		msg.append(", entryDate=");
		msg.append(entryDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the first w l entry in the ordered set where taskId = &#63; and entryDate = &#63;.
	 *
	 * @param taskId the task ID
	 * @param entryDate the entry date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching w l entry, or <code>null</code> if a matching w l entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLEntry fetchByT_ED_First(long taskId, Date entryDate,
		OrderByComparator orderByComparator) throws SystemException {
		List<WLEntry> list = findByT_ED(taskId, entryDate, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last w l entry in the ordered set where taskId = &#63; and entryDate = &#63;.
	 *
	 * @param taskId the task ID
	 * @param entryDate the entry date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching w l entry
	 * @throws com.jenginetest.builder.NoSuchEntryException if a matching w l entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLEntry findByT_ED_Last(long taskId, Date entryDate,
		OrderByComparator orderByComparator)
		throws NoSuchEntryException, SystemException {
		WLEntry wlEntry = fetchByT_ED_Last(taskId, entryDate, orderByComparator);

		if (wlEntry != null) {
			return wlEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("taskId=");
		msg.append(taskId);

		msg.append(", entryDate=");
		msg.append(entryDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the last w l entry in the ordered set where taskId = &#63; and entryDate = &#63;.
	 *
	 * @param taskId the task ID
	 * @param entryDate the entry date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching w l entry, or <code>null</code> if a matching w l entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLEntry fetchByT_ED_Last(long taskId, Date entryDate,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByT_ED(taskId, entryDate);

		List<WLEntry> list = findByT_ED(taskId, entryDate, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the w l entries before and after the current w l entry in the ordered set where taskId = &#63; and entryDate = &#63;.
	 *
	 * @param entryId the primary key of the current w l entry
	 * @param taskId the task ID
	 * @param entryDate the entry date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next w l entry
	 * @throws com.jenginetest.builder.NoSuchEntryException if a w l entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLEntry[] findByT_ED_PrevAndNext(long entryId, long taskId,
		Date entryDate, OrderByComparator orderByComparator)
		throws NoSuchEntryException, SystemException {
		WLEntry wlEntry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			WLEntry[] array = new WLEntryImpl[3];

			array[0] = getByT_ED_PrevAndNext(session, wlEntry, taskId,
					entryDate, orderByComparator, true);

			array[1] = wlEntry;

			array[2] = getByT_ED_PrevAndNext(session, wlEntry, taskId,
					entryDate, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WLEntry getByT_ED_PrevAndNext(Session session, WLEntry wlEntry,
		long taskId, Date entryDate, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WLENTRY_WHERE);

		query.append(_FINDER_COLUMN_T_ED_TASKID_2);

		if (entryDate == null) {
			query.append(_FINDER_COLUMN_T_ED_ENTRYDATE_1);
		}
		else {
			query.append(_FINDER_COLUMN_T_ED_ENTRYDATE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(WLEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(taskId);

		if (entryDate != null) {
			qPos.add(CalendarUtil.getTimestamp(entryDate));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wlEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WLEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the w l entries where entryDate &lt; &#63;.
	 *
	 * @param entryDate the entry date
	 * @return the matching w l entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLEntry> findByLessDate(Date entryDate)
		throws SystemException {
		return findByLessDate(entryDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the w l entries where entryDate &lt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param entryDate the entry date
	 * @param start the lower bound of the range of w l entries
	 * @param end the upper bound of the range of w l entries (not inclusive)
	 * @return the range of matching w l entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLEntry> findByLessDate(Date entryDate, int start, int end)
		throws SystemException {
		return findByLessDate(entryDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the w l entries where entryDate &lt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param entryDate the entry date
	 * @param start the lower bound of the range of w l entries
	 * @param end the upper bound of the range of w l entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching w l entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLEntry> findByLessDate(Date entryDate, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LESSDATE;
		finderArgs = new Object[] { entryDate, start, end, orderByComparator };

		List<WLEntry> list = (List<WLEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (WLEntry wlEntry : list) {
				if (!Validator.equals(entryDate, wlEntry.getEntryDate())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_WLENTRY_WHERE);

			if (entryDate == null) {
				query.append(_FINDER_COLUMN_LESSDATE_ENTRYDATE_1);
			}
			else {
				query.append(_FINDER_COLUMN_LESSDATE_ENTRYDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(WLEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (entryDate != null) {
					qPos.add(CalendarUtil.getTimestamp(entryDate));
				}

				list = (List<WLEntry>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first w l entry in the ordered set where entryDate &lt; &#63;.
	 *
	 * @param entryDate the entry date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching w l entry
	 * @throws com.jenginetest.builder.NoSuchEntryException if a matching w l entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLEntry findByLessDate_First(Date entryDate,
		OrderByComparator orderByComparator)
		throws NoSuchEntryException, SystemException {
		WLEntry wlEntry = fetchByLessDate_First(entryDate, orderByComparator);

		if (wlEntry != null) {
			return wlEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("entryDate=");
		msg.append(entryDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the first w l entry in the ordered set where entryDate &lt; &#63;.
	 *
	 * @param entryDate the entry date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching w l entry, or <code>null</code> if a matching w l entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLEntry fetchByLessDate_First(Date entryDate,
		OrderByComparator orderByComparator) throws SystemException {
		List<WLEntry> list = findByLessDate(entryDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last w l entry in the ordered set where entryDate &lt; &#63;.
	 *
	 * @param entryDate the entry date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching w l entry
	 * @throws com.jenginetest.builder.NoSuchEntryException if a matching w l entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLEntry findByLessDate_Last(Date entryDate,
		OrderByComparator orderByComparator)
		throws NoSuchEntryException, SystemException {
		WLEntry wlEntry = fetchByLessDate_Last(entryDate, orderByComparator);

		if (wlEntry != null) {
			return wlEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("entryDate=");
		msg.append(entryDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the last w l entry in the ordered set where entryDate &lt; &#63;.
	 *
	 * @param entryDate the entry date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching w l entry, or <code>null</code> if a matching w l entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLEntry fetchByLessDate_Last(Date entryDate,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByLessDate(entryDate);

		List<WLEntry> list = findByLessDate(entryDate, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the w l entries before and after the current w l entry in the ordered set where entryDate &lt; &#63;.
	 *
	 * @param entryId the primary key of the current w l entry
	 * @param entryDate the entry date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next w l entry
	 * @throws com.jenginetest.builder.NoSuchEntryException if a w l entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLEntry[] findByLessDate_PrevAndNext(long entryId, Date entryDate,
		OrderByComparator orderByComparator)
		throws NoSuchEntryException, SystemException {
		WLEntry wlEntry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			WLEntry[] array = new WLEntryImpl[3];

			array[0] = getByLessDate_PrevAndNext(session, wlEntry, entryDate,
					orderByComparator, true);

			array[1] = wlEntry;

			array[2] = getByLessDate_PrevAndNext(session, wlEntry, entryDate,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WLEntry getByLessDate_PrevAndNext(Session session,
		WLEntry wlEntry, Date entryDate, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WLENTRY_WHERE);

		if (entryDate == null) {
			query.append(_FINDER_COLUMN_LESSDATE_ENTRYDATE_1);
		}
		else {
			query.append(_FINDER_COLUMN_LESSDATE_ENTRYDATE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(WLEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (entryDate != null) {
			qPos.add(CalendarUtil.getTimestamp(entryDate));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wlEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WLEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the w l entries.
	 *
	 * @return the w l entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLEntry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the w l entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of w l entries
	 * @param end the upper bound of the range of w l entries (not inclusive)
	 * @return the range of w l entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLEntry> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the w l entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of w l entries
	 * @param end the upper bound of the range of w l entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of w l entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLEntry> findAll(int start, int end,
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

		List<WLEntry> list = (List<WLEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_WLENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WLENTRY.concat(WLEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<WLEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<WLEntry>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the w l entries where taskId = &#63; from the database.
	 *
	 * @param taskId the task ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTaskId(long taskId) throws SystemException {
		for (WLEntry wlEntry : findByTaskId(taskId)) {
			remove(wlEntry);
		}
	}

	/**
	 * Removes all the w l entries where taskId = &#63; and entryDate = &#63; from the database.
	 *
	 * @param taskId the task ID
	 * @param entryDate the entry date
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByT_ED(long taskId, Date entryDate)
		throws SystemException {
		for (WLEntry wlEntry : findByT_ED(taskId, entryDate)) {
			remove(wlEntry);
		}
	}

	/**
	 * Removes all the w l entries where entryDate &lt; &#63; from the database.
	 *
	 * @param entryDate the entry date
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByLessDate(Date entryDate) throws SystemException {
		for (WLEntry wlEntry : findByLessDate(entryDate)) {
			remove(wlEntry);
		}
	}

	/**
	 * Removes all the w l entries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (WLEntry wlEntry : findAll()) {
			remove(wlEntry);
		}
	}

	/**
	 * Returns the number of w l entries where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @return the number of matching w l entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTaskId(long taskId) throws SystemException {
		Object[] finderArgs = new Object[] { taskId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TASKID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WLENTRY_WHERE);

			query.append(_FINDER_COLUMN_TASKID_TASKID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(taskId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TASKID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of w l entries where taskId = &#63; and entryDate = &#63;.
	 *
	 * @param taskId the task ID
	 * @param entryDate the entry date
	 * @return the number of matching w l entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByT_ED(long taskId, Date entryDate)
		throws SystemException {
		Object[] finderArgs = new Object[] { taskId, entryDate };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_T_ED,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_WLENTRY_WHERE);

			query.append(_FINDER_COLUMN_T_ED_TASKID_2);

			if (entryDate == null) {
				query.append(_FINDER_COLUMN_T_ED_ENTRYDATE_1);
			}
			else {
				query.append(_FINDER_COLUMN_T_ED_ENTRYDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(taskId);

				if (entryDate != null) {
					qPos.add(CalendarUtil.getTimestamp(entryDate));
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_T_ED,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of w l entries where entryDate &lt; &#63;.
	 *
	 * @param entryDate the entry date
	 * @return the number of matching w l entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByLessDate(Date entryDate) throws SystemException {
		Object[] finderArgs = new Object[] { entryDate };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_LESSDATE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WLENTRY_WHERE);

			if (entryDate == null) {
				query.append(_FINDER_COLUMN_LESSDATE_ENTRYDATE_1);
			}
			else {
				query.append(_FINDER_COLUMN_LESSDATE_ENTRYDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (entryDate != null) {
					qPos.add(CalendarUtil.getTimestamp(entryDate));
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_LESSDATE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of w l entries.
	 *
	 * @return the number of w l entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_WLENTRY);

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
	 * Initializes the w l entry persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.jenginetest.builder.model.WLEntry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<WLEntry>> listenersList = new ArrayList<ModelListener<WLEntry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<WLEntry>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(WLEntryImpl.class.getName());
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
	@BeanReference(type = AssetCategoryPersistence.class)
	protected AssetCategoryPersistence assetCategoryPersistence;
	@BeanReference(type = AssetEntryPersistence.class)
	protected AssetEntryPersistence assetEntryPersistence;
	private static final String _SQL_SELECT_WLENTRY = "SELECT wlEntry FROM WLEntry wlEntry";
	private static final String _SQL_SELECT_WLENTRY_WHERE = "SELECT wlEntry FROM WLEntry wlEntry WHERE ";
	private static final String _SQL_COUNT_WLENTRY = "SELECT COUNT(wlEntry) FROM WLEntry wlEntry";
	private static final String _SQL_COUNT_WLENTRY_WHERE = "SELECT COUNT(wlEntry) FROM WLEntry wlEntry WHERE ";
	private static final String _FINDER_COLUMN_TASKID_TASKID_2 = "wlEntry.taskId = ?";
	private static final String _FINDER_COLUMN_T_ED_TASKID_2 = "wlEntry.taskId = ? AND ";
	private static final String _FINDER_COLUMN_T_ED_ENTRYDATE_1 = "wlEntry.entryDate IS NULL";
	private static final String _FINDER_COLUMN_T_ED_ENTRYDATE_2 = "wlEntry.entryDate = ?";
	private static final String _FINDER_COLUMN_LESSDATE_ENTRYDATE_1 = "wlEntry.entryDate < NULL";
	private static final String _FINDER_COLUMN_LESSDATE_ENTRYDATE_2 = "wlEntry.entryDate < ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "wlEntry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No WLEntry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No WLEntry exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(WLEntryPersistenceImpl.class);
	private static WLEntry _nullWLEntry = new WLEntryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<WLEntry> toCacheModel() {
				return _nullWLEntryCacheModel;
			}
		};

	private static CacheModel<WLEntry> _nullWLEntryCacheModel = new CacheModel<WLEntry>() {
			public WLEntry toEntityModel() {
				return _nullWLEntry;
			}
		};
}