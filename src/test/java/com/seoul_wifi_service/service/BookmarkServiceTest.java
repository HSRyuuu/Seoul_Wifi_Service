package com.seoul_wifi_service.service;

import com.seoul_wifi_service.domain.Bookmark;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
@RequiredArgsConstructor
@Transactional
class BookmarkServiceTest {

    @Autowired
    BookmarkService bookmarkService;

    @Test
    @DisplayName("save and findById")
    void save() {
        //given
        String key = "WF201070";
        String bookmarkGroupName = "집근처";

        //when
        Bookmark save = bookmarkService.save(key, bookmarkGroupName);
        Bookmark find = bookmarkService.findById(save.getId());

        //then
        assertThat(save).isEqualTo(find);

    }

    @Test
    void findAll() {
        List<Bookmark> all = bookmarkService.findAll();

        assertThat(all).isNotNull();
    }

    @Test
    void delete() {
        //given
        String key = "WF201070";
        String bookmarkGroupName = "집근처";
        Bookmark save = bookmarkService.save(key, bookmarkGroupName);

        //when
        bookmarkService.delete(save.getId());
        Bookmark find = bookmarkService.findById(save.getId());

        //then
        assertThat(find).isNull();
    }
}