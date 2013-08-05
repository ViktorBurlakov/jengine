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

import com.jenginetest.builder.model.WLTaskOption;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the w l task option service. This utility wraps {@link WLTaskOptionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WLTaskOptionPersistence
 * @see WLTaskOptionPersistenceImpl
 * @generated
 */
public class WLTaskOptionUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(WLTaskOption wlTaskOption) {
		getPersistence().clearCache(wlTaskOption);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<WLTaskOption> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WLTaskOption> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WLTaskOption> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static WLTaskOption update(WLTaskOption wlTaskOption, boolean merge)
		throws SystemException {
		return getPersistence().update(wlTaskOption, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static WLTaskOption update(WLTaskOption wlTaskOption, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(wlTaskOption, merge, serviceContext);
	}

	/**
	* Caches the w l task option in the entity cache if it is enabled.
	*
	* @param wlTaskOption the w l task option
	*/
	public static void cacheResult(
		com.jenginetest.builder.model.WLTaskOption wlTaskOption) {
		getPersistence().cacheResult(wlTaskOption);
	}

	/**
	* Caches the w l task options in the entity cache if it is enabled.
	*
	* @param wlTaskOptions the w l task options
	*/
	public static void cacheResult(
		java.util.List<com.jenginetest.builder.model.WLTaskOption> wlTaskOptions) {
		getPersistence().cacheResult(wlTaskOptions);
	}

	/**
	* Creates a new w l task option with the primary key. Does not add the w l task option to the database.
	*
	* @param optionId the primary key for the new w l task option
	* @return the new w l task option
	*/
	public static com.jenginetest.builder.model.WLTaskOption create(
		long optionId) {
		return getPersistence().create(optionId);
	}

	/**
	* Removes the w l task option with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param optionId the primary key of the w l task option
	* @return the w l task option that was removed
	* @throws com.jenginetest.builder.NoSuchTaskOptionException if a w l task option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLTaskOption remove(
		long optionId)
		throws com.jenginetest.builder.NoSuchTaskOptionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(optionId);
	}

	public static com.jenginetest.builder.model.WLTaskOption updateImpl(
		com.jenginetest.builder.model.WLTaskOption wlTaskOption, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(wlTaskOption, merge);
	}

	/**
	* Returns the w l task option with the primary key or throws a {@link com.jenginetest.builder.NoSuchTaskOptionException} if it could not be found.
	*
	* @param optionId the primary key of the w l task option
	* @return the w l task option
	* @throws com.jenginetest.builder.NoSuchTaskOptionException if a w l task option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLTaskOption findByPrimaryKey(
		long optionId)
		throws com.jenginetest.builder.NoSuchTaskOptionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(optionId);
	}

	/**
	* Returns the w l task option with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param optionId the primary key of the w l task option
	* @return the w l task option, or <code>null</code> if a w l task option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jenginetest.builder.model.WLTaskOption fetchByPrimaryKey(
		long optionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(optionId);
	}

	/**
	* Returns all the w l task options.
	*
	* @return the w l task options
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jenginetest.builder.model.WLTaskOption> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the w l task options.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of w l task options
	* @param end the upper bound of the range of w l task options (not inclusive)
	* @return the range of w l task options
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jenginetest.builder.model.WLTaskOption> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the w l task options.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of w l task options
	* @param end the upper bound of the range of w l task options (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of w l task options
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jenginetest.builder.model.WLTaskOption> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the w l task options from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of w l task options.
	*
	* @return the number of w l task options
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static WLTaskOptionPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (WLTaskOptionPersistence)PortletBeanLocatorUtil.locate(com.jenginetest.builder.service.ClpSerializer.getServletContextName(),
					WLTaskOptionPersistence.class.getName());

			ReferenceRegistry.registerReference(WLTaskOptionUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(WLTaskOptionPersistence persistence) {
	}

	private static WLTaskOptionPersistence _persistence;
}