package com.cetus.jengine.orm.ext.liferay.testportlet.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link TestLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       TestLocalService
 * @generated
 */
public class TestLocalServiceWrapper implements TestLocalService,
    ServiceWrapper<TestLocalService> {
    private TestLocalService _testLocalService;

    public TestLocalServiceWrapper(TestLocalService testLocalService) {
        _testLocalService = testLocalService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _testLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _testLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _testLocalService.invokeMethod(name, parameterTypes, arguments);
    }

    public void test()
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _testLocalService.test();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public TestLocalService getWrappedTestLocalService() {
        return _testLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedTestLocalService(TestLocalService testLocalService) {
        _testLocalService = testLocalService;
    }

    public TestLocalService getWrappedService() {
        return _testLocalService;
    }

    public void setWrappedService(TestLocalService testLocalService) {
        _testLocalService = testLocalService;
    }
}
