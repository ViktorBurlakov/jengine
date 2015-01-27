package com.cetus.jengine.orm.ext.liferay.testportlet.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link SBookLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       SBookLocalService
 * @generated
 */
public class SBookLocalServiceWrapper implements SBookLocalService,
    ServiceWrapper<SBookLocalService> {
    private SBookLocalService _sBookLocalService;

    public SBookLocalServiceWrapper(SBookLocalService sBookLocalService) {
        _sBookLocalService = sBookLocalService;
    }

    /**
    * Adds the s book to the database. Also notifies the appropriate model listeners.
    *
    * @param sBook the s book
    * @return the s book that was added
    * @throws SystemException if a system exception occurred
    */
    public com.cetus.jengine.orm.ext.liferay.testportlet.model.SBook addSBook(
        com.cetus.jengine.orm.ext.liferay.testportlet.model.SBook sBook)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _sBookLocalService.addSBook(sBook);
    }

    /**
    * Creates a new s book with the primary key. Does not add the s book to the database.
    *
    * @param bookId the primary key for the new s book
    * @return the new s book
    */
    public com.cetus.jengine.orm.ext.liferay.testportlet.model.SBook createSBook(
        long bookId) {
        return _sBookLocalService.createSBook(bookId);
    }

    /**
    * Deletes the s book with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param bookId the primary key of the s book
    * @return the s book that was removed
    * @throws PortalException if a s book with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.cetus.jengine.orm.ext.liferay.testportlet.model.SBook deleteSBook(
        long bookId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _sBookLocalService.deleteSBook(bookId);
    }

    /**
    * Deletes the s book from the database. Also notifies the appropriate model listeners.
    *
    * @param sBook the s book
    * @return the s book that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.cetus.jengine.orm.ext.liferay.testportlet.model.SBook deleteSBook(
        com.cetus.jengine.orm.ext.liferay.testportlet.model.SBook sBook)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _sBookLocalService.deleteSBook(sBook);
    }

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _sBookLocalService.dynamicQuery();
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
        return _sBookLocalService.dynamicQuery(dynamicQuery);
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
        return _sBookLocalService.dynamicQuery(dynamicQuery, start, end);
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
        return _sBookLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _sBookLocalService.dynamicQueryCount(dynamicQuery);
    }

    public com.cetus.jengine.orm.ext.liferay.testportlet.model.SBook fetchSBook(
        long bookId) throws com.liferay.portal.kernel.exception.SystemException {
        return _sBookLocalService.fetchSBook(bookId);
    }

    /**
    * Returns the s book with the primary key.
    *
    * @param bookId the primary key of the s book
    * @return the s book
    * @throws PortalException if a s book with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.cetus.jengine.orm.ext.liferay.testportlet.model.SBook getSBook(
        long bookId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _sBookLocalService.getSBook(bookId);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _sBookLocalService.getPersistedModel(primaryKeyObj);
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
    public java.util.List<com.cetus.jengine.orm.ext.liferay.testportlet.model.SBook> getSBooks(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _sBookLocalService.getSBooks(start, end);
    }

    /**
    * Returns the number of s books.
    *
    * @return the number of s books
    * @throws SystemException if a system exception occurred
    */
    public int getSBooksCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _sBookLocalService.getSBooksCount();
    }

    /**
    * Updates the s book in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param sBook the s book
    * @return the s book that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.cetus.jengine.orm.ext.liferay.testportlet.model.SBook updateSBook(
        com.cetus.jengine.orm.ext.liferay.testportlet.model.SBook sBook)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _sBookLocalService.updateSBook(sBook);
    }

    /**
    * Updates the s book in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param sBook the s book
    * @param merge whether to merge the s book with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the s book that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.cetus.jengine.orm.ext.liferay.testportlet.model.SBook updateSBook(
        com.cetus.jengine.orm.ext.liferay.testportlet.model.SBook sBook,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _sBookLocalService.updateSBook(sBook, merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _sBookLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _sBookLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _sBookLocalService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public SBookLocalService getWrappedSBookLocalService() {
        return _sBookLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedSBookLocalService(SBookLocalService sBookLocalService) {
        _sBookLocalService = sBookLocalService;
    }

    public SBookLocalService getWrappedService() {
        return _sBookLocalService;
    }

    public void setWrappedService(SBookLocalService sBookLocalService) {
        _sBookLocalService = sBookLocalService;
    }
}
