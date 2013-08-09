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

package com.jengine.db.field;


import com.jengine.db.CustomBaseModel;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.Map;

import static com.jengine.utils.CollectionUtil.map;

public class ReferenceField extends Field {
    protected String referenceFieldDbName;
    protected String referenceFieldServiceName;
    protected Class fieldClassImpl;

    public ReferenceField(Class fieldClass) {
        super(fieldClass);
    }

    public ReferenceField(Class fieldClass, Object... options) {
        super(fieldClass, map(options));
    }

    public ReferenceField(Class fieldClass, Map<String, Object> options) {
        super(fieldClass, options);
    }

    public ReferenceField(String name, Class fieldClass, Map<String, Object> options) {
        super(name, fieldClass, options);
    }

    public void init() {
        super.init();
        if (!options.containsKey("dbName")) {
            this.dbName = String.format("%sId", name);
            this.referenceFieldDbName = this.dbName;
        }
        if (!options.containsKey("serviceName")) {
            this.serviceName = String.format("%sId", name);
            this.referenceFieldServiceName = this.serviceName;
        }
    }

    public boolean isReference() {
        return true;
    }

    public Class getFieldClassImpl() {
        return fieldClassImpl;
    }

    public void setFieldClassImpl(Class fieldClassImpl) {
        this.fieldClassImpl = fieldClassImpl;
    }

    public Object castType(Object value) {
        return value instanceof CustomBaseModel ? value : new Long(String.valueOf(value));
    }

    public Object castServiceType(Object value) throws SystemException, PortalException {
        Object value2 = castType(value);
        return Long.class.equals(value2.getClass()) ? value2 : (Long) ((CustomBaseModel) value2).getPrimaryKey();
    }

    public String format(Object value) throws SystemException, PortalException {
        return ((CustomBaseModel)value).getVerbose();
    }

    public String getReferenceFieldDbName() {
        return referenceFieldDbName;
    }

    public void setReferenceFieldDbName(String referenceFieldDbName) {
        this.referenceFieldDbName = referenceFieldDbName;
    }

    public String getReferenceFieldServiceName() {
        return referenceFieldServiceName;
    }

    public void setReferenceFieldServiceName(String referenceFieldServiceName) {
        this.referenceFieldServiceName = referenceFieldServiceName;
    }
}
