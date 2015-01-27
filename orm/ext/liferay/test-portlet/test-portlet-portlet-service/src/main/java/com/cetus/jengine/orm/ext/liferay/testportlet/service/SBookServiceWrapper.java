package com.cetus.jengine.orm.ext.liferay.testportlet.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link SBookService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       SBookService
 * @generated
 */
public class SBookServiceWrapper implements SBookService,
    ServiceWrapper<SBookService> {
    private SBookService _sBookService;

    public SBookServiceWrapper(SBookService sBookService) {
        _sBookService = sBookService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _sBookService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _sBookService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _sBookService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public SBookService getWrappedSBookService() {
        return _sBookService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedSBookService(SBookService sBookService) {
        _sBookService = sBookService;
    }

    public SBookService getWrappedService() {
        return _sBookService;
    }

    public void setWrappedService(SBookService sBookService) {
        _sBookService = sBookService;
    }
}
