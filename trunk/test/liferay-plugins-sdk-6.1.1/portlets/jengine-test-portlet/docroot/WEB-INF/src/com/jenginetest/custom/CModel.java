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

package com.jenginetest.custom;

import com.jengine.db.CBaseModel;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;

import java.util.Map;


public class CModel<T extends BaseModel<T>> extends CBaseModel<T> {

    public CModel() throws SystemException, PortalException {
    }

    public CModel(Map<String, Map> serviceContext) throws SystemException, PortalException {
        super(serviceContext);
    }

    public CModel(Map<String, Map> serviceContext, Map values) throws SystemException, PortalException {
        super(serviceContext, values);
    }

    public CModel(Map<String, Map> serviceContext, T object) throws SystemException, PortalException {
        super(serviceContext, object);
    }
}
