package com.jengine.orm.field;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: victor
 * Date: 1/1/14
 * Time: 12:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class BaseDateField extends Field {
    protected DateFormat formatter = null;
    protected String format = "yyyy-MM-dd"; // ISO date format
    protected Boolean autoNow = false;

    public BaseDateField(Map<String, Object> options) {
        super(Date.class, options);
        if (options.containsKey("format")) {
            this.format = (String) options.get("format");
        }
        if (options.containsKey("autoNow")) {
            this.autoNow = (Boolean) options.get("autoNow");
        }
        this.formatter = new SimpleDateFormat(format);
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
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
