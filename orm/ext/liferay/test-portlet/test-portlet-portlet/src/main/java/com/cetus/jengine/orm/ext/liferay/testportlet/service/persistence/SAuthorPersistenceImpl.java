package com.cetus.jengine.orm.ext.liferay.testportlet.service.persistence;

import com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchSAuthorException;
import com.cetus.jengine.orm.ext.liferay.testportlet.model.SAuthor;
import com.cetus.jengine.orm.ext.liferay.testportlet.model.impl.SAuthorImpl;
import com.cetus.jengine.orm.ext.liferay.testportlet.model.impl.SAuthorModelImpl;
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
 * The persistence implementation for the s author service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SAuthorPersistence
 * @see SAuthorUtil
 * @generated
 */
public class SAuthorPersistenceImpl extends BasePersistenceImpl<SAuthor>
    implements SAuthorPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link SAuthorUtil} to access the s author persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = SAuthorImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SAuthorModelImpl.ENTITY_CACHE_ENABLED,
            SAuthorModelImpl.FINDER_CACHE_ENABLED, SAuthorImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SAuthorModelImpl.ENTITY_CACHE_ENABLED,
            SAuthorModelImpl.FINDER_CACHE_ENABLED, SAuthorImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SAuthorModelImpl.ENTITY_CACHE_ENABLED,
            SAuthorModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_SAUTHOR = "SELECT sAuthor FROM SAuthor sAuthor";
    private static final String _SQL_COUNT_SAUTHOR = "SELECT COUNT(sAuthor) FROM SAuthor sAuthor";
    private static final String _ORDER_BY_ENTITY_ALIAS = "sAuthor.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SAuthor exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(SAuthorPersistenceImpl.class);
    private static SAuthor _nullSAuthor = new SAuthorImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<SAuthor> toCacheModel() {
                return _nullSAuthorCacheModel;
            }
        };

    private static CacheModel<SAuthor> _nullSAuthorCacheModel = new CacheModel<SAuthor>() {
            public SAuthor toEntityModel() {
                return _nullSAuthor;
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
     * Caches the s author in the entity cache if it is enabled.
     *
     * @param sAuthor the s author
     */
    public void cacheResult(SAuthor sAuthor) {
        EntityCacheUtil.putResult(SAuthorModelImpl.ENTITY_CACHE_ENABLED,
            SAuthorImpl.class, sAuthor.getPrimaryKey(), sAuthor);

        sAuthor.resetOriginalValues();
    }

    /**
     * Caches the s authors in the entity cache if it is enabled.
     *
     * @param sAuthors the s authors
     */
    public void cacheResult(List<SAuthor> sAuthors) {
        for (SAuthor sAuthor : sAuthors) {
            if (EntityCacheUtil.getResult(
                        SAuthorModelImpl.ENTITY_CACHE_ENABLED,
                        SAuthorImpl.class, sAuthor.getPrimaryKey()) == null) {
                cacheResult(sAuthor);
            } else {
                sAuthor.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all s authors.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(SAuthorImpl.class.getName());
        }

        EntityCacheUtil.clearCache(SAuthorImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the s author.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(SAuthor sAuthor) {
        EntityCacheUtil.removeResult(SAuthorModelImpl.ENTITY_CACHE_ENABLED,
            SAuthorImpl.class, sAuthor.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<SAuthor> sAuthors) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (SAuthor sAuthor : sAuthors) {
            EntityCacheUtil.removeResult(SAuthorModelImpl.ENTITY_CACHE_ENABLED,
                SAuthorImpl.class, sAuthor.getPrimaryKey());
        }
    }

    /**
     * Creates a new s author with the primary key. Does not add the s author to the database.
     *
     * @param authorId the primary key for the new s author
     * @return the new s author
     */
    public SAuthor create(long authorId) {
        SAuthor sAuthor = new SAuthorImpl();

        sAuthor.setNew(true);
        sAuthor.setPrimaryKey(authorId);

        return sAuthor;
    }

    /**
     * Removes the s author with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param authorId the primary key of the s author
     * @return the s author that was removed
     * @throws com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchSAuthorException if a s author with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public SAuthor remove(long authorId)
        throws NoSuchSAuthorException, SystemException {
        return remove(Long.valueOf(authorId));
    }

    /**
     * Removes the s author with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the s author
     * @return the s author that was removed
     * @throws com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchSAuthorException if a s author with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SAuthor remove(Serializable primaryKey)
        throws NoSuchSAuthorException, SystemException {
        Session session = null;

        try {
            session = openSession();

            SAuthor sAuthor = (SAuthor) session.get(SAuthorImpl.class,
                    primaryKey);

            if (sAuthor == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchSAuthorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(sAuthor);
        } catch (NoSuchSAuthorException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected SAuthor removeImpl(SAuthor sAuthor) throws SystemException {
        sAuthor = toUnwrappedModel(sAuthor);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, sAuthor);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(sAuthor);

        return sAuthor;
    }

    @Override
    public SAuthor updateImpl(
        com.cetus.jengine.orm.ext.liferay.testportlet.model.SAuthor sAuthor,
        boolean merge) throws SystemException {
        sAuthor = toUnwrappedModel(sAuthor);

        boolean isNew = sAuthor.isNew();

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, sAuthor, merge);

            sAuthor.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(SAuthorModelImpl.ENTITY_CACHE_ENABLED,
            SAuthorImpl.class, sAuthor.getPrimaryKey(), sAuthor);

        return sAuthor;
    }

    protected SAuthor toUnwrappedModel(SAuthor sAuthor) {
        if (sAuthor instanceof SAuthorImpl) {
            return sAuthor;
        }

        SAuthorImpl sAuthorImpl = new SAuthorImpl();

        sAuthorImpl.setNew(sAuthor.isNew());
        sAuthorImpl.setPrimaryKey(sAuthor.getPrimaryKey());

        sAuthorImpl.setAuthorId(sAuthor.getAuthorId());
        sAuthorImpl.setFirstName(sAuthor.getFirstName());
        sAuthorImpl.setLastName(sAuthor.getLastName());

        return sAuthorImpl;
    }

    /**
     * Returns the s author with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the s author
     * @return the s author
     * @throws com.liferay.portal.NoSuchModelException if a s author with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SAuthor findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the s author with the primary key or throws a {@link com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchSAuthorException} if it could not be found.
     *
     * @param authorId the primary key of the s author
     * @return the s author
     * @throws com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchSAuthorException if a s author with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public SAuthor findByPrimaryKey(long authorId)
        throws NoSuchSAuthorException, SystemException {
        SAuthor sAuthor = fetchByPrimaryKey(authorId);

        if (sAuthor == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + authorId);
            }

            throw new NoSuchSAuthorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                authorId);
        }

        return sAuthor;
    }

    /**
     * Returns the s author with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the s author
     * @return the s author, or <code>null</code> if a s author with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SAuthor fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the s author with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param authorId the primary key of the s author
     * @return the s author, or <code>null</code> if a s author with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public SAuthor fetchByPrimaryKey(long authorId) throws SystemException {
        SAuthor sAuthor = (SAuthor) EntityCacheUtil.getResult(SAuthorModelImpl.ENTITY_CACHE_ENABLED,
                SAuthorImpl.class, authorId);

        if (sAuthor == _nullSAuthor) {
            return null;
        }

        if (sAuthor == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                sAuthor = (SAuthor) session.get(SAuthorImpl.class,
                        Long.valueOf(authorId));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (sAuthor != null) {
                    cacheResult(sAuthor);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(SAuthorModelImpl.ENTITY_CACHE_ENABLED,
                        SAuthorImpl.class, authorId, _nullSAuthor);
                }

                closeSession(session);
            }
        }

        return sAuthor;
    }

    /**
     * Returns all the s authors.
     *
     * @return the s authors
     * @throws SystemException if a system exception occurred
     */
    public List<SAuthor> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the s authors.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of s authors
     * @param end the upper bound of the range of s authors (not inclusive)
     * @return the range of s authors
     * @throws SystemException if a system exception occurred
     */
    public List<SAuthor> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the s authors.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of s authors
     * @param end the upper bound of the range of s authors (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of s authors
     * @throws SystemException if a system exception occurred
     */
    public List<SAuthor> findAll(int start, int end,
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

        List<SAuthor> list = (List<SAuthor>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_SAUTHOR);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_SAUTHOR;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<SAuthor>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<SAuthor>) QueryUtil.list(q, getDialect(),
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
     * Removes all the s authors from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (SAuthor sAuthor : findAll()) {
            remove(sAuthor);
        }
    }

    /**
     * Returns the number of s authors.
     *
     * @return the number of s authors
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_SAUTHOR);

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
     * Initializes the s author persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.cetus.jengine.orm.ext.liferay.testportlet.model.SAuthor")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<SAuthor>> listenersList = new ArrayList<ModelListener<SAuthor>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<SAuthor>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(SAuthorImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
