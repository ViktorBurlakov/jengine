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

package com.jenginetest.builder.model.impl;

import com.jenginetest.builder.model.Library;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing Library in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Library
 * @generated
 */
public class LibraryCacheModel implements CacheModel<Library>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{libraryId=");
		sb.append(libraryId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", address=");
		sb.append(address);
		sb.append("}");

		return sb.toString();
	}

	public Library toEntityModel() {
		LibraryImpl libraryImpl = new LibraryImpl();

		libraryImpl.setLibraryId(libraryId);

		if (name == null) {
			libraryImpl.setName(StringPool.BLANK);
		}
		else {
			libraryImpl.setName(name);
		}

		if (address == null) {
			libraryImpl.setAddress(StringPool.BLANK);
		}
		else {
			libraryImpl.setAddress(address);
		}

		libraryImpl.resetOriginalValues();

		return libraryImpl;
	}

	public long libraryId;
	public String name;
	public String address;
}