package com.cetus.jengine.orm.ext.liferay.testportlet.service.persistence;

import com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchSTransactionException;
import com.cetus.jengine.orm.ext.liferay.testportlet.model.STransaction;
import com.cetus.jengine.orm.ext.liferay.testportlet.model.impl.STransactionImpl;
import com.cetus.jengine.orm.ext.liferay.testportlet.model.impl.STransactionModelImpl;
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
 * The persistence implementation for the s transaction service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see STransactionPersistence
 * @see STransactionUtil
 * @generated
 */
public class STransactionPersistenceImpl extends BasePersistenceImpl<STransaction>
    implements STransactionPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link STransactionUtil} to access the s transaction persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = STransactionImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(STransactionModelImpl.ENTITY_CACHE_ENABLED,
            STransactionModelImpl.FINDER_CACHE_ENABLED, STransactionImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(STransactionModelImpl.ENTITY_CACHE_ENABLED,
            STransactionModelImpl.FINDER_CACHE_ENABLED, STransactionImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(STransactionModelImpl.ENTITY_CACHE_ENABLED,
            STransactionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_STRANSACTION = "SELECT sTransaction FROM STransaction sTransaction";
    private static final String _SQL_COUNT_STRANSACTION = "SELECT COUNT(sTransaction) FROM STransaction sTransaction";
    private static final String _ORDER_BY_ENTITY_ALIAS = "sTransaction.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No STransaction exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(STransactionPersistenceImpl.class);
    private static STransaction _nullSTransaction = new STransactionImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<STransaction> toCacheModel() {
                return _nullSTransactionCacheModel;
            }
        };

    private static CacheModel<STransaction> _nullSTransactionCacheModel = new CacheModel<STransaction>() {
            public STransaction toEntityModel() {
                return _nullSTransaction;
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
     * Caches the s transaction in the entity cache if it is enabled.
     *
     * @param sTransaction the s transaction
     */
    public void cacheResult(STransaction sTransaction) {
        EntityCacheUtil.putResult(STransactionModelImpl.ENTITY_CACHE_ENABLED,
            STransactionImpl.class, sTransaction.getPrimaryKey(), sTransaction);

        sTransaction.resetOriginalValues();
    }

    /**
     * Caches the s transactions in the entity cache if it is enabled.
     *
     * @param sTransactions the s transactions
     */
    public void cacheResult(List<STransaction> sTransactions) {
        for (STransaction sTransaction : sTransactions) {
            if (EntityCacheUtil.getResult(
                        STransactionModelImpl.ENTITY_CACHE_ENABLED,
                        STransactionImpl.class, sTransaction.getPrimaryKey()) == null) {
                cacheResult(sTransaction);
            } else {
                sTransaction.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all s transactions.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(STransactionImpl.class.getName());
        }

        EntityCacheUtil.clearCache(STransactionImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the s transaction.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(STransaction sTransaction) {
        EntityCacheUtil.removeResult(STransactionModelImpl.ENTITY_CACHE_ENABLED,
            STransactionImpl.class, sTransaction.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<STransaction> sTransactions) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (STransaction sTransaction : sTransactions) {
            EntityCacheUtil.removeResult(STransactionModelImpl.ENTITY_CACHE_ENABLED,
                STransactionImpl.class, sTransaction.getPrimaryKey());
        }
    }

    /**
     * Creates a new s transaction with the primary key. Does not add the s transaction to the database.
     *
     * @param transactionId the primary key for the new s transaction
     * @return the new s transaction
     */
    public STransaction create(long transactionId) {
        STransaction sTransaction = new STransactionImpl();

        sTransaction.setNew(true);
        sTransaction.setPrimaryKey(transactionId);

        return sTransaction;
    }

    /**
     * Removes the s transaction with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param transactionId the primary key of the s transaction
     * @return the s transaction that was removed
     * @throws com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchSTransactionException if a s transaction with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public STransaction remove(long transactionId)
        throws NoSuchSTransactionException, SystemException {
        return remove(Long.valueOf(transactionId));
    }

    /**
     * Removes the s transaction with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the s transaction
     * @return the s transaction that was removed
     * @throws com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchSTransactionException if a s transaction with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public STransaction remove(Serializable primaryKey)
        throws NoSuchSTransactionException, SystemException {
        Session session = null;

        try {
            session = openSession();

            STransaction sTransaction = (STransaction) session.get(STransactionImpl.class,
                    primaryKey);

            if (sTransaction == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchSTransactionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(sTransaction);
        } catch (NoSuchSTransactionException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected STransaction removeImpl(STransaction sTransaction)
        throws SystemException {
        sTransaction = toUnwrappedModel(sTransaction);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, sTransaction);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(sTransaction);

        return sTransaction;
    }

    @Override
    public STransaction updateImpl(
        com.cetus.jengine.orm.ext.liferay.testportlet.model.STransaction sTransaction,
        boolean merge) throws SystemException {
        sTransaction = toUnwrappedModel(sTransaction);

        boolean isNew = sTransaction.isNew();

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, sTransaction, merge);

            sTransaction.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(STransactionModelImpl.ENTITY_CACHE_ENABLED,
            STransactionImpl.class, sTransaction.getPrimaryKey(), sTransaction);

        return sTransaction;
    }

    protected STransaction toUnwrappedModel(STransaction sTransaction) {
        if (sTransaction instanceof STransactionImpl) {
            return sTransaction;
        }

        STransactionImpl sTransactionImpl = new STransactionImpl();

        sTransactionImpl.setNew(sTransaction.isNew());
        sTransactionImpl.setPrimaryKey(sTransaction.getPrimaryKey());

        sTransactionImpl.setTransactionId(sTransaction.getTransactionId());
        sTransactionImpl.setBookId(sTransaction.getBookId());
        sTransactionImpl.setMemberId(sTransaction.getMemberId());
        sTransactionImpl.setTdate(sTransaction.getTdate());

        return sTransactionImpl;
    }

    /**
     * Returns the s transaction with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the s transaction
     * @return the s transaction
     * @throws com.liferay.portal.NoSuchModelException if a s transaction with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public STransaction findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the s transaction with the primary key or throws a {@link com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchSTransactionException} if it could not be found.
     *
     * @param transactionId the primary key of the s transaction
     * @return the s transaction
     * @throws com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchSTransactionException if a s transaction with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public STransaction findByPrimaryKey(long transactionId)
        throws NoSuchSTransactionException, SystemException {
        STransaction sTransaction = fetchByPrimaryKey(transactionId);

        if (sTransaction == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + transactionId);
            }

            throw new NoSuchSTransactionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                transactionId);
        }

        return sTransaction;
    }

    /**
     * Returns the s transaction with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the s transaction
     * @return the s transaction, or <code>null</code> if a s transaction with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public STransaction fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the s transaction with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param transactionId the primary key of the s transaction
     * @return the s transaction, or <code>null</code> if a s transaction with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public STransaction fetchByPrimaryKey(long transactionId)
        throws SystemException {
        STransaction sTransaction = (STransaction) EntityCacheUtil.getResult(STransactionModelImpl.ENTITY_CACHE_ENABLED,
                STransactionImpl.class, transactionId);

        if (sTransaction == _nullSTransaction) {
            return null;
        }

        if (sTransaction == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                sTransaction = (STransaction) session.get(STransactionImpl.class,
                        Long.valueOf(transactionId));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (sTransaction != null) {
                    cacheResult(sTransaction);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(STransactionModelImpl.ENTITY_CACHE_ENABLED,
                        STransactionImpl.class, transactionId, _nullSTransaction);
                }

                closeSession(session);
            }
        }

        return sTransaction;
    }

    /**
     * Returns all the s transactions.
     *
     * @return the s transactions
     * @throws SystemException if a system exception occurred
     */
    public List<STransaction> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the s transactions.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of s transactions
     * @param end the upper bound of the range of s transactions (not inclusive)
     * @return the range of s transactions
     * @throws SystemException if a system exception occurred
     */
    public List<STransaction> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the s transactions.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of s transactions
     * @param end the upper bound of the range of s transactions (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of s transactions
     * @throws SystemException if a system exception occurred
     */
    public List<STransaction> findAll(int start, int end,
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

        List<STransaction> list = (List<STransaction>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_STRANSACTION);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_STRANSACTION;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<STransaction>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<STransaction>) QueryUtil.list(q, getDialect(),
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
     * Removes all the s transactions from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (STransaction sTransaction : findAll()) {
            remove(sTransaction);
        }
    }

    /**
     * Returns the number of s transactions.
     *
     * @return the number of s transactions
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_STRANSACTION);

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
     * Initializes the s transaction persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.cetus.jengine.orm.ext.liferay.testportlet.model.STransaction")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<STransaction>> listenersList = new ArrayList<ModelListener<STransaction>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<STransaction>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(STransactionImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
