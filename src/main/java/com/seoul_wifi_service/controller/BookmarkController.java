package com.seoul_wifi_service.controller;

import com.seoul_wifi_service.domain.Bookmark;
import com.seoul_wifi_service.service.BookmarkService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class BookmarkController {
    private final BookmarkService bookmarkService;

    @GetMapping("/bookmark")
    public String bookmark(Model model){
        List<Bookmark> bookmarkList = bookmarkService.findAll();

        model.addAttribute("bookmarkList", bookmarkList);
        return "bookmark/bookmark-list";
    }

    @GetMapping("/bookmark/delete")
    public String deleteForm(@RequestParam long id, Model model){
        Bookmark find = bookmarkService.findById(id);
        model.addAttribute("bookmark", find);
        return "bookmark/bookmark-delete-form";
    }

    @PostMapping("/bookmark/delete")
    public String delete(@RequestParam long id){
        bookmarkService.delete(id);
        return "redirect:/bookmark";
    }
}
