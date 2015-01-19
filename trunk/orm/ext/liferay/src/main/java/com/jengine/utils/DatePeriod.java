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

package com.jengine.utils;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatePeriod {
    public enum PERIOD_TYPE {
        TOTAL, YEAR, QUARTER, MONTH, WEEK, DAY, MANUAL;
    }
    public static final String REQUEST_PARAMETER_DATE_FORMAT = "yyyy-MM-dd";
    public static final DateFormat PARAMETER_DATE_FORMAT = new SimpleDateFormat(REQUEST_PARAMETER_DATE_FORMAT);

    private Date dateFrom = null;
    private Date dateTo = null;
    private PERIOD_TYPE periodType = null;

    public DatePeriod(String dateFrom, String dateTo, String periodType) {
        Date d1 = null;
        Date d2 = null;
        try {
            d1 = PARAMETER_DATE_FORMAT.parse(dateFrom);
        } catch (Exception e) {
        }
        try {
            d2 = PARAMETER_DATE_FORMAT.parse(dateTo);
        } catch (Exception e) {
        }
        this.init(d1, d2, periodType);
    }

    public DatePeriod(Date dateFrom, Date dateTo, String periodType) {
        this.init(dateFrom, dateTo, periodType);
    }

    public void init(Date dateFrom, Date dateTo, String periodType) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.periodType = periodType != null ? PERIOD_TYPE.valueOf(periodType.toUpperCase()) : PERIOD_TYPE.MONTH;
        /*if (this.periodType.equals(DatePeriod.PERIOD_TYPE.TOTAL)) {
            Date[] range = CalendarUtil.getCurrentMonthRange();
            this.dateFrom = range[0];
            this.dateTo = range[1];
        }*/
    }

    public Date[] getRange() {
        return new Date[] {dateFrom, dateTo};
    }

    public String format() {
        switch (periodType) {
            case TOTAL: return "Total";
            case YEAR: return CalendarUtil.YEAR_FORMAT.format(dateFrom);
            case QUARTER: return CalendarUtil.QUARTER_FORMAT.format(dateFrom) + " " + CalendarUtil.YEAR_FORMAT.format(dateFrom);
            case MONTH: return CalendarUtil.MONTH_YEAR_FORMAT.format(dateFrom);
            case WEEK: return CalendarUtil.WEEK_YEAR_FORMAT.format(dateFrom);
            case DAY : return CalendarUtil.DAY_FORMAT.format(dateFrom);
            case MANUAL: return CalendarUtil.DAY_FORMAT.format(dateFrom) + " - " + CalendarUtil.DAY_FORMAT.format(dateFrom);
        }
        return "";
    }

    protected Date[] getCurrentPeriodRange() {
        switch (periodType) {
            case TOTAL: return null;
            case YEAR: return CalendarUtil.getCurrentYearRange();
            case QUARTER: return CalendarUtil.getCurrentMonthRange();
            case MONTH: return CalendarUtil.getCurrentMonthRange();
            case WEEK: return CalendarUtil.getCurrentWeekRange();
            case DAY : return CalendarUtil.getCurrentDateRange();
            case MANUAL: return new Date[] {dateFrom, dateTo};
        }
        return null;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public PERIOD_TYPE getPeriodType() {
        return periodType;
    }
}
