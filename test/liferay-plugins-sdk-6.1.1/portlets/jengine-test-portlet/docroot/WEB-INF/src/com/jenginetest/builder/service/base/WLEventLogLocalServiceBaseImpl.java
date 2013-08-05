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

package com.jenginetest.builder.service.base;

import com.jenginetest.builder.model.WLEventLog;
import com.jenginetest.builder.service.LoggingActivityLocalService;
import com.jenginetest.builder.service.LoggingActivityService;
import com.jenginetest.builder.service.WLEntryLocalService;
import com.jenginetest.builder.service.WLEntryService;
import com.jenginetest.builder.service.WLEventLogLocalService;
import com.jenginetest.builder.service.WLEventLogService;
import com.jenginetest.builder.service.WLProjectLocalService;
import com.jenginetest.builder.service.WLProjectService;
import com.jenginetest.builder.service.WLProjectUserLocalService;
import com.jenginetest.builder.service.WLProjectUserRoleLocalService;
import com.jenginetest.builder.service.WLProjectUserRoleService;
import com.jenginetest.builder.service.WLProjectUserService;
import com.jenginetest.builder.service.WLTaskLocalService;
import com.jenginetest.builder.service.WLTaskOptionLocalService;
import com.jenginetest.builder.service.WLTaskOptionService;
import com.jenginetest.builder.service.WLTaskService;
import com.jenginetest.builder.service.persistence.WLEntryPersistence;
import com.jenginetest.builder.service.persistence.WLEventLogPersistence;
import com.jenginetest.builder.service.persistence.WLProjectPersistence;
import com.jenginetest.builder.service.persistence.WLProjectUserPersistence;
import com.jenginetest.builder.service.persistence.WLProjectUserRolePersistence;
import com.jenginetest.builder.service.persistence.WLTaskOptionPersistence;
import com.jenginetest.builder.service.persistence.WLTaskPersistence;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the w l event log local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.jenginetest.builder.service.impl.WLEventLogLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.jenginetest.builder.service.impl.WLEventLogLocalServiceImpl
 * @see com.jenginetest.builder.service.WLEventLogLocalServiceUtil
 * @generated
 */
