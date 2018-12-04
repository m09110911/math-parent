package com.math.common.tools.date;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * <pre>
 *  时间辅助类
 *  LocalDate ,LocalDateTime,LocalTime, Date 之间的互转
 * </pre>
 */
public class DateFormatAndUtils {

    public final static String DEFAULT_FOMAT_TIMS = "yyyy-MM-dd HH:mm:ss";

    public final static String DEFAULT_FOMAT_DAY = "yyyy-MM-dd";


    /**
     * LocalDate -> Date
     *
     * @param localDate
     * @return java.util.Date
     */
    public static Date of(LocalDate localDate) {
        return of(localDate.atStartOfDay());
    }

    /**
     * LocalDateTime -> Date
     *
     * @param localDateTime
     * @return java.util.Date
     */
    public static Date of(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * LocalTime -> Date
     *
     * @param localTime
     * @return java.util.Date
     */
    public static Date of(LocalTime localTime) {
        return of(LocalDateTime.of(LocalDate.now(), localTime));
    }

    /**
     * Date -> LocalDateTime
     *
     * @param date
     * @return LocalDateTime
     */
    public static LocalDateTime parse(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * @param dateStr 时间字符串 2017-04-18
     * @param pattern 字符串格式 如 yyyy-MM-dd
     * @return LocalDateTime
     */
    public static LocalDateTime parse(String dateStr, String pattern) {
        return parse(parseToDate(dateStr, pattern));
    }

    /**
     * Date -> LocalTime
     *
     * @param date
     * @return LocalTime
     */
    public static LocalTime parseToLocalTime(Date date) {
        return parse(date).toLocalTime();
    }

    /**
     * @param dateStr 时间字符串 2017-04-18
     * @param pattern 字符串格式 如 yyyy-MM-dd
     * @return LocalTime
     */
    public static LocalTime parseToLocalTime(String dateStr, String pattern) {
        return parseToLocalTime(parseToDate(dateStr, pattern));
    }

    /**
     * Date -> LocalDate
     *
     * @param date
     * @return LocalDate
     */
    public static LocalDate parseToLocalDate(Date date) {
        return parse(date).toLocalDate();
    }

    /**
     * @param dateStr 时间字符串 2017-04-18
     * @param pattern 字符串格式 如 yyyy-MM-dd
     * @return LocalDate
     */
    public static LocalDate parseToLocalDate(String dateStr, String pattern) {
        return parseToLocalDate(parseToDate(dateStr, pattern));
    }

    /**
     * @param dateStr 时间字符串 2017-04-18
     * @param pattern 字符串格式 如 yyyy-MM-dd
     * @return Date
     */
    public static Date parseToDate(String dateStr, String pattern) {
        Date date = null;
        try {
            date = new SimpleDateFormat(pattern).parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException("时间格式化错误 字符串[" + dateStr + "],格式{" + pattern + "}");
        }
        return date;
    }

    /**
     * 时间转字符串(格式化)
     *
     * @param localDateTime
     * @param pattern       格式化 样式 如 yyyy-MM-dd
     * @return String
     */
    public static String format(LocalDateTime localDateTime, String pattern) {
        return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 时间转字符串(格式化)
     *
     * @param localTime
     * @param pattern   格式化 样式 如 yyyy-MM-dd
     * @return String
     */
    public static String format(LocalTime localTime, String pattern) {
        return format(LocalDateTime.of(LocalDate.now(), localTime), pattern);
    }

    /**
     * 时间转字符串(格式化)
     *
     * @param localDate
     * @param pattern   格式化 样式 如 yyyy-MM-dd
     * @return String
     */
    public static String format(LocalDate localDate, String pattern) {
        return format(LocalDateTime.of(localDate, LocalTime.now()), pattern);
    }

    /**
     * 时间转字符串(格式化)
     *
     * @param pattern 格式化 样式 如 yyyy-MM-dd
     * @return String
     */
    public static String format(Date date, String pattern) {
        return format(parse(date), pattern);
    }

}
