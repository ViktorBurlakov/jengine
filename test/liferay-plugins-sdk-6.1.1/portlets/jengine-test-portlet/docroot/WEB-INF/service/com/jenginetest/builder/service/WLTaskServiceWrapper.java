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
 * This class is a wrapper for {@link WLTaskService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       WLTaskService
 * @generated
 */
public class WLTaskServiceWrapper implements WLTaskService,
	ServiceWrapper<WLTaskService> {
	public WLTaskServiceWrapper(WLTaskService wlTaskService) {
		_wlTaskService = wlTaskService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _wlTaskService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_wlTaskService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _wlTaskService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public WLTaskService getWrappedWLTaskService() {
		return _wlTaskService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedWLTaskService(WLTaskService wlTaskService) {
		_wlTaskService = wlTaskService;
	}

	public WLTaskService getWrappedService() {
		return _wlTaskService;
	}

	public void setWrappedService(WLTaskService wlTaskService) {
		_wlTaskService = wlTaskService;
	}

	private WLTaskService _wlTaskService;
}