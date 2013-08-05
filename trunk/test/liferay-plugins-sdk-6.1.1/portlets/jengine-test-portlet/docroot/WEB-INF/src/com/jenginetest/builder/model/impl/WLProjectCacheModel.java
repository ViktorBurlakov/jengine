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

import com.jenginetest.builder.model.WLProject;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing WLProject in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see WLProject
 * @generated
 */
public class WLProjectCacheModel implements CacheModel<WLProject>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(43);

		sb.append("{projectId=");
		sb.append(projectId);
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
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", title=");
		sb.append(title);
		sb.append(", status=");
		sb.append(status);
		sb.append(", description=");
		sb.append(description);
		sb.append(", color=");
		sb.append(color);
		sb.append(", lockEnable=");
		sb.append(lockEnable);
		sb.append(", lockPeriodType=");
		sb.append(lockPeriodType);
		sb.append(", lockDeferment=");
		sb.append(lockDeferment);
		sb.append(", automaticallyAssign=");
		sb.append(automaticallyAssign);
		sb.append(", defaultProject=");
		sb.append(defaultProject);
		sb.append(", externalUrl=");
		sb.append(externalUrl);
		sb.append(", externalMandatory=");
		sb.append(externalMandatory);
		sb.append("}");

		return sb.toString();
	}

	public WLProject toEntityModel() {
		WLProjectImpl wlProjectImpl = new WLProjectImpl();

		wlProjectImpl.setProjectId(projectId);
		wlProjectImpl.setGroupId(groupId);
		wlProjectImpl.setCompanyId(companyId);
		wlProjectImpl.setCreateUserId(createUserId);

		if (createUserName == null) {
			wlProjectImpl.setCreateUserName(StringPool.BLANK);
		}
		else {
			wlProjectImpl.setCreateUserName(createUserName);
		}

		if (createDate == Long.MIN_VALUE) {
			wlProjectImpl.setCreateDate(null);
		}
		else {
			wlProjectImpl.setCreateDate(new Date(createDate));
		}

		wlProjectImpl.setModifiedUserId(modifiedUserId);

		if (modifiedUserName == null) {
			wlProjectImpl.setModifiedUserName(StringPool.BLANK);
		}
		else {
			wlProjectImpl.setModifiedUserName(modifiedUserName);
		}

		if (modifiedDate == Long.MIN_VALUE) {
			wlProjectImpl.setModifiedDate(null);
		}
		else {
			wlProjectImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (startDate == Long.MIN_VALUE) {
			wlProjectImpl.setStartDate(null);
		}
		else {
			wlProjectImpl.setStartDate(new Date(startDate));
		}

		if (title == null) {
			wlProjectImpl.setTitle(StringPool.BLANK);
		}
		else {
			wlProjectImpl.setTitle(title);
		}

		wlProjectImpl.setStatus(status);

		if (description == null) {
			wlProjectImpl.setDescription(StringPool.BLANK);
		}
		else {
			wlProjectImpl.setDescription(description);
		}

		if (color == null) {
			wlProjectImpl.setColor(StringPool.BLANK);
		}
		else {
			wlProjectImpl.setColor(color);
		}

		wlProjectImpl.setLockEnable(lockEnable);

		if (lockPeriodType == null) {
			wlProjectImpl.setLockPeriodType(StringPool.BLANK);
		}
		else {
			wlProjectImpl.setLockPeriodType(lockPeriodType);
		}

		wlProjectImpl.setLockDeferment(lockDeferment);
		wlProjectImpl.setAutomaticallyAssign(automaticallyAssign);
		wlProjectImpl.setDefaultProject(defaultProject);

		if (externalUrl == null) {
			wlProjectImpl.setExternalUrl(StringPool.BLANK);
		}
		else {
			wlProjectImpl.setExternalUrl(externalUrl);
		}

		wlProjectImpl.setExternalMandatory(externalMandatory);

		wlProjectImpl.resetOriginalValues();

		return wlProjectImpl;
	}

	public long projectId;
	public long groupId;
	public long companyId;
	public long createUserId;
	public String createUserName;
	public long createDate;
	public long modifiedUserId;
	public String modifiedUserName;
	public long modifiedDate;
	public long startDate;
	public String title;
	public int status;
	public String description;
	public String color;
	public boolean lockEnable;
	public String lockPeriodType;
	public int lockDeferment;
	public boolean automaticallyAssign;
	public boolean defaultProject;
	public String externalUrl;
	public boolean externalMandatory;
}