package com.seoul_wifi_service.service;

import com.seoul_wifi_service.domain.History;
import com.seoul_wifi_service.dto.LocationDTO;
import com.seoul_wifi_service.repository.history.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoryService {
    private final HistoryRepository historyRepository;

    public History findById(long id){
        return historyRepository.findById(id);
    }
    public List<History> findAll() {
        return historyRepository.findAll();
    }

    public History save(LocationDTO loc) {
        History history = new History(loc.getLat(), loc.getLnt());
        history.setSearchDateTime(MyDateTimeUtil.getDateTimeNow());
        return historyRepository.save(history);
    }

    public void delete(String id) {
        historyRepository.delete(Long.parseLong(id));
    }
    public void delete(long id){
        historyRepository.delete(id);
    }
}
