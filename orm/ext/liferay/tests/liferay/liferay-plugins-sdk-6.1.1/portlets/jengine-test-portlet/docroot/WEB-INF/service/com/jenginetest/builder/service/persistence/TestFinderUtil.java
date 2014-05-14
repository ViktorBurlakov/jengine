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

package com.jenginetest.builder.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Brian Wing Shun Chan
 */
public class TestFinderUtil {
	public static java.util.List search()
		throws com.liferay.portal.SystemException {
		return getFinder().search();
	}

	public static TestFinder getFinder() {
		if (_finder == null) {
			_finder = (TestFinder)PortletBeanLocatorUtil.locate(com.jenginetest.builder.service.ClpSerializer.getServletContextName(),
					TestFinder.class.getName());

			ReferenceRegistry.registerReference(TestFinderUtil.class, "_finder");
		}

		return _finder;
	}

	public void setFinder(TestFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(TestFinderUtil.class, "_finder");
	}

	private static TestFinder _finder;
}