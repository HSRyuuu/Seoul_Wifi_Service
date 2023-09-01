package com.seoul_wifi_service.config;

import com.seoul_wifi_service.api.ApiConst;
import com.seoul_wifi_service.repository.bookmark.BookmarkMapper;
import com.seoul_wifi_service.repository.bookmark.BookmarkRepository;
import com.seoul_wifi_service.repository.bookmarkgroup.BookmarkGroupMapper;
import com.seoul_wifi_service.repository.bookmarkgroup.BookmarkGroupRepository;
import com.seoul_wifi_service.repository.history.HistoryMapper;
import com.seoul_wifi_service.repository.history.HistoryRepository;
import com.seoul_wifi_service.repository.wifi.WifiRepository;
import com.seoul_wifi_service.repository.wifi.WifiMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class RepositoryConfig {
    private final BookmarkMapper bookmarkMapper;
    private final BookmarkGroupMapper bookmarkGroupMapper;
    private final HistoryMapper historyMapper;
    private final WifiMapper wifiMapper;

    @Bean
    public BookmarkRepository bookmarkRepository(){
        return new BookmarkRepository(bookmarkMapper);
    }
    @Bean
    public BookmarkGroupRepository bookmarkGroupRepository(){
        return new BookmarkGroupRepository(bookmarkGroupMapper);
    }
    @Bean
    public HistoryRepository historyRepository(){
        return new HistoryRepository(historyMapper);
    }
    @Bean
    public WifiRepository wifiLoader(){
        return new WifiRepository(wifiMapper);
    }

}
