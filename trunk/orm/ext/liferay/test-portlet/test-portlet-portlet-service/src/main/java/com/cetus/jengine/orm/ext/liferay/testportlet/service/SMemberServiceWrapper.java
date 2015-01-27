package com.cetus.jengine.orm.ext.liferay.testportlet.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link SMemberService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       SMemberService
 * @generated
 */
public class SMemberServiceWrapper implements SMemberService,
    ServiceWrapper<SMemberService> {
    private SMemberService _sMemberService;

    public SMemberServiceWrapper(SMemberService sMemberService) {
        _sMemberService = sMemberService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _sMemberService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _sMemberService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _sMemberService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public SMemberService getWrappedSMemberService() {
        return _sMemberService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedSMemberService(SMemberService sMemberService) {
        _sMemberService = sMemberService;
    }

    public SMemberService getWrappedService() {
        return _sMemberService;
    }

    public void setWrappedService(SMemberService sMemberService) {
        _sMemberService = sMemberService;
    }
}