public abstract class WLEventLogLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements WLEventLogLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.jenginetest.builder.service.WLEventLogLocalServiceUtil} to access the w l event log local service.
	 */

	/**
	 * Adds the w l event log to the database. Also notifies the appropriate model listeners.
	 *
	 * @param wlEventLog the w l event log
	 * @return the w l event log that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public WLEventLog addWLEventLog(WLEventLog wlEventLog)
		throws SystemException {
		wlEventLog.setNew(true);

		return wlEventLogPersistence.update(wlEventLog, false);
	}

	/**
	 * Creates a new w l event log with the primary key. Does not add the w l event log to the database.
	 *
	 * @param eventLogId the primary key for the new w l event log
	 * @return the new w l event log
	 */
	public WLEventLog createWLEventLog(long eventLogId) {
		return wlEventLogPersistence.create(eventLogId);
	}

	/**
	 * Deletes the w l event log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventLogId the primary key of the w l event log
	 * @return the w l event log that was removed
	 * @throws PortalException if a w l event log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public WLEventLog deleteWLEventLog(long eventLogId)
		throws PortalException, SystemException {
		return wlEventLogPersistence.remove(eventLogId);
	}

	/**
	 * Deletes the w l event log from the database. Also notifies the appropriate model listeners.
	 *
	 * @param wlEventLog the w l event log
	 * @return the w l event log that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public WLEventLog deleteWLEventLog(WLEventLog wlEventLog)
		throws SystemException {
		return wlEventLogPersistence.remove(wlEventLog);
	}

	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(WLEventLog.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return wlEventLogPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return wlEventLogPersistence.findWithDynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return wlEventLogPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return wlEventLogPersistence.countWithDynamicQuery(dynamicQuery);
	}

	public WLEventLog fetchWLEventLog(long eventLogId)
		throws SystemException {
		return wlEventLogPersistence.fetchByPrimaryKey(eventLogId);
	}

	/**
	 * Returns the w l event log with the primary key.
	 *
	 * @param eventLogId the primary key of the w l event log
	 * @return the w l event log
	 * @throws PortalException if a w l event log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WLEventLog getWLEventLog(long eventLogId)
		throws PortalException, SystemException {
		return wlEventLogPersistence.findByPrimaryKey(eventLogId);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return wlEventLogPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the w l event logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of w l event logs
	 * @param end the upper bound of the range of w l event logs (not inclusive)
	 * @return the range of w l event logs
	 * @throws SystemException if a system exception occurred
	 */
	public List<WLEventLog> getWLEventLogs(int start, int end)
		throws SystemException {
		return wlEventLogPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of w l event logs.
	 *
	 * @return the number of w l event logs
	 * @throws SystemException if a system exception occurred
	 */
	public int getWLEventLogsCount() throws SystemException {
		return wlEventLogPersistence.countAll();
	}

	/**
	 * Updates the w l event log in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param wlEventLog the w l event log
	 * @return the w l event log that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public WLEventLog updateWLEventLog(WLEventLog wlEventLog)
		throws SystemException {
		return updateWLEventLog(wlEventLog, true);
	}

	/**
	 * Updates the w l event log in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param wlEventLog the w l event log
	 * @param merge whether to merge the w l event log with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the w l event log that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public WLEventLog updateWLEventLog(WLEventLog wlEventLog, boolean merge)
		throws SystemException {
		wlEventLog.setNew(false);

		return wlEventLogPersistence.update(wlEventLog, merge);
	}

	/**
	 * Returns the logging activity local service.
	 *
	 * @return the logging activity local service
	 */
	public LoggingActivityLocalService getLoggingActivityLocalService() {
		return loggingActivityLocalService;
	}

	/**
	 * Sets the logging activity local service.
	 *
	 * @param loggingActivityLocalService the logging activity local service
	 */
	public void setLoggingActivityLocalService(
		LoggingActivityLocalService loggingActivityLocalService) {
		this.loggingActivityLocalService = loggingActivityLocalService;
	}

	/**
	 * Returns the logging activity remote service.
	 *
	 * @return the logging activity remote service
	 */
	public LoggingActivityService getLoggingActivityService() {
		return loggingActivityService;
	}

	/**
	 * Sets the logging activity remote service.
	 *
	 * @param loggingActivityService the logging activity remote service
	 */
	public void setLoggingActivityService(
		LoggingActivityService loggingActivityService) {
		this.loggingActivityService = loggingActivityService;
	}

	/**
	 * Returns the w l entry local service.
	 *
	 * @return the w l entry local service
	 */
	public WLEntryLocalService getWLEntryLocalService() {
		return wlEntryLocalService;
	}

	/**
	 * Sets the w l entry local service.
	 *
	 * @param wlEntryLocalService the w l entry local service
	 */
	public void setWLEntryLocalService(WLEntryLocalService wlEntryLocalService) {
		this.wlEntryLocalService = wlEntryLocalService;
	}

	/**
	 * Returns the w l entry remote service.
	 *
	 * @return the w l entry remote service
	 */
	public WLEntryService getWLEntryService() {
		return wlEntryService;
	}

	/**
	 * Sets the w l entry remote service.
	 *
	 * @param wlEntryService the w l entry remote service
	 */
	public void setWLEntryService(WLEntryService wlEntryService) {
		this.wlEntryService = wlEntryService;
	}

	/**
	 * Returns the w l entry persistence.
	 *
	 * @return the w l entry persistence
	 */
	public WLEntryPersistence getWLEntryPersistence() {
		return wlEntryPersistence;
	}

	/**
	 * Sets the w l entry persistence.
	 *
	 * @param wlEntryPersistence the w l entry persistence
	 */
	public void setWLEntryPersistence(WLEntryPersistence wlEntryPersistence) {
		this.wlEntryPersistence = wlEntryPersistence;
	}

	/**
	 * Returns the w l event log local service.
	 *
	 * @return the w l event log local service
	 */
	public WLEventLogLocalService getWLEventLogLocalService() {
		return wlEventLogLocalService;
	}

	/**
	 * Sets the w l event log local service.
	 *
	 * @param wlEventLogLocalService the w l event log local service
	 */
	public void setWLEventLogLocalService(
		WLEventLogLocalService wlEventLogLocalService) {
		this.wlEventLogLocalService = wlEventLogLocalService;
	}

	/**
	 * Returns the w l event log remote service.
	 *
	 * @return the w l event log remote service
	 */
	public WLEventLogService getWLEventLogService() {
		return wlEventLogService;
	}

	/**
	 * Sets the w l event log remote service.
	 *
	 * @param wlEventLogService the w l event log remote service
	 */
	public void setWLEventLogService(WLEventLogService wlEventLogService) {
		this.wlEventLogService = wlEventLogService;
	}

	/**
	 * Returns the w l event log persistence.
	 *
	 * @return the w l event log persistence
	 */
	public WLEventLogPersistence getWLEventLogPersistence() {
		return wlEventLogPersistence;
	}

	/**
	 * Sets the w l event log persistence.
	 *
	 * @param wlEventLogPersistence the w l event log persistence
	 */
	public void setWLEventLogPersistence(
		WLEventLogPersistence wlEventLogPersistence) {
		this.wlEventLogPersistence = wlEventLogPersistence;
	}

	/**
	 * Returns the w l project local service.
	 *
	 * @return the w l project local service
	 */
	public WLProjectLocalService getWLProjectLocalService() {
		return wlProjectLocalService;
	}

	/**
	 * Sets the w l project local service.
	 *
	 * @param wlProjectLocalService the w l project local service
	 */
	public void setWLProjectLocalService(
		WLProjectLocalService wlProjectLocalService) {
		this.wlProjectLocalService = wlProjectLocalService;
	}

	/**
	 * Returns the w l project remote service.
	 *
	 * @return the w l project remote service
	 */
	public WLProjectService getWLProjectService() {
		return wlProjectService;
	}

	/**
	 * Sets the w l project remote service.
	 *
	 * @param wlProjectService the w l project remote service
	 */
	public void setWLProjectService(WLProjectService wlProjectService) {
		this.wlProjectService = wlProjectService;
	}

	/**
	 * Returns the w l project persistence.
	 *
	 * @return the w l project persistence
	 */
	public WLProjectPersistence getWLProjectPersistence() {
		return wlProjectPersistence;
	}

	/**
	 * Sets the w l project persistence.
	 *
	 * @param wlProjectPersistence the w l project persistence
	 */
	public void setWLProjectPersistence(
		WLProjectPersistence wlProjectPersistence) {
		this.wlProjectPersistence = wlProjectPersistence;
	}

	/**
	 * Returns the w l project user local service.
	 *
	 * @return the w l project user local service
	 */
	public WLProjectUserLocalService getWLProjectUserLocalService() {
		return wlProjectUserLocalService;
	}

	/**
	 * Sets the w l project user local service.
	 *
	 * @param wlProjectUserLocalService the w l project user local service
	 */
	public void setWLProjectUserLocalService(
		WLProjectUserLocalService wlProjectUserLocalService) {
		this.wlProjectUserLocalService = wlProjectUserLocalService;
	}

	/**
	 * Returns the w l project user remote service.
	 *
	 * @return the w l project user remote service
	 */
	public WLProjectUserService getWLProjectUserService() {
		return wlProjectUserService;
	}

	/**
	 * Sets the w l project user remote service.
	 *
	 * @param wlProjectUserService the w l project user remote service
	 */
	public void setWLProjectUserService(
		WLProjectUserService wlProjectUserService) {
		this.wlProjectUserService = wlProjectUserService;
	}

	/**
	 * Returns the w l project user persistence.
	 *
	 * @return the w l project user persistence
	 */
	public WLProjectUserPersistence getWLProjectUserPersistence() {
		return wlProjectUserPersistence;
	}

	/**
	 * Sets the w l project user persistence.
	 *
	 * @param wlProjectUserPersistence the w l project user persistence
	 */
	public void setWLProjectUserPersistence(
		WLProjectUserPersistence wlProjectUserPersistence) {
		this.wlProjectUserPersistence = wlProjectUserPersistence;
	}

	/**
	 * Returns the w l project user role local service.
	 *
	 * @return the w l project user role local service
	 */
	public WLProjectUserRoleLocalService getWLProjectUserRoleLocalService() {
		return wlProjectUserRoleLocalService;
	}

	/**
	 * Sets the w l project user role local service.
	 *
	 * @param wlProjectUserRoleLocalService the w l project user role local service
	 */
	public void setWLProjectUserRoleLocalService(
		WLProjectUserRoleLocalService wlProjectUserRoleLocalService) {
		this.wlProjectUserRoleLocalService = wlProjectUserRoleLocalService;
	}

	/**
	 * Returns the w l project user role remote service.
	 *
	 * @return the w l project user role remote service
	 */
	public WLProjectUserRoleService getWLProjectUserRoleService() {
		return wlProjectUserRoleService;
	}

	/**
	 * Sets the w l project user role remote service.
	 *
	 * @param wlProjectUserRoleService the w l project user role remote service
	 */
	public void setWLProjectUserRoleService(
		WLProjectUserRoleService wlProjectUserRoleService) {
		this.wlProjectUserRoleService = wlProjectUserRoleService;
	}

	/**
	 * Returns the w l project user role persistence.
	 *
	 * @return the w l project user role persistence
	 */
	public WLProjectUserRolePersistence getWLProjectUserRolePersistence() {
		return wlProjectUserRolePersistence;
	}

	/**
	 * Sets the w l project user role persistence.
	 *
	 * @param wlProjectUserRolePersistence the w l project user role persistence
	 */
	public void setWLProjectUserRolePersistence(
		WLProjectUserRolePersistence wlProjectUserRolePersistence) {
		this.wlProjectUserRolePersistence = wlProjectUserRolePersistence;
	}

	/**
	 * Returns the w l task local service.
	 *
	 * @return the w l task local service
	 */
	public WLTaskLocalService getWLTaskLocalService() {
		return wlTaskLocalService;
	}

	/**
	 * Sets the w l task local service.
	 *
	 * @param wlTaskLocalService the w l task local service
	 */
	public void setWLTaskLocalService(WLTaskLocalService wlTaskLocalService) {
		this.wlTaskLocalService = wlTaskLocalService;
	}

	/**
	 * Returns the w l task remote service.
	 *
	 * @return the w l task remote service
	 */
	public WLTaskService getWLTaskService() {
		return wlTaskService;
	}

	/**
	 * Sets the w l task remote service.
	 *
	 * @param wlTaskService the w l task remote service
	 */
	public void setWLTaskService(WLTaskService wlTaskService) {
		this.wlTaskService = wlTaskService;
	}

	/**
	 * Returns the w l task persistence.
	 *
	 * @return the w l task persistence
	 */
	public WLTaskPersistence getWLTaskPersistence() {
		return wlTaskPersistence;
	}

	/**
	 * Sets the w l task persistence.
	 *
	 * @param wlTaskPersistence the w l task persistence
	 */
	public void setWLTaskPersistence(WLTaskPersistence wlTaskPersistence) {
		this.wlTaskPersistence = wlTaskPersistence;
	}

	/**
	 * Returns the w l task option local service.
	 *
	 * @return the w l task option local service
	 */
	public WLTaskOptionLocalService getWLTaskOptionLocalService() {
		return wlTaskOptionLocalService;
	}

	/**
	 * Sets the w l task option local service.
	 *
	 * @param wlTaskOptionLocalService the w l task option local service
	 */
	public void setWLTaskOptionLocalService(
		WLTaskOptionLocalService wlTaskOptionLocalService) {
		this.wlTaskOptionLocalService = wlTaskOptionLocalService;
	}

	/**
	 * Returns the w l task option remote service.
	 *
	 * @return the w l task option remote service
	 */
	public WLTaskOptionService getWLTaskOptionService() {
		return wlTaskOptionService;
	}

	/**
	 * Sets the w l task option remote service.
	 *
	 * @param wlTaskOptionService the w l task option remote service
	 */
	public void setWLTaskOptionService(WLTaskOptionService wlTaskOptionService) {
		this.wlTaskOptionService = wlTaskOptionService;
	}

	/**
	 * Returns the w l task option persistence.
	 *
	 * @return the w l task option persistence
	 */
	public WLTaskOptionPersistence getWLTaskOptionPersistence() {
		return wlTaskOptionPersistence;
	}

	/**
	 * Sets the w l task option persistence.
	 *
	 * @param wlTaskOptionPersistence the w l task option persistence
	 */
	public void setWLTaskOptionPersistence(
		WLTaskOptionPersistence wlTaskOptionPersistence) {
		this.wlTaskOptionPersistence = wlTaskOptionPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Returns the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		PersistedModelLocalServiceRegistryUtil.register("com.jenginetest.builder.model.WLEventLog",
			wlEventLogLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.jenginetest.builder.model.WLEventLog");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
	}

	protected Class<?> getModelClass() {
		return WLEventLog.class;
	}

	protected String getModelClassName() {
		return WLEventLog.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = wlEventLogPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = LoggingActivityLocalService.class)
	protected LoggingActivityLocalService loggingActivityLocalService;
	@BeanReference(type = LoggingActivityService.class)
	protected LoggingActivityService loggingActivityService;
	@BeanReference(type = WLEntryLocalService.class)
	protected WLEntryLocalService wlEntryLocalService;
	@BeanReference(type = WLEntryService.class)
	protected WLEntryService wlEntryService;
	@BeanReference(type = WLEntryPersistence.class)
	protected WLEntryPersistence wlEntryPersistence;
	@BeanReference(type = WLEventLogLocalService.class)
	protected WLEventLogLocalService wlEventLogLocalService;
	@BeanReference(type = WLEventLogService.class)
	protected WLEventLogService wlEventLogService;
	@BeanReference(type = WLEventLogPersistence.class)
	protected WLEventLogPersistence wlEventLogPersistence;
	@BeanReference(type = WLProjectLocalService.class)
	protected WLProjectLocalService wlProjectLocalService;
	@BeanReference(type = WLProjectService.class)
	protected WLProjectService wlProjectService;
	@BeanReference(type = WLProjectPersistence.class)
	protected WLProjectPersistence wlProjectPersistence;
	@BeanReference(type = WLProjectUserLocalService.class)
	protected WLProjectUserLocalService wlProjectUserLocalService;
	@BeanReference(type = WLProjectUserService.class)
	protected WLProjectUserService wlProjectUserService;
	@BeanReference(type = WLProjectUserPersistence.class)
	protected WLProjectUserPersistence wlProjectUserPersistence;
	@BeanReference(type = WLProjectUserRoleLocalService.class)
	protected WLProjectUserRoleLocalService wlProjectUserRoleLocalService;
	@BeanReference(type = WLProjectUserRoleService.class)
	protected WLProjectUserRoleService wlProjectUserRoleService;
	@BeanReference(type = WLProjectUserRolePersistence.class)
	protected WLProjectUserRolePersistence wlProjectUserRolePersistence;
	@BeanReference(type = WLTaskLocalService.class)
	protected WLTaskLocalService wlTaskLocalService;
	@BeanReference(type = WLTaskService.class)
	protected WLTaskService wlTaskService;
	@BeanReference(type = WLTaskPersistence.class)
	protected WLTaskPersistence wlTaskPersistence;
	@BeanReference(type = WLTaskOptionLocalService.class)
	protected WLTaskOptionLocalService wlTaskOptionLocalService;
	@BeanReference(type = WLTaskOptionService.class)
	protected WLTaskOptionService wlTaskOptionService;
	@BeanReference(type = WLTaskOptionPersistence.class)
	protected WLTaskOptionPersistence wlTaskOptionPersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private WLEventLogLocalServiceClpInvoker _clpInvoker = new WLEventLogLocalServiceClpInvoker();
}