package com.seoul_wifi_service.dto;

import lombok.Data;

@Data
public class BookmarkGroupDTO {
    private String name;//북마크 이름
    private int priority;//순서

    public BookmarkGroupDTO() {
    }

    public BookmarkGroupDTO(String name, int priority, String createDateTime) {
        this.name = name;
        this.priority = priority;
    }
}
