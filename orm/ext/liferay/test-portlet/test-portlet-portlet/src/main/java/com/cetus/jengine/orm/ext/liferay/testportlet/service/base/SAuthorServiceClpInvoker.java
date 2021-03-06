package com.cetus.jengine.orm.ext.liferay.testportlet.service.base;

import com.cetus.jengine.orm.ext.liferay.testportlet.service.SAuthorServiceUtil;

import java.util.Arrays;


public class SAuthorServiceClpInvoker {
    private String _methodName50;
    private String[] _methodParameterTypes50;
    private String _methodName51;
    private String[] _methodParameterTypes51;

    public SAuthorServiceClpInvoker() {
        _methodName50 = "getBeanIdentifier";

        _methodParameterTypes50 = new String[] {  };

        _methodName51 = "setBeanIdentifier";

        _methodParameterTypes51 = new String[] { "java.lang.String" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName50.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes50, parameterTypes)) {
            return SAuthorServiceUtil.getBeanIdentifier();
        }

        if (_methodName51.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes51, parameterTypes)) {
            SAuthorServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);
        }

        throw new UnsupportedOperationException();
    }
}
