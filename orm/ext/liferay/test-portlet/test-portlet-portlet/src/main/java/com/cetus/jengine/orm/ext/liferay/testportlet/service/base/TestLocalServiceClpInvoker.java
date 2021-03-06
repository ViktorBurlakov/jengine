package com.cetus.jengine.orm.ext.liferay.testportlet.service.base;

import com.cetus.jengine.orm.ext.liferay.testportlet.service.TestLocalServiceUtil;

import java.util.Arrays;


public class TestLocalServiceClpInvoker {
    private String _methodName50;
    private String[] _methodParameterTypes50;
    private String _methodName51;
    private String[] _methodParameterTypes51;
    private String _methodName54;
    private String[] _methodParameterTypes54;

    public TestLocalServiceClpInvoker() {
        _methodName50 = "getBeanIdentifier";

        _methodParameterTypes50 = new String[] {  };

        _methodName51 = "setBeanIdentifier";

        _methodParameterTypes51 = new String[] { "java.lang.String" };

        _methodName54 = "test";

        _methodParameterTypes54 = new String[] {  };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName50.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes50, parameterTypes)) {
            return TestLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName51.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes51, parameterTypes)) {
            TestLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);
        }

        if (_methodName54.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
            TestLocalServiceUtil.test();
        }

        throw new UnsupportedOperationException();
    }
}
