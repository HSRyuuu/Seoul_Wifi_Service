package com.seoul_wifi_service.service;

import java.time.LocalDateTime;


public class DateTimeFormatService {
    public String getDateTimeNow() {
        return LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")).toString();
    }
}
