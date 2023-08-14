package com.seoul_wifi_service.service;

import com.seoul_wifi_service.api.ApiExplorer;
import com.seoul_wifi_service.json_utils.JsonConverter;
import com.seoul_wifi_service.repository.wifi.WifiLoader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WifiService {
    private final ApiExplorer apiExplorer;
    private final JsonConverter jsonConverter;
    private final WifiLoader wifiLoader;


}
