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

import com.jenginetest.builder.model.SBook;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing SBook in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see SBook
 * @generated
 */
public class SBookCacheModel implements CacheModel<SBook>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{bookId=");
		sb.append(bookId);
		sb.append(", libraryId=");
		sb.append(libraryId);
		sb.append(", title=");
		sb.append(title);
		sb.append("}");

		return sb.toString();
	}

	public SBook toEntityModel() {
		SBookImpl sBookImpl = new SBookImpl();

		sBookImpl.setBookId(bookId);
		sBookImpl.setLibraryId(libraryId);

		if (title == null) {
			sBookImpl.setTitle(StringPool.BLANK);
		}
		else {
			sBookImpl.setTitle(title);
		}

		sBookImpl.resetOriginalValues();

		return sBookImpl;
	}

	public long bookId;
	public long libraryId;
	public String title;
}