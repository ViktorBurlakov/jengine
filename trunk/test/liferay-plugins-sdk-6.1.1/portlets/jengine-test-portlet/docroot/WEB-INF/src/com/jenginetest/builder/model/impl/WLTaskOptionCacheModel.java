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

import com.jenginetest.builder.model.WLTaskOption;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing WLTaskOption in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see WLTaskOption
 * @generated
 */
public class WLTaskOptionCacheModel implements CacheModel<WLTaskOption>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{optionId=");
		sb.append(optionId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createUserId=");
		sb.append(createUserId);
		sb.append(", createUserName=");
		sb.append(createUserName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedUserId=");
		sb.append(modifiedUserId);
		sb.append(", modifiedUserName=");
		sb.append(modifiedUserName);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", taskId=");
		sb.append(taskId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", data=");
		sb.append(data);
		sb.append("}");

		return sb.toString();
	}

	public WLTaskOption toEntityModel() {
		WLTaskOptionImpl wlTaskOptionImpl = new WLTaskOptionImpl();

		wlTaskOptionImpl.setOptionId(optionId);
		wlTaskOptionImpl.setGroupId(groupId);
		wlTaskOptionImpl.setCompanyId(companyId);
		wlTaskOptionImpl.setCreateUserId(createUserId);

		if (createUserName == null) {
			wlTaskOptionImpl.setCreateUserName(StringPool.BLANK);
		}
		else {
			wlTaskOptionImpl.setCreateUserName(createUserName);
		}

		if (createDate == Long.MIN_VALUE) {
			wlTaskOptionImpl.setCreateDate(null);
		}
		else {
			wlTaskOptionImpl.setCreateDate(new Date(createDate));
		}

		wlTaskOptionImpl.setModifiedUserId(modifiedUserId);

		if (modifiedUserName == null) {
			wlTaskOptionImpl.setModifiedUserName(StringPool.BLANK);
		}
		else {
			wlTaskOptionImpl.setModifiedUserName(modifiedUserName);
		}

		if (modifiedDate == Long.MIN_VALUE) {
			wlTaskOptionImpl.setModifiedDate(null);
		}
		else {
			wlTaskOptionImpl.setModifiedDate(new Date(modifiedDate));
		}

		wlTaskOptionImpl.setTaskId(taskId);

		if (name == null) {
			wlTaskOptionImpl.setName(StringPool.BLANK);
		}
		else {
			wlTaskOptionImpl.setName(name);
		}

		if (data == null) {
			wlTaskOptionImpl.setData(StringPool.BLANK);
		}
		else {
			wlTaskOptionImpl.setData(data);
		}

		wlTaskOptionImpl.resetOriginalValues();

		return wlTaskOptionImpl;
	}

	public long optionId;
	public long groupId;
	public long companyId;
	public long createUserId;
	public String createUserName;
	public long createDate;
	public long modifiedUserId;
	public String modifiedUserName;
	public long modifiedDate;
	public long taskId;
	public String name;
	public String data;
}