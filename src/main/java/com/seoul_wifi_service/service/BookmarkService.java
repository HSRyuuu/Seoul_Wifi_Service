package com.seoul_wifi_service.service;

import com.seoul_wifi_service.domain.Bookmark;
import com.seoul_wifi_service.dto.WifiDTO;
import com.seoul_wifi_service.repository.bookmark.BookmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookmarkService {
    private final BookmarkRepository bookmarkRepository;
    private final WifiService wifiService;

    public Bookmark findById(long id) {
        return bookmarkRepository.findById(id);
    }

    public List<Bookmark> findAll() {
        return bookmarkRepository.findAll();
    }

    public Bookmark save(String key, String bookmarkGroupName) {
        WifiDTO wifiDTO = wifiService.findByManageNumber(key);
        Bookmark bookmark = new Bookmark();
        bookmark.setBookmarkGroupName(bookmarkGroupName);
        bookmark.setWifiManageNumber(key);
        bookmark.setWifiName(wifiDTO.getName());
        bookmark.setDateTime(MyDateTimeUtil.getDateTimeNow());
        return bookmarkRepository.save(bookmark);
    }

    public void delete(long id) {
        bookmarkRepository.delete(id);
    }

}
