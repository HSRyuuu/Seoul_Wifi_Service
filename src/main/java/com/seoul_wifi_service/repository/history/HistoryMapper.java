package com.seoul_wifi_service.repository.history;

import com.seoul_wifi_service.domain.History;
import com.seoul_wifi_service.dto.LocationDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HistoryMapper {
    History findById(long id);
    List<History> findAll();
    void save(History history);
    void delete(long id);
}
