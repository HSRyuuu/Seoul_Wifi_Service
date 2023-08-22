package com.seoul_wifi_service.controller;

import com.seoul_wifi_service.domain.BookmarkGroup;
import com.seoul_wifi_service.dto.BookmarkGroupDTO;
import com.seoul_wifi_service.service.BookmarkGroupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class BookmarkGroupController {
    private final BookmarkGroupService bookmarkGroupService;

    @GetMapping("/bookmark-group")
    public String bookmarkGroup(Model model){
        List<BookmarkGroup> bookmarkGroupList = bookmarkGroupService.findAll();

        model.addAttribute("bookmarkGroupList", bookmarkGroupList);

        return "bookmark-group/bookmark-group";
    }
    @GetMapping("/bookmark-group/add")
    public String addBookmarkGroupForm(Model model){
        model.addAttribute("bookmarkGroup", new BookmarkGroupDTO());
        return "bookmark-group/bookmark-group-add-form";
    }

    @PostMapping("/bookmark-group/add")
    public String addBookmarkGroup(@ModelAttribute("bookmarkGroup") BookmarkGroupDTO bookmarkGroupDTO){
        bookmarkGroupService.save(bookmarkGroupDTO);
        return "redirect:/bookmark-group";
    }
    @GetMapping("/bookmark-group/edit/{id}")
    public String editBookmarkGroupForm(@PathVariable long id,
                                        Model model){
        BookmarkGroup find = bookmarkGroupService.findById(id);

        model.addAttribute("bookmarkGroup", new BookmarkGroupDTO(find.getName(), find.getPriority()));
        return "bookmark-group/bookmark-group-add-form";
    }

    @PostMapping("/bookmark-group/edit/{id}")
    public String editBookmarkGroup(@PathVariable long id,
                                    @ModelAttribute("bookmarkGroup") BookmarkGroupDTO bookmarkGroupDTO){
        bookmarkGroupService.edit(id, bookmarkGroupDTO);
        return "redirect:/bookmark-group";
    }

    @PostMapping("/bookmark-group/delete/{id}")
    public String deleteBookmarkGroup(@PathVariable long id){
        bookmarkGroupService.delete(id);
        return "redirect:/bookmark-group";
    }
}
