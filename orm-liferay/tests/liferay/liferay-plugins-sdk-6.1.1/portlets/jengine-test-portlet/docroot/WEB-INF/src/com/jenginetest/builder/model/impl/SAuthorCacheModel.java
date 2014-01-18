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

import com.jenginetest.builder.model.SAuthor;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing SAuthor in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see SAuthor
 * @generated
 */
public class SAuthorCacheModel implements CacheModel<SAuthor>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{authorId=");
		sb.append(authorId);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append("}");

		return sb.toString();
	}

	public SAuthor toEntityModel() {
		SAuthorImpl sAuthorImpl = new SAuthorImpl();

		sAuthorImpl.setAuthorId(authorId);

		if (firstName == null) {
			sAuthorImpl.setFirstName(StringPool.BLANK);
		}
		else {
			sAuthorImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			sAuthorImpl.setLastName(StringPool.BLANK);
		}
		else {
			sAuthorImpl.setLastName(lastName);
		}

		sAuthorImpl.resetOriginalValues();

		return sAuthorImpl;
	}

	public long authorId;
	public String firstName;
	public String lastName;
}