package com.cetus.jengine.orm.ext.liferay.testportlet.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link SLibraryService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       SLibraryService
 * @generated
 */
public class SLibraryServiceWrapper implements SLibraryService,
    ServiceWrapper<SLibraryService> {
    private SLibraryService _sLibraryService;

    public SLibraryServiceWrapper(SLibraryService sLibraryService) {
        _sLibraryService = sLibraryService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _sLibraryService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _sLibraryService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _sLibraryService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public SLibraryService getWrappedSLibraryService() {
        return _sLibraryService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedSLibraryService(SLibraryService sLibraryService) {
        _sLibraryService = sLibraryService;
    }

    public SLibraryService getWrappedService() {
        return _sLibraryService;
    }

    public void setWrappedService(SLibraryService sLibraryService) {
        _sLibraryService = sLibraryService;
    }
}
