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

package com.jenginetest.builder.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link WLEntry}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       WLEntry
 * @generated
 */
public class WLEntryWrapper implements WLEntry, ModelWrapper<WLEntry> {
	public WLEntryWrapper(WLEntry wlEntry) {
		_wlEntry = wlEntry;
	}

	public Class<?> getModelClass() {
		return WLEntry.class;
	}

	public String getModelClassName() {
		return WLEntry.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("entryId", getEntryId());
		attributes.put("createUserId", getCreateUserId());
		attributes.put("createUserName", getCreateUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedUserId", getModifiedUserId());
		attributes.put("modifiedUserName", getModifiedUserName());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("start", getStart());
		attributes.put("startTime", getStartTime());
		attributes.put("finishTime", getFinishTime());
		attributes.put("entryDate", getEntryDate());
		attributes.put("entryTime", getEntryTime());
		attributes.put("timezone", getTimezone());
		attributes.put("length", getLength());
		attributes.put("taskId", getTaskId());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long entryId = (Long)attributes.get("entryId");

		if (entryId != null) {
			setEntryId(entryId);
		}

		Long createUserId = (Long)attributes.get("createUserId");

		if (createUserId != null) {
			setCreateUserId(createUserId);
		}

		String createUserName = (String)attributes.get("createUserName");

		if (createUserName != null) {
			setCreateUserName(createUserName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long modifiedUserId = (Long)attributes.get("modifiedUserId");

		if (modifiedUserId != null) {
			setModifiedUserId(modifiedUserId);
		}

		String modifiedUserName = (String)attributes.get("modifiedUserName");

		if (modifiedUserName != null) {
			setModifiedUserName(modifiedUserName);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Date start = (Date)attributes.get("start");

		if (start != null) {
			setStart(start);
		}

		Long startTime = (Long)attributes.get("startTime");

		if (startTime != null) {
			setStartTime(startTime);
		}

		Long finishTime = (Long)attributes.get("finishTime");

		if (finishTime != null) {
			setFinishTime(finishTime);
		}

		Date entryDate = (Date)attributes.get("entryDate");

		if (entryDate != null) {
			setEntryDate(entryDate);
		}

		Long entryTime = (Long)attributes.get("entryTime");

		if (entryTime != null) {
			setEntryTime(entryTime);
		}

		Integer timezone = (Integer)attributes.get("timezone");

		if (timezone != null) {
			setTimezone(timezone);
		}

		Long length = (Long)attributes.get("length");

		if (length != null) {
			setLength(length);
		}

		Long taskId = (Long)attributes.get("taskId");

		if (taskId != null) {
			setTaskId(taskId);
		}
	}

	/**
	* Returns the primary key of this w l entry.
	*
	* @return the primary key of this w l entry
	*/
	public long getPrimaryKey() {
		return _wlEntry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this w l entry.
	*
	* @param primaryKey the primary key of this w l entry
	*/
	public void setPrimaryKey(long primaryKey) {
		_wlEntry.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the entry ID of this w l entry.
	*
	* @return the entry ID of this w l entry
	*/
	public long getEntryId() {
		return _wlEntry.getEntryId();
	}

	/**
	* Sets the entry ID of this w l entry.
	*
	* @param entryId the entry ID of this w l entry
	*/
	public void setEntryId(long entryId) {
		_wlEntry.setEntryId(entryId);
	}

	/**
	* Returns the create user ID of this w l entry.
	*
	* @return the create user ID of this w l entry
	*/
	public long getCreateUserId() {
		return _wlEntry.getCreateUserId();
	}

	/**
	* Sets the create user ID of this w l entry.
	*
	* @param createUserId the create user ID of this w l entry
	*/
	public void setCreateUserId(long createUserId) {
		_wlEntry.setCreateUserId(createUserId);
	}

	/**
	* Returns the create user uuid of this w l entry.
	*
	* @return the create user uuid of this w l entry
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getCreateUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wlEntry.getCreateUserUuid();
	}

	/**
	* Sets the create user uuid of this w l entry.
	*
	* @param createUserUuid the create user uuid of this w l entry
	*/
	public void setCreateUserUuid(java.lang.String createUserUuid) {
		_wlEntry.setCreateUserUuid(createUserUuid);
	}

	/**
	* Returns the create user name of this w l entry.
	*
	* @return the create user name of this w l entry
	*/
	public java.lang.String getCreateUserName() {
		return _wlEntry.getCreateUserName();
	}

	/**
	* Sets the create user name of this w l entry.
	*
	* @param createUserName the create user name of this w l entry
	*/
	public void setCreateUserName(java.lang.String createUserName) {
		_wlEntry.setCreateUserName(createUserName);
	}

	/**
	* Returns the create date of this w l entry.
	*
	* @return the create date of this w l entry
	*/
	public java.util.Date getCreateDate() {
		return _wlEntry.getCreateDate();
	}

	/**
	* Sets the create date of this w l entry.
	*
	* @param createDate the create date of this w l entry
	*/
	public void setCreateDate(java.util.Date createDate) {
		_wlEntry.setCreateDate(createDate);
	}

	/**
	* Returns the modified user ID of this w l entry.
	*
	* @return the modified user ID of this w l entry
	*/
	public long getModifiedUserId() {
		return _wlEntry.getModifiedUserId();
	}

	/**
	* Sets the modified user ID of this w l entry.
	*
	* @param modifiedUserId the modified user ID of this w l entry
	*/
	public void setModifiedUserId(long modifiedUserId) {
		_wlEntry.setModifiedUserId(modifiedUserId);
	}

	/**
	* Returns the modified user uuid of this w l entry.
	*
	* @return the modified user uuid of this w l entry
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getModifiedUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wlEntry.getModifiedUserUuid();
	}

	/**
	* Sets the modified user uuid of this w l entry.
	*
	* @param modifiedUserUuid the modified user uuid of this w l entry
	*/
	public void setModifiedUserUuid(java.lang.String modifiedUserUuid) {
		_wlEntry.setModifiedUserUuid(modifiedUserUuid);
	}

	/**
	* Returns the modified user name of this w l entry.
	*
	* @return the modified user name of this w l entry
	*/
	public java.lang.String getModifiedUserName() {
		return _wlEntry.getModifiedUserName();
	}

	/**
	* Sets the modified user name of this w l entry.
	*
	* @param modifiedUserName the modified user name of this w l entry
	*/
	public void setModifiedUserName(java.lang.String modifiedUserName) {
		_wlEntry.setModifiedUserName(modifiedUserName);
	}

	/**
	* Returns the modified date of this w l entry.
	*
	* @return the modified date of this w l entry
	*/
	public java.util.Date getModifiedDate() {
		return _wlEntry.getModifiedDate();
	}

	/**
	* Sets the modified date of this w l entry.
	*
	* @param modifiedDate the modified date of this w l entry
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_wlEntry.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the start of this w l entry.
	*
	* @return the start of this w l entry
	*/
	public java.util.Date getStart() {
		return _wlEntry.getStart();
	}

	/**
	* Sets the start of this w l entry.
	*
	* @param start the start of this w l entry
	*/
	public void setStart(java.util.Date start) {
		_wlEntry.setStart(start);
	}

	/**
	* Returns the start time of this w l entry.
	*
	* @return the start time of this w l entry
	*/
	public long getStartTime() {
		return _wlEntry.getStartTime();
	}

	/**
	* Sets the start time of this w l entry.
	*
	* @param startTime the start time of this w l entry
	*/
	public void setStartTime(long startTime) {
		_wlEntry.setStartTime(startTime);
	}

	/**
	* Returns the finish time of this w l entry.
	*
	* @return the finish time of this w l entry
	*/
	public long getFinishTime() {
		return _wlEntry.getFinishTime();
	}

	/**
	* Sets the finish time of this w l entry.
	*
	* @param finishTime the finish time of this w l entry
	*/
	public void setFinishTime(long finishTime) {
		_wlEntry.setFinishTime(finishTime);
	}

	/**
	* Returns the entry date of this w l entry.
	*
	* @return the entry date of this w l entry
	*/
	public java.util.Date getEntryDate() {
		return _wlEntry.getEntryDate();
	}

	/**
	* Sets the entry date of this w l entry.
	*
	* @param entryDate the entry date of this w l entry
	*/
	public void setEntryDate(java.util.Date entryDate) {
		_wlEntry.setEntryDate(entryDate);
	}

	/**
	* Returns the entry time of this w l entry.
	*
	* @return the entry time of this w l entry
	*/
	public long getEntryTime() {
		return _wlEntry.getEntryTime();
	}

	/**
	* Sets the entry time of this w l entry.
	*
	* @param entryTime the entry time of this w l entry
	*/
	public void setEntryTime(long entryTime) {
		_wlEntry.setEntryTime(entryTime);
	}

	/**
	* Returns the timezone of this w l entry.
	*
	* @return the timezone of this w l entry
	*/
	public int getTimezone() {
		return _wlEntry.getTimezone();
	}

	/**
	* Sets the timezone of this w l entry.
	*
	* @param timezone the timezone of this w l entry
	*/
	public void setTimezone(int timezone) {
		_wlEntry.setTimezone(timezone);
	}

	/**
	* Returns the length of this w l entry.
	*
	* @return the length of this w l entry
	*/
	public long getLength() {
		return _wlEntry.getLength();
	}

	/**
	* Sets the length of this w l entry.
	*
	* @param length the length of this w l entry
	*/
	public void setLength(long length) {
		_wlEntry.setLength(length);
	}

	/**
	* Returns the task ID of this w l entry.
	*
	* @return the task ID of this w l entry
	*/
	public long getTaskId() {
		return _wlEntry.getTaskId();
	}

	/**
	* Sets the task ID of this w l entry.
	*
	* @param taskId the task ID of this w l entry
	*/
	public void setTaskId(long taskId) {
		_wlEntry.setTaskId(taskId);
	}

	public boolean isNew() {
		return _wlEntry.isNew();
	}

	public void setNew(boolean n) {
		_wlEntry.setNew(n);
	}

	public boolean isCachedModel() {
		return _wlEntry.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_wlEntry.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _wlEntry.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _wlEntry.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_wlEntry.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _wlEntry.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_wlEntry.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new WLEntryWrapper((WLEntry)_wlEntry.clone());
	}

	public int compareTo(com.jenginetest.builder.model.WLEntry wlEntry) {
		return _wlEntry.compareTo(wlEntry);
	}

	@Override
	public int hashCode() {
		return _wlEntry.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.jenginetest.builder.model.WLEntry> toCacheModel() {
		return _wlEntry.toCacheModel();
	}

	public com.jenginetest.builder.model.WLEntry toEscapedModel() {
		return new WLEntryWrapper(_wlEntry.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _wlEntry.toString();
	}

	public java.lang.String toXmlString() {
		return _wlEntry.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_wlEntry.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public WLEntry getWrappedWLEntry() {
		return _wlEntry;
	}

	public WLEntry getWrappedModel() {
		return _wlEntry;
	}

	public void resetOriginalValues() {
		_wlEntry.resetOriginalValues();
	}

	private WLEntry _wlEntry;
}