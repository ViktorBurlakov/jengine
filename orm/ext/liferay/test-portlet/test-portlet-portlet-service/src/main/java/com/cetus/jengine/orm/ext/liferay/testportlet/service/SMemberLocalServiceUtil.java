package com.cetus.jengine.orm.ext.liferay.testportlet.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the s member local service. This utility wraps {@link com.cetus.jengine.orm.ext.liferay.testportlet.service.impl.SMemberLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SMemberLocalService
 * @see com.cetus.jengine.orm.ext.liferay.testportlet.service.base.SMemberLocalServiceBaseImpl
 * @see com.cetus.jengine.orm.ext.liferay.testportlet.service.impl.SMemberLocalServiceImpl
 * @generated
 */
public class SMemberLocalServiceUtil {
    private static SMemberLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.cetus.jengine.orm.ext.liferay.testportlet.service.impl.SMemberLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the s member to the database. Also notifies the appropriate model listeners.
    *
    * @param sMember the s member
    * @return the s member that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.cetus.jengine.orm.ext.liferay.testportlet.model.SMember addSMember(
        com.cetus.jengine.orm.ext.liferay.testportlet.model.SMember sMember)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addSMember(sMember);
    }

    /**
    * Creates a new s member with the primary key. Does not add the s member to the database.
    *
    * @param memberId the primary key for the new s member
    * @return the new s member
    */
    public static com.cetus.jengine.orm.ext.liferay.testportlet.model.SMember createSMember(
        long memberId) {
        return getService().createSMember(memberId);
    }

    /**
    * Deletes the s member with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param memberId the primary key of the s member
    * @return the s member that was removed
    * @throws PortalException if a s member with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.cetus.jengine.orm.ext.liferay.testportlet.model.SMember deleteSMember(
        long memberId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteSMember(memberId);
    }

    /**
    * Deletes the s member from the database. Also notifies the appropriate model listeners.
    *
    * @param sMember the s member
    * @return the s member that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.cetus.jengine.orm.ext.liferay.testportlet.model.SMember deleteSMember(
        com.cetus.jengine.orm.ext.liferay.testportlet.model.SMember sMember)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteSMember(sMember);
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

    public static com.cetus.jengine.orm.ext.liferay.testportlet.model.SMember fetchSMember(
        long memberId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchSMember(memberId);
    }

    /**
    * Returns the s member with the primary key.
    *
    * @param memberId the primary key of the s member
    * @return the s member
    * @throws PortalException if a s member with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.cetus.jengine.orm.ext.liferay.testportlet.model.SMember getSMember(
        long memberId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getSMember(memberId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the s members.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of s members
    * @param end the upper bound of the range of s members (not inclusive)
    * @return the range of s members
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.cetus.jengine.orm.ext.liferay.testportlet.model.SMember> getSMembers(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getSMembers(start, end);
    }

    /**
    * Returns the number of s members.
    *
    * @return the number of s members
    * @throws SystemException if a system exception occurred
    */
    public static int getSMembersCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getSMembersCount();
    }

    /**
    * Updates the s member in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param sMember the s member
    * @return the s member that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.cetus.jengine.orm.ext.liferay.testportlet.model.SMember updateSMember(
        com.cetus.jengine.orm.ext.liferay.testportlet.model.SMember sMember)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateSMember(sMember);
    }

    /**
    * Updates the s member in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param sMember the s member
    * @param merge whether to merge the s member with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the s member that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.cetus.jengine.orm.ext.liferay.testportlet.model.SMember updateSMember(
        com.cetus.jengine.orm.ext.liferay.testportlet.model.SMember sMember,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateSMember(sMember, merge);
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

    public static SMemberLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    SMemberLocalService.class.getName());

            if (invokableLocalService instanceof SMemberLocalService) {
                _service = (SMemberLocalService) invokableLocalService;
            } else {
                _service = new SMemberLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(SMemberLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated
     */
    public void setService(SMemberLocalService service) {
    }
}
