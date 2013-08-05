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

package com.jenginetest.builder.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link WLProjectService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       WLProjectService
 * @generated
 */
public class WLProjectServiceWrapper implements WLProjectService,
	ServiceWrapper<WLProjectService> {
	public WLProjectServiceWrapper(WLProjectService wlProjectService) {
		_wlProjectService = wlProjectService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _wlProjectService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_wlProjectService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _wlProjectService.invokeMethod(name, parameterTypes, arguments);
	}

	public void test()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_wlProjectService.test();
	}

	public void test1()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_wlProjectService.test1();
	}

	public void test2()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_wlProjectService.test2();
	}

	public void test3()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_wlProjectService.test3();
	}

	public void test4()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_wlProjectService.test4();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public WLProjectService getWrappedWLProjectService() {
		return _wlProjectService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedWLProjectService(WLProjectService wlProjectService) {
		_wlProjectService = wlProjectService;
	}

	public WLProjectService getWrappedService() {
		return _wlProjectService;
	}

	public void setWrappedService(WLProjectService wlProjectService) {
		_wlProjectService = wlProjectService;
	}

	private WLProjectService _wlProjectService;
}