package com.seoul_wifi_service.repository.history;

import com.seoul_wifi_service.domain.History;
import com.seoul_wifi_service.dto.LocationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class HistoryRepository {
    private final HistoryMapper historyMapper;

    public History findById(long id) {
        return historyMapper.findById(id);
    }

    public List<History> findAll() {
        return historyMapper.findAll();
    }

    public History save(History history) {
        historyMapper.save(history);
        return history;
    }

    public void delete(long id) {
        historyMapper.delete(id);
    }
}
