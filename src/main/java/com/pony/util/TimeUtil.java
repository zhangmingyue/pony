package com.pony.util;

import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/2/17
 */
public class TimeUtil {

    private static final Logger log = LoggerFactory.getLogger(TimeUtil.class);
    private static final long DEFAULT_TIME_MILLIS = 5000000000L;
    public static final long HOURS_PER_DAY = 24L;
    public static final long SECONDS_PER_HOUR = 3600L;
    public static final long MILLIS_PER_SECOND = 1000L;
    public static final long MILLIS_PER_MINUTE = 60000L;
    public static final long MILLIS_PER_HOUR = 3600000L;
    public static final long MILLIONS_PER_DAY = 86400000L;
    public static final long TIME_INTERVAL = 28800000L;
    public static final DateFormat FORMATTER_SECOND = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final DateFormat FORMATTER_MINUTE = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    public static final DateFormat FORMATTER_HOUR = new SimpleDateFormat("yyyy-MM-dd HH");
    public static final DateFormat FORMATTER_DAY = new SimpleDateFormat("yyyy-MM-dd");
    public static final DateFormat FORMATTER_DATE;
    public static final String FORMATTER_SECOND_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMATTER_MINUTE_PATTERN = "yyyy-MM-dd HH:mm";
    public static final String FORMATTER_HOUR_PATTERN = "yyyy-MM-dd HH";
    public static final String FORMATTER_DAY_PATTERN = "yyyy-MM-dd";
    public static final String FORMATTER_DATE_PATTERN = "EEE, dd MMM yyyy HH:mm:ss zzz";
    private static final Object lockObj;
    private static Map<String, ThreadLocal<SimpleDateFormat>> simpleDateFormatMap;

    public TimeUtil() {
    }

    private static SimpleDateFormat getSimpleDateFormat(final String pattern, final Locale local) {
        ThreadLocal threadLocal = (ThreadLocal)simpleDateFormatMap.get(pattern);
        if(threadLocal == null) {
            Object var3 = lockObj;
            synchronized(lockObj) {
                threadLocal = (ThreadLocal)simpleDateFormatMap.get(pattern);
                if(threadLocal == null) {
                    threadLocal = new ThreadLocal() {
                        protected SimpleDateFormat initialValue() {
                            return new SimpleDateFormat(pattern, local);
                        }
                    };
                    simpleDateFormatMap.put(pattern, threadLocal);
                }
            }
        }

        return (SimpleDateFormat)threadLocal.get();
    }

    private static SimpleDateFormat getSimpleDateFormat(String pattern) {
        return getSimpleDateFormat(pattern, Locale.getDefault(Locale.Category.FORMAT));
    }

    public static String format(Date date, String pattern) {
        return date == null?null:getSimpleDateFormat(pattern).format(date);
    }

    public static Date parse(String dateStr, String pattern) throws ParseException {
        return getSimpleDateFormat(pattern).parse(dateStr);
    }

    public static Date autoParseDate(String dateStr) throws ParseException {
        Date result = null;
        if(Strings.isNullOrEmpty(dateStr)) {
            if(dateStr.matches("\\d{4}-\\d{1,2}-\\d{1,2}")) {
                result = parse(dateStr, "yyyy-MM-dd");
            } else if(dateStr.matches("\\d{4}-\\d{1,2}-\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}")) {
                result = parse(dateStr, "yyyy-MM-dd HH:mm:ss");
            }
        }

        return result;
    }

    public static String getTodayBeginTime() {
        return getTodayBeginTime("yyyy-MM-dd HH:mm:ss");
    }

    public static String getTodayBeginTime(String formatterPattern) {
        long currentTimeInMs = System.currentTimeMillis();
        Date date = new Date((currentTimeInMs + 28800000L) / 86400000L * 86400000L - 28800000L);
        return getSimpleDateFormat(formatterPattern).format(date);
    }

    public static String getPreviousDayBeginTime(int n) {
        return getPreviousDayBeginTime(n, "yyyy-MM-dd HH:mm:ss");
    }

    public static String getPreviousDayBeginTime(int n, String formatterPattern) {
        Date date = new Date(getPreviousDayBeginTimeInTimeMillis(n));
        return getSimpleDateFormat(formatterPattern).format(date);
    }

    public static long getPreviousDayBeginTimeInTimeMillis(int n) {
        long currentTimeInMs = System.currentTimeMillis();
        return ((currentTimeInMs + 28800000L) / 86400000L + (long)n) * 86400000L - 28800000L;
    }

