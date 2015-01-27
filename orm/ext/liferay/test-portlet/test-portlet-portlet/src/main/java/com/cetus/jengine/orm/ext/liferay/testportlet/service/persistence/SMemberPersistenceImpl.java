package com.cetus.jengine.orm.ext.liferay.testportlet.service.persistence;

import com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchSMemberException;
import com.cetus.jengine.orm.ext.liferay.testportlet.model.SMember;
import com.cetus.jengine.orm.ext.liferay.testportlet.model.impl.SMemberImpl;
import com.cetus.jengine.orm.ext.liferay.testportlet.model.impl.SMemberModelImpl;
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
 * The persistence implementation for the s member service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SMemberPersistence
 * @see SMemberUtil
 * @generated
 */
public class SMemberPersistenceImpl extends BasePersistenceImpl<SMember>
    implements SMemberPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link SMemberUtil} to access the s member persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = SMemberImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SMemberModelImpl.ENTITY_CACHE_ENABLED,
            SMemberModelImpl.FINDER_CACHE_ENABLED, SMemberImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SMemberModelImpl.ENTITY_CACHE_ENABLED,
            SMemberModelImpl.FINDER_CACHE_ENABLED, SMemberImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SMemberModelImpl.ENTITY_CACHE_ENABLED,
            SMemberModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_SMEMBER = "SELECT sMember FROM SMember sMember";
    private static final String _SQL_COUNT_SMEMBER = "SELECT COUNT(sMember) FROM SMember sMember";
    private static final String _ORDER_BY_ENTITY_ALIAS = "sMember.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SMember exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(SMemberPersistenceImpl.class);
    private static SMember _nullSMember = new SMemberImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<SMember> toCacheModel() {
                return _nullSMemberCacheModel;
            }
        };

    private static CacheModel<SMember> _nullSMemberCacheModel = new CacheModel<SMember>() {
            public SMember toEntityModel() {
                return _nullSMember;
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
     * Caches the s member in the entity cache if it is enabled.
     *
     * @param sMember the s member
     */
    public void cacheResult(SMember sMember) {
        EntityCacheUtil.putResult(SMemberModelImpl.ENTITY_CACHE_ENABLED,
            SMemberImpl.class, sMember.getPrimaryKey(), sMember);

        sMember.resetOriginalValues();
    }

    /**
     * Caches the s members in the entity cache if it is enabled.
     *
     * @param sMembers the s members
     */
    public void cacheResult(List<SMember> sMembers) {
        for (SMember sMember : sMembers) {
            if (EntityCacheUtil.getResult(
                        SMemberModelImpl.ENTITY_CACHE_ENABLED,
                        SMemberImpl.class, sMember.getPrimaryKey()) == null) {
                cacheResult(sMember);
            } else {
                sMember.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all s members.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(SMemberImpl.class.getName());
        }

        EntityCacheUtil.clearCache(SMemberImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the s member.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(SMember sMember) {
        EntityCacheUtil.removeResult(SMemberModelImpl.ENTITY_CACHE_ENABLED,
            SMemberImpl.class, sMember.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<SMember> sMembers) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (SMember sMember : sMembers) {
            EntityCacheUtil.removeResult(SMemberModelImpl.ENTITY_CACHE_ENABLED,
                SMemberImpl.class, sMember.getPrimaryKey());
        }
    }

    /**
     * Creates a new s member with the primary key. Does not add the s member to the database.
     *
     * @param memberId the primary key for the new s member
     * @return the new s member
     */
    public SMember create(long memberId) {
        SMember sMember = new SMemberImpl();

        sMember.setNew(true);
        sMember.setPrimaryKey(memberId);

        return sMember;
    }

    /**
     * Removes the s member with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param memberId the primary key of the s member
     * @return the s member that was removed
     * @throws com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchSMemberException if a s member with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public SMember remove(long memberId)
        throws NoSuchSMemberException, SystemException {
        return remove(Long.valueOf(memberId));
    }

    /**
     * Removes the s member with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the s member
     * @return the s member that was removed
     * @throws com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchSMemberException if a s member with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SMember remove(Serializable primaryKey)
        throws NoSuchSMemberException, SystemException {
        Session session = null;

        try {
            session = openSession();

            SMember sMember = (SMember) session.get(SMemberImpl.class,
                    primaryKey);

            if (sMember == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchSMemberException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(sMember);
        } catch (NoSuchSMemberException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected SMember removeImpl(SMember sMember) throws SystemException {
        sMember = toUnwrappedModel(sMember);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, sMember);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(sMember);

        return sMember;
    }

    @Override
    public SMember updateImpl(
        com.cetus.jengine.orm.ext.liferay.testportlet.model.SMember sMember,
        boolean merge) throws SystemException {
        sMember = toUnwrappedModel(sMember);

        boolean isNew = sMember.isNew();

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, sMember, merge);

            sMember.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(SMemberModelImpl.ENTITY_CACHE_ENABLED,
            SMemberImpl.class, sMember.getPrimaryKey(), sMember);

        return sMember;
    }

    protected SMember toUnwrappedModel(SMember sMember) {
        if (sMember instanceof SMemberImpl) {
            return sMember;
        }

        SMemberImpl sMemberImpl = new SMemberImpl();

        sMemberImpl.setNew(sMember.isNew());
        sMemberImpl.setPrimaryKey(sMember.getPrimaryKey());

        sMemberImpl.setMemberId(sMember.getMemberId());
        sMemberImpl.setLibraryId(sMember.getLibraryId());
        sMemberImpl.setFirstName(sMember.getFirstName());
        sMemberImpl.setLastName(sMember.getLastName());

        return sMemberImpl;
    }

    /**
     * Returns the s member with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the s member
     * @return the s member
     * @throws com.liferay.portal.NoSuchModelException if a s member with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SMember findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the s member with the primary key or throws a {@link com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchSMemberException} if it could not be found.
     *
     * @param memberId the primary key of the s member
     * @return the s member
     * @throws com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchSMemberException if a s member with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public SMember findByPrimaryKey(long memberId)
        throws NoSuchSMemberException, SystemException {
        SMember sMember = fetchByPrimaryKey(memberId);

        if (sMember == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + memberId);
            }

            throw new NoSuchSMemberException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                memberId);
        }

        return sMember;
    }

    /**
     * Returns the s member with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the s member
     * @return the s member, or <code>null</code> if a s member with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SMember fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the s member with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param memberId the primary key of the s member
     * @return the s member, or <code>null</code> if a s member with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public SMember fetchByPrimaryKey(long memberId) throws SystemException {
        SMember sMember = (SMember) EntityCacheUtil.getResult(SMemberModelImpl.ENTITY_CACHE_ENABLED,
                SMemberImpl.class, memberId);

        if (sMember == _nullSMember) {
            return null;
        }

        if (sMember == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                sMember = (SMember) session.get(SMemberImpl.class,
                        Long.valueOf(memberId));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (sMember != null) {
                    cacheResult(sMember);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(SMemberModelImpl.ENTITY_CACHE_ENABLED,
                        SMemberImpl.class, memberId, _nullSMember);
                }

                closeSession(session);
            }
        }

        return sMember;
    }

    /**
     * Returns all the s members.
     *
     * @return the s members
     * @throws SystemException if a system exception occurred
     */
    public List<SMember> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the s members.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of s members
     * @param end the upper bound of the range of s members (not inclusive)
     * @return the range of s members
     * @throws SystemException if a system exception occurred
     */
    public List<SMember> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the s members.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of s members
     * @param end the upper bound of the range of s members (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of s members
     * @throws SystemException if a system exception occurred
     */
    public List<SMember> findAll(int start, int end,
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

        List<SMember> list = (List<SMember>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_SMEMBER);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_SMEMBER;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<SMember>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<SMember>) QueryUtil.list(q, getDialect(),
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
     * Removes all the s members from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (SMember sMember : findAll()) {
            remove(sMember);
        }
    }

    /**
     * Returns the number of s members.
     *
     * @return the number of s members
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_SMEMBER);

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
     * Initializes the s member persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.cetus.jengine.orm.ext.liferay.testportlet.model.SMember")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<SMember>> listenersList = new ArrayList<ModelListener<SMember>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<SMember>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(SMemberImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
