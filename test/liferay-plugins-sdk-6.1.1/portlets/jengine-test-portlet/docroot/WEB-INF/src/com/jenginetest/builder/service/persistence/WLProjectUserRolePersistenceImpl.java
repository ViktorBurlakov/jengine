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

import com.jenginetest.builder.NoSuchProjectUserRoleException;
import com.jenginetest.builder.model.WLProjectUserRole;
import com.jenginetest.builder.model.impl.WLProjectUserRoleImpl;
import com.jenginetest.builder.model.impl.WLProjectUserRoleModelImpl;

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
import com.liferay.portal.service.persistence.RolePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the w l project user role service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WLProjectUserRolePersistence
 * @see WLProjectUserRoleUtil
 * @generated
 */
public class WLProjectUserRolePersistenceImpl extends BasePersistenceImpl<WLProjectUserRole>
	implements WLProjectUserRolePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WLProjectUserRoleUtil} to access the w l project user role persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WLProjectUserRoleImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PU = new FinderPath(WLProjectUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectUserRoleModelImpl.FINDER_CACHE_ENABLED,
			WLProjectUserRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPU",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PU = new FinderPath(WLProjectUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectUserRoleModelImpl.FINDER_CACHE_ENABLED,
			WLProjectUserRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPU",
			new String[] { Long.class.getName() },
			WLProjectUserRoleModelImpl.PROJECTUSERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PU = new FinderPath(WLProjectUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectUserRoleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPU",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_R = new FinderPath(WLProjectUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectUserRoleModelImpl.FINDER_CACHE_ENABLED,
			WLProjectUserRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByR",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_R = new FinderPath(WLProjectUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectUserRoleModelImpl.FINDER_CACHE_ENABLED,
			WLProjectUserRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByR",
			new String[] { Long.class.getName() },
			WLProjectUserRoleModelImpl.ROLEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_R = new FinderPath(WLProjectUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectUserRoleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByR",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_C_ROLE = new FinderPath(WLProjectUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectUserRoleModelImpl.FINDER_CACHE_ENABLED,
			WLProjectUserRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_C_Role",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C_ROLE =
		new FinderPath(WLProjectUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectUserRoleModelImpl.FINDER_CACHE_ENABLED,
			WLProjectUserRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_C_Role",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			WLProjectUserRoleModelImpl.GROUPID_COLUMN_BITMASK |
			WLProjectUserRoleModelImpl.COMPANYID_COLUMN_BITMASK |
			WLProjectUserRoleModelImpl.ROLEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_C_ROLE = new FinderPath(WLProjectUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectUserRoleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_C_Role",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});
	public static final FinderPath FINDER_PATH_FETCH_BY_PROJECTUSERANDROLE = new FinderPath(WLProjectUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectUserRoleModelImpl.FINDER_CACHE_ENABLED,
			WLProjectUserRoleImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByProjectUserAndRole",
			new String[] { Long.class.getName(), Long.class.getName() },
			WLProjectUserRoleModelImpl.PROJECTUSERID_COLUMN_BITMASK |
			WLProjectUserRoleModelImpl.ROLEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROJECTUSERANDROLE = new FinderPath(WLProjectUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectUserRoleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByProjectUserAndRole",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WLProjectUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectUserRoleModelImpl.FINDER_CACHE_ENABLED,
			WLProjectUserRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WLProjectUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectUserRoleModelImpl.FINDER_CACHE_ENABLED,
			WLProjectUserRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WLProjectUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectUserRoleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the w l project user role in the entity cache if it is enabled.
	 *
	 * @param wlProjectUserRole the w l project user role
	 */
	public void cacheResult(WLProjectUserRole wlProjectUserRole) {
		EntityCacheUtil.putResult(WLProjectUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectUserRoleImpl.class, wlProjectUserRole.getPrimaryKey(),
			wlProjectUserRole);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROJECTUSERANDROLE,
			new Object[] {
				Long.valueOf(wlProjectUserRole.getProjectUserId()),
				Long.valueOf(wlProjectUserRole.getRoleId())
			}, wlProjectUserRole);

		wlProjectUserRole.resetOriginalValues();
	}

	/**
	 * Caches the w l project user roles in the entity cache if it is enabled.
	 *
	 * @param wlProjectUserRoles the w l project user roles
	 */
	public void cacheResult(List<WLProjectUserRole> wlProjectUserRoles) {
		for (WLProjectUserRole wlProjectUserRole : wlProjectUserRoles) {
			if (EntityCacheUtil.getResult(
						WLProjectUserRoleModelImpl.ENTITY_CACHE_ENABLED,
						WLProjectUserRoleImpl.class,
						wlProjectUserRole.getPrimaryKey()) == null) {
				cacheResult(wlProjectUserRole);
			}
			else {
				wlProjectUserRole.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all w l project user roles.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(WLProjectUserRoleImpl.class.getName());
		}

		EntityCacheUtil.clearCache(WLProjectUserRoleImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the w l project user role.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WLProjectUserRole wlProjectUserRole) {
		EntityCacheUtil.removeResult(WLProjectUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectUserRoleImpl.class, wlProjectUserRole.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(wlProjectUserRole);
	}

	@Override
	public void clearCache(List<WLProjectUserRole> wlProjectUserRoles) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (WLProjectUserRole wlProjectUserRole : wlProjectUserRoles) {
			EntityCacheUtil.removeResult(WLProjectUserRoleModelImpl.ENTITY_CACHE_ENABLED,
				WLProjectUserRoleImpl.class, wlProjectUserRole.getPrimaryKey());

			clearUniqueFindersCache(wlProjectUserRole);
		}
	}

	protected void clearUniqueFindersCache(WLProjectUserRole wlProjectUserRole) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PROJECTUSERANDROLE,
			new Object[] {
				Long.valueOf(wlProjectUserRole.getProjectUserId()),
				Long.valueOf(wlProjectUserRole.getRoleId())
			});
	}

	/**
	 * Creates a new w l project user role with the primary key. Does not add the w l project user role to the database.
	 *
	 * @param projectUserRoleId the primary key for the new w l project user role
	 * @return the new w l project user role
	 */
	public WLProjectUserRole create(long projectUserRoleId) {
		WLProjectUserRole wlProjectUserRole = new WLProjectUserRoleImpl();

		wlProjectUserRole.setNew(true);
		wlProjectUserRole.setPrimaryKey(projectUserRoleId);

		return wlProjectUserRole;
	}

	/**
	 * Removes the w l project user role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param projectUserRoleId the primary key of the w l project user role
	 * @return the w l project user role that was removed
	 * @throws com.jenginetest.builder.NoSuchProjectUserRoleException if a w l project user role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProjectUserRole remove(long projectUserRoleId)
		throws NoSuchProjectUserRoleException, SystemException {
		return remove(Long.valueOf(projectUserRoleId));
	}

	/**
	 * Removes the w l project user role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the w l project user role
	 * @return the w l project user role that was removed
	 * @throws com.jenginetest.builder.NoSuchProjectUserRoleException if a w l project user role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WLProjectUserRole remove(Serializable primaryKey)
		throws NoSuchProjectUserRoleException, SystemException {
		Session session = null;

		try {
			session = openSession();

			WLProjectUserRole wlProjectUserRole = (WLProjectUserRole)session.get(WLProjectUserRoleImpl.class,
					primaryKey);

			if (wlProjectUserRole == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProjectUserRoleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(wlProjectUserRole);
		}
		catch (NoSuchProjectUserRoleException nsee) {
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
	protected WLProjectUserRole removeImpl(WLProjectUserRole wlProjectUserRole)
		throws SystemException {
		wlProjectUserRole = toUnwrappedModel(wlProjectUserRole);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, wlProjectUserRole);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(wlProjectUserRole);

		return wlProjectUserRole;
	}

	@Override
	public WLProjectUserRole updateImpl(
		com.jenginetest.builder.model.WLProjectUserRole wlProjectUserRole,
		boolean merge) throws SystemException {
		wlProjectUserRole = toUnwrappedModel(wlProjectUserRole);

		boolean isNew = wlProjectUserRole.isNew();

		WLProjectUserRoleModelImpl wlProjectUserRoleModelImpl = (WLProjectUserRoleModelImpl)wlProjectUserRole;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, wlProjectUserRole, merge);

			wlProjectUserRole.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !WLProjectUserRoleModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((wlProjectUserRoleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PU.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(wlProjectUserRoleModelImpl.getOriginalProjectUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PU, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PU,
					args);

				args = new Object[] {
						Long.valueOf(wlProjectUserRoleModelImpl.getProjectUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PU, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PU,
					args);
			}

			if ((wlProjectUserRoleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_R.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(wlProjectUserRoleModelImpl.getOriginalRoleId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_R, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_R,
					args);

				args = new Object[] {
						Long.valueOf(wlProjectUserRoleModelImpl.getRoleId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_R, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_R,
					args);
			}

			if ((wlProjectUserRoleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C_ROLE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(wlProjectUserRoleModelImpl.getOriginalGroupId()),
						Long.valueOf(wlProjectUserRoleModelImpl.getOriginalCompanyId()),
						Long.valueOf(wlProjectUserRoleModelImpl.getOriginalRoleId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_C_ROLE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C_ROLE,
					args);

				args = new Object[] {
						Long.valueOf(wlProjectUserRoleModelImpl.getGroupId()),
						Long.valueOf(wlProjectUserRoleModelImpl.getCompanyId()),
						Long.valueOf(wlProjectUserRoleModelImpl.getRoleId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_C_ROLE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C_ROLE,
					args);
			}
		}

		EntityCacheUtil.putResult(WLProjectUserRoleModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectUserRoleImpl.class, wlProjectUserRole.getPrimaryKey(),
			wlProjectUserRole);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROJECTUSERANDROLE,
				new Object[] {
					Long.valueOf(wlProjectUserRole.getProjectUserId()),
					Long.valueOf(wlProjectUserRole.getRoleId())
				}, wlProjectUserRole);
		}
		else {
			if ((wlProjectUserRoleModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PROJECTUSERANDROLE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(wlProjectUserRoleModelImpl.getOriginalProjectUserId()),
						Long.valueOf(wlProjectUserRoleModelImpl.getOriginalRoleId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROJECTUSERANDROLE,
					args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PROJECTUSERANDROLE,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROJECTUSERANDROLE,
					new Object[] {
						Long.valueOf(wlProjectUserRole.getProjectUserId()),
						Long.valueOf(wlProjectUserRole.getRoleId())
					}, wlProjectUserRole);
			}
		}

		return wlProjectUserRole;
	}

	protected WLProjectUserRole toUnwrappedModel(
		WLProjectUserRole wlProjectUserRole) {
		if (wlProjectUserRole instanceof WLProjectUserRoleImpl) {
			return wlProjectUserRole;
		}

		WLProjectUserRoleImpl wlProjectUserRoleImpl = new WLProjectUserRoleImpl();

		wlProjectUserRoleImpl.setNew(wlProjectUserRole.isNew());
		wlProjectUserRoleImpl.setPrimaryKey(wlProjectUserRole.getPrimaryKey());

		wlProjectUserRoleImpl.setGroupId(wlProjectUserRole.getGroupId());
		wlProjectUserRoleImpl.setCompanyId(wlProjectUserRole.getCompanyId());
		wlProjectUserRoleImpl.setProjectUserRoleId(wlProjectUserRole.getProjectUserRoleId());
		wlProjectUserRoleImpl.setProjectUserId(wlProjectUserRole.getProjectUserId());
		wlProjectUserRoleImpl.setRoleId(wlProjectUserRole.getRoleId());

		return wlProjectUserRoleImpl;
	}

	/**
	 * Returns the w l project user role with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the w l project user role
	 * @return the w l project user role
	 * @throws com.liferay.portal.NoSuchModelException if a w l project user role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WLProjectUserRole findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the w l project user role with the primary key or throws a {@link com.jenginetest.builder.NoSuchProjectUserRoleException} if it could not be found.
	 *
	 * @param projectUserRoleId the primary key of the w l project user role
	 * @return the w l project user role
	 * @throws com.jenginetest.builder.NoSuchProjectUserRoleException if a w l project user role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProjectUserRole findByPrimaryKey(long projectUserRoleId)
		throws NoSuchProjectUserRoleException, SystemException {
		WLProjectUserRole wlProjectUserRole = fetchByPrimaryKey(projectUserRoleId);

		if (wlProjectUserRole == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + projectUserRoleId);
			}

			throw new NoSuchProjectUserRoleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				projectUserRoleId);
		}

		return wlProjectUserRole;
	}

	/**
	 * Returns the w l project user role with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the w l project user role
	 * @return the w l project user role, or <code>null</code> if a w l project user role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WLProjectUserRole fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the w l project user role with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param projectUserRoleId the primary key of the w l project user role
	 * @return the w l project user role, or <code>null</code> if a w l project user role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProjectUserRole fetchByPrimaryKey(long projectUserRoleId)
		throws SystemException {
		WLProjectUserRole wlProjectUserRole = (WLProjectUserRole)EntityCacheUtil.getResult(WLProjectUserRoleModelImpl.ENTITY_CACHE_ENABLED,
				WLProjectUserRoleImpl.class, projectUserRoleId);

		if (wlProjectUserRole == _nullWLProjectUserRole) {
			return null;
		}

		if (wlProjectUserRole == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				wlProjectUserRole = (WLProjectUserRole)session.get(WLProjectUserRoleImpl.class,
						Long.valueOf(projectUserRoleId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (wlProjectUserRole != null) {
					cacheResult(wlProjectUserRole);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(WLProjectUserRoleModelImpl.ENTITY_CACHE_ENABLED,
						WLProjectUserRoleImpl.class, projectUserRoleId,
						_nullWLProjectUserRole);
				}

				closeSession(session);
			}
		}

		return wlProjectUserRole;
	}

	/**
	 * Returns all the w l project user roles where projectUserId = &#63;.
	 *
	 * @param projectUserId the project user ID
	 * @return the matching w l project user roles
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLProjectUserRole> findByPU(long projectUserId)
		throws SystemException {
		return findByPU(projectUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the w l project user roles where projectUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param projectUserId the project user ID
	 * @param start the lower bound of the range of w l project user roles
	 * @param end the upper bound of the range of w l project user roles (not inclusive)
	 * @return the range of matching w l project user roles
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLProjectUserRole> findByPU(long projectUserId, int start,
		int end) throws SystemException {
		return findByPU(projectUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the w l project user roles where projectUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param projectUserId the project user ID
	 * @param start the lower bound of the range of w l project user roles
	 * @param end the upper bound of the range of w l project user roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching w l project user roles
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLProjectUserRole> findByPU(long projectUserId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PU;
			finderArgs = new Object[] { projectUserId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PU;
			finderArgs = new Object[] {
					projectUserId,
					
					start, end, orderByComparator
				};
		}

		List<WLProjectUserRole> list = (List<WLProjectUserRole>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (WLProjectUserRole wlProjectUserRole : list) {
				if ((projectUserId != wlProjectUserRole.getProjectUserId())) {
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

			query.append(_SQL_SELECT_WLPROJECTUSERROLE_WHERE);

			query.append(_FINDER_COLUMN_PU_PROJECTUSERID_2);

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

				qPos.add(projectUserId);

				list = (List<WLProjectUserRole>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first w l project user role in the ordered set where projectUserId = &#63;.
	 *
	 * @param projectUserId the project user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching w l project user role
	 * @throws com.jenginetest.builder.NoSuchProjectUserRoleException if a matching w l project user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProjectUserRole findByPU_First(long projectUserId,
		OrderByComparator orderByComparator)
		throws NoSuchProjectUserRoleException, SystemException {
		WLProjectUserRole wlProjectUserRole = fetchByPU_First(projectUserId,
				orderByComparator);

		if (wlProjectUserRole != null) {
			return wlProjectUserRole;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("projectUserId=");
		msg.append(projectUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectUserRoleException(msg.toString());
	}

	/**
	 * Returns the first w l project user role in the ordered set where projectUserId = &#63;.
	 *
	 * @param projectUserId the project user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching w l project user role, or <code>null</code> if a matching w l project user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProjectUserRole fetchByPU_First(long projectUserId,
		OrderByComparator orderByComparator) throws SystemException {
		List<WLProjectUserRole> list = findByPU(projectUserId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last w l project user role in the ordered set where projectUserId = &#63;.
	 *
	 * @param projectUserId the project user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching w l project user role
	 * @throws com.jenginetest.builder.NoSuchProjectUserRoleException if a matching w l project user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProjectUserRole findByPU_Last(long projectUserId,
		OrderByComparator orderByComparator)
		throws NoSuchProjectUserRoleException, SystemException {
		WLProjectUserRole wlProjectUserRole = fetchByPU_Last(projectUserId,
				orderByComparator);

		if (wlProjectUserRole != null) {
			return wlProjectUserRole;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("projectUserId=");
		msg.append(projectUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectUserRoleException(msg.toString());
	}

	/**
	 * Returns the last w l project user role in the ordered set where projectUserId = &#63;.
	 *
	 * @param projectUserId the project user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching w l project user role, or <code>null</code> if a matching w l project user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProjectUserRole fetchByPU_Last(long projectUserId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPU(projectUserId);

		List<WLProjectUserRole> list = findByPU(projectUserId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the w l project user roles before and after the current w l project user role in the ordered set where projectUserId = &#63;.
	 *
	 * @param projectUserRoleId the primary key of the current w l project user role
	 * @param projectUserId the project user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next w l project user role
	 * @throws com.jenginetest.builder.NoSuchProjectUserRoleException if a w l project user role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProjectUserRole[] findByPU_PrevAndNext(long projectUserRoleId,
		long projectUserId, OrderByComparator orderByComparator)
		throws NoSuchProjectUserRoleException, SystemException {
		WLProjectUserRole wlProjectUserRole = findByPrimaryKey(projectUserRoleId);

		Session session = null;

		try {
			session = openSession();

			WLProjectUserRole[] array = new WLProjectUserRoleImpl[3];

			array[0] = getByPU_PrevAndNext(session, wlProjectUserRole,
					projectUserId, orderByComparator, true);

			array[1] = wlProjectUserRole;

			array[2] = getByPU_PrevAndNext(session, wlProjectUserRole,
					projectUserId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WLProjectUserRole getByPU_PrevAndNext(Session session,
		WLProjectUserRole wlProjectUserRole, long projectUserId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WLPROJECTUSERROLE_WHERE);

		query.append(_FINDER_COLUMN_PU_PROJECTUSERID_2);

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

		qPos.add(projectUserId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wlProjectUserRole);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WLProjectUserRole> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the w l project user roles where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @return the matching w l project user roles
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLProjectUserRole> findByR(long roleId)
		throws SystemException {
		return findByR(roleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the w l project user roles where roleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param roleId the role ID
	 * @param start the lower bound of the range of w l project user roles
	 * @param end the upper bound of the range of w l project user roles (not inclusive)
	 * @return the range of matching w l project user roles
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLProjectUserRole> findByR(long roleId, int start, int end)
		throws SystemException {
		return findByR(roleId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the w l project user roles where roleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param roleId the role ID
	 * @param start the lower bound of the range of w l project user roles
	 * @param end the upper bound of the range of w l project user roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching w l project user roles
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLProjectUserRole> findByR(long roleId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_R;
			finderArgs = new Object[] { roleId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_R;
			finderArgs = new Object[] { roleId, start, end, orderByComparator };
		}

		List<WLProjectUserRole> list = (List<WLProjectUserRole>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (WLProjectUserRole wlProjectUserRole : list) {
				if ((roleId != wlProjectUserRole.getRoleId())) {
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

			query.append(_SQL_SELECT_WLPROJECTUSERROLE_WHERE);

			query.append(_FINDER_COLUMN_R_ROLEID_2);

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

				qPos.add(roleId);

				list = (List<WLProjectUserRole>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first w l project user role in the ordered set where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching w l project user role
	 * @throws com.jenginetest.builder.NoSuchProjectUserRoleException if a matching w l project user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProjectUserRole findByR_First(long roleId,
		OrderByComparator orderByComparator)
		throws NoSuchProjectUserRoleException, SystemException {
		WLProjectUserRole wlProjectUserRole = fetchByR_First(roleId,
				orderByComparator);

		if (wlProjectUserRole != null) {
			return wlProjectUserRole;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("roleId=");
		msg.append(roleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectUserRoleException(msg.toString());
	}

	/**
	 * Returns the first w l project user role in the ordered set where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching w l project user role, or <code>null</code> if a matching w l project user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProjectUserRole fetchByR_First(long roleId,
		OrderByComparator orderByComparator) throws SystemException {
		List<WLProjectUserRole> list = findByR(roleId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last w l project user role in the ordered set where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching w l project user role
	 * @throws com.jenginetest.builder.NoSuchProjectUserRoleException if a matching w l project user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProjectUserRole findByR_Last(long roleId,
		OrderByComparator orderByComparator)
		throws NoSuchProjectUserRoleException, SystemException {
		WLProjectUserRole wlProjectUserRole = fetchByR_Last(roleId,
				orderByComparator);

		if (wlProjectUserRole != null) {
			return wlProjectUserRole;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("roleId=");
		msg.append(roleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectUserRoleException(msg.toString());
	}

	/**
	 * Returns the last w l project user role in the ordered set where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching w l project user role, or <code>null</code> if a matching w l project user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProjectUserRole fetchByR_Last(long roleId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByR(roleId);

		List<WLProjectUserRole> list = findByR(roleId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the w l project user roles before and after the current w l project user role in the ordered set where roleId = &#63;.
	 *
	 * @param projectUserRoleId the primary key of the current w l project user role
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next w l project user role
	 * @throws com.jenginetest.builder.NoSuchProjectUserRoleException if a w l project user role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProjectUserRole[] findByR_PrevAndNext(long projectUserRoleId,
		long roleId, OrderByComparator orderByComparator)
		throws NoSuchProjectUserRoleException, SystemException {
		WLProjectUserRole wlProjectUserRole = findByPrimaryKey(projectUserRoleId);

		Session session = null;

		try {
			session = openSession();

			WLProjectUserRole[] array = new WLProjectUserRoleImpl[3];

			array[0] = getByR_PrevAndNext(session, wlProjectUserRole, roleId,
					orderByComparator, true);

			array[1] = wlProjectUserRole;

			array[2] = getByR_PrevAndNext(session, wlProjectUserRole, roleId,
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

	protected WLProjectUserRole getByR_PrevAndNext(Session session,
		WLProjectUserRole wlProjectUserRole, long roleId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WLPROJECTUSERROLE_WHERE);

		query.append(_FINDER_COLUMN_R_ROLEID_2);

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

		qPos.add(roleId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wlProjectUserRole);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WLProjectUserRole> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the w l project user roles where groupId = &#63; and companyId = &#63; and roleId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param roleId the role ID
	 * @return the matching w l project user roles
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLProjectUserRole> findByG_C_Role(long groupId, long companyId,
		long roleId) throws SystemException {
		return findByG_C_Role(groupId, companyId, roleId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the w l project user roles where groupId = &#63; and companyId = &#63; and roleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param roleId the role ID
	 * @param start the lower bound of the range of w l project user roles
	 * @param end the upper bound of the range of w l project user roles (not inclusive)
	 * @return the range of matching w l project user roles
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLProjectUserRole> findByG_C_Role(long groupId, long companyId,
		long roleId, int start, int end) throws SystemException {
		return findByG_C_Role(groupId, companyId, roleId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the w l project user roles where groupId = &#63; and companyId = &#63; and roleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param roleId the role ID
	 * @param start the lower bound of the range of w l project user roles
	 * @param end the upper bound of the range of w l project user roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching w l project user roles
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLProjectUserRole> findByG_C_Role(long groupId, long companyId,
		long roleId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_C_ROLE;
			finderArgs = new Object[] { groupId, companyId, roleId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_C_ROLE;
			finderArgs = new Object[] {
					groupId, companyId, roleId,
					
					start, end, orderByComparator
				};
		}

		List<WLProjectUserRole> list = (List<WLProjectUserRole>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (WLProjectUserRole wlProjectUserRole : list) {
				if ((groupId != wlProjectUserRole.getGroupId()) ||
						(companyId != wlProjectUserRole.getCompanyId()) ||
						(roleId != wlProjectUserRole.getRoleId())) {
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

			query.append(_SQL_SELECT_WLPROJECTUSERROLE_WHERE);

			query.append(_FINDER_COLUMN_G_C_ROLE_GROUPID_2);

			query.append(_FINDER_COLUMN_G_C_ROLE_COMPANYID_2);

			query.append(_FINDER_COLUMN_G_C_ROLE_ROLEID_2);

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

				qPos.add(roleId);

				list = (List<WLProjectUserRole>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first w l project user role in the ordered set where groupId = &#63; and companyId = &#63; and roleId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching w l project user role
	 * @throws com.jenginetest.builder.NoSuchProjectUserRoleException if a matching w l project user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProjectUserRole findByG_C_Role_First(long groupId, long companyId,
		long roleId, OrderByComparator orderByComparator)
		throws NoSuchProjectUserRoleException, SystemException {
		WLProjectUserRole wlProjectUserRole = fetchByG_C_Role_First(groupId,
				companyId, roleId, orderByComparator);

		if (wlProjectUserRole != null) {
			return wlProjectUserRole;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", roleId=");
		msg.append(roleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectUserRoleException(msg.toString());
	}

	/**
	 * Returns the first w l project user role in the ordered set where groupId = &#63; and companyId = &#63; and roleId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching w l project user role, or <code>null</code> if a matching w l project user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProjectUserRole fetchByG_C_Role_First(long groupId,
		long companyId, long roleId, OrderByComparator orderByComparator)
		throws SystemException {
		List<WLProjectUserRole> list = findByG_C_Role(groupId, companyId,
				roleId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last w l project user role in the ordered set where groupId = &#63; and companyId = &#63; and roleId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching w l project user role
	 * @throws com.jenginetest.builder.NoSuchProjectUserRoleException if a matching w l project user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProjectUserRole findByG_C_Role_Last(long groupId, long companyId,
		long roleId, OrderByComparator orderByComparator)
		throws NoSuchProjectUserRoleException, SystemException {
		WLProjectUserRole wlProjectUserRole = fetchByG_C_Role_Last(groupId,
				companyId, roleId, orderByComparator);

		if (wlProjectUserRole != null) {
			return wlProjectUserRole;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", roleId=");
		msg.append(roleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectUserRoleException(msg.toString());
	}

	/**
	 * Returns the last w l project user role in the ordered set where groupId = &#63; and companyId = &#63; and roleId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching w l project user role, or <code>null</code> if a matching w l project user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProjectUserRole fetchByG_C_Role_Last(long groupId, long companyId,
		long roleId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByG_C_Role(groupId, companyId, roleId);

		List<WLProjectUserRole> list = findByG_C_Role(groupId, companyId,
				roleId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the w l project user roles before and after the current w l project user role in the ordered set where groupId = &#63; and companyId = &#63; and roleId = &#63;.
	 *
	 * @param projectUserRoleId the primary key of the current w l project user role
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next w l project user role
	 * @throws com.jenginetest.builder.NoSuchProjectUserRoleException if a w l project user role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProjectUserRole[] findByG_C_Role_PrevAndNext(
		long projectUserRoleId, long groupId, long companyId, long roleId,
		OrderByComparator orderByComparator)
		throws NoSuchProjectUserRoleException, SystemException {
		WLProjectUserRole wlProjectUserRole = findByPrimaryKey(projectUserRoleId);

		Session session = null;

		try {
			session = openSession();

			WLProjectUserRole[] array = new WLProjectUserRoleImpl[3];

			array[0] = getByG_C_Role_PrevAndNext(session, wlProjectUserRole,
					groupId, companyId, roleId, orderByComparator, true);

			array[1] = wlProjectUserRole;

			array[2] = getByG_C_Role_PrevAndNext(session, wlProjectUserRole,
					groupId, companyId, roleId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WLProjectUserRole getByG_C_Role_PrevAndNext(Session session,
		WLProjectUserRole wlProjectUserRole, long groupId, long companyId,
		long roleId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WLPROJECTUSERROLE_WHERE);

		query.append(_FINDER_COLUMN_G_C_ROLE_GROUPID_2);

		query.append(_FINDER_COLUMN_G_C_ROLE_COMPANYID_2);

		query.append(_FINDER_COLUMN_G_C_ROLE_ROLEID_2);

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

		qPos.add(roleId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wlProjectUserRole);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WLProjectUserRole> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the w l project user role where projectUserId = &#63; and roleId = &#63; or throws a {@link com.jenginetest.builder.NoSuchProjectUserRoleException} if it could not be found.
	 *
	 * @param projectUserId the project user ID
	 * @param roleId the role ID
	 * @return the matching w l project user role
	 * @throws com.jenginetest.builder.NoSuchProjectUserRoleException if a matching w l project user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProjectUserRole findByProjectUserAndRole(long projectUserId,
		long roleId) throws NoSuchProjectUserRoleException, SystemException {
		WLProjectUserRole wlProjectUserRole = fetchByProjectUserAndRole(projectUserId,
				roleId);

		if (wlProjectUserRole == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("projectUserId=");
			msg.append(projectUserId);

			msg.append(", roleId=");
			msg.append(roleId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchProjectUserRoleException(msg.toString());
		}

		return wlProjectUserRole;
	}

	/**
	 * Returns the w l project user role where projectUserId = &#63; and roleId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param projectUserId the project user ID
	 * @param roleId the role ID
	 * @return the matching w l project user role, or <code>null</code> if a matching w l project user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProjectUserRole fetchByProjectUserAndRole(long projectUserId,
		long roleId) throws SystemException {
		return fetchByProjectUserAndRole(projectUserId, roleId, true);
	}

	/**
	 * Returns the w l project user role where projectUserId = &#63; and roleId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param projectUserId the project user ID
	 * @param roleId the role ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching w l project user role, or <code>null</code> if a matching w l project user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProjectUserRole fetchByProjectUserAndRole(long projectUserId,
		long roleId, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { projectUserId, roleId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PROJECTUSERANDROLE,
					finderArgs, this);
		}

		if (result instanceof WLProjectUserRole) {
			WLProjectUserRole wlProjectUserRole = (WLProjectUserRole)result;

			if ((projectUserId != wlProjectUserRole.getProjectUserId()) ||
					(roleId != wlProjectUserRole.getRoleId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_WLPROJECTUSERROLE_WHERE);

			query.append(_FINDER_COLUMN_PROJECTUSERANDROLE_PROJECTUSERID_2);

			query.append(_FINDER_COLUMN_PROJECTUSERANDROLE_ROLEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(projectUserId);

				qPos.add(roleId);

				List<WLProjectUserRole> list = q.list();

				result = list;

				WLProjectUserRole wlProjectUserRole = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROJECTUSERANDROLE,
						finderArgs, list);
				}
				else {
					wlProjectUserRole = list.get(0);

					cacheResult(wlProjectUserRole);

					if ((wlProjectUserRole.getProjectUserId() != projectUserId) ||
							(wlProjectUserRole.getRoleId() != roleId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROJECTUSERANDROLE,
							finderArgs, wlProjectUserRole);
					}
				}

				return wlProjectUserRole;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PROJECTUSERANDROLE,
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
				return (WLProjectUserRole)result;
			}
		}
	}

	/**
	 * Returns all the w l project user roles.
	 *
	 * @return the w l project user roles
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLProjectUserRole> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the w l project user roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of w l project user roles
	 * @param end the upper bound of the range of w l project user roles (not inclusive)
	 * @return the range of w l project user roles
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLProjectUserRole> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the w l project user roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of w l project user roles
	 * @param end the upper bound of the range of w l project user roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of w l project user roles
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLProjectUserRole> findAll(int start, int end,
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

		List<WLProjectUserRole> list = (List<WLProjectUserRole>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_WLPROJECTUSERROLE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WLPROJECTUSERROLE;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<WLProjectUserRole>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<WLProjectUserRole>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the w l project user roles where projectUserId = &#63; from the database.
	 *
	 * @param projectUserId the project user ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByPU(long projectUserId) throws SystemException {
		for (WLProjectUserRole wlProjectUserRole : findByPU(projectUserId)) {
			remove(wlProjectUserRole);
		}
	}

	/**
	 * Removes all the w l project user roles where roleId = &#63; from the database.
	 *
	 * @param roleId the role ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByR(long roleId) throws SystemException {
		for (WLProjectUserRole wlProjectUserRole : findByR(roleId)) {
			remove(wlProjectUserRole);
		}
	}

	/**
	 * Removes all the w l project user roles where groupId = &#63; and companyId = &#63; and roleId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param roleId the role ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_C_Role(long groupId, long companyId, long roleId)
		throws SystemException {
		for (WLProjectUserRole wlProjectUserRole : findByG_C_Role(groupId,
				companyId, roleId)) {
			remove(wlProjectUserRole);
		}
	}

	/**
	 * Removes the w l project user role where projectUserId = &#63; and roleId = &#63; from the database.
	 *
	 * @param projectUserId the project user ID
	 * @param roleId the role ID
	 * @return the w l project user role that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public WLProjectUserRole removeByProjectUserAndRole(long projectUserId,
		long roleId) throws NoSuchProjectUserRoleException, SystemException {
		WLProjectUserRole wlProjectUserRole = findByProjectUserAndRole(projectUserId,
				roleId);

		return remove(wlProjectUserRole);
	}

	/**
	 * Removes all the w l project user roles from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (WLProjectUserRole wlProjectUserRole : findAll()) {
			remove(wlProjectUserRole);
		}
	}

	/**
	 * Returns the number of w l project user roles where projectUserId = &#63;.
	 *
	 * @param projectUserId the project user ID
	 * @return the number of matching w l project user roles
	 * @throws SystemException if a system exception occurred
	 */
	public int countByPU(long projectUserId) throws SystemException {
		Object[] finderArgs = new Object[] { projectUserId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PU,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WLPROJECTUSERROLE_WHERE);

			query.append(_FINDER_COLUMN_PU_PROJECTUSERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(projectUserId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PU, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of w l project user roles where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @return the number of matching w l project user roles
	 * @throws SystemException if a system exception occurred
	 */
	public int countByR(long roleId) throws SystemException {
		Object[] finderArgs = new Object[] { roleId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_R,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WLPROJECTUSERROLE_WHERE);

			query.append(_FINDER_COLUMN_R_ROLEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(roleId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_R, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of w l project user roles where groupId = &#63; and companyId = &#63; and roleId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param roleId the role ID
	 * @return the number of matching w l project user roles
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_C_Role(long groupId, long companyId, long roleId)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, companyId, roleId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_C_ROLE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_WLPROJECTUSERROLE_WHERE);

			query.append(_FINDER_COLUMN_G_C_ROLE_GROUPID_2);

			query.append(_FINDER_COLUMN_G_C_ROLE_COMPANYID_2);

			query.append(_FINDER_COLUMN_G_C_ROLE_ROLEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				qPos.add(roleId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_C_ROLE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of w l project user roles where projectUserId = &#63; and roleId = &#63;.
	 *
	 * @param projectUserId the project user ID
	 * @param roleId the role ID
	 * @return the number of matching w l project user roles
	 * @throws SystemException if a system exception occurred
	 */
	public int countByProjectUserAndRole(long projectUserId, long roleId)
		throws SystemException {
		Object[] finderArgs = new Object[] { projectUserId, roleId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PROJECTUSERANDROLE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_WLPROJECTUSERROLE_WHERE);

			query.append(_FINDER_COLUMN_PROJECTUSERANDROLE_PROJECTUSERID_2);

			query.append(_FINDER_COLUMN_PROJECTUSERANDROLE_ROLEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(projectUserId);

				qPos.add(roleId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PROJECTUSERANDROLE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of w l project user roles.
	 *
	 * @return the number of w l project user roles
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_WLPROJECTUSERROLE);

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
	 * Initializes the w l project user role persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.jenginetest.builder.model.WLProjectUserRole")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<WLProjectUserRole>> listenersList = new ArrayList<ModelListener<WLProjectUserRole>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<WLProjectUserRole>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(WLProjectUserRoleImpl.class.getName());
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
	@BeanReference(type = RolePersistence.class)
	protected RolePersistence rolePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_WLPROJECTUSERROLE = "SELECT wlProjectUserRole FROM WLProjectUserRole wlProjectUserRole";
	private static final String _SQL_SELECT_WLPROJECTUSERROLE_WHERE = "SELECT wlProjectUserRole FROM WLProjectUserRole wlProjectUserRole WHERE ";
	private static final String _SQL_COUNT_WLPROJECTUSERROLE = "SELECT COUNT(wlProjectUserRole) FROM WLProjectUserRole wlProjectUserRole";
	private static final String _SQL_COUNT_WLPROJECTUSERROLE_WHERE = "SELECT COUNT(wlProjectUserRole) FROM WLProjectUserRole wlProjectUserRole WHERE ";
	private static final String _FINDER_COLUMN_PU_PROJECTUSERID_2 = "wlProjectUserRole.projectUserId = ?";
	private static final String _FINDER_COLUMN_R_ROLEID_2 = "wlProjectUserRole.roleId = ?";
	private static final String _FINDER_COLUMN_G_C_ROLE_GROUPID_2 = "wlProjectUserRole.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_C_ROLE_COMPANYID_2 = "wlProjectUserRole.companyId = ? AND ";
	private static final String _FINDER_COLUMN_G_C_ROLE_ROLEID_2 = "wlProjectUserRole.roleId = ?";
	private static final String _FINDER_COLUMN_PROJECTUSERANDROLE_PROJECTUSERID_2 =
		"wlProjectUserRole.projectUserId = ? AND ";
	private static final String _FINDER_COLUMN_PROJECTUSERANDROLE_ROLEID_2 = "wlProjectUserRole.roleId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "wlProjectUserRole.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No WLProjectUserRole exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No WLProjectUserRole exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(WLProjectUserRolePersistenceImpl.class);
	private static WLProjectUserRole _nullWLProjectUserRole = new WLProjectUserRoleImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<WLProjectUserRole> toCacheModel() {
				return _nullWLProjectUserRoleCacheModel;
			}
		};

	private static CacheModel<WLProjectUserRole> _nullWLProjectUserRoleCacheModel =
		new CacheModel<WLProjectUserRole>() {
			public WLProjectUserRole toEntityModel() {
				return _nullWLProjectUserRole;
			}
		};
}