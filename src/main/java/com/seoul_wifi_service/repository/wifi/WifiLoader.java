package com.seoul_wifi_service.repository.wifi;

import com.seoul_wifi_service.dto.WifiDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class WifiLoader {
    private final WifiLoaderMapper wifiLoaderMapper;
    public void loadList(List<WifiDTO> list){
        wifiLoaderMapper.loadList(list);
    }
}
