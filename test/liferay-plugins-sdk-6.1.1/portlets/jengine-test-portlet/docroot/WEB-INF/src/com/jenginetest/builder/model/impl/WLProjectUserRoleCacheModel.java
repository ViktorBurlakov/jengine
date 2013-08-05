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

import com.jenginetest.builder.model.WLProjectUserRole;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing WLProjectUserRole in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see WLProjectUserRole
 * @generated
 */
public class WLProjectUserRoleCacheModel implements CacheModel<WLProjectUserRole>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", projectUserRoleId=");
		sb.append(projectUserRoleId);
		sb.append(", projectUserId=");
		sb.append(projectUserId);
		sb.append(", roleId=");
		sb.append(roleId);
		sb.append("}");

		return sb.toString();
	}

	public WLProjectUserRole toEntityModel() {
		WLProjectUserRoleImpl wlProjectUserRoleImpl = new WLProjectUserRoleImpl();

		wlProjectUserRoleImpl.setGroupId(groupId);
		wlProjectUserRoleImpl.setCompanyId(companyId);
		wlProjectUserRoleImpl.setProjectUserRoleId(projectUserRoleId);
		wlProjectUserRoleImpl.setProjectUserId(projectUserId);
		wlProjectUserRoleImpl.setRoleId(roleId);

		wlProjectUserRoleImpl.resetOriginalValues();

		return wlProjectUserRoleImpl;
	}

	public long groupId;
	public long companyId;
	public long projectUserRoleId;
	public long projectUserId;
	public long roleId;
}