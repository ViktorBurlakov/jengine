/*
 *  This file is part of JEngine.
 *  *
 *  * Copyright (C) 2013-2014 Cetus (http://cs1.com.ua/). All rights reserved.
 *  *
 *  * JEngine is free software: you can redistribute it and/or modify
 *  * it under the terms of the GNU General Public License as published by
 *  * the Free Software Foundation, either version 3 of the License, or
 *  * (at your option) any later version.
 *  *
 *  * JEngine is distributed in the hope that it will be useful,
 *  * but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  * GNU General Public License for more details.
 *  *
 *  * You should have received a copy of the GNU General Public License
 *  * along with JEngine.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.jengine.orm.model.field.datetime;

import com.jengine.orm.db.DBException;
import com.jengine.orm.model.Model;
import com.jengine.orm.model.field.Field;
import com.jengine.utils.DateUtil;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


public class BaseDateField extends Field {
    protected DateFormat formatter = null;
    protected String format = null;
    protected Boolean autoNow = false;
    protected Boolean autoNowAdd = false;

    public BaseDateField(BaseDateField field) {
        super(field);
        this.format = field.getFormat();
        this.formatter = new SimpleDateFormat(format);
        this.autoNow = field.getAutoNow();
        this.autoNowAdd = field.getAutoNowAdd();
    }

    public BaseDateField(Class fieldClass, Map<String, Object> options) {
        super(fieldClass, options);
        format = getDefaultFormat();
        if (options.containsKey("format")) {
            this.format = (String) options.get("format");
        }
        if (options.containsKey("autoNow")) {
            this.autoNow = (Boolean) options.get("autoNow");
        }
        if (options.containsKey("autoNowAdd")) {
            this.autoNowAdd = (Boolean) options.get("autoNowAdd");
        }
        this.formatter = new SimpleDateFormat(format);
    }

    public Object getDefaultValue() {
        return autoNow || autoNowAdd ? DateUtil.trimMills(new Date()) : super.getDefaultValue();
    }

    public Object getPersistenceValue(Model obj) throws DBException {
        return autoNow ? new Date() : super.getPersistenceValue(obj);
    }

    public boolean isChanged(Model obj) throws DBException {
        return autoNow ? true : super.isChanged(obj);
    }

    public String getDefaultFormat() {
        return "yyyy-MM-dd";
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
        this.formatter = new SimpleDateFormat(format);
    }

    public Boolean getAutoNow() {
        return autoNow;
    }

    public void setAutoNow(Boolean autoNow) {
        this.autoNow = autoNow;
    }

    public Boolean getAutoNowAdd() {
        return autoNowAdd;
    }

    public void setAutoNowAdd(Boolean autoNowAdd) {
        this.autoNowAdd = autoNowAdd;
    }

    public Date cast(Object value){
        if (Long.class.isInstance(value)) {
            return new Date((Long)value);
        } else if (Timestamp.class.isInstance(value) && fieldClass.equals(Date.class)){
            //TODO: to better with Variant
            return new Date(((Timestamp) value).getTime());
        } else if (String.class.isInstance(value)){
            try {

                return formatter.parse((String) value);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return (Date) value;
    }

    public String format(Object value) {
        return new SimpleDateFormat(format).format(value);
    }
}
