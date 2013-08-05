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

import com.jenginetest.builder.model.WLEntry;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing WLEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see WLEntry
 * @generated
 */
public class WLEntryCacheModel implements CacheModel<WLEntry>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{entryId=");
		sb.append(entryId);
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
		sb.append(", start=");
		sb.append(start);
		sb.append(", startTime=");
		sb.append(startTime);
		sb.append(", finishTime=");
		sb.append(finishTime);
		sb.append(", entryDate=");
		sb.append(entryDate);
		sb.append(", entryTime=");
		sb.append(entryTime);
		sb.append(", timezone=");
		sb.append(timezone);
		sb.append(", length=");
		sb.append(length);
		sb.append(", taskId=");
		sb.append(taskId);
		sb.append("}");

		return sb.toString();
	}

	public WLEntry toEntityModel() {
		WLEntryImpl wlEntryImpl = new WLEntryImpl();

		wlEntryImpl.setEntryId(entryId);
		wlEntryImpl.setCreateUserId(createUserId);

		if (createUserName == null) {
			wlEntryImpl.setCreateUserName(StringPool.BLANK);
		}
		else {
			wlEntryImpl.setCreateUserName(createUserName);
		}

		if (createDate == Long.MIN_VALUE) {
			wlEntryImpl.setCreateDate(null);
		}
		else {
			wlEntryImpl.setCreateDate(new Date(createDate));
		}

		wlEntryImpl.setModifiedUserId(modifiedUserId);

		if (modifiedUserName == null) {
			wlEntryImpl.setModifiedUserName(StringPool.BLANK);
		}
		else {
			wlEntryImpl.setModifiedUserName(modifiedUserName);
		}

		if (modifiedDate == Long.MIN_VALUE) {
			wlEntryImpl.setModifiedDate(null);
		}
		else {
			wlEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (start == Long.MIN_VALUE) {
			wlEntryImpl.setStart(null);
		}
		else {
			wlEntryImpl.setStart(new Date(start));
		}

		wlEntryImpl.setStartTime(startTime);
		wlEntryImpl.setFinishTime(finishTime);

		if (entryDate == Long.MIN_VALUE) {
			wlEntryImpl.setEntryDate(null);
		}
		else {
			wlEntryImpl.setEntryDate(new Date(entryDate));
		}

		wlEntryImpl.setEntryTime(entryTime);
		wlEntryImpl.setTimezone(timezone);
		wlEntryImpl.setLength(length);
		wlEntryImpl.setTaskId(taskId);

		wlEntryImpl.resetOriginalValues();

		return wlEntryImpl;
	}

	public long entryId;
	public long createUserId;
	public String createUserName;
	public long createDate;
	public long modifiedUserId;
	public String modifiedUserName;
	public long modifiedDate;
	public long start;
	public long startTime;
	public long finishTime;
	public long entryDate;
	public long entryTime;
	public int timezone;
	public long length;
	public long taskId;
}