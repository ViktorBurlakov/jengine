package com.cetus.jengine.orm.ext.liferay.testportlet.service.persistence;

import com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchSLibraryException;
import com.cetus.jengine.orm.ext.liferay.testportlet.model.SLibrary;
import com.cetus.jengine.orm.ext.liferay.testportlet.model.impl.SLibraryImpl;
import com.cetus.jengine.orm.ext.liferay.testportlet.model.impl.SLibraryModelImpl;
import com.cetus.jengine.orm.ext.liferay.testportlet.service.persistence.SAuthorPersistence;
import com.cetus.jengine.orm.ext.liferay.testportlet.service.persistence.SBookPersistence;
import com.cetus.jengine.orm.ext.liferay.testportlet.service.persistence.SLibraryPersistence;
import com.cetus.jengine.orm.ext.liferay.testportlet.service.persistence.SMemberPersistence;
import com.cetus.jengine.orm.ext.liferay.testportlet.service.persistence.STransactionPersistence;

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
 * The persistence implementation for the s library service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SLibraryPersistence
 * @see SLibraryUtil
 * @generated
 */
public class SLibraryPersistenceImpl extends BasePersistenceImpl<SLibrary>
    implements SLibraryPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link SLibraryUtil} to access the s library persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = SLibraryImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SLibraryModelImpl.ENTITY_CACHE_ENABLED,
            SLibraryModelImpl.FINDER_CACHE_ENABLED, SLibraryImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SLibraryModelImpl.ENTITY_CACHE_ENABLED,
            SLibraryModelImpl.FINDER_CACHE_ENABLED, SLibraryImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SLibraryModelImpl.ENTITY_CACHE_ENABLED,
            SLibraryModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_SLIBRARY = "SELECT sLibrary FROM SLibrary sLibrary";
    private static final String _SQL_COUNT_SLIBRARY = "SELECT COUNT(sLibrary) FROM SLibrary sLibrary";
    private static final String _ORDER_BY_ENTITY_ALIAS = "sLibrary.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SLibrary exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(SLibraryPersistenceImpl.class);
    private static SLibrary _nullSLibrary = new SLibraryImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<SLibrary> toCacheModel() {
                return _nullSLibraryCacheModel;
            }
        };

    private static CacheModel<SLibrary> _nullSLibraryCacheModel = new CacheModel<SLibrary>() {
            public SLibrary toEntityModel() {
                return _nullSLibrary;
            }
        };

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

    /**
     * Caches the s library in the entity cache if it is enabled.
     *
     * @param sLibrary the s library
     */
    public void cacheResult(SLibrary sLibrary) {
        EntityCacheUtil.putResult(SLibraryModelImpl.ENTITY_CACHE_ENABLED,
            SLibraryImpl.class, sLibrary.getPrimaryKey(), sLibrary);

        sLibrary.resetOriginalValues();
    }

    /**
     * Caches the s libraries in the entity cache if it is enabled.
     *
     * @param sLibraries the s libraries
     */
    public void cacheResult(List<SLibrary> sLibraries) {
        for (SLibrary sLibrary : sLibraries) {
            if (EntityCacheUtil.getResult(
                        SLibraryModelImpl.ENTITY_CACHE_ENABLED,
                        SLibraryImpl.class, sLibrary.getPrimaryKey()) == null) {
                cacheResult(sLibrary);
            } else {
                sLibrary.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all s libraries.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(SLibraryImpl.class.getName());
        }

        EntityCacheUtil.clearCache(SLibraryImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the s library.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(SLibrary sLibrary) {
        EntityCacheUtil.removeResult(SLibraryModelImpl.ENTITY_CACHE_ENABLED,
            SLibraryImpl.class, sLibrary.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<SLibrary> sLibraries) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (SLibrary sLibrary : sLibraries) {
            EntityCacheUtil.removeResult(SLibraryModelImpl.ENTITY_CACHE_ENABLED,
                SLibraryImpl.class, sLibrary.getPrimaryKey());
        }
    }

    /**
     * Creates a new s library with the primary key. Does not add the s library to the database.
     *
     * @param libraryId the primary key for the new s library
     * @return the new s library
     */
    public SLibrary create(long libraryId) {
        SLibrary sLibrary = new SLibraryImpl();

        sLibrary.setNew(true);
        sLibrary.setPrimaryKey(libraryId);

        return sLibrary;
    }

    /**
     * Removes the s library with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param libraryId the primary key of the s library
     * @return the s library that was removed
     * @throws com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchSLibraryException if a s library with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public SLibrary remove(long libraryId)
        throws NoSuchSLibraryException, SystemException {
        return remove(Long.valueOf(libraryId));
    }

    /**
     * Removes the s library with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the s library
     * @return the s library that was removed
     * @throws com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchSLibraryException if a s library with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SLibrary remove(Serializable primaryKey)
        throws NoSuchSLibraryException, SystemException {
        Session session = null;

        try {
            session = openSession();

            SLibrary sLibrary = (SLibrary) session.get(SLibraryImpl.class,
                    primaryKey);

            if (sLibrary == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchSLibraryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(sLibrary);
        } catch (NoSuchSLibraryException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected SLibrary removeImpl(SLibrary sLibrary) throws SystemException {
        sLibrary = toUnwrappedModel(sLibrary);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, sLibrary);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(sLibrary);

        return sLibrary;
    }

    @Override
    public SLibrary updateImpl(
        com.cetus.jengine.orm.ext.liferay.testportlet.model.SLibrary sLibrary,
        boolean merge) throws SystemException {
        sLibrary = toUnwrappedModel(sLibrary);

        boolean isNew = sLibrary.isNew();

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, sLibrary, merge);

            sLibrary.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(SLibraryModelImpl.ENTITY_CACHE_ENABLED,
            SLibraryImpl.class, sLibrary.getPrimaryKey(), sLibrary);

        return sLibrary;
    }

    protected SLibrary toUnwrappedModel(SLibrary sLibrary) {
        if (sLibrary instanceof SLibraryImpl) {
            return sLibrary;
        }

        SLibraryImpl sLibraryImpl = new SLibraryImpl();

        sLibraryImpl.setNew(sLibrary.isNew());
        sLibraryImpl.setPrimaryKey(sLibrary.getPrimaryKey());

        sLibraryImpl.setLibraryId(sLibrary.getLibraryId());
        sLibraryImpl.setName(sLibrary.getName());
        sLibraryImpl.setAddress(sLibrary.getAddress());

        return sLibraryImpl;
    }

    /**
     * Returns the s library with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the s library
     * @return the s library
     * @throws com.liferay.portal.NoSuchModelException if a s library with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SLibrary findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the s library with the primary key or throws a {@link com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchSLibraryException} if it could not be found.
     *
     * @param libraryId the primary key of the s library
     * @return the s library
     * @throws com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchSLibraryException if a s library with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public SLibrary findByPrimaryKey(long libraryId)
        throws NoSuchSLibraryException, SystemException {
        SLibrary sLibrary = fetchByPrimaryKey(libraryId);

        if (sLibrary == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + libraryId);
            }

            throw new NoSuchSLibraryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                libraryId);
        }

        return sLibrary;
    }

    /**
     * Returns the s library with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the s library
     * @return the s library, or <code>null</code> if a s library with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SLibrary fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the s library with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param libraryId the primary key of the s library
     * @return the s library, or <code>null</code> if a s library with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public SLibrary fetchByPrimaryKey(long libraryId) throws SystemException {
        SLibrary sLibrary = (SLibrary) EntityCacheUtil.getResult(SLibraryModelImpl.ENTITY_CACHE_ENABLED,
                SLibraryImpl.class, libraryId);

        if (sLibrary == _nullSLibrary) {
            return null;
        }

        if (sLibrary == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                sLibrary = (SLibrary) session.get(SLibraryImpl.class,
                        Long.valueOf(libraryId));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (sLibrary != null) {
                    cacheResult(sLibrary);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(SLibraryModelImpl.ENTITY_CACHE_ENABLED,
                        SLibraryImpl.class, libraryId, _nullSLibrary);
                }

                closeSession(session);
            }
        }

        return sLibrary;
    }

    /**
     * Returns all the s libraries.
     *
     * @return the s libraries
     * @throws SystemException if a system exception occurred
     */
    public List<SLibrary> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the s libraries.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of s libraries
     * @param end the upper bound of the range of s libraries (not inclusive)
     * @return the range of s libraries
     * @throws SystemException if a system exception occurred
     */
    public List<SLibrary> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the s libraries.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of s libraries
     * @param end the upper bound of the range of s libraries (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of s libraries
     * @throws SystemException if a system exception occurred
     */
    public List<SLibrary> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = new Object[] { start, end, orderByComparator };

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<SLibrary> list = (List<SLibrary>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_SLIBRARY);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_SLIBRARY;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<SLibrary>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<SLibrary>) QueryUtil.list(q, getDialect(),
                            start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    FinderCacheUtil.removeResult(finderPath, finderArgs);
                } else {
                    cacheResult(list);

                    FinderCacheUtil.putResult(finderPath, finderArgs, list);
                }

                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the s libraries from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (SLibrary sLibrary : findAll()) {
            remove(sLibrary);
        }
    }

    /**
     * Returns the number of s libraries.
     *
     * @return the number of s libraries
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_SLIBRARY);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
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
     * Initializes the s library persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.cetus.jengine.orm.ext.liferay.testportlet.model.SLibrary")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<SLibrary>> listenersList = new ArrayList<ModelListener<SLibrary>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<SLibrary>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(SLibraryImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
