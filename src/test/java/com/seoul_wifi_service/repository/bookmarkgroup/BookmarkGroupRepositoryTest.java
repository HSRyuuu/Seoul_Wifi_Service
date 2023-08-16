package com.seoul_wifi_service.repository.bookmarkgroup;

import com.seoul_wifi_service.domain.BookmarkGroup;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


@Slf4j
@SpringBootTest
@RequiredArgsConstructor
@Transactional
class BookmarkGroupRepositoryTest {
    @Autowired
    BookmarkGroupRepository bookmarkGroupRepository;

    @Test
    @DisplayName("save and findById")
    void findById() {
        //given
        BookmarkGroup bookmarkGroup = new BookmarkGroup("group1", 1);
        //when
        BookmarkGroup save = bookmarkGroupRepository.save(bookmarkGroup);
        log.info("save bookmark group : {}", save);

        BookmarkGroup find = bookmarkGroupRepository.findById(save.getId());
        log.info("find bookmark group : {}", find);

        //then
        assertThat(save).isEqualTo(find);

    }

    @Test
    @DisplayName("findAll() -> db에서 size 확인 !!")
    void findAll() {
        //given
        List<BookmarkGroup> all = bookmarkGroupRepository.findAll();

        //when

        //then
        assertThat(all).isNotNull();
    }

    @Test
    void edit() {
        //given
        BookmarkGroup bookmarkGroup = new BookmarkGroup("group3", 3);
        BookmarkGroup save = bookmarkGroupRepository.save(bookmarkGroup);
        log.info("save bookmark group : {}", save);

        //when
        BookmarkGroup editDTO = new BookmarkGroup("groupEdit", 2);
        bookmarkGroupRepository.edit(save.getId(), editDTO);

        BookmarkGroup find = bookmarkGroupRepository.findById(save.getId());

        //then
        assertThat(find.getName()).isEqualTo("groupEdit");
        assertThat(find.getPriority()).isEqualTo(2);

    }

    @Test
    void delete() {
        //given
        BookmarkGroup bookmarkGroup = new BookmarkGroup("group3", 3);
        BookmarkGroup save = bookmarkGroupRepository.save(bookmarkGroup);
        log.info("save bookmark group : {}", save);

        //when
        bookmarkGroupRepository.delete(save.getId());
        BookmarkGroup findById = bookmarkGroupRepository.findById(save.getId());

        //then
        assertThat(findById).isNull();
    }

}