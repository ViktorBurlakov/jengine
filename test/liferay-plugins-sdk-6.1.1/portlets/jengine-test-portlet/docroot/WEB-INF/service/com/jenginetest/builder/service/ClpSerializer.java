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

package com.jenginetest.builder.service;

import com.jenginetest.builder.model.WLEntryClp;
import com.jenginetest.builder.model.WLEventLogClp;
import com.jenginetest.builder.model.WLProjectClp;
import com.jenginetest.builder.model.WLProjectUserClp;
import com.jenginetest.builder.model.WLProjectUserRoleClp;
import com.jenginetest.builder.model.WLTaskClp;
import com.jenginetest.builder.model.WLTaskOptionClp;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"jengine-test-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"jengine-test-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "jengine-test-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(WLEntryClp.class.getName())) {
			return translateInputWLEntry(oldModel);
		}

		if (oldModelClassName.equals(WLEventLogClp.class.getName())) {
			return translateInputWLEventLog(oldModel);
		}

		if (oldModelClassName.equals(WLProjectClp.class.getName())) {
			return translateInputWLProject(oldModel);
		}

		if (oldModelClassName.equals(WLProjectUserClp.class.getName())) {
			return translateInputWLProjectUser(oldModel);
		}

		if (oldModelClassName.equals(WLProjectUserRoleClp.class.getName())) {
			return translateInputWLProjectUserRole(oldModel);
		}

		if (oldModelClassName.equals(WLTaskClp.class.getName())) {
			return translateInputWLTask(oldModel);
		}

		if (oldModelClassName.equals(WLTaskOptionClp.class.getName())) {
			return translateInputWLTaskOption(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputWLEntry(BaseModel<?> oldModel) {
		WLEntryClp oldClpModel = (WLEntryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getWLEntryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputWLEventLog(BaseModel<?> oldModel) {
		WLEventLogClp oldClpModel = (WLEventLogClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getWLEventLogRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputWLProject(BaseModel<?> oldModel) {
		WLProjectClp oldClpModel = (WLProjectClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getWLProjectRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputWLProjectUser(BaseModel<?> oldModel) {
		WLProjectUserClp oldClpModel = (WLProjectUserClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getWLProjectUserRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputWLProjectUserRole(BaseModel<?> oldModel) {
		WLProjectUserRoleClp oldClpModel = (WLProjectUserRoleClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getWLProjectUserRoleRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputWLTask(BaseModel<?> oldModel) {
		WLTaskClp oldClpModel = (WLTaskClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getWLTaskRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputWLTaskOption(BaseModel<?> oldModel) {
		WLTaskOptionClp oldClpModel = (WLTaskOptionClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getWLTaskOptionRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"com.jenginetest.builder.model.impl.WLEntryImpl")) {
			return translateOutputWLEntry(oldModel);
		}

		if (oldModelClassName.equals(
					"com.jenginetest.builder.model.impl.WLEventLogImpl")) {
			return translateOutputWLEventLog(oldModel);
		}

		if (oldModelClassName.equals(
					"com.jenginetest.builder.model.impl.WLProjectImpl")) {
			return translateOutputWLProject(oldModel);
		}

		if (oldModelClassName.equals(
					"com.jenginetest.builder.model.impl.WLProjectUserImpl")) {
			return translateOutputWLProjectUser(oldModel);
		}

		if (oldModelClassName.equals(
					"com.jenginetest.builder.model.impl.WLProjectUserRoleImpl")) {
			return translateOutputWLProjectUserRole(oldModel);
		}

		if (oldModelClassName.equals(
					"com.jenginetest.builder.model.impl.WLTaskImpl")) {
			return translateOutputWLTask(oldModel);
		}

		if (oldModelClassName.equals(
					"com.jenginetest.builder.model.impl.WLTaskOptionImpl")) {
			return translateOutputWLTaskOption(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals("com.jenginetest.builder.NoSuchEntryException")) {
			return new com.jenginetest.builder.NoSuchEntryException();
		}

		if (className.equals("com.jenginetest.builder.NoSuchEventLogException")) {
			return new com.jenginetest.builder.NoSuchEventLogException();
		}

		if (className.equals("com.jenginetest.builder.NoSuchProjectException")) {
			return new com.jenginetest.builder.NoSuchProjectException();
		}

		if (className.equals(
					"com.jenginetest.builder.NoSuchProjectUserException")) {
			return new com.jenginetest.builder.NoSuchProjectUserException();
		}

		if (className.equals(
					"com.jenginetest.builder.NoSuchProjectUserRoleException")) {
			return new com.jenginetest.builder.NoSuchProjectUserRoleException();
		}

		if (className.equals("com.jenginetest.builder.NoSuchTaskException")) {
			return new com.jenginetest.builder.NoSuchTaskException();
		}

		if (className.equals(
					"com.jenginetest.builder.NoSuchTaskOptionException")) {
			return new com.jenginetest.builder.NoSuchTaskOptionException();
		}

		return throwable;
	}

	public static Object translateOutputWLEntry(BaseModel<?> oldModel) {
		WLEntryClp newModel = new WLEntryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setWLEntryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputWLEventLog(BaseModel<?> oldModel) {
		WLEventLogClp newModel = new WLEventLogClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setWLEventLogRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputWLProject(BaseModel<?> oldModel) {
		WLProjectClp newModel = new WLProjectClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setWLProjectRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputWLProjectUser(BaseModel<?> oldModel) {
		WLProjectUserClp newModel = new WLProjectUserClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setWLProjectUserRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputWLProjectUserRole(BaseModel<?> oldModel) {
		WLProjectUserRoleClp newModel = new WLProjectUserRoleClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setWLProjectUserRoleRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputWLTask(BaseModel<?> oldModel) {
		WLTaskClp newModel = new WLTaskClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setWLTaskRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputWLTaskOption(BaseModel<?> oldModel) {
		WLTaskOptionClp newModel = new WLTaskOptionClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setWLTaskOptionRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}