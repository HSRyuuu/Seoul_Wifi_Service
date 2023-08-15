package com.seoul_wifi_service.api;

import com.seoul_wifi_service.dto.WifiApiDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class ApiExplorerTest {

    static ApiExplorer apiExplorer = new ApiExplorer();
    static JsonConverter jsonConverter = new JsonConverter();

    @Test
    void getApiJson() throws IOException {
        //given
        int pageStart = 1;
        int pageEnd = 3;

        //when
        String apiJson = apiExplorer.getApiJson(pageStart, pageEnd);

        //then
        System.out.println(apiJson);
    }

    @Test
    void printTest() throws IOException {
        String apiJson = apiExplorer.getApiJson(1, 3);

        WifiApiDTO[] wifiApiDTOS = jsonConverter.jsonToWifiObject(apiJson);
        assertThat(wifiApiDTOS.length).isEqualTo(3);
        printObject(wifiApiDTOS);
    }

    /**
     * 테스트용 출력 메서드
     */
    private void printObject(WifiApiDTO[] wifiApiDTOS) {
        int i = 1;
        for (WifiApiDTO wi : wifiApiDTOS) {
            System.out.println("[" + i++ + "]");
            System.out.println(wi);
            System.out.println("====================");
        }
    }
}