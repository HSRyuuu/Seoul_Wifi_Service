package com.seoul_wifi_service.service;

import com.seoul_wifi_service.domain.History;
import com.seoul_wifi_service.dto.LocationDTO;
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
class HistoryServiceTest {

    @Autowired
    HistoryService historyService;

    @Test
    void findAll() {
        List<History> all = historyService.findAll();
        for (History history : all) {
            log.info("[{}]",history);
        }
    }

    @Test
    @DisplayName("save and findById")
    void save() {
        //given
        LocationDTO loc = new LocationDTO(37.0, 127.0);

        //when
        History save = historyService.save(loc);
        History find = historyService.findById(save.getId());

        //then
        assertThat(save).isEqualTo(find);
    }

    @Test
    void delete() {
        //given
        LocationDTO loc = new LocationDTO(37.0, 127.0);
        History save = historyService.save(loc);
        //when
        historyService.delete(save.getId());
        History find = historyService.findById(save.getId());

        //then
        assertThat(find).isNull();
    }
}