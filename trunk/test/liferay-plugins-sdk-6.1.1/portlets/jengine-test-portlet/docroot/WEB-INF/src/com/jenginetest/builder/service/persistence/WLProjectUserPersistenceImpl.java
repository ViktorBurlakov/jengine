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

import com.jenginetest.builder.NoSuchProjectUserException;
import com.jenginetest.builder.model.WLProjectUser;
import com.jenginetest.builder.model.impl.WLProjectUserImpl;
import com.jenginetest.builder.model.impl.WLProjectUserModelImpl;

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
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
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
 * The persistence implementation for the w l project user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WLProjectUserPersistence
 * @see WLProjectUserUtil
 * @generated
 */
public class WLProjectUserPersistenceImpl extends BasePersistenceImpl<WLProjectUser>
	implements WLProjectUserPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WLProjectUserUtil} to access the w l project user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WLProjectUserImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROJECT = new FinderPath(WLProjectUserModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectUserModelImpl.FINDER_CACHE_ENABLED,
			WLProjectUserImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByProject",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT =
		new FinderPath(WLProjectUserModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectUserModelImpl.FINDER_CACHE_ENABLED,
			WLProjectUserImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByProject", new String[] { Long.class.getName() },
			WLProjectUserModelImpl.PROJECTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROJECT = new FinderPath(WLProjectUserModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProject",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USER = new FinderPath(WLProjectUserModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectUserModelImpl.FINDER_CACHE_ENABLED,
			WLProjectUserImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUser",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER = new FinderPath(WLProjectUserModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectUserModelImpl.FINDER_CACHE_ENABLED,
			WLProjectUserImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUser", new String[] { Long.class.getName() },
			WLProjectUserModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USER = new FinderPath(WLProjectUserModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUser",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_C_USER = new FinderPath(WLProjectUserModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectUserModelImpl.FINDER_CACHE_ENABLED,
			WLProjectUserImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByG_C_User",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C_USER =
		new FinderPath(WLProjectUserModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectUserModelImpl.FINDER_CACHE_ENABLED,
			WLProjectUserImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByG_C_User",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			WLProjectUserModelImpl.GROUPID_COLUMN_BITMASK |
			WLProjectUserModelImpl.COMPANYID_COLUMN_BITMASK |
			WLProjectUserModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_C_USER = new FinderPath(WLProjectUserModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_C_User",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});
	public static final FinderPath FINDER_PATH_FETCH_BY_G_C_USERPROJECT = new FinderPath(WLProjectUserModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectUserModelImpl.FINDER_CACHE_ENABLED,
			WLProjectUserImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByG_C_UserProject",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Long.class.getName()
			},
			WLProjectUserModelImpl.GROUPID_COLUMN_BITMASK |
			WLProjectUserModelImpl.COMPANYID_COLUMN_BITMASK |
			WLProjectUserModelImpl.USERID_COLUMN_BITMASK |
			WLProjectUserModelImpl.PROJECTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_C_USERPROJECT = new FinderPath(WLProjectUserModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByG_C_UserProject",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Long.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_C_PROJECT =
		new FinderPath(WLProjectUserModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectUserModelImpl.FINDER_CACHE_ENABLED,
			WLProjectUserImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByG_C_Project",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C_PROJECT =
		new FinderPath(WLProjectUserModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectUserModelImpl.FINDER_CACHE_ENABLED,
			WLProjectUserImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByG_C_Project",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			WLProjectUserModelImpl.GROUPID_COLUMN_BITMASK |
			WLProjectUserModelImpl.COMPANYID_COLUMN_BITMASK |
			WLProjectUserModelImpl.PROJECTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_C_PROJECT = new FinderPath(WLProjectUserModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_C_Project",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});
	public static final FinderPath FINDER_PATH_FETCH_BY_PROJECTANDUSER = new FinderPath(WLProjectUserModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectUserModelImpl.FINDER_CACHE_ENABLED,
			WLProjectUserImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByProjectAndUser",
			new String[] { Long.class.getName(), Long.class.getName() },
			WLProjectUserModelImpl.PROJECTID_COLUMN_BITMASK |
			WLProjectUserModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROJECTANDUSER = new FinderPath(WLProjectUserModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProjectAndUser",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WLProjectUserModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectUserModelImpl.FINDER_CACHE_ENABLED,
			WLProjectUserImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WLProjectUserModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectUserModelImpl.FINDER_CACHE_ENABLED,
			WLProjectUserImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WLProjectUserModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the w l project user in the entity cache if it is enabled.
	 *
	 * @param wlProjectUser the w l project user
	 */
	public void cacheResult(WLProjectUser wlProjectUser) {
		EntityCacheUtil.putResult(WLProjectUserModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectUserImpl.class, wlProjectUser.getPrimaryKey(),
			wlProjectUser);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_C_USERPROJECT,
			new Object[] {
				Long.valueOf(wlProjectUser.getGroupId()),
				Long.valueOf(wlProjectUser.getCompanyId()),
				Long.valueOf(wlProjectUser.getUserId()),
				Long.valueOf(wlProjectUser.getProjectId())
			}, wlProjectUser);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROJECTANDUSER,
			new Object[] {
				Long.valueOf(wlProjectUser.getProjectId()),
				Long.valueOf(wlProjectUser.getUserId())
			}, wlProjectUser);

		wlProjectUser.resetOriginalValues();
	}

	/**
	 * Caches the w l project users in the entity cache if it is enabled.
	 *
	 * @param wlProjectUsers the w l project users
	 */
	public void cacheResult(List<WLProjectUser> wlProjectUsers) {
		for (WLProjectUser wlProjectUser : wlProjectUsers) {
			if (EntityCacheUtil.getResult(
						WLProjectUserModelImpl.ENTITY_CACHE_ENABLED,
						WLProjectUserImpl.class, wlProjectUser.getPrimaryKey()) == null) {
				cacheResult(wlProjectUser);
			}
			else {
				wlProjectUser.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all w l project users.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(WLProjectUserImpl.class.getName());
		}

		EntityCacheUtil.clearCache(WLProjectUserImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the w l project user.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WLProjectUser wlProjectUser) {
		EntityCacheUtil.removeResult(WLProjectUserModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectUserImpl.class, wlProjectUser.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(wlProjectUser);
	}

	@Override
	public void clearCache(List<WLProjectUser> wlProjectUsers) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (WLProjectUser wlProjectUser : wlProjectUsers) {
			EntityCacheUtil.removeResult(WLProjectUserModelImpl.ENTITY_CACHE_ENABLED,
				WLProjectUserImpl.class, wlProjectUser.getPrimaryKey());

			clearUniqueFindersCache(wlProjectUser);
		}
	}

	protected void clearUniqueFindersCache(WLProjectUser wlProjectUser) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_C_USERPROJECT,
			new Object[] {
				Long.valueOf(wlProjectUser.getGroupId()),
				Long.valueOf(wlProjectUser.getCompanyId()),
				Long.valueOf(wlProjectUser.getUserId()),
				Long.valueOf(wlProjectUser.getProjectId())
			});

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PROJECTANDUSER,
			new Object[] {
				Long.valueOf(wlProjectUser.getProjectId()),
				Long.valueOf(wlProjectUser.getUserId())
			});
	}

	/**
	 * Creates a new w l project user with the primary key. Does not add the w l project user to the database.
	 *
	 * @param projectUserId the primary key for the new w l project user
	 * @return the new w l project user
	 */
	public WLProjectUser create(long projectUserId) {
		WLProjectUser wlProjectUser = new WLProjectUserImpl();

		wlProjectUser.setNew(true);
		wlProjectUser.setPrimaryKey(projectUserId);

		return wlProjectUser;
	}

	/**
	 * Removes the w l project user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param projectUserId the primary key of the w l project user
	 * @return the w l project user that was removed
	 * @throws com.jenginetest.builder.NoSuchProjectUserException if a w l project user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProjectUser remove(long projectUserId)
		throws NoSuchProjectUserException, SystemException {
		return remove(Long.valueOf(projectUserId));
	}

	/**
	 * Removes the w l project user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the w l project user
	 * @return the w l project user that was removed
	 * @throws com.jenginetest.builder.NoSuchProjectUserException if a w l project user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WLProjectUser remove(Serializable primaryKey)
		throws NoSuchProjectUserException, SystemException {
		Session session = null;

		try {
			session = openSession();

			WLProjectUser wlProjectUser = (WLProjectUser)session.get(WLProjectUserImpl.class,
					primaryKey);

			if (wlProjectUser == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProjectUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(wlProjectUser);
		}
		catch (NoSuchProjectUserException nsee) {
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
	protected WLProjectUser removeImpl(WLProjectUser wlProjectUser)
		throws SystemException {
		wlProjectUser = toUnwrappedModel(wlProjectUser);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, wlProjectUser);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(wlProjectUser);

		return wlProjectUser;
	}

	@Override
	public WLProjectUser updateImpl(
		com.jenginetest.builder.model.WLProjectUser wlProjectUser, boolean merge)
		throws SystemException {
		wlProjectUser = toUnwrappedModel(wlProjectUser);

		boolean isNew = wlProjectUser.isNew();

		WLProjectUserModelImpl wlProjectUserModelImpl = (WLProjectUserModelImpl)wlProjectUser;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, wlProjectUser, merge);

			wlProjectUser.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !WLProjectUserModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((wlProjectUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(wlProjectUserModelImpl.getOriginalProjectId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROJECT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT,
					args);

				args = new Object[] {
						Long.valueOf(wlProjectUserModelImpl.getProjectId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROJECT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT,
					args);
			}

			if ((wlProjectUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(wlProjectUserModelImpl.getOriginalUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER,
					args);

				args = new Object[] {
						Long.valueOf(wlProjectUserModelImpl.getUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER,
					args);
			}

			if ((wlProjectUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C_USER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(wlProjectUserModelImpl.getOriginalGroupId()),
						Long.valueOf(wlProjectUserModelImpl.getOriginalCompanyId()),
						Long.valueOf(wlProjectUserModelImpl.getOriginalUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_C_USER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C_USER,
					args);

				args = new Object[] {
						Long.valueOf(wlProjectUserModelImpl.getGroupId()),
						Long.valueOf(wlProjectUserModelImpl.getCompanyId()),
						Long.valueOf(wlProjectUserModelImpl.getUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_C_USER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C_USER,
					args);
			}

			if ((wlProjectUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C_PROJECT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(wlProjectUserModelImpl.getOriginalGroupId()),
						Long.valueOf(wlProjectUserModelImpl.getOriginalCompanyId()),
						Long.valueOf(wlProjectUserModelImpl.getOriginalProjectId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_C_PROJECT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C_PROJECT,
					args);

				args = new Object[] {
						Long.valueOf(wlProjectUserModelImpl.getGroupId()),
						Long.valueOf(wlProjectUserModelImpl.getCompanyId()),
						Long.valueOf(wlProjectUserModelImpl.getProjectId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_C_PROJECT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C_PROJECT,
					args);
			}
		}

		EntityCacheUtil.putResult(WLProjectUserModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectUserImpl.class, wlProjectUser.getPrimaryKey(),
			wlProjectUser);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_C_USERPROJECT,
				new Object[] {
					Long.valueOf(wlProjectUser.getGroupId()),
					Long.valueOf(wlProjectUser.getCompanyId()),
					Long.valueOf(wlProjectUser.getUserId()),
					Long.valueOf(wlProjectUser.getProjectId())
				}, wlProjectUser);

			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROJECTANDUSER,
				new Object[] {
					Long.valueOf(wlProjectUser.getProjectId()),
					Long.valueOf(wlProjectUser.getUserId())
				}, wlProjectUser);
		}
		else {
			if ((wlProjectUserModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_G_C_USERPROJECT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(wlProjectUserModelImpl.getOriginalGroupId()),
						Long.valueOf(wlProjectUserModelImpl.getOriginalCompanyId()),
						Long.valueOf(wlProjectUserModelImpl.getOriginalUserId()),
						Long.valueOf(wlProjectUserModelImpl.getOriginalProjectId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_C_USERPROJECT,
					args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_C_USERPROJECT,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_C_USERPROJECT,
					new Object[] {
						Long.valueOf(wlProjectUser.getGroupId()),
						Long.valueOf(wlProjectUser.getCompanyId()),
						Long.valueOf(wlProjectUser.getUserId()),
						Long.valueOf(wlProjectUser.getProjectId())
					}, wlProjectUser);
			}

			if ((wlProjectUserModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PROJECTANDUSER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(wlProjectUserModelImpl.getOriginalProjectId()),
						Long.valueOf(wlProjectUserModelImpl.getOriginalUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROJECTANDUSER,
					args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PROJECTANDUSER,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROJECTANDUSER,
					new Object[] {
						Long.valueOf(wlProjectUser.getProjectId()),
						Long.valueOf(wlProjectUser.getUserId())
					}, wlProjectUser);
			}
		}

		return wlProjectUser;
	}

	protected WLProjectUser toUnwrappedModel(WLProjectUser wlProjectUser) {
		if (wlProjectUser instanceof WLProjectUserImpl) {
			return wlProjectUser;
		}

		WLProjectUserImpl wlProjectUserImpl = new WLProjectUserImpl();

		wlProjectUserImpl.setNew(wlProjectUser.isNew());
		wlProjectUserImpl.setPrimaryKey(wlProjectUser.getPrimaryKey());

		wlProjectUserImpl.setGroupId(wlProjectUser.getGroupId());
		wlProjectUserImpl.setCompanyId(wlProjectUser.getCompanyId());
		wlProjectUserImpl.setProjectUserId(wlProjectUser.getProjectUserId());
		wlProjectUserImpl.setUserId(wlProjectUser.getUserId());
		wlProjectUserImpl.setProjectId(wlProjectUser.getProjectId());

		return wlProjectUserImpl;
	}

	/**
	 * Returns the w l project user with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the w l project user
	 * @return the w l project user
	 * @throws com.liferay.portal.NoSuchModelException if a w l project user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WLProjectUser findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the w l project user with the primary key or throws a {@link com.jenginetest.builder.NoSuchProjectUserException} if it could not be found.
	 *
	 * @param projectUserId the primary key of the w l project user
	 * @return the w l project user
	 * @throws com.jenginetest.builder.NoSuchProjectUserException if a w l project user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProjectUser findByPrimaryKey(long projectUserId)
		throws NoSuchProjectUserException, SystemException {
		WLProjectUser wlProjectUser = fetchByPrimaryKey(projectUserId);

		if (wlProjectUser == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + projectUserId);
			}

			throw new NoSuchProjectUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				projectUserId);
		}

		return wlProjectUser;
	}

	/**
	 * Returns the w l project user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the w l project user
	 * @return the w l project user, or <code>null</code> if a w l project user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WLProjectUser fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the w l project user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param projectUserId the primary key of the w l project user
	 * @return the w l project user, or <code>null</code> if a w l project user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProjectUser fetchByPrimaryKey(long projectUserId)
		throws SystemException {
		WLProjectUser wlProjectUser = (WLProjectUser)EntityCacheUtil.getResult(WLProjectUserModelImpl.ENTITY_CACHE_ENABLED,
				WLProjectUserImpl.class, projectUserId);

		if (wlProjectUser == _nullWLProjectUser) {
			return null;
		}

		if (wlProjectUser == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				wlProjectUser = (WLProjectUser)session.get(WLProjectUserImpl.class,
						Long.valueOf(projectUserId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (wlProjectUser != null) {
					cacheResult(wlProjectUser);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(WLProjectUserModelImpl.ENTITY_CACHE_ENABLED,
						WLProjectUserImpl.class, projectUserId,
						_nullWLProjectUser);
				}

				closeSession(session);
			}
		}

		return wlProjectUser;
	}

	/**
	 * Returns all the w l project users where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the matching w l project users
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLProjectUser> findByProject(long projectId)
		throws SystemException {
		return findByProject(projectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the w l project users where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of w l project users
	 * @param end the upper bound of the range of w l project users (not inclusive)
	 * @return the range of matching w l project users
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLProjectUser> findByProject(long projectId, int start, int end)
		throws SystemException {
		return findByProject(projectId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the w l project users where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of w l project users
	 * @param end the upper bound of the range of w l project users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching w l project users
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLProjectUser> findByProject(long projectId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT;
			finderArgs = new Object[] { projectId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PROJECT;
			finderArgs = new Object[] { projectId, start, end, orderByComparator };
		}

		List<WLProjectUser> list = (List<WLProjectUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (WLProjectUser wlProjectUser : list) {
				if ((projectId != wlProjectUser.getProjectId())) {
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
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_WLPROJECTUSER_WHERE);

			query.append(_FINDER_COLUMN_PROJECT_PROJECTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(projectId);

				list = (List<WLProjectUser>)QueryUtil.list(q, getDialect(),
						start, end);
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
	 * Returns the first w l project user in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching w l project user
	 * @throws com.jenginetest.builder.NoSuchProjectUserException if a matching w l project user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProjectUser findByProject_First(long projectId,
		OrderByComparator orderByComparator)
		throws NoSuchProjectUserException, SystemException {
		WLProjectUser wlProjectUser = fetchByProject_First(projectId,
				orderByComparator);

		if (wlProjectUser != null) {
			return wlProjectUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("projectId=");
		msg.append(projectId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectUserException(msg.toString());
	}

	/**
	 * Returns the first w l project user in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching w l project user, or <code>null</code> if a matching w l project user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProjectUser fetchByProject_First(long projectId,
		OrderByComparator orderByComparator) throws SystemException {
		List<WLProjectUser> list = findByProject(projectId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last w l project user in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching w l project user
	 * @throws com.jenginetest.builder.NoSuchProjectUserException if a matching w l project user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProjectUser findByProject_Last(long projectId,
		OrderByComparator orderByComparator)
		throws NoSuchProjectUserException, SystemException {
		WLProjectUser wlProjectUser = fetchByProject_Last(projectId,
				orderByComparator);

		if (wlProjectUser != null) {
			return wlProjectUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("projectId=");
		msg.append(projectId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectUserException(msg.toString());
	}

	/**
	 * Returns the last w l project user in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching w l project user, or <code>null</code> if a matching w l project user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProjectUser fetchByProject_Last(long projectId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByProject(projectId);

		List<WLProjectUser> list = findByProject(projectId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the w l project users before and after the current w l project user in the ordered set where projectId = &#63;.
	 *
	 * @param projectUserId the primary key of the current w l project user
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next w l project user
	 * @throws com.jenginetest.builder.NoSuchProjectUserException if a w l project user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProjectUser[] findByProject_PrevAndNext(long projectUserId,
		long projectId, OrderByComparator orderByComparator)
		throws NoSuchProjectUserException, SystemException {
		WLProjectUser wlProjectUser = findByPrimaryKey(projectUserId);

		Session session = null;

		try {
			session = openSession();

			WLProjectUser[] array = new WLProjectUserImpl[3];

			array[0] = getByProject_PrevAndNext(session, wlProjectUser,
					projectId, orderByComparator, true);

			array[1] = wlProjectUser;

			array[2] = getByProject_PrevAndNext(session, wlProjectUser,
					projectId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WLProjectUser getByProject_PrevAndNext(Session session,
		WLProjectUser wlProjectUser, long projectId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WLPROJECTUSER_WHERE);

		query.append(_FINDER_COLUMN_PROJECT_PROJECTID_2);

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

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(projectId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wlProjectUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WLProjectUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the w l project users where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching w l project users
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLProjectUser> findByUser(long userId)
		throws SystemException {
		return findByUser(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the w l project users where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of w l project users
	 * @param end the upper bound of the range of w l project users (not inclusive)
	 * @return the range of matching w l project users
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLProjectUser> findByUser(long userId, int start, int end)
		throws SystemException {
		return findByUser(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the w l project users where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of w l project users
	 * @param end the upper bound of the range of w l project users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching w l project users
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLProjectUser> findByUser(long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USER;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<WLProjectUser> list = (List<WLProjectUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (WLProjectUser wlProjectUser : list) {
				if ((userId != wlProjectUser.getUserId())) {
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
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_WLPROJECTUSER_WHERE);

			query.append(_FINDER_COLUMN_USER_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				list = (List<WLProjectUser>)QueryUtil.list(q, getDialect(),
						start, end);
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
	 * Returns the first w l project user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching w l project user
	 * @throws com.jenginetest.builder.NoSuchProjectUserException if a matching w l project user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProjectUser findByUser_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchProjectUserException, SystemException {
		WLProjectUser wlProjectUser = fetchByUser_First(userId,
				orderByComparator);

		if (wlProjectUser != null) {
			return wlProjectUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectUserException(msg.toString());
	}

	/**
	 * Returns the first w l project user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching w l project user, or <code>null</code> if a matching w l project user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProjectUser fetchByUser_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<WLProjectUser> list = findByUser(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last w l project user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching w l project user
	 * @throws com.jenginetest.builder.NoSuchProjectUserException if a matching w l project user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProjectUser findByUser_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchProjectUserException, SystemException {
		WLProjectUser wlProjectUser = fetchByUser_Last(userId, orderByComparator);

		if (wlProjectUser != null) {
			return wlProjectUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectUserException(msg.toString());
	}

	/**
	 * Returns the last w l project user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching w l project user, or <code>null</code> if a matching w l project user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProjectUser fetchByUser_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUser(userId);

		List<WLProjectUser> list = findByUser(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the w l project users before and after the current w l project user in the ordered set where userId = &#63;.
	 *
	 * @param projectUserId the primary key of the current w l project user
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next w l project user
	 * @throws com.jenginetest.builder.NoSuchProjectUserException if a w l project user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProjectUser[] findByUser_PrevAndNext(long projectUserId,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchProjectUserException, SystemException {
		WLProjectUser wlProjectUser = findByPrimaryKey(projectUserId);

		Session session = null;

		try {
			session = openSession();

			WLProjectUser[] array = new WLProjectUserImpl[3];

			array[0] = getByUser_PrevAndNext(session, wlProjectUser, userId,
					orderByComparator, true);

			array[1] = wlProjectUser;

			array[2] = getByUser_PrevAndNext(session, wlProjectUser, userId,
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

	protected WLProjectUser getByUser_PrevAndNext(Session session,
		WLProjectUser wlProjectUser, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WLPROJECTUSER_WHERE);

		query.append(_FINDER_COLUMN_USER_USERID_2);

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

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wlProjectUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WLProjectUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the w l project users where groupId = &#63; and companyId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @return the matching w l project users
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLProjectUser> findByG_C_User(long groupId, long companyId,
		long userId) throws SystemException {
		return findByG_C_User(groupId, companyId, userId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the w l project users where groupId = &#63; and companyId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of w l project users
	 * @param end the upper bound of the range of w l project users (not inclusive)
	 * @return the range of matching w l project users
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLProjectUser> findByG_C_User(long groupId, long companyId,
		long userId, int start, int end) throws SystemException {
		return findByG_C_User(groupId, companyId, userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the w l project users where groupId = &#63; and companyId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of w l project users
	 * @param end the upper bound of the range of w l project users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching w l project users
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLProjectUser> findByG_C_User(long groupId, long companyId,
		long userId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C_USER;
			finderArgs = new Object[] { groupId, companyId, userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_C_USER;
			finderArgs = new Object[] {
					groupId, companyId, userId,
					
					start, end, orderByComparator
				};
		}

		List<WLProjectUser> list = (List<WLProjectUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (WLProjectUser wlProjectUser : list) {
				if ((groupId != wlProjectUser.getGroupId()) ||
						(companyId != wlProjectUser.getCompanyId()) ||
						(userId != wlProjectUser.getUserId())) {
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
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_WLPROJECTUSER_WHERE);

			query.append(_FINDER_COLUMN_G_C_USER_GROUPID_2);

			query.append(_FINDER_COLUMN_G_C_USER_COMPANYID_2);

			query.append(_FINDER_COLUMN_G_C_USER_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				qPos.add(userId);

				list = (List<WLProjectUser>)QueryUtil.list(q, getDialect(),
						start, end);
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
	 * Returns the first w l project user in the ordered set where groupId = &#63; and companyId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching w l project user
	 * @throws com.jenginetest.builder.NoSuchProjectUserException if a matching w l project user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProjectUser findByG_C_User_First(long groupId, long companyId,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchProjectUserException, SystemException {
		WLProjectUser wlProjectUser = fetchByG_C_User_First(groupId, companyId,
				userId, orderByComparator);

		if (wlProjectUser != null) {
			return wlProjectUser;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectUserException(msg.toString());
	}

	/**
	 * Returns the first w l project user in the ordered set where groupId = &#63; and companyId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching w l project user, or <code>null</code> if a matching w l project user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProjectUser fetchByG_C_User_First(long groupId, long companyId,
		long userId, OrderByComparator orderByComparator)
		throws SystemException {
		List<WLProjectUser> list = findByG_C_User(groupId, companyId, userId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last w l project user in the ordered set where groupId = &#63; and companyId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching w l project user
	 * @throws com.jenginetest.builder.NoSuchProjectUserException if a matching w l project user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProjectUser findByG_C_User_Last(long groupId, long companyId,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchProjectUserException, SystemException {
		WLProjectUser wlProjectUser = fetchByG_C_User_Last(groupId, companyId,
				userId, orderByComparator);

		if (wlProjectUser != null) {
			return wlProjectUser;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectUserException(msg.toString());
	}

	/**
	 * Returns the last w l project user in the ordered set where groupId = &#63; and companyId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching w l project user, or <code>null</code> if a matching w l project user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProjectUser fetchByG_C_User_Last(long groupId, long companyId,
		long userId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByG_C_User(groupId, companyId, userId);

		List<WLProjectUser> list = findByG_C_User(groupId, companyId, userId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the w l project users before and after the current w l project user in the ordered set where groupId = &#63; and companyId = &#63; and userId = &#63;.
	 *
	 * @param projectUserId the primary key of the current w l project user
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next w l project user
	 * @throws com.jenginetest.builder.NoSuchProjectUserException if a w l project user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProjectUser[] findByG_C_User_PrevAndNext(long projectUserId,
		long groupId, long companyId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchProjectUserException, SystemException {
		WLProjectUser wlProjectUser = findByPrimaryKey(projectUserId);

		Session session = null;

		try {
			session = openSession();

			WLProjectUser[] array = new WLProjectUserImpl[3];

			array[0] = getByG_C_User_PrevAndNext(session, wlProjectUser,
					groupId, companyId, userId, orderByComparator, true);

			array[1] = wlProjectUser;

			array[2] = getByG_C_User_PrevAndNext(session, wlProjectUser,
					groupId, companyId, userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WLProjectUser getByG_C_User_PrevAndNext(Session session,
		WLProjectUser wlProjectUser, long groupId, long companyId, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WLPROJECTUSER_WHERE);

		query.append(_FINDER_COLUMN_G_C_USER_GROUPID_2);

		query.append(_FINDER_COLUMN_G_C_USER_COMPANYID_2);

		query.append(_FINDER_COLUMN_G_C_USER_USERID_2);

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

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(companyId);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wlProjectUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WLProjectUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the w l project user where groupId = &#63; and companyId = &#63; and userId = &#63; and projectId = &#63; or throws a {@link com.jenginetest.builder.NoSuchProjectUserException} if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param projectId the project ID
	 * @return the matching w l project user
	 * @throws com.jenginetest.builder.NoSuchProjectUserException if a matching w l project user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProjectUser findByG_C_UserProject(long groupId, long companyId,
		long userId, long projectId)
		throws NoSuchProjectUserException, SystemException {
		WLProjectUser wlProjectUser = fetchByG_C_UserProject(groupId,
				companyId, userId, projectId);

		if (wlProjectUser == null) {
			StringBundler msg = new StringBundler(10);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", companyId=");
			msg.append(companyId);

			msg.append(", userId=");
			msg.append(userId);

			msg.append(", projectId=");
			msg.append(projectId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchProjectUserException(msg.toString());
		}

		return wlProjectUser;
	}

	/**
	 * Returns the w l project user where groupId = &#63; and companyId = &#63; and userId = &#63; and projectId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param projectId the project ID
	 * @return the matching w l project user, or <code>null</code> if a matching w l project user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProjectUser fetchByG_C_UserProject(long groupId, long companyId,
		long userId, long projectId) throws SystemException {
		return fetchByG_C_UserProject(groupId, companyId, userId, projectId,
			true);
	}

	/**
	 * Returns the w l project user where groupId = &#63; and companyId = &#63; and userId = &#63; and projectId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param projectId the project ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching w l project user, or <code>null</code> if a matching w l project user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProjectUser fetchByG_C_UserProject(long groupId, long companyId,
		long userId, long projectId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, companyId, userId, projectId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_G_C_USERPROJECT,
					finderArgs, this);
		}

		if (result instanceof WLProjectUser) {
			WLProjectUser wlProjectUser = (WLProjectUser)result;

			if ((groupId != wlProjectUser.getGroupId()) ||
					(companyId != wlProjectUser.getCompanyId()) ||
					(userId != wlProjectUser.getUserId()) ||
					(projectId != wlProjectUser.getProjectId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_WLPROJECTUSER_WHERE);

			query.append(_FINDER_COLUMN_G_C_USERPROJECT_GROUPID_2);

			query.append(_FINDER_COLUMN_G_C_USERPROJECT_COMPANYID_2);

			query.append(_FINDER_COLUMN_G_C_USERPROJECT_USERID_2);

			query.append(_FINDER_COLUMN_G_C_USERPROJECT_PROJECTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				qPos.add(userId);

				qPos.add(projectId);

				List<WLProjectUser> list = q.list();

				result = list;

				WLProjectUser wlProjectUser = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_C_USERPROJECT,
						finderArgs, list);
				}
				else {
					wlProjectUser = list.get(0);

					cacheResult(wlProjectUser);

					if ((wlProjectUser.getGroupId() != groupId) ||
							(wlProjectUser.getCompanyId() != companyId) ||
							(wlProjectUser.getUserId() != userId) ||
							(wlProjectUser.getProjectId() != projectId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_C_USERPROJECT,
							finderArgs, wlProjectUser);
					}
				}

				return wlProjectUser;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_C_USERPROJECT,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (WLProjectUser)result;
			}
		}
	}

	/**
	 * Returns all the w l project users where groupId = &#63; and companyId = &#63; and projectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param projectId the project ID
	 * @return the matching w l project users
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLProjectUser> findByG_C_Project(long groupId, long companyId,
		long projectId) throws SystemException {
		return findByG_C_Project(groupId, companyId, projectId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the w l project users where groupId = &#63; and companyId = &#63; and projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param projectId the project ID
	 * @param start the lower bound of the range of w l project users
	 * @param end the upper bound of the range of w l project users (not inclusive)
	 * @return the range of matching w l project users
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLProjectUser> findByG_C_Project(long groupId, long companyId,
		long projectId, int start, int end) throws SystemException {
		return findByG_C_Project(groupId, companyId, projectId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the w l project users where groupId = &#63; and companyId = &#63; and projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param projectId the project ID
	 * @param start the lower bound of the range of w l project users
	 * @param end the upper bound of the range of w l project users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching w l project users
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLProjectUser> findByG_C_Project(long groupId, long companyId,
		long projectId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C_PROJECT;
			finderArgs = new Object[] { groupId, companyId, projectId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_C_PROJECT;
			finderArgs = new Object[] {
					groupId, companyId, projectId,
					
					start, end, orderByComparator
				};
		}

		List<WLProjectUser> list = (List<WLProjectUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (WLProjectUser wlProjectUser : list) {
				if ((groupId != wlProjectUser.getGroupId()) ||
						(companyId != wlProjectUser.getCompanyId()) ||
						(projectId != wlProjectUser.getProjectId())) {
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
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_WLPROJECTUSER_WHERE);

			query.append(_FINDER_COLUMN_G_C_PROJECT_GROUPID_2);

			query.append(_FINDER_COLUMN_G_C_PROJECT_COMPANYID_2);

			query.append(_FINDER_COLUMN_G_C_PROJECT_PROJECTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				qPos.add(projectId);

				list = (List<WLProjectUser>)QueryUtil.list(q, getDialect(),
						start, end);
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
	 * Returns the first w l project user in the ordered set where groupId = &#63; and companyId = &#63; and projectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching w l project user
	 * @throws com.jenginetest.builder.NoSuchProjectUserException if a matching w l project user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProjectUser findByG_C_Project_First(long groupId, long companyId,
		long projectId, OrderByComparator orderByComparator)
		throws NoSuchProjectUserException, SystemException {
		WLProjectUser wlProjectUser = fetchByG_C_Project_First(groupId,
				companyId, projectId, orderByComparator);

		if (wlProjectUser != null) {
			return wlProjectUser;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", projectId=");
		msg.append(projectId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectUserException(msg.toString());
	}

	/**
	 * Returns the first w l project user in the ordered set where groupId = &#63; and companyId = &#63; and projectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching w l project user, or <code>null</code> if a matching w l project user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProjectUser fetchByG_C_Project_First(long groupId, long companyId,
		long projectId, OrderByComparator orderByComparator)
		throws SystemException {
		List<WLProjectUser> list = findByG_C_Project(groupId, companyId,
				projectId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last w l project user in the ordered set where groupId = &#63; and companyId = &#63; and projectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching w l project user
	 * @throws com.jenginetest.builder.NoSuchProjectUserException if a matching w l project user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProjectUser findByG_C_Project_Last(long groupId, long companyId,
		long projectId, OrderByComparator orderByComparator)
		throws NoSuchProjectUserException, SystemException {
		WLProjectUser wlProjectUser = fetchByG_C_Project_Last(groupId,
				companyId, projectId, orderByComparator);

		if (wlProjectUser != null) {
			return wlProjectUser;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", projectId=");
		msg.append(projectId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectUserException(msg.toString());
	}

	/**
	 * Returns the last w l project user in the ordered set where groupId = &#63; and companyId = &#63; and projectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching w l project user, or <code>null</code> if a matching w l project user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProjectUser fetchByG_C_Project_Last(long groupId, long companyId,
		long projectId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByG_C_Project(groupId, companyId, projectId);

		List<WLProjectUser> list = findByG_C_Project(groupId, companyId,
				projectId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the w l project users before and after the current w l project user in the ordered set where groupId = &#63; and companyId = &#63; and projectId = &#63;.
	 *
	 * @param projectUserId the primary key of the current w l project user
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next w l project user
	 * @throws com.jenginetest.builder.NoSuchProjectUserException if a w l project user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProjectUser[] findByG_C_Project_PrevAndNext(long projectUserId,
		long groupId, long companyId, long projectId,
		OrderByComparator orderByComparator)
		throws NoSuchProjectUserException, SystemException {
		WLProjectUser wlProjectUser = findByPrimaryKey(projectUserId);

		Session session = null;

		try {
			session = openSession();

			WLProjectUser[] array = new WLProjectUserImpl[3];

			array[0] = getByG_C_Project_PrevAndNext(session, wlProjectUser,
					groupId, companyId, projectId, orderByComparator, true);

			array[1] = wlProjectUser;

			array[2] = getByG_C_Project_PrevAndNext(session, wlProjectUser,
					groupId, companyId, projectId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WLProjectUser getByG_C_Project_PrevAndNext(Session session,
		WLProjectUser wlProjectUser, long groupId, long companyId,
		long projectId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WLPROJECTUSER_WHERE);

		query.append(_FINDER_COLUMN_G_C_PROJECT_GROUPID_2);

		query.append(_FINDER_COLUMN_G_C_PROJECT_COMPANYID_2);

		query.append(_FINDER_COLUMN_G_C_PROJECT_PROJECTID_2);

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

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(companyId);

		qPos.add(projectId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wlProjectUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WLProjectUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the w l project user where projectId = &#63; and userId = &#63; or throws a {@link com.jenginetest.builder.NoSuchProjectUserException} if it could not be found.
	 *
	 * @param projectId the project ID
	 * @param userId the user ID
	 * @return the matching w l project user
	 * @throws com.jenginetest.builder.NoSuchProjectUserException if a matching w l project user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProjectUser findByProjectAndUser(long projectId, long userId)
		throws NoSuchProjectUserException, SystemException {
		WLProjectUser wlProjectUser = fetchByProjectAndUser(projectId, userId);

		if (wlProjectUser == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("projectId=");
			msg.append(projectId);

			msg.append(", userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchProjectUserException(msg.toString());
		}

		return wlProjectUser;
	}

	/**
	 * Returns the w l project user where projectId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param projectId the project ID
	 * @param userId the user ID
	 * @return the matching w l project user, or <code>null</code> if a matching w l project user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProjectUser fetchByProjectAndUser(long projectId, long userId)
		throws SystemException {
		return fetchByProjectAndUser(projectId, userId, true);
	}

	/**
	 * Returns the w l project user where projectId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param projectId the project ID
	 * @param userId the user ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching w l project user, or <code>null</code> if a matching w l project user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProjectUser fetchByProjectAndUser(long projectId, long userId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { projectId, userId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PROJECTANDUSER,
					finderArgs, this);
		}

		if (result instanceof WLProjectUser) {
			WLProjectUser wlProjectUser = (WLProjectUser)result;

			if ((projectId != wlProjectUser.getProjectId()) ||
					(userId != wlProjectUser.getUserId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_WLPROJECTUSER_WHERE);

			query.append(_FINDER_COLUMN_PROJECTANDUSER_PROJECTID_2);

			query.append(_FINDER_COLUMN_PROJECTANDUSER_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(projectId);

				qPos.add(userId);

				List<WLProjectUser> list = q.list();

				result = list;

				WLProjectUser wlProjectUser = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROJECTANDUSER,
						finderArgs, list);
				}
				else {
					wlProjectUser = list.get(0);

					cacheResult(wlProjectUser);

					if ((wlProjectUser.getProjectId() != projectId) ||
							(wlProjectUser.getUserId() != userId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROJECTANDUSER,
							finderArgs, wlProjectUser);
					}
				}

				return wlProjectUser;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PROJECTANDUSER,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (WLProjectUser)result;
			}
		}
	}

	/**
	 * Returns all the w l project users.
	 *
	 * @return the w l project users
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLProjectUser> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the w l project users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of w l project users
	 * @param end the upper bound of the range of w l project users (not inclusive)
	 * @return the range of w l project users
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLProjectUser> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the w l project users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of w l project users
	 * @param end the upper bound of the range of w l project users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of w l project users
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLProjectUser> findAll(int start, int end,
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

		List<WLProjectUser> list = (List<WLProjectUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_WLPROJECTUSER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WLPROJECTUSER;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<WLProjectUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<WLProjectUser>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the w l project users where projectId = &#63; from the database.
	 *
	 * @param projectId the project ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByProject(long projectId) throws SystemException {
		for (WLProjectUser wlProjectUser : findByProject(projectId)) {
			remove(wlProjectUser);
		}
	}

	/**
	 * Removes all the w l project users where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUser(long userId) throws SystemException {
		for (WLProjectUser wlProjectUser : findByUser(userId)) {
			remove(wlProjectUser);
		}
	}

	/**
	 * Removes all the w l project users where groupId = &#63; and companyId = &#63; and userId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_C_User(long groupId, long companyId, long userId)
		throws SystemException {
		for (WLProjectUser wlProjectUser : findByG_C_User(groupId, companyId,
				userId)) {
			remove(wlProjectUser);
		}
	}

	/**
	 * Removes the w l project user where groupId = &#63; and companyId = &#63; and userId = &#63; and projectId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param projectId the project ID
	 * @return the w l project user that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public WLProjectUser removeByG_C_UserProject(long groupId, long companyId,
		long userId, long projectId)
		throws NoSuchProjectUserException, SystemException {
		WLProjectUser wlProjectUser = findByG_C_UserProject(groupId, companyId,
				userId, projectId);

		return remove(wlProjectUser);
	}

	/**
	 * Removes all the w l project users where groupId = &#63; and companyId = &#63; and projectId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param projectId the project ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_C_Project(long groupId, long companyId, long projectId)
		throws SystemException {
		for (WLProjectUser wlProjectUser : findByG_C_Project(groupId,
				companyId, projectId)) {
			remove(wlProjectUser);
		}
	}

	/**
	 * Removes the w l project user where projectId = &#63; and userId = &#63; from the database.
	 *
	 * @param projectId the project ID
	 * @param userId the user ID
	 * @return the w l project user that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public WLProjectUser removeByProjectAndUser(long projectId, long userId)
		throws NoSuchProjectUserException, SystemException {
		WLProjectUser wlProjectUser = findByProjectAndUser(projectId, userId);

		return remove(wlProjectUser);
	}

	/**
	 * Removes all the w l project users from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (WLProjectUser wlProjectUser : findAll()) {
			remove(wlProjectUser);
		}
	}

	/**
	 * Returns the number of w l project users where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the number of matching w l project users
	 * @throws SystemException if a system exception occurred
	 */
	public int countByProject(long projectId) throws SystemException {
		Object[] finderArgs = new Object[] { projectId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PROJECT,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WLPROJECTUSER_WHERE);

			query.append(_FINDER_COLUMN_PROJECT_PROJECTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PROJECT,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of w l project users where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching w l project users
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUser(long userId) throws SystemException {
		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USER,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WLPROJECTUSER_WHERE);

			query.append(_FINDER_COLUMN_USER_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USER,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of w l project users where groupId = &#63; and companyId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @return the number of matching w l project users
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_C_User(long groupId, long companyId, long userId)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, companyId, userId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_C_USER,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_WLPROJECTUSER_WHERE);

			query.append(_FINDER_COLUMN_G_C_USER_GROUPID_2);

			query.append(_FINDER_COLUMN_G_C_USER_COMPANYID_2);

			query.append(_FINDER_COLUMN_G_C_USER_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				qPos.add(userId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_C_USER,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of w l project users where groupId = &#63; and companyId = &#63; and userId = &#63; and projectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param projectId the project ID
	 * @return the number of matching w l project users
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_C_UserProject(long groupId, long companyId,
		long userId, long projectId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId, companyId, userId, projectId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_C_USERPROJECT,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_WLPROJECTUSER_WHERE);

			query.append(_FINDER_COLUMN_G_C_USERPROJECT_GROUPID_2);

			query.append(_FINDER_COLUMN_G_C_USERPROJECT_COMPANYID_2);

			query.append(_FINDER_COLUMN_G_C_USERPROJECT_USERID_2);

			query.append(_FINDER_COLUMN_G_C_USERPROJECT_PROJECTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				qPos.add(userId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_C_USERPROJECT,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of w l project users where groupId = &#63; and companyId = &#63; and projectId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param projectId the project ID
	 * @return the number of matching w l project users
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_C_Project(long groupId, long companyId, long projectId)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, companyId, projectId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_C_PROJECT,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_WLPROJECTUSER_WHERE);

			query.append(_FINDER_COLUMN_G_C_PROJECT_GROUPID_2);

			query.append(_FINDER_COLUMN_G_C_PROJECT_COMPANYID_2);

			query.append(_FINDER_COLUMN_G_C_PROJECT_PROJECTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_C_PROJECT,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of w l project users where projectId = &#63; and userId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param userId the user ID
	 * @return the number of matching w l project users
	 * @throws SystemException if a system exception occurred
	 */
	public int countByProjectAndUser(long projectId, long userId)
		throws SystemException {
		Object[] finderArgs = new Object[] { projectId, userId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PROJECTANDUSER,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_WLPROJECTUSER_WHERE);

			query.append(_FINDER_COLUMN_PROJECTANDUSER_PROJECTID_2);

			query.append(_FINDER_COLUMN_PROJECTANDUSER_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(projectId);

				qPos.add(userId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PROJECTANDUSER,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of w l project users.
	 *
	 * @return the number of w l project users
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_WLPROJECTUSER);

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
	 * Initializes the w l project user persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.jenginetest.builder.model.WLProjectUser")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<WLProjectUser>> listenersList = new ArrayList<ModelListener<WLProjectUser>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<WLProjectUser>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(WLProjectUserImpl.class.getName());
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
	private static final String _SQL_SELECT_WLPROJECTUSER = "SELECT wlProjectUser FROM WLProjectUser wlProjectUser";
	private static final String _SQL_SELECT_WLPROJECTUSER_WHERE = "SELECT wlProjectUser FROM WLProjectUser wlProjectUser WHERE ";
	private static final String _SQL_COUNT_WLPROJECTUSER = "SELECT COUNT(wlProjectUser) FROM WLProjectUser wlProjectUser";
	private static final String _SQL_COUNT_WLPROJECTUSER_WHERE = "SELECT COUNT(wlProjectUser) FROM WLProjectUser wlProjectUser WHERE ";
	private static final String _FINDER_COLUMN_PROJECT_PROJECTID_2 = "wlProjectUser.projectId = ?";
	private static final String _FINDER_COLUMN_USER_USERID_2 = "wlProjectUser.userId = ?";
	private static final String _FINDER_COLUMN_G_C_USER_GROUPID_2 = "wlProjectUser.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_C_USER_COMPANYID_2 = "wlProjectUser.companyId = ? AND ";
	private static final String _FINDER_COLUMN_G_C_USER_USERID_2 = "wlProjectUser.userId = ?";
	private static final String _FINDER_COLUMN_G_C_USERPROJECT_GROUPID_2 = "wlProjectUser.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_C_USERPROJECT_COMPANYID_2 = "wlProjectUser.companyId = ? AND ";
	private static final String _FINDER_COLUMN_G_C_USERPROJECT_USERID_2 = "wlProjectUser.userId = ? AND ";
	private static final String _FINDER_COLUMN_G_C_USERPROJECT_PROJECTID_2 = "wlProjectUser.projectId = ?";
	private static final String _FINDER_COLUMN_G_C_PROJECT_GROUPID_2 = "wlProjectUser.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_C_PROJECT_COMPANYID_2 = "wlProjectUser.companyId = ? AND ";
	private static final String _FINDER_COLUMN_G_C_PROJECT_PROJECTID_2 = "wlProjectUser.projectId = ?";
	private static final String _FINDER_COLUMN_PROJECTANDUSER_PROJECTID_2 = "wlProjectUser.projectId = ? AND ";
	private static final String _FINDER_COLUMN_PROJECTANDUSER_USERID_2 = "wlProjectUser.userId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "wlProjectUser.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No WLProjectUser exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No WLProjectUser exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(WLProjectUserPersistenceImpl.class);
	private static WLProjectUser _nullWLProjectUser = new WLProjectUserImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<WLProjectUser> toCacheModel() {
				return _nullWLProjectUserCacheModel;
			}
		};

	private static CacheModel<WLProjectUser> _nullWLProjectUserCacheModel = new CacheModel<WLProjectUser>() {
			public WLProjectUser toEntityModel() {
				return _nullWLProjectUser;
			}
		};
}