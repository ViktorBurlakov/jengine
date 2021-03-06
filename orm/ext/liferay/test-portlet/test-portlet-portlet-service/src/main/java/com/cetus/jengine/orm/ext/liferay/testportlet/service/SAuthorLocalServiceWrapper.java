package com.cetus.jengine.orm.ext.liferay.testportlet.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link SAuthorLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       SAuthorLocalService
 * @generated
 */
public class SAuthorLocalServiceWrapper implements SAuthorLocalService,
    ServiceWrapper<SAuthorLocalService> {
    private SAuthorLocalService _sAuthorLocalService;

    public SAuthorLocalServiceWrapper(SAuthorLocalService sAuthorLocalService) {
        _sAuthorLocalService = sAuthorLocalService;
    }

    /**
    * Adds the s author to the database. Also notifies the appropriate model listeners.
    *
    * @param sAuthor the s author
    * @return the s author that was added
    * @throws SystemException if a system exception occurred
    */
    public com.cetus.jengine.orm.ext.liferay.testportlet.model.SAuthor addSAuthor(
        com.cetus.jengine.orm.ext.liferay.testportlet.model.SAuthor sAuthor)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _sAuthorLocalService.addSAuthor(sAuthor);
    }

    /**
    * Creates a new s author with the primary key. Does not add the s author to the database.
    *
    * @param authorId the primary key for the new s author
    * @return the new s author
    */
    public com.cetus.jengine.orm.ext.liferay.testportlet.model.SAuthor createSAuthor(
        long authorId) {
        return _sAuthorLocalService.createSAuthor(authorId);
    }

    /**
    * Deletes the s author with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param authorId the primary key of the s author
    * @return the s author that was removed
    * @throws PortalException if a s author with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.cetus.jengine.orm.ext.liferay.testportlet.model.SAuthor deleteSAuthor(
        long authorId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _sAuthorLocalService.deleteSAuthor(authorId);
    }

    /**
    * Deletes the s author from the database. Also notifies the appropriate model listeners.
    *
    * @param sAuthor the s author
    * @return the s author that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.cetus.jengine.orm.ext.liferay.testportlet.model.SAuthor deleteSAuthor(
        com.cetus.jengine.orm.ext.liferay.testportlet.model.SAuthor sAuthor)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _sAuthorLocalService.deleteSAuthor(sAuthor);
    }

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _sAuthorLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _sAuthorLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _sAuthorLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _sAuthorLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _sAuthorLocalService.dynamicQueryCount(dynamicQuery);
    }

    public com.cetus.jengine.orm.ext.liferay.testportlet.model.SAuthor fetchSAuthor(
        long authorId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _sAuthorLocalService.fetchSAuthor(authorId);
    }

    /**
    * Returns the s author with the primary key.
    *
    * @param authorId the primary key of the s author
    * @return the s author
    * @throws PortalException if a s author with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.cetus.jengine.orm.ext.liferay.testportlet.model.SAuthor getSAuthor(
        long authorId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _sAuthorLocalService.getSAuthor(authorId);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _sAuthorLocalService.getPersistedModel(primaryKeyObj);
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
    public java.util.List<com.cetus.jengine.orm.ext.liferay.testportlet.model.SAuthor> getSAuthors(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _sAuthorLocalService.getSAuthors(start, end);
    }

    /**
    * Returns the number of s authors.
    *
    * @return the number of s authors
    * @throws SystemException if a system exception occurred
    */
    public int getSAuthorsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _sAuthorLocalService.getSAuthorsCount();
    }

    /**
    * Updates the s author in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param sAuthor the s author
    * @return the s author that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.cetus.jengine.orm.ext.liferay.testportlet.model.SAuthor updateSAuthor(
        com.cetus.jengine.orm.ext.liferay.testportlet.model.SAuthor sAuthor)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _sAuthorLocalService.updateSAuthor(sAuthor);
    }

    /**
    * Updates the s author in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param sAuthor the s author
    * @param merge whether to merge the s author with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the s author that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.cetus.jengine.orm.ext.liferay.testportlet.model.SAuthor updateSAuthor(
        com.cetus.jengine.orm.ext.liferay.testportlet.model.SAuthor sAuthor,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _sAuthorLocalService.updateSAuthor(sAuthor, merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _sAuthorLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _sAuthorLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _sAuthorLocalService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public SAuthorLocalService getWrappedSAuthorLocalService() {
        return _sAuthorLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedSAuthorLocalService(
        SAuthorLocalService sAuthorLocalService) {
        _sAuthorLocalService = sAuthorLocalService;
    }

    public SAuthorLocalService getWrappedService() {
        return _sAuthorLocalService;
    }

    public void setWrappedService(SAuthorLocalService sAuthorLocalService) {
        _sAuthorLocalService = sAuthorLocalService;
    }
}
