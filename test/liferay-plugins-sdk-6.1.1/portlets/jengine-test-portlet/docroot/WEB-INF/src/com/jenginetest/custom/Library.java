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


import com.jengine.db.Manager;
import com.jengine.db.ModelManager;
import com.jengine.db.field.Field;
import com.jengine.db.field.PrimaryKey;
import com.jengine.db.field.StringField;
import com.jenginetest.builder.model.SLibrary;
import com.jenginetest.builder.model.impl.SLibraryImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.io.Serializable;
import java.util.Map;


public class Library extends CModel<SLibrary> {
    public static Field libraryId = new PrimaryKey();
    public static Field name    = new StringField("verbose", "Name");
    public static Field address = new StringField("verbose", "Address");

    @Manager
    public static ModelManager manager = new ModelManager(Library.class, "Library", SLibrary.class, SLibraryImpl.class,
            SLibraryImpl.TABLE_NAME, SLibraryImpl.TABLE_COLUMNS, SLibraryImpl.ENTITY_CACHE_ENABLED);
    static public ClassUtil<Library> cls = new ClassUtil<Library>(Library.class);


    public Library(Serializable id, Map<String, Map> serviceContext) throws SystemException, PortalException {
        super(id, serviceContext);
    }

    public Library(SLibrary library, Map<String, Map> serviceContext) {
        super(library, serviceContext);
    }

    public String getVerbose() throws SystemException, PortalException {
        return String.format("%s", getName());
    }

    /* getters and setters block  */

    public String getAddress() throws SystemException, PortalException {
        return (String) getValue(address);
    }

    public String getName() throws SystemException, PortalException {
        return (String) getValue(name);
    }
}
