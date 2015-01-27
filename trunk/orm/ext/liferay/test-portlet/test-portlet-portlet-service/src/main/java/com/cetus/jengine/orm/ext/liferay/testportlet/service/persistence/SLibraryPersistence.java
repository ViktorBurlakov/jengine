package com.cetus.jengine.orm.ext.liferay.testportlet.service.persistence;

import com.cetus.jengine.orm.ext.liferay.testportlet.model.SLibrary;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the s library service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SLibraryPersistenceImpl
 * @see SLibraryUtil
 * @generated
 */
public interface SLibraryPersistence extends BasePersistence<SLibrary> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link SLibraryUtil} to access the s library persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the s library in the entity cache if it is enabled.
    *
    * @param sLibrary the s library
    */
    public void cacheResult(
        com.cetus.jengine.orm.ext.liferay.testportlet.model.SLibrary sLibrary);

    /**
    * Caches the s libraries in the entity cache if it is enabled.
    *
    * @param sLibraries the s libraries
    */
    public void cacheResult(
        java.util.List<com.cetus.jengine.orm.ext.liferay.testportlet.model.SLibrary> sLibraries);

    /**
    * Creates a new s library with the primary key. Does not add the s library to the database.
    *
    * @param libraryId the primary key for the new s library
    * @return the new s library
    */
    public com.cetus.jengine.orm.ext.liferay.testportlet.model.SLibrary create(
        long libraryId);

    /**
    * Removes the s library with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param libraryId the primary key of the s library
    * @return the s library that was removed
    * @throws com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchSLibraryException if a s library with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.cetus.jengine.orm.ext.liferay.testportlet.model.SLibrary remove(
        long libraryId)
        throws com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchSLibraryException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.cetus.jengine.orm.ext.liferay.testportlet.model.SLibrary updateImpl(
        com.cetus.jengine.orm.ext.liferay.testportlet.model.SLibrary sLibrary,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the s library with the primary key or throws a {@link com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchSLibraryException} if it could not be found.
    *
    * @param libraryId the primary key of the s library
    * @return the s library
    * @throws com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchSLibraryException if a s library with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.cetus.jengine.orm.ext.liferay.testportlet.model.SLibrary findByPrimaryKey(
        long libraryId)
        throws com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchSLibraryException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the s library with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param libraryId the primary key of the s library
    * @return the s library, or <code>null</code> if a s library with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.cetus.jengine.orm.ext.liferay.testportlet.model.SLibrary fetchByPrimaryKey(
        long libraryId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the s libraries.
    *
    * @return the s libraries
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.cetus.jengine.orm.ext.liferay.testportlet.model.SLibrary> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.cetus.jengine.orm.ext.liferay.testportlet.model.SLibrary> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.cetus.jengine.orm.ext.liferay.testportlet.model.SLibrary> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the s libraries from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of s libraries.
    *
    * @return the number of s libraries
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
