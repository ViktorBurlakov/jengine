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

import com.jenginetest.builder.model.SLibrary;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing SLibrary in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see SLibrary
 * @generated
 */
public class SLibraryCacheModel implements CacheModel<SLibrary>, Serializable {
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

	public SLibrary toEntityModel() {
		SLibraryImpl sLibraryImpl = new SLibraryImpl();

		sLibraryImpl.setLibraryId(libraryId);

		if (name == null) {
			sLibraryImpl.setName(StringPool.BLANK);
		}
		else {
			sLibraryImpl.setName(name);
		}

		if (address == null) {
			sLibraryImpl.setAddress(StringPool.BLANK);
		}
		else {
			sLibraryImpl.setAddress(address);
		}

		sLibraryImpl.resetOriginalValues();

		return sLibraryImpl;
	}

	public long libraryId;
	public String name;
	public String address;
}