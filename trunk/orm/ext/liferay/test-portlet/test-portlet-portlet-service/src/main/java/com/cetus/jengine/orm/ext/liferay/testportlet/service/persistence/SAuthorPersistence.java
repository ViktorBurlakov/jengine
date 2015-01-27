package com.cetus.jengine.orm.ext.liferay.testportlet.service.persistence;

import com.cetus.jengine.orm.ext.liferay.testportlet.model.SAuthor;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the s author service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SAuthorPersistenceImpl
 * @see SAuthorUtil
 * @generated
 */
public interface SAuthorPersistence extends BasePersistence<SAuthor> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link SAuthorUtil} to access the s author persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the s author in the entity cache if it is enabled.
    *
    * @param sAuthor the s author
    */
    public void cacheResult(
        com.cetus.jengine.orm.ext.liferay.testportlet.model.SAuthor sAuthor);

    /**
    * Caches the s authors in the entity cache if it is enabled.
    *
    * @param sAuthors the s authors
    */
    public void cacheResult(
        java.util.List<com.cetus.jengine.orm.ext.liferay.testportlet.model.SAuthor> sAuthors);

    /**
    * Creates a new s author with the primary key. Does not add the s author to the database.
    *
    * @param authorId the primary key for the new s author
    * @return the new s author
    */
    public com.cetus.jengine.orm.ext.liferay.testportlet.model.SAuthor create(
        long authorId);

    /**
    * Removes the s author with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param authorId the primary key of the s author
    * @return the s author that was removed
    * @throws com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchSAuthorException if a s author with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.cetus.jengine.orm.ext.liferay.testportlet.model.SAuthor remove(
        long authorId)
        throws com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchSAuthorException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.cetus.jengine.orm.ext.liferay.testportlet.model.SAuthor updateImpl(
        com.cetus.jengine.orm.ext.liferay.testportlet.model.SAuthor sAuthor,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the s author with the primary key or throws a {@link com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchSAuthorException} if it could not be found.
    *
    * @param authorId the primary key of the s author
    * @return the s author
    * @throws com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchSAuthorException if a s author with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.cetus.jengine.orm.ext.liferay.testportlet.model.SAuthor findByPrimaryKey(
        long authorId)
        throws com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchSAuthorException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the s author with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param authorId the primary key of the s author
    * @return the s author, or <code>null</code> if a s author with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.cetus.jengine.orm.ext.liferay.testportlet.model.SAuthor fetchByPrimaryKey(
        long authorId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the s authors.
    *
    * @return the s authors
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.cetus.jengine.orm.ext.liferay.testportlet.model.SAuthor> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.cetus.jengine.orm.ext.liferay.testportlet.model.SAuthor> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.cetus.jengine.orm.ext.liferay.testportlet.model.SAuthor> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the s authors from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of s authors.
    *
    * @return the number of s authors
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
