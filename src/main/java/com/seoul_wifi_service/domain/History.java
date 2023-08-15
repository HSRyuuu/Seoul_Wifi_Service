package com.seoul_wifi_service.domain;

import com.seoul_wifi_service.service.MyDateTimeFormatter;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"searchDateTime"})
@ToString
public class History {
    private long id;
    private double lat;//위도
    private double lnt;//경도
    private String searchDateTime;//생성 일시


    public History(double lat, double lnt) {
        this.lat = lat;
        this.lnt = lnt;
        this.searchDateTime = MyDateTimeFormatter.getDateTimeNow();
    }
}
