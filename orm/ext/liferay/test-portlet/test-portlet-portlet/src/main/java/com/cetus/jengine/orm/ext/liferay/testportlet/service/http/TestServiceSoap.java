package com.cetus.jengine.orm.ext.liferay.testportlet.service.http;

import com.cetus.jengine.orm.ext.liferay.testportlet.service.TestServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * <p>
 * This class provides a SOAP utility for the
 * {@link com.cetus.jengine.orm.ext.liferay.testportlet.service.TestServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at
 * http://localhost:8080/api/secure/axis. Set the property
 * <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       TestServiceHttp
 * @see       com.cetus.jengine.orm.ext.liferay.testportlet.service.TestServiceUtil
 * @generated
 */
public class TestServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(TestServiceSoap.class);

    public static void test() throws RemoteException {
        try {
            TestServiceUtil.test();
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
