/*
 * This file is part of JEngine.
 *
 * Copyright (C) 2013 Victor Burlakov
 *
 * JEngine is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JEngine is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with JEngine.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.jenginetest.builder.service.impl;

import com.jenginetest.builder.service.base.WLProjectServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the w l project remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.jenginetest.builder.service.WLProjectService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.jenginetest.builder.service.base.WLProjectServiceBaseImpl
 * @see com.jenginetest.builder.service.WLProjectServiceUtil
 */
public class WLProjectServiceImpl extends WLProjectServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.jenginetest.builder.service.WLProjectServiceUtil} to access the w l project remote service.
	 */

    public void test() throws SystemException, PortalException {
        test1();
        test2();
        test3();
        test4();
    }
    public void test1() throws SystemException, PortalException {
        wlProjectLocalService.test1();
    }
    public void test2() throws SystemException, PortalException {
        wlProjectLocalService.test2();
    }

    public void test3() throws SystemException, PortalException {
        wlProjectLocalService.test3();
    }

    public void test4() throws SystemException, PortalException {
        wlProjectLocalService.test4();
    }
}