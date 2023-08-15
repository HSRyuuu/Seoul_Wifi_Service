package com.seoul_wifi_service.repository.wifi;

import com.seoul_wifi_service.dto.LocationDTO;
import com.seoul_wifi_service.dto.WifiApiDTO;
import com.seoul_wifi_service.dto.WifiDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class WifiRepository {
    private final WifiMapper wifiMapper;
    public void load(WifiApiDTO[] wifiApiDTOs){
        wifiMapper.load(wifiApiDTOs);
    }
    public void deleteAll(){
        wifiMapper.deleteAll();
    }

    public List<WifiDTO> selectTop20Wifi(LocationDTO loc){
        return wifiMapper.selectTop20Wifi(loc);
    }
    public WifiDTO findByManageNumber(String manageNumber, LocationDTO loc){
        return wifiMapper.findByManageNumber(manageNumber, loc);
    }

}
