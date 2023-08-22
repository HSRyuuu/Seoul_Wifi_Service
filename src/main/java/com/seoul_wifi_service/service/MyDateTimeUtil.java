package com.seoul_wifi_service.service;

import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;

@UtilityClass
public class MyDateTimeUtil {
    public static String getDateTimeNow() {
        return LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
    }
}
