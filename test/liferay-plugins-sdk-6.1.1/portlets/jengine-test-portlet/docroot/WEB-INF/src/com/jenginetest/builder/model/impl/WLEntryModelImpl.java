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
import com.jenginetest.builder.model.WLEntryModel;
import com.jenginetest.builder.model.WLEntrySoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the WLEntry service. Represents a row in the &quot;WL_WLEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.jenginetest.builder.model.WLEntryModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link WLEntryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WLEntryImpl
 * @see com.jenginetest.builder.model.WLEntry
 * @see com.jenginetest.builder.model.WLEntryModel
 * @generated
 */
@JSON(strict = true)
public class WLEntryModelImpl extends BaseModelImpl<WLEntry>
	implements WLEntryModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a w l entry model instance should use the {@link com.jenginetest.builder.model.WLEntry} interface instead.
	 */
	public static final String TABLE_NAME = "WL_WLEntry";
	public static final Object[][] TABLE_COLUMNS = {
			{ "entryId", Types.BIGINT },
			{ "createUserId", Types.BIGINT },
			{ "createUserName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedUserId", Types.BIGINT },
			{ "modifiedUserName", Types.VARCHAR },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "start_", Types.TIMESTAMP },
			{ "startTime", Types.BIGINT },
			{ "finishTime", Types.BIGINT },
			{ "entryDate", Types.TIMESTAMP },
			{ "entryTime", Types.BIGINT },
			{ "timezone", Types.INTEGER },
			{ "length", Types.BIGINT },
			{ "taskId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table WL_WLEntry (entryId LONG not null primary key,createUserId LONG,createUserName VARCHAR(75) null,createDate DATE null,modifiedUserId LONG,modifiedUserName VARCHAR(75) null,modifiedDate DATE null,start_ DATE null,startTime LONG,finishTime LONG,entryDate DATE null,entryTime LONG,timezone INTEGER,length LONG,taskId LONG)";
	public static final String TABLE_SQL_DROP = "drop table WL_WLEntry";
	public static final String ORDER_BY_JPQL = " ORDER BY wlEntry.entryId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY WL_WLEntry.entryId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.jenginetest.builder.model.WLEntry"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.jenginetest.builder.model.WLEntry"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.jenginetest.builder.model.WLEntry"),
			true);
	public static long ENTRYDATE_COLUMN_BITMASK = 1L;
	public static long TASKID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static WLEntry toModel(WLEntrySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		WLEntry model = new WLEntryImpl();

		model.setEntryId(soapModel.getEntryId());
		model.setCreateUserId(soapModel.getCreateUserId());
		model.setCreateUserName(soapModel.getCreateUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedUserId(soapModel.getModifiedUserId());
		model.setModifiedUserName(soapModel.getModifiedUserName());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setStart(soapModel.getStart());
		model.setStartTime(soapModel.getStartTime());
		model.setFinishTime(soapModel.getFinishTime());
		model.setEntryDate(soapModel.getEntryDate());
		model.setEntryTime(soapModel.getEntryTime());
		model.setTimezone(soapModel.getTimezone());
		model.setLength(soapModel.getLength());
		model.setTaskId(soapModel.getTaskId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<WLEntry> toModels(WLEntrySoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<WLEntry> models = new ArrayList<WLEntry>(soapModels.length);

		for (WLEntrySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.jenginetest.builder.model.WLEntry"));

	public WLEntryModelImpl() {
	}

	public long getPrimaryKey() {
		return _entryId;
	}

	public void setPrimaryKey(long primaryKey) {
		setEntryId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_entryId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return WLEntry.class;
	}

	public String getModelClassName() {
		return WLEntry.class.getName();
	}

	@Override
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

	@Override
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

	@JSON
	public long getEntryId() {
		return _entryId;
	}

	public void setEntryId(long entryId) {
		_columnBitmask = -1L;

		_entryId = entryId;
	}

	@JSON
	public long getCreateUserId() {
		return _createUserId;
	}

	public void setCreateUserId(long createUserId) {
		_createUserId = createUserId;
	}

	public String getCreateUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getCreateUserId(), "uuid",
			_createUserUuid);
	}

	public void setCreateUserUuid(String createUserUuid) {
		_createUserUuid = createUserUuid;
	}

	@JSON
	public String getCreateUserName() {
		if (_createUserName == null) {
			return StringPool.BLANK;
		}
		else {
			return _createUserName;
		}
	}

	public void setCreateUserName(String createUserName) {
		_createUserName = createUserName;
	}

	@JSON
	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	public long getModifiedUserId() {
		return _modifiedUserId;
	}

	public void setModifiedUserId(long modifiedUserId) {
		_modifiedUserId = modifiedUserId;
	}

	public String getModifiedUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getModifiedUserId(), "uuid",
			_modifiedUserUuid);
	}

	public void setModifiedUserUuid(String modifiedUserUuid) {
		_modifiedUserUuid = modifiedUserUuid;
	}

	@JSON
	public String getModifiedUserName() {
		if (_modifiedUserName == null) {
			return StringPool.BLANK;
		}
		else {
			return _modifiedUserName;
		}
	}

	public void setModifiedUserName(String modifiedUserName) {
		_modifiedUserName = modifiedUserName;
	}

	@JSON
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	public Date getStart() {
		return _start;
	}

	public void setStart(Date start) {
		_start = start;
	}

	@JSON
	public long getStartTime() {
		return _startTime;
	}

	public void setStartTime(long startTime) {
		_startTime = startTime;
	}

	@JSON
	public long getFinishTime() {
		return _finishTime;
	}

	public void setFinishTime(long finishTime) {
		_finishTime = finishTime;
	}

	@JSON
	public Date getEntryDate() {
		return _entryDate;
	}

	public void setEntryDate(Date entryDate) {
		_columnBitmask |= ENTRYDATE_COLUMN_BITMASK;

		if (_originalEntryDate == null) {
			_originalEntryDate = _entryDate;
		}

		_entryDate = entryDate;
	}

	public Date getOriginalEntryDate() {
		return _originalEntryDate;
	}

	@JSON
	public long getEntryTime() {
		return _entryTime;
	}

	public void setEntryTime(long entryTime) {
		_entryTime = entryTime;
	}

	@JSON
	public int getTimezone() {
		return _timezone;
	}

	public void setTimezone(int timezone) {
		_timezone = timezone;
	}

	@JSON
	public long getLength() {
		return _length;
	}

	public void setLength(long length) {
		_length = length;
	}

	@JSON
	public long getTaskId() {
		return _taskId;
	}

	public void setTaskId(long taskId) {
		_columnBitmask |= TASKID_COLUMN_BITMASK;

		if (!_setOriginalTaskId) {
			_setOriginalTaskId = true;

			_originalTaskId = _taskId;
		}

		_taskId = taskId;
	}

	public long getOriginalTaskId() {
		return _originalTaskId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			WLEntry.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public WLEntry toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (WLEntry)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		WLEntryImpl wlEntryImpl = new WLEntryImpl();

		wlEntryImpl.setEntryId(getEntryId());
		wlEntryImpl.setCreateUserId(getCreateUserId());
		wlEntryImpl.setCreateUserName(getCreateUserName());
		wlEntryImpl.setCreateDate(getCreateDate());
		wlEntryImpl.setModifiedUserId(getModifiedUserId());
		wlEntryImpl.setModifiedUserName(getModifiedUserName());
		wlEntryImpl.setModifiedDate(getModifiedDate());
		wlEntryImpl.setStart(getStart());
		wlEntryImpl.setStartTime(getStartTime());
		wlEntryImpl.setFinishTime(getFinishTime());
		wlEntryImpl.setEntryDate(getEntryDate());
		wlEntryImpl.setEntryTime(getEntryTime());
		wlEntryImpl.setTimezone(getTimezone());
		wlEntryImpl.setLength(getLength());
		wlEntryImpl.setTaskId(getTaskId());

		wlEntryImpl.resetOriginalValues();

		return wlEntryImpl;
	}

	public int compareTo(WLEntry wlEntry) {
		int value = 0;

		if (getEntryId() < wlEntry.getEntryId()) {
			value = -1;
		}
		else if (getEntryId() > wlEntry.getEntryId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		WLEntry wlEntry = null;

		try {
			wlEntry = (WLEntry)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = wlEntry.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		WLEntryModelImpl wlEntryModelImpl = this;

		wlEntryModelImpl._originalEntryDate = wlEntryModelImpl._entryDate;

		wlEntryModelImpl._originalTaskId = wlEntryModelImpl._taskId;

		wlEntryModelImpl._setOriginalTaskId = false;

		wlEntryModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<WLEntry> toCacheModel() {
		WLEntryCacheModel wlEntryCacheModel = new WLEntryCacheModel();

		wlEntryCacheModel.entryId = getEntryId();

		wlEntryCacheModel.createUserId = getCreateUserId();

		wlEntryCacheModel.createUserName = getCreateUserName();

		String createUserName = wlEntryCacheModel.createUserName;

		if ((createUserName != null) && (createUserName.length() == 0)) {
			wlEntryCacheModel.createUserName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			wlEntryCacheModel.createDate = createDate.getTime();
		}
		else {
			wlEntryCacheModel.createDate = Long.MIN_VALUE;
		}

		wlEntryCacheModel.modifiedUserId = getModifiedUserId();

		wlEntryCacheModel.modifiedUserName = getModifiedUserName();

		String modifiedUserName = wlEntryCacheModel.modifiedUserName;

		if ((modifiedUserName != null) && (modifiedUserName.length() == 0)) {
			wlEntryCacheModel.modifiedUserName = null;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			wlEntryCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			wlEntryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		Date start = getStart();

		if (start != null) {
			wlEntryCacheModel.start = start.getTime();
		}
		else {
			wlEntryCacheModel.start = Long.MIN_VALUE;
		}

		wlEntryCacheModel.startTime = getStartTime();

		wlEntryCacheModel.finishTime = getFinishTime();

		Date entryDate = getEntryDate();

		if (entryDate != null) {
			wlEntryCacheModel.entryDate = entryDate.getTime();
		}
		else {
			wlEntryCacheModel.entryDate = Long.MIN_VALUE;
		}

		wlEntryCacheModel.entryTime = getEntryTime();

		wlEntryCacheModel.timezone = getTimezone();

		wlEntryCacheModel.length = getLength();

		wlEntryCacheModel.taskId = getTaskId();

		return wlEntryCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{entryId=");
		sb.append(getEntryId());
		sb.append(", createUserId=");
		sb.append(getCreateUserId());
		sb.append(", createUserName=");
		sb.append(getCreateUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedUserId=");
		sb.append(getModifiedUserId());
		sb.append(", modifiedUserName=");
		sb.append(getModifiedUserName());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", start=");
		sb.append(getStart());
		sb.append(", startTime=");
		sb.append(getStartTime());
		sb.append(", finishTime=");
		sb.append(getFinishTime());
		sb.append(", entryDate=");
		sb.append(getEntryDate());
		sb.append(", entryTime=");
		sb.append(getEntryTime());
		sb.append(", timezone=");
		sb.append(getTimezone());
		sb.append(", length=");
		sb.append(getLength());
		sb.append(", taskId=");
		sb.append(getTaskId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(49);

		sb.append("<model><model-name>");
		sb.append("com.jenginetest.builder.model.WLEntry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>entryId</column-name><column-value><![CDATA[");
		sb.append(getEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createUserId</column-name><column-value><![CDATA[");
		sb.append(getCreateUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createUserName</column-name><column-value><![CDATA[");
		sb.append(getCreateUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedUserId</column-name><column-value><![CDATA[");
		sb.append(getModifiedUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedUserName</column-name><column-value><![CDATA[");
		sb.append(getModifiedUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>start</column-name><column-value><![CDATA[");
		sb.append(getStart());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startTime</column-name><column-value><![CDATA[");
		sb.append(getStartTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>finishTime</column-name><column-value><![CDATA[");
		sb.append(getFinishTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>entryDate</column-name><column-value><![CDATA[");
		sb.append(getEntryDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>entryTime</column-name><column-value><![CDATA[");
		sb.append(getEntryTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>timezone</column-name><column-value><![CDATA[");
		sb.append(getTimezone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>length</column-name><column-value><![CDATA[");
		sb.append(getLength());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>taskId</column-name><column-value><![CDATA[");
		sb.append(getTaskId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = WLEntry.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			WLEntry.class
		};
	private long _entryId;
	private long _createUserId;
	private String _createUserUuid;
	private String _createUserName;
	private Date _createDate;
	private long _modifiedUserId;
	private String _modifiedUserUuid;
	private String _modifiedUserName;
	private Date _modifiedDate;
	private Date _start;
	private long _startTime;
	private long _finishTime;
	private Date _entryDate;
	private Date _originalEntryDate;
	private long _entryTime;
	private int _timezone;
	private long _length;
	private long _taskId;
	private long _originalTaskId;
	private boolean _setOriginalTaskId;
	private long _columnBitmask;
	private WLEntry _escapedModelProxy;
}