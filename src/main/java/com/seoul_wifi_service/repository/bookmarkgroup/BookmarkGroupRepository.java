package com.seoul_wifi_service.repository.bookmarkgroup;

import com.seoul_wifi_service.domain.BookmarkGroup;
import com.seoul_wifi_service.dto.BookmarkGroupDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BookmarkGroupRepository {
    private final BookmarkGroupMapper bookmarkGroupMapper;

    public BookmarkGroup findById(long id){
        return bookmarkGroupMapper.findById(id);
    }
    public List<BookmarkGroup> findAll(){
        return bookmarkGroupMapper.findAll();
    }

    public BookmarkGroup save(BookmarkGroup bookmarkGroup){
        bookmarkGroupMapper.save(bookmarkGroup);
        return bookmarkGroup;
    }
    public void edit(long id, BookmarkGroup bookmarkGroup){
        bookmarkGroupMapper.edit(id, bookmarkGroup);
    }
    public void delete(long id){
        bookmarkGroupMapper.delete(id);
    }
}
