package com.seoul_wifi_service.api;

import com.seoul_wifi_service.dto.WifiApiDTO;
import com.seoul_wifi_service.json_utils.JsonConverter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.*;


@Slf4j
class JsonConverterTest {

    ApiExplorer apiExplorer = new ApiExplorer();
    JsonConverter jsonConverter = new JsonConverter();

    @Test
    void jsonToWifiObject() throws IOException {
        //given
        String apiJson = apiExplorer.getApiJson(1, 3);

        //when
        WifiApiDTO[] wifiApiDTOS = jsonConverter.jsonToWifiObject(apiJson);

        //then
        assertThat(wifiApiDTOS.length).isEqualTo(3);

    }

    @Test
    void getRowsAmountByJson() throws IOException {
        int amount = 23331; // 변할 수 있음

        //given
        int pageStart = 1;
        int pageEnd = 3;
        String apiJson = apiExplorer.getApiJson(pageStart, pageEnd);

        //when
        int rowsAmount = apiExplorer.getRowsAmount();

        //then
        assertThat(rowsAmount).isEqualTo(amount);

    }

}
