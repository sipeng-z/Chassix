package com.utils;

import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;


public final class DateTimeUtils {


    public static final String YEAR = "yyyy";


    public static final String YEAR_MONTH = "yyyy-MM";


    public static final String YEAR_MONTH_DAY = "yyyy-MM-dd";


    public static final String YEAR_MONTH_DAY_SIMPLE = "yyyyMMdd";


    public static final String YEAR_MONTH_DAY_HOUR = "yyyy-MM-dd HH";


    public static final String YEAR_MONTH_DAY_HOUR_MINUTE = "yyyy-MM-dd HH:mm";


    public static final String YEAR_MONTH_DAY_HOUR_MINUTE_SECOND = "yyyy-MM-dd HH:mm:ss";


    public static final String YEAR_MONTH_DAY_HOUR_MINUTE_SECOND_SIMPLE = "yyyyMMddHHmmss";


    public static final String HOUR_MINUTE_SECOND = "HH:mm:ss";


    public static final String HOUR_MINUTE = "HH:mm";


    public static final String MONTH_DAY = "M.d";


    private static final int DAY_SECOND = 24 * 60 * 60;


    private static final int HOUR_SECOND = 60 * 60;


    private static final int MINUTE_SECOND = 60;


  /*  public static String format(Date date, String pattern) {
        if (date == null)
            return "";
        return new DateTime(date).toString(pattern);
    }


    public static Date formatDateString(String dateString, String pattern) {
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(pattern);
            return dateTimeFormatter.parseDateTime(dateString).toDate();
        } catch (Exception e) {
            return null;
        }
    }*/


}
