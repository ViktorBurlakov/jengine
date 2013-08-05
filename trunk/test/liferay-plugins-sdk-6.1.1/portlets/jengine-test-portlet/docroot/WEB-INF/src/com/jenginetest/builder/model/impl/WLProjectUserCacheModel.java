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

package com.jenginetest.builder.model.impl;

import com.jenginetest.builder.model.WLProjectUser;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing WLProjectUser in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see WLProjectUser
 * @generated
 */
public class WLProjectUserCacheModel implements CacheModel<WLProjectUser>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", projectUserId=");
		sb.append(projectUserId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", projectId=");
		sb.append(projectId);
		sb.append("}");

		return sb.toString();
	}

	public WLProjectUser toEntityModel() {
		WLProjectUserImpl wlProjectUserImpl = new WLProjectUserImpl();

		wlProjectUserImpl.setGroupId(groupId);
		wlProjectUserImpl.setCompanyId(companyId);
		wlProjectUserImpl.setProjectUserId(projectUserId);
		wlProjectUserImpl.setUserId(userId);
		wlProjectUserImpl.setProjectId(projectId);

		wlProjectUserImpl.resetOriginalValues();

		return wlProjectUserImpl;
	}

	public long groupId;
	public long companyId;
	public long projectUserId;
	public long userId;
	public long projectId;
}