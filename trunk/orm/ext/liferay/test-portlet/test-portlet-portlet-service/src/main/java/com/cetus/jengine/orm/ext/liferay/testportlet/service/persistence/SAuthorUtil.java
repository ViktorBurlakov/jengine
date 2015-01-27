package com.cetus.jengine.orm.ext.liferay.testportlet.service.persistence;

import com.cetus.jengine.orm.ext.liferay.testportlet.model.SAuthor;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the s author service. This utility wraps {@link SAuthorPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SAuthorPersistence
 * @see SAuthorPersistenceImpl
 * @generated
 */
public class SAuthorUtil {
    private static SAuthorPersistence _persistence;

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
    public static void clearCache(SAuthor sAuthor) {
        getPersistence().clearCache(sAuthor);
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
    public static List<SAuthor> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<SAuthor> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<SAuthor> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static SAuthor update(SAuthor sAuthor, boolean merge)
        throws SystemException {
        return getPersistence().update(sAuthor, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static SAuthor update(SAuthor sAuthor, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(sAuthor, merge, serviceContext);
    }

    /**
    * Caches the s author in the entity cache if it is enabled.
    *
    * @param sAuthor the s author
    */
    public static void cacheResult(
        com.cetus.jengine.orm.ext.liferay.testportlet.model.SAuthor sAuthor) {
        getPersistence().cacheResult(sAuthor);
    }

    /**
    * Caches the s authors in the entity cache if it is enabled.
    *
    * @param sAuthors the s authors
    */
    public static void cacheResult(
        java.util.List<com.cetus.jengine.orm.ext.liferay.testportlet.model.SAuthor> sAuthors) {
        getPersistence().cacheResult(sAuthors);
    }

    /**
    * Creates a new s author with the primary key. Does not add the s author to the database.
    *
    * @param authorId the primary key for the new s author
    * @return the new s author
    */
    public static com.cetus.jengine.orm.ext.liferay.testportlet.model.SAuthor create(
        long authorId) {
        return getPersistence().create(authorId);
    }

    /**
    * Removes the s author with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param authorId the primary key of the s author
    * @return the s author that was removed
    * @throws com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchSAuthorException if a s author with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.cetus.jengine.orm.ext.liferay.testportlet.model.SAuthor remove(
        long authorId)
        throws com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchSAuthorException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(authorId);
    }

    public static com.cetus.jengine.orm.ext.liferay.testportlet.model.SAuthor updateImpl(
        com.cetus.jengine.orm.ext.liferay.testportlet.model.SAuthor sAuthor,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(sAuthor, merge);
    }

    /**
    * Returns the s author with the primary key or throws a {@link com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchSAuthorException} if it could not be found.
    *
    * @param authorId the primary key of the s author
    * @return the s author
    * @throws com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchSAuthorException if a s author with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.cetus.jengine.orm.ext.liferay.testportlet.model.SAuthor findByPrimaryKey(
        long authorId)
        throws com.cetus.jengine.orm.ext.liferay.testportlet.NoSuchSAuthorException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(authorId);
    }

    /**
    * Returns the s author with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param authorId the primary key of the s author
    * @return the s author, or <code>null</code> if a s author with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.cetus.jengine.orm.ext.liferay.testportlet.model.SAuthor fetchByPrimaryKey(
        long authorId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(authorId);
    }

    /**
    * Returns all the s authors.
    *
    * @return the s authors
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.cetus.jengine.orm.ext.liferay.testportlet.model.SAuthor> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<com.cetus.jengine.orm.ext.liferay.testportlet.model.SAuthor> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
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
    public static java.util.List<com.cetus.jengine.orm.ext.liferay.testportlet.model.SAuthor> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the s authors from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of s authors.
    *
    * @return the number of s authors
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static SAuthorPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (SAuthorPersistence) PortletBeanLocatorUtil.locate(com.cetus.jengine.orm.ext.liferay.testportlet.service.ClpSerializer.getServletContextName(),
                    SAuthorPersistence.class.getName());

            ReferenceRegistry.registerReference(SAuthorUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(SAuthorPersistence persistence) {
    }
}
