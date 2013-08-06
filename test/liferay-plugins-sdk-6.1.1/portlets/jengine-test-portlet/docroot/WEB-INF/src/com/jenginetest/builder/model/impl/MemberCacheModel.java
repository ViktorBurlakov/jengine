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

import com.jenginetest.builder.model.Member;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing Member in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Member
 * @generated
 */
public class MemberCacheModel implements CacheModel<Member>, Serializable {
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

	public Member toEntityModel() {
		MemberImpl memberImpl = new MemberImpl();

		memberImpl.setMemberId(memberId);
		memberImpl.setLibraryId(libraryId);

		if (firstName == null) {
			memberImpl.setFirstName(StringPool.BLANK);
		}
		else {
			memberImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			memberImpl.setLastName(StringPool.BLANK);
		}
		else {
			memberImpl.setLastName(lastName);
		}

		memberImpl.resetOriginalValues();

		return memberImpl;
	}

	public long memberId;
	public long libraryId;
	public String firstName;
	public String lastName;
}