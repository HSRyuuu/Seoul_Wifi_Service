package com.seoul_wifi_service.repository.wifi;

import com.seoul_wifi_service.dto.LocationDTO;
import com.seoul_wifi_service.dto.WifiDTO;
import com.seoul_wifi_service.service.WifiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@Slf4j
@SpringBootTest
@RequiredArgsConstructor
class WifiRepositoryTest {

    @Autowired
    WifiRepository wifiRepository;
    @Autowired
    WifiService wifiService;

    @Test
    @DisplayName("deleteAll and loadAll (service)")
    void loadAll() throws IOException {
        wifiService.loadAllWifiOnDB();
    }

    @Test
    void selectTop20Wifi(){
        //given
        LocationDTO loc = new LocationDTO(37.5488603, 127.149493);
        //LocationDTO loc = new LocationDTO(0.0, 0.0);

        //when
        List<WifiDTO> findList = wifiRepository.selectTop20Wifi(loc);
        int cnt = 1;
        for(WifiDTO wi : findList){
            log.info("<{}> : {}", cnt, wi);
            cnt++;
        }

        //then
        assertThat(findList.size()).isEqualTo(20);
    }

    @Test
    void findByManageNumber(){
        //given
        LocationDTO loc = new LocationDTO(37.5488603, 127.149493);
        String manageNumber = "WF201070";

        //when
        WifiDTO find = wifiRepository.findByManageNumber(manageNumber, loc);

        //then
        assertThat(find.getDistrict()).isEqualTo("강동구");
        assertThat(find.getName()).isEqualTo("명일1동주민센터");

    }
}