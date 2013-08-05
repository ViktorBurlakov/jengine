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

import com.jenginetest.builder.NoSuchTaskException;
import com.jenginetest.builder.model.WLTask;
import com.jenginetest.builder.model.impl.WLTaskImpl;
import com.jenginetest.builder.model.impl.WLTaskModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQuery;
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQueryFactoryUtil;
import com.liferay.portal.kernel.dao.jdbc.RowMapper;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.GroupPersistence;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.portlet.asset.service.persistence.AssetEntryPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the w l task service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WLTaskPersistence
 * @see WLTaskUtil
 * @generated
 */
public class WLTaskPersistenceImpl extends BasePersistenceImpl<WLTask>
	implements WLTaskPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WLTaskUtil} to access the w l task persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WLTaskImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_S_W_P = new FinderPath(WLTaskModelImpl.ENTITY_CACHE_ENABLED,
			WLTaskModelImpl.FINDER_CACHE_ENABLED, WLTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByS_W_P",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_W_P = new FinderPath(WLTaskModelImpl.ENTITY_CACHE_ENABLED,
			WLTaskModelImpl.FINDER_CACHE_ENABLED, WLTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByS_W_P",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Long.class.getName()
			},
			WLTaskModelImpl.SUBJECT_COLUMN_BITMASK |
			WLTaskModelImpl.WORKERID_COLUMN_BITMASK |
			WLTaskModelImpl.PROJECTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_S_W_P = new FinderPath(WLTaskModelImpl.ENTITY_CACHE_ENABLED,
			WLTaskModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByS_W_P",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Long.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_O_G_C_S_P_W =
		new FinderPath(WLTaskModelImpl.ENTITY_CACHE_ENABLED,
			WLTaskModelImpl.FINDER_CACHE_ENABLED, WLTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByO_G_C_S_P_W",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				String.class.getName(), Long.class.getName(),
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_O_G_C_S_P_W =
		new FinderPath(WLTaskModelImpl.ENTITY_CACHE_ENABLED,
			WLTaskModelImpl.FINDER_CACHE_ENABLED, WLTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByO_G_C_S_P_W",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				String.class.getName(), Long.class.getName(),
				Long.class.getName()
			},
			WLTaskModelImpl.OWNERID_COLUMN_BITMASK |
			WLTaskModelImpl.GROUPID_COLUMN_BITMASK |
			WLTaskModelImpl.COMPANYID_COLUMN_BITMASK |
			WLTaskModelImpl.SUBJECT_COLUMN_BITMASK |
			WLTaskModelImpl.PROJECTID_COLUMN_BITMASK |
			WLTaskModelImpl.WORKERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_O_G_C_S_P_W = new FinderPath(WLTaskModelImpl.ENTITY_CACHE_ENABLED,
			WLTaskModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByO_G_C_S_P_W",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				String.class.getName(), Long.class.getName(),
				Long.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_O_G_C_S_E_P_W =
		new FinderPath(WLTaskModelImpl.ENTITY_CACHE_ENABLED,
			WLTaskModelImpl.FINDER_CACHE_ENABLED, WLTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByO_G_C_S_E_P_W",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				String.class.getName(), String.class.getName(),
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_O_G_C_S_E_P_W =
		new FinderPath(WLTaskModelImpl.ENTITY_CACHE_ENABLED,
			WLTaskModelImpl.FINDER_CACHE_ENABLED, WLTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByO_G_C_S_E_P_W",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				String.class.getName(), String.class.getName(),
				Long.class.getName(), Long.class.getName()
			},
			WLTaskModelImpl.OWNERID_COLUMN_BITMASK |
			WLTaskModelImpl.GROUPID_COLUMN_BITMASK |
			WLTaskModelImpl.COMPANYID_COLUMN_BITMASK |
			WLTaskModelImpl.SUBJECT_COLUMN_BITMASK |
			WLTaskModelImpl.EXTERNALID_COLUMN_BITMASK |
			WLTaskModelImpl.PROJECTID_COLUMN_BITMASK |
			WLTaskModelImpl.WORKERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_O_G_C_S_E_P_W = new FinderPath(WLTaskModelImpl.ENTITY_CACHE_ENABLED,
			WLTaskModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByO_G_C_S_E_P_W",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				String.class.getName(), String.class.getName(),
				Long.class.getName(), Long.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_O_G_C = new FinderPath(WLTaskModelImpl.ENTITY_CACHE_ENABLED,
			WLTaskModelImpl.FINDER_CACHE_ENABLED, WLTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByO_G_C",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_O_G_C = new FinderPath(WLTaskModelImpl.ENTITY_CACHE_ENABLED,
			WLTaskModelImpl.FINDER_CACHE_ENABLED, WLTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByO_G_C",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			WLTaskModelImpl.OWNERID_COLUMN_BITMASK |
			WLTaskModelImpl.GROUPID_COLUMN_BITMASK |
			WLTaskModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_O_G_C = new FinderPath(WLTaskModelImpl.ENTITY_CACHE_ENABLED,
			WLTaskModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByO_G_C",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_O_G_C_SP = new FinderPath(WLTaskModelImpl.ENTITY_CACHE_ENABLED,
			WLTaskModelImpl.FINDER_CACHE_ENABLED, WLTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByO_G_C_SP",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_O_G_C_SP =
		new FinderPath(WLTaskModelImpl.ENTITY_CACHE_ENABLED,
			WLTaskModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByO_G_C_SP",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_O_G_C_SP_P =
		new FinderPath(WLTaskModelImpl.ENTITY_CACHE_ENABLED,
			WLTaskModelImpl.FINDER_CACHE_ENABLED, WLTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByO_G_C_SP_P",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				String.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_O_G_C_SP_P =
		new FinderPath(WLTaskModelImpl.ENTITY_CACHE_ENABLED,
			WLTaskModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByO_G_C_SP_P",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				String.class.getName(), Long.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_O_G_C_SP_W =
		new FinderPath(WLTaskModelImpl.ENTITY_CACHE_ENABLED,
			WLTaskModelImpl.FINDER_CACHE_ENABLED, WLTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByO_G_C_SP_W",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				String.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_O_G_C_SP_W =
		new FinderPath(WLTaskModelImpl.ENTITY_CACHE_ENABLED,
			WLTaskModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByO_G_C_SP_W",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				String.class.getName(), Long.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_O_G_C_SP_P_W =
		new FinderPath(WLTaskModelImpl.ENTITY_CACHE_ENABLED,
			WLTaskModelImpl.FINDER_CACHE_ENABLED, WLTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByO_G_C_SP_P_W",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				String.class.getName(), Long.class.getName(),
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_O_G_C_SP_P_W =
		new FinderPath(WLTaskModelImpl.ENTITY_CACHE_ENABLED,
			WLTaskModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByO_G_C_SP_P_W",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				String.class.getName(), Long.class.getName(),
				Long.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WLTaskModelImpl.ENTITY_CACHE_ENABLED,
			WLTaskModelImpl.FINDER_CACHE_ENABLED, WLTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WLTaskModelImpl.ENTITY_CACHE_ENABLED,
			WLTaskModelImpl.FINDER_CACHE_ENABLED, WLTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WLTaskModelImpl.ENTITY_CACHE_ENABLED,
			WLTaskModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the w l task in the entity cache if it is enabled.
	 *
	 * @param wlTask the w l task
	 */
	public void cacheResult(WLTask wlTask) {
		EntityCacheUtil.putResult(WLTaskModelImpl.ENTITY_CACHE_ENABLED,
			WLTaskImpl.class, wlTask.getPrimaryKey(), wlTask);

		wlTask.resetOriginalValues();
	}

	/**
	 * Caches the w l tasks in the entity cache if it is enabled.
	 *
	 * @param wlTasks the w l tasks
	 */
	public void cacheResult(List<WLTask> wlTasks) {
		for (WLTask wlTask : wlTasks) {
			if (EntityCacheUtil.getResult(
						WLTaskModelImpl.ENTITY_CACHE_ENABLED, WLTaskImpl.class,
						wlTask.getPrimaryKey()) == null) {
				cacheResult(wlTask);
			}
			else {
				wlTask.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all w l tasks.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(WLTaskImpl.class.getName());
		}

		EntityCacheUtil.clearCache(WLTaskImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the w l task.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WLTask wlTask) {
		EntityCacheUtil.removeResult(WLTaskModelImpl.ENTITY_CACHE_ENABLED,
			WLTaskImpl.class, wlTask.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<WLTask> wlTasks) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (WLTask wlTask : wlTasks) {
			EntityCacheUtil.removeResult(WLTaskModelImpl.ENTITY_CACHE_ENABLED,
				WLTaskImpl.class, wlTask.getPrimaryKey());
		}
	}

	/**
	 * Creates a new w l task with the primary key. Does not add the w l task to the database.
	 *
	 * @param taskId the primary key for the new w l task
	 * @return the new w l task
	 */
	public WLTask create(long taskId) {
		WLTask wlTask = new WLTaskImpl();

		wlTask.setNew(true);
		wlTask.setPrimaryKey(taskId);

		return wlTask;
	}

	/**
	 * Removes the w l task with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskId the primary key of the w l task
	 * @return the w l task that was removed
	 * @throws com.jenginetest.builder.NoSuchTaskException if a w l task with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLTask remove(long taskId)
		throws NoSuchTaskException, SystemException {
		return remove(Long.valueOf(taskId));
	}

	/**
	 * Removes the w l task with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the w l task
	 * @return the w l task that was removed
	 * @throws com.jenginetest.builder.NoSuchTaskException if a w l task with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WLTask remove(Serializable primaryKey)
		throws NoSuchTaskException, SystemException {
		Session session = null;

		try {
			session = openSession();

			WLTask wlTask = (WLTask)session.get(WLTaskImpl.class, primaryKey);

			if (wlTask == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTaskException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(wlTask);
		}
		catch (NoSuchTaskException nsee) {
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
	protected WLTask removeImpl(WLTask wlTask) throws SystemException {
		wlTask = toUnwrappedModel(wlTask);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, wlTask);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(wlTask);

		return wlTask;
	}

	@Override
	public WLTask updateImpl(com.jenginetest.builder.model.WLTask wlTask,
		boolean merge) throws SystemException {
		wlTask = toUnwrappedModel(wlTask);

		boolean isNew = wlTask.isNew();

		WLTaskModelImpl wlTaskModelImpl = (WLTaskModelImpl)wlTask;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, wlTask, merge);

			wlTask.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !WLTaskModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((wlTaskModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_W_P.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						wlTaskModelImpl.getOriginalSubject(),
						Long.valueOf(wlTaskModelImpl.getOriginalWorkerId()),
						Long.valueOf(wlTaskModelImpl.getOriginalProjectId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_S_W_P, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_W_P,
					args);

				args = new Object[] {
						wlTaskModelImpl.getSubject(),
						Long.valueOf(wlTaskModelImpl.getWorkerId()),
						Long.valueOf(wlTaskModelImpl.getProjectId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_S_W_P, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_W_P,
					args);
			}

			if ((wlTaskModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_O_G_C_S_P_W.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(wlTaskModelImpl.getOriginalOwnerId()),
						Long.valueOf(wlTaskModelImpl.getOriginalGroupId()),
						Long.valueOf(wlTaskModelImpl.getOriginalCompanyId()),
						
						wlTaskModelImpl.getOriginalSubject(),
						Long.valueOf(wlTaskModelImpl.getOriginalProjectId()),
						Long.valueOf(wlTaskModelImpl.getOriginalWorkerId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_O_G_C_S_P_W,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_O_G_C_S_P_W,
					args);

				args = new Object[] {
						Long.valueOf(wlTaskModelImpl.getOwnerId()),
						Long.valueOf(wlTaskModelImpl.getGroupId()),
						Long.valueOf(wlTaskModelImpl.getCompanyId()),
						
						wlTaskModelImpl.getSubject(),
						Long.valueOf(wlTaskModelImpl.getProjectId()),
						Long.valueOf(wlTaskModelImpl.getWorkerId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_O_G_C_S_P_W,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_O_G_C_S_P_W,
					args);
			}

			if ((wlTaskModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_O_G_C_S_E_P_W.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(wlTaskModelImpl.getOriginalOwnerId()),
						Long.valueOf(wlTaskModelImpl.getOriginalGroupId()),
						Long.valueOf(wlTaskModelImpl.getOriginalCompanyId()),
						
						wlTaskModelImpl.getOriginalSubject(),
						
						wlTaskModelImpl.getOriginalExternalId(),
						Long.valueOf(wlTaskModelImpl.getOriginalProjectId()),
						Long.valueOf(wlTaskModelImpl.getOriginalWorkerId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_O_G_C_S_E_P_W,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_O_G_C_S_E_P_W,
					args);

				args = new Object[] {
						Long.valueOf(wlTaskModelImpl.getOwnerId()),
						Long.valueOf(wlTaskModelImpl.getGroupId()),
						Long.valueOf(wlTaskModelImpl.getCompanyId()),
						
						wlTaskModelImpl.getSubject(),
						
						wlTaskModelImpl.getExternalId(),
						Long.valueOf(wlTaskModelImpl.getProjectId()),
						Long.valueOf(wlTaskModelImpl.getWorkerId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_O_G_C_S_E_P_W,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_O_G_C_S_E_P_W,
					args);
			}

			if ((wlTaskModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_O_G_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(wlTaskModelImpl.getOriginalOwnerId()),
						Long.valueOf(wlTaskModelImpl.getOriginalGroupId()),
						Long.valueOf(wlTaskModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_O_G_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_O_G_C,
					args);

				args = new Object[] {
						Long.valueOf(wlTaskModelImpl.getOwnerId()),
						Long.valueOf(wlTaskModelImpl.getGroupId()),
						Long.valueOf(wlTaskModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_O_G_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_O_G_C,
					args);
			}
		}

		EntityCacheUtil.putResult(WLTaskModelImpl.ENTITY_CACHE_ENABLED,
			WLTaskImpl.class, wlTask.getPrimaryKey(), wlTask);

		return wlTask;
	}

	protected WLTask toUnwrappedModel(WLTask wlTask) {
		if (wlTask instanceof WLTaskImpl) {
			return wlTask;
		}

		WLTaskImpl wlTaskImpl = new WLTaskImpl();

		wlTaskImpl.setNew(wlTask.isNew());
		wlTaskImpl.setPrimaryKey(wlTask.getPrimaryKey());

		wlTaskImpl.setTaskId(wlTask.getTaskId());
		wlTaskImpl.setGroupId(wlTask.getGroupId());
		wlTaskImpl.setCompanyId(wlTask.getCompanyId());
		wlTaskImpl.setCreateUserId(wlTask.getCreateUserId());
		wlTaskImpl.setCreateUserName(wlTask.getCreateUserName());
		wlTaskImpl.setCreateDate(wlTask.getCreateDate());
		wlTaskImpl.setModifiedUserId(wlTask.getModifiedUserId());
		wlTaskImpl.setModifiedUserName(wlTask.getModifiedUserName());
		wlTaskImpl.setModifiedDate(wlTask.getModifiedDate());
		wlTaskImpl.setSubject(wlTask.getSubject());
		wlTaskImpl.setProjectId(wlTask.getProjectId());
		wlTaskImpl.setOwnerId(wlTask.getOwnerId());
		wlTaskImpl.setWorkerId(wlTask.getWorkerId());
		wlTaskImpl.setExternalId(wlTask.getExternalId());

		return wlTaskImpl;
	}

	/**
	 * Returns the w l task with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the w l task
	 * @return the w l task
	 * @throws com.liferay.portal.NoSuchModelException if a w l task with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WLTask findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the w l task with the primary key or throws a {@link com.jenginetest.builder.NoSuchTaskException} if it could not be found.
	 *
	 * @param taskId the primary key of the w l task
	 * @return the w l task
	 * @throws com.jenginetest.builder.NoSuchTaskException if a w l task with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLTask findByPrimaryKey(long taskId)
		throws NoSuchTaskException, SystemException {
		WLTask wlTask = fetchByPrimaryKey(taskId);

		if (wlTask == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + taskId);
			}

			throw new NoSuchTaskException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				taskId);
		}

		return wlTask;
	}

	/**
	 * Returns the w l task with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the w l task
	 * @return the w l task, or <code>null</code> if a w l task with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WLTask fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the w l task with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param taskId the primary key of the w l task
	 * @return the w l task, or <code>null</code> if a w l task with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLTask fetchByPrimaryKey(long taskId) throws SystemException {
		WLTask wlTask = (WLTask)EntityCacheUtil.getResult(WLTaskModelImpl.ENTITY_CACHE_ENABLED,
				WLTaskImpl.class, taskId);

		if (wlTask == _nullWLTask) {
			return null;
		}

		if (wlTask == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				wlTask = (WLTask)session.get(WLTaskImpl.class,
						Long.valueOf(taskId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (wlTask != null) {
					cacheResult(wlTask);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(WLTaskModelImpl.ENTITY_CACHE_ENABLED,
						WLTaskImpl.class, taskId, _nullWLTask);
				}

				closeSession(session);
			}
		}

		return wlTask;
	}

	/**
	 * Returns all the w l tasks where subject = &#63; and workerId = &#63; and projectId = &#63;.
	 *
	 * @param subject the subject
	 * @param workerId the worker ID
	 * @param projectId the project ID
	 * @return the matching w l tasks
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLTask> findByS_W_P(String subject, long workerId,
		long projectId) throws SystemException {
		return findByS_W_P(subject, workerId, projectId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the w l tasks where subject = &#63; and workerId = &#63; and projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param subject the subject
	 * @param workerId the worker ID
	 * @param projectId the project ID
	 * @param start the lower bound of the range of w l tasks
	 * @param end the upper bound of the range of w l tasks (not inclusive)
	 * @return the range of matching w l tasks
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLTask> findByS_W_P(String subject, long workerId,
		long projectId, int start, int end) throws SystemException {
		return findByS_W_P(subject, workerId, projectId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the w l tasks where subject = &#63; and workerId = &#63; and projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param subject the subject
	 * @param workerId the worker ID
	 * @param projectId the project ID
	 * @param start the lower bound of the range of w l tasks
	 * @param end the upper bound of the range of w l tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching w l tasks
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLTask> findByS_W_P(String subject, long workerId,
		long projectId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_W_P;
			finderArgs = new Object[] { subject, workerId, projectId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_S_W_P;
			finderArgs = new Object[] {
					subject, workerId, projectId,
					
					start, end, orderByComparator
				};
		}

		List<WLTask> list = (List<WLTask>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (WLTask wlTask : list) {
				if (!Validator.equals(subject, wlTask.getSubject()) ||
						(workerId != wlTask.getWorkerId()) ||
						(projectId != wlTask.getProjectId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_WLTASK_WHERE);

			if (subject == null) {
				query.append(_FINDER_COLUMN_S_W_P_SUBJECT_1);
			}
			else {
				if (subject.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_S_W_P_SUBJECT_3);
				}
				else {
					query.append(_FINDER_COLUMN_S_W_P_SUBJECT_2);
				}
			}

			query.append(_FINDER_COLUMN_S_W_P_WORKERID_2);

			query.append(_FINDER_COLUMN_S_W_P_PROJECTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(WLTaskModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (subject != null) {
					qPos.add(subject);
				}

				qPos.add(workerId);

				qPos.add(projectId);

				list = (List<WLTask>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first w l task in the ordered set where subject = &#63; and workerId = &#63; and projectId = &#63;.
	 *
	 * @param subject the subject
	 * @param workerId the worker ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching w l task
	 * @throws com.jenginetest.builder.NoSuchTaskException if a matching w l task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLTask findByS_W_P_First(String subject, long workerId,
		long projectId, OrderByComparator orderByComparator)
		throws NoSuchTaskException, SystemException {
		WLTask wlTask = fetchByS_W_P_First(subject, workerId, projectId,
				orderByComparator);

		if (wlTask != null) {
			return wlTask;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("subject=");
		msg.append(subject);

		msg.append(", workerId=");
		msg.append(workerId);

		msg.append(", projectId=");
		msg.append(projectId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTaskException(msg.toString());
	}

	/**
	 * Returns the first w l task in the ordered set where subject = &#63; and workerId = &#63; and projectId = &#63;.
	 *
	 * @param subject the subject
	 * @param workerId the worker ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching w l task, or <code>null</code> if a matching w l task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLTask fetchByS_W_P_First(String subject, long workerId,
		long projectId, OrderByComparator orderByComparator)
		throws SystemException {
		List<WLTask> list = findByS_W_P(subject, workerId, projectId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last w l task in the ordered set where subject = &#63; and workerId = &#63; and projectId = &#63;.
	 *
	 * @param subject the subject
	 * @param workerId the worker ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching w l task
	 * @throws com.jenginetest.builder.NoSuchTaskException if a matching w l task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLTask findByS_W_P_Last(String subject, long workerId,
		long projectId, OrderByComparator orderByComparator)
		throws NoSuchTaskException, SystemException {
		WLTask wlTask = fetchByS_W_P_Last(subject, workerId, projectId,
				orderByComparator);

		if (wlTask != null) {
			return wlTask;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("subject=");
		msg.append(subject);

		msg.append(", workerId=");
		msg.append(workerId);

		msg.append(", projectId=");
		msg.append(projectId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTaskException(msg.toString());
	}

	/**
	 * Returns the last w l task in the ordered set where subject = &#63; and workerId = &#63; and projectId = &#63;.
	 *
	 * @param subject the subject
	 * @param workerId the worker ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching w l task, or <code>null</code> if a matching w l task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLTask fetchByS_W_P_Last(String subject, long workerId,
		long projectId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByS_W_P(subject, workerId, projectId);

		List<WLTask> list = findByS_W_P(subject, workerId, projectId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the w l tasks before and after the current w l task in the ordered set where subject = &#63; and workerId = &#63; and projectId = &#63;.
	 *
	 * @param taskId the primary key of the current w l task
	 * @param subject the subject
	 * @param workerId the worker ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next w l task
	 * @throws com.jenginetest.builder.NoSuchTaskException if a w l task with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLTask[] findByS_W_P_PrevAndNext(long taskId, String subject,
		long workerId, long projectId, OrderByComparator orderByComparator)
		throws NoSuchTaskException, SystemException {
		WLTask wlTask = findByPrimaryKey(taskId);

		Session session = null;

		try {
			session = openSession();

			WLTask[] array = new WLTaskImpl[3];

			array[0] = getByS_W_P_PrevAndNext(session, wlTask, subject,
					workerId, projectId, orderByComparator, true);

			array[1] = wlTask;

			array[2] = getByS_W_P_PrevAndNext(session, wlTask, subject,
					workerId, projectId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WLTask getByS_W_P_PrevAndNext(Session session, WLTask wlTask,
		String subject, long workerId, long projectId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WLTASK_WHERE);

		if (subject == null) {
			query.append(_FINDER_COLUMN_S_W_P_SUBJECT_1);
		}
		else {
			if (subject.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_S_W_P_SUBJECT_3);
			}
			else {
				query.append(_FINDER_COLUMN_S_W_P_SUBJECT_2);
			}
		}

		query.append(_FINDER_COLUMN_S_W_P_WORKERID_2);

		query.append(_FINDER_COLUMN_S_W_P_PROJECTID_2);

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
			query.append(WLTaskModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (subject != null) {
			qPos.add(subject);
		}

		qPos.add(workerId);

		qPos.add(projectId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wlTask);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WLTask> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject = &#63; and projectId = &#63; and workerId = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @param projectId the project ID
	 * @param workerId the worker ID
	 * @return the matching w l tasks
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLTask> findByO_G_C_S_P_W(long ownerId, long groupId,
		long companyId, String subject, long projectId, long workerId)
		throws SystemException {
		return findByO_G_C_S_P_W(ownerId, groupId, companyId, subject,
			projectId, workerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject = &#63; and projectId = &#63; and workerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @param projectId the project ID
	 * @param workerId the worker ID
	 * @param start the lower bound of the range of w l tasks
	 * @param end the upper bound of the range of w l tasks (not inclusive)
	 * @return the range of matching w l tasks
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLTask> findByO_G_C_S_P_W(long ownerId, long groupId,
		long companyId, String subject, long projectId, long workerId,
		int start, int end) throws SystemException {
		return findByO_G_C_S_P_W(ownerId, groupId, companyId, subject,
			projectId, workerId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject = &#63; and projectId = &#63; and workerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @param projectId the project ID
	 * @param workerId the worker ID
	 * @param start the lower bound of the range of w l tasks
	 * @param end the upper bound of the range of w l tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching w l tasks
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLTask> findByO_G_C_S_P_W(long ownerId, long groupId,
		long companyId, String subject, long projectId, long workerId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_O_G_C_S_P_W;
			finderArgs = new Object[] {
					ownerId, groupId, companyId, subject, projectId, workerId
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_O_G_C_S_P_W;
			finderArgs = new Object[] {
					ownerId, groupId, companyId, subject, projectId, workerId,
					
					start, end, orderByComparator
				};
		}

		List<WLTask> list = (List<WLTask>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (WLTask wlTask : list) {
				if ((ownerId != wlTask.getOwnerId()) ||
						(groupId != wlTask.getGroupId()) ||
						(companyId != wlTask.getCompanyId()) ||
						!Validator.equals(subject, wlTask.getSubject()) ||
						(projectId != wlTask.getProjectId()) ||
						(workerId != wlTask.getWorkerId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(8 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(8);
			}

			query.append(_SQL_SELECT_WLTASK_WHERE);

			query.append(_FINDER_COLUMN_O_G_C_S_P_W_OWNERID_2);

			query.append(_FINDER_COLUMN_O_G_C_S_P_W_GROUPID_2);

			query.append(_FINDER_COLUMN_O_G_C_S_P_W_COMPANYID_2);

			if (subject == null) {
				query.append(_FINDER_COLUMN_O_G_C_S_P_W_SUBJECT_1);
			}
			else {
				if (subject.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_O_G_C_S_P_W_SUBJECT_3);
				}
				else {
					query.append(_FINDER_COLUMN_O_G_C_S_P_W_SUBJECT_2);
				}
			}

			query.append(_FINDER_COLUMN_O_G_C_S_P_W_PROJECTID_2);

			query.append(_FINDER_COLUMN_O_G_C_S_P_W_WORKERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(WLTaskModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ownerId);

				qPos.add(groupId);

				qPos.add(companyId);

				if (subject != null) {
					qPos.add(subject);
				}

				qPos.add(projectId);

				qPos.add(workerId);

				list = (List<WLTask>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject = &#63; and projectId = &#63; and workerId = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @param projectId the project ID
	 * @param workerId the worker ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching w l task
	 * @throws com.jenginetest.builder.NoSuchTaskException if a matching w l task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLTask findByO_G_C_S_P_W_First(long ownerId, long groupId,
		long companyId, String subject, long projectId, long workerId,
		OrderByComparator orderByComparator)
		throws NoSuchTaskException, SystemException {
		WLTask wlTask = fetchByO_G_C_S_P_W_First(ownerId, groupId, companyId,
				subject, projectId, workerId, orderByComparator);

		if (wlTask != null) {
			return wlTask;
		}

		StringBundler msg = new StringBundler(14);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ownerId=");
		msg.append(ownerId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", subject=");
		msg.append(subject);

		msg.append(", projectId=");
		msg.append(projectId);

		msg.append(", workerId=");
		msg.append(workerId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTaskException(msg.toString());
	}

	/**
	 * Returns the first w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject = &#63; and projectId = &#63; and workerId = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @param projectId the project ID
	 * @param workerId the worker ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching w l task, or <code>null</code> if a matching w l task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLTask fetchByO_G_C_S_P_W_First(long ownerId, long groupId,
		long companyId, String subject, long projectId, long workerId,
		OrderByComparator orderByComparator) throws SystemException {
		List<WLTask> list = findByO_G_C_S_P_W(ownerId, groupId, companyId,
				subject, projectId, workerId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject = &#63; and projectId = &#63; and workerId = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @param projectId the project ID
	 * @param workerId the worker ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching w l task
	 * @throws com.jenginetest.builder.NoSuchTaskException if a matching w l task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLTask findByO_G_C_S_P_W_Last(long ownerId, long groupId,
		long companyId, String subject, long projectId, long workerId,
		OrderByComparator orderByComparator)
		throws NoSuchTaskException, SystemException {
		WLTask wlTask = fetchByO_G_C_S_P_W_Last(ownerId, groupId, companyId,
				subject, projectId, workerId, orderByComparator);

		if (wlTask != null) {
			return wlTask;
		}

		StringBundler msg = new StringBundler(14);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ownerId=");
		msg.append(ownerId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", subject=");
		msg.append(subject);

		msg.append(", projectId=");
		msg.append(projectId);

		msg.append(", workerId=");
		msg.append(workerId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTaskException(msg.toString());
	}

	/**
	 * Returns the last w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject = &#63; and projectId = &#63; and workerId = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @param projectId the project ID
	 * @param workerId the worker ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching w l task, or <code>null</code> if a matching w l task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLTask fetchByO_G_C_S_P_W_Last(long ownerId, long groupId,
		long companyId, String subject, long projectId, long workerId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByO_G_C_S_P_W(ownerId, groupId, companyId, subject,
				projectId, workerId);

		List<WLTask> list = findByO_G_C_S_P_W(ownerId, groupId, companyId,
				subject, projectId, workerId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the w l tasks before and after the current w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject = &#63; and projectId = &#63; and workerId = &#63;.
	 *
	 * @param taskId the primary key of the current w l task
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @param projectId the project ID
	 * @param workerId the worker ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next w l task
	 * @throws com.jenginetest.builder.NoSuchTaskException if a w l task with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLTask[] findByO_G_C_S_P_W_PrevAndNext(long taskId, long ownerId,
		long groupId, long companyId, String subject, long projectId,
		long workerId, OrderByComparator orderByComparator)
		throws NoSuchTaskException, SystemException {
		WLTask wlTask = findByPrimaryKey(taskId);

		Session session = null;

		try {
			session = openSession();

			WLTask[] array = new WLTaskImpl[3];

			array[0] = getByO_G_C_S_P_W_PrevAndNext(session, wlTask, ownerId,
					groupId, companyId, subject, projectId, workerId,
					orderByComparator, true);

			array[1] = wlTask;

			array[2] = getByO_G_C_S_P_W_PrevAndNext(session, wlTask, ownerId,
					groupId, companyId, subject, projectId, workerId,
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

	protected WLTask getByO_G_C_S_P_W_PrevAndNext(Session session,
		WLTask wlTask, long ownerId, long groupId, long companyId,
		String subject, long projectId, long workerId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WLTASK_WHERE);

		query.append(_FINDER_COLUMN_O_G_C_S_P_W_OWNERID_2);

		query.append(_FINDER_COLUMN_O_G_C_S_P_W_GROUPID_2);

		query.append(_FINDER_COLUMN_O_G_C_S_P_W_COMPANYID_2);

		if (subject == null) {
			query.append(_FINDER_COLUMN_O_G_C_S_P_W_SUBJECT_1);
		}
		else {
			if (subject.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_O_G_C_S_P_W_SUBJECT_3);
			}
			else {
				query.append(_FINDER_COLUMN_O_G_C_S_P_W_SUBJECT_2);
			}
		}

		query.append(_FINDER_COLUMN_O_G_C_S_P_W_PROJECTID_2);

		query.append(_FINDER_COLUMN_O_G_C_S_P_W_WORKERID_2);

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
			query.append(WLTaskModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(ownerId);

		qPos.add(groupId);

		qPos.add(companyId);

		if (subject != null) {
			qPos.add(subject);
		}

		qPos.add(projectId);

		qPos.add(workerId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wlTask);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WLTask> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject = &#63; and externalId = &#63; and projectId = &#63; and workerId = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @param externalId the external ID
	 * @param projectId the project ID
	 * @param workerId the worker ID
	 * @return the matching w l tasks
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLTask> findByO_G_C_S_E_P_W(long ownerId, long groupId,
		long companyId, String subject, String externalId, long projectId,
		long workerId) throws SystemException {
		return findByO_G_C_S_E_P_W(ownerId, groupId, companyId, subject,
			externalId, projectId, workerId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject = &#63; and externalId = &#63; and projectId = &#63; and workerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @param externalId the external ID
	 * @param projectId the project ID
	 * @param workerId the worker ID
	 * @param start the lower bound of the range of w l tasks
	 * @param end the upper bound of the range of w l tasks (not inclusive)
	 * @return the range of matching w l tasks
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLTask> findByO_G_C_S_E_P_W(long ownerId, long groupId,
		long companyId, String subject, String externalId, long projectId,
		long workerId, int start, int end) throws SystemException {
		return findByO_G_C_S_E_P_W(ownerId, groupId, companyId, subject,
			externalId, projectId, workerId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject = &#63; and externalId = &#63; and projectId = &#63; and workerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @param externalId the external ID
	 * @param projectId the project ID
	 * @param workerId the worker ID
	 * @param start the lower bound of the range of w l tasks
	 * @param end the upper bound of the range of w l tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching w l tasks
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLTask> findByO_G_C_S_E_P_W(long ownerId, long groupId,
		long companyId, String subject, String externalId, long projectId,
		long workerId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_O_G_C_S_E_P_W;
			finderArgs = new Object[] {
					ownerId, groupId, companyId, subject, externalId, projectId,
					workerId
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_O_G_C_S_E_P_W;
			finderArgs = new Object[] {
					ownerId, groupId, companyId, subject, externalId, projectId,
					workerId,
					
					start, end, orderByComparator
				};
		}

		List<WLTask> list = (List<WLTask>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (WLTask wlTask : list) {
				if ((ownerId != wlTask.getOwnerId()) ||
						(groupId != wlTask.getGroupId()) ||
						(companyId != wlTask.getCompanyId()) ||
						!Validator.equals(subject, wlTask.getSubject()) ||
						!Validator.equals(externalId, wlTask.getExternalId()) ||
						(projectId != wlTask.getProjectId()) ||
						(workerId != wlTask.getWorkerId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(9 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(9);
			}

			query.append(_SQL_SELECT_WLTASK_WHERE);

			query.append(_FINDER_COLUMN_O_G_C_S_E_P_W_OWNERID_2);

			query.append(_FINDER_COLUMN_O_G_C_S_E_P_W_GROUPID_2);

			query.append(_FINDER_COLUMN_O_G_C_S_E_P_W_COMPANYID_2);

			if (subject == null) {
				query.append(_FINDER_COLUMN_O_G_C_S_E_P_W_SUBJECT_1);
			}
			else {
				if (subject.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_O_G_C_S_E_P_W_SUBJECT_3);
				}
				else {
					query.append(_FINDER_COLUMN_O_G_C_S_E_P_W_SUBJECT_2);
				}
			}

			if (externalId == null) {
				query.append(_FINDER_COLUMN_O_G_C_S_E_P_W_EXTERNALID_1);
			}
			else {
				if (externalId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_O_G_C_S_E_P_W_EXTERNALID_3);
				}
				else {
					query.append(_FINDER_COLUMN_O_G_C_S_E_P_W_EXTERNALID_2);
				}
			}

			query.append(_FINDER_COLUMN_O_G_C_S_E_P_W_PROJECTID_2);

			query.append(_FINDER_COLUMN_O_G_C_S_E_P_W_WORKERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(WLTaskModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ownerId);

				qPos.add(groupId);

				qPos.add(companyId);

				if (subject != null) {
					qPos.add(subject);
				}

				if (externalId != null) {
					qPos.add(externalId);
				}

				qPos.add(projectId);

				qPos.add(workerId);

				list = (List<WLTask>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject = &#63; and externalId = &#63; and projectId = &#63; and workerId = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @param externalId the external ID
	 * @param projectId the project ID
	 * @param workerId the worker ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching w l task
	 * @throws com.jenginetest.builder.NoSuchTaskException if a matching w l task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLTask findByO_G_C_S_E_P_W_First(long ownerId, long groupId,
		long companyId, String subject, String externalId, long projectId,
		long workerId, OrderByComparator orderByComparator)
		throws NoSuchTaskException, SystemException {
		WLTask wlTask = fetchByO_G_C_S_E_P_W_First(ownerId, groupId, companyId,
				subject, externalId, projectId, workerId, orderByComparator);

		if (wlTask != null) {
			return wlTask;
		}

		StringBundler msg = new StringBundler(16);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ownerId=");
		msg.append(ownerId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", subject=");
		msg.append(subject);

		msg.append(", externalId=");
		msg.append(externalId);

		msg.append(", projectId=");
		msg.append(projectId);

		msg.append(", workerId=");
		msg.append(workerId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTaskException(msg.toString());
	}

	/**
	 * Returns the first w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject = &#63; and externalId = &#63; and projectId = &#63; and workerId = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @param externalId the external ID
	 * @param projectId the project ID
	 * @param workerId the worker ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching w l task, or <code>null</code> if a matching w l task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLTask fetchByO_G_C_S_E_P_W_First(long ownerId, long groupId,
		long companyId, String subject, String externalId, long projectId,
		long workerId, OrderByComparator orderByComparator)
		throws SystemException {
		List<WLTask> list = findByO_G_C_S_E_P_W(ownerId, groupId, companyId,
				subject, externalId, projectId, workerId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject = &#63; and externalId = &#63; and projectId = &#63; and workerId = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @param externalId the external ID
	 * @param projectId the project ID
	 * @param workerId the worker ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching w l task
	 * @throws com.jenginetest.builder.NoSuchTaskException if a matching w l task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLTask findByO_G_C_S_E_P_W_Last(long ownerId, long groupId,
		long companyId, String subject, String externalId, long projectId,
		long workerId, OrderByComparator orderByComparator)
		throws NoSuchTaskException, SystemException {
		WLTask wlTask = fetchByO_G_C_S_E_P_W_Last(ownerId, groupId, companyId,
				subject, externalId, projectId, workerId, orderByComparator);

		if (wlTask != null) {
			return wlTask;
		}

		StringBundler msg = new StringBundler(16);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ownerId=");
		msg.append(ownerId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", subject=");
		msg.append(subject);

		msg.append(", externalId=");
		msg.append(externalId);

		msg.append(", projectId=");
		msg.append(projectId);

		msg.append(", workerId=");
		msg.append(workerId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTaskException(msg.toString());
	}

	/**
	 * Returns the last w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject = &#63; and externalId = &#63; and projectId = &#63; and workerId = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @param externalId the external ID
	 * @param projectId the project ID
	 * @param workerId the worker ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching w l task, or <code>null</code> if a matching w l task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLTask fetchByO_G_C_S_E_P_W_Last(long ownerId, long groupId,
		long companyId, String subject, String externalId, long projectId,
		long workerId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByO_G_C_S_E_P_W(ownerId, groupId, companyId, subject,
				externalId, projectId, workerId);

		List<WLTask> list = findByO_G_C_S_E_P_W(ownerId, groupId, companyId,
				subject, externalId, projectId, workerId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the w l tasks before and after the current w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject = &#63; and externalId = &#63; and projectId = &#63; and workerId = &#63;.
	 *
	 * @param taskId the primary key of the current w l task
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @param externalId the external ID
	 * @param projectId the project ID
	 * @param workerId the worker ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next w l task
	 * @throws com.jenginetest.builder.NoSuchTaskException if a w l task with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLTask[] findByO_G_C_S_E_P_W_PrevAndNext(long taskId, long ownerId,
		long groupId, long companyId, String subject, String externalId,
		long projectId, long workerId, OrderByComparator orderByComparator)
		throws NoSuchTaskException, SystemException {
		WLTask wlTask = findByPrimaryKey(taskId);

		Session session = null;

		try {
			session = openSession();

			WLTask[] array = new WLTaskImpl[3];

			array[0] = getByO_G_C_S_E_P_W_PrevAndNext(session, wlTask, ownerId,
					groupId, companyId, subject, externalId, projectId,
					workerId, orderByComparator, true);

			array[1] = wlTask;

			array[2] = getByO_G_C_S_E_P_W_PrevAndNext(session, wlTask, ownerId,
					groupId, companyId, subject, externalId, projectId,
					workerId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WLTask getByO_G_C_S_E_P_W_PrevAndNext(Session session,
		WLTask wlTask, long ownerId, long groupId, long companyId,
		String subject, String externalId, long projectId, long workerId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WLTASK_WHERE);

		query.append(_FINDER_COLUMN_O_G_C_S_E_P_W_OWNERID_2);

		query.append(_FINDER_COLUMN_O_G_C_S_E_P_W_GROUPID_2);

		query.append(_FINDER_COLUMN_O_G_C_S_E_P_W_COMPANYID_2);

		if (subject == null) {
			query.append(_FINDER_COLUMN_O_G_C_S_E_P_W_SUBJECT_1);
		}
		else {
			if (subject.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_O_G_C_S_E_P_W_SUBJECT_3);
			}
			else {
				query.append(_FINDER_COLUMN_O_G_C_S_E_P_W_SUBJECT_2);
			}
		}

		if (externalId == null) {
			query.append(_FINDER_COLUMN_O_G_C_S_E_P_W_EXTERNALID_1);
		}
		else {
			if (externalId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_O_G_C_S_E_P_W_EXTERNALID_3);
			}
			else {
				query.append(_FINDER_COLUMN_O_G_C_S_E_P_W_EXTERNALID_2);
			}
		}

		query.append(_FINDER_COLUMN_O_G_C_S_E_P_W_PROJECTID_2);

		query.append(_FINDER_COLUMN_O_G_C_S_E_P_W_WORKERID_2);

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
			query.append(WLTaskModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(ownerId);

		qPos.add(groupId);

		qPos.add(companyId);

		if (subject != null) {
			qPos.add(subject);
		}

		if (externalId != null) {
			qPos.add(externalId);
		}

		qPos.add(projectId);

		qPos.add(workerId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wlTask);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WLTask> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching w l tasks
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLTask> findByO_G_C(long ownerId, long groupId, long companyId)
		throws SystemException {
		return findByO_G_C(ownerId, groupId, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of w l tasks
	 * @param end the upper bound of the range of w l tasks (not inclusive)
	 * @return the range of matching w l tasks
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLTask> findByO_G_C(long ownerId, long groupId, long companyId,
		int start, int end) throws SystemException {
		return findByO_G_C(ownerId, groupId, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of w l tasks
	 * @param end the upper bound of the range of w l tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching w l tasks
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLTask> findByO_G_C(long ownerId, long groupId, long companyId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_O_G_C;
			finderArgs = new Object[] { ownerId, groupId, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_O_G_C;
			finderArgs = new Object[] {
					ownerId, groupId, companyId,
					
					start, end, orderByComparator
				};
		}

		List<WLTask> list = (List<WLTask>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (WLTask wlTask : list) {
				if ((ownerId != wlTask.getOwnerId()) ||
						(groupId != wlTask.getGroupId()) ||
						(companyId != wlTask.getCompanyId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_WLTASK_WHERE);

			query.append(_FINDER_COLUMN_O_G_C_OWNERID_2);

			query.append(_FINDER_COLUMN_O_G_C_GROUPID_2);

			query.append(_FINDER_COLUMN_O_G_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(WLTaskModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ownerId);

				qPos.add(groupId);

				qPos.add(companyId);

				list = (List<WLTask>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching w l task
	 * @throws com.jenginetest.builder.NoSuchTaskException if a matching w l task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLTask findByO_G_C_First(long ownerId, long groupId, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchTaskException, SystemException {
		WLTask wlTask = fetchByO_G_C_First(ownerId, groupId, companyId,
				orderByComparator);

		if (wlTask != null) {
			return wlTask;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ownerId=");
		msg.append(ownerId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTaskException(msg.toString());
	}

	/**
	 * Returns the first w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching w l task, or <code>null</code> if a matching w l task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLTask fetchByO_G_C_First(long ownerId, long groupId,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		List<WLTask> list = findByO_G_C(ownerId, groupId, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching w l task
	 * @throws com.jenginetest.builder.NoSuchTaskException if a matching w l task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLTask findByO_G_C_Last(long ownerId, long groupId, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchTaskException, SystemException {
		WLTask wlTask = fetchByO_G_C_Last(ownerId, groupId, companyId,
				orderByComparator);

		if (wlTask != null) {
			return wlTask;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ownerId=");
		msg.append(ownerId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTaskException(msg.toString());
	}

	/**
	 * Returns the last w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching w l task, or <code>null</code> if a matching w l task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLTask fetchByO_G_C_Last(long ownerId, long groupId, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByO_G_C(ownerId, groupId, companyId);

		List<WLTask> list = findByO_G_C(ownerId, groupId, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the w l tasks before and after the current w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * @param taskId the primary key of the current w l task
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next w l task
	 * @throws com.jenginetest.builder.NoSuchTaskException if a w l task with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLTask[] findByO_G_C_PrevAndNext(long taskId, long ownerId,
		long groupId, long companyId, OrderByComparator orderByComparator)
		throws NoSuchTaskException, SystemException {
		WLTask wlTask = findByPrimaryKey(taskId);

		Session session = null;

		try {
			session = openSession();

			WLTask[] array = new WLTaskImpl[3];

			array[0] = getByO_G_C_PrevAndNext(session, wlTask, ownerId,
					groupId, companyId, orderByComparator, true);

			array[1] = wlTask;

			array[2] = getByO_G_C_PrevAndNext(session, wlTask, ownerId,
					groupId, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WLTask getByO_G_C_PrevAndNext(Session session, WLTask wlTask,
		long ownerId, long groupId, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WLTASK_WHERE);

		query.append(_FINDER_COLUMN_O_G_C_OWNERID_2);

		query.append(_FINDER_COLUMN_O_G_C_GROUPID_2);

		query.append(_FINDER_COLUMN_O_G_C_COMPANYID_2);

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
			query.append(WLTaskModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(ownerId);

		qPos.add(groupId);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wlTask);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WLTask> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @return the matching w l tasks
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLTask> findByO_G_C_SP(long ownerId, long groupId,
		long companyId, String subject) throws SystemException {
		return findByO_G_C_SP(ownerId, groupId, companyId, subject,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @param start the lower bound of the range of w l tasks
	 * @param end the upper bound of the range of w l tasks (not inclusive)
	 * @return the range of matching w l tasks
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLTask> findByO_G_C_SP(long ownerId, long groupId,
		long companyId, String subject, int start, int end)
		throws SystemException {
		return findByO_G_C_SP(ownerId, groupId, companyId, subject, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @param start the lower bound of the range of w l tasks
	 * @param end the upper bound of the range of w l tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching w l tasks
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLTask> findByO_G_C_SP(long ownerId, long groupId,
		long companyId, String subject, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_O_G_C_SP;
		finderArgs = new Object[] {
				ownerId, groupId, companyId, subject,
				
				start, end, orderByComparator
			};

		List<WLTask> list = (List<WLTask>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (WLTask wlTask : list) {
				if ((ownerId != wlTask.getOwnerId()) ||
						(groupId != wlTask.getGroupId()) ||
						(companyId != wlTask.getCompanyId()) ||
						!Validator.equals(subject, wlTask.getSubject())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_WLTASK_WHERE);

			query.append(_FINDER_COLUMN_O_G_C_SP_OWNERID_2);

			query.append(_FINDER_COLUMN_O_G_C_SP_GROUPID_2);

			query.append(_FINDER_COLUMN_O_G_C_SP_COMPANYID_2);

			if (subject == null) {
				query.append(_FINDER_COLUMN_O_G_C_SP_SUBJECT_1);
			}
			else {
				if (subject.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_O_G_C_SP_SUBJECT_3);
				}
				else {
					query.append(_FINDER_COLUMN_O_G_C_SP_SUBJECT_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(WLTaskModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ownerId);

				qPos.add(groupId);

				qPos.add(companyId);

				if (subject != null) {
					qPos.add(subject);
				}

				list = (List<WLTask>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching w l task
	 * @throws com.jenginetest.builder.NoSuchTaskException if a matching w l task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLTask findByO_G_C_SP_First(long ownerId, long groupId,
		long companyId, String subject, OrderByComparator orderByComparator)
		throws NoSuchTaskException, SystemException {
		WLTask wlTask = fetchByO_G_C_SP_First(ownerId, groupId, companyId,
				subject, orderByComparator);

		if (wlTask != null) {
			return wlTask;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ownerId=");
		msg.append(ownerId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", subject=");
		msg.append(subject);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTaskException(msg.toString());
	}

	/**
	 * Returns the first w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching w l task, or <code>null</code> if a matching w l task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLTask fetchByO_G_C_SP_First(long ownerId, long groupId,
		long companyId, String subject, OrderByComparator orderByComparator)
		throws SystemException {
		List<WLTask> list = findByO_G_C_SP(ownerId, groupId, companyId,
				subject, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching w l task
	 * @throws com.jenginetest.builder.NoSuchTaskException if a matching w l task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLTask findByO_G_C_SP_Last(long ownerId, long groupId,
		long companyId, String subject, OrderByComparator orderByComparator)
		throws NoSuchTaskException, SystemException {
		WLTask wlTask = fetchByO_G_C_SP_Last(ownerId, groupId, companyId,
				subject, orderByComparator);

		if (wlTask != null) {
			return wlTask;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ownerId=");
		msg.append(ownerId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", subject=");
		msg.append(subject);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTaskException(msg.toString());
	}

	/**
	 * Returns the last w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching w l task, or <code>null</code> if a matching w l task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLTask fetchByO_G_C_SP_Last(long ownerId, long groupId,
		long companyId, String subject, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByO_G_C_SP(ownerId, groupId, companyId, subject);

		List<WLTask> list = findByO_G_C_SP(ownerId, groupId, companyId,
				subject, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the w l tasks before and after the current w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63;.
	 *
	 * @param taskId the primary key of the current w l task
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next w l task
	 * @throws com.jenginetest.builder.NoSuchTaskException if a w l task with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLTask[] findByO_G_C_SP_PrevAndNext(long taskId, long ownerId,
		long groupId, long companyId, String subject,
		OrderByComparator orderByComparator)
		throws NoSuchTaskException, SystemException {
		WLTask wlTask = findByPrimaryKey(taskId);

		Session session = null;

		try {
			session = openSession();

			WLTask[] array = new WLTaskImpl[3];

			array[0] = getByO_G_C_SP_PrevAndNext(session, wlTask, ownerId,
					groupId, companyId, subject, orderByComparator, true);

			array[1] = wlTask;

			array[2] = getByO_G_C_SP_PrevAndNext(session, wlTask, ownerId,
					groupId, companyId, subject, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WLTask getByO_G_C_SP_PrevAndNext(Session session, WLTask wlTask,
		long ownerId, long groupId, long companyId, String subject,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WLTASK_WHERE);

		query.append(_FINDER_COLUMN_O_G_C_SP_OWNERID_2);

		query.append(_FINDER_COLUMN_O_G_C_SP_GROUPID_2);

		query.append(_FINDER_COLUMN_O_G_C_SP_COMPANYID_2);

		if (subject == null) {
			query.append(_FINDER_COLUMN_O_G_C_SP_SUBJECT_1);
		}
		else {
			if (subject.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_O_G_C_SP_SUBJECT_3);
			}
			else {
				query.append(_FINDER_COLUMN_O_G_C_SP_SUBJECT_2);
			}
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
			query.append(WLTaskModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(ownerId);

		qPos.add(groupId);

		qPos.add(companyId);

		if (subject != null) {
			qPos.add(subject);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wlTask);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WLTask> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and projectId = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @param projectId the project ID
	 * @return the matching w l tasks
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLTask> findByO_G_C_SP_P(long ownerId, long groupId,
		long companyId, String subject, long projectId)
		throws SystemException {
		return findByO_G_C_SP_P(ownerId, groupId, companyId, subject,
			projectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @param projectId the project ID
	 * @param start the lower bound of the range of w l tasks
	 * @param end the upper bound of the range of w l tasks (not inclusive)
	 * @return the range of matching w l tasks
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLTask> findByO_G_C_SP_P(long ownerId, long groupId,
		long companyId, String subject, long projectId, int start, int end)
		throws SystemException {
		return findByO_G_C_SP_P(ownerId, groupId, companyId, subject,
			projectId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @param projectId the project ID
	 * @param start the lower bound of the range of w l tasks
	 * @param end the upper bound of the range of w l tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching w l tasks
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLTask> findByO_G_C_SP_P(long ownerId, long groupId,
		long companyId, String subject, long projectId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_O_G_C_SP_P;
		finderArgs = new Object[] {
				ownerId, groupId, companyId, subject, projectId,
				
				start, end, orderByComparator
			};

		List<WLTask> list = (List<WLTask>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (WLTask wlTask : list) {
				if ((ownerId != wlTask.getOwnerId()) ||
						(groupId != wlTask.getGroupId()) ||
						(companyId != wlTask.getCompanyId()) ||
						!Validator.equals(subject, wlTask.getSubject()) ||
						(projectId != wlTask.getProjectId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(7 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(7);
			}

			query.append(_SQL_SELECT_WLTASK_WHERE);

			query.append(_FINDER_COLUMN_O_G_C_SP_P_OWNERID_2);

			query.append(_FINDER_COLUMN_O_G_C_SP_P_GROUPID_2);

			query.append(_FINDER_COLUMN_O_G_C_SP_P_COMPANYID_2);

			if (subject == null) {
				query.append(_FINDER_COLUMN_O_G_C_SP_P_SUBJECT_1);
			}
			else {
				if (subject.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_O_G_C_SP_P_SUBJECT_3);
				}
				else {
					query.append(_FINDER_COLUMN_O_G_C_SP_P_SUBJECT_2);
				}
			}

			query.append(_FINDER_COLUMN_O_G_C_SP_P_PROJECTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(WLTaskModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ownerId);

				qPos.add(groupId);

				qPos.add(companyId);

				if (subject != null) {
					qPos.add(subject);
				}

				qPos.add(projectId);

				list = (List<WLTask>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and projectId = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching w l task
	 * @throws com.jenginetest.builder.NoSuchTaskException if a matching w l task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLTask findByO_G_C_SP_P_First(long ownerId, long groupId,
		long companyId, String subject, long projectId,
		OrderByComparator orderByComparator)
		throws NoSuchTaskException, SystemException {
		WLTask wlTask = fetchByO_G_C_SP_P_First(ownerId, groupId, companyId,
				subject, projectId, orderByComparator);

		if (wlTask != null) {
			return wlTask;
		}

		StringBundler msg = new StringBundler(12);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ownerId=");
		msg.append(ownerId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", subject=");
		msg.append(subject);

		msg.append(", projectId=");
		msg.append(projectId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTaskException(msg.toString());
	}

	/**
	 * Returns the first w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and projectId = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching w l task, or <code>null</code> if a matching w l task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLTask fetchByO_G_C_SP_P_First(long ownerId, long groupId,
		long companyId, String subject, long projectId,
		OrderByComparator orderByComparator) throws SystemException {
		List<WLTask> list = findByO_G_C_SP_P(ownerId, groupId, companyId,
				subject, projectId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and projectId = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching w l task
	 * @throws com.jenginetest.builder.NoSuchTaskException if a matching w l task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLTask findByO_G_C_SP_P_Last(long ownerId, long groupId,
		long companyId, String subject, long projectId,
		OrderByComparator orderByComparator)
		throws NoSuchTaskException, SystemException {
		WLTask wlTask = fetchByO_G_C_SP_P_Last(ownerId, groupId, companyId,
				subject, projectId, orderByComparator);

		if (wlTask != null) {
			return wlTask;
		}

		StringBundler msg = new StringBundler(12);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ownerId=");
		msg.append(ownerId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", subject=");
		msg.append(subject);

		msg.append(", projectId=");
		msg.append(projectId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTaskException(msg.toString());
	}

	/**
	 * Returns the last w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and projectId = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching w l task, or <code>null</code> if a matching w l task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLTask fetchByO_G_C_SP_P_Last(long ownerId, long groupId,
		long companyId, String subject, long projectId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByO_G_C_SP_P(ownerId, groupId, companyId, subject,
				projectId);

		List<WLTask> list = findByO_G_C_SP_P(ownerId, groupId, companyId,
				subject, projectId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the w l tasks before and after the current w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and projectId = &#63;.
	 *
	 * @param taskId the primary key of the current w l task
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next w l task
	 * @throws com.jenginetest.builder.NoSuchTaskException if a w l task with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLTask[] findByO_G_C_SP_P_PrevAndNext(long taskId, long ownerId,
		long groupId, long companyId, String subject, long projectId,
		OrderByComparator orderByComparator)
		throws NoSuchTaskException, SystemException {
		WLTask wlTask = findByPrimaryKey(taskId);

		Session session = null;

		try {
			session = openSession();

			WLTask[] array = new WLTaskImpl[3];

			array[0] = getByO_G_C_SP_P_PrevAndNext(session, wlTask, ownerId,
					groupId, companyId, subject, projectId, orderByComparator,
					true);

			array[1] = wlTask;

			array[2] = getByO_G_C_SP_P_PrevAndNext(session, wlTask, ownerId,
					groupId, companyId, subject, projectId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WLTask getByO_G_C_SP_P_PrevAndNext(Session session,
		WLTask wlTask, long ownerId, long groupId, long companyId,
		String subject, long projectId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WLTASK_WHERE);

		query.append(_FINDER_COLUMN_O_G_C_SP_P_OWNERID_2);

		query.append(_FINDER_COLUMN_O_G_C_SP_P_GROUPID_2);

		query.append(_FINDER_COLUMN_O_G_C_SP_P_COMPANYID_2);

		if (subject == null) {
			query.append(_FINDER_COLUMN_O_G_C_SP_P_SUBJECT_1);
		}
		else {
			if (subject.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_O_G_C_SP_P_SUBJECT_3);
			}
			else {
				query.append(_FINDER_COLUMN_O_G_C_SP_P_SUBJECT_2);
			}
		}

		query.append(_FINDER_COLUMN_O_G_C_SP_P_PROJECTID_2);

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
			query.append(WLTaskModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(ownerId);

		qPos.add(groupId);

		qPos.add(companyId);

		if (subject != null) {
			qPos.add(subject);
		}

		qPos.add(projectId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wlTask);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WLTask> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and workerId = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @param workerId the worker ID
	 * @return the matching w l tasks
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLTask> findByO_G_C_SP_W(long ownerId, long groupId,
		long companyId, String subject, long workerId)
		throws SystemException {
		return findByO_G_C_SP_W(ownerId, groupId, companyId, subject, workerId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and workerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @param workerId the worker ID
	 * @param start the lower bound of the range of w l tasks
	 * @param end the upper bound of the range of w l tasks (not inclusive)
	 * @return the range of matching w l tasks
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLTask> findByO_G_C_SP_W(long ownerId, long groupId,
		long companyId, String subject, long workerId, int start, int end)
		throws SystemException {
		return findByO_G_C_SP_W(ownerId, groupId, companyId, subject, workerId,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and workerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @param workerId the worker ID
	 * @param start the lower bound of the range of w l tasks
	 * @param end the upper bound of the range of w l tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching w l tasks
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLTask> findByO_G_C_SP_W(long ownerId, long groupId,
		long companyId, String subject, long workerId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_O_G_C_SP_W;
		finderArgs = new Object[] {
				ownerId, groupId, companyId, subject, workerId,
				
				start, end, orderByComparator
			};

		List<WLTask> list = (List<WLTask>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (WLTask wlTask : list) {
				if ((ownerId != wlTask.getOwnerId()) ||
						(groupId != wlTask.getGroupId()) ||
						(companyId != wlTask.getCompanyId()) ||
						!Validator.equals(subject, wlTask.getSubject()) ||
						(workerId != wlTask.getWorkerId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(7 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(7);
			}

			query.append(_SQL_SELECT_WLTASK_WHERE);

			query.append(_FINDER_COLUMN_O_G_C_SP_W_OWNERID_2);

			query.append(_FINDER_COLUMN_O_G_C_SP_W_GROUPID_2);

			query.append(_FINDER_COLUMN_O_G_C_SP_W_COMPANYID_2);

			if (subject == null) {
				query.append(_FINDER_COLUMN_O_G_C_SP_W_SUBJECT_1);
			}
			else {
				if (subject.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_O_G_C_SP_W_SUBJECT_3);
				}
				else {
					query.append(_FINDER_COLUMN_O_G_C_SP_W_SUBJECT_2);
				}
			}

			query.append(_FINDER_COLUMN_O_G_C_SP_W_WORKERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(WLTaskModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ownerId);

				qPos.add(groupId);

				qPos.add(companyId);

				if (subject != null) {
					qPos.add(subject);
				}

				qPos.add(workerId);

				list = (List<WLTask>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and workerId = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @param workerId the worker ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching w l task
	 * @throws com.jenginetest.builder.NoSuchTaskException if a matching w l task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLTask findByO_G_C_SP_W_First(long ownerId, long groupId,
		long companyId, String subject, long workerId,
		OrderByComparator orderByComparator)
		throws NoSuchTaskException, SystemException {
		WLTask wlTask = fetchByO_G_C_SP_W_First(ownerId, groupId, companyId,
				subject, workerId, orderByComparator);

		if (wlTask != null) {
			return wlTask;
		}

		StringBundler msg = new StringBundler(12);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ownerId=");
		msg.append(ownerId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", subject=");
		msg.append(subject);

		msg.append(", workerId=");
		msg.append(workerId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTaskException(msg.toString());
	}

	/**
	 * Returns the first w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and workerId = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @param workerId the worker ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching w l task, or <code>null</code> if a matching w l task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLTask fetchByO_G_C_SP_W_First(long ownerId, long groupId,
		long companyId, String subject, long workerId,
		OrderByComparator orderByComparator) throws SystemException {
		List<WLTask> list = findByO_G_C_SP_W(ownerId, groupId, companyId,
				subject, workerId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and workerId = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @param workerId the worker ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching w l task
	 * @throws com.jenginetest.builder.NoSuchTaskException if a matching w l task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLTask findByO_G_C_SP_W_Last(long ownerId, long groupId,
		long companyId, String subject, long workerId,
		OrderByComparator orderByComparator)
		throws NoSuchTaskException, SystemException {
		WLTask wlTask = fetchByO_G_C_SP_W_Last(ownerId, groupId, companyId,
				subject, workerId, orderByComparator);

		if (wlTask != null) {
			return wlTask;
		}

		StringBundler msg = new StringBundler(12);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ownerId=");
		msg.append(ownerId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", subject=");
		msg.append(subject);

		msg.append(", workerId=");
		msg.append(workerId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTaskException(msg.toString());
	}

	/**
	 * Returns the last w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and workerId = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @param workerId the worker ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching w l task, or <code>null</code> if a matching w l task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLTask fetchByO_G_C_SP_W_Last(long ownerId, long groupId,
		long companyId, String subject, long workerId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByO_G_C_SP_W(ownerId, groupId, companyId, subject,
				workerId);

		List<WLTask> list = findByO_G_C_SP_W(ownerId, groupId, companyId,
				subject, workerId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the w l tasks before and after the current w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and workerId = &#63;.
	 *
	 * @param taskId the primary key of the current w l task
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @param workerId the worker ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next w l task
	 * @throws com.jenginetest.builder.NoSuchTaskException if a w l task with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLTask[] findByO_G_C_SP_W_PrevAndNext(long taskId, long ownerId,
		long groupId, long companyId, String subject, long workerId,
		OrderByComparator orderByComparator)
		throws NoSuchTaskException, SystemException {
		WLTask wlTask = findByPrimaryKey(taskId);

		Session session = null;

		try {
			session = openSession();

			WLTask[] array = new WLTaskImpl[3];

			array[0] = getByO_G_C_SP_W_PrevAndNext(session, wlTask, ownerId,
					groupId, companyId, subject, workerId, orderByComparator,
					true);

			array[1] = wlTask;

			array[2] = getByO_G_C_SP_W_PrevAndNext(session, wlTask, ownerId,
					groupId, companyId, subject, workerId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WLTask getByO_G_C_SP_W_PrevAndNext(Session session,
		WLTask wlTask, long ownerId, long groupId, long companyId,
		String subject, long workerId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WLTASK_WHERE);

		query.append(_FINDER_COLUMN_O_G_C_SP_W_OWNERID_2);

		query.append(_FINDER_COLUMN_O_G_C_SP_W_GROUPID_2);

		query.append(_FINDER_COLUMN_O_G_C_SP_W_COMPANYID_2);

		if (subject == null) {
			query.append(_FINDER_COLUMN_O_G_C_SP_W_SUBJECT_1);
		}
		else {
			if (subject.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_O_G_C_SP_W_SUBJECT_3);
			}
			else {
				query.append(_FINDER_COLUMN_O_G_C_SP_W_SUBJECT_2);
			}
		}

		query.append(_FINDER_COLUMN_O_G_C_SP_W_WORKERID_2);

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
			query.append(WLTaskModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(ownerId);

		qPos.add(groupId);

		qPos.add(companyId);

		if (subject != null) {
			qPos.add(subject);
		}

		qPos.add(workerId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wlTask);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WLTask> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and projectId = &#63; and workerId = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @param projectId the project ID
	 * @param workerId the worker ID
	 * @return the matching w l tasks
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLTask> findByO_G_C_SP_P_W(long ownerId, long groupId,
		long companyId, String subject, long projectId, long workerId)
		throws SystemException {
		return findByO_G_C_SP_P_W(ownerId, groupId, companyId, subject,
			projectId, workerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and projectId = &#63; and workerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @param projectId the project ID
	 * @param workerId the worker ID
	 * @param start the lower bound of the range of w l tasks
	 * @param end the upper bound of the range of w l tasks (not inclusive)
	 * @return the range of matching w l tasks
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLTask> findByO_G_C_SP_P_W(long ownerId, long groupId,
		long companyId, String subject, long projectId, long workerId,
		int start, int end) throws SystemException {
		return findByO_G_C_SP_P_W(ownerId, groupId, companyId, subject,
			projectId, workerId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and projectId = &#63; and workerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @param projectId the project ID
	 * @param workerId the worker ID
	 * @param start the lower bound of the range of w l tasks
	 * @param end the upper bound of the range of w l tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching w l tasks
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLTask> findByO_G_C_SP_P_W(long ownerId, long groupId,
		long companyId, String subject, long projectId, long workerId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_O_G_C_SP_P_W;
		finderArgs = new Object[] {
				ownerId, groupId, companyId, subject, projectId, workerId,
				
				start, end, orderByComparator
			};

		List<WLTask> list = (List<WLTask>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (WLTask wlTask : list) {
				if ((ownerId != wlTask.getOwnerId()) ||
						(groupId != wlTask.getGroupId()) ||
						(companyId != wlTask.getCompanyId()) ||
						!Validator.equals(subject, wlTask.getSubject()) ||
						(projectId != wlTask.getProjectId()) ||
						(workerId != wlTask.getWorkerId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(8 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(8);
			}

			query.append(_SQL_SELECT_WLTASK_WHERE);

			query.append(_FINDER_COLUMN_O_G_C_SP_P_W_OWNERID_2);

			query.append(_FINDER_COLUMN_O_G_C_SP_P_W_GROUPID_2);

			query.append(_FINDER_COLUMN_O_G_C_SP_P_W_COMPANYID_2);

			if (subject == null) {
				query.append(_FINDER_COLUMN_O_G_C_SP_P_W_SUBJECT_1);
			}
			else {
				if (subject.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_O_G_C_SP_P_W_SUBJECT_3);
				}
				else {
					query.append(_FINDER_COLUMN_O_G_C_SP_P_W_SUBJECT_2);
				}
			}

			query.append(_FINDER_COLUMN_O_G_C_SP_P_W_PROJECTID_2);

			query.append(_FINDER_COLUMN_O_G_C_SP_P_W_WORKERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(WLTaskModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ownerId);

				qPos.add(groupId);

				qPos.add(companyId);

				if (subject != null) {
					qPos.add(subject);
				}

				qPos.add(projectId);

				qPos.add(workerId);

				list = (List<WLTask>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and projectId = &#63; and workerId = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @param projectId the project ID
	 * @param workerId the worker ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching w l task
	 * @throws com.jenginetest.builder.NoSuchTaskException if a matching w l task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLTask findByO_G_C_SP_P_W_First(long ownerId, long groupId,
		long companyId, String subject, long projectId, long workerId,
		OrderByComparator orderByComparator)
		throws NoSuchTaskException, SystemException {
		WLTask wlTask = fetchByO_G_C_SP_P_W_First(ownerId, groupId, companyId,
				subject, projectId, workerId, orderByComparator);

		if (wlTask != null) {
			return wlTask;
		}

		StringBundler msg = new StringBundler(14);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ownerId=");
		msg.append(ownerId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", subject=");
		msg.append(subject);

		msg.append(", projectId=");
		msg.append(projectId);

		msg.append(", workerId=");
		msg.append(workerId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTaskException(msg.toString());
	}

	/**
	 * Returns the first w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and projectId = &#63; and workerId = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @param projectId the project ID
	 * @param workerId the worker ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching w l task, or <code>null</code> if a matching w l task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLTask fetchByO_G_C_SP_P_W_First(long ownerId, long groupId,
		long companyId, String subject, long projectId, long workerId,
		OrderByComparator orderByComparator) throws SystemException {
		List<WLTask> list = findByO_G_C_SP_P_W(ownerId, groupId, companyId,
				subject, projectId, workerId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and projectId = &#63; and workerId = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @param projectId the project ID
	 * @param workerId the worker ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching w l task
	 * @throws com.jenginetest.builder.NoSuchTaskException if a matching w l task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLTask findByO_G_C_SP_P_W_Last(long ownerId, long groupId,
		long companyId, String subject, long projectId, long workerId,
		OrderByComparator orderByComparator)
		throws NoSuchTaskException, SystemException {
		WLTask wlTask = fetchByO_G_C_SP_P_W_Last(ownerId, groupId, companyId,
				subject, projectId, workerId, orderByComparator);

		if (wlTask != null) {
			return wlTask;
		}

		StringBundler msg = new StringBundler(14);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ownerId=");
		msg.append(ownerId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", subject=");
		msg.append(subject);

		msg.append(", projectId=");
		msg.append(projectId);

		msg.append(", workerId=");
		msg.append(workerId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTaskException(msg.toString());
	}

	/**
	 * Returns the last w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and projectId = &#63; and workerId = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @param projectId the project ID
	 * @param workerId the worker ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching w l task, or <code>null</code> if a matching w l task could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLTask fetchByO_G_C_SP_P_W_Last(long ownerId, long groupId,
		long companyId, String subject, long projectId, long workerId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByO_G_C_SP_P_W(ownerId, groupId, companyId, subject,
				projectId, workerId);

		List<WLTask> list = findByO_G_C_SP_P_W(ownerId, groupId, companyId,
				subject, projectId, workerId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the w l tasks before and after the current w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and projectId = &#63; and workerId = &#63;.
	 *
	 * @param taskId the primary key of the current w l task
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @param projectId the project ID
	 * @param workerId the worker ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next w l task
	 * @throws com.jenginetest.builder.NoSuchTaskException if a w l task with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLTask[] findByO_G_C_SP_P_W_PrevAndNext(long taskId, long ownerId,
		long groupId, long companyId, String subject, long projectId,
		long workerId, OrderByComparator orderByComparator)
		throws NoSuchTaskException, SystemException {
		WLTask wlTask = findByPrimaryKey(taskId);

		Session session = null;

		try {
			session = openSession();

			WLTask[] array = new WLTaskImpl[3];

			array[0] = getByO_G_C_SP_P_W_PrevAndNext(session, wlTask, ownerId,
					groupId, companyId, subject, projectId, workerId,
					orderByComparator, true);

			array[1] = wlTask;

			array[2] = getByO_G_C_SP_P_W_PrevAndNext(session, wlTask, ownerId,
					groupId, companyId, subject, projectId, workerId,
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

	protected WLTask getByO_G_C_SP_P_W_PrevAndNext(Session session,
		WLTask wlTask, long ownerId, long groupId, long companyId,
		String subject, long projectId, long workerId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WLTASK_WHERE);

		query.append(_FINDER_COLUMN_O_G_C_SP_P_W_OWNERID_2);

		query.append(_FINDER_COLUMN_O_G_C_SP_P_W_GROUPID_2);

		query.append(_FINDER_COLUMN_O_G_C_SP_P_W_COMPANYID_2);

		if (subject == null) {
			query.append(_FINDER_COLUMN_O_G_C_SP_P_W_SUBJECT_1);
		}
		else {
			if (subject.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_O_G_C_SP_P_W_SUBJECT_3);
			}
			else {
				query.append(_FINDER_COLUMN_O_G_C_SP_P_W_SUBJECT_2);
			}
		}

		query.append(_FINDER_COLUMN_O_G_C_SP_P_W_PROJECTID_2);

		query.append(_FINDER_COLUMN_O_G_C_SP_P_W_WORKERID_2);

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
			query.append(WLTaskModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(ownerId);

		qPos.add(groupId);

		qPos.add(companyId);

		if (subject != null) {
			qPos.add(subject);
		}

		qPos.add(projectId);

		qPos.add(workerId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wlTask);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WLTask> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the w l tasks.
	 *
	 * @return the w l tasks
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLTask> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the w l tasks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of w l tasks
	 * @param end the upper bound of the range of w l tasks (not inclusive)
	 * @return the range of w l tasks
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLTask> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the w l tasks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of w l tasks
	 * @param end the upper bound of the range of w l tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of w l tasks
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLTask> findAll(int start, int end,
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

		List<WLTask> list = (List<WLTask>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_WLTASK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WLTASK.concat(WLTaskModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<WLTask>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<WLTask>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the w l tasks where subject = &#63; and workerId = &#63; and projectId = &#63; from the database.
	 *
	 * @param subject the subject
	 * @param workerId the worker ID
	 * @param projectId the project ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByS_W_P(String subject, long workerId, long projectId)
		throws SystemException {
		for (WLTask wlTask : findByS_W_P(subject, workerId, projectId)) {
			remove(wlTask);
		}
	}

	/**
	 * Removes all the w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject = &#63; and projectId = &#63; and workerId = &#63; from the database.
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @param projectId the project ID
	 * @param workerId the worker ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByO_G_C_S_P_W(long ownerId, long groupId, long companyId,
		String subject, long projectId, long workerId)
		throws SystemException {
		for (WLTask wlTask : findByO_G_C_S_P_W(ownerId, groupId, companyId,
				subject, projectId, workerId)) {
			remove(wlTask);
		}
	}

	/**
	 * Removes all the w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject = &#63; and externalId = &#63; and projectId = &#63; and workerId = &#63; from the database.
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @param externalId the external ID
	 * @param projectId the project ID
	 * @param workerId the worker ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByO_G_C_S_E_P_W(long ownerId, long groupId,
		long companyId, String subject, String externalId, long projectId,
		long workerId) throws SystemException {
		for (WLTask wlTask : findByO_G_C_S_E_P_W(ownerId, groupId, companyId,
				subject, externalId, projectId, workerId)) {
			remove(wlTask);
		}
	}

	/**
	 * Removes all the w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByO_G_C(long ownerId, long groupId, long companyId)
		throws SystemException {
		for (WLTask wlTask : findByO_G_C(ownerId, groupId, companyId)) {
			remove(wlTask);
		}
	}

	/**
	 * Removes all the w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; from the database.
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByO_G_C_SP(long ownerId, long groupId, long companyId,
		String subject) throws SystemException {
		for (WLTask wlTask : findByO_G_C_SP(ownerId, groupId, companyId, subject)) {
			remove(wlTask);
		}
	}

	/**
	 * Removes all the w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and projectId = &#63; from the database.
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @param projectId the project ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByO_G_C_SP_P(long ownerId, long groupId, long companyId,
		String subject, long projectId) throws SystemException {
		for (WLTask wlTask : findByO_G_C_SP_P(ownerId, groupId, companyId,
				subject, projectId)) {
			remove(wlTask);
		}
	}

	/**
	 * Removes all the w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and workerId = &#63; from the database.
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @param workerId the worker ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByO_G_C_SP_W(long ownerId, long groupId, long companyId,
		String subject, long workerId) throws SystemException {
		for (WLTask wlTask : findByO_G_C_SP_W(ownerId, groupId, companyId,
				subject, workerId)) {
			remove(wlTask);
		}
	}

	/**
	 * Removes all the w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and projectId = &#63; and workerId = &#63; from the database.
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @param projectId the project ID
	 * @param workerId the worker ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByO_G_C_SP_P_W(long ownerId, long groupId,
		long companyId, String subject, long projectId, long workerId)
		throws SystemException {
		for (WLTask wlTask : findByO_G_C_SP_P_W(ownerId, groupId, companyId,
				subject, projectId, workerId)) {
			remove(wlTask);
		}
	}

	/**
	 * Removes all the w l tasks from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (WLTask wlTask : findAll()) {
			remove(wlTask);
		}
	}

	/**
	 * Returns the number of w l tasks where subject = &#63; and workerId = &#63; and projectId = &#63;.
	 *
	 * @param subject the subject
	 * @param workerId the worker ID
	 * @param projectId the project ID
	 * @return the number of matching w l tasks
	 * @throws SystemException if a system exception occurred
	 */
	public int countByS_W_P(String subject, long workerId, long projectId)
		throws SystemException {
		Object[] finderArgs = new Object[] { subject, workerId, projectId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_S_W_P,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_WLTASK_WHERE);

			if (subject == null) {
				query.append(_FINDER_COLUMN_S_W_P_SUBJECT_1);
			}
			else {
				if (subject.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_S_W_P_SUBJECT_3);
				}
				else {
					query.append(_FINDER_COLUMN_S_W_P_SUBJECT_2);
				}
			}

			query.append(_FINDER_COLUMN_S_W_P_WORKERID_2);

			query.append(_FINDER_COLUMN_S_W_P_PROJECTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (subject != null) {
					qPos.add(subject);
				}

				qPos.add(workerId);

				qPos.add(projectId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_S_W_P,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject = &#63; and projectId = &#63; and workerId = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @param projectId the project ID
	 * @param workerId the worker ID
	 * @return the number of matching w l tasks
	 * @throws SystemException if a system exception occurred
	 */
	public int countByO_G_C_S_P_W(long ownerId, long groupId, long companyId,
		String subject, long projectId, long workerId)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				ownerId, groupId, companyId, subject, projectId, workerId
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_O_G_C_S_P_W,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(7);

			query.append(_SQL_COUNT_WLTASK_WHERE);

			query.append(_FINDER_COLUMN_O_G_C_S_P_W_OWNERID_2);

			query.append(_FINDER_COLUMN_O_G_C_S_P_W_GROUPID_2);

			query.append(_FINDER_COLUMN_O_G_C_S_P_W_COMPANYID_2);

			if (subject == null) {
				query.append(_FINDER_COLUMN_O_G_C_S_P_W_SUBJECT_1);
			}
			else {
				if (subject.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_O_G_C_S_P_W_SUBJECT_3);
				}
				else {
					query.append(_FINDER_COLUMN_O_G_C_S_P_W_SUBJECT_2);
				}
			}

			query.append(_FINDER_COLUMN_O_G_C_S_P_W_PROJECTID_2);

			query.append(_FINDER_COLUMN_O_G_C_S_P_W_WORKERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ownerId);

				qPos.add(groupId);

				qPos.add(companyId);

				if (subject != null) {
					qPos.add(subject);
				}

				qPos.add(projectId);

				qPos.add(workerId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_O_G_C_S_P_W,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject = &#63; and externalId = &#63; and projectId = &#63; and workerId = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @param externalId the external ID
	 * @param projectId the project ID
	 * @param workerId the worker ID
	 * @return the number of matching w l tasks
	 * @throws SystemException if a system exception occurred
	 */
	public int countByO_G_C_S_E_P_W(long ownerId, long groupId, long companyId,
		String subject, String externalId, long projectId, long workerId)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				ownerId, groupId, companyId, subject, externalId, projectId,
				workerId
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_O_G_C_S_E_P_W,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(8);

			query.append(_SQL_COUNT_WLTASK_WHERE);

			query.append(_FINDER_COLUMN_O_G_C_S_E_P_W_OWNERID_2);

			query.append(_FINDER_COLUMN_O_G_C_S_E_P_W_GROUPID_2);

			query.append(_FINDER_COLUMN_O_G_C_S_E_P_W_COMPANYID_2);

			if (subject == null) {
				query.append(_FINDER_COLUMN_O_G_C_S_E_P_W_SUBJECT_1);
			}
			else {
				if (subject.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_O_G_C_S_E_P_W_SUBJECT_3);
				}
				else {
					query.append(_FINDER_COLUMN_O_G_C_S_E_P_W_SUBJECT_2);
				}
			}

			if (externalId == null) {
				query.append(_FINDER_COLUMN_O_G_C_S_E_P_W_EXTERNALID_1);
			}
			else {
				if (externalId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_O_G_C_S_E_P_W_EXTERNALID_3);
				}
				else {
					query.append(_FINDER_COLUMN_O_G_C_S_E_P_W_EXTERNALID_2);
				}
			}

			query.append(_FINDER_COLUMN_O_G_C_S_E_P_W_PROJECTID_2);

			query.append(_FINDER_COLUMN_O_G_C_S_E_P_W_WORKERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ownerId);

				qPos.add(groupId);

				qPos.add(companyId);

				if (subject != null) {
					qPos.add(subject);
				}

				if (externalId != null) {
					qPos.add(externalId);
				}

				qPos.add(projectId);

				qPos.add(workerId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_O_G_C_S_E_P_W,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching w l tasks
	 * @throws SystemException if a system exception occurred
	 */
	public int countByO_G_C(long ownerId, long groupId, long companyId)
		throws SystemException {
		Object[] finderArgs = new Object[] { ownerId, groupId, companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_O_G_C,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_WLTASK_WHERE);

			query.append(_FINDER_COLUMN_O_G_C_OWNERID_2);

			query.append(_FINDER_COLUMN_O_G_C_GROUPID_2);

			query.append(_FINDER_COLUMN_O_G_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ownerId);

				qPos.add(groupId);

				qPos.add(companyId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_O_G_C,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @return the number of matching w l tasks
	 * @throws SystemException if a system exception occurred
	 */
	public int countByO_G_C_SP(long ownerId, long groupId, long companyId,
		String subject) throws SystemException {
		Object[] finderArgs = new Object[] { ownerId, groupId, companyId, subject };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_O_G_C_SP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_WLTASK_WHERE);

			query.append(_FINDER_COLUMN_O_G_C_SP_OWNERID_2);

			query.append(_FINDER_COLUMN_O_G_C_SP_GROUPID_2);

			query.append(_FINDER_COLUMN_O_G_C_SP_COMPANYID_2);

			if (subject == null) {
				query.append(_FINDER_COLUMN_O_G_C_SP_SUBJECT_1);
			}
			else {
				if (subject.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_O_G_C_SP_SUBJECT_3);
				}
				else {
					query.append(_FINDER_COLUMN_O_G_C_SP_SUBJECT_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ownerId);

				qPos.add(groupId);

				qPos.add(companyId);

				if (subject != null) {
					qPos.add(subject);
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

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_O_G_C_SP,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and projectId = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @param projectId the project ID
	 * @return the number of matching w l tasks
	 * @throws SystemException if a system exception occurred
	 */
	public int countByO_G_C_SP_P(long ownerId, long groupId, long companyId,
		String subject, long projectId) throws SystemException {
		Object[] finderArgs = new Object[] {
				ownerId, groupId, companyId, subject, projectId
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_O_G_C_SP_P,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_COUNT_WLTASK_WHERE);

			query.append(_FINDER_COLUMN_O_G_C_SP_P_OWNERID_2);

			query.append(_FINDER_COLUMN_O_G_C_SP_P_GROUPID_2);

			query.append(_FINDER_COLUMN_O_G_C_SP_P_COMPANYID_2);

			if (subject == null) {
				query.append(_FINDER_COLUMN_O_G_C_SP_P_SUBJECT_1);
			}
			else {
				if (subject.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_O_G_C_SP_P_SUBJECT_3);
				}
				else {
					query.append(_FINDER_COLUMN_O_G_C_SP_P_SUBJECT_2);
				}
			}

			query.append(_FINDER_COLUMN_O_G_C_SP_P_PROJECTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ownerId);

				qPos.add(groupId);

				qPos.add(companyId);

				if (subject != null) {
					qPos.add(subject);
				}

				qPos.add(projectId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_O_G_C_SP_P,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and workerId = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @param workerId the worker ID
	 * @return the number of matching w l tasks
	 * @throws SystemException if a system exception occurred
	 */
	public int countByO_G_C_SP_W(long ownerId, long groupId, long companyId,
		String subject, long workerId) throws SystemException {
		Object[] finderArgs = new Object[] {
				ownerId, groupId, companyId, subject, workerId
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_O_G_C_SP_W,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_COUNT_WLTASK_WHERE);

			query.append(_FINDER_COLUMN_O_G_C_SP_W_OWNERID_2);

			query.append(_FINDER_COLUMN_O_G_C_SP_W_GROUPID_2);

			query.append(_FINDER_COLUMN_O_G_C_SP_W_COMPANYID_2);

			if (subject == null) {
				query.append(_FINDER_COLUMN_O_G_C_SP_W_SUBJECT_1);
			}
			else {
				if (subject.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_O_G_C_SP_W_SUBJECT_3);
				}
				else {
					query.append(_FINDER_COLUMN_O_G_C_SP_W_SUBJECT_2);
				}
			}

			query.append(_FINDER_COLUMN_O_G_C_SP_W_WORKERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ownerId);

				qPos.add(groupId);

				qPos.add(companyId);

				if (subject != null) {
					qPos.add(subject);
				}

				qPos.add(workerId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_O_G_C_SP_W,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and projectId = &#63; and workerId = &#63;.
	 *
	 * @param ownerId the owner ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param subject the subject
	 * @param projectId the project ID
	 * @param workerId the worker ID
	 * @return the number of matching w l tasks
	 * @throws SystemException if a system exception occurred
	 */
	public int countByO_G_C_SP_P_W(long ownerId, long groupId, long companyId,
		String subject, long projectId, long workerId)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				ownerId, groupId, companyId, subject, projectId, workerId
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_O_G_C_SP_P_W,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(7);

			query.append(_SQL_COUNT_WLTASK_WHERE);

			query.append(_FINDER_COLUMN_O_G_C_SP_P_W_OWNERID_2);

			query.append(_FINDER_COLUMN_O_G_C_SP_P_W_GROUPID_2);

			query.append(_FINDER_COLUMN_O_G_C_SP_P_W_COMPANYID_2);

			if (subject == null) {
				query.append(_FINDER_COLUMN_O_G_C_SP_P_W_SUBJECT_1);
			}
			else {
				if (subject.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_O_G_C_SP_P_W_SUBJECT_3);
				}
				else {
					query.append(_FINDER_COLUMN_O_G_C_SP_P_W_SUBJECT_2);
				}
			}

			query.append(_FINDER_COLUMN_O_G_C_SP_P_W_PROJECTID_2);

			query.append(_FINDER_COLUMN_O_G_C_SP_P_W_WORKERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ownerId);

				qPos.add(groupId);

				qPos.add(companyId);

				if (subject != null) {
					qPos.add(subject);
				}

				qPos.add(projectId);

				qPos.add(workerId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_O_G_C_SP_P_W,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of w l tasks.
	 *
	 * @return the number of w l tasks
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_WLTASK);

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
	 * Returns all the w l task options associated with the w l task.
	 *
	 * @param pk the primary key of the w l task
	 * @return the w l task options associated with the w l task
	 * @throws SystemException if a system exception occurred
	 */
	public List<com.jenginetest.builder.model.WLTaskOption> getWLTaskOptions(
		long pk) throws SystemException {
		return getWLTaskOptions(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the w l task options associated with the w l task.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pk the primary key of the w l task
	 * @param start the lower bound of the range of w l tasks
	 * @param end the upper bound of the range of w l tasks (not inclusive)
	 * @return the range of w l task options associated with the w l task
	 * @throws SystemException if a system exception occurred
	 */
	public List<com.jenginetest.builder.model.WLTaskOption> getWLTaskOptions(
		long pk, int start, int end) throws SystemException {
		return getWLTaskOptions(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_WLTASKOPTIONS = new FinderPath(com.jenginetest.builder.model.impl.WLTaskOptionModelImpl.ENTITY_CACHE_ENABLED,
			com.jenginetest.builder.model.impl.WLTaskOptionModelImpl.FINDER_CACHE_ENABLED,
			com.jenginetest.builder.model.impl.WLTaskOptionImpl.class,
			com.jenginetest.builder.service.persistence.WLTaskOptionPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"getWLTaskOptions",
			new String[] {
				Long.class.getName(), "java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	static {
		FINDER_PATH_GET_WLTASKOPTIONS.setCacheKeyGeneratorCacheName(null);
	}

	/**
	 * Returns an ordered range of all the w l task options associated with the w l task.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pk the primary key of the w l task
	 * @param start the lower bound of the range of w l tasks
	 * @param end the upper bound of the range of w l tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of w l task options associated with the w l task
	 * @throws SystemException if a system exception occurred
	 */
	public List<com.jenginetest.builder.model.WLTaskOption> getWLTaskOptions(
		long pk, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk, start, end, orderByComparator };

		List<com.jenginetest.builder.model.WLTaskOption> list = (List<com.jenginetest.builder.model.WLTaskOption>)FinderCacheUtil.getResult(FINDER_PATH_GET_WLTASKOPTIONS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				String sql = null;

				if (orderByComparator != null) {
					sql = _SQL_GETWLTASKOPTIONS.concat(ORDER_BY_CLAUSE)
											   .concat(orderByComparator.getOrderBy());
				}
				else {
					sql = _SQL_GETWLTASKOPTIONS;
				}

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("WL_WLTaskOption",
					com.jenginetest.builder.model.impl.WLTaskOptionImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<com.jenginetest.builder.model.WLTaskOption>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_GET_WLTASKOPTIONS,
						finderArgs);
				}
				else {
					wlTaskOptionPersistence.cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_GET_WLTASKOPTIONS,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_WLTASKOPTIONS_SIZE = new FinderPath(com.jenginetest.builder.model.impl.WLTaskOptionModelImpl.ENTITY_CACHE_ENABLED,
			com.jenginetest.builder.model.impl.WLTaskOptionModelImpl.FINDER_CACHE_ENABLED,
			com.jenginetest.builder.model.impl.WLTaskOptionImpl.class,
			com.jenginetest.builder.service.persistence.WLTaskOptionPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"getWLTaskOptionsSize", new String[] { Long.class.getName() });

	static {
		FINDER_PATH_GET_WLTASKOPTIONS_SIZE.setCacheKeyGeneratorCacheName(null);
	}

	/**
	 * Returns the number of w l task options associated with the w l task.
	 *
	 * @param pk the primary key of the w l task
	 * @return the number of w l task options associated with the w l task
	 * @throws SystemException if a system exception occurred
	 */
	public int getWLTaskOptionsSize(long pk) throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_WLTASKOPTIONS_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETWLTASKOPTIONSSIZE);

				q.addScalar(COUNT_COLUMN_NAME,
					com.liferay.portal.kernel.dao.orm.Type.LONG);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_GET_WLTASKOPTIONS_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_WLTASKOPTION = new FinderPath(com.jenginetest.builder.model.impl.WLTaskOptionModelImpl.ENTITY_CACHE_ENABLED,
			com.jenginetest.builder.model.impl.WLTaskOptionModelImpl.FINDER_CACHE_ENABLED,
			com.jenginetest.builder.model.impl.WLTaskOptionImpl.class,
			com.jenginetest.builder.service.persistence.WLTaskOptionPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"containsWLTaskOption",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns <code>true</code> if the w l task option is associated with the w l task.
	 *
	 * @param pk the primary key of the w l task
	 * @param wlTaskOptionPK the primary key of the w l task option
	 * @return <code>true</code> if the w l task option is associated with the w l task; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsWLTaskOption(long pk, long wlTaskOptionPK)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk, wlTaskOptionPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_WLTASKOPTION,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsWLTaskOption.contains(pk,
							wlTaskOptionPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_WLTASKOPTION,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	/**
	 * Returns <code>true</code> if the w l task has any w l task options associated with it.
	 *
	 * @param pk the primary key of the w l task to check for associations with w l task options
	 * @return <code>true</code> if the w l task has any w l task options associated with it; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsWLTaskOptions(long pk) throws SystemException {
		if (getWLTaskOptionsSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Returns all the w l entries associated with the w l task.
	 *
	 * @param pk the primary key of the w l task
	 * @return the w l entries associated with the w l task
	 * @throws SystemException if a system exception occurred
	 */
	public List<com.jenginetest.builder.model.WLEntry> getWLEntries(long pk)
		throws SystemException {
		return getWLEntries(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the w l entries associated with the w l task.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pk the primary key of the w l task
	 * @param start the lower bound of the range of w l tasks
	 * @param end the upper bound of the range of w l tasks (not inclusive)
	 * @return the range of w l entries associated with the w l task
	 * @throws SystemException if a system exception occurred
	 */
	public List<com.jenginetest.builder.model.WLEntry> getWLEntries(long pk,
		int start, int end) throws SystemException {
		return getWLEntries(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_WLENTRIES = new FinderPath(com.jenginetest.builder.model.impl.WLEntryModelImpl.ENTITY_CACHE_ENABLED,
			com.jenginetest.builder.model.impl.WLEntryModelImpl.FINDER_CACHE_ENABLED,
			com.jenginetest.builder.model.impl.WLEntryImpl.class,
			com.jenginetest.builder.service.persistence.WLEntryPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"getWLEntries",
			new String[] {
				Long.class.getName(), "java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	static {
		FINDER_PATH_GET_WLENTRIES.setCacheKeyGeneratorCacheName(null);
	}

	/**
	 * Returns an ordered range of all the w l entries associated with the w l task.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pk the primary key of the w l task
	 * @param start the lower bound of the range of w l tasks
	 * @param end the upper bound of the range of w l tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of w l entries associated with the w l task
	 * @throws SystemException if a system exception occurred
	 */
	public List<com.jenginetest.builder.model.WLEntry> getWLEntries(long pk,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk, start, end, orderByComparator };

		List<com.jenginetest.builder.model.WLEntry> list = (List<com.jenginetest.builder.model.WLEntry>)FinderCacheUtil.getResult(FINDER_PATH_GET_WLENTRIES,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				String sql = null;

				if (orderByComparator != null) {
					sql = _SQL_GETWLENTRIES.concat(ORDER_BY_CLAUSE)
										   .concat(orderByComparator.getOrderBy());
				}
				else {
					sql = _SQL_GETWLENTRIES.concat(com.jenginetest.builder.model.impl.WLEntryModelImpl.ORDER_BY_SQL);
				}

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("WL_WLEntry",
					com.jenginetest.builder.model.impl.WLEntryImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<com.jenginetest.builder.model.WLEntry>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_GET_WLENTRIES,
						finderArgs);
				}
				else {
					wlEntryPersistence.cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_GET_WLENTRIES,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_WLENTRIES_SIZE = new FinderPath(com.jenginetest.builder.model.impl.WLEntryModelImpl.ENTITY_CACHE_ENABLED,
			com.jenginetest.builder.model.impl.WLEntryModelImpl.FINDER_CACHE_ENABLED,
			com.jenginetest.builder.model.impl.WLEntryImpl.class,
			com.jenginetest.builder.service.persistence.WLEntryPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"getWLEntriesSize", new String[] { Long.class.getName() });

	static {
		FINDER_PATH_GET_WLENTRIES_SIZE.setCacheKeyGeneratorCacheName(null);
	}

	/**
	 * Returns the number of w l entries associated with the w l task.
	 *
	 * @param pk the primary key of the w l task
	 * @return the number of w l entries associated with the w l task
	 * @throws SystemException if a system exception occurred
	 */
	public int getWLEntriesSize(long pk) throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_WLENTRIES_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETWLENTRIESSIZE);

				q.addScalar(COUNT_COLUMN_NAME,
					com.liferay.portal.kernel.dao.orm.Type.LONG);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_GET_WLENTRIES_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_WLENTRY = new FinderPath(com.jenginetest.builder.model.impl.WLEntryModelImpl.ENTITY_CACHE_ENABLED,
			com.jenginetest.builder.model.impl.WLEntryModelImpl.FINDER_CACHE_ENABLED,
			com.jenginetest.builder.model.impl.WLEntryImpl.class,
			com.jenginetest.builder.service.persistence.WLEntryPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"containsWLEntry",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns <code>true</code> if the w l entry is associated with the w l task.
	 *
	 * @param pk the primary key of the w l task
	 * @param wlEntryPK the primary key of the w l entry
	 * @return <code>true</code> if the w l entry is associated with the w l task; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsWLEntry(long pk, long wlEntryPK)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk, wlEntryPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_WLENTRY,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsWLEntry.contains(pk, wlEntryPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_WLENTRY,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	/**
	 * Returns <code>true</code> if the w l task has any w l entries associated with it.
	 *
	 * @param pk the primary key of the w l task to check for associations with w l entries
	 * @return <code>true</code> if the w l task has any w l entries associated with it; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsWLEntries(long pk) throws SystemException {
		if (getWLEntriesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Initializes the w l task persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.jenginetest.builder.model.WLTask")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<WLTask>> listenersList = new ArrayList<ModelListener<WLTask>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<WLTask>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		containsWLTaskOption = new ContainsWLTaskOption();

		containsWLEntry = new ContainsWLEntry();
	}

	public void destroy() {
		EntityCacheUtil.removeCache(WLTaskImpl.class.getName());
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
	@BeanReference(type = AssetEntryPersistence.class)
	protected AssetEntryPersistence assetEntryPersistence;
	protected ContainsWLTaskOption containsWLTaskOption;
	protected ContainsWLEntry containsWLEntry;

	protected class ContainsWLTaskOption {
		protected ContainsWLTaskOption() {
			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSWLTASKOPTION,
					new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT },
					RowMapper.COUNT);
		}

		protected boolean contains(long taskId, long optionId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						new Long(taskId), new Long(optionId)
					});

			if (results.size() > 0) {
				Integer count = results.get(0);

				if (count.intValue() > 0) {
					return true;
				}
			}

			return false;
		}

		private MappingSqlQuery<Integer> _mappingSqlQuery;
	}

	protected class ContainsWLEntry {
		protected ContainsWLEntry() {
			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSWLENTRY,
					new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT },
					RowMapper.COUNT);
		}

		protected boolean contains(long taskId, long entryId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						new Long(taskId), new Long(entryId)
					});

			if (results.size() > 0) {
				Integer count = results.get(0);

				if (count.intValue() > 0) {
					return true;
				}
			}

			return false;
		}

		private MappingSqlQuery<Integer> _mappingSqlQuery;
	}

	private static final String _SQL_SELECT_WLTASK = "SELECT wlTask FROM WLTask wlTask";
	private static final String _SQL_SELECT_WLTASK_WHERE = "SELECT wlTask FROM WLTask wlTask WHERE ";
	private static final String _SQL_COUNT_WLTASK = "SELECT COUNT(wlTask) FROM WLTask wlTask";
	private static final String _SQL_COUNT_WLTASK_WHERE = "SELECT COUNT(wlTask) FROM WLTask wlTask WHERE ";
	private static final String _SQL_GETWLTASKOPTIONS = "SELECT {WL_WLTaskOption.*} FROM WL_WLTaskOption INNER JOIN WL_WLTask ON (WL_WLTask.taskId = WL_WLTaskOption.taskId) WHERE (WL_WLTask.taskId = ?)";
	private static final String _SQL_GETWLTASKOPTIONSSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM WL_WLTaskOption WHERE taskId = ?";
	private static final String _SQL_CONTAINSWLTASKOPTION = "SELECT COUNT(*) AS COUNT_VALUE FROM WL_WLTaskOption WHERE taskId = ? AND optionId = ?";
	private static final String _SQL_GETWLENTRIES = "SELECT {WL_WLEntry.*} FROM WL_WLEntry INNER JOIN WL_WLTask ON (WL_WLTask.taskId = WL_WLEntry.taskId) WHERE (WL_WLTask.taskId = ?)";
	private static final String _SQL_GETWLENTRIESSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM WL_WLEntry WHERE taskId = ?";
	private static final String _SQL_CONTAINSWLENTRY = "SELECT COUNT(*) AS COUNT_VALUE FROM WL_WLEntry WHERE taskId = ? AND entryId = ?";
	private static final String _FINDER_COLUMN_S_W_P_SUBJECT_1 = "wlTask.subject IS NULL AND ";
	private static final String _FINDER_COLUMN_S_W_P_SUBJECT_2 = "lower(wlTask.subject) = lower(CAST_TEXT(?)) AND ";
	private static final String _FINDER_COLUMN_S_W_P_SUBJECT_3 = "(wlTask.subject IS NULL OR lower(wlTask.subject) = lower(CAST_TEXT(?))) AND ";
	private static final String _FINDER_COLUMN_S_W_P_WORKERID_2 = "wlTask.workerId = ? AND ";
	private static final String _FINDER_COLUMN_S_W_P_PROJECTID_2 = "wlTask.projectId = ?";
	private static final String _FINDER_COLUMN_O_G_C_S_P_W_OWNERID_2 = "wlTask.ownerId = ? AND ";
	private static final String _FINDER_COLUMN_O_G_C_S_P_W_GROUPID_2 = "wlTask.groupId = ? AND ";
	private static final String _FINDER_COLUMN_O_G_C_S_P_W_COMPANYID_2 = "wlTask.companyId = ? AND ";
	private static final String _FINDER_COLUMN_O_G_C_S_P_W_SUBJECT_1 = "wlTask.subject IS NULL AND ";
	private static final String _FINDER_COLUMN_O_G_C_S_P_W_SUBJECT_2 = "lower(wlTask.subject) = lower(CAST_TEXT(?)) AND ";
	private static final String _FINDER_COLUMN_O_G_C_S_P_W_SUBJECT_3 = "(wlTask.subject IS NULL OR lower(wlTask.subject) = lower(CAST_TEXT(?))) AND ";
	private static final String _FINDER_COLUMN_O_G_C_S_P_W_PROJECTID_2 = "wlTask.projectId = ? AND ";
	private static final String _FINDER_COLUMN_O_G_C_S_P_W_WORKERID_2 = "wlTask.workerId = ?";
	private static final String _FINDER_COLUMN_O_G_C_S_E_P_W_OWNERID_2 = "wlTask.ownerId = ? AND ";
	private static final String _FINDER_COLUMN_O_G_C_S_E_P_W_GROUPID_2 = "wlTask.groupId = ? AND ";
	private static final String _FINDER_COLUMN_O_G_C_S_E_P_W_COMPANYID_2 = "wlTask.companyId = ? AND ";
	private static final String _FINDER_COLUMN_O_G_C_S_E_P_W_SUBJECT_1 = "wlTask.subject IS NULL AND ";
	private static final String _FINDER_COLUMN_O_G_C_S_E_P_W_SUBJECT_2 = "lower(wlTask.subject) = lower(CAST_TEXT(?)) AND ";
	private static final String _FINDER_COLUMN_O_G_C_S_E_P_W_SUBJECT_3 = "(wlTask.subject IS NULL OR lower(wlTask.subject) = lower(CAST_TEXT(?))) AND ";
	private static final String _FINDER_COLUMN_O_G_C_S_E_P_W_EXTERNALID_1 = "wlTask.externalId IS NULL AND ";
	private static final String _FINDER_COLUMN_O_G_C_S_E_P_W_EXTERNALID_2 = "lower(wlTask.externalId) = lower(CAST_TEXT(?)) AND ";
	private static final String _FINDER_COLUMN_O_G_C_S_E_P_W_EXTERNALID_3 = "(wlTask.externalId IS NULL OR lower(wlTask.externalId) = lower(CAST_TEXT(?))) AND ";
	private static final String _FINDER_COLUMN_O_G_C_S_E_P_W_PROJECTID_2 = "wlTask.projectId = ? AND ";
	private static final String _FINDER_COLUMN_O_G_C_S_E_P_W_WORKERID_2 = "wlTask.workerId = ?";
	private static final String _FINDER_COLUMN_O_G_C_OWNERID_2 = "wlTask.ownerId = ? AND ";
	private static final String _FINDER_COLUMN_O_G_C_GROUPID_2 = "wlTask.groupId = ? AND ";
	private static final String _FINDER_COLUMN_O_G_C_COMPANYID_2 = "wlTask.companyId = ?";
	private static final String _FINDER_COLUMN_O_G_C_SP_OWNERID_2 = "wlTask.ownerId = ? AND ";
	private static final String _FINDER_COLUMN_O_G_C_SP_GROUPID_2 = "wlTask.groupId = ? AND ";
	private static final String _FINDER_COLUMN_O_G_C_SP_COMPANYID_2 = "wlTask.companyId = ? AND ";
	private static final String _FINDER_COLUMN_O_G_C_SP_SUBJECT_1 = "wlTask.subject like NULL";
	private static final String _FINDER_COLUMN_O_G_C_SP_SUBJECT_2 = "lower(wlTask.subject) like lower(CAST_TEXT(?))";
	private static final String _FINDER_COLUMN_O_G_C_SP_SUBJECT_3 = "(wlTask.subject IS NULL OR lower(wlTask.subject) like lower(CAST_TEXT(?)))";
	private static final String _FINDER_COLUMN_O_G_C_SP_P_OWNERID_2 = "wlTask.ownerId = ? AND ";
	private static final String _FINDER_COLUMN_O_G_C_SP_P_GROUPID_2 = "wlTask.groupId = ? AND ";
	private static final String _FINDER_COLUMN_O_G_C_SP_P_COMPANYID_2 = "wlTask.companyId = ? AND ";
	private static final String _FINDER_COLUMN_O_G_C_SP_P_SUBJECT_1 = "wlTask.subject like NULL AND ";
	private static final String _FINDER_COLUMN_O_G_C_SP_P_SUBJECT_2 = "lower(wlTask.subject) like lower(CAST_TEXT(?)) AND ";
	private static final String _FINDER_COLUMN_O_G_C_SP_P_SUBJECT_3 = "(wlTask.subject IS NULL OR lower(wlTask.subject) like lower(CAST_TEXT(?))) AND ";
	private static final String _FINDER_COLUMN_O_G_C_SP_P_PROJECTID_2 = "wlTask.projectId = ?";
	private static final String _FINDER_COLUMN_O_G_C_SP_W_OWNERID_2 = "wlTask.ownerId = ? AND ";
	private static final String _FINDER_COLUMN_O_G_C_SP_W_GROUPID_2 = "wlTask.groupId = ? AND ";
	private static final String _FINDER_COLUMN_O_G_C_SP_W_COMPANYID_2 = "wlTask.companyId = ? AND ";
	private static final String _FINDER_COLUMN_O_G_C_SP_W_SUBJECT_1 = "wlTask.subject like NULL AND ";
	private static final String _FINDER_COLUMN_O_G_C_SP_W_SUBJECT_2 = "lower(wlTask.subject) like lower(CAST_TEXT(?)) AND ";
	private static final String _FINDER_COLUMN_O_G_C_SP_W_SUBJECT_3 = "(wlTask.subject IS NULL OR lower(wlTask.subject) like lower(CAST_TEXT(?))) AND ";
	private static final String _FINDER_COLUMN_O_G_C_SP_W_WORKERID_2 = "wlTask.workerId = ?";
	private static final String _FINDER_COLUMN_O_G_C_SP_P_W_OWNERID_2 = "wlTask.ownerId = ? AND ";
	private static final String _FINDER_COLUMN_O_G_C_SP_P_W_GROUPID_2 = "wlTask.groupId = ? AND ";
	private static final String _FINDER_COLUMN_O_G_C_SP_P_W_COMPANYID_2 = "wlTask.companyId = ? AND ";
	private static final String _FINDER_COLUMN_O_G_C_SP_P_W_SUBJECT_1 = "wlTask.subject like NULL AND ";
	private static final String _FINDER_COLUMN_O_G_C_SP_P_W_SUBJECT_2 = "lower(wlTask.subject) like lower(CAST_TEXT(?)) AND ";
	private static final String _FINDER_COLUMN_O_G_C_SP_P_W_SUBJECT_3 = "(wlTask.subject IS NULL OR lower(wlTask.subject) like lower(CAST_TEXT(?))) AND ";
	private static final String _FINDER_COLUMN_O_G_C_SP_P_W_PROJECTID_2 = "wlTask.projectId = ? AND ";
	private static final String _FINDER_COLUMN_O_G_C_SP_P_W_WORKERID_2 = "wlTask.workerId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "wlTask.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No WLTask exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No WLTask exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(WLTaskPersistenceImpl.class);
	private static WLTask _nullWLTask = new WLTaskImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<WLTask> toCacheModel() {
				return _nullWLTaskCacheModel;
			}
		};

	private static CacheModel<WLTask> _nullWLTaskCacheModel = new CacheModel<WLTask>() {
			public WLTask toEntityModel() {
				return _nullWLTask;
			}
		};
}