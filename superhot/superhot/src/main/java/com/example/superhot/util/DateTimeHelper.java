package com.example.superhot.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeHelper {

    public static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static LocalDateTime convertStringToLocalDateTime(String date){
        return LocalDateTime.parse(date,formatter).toLocalDate().atStartOfDay();
    }
}
