package com.cetus.jengine.orm.ext.liferay.testportlet.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link STransactionService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       STransactionService
 * @generated
 */
public class STransactionServiceWrapper implements STransactionService,
    ServiceWrapper<STransactionService> {
    private STransactionService _sTransactionService;

    public STransactionServiceWrapper(STransactionService sTransactionService) {
        _sTransactionService = sTransactionService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _sTransactionService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _sTransactionService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _sTransactionService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public STransactionService getWrappedSTransactionService() {
        return _sTransactionService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedSTransactionService(
        STransactionService sTransactionService) {
        _sTransactionService = sTransactionService;
    }

    public STransactionService getWrappedService() {
        return _sTransactionService;
    }

    public void setWrappedService(STransactionService sTransactionService) {
        _sTransactionService = sTransactionService;
    }
}
