package com.cetus.jengine.orm.ext.liferay.testportlet.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link SAuthorService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       SAuthorService
 * @generated
 */
public class SAuthorServiceWrapper implements SAuthorService,
    ServiceWrapper<SAuthorService> {
    private SAuthorService _sAuthorService;

    public SAuthorServiceWrapper(SAuthorService sAuthorService) {
        _sAuthorService = sAuthorService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _sAuthorService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _sAuthorService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _sAuthorService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public SAuthorService getWrappedSAuthorService() {
        return _sAuthorService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedSAuthorService(SAuthorService sAuthorService) {
        _sAuthorService = sAuthorService;
    }

    public SAuthorService getWrappedService() {
        return _sAuthorService;
    }

    public void setWrappedService(SAuthorService sAuthorService) {
        _sAuthorService = sAuthorService;
    }
}
