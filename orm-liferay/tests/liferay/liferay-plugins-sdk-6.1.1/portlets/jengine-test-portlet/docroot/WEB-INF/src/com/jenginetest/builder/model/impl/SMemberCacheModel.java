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

import com.jenginetest.builder.model.SMember;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing SMember in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see SMember
 * @generated
 */
public class SMemberCacheModel implements CacheModel<SMember>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{memberId=");
		sb.append(memberId);
		sb.append(", libraryId=");
		sb.append(libraryId);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append("}");

		return sb.toString();
	}

	public SMember toEntityModel() {
		SMemberImpl sMemberImpl = new SMemberImpl();

		sMemberImpl.setMemberId(memberId);
		sMemberImpl.setLibraryId(libraryId);

		if (firstName == null) {
			sMemberImpl.setFirstName(StringPool.BLANK);
		}
		else {
			sMemberImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			sMemberImpl.setLastName(StringPool.BLANK);
		}
		else {
			sMemberImpl.setLastName(lastName);
		}

		sMemberImpl.resetOriginalValues();

		return sMemberImpl;
	}

	public long memberId;
	public long libraryId;
	public String firstName;
	public String lastName;
}