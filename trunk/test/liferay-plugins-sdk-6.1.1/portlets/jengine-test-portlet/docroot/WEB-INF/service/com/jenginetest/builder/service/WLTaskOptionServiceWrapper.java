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
 * This class is a wrapper for {@link WLTaskOptionService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       WLTaskOptionService
 * @generated
 */
public class WLTaskOptionServiceWrapper implements WLTaskOptionService,
	ServiceWrapper<WLTaskOptionService> {
	public WLTaskOptionServiceWrapper(WLTaskOptionService wlTaskOptionService) {
		_wlTaskOptionService = wlTaskOptionService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _wlTaskOptionService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_wlTaskOptionService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _wlTaskOptionService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public WLTaskOptionService getWrappedWLTaskOptionService() {
		return _wlTaskOptionService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedWLTaskOptionService(
		WLTaskOptionService wlTaskOptionService) {
		_wlTaskOptionService = wlTaskOptionService;
	}

	public WLTaskOptionService getWrappedService() {
		return _wlTaskOptionService;
	}

	public void setWrappedService(WLTaskOptionService wlTaskOptionService) {
		_wlTaskOptionService = wlTaskOptionService;
	}

	private WLTaskOptionService _wlTaskOptionService;
}