package com.seoul_wifi_service.service;

import java.time.LocalDateTime;


public class MyDateTimeFormatter {
    public static String getDateTimeNow() {
        return LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")).toString();
    }
}
