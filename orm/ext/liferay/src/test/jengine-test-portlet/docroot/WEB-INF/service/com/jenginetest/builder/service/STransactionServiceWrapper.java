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

package com.jenginetest.builder.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link STransactionService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       STransactionService
 * @generated
 */
public class STransactionServiceWrapper implements STransactionService,
	ServiceWrapper<STransactionService> {
	public STransactionServiceWrapper(STransactionService sTransactionService) {
		_sTransactionService = sTransactionService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _sTransactionService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_sTransactionService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _sTransactionService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public STransactionService getWrappedSTransactionService() {
		return _sTransactionService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedSTransactionService(
		STransactionService sTransactionService) {
		_sTransactionService = sTransactionService;
	}

	public STransactionService getWrappedService() {
		return _sTransactionService;
	}

	public void setWrappedService(STransactionService sTransactionService) {
		_sTransactionService = sTransactionService;
	}

	private STransactionService _sTransactionService;
}