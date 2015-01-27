package com.cetus.jengine.orm.ext.liferay.testportlet.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * The utility for the s transaction remote service. This utility wraps {@link com.cetus.jengine.orm.ext.liferay.testportlet.service.impl.STransactionServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see STransactionService
 * @see com.cetus.jengine.orm.ext.liferay.testportlet.service.base.STransactionServiceBaseImpl
 * @see com.cetus.jengine.orm.ext.liferay.testportlet.service.impl.STransactionServiceImpl
 * @generated
 */
public class STransactionServiceUtil {
    private static STransactionService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.cetus.jengine.orm.ext.liferay.testportlet.service.impl.STransactionServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

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

    public static STransactionService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    STransactionService.class.getName());

            if (invokableService instanceof STransactionService) {
                _service = (STransactionService) invokableService;
            } else {
                _service = new STransactionServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(STransactionServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated
     */
    public void setService(STransactionService service) {
    }
}
