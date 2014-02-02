package com.jengine.orm.model.field.datetime;

import com.jengine.orm.model.Model;
import com.jengine.orm.db.DBException;
import com.jengine.orm.model.field.Field;

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
        return autoNow || autoNowAdd ? new Date() : super.getDefaultValue();
    }

    public Object getPersistenceValue(Model obj) throws DBException {
        return autoNow ? new Date() : super.getPersistenceValue(obj);
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

    public Date cast(Object value){
        if (Long.class.isInstance(value)) {
            return new Date((Long)value);
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
