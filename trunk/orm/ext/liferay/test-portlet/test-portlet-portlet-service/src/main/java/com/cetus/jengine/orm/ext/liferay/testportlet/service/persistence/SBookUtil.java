package com.cetus.jengine.orm.ext.liferay.testportlet.service.persistence;

import com.cetus.jengine.orm.ext.liferay.testportlet.model.SBook;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the s book service. This utility wraps {@link SBookPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SBookPersistence
 * @see SBookPersistenceImpl
 * @generated
 */
public class SBookUtil {
    private static SBookPersistence _persistence;

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
    public static void clearCache(SBook sBook) {
        getPersistence().clearCache(sBook);
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
    public static List<SBook> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<SBook> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<SBook> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static SBook update(SBook sBook, boolean merge)
        throws SystemException {
        return getPersistence().update(sBook, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static SBook update(SBook sBook, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(sBook, merge, serviceContext);
    }

    /**
    * Caches the s book in the entity cache if it is enabled.
    *
    * @param sBook the s book
    */
    public static void cacheResult(
        com.cetus.jengine.orm.ext.liferay.testportlet.model.SBook sBook) {
        getPersistence().cacheResult(sBook);
    }

    /**
    * Caches the s books in the entity cache if it is enabled.
    *
    * @param sBooks the s books
    */
    public static void cacheResult(
        java.util.List<com.cetus.jengine.orm.ext.liferay.testportlet.model.SBook> sBooks) {
        getPersistence().cacheResult(sBooks);
    }

    /**
    * Creates a new s book with the primary key. Does not add the s book to the database.
    *
    * @param bookId the primary key for the new s book
    * @return the new s book
    */
    public static com.cetus.jengine.orm.ext.liferay.testportlet.model.SBook create(
        long bookId) {
        return getPersistence().create(bookId);
    }

    /**
    * Removes the s book with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param bookId the primary key of the s book
    * @return the s book that was removed
    * @throws com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchookException if a s book with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.cetus.jengine.orm.ext.liferay.testportlet.model.SBook remove(
        long bookId)
        throws com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchookException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(bookId);
    }

    public static com.cetus.jengine.orm.ext.liferay.testportlet.model.SBook updateImpl(
        com.cetus.jengine.orm.ext.liferay.testportlet.model.SBook sBook,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(sBook, merge);
    }

    /**
    * Returns the s book with the primary key or throws a {@link com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchookException} if it could not be found.
    *
    * @param bookId the primary key of the s book
    * @return the s book
    * @throws com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchookException if a s book with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.cetus.jengine.orm.ext.liferay.testportlet.model.SBook findByPrimaryKey(
        long bookId)
        throws com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchookException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(bookId);
    }

    /**
    * Returns the s book with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param bookId the primary key of the s book
    * @return the s book, or <code>null</code> if a s book with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.cetus.jengine.orm.ext.liferay.testportlet.model.SBook fetchByPrimaryKey(
        long bookId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(bookId);
    }

    /**
    * Returns all the s books.
    *
    * @return the s books
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.cetus.jengine.orm.ext.liferay.testportlet.model.SBook> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

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
    public static java.util.List<com.cetus.jengine.orm.ext.liferay.testportlet.model.SBook> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

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
    public static java.util.List<com.cetus.jengine.orm.ext.liferay.testportlet.model.SBook> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the s books from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of s books.
    *
    * @return the number of s books
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static SBookPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (SBookPersistence) PortletBeanLocatorUtil.locate(com.cetus.jengine.orm.ext.liferay.testportlet.service.ClpSerializer.getServletContextName(),
                    SBookPersistence.class.getName());

            ReferenceRegistry.registerReference(SBookUtil.class, "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(SBookPersistence persistence) {
    }
}
