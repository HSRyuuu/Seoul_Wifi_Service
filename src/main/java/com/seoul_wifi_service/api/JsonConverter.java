package com.seoul_wifi_service.api;

import com.seoul_wifi_service.dto.WifiApiDTO;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Component;


@Component
public class JsonConverter {
    /**
     * json String을 받아서 WifiInfo 배열로 변환
     *
     * @param json
     * @return WifiInfo[] 배열
     */
    public WifiApiDTO[] jsonToWifiObject(String json) {
        JsonObject jObj = JsonParser.parseString(json).getAsJsonObject();

        JsonObject jsonObject = jObj.getAsJsonObject("TbPublicWifiInfo");
        JsonArray rowArray = jsonObject.getAsJsonArray("row");

        Gson gson = new Gson();
        WifiApiDTO[] wifiApiDTOS = gson.fromJson(rowArray, WifiApiDTO[].class);
        return wifiApiDTOS;
    }

    /**
     * API로 받은 데이터의 "list_total_count" 를 파싱해서 총 데이터 건수를 반환한다.
     *
     * @param json
     * @return 총 데이터 건수(row 수)
     */
    public int getRowsAmountByJson(String json) {
        JsonObject jObj = JsonParser.parseString(json).getAsJsonObject();
        JsonObject jsonObject = jObj.getAsJsonObject("TbPublicWifiInfo");
        return jsonObject.getAsJsonPrimitive("list_total_count").getAsInt(); //전체 row 수
    }

}
