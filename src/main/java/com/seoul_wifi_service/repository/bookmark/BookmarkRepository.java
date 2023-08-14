package com.seoul_wifi_service.repository.bookmark;

import com.seoul_wifi_service.domain.Bookmark;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BookmarkRepository {
    private final BookmarkMapper bookmarkMapper;
    public Bookmark findById(long id){
        return bookmarkMapper.findById(id);
    }

    public List<Bookmark> findAll(){
        return bookmarkMapper.findAll();
    }

    public Bookmark save(Bookmark bookmark){
        bookmarkMapper.save(bookmark);
        return bookmark;
    }

    public void updateBookmarkGroupName(String before, String after){
        bookmarkMapper.updateBookmarkGroupName(before, after);
    }
    public void delete(long id){
        bookmarkMapper.delete(id);
    }
    public void deleteByBookmarkGroupName(String name){
        bookmarkMapper.deleteByBookmarkGroupName(name);
    }
}
