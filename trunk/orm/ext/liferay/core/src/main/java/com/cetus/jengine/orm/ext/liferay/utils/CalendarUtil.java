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

package com.cetus.jengine.orm.ext.liferay.utils;

import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

import java.text.*;
import java.util.*;


public class CalendarUtil {

    public static final DateFormat YEAR_FORMAT = new SimpleDateFormat("yyyy");
    public static final DateFormat MONTH_YEAR_FORMAT = new SimpleDateFormat("MMMM/yyyy");
    public static final DateFormat WEEK_YEAR_FORMAT = new SimpleDateFormat("ww/yyyy");
    public static final DateFormat DAY_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    public static final String SIMPLE_DATE_FORMAT = "yyyy-MM-dd";
    public static final String SIMPLE_DATETIME_FORMAT = "yyyy-MM-dd/HH:mm:ss";
    public static final DateFormat SIMPLE_DATE_FORMATTER = new SimpleDateFormat(SIMPLE_DATE_FORMAT);
    public static final DateFormat SIMPLE_DATETIME_FORMATTER = new SimpleDateFormat(SIMPLE_DATETIME_FORMAT);

    public static final DateFormat QUARTER_FORMAT = new DateFormat() {

        @Override
        public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int month = calendar.get(Calendar.MONTH);
            String q1 = "1 quarter";
            String q2 = "2 quarter";
            String q3 = "3 quarter";
            String q4 = "4 quarter";
            switch(month) {
                case Calendar.JANUARY: toAppendTo.append(q1); break;
                case Calendar.FEBRUARY: toAppendTo.append(q1); break;
                case Calendar.MARCH: toAppendTo.append(q1); break;
                case Calendar.APRIL: toAppendTo.append(q2); break;
                case Calendar.MAY: toAppendTo.append(q2); break;
                case Calendar.JUNE: toAppendTo.append(q2); break;
                case Calendar.JULY: toAppendTo.append(q3); break;
                case Calendar.AUGUST: toAppendTo.append(q3); break;
                case Calendar.SEPTEMBER: toAppendTo.append(q3); break;
                case Calendar.OCTOBER: toAppendTo.append(q4); break;
                case Calendar.NOVEMBER: toAppendTo.append(q4); break;
                case Calendar.DECEMBER: toAppendTo.append(q4); break;
            }
            return toAppendTo;
        }

        @Override
        public Date parse(String source, ParsePosition pos) {

            return null;
        }
    };

    private static int dailyTaskDeadlineInSeconds = 0;
    private static final int dayLengthInSeconds = 86399;

    private static final int defaultDailyTaskDeadlineInSeconds = 72000;

    private static final int MINUTE_IN_MILLIS = 60000;

    private static final long DAY_IN_MILLIS = java.util.concurrent.TimeUnit.HOURS.toMillis(24);

    private static Date moveToSummerTime;

    private static Date moveToWinterTime;

    public static final String TODAY_NAME_KEY = "today.label";

    public static final String[] WEEK_DAY_NAME_KEYS = { "sunday.label", "monday.label", "tuesday.label",
            "wednesday.label", "thursday.label", "friday.label", "saturday.label" };
    public static final String YESTERDAY_NAME_KEY = "yesterday.label";

    public static final long HOUR_IN_MILLIS = java.util.concurrent.TimeUnit.HOURS.toMillis(1);

    static {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 28);
        cal.set(Calendar.MONTH, 9);// october
        cal.set(Calendar.YEAR, new Date().getYear() + 1900);
        cal.set(Calendar.HOUR_OF_DAY, 4);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        moveToWinterTime = new Date(cal.getTimeInMillis());
        cal.set(Calendar.DAY_OF_MONTH, 25);
        cal.set(Calendar.MONTH, 2);// march
        cal.set(Calendar.HOUR_OF_DAY, 3);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        moveToSummerTime = new Date(cal.getTimeInMillis());
    }

    public static long toMinutes(long millis)  {
        return millis / 60000;
    }

    public static String formatDate(Date date, String formatString) {
        SimpleDateFormat format = new SimpleDateFormat(formatString);
        return format.format(date);
    }

    /**
     * Format date according with format string : dd/MM/yyyy
     * 
     * @param date
     * @return
     */
    public static String formatDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.format(date);
    }

    /**
     * Format hours as number with fraction.
     * 
     * @param hours
     * @return
     */
    public static String formatHoursNumber(double hours) {
        DecimalFormat numberFormat = new DecimalFormat("#########0.##");
        return numberFormat.format(hours);
    }

    /**
     * Format date as dd.MM.yyyy
     * 
     * @param date
     * @return
     */
    public static String formatShortDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return dateFormat.format(date);
    }

    /**
     * Format date in short time string: hh:mm
     * 
     * @param date
     * @return
     */
    public static String formatShortTime(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        return format.format(date);
    }

    /**
     * Format date in short time string: hh:mm
     * 
     * @param //date
     * @return
     */
    public static String formatShortTime(int timeInMinutes) {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        return format.format(new Date(timeInMinutes * MINUTE_IN_MILLIS));
    }

