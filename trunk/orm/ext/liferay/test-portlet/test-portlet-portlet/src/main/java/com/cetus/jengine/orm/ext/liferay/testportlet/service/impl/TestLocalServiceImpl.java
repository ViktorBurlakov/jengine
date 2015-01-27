package com.cetus.jengine.orm.ext.liferay.testportlet.service.impl;

import com.cetus.jengine.orm.ext.liferay.testportlet.test.Test;
import com.cetus.jengine.orm.ext.liferay.testportlet.service.base.TestLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;


/**
 * The implementation of the test local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.cetus.jengine.orm.ext.liferay.testportlet.service.TestLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.cetus.jengine.orm.ext.liferay.testportlet.service.base.TestLocalServiceBaseImpl
 * @see com.cetus.jengine.orm.ext.liferay.testportlet.service.TestLocalServiceUtil
 */
public class TestLocalServiceImpl extends TestLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.cetus.jengine.orm.ext.liferay.testportlet.service.TestLocalServiceUtil} to access the test local service.
     */

    public void test() throws SystemException, PortalException {
        try {
            Test.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
