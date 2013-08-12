/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.jenginetest.builder.service.impl;

import com.jenginetest.builder.service.base.TestServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the test remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.jenginetest.builder.service.TestService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.jenginetest.builder.service.base.TestServiceBaseImpl
 * @see com.jenginetest.builder.service.TestServiceUtil
 */
public class TestServiceImpl extends TestServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.jenginetest.builder.service.TestServiceUtil} to access the test remote service.
	 */
    public void test() throws SystemException, PortalException {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
    }
    public void test1() throws SystemException, PortalException {
        testLocalService.test1();
    }
    public void test2() throws SystemException, PortalException {
        testLocalService.test2();
    }

    public void test3() throws SystemException, PortalException {
        testLocalService.test3();
    }

    public void test4() throws SystemException, PortalException {
        testLocalService.test4();
    }

    public void test5() throws SystemException, PortalException {
        testLocalService.test5();
    }

    public void test6() throws SystemException, PortalException {
        testLocalService.test6();
    }

    public void test7() throws SystemException, PortalException {
        testLocalService.test7();
    }
}