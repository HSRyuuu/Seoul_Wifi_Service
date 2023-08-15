package com.seoul_wifi_service.repository.wifi;

import com.seoul_wifi_service.dto.LocationDTO;
import com.seoul_wifi_service.dto.WifiApiDTO;
import com.seoul_wifi_service.dto.WifiDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WifiMapper {
    void load(WifiApiDTO[] wifiApiDTOs);
    void deleteAll();
    List<WifiDTO> selectTop20Wifi(LocationDTO loc);
    WifiDTO findByManageNumber(@Param("manageNumber") String manageNumber, LocationDTO loc);
    
}
