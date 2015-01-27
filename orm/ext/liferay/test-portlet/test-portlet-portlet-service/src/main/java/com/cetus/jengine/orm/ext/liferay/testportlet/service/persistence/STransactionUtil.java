package com.cetus.jengine.orm.ext.liferay.testportlet.service.persistence;

import com.cetus.jengine.orm.ext.liferay.testportlet.model.STransaction;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the s transaction service. This utility wraps {@link STransactionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see STransactionPersistence
 * @see STransactionPersistenceImpl
 * @generated
 */
public class STransactionUtil {
    private static STransactionPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(STransaction sTransaction) {
        getPersistence().clearCache(sTransaction);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<STransaction> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<STransaction> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<STransaction> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static STransaction update(STransaction sTransaction, boolean merge)
        throws SystemException {
        return getPersistence().update(sTransaction, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static STransaction update(STransaction sTransaction, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(sTransaction, merge, serviceContext);
    }

    /**
    * Caches the s transaction in the entity cache if it is enabled.
    *
    * @param sTransaction the s transaction
    */
    public static void cacheResult(
        com.cetus.jengine.orm.ext.liferay.testportlet.model.STransaction sTransaction) {
        getPersistence().cacheResult(sTransaction);
    }

    /**
    * Caches the s transactions in the entity cache if it is enabled.
    *
    * @param sTransactions the s transactions
    */
    public static void cacheResult(
        java.util.List<com.cetus.jengine.orm.ext.liferay.testportlet.model.STransaction> sTransactions) {
        getPersistence().cacheResult(sTransactions);
    }

    /**
    * Creates a new s transaction with the primary key. Does not add the s transaction to the database.
    *
    * @param transactionId the primary key for the new s transaction
    * @return the new s transaction
    */
    public static com.cetus.jengine.orm.ext.liferay.testportlet.model.STransaction create(
        long transactionId) {
        return getPersistence().create(transactionId);
    }

    /**
    * Removes the s transaction with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param transactionId the primary key of the s transaction
    * @return the s transaction that was removed
    * @throws com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchSTransactionException if a s transaction with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.cetus.jengine.orm.ext.liferay.testportlet.model.STransaction remove(
        long transactionId)
        throws com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchSTransactionException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(transactionId);
    }

    public static com.cetus.jengine.orm.ext.liferay.testportlet.model.STransaction updateImpl(
        com.cetus.jengine.orm.ext.liferay.testportlet.model.STransaction sTransaction,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(sTransaction, merge);
    }

    /**
    * Returns the s transaction with the primary key or throws a {@link com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchSTransactionException} if it could not be found.
    *
    * @param transactionId the primary key of the s transaction
    * @return the s transaction
    * @throws com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchSTransactionException if a s transaction with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.cetus.jengine.orm.ext.liferay.testportlet.model.STransaction findByPrimaryKey(
        long transactionId)
        throws com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchSTransactionException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(transactionId);
    }

    /**
    * Returns the s transaction with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param transactionId the primary key of the s transaction
    * @return the s transaction, or <code>null</code> if a s transaction with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.cetus.jengine.orm.ext.liferay.testportlet.model.STransaction fetchByPrimaryKey(
        long transactionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(transactionId);
    }

    /**
    * Returns all the s transactions.
    *
    * @return the s transactions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.cetus.jengine.orm.ext.liferay.testportlet.model.STransaction> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<com.cetus.jengine.orm.ext.liferay.testportlet.model.STransaction> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
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
    public static java.util.List<com.cetus.jengine.orm.ext.liferay.testportlet.model.STransaction> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the s transactions from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of s transactions.
    *
    * @return the number of s transactions
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static STransactionPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (STransactionPersistence) PortletBeanLocatorUtil.locate(com.cetus.jengine.orm.ext.liferay.testportlet.service.ClpSerializer.getServletContextName(),
                    STransactionPersistence.class.getName());

            ReferenceRegistry.registerReference(STransactionUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(STransactionPersistence persistence) {
    }
}
