package com.cetus.jengine.orm.ext.liferay.testportlet.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the s library local service. This utility wraps {@link com.cetus.jengine.orm.ext.liferay.testportlet.service.impl.SLibraryLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SLibraryLocalService
 * @see com.cetus.jengine.orm.ext.liferay.testportlet.service.base.SLibraryLocalServiceBaseImpl
 * @see com.cetus.jengine.orm.ext.liferay.testportlet.service.impl.SLibraryLocalServiceImpl
 * @generated
 */
public class SLibraryLocalServiceUtil {
    private static SLibraryLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.cetus.jengine.orm.ext.liferay.testportlet.service.impl.SLibraryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the s library to the database. Also notifies the appropriate model listeners.
    *
    * @param sLibrary the s library
    * @return the s library that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.cetus.jengine.orm.ext.liferay.testportlet.model.SLibrary addSLibrary(
        com.cetus.jengine.orm.ext.liferay.testportlet.model.SLibrary sLibrary)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addSLibrary(sLibrary);
    }

    /**
    * Creates a new s library with the primary key. Does not add the s library to the database.
    *
    * @param libraryId the primary key for the new s library
    * @return the new s library
    */
    public static com.cetus.jengine.orm.ext.liferay.testportlet.model.SLibrary createSLibrary(
        long libraryId) {
        return getService().createSLibrary(libraryId);
    }

    /**
    * Deletes the s library with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param libraryId the primary key of the s library
    * @return the s library that was removed
    * @throws PortalException if a s library with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.cetus.jengine.orm.ext.liferay.testportlet.model.SLibrary deleteSLibrary(
        long libraryId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteSLibrary(libraryId);
    }

    /**
    * Deletes the s library from the database. Also notifies the appropriate model listeners.
    *
    * @param sLibrary the s library
    * @return the s library that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.cetus.jengine.orm.ext.liferay.testportlet.model.SLibrary deleteSLibrary(
        com.cetus.jengine.orm.ext.liferay.testportlet.model.SLibrary sLibrary)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteSLibrary(sLibrary);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
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
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
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
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    public static com.cetus.jengine.orm.ext.liferay.testportlet.model.SLibrary fetchSLibrary(
        long libraryId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchSLibrary(libraryId);
    }

    /**
    * Returns the s library with the primary key.
    *
    * @param libraryId the primary key of the s library
    * @return the s library
    * @throws PortalException if a s library with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.cetus.jengine.orm.ext.liferay.testportlet.model.SLibrary getSLibrary(
        long libraryId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getSLibrary(libraryId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static java.util.List<com.cetus.jengine.orm.ext.liferay.testportlet.model.SLibrary> getSLibraries(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getSLibraries(start, end);
    }

    /**
    * Returns the number of s libraries.
    *
    * @return the number of s libraries
    * @throws SystemException if a system exception occurred
    */
    public static int getSLibrariesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getSLibrariesCount();
    }

    /**
    * Updates the s library in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param sLibrary the s library
    * @return the s library that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.cetus.jengine.orm.ext.liferay.testportlet.model.SLibrary updateSLibrary(
        com.cetus.jengine.orm.ext.liferay.testportlet.model.SLibrary sLibrary)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateSLibrary(sLibrary);
    }

    /**
    * Updates the s library in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param sLibrary the s library
    * @param merge whether to merge the s library with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the s library that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.cetus.jengine.orm.ext.liferay.testportlet.model.SLibrary updateSLibrary(
        com.cetus.jengine.orm.ext.liferay.testportlet.model.SLibrary sLibrary,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateSLibrary(sLibrary, merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static void clearService() {
        _service = null;
    }

    public static SLibraryLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    SLibraryLocalService.class.getName());

            if (invokableLocalService instanceof SLibraryLocalService) {
                _service = (SLibraryLocalService) invokableLocalService;
            } else {
                _service = new SLibraryLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(SLibraryLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated
     */
    public void setService(SLibraryLocalService service) {
    }
}
