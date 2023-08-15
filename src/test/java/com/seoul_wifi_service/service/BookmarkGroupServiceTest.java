package com.seoul_wifi_service.service;

import com.seoul_wifi_service.domain.BookmarkGroup;
import com.seoul_wifi_service.dto.BookmarkGroupDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
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
class BookmarkGroupServiceTest {

    @Autowired
    BookmarkGroupService bookmarkGroupService;

    @Test
    void save() {
        //given
        BookmarkGroupDTO bookmarkGroupDTO = new BookmarkGroupDTO("집근처1", 1);

        //when
        BookmarkGroup save = bookmarkGroupService.save(bookmarkGroupDTO);
        BookmarkGroup find = bookmarkGroupService.findById(save.getId());

        //then
        assertThat(save).isEqualTo(find);

    }
    @Test
    void findAll() {
        List<BookmarkGroup> all = bookmarkGroupService.findAll();

        assertThat(all).isNotNull();
    }

    @Test
    void edit() {
        //given
        BookmarkGroupDTO saveDTO = new BookmarkGroupDTO("집근처1", 1);
        BookmarkGroup save = bookmarkGroupService.save(saveDTO);
        long id = save.getId();

        //when
        BookmarkGroupDTO editDTO = new BookmarkGroupDTO("집근처2", 2);
        bookmarkGroupService.edit(id, editDTO);

        BookmarkGroup find = bookmarkGroupService.findById(id);
        assertThat(find.getName()).isEqualTo(editDTO.getName());
        assertThat(find.getPriority()).isEqualTo(editDTO.getPriority());
    }

    @Test
    void delete() {
        //given
        BookmarkGroupDTO saveDTO = new BookmarkGroupDTO("집근처1", 1);
        BookmarkGroup save = bookmarkGroupService.save(saveDTO);

        //when
        bookmarkGroupService.delete(save.getId());
        BookmarkGroup find = bookmarkGroupService.findById(save.getId());

        //then
        assertThat(find).isNull();
    }
}