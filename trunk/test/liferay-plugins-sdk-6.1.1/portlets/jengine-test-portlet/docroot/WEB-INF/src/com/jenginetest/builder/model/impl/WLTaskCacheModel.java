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

import com.jenginetest.builder.model.WLTask;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing WLTask in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see WLTask
 * @generated
 */
public class WLTaskCacheModel implements CacheModel<WLTask>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{taskId=");
		sb.append(taskId);
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
		sb.append(", subject=");
		sb.append(subject);
		sb.append(", projectId=");
		sb.append(projectId);
		sb.append(", ownerId=");
		sb.append(ownerId);
		sb.append(", workerId=");
		sb.append(workerId);
		sb.append(", externalId=");
		sb.append(externalId);
		sb.append("}");

		return sb.toString();
	}

	public WLTask toEntityModel() {
		WLTaskImpl wlTaskImpl = new WLTaskImpl();

		wlTaskImpl.setTaskId(taskId);
		wlTaskImpl.setGroupId(groupId);
		wlTaskImpl.setCompanyId(companyId);
		wlTaskImpl.setCreateUserId(createUserId);

		if (createUserName == null) {
			wlTaskImpl.setCreateUserName(StringPool.BLANK);
		}
		else {
			wlTaskImpl.setCreateUserName(createUserName);
		}

		if (createDate == Long.MIN_VALUE) {
			wlTaskImpl.setCreateDate(null);
		}
		else {
			wlTaskImpl.setCreateDate(new Date(createDate));
		}

		wlTaskImpl.setModifiedUserId(modifiedUserId);

		if (modifiedUserName == null) {
			wlTaskImpl.setModifiedUserName(StringPool.BLANK);
		}
		else {
			wlTaskImpl.setModifiedUserName(modifiedUserName);
		}

		if (modifiedDate == Long.MIN_VALUE) {
			wlTaskImpl.setModifiedDate(null);
		}
		else {
			wlTaskImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (subject == null) {
			wlTaskImpl.setSubject(StringPool.BLANK);
		}
		else {
			wlTaskImpl.setSubject(subject);
		}

		wlTaskImpl.setProjectId(projectId);
		wlTaskImpl.setOwnerId(ownerId);
		wlTaskImpl.setWorkerId(workerId);

		if (externalId == null) {
			wlTaskImpl.setExternalId(StringPool.BLANK);
		}
		else {
			wlTaskImpl.setExternalId(externalId);
		}

		wlTaskImpl.resetOriginalValues();

		return wlTaskImpl;
	}

	public long taskId;
	public long groupId;
	public long companyId;
	public long createUserId;
	public String createUserName;
	public long createDate;
	public long modifiedUserId;
	public String modifiedUserName;
	public long modifiedDate;
	public String subject;
	public long projectId;
	public long ownerId;
	public long workerId;
	public String externalId;
}