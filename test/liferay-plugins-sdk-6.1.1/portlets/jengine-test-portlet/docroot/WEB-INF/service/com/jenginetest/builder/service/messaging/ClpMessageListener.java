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

package com.jenginetest.builder.service.messaging;

import com.jenginetest.builder.service.ClpSerializer;
import com.jenginetest.builder.service.LoggingActivityLocalServiceUtil;
import com.jenginetest.builder.service.LoggingActivityServiceUtil;
import com.jenginetest.builder.service.WLEntryLocalServiceUtil;
import com.jenginetest.builder.service.WLEntryServiceUtil;
import com.jenginetest.builder.service.WLEventLogLocalServiceUtil;
import com.jenginetest.builder.service.WLEventLogServiceUtil;
import com.jenginetest.builder.service.WLProjectLocalServiceUtil;
import com.jenginetest.builder.service.WLProjectServiceUtil;
import com.jenginetest.builder.service.WLProjectUserLocalServiceUtil;
import com.jenginetest.builder.service.WLProjectUserRoleLocalServiceUtil;
import com.jenginetest.builder.service.WLProjectUserRoleServiceUtil;
import com.jenginetest.builder.service.WLProjectUserServiceUtil;
import com.jenginetest.builder.service.WLTaskLocalServiceUtil;
import com.jenginetest.builder.service.WLTaskOptionLocalServiceUtil;
import com.jenginetest.builder.service.WLTaskOptionServiceUtil;
import com.jenginetest.builder.service.WLTaskServiceUtil;

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
			LoggingActivityLocalServiceUtil.clearService();

			LoggingActivityServiceUtil.clearService();
			WLEntryLocalServiceUtil.clearService();

			WLEntryServiceUtil.clearService();
			WLEventLogLocalServiceUtil.clearService();

			WLEventLogServiceUtil.clearService();
			WLProjectLocalServiceUtil.clearService();

			WLProjectServiceUtil.clearService();
			WLProjectUserLocalServiceUtil.clearService();

			WLProjectUserServiceUtil.clearService();
			WLProjectUserRoleLocalServiceUtil.clearService();

			WLProjectUserRoleServiceUtil.clearService();
			WLTaskLocalServiceUtil.clearService();

			WLTaskServiceUtil.clearService();
			WLTaskOptionLocalServiceUtil.clearService();

			WLTaskOptionServiceUtil.clearService();
		}
	}
}