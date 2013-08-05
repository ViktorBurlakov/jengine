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

package com.jenginetest.builder.service.persistence;

import com.jenginetest.builder.model.WLTask;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the w l task service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WLTaskPersistenceImpl
 * @see WLTaskUtil
 * @generated
 */
public interface WLTaskPersistence extends BasePersistence<WLTask> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WLTaskUtil} to access the w l task persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the w l task in the entity cache if it is enabled.
	*
	* @param wlTask the w l task
	*/
	public void cacheResult(com.jenginetest.builder.model.WLTask wlTask);

	/**
	* Caches the w l tasks in the entity cache if it is enabled.
	*
	* @param wlTasks the w l tasks
	*/
	public void cacheResult(
		java.util.List<com.jenginetest.builder.model.WLTask> wlTasks);

	/**
	* Creates a new w l task with the primary key. Does not add the w l task to the database.
	*
	* @param taskId the primary key for the new w l task
	* @return the new w l task
	*/
	public com.jenginetest.builder.model.WLTask create(long taskId);

	/**
	* Removes the w l task with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param taskId the primary key of the w l task
	* @return the w l task that was removed
	* @throws com.jenginetest.builder.NoSuchTaskException if a w l task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLTask remove(long taskId)
		throws com.jenginetest.builder.NoSuchTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.jenginetest.builder.model.WLTask updateImpl(
		com.jenginetest.builder.model.WLTask wlTask, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the w l task with the primary key or throws a {@link com.jenginetest.builder.NoSuchTaskException} if it could not be found.
	*
	* @param taskId the primary key of the w l task
	* @return the w l task
	* @throws com.jenginetest.builder.NoSuchTaskException if a w l task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLTask findByPrimaryKey(long taskId)
		throws com.jenginetest.builder.NoSuchTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the w l task with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param taskId the primary key of the w l task
	* @return the w l task, or <code>null</code> if a w l task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLTask fetchByPrimaryKey(long taskId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the w l tasks where subject = &#63; and workerId = &#63; and projectId = &#63;.
	*
	* @param subject the subject
	* @param workerId the worker ID
	* @param projectId the project ID
	* @return the matching w l tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLTask> findByS_W_P(
		java.lang.String subject, long workerId, long projectId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the w l tasks where subject = &#63; and workerId = &#63; and projectId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param subject the subject
	* @param workerId the worker ID
	* @param projectId the project ID
	* @param start the lower bound of the range of w l tasks
	* @param end the upper bound of the range of w l tasks (not inclusive)
	* @return the range of matching w l tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLTask> findByS_W_P(
		java.lang.String subject, long workerId, long projectId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the w l tasks where subject = &#63; and workerId = &#63; and projectId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param subject the subject
	* @param workerId the worker ID
	* @param projectId the project ID
	* @param start the lower bound of the range of w l tasks
	* @param end the upper bound of the range of w l tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching w l tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLTask> findByS_W_P(
		java.lang.String subject, long workerId, long projectId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first w l task in the ordered set where subject = &#63; and workerId = &#63; and projectId = &#63;.
	*
	* @param subject the subject
	* @param workerId the worker ID
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching w l task
	* @throws com.jenginetest.builder.NoSuchTaskException if a matching w l task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLTask findByS_W_P_First(
		java.lang.String subject, long workerId, long projectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first w l task in the ordered set where subject = &#63; and workerId = &#63; and projectId = &#63;.
	*
	* @param subject the subject
	* @param workerId the worker ID
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching w l task, or <code>null</code> if a matching w l task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLTask fetchByS_W_P_First(
		java.lang.String subject, long workerId, long projectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last w l task in the ordered set where subject = &#63; and workerId = &#63; and projectId = &#63;.
	*
	* @param subject the subject
	* @param workerId the worker ID
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching w l task
	* @throws com.jenginetest.builder.NoSuchTaskException if a matching w l task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLTask findByS_W_P_Last(
		java.lang.String subject, long workerId, long projectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last w l task in the ordered set where subject = &#63; and workerId = &#63; and projectId = &#63;.
	*
	* @param subject the subject
	* @param workerId the worker ID
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching w l task, or <code>null</code> if a matching w l task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLTask fetchByS_W_P_Last(
		java.lang.String subject, long workerId, long projectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the w l tasks before and after the current w l task in the ordered set where subject = &#63; and workerId = &#63; and projectId = &#63;.
	*
	* @param taskId the primary key of the current w l task
	* @param subject the subject
	* @param workerId the worker ID
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next w l task
	* @throws com.jenginetest.builder.NoSuchTaskException if a w l task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLTask[] findByS_W_P_PrevAndNext(
		long taskId, java.lang.String subject, long workerId, long projectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject = &#63; and projectId = &#63; and workerId = &#63;.
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @param projectId the project ID
	* @param workerId the worker ID
	* @return the matching w l tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLTask> findByO_G_C_S_P_W(
		long ownerId, long groupId, long companyId, java.lang.String subject,
		long projectId, long workerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject = &#63; and projectId = &#63; and workerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @param projectId the project ID
	* @param workerId the worker ID
	* @param start the lower bound of the range of w l tasks
	* @param end the upper bound of the range of w l tasks (not inclusive)
	* @return the range of matching w l tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLTask> findByO_G_C_S_P_W(
		long ownerId, long groupId, long companyId, java.lang.String subject,
		long projectId, long workerId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject = &#63; and projectId = &#63; and workerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @param projectId the project ID
	* @param workerId the worker ID
	* @param start the lower bound of the range of w l tasks
	* @param end the upper bound of the range of w l tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching w l tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLTask> findByO_G_C_S_P_W(
		long ownerId, long groupId, long companyId, java.lang.String subject,
		long projectId, long workerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject = &#63; and projectId = &#63; and workerId = &#63;.
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @param projectId the project ID
	* @param workerId the worker ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching w l task
	* @throws com.jenginetest.builder.NoSuchTaskException if a matching w l task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLTask findByO_G_C_S_P_W_First(
		long ownerId, long groupId, long companyId, java.lang.String subject,
		long projectId, long workerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject = &#63; and projectId = &#63; and workerId = &#63;.
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @param projectId the project ID
	* @param workerId the worker ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching w l task, or <code>null</code> if a matching w l task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLTask fetchByO_G_C_S_P_W_First(
		long ownerId, long groupId, long companyId, java.lang.String subject,
		long projectId, long workerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject = &#63; and projectId = &#63; and workerId = &#63;.
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @param projectId the project ID
	* @param workerId the worker ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching w l task
	* @throws com.jenginetest.builder.NoSuchTaskException if a matching w l task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLTask findByO_G_C_S_P_W_Last(
		long ownerId, long groupId, long companyId, java.lang.String subject,
		long projectId, long workerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject = &#63; and projectId = &#63; and workerId = &#63;.
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @param projectId the project ID
	* @param workerId the worker ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching w l task, or <code>null</code> if a matching w l task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLTask fetchByO_G_C_S_P_W_Last(
		long ownerId, long groupId, long companyId, java.lang.String subject,
		long projectId, long workerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the w l tasks before and after the current w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject = &#63; and projectId = &#63; and workerId = &#63;.
	*
	* @param taskId the primary key of the current w l task
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @param projectId the project ID
	* @param workerId the worker ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next w l task
	* @throws com.jenginetest.builder.NoSuchTaskException if a w l task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLTask[] findByO_G_C_S_P_W_PrevAndNext(
		long taskId, long ownerId, long groupId, long companyId,
		java.lang.String subject, long projectId, long workerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject = &#63; and externalId = &#63; and projectId = &#63; and workerId = &#63;.
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @param externalId the external ID
	* @param projectId the project ID
	* @param workerId the worker ID
	* @return the matching w l tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLTask> findByO_G_C_S_E_P_W(
		long ownerId, long groupId, long companyId, java.lang.String subject,
		java.lang.String externalId, long projectId, long workerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject = &#63; and externalId = &#63; and projectId = &#63; and workerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @param externalId the external ID
	* @param projectId the project ID
	* @param workerId the worker ID
	* @param start the lower bound of the range of w l tasks
	* @param end the upper bound of the range of w l tasks (not inclusive)
	* @return the range of matching w l tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLTask> findByO_G_C_S_E_P_W(
		long ownerId, long groupId, long companyId, java.lang.String subject,
		java.lang.String externalId, long projectId, long workerId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject = &#63; and externalId = &#63; and projectId = &#63; and workerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @param externalId the external ID
	* @param projectId the project ID
	* @param workerId the worker ID
	* @param start the lower bound of the range of w l tasks
	* @param end the upper bound of the range of w l tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching w l tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLTask> findByO_G_C_S_E_P_W(
		long ownerId, long groupId, long companyId, java.lang.String subject,
		java.lang.String externalId, long projectId, long workerId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject = &#63; and externalId = &#63; and projectId = &#63; and workerId = &#63;.
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @param externalId the external ID
	* @param projectId the project ID
	* @param workerId the worker ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching w l task
	* @throws com.jenginetest.builder.NoSuchTaskException if a matching w l task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLTask findByO_G_C_S_E_P_W_First(
		long ownerId, long groupId, long companyId, java.lang.String subject,
		java.lang.String externalId, long projectId, long workerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject = &#63; and externalId = &#63; and projectId = &#63; and workerId = &#63;.
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @param externalId the external ID
	* @param projectId the project ID
	* @param workerId the worker ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching w l task, or <code>null</code> if a matching w l task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLTask fetchByO_G_C_S_E_P_W_First(
		long ownerId, long groupId, long companyId, java.lang.String subject,
		java.lang.String externalId, long projectId, long workerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject = &#63; and externalId = &#63; and projectId = &#63; and workerId = &#63;.
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @param externalId the external ID
	* @param projectId the project ID
	* @param workerId the worker ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching w l task
	* @throws com.jenginetest.builder.NoSuchTaskException if a matching w l task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLTask findByO_G_C_S_E_P_W_Last(
		long ownerId, long groupId, long companyId, java.lang.String subject,
		java.lang.String externalId, long projectId, long workerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject = &#63; and externalId = &#63; and projectId = &#63; and workerId = &#63;.
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @param externalId the external ID
	* @param projectId the project ID
	* @param workerId the worker ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching w l task, or <code>null</code> if a matching w l task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLTask fetchByO_G_C_S_E_P_W_Last(
		long ownerId, long groupId, long companyId, java.lang.String subject,
		java.lang.String externalId, long projectId, long workerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the w l tasks before and after the current w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject = &#63; and externalId = &#63; and projectId = &#63; and workerId = &#63;.
	*
	* @param taskId the primary key of the current w l task
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @param externalId the external ID
	* @param projectId the project ID
	* @param workerId the worker ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next w l task
	* @throws com.jenginetest.builder.NoSuchTaskException if a w l task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLTask[] findByO_G_C_S_E_P_W_PrevAndNext(
		long taskId, long ownerId, long groupId, long companyId,
		java.lang.String subject, java.lang.String externalId, long projectId,
		long workerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63;.
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @return the matching w l tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLTask> findByO_G_C(
		long ownerId, long groupId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param start the lower bound of the range of w l tasks
	* @param end the upper bound of the range of w l tasks (not inclusive)
	* @return the range of matching w l tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLTask> findByO_G_C(
		long ownerId, long groupId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param start the lower bound of the range of w l tasks
	* @param end the upper bound of the range of w l tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching w l tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLTask> findByO_G_C(
		long ownerId, long groupId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63;.
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching w l task
	* @throws com.jenginetest.builder.NoSuchTaskException if a matching w l task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLTask findByO_G_C_First(
		long ownerId, long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63;.
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching w l task, or <code>null</code> if a matching w l task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLTask fetchByO_G_C_First(
		long ownerId, long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63;.
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching w l task
	* @throws com.jenginetest.builder.NoSuchTaskException if a matching w l task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLTask findByO_G_C_Last(long ownerId,
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63;.
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching w l task, or <code>null</code> if a matching w l task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLTask fetchByO_G_C_Last(
		long ownerId, long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the w l tasks before and after the current w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63;.
	*
	* @param taskId the primary key of the current w l task
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next w l task
	* @throws com.jenginetest.builder.NoSuchTaskException if a w l task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLTask[] findByO_G_C_PrevAndNext(
		long taskId, long ownerId, long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63;.
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @return the matching w l tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLTask> findByO_G_C_SP(
		long ownerId, long groupId, long companyId, java.lang.String subject)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @param start the lower bound of the range of w l tasks
	* @param end the upper bound of the range of w l tasks (not inclusive)
	* @return the range of matching w l tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLTask> findByO_G_C_SP(
		long ownerId, long groupId, long companyId, java.lang.String subject,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @param start the lower bound of the range of w l tasks
	* @param end the upper bound of the range of w l tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching w l tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLTask> findByO_G_C_SP(
		long ownerId, long groupId, long companyId, java.lang.String subject,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63;.
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching w l task
	* @throws com.jenginetest.builder.NoSuchTaskException if a matching w l task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLTask findByO_G_C_SP_First(
		long ownerId, long groupId, long companyId, java.lang.String subject,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63;.
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching w l task, or <code>null</code> if a matching w l task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLTask fetchByO_G_C_SP_First(
		long ownerId, long groupId, long companyId, java.lang.String subject,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63;.
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching w l task
	* @throws com.jenginetest.builder.NoSuchTaskException if a matching w l task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLTask findByO_G_C_SP_Last(
		long ownerId, long groupId, long companyId, java.lang.String subject,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63;.
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching w l task, or <code>null</code> if a matching w l task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLTask fetchByO_G_C_SP_Last(
		long ownerId, long groupId, long companyId, java.lang.String subject,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the w l tasks before and after the current w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63;.
	*
	* @param taskId the primary key of the current w l task
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next w l task
	* @throws com.jenginetest.builder.NoSuchTaskException if a w l task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLTask[] findByO_G_C_SP_PrevAndNext(
		long taskId, long ownerId, long groupId, long companyId,
		java.lang.String subject,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and projectId = &#63;.
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @param projectId the project ID
	* @return the matching w l tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLTask> findByO_G_C_SP_P(
		long ownerId, long groupId, long companyId, java.lang.String subject,
		long projectId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and projectId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @param projectId the project ID
	* @param start the lower bound of the range of w l tasks
	* @param end the upper bound of the range of w l tasks (not inclusive)
	* @return the range of matching w l tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLTask> findByO_G_C_SP_P(
		long ownerId, long groupId, long companyId, java.lang.String subject,
		long projectId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and projectId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @param projectId the project ID
	* @param start the lower bound of the range of w l tasks
	* @param end the upper bound of the range of w l tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching w l tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLTask> findByO_G_C_SP_P(
		long ownerId, long groupId, long companyId, java.lang.String subject,
		long projectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and projectId = &#63;.
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching w l task
	* @throws com.jenginetest.builder.NoSuchTaskException if a matching w l task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLTask findByO_G_C_SP_P_First(
		long ownerId, long groupId, long companyId, java.lang.String subject,
		long projectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and projectId = &#63;.
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching w l task, or <code>null</code> if a matching w l task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLTask fetchByO_G_C_SP_P_First(
		long ownerId, long groupId, long companyId, java.lang.String subject,
		long projectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and projectId = &#63;.
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching w l task
	* @throws com.jenginetest.builder.NoSuchTaskException if a matching w l task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLTask findByO_G_C_SP_P_Last(
		long ownerId, long groupId, long companyId, java.lang.String subject,
		long projectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and projectId = &#63;.
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching w l task, or <code>null</code> if a matching w l task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLTask fetchByO_G_C_SP_P_Last(
		long ownerId, long groupId, long companyId, java.lang.String subject,
		long projectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the w l tasks before and after the current w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and projectId = &#63;.
	*
	* @param taskId the primary key of the current w l task
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next w l task
	* @throws com.jenginetest.builder.NoSuchTaskException if a w l task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLTask[] findByO_G_C_SP_P_PrevAndNext(
		long taskId, long ownerId, long groupId, long companyId,
		java.lang.String subject, long projectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and workerId = &#63;.
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @param workerId the worker ID
	* @return the matching w l tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLTask> findByO_G_C_SP_W(
		long ownerId, long groupId, long companyId, java.lang.String subject,
		long workerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and workerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @param workerId the worker ID
	* @param start the lower bound of the range of w l tasks
	* @param end the upper bound of the range of w l tasks (not inclusive)
	* @return the range of matching w l tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLTask> findByO_G_C_SP_W(
		long ownerId, long groupId, long companyId, java.lang.String subject,
		long workerId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and workerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @param workerId the worker ID
	* @param start the lower bound of the range of w l tasks
	* @param end the upper bound of the range of w l tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching w l tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLTask> findByO_G_C_SP_W(
		long ownerId, long groupId, long companyId, java.lang.String subject,
		long workerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and workerId = &#63;.
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @param workerId the worker ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching w l task
	* @throws com.jenginetest.builder.NoSuchTaskException if a matching w l task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLTask findByO_G_C_SP_W_First(
		long ownerId, long groupId, long companyId, java.lang.String subject,
		long workerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and workerId = &#63;.
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @param workerId the worker ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching w l task, or <code>null</code> if a matching w l task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLTask fetchByO_G_C_SP_W_First(
		long ownerId, long groupId, long companyId, java.lang.String subject,
		long workerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and workerId = &#63;.
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @param workerId the worker ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching w l task
	* @throws com.jenginetest.builder.NoSuchTaskException if a matching w l task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLTask findByO_G_C_SP_W_Last(
		long ownerId, long groupId, long companyId, java.lang.String subject,
		long workerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and workerId = &#63;.
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @param workerId the worker ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching w l task, or <code>null</code> if a matching w l task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLTask fetchByO_G_C_SP_W_Last(
		long ownerId, long groupId, long companyId, java.lang.String subject,
		long workerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the w l tasks before and after the current w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and workerId = &#63;.
	*
	* @param taskId the primary key of the current w l task
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @param workerId the worker ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next w l task
	* @throws com.jenginetest.builder.NoSuchTaskException if a w l task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLTask[] findByO_G_C_SP_W_PrevAndNext(
		long taskId, long ownerId, long groupId, long companyId,
		java.lang.String subject, long workerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and projectId = &#63; and workerId = &#63;.
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @param projectId the project ID
	* @param workerId the worker ID
	* @return the matching w l tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLTask> findByO_G_C_SP_P_W(
		long ownerId, long groupId, long companyId, java.lang.String subject,
		long projectId, long workerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and projectId = &#63; and workerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @param projectId the project ID
	* @param workerId the worker ID
	* @param start the lower bound of the range of w l tasks
	* @param end the upper bound of the range of w l tasks (not inclusive)
	* @return the range of matching w l tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLTask> findByO_G_C_SP_P_W(
		long ownerId, long groupId, long companyId, java.lang.String subject,
		long projectId, long workerId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and projectId = &#63; and workerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @param projectId the project ID
	* @param workerId the worker ID
	* @param start the lower bound of the range of w l tasks
	* @param end the upper bound of the range of w l tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching w l tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLTask> findByO_G_C_SP_P_W(
		long ownerId, long groupId, long companyId, java.lang.String subject,
		long projectId, long workerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and projectId = &#63; and workerId = &#63;.
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @param projectId the project ID
	* @param workerId the worker ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching w l task
	* @throws com.jenginetest.builder.NoSuchTaskException if a matching w l task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLTask findByO_G_C_SP_P_W_First(
		long ownerId, long groupId, long companyId, java.lang.String subject,
		long projectId, long workerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and projectId = &#63; and workerId = &#63;.
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @param projectId the project ID
	* @param workerId the worker ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching w l task, or <code>null</code> if a matching w l task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLTask fetchByO_G_C_SP_P_W_First(
		long ownerId, long groupId, long companyId, java.lang.String subject,
		long projectId, long workerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and projectId = &#63; and workerId = &#63;.
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @param projectId the project ID
	* @param workerId the worker ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching w l task
	* @throws com.jenginetest.builder.NoSuchTaskException if a matching w l task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLTask findByO_G_C_SP_P_W_Last(
		long ownerId, long groupId, long companyId, java.lang.String subject,
		long projectId, long workerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and projectId = &#63; and workerId = &#63;.
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @param projectId the project ID
	* @param workerId the worker ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching w l task, or <code>null</code> if a matching w l task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLTask fetchByO_G_C_SP_P_W_Last(
		long ownerId, long groupId, long companyId, java.lang.String subject,
		long projectId, long workerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the w l tasks before and after the current w l task in the ordered set where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and projectId = &#63; and workerId = &#63;.
	*
	* @param taskId the primary key of the current w l task
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @param projectId the project ID
	* @param workerId the worker ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next w l task
	* @throws com.jenginetest.builder.NoSuchTaskException if a w l task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jenginetest.builder.model.WLTask[] findByO_G_C_SP_P_W_PrevAndNext(
		long taskId, long ownerId, long groupId, long companyId,
		java.lang.String subject, long projectId, long workerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jenginetest.builder.NoSuchTaskException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the w l tasks.
	*
	* @return the w l tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLTask> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the w l tasks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of w l tasks
	* @param end the upper bound of the range of w l tasks (not inclusive)
	* @return the range of w l tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLTask> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the w l tasks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of w l tasks
	* @param end the upper bound of the range of w l tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of w l tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLTask> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the w l tasks where subject = &#63; and workerId = &#63; and projectId = &#63; from the database.
	*
	* @param subject the subject
	* @param workerId the worker ID
	* @param projectId the project ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByS_W_P(java.lang.String subject, long workerId,
		long projectId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject = &#63; and projectId = &#63; and workerId = &#63; from the database.
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @param projectId the project ID
	* @param workerId the worker ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByO_G_C_S_P_W(long ownerId, long groupId, long companyId,
		java.lang.String subject, long projectId, long workerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject = &#63; and externalId = &#63; and projectId = &#63; and workerId = &#63; from the database.
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @param externalId the external ID
	* @param projectId the project ID
	* @param workerId the worker ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByO_G_C_S_E_P_W(long ownerId, long groupId,
		long companyId, java.lang.String subject, java.lang.String externalId,
		long projectId, long workerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; from the database.
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByO_G_C(long ownerId, long groupId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; from the database.
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @throws SystemException if a system exception occurred
	*/
	public void removeByO_G_C_SP(long ownerId, long groupId, long companyId,
		java.lang.String subject)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and projectId = &#63; from the database.
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @param projectId the project ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByO_G_C_SP_P(long ownerId, long groupId, long companyId,
		java.lang.String subject, long projectId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and workerId = &#63; from the database.
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @param workerId the worker ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByO_G_C_SP_W(long ownerId, long groupId, long companyId,
		java.lang.String subject, long workerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and projectId = &#63; and workerId = &#63; from the database.
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @param projectId the project ID
	* @param workerId the worker ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByO_G_C_SP_P_W(long ownerId, long groupId,
		long companyId, java.lang.String subject, long projectId, long workerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the w l tasks from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of w l tasks where subject = &#63; and workerId = &#63; and projectId = &#63;.
	*
	* @param subject the subject
	* @param workerId the worker ID
	* @param projectId the project ID
	* @return the number of matching w l tasks
	* @throws SystemException if a system exception occurred
	*/
	public int countByS_W_P(java.lang.String subject, long workerId,
		long projectId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject = &#63; and projectId = &#63; and workerId = &#63;.
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @param projectId the project ID
	* @param workerId the worker ID
	* @return the number of matching w l tasks
	* @throws SystemException if a system exception occurred
	*/
	public int countByO_G_C_S_P_W(long ownerId, long groupId, long companyId,
		java.lang.String subject, long projectId, long workerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject = &#63; and externalId = &#63; and projectId = &#63; and workerId = &#63;.
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @param externalId the external ID
	* @param projectId the project ID
	* @param workerId the worker ID
	* @return the number of matching w l tasks
	* @throws SystemException if a system exception occurred
	*/
	public int countByO_G_C_S_E_P_W(long ownerId, long groupId, long companyId,
		java.lang.String subject, java.lang.String externalId, long projectId,
		long workerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63;.
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @return the number of matching w l tasks
	* @throws SystemException if a system exception occurred
	*/
	public int countByO_G_C(long ownerId, long groupId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63;.
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @return the number of matching w l tasks
	* @throws SystemException if a system exception occurred
	*/
	public int countByO_G_C_SP(long ownerId, long groupId, long companyId,
		java.lang.String subject)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and projectId = &#63;.
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @param projectId the project ID
	* @return the number of matching w l tasks
	* @throws SystemException if a system exception occurred
	*/
	public int countByO_G_C_SP_P(long ownerId, long groupId, long companyId,
		java.lang.String subject, long projectId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and workerId = &#63;.
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @param workerId the worker ID
	* @return the number of matching w l tasks
	* @throws SystemException if a system exception occurred
	*/
	public int countByO_G_C_SP_W(long ownerId, long groupId, long companyId,
		java.lang.String subject, long workerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of w l tasks where ownerId = &#63; and groupId = &#63; and companyId = &#63; and subject like &#63; and projectId = &#63; and workerId = &#63;.
	*
	* @param ownerId the owner ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param subject the subject
	* @param projectId the project ID
	* @param workerId the worker ID
	* @return the number of matching w l tasks
	* @throws SystemException if a system exception occurred
	*/
	public int countByO_G_C_SP_P_W(long ownerId, long groupId, long companyId,
		java.lang.String subject, long projectId, long workerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of w l tasks.
	*
	* @return the number of w l tasks
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the w l task options associated with the w l task.
	*
	* @param pk the primary key of the w l task
	* @return the w l task options associated with the w l task
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLTaskOption> getWLTaskOptions(
		long pk) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the w l task options associated with the w l task.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the w l task
	* @param start the lower bound of the range of w l tasks
	* @param end the upper bound of the range of w l tasks (not inclusive)
	* @return the range of w l task options associated with the w l task
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLTaskOption> getWLTaskOptions(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the w l task options associated with the w l task.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the w l task
	* @param start the lower bound of the range of w l tasks
	* @param end the upper bound of the range of w l tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of w l task options associated with the w l task
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLTaskOption> getWLTaskOptions(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of w l task options associated with the w l task.
	*
	* @param pk the primary key of the w l task
	* @return the number of w l task options associated with the w l task
	* @throws SystemException if a system exception occurred
	*/
	public int getWLTaskOptionsSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the w l task option is associated with the w l task.
	*
	* @param pk the primary key of the w l task
	* @param wlTaskOptionPK the primary key of the w l task option
	* @return <code>true</code> if the w l task option is associated with the w l task; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsWLTaskOption(long pk, long wlTaskOptionPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the w l task has any w l task options associated with it.
	*
	* @param pk the primary key of the w l task to check for associations with w l task options
	* @return <code>true</code> if the w l task has any w l task options associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsWLTaskOptions(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the w l entries associated with the w l task.
	*
	* @param pk the primary key of the w l task
	* @return the w l entries associated with the w l task
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLEntry> getWLEntries(
		long pk) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the w l entries associated with the w l task.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the w l task
	* @param start the lower bound of the range of w l tasks
	* @param end the upper bound of the range of w l tasks (not inclusive)
	* @return the range of w l entries associated with the w l task
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLEntry> getWLEntries(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the w l entries associated with the w l task.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the w l task
	* @param start the lower bound of the range of w l tasks
	* @param end the upper bound of the range of w l tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of w l entries associated with the w l task
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jenginetest.builder.model.WLEntry> getWLEntries(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of w l entries associated with the w l task.
	*
	* @param pk the primary key of the w l task
	* @return the number of w l entries associated with the w l task
	* @throws SystemException if a system exception occurred
	*/
	public int getWLEntriesSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the w l entry is associated with the w l task.
	*
	* @param pk the primary key of the w l task
	* @param wlEntryPK the primary key of the w l entry
	* @return <code>true</code> if the w l entry is associated with the w l task; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsWLEntry(long pk, long wlEntryPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the w l task has any w l entries associated with it.
	*
	* @param pk the primary key of the w l task to check for associations with w l entries
	* @return <code>true</code> if the w l task has any w l entries associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsWLEntries(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;
}