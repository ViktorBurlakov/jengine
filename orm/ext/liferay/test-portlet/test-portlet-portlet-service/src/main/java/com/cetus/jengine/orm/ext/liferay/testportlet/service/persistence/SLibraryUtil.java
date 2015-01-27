package com.cetus.jengine.orm.ext.liferay.testportlet.service.persistence;

import com.cetus.jengine.orm.ext.liferay.testportlet.model.SLibrary;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the s library service. This utility wraps {@link SLibraryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SLibraryPersistence
 * @see SLibraryPersistenceImpl
 * @generated
 */
public class SLibraryUtil {
    private static SLibraryPersistence _persistence;

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
    public static void clearCache(SLibrary sLibrary) {
        getPersistence().clearCache(sLibrary);
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
    public static List<SLibrary> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<SLibrary> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<SLibrary> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static SLibrary update(SLibrary sLibrary, boolean merge)
        throws SystemException {
        return getPersistence().update(sLibrary, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static SLibrary update(SLibrary sLibrary, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(sLibrary, merge, serviceContext);
    }

    /**
    * Caches the s library in the entity cache if it is enabled.
    *
    * @param sLibrary the s library
    */
    public static void cacheResult(
        com.cetus.jengine.orm.ext.liferay.testportlet.model.SLibrary sLibrary) {
        getPersistence().cacheResult(sLibrary);
    }

    /**
    * Caches the s libraries in the entity cache if it is enabled.
    *
    * @param sLibraries the s libraries
    */
    public static void cacheResult(
        java.util.List<com.cetus.jengine.orm.ext.liferay.testportlet.model.SLibrary> sLibraries) {
        getPersistence().cacheResult(sLibraries);
    }

    /**
    * Creates a new s library with the primary key. Does not add the s library to the database.
    *
    * @param libraryId the primary key for the new s library
    * @return the new s library
    */
    public static com.cetus.jengine.orm.ext.liferay.testportlet.model.SLibrary create(
        long libraryId) {
        return getPersistence().create(libraryId);
    }

    /**
    * Removes the s library with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param libraryId the primary key of the s library
    * @return the s library that was removed
    * @throws com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchSLibraryException if a s library with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.cetus.jengine.orm.ext.liferay.testportlet.model.SLibrary remove(
        long libraryId)
        throws com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchSLibraryException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(libraryId);
    }

    public static com.cetus.jengine.orm.ext.liferay.testportlet.model.SLibrary updateImpl(
        com.cetus.jengine.orm.ext.liferay.testportlet.model.SLibrary sLibrary,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(sLibrary, merge);
    }

    /**
    * Returns the s library with the primary key or throws a {@link com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchSLibraryException} if it could not be found.
    *
    * @param libraryId the primary key of the s library
    * @return the s library
    * @throws com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchSLibraryException if a s library with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.cetus.jengine.orm.ext.liferay.testportlet.model.SLibrary findByPrimaryKey(
        long libraryId)
        throws com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchSLibraryException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(libraryId);
    }

    /**
    * Returns the s library with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param libraryId the primary key of the s library
    * @return the s library, or <code>null</code> if a s library with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.cetus.jengine.orm.ext.liferay.testportlet.model.SLibrary fetchByPrimaryKey(
        long libraryId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(libraryId);
    }

    /**
    * Returns all the s libraries.
    *
    * @return the s libraries
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.cetus.jengine.orm.ext.liferay.testportlet.model.SLibrary> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<com.cetus.jengine.orm.ext.liferay.testportlet.model.SLibrary> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
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
    public static java.util.List<com.cetus.jengine.orm.ext.liferay.testportlet.model.SLibrary> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the s libraries from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of s libraries.
    *
    * @return the number of s libraries
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static SLibraryPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (SLibraryPersistence) PortletBeanLocatorUtil.locate(com.cetus.jengine.orm.ext.liferay.testportlet.service.ClpSerializer.getServletContextName(),
                    SLibraryPersistence.class.getName());

            ReferenceRegistry.registerReference(SLibraryUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(SLibraryPersistence persistence) {
    }
}
