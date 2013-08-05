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

import com.jenginetest.builder.model.WLEventLog;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing WLEventLog in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see WLEventLog
 * @generated
 */
public class WLEventLogCacheModel implements CacheModel<WLEventLog>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", eventLogId=");
		sb.append(eventLogId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", logDate=");
		sb.append(logDate);
		sb.append(", event=");
		sb.append(event);
		sb.append(", title=");
		sb.append(title);
		sb.append(", modelName=");
		sb.append(modelName);
		sb.append(", modelPK=");
		sb.append(modelPK);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	public WLEventLog toEntityModel() {
		WLEventLogImpl wlEventLogImpl = new WLEventLogImpl();

		wlEventLogImpl.setGroupId(groupId);
		wlEventLogImpl.setCompanyId(companyId);
		wlEventLogImpl.setEventLogId(eventLogId);
		wlEventLogImpl.setUserId(userId);

		if (logDate == Long.MIN_VALUE) {
			wlEventLogImpl.setLogDate(null);
		}
		else {
			wlEventLogImpl.setLogDate(new Date(logDate));
		}

		if (event == null) {
			wlEventLogImpl.setEvent(StringPool.BLANK);
		}
		else {
			wlEventLogImpl.setEvent(event);
		}

		if (title == null) {
			wlEventLogImpl.setTitle(StringPool.BLANK);
		}
		else {
			wlEventLogImpl.setTitle(title);
		}

		if (modelName == null) {
			wlEventLogImpl.setModelName(StringPool.BLANK);
		}
		else {
			wlEventLogImpl.setModelName(modelName);
		}

		wlEventLogImpl.setModelPK(modelPK);

		if (description == null) {
			wlEventLogImpl.setDescription(StringPool.BLANK);
		}
		else {
			wlEventLogImpl.setDescription(description);
		}

		wlEventLogImpl.resetOriginalValues();

		return wlEventLogImpl;
	}

	public long groupId;
	public long companyId;
	public long eventLogId;
	public long userId;
	public long logDate;
	public String event;
	public String title;
	public String modelName;
	public Long modelPK;
	public String description;
}