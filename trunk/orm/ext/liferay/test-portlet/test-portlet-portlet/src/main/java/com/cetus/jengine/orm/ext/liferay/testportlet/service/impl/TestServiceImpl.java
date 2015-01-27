package com.cetus.jengine.orm.ext.liferay.testportlet.service.impl;

import com.cetus.jengine.orm.ext.liferay.testportlet.service.base.TestServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;


/**
 * The implementation of the test remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.cetus.jengine.orm.ext.liferay.testportlet.service.TestService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.cetus.jengine.orm.ext.liferay.testportlet.service.base.TestServiceBaseImpl
 * @see com.cetus.jengine.orm.ext.liferay.testportlet.service.TestServiceUtil
 */
public class TestServiceImpl extends TestServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.cetus.jengine.orm.ext.liferay.testportlet.service.TestServiceUtil} to access the test remote service.
     */

    public void test() throws SystemException, PortalException {
        testLocalService.test();
    }

}