    public static String getWeekBeginDate(int index) {
        Calendar calendar = Calendar.getInstance();
        int dayInWeek = calendar.get(7) - 1;
        String weekBeginDate = getPreviousDayBeginTime(index * 7 - (dayInWeek - 1), "yyyy-MM-dd");
        return weekBeginDate;
    }

    public static String getPreviousMinuteInDate(int n) {
        Date date = new Date(System.currentTimeMillis() + (long)n * 60000L);
        String dateInFormatter = getSimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);

        try {
            Date e = getSimpleDateFormat("yyyy-MM-dd HH:mm").parse(dateInFormatter);
            return getSimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(e);
        } catch (Exception var4) {
            log.error("parse datetime failed. the dateTime = {}.", dateInFormatter);
            return dateInFormatter;
        }
    }

    public static String getPreviousMinuteInDate(String time, int n) {
        Date date = new Date(parseDatetime(time) + (long)n * 60000L);
        String dateInFormatter = getSimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);

        try {
            Date e = getSimpleDateFormat("yyyy-MM-dd HH:mm").parse(dateInFormatter);
            return getSimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(e);
        } catch (Exception var5) {
            log.error("parse datetime failed. the dateTime = {}.", dateInFormatter);
            return dateInFormatter;
        }
    }

    public static String getCurrentTime() {
        return getCurrentTime("yyyy-MM-dd HH:mm:ss");
    }

    public static String getCurrentTime(String pattern) {
        return parseTime(System.currentTimeMillis(), pattern);
    }

    public static String parseTime(long time) {
        return parseTime(time, "yyyy-MM-dd HH:mm:ss");
    }

    public static String parseTime(long time, String pattern) {
        if(time < 5000000000L) {
            time *= 1000L;
        }

        Date date = new Date(time);
        return getSimpleDateFormat(pattern).format(date);
    }

    public static long parseDatetime(String datetime) {
        if(!datetime.contains(":")) {
            datetime = datetime + " 00:00:00";
        }

        return parseDatetime(datetime, "yyyy-MM-dd HH:mm:ss");
    }

    public static long parseDatetime(String datetime, String pattern) {
        try {
            return getSimpleDateFormat(pattern).parse(datetime).getTime();
        } catch (ParseException var3) {
            log.error("parse datetime failed. the dateTime = {}.", datetime);
            return System.currentTimeMillis();
        }
    }

    public static long belongToPeriod(long time) {
        return belongToPeriod(time, 60000L);
    }

    public static long belongToPeriod(long time, long timeInMillis) {
        long period = time / timeInMillis * timeInMillis;
        return period;
    }

    public static int belongToHour(long time) {
        if(time < 5000000000L) {
            time *= 1000L;
        }

        Calendar calendar = Calendar.getInstance();
        Date date = new Date(time);
        calendar.setTime(date);
        return calendar.get(11);
    }

    public static long hourStartTimeInMillis(long time) {
        return time / 3600000L * 3600000L;
    }

    public static final long belongToDay(long time) {
        long day;
        if(time < 5000000000L) {
            day = (time * 1000L + 28800000L) / 86400000L * 86400000L - 28800000L;
        } else {
            day = (time + 28800000L) / 86400000L * 86400000L - 28800000L;
        }

        return day;
    }

    public static String belongToMinuteInDate(String time) {
        try {
            Date e = getSimpleDateFormat("yyyy-MM-dd HH:mm").parse(time);
            return getSimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(e);
        } catch (ParseException var2) {
            log.error("parse datetime failed. the dateTime = {}.", time);
            return time;
        }
    }

    public static synchronized String belongToDay(String time) {
        try {
            Date e = parse(time, "yyyy-MM-dd");
            return getSimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(e);
        } catch (Exception var2) {
            log.error("parse datetime failed. the dateTime = {}.", time);
            return null;
        }
    }

    public static final long belongToDayTruncated(long time) {
        long day = time / 86400000L * 86400000L;
        return day;
    }

    public static long dateToTimeInMs(String date) {
        long millionSeconds = 0L;

        try {
            if(isValidDate(date)) {
                millionSeconds = getSimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date).getTime();
            }
        } catch (Exception var4) {
            log.error("Can not parse the date = {}. The correct pattern is \'yyyy-MM-dd HH:mm:ss\'", date);
        }

        return millionSeconds;
    }

    public static boolean isValidDate(String time) {
        try {
            Date e = parse(time, "yyyy-MM-dd HH:mm:ss");
            return format(e, "yyyy-MM-dd HH:mm:ss").equals(time);
        } catch (Exception var2) {
            return false;
        }
    }

    public static String dayFormat(long timeInMs) {
        Date date = new Date(timeInMs);
        return getSimpleDateFormat("yyyy-MM-dd").format(date);
    }

    public static String getCurrentDateTime() {
        Date date = new Date();
        SimpleDateFormat dateFormat = getSimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.ENGLISH);
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return dateFormat.format(date);
    }

    public static final long getMILLIS_PER_DAY() {
        return 86400000L;
    }

    public static final boolean equals(String firstDate, String secondDate) throws ParseException {
        return equals(firstDate, secondDate, "yyyy-MM-dd HH:mm:ss");
    }

    public static final boolean equals(String firstDate, String secondDate, String pattern) throws ParseException {
        return equals(firstDate, pattern, secondDate, pattern);
    }

    public static final boolean equals(String firstDate, String firstPattern, String secondDate, String secondPattern) throws ParseException {
        int result = compare(firstDate, firstPattern, secondDate, secondPattern);
        return result == 0;
    }

    public static final int compare(String firstDate, String secondDate) throws ParseException {
        return compare(firstDate, secondDate, "yyyy-MM-dd HH:mm:ss");
    }

    public static final int compare(String firstDate, String secondDate, String pattern) throws ParseException {
        return compare(firstDate, pattern, secondDate, pattern);
    }

    public static final int compare(String firstDate, String firstPattern, String secondDate, String secondPattern) throws ParseException {
        Calendar firstCalendar = Calendar.getInstance();
        Calendar secondCalendar = Calendar.getInstance();
        firstCalendar.setTime(parse(firstDate, firstPattern));
        secondCalendar.setTime(parse(secondDate, secondPattern));
        return firstCalendar.compareTo(secondCalendar);
    }

    public static final String formatConvert(String dateString, String afterPattern) throws ParseException {
        return formatConvert(dateString, "yyyy-MM-dd HH:mm:ss", afterPattern);
    }

    public static final String formatConvert(String dateString, String beforePattern, String afterPattern) throws ParseException {
        Date date = parse(dateString, beforePattern);
        return format(date, afterPattern);
    }

    public static final Date addYear(Date inputDate, int amount) {
        if(inputDate == null) {
            return null;
        } else {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(inputDate);
            calendar.add(1, amount);
            return calendar.getTime();
        }
    }

    public static final Date addMonth(Date inputDate, int amount) {
        if(inputDate == null) {
            return null;
        } else {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(inputDate);
            calendar.add(2, amount);
            return calendar.getTime();
        }
    }

    public static final Date addDay(Date inputDate, int amount) {
        if(inputDate == null) {
            return null;
        } else {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(inputDate);
            calendar.add(5, amount);
            return calendar.getTime();
        }
    }

    public static final Date addHour(Date inputDate, int amount) {
        if(inputDate == null) {
            return null;
        } else {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(inputDate);
            calendar.add(10, amount);
            return calendar.getTime();
        }
    }

    public static final Date addMinute(Date inputDate, int amount) {
        if(inputDate == null) {
            return null;
        } else {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(inputDate);
            calendar.add(12, amount);
            return calendar.getTime();
        }
    }

    public static final Date addSecond(Date inputDate, int amount) {
        if(inputDate == null) {
            return null;
        } else {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(inputDate);
            calendar.add(13, amount);
            return calendar.getTime();
        }
    }

    public static final Date addMillisecond(Date inputDate, int amount) {
        if(inputDate == null) {
            return null;
        } else {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(inputDate);
            calendar.add(14, amount);
            return calendar.getTime();
        }
    }

    public Date createDate(int inputYear, int inputMonth, int inputDay) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(inputYear, inputMonth, inputDay);
        return calendar.getTime();
    }

    public Date createDate(int inputYear, int inputMonth, int inputDay, int inputHour, int inputMinute, int inputSecond) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(inputYear, inputMonth, inputDay, inputHour, inputMinute, inputSecond);
        return calendar.getTime();
    }

    public Date createDate(int inputYear, int inputMonth, int inputDay, int inputHour, int inputMinute, int inputSecond, int inputMillisecond) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(inputYear, inputMonth, inputDay, inputHour, inputMinute, inputSecond);
        calendar.set(14, inputMillisecond);
        return calendar.getTime();
    }

    public static void main(String[] args) {
        try {
            Date e = parse("2016-03-15 12:12:12", "yyyy-MM-dd HH:mm:ss");
            Date addDay = addDay(e, -20);
            System.out.println("--->" + format(addDay, "yyyy-MM-dd HH:mm:ss"));
        } catch (ParseException var3) {
            var3.printStackTrace();
        }

    }

    static {
        FORMATTER_DATE = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.ENGLISH);
        lockObj = new Object();
        simpleDateFormatMap = new HashMap();
    }
}
