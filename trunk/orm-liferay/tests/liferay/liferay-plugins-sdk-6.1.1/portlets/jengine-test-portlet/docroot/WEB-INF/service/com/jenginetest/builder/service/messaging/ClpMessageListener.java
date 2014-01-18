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

import com.jenginetest.builder.service.ClpSerializer;
import com.jenginetest.builder.service.SAuthorLocalServiceUtil;
import com.jenginetest.builder.service.SAuthorServiceUtil;
import com.jenginetest.builder.service.SBookLocalServiceUtil;
import com.jenginetest.builder.service.SBookServiceUtil;
import com.jenginetest.builder.service.SLibraryLocalServiceUtil;
import com.jenginetest.builder.service.SLibraryServiceUtil;
import com.jenginetest.builder.service.SMemberLocalServiceUtil;
import com.jenginetest.builder.service.SMemberServiceUtil;
import com.jenginetest.builder.service.STransactionLocalServiceUtil;
import com.jenginetest.builder.service.STransactionServiceUtil;
import com.jenginetest.builder.service.TestLocalServiceUtil;
import com.jenginetest.builder.service.TestServiceUtil;

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
			SAuthorLocalServiceUtil.clearService();

			SAuthorServiceUtil.clearService();
			SBookLocalServiceUtil.clearService();

			SBookServiceUtil.clearService();
			SLibraryLocalServiceUtil.clearService();

			SLibraryServiceUtil.clearService();
			SMemberLocalServiceUtil.clearService();

			SMemberServiceUtil.clearService();
			STransactionLocalServiceUtil.clearService();

			STransactionServiceUtil.clearService();
			TestLocalServiceUtil.clearService();

			TestServiceUtil.clearService();
		}
	}
}