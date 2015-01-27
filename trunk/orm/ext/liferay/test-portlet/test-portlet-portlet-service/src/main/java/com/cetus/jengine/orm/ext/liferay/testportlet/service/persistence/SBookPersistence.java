package com.cetus.jengine.orm.ext.liferay.testportlet.service.persistence;

import com.cetus.jengine.orm.ext.liferay.testportlet.model.SBook;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the s book service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SBookPersistenceImpl
 * @see SBookUtil
 * @generated
 */
public interface SBookPersistence extends BasePersistence<SBook> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link SBookUtil} to access the s book persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the s book in the entity cache if it is enabled.
    *
    * @param sBook the s book
    */
    public void cacheResult(
        com.cetus.jengine.orm.ext.liferay.testportlet.model.SBook sBook);

    /**
    * Caches the s books in the entity cache if it is enabled.
    *
    * @param sBooks the s books
    */
    public void cacheResult(
        java.util.List<com.cetus.jengine.orm.ext.liferay.testportlet.model.SBook> sBooks);

    /**
    * Creates a new s book with the primary key. Does not add the s book to the database.
    *
    * @param bookId the primary key for the new s book
    * @return the new s book
    */
    public com.cetus.jengine.orm.ext.liferay.testportlet.model.SBook create(
        long bookId);

    /**
    * Removes the s book with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param bookId the primary key of the s book
    * @return the s book that was removed
    * @throws com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchookException if a s book with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.cetus.jengine.orm.ext.liferay.testportlet.model.SBook remove(
        long bookId)
        throws com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchookException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.cetus.jengine.orm.ext.liferay.testportlet.model.SBook updateImpl(
        com.cetus.jengine.orm.ext.liferay.testportlet.model.SBook sBook,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the s book with the primary key or throws a {@link com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchookException} if it could not be found.
    *
    * @param bookId the primary key of the s book
    * @return the s book
    * @throws com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchookException if a s book with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.cetus.jengine.orm.ext.liferay.testportlet.model.SBook findByPrimaryKey(
        long bookId)
        throws com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchookException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the s book with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param bookId the primary key of the s book
    * @return the s book, or <code>null</code> if a s book with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.cetus.jengine.orm.ext.liferay.testportlet.model.SBook fetchByPrimaryKey(
        long bookId) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the s books.
    *
    * @return the s books
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.cetus.jengine.orm.ext.liferay.testportlet.model.SBook> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the s books.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of s books
    * @param end the upper bound of the range of s books (not inclusive)
    * @return the range of s books
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.cetus.jengine.orm.ext.liferay.testportlet.model.SBook> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the s books.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of s books
    * @param end the upper bound of the range of s books (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of s books
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.cetus.jengine.orm.ext.liferay.testportlet.model.SBook> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the s books from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of s books.
    *
    * @return the number of s books
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
