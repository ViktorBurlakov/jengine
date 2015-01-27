package com.cetus.jengine.orm.ext.liferay.testportlet.service.persistence;

import com.cetus.jengine.orm.ext.liferay.testportlet.model.STransaction;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the s transaction service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see STransactionPersistenceImpl
 * @see STransactionUtil
 * @generated
 */
public interface STransactionPersistence extends BasePersistence<STransaction> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link STransactionUtil} to access the s transaction persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the s transaction in the entity cache if it is enabled.
    *
    * @param sTransaction the s transaction
    */
    public void cacheResult(
        com.cetus.jengine.orm.ext.liferay.testportlet.model.STransaction sTransaction);

    /**
    * Caches the s transactions in the entity cache if it is enabled.
    *
    * @param sTransactions the s transactions
    */
    public void cacheResult(
        java.util.List<com.cetus.jengine.orm.ext.liferay.testportlet.model.STransaction> sTransactions);

    /**
    * Creates a new s transaction with the primary key. Does not add the s transaction to the database.
    *
    * @param transactionId the primary key for the new s transaction
    * @return the new s transaction
    */
    public com.cetus.jengine.orm.ext.liferay.testportlet.model.STransaction create(
        long transactionId);

    /**
    * Removes the s transaction with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param transactionId the primary key of the s transaction
    * @return the s transaction that was removed
    * @throws com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchSTransactionException if a s transaction with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.cetus.jengine.orm.ext.liferay.testportlet.model.STransaction remove(
        long transactionId)
        throws com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchSTransactionException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.cetus.jengine.orm.ext.liferay.testportlet.model.STransaction updateImpl(
        com.cetus.jengine.orm.ext.liferay.testportlet.model.STransaction sTransaction,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the s transaction with the primary key or throws a {@link com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchSTransactionException} if it could not be found.
    *
    * @param transactionId the primary key of the s transaction
    * @return the s transaction
    * @throws com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchSTransactionException if a s transaction with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.cetus.jengine.orm.ext.liferay.testportlet.model.STransaction findByPrimaryKey(
        long transactionId)
        throws com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchSTransactionException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the s transaction with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param transactionId the primary key of the s transaction
    * @return the s transaction, or <code>null</code> if a s transaction with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.cetus.jengine.orm.ext.liferay.testportlet.model.STransaction fetchByPrimaryKey(
        long transactionId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the s transactions.
    *
    * @return the s transactions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.cetus.jengine.orm.ext.liferay.testportlet.model.STransaction> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.cetus.jengine.orm.ext.liferay.testportlet.model.STransaction> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.cetus.jengine.orm.ext.liferay.testportlet.model.STransaction> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the s transactions from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of s transactions.
    *
    * @return the number of s transactions
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
