package com.seoul_wifi_service.service;


import com.seoul_wifi_service.domain.BookmarkGroup;
import com.seoul_wifi_service.dto.BookmarkGroupDTO;
import com.seoul_wifi_service.repository.bookmark.BookmarkRepository;
import com.seoul_wifi_service.repository.bookmarkgroup.BookmarkGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class BookmarkGroupService {
    private final BookmarkGroupRepository bookmarkGroupRepository;
    private final BookmarkRepository bookmarkRepository;

    public BookmarkGroup findById(long id) {
        return bookmarkGroupRepository.findById(id);
    }

    public List<BookmarkGroup> findAll() {
        return bookmarkGroupRepository.findAll();
    }

    public BookmarkGroup save(BookmarkGroupDTO bookmarkGroupDTO) {
        BookmarkGroup bookmarkGroup = new BookmarkGroup(bookmarkGroupDTO.getName(), bookmarkGroupDTO.getPriority());
        return bookmarkGroupRepository.save(bookmarkGroup);
    }

    public void edit(long id, BookmarkGroupDTO bookmarkGroupDTO) {
        String before = bookmarkGroupRepository.findById(id).getName();

        BookmarkGroup bookmarkGroup = new BookmarkGroup(bookmarkGroupDTO.getName(), bookmarkGroupDTO.getPriority());
        bookmarkGroup.setEditDateTime(MyDateTimeFormatter.getDateTimeNow());
        bookmarkGroupRepository.edit(id, bookmarkGroup);

        bookmarkRepository.updateBookmarkGroupName(before, bookmarkGroupDTO.getName());
    }

    public void delete(long id) {
        String name = bookmarkGroupRepository.findById(id).getName();
        bookmarkRepository.deleteByBookmarkGroupName(name);
        bookmarkGroupRepository.delete(id);
    }
}
