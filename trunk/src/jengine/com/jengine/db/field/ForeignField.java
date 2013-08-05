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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ForeignField extends ModelField {
    private ReferenceField reference = null;
    private ModelField field = null;

    public ForeignField(String name, ReferenceField reference, ModelField field) {
        super(name, field.getFieldClass());
        this.reference = reference;
        this.field = field;
    }

    public ForeignField(String name, Class fieldClass, Map<String, Object> options) {
        super(name, fieldClass, options);
    }

    public Object castType(Object value) throws SystemException, PortalException {
        return getField().castType(value);
    }

    public Object castServiceType(Object value) throws SystemException, PortalException {
        return getField().castServiceType(value);
    }

    public String getDbName() {
        return getField().getDbName();
    }

    public ModelField getLastField() {
        return this.field.isForeign() ? ((ForeignField)field).getLastField() : field;
    }

    public List<String> getReferencePath() {
        List<String> path = new ArrayList<String>();
        path.add(reference.getName());
        if (field.isForeign()) {
            path.addAll(((ForeignField) field).getReferencePath());
        } else if (field.isReference()) {
            path.add(field.getName());
        }
        return path;
    }

    public List<String> getPath() {
        return Arrays.asList(getName().split("\\."));
    }

    public ReferenceField getReference() {
        return reference;
    }

    public void setReference(ReferenceField reference) {
        this.reference = reference;
    }

    public ModelField getField() {
        return field;
    }

    public void setField(ModelField field) {
        this.field = field;
    }

    public boolean isForeign() {
        return true;
    }

    public boolean isReference() {
        return this.field.isReference();
    }
}
