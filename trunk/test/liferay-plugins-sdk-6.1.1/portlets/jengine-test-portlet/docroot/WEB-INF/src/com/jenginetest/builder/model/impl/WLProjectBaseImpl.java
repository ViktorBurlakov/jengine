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

package com.jenginetest.builder.model.impl;

import com.jenginetest.builder.model.WLProject;
import com.jenginetest.builder.service.WLProjectLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the WLProject service. Represents a row in the &quot;WL_WLProject&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link WLProjectImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WLProjectImpl
 * @see com.jenginetest.builder.model.WLProject
 * @generated
 */
public abstract class WLProjectBaseImpl extends WLProjectModelImpl
	implements WLProject {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a w l project model instance should use the {@link WLProject} interface instead.
	 */
	public void persist() throws SystemException {
		if (this.isNew()) {
			WLProjectLocalServiceUtil.addWLProject(this);
		}
		else {
			WLProjectLocalServiceUtil.updateWLProject(this);
		}
	}
}