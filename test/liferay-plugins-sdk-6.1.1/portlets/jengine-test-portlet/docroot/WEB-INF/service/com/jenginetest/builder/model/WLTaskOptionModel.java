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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the WLTaskOption service. Represents a row in the &quot;WL_WLTaskOption&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.jenginetest.builder.model.impl.WLTaskOptionModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.jenginetest.builder.model.impl.WLTaskOptionImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WLTaskOption
 * @see com.jenginetest.builder.model.impl.WLTaskOptionImpl
 * @see com.jenginetest.builder.model.impl.WLTaskOptionModelImpl
 * @generated
 */
public interface WLTaskOptionModel extends BaseModel<WLTaskOption> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a w l task option model instance should use the {@link WLTaskOption} interface instead.
	 */

	/**
	 * Returns the primary key of this w l task option.
	 *
	 * @return the primary key of this w l task option
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this w l task option.
	 *
	 * @param primaryKey the primary key of this w l task option
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the option ID of this w l task option.
	 *
	 * @return the option ID of this w l task option
	 */
	public long getOptionId();

	/**
	 * Sets the option ID of this w l task option.
	 *
	 * @param optionId the option ID of this w l task option
	 */
	public void setOptionId(long optionId);

	/**
	 * Returns the group ID of this w l task option.
	 *
	 * @return the group ID of this w l task option
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this w l task option.
	 *
	 * @param groupId the group ID of this w l task option
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this w l task option.
	 *
	 * @return the company ID of this w l task option
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this w l task option.
	 *
	 * @param companyId the company ID of this w l task option
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the create user ID of this w l task option.
	 *
	 * @return the create user ID of this w l task option
	 */
	public long getCreateUserId();

	/**
	 * Sets the create user ID of this w l task option.
	 *
	 * @param createUserId the create user ID of this w l task option
	 */
	public void setCreateUserId(long createUserId);

	/**
	 * Returns the create user uuid of this w l task option.
	 *
	 * @return the create user uuid of this w l task option
	 * @throws SystemException if a system exception occurred
	 */
	public String getCreateUserUuid() throws SystemException;

	/**
	 * Sets the create user uuid of this w l task option.
	 *
	 * @param createUserUuid the create user uuid of this w l task option
	 */
	public void setCreateUserUuid(String createUserUuid);

	/**
	 * Returns the create user name of this w l task option.
	 *
	 * @return the create user name of this w l task option
	 */
	@AutoEscape
	public String getCreateUserName();

	/**
	 * Sets the create user name of this w l task option.
	 *
	 * @param createUserName the create user name of this w l task option
	 */
	public void setCreateUserName(String createUserName);

	/**
	 * Returns the create date of this w l task option.
	 *
	 * @return the create date of this w l task option
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this w l task option.
	 *
	 * @param createDate the create date of this w l task option
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified user ID of this w l task option.
	 *
	 * @return the modified user ID of this w l task option
	 */
	public long getModifiedUserId();

	/**
	 * Sets the modified user ID of this w l task option.
	 *
	 * @param modifiedUserId the modified user ID of this w l task option
	 */
	public void setModifiedUserId(long modifiedUserId);

	/**
	 * Returns the modified user uuid of this w l task option.
	 *
	 * @return the modified user uuid of this w l task option
	 * @throws SystemException if a system exception occurred
	 */
	public String getModifiedUserUuid() throws SystemException;

	/**
	 * Sets the modified user uuid of this w l task option.
	 *
	 * @param modifiedUserUuid the modified user uuid of this w l task option
	 */
	public void setModifiedUserUuid(String modifiedUserUuid);

	/**
	 * Returns the modified user name of this w l task option.
	 *
	 * @return the modified user name of this w l task option
	 */
	@AutoEscape
	public String getModifiedUserName();

	/**
	 * Sets the modified user name of this w l task option.
	 *
	 * @param modifiedUserName the modified user name of this w l task option
	 */
	public void setModifiedUserName(String modifiedUserName);

	/**
	 * Returns the modified date of this w l task option.
	 *
	 * @return the modified date of this w l task option
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this w l task option.
	 *
	 * @param modifiedDate the modified date of this w l task option
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the task ID of this w l task option.
	 *
	 * @return the task ID of this w l task option
	 */
	public long getTaskId();

	/**
	 * Sets the task ID of this w l task option.
	 *
	 * @param taskId the task ID of this w l task option
	 */
	public void setTaskId(long taskId);

	/**
	 * Returns the name of this w l task option.
	 *
	 * @return the name of this w l task option
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this w l task option.
	 *
	 * @param name the name of this w l task option
	 */
	public void setName(String name);

	/**
	 * Returns the data of this w l task option.
	 *
	 * @return the data of this w l task option
	 */
	@AutoEscape
	public String getData();

	/**
	 * Sets the data of this w l task option.
	 *
	 * @param data the data of this w l task option
	 */
	public void setData(String data);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(WLTaskOption wlTaskOption);

	public int hashCode();

	public CacheModel<WLTaskOption> toCacheModel();

	public WLTaskOption toEscapedModel();

	public String toString();

	public String toXmlString();
}