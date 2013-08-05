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

package com.jenginetest.builder;

import com.liferay.portal.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchTaskOptionException extends NoSuchModelException {

	public NoSuchTaskOptionException() {
		super();
	}

	public NoSuchTaskOptionException(String msg) {
		super(msg);
	}

	public NoSuchTaskOptionException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchTaskOptionException(Throwable cause) {
		super(cause);
	}

}