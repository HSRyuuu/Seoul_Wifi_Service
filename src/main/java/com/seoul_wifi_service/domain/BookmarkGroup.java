package com.seoul_wifi_service.domain;

import com.seoul_wifi_service.service.DateTimeFormatService;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"createDateTime", "editDateTime"})
@ToString
public class BookmarkGroup {
    private long id;
    private String name;//북마크 이름
    private int priority;//순서
    private String createDateTime;//생성 일시
    private String editDateTime;//수정 일시

    public BookmarkGroup(String name, int priority) {
        this.name = name;
        this.priority = priority;
        this.createDateTime = new DateTimeFormatService().getDateTimeNow();
    }
}
