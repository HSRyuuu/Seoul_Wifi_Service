package com.seoul_wifi_service.api;

import org.springframework.beans.factory.annotation.Value;

public abstract class ApiConst {
    public static final String SERVER_URL = "http://openapi.seoul.go.kr:8088";

    @Value("${seoulWifi.apiKey}")
    public static String AUTHENTICATION_KEY;

    public static final String SERVICE_NAME = "TbPublicWifiInfo";
}
