package com.seoul_wifi_service.repository.bookmark;

import com.seoul_wifi_service.domain.Bookmark;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookmarkMapper {
    Bookmark findById(long id);
    List<Bookmark> findAll();
    void save(Bookmark bookmark);
    void updateBookmarkGroupName(@Param("before") String before, @Param("after") String after);
    void delete(long id);
    void deleteByBookmarkGroupName(String name);
}
