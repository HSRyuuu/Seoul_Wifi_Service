package com.seoul_wifi_service.repository.bookmarkgroup;

import com.seoul_wifi_service.domain.BookmarkGroup;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookmarkGroupMapper {

    BookmarkGroup findById(long id);
    List<BookmarkGroup> findAll();
    void save(BookmarkGroup bookmarkGroup);
    void edit(@Param("beforeId")long id, BookmarkGroup bookmarkGroup);
    void delete(long id);
}
