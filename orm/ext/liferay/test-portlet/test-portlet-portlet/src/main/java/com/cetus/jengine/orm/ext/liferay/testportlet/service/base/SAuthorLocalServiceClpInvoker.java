package com.cetus.jengine.orm.ext.liferay.testportlet.service.base;

import com.cetus.jengine.orm.ext.liferay.testportlet.service.SAuthorLocalServiceUtil;

import java.util.Arrays;


public class SAuthorLocalServiceClpInvoker {
    private String _methodName0;
    private String[] _methodParameterTypes0;
    private String _methodName1;
    private String[] _methodParameterTypes1;
    private String _methodName2;
    private String[] _methodParameterTypes2;
    private String _methodName3;
    private String[] _methodParameterTypes3;
    private String _methodName4;
    private String[] _methodParameterTypes4;
    private String _methodName5;
    private String[] _methodParameterTypes5;
    private String _methodName6;
    private String[] _methodParameterTypes6;
    private String _methodName7;
    private String[] _methodParameterTypes7;
    private String _methodName8;
    private String[] _methodParameterTypes8;
    private String _methodName9;
    private String[] _methodParameterTypes9;
    private String _methodName10;
    private String[] _methodParameterTypes10;
    private String _methodName11;
    private String[] _methodParameterTypes11;
    private String _methodName12;
    private String[] _methodParameterTypes12;
    private String _methodName13;
    private String[] _methodParameterTypes13;
    private String _methodName14;
    private String[] _methodParameterTypes14;
    private String _methodName15;
    private String[] _methodParameterTypes15;
    private String _methodName66;
    private String[] _methodParameterTypes66;
    private String _methodName67;
    private String[] _methodParameterTypes67;

    public SAuthorLocalServiceClpInvoker() {
        _methodName0 = "addSAuthor";

        _methodParameterTypes0 = new String[] {
                "com.cetus.jengine.orm.ext.liferay.testportlet.model.SAuthor"
            };

        _methodName1 = "createSAuthor";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteSAuthor";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteSAuthor";

        _methodParameterTypes3 = new String[] {
                "com.cetus.jengine.orm.ext.liferay.testportlet.model.SAuthor"
            };

        _methodName4 = "dynamicQuery";

        _methodParameterTypes4 = new String[] {  };

        _methodName5 = "dynamicQuery";

        _methodParameterTypes5 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName6 = "dynamicQuery";

        _methodParameterTypes6 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
            };

        _methodName7 = "dynamicQuery";

        _methodParameterTypes7 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };

        _methodName8 = "dynamicQueryCount";

        _methodParameterTypes8 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName9 = "fetchSAuthor";

        _methodParameterTypes9 = new String[] { "long" };

        _methodName10 = "getSAuthor";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getPersistedModel";

        _methodParameterTypes11 = new String[] { "java.io.Serializable" };

        _methodName12 = "getSAuthors";

        _methodParameterTypes12 = new String[] { "int", "int" };

        _methodName13 = "getSAuthorsCount";

        _methodParameterTypes13 = new String[] {  };

        _methodName14 = "updateSAuthor";

        _methodParameterTypes14 = new String[] {
                "com.cetus.jengine.orm.ext.liferay.testportlet.model.SAuthor"
            };

        _methodName15 = "updateSAuthor";

        _methodParameterTypes15 = new String[] {
                "com.cetus.jengine.orm.ext.liferay.testportlet.model.SAuthor",
                "boolean"
            };

        _methodName66 = "getBeanIdentifier";

        _methodParameterTypes66 = new String[] {  };

        _methodName67 = "setBeanIdentifier";

        _methodParameterTypes67 = new String[] { "java.lang.String" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return SAuthorLocalServiceUtil.addSAuthor((com.cetus.jengine.orm.ext.liferay.testportlet.model.SAuthor) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return SAuthorLocalServiceUtil.createSAuthor(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return SAuthorLocalServiceUtil.deleteSAuthor(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return SAuthorLocalServiceUtil.deleteSAuthor((com.cetus.jengine.orm.ext.liferay.testportlet.model.SAuthor) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return SAuthorLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return SAuthorLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return SAuthorLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return SAuthorLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return SAuthorLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return SAuthorLocalServiceUtil.fetchSAuthor(((Long) arguments[0]).longValue());
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return SAuthorLocalServiceUtil.getSAuthor(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return SAuthorLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return SAuthorLocalServiceUtil.getSAuthors(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return SAuthorLocalServiceUtil.getSAuthorsCount();
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return SAuthorLocalServiceUtil.updateSAuthor((com.cetus.jengine.orm.ext.liferay.testportlet.model.SAuthor) arguments[0]);
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return SAuthorLocalServiceUtil.updateSAuthor((com.cetus.jengine.orm.ext.liferay.testportlet.model.SAuthor) arguments[0],
                ((Boolean) arguments[1]).booleanValue());
        }

        if (_methodName66.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes66, parameterTypes)) {
            return SAuthorLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName67.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes67, parameterTypes)) {
            SAuthorLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);
        }

        throw new UnsupportedOperationException();
    }
}
