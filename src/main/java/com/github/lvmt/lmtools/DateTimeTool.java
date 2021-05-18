package com.github.lvmt.lmtools;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;


/**
 * @author lvmengtian
 * Created on 2021-05-18
 *
 * 时间处理工具类
 */
public class DateTimeTool {

    private static final ZoneOffset SYSTEM_ZONE = OffsetDateTime.now().getOffset();

    /** LocalDateTime转时间戳 */
    public Long toTimestamp(LocalDateTime localDateTime) {
        return localDateTime.toInstant(SYSTEM_ZONE).toEpochMilli();
    }

    /** LocalDate转时间戳 */
    public Long toTimestamp(LocalDate localDate) {
        return localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }
}
