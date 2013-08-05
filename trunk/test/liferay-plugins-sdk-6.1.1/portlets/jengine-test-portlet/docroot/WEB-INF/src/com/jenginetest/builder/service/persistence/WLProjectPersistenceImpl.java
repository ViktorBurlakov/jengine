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

import com.jenginetest.builder.NoSuchProjectException;
import com.jenginetest.builder.model.WLProject;
import com.jenginetest.builder.model.impl.WLProjectImpl;
import com.jenginetest.builder.model.impl.WLProjectModelImpl;

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
 * The persistence implementation for the w l project service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WLProjectPersistence
 * @see WLProjectUtil
 * @generated
 */
public class WLProjectPersistenceImpl extends BasePersistenceImpl<WLProject>
	implements WLProjectPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WLProjectUtil} to access the w l project persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WLProjectImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(WLProjectModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectModelImpl.FINDER_CACHE_ENABLED, WLProjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(WLProjectModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectModelImpl.FINDER_CACHE_ENABLED, WLProjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			WLProjectModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(WLProjectModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPCOMPANY =
		new FinderPath(WLProjectModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectModelImpl.FINDER_CACHE_ENABLED, WLProjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupCompany",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPCOMPANY =
		new FinderPath(WLProjectModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectModelImpl.FINDER_CACHE_ENABLED, WLProjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupCompany",
			new String[] { Long.class.getName(), Long.class.getName() },
			WLProjectModelImpl.GROUPID_COLUMN_BITMASK |
			WLProjectModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPCOMPANY = new FinderPath(WLProjectModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupCompany",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPCOMPANYAUTOMATICALLYASSIGN =
		new FinderPath(WLProjectModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectModelImpl.FINDER_CACHE_ENABLED, WLProjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupCompanyAutomaticallyAssign",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPCOMPANYAUTOMATICALLYASSIGN =
		new FinderPath(WLProjectModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectModelImpl.FINDER_CACHE_ENABLED, WLProjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGroupCompanyAutomaticallyAssign",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			WLProjectModelImpl.GROUPID_COLUMN_BITMASK |
			WLProjectModelImpl.COMPANYID_COLUMN_BITMASK |
			WLProjectModelImpl.AUTOMATICALLYASSIGN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPCOMPANYAUTOMATICALLYASSIGN =
		new FinderPath(WLProjectModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGroupCompanyAutomaticallyAssign",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			});
	public static final FinderPath FINDER_PATH_FETCH_BY_DEFAULTGROUPCOMPANY = new FinderPath(WLProjectModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectModelImpl.FINDER_CACHE_ENABLED, WLProjectImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByDefaultGroupCompany",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			WLProjectModelImpl.GROUPID_COLUMN_BITMASK |
			WLProjectModelImpl.COMPANYID_COLUMN_BITMASK |
			WLProjectModelImpl.DEFAULTPROJECT_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DEFAULTGROUPCOMPANY = new FinderPath(WLProjectModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDefaultGroupCompany",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TITLE = new FinderPath(WLProjectModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectModelImpl.FINDER_CACHE_ENABLED, WLProjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTitle",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLE = new FinderPath(WLProjectModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectModelImpl.FINDER_CACHE_ENABLED, WLProjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTitle",
			new String[] { String.class.getName() },
			WLProjectModelImpl.TITLE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TITLE = new FinderPath(WLProjectModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTitle",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WLProjectModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectModelImpl.FINDER_CACHE_ENABLED, WLProjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WLProjectModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectModelImpl.FINDER_CACHE_ENABLED, WLProjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WLProjectModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the w l project in the entity cache if it is enabled.
	 *
	 * @param wlProject the w l project
	 */
	public void cacheResult(WLProject wlProject) {
		EntityCacheUtil.putResult(WLProjectModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectImpl.class, wlProject.getPrimaryKey(), wlProject);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DEFAULTGROUPCOMPANY,
			new Object[] {
				Long.valueOf(wlProject.getGroupId()),
				Long.valueOf(wlProject.getCompanyId()),
				Boolean.valueOf(wlProject.getDefaultProject())
			}, wlProject);

		wlProject.resetOriginalValues();
	}

	/**
	 * Caches the w l projects in the entity cache if it is enabled.
	 *
	 * @param wlProjects the w l projects
	 */
	public void cacheResult(List<WLProject> wlProjects) {
		for (WLProject wlProject : wlProjects) {
			if (EntityCacheUtil.getResult(
						WLProjectModelImpl.ENTITY_CACHE_ENABLED,
						WLProjectImpl.class, wlProject.getPrimaryKey()) == null) {
				cacheResult(wlProject);
			}
			else {
				wlProject.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all w l projects.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(WLProjectImpl.class.getName());
		}

		EntityCacheUtil.clearCache(WLProjectImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the w l project.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WLProject wlProject) {
		EntityCacheUtil.removeResult(WLProjectModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectImpl.class, wlProject.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(wlProject);
	}

	@Override
	public void clearCache(List<WLProject> wlProjects) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (WLProject wlProject : wlProjects) {
			EntityCacheUtil.removeResult(WLProjectModelImpl.ENTITY_CACHE_ENABLED,
				WLProjectImpl.class, wlProject.getPrimaryKey());

			clearUniqueFindersCache(wlProject);
		}
	}

	protected void clearUniqueFindersCache(WLProject wlProject) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_DEFAULTGROUPCOMPANY,
			new Object[] {
				Long.valueOf(wlProject.getGroupId()),
				Long.valueOf(wlProject.getCompanyId()),
				Boolean.valueOf(wlProject.getDefaultProject())
			});
	}

	/**
	 * Creates a new w l project with the primary key. Does not add the w l project to the database.
	 *
	 * @param projectId the primary key for the new w l project
	 * @return the new w l project
	 */
	public WLProject create(long projectId) {
		WLProject wlProject = new WLProjectImpl();

		wlProject.setNew(true);
		wlProject.setPrimaryKey(projectId);

		return wlProject;
	}

	/**
	 * Removes the w l project with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param projectId the primary key of the w l project
	 * @return the w l project that was removed
	 * @throws com.jenginetest.builder.NoSuchProjectException if a w l project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProject remove(long projectId)
		throws NoSuchProjectException, SystemException {
		return remove(Long.valueOf(projectId));
	}

	/**
	 * Removes the w l project with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the w l project
	 * @return the w l project that was removed
	 * @throws com.jenginetest.builder.NoSuchProjectException if a w l project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WLProject remove(Serializable primaryKey)
		throws NoSuchProjectException, SystemException {
		Session session = null;

		try {
			session = openSession();

			WLProject wlProject = (WLProject)session.get(WLProjectImpl.class,
					primaryKey);

			if (wlProject == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProjectException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(wlProject);
		}
		catch (NoSuchProjectException nsee) {
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
	protected WLProject removeImpl(WLProject wlProject)
		throws SystemException {
		wlProject = toUnwrappedModel(wlProject);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, wlProject);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(wlProject);

		return wlProject;
	}

	@Override
	public WLProject updateImpl(
		com.jenginetest.builder.model.WLProject wlProject, boolean merge)
		throws SystemException {
		wlProject = toUnwrappedModel(wlProject);

		boolean isNew = wlProject.isNew();

		WLProjectModelImpl wlProjectModelImpl = (WLProjectModelImpl)wlProject;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, wlProject, merge);

			wlProject.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !WLProjectModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((wlProjectModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(wlProjectModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] {
						Long.valueOf(wlProjectModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((wlProjectModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPCOMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(wlProjectModelImpl.getOriginalGroupId()),
						Long.valueOf(wlProjectModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPCOMPANY,
					args);

				args = new Object[] {
						Long.valueOf(wlProjectModelImpl.getGroupId()),
						Long.valueOf(wlProjectModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPCOMPANY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPCOMPANY,
					args);
			}

			if ((wlProjectModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPCOMPANYAUTOMATICALLYASSIGN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(wlProjectModelImpl.getOriginalGroupId()),
						Long.valueOf(wlProjectModelImpl.getOriginalCompanyId()),
						Boolean.valueOf(wlProjectModelImpl.getOriginalAutomaticallyAssign())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPCOMPANYAUTOMATICALLYASSIGN,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPCOMPANYAUTOMATICALLYASSIGN,
					args);

				args = new Object[] {
						Long.valueOf(wlProjectModelImpl.getGroupId()),
						Long.valueOf(wlProjectModelImpl.getCompanyId()),
						Boolean.valueOf(wlProjectModelImpl.getAutomaticallyAssign())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPCOMPANYAUTOMATICALLYASSIGN,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPCOMPANYAUTOMATICALLYASSIGN,
					args);
			}

			if ((wlProjectModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						wlProjectModelImpl.getOriginalTitle()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TITLE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLE,
					args);

				args = new Object[] { wlProjectModelImpl.getTitle() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TITLE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLE,
					args);
			}
		}

		EntityCacheUtil.putResult(WLProjectModelImpl.ENTITY_CACHE_ENABLED,
			WLProjectImpl.class, wlProject.getPrimaryKey(), wlProject);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DEFAULTGROUPCOMPANY,
				new Object[] {
					Long.valueOf(wlProject.getGroupId()),
					Long.valueOf(wlProject.getCompanyId()),
					Boolean.valueOf(wlProject.getDefaultProject())
				}, wlProject);
		}
		else {
			if ((wlProjectModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_DEFAULTGROUPCOMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(wlProjectModelImpl.getOriginalGroupId()),
						Long.valueOf(wlProjectModelImpl.getOriginalCompanyId()),
						Boolean.valueOf(wlProjectModelImpl.getOriginalDefaultProject())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEFAULTGROUPCOMPANY,
					args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_DEFAULTGROUPCOMPANY,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DEFAULTGROUPCOMPANY,
					new Object[] {
						Long.valueOf(wlProject.getGroupId()),
						Long.valueOf(wlProject.getCompanyId()),
						Boolean.valueOf(wlProject.getDefaultProject())
					}, wlProject);
			}
		}

		return wlProject;
	}

	protected WLProject toUnwrappedModel(WLProject wlProject) {
		if (wlProject instanceof WLProjectImpl) {
			return wlProject;
		}

		WLProjectImpl wlProjectImpl = new WLProjectImpl();

		wlProjectImpl.setNew(wlProject.isNew());
		wlProjectImpl.setPrimaryKey(wlProject.getPrimaryKey());

		wlProjectImpl.setProjectId(wlProject.getProjectId());
		wlProjectImpl.setGroupId(wlProject.getGroupId());
		wlProjectImpl.setCompanyId(wlProject.getCompanyId());
		wlProjectImpl.setCreateUserId(wlProject.getCreateUserId());
		wlProjectImpl.setCreateUserName(wlProject.getCreateUserName());
		wlProjectImpl.setCreateDate(wlProject.getCreateDate());
		wlProjectImpl.setModifiedUserId(wlProject.getModifiedUserId());
		wlProjectImpl.setModifiedUserName(wlProject.getModifiedUserName());
		wlProjectImpl.setModifiedDate(wlProject.getModifiedDate());
		wlProjectImpl.setStartDate(wlProject.getStartDate());
		wlProjectImpl.setTitle(wlProject.getTitle());
		wlProjectImpl.setStatus(wlProject.getStatus());
		wlProjectImpl.setDescription(wlProject.getDescription());
		wlProjectImpl.setColor(wlProject.getColor());
		wlProjectImpl.setLockEnable(wlProject.isLockEnable());
		wlProjectImpl.setLockPeriodType(wlProject.getLockPeriodType());
		wlProjectImpl.setLockDeferment(wlProject.getLockDeferment());
		wlProjectImpl.setAutomaticallyAssign(wlProject.isAutomaticallyAssign());
		wlProjectImpl.setDefaultProject(wlProject.isDefaultProject());
		wlProjectImpl.setExternalUrl(wlProject.getExternalUrl());
		wlProjectImpl.setExternalMandatory(wlProject.isExternalMandatory());

		return wlProjectImpl;
	}

	/**
	 * Returns the w l project with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the w l project
	 * @return the w l project
	 * @throws com.liferay.portal.NoSuchModelException if a w l project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WLProject findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the w l project with the primary key or throws a {@link com.jenginetest.builder.NoSuchProjectException} if it could not be found.
	 *
	 * @param projectId the primary key of the w l project
	 * @return the w l project
	 * @throws com.jenginetest.builder.NoSuchProjectException if a w l project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProject findByPrimaryKey(long projectId)
		throws NoSuchProjectException, SystemException {
		WLProject wlProject = fetchByPrimaryKey(projectId);

		if (wlProject == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + projectId);
			}

			throw new NoSuchProjectException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				projectId);
		}

		return wlProject;
	}

	/**
	 * Returns the w l project with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the w l project
	 * @return the w l project, or <code>null</code> if a w l project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WLProject fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the w l project with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param projectId the primary key of the w l project
	 * @return the w l project, or <code>null</code> if a w l project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProject fetchByPrimaryKey(long projectId)
		throws SystemException {
		WLProject wlProject = (WLProject)EntityCacheUtil.getResult(WLProjectModelImpl.ENTITY_CACHE_ENABLED,
				WLProjectImpl.class, projectId);

		if (wlProject == _nullWLProject) {
			return null;
		}

		if (wlProject == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				wlProject = (WLProject)session.get(WLProjectImpl.class,
						Long.valueOf(projectId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (wlProject != null) {
					cacheResult(wlProject);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(WLProjectModelImpl.ENTITY_CACHE_ENABLED,
						WLProjectImpl.class, projectId, _nullWLProject);
				}

				closeSession(session);
			}
		}

		return wlProject;
	}

	/**
	 * Returns all the w l projects where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching w l projects
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLProject> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the w l projects where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of w l projects
	 * @param end the upper bound of the range of w l projects (not inclusive)
	 * @return the range of matching w l projects
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLProject> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the w l projects where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of w l projects
	 * @param end the upper bound of the range of w l projects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching w l projects
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLProject> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<WLProject> list = (List<WLProject>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (WLProject wlProject : list) {
				if ((groupId != wlProject.getGroupId())) {
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

			query.append(_SQL_SELECT_WLPROJECT_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(WLProjectModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<WLProject>)QueryUtil.list(q, getDialect(), start,
						end);
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
	 * Returns the first w l project in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching w l project
	 * @throws com.jenginetest.builder.NoSuchProjectException if a matching w l project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProject findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchProjectException, SystemException {
		WLProject wlProject = fetchByGroupId_First(groupId, orderByComparator);

		if (wlProject != null) {
			return wlProject;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectException(msg.toString());
	}

	/**
	 * Returns the first w l project in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching w l project, or <code>null</code> if a matching w l project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProject fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<WLProject> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last w l project in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching w l project
	 * @throws com.jenginetest.builder.NoSuchProjectException if a matching w l project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProject findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchProjectException, SystemException {
		WLProject wlProject = fetchByGroupId_Last(groupId, orderByComparator);

		if (wlProject != null) {
			return wlProject;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectException(msg.toString());
	}

	/**
	 * Returns the last w l project in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching w l project, or <code>null</code> if a matching w l project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProject fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		List<WLProject> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the w l projects before and after the current w l project in the ordered set where groupId = &#63;.
	 *
	 * @param projectId the primary key of the current w l project
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next w l project
	 * @throws com.jenginetest.builder.NoSuchProjectException if a w l project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProject[] findByGroupId_PrevAndNext(long projectId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchProjectException, SystemException {
		WLProject wlProject = findByPrimaryKey(projectId);

		Session session = null;

		try {
			session = openSession();

			WLProject[] array = new WLProjectImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, wlProject, groupId,
					orderByComparator, true);

			array[1] = wlProject;

			array[2] = getByGroupId_PrevAndNext(session, wlProject, groupId,
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

	protected WLProject getByGroupId_PrevAndNext(Session session,
		WLProject wlProject, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WLPROJECT_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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
			query.append(WLProjectModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wlProject);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WLProject> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the w l projects where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching w l projects
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLProject> findByGroupCompany(long groupId, long companyId)
		throws SystemException {
		return findByGroupCompany(groupId, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the w l projects where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of w l projects
	 * @param end the upper bound of the range of w l projects (not inclusive)
	 * @return the range of matching w l projects
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLProject> findByGroupCompany(long groupId, long companyId,
		int start, int end) throws SystemException {
		return findByGroupCompany(groupId, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the w l projects where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of w l projects
	 * @param end the upper bound of the range of w l projects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching w l projects
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLProject> findByGroupCompany(long groupId, long companyId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPCOMPANY;
			finderArgs = new Object[] { groupId, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPCOMPANY;
			finderArgs = new Object[] {
					groupId, companyId,
					
					start, end, orderByComparator
				};
		}

		List<WLProject> list = (List<WLProject>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (WLProject wlProject : list) {
				if ((groupId != wlProject.getGroupId()) ||
						(companyId != wlProject.getCompanyId())) {
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

			query.append(_SQL_SELECT_WLPROJECT_WHERE);

			query.append(_FINDER_COLUMN_GROUPCOMPANY_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPCOMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(WLProjectModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				list = (List<WLProject>)QueryUtil.list(q, getDialect(), start,
						end);
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
	 * Returns the first w l project in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching w l project
	 * @throws com.jenginetest.builder.NoSuchProjectException if a matching w l project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProject findByGroupCompany_First(long groupId, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchProjectException, SystemException {
		WLProject wlProject = fetchByGroupCompany_First(groupId, companyId,
				orderByComparator);

		if (wlProject != null) {
			return wlProject;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectException(msg.toString());
	}

	/**
	 * Returns the first w l project in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching w l project, or <code>null</code> if a matching w l project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProject fetchByGroupCompany_First(long groupId, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<WLProject> list = findByGroupCompany(groupId, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last w l project in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching w l project
	 * @throws com.jenginetest.builder.NoSuchProjectException if a matching w l project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProject findByGroupCompany_Last(long groupId, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchProjectException, SystemException {
		WLProject wlProject = fetchByGroupCompany_Last(groupId, companyId,
				orderByComparator);

		if (wlProject != null) {
			return wlProject;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectException(msg.toString());
	}

	/**
	 * Returns the last w l project in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching w l project, or <code>null</code> if a matching w l project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProject fetchByGroupCompany_Last(long groupId, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupCompany(groupId, companyId);

		List<WLProject> list = findByGroupCompany(groupId, companyId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the w l projects before and after the current w l project in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param projectId the primary key of the current w l project
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next w l project
	 * @throws com.jenginetest.builder.NoSuchProjectException if a w l project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProject[] findByGroupCompany_PrevAndNext(long projectId,
		long groupId, long companyId, OrderByComparator orderByComparator)
		throws NoSuchProjectException, SystemException {
		WLProject wlProject = findByPrimaryKey(projectId);

		Session session = null;

		try {
			session = openSession();

			WLProject[] array = new WLProjectImpl[3];

			array[0] = getByGroupCompany_PrevAndNext(session, wlProject,
					groupId, companyId, orderByComparator, true);

			array[1] = wlProject;

			array[2] = getByGroupCompany_PrevAndNext(session, wlProject,
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

	protected WLProject getByGroupCompany_PrevAndNext(Session session,
		WLProject wlProject, long groupId, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WLPROJECT_WHERE);

		query.append(_FINDER_COLUMN_GROUPCOMPANY_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPCOMPANY_COMPANYID_2);

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
			query.append(WLProjectModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wlProject);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WLProject> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the w l projects where groupId = &#63; and companyId = &#63; and automaticallyAssign = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param automaticallyAssign the automatically assign
	 * @return the matching w l projects
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLProject> findByGroupCompanyAutomaticallyAssign(long groupId,
		long companyId, boolean automaticallyAssign) throws SystemException {
		return findByGroupCompanyAutomaticallyAssign(groupId, companyId,
			automaticallyAssign, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the w l projects where groupId = &#63; and companyId = &#63; and automaticallyAssign = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param automaticallyAssign the automatically assign
	 * @param start the lower bound of the range of w l projects
	 * @param end the upper bound of the range of w l projects (not inclusive)
	 * @return the range of matching w l projects
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLProject> findByGroupCompanyAutomaticallyAssign(long groupId,
		long companyId, boolean automaticallyAssign, int start, int end)
		throws SystemException {
		return findByGroupCompanyAutomaticallyAssign(groupId, companyId,
			automaticallyAssign, start, end, null);
	}

	/**
	 * Returns an ordered range of all the w l projects where groupId = &#63; and companyId = &#63; and automaticallyAssign = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param automaticallyAssign the automatically assign
	 * @param start the lower bound of the range of w l projects
	 * @param end the upper bound of the range of w l projects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching w l projects
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLProject> findByGroupCompanyAutomaticallyAssign(long groupId,
		long companyId, boolean automaticallyAssign, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPCOMPANYAUTOMATICALLYASSIGN;
			finderArgs = new Object[] { groupId, companyId, automaticallyAssign };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPCOMPANYAUTOMATICALLYASSIGN;
			finderArgs = new Object[] {
					groupId, companyId, automaticallyAssign,
					
					start, end, orderByComparator
				};
		}

		List<WLProject> list = (List<WLProject>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (WLProject wlProject : list) {
				if ((groupId != wlProject.getGroupId()) ||
						(companyId != wlProject.getCompanyId()) ||
						(automaticallyAssign != wlProject.getAutomaticallyAssign())) {
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

			query.append(_SQL_SELECT_WLPROJECT_WHERE);

			query.append(_FINDER_COLUMN_GROUPCOMPANYAUTOMATICALLYASSIGN_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPCOMPANYAUTOMATICALLYASSIGN_COMPANYID_2);

			query.append(_FINDER_COLUMN_GROUPCOMPANYAUTOMATICALLYASSIGN_AUTOMATICALLYASSIGN_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(WLProjectModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				qPos.add(automaticallyAssign);

				list = (List<WLProject>)QueryUtil.list(q, getDialect(), start,
						end);
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
	 * Returns the first w l project in the ordered set where groupId = &#63; and companyId = &#63; and automaticallyAssign = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param automaticallyAssign the automatically assign
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching w l project
	 * @throws com.jenginetest.builder.NoSuchProjectException if a matching w l project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProject findByGroupCompanyAutomaticallyAssign_First(long groupId,
		long companyId, boolean automaticallyAssign,
		OrderByComparator orderByComparator)
		throws NoSuchProjectException, SystemException {
		WLProject wlProject = fetchByGroupCompanyAutomaticallyAssign_First(groupId,
				companyId, automaticallyAssign, orderByComparator);

		if (wlProject != null) {
			return wlProject;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", automaticallyAssign=");
		msg.append(automaticallyAssign);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectException(msg.toString());
	}

	/**
	 * Returns the first w l project in the ordered set where groupId = &#63; and companyId = &#63; and automaticallyAssign = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param automaticallyAssign the automatically assign
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching w l project, or <code>null</code> if a matching w l project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProject fetchByGroupCompanyAutomaticallyAssign_First(
		long groupId, long companyId, boolean automaticallyAssign,
		OrderByComparator orderByComparator) throws SystemException {
		List<WLProject> list = findByGroupCompanyAutomaticallyAssign(groupId,
				companyId, automaticallyAssign, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last w l project in the ordered set where groupId = &#63; and companyId = &#63; and automaticallyAssign = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param automaticallyAssign the automatically assign
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching w l project
	 * @throws com.jenginetest.builder.NoSuchProjectException if a matching w l project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProject findByGroupCompanyAutomaticallyAssign_Last(long groupId,
		long companyId, boolean automaticallyAssign,
		OrderByComparator orderByComparator)
		throws NoSuchProjectException, SystemException {
		WLProject wlProject = fetchByGroupCompanyAutomaticallyAssign_Last(groupId,
				companyId, automaticallyAssign, orderByComparator);

		if (wlProject != null) {
			return wlProject;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", automaticallyAssign=");
		msg.append(automaticallyAssign);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectException(msg.toString());
	}

	/**
	 * Returns the last w l project in the ordered set where groupId = &#63; and companyId = &#63; and automaticallyAssign = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param automaticallyAssign the automatically assign
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching w l project, or <code>null</code> if a matching w l project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProject fetchByGroupCompanyAutomaticallyAssign_Last(long groupId,
		long companyId, boolean automaticallyAssign,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupCompanyAutomaticallyAssign(groupId, companyId,
				automaticallyAssign);

		List<WLProject> list = findByGroupCompanyAutomaticallyAssign(groupId,
				companyId, automaticallyAssign, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the w l projects before and after the current w l project in the ordered set where groupId = &#63; and companyId = &#63; and automaticallyAssign = &#63;.
	 *
	 * @param projectId the primary key of the current w l project
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param automaticallyAssign the automatically assign
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next w l project
	 * @throws com.jenginetest.builder.NoSuchProjectException if a w l project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProject[] findByGroupCompanyAutomaticallyAssign_PrevAndNext(
		long projectId, long groupId, long companyId,
		boolean automaticallyAssign, OrderByComparator orderByComparator)
		throws NoSuchProjectException, SystemException {
		WLProject wlProject = findByPrimaryKey(projectId);

		Session session = null;

		try {
			session = openSession();

			WLProject[] array = new WLProjectImpl[3];

			array[0] = getByGroupCompanyAutomaticallyAssign_PrevAndNext(session,
					wlProject, groupId, companyId, automaticallyAssign,
					orderByComparator, true);

			array[1] = wlProject;

			array[2] = getByGroupCompanyAutomaticallyAssign_PrevAndNext(session,
					wlProject, groupId, companyId, automaticallyAssign,
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

	protected WLProject getByGroupCompanyAutomaticallyAssign_PrevAndNext(
		Session session, WLProject wlProject, long groupId, long companyId,
		boolean automaticallyAssign, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WLPROJECT_WHERE);

		query.append(_FINDER_COLUMN_GROUPCOMPANYAUTOMATICALLYASSIGN_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPCOMPANYAUTOMATICALLYASSIGN_COMPANYID_2);

		query.append(_FINDER_COLUMN_GROUPCOMPANYAUTOMATICALLYASSIGN_AUTOMATICALLYASSIGN_2);

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
			query.append(WLProjectModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(companyId);

		qPos.add(automaticallyAssign);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wlProject);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WLProject> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the w l project where groupId = &#63; and companyId = &#63; and defaultProject = &#63; or throws a {@link com.jenginetest.builder.NoSuchProjectException} if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param defaultProject the default project
	 * @return the matching w l project
	 * @throws com.jenginetest.builder.NoSuchProjectException if a matching w l project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProject findByDefaultGroupCompany(long groupId, long companyId,
		boolean defaultProject) throws NoSuchProjectException, SystemException {
		WLProject wlProject = fetchByDefaultGroupCompany(groupId, companyId,
				defaultProject);

		if (wlProject == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", companyId=");
			msg.append(companyId);

			msg.append(", defaultProject=");
			msg.append(defaultProject);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchProjectException(msg.toString());
		}

		return wlProject;
	}

	/**
	 * Returns the w l project where groupId = &#63; and companyId = &#63; and defaultProject = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param defaultProject the default project
	 * @return the matching w l project, or <code>null</code> if a matching w l project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProject fetchByDefaultGroupCompany(long groupId, long companyId,
		boolean defaultProject) throws SystemException {
		return fetchByDefaultGroupCompany(groupId, companyId, defaultProject,
			true);
	}

	/**
	 * Returns the w l project where groupId = &#63; and companyId = &#63; and defaultProject = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param defaultProject the default project
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching w l project, or <code>null</code> if a matching w l project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProject fetchByDefaultGroupCompany(long groupId, long companyId,
		boolean defaultProject, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, companyId, defaultProject };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_DEFAULTGROUPCOMPANY,
					finderArgs, this);
		}

		if (result instanceof WLProject) {
			WLProject wlProject = (WLProject)result;

			if ((groupId != wlProject.getGroupId()) ||
					(companyId != wlProject.getCompanyId()) ||
					(defaultProject != wlProject.getDefaultProject())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_WLPROJECT_WHERE);

			query.append(_FINDER_COLUMN_DEFAULTGROUPCOMPANY_GROUPID_2);

			query.append(_FINDER_COLUMN_DEFAULTGROUPCOMPANY_COMPANYID_2);

			query.append(_FINDER_COLUMN_DEFAULTGROUPCOMPANY_DEFAULTPROJECT_2);

			query.append(WLProjectModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				qPos.add(defaultProject);

				List<WLProject> list = q.list();

				result = list;

				WLProject wlProject = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DEFAULTGROUPCOMPANY,
						finderArgs, list);
				}
				else {
					wlProject = list.get(0);

					cacheResult(wlProject);

					if ((wlProject.getGroupId() != groupId) ||
							(wlProject.getCompanyId() != companyId) ||
							(wlProject.getDefaultProject() != defaultProject)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DEFAULTGROUPCOMPANY,
							finderArgs, wlProject);
					}
				}

				return wlProject;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_DEFAULTGROUPCOMPANY,
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
				return (WLProject)result;
			}
		}
	}

	/**
	 * Returns all the w l projects where title = &#63;.
	 *
	 * @param title the title
	 * @return the matching w l projects
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLProject> findByTitle(String title) throws SystemException {
		return findByTitle(title, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the w l projects where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of w l projects
	 * @param end the upper bound of the range of w l projects (not inclusive)
	 * @return the range of matching w l projects
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLProject> findByTitle(String title, int start, int end)
		throws SystemException {
		return findByTitle(title, start, end, null);
	}

	/**
	 * Returns an ordered range of all the w l projects where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of w l projects
	 * @param end the upper bound of the range of w l projects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching w l projects
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLProject> findByTitle(String title, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLE;
			finderArgs = new Object[] { title };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TITLE;
			finderArgs = new Object[] { title, start, end, orderByComparator };
		}

		List<WLProject> list = (List<WLProject>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (WLProject wlProject : list) {
				if (!Validator.equals(title, wlProject.getTitle())) {
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

			query.append(_SQL_SELECT_WLPROJECT_WHERE);

			if (title == null) {
				query.append(_FINDER_COLUMN_TITLE_TITLE_1);
			}
			else {
				if (title.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_TITLE_TITLE_3);
				}
				else {
					query.append(_FINDER_COLUMN_TITLE_TITLE_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(WLProjectModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (title != null) {
					qPos.add(title);
				}

				list = (List<WLProject>)QueryUtil.list(q, getDialect(), start,
						end);
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
	 * Returns the first w l project in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching w l project
	 * @throws com.jenginetest.builder.NoSuchProjectException if a matching w l project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProject findByTitle_First(String title,
		OrderByComparator orderByComparator)
		throws NoSuchProjectException, SystemException {
		WLProject wlProject = fetchByTitle_First(title, orderByComparator);

		if (wlProject != null) {
			return wlProject;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("title=");
		msg.append(title);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectException(msg.toString());
	}

	/**
	 * Returns the first w l project in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching w l project, or <code>null</code> if a matching w l project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProject fetchByTitle_First(String title,
		OrderByComparator orderByComparator) throws SystemException {
		List<WLProject> list = findByTitle(title, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last w l project in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching w l project
	 * @throws com.jenginetest.builder.NoSuchProjectException if a matching w l project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProject findByTitle_Last(String title,
		OrderByComparator orderByComparator)
		throws NoSuchProjectException, SystemException {
		WLProject wlProject = fetchByTitle_Last(title, orderByComparator);

		if (wlProject != null) {
			return wlProject;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("title=");
		msg.append(title);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectException(msg.toString());
	}

	/**
	 * Returns the last w l project in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching w l project, or <code>null</code> if a matching w l project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProject fetchByTitle_Last(String title,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTitle(title);

		List<WLProject> list = findByTitle(title, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the w l projects before and after the current w l project in the ordered set where title = &#63;.
	 *
	 * @param projectId the primary key of the current w l project
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next w l project
	 * @throws com.jenginetest.builder.NoSuchProjectException if a w l project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLProject[] findByTitle_PrevAndNext(long projectId, String title,
		OrderByComparator orderByComparator)
		throws NoSuchProjectException, SystemException {
		WLProject wlProject = findByPrimaryKey(projectId);

		Session session = null;

		try {
			session = openSession();

			WLProject[] array = new WLProjectImpl[3];

			array[0] = getByTitle_PrevAndNext(session, wlProject, title,
					orderByComparator, true);

			array[1] = wlProject;

			array[2] = getByTitle_PrevAndNext(session, wlProject, title,
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

	protected WLProject getByTitle_PrevAndNext(Session session,
		WLProject wlProject, String title, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WLPROJECT_WHERE);

		if (title == null) {
			query.append(_FINDER_COLUMN_TITLE_TITLE_1);
		}
		else {
			if (title.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TITLE_TITLE_3);
			}
			else {
				query.append(_FINDER_COLUMN_TITLE_TITLE_2);
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
			query.append(WLProjectModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (title != null) {
			qPos.add(title);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wlProject);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WLProject> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the w l projects.
	 *
	 * @return the w l projects
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLProject> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the w l projects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of w l projects
	 * @param end the upper bound of the range of w l projects (not inclusive)
	 * @return the range of w l projects
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLProject> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the w l projects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of w l projects
	 * @param end the upper bound of the range of w l projects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of w l projects
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLProject> findAll(int start, int end,
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

		List<WLProject> list = (List<WLProject>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_WLPROJECT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WLPROJECT.concat(WLProjectModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<WLProject>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<WLProject>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the w l projects where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroupId(long groupId) throws SystemException {
		for (WLProject wlProject : findByGroupId(groupId)) {
			remove(wlProject);
		}
	}

	/**
	 * Removes all the w l projects where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroupCompany(long groupId, long companyId)
		throws SystemException {
		for (WLProject wlProject : findByGroupCompany(groupId, companyId)) {
			remove(wlProject);
		}
	}

	/**
	 * Removes all the w l projects where groupId = &#63; and companyId = &#63; and automaticallyAssign = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param automaticallyAssign the automatically assign
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroupCompanyAutomaticallyAssign(long groupId,
		long companyId, boolean automaticallyAssign) throws SystemException {
		for (WLProject wlProject : findByGroupCompanyAutomaticallyAssign(
				groupId, companyId, automaticallyAssign)) {
			remove(wlProject);
		}
	}

	/**
	 * Removes the w l project where groupId = &#63; and companyId = &#63; and defaultProject = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param defaultProject the default project
	 * @return the w l project that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public WLProject removeByDefaultGroupCompany(long groupId, long companyId,
		boolean defaultProject) throws NoSuchProjectException, SystemException {
		WLProject wlProject = findByDefaultGroupCompany(groupId, companyId,
				defaultProject);

		return remove(wlProject);
	}

	/**
	 * Removes all the w l projects where title = &#63; from the database.
	 *
	 * @param title the title
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTitle(String title) throws SystemException {
		for (WLProject wlProject : findByTitle(title)) {
			remove(wlProject);
		}
	}

	/**
	 * Removes all the w l projects from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (WLProject wlProject : findAll()) {
			remove(wlProject);
		}
	}

	/**
	 * Returns the number of w l projects where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching w l projects
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroupId(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WLPROJECT_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of w l projects where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching w l projects
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroupCompany(long groupId, long companyId)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPCOMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_WLPROJECT_WHERE);

			query.append(_FINDER_COLUMN_GROUPCOMPANY_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPCOMPANY_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPCOMPANY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of w l projects where groupId = &#63; and companyId = &#63; and automaticallyAssign = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param automaticallyAssign the automatically assign
	 * @return the number of matching w l projects
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroupCompanyAutomaticallyAssign(long groupId,
		long companyId, boolean automaticallyAssign) throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId, companyId, automaticallyAssign
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPCOMPANYAUTOMATICALLYASSIGN,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_WLPROJECT_WHERE);

			query.append(_FINDER_COLUMN_GROUPCOMPANYAUTOMATICALLYASSIGN_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPCOMPANYAUTOMATICALLYASSIGN_COMPANYID_2);

			query.append(_FINDER_COLUMN_GROUPCOMPANYAUTOMATICALLYASSIGN_AUTOMATICALLYASSIGN_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				qPos.add(automaticallyAssign);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPCOMPANYAUTOMATICALLYASSIGN,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of w l projects where groupId = &#63; and companyId = &#63; and defaultProject = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param defaultProject the default project
	 * @return the number of matching w l projects
	 * @throws SystemException if a system exception occurred
	 */
	public int countByDefaultGroupCompany(long groupId, long companyId,
		boolean defaultProject) throws SystemException {
		Object[] finderArgs = new Object[] { groupId, companyId, defaultProject };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DEFAULTGROUPCOMPANY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_WLPROJECT_WHERE);

			query.append(_FINDER_COLUMN_DEFAULTGROUPCOMPANY_GROUPID_2);

			query.append(_FINDER_COLUMN_DEFAULTGROUPCOMPANY_COMPANYID_2);

			query.append(_FINDER_COLUMN_DEFAULTGROUPCOMPANY_DEFAULTPROJECT_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				qPos.add(defaultProject);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DEFAULTGROUPCOMPANY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of w l projects where title = &#63;.
	 *
	 * @param title the title
	 * @return the number of matching w l projects
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTitle(String title) throws SystemException {
		Object[] finderArgs = new Object[] { title };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TITLE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WLPROJECT_WHERE);

			if (title == null) {
				query.append(_FINDER_COLUMN_TITLE_TITLE_1);
			}
			else {
				if (title.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_TITLE_TITLE_3);
				}
				else {
					query.append(_FINDER_COLUMN_TITLE_TITLE_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (title != null) {
					qPos.add(title);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TITLE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of w l projects.
	 *
	 * @return the number of w l projects
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_WLPROJECT);

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
	 * Returns all the w l tasks associated with the w l project.
	 *
	 * @param pk the primary key of the w l project
	 * @return the w l tasks associated with the w l project
	 * @throws SystemException if a system exception occurred
	 */
	public List<com.jenginetest.builder.model.WLTask> getWLTasks(long pk)
		throws SystemException {
		return getWLTasks(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the w l tasks associated with the w l project.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pk the primary key of the w l project
	 * @param start the lower bound of the range of w l projects
	 * @param end the upper bound of the range of w l projects (not inclusive)
	 * @return the range of w l tasks associated with the w l project
	 * @throws SystemException if a system exception occurred
	 */
	public List<com.jenginetest.builder.model.WLTask> getWLTasks(long pk,
		int start, int end) throws SystemException {
		return getWLTasks(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_WLTASKS = new FinderPath(com.jenginetest.builder.model.impl.WLTaskModelImpl.ENTITY_CACHE_ENABLED,
			com.jenginetest.builder.model.impl.WLTaskModelImpl.FINDER_CACHE_ENABLED,
			com.jenginetest.builder.model.impl.WLTaskImpl.class,
			com.jenginetest.builder.service.persistence.WLTaskPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"getWLTasks",
			new String[] {
				Long.class.getName(), "java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	static {
		FINDER_PATH_GET_WLTASKS.setCacheKeyGeneratorCacheName(null);
	}

	/**
	 * Returns an ordered range of all the w l tasks associated with the w l project.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pk the primary key of the w l project
	 * @param start the lower bound of the range of w l projects
	 * @param end the upper bound of the range of w l projects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of w l tasks associated with the w l project
	 * @throws SystemException if a system exception occurred
	 */
	public List<com.jenginetest.builder.model.WLTask> getWLTasks(long pk,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk, start, end, orderByComparator };

		List<com.jenginetest.builder.model.WLTask> list = (List<com.jenginetest.builder.model.WLTask>)FinderCacheUtil.getResult(FINDER_PATH_GET_WLTASKS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				String sql = null;

				if (orderByComparator != null) {
					sql = _SQL_GETWLTASKS.concat(ORDER_BY_CLAUSE)
										 .concat(orderByComparator.getOrderBy());
				}
				else {
					sql = _SQL_GETWLTASKS.concat(com.jenginetest.builder.model.impl.WLTaskModelImpl.ORDER_BY_SQL);
				}

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("WL_WLTask",
					com.jenginetest.builder.model.impl.WLTaskImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<com.jenginetest.builder.model.WLTask>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_GET_WLTASKS,
						finderArgs);
				}
				else {
					wlTaskPersistence.cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_GET_WLTASKS,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_WLTASKS_SIZE = new FinderPath(com.jenginetest.builder.model.impl.WLTaskModelImpl.ENTITY_CACHE_ENABLED,
			com.jenginetest.builder.model.impl.WLTaskModelImpl.FINDER_CACHE_ENABLED,
			com.jenginetest.builder.model.impl.WLTaskImpl.class,
			com.jenginetest.builder.service.persistence.WLTaskPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"getWLTasksSize", new String[] { Long.class.getName() });

	static {
		FINDER_PATH_GET_WLTASKS_SIZE.setCacheKeyGeneratorCacheName(null);
	}

	/**
	 * Returns the number of w l tasks associated with the w l project.
	 *
	 * @param pk the primary key of the w l project
	 * @return the number of w l tasks associated with the w l project
	 * @throws SystemException if a system exception occurred
	 */
	public int getWLTasksSize(long pk) throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_WLTASKS_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETWLTASKSSIZE);

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

				FinderCacheUtil.putResult(FINDER_PATH_GET_WLTASKS_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_WLTASK = new FinderPath(com.jenginetest.builder.model.impl.WLTaskModelImpl.ENTITY_CACHE_ENABLED,
			com.jenginetest.builder.model.impl.WLTaskModelImpl.FINDER_CACHE_ENABLED,
			com.jenginetest.builder.model.impl.WLTaskImpl.class,
			com.jenginetest.builder.service.persistence.WLTaskPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"containsWLTask",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns <code>true</code> if the w l task is associated with the w l project.
	 *
	 * @param pk the primary key of the w l project
	 * @param wlTaskPK the primary key of the w l task
	 * @return <code>true</code> if the w l task is associated with the w l project; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsWLTask(long pk, long wlTaskPK)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk, wlTaskPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_WLTASK,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsWLTask.contains(pk, wlTaskPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_WLTASK,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	/**
	 * Returns <code>true</code> if the w l project has any w l tasks associated with it.
	 *
	 * @param pk the primary key of the w l project to check for associations with w l tasks
	 * @return <code>true</code> if the w l project has any w l tasks associated with it; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsWLTasks(long pk) throws SystemException {
		if (getWLTasksSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Initializes the w l project persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.jenginetest.builder.model.WLProject")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<WLProject>> listenersList = new ArrayList<ModelListener<WLProject>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<WLProject>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		containsWLTask = new ContainsWLTask();
	}

	public void destroy() {
		EntityCacheUtil.removeCache(WLProjectImpl.class.getName());
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
	protected ContainsWLTask containsWLTask;

	protected class ContainsWLTask {
		protected ContainsWLTask() {
			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSWLTASK,
					new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT },
					RowMapper.COUNT);
		}

		protected boolean contains(long projectId, long taskId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						new Long(projectId), new Long(taskId)
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

	private static final String _SQL_SELECT_WLPROJECT = "SELECT wlProject FROM WLProject wlProject";
	private static final String _SQL_SELECT_WLPROJECT_WHERE = "SELECT wlProject FROM WLProject wlProject WHERE ";
	private static final String _SQL_COUNT_WLPROJECT = "SELECT COUNT(wlProject) FROM WLProject wlProject";
	private static final String _SQL_COUNT_WLPROJECT_WHERE = "SELECT COUNT(wlProject) FROM WLProject wlProject WHERE ";
	private static final String _SQL_GETWLTASKS = "SELECT {WL_WLTask.*} FROM WL_WLTask INNER JOIN WL_WLProject ON (WL_WLProject.projectId = WL_WLTask.projectId) WHERE (WL_WLProject.projectId = ?)";
	private static final String _SQL_GETWLTASKSSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM WL_WLTask WHERE projectId = ?";
	private static final String _SQL_CONTAINSWLTASK = "SELECT COUNT(*) AS COUNT_VALUE FROM WL_WLTask WHERE projectId = ? AND taskId = ?";
	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "wlProject.groupId = ?";
	private static final String _FINDER_COLUMN_GROUPCOMPANY_GROUPID_2 = "wlProject.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPCOMPANY_COMPANYID_2 = "wlProject.companyId = ?";
	private static final String _FINDER_COLUMN_GROUPCOMPANYAUTOMATICALLYASSIGN_GROUPID_2 =
		"wlProject.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPCOMPANYAUTOMATICALLYASSIGN_COMPANYID_2 =
		"wlProject.companyId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPCOMPANYAUTOMATICALLYASSIGN_AUTOMATICALLYASSIGN_2 =
		"wlProject.automaticallyAssign = ?";
	private static final String _FINDER_COLUMN_DEFAULTGROUPCOMPANY_GROUPID_2 = "wlProject.groupId = ? AND ";
	private static final String _FINDER_COLUMN_DEFAULTGROUPCOMPANY_COMPANYID_2 = "wlProject.companyId = ? AND ";
	private static final String _FINDER_COLUMN_DEFAULTGROUPCOMPANY_DEFAULTPROJECT_2 =
		"wlProject.defaultProject = ?";
	private static final String _FINDER_COLUMN_TITLE_TITLE_1 = "wlProject.title IS NULL";
	private static final String _FINDER_COLUMN_TITLE_TITLE_2 = "wlProject.title = ?";
	private static final String _FINDER_COLUMN_TITLE_TITLE_3 = "(wlProject.title IS NULL OR wlProject.title = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "wlProject.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No WLProject exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No WLProject exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(WLProjectPersistenceImpl.class);
	private static WLProject _nullWLProject = new WLProjectImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<WLProject> toCacheModel() {
				return _nullWLProjectCacheModel;
			}
		};

	private static CacheModel<WLProject> _nullWLProjectCacheModel = new CacheModel<WLProject>() {
			public WLProject toEntityModel() {
				return _nullWLProject;
			}
		};
}