package com.github.lvmt.lmtools;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;


/**
 * @author lvmengtian
 * Created on 2021-05-18
 *
 * 时间处理工具类
 */
public class DateTimeTool {

    private static final ZoneOffset SYSTEM_ZONE = OffsetDateTime.now().getOffset();

    /**
     * 时间戳转localDate
     */
    public static LocalDate parseLocalDate(long timestamp) {
        return Instant.ofEpochMilli(timestamp).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * 时间戳转LocalDateTime
     * @param timestamp
     * @return
     */
    public static LocalDateTime parseLocalDateTime(long timestamp) {
        return Instant.ofEpochMilli(timestamp).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * 将字符串格式的日期，转成LocalDate
     * yyyyMMdd格式采用 {@link DateTimeFormatter#BASIC_ISO_DATE}
     * yyyy-MM-dd格式采用 {@link DateTimeFormatter#ISO_LOCAL_DATE}
     * @param date 字符串格式的日志
     * @param formatter 格式
     * @return 对应的LocalDate
     */
    public static LocalDate parseLocalDate(String date, DateTimeFormatter formatter) {
        return LocalDate.parse(date, formatter);
    }

    /**
     * localDate转时间戳
     */
    public static long parseTimestamp(LocalDate localDate) {
        return localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * localDateTime转时间戳
     */
    public static long parseTimestamp(LocalDateTime localDateTime) {
        return localDateTime.toInstant(SYSTEM_ZONE).toEpochMilli();
    }

    /**
     * 字符串形式的日期转时间戳
     */
    public static long parseTimestamp(String date, DateTimeFormatter formatter) {
        return parseTimestamp(parseLocalDate(date, formatter));
    }

    /**
     * 毫秒级时间戳转ISO字符串(yyyy-MM-dd HH:mm:ss)
     */
    public static String millisToISO(long millis) {
        return ISO_LOCAL_DATE_TIME.format(parseLocalDateTime(millis));
    }

    public static String secondsToISO(long seconds) {
        return millisToISO(seconds * 1000L);
    }
}
