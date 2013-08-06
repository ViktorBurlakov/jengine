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

package com.jenginetest.builder.service.messaging;

import com.jenginetest.builder.service.AuthorLocalServiceUtil;
import com.jenginetest.builder.service.AuthorServiceUtil;
import com.jenginetest.builder.service.BookLocalServiceUtil;
import com.jenginetest.builder.service.BookServiceUtil;
import com.jenginetest.builder.service.ClpSerializer;
import com.jenginetest.builder.service.LibraryLocalServiceUtil;
import com.jenginetest.builder.service.LibraryServiceUtil;
import com.jenginetest.builder.service.MemberLocalServiceUtil;
import com.jenginetest.builder.service.MemberServiceUtil;
import com.jenginetest.builder.service.TestLocalServiceUtil;
import com.jenginetest.builder.service.TestServiceUtil;
import com.jenginetest.builder.service.TransactionLocalServiceUtil;
import com.jenginetest.builder.service.TransactionServiceUtil;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			AuthorLocalServiceUtil.clearService();

			AuthorServiceUtil.clearService();
			BookLocalServiceUtil.clearService();

			BookServiceUtil.clearService();
			LibraryLocalServiceUtil.clearService();

			LibraryServiceUtil.clearService();
			MemberLocalServiceUtil.clearService();

			MemberServiceUtil.clearService();
			TestLocalServiceUtil.clearService();

			TestServiceUtil.clearService();
			TransactionLocalServiceUtil.clearService();

			TransactionServiceUtil.clearService();
		}
	}
}