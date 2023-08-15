package com.seoul_wifi_service.service;

import com.seoul_wifi_service.api.ApiExplorer;
import com.seoul_wifi_service.dto.WifiApiDTO;
import com.seoul_wifi_service.api.JsonConverter;
import com.seoul_wifi_service.repository.wifi.WifiRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class WifiService {
    private final ApiExplorer apiExplorer;
    private final JsonConverter jsonConverter;
    private final WifiRepository wifiRepository;

    /**
     * DB에 모든 와이파이 데이터 저장
     */
    public int loadAllWifiOnDB() throws IOException {
        wifiRepository.deleteAll();
        int rowsAmount = apiExplorer.getRowsAmount();
        loadAllWifi(rowsAmount);
        log.info("load complete!!! amount : {}", rowsAmount);

        return rowsAmount;
    }

    /**
     * api는 한번에 1000개의 데이터까지만 받을 수 있기 때문에 1000개씩 끊어서 db에 저장
     *
     * @param rowsAmount : 전체 row 수
     */
    private void loadAllWifi(int rowsAmount) throws IOException {
        int cnt = 0;
        for (int i = 1; i <= rowsAmount; i += 1000) {
            String jsonStr = apiExplorer.getApiJson(i, i + 999);
            WifiApiDTO[] wifiApiDTOs = jsonConverter.jsonToWifiObject(jsonStr);
            wifiRepository.load(wifiApiDTOs);
            cnt += wifiApiDTOs.length;
            log.info("load amount : {}", cnt);
        }
    }



}
