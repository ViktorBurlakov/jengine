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
 * This class is a wrapper for {@link LoggingActivityLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       LoggingActivityLocalService
 * @generated
 */
public class LoggingActivityLocalServiceWrapper
	implements LoggingActivityLocalService,
		ServiceWrapper<LoggingActivityLocalService> {
	public LoggingActivityLocalServiceWrapper(
		LoggingActivityLocalService loggingActivityLocalService) {
		_loggingActivityLocalService = loggingActivityLocalService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _loggingActivityLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_loggingActivityLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _loggingActivityLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public LoggingActivityLocalService getWrappedLoggingActivityLocalService() {
		return _loggingActivityLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedLoggingActivityLocalService(
		LoggingActivityLocalService loggingActivityLocalService) {
		_loggingActivityLocalService = loggingActivityLocalService;
	}

	public LoggingActivityLocalService getWrappedService() {
		return _loggingActivityLocalService;
	}

	public void setWrappedService(
		LoggingActivityLocalService loggingActivityLocalService) {
		_loggingActivityLocalService = loggingActivityLocalService;
	}

	private LoggingActivityLocalService _loggingActivityLocalService;
}