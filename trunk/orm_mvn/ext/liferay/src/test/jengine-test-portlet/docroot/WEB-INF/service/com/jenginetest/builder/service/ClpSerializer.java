/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.jenginetest.builder.service;

import com.jenginetest.builder.model.SAuthorClp;
import com.jenginetest.builder.model.SBookClp;
import com.jenginetest.builder.model.SLibraryClp;
import com.jenginetest.builder.model.SMemberClp;
import com.jenginetest.builder.model.STransactionClp;

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

		if (oldModelClassName.equals(SAuthorClp.class.getName())) {
			return translateInputSAuthor(oldModel);
		}

		if (oldModelClassName.equals(SBookClp.class.getName())) {
			return translateInputSBook(oldModel);
		}

		if (oldModelClassName.equals(SLibraryClp.class.getName())) {
			return translateInputSLibrary(oldModel);
		}

		if (oldModelClassName.equals(SMemberClp.class.getName())) {
			return translateInputSMember(oldModel);
		}

		if (oldModelClassName.equals(STransactionClp.class.getName())) {
			return translateInputSTransaction(oldModel);
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

	public static Object translateInputSAuthor(BaseModel<?> oldModel) {
		SAuthorClp oldClpModel = (SAuthorClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSAuthorRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSBook(BaseModel<?> oldModel) {
		SBookClp oldClpModel = (SBookClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSBookRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSLibrary(BaseModel<?> oldModel) {
		SLibraryClp oldClpModel = (SLibraryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSLibraryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSMember(BaseModel<?> oldModel) {
		SMemberClp oldClpModel = (SMemberClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSMemberRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSTransaction(BaseModel<?> oldModel) {
		STransactionClp oldClpModel = (STransactionClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSTransactionRemoteModel();

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
					"com.jenginetest.builder.model.impl.SAuthorImpl")) {
			return translateOutputSAuthor(oldModel);
		}

		if (oldModelClassName.equals(
					"com.jenginetest.builder.model.impl.SBookImpl")) {
			return translateOutputSBook(oldModel);
		}

		if (oldModelClassName.equals(
					"com.jenginetest.builder.model.impl.SLibraryImpl")) {
			return translateOutputSLibrary(oldModel);
		}

		if (oldModelClassName.equals(
					"com.jenginetest.builder.model.impl.SMemberImpl")) {
			return translateOutputSMember(oldModel);
		}

		if (oldModelClassName.equals(
					"com.jenginetest.builder.model.impl.STransactionImpl")) {
			return translateOutputSTransaction(oldModel);
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

		if (className.equals("com.jenginetest.builder.NoSuchSAuthorException")) {
			return new com.jenginetest.builder.NoSuchSAuthorException();
		}

		if (className.equals("com.jenginetest.builder.NoSuchookException")) {
			return new com.jenginetest.builder.NoSuchookException();
		}

		if (className.equals("com.jenginetest.builder.NoSuchSLibraryException")) {
			return new com.jenginetest.builder.NoSuchSLibraryException();
		}

		if (className.equals("com.jenginetest.builder.NoSuchSMemberException")) {
			return new com.jenginetest.builder.NoSuchSMemberException();
		}

		if (className.equals(
					"com.jenginetest.builder.NoSuchSTransactionException")) {
			return new com.jenginetest.builder.NoSuchSTransactionException();
		}

		return throwable;
	}

	public static Object translateOutputSAuthor(BaseModel<?> oldModel) {
		SAuthorClp newModel = new SAuthorClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSAuthorRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSBook(BaseModel<?> oldModel) {
		SBookClp newModel = new SBookClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSBookRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSLibrary(BaseModel<?> oldModel) {
		SLibraryClp newModel = new SLibraryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSLibraryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSMember(BaseModel<?> oldModel) {
		SMemberClp newModel = new SMemberClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSMemberRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSTransaction(BaseModel<?> oldModel) {
		STransactionClp newModel = new STransactionClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSTransactionRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}