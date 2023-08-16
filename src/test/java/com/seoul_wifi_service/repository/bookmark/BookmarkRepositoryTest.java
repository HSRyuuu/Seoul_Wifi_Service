package com.seoul_wifi_service.repository.bookmark;

import com.seoul_wifi_service.domain.Bookmark;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
@Transactional
class BookmarkRepositoryTest {

    @Autowired
    BookmarkRepository bookmarkRepository;
    @Test
    @DisplayName("save and findById")
    void save() {
        //given
        Bookmark bookmark = new Bookmark("집근처", "---EP000001", "갈현1동주민센터");

        //when
        Bookmark save = bookmarkRepository.save(bookmark);
        log.info("save bookmark : {}", bookmark);

        Bookmark findBookmark = bookmarkRepository.findById(save.getId());
        log.info("find bookmark : {}", findBookmark);

        //then
        assertThat(save).isEqualTo(findBookmark);

    }

    @Test
    @DisplayName("findAll() - size 체크 필요")
    void findAll() {
        //given
        List<Bookmark> all = bookmarkRepository.findAll();

        //when

        //then
        assertThat(all).isNotNull();
    }

    @Test
    void updateBookmarkGroupName() {
        //given
        Bookmark bookmark = new Bookmark("group1", "num1", "name1");
        Bookmark save = bookmarkRepository.save(bookmark);

        //when
        bookmarkRepository.updateBookmarkGroupName("group1", "group2");
        Bookmark afterUpdate = bookmarkRepository.findById(save.getId());

        //then
        assertThat(afterUpdate.getBookmarkGroupName()).isEqualTo("group2");


    }

    @Test
    void delete() {
        //given
        Bookmark bookmark = new Bookmark("group1", "num1", "name1");
        Bookmark save = bookmarkRepository.save(bookmark);

        //when
        bookmarkRepository.delete(save.getId());
        Bookmark find = bookmarkRepository.findById(save.getId());

        //then
        assertThat(find).isNull();

    }

    @Test
    void deleteByBookmarkGroupName() {
        //given
        Bookmark bookmark = new Bookmark("group2", "num2", "name2");
        Bookmark save = bookmarkRepository.save(bookmark);

        //when
        bookmarkRepository.deleteByBookmarkGroupName("group2");
        Bookmark find = bookmarkRepository.findById(save.getId());

        //then
        assertThat(find).isNull();
    }
}