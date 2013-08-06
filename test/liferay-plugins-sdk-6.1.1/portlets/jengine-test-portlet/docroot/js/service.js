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

Liferay.Service.register("Liferay.Service.WL", "com.jenginetest.builder.service", "jengine-test-portlet");

Liferay.Service.registerClass(
	Liferay.Service.WL, "WLProject",
	{
		test: true,
		test1: true,
		test2: true,
		test3: true,
		test4: true
	}
);

Liferay.Service.register("Liferay.Service.S", "com.jenginetest.builder.service", "jengine-test-portlet");

Liferay.Service.register("Liferay.Service.SB", "com.jenginetest.builder.service", "jengine-test-portlet");

Liferay.Service.registerClass(
	Liferay.Service.SB, "Test",
	{
		test: true,
		test1: true,
		test2: true,
		test3: true,
		test4: true
	}
);