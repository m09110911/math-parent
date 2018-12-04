package com.math.common.json.impl;

import com.math.common.json.JsonFormatter;
import com.math.common.tools.date.DateFormatAndUtils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class DefaultJsonFormatter implements JsonFormatter {
    private static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

    private static final int DOUBLE_PATTERN_SIZE = 2;

    @Override
    public String format(Double doubleValue) {
        return new BigDecimal(doubleValue.toString()).setScale(DOUBLE_PATTERN_SIZE, BigDecimal.ROUND_HALF_EVEN).toString();
    }

    @Override
    public String format(Date date) {
        return DateFormatAndUtils.format(date, DATE_PATTERN);
    }

    @Override
    public String format(LocalDateTime date) {
        return DateFormatAndUtils.format(date, DATE_PATTERN);
    }

    @Override
    public String format(LocalDate date) {
        return DateFormatAndUtils.format(date, DATE_PATTERN);
    }

    @Override
    public String format(LocalTime date) {
        return DateFormatAndUtils.format(date, DATE_PATTERN);
    }
}
