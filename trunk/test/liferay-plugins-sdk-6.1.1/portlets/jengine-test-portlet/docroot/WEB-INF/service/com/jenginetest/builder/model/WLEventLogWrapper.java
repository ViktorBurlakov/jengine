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
 * This class is a wrapper for {@link WLEventLog}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       WLEventLog
 * @generated
 */
public class WLEventLogWrapper implements WLEventLog, ModelWrapper<WLEventLog> {
	public WLEventLogWrapper(WLEventLog wlEventLog) {
		_wlEventLog = wlEventLog;
	}

	public Class<?> getModelClass() {
		return WLEventLog.class;
	}

	public String getModelClassName() {
		return WLEventLog.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("eventLogId", getEventLogId());
		attributes.put("userId", getUserId());
		attributes.put("logDate", getLogDate());
		attributes.put("event", getEvent());
		attributes.put("title", getTitle());
		attributes.put("modelName", getModelName());
		attributes.put("modelPK", getModelPK());
		attributes.put("description", getDescription());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long eventLogId = (Long)attributes.get("eventLogId");

		if (eventLogId != null) {
			setEventLogId(eventLogId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date logDate = (Date)attributes.get("logDate");

		if (logDate != null) {
			setLogDate(logDate);
		}

		String event = (String)attributes.get("event");

		if (event != null) {
			setEvent(event);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String modelName = (String)attributes.get("modelName");

		if (modelName != null) {
			setModelName(modelName);
		}

		Long modelPK = (Long)attributes.get("modelPK");

		if (modelPK != null) {
			setModelPK(modelPK);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	/**
	* Returns the primary key of this w l event log.
	*
	* @return the primary key of this w l event log
	*/
	public long getPrimaryKey() {
		return _wlEventLog.getPrimaryKey();
	}

	/**
	* Sets the primary key of this w l event log.
	*
	* @param primaryKey the primary key of this w l event log
	*/
	public void setPrimaryKey(long primaryKey) {
		_wlEventLog.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the group ID of this w l event log.
	*
	* @return the group ID of this w l event log
	*/
	public long getGroupId() {
		return _wlEventLog.getGroupId();
	}

	/**
	* Sets the group ID of this w l event log.
	*
	* @param groupId the group ID of this w l event log
	*/
	public void setGroupId(long groupId) {
		_wlEventLog.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this w l event log.
	*
	* @return the company ID of this w l event log
	*/
	public long getCompanyId() {
		return _wlEventLog.getCompanyId();
	}

	/**
	* Sets the company ID of this w l event log.
	*
	* @param companyId the company ID of this w l event log
	*/
	public void setCompanyId(long companyId) {
		_wlEventLog.setCompanyId(companyId);
	}

	/**
	* Returns the event log ID of this w l event log.
	*
	* @return the event log ID of this w l event log
	*/
	public long getEventLogId() {
		return _wlEventLog.getEventLogId();
	}

	/**
	* Sets the event log ID of this w l event log.
	*
	* @param eventLogId the event log ID of this w l event log
	*/
	public void setEventLogId(long eventLogId) {
		_wlEventLog.setEventLogId(eventLogId);
	}

	/**
	* Returns the user ID of this w l event log.
	*
	* @return the user ID of this w l event log
	*/
	public long getUserId() {
		return _wlEventLog.getUserId();
	}

	/**
	* Sets the user ID of this w l event log.
	*
	* @param userId the user ID of this w l event log
	*/
	public void setUserId(long userId) {
		_wlEventLog.setUserId(userId);
	}

	/**
	* Returns the user uuid of this w l event log.
	*
	* @return the user uuid of this w l event log
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wlEventLog.getUserUuid();
	}

	/**
	* Sets the user uuid of this w l event log.
	*
	* @param userUuid the user uuid of this w l event log
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_wlEventLog.setUserUuid(userUuid);
	}

	/**
	* Returns the log date of this w l event log.
	*
	* @return the log date of this w l event log
	*/
	public java.util.Date getLogDate() {
		return _wlEventLog.getLogDate();
	}

	/**
	* Sets the log date of this w l event log.
	*
	* @param logDate the log date of this w l event log
	*/
	public void setLogDate(java.util.Date logDate) {
		_wlEventLog.setLogDate(logDate);
	}

	/**
	* Returns the event of this w l event log.
	*
	* @return the event of this w l event log
	*/
	public java.lang.String getEvent() {
		return _wlEventLog.getEvent();
	}

	/**
	* Sets the event of this w l event log.
	*
	* @param event the event of this w l event log
	*/
	public void setEvent(java.lang.String event) {
		_wlEventLog.setEvent(event);
	}

	/**
	* Returns the title of this w l event log.
	*
	* @return the title of this w l event log
	*/
	public java.lang.String getTitle() {
		return _wlEventLog.getTitle();
	}

	/**
	* Sets the title of this w l event log.
	*
	* @param title the title of this w l event log
	*/
	public void setTitle(java.lang.String title) {
		_wlEventLog.setTitle(title);
	}

	/**
	* Returns the model name of this w l event log.
	*
	* @return the model name of this w l event log
	*/
	public java.lang.String getModelName() {
		return _wlEventLog.getModelName();
	}

	/**
	* Sets the model name of this w l event log.
	*
	* @param modelName the model name of this w l event log
	*/
	public void setModelName(java.lang.String modelName) {
		_wlEventLog.setModelName(modelName);
	}

	/**
	* Returns the model p k of this w l event log.
	*
	* @return the model p k of this w l event log
	*/
	public java.lang.Long getModelPK() {
		return _wlEventLog.getModelPK();
	}

	/**
	* Sets the model p k of this w l event log.
	*
	* @param modelPK the model p k of this w l event log
	*/
	public void setModelPK(java.lang.Long modelPK) {
		_wlEventLog.setModelPK(modelPK);
	}

	/**
	* Returns the description of this w l event log.
	*
	* @return the description of this w l event log
	*/
	public java.lang.String getDescription() {
		return _wlEventLog.getDescription();
	}

	/**
	* Sets the description of this w l event log.
	*
	* @param description the description of this w l event log
	*/
	public void setDescription(java.lang.String description) {
		_wlEventLog.setDescription(description);
	}

	public boolean isNew() {
		return _wlEventLog.isNew();
	}

	public void setNew(boolean n) {
		_wlEventLog.setNew(n);
	}

	public boolean isCachedModel() {
		return _wlEventLog.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_wlEventLog.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _wlEventLog.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _wlEventLog.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_wlEventLog.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _wlEventLog.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_wlEventLog.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new WLEventLogWrapper((WLEventLog)_wlEventLog.clone());
	}

	public int compareTo(com.jenginetest.builder.model.WLEventLog wlEventLog) {
		return _wlEventLog.compareTo(wlEventLog);
	}

	@Override
	public int hashCode() {
		return _wlEventLog.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.jenginetest.builder.model.WLEventLog> toCacheModel() {
		return _wlEventLog.toCacheModel();
	}

	public com.jenginetest.builder.model.WLEventLog toEscapedModel() {
		return new WLEventLogWrapper(_wlEventLog.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _wlEventLog.toString();
	}

	public java.lang.String toXmlString() {
		return _wlEventLog.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_wlEventLog.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public WLEventLog getWrappedWLEventLog() {
		return _wlEventLog;
	}

	public WLEventLog getWrappedModel() {
		return _wlEventLog;
	}

	public void resetOriginalValues() {
		_wlEventLog.resetOriginalValues();
	}

	private WLEventLog _wlEventLog;
}