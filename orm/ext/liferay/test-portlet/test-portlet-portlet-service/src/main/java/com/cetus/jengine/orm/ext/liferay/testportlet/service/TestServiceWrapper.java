package com.cetus.jengine.orm.ext.liferay.testportlet.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link TestService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       TestService
 * @generated
 */
public class TestServiceWrapper implements TestService,
    ServiceWrapper<TestService> {
    private TestService _testService;

    public TestServiceWrapper(TestService testService) {
        _testService = testService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _testService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _testService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _testService.invokeMethod(name, parameterTypes, arguments);
    }

    public void test()
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _testService.test();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public TestService getWrappedTestService() {
        return _testService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedTestService(TestService testService) {
        _testService = testService;
    }

    public TestService getWrappedService() {
        return _testService;
    }

    public void setWrappedService(TestService testService) {
        _testService = testService;
    }
}
