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
 * This class is a wrapper for {@link WLProjectUserService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       WLProjectUserService
 * @generated
 */
public class WLProjectUserServiceWrapper implements WLProjectUserService,
	ServiceWrapper<WLProjectUserService> {
	public WLProjectUserServiceWrapper(
		WLProjectUserService wlProjectUserService) {
		_wlProjectUserService = wlProjectUserService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _wlProjectUserService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_wlProjectUserService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _wlProjectUserService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public WLProjectUserService getWrappedWLProjectUserService() {
		return _wlProjectUserService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedWLProjectUserService(
		WLProjectUserService wlProjectUserService) {
		_wlProjectUserService = wlProjectUserService;
	}

	public WLProjectUserService getWrappedService() {
		return _wlProjectUserService;
	}

	public void setWrappedService(WLProjectUserService wlProjectUserService) {
		_wlProjectUserService = wlProjectUserService;
	}

	private WLProjectUserService _wlProjectUserService;
}