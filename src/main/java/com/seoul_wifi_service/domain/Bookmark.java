package com.seoul_wifi_service.domain;

import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Getter
@Setter
@EqualsAndHashCode(exclude = {"dateTime"})
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Bookmark {
    private long id;
    private String bookmarkGroupName;//북마크그룹 이름
    private String wifiManageNumber;//wifi 관리번호
    private String wifiName;//wifi 이름
    private String dateTime;//생성 일시


    public Bookmark(String bookmarkGroupName, String wifiManageNumber, String wifiName) {
        this.bookmarkGroupName = bookmarkGroupName;
        this.wifiManageNumber = wifiManageNumber;
        this.wifiName = wifiName;
        this.dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")).toString();
        ;
    }
}