/*    public static Date[] getCurrentMonthRange() {
        Calendar today = Calendar.getInstance();

        Date[] result = new Date[2];

        result[1] = today.getTime();

        today.set(today.get(Calendar.YEAR), today.get(Calendar.MONTH), 1);

        result[0] = today.getTime();

        return result;
    }*/

    public static Date[] getCurrentDateRange() {
        Date now = new Date();
        return  new Date[] { getGTDate(now), getLTDate(now)};
    }

    public static Date[] getCurrentMonthRange() {
        int date = Calendar.getInstance().get(Calendar.YEAR);
        int month = Calendar.getInstance().get(Calendar.MONTH);

        return getMonthRange(date, month);
    }

    public static Date[] getCurrentYearRange() {
        return getYearRange(Calendar.getInstance().get(Calendar.YEAR));
    }

    public static Date[] getYearRange(int year) {
        Date[] result = new Date[2];
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        result[0] = calendar.getTime();
        calendar.set(Calendar.MONTH, 11);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        result[1] = calendar.getTime();

        return result;
    }

    public static Date[] getMonthRange(int year, int month) {
        Date[] result = new Date[2];
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        result[0] = calendar.getTime();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        result[1] = calendar.getTime();

        return result;
    }

    public static Date[] getCurrentWeekRange() {
        Calendar today = Calendar.getInstance();

        Date[] result = new Date[2];

        result[1] = today.getTime();

        today.add(Calendar.DAY_OF_MONTH, Calendar.MONDAY - today.get(Calendar.DAY_OF_WEEK));

        result[0] = today.getTime();

        return result;
    }

    /**
     * Get time range for one day: from 0 am till 12pm.
     * 
     * @param time
     * @return
     */
    public static Date[] getDayRange(long time) {
        Calendar today = Calendar.getInstance();
        Date[] result = new Date[2];
        today.setTimeInMillis(time);
        // 00:00
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        result[0] = today.getTime();
        // 24:00
        today.set(Calendar.HOUR_OF_DAY, 23);
        today.set(Calendar.MINUTE, 59);
        today.set(Calendar.SECOND, 59);
        result[1] = today.getTime();
        return result;
    }

    public static long getDurationInMunites(Date begin, Date end) {
        long mSeconds = Math.abs(end.getTime() - begin.getTime());
        long minutes = Math.round(mSeconds / 60000.0);

        return minutes;
    }

    public static long getSeconds(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.SECOND) + c.get(Calendar.MINUTE) * 60 + c.get(Calendar.HOUR_OF_DAY) * 3600;
    }

    public static Date getGTDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        return com.liferay.portal.kernel.util.CalendarUtil.getGTDate(cal);
    }

    public static String formatTime(long minutes) {
        long hours = minutes / 60;
        long rest_minutes = minutes % 60;
        return String.format("%d:%02d", hours, rest_minutes);
    }

    public static double toHours(long minutes) {
        return (double) (minutes/ 60.0);
    }

    public static int getHours(long length) {
        return (int) (length / 60);
    }

    public static Date[] getLastMonthRange() {
        Calendar today = Calendar.getInstance();

        Date[] result = new Date[2];

        today.add(Calendar.MONTH, -1);

        today.set(today.get(Calendar.YEAR), today.get(Calendar.MONTH), 1);

        result[0] = today.getTime();

        today.add(Calendar.DATE, today.getActualMaximum(Calendar.DAY_OF_MONTH) - 1);

        result[1] = today.getTime();

        return result;
    }

    public static Date[] getLastWeekRange() {
        Calendar today = Calendar.getInstance();

        Date[] result = new Date[2];

        today.add(Calendar.DAY_OF_MONTH, -7);

        today.add(Calendar.DAY_OF_MONTH, Calendar.MONDAY - today.get(Calendar.DAY_OF_WEEK));

        result[0] = today.getTime();

        today.add(Calendar.DAY_OF_MONTH, 4);

        result[1] = today.getTime();

        return result;
    }

    public static Date getLTDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        return com.liferay.portal.kernel.util.CalendarUtil.getLTDate(cal);
    }

    public static int getMinutes(long length) {
        return (int) (length % 60);
    }

    /**
     * Get first and last day of given month
     * 
     * @param currentDate
     * @return
     */
    public static Date[] getMonthRange(Date currentDate) {
        Calendar cal = Calendar.getInstance();
        cal.setLenient(true);// set up soft mode
        cal.setTime(currentDate);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        Date start = cal.getTime();
        cal.set(Calendar.DAY_OF_MONTH, 28);
        Date end = null;
        while (true) {
            end = cal.getTime();
            if (start.getMonth() != end.getMonth()) {
                cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) - 1);
                cal.set(Calendar.HOUR_OF_DAY, 23);
                cal.set(Calendar.MINUTE, 59);
                cal.set(Calendar.SECOND, 59);
                end = cal.getTime();
                break;
            }
            cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + 1);
        }
        return new Date[] { start, end };
    }

    /**
     * Get week range relate to current week.
     * 
     * @param offset
     * @return
     */
    public static Date[] getWeekRange(int offset, long startFrom) {
        Calendar today = Calendar.getInstance();
        today.setTimeInMillis(startFrom);
        Date[] result = new Date[2];
        int daysFromMonday = -1;
        if (today.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            daysFromMonday = 6;
        } else {
            daysFromMonday = today.get(Calendar.DAY_OF_WEEK) - 2;
        }
        // monday
        today.add(Calendar.DAY_OF_MONTH, -daysFromMonday);
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 1);
        result[0] = new Date(today.getTimeInMillis() + java.util.concurrent.TimeUnit.DAYS.toMillis(7) * offset);
        // sunday
        today.add(Calendar.DAY_OF_MONTH, 6);
        today.set(Calendar.HOUR_OF_DAY, 23);
        today.set(Calendar.MINUTE, 59);
        today.set(Calendar.SECOND, 59);
        result[1] = new Date(today.getTimeInMillis() + java.util.concurrent.TimeUnit.DAYS.toMillis(7) * offset);
        return result;
    }

    public static boolean isSameDay(Date date1, Date date2) {

        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(date1);
        cal2.setTime(date2);

        Date dateGT1 = com.liferay.portal.kernel.util.CalendarUtil.getGTDate(cal1);
        Date dateGT2 = com.liferay.portal.kernel.util.CalendarUtil.getGTDate(cal2);

        return dateGT1.getTime() == dateGT2.getTime();
    }

    public static boolean isSummerTime(long time) {
        Date date = new Date(time);
        synchronized (moveToWinterTime) {
            synchronized (moveToSummerTime) {
                moveToWinterTime.setYear(date.getYear());
                moveToSummerTime.setYear(date.getYear());
                return date.after(moveToSummerTime) && date.before(moveToWinterTime);
            }
        }
    }

    public static boolean isTime(String timeString) {
        if (timeString == null || StringPool.BLANK.equals(timeString.trim())) {
            return false;
        }

        timeString = timeString.trim();

        if (timeString.length() > 2 && timeString.indexOf(StringPool.COLON) == 0) {
            return false;
        }

        String[] timeParts = timeString.split(StringPool.COLON);

        if (timeParts.length > 3) {
            return false;
        }

        for (int i = 0; i < timeParts.length; i++) {
            String timePart = timeParts[i];
            if (!Validator.isDigit(timePart)) {
                return false;
            }
            int partValue = Integer.valueOf(timePart);
            if (partValue > (i == 0 ? 23 : 59)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isWeekend(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        return dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY;
    }

    public static boolean isWinterTime(long time) {
        Date date = new Date(time);
        synchronized (moveToWinterTime) {
            synchronized (moveToSummerTime) {
                moveToWinterTime.setYear(date.getYear() - 1);
                moveToSummerTime.setYear(date.getYear());
                return date.after(moveToWinterTime) && date.before(moveToSummerTime);
            }
        }

    }

    public static int toSeconds(String time) {
        if (!isTime(time)) {
            return -1;
        }

        int result = 0;

        String[] timeParts = time.split(StringPool.COLON);

        for (int i = 0; i < timeParts.length; i++) {
            int partValue = Integer.valueOf(timeParts[i]);
            result += partValue * (i == 0 ? 3600 : i == 1 ? 60 : 1);
        }

        return result;
    }

    /**
     * Convert excel date to java date
     * 
     * @param val
     * @return
     */
    public static Date convertFromExcelDate(Double val) {
        int days = val.intValue();
        Calendar cal = Calendar.getInstance();
        cal.setLenient(true);
        cal.set(Calendar.YEAR, 1900);// ms starts epoch from 01.01.1900
        cal.set(Calendar.MONTH, 0);
        cal.set(Calendar.DAY_OF_YEAR, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.add(Calendar.DAY_OF_MONTH, days - 2);// subtract 1 for fixing
                                                 // leap year and 1 is epoch
                                                 // start.
        double fraction = val - days;// time!
        long millis = (long) (fraction * DAY_IN_MILLIS);
        cal.add(Calendar.MILLISECOND, (int) millis);
        return new Date(cal.getTimeInMillis());
    }

    /**
     * Get excel week day
     * 
     * @param date
     * @param mode
     *            -look at
     *            http://www.techonthenet.com/excel/formulas/weekday.php
     * @return
     */
    public static int getExcelWeekDay(Date date, int mode) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if (mode == 2) {
            // 1 - Monday, 7 - Sunday
            final int shift_pos[] = new int[] { 0, 7, 1, 2, 3, 4, 5, 6 };
            return shift_pos[cal.get(Calendar.DAY_OF_WEEK)];
        }
        if (mode == 3) {
            // 0 - Monday, 6 -Sunday
            final int shift_pos[] = new int[] { 0, 6, 0, 1, 2, 3, 4, 5 };
            return shift_pos[cal.get(Calendar.DAY_OF_WEEK)];
        }
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    private CalendarUtil() {
    }

    public static List<Date> getDays(Date from, Date to) {
        List<Date> dates = new ArrayList<Date>();
        List<Date> result = new ArrayList<Date>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(from);

        while (calendar.getTime().before(to))
        {
            result.add(calendar.getTime());
            calendar.add(Calendar.DATE, 1);
        }

        return dates;
    }
}
