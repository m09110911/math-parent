package com.math.common.json;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public interface JsonFormatter {

    String format(Double doubleValue);

    String format(Date date);

    String format(LocalDateTime date);

    String format(LocalDate date);

    String format(LocalTime date);
}
