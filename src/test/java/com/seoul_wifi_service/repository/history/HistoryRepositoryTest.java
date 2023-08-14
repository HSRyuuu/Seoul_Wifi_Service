package com.seoul_wifi_service.repository.history;

import com.seoul_wifi_service.domain.History;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
class HistoryRepositoryTest {

    @Autowired
    HistoryRepository historyRepository;
    @Test
    @DisplayName("save and findById")
    void save() {
        //given
        History history = new History(37.0, 126.0);

        //when
        History save = historyRepository.save(history);
        History find = historyRepository.findById(save.getId());

        //then
        assertThat(save).isEqualTo(find);
    }

    @Test
    @DisplayName("findAll() -> db에서 size 확인 !!")
    void findAll() {
        //given
        List<History> all = historyRepository.findAll();

        //when
        int size = 1;

        //then
        assertThat(all.size()).isEqualTo(1);
    }

    @Test
    void delete() {
        //given
        History history = new History(37.0, 126.0);
        History save = historyRepository.save(history);

        //when
        historyRepository.delete(save.getId());
        History findById = historyRepository.findById(save.getId());

        //then
        assertThat(findById).isNull();
    }
}